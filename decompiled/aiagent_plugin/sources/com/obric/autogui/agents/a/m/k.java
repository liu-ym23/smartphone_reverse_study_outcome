package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f26676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f26677b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f26678c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f26679d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ k[] f26680e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f26676a, f26677b, f26678c, f26679d};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26676a = new k("SCREENSHOT", 0);
        f26677b = new k("VIEW_TREE", 1);
        f26678c = new k("TOP_COMPONENT", 2);
        f26679d = new k("IMAGE_HASH", 3);
        k[] r0 = a();
        f26680e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(f26680e.clone(), k[].class, "com.obric.aiagent.plugin");
    }
}
