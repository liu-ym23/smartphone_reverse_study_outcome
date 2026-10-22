package androidx.compose.foundation;

import S7.k;
import S7.o;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/SurfaceScope;", "", "Landroid/view/Surface;", "Lkotlin/Function3;", "", "LC7/r;", "onChanged", "(Landroid/view/Surface;LS7/o;)V", "Lkotlin/Function1;", "onDestroyed", "(Landroid/view/Surface;LS7/k;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SurfaceScope {
    void onChanged(Surface surface, o oVar);

    void onDestroyed(Surface surface, k kVar);
}
