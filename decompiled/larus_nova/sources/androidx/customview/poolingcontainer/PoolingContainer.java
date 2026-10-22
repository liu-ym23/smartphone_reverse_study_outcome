package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = 2131375666;
    private static final int PoolingContainerListenerHolderTag = 2131382748;

    public static final void callPoolingContainerOnRelease(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<View> r101 = ViewKt.getAllViews(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r101.next()).onRelease();
        goto L4
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<View> r101 = ViewGroupKt.getChildren(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r101.next()).onRelease();
        goto L4
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View r100) {
        int r101 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder r102 = (PoolingContainerListenerHolder) r100.getTag(r101);
        if (r102 != null) goto L6;
        PoolingContainerListenerHolder r103 = new PoolingContainerListenerHolder();
        r100.setTag(r101, r103);
        return r103;
    L6:
        return r102;
    }

    public static final boolean isPoolingContainer(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(IsPoolingContainerTag);
        if ((r101 instanceof Boolean) == false) goto L5;
        Boolean r102 = (Boolean) r101;
    L6:
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.booleanValue();
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean isWithinPoolingContainer(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<ViewParent> r101 = ViewKt.getAncestors(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = (ViewParent) r101.next();
        if ((r102 instanceof View) == false) goto L4;
        if (isPoolingContainer((View) r102) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static final void addPoolingContainerListener(View r100, PoolingContainerListener r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "listener");
        getPoolingContainerListenerHolder(r100).addListener(r101);
    }

    public static final void removePoolingContainerListener(View r100, PoolingContainerListener r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "listener");
        getPoolingContainerListenerHolder(r100).removeListener(r101);
    }

    public static final void setPoolingContainer(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTag(IsPoolingContainerTag, Boolean.valueOf(r101));
    }
}
