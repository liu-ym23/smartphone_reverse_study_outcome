package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("once")
    public static final l f32930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("daily")
    public static final l f32931b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("weekly")
    public static final l f32932c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("monthly")
    public static final l f32933d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("yearly")
    public static final l f32934e = null;

    @SerializedName("workday")
    public static final l f = null;

    @SerializedName("holiday")
    public static final l g = null;
    private static final /* synthetic */ l[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f32930a, f32931b, f32932c, f32933d, f32934e, f, g};
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32930a = new l("ONCE", 0);
        f32931b = new l("DAILY", 1);
        f32932c = new l("WEEKLY", 2);
        f32933d = new l("MONTHLY", 3);
        f32934e = new l("YEARLY", 4);
        f = new l("WORKDAY", 5);
        g = new l("HOLIDAY", 6);
        l[] r0 = a();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(h.clone(), l[].class, "com.obric.aiagent.plugin");
    }
}
