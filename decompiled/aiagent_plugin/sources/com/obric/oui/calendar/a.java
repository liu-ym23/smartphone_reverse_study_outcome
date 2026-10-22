package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CalendarMode.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f34363b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f34364d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f34365c;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f34364d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("MONTHS", 0, 5);
        f34362a = r0;
        a r1 = new a("WEEKS", 1, 1);
        f34363b = r1;
        f34364d = new a[]{r0, r1};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f34365c = r3;
    }
}
