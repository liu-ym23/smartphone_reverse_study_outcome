package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/CertSignParams;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "app_id", "", "merchant_id", "pin", "origin_data", "sign_factor", "sign_factor_id", "logParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "lackOfSignFactor", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CertSignParams implements Serializable, CJPayObject {
    public String app_id;
    public JSONObject logParams;
    public String merchant_id;
    public final String origin_data;
    public final String pin;
    public final String sign_factor;
    public final String sign_factor_id;

    public CertSignParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CertSignParams copy$default(CertSignParams r100, String r101, String r102, String r103, String r104, String r110, String r111, JSONObject r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.app_id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.merchant_id;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.pin;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.origin_data;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.sign_factor;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.sign_factor_id;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.logParams;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.app_id;
    }

    public final String component2() {
        return this.merchant_id;
    }

    public final String component3() {
        return this.pin;
    }

    public final String component4() {
        return this.origin_data;
    }

    public final String component5() {
        return this.sign_factor;
    }

    public final String component6() {
        return this.sign_factor_id;
    }

    public final JSONObject component7() {
        return this.logParams;
    }

    public final CertSignParams copy(String r110, String r111, String r112, String r113, String r114, String r115, JSONObject r116) {
        return new CertSignParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CertSignParams) == true) goto L8;
        return false;
    L8:
        CertSignParams r101 = (CertSignParams) r100;
        if (Intrinsics.areEqual(this.app_id, r101.app_id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.merchant_id, r101.merchant_id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pin, r101.pin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.origin_data, r101.origin_data) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sign_factor, r101.sign_factor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sign_factor_id, r101.sign_factor_id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.logParams, r101.logParams) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.app_id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.merchant_id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.origin_data;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sign_factor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.sign_factor_id;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.logParams;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CertSignParams(app_id=" + this.app_id + ", merchant_id=" + this.merchant_id + ", pin=" + this.pin + ", origin_data=" + this.origin_data + ", sign_factor=" + this.sign_factor + ", sign_factor_id=" + this.sign_factor_id + ", logParams=" + this.logParams + ')';
    }

    public final boolean isValid() {
        String r100 = this.app_id;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L39;
        String r102 = this.merchant_id;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L40;
        String r104 = this.origin_data;
        if (r104 != null) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L41;
        String r106 = this.sign_factor;
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == false) goto L42;
        String r108 = this.sign_factor_id;
        if (r108 != null) goto L33;
    L35:
        boolean r109 = false;
    L36:
        if (r109 == false) goto L43;
        return true;
    L43:
        return false;
    L33:
        if ((!StringsKt.isBlank(r108)) != true) goto L35;
        r109 = true;
        goto L36
    L42:
        return false;
    L26:
        if ((!StringsKt.isBlank(r106)) != true) goto L28;
        r107 = true;
        goto L29
    L41:
        return false;
    L19:
        if ((!StringsKt.isBlank(r104)) != true) goto L21;
        r105 = true;
        goto L22
    L40:
        return false;
    L12:
        if ((!StringsKt.isBlank(r102)) != true) goto L14;
        r103 = true;
        goto L15
    L39:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean lackOfSignFactor() {
        String r100 = this.app_id;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L39;
        String r102 = this.merchant_id;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L40;
        String r104 = this.origin_data;
        if (r104 != null) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L41;
        String r106 = this.sign_factor;
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == false) goto L37;
        String r108 = this.sign_factor_id;
        if (r108 != null) goto L33;
    L35:
        boolean r109 = false;
    L36:
        if (r109 == false) goto L37;
        return false;
    L33:
        if ((!StringsKt.isBlank(r108)) != true) goto L35;
        r109 = true;
    L37:
        return true;
    L26:
        if ((!StringsKt.isBlank(r106)) != true) goto L28;
        r107 = true;
        goto L29
    L41:
        return false;
    L19:
        if ((!StringsKt.isBlank(r104)) != true) goto L21;
        r105 = true;
        goto L22
    L40:
        return false;
    L12:
        if ((!StringsKt.isBlank(r102)) != true) goto L14;
        r103 = true;
        goto L15
    L39:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r101 = true;
        goto L8
    }

    public CertSignParams(String r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106) {
        this.app_id = r100;
        this.merchant_id = r101;
        this.pin = r102;
        this.origin_data = r103;
        this.sign_factor = r104;
        this.sign_factor_id = r105;
        this.logParams = r106;
    }

    public /* synthetic */ CertSignParams(String r100, String r101, String r102, String r103, String r110, String r111, JSONObject r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r108 = "";
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = null;
    L29:
        JSONObject r116 = r112;
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
