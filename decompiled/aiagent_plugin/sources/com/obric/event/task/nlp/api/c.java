package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("any_match")
    public static final c f32894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("all_match")
    public static final c f32895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ c[] f32896c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f32897d = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f32894a, f32895b};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32894a = new c("ANY_MATCH", 0);
        f32895b = new c("ALL_MATCH", 1);
        c[] r0 = a();
        f32896c = r0;
        f32897d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f32896c.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
