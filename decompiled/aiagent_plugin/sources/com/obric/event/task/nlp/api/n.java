package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("draft")
    public static final n f32939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("submitted")
    public static final n f32940b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ n[] f32941c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f32942d = null;

    private static final /* synthetic */ n[] a() {
        return new n[]{f32939a, f32940b};
    }

    private n(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32939a = new n("DRAFT", 0);
        f32940b = new n("SUBMITTED", 1);
        n[] r0 = a();
        f32941c = r0;
        f32942d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f32941c.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
