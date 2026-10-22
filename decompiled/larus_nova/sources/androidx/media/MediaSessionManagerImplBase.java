package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = false;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    ContentResolver mContentResolver;
    Context mContext;

    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        private String mPackageName;
        private int mPid;
        private int mUid;

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mPid), Integer.valueOf(this.mUid)});
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mPackageName;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mPid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mUid;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RemoteUserInfoImplBase) == true) goto L8;
            return false;
        L8:
            RemoteUserInfoImplBase r101 = (RemoteUserInfoImplBase) r100;
            if (TextUtils.equals(this.mPackageName, r101.mPackageName) == true) goto L11;
        L15:
            return false;
        L11:
            if (this.mPid != r101.mPid) goto L15;
            if (this.mUid != r101.mUid) goto L15;
            return true;
        }

        public RemoteUserInfoImplBase(String r100, int r101, int r102) {
            this.mPackageName = r100;
            this.mPid = r101;
            this.mUid = r102;
        }
    }

    static {
        DEBUG = MediaSessionManager.DEBUG;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        return this.mContext;
    }

    public MediaSessionManagerImplBase(Context r100) {
        this.mContext = r100;
        this.mContentResolver = r100.getContentResolver();
    }

    public boolean isEnabledNotificationListener(MediaSessionManager.RemoteUserInfoImpl r100) {
        String r101 = androidx_media_MediaSessionManagerImplBase_android_provider_Settings$Secure_getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (r101 == null) goto L14;
        String[] r102 = r101.split(":");
        int r103 = 0;
    L6:
        if (r103 >= r102.length) goto L14;
        ComponentName r104 = ComponentName.unflattenFromString(r102[r103]);
        if (r104 == null) goto L13;
        if (r104.getPackageName().equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        r103 = r103 + 1;
    L14:
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r100) {
        if (this.mContext.getPackageManager().getApplicationInfo(r100.getPackageName(), 0).uid == r100.getUid()) goto L11;
        if (DEBUG == false) goto L9;
        r100.getPackageName();
        r100.getUid();
    L9:
        return false;
    L11:
        if (isPermissionGranted(r100, PERMISSION_STATUS_BAR_SERVICE) == false) goto L13;
    L18:
        return true;
    L13:
        if (isPermissionGranted(r100, PERMISSION_MEDIA_CONTENT_CONTROL) == true) goto L18;
        if (r100.getUid() == 1000) goto L18;
        if (isEnabledNotificationListener(r100) == true) goto L18;
        return false;
    L21:
        if (DEBUG == false) goto L23;
        r100.getPackageName();
    L23:
        return false;
    }

    private static String androidx_media_MediaSessionManagerImplBase_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r110, r111};
        b r112 = new b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl r100, String r101) {
        if (r100.getPid() >= 0) goto L10;
        if (this.mContext.getPackageManager().checkPermission(r101, r100.getPackageName()) == 0) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (androidx_media_MediaSessionManagerImplBase_android_content_Context_checkPermission(this.mContext, r101, r100.getPid(), r100.getUid()) == 0) goto L15;
        return false;
    L15:
        return true;
    }

    private static int androidx_media_MediaSessionManagerImplBase_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        b r112 = new b("auto_cert_androidx_media_MediaSessionManagerImplBase_android_content_Context_checkPermission");
        a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
