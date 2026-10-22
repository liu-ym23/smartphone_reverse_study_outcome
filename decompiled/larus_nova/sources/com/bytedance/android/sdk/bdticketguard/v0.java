package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/v0;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "ticket", "b", "ts_sign", "c", "ts_sign_ree", "d", TextureRenderKeys.KEY_IS_CERT, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class v0 {

    @SerializedName(TextureRenderKeys.KEY_IS_CERT)
    private final String cert;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ts_sign")
    private final String ts_sign;

    @SerializedName("ts_sign_ree")
    private final String ts_sign_ree;

    @SerializedName("type")
    private final String type;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/v0$a;", "", "", "ts_sign", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ts_sign_ree", "b", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("ts_sign")
        private final String ts_sign;

        @SerializedName("ts_sign_ree")
        private final String ts_sign_ree;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.ts_sign, r101.ts_sign) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.ts_sign_ree, r101.ts_sign_ree) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.ts_sign;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.ts_sign_ree;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CombineTsSign(ts_sign=" + this.ts_sign + ", ts_sign_ree=" + this.ts_sign_ree + ")";
        }

        public final String a() {
            return this.ts_sign;
        }

        public final String b() {
            return this.ts_sign_ree;
        }

        public a(String r100, String r101) {
            this.ts_sign = r100;
            this.ts_sign_ree = r101;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L16;
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ts_sign, r101.ts_sign) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ts_sign_ree, r101.ts_sign_ree) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cert, r101.cert) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.ticket;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ts_sign;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ts_sign_ree;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cert;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "TicketDataBean(type=" + this.type + ", ticket=" + this.ticket + ", ts_sign=" + this.ts_sign + ", ts_sign_ree=" + this.ts_sign_ree + ", cert=" + this.cert + ")";
    }

    public final u0 e() {
        return new u0(this.type, this.ticket, GsonProtectorUtils.toJson(TicketGuardApiKt.a(), new a(this.ts_sign, this.ts_sign_ree)), this.cert);
    }

    public final String a() {
        return this.cert;
    }

    public final String b() {
        return this.ticket;
    }

    public final String c() {
        return this.ts_sign;
    }

    public final String d() {
        return this.ts_sign_ree;
    }

    public final String getType() {
        return this.type;
    }

    public v0(String r100, String r101, String r102, String r103, String r104) {
        this.type = r100;
        this.ticket = r101;
        this.ts_sign = r102;
        this.ts_sign_ree = r103;
        this.cert = r104;
    }
}
