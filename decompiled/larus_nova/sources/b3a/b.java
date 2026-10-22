package b3a;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f17397c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f17395a, r101.f17395a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17396b, r101.f17396b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17397c, r101.f17397c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f17395a.hashCode() * 31) + this.f17396b.hashCode()) * 31) + this.f17397c.hashCode();
    }

    public final String toString() {
        return "SpeechAecModelMeta(collectionName=" + this.f17395a + ", version=" + this.f17396b + ", models=" + this.f17397c + ')';
    }

    public b(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        ArrayList r103 = null;
        if ((r101 & 2) != 0) goto L10;
        r102 = null;
    L10:
        if ((r101 & 4) == 0) goto L12;
        r103 = new ArrayList();
    L12:
        Intrinsics.checkNotNullParameter(r100, "collectionName");
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r103, "models");
        this.f17395a = r100;
        this.f17396b = r102;
        this.f17397c = r103;
    }
}
