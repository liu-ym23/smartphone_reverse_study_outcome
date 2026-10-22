package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/c0;", "", "", "tagCode", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTagCode", "(Ljava/lang/String;)V", "", "counter", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setCounter", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("counter")
    private Integer counter;

    @SerializedName("tag_code")
    private String tagCode;

    public static final class a {
    }

    static {
    }

    public c0() {
    }

    public final int hashCode() {
        Integer r100 = this.counter;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tagCode;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Integer a() {
        return this.counter;
    }

    public final String b() {
        return this.tagCode;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c0) == true) goto L5;
        return false;
    L5:
        if (this == r100) goto L7;
        return false;
    L7:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.counter, r101.counter) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tagCode, r101.tagCode) == false) goto L14;
        return true;
    L14:
        return false;
    }
}
