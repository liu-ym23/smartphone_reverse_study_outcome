package b58;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import z48.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<b, Integer> f17779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, String> f17780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<b, Integer> f17781c;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f17779a, r101.f17779a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17780b, r101.f17780b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17781c, r101.f17781c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Function1<b, Integer> r100 = this.f17779a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<b, String> r104 = this.f17780b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<b, Integer> r107 = this.f17781c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerSpeechGroupUIConfig(groupIconImageResource=" + this.f17779a + ", groupText=" + this.f17780b + ", groupTextColor=" + this.f17781c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super b, Integer> r100, Function1<? super b, String> r101, Function1<? super b, Integer> r102) {
        this.f17779a = r100;
        this.f17780b = r101;
        this.f17781c = r102;
    }
}
