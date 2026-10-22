package com.obric.agent.intents.skill.d;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SystemSkillResultStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pending")
    public static final j f15176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("completed")
    public static final j f15177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("failed")
    public static final j f15178c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f15179d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f15180e = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f15176a, f15177b, f15178c};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f15176a = new j("PENDING", 0);
        f15177b = new j("COMPLETED", 1);
        f15178c = new j("FAILED", 2);
        j[] r0 = a();
        f15179d = r0;
        f15180e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f15179d.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
