package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/a;", "", "", "additionalType", "I", "b", "()I", "", "additionalModel", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f53481a = 0;

    @SerializedName("additional_model")
    private final String additionalModel;

    @SerializedName("additional_type")
    private final int additionalType;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.base.model.a$a, reason: collision with other inner class name */
    public static final class C0879a {
    }

    static {
    }

    public a() {
        this(0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.additionalType == r101.additionalType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.additionalModel, r101.additionalModel) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.additionalType * 31;
        String r101 = this.additionalModel;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "AdditionalDescription(additionalType=" + this.additionalType + ", additionalModel=" + this.additionalModel + ")";
    }

    public final String a() {
        return this.additionalModel;
    }

    public final int b() {
        return this.additionalType;
    }

    public a(int r100, String r101) {
        this.additionalType = r100;
        this.additionalModel = r101;
    }
}
