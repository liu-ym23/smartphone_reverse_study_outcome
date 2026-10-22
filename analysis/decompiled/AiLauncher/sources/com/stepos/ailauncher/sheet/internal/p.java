package com.stepos.ailauncher.sheet.internal;

import Z8.C1173v;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.U;
import com.stepos.ailauncher.sheet.a0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J»\u0002\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b)\u0010*JW\u00103\u001a\u0002022\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0$H\u0002¢\u0006\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/p;", "", "<init>", "()V", "Landroid/view/View;", "clipView", "panel", "", "startWidth", "endWidth", "startHeight", "endHeight", "centerX", "centerY", "startOffsetY", "endOffsetY", "startRadius", "endRadius", "widthStiffness", "widthDampingRatio", "heightStiffness", "heightDampingRatio", "radiusStiffness", "radiusDampingRatio", "positionStiffness", "positionDampingRatio", "positionStartVelocity", "heightStartVelocity", "", "restoreOnEnd", "bottomWidthPinchPx", "widthMinVisibleChange", "scaleContentView", "Lkotlin/Function0;", "LY8/t;", "onAfterPanelTransform", "Lkotlin/Function1;", "onProgress", "onCollapsedToBar", "onEnd", "Lcom/stepos/ailauncher/sheet/internal/p$a;", "m", "(Landroid/view/View;Landroid/view/View;FFFFFFFFFFFFFFFFFFFFZFFLandroid/view/View;Lp9/a;Lp9/l;Lp9/a;Lp9/a;)Lcom/stepos/ailauncher/sheet/internal/p$a;", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "stiffness", "dampingRatio", "startVelocity", "minVisibleChange", "onUpdate", "Landroidx/dynamicanimation/animation/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(FFFFFFLp9/l;)Landroidx/dynamicanimation/animation/i;", "Landroid/graphics/Paint;", "SCALE_LAYER_PAINT", "Landroid/graphics/Paint;", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    public static final p INSTANCE = new p();
    private static final Paint SCALE_LAYER_PAINT = new Paint(3);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/p$a;", "", "", "Landroidx/dynamicanimation/animation/i;", "animations", "Lkotlin/Function0;", "LY8/t;", "restore", "<init>", "(Ljava/util/List;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "()V", "Ljava/util/List;", "Lp9/a;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final List<androidx.dynamicanimation.animation.i> animations;
        private final InterfaceC5063a<Y8.t> restore;

        public a(List<androidx.dynamicanimation.animation.i> animations, InterfaceC5063a<Y8.t> restore) {
            kotlin.jvm.internal.p.i(animations, "animations");
            kotlin.jvm.internal.p.i(restore, "restore");
            this.animations = animations;
            this.restore = restore;
        }

        public final void a() {
            Iterator<T> it = this.animations.iterator();
            while (it.hasNext()) {
                ((androidx.dynamicanimation.animation.i) it.next()).d();
            }
            this.restore.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sheet/internal/p$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ Ref$FloatRef $bottomOffset;
        final /* synthetic */ float $centerX;
        final /* synthetic */ float $centerY;
        final /* synthetic */ Ref$FloatRef $clipHeight;
        final /* synthetic */ Ref$FloatRef $clipWidth;
        final /* synthetic */ float $endHeight;
        final /* synthetic */ float $endOffsetY;
        final /* synthetic */ float $endWidth;
        final /* synthetic */ boolean $expanding;
        final /* synthetic */ boolean $nineSplitCollapse;
        final /* synthetic */ Ref$FloatRef $offsetY;
        final /* synthetic */ Ref$FloatRef $pinchPx;
        final /* synthetic */ Ref$FloatRef $radius;
        final /* synthetic */ Rect $rect;

        public b(Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f10, float f11, Ref$FloatRef ref$FloatRef4, Ref$FloatRef ref$FloatRef5, boolean z10, Rect rect, Ref$FloatRef ref$FloatRef6, boolean z11, float f12, float f13, float f14) {
            this.$clipWidth = ref$FloatRef;
            this.$pinchPx = ref$FloatRef2;
            this.$clipHeight = ref$FloatRef3;
            this.$centerX = f10;
            this.$centerY = f11;
            this.$offsetY = ref$FloatRef4;
            this.$bottomOffset = ref$FloatRef5;
            this.$nineSplitCollapse = z10;
            this.$rect = rect;
            this.$radius = ref$FloatRef6;
            this.$expanding = z11;
            this.$endWidth = f12;
            this.$endHeight = f13;
            this.$endOffsetY = f14;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            float fE = C5685n.e(this.$clipWidth.f34817a - this.$pinchPx.f34817a, 1.0f);
            float fE2 = C5685n.e(this.$clipHeight.f34817a, 1.0f);
            float f10 = fE * 0.5f;
            int iFloor = (int) Math.floor(this.$centerX - f10);
            int iFloor2 = (int) Math.floor((this.$centerY - r4) + this.$offsetY.f34817a + this.$bottomOffset.f34817a);
            int iCeil = (int) Math.ceil(this.$centerX + f10);
            float f11 = this.$centerY + (fE2 * 0.5f) + this.$offsetY.f34817a + this.$bottomOffset.f34817a;
            int iFloor3 = (int) (this.$nineSplitCollapse ? Math.floor(f11) : Math.ceil(f11));
            this.$rect.set(iFloor, iFloor2, iCeil, iFloor3);
            float fM = C5685n.m(this.$radius.f34817a, 0.0f, Math.min(fE, fE2) * 0.5f);
            boolean z10 = this.$expanding && fE + 0.5f >= this.$endWidth && fE2 + 0.5f >= this.$endHeight && this.$offsetY.f34817a <= this.$endOffsetY + 0.5f;
            if (this.$nineSplitCollapse) {
                outline.setRoundRect(this.$rect, K.INSTANCE.b(fE, fE2, this.$radius.f34817a));
            } else if (z10) {
                outline.setRoundRect(iFloor, iFloor2, iCeil, iFloor3 + ((int) fM), fM);
            } else {
                outline.setRoundRect(this.$rect, fM);
            }
        }
    }

    public static /* synthetic */ androidx.dynamicanimation.animation.i k(p pVar, float f10, float f11, float f12, float f13, float f14, float f15, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            f14 = 0.0f;
        }
        if ((i10 & 32) != 0) {
            f15 = 0.0f;
        }
        return pVar.j(f10, f11, f12, f13, f14, f15, interfaceC5074l);
    }

    public static final void l(InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        interfaceC5074l.invoke(Float.valueOf(f10));
    }

    public static final void n(Ref$BooleanRef ref$BooleanRef, boolean z10, float f10, float f11, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, float f12, float f13, float f14, float f15, float f16, Ref$FloatRef ref$FloatRef3, float f17, View view, float f18, boolean z11, float f19, InterfaceC5063a<Y8.t> interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef2, InterfaceC5063a<Y8.t> interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef4, Ref$FloatRef ref$FloatRef5, float f20, float f21, float f22, float f23, Ref$BooleanRef ref$BooleanRef3) {
        float f24;
        Ref$FloatRef ref$FloatRef6 = ref$FloatRef;
        Ref$FloatRef ref$FloatRef7 = ref$FloatRef2;
        if (ref$BooleanRef.f34815a) {
            return;
        }
        if (z10) {
            float fA = K.INSTANCE.a(f17 + (C5685n.e(ref$FloatRef6.f34817a, 1.0f) * 0.5f) + ref$FloatRef7.f34817a, a0.c(f14, f15, f16, f10 > f11 ? (f10 - ref$FloatRef6.f34817a) / (f10 - f11) : (ref$FloatRef7.f34817a - f12) / f13));
            ref$FloatRef3.f34817a = fA;
            view.setTranslationY(f18 + fA);
        }
        if (z11) {
            view.setTranslationY(f18 + Math.min(0.0f, ((f11 - ref$FloatRef6.f34817a) * 0.5f) + (ref$FloatRef7.f34817a - f19)));
            o(view3, ref$FloatRef4, ref$FloatRef5, ref$FloatRef6, z11, f20, f21, f11, f10, f22, view, f17, f18, f23, ref$BooleanRef3, ref$FloatRef7);
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            f24 = f11;
            ref$FloatRef6 = ref$FloatRef;
            ref$FloatRef7 = ref$FloatRef2;
        } else {
            f24 = f11;
            o(view3, ref$FloatRef4, ref$FloatRef5, ref$FloatRef6, z11, f20, f21, f24, f10, f22, view, f17, f18, f23, ref$BooleanRef3, ref$FloatRef7);
        }
        view2.invalidateOutline();
        if (z11 || ref$BooleanRef2.f34815a || !U.a(ref$FloatRef6.f34817a, f24, f19 - ref$FloatRef7.f34817a)) {
            return;
        }
        ref$BooleanRef2.f34815a = true;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
    }

    public static final void o(View view, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, boolean z10, float f10, float f11, float f12, float f13, float f14, View view2, float f15, float f16, float f17, Ref$BooleanRef ref$BooleanRef, Ref$FloatRef ref$FloatRef4) {
        if (view == null) {
            return;
        }
        float fE = C5685n.e(ref$FloatRef.f34817a - ref$FloatRef2.f34817a, 1.0f);
        float fE2 = C5685n.e(ref$FloatRef3.f34817a, 1.0f);
        if (!z10) {
            f10 = f11;
        }
        float fE3 = C5685n.e(f10, 1.0f);
        if (!z10) {
            f12 = f13;
        }
        float fE4 = C5685n.e(f12, 1.0f);
        float fM = C5685n.m(fE / fE3, 0.01f, 1.0f);
        view.setPivotX((f14 - view2.getLeft()) - view.getLeft());
        view.setPivotY((((f15 - (fE4 * 0.5f)) - f16) - view2.getTop()) - view.getTop());
        view.setScaleX(fM);
        view.setScaleY(fM);
        view.setTranslationY(((z10 && ref$BooleanRef.f34815a) ? 0.0f : C5685n.e(((fE4 - fE2) * 0.5f) + ref$FloatRef4.f34817a, 0.0f)) + f17);
    }

    public static final Y8.t q(Ref$BooleanRef ref$BooleanRef, View view, ViewOutlineProvider viewOutlineProvider, boolean z10, int i10, Boolean bool, View view2, ViewOutlineProvider viewOutlineProvider2, boolean z11, float f10, float f11, View view3, int i11, float f12, float f13, float f14, float f15, float f16) {
        x(ref$BooleanRef, view, viewOutlineProvider, z10, i10, bool, view2, viewOutlineProvider2, z11, f10, f11, view3, i11, f12, f13, f14, f15, f16);
        return Y8.t.f7040a;
    }

    public static final Y8.t r(boolean z10, float f10, Ref$BooleanRef ref$BooleanRef, Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef2, boolean z11, float f11, float f12, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f13, float f14, float f15, float f16, float f17, Ref$FloatRef ref$FloatRef4, float f18, View view, float f19, float f20, InterfaceC5063a interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef3, InterfaceC5063a interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef5, float f21, float f22, float f23, Ref$BooleanRef ref$BooleanRef4, float f24) {
        float fE = C5685n.e(f24, 1.0f);
        if (z10) {
            if (fE >= f10) {
                ref$BooleanRef.f34815a = true;
            }
            if (ref$BooleanRef.f34815a) {
                fE = Math.max(fE, f10);
            }
        }
        ref$FloatRef.f34817a = fE;
        n(ref$BooleanRef2, z11, f11, f12, ref$FloatRef2, ref$FloatRef3, f13, f14, f15, f16, f17, ref$FloatRef4, f18, view, f19, z10, f20, interfaceC5063a, view2, ref$BooleanRef3, interfaceC5063a2, view3, ref$FloatRef, ref$FloatRef5, f10, f21, f22, f23, ref$BooleanRef4);
        return Y8.t.f7040a;
    }

    public static final Y8.t s(boolean z10, float f10, Ref$BooleanRef ref$BooleanRef, Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef2, float f11, Ref$BooleanRef ref$BooleanRef3, boolean z11, float f12, Ref$FloatRef ref$FloatRef2, float f13, float f14, float f15, float f16, float f17, Ref$FloatRef ref$FloatRef3, float f18, View view, float f19, float f20, InterfaceC5063a interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef4, InterfaceC5063a interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef4, Ref$FloatRef ref$FloatRef5, float f21, float f22, float f23, float f24, float f25) {
        float fE = C5685n.e(f25, 1.0f);
        if (z10) {
            if (fE >= f10) {
                ref$BooleanRef.f34815a = true;
            }
            if (ref$BooleanRef.f34815a) {
                fE = Math.max(fE, f10);
            }
        }
        ref$FloatRef.f34817a = fE;
        ref$BooleanRef2.f34815a = !z10 && f11 > 0.0f && fE <= Math.max(4.0f * f10, f10);
        n(ref$BooleanRef3, z11, f12, f10, ref$FloatRef, ref$FloatRef2, f13, f14, f15, f16, f17, ref$FloatRef3, f18, view, f19, z10, f20, interfaceC5063a, view2, ref$BooleanRef4, interfaceC5063a2, view3, ref$FloatRef4, ref$FloatRef5, f21, f22, f23, f24, ref$BooleanRef);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t t(boolean r29, float r30, float r31, kotlin.jvm.internal.Ref$BooleanRef r32, kotlin.jvm.internal.Ref$FloatRef r33, p9.InterfaceC5074l r34, float r35, kotlin.jvm.internal.Ref$BooleanRef r36, boolean r37, float r38, float r39, kotlin.jvm.internal.Ref$FloatRef r40, float r41, float r42, float r43, kotlin.jvm.internal.Ref$FloatRef r44, float r45, android.view.View r46, float r47, p9.InterfaceC5063a r48, android.view.View r49, kotlin.jvm.internal.Ref$BooleanRef r50, p9.InterfaceC5063a r51, android.view.View r52, kotlin.jvm.internal.Ref$FloatRef r53, kotlin.jvm.internal.Ref$FloatRef r54, float r55, float r56, float r57, float r58, kotlin.jvm.internal.Ref$BooleanRef r59, float r60) {
        /*
            r0 = r31
            r1 = r32
            r2 = r60
            if (r29 == 0) goto L1e
            int r3 = (r30 > r0 ? 1 : (r30 == r0 ? 0 : -1))
            if (r3 <= 0) goto L1e
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 > 0) goto L13
            r3 = 1
            r1.f34815a = r3
        L13:
            boolean r1 = r1.f34815a
            if (r1 == 0) goto L1e
            float r1 = java.lang.Math.min(r2, r0)
        L1b:
            r5 = r33
            goto L20
        L1e:
            r1 = r2
            goto L1b
        L20:
            r5.f34817a = r1
            r15 = r29
            r6 = r30
            r7 = r35
            r1 = r37
            r2 = r38
            r3 = r39
            r4 = r40
            r8 = r41
            r9 = r42
            r10 = r43
            r11 = r44
            r12 = r45
            r13 = r46
            r14 = r47
            r17 = r48
            r18 = r49
            r19 = r50
            r20 = r51
            r21 = r52
            r22 = r53
            r23 = r54
            r24 = r55
            r25 = r56
            r26 = r57
            r27 = r58
            r28 = r59
            r16 = r0
            r0 = r36
            n(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r0 = r34
            if (r0 == 0) goto L73
            float r1 = r60 - r30
            float r1 = r1 / r35
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = v9.C5685n.m(r1, r2, r3)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r0.invoke(r1)
        L73:
            Y8.t r0 = Y8.t.f7040a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sheet.internal.p.t(boolean, float, float, kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$FloatRef, p9.l, float, kotlin.jvm.internal.Ref$BooleanRef, boolean, float, float, kotlin.jvm.internal.Ref$FloatRef, float, float, float, kotlin.jvm.internal.Ref$FloatRef, float, android.view.View, float, p9.a, android.view.View, kotlin.jvm.internal.Ref$BooleanRef, p9.a, android.view.View, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$FloatRef, float, float, float, float, kotlin.jvm.internal.Ref$BooleanRef, float):Y8.t");
    }

    public static final Y8.t u(Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef, boolean z10, float f10, float f11, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f12, float f13, float f14, float f15, float f16, Ref$FloatRef ref$FloatRef4, float f17, View view, float f18, boolean z11, float f19, InterfaceC5063a interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef2, InterfaceC5063a interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef5, Ref$FloatRef ref$FloatRef6, float f20, float f21, float f22, float f23, Ref$BooleanRef ref$BooleanRef3, float f24) {
        ref$FloatRef.f34817a = C5685n.e(f24, 0.0f);
        n(ref$BooleanRef, z10, f10, f11, ref$FloatRef2, ref$FloatRef3, f12, f13, f14, f15, f16, ref$FloatRef4, f17, view, f18, z11, f19, interfaceC5063a, view2, ref$BooleanRef2, interfaceC5063a2, view3, ref$FloatRef5, ref$FloatRef6, f20, f21, f22, f23, ref$BooleanRef3);
        return Y8.t.f7040a;
    }

    public static final void v(Ref$BooleanRef ref$BooleanRef, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef, float f10, Ref$FloatRef ref$FloatRef2, float f11, Ref$FloatRef ref$FloatRef3, float f12, Ref$FloatRef ref$FloatRef4, float f13, InterfaceC5074l interfaceC5074l, boolean z10, InterfaceC5063a interfaceC5063a, Ref$BooleanRef ref$BooleanRef2, boolean z11, float f14, float f15, float f16, float f17, float f18, float f19, Ref$FloatRef ref$FloatRef5, float f20, View view, float f21, boolean z12, InterfaceC5063a interfaceC5063a2, View view2, Ref$BooleanRef ref$BooleanRef3, InterfaceC5063a interfaceC5063a3, View view3, Ref$FloatRef ref$FloatRef6, float f22, float f23, float f24, Ref$BooleanRef ref$BooleanRef4, ViewOutlineProvider viewOutlineProvider, boolean z13, int i10, Boolean bool, ViewOutlineProvider viewOutlineProvider2, boolean z14, float f25, int i11, float f26, float f27, float f28, float f29, androidx.dynamicanimation.animation.e eVar, boolean z15, float f30, float f31) {
        if (z15 || ref$BooleanRef.f34815a) {
            return;
        }
        int i12 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i12;
        if (i12 > 0) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        ref$FloatRef.f34817a = f10;
        ref$FloatRef2.f34817a = f11;
        ref$FloatRef3.f34817a = f12;
        ref$FloatRef4.f34817a = f13;
        n(ref$BooleanRef2, z11, f14, f11, ref$FloatRef2, ref$FloatRef3, f15, f16, f17, f18, f19, ref$FloatRef5, f20, view, f21, z12, f12, interfaceC5063a2, view2, ref$BooleanRef3, interfaceC5063a3, view3, ref$FloatRef, ref$FloatRef6, f10, f22, f23, f24, ref$BooleanRef4);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (z10) {
            x(ref$BooleanRef2, view2, viewOutlineProvider, z13, i10, bool, view, viewOutlineProvider2, z14, f25, f21, view3, i11, f26, f27, f28, f29, f24);
        }
        interfaceC5063a.invoke();
    }

    public static final void w(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef3, Ref$BooleanRef ref$BooleanRef4, float f10, Ref$IntRef ref$IntRef, float f11, List list, e.q qVar, Ref$FloatRef ref$FloatRef2, Ref$BooleanRef ref$BooleanRef5, boolean z10, float f12, float f13, Ref$FloatRef ref$FloatRef3, Ref$FloatRef ref$FloatRef4, float f14, float f15, float f16, float f17, float f18, Ref$FloatRef ref$FloatRef5, float f19, View view, float f20, boolean z11, float f21, InterfaceC5063a interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef6, InterfaceC5063a interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef6, float f22, float f23, float f24, float f25, Ref$BooleanRef ref$BooleanRef7, androidx.dynamicanimation.animation.e eVar, float f26, float f27) {
        if (ref$BooleanRef.f34815a && f27 > 0.0f) {
            ref$BooleanRef2.f34815a = true;
        }
        if (ref$BooleanRef2.f34815a && ref$FloatRef.f34817a > 0.0f && f27 <= 0.0f) {
            y(ref$BooleanRef3, ref$BooleanRef4, f10, ref$IntRef, f11, list, qVar, ref$FloatRef2, ref$BooleanRef5, z10, f12, f13, ref$FloatRef3, ref$FloatRef4, f14, f15, f16, f17, f18, ref$FloatRef5, f19, view, f20, z11, f21, interfaceC5063a, view2, ref$BooleanRef6, interfaceC5063a2, view3, ref$FloatRef6, f22, f23, f24, f25, ref$BooleanRef7);
        }
        ref$FloatRef.f34817a = f27;
    }

    public static final void x(Ref$BooleanRef ref$BooleanRef, View view, ViewOutlineProvider viewOutlineProvider, boolean z10, int i10, Boolean bool, View view2, ViewOutlineProvider viewOutlineProvider2, boolean z11, float f10, float f11, View view3, int i11, float f12, float f13, float f14, float f15, float f16) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        view.setOutlineProvider(viewOutlineProvider);
        view.setClipToOutline(z10);
        view.setLayerType(i10, null);
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).setClipChildren(zBooleanValue);
        }
        view2.setOutlineProvider(viewOutlineProvider2);
        view2.setClipToOutline(z11);
        view2.setElevation(f10);
        view2.setTranslationY(f11);
        if (view3 != null) {
            view3.setLayerType(i11, null);
            view3.setScaleX(f12);
            view3.setScaleY(f13);
            view3.setPivotX(f14);
            view3.setPivotY(f15);
            view3.setTranslationY(f16);
        }
        view2.invalidateOutline();
    }

    public static final void y(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, float f10, Ref$IntRef ref$IntRef, float f11, List<androidx.dynamicanimation.animation.i> list, e.q qVar, final Ref$FloatRef ref$FloatRef, final Ref$BooleanRef ref$BooleanRef3, final boolean z10, final float f12, final float f13, final Ref$FloatRef ref$FloatRef2, final Ref$FloatRef ref$FloatRef3, final float f14, final float f15, final float f16, final float f17, final float f18, final Ref$FloatRef ref$FloatRef4, final float f19, final View view, final float f20, final boolean z11, final float f21, final InterfaceC5063a<Y8.t> interfaceC5063a, final View view2, final Ref$BooleanRef ref$BooleanRef4, final InterfaceC5063a<Y8.t> interfaceC5063a2, final View view3, final Ref$FloatRef ref$FloatRef5, final float f22, final float f23, final float f24, final float f25, final Ref$BooleanRef ref$BooleanRef5) {
        if (ref$BooleanRef.f34815a || ref$BooleanRef2.f34815a || f10 <= 0.0f) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        ref$IntRef.f34818a++;
        float fSqrt = (float) Math.sqrt(f11);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(0.0f));
        iVar.B(new androidx.dynamicanimation.animation.j(0.0f).h(f11).f(1.0f));
        iVar.r(fSqrt * f10 * 2.7182817f);
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.n
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f26, float f27) {
                p.z(ref$FloatRef, ref$BooleanRef3, z10, f12, f13, ref$FloatRef2, ref$FloatRef3, f14, f15, f16, f17, f18, ref$FloatRef4, f19, view, f20, z11, f21, interfaceC5063a, view2, ref$BooleanRef4, interfaceC5063a2, view3, ref$FloatRef5, f22, f23, f24, f25, ref$BooleanRef5, eVar, f26, f27);
            }
        });
        list.add(iVar);
        iVar.b(qVar);
        iVar.t();
    }

    public static final void z(Ref$FloatRef ref$FloatRef, Ref$BooleanRef ref$BooleanRef, boolean z10, float f10, float f11, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, float f12, float f13, float f14, float f15, float f16, Ref$FloatRef ref$FloatRef4, float f17, View view, float f18, boolean z11, float f19, InterfaceC5063a interfaceC5063a, View view2, Ref$BooleanRef ref$BooleanRef2, InterfaceC5063a interfaceC5063a2, View view3, Ref$FloatRef ref$FloatRef5, float f20, float f21, float f22, float f23, Ref$BooleanRef ref$BooleanRef3, androidx.dynamicanimation.animation.e eVar, float f24, float f25) {
        ref$FloatRef.f34817a = C5685n.e(f24, 0.0f);
        n(ref$BooleanRef, z10, f10, f11, ref$FloatRef2, ref$FloatRef3, f12, f13, f14, f15, f16, ref$FloatRef4, f17, view, f18, z11, f19, interfaceC5063a, view2, ref$BooleanRef2, interfaceC5063a2, view3, ref$FloatRef5, ref$FloatRef, f20, f21, f22, f23, ref$BooleanRef3);
    }

    public final androidx.dynamicanimation.animation.i j(float start, float end, float stiffness, float dampingRatio, float startVelocity, float minVisibleChange, final InterfaceC5074l<? super Float, Y8.t> onUpdate) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(start));
        iVar.B(new androidx.dynamicanimation.animation.j(end).h(stiffness).f(dampingRatio));
        if (startVelocity != 0.0f) {
            iVar.r(startVelocity);
        }
        if (minVisibleChange > 0.0f) {
            iVar.o(minVisibleChange);
        }
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.o
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                p.l(onUpdate, eVar, f10, f11);
            }
        });
        return iVar;
    }

    public final a m(final View clipView, final View panel, final float startWidth, final float endWidth, final float startHeight, final float endHeight, final float centerX, final float centerY, final float startOffsetY, final float endOffsetY, float startRadius, final float endRadius, float widthStiffness, float widthDampingRatio, final float heightStiffness, float heightDampingRatio, float radiusStiffness, float radiusDampingRatio, float positionStiffness, float positionDampingRatio, float positionStartVelocity, float heightStartVelocity, final boolean restoreOnEnd, final float bottomWidthPinchPx, float widthMinVisibleChange, final View scaleContentView, final InterfaceC5063a<Y8.t> onAfterPanelTransform, final InterfaceC5074l<? super Float, Y8.t> onProgress, final InterfaceC5063a<Y8.t> onCollapsedToBar, final InterfaceC5063a<Y8.t> onEnd) {
        e.q qVar;
        final List<androidx.dynamicanimation.animation.i> list;
        kotlin.jvm.internal.p.i(clipView, "clipView");
        kotlin.jvm.internal.p.i(panel, "panel");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        final ViewOutlineProvider outlineProvider = clipView.getOutlineProvider();
        final boolean clipToOutline = clipView.getClipToOutline();
        boolean z10 = clipView instanceof ViewGroup;
        ViewGroup viewGroup = z10 ? (ViewGroup) clipView : null;
        final Boolean boolValueOf = viewGroup != null ? Boolean.valueOf(viewGroup.getClipChildren()) : null;
        final ViewOutlineProvider outlineProvider2 = panel.getOutlineProvider();
        final boolean clipToOutline2 = panel.getClipToOutline();
        final float elevation = panel.getElevation();
        final int layerType = clipView.getLayerType();
        final int layerType2 = scaleContentView != null ? scaleContentView.getLayerType() : 0;
        final float scaleX = scaleContentView != null ? scaleContentView.getScaleX() : 1.0f;
        final float scaleY = scaleContentView != null ? scaleContentView.getScaleY() : 1.0f;
        final float pivotX = scaleContentView != null ? scaleContentView.getPivotX() : 0.0f;
        final float pivotY = scaleContentView != null ? scaleContentView.getPivotY() : 0.0f;
        final float translationY = scaleContentView != null ? scaleContentView.getTranslationY() : 0.0f;
        final float translationY2 = panel.getTranslationY();
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.f34817a = startWidth;
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        ref$FloatRef2.f34817a = startHeight;
        final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
        final Ref$FloatRef ref$FloatRef4 = new Ref$FloatRef();
        ref$FloatRef4.f34817a = startOffsetY;
        final Ref$FloatRef ref$FloatRef5 = new Ref$FloatRef();
        ref$FloatRef5.f34817a = startRadius;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        final Ref$FloatRef ref$FloatRef6 = new Ref$FloatRef();
        final Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef4 = new Ref$BooleanRef();
        float f10 = endOffsetY - startOffsetY;
        float f11 = Math.abs(f10) >= 1.0f ? f10 : 1.0f;
        Rect rect = new Rect();
        boolean z11 = !restoreOnEnd && bottomWidthPinchPx > 0.0f;
        panel.setClipToOutline(false);
        panel.setElevation(0.0f);
        ViewGroup viewGroup2 = z10 ? (ViewGroup) clipView : null;
        if (viewGroup2 != null) {
            viewGroup2.setClipChildren(false);
            Y8.t tVar = Y8.t.f7040a;
        }
        clipView.setLayerType(restoreOnEnd ? 2 : 0, null);
        if (scaleContentView != null) {
            scaleContentView.setLayerType(2, SCALE_LAYER_PAINT);
            Y8.t tVar2 = Y8.t.f7040a;
        }
        clipView.getLocationOnScreen(new int[2]);
        final float fMin = Math.min(clipView.getHeight(), clipView.getResources().getDisplayMetrics().heightPixels - r3[1]);
        final float f12 = clipView.getResources().getDisplayMetrics().density * 5.0f;
        final float f13 = centerY + (0.5f * startHeight) + startOffsetY;
        final Ref$FloatRef ref$FloatRef7 = new Ref$FloatRef();
        final Ref$BooleanRef ref$BooleanRef5 = new Ref$BooleanRef();
        ref$BooleanRef5.f34815a = !restoreOnEnd;
        final Ref$BooleanRef ref$BooleanRef6 = new Ref$BooleanRef();
        ref$BooleanRef6.f34815a = !restoreOnEnd;
        final Ref$BooleanRef ref$BooleanRef7 = new Ref$BooleanRef();
        ref$BooleanRef7.f34815a = !restoreOnEnd;
        clipView.setOutlineProvider(new b(ref$FloatRef, ref$FloatRef3, ref$FloatRef2, centerX, centerY, ref$FloatRef4, ref$FloatRef7, z11, rect, ref$FloatRef5, restoreOnEnd, endWidth, endHeight, endOffsetY));
        clipView.setClipToOutline(true);
        final Ref$BooleanRef ref$BooleanRef8 = new Ref$BooleanRef();
        final float f14 = f11;
        final boolean z12 = z11;
        androidx.dynamicanimation.animation.i iVarK = k(this, startWidth, endWidth, widthStiffness, widthDampingRatio, 0.0f, widthMinVisibleChange, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p.r(restoreOnEnd, endWidth, ref$BooleanRef5, ref$FloatRef, ref$BooleanRef8, z12, startHeight, endHeight, ref$FloatRef2, ref$FloatRef4, startOffsetY, f14, f13, fMin, f12, ref$FloatRef7, centerY, panel, translationY2, endOffsetY, onAfterPanelTransform, clipView, ref$BooleanRef4, onCollapsedToBar, scaleContentView, ref$FloatRef3, startWidth, centerX, translationY, ref$BooleanRef6, ((Float) obj).floatValue());
            }
        }, 16, null);
        final float f15 = translationY;
        List listS = C1173v.s(iVarK, k(this, startHeight, endHeight, heightStiffness, heightDampingRatio, heightStartVelocity, 0.0f, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p.s(restoreOnEnd, endHeight, ref$BooleanRef6, ref$FloatRef2, ref$BooleanRef, bottomWidthPinchPx, ref$BooleanRef8, z12, startHeight, ref$FloatRef4, startOffsetY, f14, f13, fMin, f12, ref$FloatRef7, centerY, panel, translationY2, endOffsetY, onAfterPanelTransform, clipView, ref$BooleanRef4, onCollapsedToBar, scaleContentView, ref$FloatRef, ref$FloatRef3, endWidth, startWidth, centerX, f15, ((Float) obj).floatValue());
            }
        }, 32, null), k(this, startOffsetY, endOffsetY, positionStiffness, positionDampingRatio, positionStartVelocity, 0.0f, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p.t(restoreOnEnd, startOffsetY, endOffsetY, ref$BooleanRef7, ref$FloatRef4, onProgress, f14, ref$BooleanRef8, z12, startHeight, endHeight, ref$FloatRef2, f13, fMin, f12, ref$FloatRef7, centerY, panel, translationY2, onAfterPanelTransform, clipView, ref$BooleanRef4, onCollapsedToBar, scaleContentView, ref$FloatRef, ref$FloatRef3, endWidth, startWidth, centerX, f15, ref$BooleanRef6, ((Float) obj).floatValue());
            }
        }, 32, null), k(this, startRadius, endRadius, radiusStiffness, radiusDampingRatio, 0.0f, 0.0f, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.internal.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return p.u(ref$FloatRef5, ref$BooleanRef8, z12, startHeight, endHeight, ref$FloatRef2, ref$FloatRef4, startOffsetY, f14, f13, fMin, f12, ref$FloatRef7, centerY, panel, translationY2, restoreOnEnd, endOffsetY, onAfterPanelTransform, clipView, ref$BooleanRef4, onCollapsedToBar, scaleContentView, ref$FloatRef, ref$FloatRef3, endWidth, startWidth, centerX, f15, ref$BooleanRef6, ((Float) obj).floatValue());
            }
        }, 48, null));
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = listS.size();
        final Ref$BooleanRef ref$BooleanRef9 = new Ref$BooleanRef();
        final e.q qVar2 = new e.q() { // from class: com.stepos.ailauncher.sheet.internal.k
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z13, float f16, float f17) {
                p.v(ref$BooleanRef9, ref$IntRef, ref$FloatRef, endWidth, ref$FloatRef2, endHeight, ref$FloatRef4, endOffsetY, ref$FloatRef5, endRadius, onProgress, restoreOnEnd, onEnd, ref$BooleanRef8, z12, startHeight, startOffsetY, f14, f13, fMin, f12, ref$FloatRef7, centerY, panel, translationY2, restoreOnEnd, onAfterPanelTransform, clipView, ref$BooleanRef4, onCollapsedToBar, scaleContentView, ref$FloatRef3, startWidth, centerX, f15, ref$BooleanRef6, outlineProvider, clipToOutline, layerType, boolValueOf, outlineProvider2, clipToOutline2, elevation, layerType2, scaleX, scaleY, pivotX, pivotY, eVar, z13, f16, f17);
            }
        };
        final Ref$FloatRef ref$FloatRef8 = ref$FloatRef2;
        final Ref$FloatRef ref$FloatRef9 = ref$FloatRef4;
        final float f16 = f14;
        final float f17 = f13;
        final float f18 = f12;
        final Ref$FloatRef ref$FloatRef10 = ref$FloatRef7;
        final float f19 = translationY2;
        final Ref$BooleanRef ref$BooleanRef10 = ref$BooleanRef4;
        final Ref$FloatRef ref$FloatRef11 = ref$FloatRef3;
        final float f20 = f15;
        final Ref$BooleanRef ref$BooleanRef11 = ref$BooleanRef6;
        final float f21 = scaleY;
        final float f22 = pivotX;
        final float f23 = pivotY;
        final Ref$BooleanRef ref$BooleanRef12 = ref$BooleanRef8;
        final float f24 = fMin;
        final int i10 = layerType2;
        final float f25 = scaleX;
        final Boolean bool = boolValueOf;
        if (bottomWidthPinchPx > 0.0f) {
            list = listS;
            e.r rVar = new e.r() { // from class: com.stepos.ailauncher.sheet.internal.l
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f26, float f27) {
                    p.w(ref$BooleanRef, ref$BooleanRef3, ref$FloatRef6, ref$BooleanRef2, ref$BooleanRef9, bottomWidthPinchPx, ref$IntRef, heightStiffness, list, qVar2, ref$FloatRef11, ref$BooleanRef12, z12, startHeight, endHeight, ref$FloatRef8, ref$FloatRef9, startOffsetY, f16, f17, f24, f18, ref$FloatRef10, centerY, panel, f19, restoreOnEnd, endOffsetY, onAfterPanelTransform, clipView, ref$BooleanRef10, onCollapsedToBar, scaleContentView, ref$FloatRef, endWidth, startWidth, centerX, f20, ref$BooleanRef11, eVar, f26, f27);
                }
            };
            qVar = qVar2;
            ref$BooleanRef12 = ref$BooleanRef12;
            ref$FloatRef8 = ref$FloatRef8;
            ref$FloatRef9 = ref$FloatRef9;
            f16 = f16;
            f17 = f17;
            f24 = f24;
            f18 = f18;
            ref$FloatRef10 = ref$FloatRef10;
            f19 = f19;
            ref$BooleanRef10 = ref$BooleanRef10;
            f20 = f20;
            ref$BooleanRef11 = ref$BooleanRef11;
            ref$FloatRef11 = ref$FloatRef11;
            iVarK.c(rVar);
        } else {
            qVar = qVar2;
            list = listS;
        }
        for (androidx.dynamicanimation.animation.i iVar : list) {
            iVar.b(qVar);
            iVar.t();
        }
        final Ref$BooleanRef ref$BooleanRef13 = ref$BooleanRef12;
        List list2 = list;
        final float f26 = f19;
        n(ref$BooleanRef13, z12, startHeight, endHeight, ref$FloatRef8, ref$FloatRef9, startOffsetY, f16, f17, f24, f18, ref$FloatRef10, centerY, panel, f26, restoreOnEnd, endOffsetY, onAfterPanelTransform, clipView, ref$BooleanRef10, onCollapsedToBar, scaleContentView, ref$FloatRef, ref$FloatRef11, endWidth, startWidth, centerX, f20, ref$BooleanRef11);
        final float f27 = f20;
        return new a(list2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.internal.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.q(ref$BooleanRef13, clipView, outlineProvider, clipToOutline, layerType, bool, panel, outlineProvider2, clipToOutline2, elevation, f26, scaleContentView, i10, f25, f21, f22, f23, f27);
            }
        });
    }
}
