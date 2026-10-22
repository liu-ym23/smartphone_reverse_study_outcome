package androidx.compose.ui.graphics.shadow;

import androidx.appfunctions.metadata.a;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0006j\u0002`\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010 \u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010\u0005R*\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R*\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext;", "Landroidx/compose/ui/graphics/shadow/PlatformShadowContext;", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "Landroidx/compose/ui/graphics/shadow/InnerShadowRendererProvider;", AppAgent.CONSTRUCT, "()V", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/DropShadowCache;", "obtainDropShadowCache", "()Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/InnerShadowCache;", "obtainInnerShadowCache", "obtainShadowKey", "()Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", "obtainDropShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "obtainDropShadowRenderer", "obtainInnerShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "obtainInnerShadowRenderer", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "createDropShadowPainter", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "createInnerShadowPainter", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "LC7/r;", "clearCache", "dropShadowCache", "Landroidx/collection/MutableScatterMap;", "innerShadowCache", "shadowKey", "Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "ShadowKey", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class AndroidShadowContext implements PlatformShadowContext, DropShadowRendererProvider, InnerShadowRendererProvider {
    private MutableScatterMap<ShadowKey, DropShadowRenderer> dropShadowCache;
    private MutableScatterMap<ShadowKey, InnerShadowRenderer> innerShadowCache;
    private ShadowKey shadowKey;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010)R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010-R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u00101R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00102\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u00105R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00106\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "density", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;Lkotlin/jvm/internal/e;)V", "component1", "()Landroidx/compose/ui/graphics/Shape;", "component2-NH-jbRc", "()J", "component2", "component3", "()Landroidx/compose/ui/unit/LayoutDirection;", "component4", "()F", "component5", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "copy-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/Shape;", "getShape", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "J", "getSize-NH-jbRc", "setSize-uvyYCjk", "(J)V", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "F", "getDensity", "setDensity", "(F)V", "Landroidx/compose/ui/graphics/shadow/Shadow;", "getShadow", "setShadow", "(Landroidx/compose/ui/graphics/shadow/Shadow;)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ShadowKey {
        private float density;
        private LayoutDirection layoutDirection;
        private Shadow shadow;
        private Shape shape;
        private long size;

        public /* synthetic */ ShadowKey(Shape shape, long j5, LayoutDirection layoutDirection, float f, Shadow shadow, e eVar) {
            this(shape, j5, layoutDirection, f, shadow);
        }

        /* renamed from: copy-eZhPAX0$default, reason: not valid java name */
        public static /* synthetic */ ShadowKey m4836copyeZhPAX0$default(ShadowKey shadowKey, Shape shape, long j5, LayoutDirection layoutDirection, float f, Shadow shadow, int i, Object obj) {
            if ((i & 1) != 0) {
                shape = shadowKey.shape;
            }
            if ((i & 2) != 0) {
                j5 = shadowKey.size;
            }
            if ((i & 4) != 0) {
                layoutDirection = shadowKey.layoutDirection;
            }
            if ((i & 8) != 0) {
                f = shadowKey.density;
            }
            if ((i & 16) != 0) {
                shadow = shadowKey.shadow;
            }
            Shadow shadow2 = shadow;
            LayoutDirection layoutDirection2 = layoutDirection;
            return shadowKey.m4838copyeZhPAX0(shape, j5, layoutDirection2, f, shadow2);
        }

        /* renamed from: component1, reason: from getter */
        public final Shape getShape() {
            return this.shape;
        }

        /* renamed from: component2-NH-jbRc, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        /* renamed from: component3, reason: from getter */
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* renamed from: component4, reason: from getter */
        public final float getDensity() {
            return this.density;
        }

        /* renamed from: component5, reason: from getter */
        public final Shadow getShadow() {
            return this.shadow;
        }

        /* renamed from: copy-eZhPAX0, reason: not valid java name */
        public final ShadowKey m4838copyeZhPAX0(Shape shape, long size, LayoutDirection layoutDirection, float density, Shadow shadow) {
            return new ShadowKey(shape, size, layoutDirection, density, shadow, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShadowKey)) {
                return false;
            }
            ShadowKey shadowKey = (ShadowKey) other;
            return k.b(this.shape, shadowKey.shape) && Size.m3960equalsimpl0(this.size, shadowKey.size) && this.layoutDirection == shadowKey.layoutDirection && Float.compare(this.density, shadowKey.density) == 0 && k.b(this.shadow, shadowKey.shadow);
        }

        public final float getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final Shadow getShadow() {
            return this.shadow;
        }

        public final Shape getShape() {
            return this.shape;
        }

        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m4839getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            int iB = a.b(this.density, (this.layoutDirection.hashCode() + ((Size.m3965hashCodeimpl(this.size) + (this.shape.hashCode() * 31)) * 31)) * 31, 31);
            Shadow shadow = this.shadow;
            return iB + (shadow == null ? 0 : shadow.hashCode());
        }

        public final void setDensity(float f) {
            this.density = f;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        public final void setShadow(Shadow shadow) {
            this.shadow = shadow;
        }

        public final void setShape(Shape shape) {
            this.shape = shape;
        }

        /* renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m4840setSizeuvyYCjk(long j5) {
            this.size = j5;
        }

        public String toString() {
            return "ShadowKey(shape=" + this.shape + ", size=" + ((Object) Size.m3968toStringimpl(this.size)) + ", layoutDirection=" + this.layoutDirection + ", density=" + this.density + ", shadow=" + this.shadow + ')';
        }

        private ShadowKey(Shape shape, long j5, LayoutDirection layoutDirection, float f, Shadow shadow) {
            this.shape = shape;
            this.size = j5;
            this.layoutDirection = layoutDirection;
            this.density = f;
            this.shadow = shadow;
        }

        public /* synthetic */ ShadowKey(Shape shape, long j5, LayoutDirection layoutDirection, float f, Shadow shadow, int i, e eVar) {
            this((i & 1) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i & 2) != 0 ? Size.INSTANCE.m3973getZeroNHjbRc() : j5, (i & 4) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 8) != 0 ? 1.0f : f, (i & 16) != 0 ? null : shadow, null);
        }
    }

    private final MutableScatterMap<ShadowKey, DropShadowRenderer> obtainDropShadowCache() {
        MutableScatterMap<ShadowKey, DropShadowRenderer> mutableScatterMap = this.dropShadowCache;
        if (mutableScatterMap != null) {
            return mutableScatterMap;
        }
        MutableScatterMap<ShadowKey, DropShadowRenderer> mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
        this.dropShadowCache = mutableScatterMap2;
        return mutableScatterMap2;
    }

    private final MutableScatterMap<ShadowKey, InnerShadowRenderer> obtainInnerShadowCache() {
        MutableScatterMap<ShadowKey, InnerShadowRenderer> mutableScatterMap = this.innerShadowCache;
        if (mutableScatterMap != null) {
            return mutableScatterMap;
        }
        MutableScatterMap<ShadowKey, InnerShadowRenderer> mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
        this.innerShadowCache = mutableScatterMap2;
        return mutableScatterMap2;
    }

    private final ShadowKey obtainShadowKey() {
        ShadowKey shadowKey = this.shadowKey;
        if (shadowKey != null) {
            return shadowKey;
        }
        ShadowKey shadowKey2 = new ShadowKey(null, 0L, null, 0.0f, null, 31, null);
        this.shadowKey = shadowKey2;
        return shadowKey2;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public void clearCache() {
        synchronized (this) {
            try {
                MutableScatterMap<ShadowKey, DropShadowRenderer> mutableScatterMap = this.dropShadowCache;
                if (mutableScatterMap != null) {
                    mutableScatterMap.clear();
                }
                MutableScatterMap<ShadowKey, InnerShadowRenderer> mutableScatterMap2 = this.innerShadowCache;
                if (mutableScatterMap2 != null) {
                    mutableScatterMap2.clear();
                }
                this.shadowKey = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public DropShadowPainter createDropShadowPainter(Shape shape, Shadow shadow) {
        return new DropShadowPainter(shape, shadow, this);
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public InnerShadowPainter createInnerShadowPainter(Shape shape, Shadow shadow) {
        return new InnerShadowPainter(shape, shadow, this);
    }

    @Override // androidx.compose.ui.graphics.shadow.DropShadowRendererProvider
    /* renamed from: obtainDropShadowRenderer-eZhPAX0, reason: not valid java name */
    public DropShadowRenderer mo4834obtainDropShadowRenderereZhPAX0(Shape shape, long size, LayoutDirection layoutDirection, Density density, Shadow shadow) {
        DropShadowRenderer dropShadowRenderer;
        synchronized (this) {
            ShadowKey shadowKeyObtainShadowKey = obtainShadowKey();
            shadowKeyObtainShadowKey.setShape(shape);
            shadowKeyObtainShadowKey.m4840setSizeuvyYCjk(size);
            shadowKeyObtainShadowKey.setLayoutDirection(layoutDirection);
            shadowKeyObtainShadowKey.setDensity(density.getDensity());
            shadowKeyObtainShadowKey.setShadow(shadow.copyWithoutOffset$ui_graphics_release());
            dropShadowRenderer = obtainDropShadowCache().get(shadowKeyObtainShadowKey);
            if (dropShadowRenderer == null) {
                DropShadowRenderer dropShadowRenderer2 = new DropShadowRenderer(shadow, shape.mo289createOutlinePq9zytI(size, layoutDirection, density));
                obtainDropShadowCache().set(ShadowKey.m4836copyeZhPAX0$default(shadowKeyObtainShadowKey, null, 0L, null, 0.0f, null, 31, null), dropShadowRenderer2);
                dropShadowRenderer = dropShadowRenderer2;
            }
        }
        return dropShadowRenderer;
    }

    @Override // androidx.compose.ui.graphics.shadow.InnerShadowRendererProvider
    /* renamed from: obtainInnerShadowRenderer-eZhPAX0, reason: not valid java name */
    public InnerShadowRenderer mo4835obtainInnerShadowRenderereZhPAX0(Shape shape, long size, LayoutDirection layoutDirection, Density density, Shadow shadow) {
        InnerShadowRenderer innerShadowRenderer;
        synchronized (this) {
            ShadowKey shadowKeyObtainShadowKey = obtainShadowKey();
            shadowKeyObtainShadowKey.setShape(shape);
            shadowKeyObtainShadowKey.m4840setSizeuvyYCjk(size);
            shadowKeyObtainShadowKey.setLayoutDirection(layoutDirection);
            shadowKeyObtainShadowKey.setDensity(density.getDensity());
            shadowKeyObtainShadowKey.setShadow(shadow);
            innerShadowRenderer = obtainInnerShadowCache().get(shadowKeyObtainShadowKey);
            if (innerShadowRenderer == null) {
                InnerShadowRenderer innerShadowRenderer2 = new InnerShadowRenderer(shadow, shape.mo289createOutlinePq9zytI(size, layoutDirection, density));
                obtainInnerShadowCache().set(ShadowKey.m4836copyeZhPAX0$default(shadowKeyObtainShadowKey, null, 0L, null, 0.0f, null, 31, null), innerShadowRenderer2);
                innerShadowRenderer = innerShadowRenderer2;
            }
        }
        return innerShadowRenderer;
    }
}
