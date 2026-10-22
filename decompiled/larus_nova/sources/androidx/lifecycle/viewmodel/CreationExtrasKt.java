package androidx.lifecycle.viewmodel;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002¨\u0006\n"}, d2 = {"contains", "", "Landroidx/lifecycle/viewmodel/CreationExtras;", "key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "plus", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "creationExtras", "plusAssign", "", "lifecycle-viewmodel"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CreationExtrasKt {
    public static final boolean contains(CreationExtras r100, CreationExtras.Key<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getExtras$lifecycle_viewmodel().containsKey(r101);
    }

    public static final MutableCreationExtras plus(CreationExtras r100, CreationExtras r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "creationExtras");
        return new MutableCreationExtras(MapsKt.plus(r100.getExtras$lifecycle_viewmodel(), r101.getExtras$lifecycle_viewmodel()));
    }

    public static final void plusAssign(MutableCreationExtras r100, CreationExtras r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "creationExtras");
        r100.getExtras$lifecycle_viewmodel().putAll(r101.getExtras$lifecycle_viewmodel());
    }
}
