package com.stepos.agentsprite.view;

import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.view.SceneView;
import com.stepos.ailauncher.chat.trace.h;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\u000eJ7\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010 \u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u000eJ'\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020,2\u0006\u0010$\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J/\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020,2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J/\u0010'\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u001aH\u0002¢\u0006\u0004\b'\u00106J/\u00108\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u001aH\u0002¢\u0006\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010:R\u0018\u0010@\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010:R0\u0010I\u001a\u00020A2\u0006\u0010B\u001a\u00020A8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\"\u0010C\u0012\u0004\bH\u0010#\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR0\u0010Q\u001a\u00020J2\u0006\u0010B\u001a\u00020J8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b%\u0010K\u0012\u0004\bP\u0010#\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/stepos/agentsprite/view/SceneView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "view", "LY8/t;", "setBackgroundSlot", "(Landroid/view/View;)V", "setAgentSlot", "setForegroundSlot", "setBubbleSlot", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/widget/FrameLayout$LayoutParams;", "generateLayoutParams", "(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;", "zIndex", "Lkotlin/Function1;", "assign", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ILandroid/view/View;Lp9/l;)V", "e", "()V", "v", "f", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "(Landroid/view/View;II)V", "containerW", "containerH", "Landroid/graphics/Rect;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;II)Landroid/graphics/Rect;", Const.INTENT_KEY_PKGNAME, "agentBounds", "k", "(Landroid/view/View;Landroid/graphics/Rect;II)V", "gravity", "bw", "lp", "(IIILandroid/widget/FrameLayout$LayoutParams;)I", "bh", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "background", "agent", "c", h.APP_FOREGROUND, Const.INTENT_KEY_UMID, "bubble", "Lcom/stepos/agentsprite/view/BubblePlacement;", UxipConstants.f30680s, "Lcom/stepos/agentsprite/view/BubblePlacement;", "getBubblePlacement", "()Lcom/stepos/agentsprite/view/BubblePlacement;", "setBubblePlacement", "(Lcom/stepos/agentsprite/view/BubblePlacement;)V", "getBubblePlacement$annotations", "bubblePlacement", "", "F", "getBubbleSpacingDp", "()F", "setBubbleSpacingDp", "(F)V", "getBubbleSpacingDp$annotations", "bubbleSpacingDp", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SceneView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public View background;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View agent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public View foreground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View bubble;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public BubblePlacement bubblePlacement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float bubbleSpacingDp;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23487a;

        static {
            int[] iArr = new int[BubblePlacement.values().length];
            try {
                iArr[BubblePlacement.AboveStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BubblePlacement.AboveCenter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BubblePlacement.AboveEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BubblePlacement.Start.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BubblePlacement.End.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BubblePlacement.BelowStart.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BubblePlacement.BelowCenter.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BubblePlacement.BelowEnd.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BubblePlacement.Overlay.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f23487a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SceneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public static /* synthetic */ void getBubblePlacement$annotations() {
    }

    public static /* synthetic */ void getBubbleSpacingDp$annotations() {
    }

    public static final t l(SceneView sceneView, View it) {
        p.i(it, "it");
        sceneView.agent = it;
        return t.f7040a;
    }

    public static final t m(SceneView sceneView, View it) {
        p.i(it, "it");
        sceneView.background = it;
        return t.f7040a;
    }

    public static final t n(SceneView sceneView, View it) {
        p.i(it, "it");
        sceneView.bubble = it;
        return t.f7040a;
    }

    public static final t o(SceneView sceneView, View it) {
        p.i(it, "it");
        sceneView.foreground = it;
        return t.f7040a;
    }

    public final void e() {
        View view = this.background;
        if (view != null) {
            f(view);
        }
        View view2 = this.agent;
        if (view2 != null) {
            f(view2);
        }
        View view3 = this.foreground;
        if (view3 != null) {
            f(view3);
        }
        View view4 = this.bubble;
        if (view4 != null) {
            f(view4);
        }
    }

    public final void f(View v10) {
        if (v10.getParent() == this) {
            v10.bringToFront();
        }
    }

    public final Rect g(View v10, int containerW, int containerH) {
        int iF = C5685n.f(v10.getMeasuredWidth(), 1);
        int iF2 = C5685n.f(v10.getMeasuredHeight(), 1);
        int i10 = (containerW - iF) / 2;
        int i11 = (containerH - iF2) / 2;
        int i12 = iF + i10;
        int i13 = iF2 + i11;
        v10.layout(i10, i11, i12, i13);
        return new Rect(i10, i11, i12, i13);
    }

    public final BubblePlacement getBubblePlacement() {
        return this.bubblePlacement;
    }

    public final float getBubbleSpacingDp() {
        return this.bubbleSpacingDp;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(int r1, int r2, int r3, android.widget.FrameLayout.LayoutParams r4) {
        /*
            r0 = this;
            r0 = r1 & 7
            r1 = 3
            if (r0 == r1) goto L18
            r1 = 5
            if (r0 == r1) goto L16
            r1 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L18
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L16
            int r2 = r2 - r3
            int r2 = r2 / 2
            goto L19
        L16:
            int r2 = r2 - r3
            goto L19
        L18:
            r2 = 0
        L19:
            int r0 = r4.leftMargin
            int r2 = r2 + r0
            int r0 = r4.rightMargin
            int r2 = r2 - r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentsprite.view.SceneView.h(int, int, int, android.widget.FrameLayout$LayoutParams):int");
    }

    public final int i(int gravity, int containerH, int bh, FrameLayout.LayoutParams lp) {
        int i10 = gravity & 112;
        return ((i10 != 48 ? i10 != 80 ? (containerH - bh) / 2 : containerH - bh : 0) + lp.topMargin) - lp.bottomMargin;
    }

    public final void j(int zIndex, View view, InterfaceC5074l<? super View, t> assign) {
        View view2 = (View) C1173v.p(this.background, this.agent, this.foreground, this.bubble).get(zIndex);
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        assign.invoke(view);
        if (view.getParent() != this) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            addView(view, layoutParams2);
        }
        e();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.view.View r9, android.graphics.Rect r10, int r11, int r12) {
        /*
            r8 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1
            int r0 = v9.C5685n.f(r0, r1)
            int r2 = r9.getMeasuredHeight()
            int r2 = v9.C5685n.f(r2, r1)
            float r3 = r8.bubbleSpacingDp
            android.content.res.Resources r4 = r8.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r1 = android.util.TypedValue.applyDimension(r1, r3, r4)
            int r1 = (int) r1
            int r3 = r10.left
            int r4 = r10.top
            int r5 = r10.width()
            int r10 = r10.height()
            com.stepos.agentsprite.view.BubblePlacement r6 = r8.bubblePlacement
            int[] r7 = com.stepos.agentsprite.view.SceneView.a.f23487a
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 0
            switch(r6) {
                case 1: goto L7f;
                case 2: goto L83;
                case 3: goto L7d;
                case 4: goto L76;
                case 5: goto L6e;
                case 6: goto L63;
                case 7: goto L69;
                case 8: goto L61;
                case 9: goto L40;
                default: goto L3a;
            }
        L3a:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L40:
            android.view.ViewGroup$LayoutParams r3 = r9.getLayoutParams()
            boolean r5 = r3 instanceof android.widget.FrameLayout.LayoutParams
            if (r5 == 0) goto L4b
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            goto L4c
        L4b:
            r3 = 0
        L4c:
            if (r3 == 0) goto L5e
            int r5 = r3.gravity
            r6 = -1
            if (r5 != r6) goto L55
            r5 = 17
        L55:
            int r6 = r8.h(r5, r11, r0, r3)
            int r3 = r8.i(r5, r12, r2, r3)
            goto L88
        L5e:
            r3 = r7
            r6 = r3
            goto L88
        L61:
            int r3 = r3 + r5
            int r3 = r3 - r0
        L63:
            int r5 = r4 + r10
            int r5 = r5 + r1
        L66:
            r6 = r3
            r3 = r5
            goto L88
        L69:
            int r5 = r5 - r0
            int r5 = r5 / 2
            int r3 = r3 + r5
            goto L63
        L6e:
            int r3 = r3 + r5
            int r3 = r3 + r1
            int r5 = r10 - r2
            int r5 = r5 / 2
        L74:
            int r5 = r5 + r4
            goto L66
        L76:
            int r3 = r3 - r0
            int r3 = r3 - r1
            int r5 = r10 - r2
            int r5 = r5 / 2
            goto L74
        L7d:
            int r3 = r3 + r5
            int r3 = r3 - r0
        L7f:
            int r5 = r4 - r2
            int r5 = r5 - r1
            goto L66
        L83:
            int r5 = r5 - r0
            int r5 = r5 / 2
            int r3 = r3 + r5
            goto L7f
        L88:
            com.stepos.agentsprite.view.BubblePlacement r8 = r8.bubblePlacement
            com.stepos.agentsprite.view.BubblePlacement r5 = com.stepos.agentsprite.view.BubblePlacement.Overlay
            if (r8 == r5) goto La6
            if (r3 >= 0) goto L93
            int r10 = r10 + r4
            int r3 = r10 + r1
        L93:
            int r8 = r3 + r2
            if (r8 <= r12) goto L9a
            int r4 = r4 - r2
            int r4 = r4 - r1
            r3 = r4
        L9a:
            if (r6 >= 0) goto L9d
            goto L9e
        L9d:
            r7 = r6
        L9e:
            int r8 = r7 + r0
            if (r8 <= r11) goto La5
            int r6 = r11 - r0
            goto La6
        La5:
            r6 = r7
        La6:
            int r0 = r0 + r6
            int r2 = r2 + r3
            r9.layout(r6, r3, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentsprite.view.SceneView.k(android.view.View, android.graphics.Rect, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int i10 = right - left;
        int i11 = bottom - top;
        View view = this.background;
        if (view != null) {
            p(view, i10, i11);
        }
        View view2 = this.foreground;
        if (view2 != null) {
            p(view2, i10, i11);
        }
        View view3 = this.agent;
        if (view3 == null) {
            return;
        }
        Rect rectG = g(view3, i10, i11);
        View view4 = this.bubble;
        if (view4 != null) {
            k(view4, rectG, i10, i11);
        }
    }

    public final void p(View v10, int w10, int h10) {
        v10.layout(0, 0, w10, h10);
    }

    public final void setAgentSlot(View view) {
        p.i(view, "view");
        j(1, view, new InterfaceC5074l() { // from class: N4.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SceneView.l(this.f4831a, (View) obj);
            }
        });
    }

    public final void setBackgroundSlot(View view) {
        p.i(view, "view");
        j(0, view, new InterfaceC5074l() { // from class: N4.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SceneView.m(this.f4834a, (View) obj);
            }
        });
    }

    public final void setBubblePlacement(BubblePlacement value) {
        p.i(value, "value");
        this.bubblePlacement = value;
        requestLayout();
    }

    public final void setBubbleSlot(View view) {
        p.i(view, "view");
        j(3, view, new InterfaceC5074l() { // from class: N4.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SceneView.n(this.f4832a, (View) obj);
            }
        });
    }

    public final void setBubbleSpacingDp(float f10) {
        this.bubbleSpacingDp = f10;
        requestLayout();
    }

    public final void setForegroundSlot(View view) {
        p.i(view, "view");
        j(2, view, new InterfaceC5074l() { // from class: N4.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SceneView.o(this.f4833a, (View) obj);
            }
        });
    }

    public /* synthetic */ SceneView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new FrameLayout.LayoutParams(getContext(), attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.bubblePlacement = BubblePlacement.AboveCenter;
        this.bubbleSpacingDp = 8.0f;
    }
}
