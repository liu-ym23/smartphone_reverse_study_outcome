package com.android.server.media;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class MediaButtonReceiverHolder {
    private static final String COMPONENT_NAME_USER_ID_DELIM = ",";
    public static final int COMPONENT_TYPE_ACTIVITY = 2;
    public static final int COMPONENT_TYPE_BROADCAST = 1;
    public static final int COMPONENT_TYPE_INVALID = 0;
    public static final int COMPONENT_TYPE_SERVICE = 3;
    private static final boolean DEBUG_KEY_EVENT = true;
    private static final int MAX_COMPONENT_NAME_LENGTH = 1024;
    private static final int PACKAGE_MANAGER_COMMON_FLAGS = 786432;
    private static final String TAG = "PendingIntentHolder";
    private final ComponentName mComponentName;
    private final int mComponentType;
    private final String mPackageName;
    private final PendingIntent mPendingIntent;
    private final int mUserId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComponentType {
    }

    public static MediaButtonReceiverHolder unflattenFromString(Context context, String mediaButtonReceiverInfo) {
        if (TextUtils.isEmpty(mediaButtonReceiverInfo) == false) goto L5;
        return null;
    L5:
        String[] tokens = mediaButtonReceiverInfo.split(COMPONENT_NAME_USER_ID_DELIM);
        if (tokens != null) goto L8;
    L21:
        return null;
    L8:
        if (tokens.length != 2) goto L10;
    L12:
        ComponentName componentName = ComponentName.unflattenFromString(tokens[0]);
        if (componentName != null) goto L15;
        return null;
    L15:
        int userId = Integer.parseInt(tokens[1]);
        if (tokens.length != 3) goto L18;
        int componentType = Integer.parseInt(tokens[2]);
    L20:
        return new MediaButtonReceiverHolder(userId, null, componentName, componentType);
    L18:
        componentType = getComponentType(context, componentName);
        goto L20
    L10:
        if (tokens.length == 3) goto L12;
        goto L12
    }

    public static MediaButtonReceiverHolder create(int userId, PendingIntent pendingIntent, String sessionPackageName) {
        if (pendingIntent != null) goto L5;
        return null;
    L5:
        int componentType = getComponentType(pendingIntent);
        ComponentName componentName = getComponentName(pendingIntent, componentType);
        if (componentName != null) goto L8;
        Log.w(TAG, "Unresolvable implicit intent is set, pi=" + pendingIntent);
        return new MediaButtonReceiverHolder(userId, pendingIntent, sessionPackageName);
    L8:
        return new MediaButtonReceiverHolder(userId, pendingIntent, componentName, componentType);
    }

    public static MediaButtonReceiverHolder create(int userId, ComponentName broadcastReceiver) {
        if (componentNameTooLong(broadcastReceiver) == true) goto L7;
        return new MediaButtonReceiverHolder(userId, null, broadcastReceiver, 1);
    L7:
        throw new IllegalArgumentException("receiver name too long");
    }

    private MediaButtonReceiverHolder(int userId, PendingIntent pendingIntent, ComponentName componentName, int componentType) {
        this.mUserId = userId;
        this.mPendingIntent = pendingIntent;
        this.mComponentName = componentName;
        this.mPackageName = componentName.getPackageName();
        this.mComponentType = componentType;
    }

    private MediaButtonReceiverHolder(int userId, PendingIntent pendingIntent, String packageName) {
        this.mUserId = userId;
        this.mPendingIntent = pendingIntent;
        this.mComponentName = null;
        this.mPackageName = packageName;
        this.mComponentType = 0;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean send(Context context, KeyEvent keyEvent, MediaSessionService mediaSessionService, String callingPackageName, int callingPid, int callingUid, String reportedPackageName, int resultCode, PendingIntent.OnFinished onFinishedListener, Handler handler) {
        Intent mediaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
        mediaButtonIntent.addFlags(268435456);
        mediaButtonIntent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
        mediaButtonIntent.putExtra("android.intent.extra.PACKAGE_NAME", reportedPackageName);
        PackageManager packageManager = context.getPackageManager();
        int targetUid = packageManager.getPackageUidAsUser(this.mPackageName, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L5
        mediaSessionService.tempAllowlistTargetPkgIfPossible(targetUid, this.mPackageName, callingPid, callingUid, callingPackageName, TAG);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        if (this.mPendingIntent == null) goto L21;
        Log.d(TAG, "Sending " + keyEvent + " to the last known PendingIntent " + this.mPendingIntent);
        this.mPendingIntent.send(context, resultCode, mediaButtonIntent, onFinishedListener, handler);     // Catch: PendingIntent.CanceledException -> L14
        return true;
    L14:
        e = e;
    L18:
        Log.w(TAG, "Error sending key event to media button receiver " + this.mPendingIntent, e);
        return false;
    L16:
        e = e;
        goto L18
    L21:
        if (this.mComponentName == null) goto L35;
        Log.d(TAG, "Sending " + keyEvent + " to the restored intent " + this.mComponentName + ", type=" + this.mComponentType);
        mediaButtonIntent.setComponent(this.mComponentName);
        UserHandle userHandle = UserHandle.of(this.mUserId);
    L26:
        e = move-exception;
        Log.w(TAG, "Error sending media button to the restored intent " + this.mComponentName + ", type=" + this.mComponentType, e);
        return false;
    L24:
        switch(this.mComponentType) {
            case 2: goto L29;
            case 3: goto L28;
            default: goto L25;
        };     // Catch: Exception -> L26
    L25:
        context.sendBroadcastAsUser(mediaButtonIntent, userHandle);     // Catch: Exception -> L26
    L41:
        return true;
    L28:
        context.createContextAsUser(userHandle, 0).startForegroundService(mediaButtonIntent);     // Catch: Exception -> L26
        goto L41
    L29:
        context.startActivityAsUser(mediaButtonIntent, userHandle);     // Catch: Exception -> L26
        goto L41
    L35:
        Log.e(TAG, "Shouldn't be happen -- pending intent or component name must be set");
        return false;
    L6:
        Log.d(TAG, "Can't allowlist, package " + this.mPackageName + "doesn't exist");
        goto L8
    }

    public String toString() {
        return "MBR {pi=" + this.mPendingIntent + ", componentName=" + this.mComponentName + ", type=" + this.mComponentType + ", pkg=" + this.mPackageName + "}";
    }

    public String flattenToString() {
        if (this.mComponentName != null) goto L7;
        return "";
    L7:
        return String.join(COMPONENT_NAME_USER_ID_DELIM, new CharSequence[]{this.mComponentName.flattenToString(), String.valueOf(this.mUserId), String.valueOf(this.mComponentType)});
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    private static int getComponentType(PendingIntent pendingIntent) {
        if (pendingIntent.isBroadcast() == false) goto L7;
        return 1;
    L7:
        if (pendingIntent.isActivity() == false) goto L11;
        return 2;
    L11:
        if (pendingIntent.isForegroundService() == false) goto L13;
        return 3;
    L13:
        if (pendingIntent.isService() == true) goto L19;
        return 0;
    L19:
        return 3;
    }

    private static int getComponentType(Context context, ComponentName componentName) {
        if (componentName != null) goto L5;
        return 0;
    L5:
        PackageManager pm = context.getPackageManager();
        ActivityInfo activityInfo = pm.getActivityInfo(componentName, 786433);     // Catch: PackageManager.NameNotFoundException -> L11
        if (activityInfo == null) goto L23;
        return 2;
    L23:
        ServiceInfo serviceInfo = pm.getServiceInfo(componentName, 786436);     // Catch: PackageManager.NameNotFoundException -> L18
        if (serviceInfo == null) goto L25;
        return 3;
    L25:
        return 1;
    L19:
        return 1;
    }

    private static ComponentName getComponentName(PendingIntent pendingIntent, int componentType) {
        List<ResolveInfo> resolveInfos = Collections.emptyList();
        switch(componentType) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L8;
        };
    L5:
        resolveInfos = pendingIntent.queryIntentComponents(786436);
        goto L8
    L6:
        resolveInfos = pendingIntent.queryIntentComponents(851969);
        goto L8
    L7:
        resolveInfos = pendingIntent.queryIntentComponents(786434);
    L8:
        Iterator<ResolveInfo> r1 = resolveInfos.iterator();
    L10:
        if (r1.hasNext() == false) goto L24;
        ResolveInfo resolveInfo = r1.next();
        ComponentInfo componentInfo = getComponentInfo(resolveInfo);
        if (componentInfo == null) goto L10;
        if (TextUtils.equals(componentInfo.packageName, pendingIntent.getCreatorPackage()) == false) goto L10;
        if (componentInfo.packageName == null) goto L10;
        if (componentInfo.name == null) goto L10;
        ComponentName componentName = new ComponentName(componentInfo.packageName, componentInfo.name);
        if (componentNameTooLong(componentName) == false) goto L22;
        Log.w(TAG, "detected and ignored component name with overly long package or name, pi=" + pendingIntent);
        goto L10
    L22:
        return componentName;
    L24:
        return null;
    }

    private static boolean componentNameTooLong(ComponentName componentName) {
        if (((componentName.getPackageName().length() + componentName.getClassName().length()) + 1) > 1024) goto L7;
        return false;
    L7:
        return true;
    }

    private static ComponentInfo getComponentInfo(ResolveInfo resolveInfo) {
        if (resolveInfo.activityInfo == null) goto L7;
        return resolveInfo.activityInfo;
    L7:
        if (resolveInfo.serviceInfo != null) goto L9;
        return null;
    L9:
        return resolveInfo.serviceInfo;
    }
}
