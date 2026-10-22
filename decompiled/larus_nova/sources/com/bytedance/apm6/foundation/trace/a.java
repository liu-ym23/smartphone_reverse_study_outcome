package com.bytedance.apm6.foundation.trace;

import android.os.Process;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    static {
        Process.myPid();
    }

    public static void b(String r100, long r101, String r102, int r103, long r104, JSONObject r105) {
        TraceBean r106 = new TraceBean();
        r106.f190806a = r100;
        r106.f190807b = r101;
        r106.f190808c = r102;
        r106.f190810e = r103;
        r106.f190811f = r104;
        r106.f190812g = TraceBean.TraceType.ASYNC_SLICE_END;
        r106.f190813h = r105;
        r106.a();
    }

    public static void a(String r100, long r101, String r102, String r103, long r104, int r105, JSONObject r106) {
        TraceBean r107 = new TraceBean();
        r107.f190806a = r100;
        r107.f190807b = r101;
        r107.f190808c = r102;
        r107.f190811f = r104;
        r107.f190809d = r103;
        r107.f190810e = r105;
        r107.f190812g = TraceBean.TraceType.ASYNC_SLICE_BEGIN;
        r107.f190813h = r106;
        r107.a();
    }
}
