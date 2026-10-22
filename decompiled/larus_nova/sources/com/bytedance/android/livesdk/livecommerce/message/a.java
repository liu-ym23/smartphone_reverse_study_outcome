package com.bytedance.android.livesdk.livecommerce.message;

import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f149379i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f149380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f149381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f149382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f149383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f149384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f149385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f149386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f149387h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.message.a$a, reason: collision with other inner class name */
    public static final class C2311a {
        @JvmStatic
        public static a a(sg2.b r100) {
            if (r100 == null) goto L15;
            TraceTimeMetricV2 r101 = r100.f541773d;
            if (r101 == null) goto L15;
            if (r101.getOpTimestamp() <= 0) goto L15;
            if (r101.getMsgSendTimestamp() <= 0) goto L15;
            a r102 = new a();
            r102.f149381b = r101.getOpTimestamp();
            r102.f149382c = r101.getProducerDuration();
            r102.f149383d = r101.getConsumerDuration();
            r102.f149384e = r101.getMsgSendTimestamp();
            String r103 = r100.f541771b;
            if (r103 != null) goto L14;
            r103 = "";
        L14:
            r102.f149386g = r103;
            return r102;
        L15:
            return null;
        }
    }

    static {
    }

    public final void a() {
        if (this.f149380a == false) goto L5;
        return;
    L5:
        this.f149380a = true;
        long r100 = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L10
        r101.put("type", this.f149386g);     // Catch: Exception -> L10
        r101.put("scene", this.f149387h);     // Catch: Exception -> L10
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L10
        r102.put("duration", r100 - this.f149381b);     // Catch: Exception -> L10
        r102.put("duration_added", ((this.f149382c + this.f149383d) + r100) - this.f149384e);     // Catch: Exception -> L10
        r102.put("business_duration", this.f149382c);     // Catch: Exception -> L10
        r102.put("message_duration", this.f149383d);     // Catch: Exception -> L10
        r102.put("live_message_center_duration", this.f149385f - this.f149384e);     // Catch: Exception -> L10
        r102.put("render_duration", r100 - this.f149385f);     // Catch: Exception -> L10
        int r103 = ECSdk.f48106a;     // Catch: Exception -> L10
        pi.b r104 = (pi.b) ECSdk.a(pi.b.class);     // Catch: Exception -> L10
        if (r104 == null) goto L13;
        r104.monitorEvent("live_ec_update_message_duration", r101, r102, null);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    public a() {
        this.f149386g = "";
        this.f149387h = "";
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f149385f = System.currentTimeMillis();
        this.f149387h = r100;
    }
}
