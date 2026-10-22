package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.byted.cast.common.TeaEventTrack;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", SVGRenderEngine.RECT, "iterator", "", "minus", "not", SRStrategy.KEY_ORIGIN_RESOLUTION, "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", SVGRenderEngine.RECT, "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Rect>, KMappedMarker {
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (this.hasMore == false) goto L7;
            Rect r100 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return r100;
        L7:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        public AnonymousClass1(Region r100) {
            RegionIterator r101 = new RegionIterator(r100);
            this.iterator = r101;
            Rect r102 = new Rect();
            this.rect = r102;
            this.hasMore = r101.next(r102);
        }
    }

    public static final Iterator<Rect> iterator(Region r100) {
        return new AnonymousClass1(r100);
    }

    public static final Region not(Region r100) {
        Region r101 = new Region(r100.getBounds());
        r101.op(r100, Region.Op.DIFFERENCE);
        return r101;
    }

    public static final Region unaryMinus(Region r100) {
        Region r101 = new Region(r100.getBounds());
        r101.op(r100, Region.Op.DIFFERENCE);
        return r101;
    }

    public static final Region and(Region r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.INTERSECT);
        return r102;
    }

    public static final boolean contains(Region r100, Point r101) {
        return r100.contains(r101.x, r101.y);
    }

    public static final void forEach(Region r100, Function1<? super Rect, Unit> r101) {
        RegionIterator r102 = new RegionIterator(r100);
    L3:
        Rect r103 = new Rect();
        if (r102.next(r103) == false) goto L5;
        r101.invoke(r103);
        goto L3
    }

    public static final Region minus(Region r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.DIFFERENCE);
        return r102;
    }

    public static final Region or(Region r100, Region r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.UNION);
        return r102;
    }

    public static final Region plus(Region r100, Region r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.UNION);
        return r102;
    }

    public static final Region xor(Region r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.XOR);
        return r102;
    }

    public static final Region and(Region r100, Region r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.INTERSECT);
        return r102;
    }

    public static final Region minus(Region r100, Region r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.DIFFERENCE);
        return r102;
    }

    public static final Region or(Region r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.union(r101);
        return r102;
    }

    public static final Region plus(Region r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.union(r101);
        return r102;
    }

    public static final Region xor(Region r100, Region r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.XOR);
        return r102;
    }
}
