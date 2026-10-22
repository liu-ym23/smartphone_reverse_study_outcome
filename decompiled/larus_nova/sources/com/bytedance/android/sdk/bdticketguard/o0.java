package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0007R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/o0;", "Lcom/bytedance/android/sdk/bdticketguard/m0;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/sdk/bdticketguard/o0$a;", "Lkotlin/collections/ArrayList;", "itemArray", "Ljava/util/ArrayList;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/ArrayList;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class o0 implements m0 {

    @SerializedName("tickets")
    private final ArrayList<a> itemArray;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/o0$a;", "", "", "ticket", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "tsSign", "b", "tsSignRee", "c", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName("ticket")
        private final String ticket;

        @SerializedName("ts_sign")
        private final String tsSign;

        @SerializedName("ts_sign_ree")
        private final String tsSignRee;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.tsSign, r101.tsSign) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.tsSignRee, r101.tsSignRee) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.ticket;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.tsSign;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.tsSignRee;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ServerDataItem(ticket=" + this.ticket + ", tsSign=" + this.tsSign + ", tsSignRee=" + this.tsSignRee + ")";
        }

        public final String a() {
            return this.ticket;
        }

        public final String b() {
            return this.tsSign;
        }

        public final String c() {
            return this.tsSignRee;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.itemArray, ((o0) r100).itemArray) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ArrayList<a> r100 = this.itemArray;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ServerDataV2(itemArray=" + this.itemArray + ")";
    }

    public final ArrayList<a> a() {
        return this.itemArray;
    }
}
