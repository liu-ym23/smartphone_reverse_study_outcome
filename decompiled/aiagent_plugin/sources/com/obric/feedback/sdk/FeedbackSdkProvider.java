package com.obric.feedback.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.provider.PluginContentProvider;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FeedbackSdkProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeedbackSdkProvider extends PluginContentProvider {
    public static final a Companion = null;
    private static final String KEY_DID = "device_id";
    private static final String KEY_TRACE_TIME_WINDOW = "trace_time_window";
    private static final String KEY_UID = "user_id";
    private static final String METHOD_GET_APP_INFO = "get_app_info";
    private static final String PKG_FEEDBACK = "com.obric.feedback";
    private static final String TAG = "FeedbackSdkProvider";

    /* JADX INFO: compiled from: FeedbackSdkProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public FeedbackSdkProvider() {
    }

    public Bundle call(String r3, String r4, Bundle r5) {
        o.e(r3, "method");
        String r0 = getCallingPackage();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (o.a(r0, PKG_FEEDBACK) == true) goto L13;
        c r2 = com.obric.feedback.sdk.a.f33229a.b();
        if (r2 == null) goto L10;
        r2.a(TAG, "call ERROR, " + r0 + " not in white list, extras: " + r5);
    L10:
        Bundle r6 = new Bundle();
        r6.putBoolean("success", false);
        r6.putString("error_msg", r0 + " not in white list");
        return r6;
    L13:
        if (o.a(r3, METHOD_GET_APP_INFO) == false) goto L27;
        Bundle r7 = new Bundle();
        b r8 = com.obric.feedback.sdk.a.f33229a.a();
        String r9 = null;
        if (r8 == null) goto L17;
        String r10 = r8.b();
    L18:
        r7.putString("device_id", r10);
        b r11 = com.obric.feedback.sdk.a.f33229a.a();
        if (r11 == null) goto L21;
        r9 = r11.a();
    L21:
        r7.putString(KEY_UID, r9);
        b r12 = com.obric.feedback.sdk.a.f33229a.a();
        if (r12 == null) goto L24;
        long r13 = r12.c();
    L25:
        r7.putLong(KEY_TRACE_TIME_WINDOW, r13);
        return r7;
    L24:
        r13 = 0;
        goto L25
    L17:
        r10 = null;
        goto L18
    L27:
        return super.call(r3, r4, r5);
    }
}
