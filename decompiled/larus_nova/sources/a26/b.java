package a26;

import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceLoaderType f1417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1418b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f1417a == r101.f1417a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1418b, r101.f1418b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f1417a.hashCode() * 31) + this.f1418b.hashCode();
    }

    public final String toString() {
        return "ResourceLoaderEnvData(type=" + this.f1417a + ", name=" + this.f1418b + ')';
    }

    public final ResourceLoaderType getType() {
        return this.f1417a;
    }

    public b(ResourceLoaderType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f1417a = r100;
        this.f1418b = r101;
    }
}
