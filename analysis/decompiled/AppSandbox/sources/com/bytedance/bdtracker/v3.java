package com.bytedance.bdtracker;

import com.bytedance.applog.profile.UserProfileCallback;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v3 {
    public static final String[] a = {"aid", "region", "os", ExceptionManagerStepOS.PACKAGE, "app_version", "sdk_version", "os_version", "device_model", "resolution", "language", "timezone", "access", "display_name", "channel", "carrier", "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "rom", "manifest_version_code", "device_manufacturer", "clientudid", "sig_hash", "display_density", "os_api", "update_version_code", "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid"};
    public static final String[] b = {"setOnce", "synchronize"};
    public static final int[] c = {-1, -1};
    public static final long[] d = {-1, -1};

    public static class a implements UserProfileCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ UserProfileCallback c;

        public a(int i, JSONObject jSONObject, UserProfileCallback userProfileCallback) {
            this.a = i;
            this.b = jSONObject;
            this.c = userProfileCallback;
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onFail(int i) {
            this.c.onFail(i);
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onSuccess() {
            v3.c[this.a] = this.b.toString().hashCode();
            v3.d[this.a] = System.currentTimeMillis();
            this.c.onSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe A[Catch: JSONException -> 0x0117, TryCatch #0 {JSONException -> 0x0117, blocks: (B:34:0x00ed, B:36:0x00f7, B:38:0x00fe, B:39:0x0113, B:31:0x00db, B:33:0x00e8, B:28:0x00bc), top: B:56:0x00b8, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.bytedance.bdtracker.e0 r24, int r25, org.json.JSONObject r26, com.bytedance.applog.profile.UserProfileCallback r27, android.os.Handler r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.v3.a(com.bytedance.bdtracker.e0, int, org.json.JSONObject, com.bytedance.applog.profile.UserProfileCallback, android.os.Handler, boolean):void");
    }
}
