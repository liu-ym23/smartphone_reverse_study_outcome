package com.stepos.core.ota.domain.model;

import ai.onnxruntime.a;
import gc.q;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Integrity {
    private final String md5;
    private final String sha256;
    private final String signature;

    public Integrity() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Integrity copy$default(Integrity integrity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = integrity.md5;
        }
        if ((i10 & 2) != 0) {
            str2 = integrity.sha256;
        }
        if ((i10 & 4) != 0) {
            str3 = integrity.signature;
        }
        return integrity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.md5;
    }

    public final String component2() {
        return this.sha256;
    }

    public final String component3() {
        return this.signature;
    }

    public final Integrity copy(String str, String str2, String str3) {
        return new Integrity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Integrity)) {
            return false;
        }
        Integrity integrity = (Integrity) obj;
        return g.b(this.md5, integrity.md5) && g.b(this.sha256, integrity.sha256) && g.b(this.signature, integrity.signature);
    }

    public final boolean getHasAny() {
        String str = this.md5;
        if (str != null && !q.t0(str)) {
            return true;
        }
        String str2 = this.sha256;
        if (str2 != null && !q.t0(str2)) {
            return true;
        }
        String str3 = this.signature;
        return (str3 == null || q.t0(str3)) ? false : true;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        String str = this.md5;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sha256;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.signature;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.md5;
        String str2 = this.sha256;
        return a.o(a.s("Integrity(md5=", str, ", sha256=", str2, ", signature="), this.signature, ")");
    }

    public Integrity(String str, String str2, String str3) {
        this.md5 = str;
        this.sha256 = str2;
        this.signature = str3;
    }

    public /* synthetic */ Integrity(String str, String str2, String str3, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
