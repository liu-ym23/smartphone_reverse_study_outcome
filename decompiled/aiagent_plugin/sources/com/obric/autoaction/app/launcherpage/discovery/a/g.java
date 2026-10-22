package com.obric.autoaction.app.launcherpage.discovery.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.plugin.R;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("condition_type")
    private final Integer f23598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("start_time")
    private final String f23599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("end_time")
    private final String f23600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("location_mode")
    private final Integer f23601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("location_type")
    private final Integer f23602e;

    @SerializedName("longitude")
    private final Double f;

    @SerializedName("latitude")
    private final Double g;

    @SerializedName("radius")
    private final Integer h;

    @SerializedName("addr_name")
    private final String i;

    @SerializedName("addr_type")
    private final Integer j;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23598a, r6.f23598a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23599b, r6.f23599b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23600c, r6.f23600c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23601d, r6.f23601d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f23602e, r6.f23602e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f23598a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f23599b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f23600c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.f23601d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.f23602e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Double r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InstructionCondition(conditionType=" + this.f23598a + ", startTime=" + this.f23599b + ", endTime=" + this.f23600c + ", locationMode=" + this.f23601d + ", locationType=" + this.f23602e + ", longitude=" + this.f + ", latitude=" + this.g + ", radius=" + this.h + ", addrName=" + this.i + ", addrType=" + this.j + ')';
    }

    public g(Integer r1, String r2, String r3, Integer r4, Integer r5, Double r6, Double r7, Integer r8, String r9, Integer r10) {
        this.f23598a = r1;
        this.f23599b = r2;
        this.f23600c = r3;
        this.f23601d = r4;
        this.f23602e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public /* synthetic */ g(Integer r2, String r3, String r4, Integer r5, Integer r6, Double r7, Double r8, Integer r9, String r10, Integer r11, int r12, d.h.b.h r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Condition a(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "context");
        Integer r0 = this.f23598a;
        int r2 = j.f23611b.a();
        Object r3 = null;
        if (r0 != null) goto L6;
    L11:
        int r4 = j.f23612c.a();
        if (r0 != null) goto L15;
        return null;
    L15:
        if (r0.intValue() != r4) goto L59;
        Integer r1 = this.f23601d;
        if (r1 == null) goto L60;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r5 != m.f23619b.a()) goto L23;
        String r6 = "geo_radius";
    L21:
        String r7 = r6;
    L26:
        if (r7 == null) goto L63;
        Integer r8 = this.f23602e;
        if (r8 == null) goto L61;
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r9 != n.f23624b.a()) goto L35;
        String r10 = "inside";
    L33:
        String r11 = r10;
    L38:
        if (r11 == null) goto L64;
        Integer r12 = this.j;
        if (r12 == null) goto L48;
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r15 != f.f23594b.a()) goto L46;
        r3 = "home";
        goto L48
    L46:
        if (r15 != f.f23595c.a()) goto L48;
        r3 = "company";
    L48:
        String r16 = r3;
        if (d.h.b.o.a(r16, "home") == false) goto L53;
        String r17 = r14.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_home"));
    L57:
        return (Condition) ZeusTransformUtils.preCheckCast(new LocationCondition(r7, r11, this.f, this.g, this.h, r17, r16), Condition.class, "com.obric.aiagent.plugin");
    L53:
        if (d.h.b.o.a(r16, "company") == false) goto L55;
        r17 = r14.getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_company, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_company"));
        goto L57
    L55:
        r17 = this.i;
        goto L57
    L64:
        return null;
    L35:
        if (r9 != n.f23625c.a()) goto L37;
        r10 = "outside";
        goto L33
    L37:
        r11 = null;
        goto L38
    L61:
        return null;
    L63:
        return null;
    L23:
        if (r5 != m.f23620c.a()) goto L25;
        r6 = "place_alias";
        goto L21
    L25:
        r7 = null;
        goto L26
    L60:
        return null;
    L59:
        return null;
    L6:
        if (r0.intValue() != r2) goto L11;
        String r18 = this.f23599b;
        if (r18 == null) goto L58;
        r3 = new TimeCondition(r18, this.f23600c, 0, 4, null);
    L58:
        return (Condition) ZeusTransformUtils.preCheckCast(r3, Condition.class, "com.obric.aiagent.plugin");
    }
}
