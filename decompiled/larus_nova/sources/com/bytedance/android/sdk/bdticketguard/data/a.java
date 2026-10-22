package com.bytedance.android.sdk.bdticketguard.data;

import com.bytedance.android.sdk.bdticketguard.AttestationResult;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f163589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f163590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f163591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f163592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f163593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f163594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f163595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function3<Result<AttestationResult>, Integer, Boolean, Unit> f163596i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L41:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L40;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f163588a, r101.f163588a) == false) goto L40;
        if (this.f163589b != r101.f163589b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L40;
        if (this.f163590c != r101.f163590c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L40;
        if (this.f163591d != r101.f163591d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L40;
        if (this.f163592e != r101.f163592e) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L40;
        if (this.f163593f != r101.f163593f) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L40;
        if (Intrinsics.areEqual(this.f163594g, r101.f163594g) == false) goto L40;
        if (Intrinsics.areEqual(this.f163595h, r101.f163595h) == false) goto L40;
        if (Intrinsics.areEqual(this.f163596i, r101.f163596i) == false) goto L40;
    L31:
        r106 = false;
        goto L32
    L26:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        String r100 = this.f163588a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f163589b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f163590c;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        long r109 = this.f163591d;
        int r110 = (((r107 + r105) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f163592e;
        int r112 = (((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f163593f) * 31;
        String r113 = this.f163594g;
        if (r113 == null) goto L16;
        int r114 = r113.hashCode();
    L17:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f163595h;
        if (r116 == null) goto L20;
        int r117 = r116.hashCode();
    L21:
        int r118 = (r115 + r117) * 31;
        Function3<Result<AttestationResult>, Integer, Boolean, Unit> r119 = this.f163596i;
        if (r119 == null) goto L25;
        r101 = r119.hashCode();
    L25:
        return r118 + r101;
    L20:
        r117 = 0;
        goto L21
    L16:
        r114 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KeyAttestationParams(scene=" + this.f163588a + ", shouldRestart=" + this.f163589b + ", rescheduleIfNotStarted=" + this.f163590c + ", initialDelayMs=" + this.f163591d + ", retryIntervalMs=" + this.f163592e + ", maxAttempts=" + this.f163593f + ", invalidatePath=" + this.f163594g + ", invalidateLogId=" + this.f163595h + ", callback=" + this.f163596i + ")";
    }

    public /* synthetic */ a(String r110, boolean r111, boolean r112, long r113, long r114, int r210, Function3 r211) {
        this(r110, r111, r112, r113, r114, r210, null, null, r211);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, boolean r101, boolean r102, long r103, long r104, int r105, String r106, String r110, Function3<? super Result<AttestationResult>, ? super Integer, ? super Boolean, Unit> r111) {
        this.f163588a = r100;
        this.f163589b = r101;
        this.f163590c = r102;
        this.f163591d = r103;
        this.f163592e = r104;
        this.f163593f = r105;
        this.f163594g = r106;
        this.f163595h = r110;
        this.f163596i = r111;
    }
}
