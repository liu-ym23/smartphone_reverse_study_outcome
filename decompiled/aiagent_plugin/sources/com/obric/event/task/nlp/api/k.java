package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("home")
    public static final k f32925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("company")
    public static final k f32926b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(MonitorConstants.CUSTOM)
    public static final k f32927c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ k[] f32928d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f32929e = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f32925a, f32926b, f32927c};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32925a = new k("HOME", 0);
        f32926b = new k("COMPANY", 1);
        f32927c = new k("CUSTOM", 2);
        k[] r0 = a();
        f32928d = r0;
        f32929e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(f32928d.clone(), k[].class, "com.obric.aiagent.plugin");
    }
}
