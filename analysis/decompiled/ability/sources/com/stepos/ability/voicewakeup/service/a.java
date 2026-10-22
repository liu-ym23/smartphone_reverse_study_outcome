package com.stepos.ability.voicewakeup.service;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final C4.g f3322a;
    public final String b;
    public final String c;
    public final int d;
    public final int[] e;
    public final byte[] f;

    public a(C4.g gVar, String str, String str2, int i, int[] iArr, byte[] bArr) {
        this.f3322a = gVar;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = iArr;
        this.f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.k.b(this.f3322a, aVar.f3322a) && kotlin.jvm.internal.k.b(this.b, aVar.b) && kotlin.jvm.internal.k.b(this.c, aVar.c) && this.d == aVar.d && kotlin.jvm.internal.k.b(this.e, aVar.e) && kotlin.jvm.internal.k.b(this.f, aVar.f);
    }

    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.e) + androidx.constraintlayout.core.dsl.a.a(this.d, B7.a.c(B7.a.c(this.f3322a.hashCode() * 31, 31, this.b), 31, this.c), 31)) * 31;
        byte[] bArr = this.f;
        return iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public final String toString() {
        String string = Arrays.toString(this.e);
        String string2 = Arrays.toString(this.f);
        StringBuilder sb = new StringBuilder("LoadableWord(word=");
        sb.append(this.f3322a);
        sb.append(", keyphrase=");
        sb.append(this.b);
        sb.append(", modelPath=");
        androidx.compose.foundation.b.B(sb, this.c, ", keyphraseId=", this.d, ", userIds=");
        return androidx.appfunctions.metadata.a.p(sb, string, ", opaqueRequest=", string2, ")");
    }
}
