package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/a;", "", "", "btm", "Ljava/lang/String;", "getBtm", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "path", "c", "", "addBtmList", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "btmListLength", "I", "b", "()I", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("add_btm_list")
    private final boolean addBtmList;

    @SerializedName("btm")
    private final String btm;

    @SerializedName("btm_list_length")
    private final int btmListLength;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("path")
    private final String path;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (this.addBtmList == r101.addBtmList) goto L14;
        return false;
    L14:
        if (this.btmListLength == r101.btmListLength) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.btm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.desc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.path;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.addBtmList;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return ((r108 + r110) * 31) + this.btmListLength;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnnieSchemaItem(btm=" + this.btm + ", desc=" + this.desc + ", path=" + this.path + ", addBtmList=" + this.addBtmList + ", btmListLength=" + this.btmListLength + ")";
    }

    public a() {
        this.btm = null;
        this.desc = null;
        this.path = null;
        this.addBtmList = false;
        this.btmListLength = 0;
    }

    public final boolean a() {
        return this.addBtmList;
    }

    public final int b() {
        return this.btmListLength;
    }

    public final String c() {
        return this.path;
    }
}
