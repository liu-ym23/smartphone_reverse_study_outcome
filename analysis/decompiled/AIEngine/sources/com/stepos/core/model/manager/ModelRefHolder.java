package com.stepos.core.model.manager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelRefHolder {
    private final String holderToken;
    private final int pid;
    private final String pkg;
    private final int uid;
    private final int userId;

    public ModelRefHolder(String holderToken, String pkg, int i10, int i11, int i12) {
        kotlin.jvm.internal.g.f(holderToken, "holderToken");
        kotlin.jvm.internal.g.f(pkg, "pkg");
        this.holderToken = holderToken;
        this.pkg = pkg;
        this.uid = i10;
        this.pid = i11;
        this.userId = i12;
    }

    public static /* synthetic */ ModelRefHolder copy$default(ModelRefHolder modelRefHolder, String str, String str2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = modelRefHolder.holderToken;
        }
        if ((i13 & 2) != 0) {
            str2 = modelRefHolder.pkg;
        }
        if ((i13 & 4) != 0) {
            i10 = modelRefHolder.uid;
        }
        if ((i13 & 8) != 0) {
            i11 = modelRefHolder.pid;
        }
        if ((i13 & 16) != 0) {
            i12 = modelRefHolder.userId;
        }
        int i14 = i12;
        int i15 = i10;
        return modelRefHolder.copy(str, str2, i15, i11, i14);
    }

    public final String component1() {
        return this.holderToken;
    }

    public final String component2() {
        return this.pkg;
    }

    public final int component3() {
        return this.uid;
    }

    public final int component4() {
        return this.pid;
    }

    public final int component5() {
        return this.userId;
    }

    public final ModelRefHolder copy(String holderToken, String pkg, int i10, int i11, int i12) {
        kotlin.jvm.internal.g.f(holderToken, "holderToken");
        kotlin.jvm.internal.g.f(pkg, "pkg");
        return new ModelRefHolder(holderToken, pkg, i10, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelRefHolder)) {
            return false;
        }
        ModelRefHolder modelRefHolder = (ModelRefHolder) obj;
        return kotlin.jvm.internal.g.b(this.holderToken, modelRefHolder.holderToken) && kotlin.jvm.internal.g.b(this.pkg, modelRefHolder.pkg) && this.uid == modelRefHolder.uid && this.pid == modelRefHolder.pid && this.userId == modelRefHolder.userId;
    }

    public final String getHolderToken() {
        return this.holderToken;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getUid() {
        return this.uid;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return Integer.hashCode(this.userId) + ai.onnxruntime.a.d(this.pid, ai.onnxruntime.a.d(this.uid, v1.d.a(this.holderToken.hashCode() * 31, 31, this.pkg), 31), 31);
    }

    public String toString() {
        String str = this.holderToken;
        String str2 = this.pkg;
        int i10 = this.uid;
        int i11 = this.pid;
        int i12 = this.userId;
        StringBuilder sbS = ai.onnxruntime.a.s("ModelRefHolder(holderToken=", str, ", pkg=", str2, ", uid=");
        h0.e.l(sbS, i10, ", pid=", i11, ", userId=");
        return ai.onnxruntime.a.j(")", i12, sbS);
    }
}
