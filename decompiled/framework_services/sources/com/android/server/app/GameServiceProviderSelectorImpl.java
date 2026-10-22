package com.android.server.app;

import android.R;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.Xml;
import com.android.server.SystemService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class GameServiceProviderSelectorImpl implements GameServiceProviderSelector {
    private static final boolean DEBUG = false;
    private static final String GAME_SERVICE_NODE_NAME = "game-service";
    private static final String TAG = "GameServiceProviderSelector";
    private final PackageManager mPackageManager;
    private final Resources mResources;

    GameServiceProviderSelectorImpl(Resources resources, PackageManager packageManager) {
        this.mResources = resources;
        this.mPackageManager = packageManager;
    }

    @Override // com.android.server.app.GameServiceProviderSelector
    public GameServiceConfiguration get(SystemService.TargetUser user, String packageNameOverride) {
        if (user != null) goto L6;
        return null;
    L6:
        if (user.isFull() == true) goto L8;
    L10:
        boolean isUserSupported = false;
    L12:
        if (isUserSupported == true) goto L16;
        Slog.i(TAG, "Game Service not supported for user: " + user.getUserIdentifier());
        return null;
    L16:
        if (TextUtils.isEmpty(packageNameOverride) == true) goto L18;
        int resolveInfoQueryFlags = 0;
        String gameServicePackage = packageNameOverride;
    L20:
        if (TextUtils.isEmpty(gameServicePackage) == false) goto L23;
        Slog.w(TAG, "No game service package defined");
        return null;
    L23:
        int userId = user.getUserIdentifier();
        List<ResolveInfo> gameServiceResolveInfos = this.mPackageManager.queryIntentServicesAsUser(new Intent("android.service.games.action.GAME_SERVICE").setPackage(gameServicePackage), resolveInfoQueryFlags | 128, userId);
        if (gameServiceResolveInfos != null) goto L26;
    L42:
        Slog.w(TAG, "No available game service found for user id: " + userId);
        return new GameServiceConfiguration(gameServicePackage, null);
    L26:
        if (gameServiceResolveInfos.isEmpty() == true) goto L42;
        GameServiceConfiguration selectedProvider = null;
        Iterator<ResolveInfo> r9 = gameServiceResolveInfos.iterator();
    L30:
        if (r9.hasNext() == false) goto L38;
        ResolveInfo resolveInfo = r9.next();
        if (resolveInfo.serviceInfo == null) goto L30;
        ServiceInfo gameServiceServiceInfo = resolveInfo.serviceInfo;
        ComponentName gameSessionServiceComponentName = determineGameSessionServiceFromGameService(gameServiceServiceInfo);
        if (gameSessionServiceComponentName == null) goto L30;
        selectedProvider = new GameServiceConfiguration(gameServicePackage, new GameServiceConfiguration.GameServiceComponentConfiguration(new UserHandle(userId), gameServiceServiceInfo.getComponentName(), gameSessionServiceComponentName));
    L38:
        if (selectedProvider != null) goto L41;
        Slog.w(TAG, "No valid game service found for user id: " + userId);
        return new GameServiceConfiguration(gameServicePackage, null);
    L41:
        return selectedProvider;
    L18:
        resolveInfoQueryFlags = 1048576;
        gameServicePackage = this.mResources.getString(R.string.create_contact_using);
        goto L20
    L8:
        if (user.isManagedProfile() == true) goto L10;
        isUserSupported = true;
        goto L12
    }

    private ComponentName determineGameSessionServiceFromGameService(ServiceInfo gameServiceServiceInfo) {
        XmlResourceParser parser = gameServiceServiceInfo.loadXmlMetaData(this.mPackageManager, "android.game_service");     // Catch: Throwable -> L10
        if (parser != null) goto L15;
        Slog.w(TAG, "No android.game_service meta-data found for " + gameServiceServiceInfo.getComponentName());     // Catch: Throwable -> L13
        if (parser == null) goto L12;
        parser.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L12:
        return null;
    L15:
        Resources resources = this.mPackageManager.getResourcesForApplication(gameServiceServiceInfo.packageName);     // Catch: Throwable -> L13
        AttributeSet attributeSet = Xml.asAttributeSet(parser);     // Catch: Throwable -> L13
    L16:
        int type = parser.next();     // Catch: Throwable -> L13
        if (type == 1) goto L21;
        if (type != 2) goto L16;
    L21:
        boolean isStartingTagGameService = GAME_SERVICE_NODE_NAME.equals(parser.getName());     // Catch: Throwable -> L13
        if (isStartingTagGameService == true) goto L26;
        Slog.w(TAG, "Meta-data does not start with game-service tag");     // Catch: Throwable -> L13
        parser.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
        return null;
    L26:
        TypedArray array = resources.obtainAttributes(attributeSet, com.android.internal.R.styleable.GameService);     // Catch: Throwable -> L13
        String gameSessionService = array.getString(0);     // Catch: Throwable -> L13
        array.recycle();     // Catch: Throwable -> L13
        parser.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
        if (TextUtils.isEmpty(gameSessionService) == false) goto L32;
        Slog.w(TAG, "No gameSessionService specified");
        return null;
    L32:
        ComponentName componentName = new ComponentName(gameServiceServiceInfo.packageName, gameSessionService);
        this.mPackageManager.getServiceInfo(componentName, 0);     // Catch: PackageManager.NameNotFoundException -> L35
        return componentName;
    L36:
        Slog.w(TAG, "GameSessionService does not exist: " + componentName);
        return null;
    L13:
        th = move-exception;
        if (parser != null) goto L49;
    L44:
        throw th;     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L49:
        parser.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L10:
        ex = move-exception;
        Slog.w("Error while parsing meta-data for " + gameServiceServiceInfo.getComponentName(), ex);
        return null;
    }
}
