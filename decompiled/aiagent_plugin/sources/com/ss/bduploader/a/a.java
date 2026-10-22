package com.ss.bduploader.a;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.bduploader.net.f;
import com.ss.bduploader.t;
import com.ss.bduploader.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogEngineUploader.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    private static final String TAG = "ttmn";

    /* JADX INFO: renamed from: com.ss.bduploader.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLogEngineUploader.java */
    private static class C1024a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f37467a = null;

        static /* synthetic */ a a() {
            return f37467a;
        }

        static {
            f37467a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C1024a.a();
    }

    private a() {
    }

    @Override // com.ss.bduploader.a.b
    public void a(String r11, JSONObject r12) {
        a(TAG, "onEventV3 monitorName " + r11);
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        a(r12);
        if (t.f37560e == null) goto L15;
        t.f37560e.a(r11, a(r12, "upload_log_type", "2"));
        return;
    L15:
        ZeusTransformUtils.forName("com.ss.android.common.lib.AppLogNewUtils", "com.obric.aiagent.plugin").getMethod("onEventV3", new Class[]{String.class, JSONObject.class}).invoke(null, new Object[]{r11, a(r12, "upload_log_type", "1")});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        x.f37566a.b(a(r12, "upload_log_type", "0"));
        e.printStackTrace();
        b(TAG, "upload error " + e);
        return;
    }

    private JSONObject a(JSONObject r3, String r4, String r5) {
        r3.put(r4, r5);     // Catch: JSONException -> L4
        c(TAG, "key" + r4 + "value" + r5);     // Catch: JSONException -> L4
    L6:
        return r3;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    static void a(final JSONObject r1) {
        f.a(new AnonymousClass1(r1));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
