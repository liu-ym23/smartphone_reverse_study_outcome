package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/address/b0;", "", "", "firstLength", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "secondLength", "b", "setSecondLength", "(I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("first_length")
    private final int firstLength;

    @SerializedName("second_length")
    private int secondLength;

    public static final class a {
    }

    static {
    }

    public b0() {
        this.firstLength = 20;
        this.secondLength = 50;
    }

    public final int a() {
        return this.firstLength;
    }

    public final int b() {
        return this.secondLength;
    }
}
