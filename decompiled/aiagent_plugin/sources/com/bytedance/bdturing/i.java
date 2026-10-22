package com.bytedance.bdturing;

import android.view.MotionEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OnTouchSmarterListener.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f6565c = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6567b;

    /* JADX INFO: compiled from: OnTouchSmarterListener.java */
    public interface a {
        void a(JSONObject r1);
    }

    static {
    }

    public i() {
        this.f6566a = 0;
    }

    public void a() {
        this.f6566a = System.currentTimeMillis();
    }

    public void a(MotionEvent r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if (c() == true) goto L6;
        this.f6567b = System.currentTimeMillis();
        r5.a(a(r3));
        return;
    }

    private JSONObject a(MotionEvent r9) {
        JSONObject r0 = new JSONObject();
        float r1 = r9.getPressure();
        float r2 = r9.getTouchMajor();
        JSONArray r3 = new JSONArray();
        long r4 = this.f6567b - this.f6566a;
        r3.put(r9.getX());     // Catch: JSONException -> L5
        r3.put(r9.getY());     // Catch: JSONException -> L5
        r0.put(DBDefinition.FORCE, r1);     // Catch: JSONException -> L5
        r0.put("majorRadius", r2);     // Catch: JSONException -> L5
        r0.put("click_coordinate", r3);     // Catch: JSONException -> L5
        r0.put("click_duration", r4);     // Catch: JSONException -> L5
        r0.put("operate_duration", 0);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public long b() {
        return this.f6566a;
    }

    private boolean c() {
        if ((System.currentTimeMillis() - this.f6567b) >= f6565c) goto L5;
        return true;
    L5:
        return false;
    }
}
