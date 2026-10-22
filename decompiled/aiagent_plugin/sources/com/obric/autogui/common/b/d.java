package com.obric.autogui.common.b;

import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: TaskTerminationReasons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f29010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<Integer> f29011c = null;

    private d() {
    }

    public final List<Integer> a() {
        return f29010b;
    }

    static {
        f29009a = new d();
        f29010b = p.b(new Integer[]{105001, 105002});
        f29011c = p.b(new Integer[]{106001, 106002, 106003, 106004, 106005, 106006, 106007});
    }

    public final List<Integer> b() {
        return f29011c;
    }

    public final int a(int r1, String r2) {
        if (r1 != 0) goto L33;
        if (r2 != null) goto L5;
    L31:
        return 200000;
    L5:
        switch(r2.hashCode()) {
            case -1791952598: goto L28;
            case -1197094397: goto L24;
            case -1174157495: goto L20;
            case 417095: goto L16;
            case 1649871927: goto L12;
            case 1918881561: goto L8;
            default: goto L31;
        };
    L8:
        if (r2.equals("user_block") == false) goto L31;
        return 201003;
    L12:
        if (r2.equals("task_failed") == false) goto L31;
        return 200001;
    L16:
        if (r2.equals("content_block") == false) goto L31;
        return 201004;
    L20:
        if (r2.equals("task_success") == false) goto L31;
        return 0;
    L24:
        if (r2.equals("cloud_block") == false) goto L31;
        return 201002;
    L28:
        if (r2.equals("intent_block") == false) goto L31;
        return 201001;
    L33:
        return r1;
    }
}
