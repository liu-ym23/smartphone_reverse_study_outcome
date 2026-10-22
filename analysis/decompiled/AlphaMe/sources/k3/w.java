package k3;

import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f13385a;

    /* renamed from: b, reason: collision with root package name */
    public int f13386b;

    /* renamed from: c, reason: collision with root package name */
    public int f13387c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13388d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13389e;

    /* renamed from: f, reason: collision with root package name */
    public w f13390f;

    /* renamed from: g, reason: collision with root package name */
    public w f13391g;

    public w(byte[] data, int i4, int i5, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f13385a = data;
        this.f13386b = i4;
        this.f13387c = i5;
        this.f13388d = z4;
        this.f13389e = z5;
    }

    public final w a() {
        w wVar = this.f13390f;
        if (wVar == this) {
            wVar = null;
        }
        w wVar2 = this.f13391g;
        Intrinsics.checkNotNull(wVar2);
        wVar2.f13390f = this.f13390f;
        w wVar3 = this.f13390f;
        Intrinsics.checkNotNull(wVar3);
        wVar3.f13391g = this.f13391g;
        this.f13390f = null;
        this.f13391g = null;
        return wVar;
    }

    public final void b(w segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f13391g = this;
        segment.f13390f = this.f13390f;
        w wVar = this.f13390f;
        Intrinsics.checkNotNull(wVar);
        wVar.f13391g = segment;
        this.f13390f = segment;
    }

    public final w c() {
        this.f13388d = true;
        return new w(this.f13385a, this.f13386b, this.f13387c, true, false);
    }

    public final void d(w sink, int i4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.f13389e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i5 = sink.f13387c;
        int i6 = i5 + i4;
        byte[] bArr = sink.f13385a;
        if (i6 > 8192) {
            if (sink.f13388d) {
                throw new IllegalArgumentException();
            }
            int i7 = sink.f13386b;
            if (i6 - i7 > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i7, i5, 2, (Object) null);
            sink.f13387c -= sink.f13386b;
            sink.f13386b = 0;
        }
        int i8 = sink.f13387c;
        int i9 = this.f13386b;
        ArraysKt.copyInto(this.f13385a, bArr, i8, i9, i9 + i4);
        sink.f13387c += i4;
        this.f13386b += i4;
    }

    public w() {
        this.f13385a = new byte[8192];
        this.f13389e = true;
        this.f13388d = false;
    }
}
