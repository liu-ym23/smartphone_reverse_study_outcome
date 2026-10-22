package blc;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Effect f19531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f19532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.a f19534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public bytekn.foundation.concurrent.executor.a f19535e;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f19531a, r101.f19531a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f19532b, r101.f19532b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f19533c, r101.f19533c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19534d, r101.f19534d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f19535e, r101.f19535e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Effect r100 = this.f19531a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f19532b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f19533c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.ss.ugc.effectplatform.a r110 = this.f19534d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        bytekn.foundation.concurrent.executor.a r113 = this.f19535e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EffectFetcherArguments(effect=" + this.f19531a + ", downloadUrl=" + this.f19532b + ", effectDir=" + this.f19533c + ", ab=" + this.f19534d + ", executor=" + this.f19535e + ")";
    }

    public b(Effect r100, List r101, String r102) {
        this.f19531a = r100;
        this.f19532b = r101;
        this.f19533c = r102;
        this.f19534d = null;
        this.f19535e = null;
    }
}
