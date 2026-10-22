package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nH\u0002J\u0018\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J7\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020'H\u0016R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext;", "Landroidx/compose/ui/graphics/shadow/PlatformShadowContext;", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "Landroidx/compose/ui/graphics/shadow/InnerShadowRendererProvider;", "<init>", "()V", "dropShadowCache", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/DropShadowCache;", "innerShadowCache", "Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/InnerShadowCache;", "shadowKey", "obtainDropShadowCache", "obtainInnerShadowCache", "obtainShadowKey", "obtainDropShadowRenderer", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/shadow/Shadow;", "obtainDropShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "obtainInnerShadowRenderer", "obtainInnerShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "createDropShadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "createInnerShadowPainter", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "clearCache", "", "ShadowKey", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidShadowContext implements PlatformShadowContext, DropShadowRendererProvider, InnerShadowRendererProvider {
    private MutableScatterMap<ShadowKey, DropShadowRenderer> dropShadowCache;
    private MutableScatterMap<ShadowKey, InnerShadowRenderer> innerShadowCache;
    private ShadowKey shadowKey;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b%\u0010\u0013J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003JD\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00063"}, d2 = {"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/shadow/Shadow;", "<init>", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getDensity", "()F", "setDensity", "(F)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "setShadow", "(Landroidx/compose/ui/graphics/shadow/Shadow;)V", "component1", "component2", "component2-NH-jbRc", "component3", "component4", "component5", "copy", "copy-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ShadowKey {
        private float density;
        private LayoutDirection layoutDirection;
        private Shadow shadow;
        private Shape shape;
        private long size;

        public /* synthetic */ ShadowKey(Shape r100, long r101, LayoutDirection r102, float r103, Shadow r104, DefaultConstructorMarker r105) {
            this(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: copy-eZhPAX0$default, reason: not valid java name */
        public static /* synthetic */ ShadowKey m5539copyeZhPAX0$default(ShadowKey r100, Shape r101, long r102, LayoutDirection r103, float r104, Shadow r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.shape;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.size;
        L8:
            long r105 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.layoutDirection;
        L11:
            LayoutDirection r113 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.density;
        L14:
            float r106 = r104;
            if ((r111 & 16) == 0) goto L17;
            r110 = r100.shadow;
        L17:
            Shape r107 = r101;
            return r100.m5541copyeZhPAX0(r107, r105, r113, r106, r110);
        }

        public final Shape component1() {
            return this.shape;
        }

        /* JADX INFO: renamed from: component2-NH-jbRc, reason: not valid java name */
        public final long m5540component2NHjbRc() {
            return this.size;
        }

        public final LayoutDirection component3() {
            return this.layoutDirection;
        }

        public final float component4() {
            return this.density;
        }

        public final Shadow component5() {
            return this.shadow;
        }

        /* JADX INFO: renamed from: copy-eZhPAX0, reason: not valid java name */
        public final ShadowKey m5541copyeZhPAX0(Shape r110, long r111, LayoutDirection r112, float r113, Shadow r114) {
            return new ShadowKey(r110, r111, r112, r113, r114, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ShadowKey) == true) goto L8;
            return false;
        L8:
            ShadowKey r101 = (ShadowKey) r100;
            if (Intrinsics.areEqual(this.shape, r101.shape) == true) goto L12;
            return false;
        L12:
            if (Size.m4647equalsimpl0(this.size, r101.size) == true) goto L15;
            return false;
        L15:
            if (this.layoutDirection == r101.layoutDirection) goto L18;
            return false;
        L18:
            if (Float.compare(this.density, r101.density) == 0) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.shadow, r101.shadow) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((this.shape.hashCode() * 31) + Size.m4652hashCodeimpl(this.size)) * 31) + this.layoutDirection.hashCode()) * 31) + Float.floatToIntBits(this.density)) * 31;
            Shadow r101 = this.shadow;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "ShadowKey(shape=" + this.shape + ", size=" + Size.m4655toStringimpl(this.size) + ", layoutDirection=" + this.layoutDirection + ", density=" + this.density + ", shadow=" + this.shadow + ')';
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

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m5542getSizeNHjbRc() {
            return this.size;
        }

        public final void setDensity(float r100) {
            this.density = r100;
        }

        public final void setLayoutDirection(LayoutDirection r100) {
            this.layoutDirection = r100;
        }

        public final void setShadow(Shadow r100) {
            this.shadow = r100;
        }

        public final void setShape(Shape r100) {
            this.shape = r100;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m5543setSizeuvyYCjk(long r100) {
            this.size = r100;
        }

        private ShadowKey(Shape r100, long r101, LayoutDirection r102, float r103, Shadow r104) {
            this.shape = r100;
            this.size = r101;
            this.layoutDirection = r102;
            this.density = r103;
            this.shadow = r104;
        }

        public /* synthetic */ ShadowKey(Shape r100, long r101, LayoutDirection r110, float r111, Shadow r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 1) == 0) goto L5;
            Shape r102 = RectangleShapeKt.getRectangleShape();
        L7:
            if ((r113 & 2) == 0) goto L9;
            long r103 = Size.Companion.m4660getZeroNHjbRc();
        L11:
            if ((r113 & 4) == 0) goto L13;
            LayoutDirection r104 = LayoutDirection.Ltr;
        L15:
            if ((r113 & 8) == 0) goto L17;
            float r105 = 1.0f;
        L19:
            if ((r113 & 16) == 0) goto L21;
            Shadow r106 = null;
        L22:
            Shape r107 = r102;
            long r115 = r103;
            LayoutDirection r116 = r104;
            float r117 = r105;
            Shadow r118 = r106;
            this(r107, r115, r116, r117, r118, null);
            return;
        L21:
            r106 = r112;
            goto L22
        L17:
            r105 = r111;
            goto L19
        L13:
            r104 = r110;
            goto L15
        L9:
            r103 = r101;
            goto L11
        L5:
            r102 = r100;
            goto L7
        }
    }

    public AndroidShadowContext() {
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public void clearCache() {
        monitor-enter(this);
        MutableScatterMap<ShadowKey, DropShadowRenderer> r100 = this.dropShadowCache;     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        r100.clear();     // Catch: Throwable -> L12
    L6:
        MutableScatterMap<ShadowKey, InnerShadowRenderer> r101 = this.innerShadowCache;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        r101.clear();     // Catch: Throwable -> L12
    L9:
        this.shadowKey = null;     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final MutableScatterMap<ShadowKey, DropShadowRenderer> obtainDropShadowCache() {
        MutableScatterMap<ShadowKey, DropShadowRenderer> r100 = this.dropShadowCache;
        if (r100 != null) goto L6;
        int r101 = 0;
        MutableScatterMap<ShadowKey, DropShadowRenderer> r102 = new MutableScatterMap(r101, 1, null);
        this.dropShadowCache = r102;
        return r102;
    L6:
        return r100;
    }

    private final MutableScatterMap<ShadowKey, InnerShadowRenderer> obtainInnerShadowCache() {
        MutableScatterMap<ShadowKey, InnerShadowRenderer> r100 = this.innerShadowCache;
        if (r100 != null) goto L6;
        int r101 = 0;
        MutableScatterMap<ShadowKey, InnerShadowRenderer> r102 = new MutableScatterMap(r101, 1, null);
        this.innerShadowCache = r102;
        return r102;
    L6:
        return r100;
    }

    private final ShadowKey obtainShadowKey() {
        ShadowKey r100 = this.shadowKey;
        if (r100 != null) goto L6;
        ShadowKey r101 = new ShadowKey(null, 0, null, 0.0f, null, 31, null);
        this.shadowKey = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public DropShadowPainter createDropShadowPainter(Shape r100, Shadow r101) {
        return new DropShadowPainter(r100, r101, this);
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowContext
    public InnerShadowPainter createInnerShadowPainter(Shape r100, Shadow r101) {
        return new InnerShadowPainter(r100, r101, this);
    }

    @Override // androidx.compose.ui.graphics.shadow.DropShadowRendererProvider
    /* JADX INFO: renamed from: obtainDropShadowRenderer-eZhPAX0, reason: not valid java name */
    public DropShadowRenderer mo5537obtainDropShadowRenderereZhPAX0(Shape r110, long r111, LayoutDirection r112, Density r113, Shadow r114) {
        monitor-enter(this);
        ShadowKey r100 = obtainShadowKey();     // Catch: Throwable -> L9
        r100.setShape(r110);     // Catch: Throwable -> L9
        r100.m5543setSizeuvyYCjk(r111);     // Catch: Throwable -> L9
        r100.setLayoutDirection(r112);     // Catch: Throwable -> L9
        r100.setDensity(r113.getDensity());     // Catch: Throwable -> L9
        r100.setShadow(r114.copyWithoutOffset$ui_graphics_release());     // Catch: Throwable -> L9
        DropShadowRenderer r101 = obtainDropShadowCache().get(r100);     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        DropShadowRenderer r115 = new DropShadowRenderer(r114, r110.mo288createOutlinePq9zytI(r111, r112, r113));     // Catch: Throwable -> L9
        obtainDropShadowCache().set(ShadowKey.m5539copyeZhPAX0$default(r100, null, 0, null, 0.0f, null, 31, null), r115);     // Catch: Throwable -> L9
        r101 = r115;
    L7:
        monitor-exit(this);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.ui.graphics.shadow.InnerShadowRendererProvider
    /* JADX INFO: renamed from: obtainInnerShadowRenderer-eZhPAX0, reason: not valid java name */
    public InnerShadowRenderer mo5538obtainInnerShadowRenderereZhPAX0(Shape r110, long r111, LayoutDirection r112, Density r113, Shadow r114) {
        monitor-enter(this);
        ShadowKey r100 = obtainShadowKey();     // Catch: Throwable -> L9
        r100.setShape(r110);     // Catch: Throwable -> L9
        r100.m5543setSizeuvyYCjk(r111);     // Catch: Throwable -> L9
        r100.setLayoutDirection(r112);     // Catch: Throwable -> L9
        r100.setDensity(r113.getDensity());     // Catch: Throwable -> L9
        r100.setShadow(r114);     // Catch: Throwable -> L9
        InnerShadowRenderer r101 = obtainInnerShadowCache().get(r100);     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        InnerShadowRenderer r115 = new InnerShadowRenderer(r114, r110.mo288createOutlinePq9zytI(r111, r112, r113));     // Catch: Throwable -> L9
        obtainInnerShadowCache().set(ShadowKey.m5539copyeZhPAX0$default(r100, null, 0, null, 0.0f, null, 31, null), r115);     // Catch: Throwable -> L9
        r101 = r115;
    L7:
        monitor-exit(this);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }
}
