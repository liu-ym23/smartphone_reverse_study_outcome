package android.view.viewmodel;

import android.view.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "key", "", "contains", "(Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Z", "creationExtras", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "plus", "(Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "LC7/r;", "plusAssign", "(Landroidx/lifecycle/viewmodel/MutableCreationExtras;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreationExtrasKt {
    public static final boolean contains(CreationExtras creationExtras, CreationExtras.Key<?> key) {
        k.f(creationExtras, "<this>");
        k.f(key, "key");
        return creationExtras.getExtras$lifecycle_viewmodel_release().containsKey(key);
    }

    public static final MutableCreationExtras plus(CreationExtras creationExtras, CreationExtras creationExtras2) {
        k.f(creationExtras, "<this>");
        k.f(creationExtras2, "creationExtras");
        return new MutableCreationExtras(a.T(creationExtras.getExtras$lifecycle_viewmodel_release(), creationExtras2.getExtras$lifecycle_viewmodel_release()));
    }

    public static final void plusAssign(MutableCreationExtras mutableCreationExtras, CreationExtras creationExtras) {
        k.f(mutableCreationExtras, "<this>");
        k.f(creationExtras, "creationExtras");
        mutableCreationExtras.getExtras$lifecycle_viewmodel_release().putAll(creationExtras.getExtras$lifecycle_viewmodel_release());
    }
}
