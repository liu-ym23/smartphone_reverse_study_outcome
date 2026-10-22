package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sms_received")
    public static final f f32904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("bluetooth_connected")
    public static final f f32905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("wifi_connected")
    public static final f f32906c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("battery_charged_to")
    public static final f f32907d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("battery_discharged_to")
    public static final f f32908e = null;

    @SerializedName("storage_low")
    public static final f f = null;
    private static final /* synthetic */ f[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    private static final /* synthetic */ f[] a() {
        return new f[]{f32904a, f32905b, f32906c, f32907d, f32908e, f};
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f32904a = new f("SMS_RECEIVED", 0);
        f32905b = new f("BLUETOOTH_CONNECTED", 1);
        f32906c = new f("WIFI_CONNECTED", 2);
        f32907d = new f("BATTERY_CHARGED_TO", 3);
        f32908e = new f("BATTERY_DISCHARGED_TO", 4);
        f = new f("STORAGE_LOW", 5);
        f[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(g.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
