package com.bytedance.android.ec.store.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/a;", "", "", "showBadge", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "toastText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "clientStoreParameter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("client_store_parameter")
    private final String clientStoreParameter;

    @SerializedName("show_badge")
    private final Boolean showBadge;

    @SerializedName("badge_message")
    private final String toastText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.showBadge, r101.showBadge) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.toastText, r101.toastText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clientStoreParameter, r101.clientStoreParameter) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.showBadge;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.toastText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.clientStoreParameter;
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
        return "BadgeInfo(showBadge=" + this.showBadge + ", toastText=" + this.toastText + ", clientStoreParameter=" + this.clientStoreParameter + ")";
    }

    public a() {
        this.showBadge = null;
        this.toastText = null;
        this.clientStoreParameter = null;
    }

    public final String a() {
        return this.clientStoreParameter;
    }

    public final Boolean b() {
        return this.showBadge;
    }

    public final String c() {
        return this.toastText;
    }
}
