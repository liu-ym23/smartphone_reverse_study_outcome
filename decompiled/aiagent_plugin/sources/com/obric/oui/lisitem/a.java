package com.obric.oui.lisitem;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ListItemHeightMode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f35414b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f35415c = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f35413a, f35414b};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f35415c.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f35413a = new a("DEFAULT", 0);
        f35414b = new a("COMPACT", 1);
        f35415c = a();
    }
}
