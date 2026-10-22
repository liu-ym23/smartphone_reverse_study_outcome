package com.baidu.mshield.x0.jni;

import com.baidu.mshield.b.c.a;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.f.j;

/* JADX INFO: loaded from: classes39.dex */
public class Native {
    public Native() {
    }

    public static String nsctl(String r100, int r101) {
        a.b("native shell, cmd: " + r100 + ", max: " + r101);
    L11:
        th = move-exception;
        d.a(th);
        return "#NULL";
    L4:
        if (d.a(EngineImpl.mContext, "plc62", false) == true) goto L6;
        return null;
    L6:
        if (new com.baidu.mshield.x0.l.a(EngineImpl.mContext).l() == 1) goto L10;
        return null;
    L10:
        return "#NULL";
    }

    public static String doExecNonStaticMethod(String r100, String r101, String r102, String r103) {
        return j.a(r100, r101, r102, r103);
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }

    public static String doExecStaticMethod(String r100, String r101, String r102, String r103) {
        return j.b(r100, r101, r102, r103);
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }
}
