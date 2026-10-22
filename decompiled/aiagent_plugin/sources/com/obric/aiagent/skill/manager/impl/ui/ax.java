package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ax extends Enum<ax> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ax f20582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ax f20583b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ax f20584c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ax[] f20585d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20586e = null;

    private static final /* synthetic */ ax[] a() {
        return new ax[]{f20582a, f20583b, f20584c};
    }

    private ax(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20582a = new ax("CREATE", 0);
        f20583b = new ax("IMPORT", 1);
        f20584c = new ax("EDIT", 2);
        ax[] r0 = a();
        f20585d = r0;
        f20586e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ax valueOf(String r2) {
        return (ax) ZeusTransformUtils.preCheckCast(Enum.valueOf(ax.class, r2), ax.class, "com.obric.aiagent.plugin");
    }

    public static ax[] values() {
        return (ax[]) ZeusTransformUtils.preCheckCast(f20585d.clone(), ax[].class, "com.obric.aiagent.plugin");
    }
}
