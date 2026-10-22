package bs8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f20315b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f20314a, r101.f20314a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20315b, r101.f20315b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f20314a.hashCode() * 31) + this.f20315b.hashCode();
    }

    public final String toString() {
        return "TaskSkillMessageSnapshot(queryPrefix=" + this.f20314a + ", messageExt=" + this.f20315b + ')';
    }

    public /* synthetic */ n(int r100) {
        this("", MapsKt.emptyMap());
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (StringsKt.trim(r100).toString().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        return this.f20314a + r100;
    L5:
        r101 = false;
        goto L6
    }

    public n(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "queryPrefix");
        Intrinsics.checkNotNullParameter(r101, "messageExt");
        this.f20314a = r100;
        this.f20315b = r101;
    }
}
