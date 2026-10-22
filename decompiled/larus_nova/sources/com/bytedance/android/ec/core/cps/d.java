package com.bytedance.android.ec.core.cps;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/cps/d;", "", "", "function", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "version", ce.f26391f, "createTime", "b", "salt", "f", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "hashEncoder", "d", "cnt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, com.heytap.mcssdk.constant.b.f276366p, "e", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName(BackupSeiMessage.SOURCE_PC)
    private final Integer cnt;

    @SerializedName("ct")
    private final String createTime;

    @SerializedName("f")
    private final String function;

    @SerializedName("am")
    private final String hashEncoder;

    @SerializedName("r")
    private final String rule;

    @SerializedName("s")
    private final String salt;

    @SerializedName("t")
    private final Integer type;

    @SerializedName(BaseSwitches.V)
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.function, r101.function) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.salt, r101.salt) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hashEncoder, r101.hashEncoder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cnt, r101.cnt) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rule, r101.rule) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.function;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.version;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.createTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.salt;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.type;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.hashEncoder;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.cnt;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.rule;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventConfig(function=" + this.function + ", version=" + this.version + ", createTime=" + this.createTime + ", salt=" + this.salt + ", type=" + this.type + ", hashEncoder=" + this.hashEncoder + ", cnt=" + this.cnt + ", rule=" + this.rule + ")";
    }

    public d() {
        this.function = null;
        this.version = null;
        this.createTime = null;
        this.salt = null;
        this.type = null;
        this.hashEncoder = null;
        this.cnt = null;
        this.rule = null;
    }

    public final Integer a() {
        return this.cnt;
    }

    public final String b() {
        return this.createTime;
    }

    public final String c() {
        return this.function;
    }

    public final String d() {
        return this.hashEncoder;
    }

    public final String e() {
        return this.rule;
    }

    public final String f() {
        return this.salt;
    }

    public final String g() {
        return this.version;
    }

    public final Integer getType() {
        return this.type;
    }
}
