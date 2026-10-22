package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Visibility.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility normalize() {
        return this;
    }

    protected Visibility(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
        this.isPublicAPI = r3;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public Integer compareTo(Visibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, r2);
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
