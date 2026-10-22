package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enter")
    public static final j f32921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("leave")
    public static final j f32922b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ j[] f32923c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f32924d = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f32921a, f32922b};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32921a = new j("ENTER", 0);
        f32922b = new j("LEAVE", 1);
        j[] r0 = a();
        f32923c = r0;
        f32924d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f32923c.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
