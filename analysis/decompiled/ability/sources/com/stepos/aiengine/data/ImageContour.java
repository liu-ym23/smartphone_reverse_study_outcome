package com.stepos.aiengine.data;

import D7.v;
import android.graphics.Point;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \n2\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\nB\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/data/ImageContour;", "Ljava/util/ArrayList;", "Landroid/graphics/Point;", "Lkotlin/collections/ArrayList;", "points", "", AppAgent.CONSTRUCT, "(Ljava/util/Collection;)V", "getPoints", "", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageContour extends ArrayList<Point> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/data/ImageContour$Companion;", "", "", "Landroid/graphics/Point;", "points", "Lcom/stepos/aiengine/data/ImageContour;", TypedValues.TransitionType.S_FROM, "(Ljava/util/Collection;)Lcom/stepos/aiengine/data/ImageContour;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final ImageContour from(Collection<? extends Point> points) {
            k.f(points, "points");
            return new ImageContour(points);
        }
    }

    public ImageContour() {
        this(null, 1, null);
    }

    public static final ImageContour from(Collection<? extends Point> collection) {
        return INSTANCE.from(collection);
    }

    public /* bridge */ boolean contains(Point point) {
        return super.contains((Object) point);
    }

    public final List<Point> getPoints() {
        return v.f1(this);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(Point point) {
        return super.indexOf((Object) point);
    }

    public /* bridge */ int lastIndexOf(Point point) {
        return super.lastIndexOf((Object) point);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ Point remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ Point removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageContour(Collection<? extends Point> points) {
        super(points);
        k.f(points, "points");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Point) {
            return contains((Point) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Point) {
            return indexOf((Point) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Point) {
            return lastIndexOf((Point) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(Point point) {
        return super.remove((Object) point);
    }

    public ImageContour(Collection collection, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Point) {
            return remove((Point) obj);
        }
        return false;
    }
}
