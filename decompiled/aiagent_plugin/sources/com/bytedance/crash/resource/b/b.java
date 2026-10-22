package com.bytedance.crash.resource.b;

import android.util.Log;
import com.bytedance.crash.resource.c;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;

/* JADX INFO: compiled from: GwpAsanConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private String h;
    private final String[] i;

    public b(JSONArray r12) {
        int r2 = 0;
        super(21, 33, 0);
        this.h = null;
        this.i = new String[]{"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};
        if (r12 != null) goto L5;
    L15:
        a("XASAN", "Config Init fail");
        return;
    L5:
        if (r12.length() >= 10) goto L15;
        StringBuilder r1 = new StringBuilder();
    L9:
        if (r2 >= r12.length()) goto L13;
        String[] r3 = this.i;
        if (r2 >= r3.length) goto L13;
        r1.append(r3[r2]);
        r1.append("=");
        r1.append(r12.optString(r2));
        r1.append("\n");
        r2 = r2 + 1;
    L13:
        this.h = r1.toString();
        b("XASAN", "Config Init:" + this.h);
    }

    @Override // com.bytedance.crash.resource.c
    public String toString() {
        return this.h;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
