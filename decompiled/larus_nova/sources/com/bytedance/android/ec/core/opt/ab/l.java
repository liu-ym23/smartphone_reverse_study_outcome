package com.bytedance.android.ec.core.opt.ab;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/l;", "", "Lcom/bytedance/android/ec/core/opt/ab/b;", "blackKeyConfig", "Lcom/bytedance/android/ec/core/opt/ab/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/core/opt/ab/b;", "setBlackKeyConfig", "(Lcom/bytedance/android/ec/core/opt/ab/b;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("black_key_config")
    private b blackKeyConfig;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.blackKeyConfig, ((l) r100).blackKeyConfig) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r100 = this.blackKeyConfig;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "NativePrefetchReuseConfig(blackKeyConfig=" + this.blackKeyConfig + ")";
    }

    public final b a() {
        return this.blackKeyConfig;
    }

    public l(int r100) {
        this.blackKeyConfig = null;
    }
}
