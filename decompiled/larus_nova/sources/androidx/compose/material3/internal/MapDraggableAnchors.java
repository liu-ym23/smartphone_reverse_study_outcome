package androidx.compose.material3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0010J\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0013\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/internal/MapDraggableAnchors;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "", "", "<init>", "(Ljava/util/Map;)V", "positionOf", "value", "(Ljava/lang/Object;)F", "hasAnchorFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minAnchor", "maxAnchor", "size", "", "getSize", "()I", "equals", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {
    private final Map<T, Float> anchors;

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public int getSize() {
        return this.anchors.size();
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public float maxAnchor() {
        Float r100 = CollectionsKt.m9877maxOrNull(this.anchors.values());
        if (r100 != null) goto L7;
        return Float.NaN;
    L7:
        return r100.floatValue();
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public float minAnchor() {
        Float r100 = CollectionsKt.m9879minOrNull(this.anchors.values());
        if (r100 != null) goto L7;
        return Float.NaN;
    L7:
        return r100.floatValue();
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }

    public MapDraggableAnchors(Map<T, Float> r100) {
        this.anchors = r100;
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public T closestAnchor(float r100) {
        Iterator<T> r101 = this.anchors.entrySet().iterator();
        if (r101.hasNext() == true) goto L5;
        T r102 = null;
    L14:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 != null) goto L17;
        return null;
    L17:
        return (T) r103.getKey();
    L5:
        r102 = r101.next();
        if (r101.hasNext() == false) goto L14;
        float r104 = Math.abs(r100 - ((Number) ((Map.Entry) r102).getValue()).floatValue());
    L9:
        T r105 = r101.next();
        float r106 = Math.abs(r100 - ((Number) ((Map.Entry) r105).getValue()).floatValue());
        if (Float.compare(r104, r106) <= 0) goto L13;
        r102 = r105;
        r104 = r106;
    L13:
        if (r101.hasNext() == true) goto L9;
        goto L14
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MapDraggableAnchors) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors) r100).anchors);
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public boolean hasAnchorFor(T r100) {
        return this.anchors.containsKey(r100);
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public float positionOf(T r100) {
        Float r101 = this.anchors.get(r100);
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return r101.floatValue();
    }

    @Override // androidx.compose.material3.internal.DraggableAnchors
    public T closestAnchor(float r110, boolean r111) {
        Iterator<T> r100 = this.anchors.entrySet().iterator();
        if (r100.hasNext() == true) goto L5;
        T r101 = null;
    L27:
        Map.Entry r102 = (Map.Entry) r101;
        if (r102 != null) goto L30;
        return null;
    L30:
        return (T) r102.getKey();
    L5:
        r101 = r100.next();
        if (r100.hasNext() == false) goto L27;
        float r103 = ((Number) ((Map.Entry) r101).getValue()).floatValue();
        if (r111 == false) goto L11;
        float r104 = r103 - r110;
    L13:
        if (r104 >= 0.0f) goto L15;
        r104 = Float.POSITIVE_INFINITY;
    L15:
        T r105 = r100.next();
        float r106 = ((Number) ((Map.Entry) r105).getValue()).floatValue();
        if (r111 == false) goto L18;
        float r107 = r106 - r110;
    L20:
        if (r107 >= 0.0f) goto L23;
        r107 = Float.POSITIVE_INFINITY;
    L23:
        if (Float.compare(r104, r107) <= 0) goto L26;
        r101 = r105;
        r104 = r107;
    L26:
        if (r100.hasNext() == true) goto L15;
    L18:
        r107 = r110 - r106;
        goto L20
    L11:
        r104 = r110 - r103;
        goto L13
    }
}
