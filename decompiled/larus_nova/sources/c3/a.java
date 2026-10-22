package c3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22262d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f22259a, ((a) r100).f22259a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f22259a.hashCode();
    }

    public final String toString() {
        return "Version(versionString=" + this.f22259a + ')';
    }

    public a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "versionString");
        this.f22259a = r110;
        boolean r100 = true;
        Object r101 = 0;
        List r111 = StringsKt.split$default(r110, new char[]{'.'}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L11;
        Integer r103 = StringsKt.toIntOrNull((String) r112.next());
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        r102.add(Integer.valueOf(r104));
        goto L4
    L8:
        r104 = 0;
        goto L9
    L11:
        if (r102.size() <= 0) goto L13;
        boolean r113 = true;
    L14:
        if (r113 == false) goto L16;
        Object r114 = ListProtector.get(r102, 0);
    L17:
        this.f22260b = ((Number) r114).intValue();
        if (1 >= r102.size()) goto L20;
        boolean r115 = true;
    L21:
        if (r115 == false) goto L23;
        Object r116 = ListProtector.get(r102, 1);
    L24:
        this.f22261c = ((Number) r116).intValue();
        if (2 < r102.size()) goto L28;
        r100 = false;
    L28:
        if (r100 == false) goto L30;
        r101 = ListProtector.get(r102, 2);
    L30:
        this.f22262d = ((Number) r101).intValue();
        return;
    L23:
        r116 = r101;
        goto L24
    L20:
        r115 = false;
        goto L21
    L16:
        r114 = r101;
        goto L17
    L13:
        r113 = false;
        goto L14
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = this.f22260b;
        int r103 = r101.f22260b;
        if (r102 != r103) goto L10;
        int r104 = this.f22261c;
        int r105 = r101.f22261c;
        if (r104 == r105) goto L9;
        return Intrinsics.compare(r104, r105);
    L9:
        return Intrinsics.compare(this.f22262d, r101.f22262d);
    L10:
        return Intrinsics.compare(r102, r103);
    }
}
