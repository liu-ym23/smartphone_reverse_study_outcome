package com.android.server.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class GameServiceController {
    private static final String TAG = "GameServiceController";
    private volatile GameServiceConfiguration.GameServiceComponentConfiguration mActiveGameServiceComponentConfiguration;
    private volatile String mActiveGameServiceProviderPackage;
    private final Executor mBackgroundExecutor;
    private final Context mContext;
    private volatile SystemService.TargetUser mCurrentForegroundUser;
    private BroadcastReceiver mGameServicePackageChangedReceiver;
    private volatile GameServiceProviderInstance mGameServiceProviderInstance;
    private final GameServiceProviderInstanceFactory mGameServiceProviderInstanceFactory;
    private volatile String mGameServiceProviderOverride;
    private final GameServiceProviderSelector mGameServiceProviderSelector;
    private volatile boolean mHasBootCompleted;
    private final Object mLock;

    private final class PackageChangedBroadcastReceiver extends BroadcastReceiver {
        private final String mPackageName;
        final /* synthetic */ GameServiceController this$0;

        public static /* synthetic */ void $r8$lambda$NbjS8cjtsU88tkU1TANmnmHMjCY(GameServiceController r0) {
            GameServiceController.m1654$$Nest$mevaluateActiveGameServiceProvider(r0);
        }

        PackageChangedBroadcastReceiver(GameServiceController r1, String packageName) {
            this.this$0 = r1;
            this.mPackageName = packageName;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getData().getSchemeSpecificPart(), this.mPackageName) == true) goto L5;
            return;
        L5:
            Executor r0 = GameServiceController.m1653$$Nest$fgetmBackgroundExecutor(this.this$0);
            final GameServiceController r1 = this.this$0;
            r0.execute(new GameServiceController$PackageChangedBroadcastReceiver$$ExternalSyntheticLambda0(r1));
        }
    }

    public static /* synthetic */ void $r8$lambda$NbjS8cjtsU88tkU1TANmnmHMjCY(GameServiceController r0) {
        r0.evaluateActiveGameServiceProvider();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m1653$$Nest$fgetmBackgroundExecutor(GameServiceController r0) {
        return r0.mBackgroundExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateActiveGameServiceProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1654$$Nest$mevaluateActiveGameServiceProvider(GameServiceController r0) {
        r0.evaluateActiveGameServiceProvider();
    }

    GameServiceController(Context context, Executor backgroundExecutor, GameServiceProviderSelector gameServiceProviderSelector, GameServiceProviderInstanceFactory gameServiceProviderInstanceFactory) {
        this.mLock = new Object();
        this.mContext = context;
        this.mGameServiceProviderInstanceFactory = gameServiceProviderInstanceFactory;
        this.mBackgroundExecutor = backgroundExecutor;
        this.mGameServiceProviderSelector = gameServiceProviderSelector;
    }

    void onBootComplete() {
        if (this.mHasBootCompleted == false) goto L5;
        return;
    L5:
        this.mHasBootCompleted = true;
        this.mBackgroundExecutor.execute(new GameServiceController$$ExternalSyntheticLambda0(this));
    }

    void notifyUserStarted(SystemService.TargetUser user) {
        if (this.mCurrentForegroundUser == null) goto L5;
        return;
    L5:
        setCurrentForegroundUserAndEvaluateProvider(user);
    }

    void notifyNewForegroundUser(SystemService.TargetUser user) {
        setCurrentForegroundUserAndEvaluateProvider(user);
    }

    void notifyUserUnlocking(SystemService.TargetUser user) {
        if (this.mCurrentForegroundUser != null) goto L5;
    L7:
        boolean isSameAsForegroundUser = false;
    L9:
        if (isSameAsForegroundUser == true) goto L11;
        return;
    L11:
        this.mBackgroundExecutor.execute(new GameServiceController$$ExternalSyntheticLambda0(this));
        return;
    L5:
        if (this.mCurrentForegroundUser.getUserIdentifier() != user.getUserIdentifier()) goto L7;
        isSameAsForegroundUser = true;
        goto L9
    }

    void notifyUserStopped(SystemService.TargetUser user) {
        if (this.mCurrentForegroundUser != null) goto L5;
    L7:
        boolean isSameAsForegroundUser = false;
    L9:
        if (isSameAsForegroundUser == true) goto L11;
        return;
    L11:
        setCurrentForegroundUserAndEvaluateProvider(null);
        return;
    L5:
        if (this.mCurrentForegroundUser.getUserIdentifier() != user.getUserIdentifier()) goto L7;
        isSameAsForegroundUser = true;
        goto L9
    }

    void setGameServiceProvider(String packageName) {
        boolean hasPackageChanged = !Objects.equals(this.mGameServiceProviderOverride, packageName);
        if (hasPackageChanged == true) goto L5;
        return;
    L5:
        this.mGameServiceProviderOverride = packageName;
        this.mBackgroundExecutor.execute(new GameServiceController$$ExternalSyntheticLambda0(this));
    }

    private void setCurrentForegroundUserAndEvaluateProvider(SystemService.TargetUser user) {
        boolean hasUserChanged = !Objects.equals(this.mCurrentForegroundUser, user);
        if (hasUserChanged == true) goto L5;
        return;
    L5:
        this.mCurrentForegroundUser = user;
        this.mBackgroundExecutor.execute(new GameServiceController$$ExternalSyntheticLambda0(this));
    }

    private void evaluateActiveGameServiceProvider() {
        if (this.mHasBootCompleted == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        GameServiceConfiguration selectedGameServiceConfiguration = this.mGameServiceProviderSelector.get(this.mCurrentForegroundUser, this.mGameServiceProviderOverride);     // Catch: Throwable -> L19
        if (selectedGameServiceConfiguration != null) goto L10;
        String gameServicePackage = null;
    L12:
        if (selectedGameServiceConfiguration != null) goto L14;
        GameServiceConfiguration.GameServiceComponentConfiguration gameServiceComponentConfiguration = null;
    L15:
        evaluateGameServiceProviderPackageChangedListenerLocked(gameServicePackage);     // Catch: Throwable -> L19
        boolean didActiveGameServiceProviderChange = !Objects.equals(gameServiceComponentConfiguration, this.mActiveGameServiceComponentConfiguration);     // Catch: Throwable -> L19
        if (didActiveGameServiceProviderChange == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L22:
        if (this.mGameServiceProviderInstance == null) goto L24;
        Slog.i(TAG, "Stopping Game Service provider: " + this.mActiveGameServiceComponentConfiguration);     // Catch: Throwable -> L19
        this.mGameServiceProviderInstance.stop();     // Catch: Throwable -> L19
        this.mGameServiceProviderInstance = null;     // Catch: Throwable -> L19
    L24:
        this.mActiveGameServiceComponentConfiguration = gameServiceComponentConfiguration;     // Catch: Throwable -> L19
        if (this.mActiveGameServiceComponentConfiguration != null) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L28:
        Slog.i(TAG, "Starting Game Service provider: " + this.mActiveGameServiceComponentConfiguration);     // Catch: Throwable -> L19
        this.mGameServiceProviderInstance = this.mGameServiceProviderInstanceFactory.create(this.mActiveGameServiceComponentConfiguration);     // Catch: Throwable -> L19
        this.mGameServiceProviderInstance.start();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L14:
        gameServiceComponentConfiguration = selectedGameServiceConfiguration.getGameServiceComponentConfiguration();     // Catch: Throwable -> L19
        goto L15
    L10:
        gameServicePackage = selectedGameServiceConfiguration.getPackageName();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void evaluateGameServiceProviderPackageChangedListenerLocked(String gameServicePackage) {
        if (TextUtils.equals(this.mActiveGameServiceProviderPackage, gameServicePackage) == false) goto L6;
        return;
    L6:
        if (this.mGameServicePackageChangedReceiver == null) goto L8;
        this.mContext.unregisterReceiver(this.mGameServicePackageChangedReceiver);
        this.mGameServicePackageChangedReceiver = null;
    L8:
        this.mActiveGameServiceProviderPackage = gameServicePackage;
        if (TextUtils.isEmpty(this.mActiveGameServiceProviderPackage) == false) goto L11;
        return;
    L11:
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        intentFilter.addDataSchemeSpecificPart(gameServicePackage, 0);
        this.mGameServicePackageChangedReceiver = new PackageChangedBroadcastReceiver(this, gameServicePackage);
        this.mContext.registerReceiver(this.mGameServicePackageChangedReceiver, intentFilter);
    }
}
