package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.impl;

import com.alipay.sdk.m.p.e;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.ttvideoengine.model.SubInfo;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import ouc.d0;
import ouc.f0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 >2\u00020\u0001:\u0002=>BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rBk\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J[\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u0006?"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/impl/ZGHttpContent;", "", e.f25671s, "", SubInfo.KEY_FORMAT, "charset", "version", "app_id", "merchant_id", com.alipay.sdk.m.k.b.C0, "Lkotlinx/serialization/json/JsonObject;", "timestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "getFormat", "setFormat", "getCharset", "setCharset", "getVersion", "setVersion", "getApp_id", "setApp_id", "getMerchant_id", "setMerchant_id", "getBiz_content", "()Lkotlinx/serialization/json/JsonObject;", "setBiz_content", "(Lkotlinx/serialization/json/JsonObject;)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ZGHttpContent {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private String app_id;
    private d0 biz_content;
    private String charset;
    private String format;
    private String merchant_id;
    private String method;
    private String timestamp;
    private String version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/impl/ZGHttpContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/impl/ZGHttpContent;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<ZGHttpContent> serializer() {
            return ZGHttpContent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public ZGHttpContent() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ZGHttpContent copy$default(ZGHttpContent r100, String r110, String r111, String r112, String r113, String r114, String r115, d0 r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.method;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.format;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.charset;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.version;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.app_id;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.merchant_id;
    L27:
        if ((r118 & 64) == 0) goto L29;
        d0 r107 = r100.biz_content;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.timestamp;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.method;
    }

    public final String component2() {
        return this.format;
    }

    public final String component3() {
        return this.charset;
    }

    public final String component4() {
        return this.version;
    }

    public final String component5() {
        return this.app_id;
    }

    public final String component6() {
        return this.merchant_id;
    }

    public final d0 component7() {
        return this.biz_content;
    }

    public final String component8() {
        return this.timestamp;
    }

    public final ZGHttpContent copy(String r110, String r111, String r112, String r113, String r114, String r115, d0 r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, e.f25671s);
        Intrinsics.checkNotNullParameter(r111, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r112, "charset");
        Intrinsics.checkNotNullParameter(r113, "version");
        Intrinsics.checkNotNullParameter(r114, "app_id");
        Intrinsics.checkNotNullParameter(r115, "merchant_id");
        Intrinsics.checkNotNullParameter(r117, "timestamp");
        return new ZGHttpContent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZGHttpContent) == true) goto L8;
        return false;
    L8:
        ZGHttpContent r101 = (ZGHttpContent) r100;
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.charset, r101.charset) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.app_id, r101.app_id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.merchant_id, r101.merchant_id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.biz_content, r101.biz_content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.method.hashCode() * 31) + this.format.hashCode()) * 31) + this.charset.hashCode()) * 31) + this.version.hashCode()) * 31) + this.app_id.hashCode()) * 31) + this.merchant_id.hashCode()) * 31;
        d0 r101 = this.biz_content;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.timestamp.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ZGHttpContent(method=" + this.method + ", format=" + this.format + ", charset=" + this.charset + ", version=" + this.version + ", app_id=" + this.app_id + ", merchant_id=" + this.merchant_id + ", biz_content=" + this.biz_content + ", timestamp=" + this.timestamp + ')';
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final d0 getBiz_content() {
        return this.biz_content;
    }

    public final String getCharset() {
        return this.charset;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getMerchant_id() {
        return this.merchant_id;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setApp_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.app_id = r100;
    }

    public final void setBiz_content(d0 r100) {
        this.biz_content = r100;
    }

    public final void setCharset(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.charset = r100;
    }

    public final void setFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.format = r100;
    }

    public final void setMerchant_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.merchant_id = r100;
    }

    public final void setMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void setTimestamp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timestamp = r100;
    }

    public final void setVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.version = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(ZGHttpContent r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeStringElement(r102, 0, r100.method);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeStringElement(r102, 1, r100.format);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeStringElement(r102, 2, r100.charset);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeStringElement(r102, 3, r100.version);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeStringElement(r102, 4, r100.app_id);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeStringElement(r102, 5, r100.merchant_id);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, f0.f526848a, r100.biz_content);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeStringElement(r102, 7, r100.timestamp);
        return;
    L74:
        return;
    L69:
        if (Intrinsics.areEqual(r100.timestamp, "") == true) goto L71;
    L60:
        if (r100.biz_content != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (Intrinsics.areEqual(r100.merchant_id, "") == false) goto L49;
        r109 = false;
        goto L54
    L42:
        if (Intrinsics.areEqual(r100.app_id, "") == false) goto L40;
        r108 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r100.version, "1.0") == false) goto L31;
        r107 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.charset, XML.CHARSET_UTF8) == false) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.format, "JSON") == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.method, "") == false) goto L4;
        r104 = false;
        goto L9
    }

    public ZGHttpContent(String r100, String r101, String r102, String r103, String r104, String r105, d0 r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "version");
        Intrinsics.checkNotNullParameter(r104, "app_id");
        Intrinsics.checkNotNullParameter(r105, "merchant_id");
        Intrinsics.checkNotNullParameter(r107, "timestamp");
        this.method = r100;
        this.format = r101;
        this.charset = r102;
        this.version = r103;
        this.app_id = r104;
        this.merchant_id = r105;
        this.biz_content = r106;
        this.timestamp = r107;
        this.timestamp = String.valueOf(MathKt.roundToLong(fuc.a.a().a() / 1000.0d));
    }

    public /* synthetic */ ZGHttpContent(int r100, String r101, String r102, String r103, String r104, String r105, String r106, d0 r110, String r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, ZGHttpContent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.method = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.format = "JSON";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.charset = XML.CHARSET_UTF8;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.version = "1.0";
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.app_id = "";
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.merchant_id = "";
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.biz_content = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.timestamp = "";
    L36:
        this.timestamp = String.valueOf(MathKt.roundToLong(fuc.a.a().a() / 1000.0d));
        return;
    L35:
        this.timestamp = r111;
        goto L36
    L31:
        this.biz_content = r110;
        goto L33
    L27:
        this.merchant_id = r106;
        goto L29
    L23:
        this.app_id = r105;
        goto L25
    L19:
        this.version = r104;
        goto L21
    L15:
        this.charset = r103;
        goto L17
    L11:
        this.format = r102;
        goto L13
    L7:
        this.method = r101;
        goto L9
    }

    public /* synthetic */ ZGHttpContent(String r110, String r111, String r112, String r113, String r114, String r115, d0 r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "JSON";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = XML.CHARSET_UTF8;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "1.0";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r118 & 64) == 0) goto L29;
        d0 r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
