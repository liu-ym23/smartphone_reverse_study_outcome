package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f19262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f19263b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f19264c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ i[] f19265d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19266e = null;

    private static final /* synthetic */ i[] a() {
        return new i[]{f19262a, f19263b, f19264c};
    }

    private i(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19262a = new i("CREATE", 0);
        f19263b = new i("UPDATE", 1);
        f19264c = new i("NO_CHANGE", 2);
        i[] r0 = a();
        f19265d = r0;
        f19266e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(f19265d.clone(), i[].class, "com.obric.aiagent.plugin");
    }
}
