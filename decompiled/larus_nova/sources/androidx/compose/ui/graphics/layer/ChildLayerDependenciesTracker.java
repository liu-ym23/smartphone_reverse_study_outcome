package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005J\u001d\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "<init>", "()V", "dependency", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "oldDependency", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "oldDependenciesSet", "trackingInProgress", "", "withTracking", "", "onDependencyRemoved", "Lkotlin/Function1;", "block", "Lkotlin/Function0;", "onDependencyAdded", "graphicsLayer", "removeDependencies", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChildLayerDependenciesTracker {
    private MutableScatterSet<GraphicsLayer> dependenciesSet;
    private GraphicsLayer dependency;
    private MutableScatterSet<GraphicsLayer> oldDependenciesSet;
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    public ChildLayerDependenciesTracker() {
    }

    public static final /* synthetic */ MutableScatterSet access$getDependenciesSet$p(ChildLayerDependenciesTracker r100) {
        return r100.dependenciesSet;
    }

    public static final /* synthetic */ GraphicsLayer access$getDependency$p(ChildLayerDependenciesTracker r100) {
        return r100.dependency;
    }

    public static final /* synthetic */ MutableScatterSet access$getOldDependenciesSet$p(ChildLayerDependenciesTracker r100) {
        return r100.oldDependenciesSet;
    }

    public static final /* synthetic */ GraphicsLayer access$getOldDependency$p(ChildLayerDependenciesTracker r100) {
        return r100.oldDependency;
    }

    public final boolean onDependencyAdded(GraphicsLayer r100) {
        if (this.trackingInProgress == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
    L5:
        MutableScatterSet<GraphicsLayer> r101 = this.dependenciesSet;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r101);
        r101.add(r100);
    L12:
        MutableScatterSet<GraphicsLayer> r102 = this.oldDependenciesSet;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNull(r102);
        return !r102.remove(r100);
    L17:
        if (this.oldDependency == r100) goto L19;
        return true;
    L19:
        this.oldDependency = null;
        return false;
    L9:
        if (this.dependency == null) goto L11;
        MutableScatterSet<GraphicsLayer> r103 = ScatterSetKt.mutableScatterSetOf();
        GraphicsLayer r104 = this.dependency;
        Intrinsics.checkNotNull(r104);
        r103.add(r104);
        r103.add(r100);
        this.dependenciesSet = r103;
        this.dependency = null;
        goto L12
    L11:
        this.dependency = r100;
        goto L12
    }

    public final void removeDependencies(Function1<? super GraphicsLayer, Unit> r110) {
        GraphicsLayer r100 = access$getDependency$p(this);
        if (r100 == null) goto L6;
        r110.invoke(r100);
        access$setDependency$p(this, null);
    L6:
        MutableScatterSet r101 = access$getDependenciesSet$p(this);
        if (r101 == null) goto L32;
        Object[] r102 = r101.elements;
        long[] r103 = r101.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r105 = 0;
    L11:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r111 = 8 - ((~(r105 - r104)) >>> 31);
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L22;
        if ((255 & r106) >= 128) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L21;
        r110.invoke(r102[(r105 << 3) + r112]);
    L21:
        r106 = r106 >> 8;
        r112 = r112 + 1;
        goto L14
    L18:
        r113 = false;
        goto L19
    L22:
        if (r111 != 8) goto L25;
    L23:
        if (r105 == r104) goto L25;
        r105 = r105 + 1;
    L25:
        r101.clear();
        return;
    }

    public static final /* synthetic */ void access$setDependency$p(ChildLayerDependenciesTracker r100, GraphicsLayer r101) {
        r100.dependency = r101;
    }

    public static final /* synthetic */ void access$setOldDependenciesSet$p(ChildLayerDependenciesTracker r100, MutableScatterSet r101) {
        r100.oldDependenciesSet = r101;
    }

    public static final /* synthetic */ void access$setOldDependency$p(ChildLayerDependenciesTracker r100, GraphicsLayer r101) {
        r100.oldDependency = r101;
    }

    public static final /* synthetic */ void access$setTrackingInProgress$p(ChildLayerDependenciesTracker r100, boolean r101) {
        r100.trackingInProgress = r101;
    }

    public final void withTracking(Function1<? super GraphicsLayer, Unit> r210, Function0<Unit> r211) {
        access$setOldDependency$p(this, access$getDependency$p(this));
        MutableScatterSet r100 = access$getDependenciesSet$p(this);
        if (r100 != null) goto L5;
    L10:
        access$setTrackingInProgress$p(this, true);
        r211.invoke();
        access$setTrackingInProgress$p(this, false);
        GraphicsLayer r101 = access$getOldDependency$p(this);
        if (r101 == null) goto L13;
        r210.invoke(r101);
    L13:
        MutableScatterSet r102 = access$getOldDependenciesSet$p(this);
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.isNotEmpty() == false) goto L42;
        Object[] r103 = r102.elements;
        long[] r104 = r102.metadata;
        int r105 = r104.length - 2;
        if (r105 < 0) goto L34;
        int r106 = 0;
    L20:
        long r107 = r104[r106];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L32;
        int r110 = 8 - ((~(r106 - r105)) >>> 31);
        int r111 = 0;
    L23:
        if (r111 >= r110) goto L31;
        if ((255 & r107) >= 128) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L30;
        r210.invoke(r103[(r106 << 3) + r111]);
    L30:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L23
    L27:
        r112 = false;
        goto L28
    L31:
        if (r110 != 8) goto L34;
    L32:
        if (r106 == r105) goto L34;
        r106 = r106 + 1;
    L34:
        r102.clear();
        return;
    L42:
        return;
    L5:
        if (r100.isNotEmpty() == false) goto L10;
        MutableScatterSet r108 = access$getOldDependenciesSet$p(this);
        if (r108 != null) goto L9;
        r108 = ScatterSetKt.mutableScatterSetOf();
        access$setOldDependenciesSet$p(this, r108);
    L9:
        r108.addAll(r100);
        r100.clear();
        goto L10
    }
}
