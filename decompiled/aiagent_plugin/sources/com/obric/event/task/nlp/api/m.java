package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("open")
    public static final m f32935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("closed")
    public static final m f32936b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ m[] f32937c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f32938d = null;

    private static final /* synthetic */ m[] a() {
        return new m[]{f32935a, f32936b};
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32935a = new m("OPEN", 0);
        f32936b = new m("CLOSED", 1);
        m[] r0 = a();
        f32937c = r0;
        f32938d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f32937c.clone(), m[].class, "com.obric.aiagent.plugin");
    }
}
