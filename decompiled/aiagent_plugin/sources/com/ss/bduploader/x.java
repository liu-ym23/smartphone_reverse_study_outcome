package com.ss.bduploader;

import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploadEventManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum x extends Enum<x> {
    private static final String TAG = "UploadEventManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f37566a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ x[] f37567e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f37568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.ss.bduploader.a.b f37569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37570d;

    public static x valueOf(String r2) {
        return (x) ZeusTransformUtils.preCheckCast(Enum.valueOf(x.class, r2), x.class, "com.obric.aiagent.plugin");
    }

    public static x[] values() {
        return (x[]) ZeusTransformUtils.preCheckCast(f37567e.clone(), x[].class, "com.obric.aiagent.plugin");
    }

    static {
        x r0 = new x("instance", 0);
        f37566a = r0;
        f37567e = new x[]{r0};
    }

    private x(String r1, int r2) {
        super(r1, r2);
        this.f37568b = new JSONArray();
        this.f37570d = true;
        a(com.ss.bduploader.a.a.a());
    }

    public synchronized void a(com.ss.bduploader.a.b r3) {
        monitor-enter(this);
        this.f37569c = (com.ss.bduploader.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.bduploader.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(JSONObject r4) {
        monitor-enter(x.class);
        if (r4 != null) goto L25;
    L18:
        monitor-exit(x.class);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L25:
        if (this.f37569c != null) goto L8;
    L17:
        this.f37568b.put(r4);     // Catch: Throwable -> L20
        goto L18
    L8:
        if (this.f37570d == false) goto L17;
        String r1 = null;
        r1 = r4.getString("event");     // Catch: JSONException -> L12 Throwable -> L20
    L15:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        this.f37569c.a(r1, r4);     // Catch: Throwable -> L20
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L15
    }

    public void b(JSONObject r4) {
        monitor-enter(x.class);
        a("ttmn", "putEvent");     // Catch: Throwable -> L7
        this.f37568b.put(r4);     // Catch: Throwable -> L7
        monitor-exit(x.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
