package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PickerSelectionMode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f34388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f34389b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ m[] f34390c = null;

    private static final /* synthetic */ m[] a() {
        return new m[]{f34388a, f34389b};
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f34390c.clone(), m[].class, "com.obric.aiagent.plugin");
    }

    static {
        f34388a = new m("SINGLE", 0);
        f34389b = new m("MULTIPLE", 1);
        f34390c = a();
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }
}
