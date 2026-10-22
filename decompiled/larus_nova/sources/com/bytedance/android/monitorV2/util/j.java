package com.bytedance.android.monitorV2.util;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163239a = 0;

    public static final class a {
        public static JSONObject a(JSONObject r100) {
            JSONObject r101 = new JSONObject();
            if (r100 == null) goto L38;
            String r102 = l.l(r100, "pid");
            boolean r103 = false;
            if (r102.length() <= 0) goto L7;
            boolean r104 = true;
        L8:
            if (r104 == false) goto L10;
            l.q(r101, "pid", r102);
        L10:
            String r105 = l.l(r100, "bid");
            if (r105.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 == false) goto L16;
            l.q(r101, "bid", r105);
        L16:
            JSONObject r107 = l.i(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r107 == null) goto L27;
            Iterator<String> r108 = r107.keys();
        L20:
            if (r108.hasNext() == false) goto L26;
            String r109 = r108.next();
            Object r110 = r107.get(r109);
            if (r110 == null) goto L20;
            if ((r110 instanceof String) == true) goto L20;
            l.q(r107, r109, r110.toString());
            goto L20
        L26:
            l.p(r101, PerfLog.PARAM_KEY_CONTEXT_ID, r107);
        L27:
            String r111 = l.l(r100, "env");
            if (r111.length() <= 0) goto L30;
            boolean r112 = true;
        L31:
            if (r112 == false) goto L33;
            l.q(r101, "env", r111);
        L33:
            String r113 = l.l(r100, "release");
            if (r113.length() <= 0) goto L36;
            r103 = true;
        L36:
            if (r103 == false) goto L38;
            l.q(r101, "release", r113);
            goto L38
        L30:
            r112 = false;
            goto L31
        L13:
            r106 = false;
            goto L14
        L7:
            r104 = false;
        L38:
            return r101;
        }
    }

    static {
    }
}
