package a58;

import com.larus.feishu.office.im.impl.base.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import z48.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<b, String> f1855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, Integer> f1856b;

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f1855a, r101.f1855a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1856b, r101.f1856b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Function1<b, String> r100 = this.f1855a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<b, Integer> r104 = this.f1856b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerPressHintUIConfig(pressHintText=" + this.f1855a + ", pressHintTextColor=" + this.f1856b + ')';
    }

    public a(r0 r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f1855a = r100;
        this.f1856b = null;
    }
}
