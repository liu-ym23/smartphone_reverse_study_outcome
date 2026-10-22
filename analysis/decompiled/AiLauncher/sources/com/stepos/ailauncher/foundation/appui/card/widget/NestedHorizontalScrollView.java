package com.stepos.ailauncher.foundation.appui.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/widget/NestedHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "touchSlop", "gestureAxis", "Lcom/stepos/ailauncher/foundation/appui/card/widget/NestedHorizontalScrollView$GestureAxis;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "GestureAxis", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NestedHorizontalScrollView extends HorizontalScrollView {
    private float downX;
    private float downY;
    private GestureAxis gestureAxis;
    private final int touchSlop;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/widget/NestedHorizontalScrollView$GestureAxis;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "HORIZONTAL", "VERTICAL", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GestureAxis {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GestureAxis[] $VALUES;
        public static final GestureAxis UNKNOWN = new GestureAxis("UNKNOWN", 0);
        public static final GestureAxis HORIZONTAL = new GestureAxis("HORIZONTAL", 1);
        public static final GestureAxis VERTICAL = new GestureAxis("VERTICAL", 2);

        private static final /* synthetic */ GestureAxis[] $values() {
            return new GestureAxis[]{UNKNOWN, HORIZONTAL, VERTICAL};
        }

        static {
            GestureAxis[] gestureAxisArr$values = $values();
            $VALUES = gestureAxisArr$values;
            $ENTRIES = kotlin.enums.a.a(gestureAxisArr$values);
        }

        private GestureAxis(String str, int i10) {
        }

        public static InterfaceC4149a<GestureAxis> getEntries() {
            return $ENTRIES;
        }

        public static GestureAxis valueOf(String str) {
            return (GestureAxis) Enum.valueOf(GestureAxis.class, str);
        }

        public static GestureAxis[] values() {
            return (GestureAxis[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GestureAxis.values().length];
            try {
                iArr[GestureAxis.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GestureAxis.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GestureAxis.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r10, r0)
            int r0 = r10.getActionMasked()
            r1 = -1
            r2 = 1
            if (r0 == 0) goto Lbc
            r3 = 0
            if (r0 == r2) goto Lae
            r4 = 3
            r5 = 2
            if (r0 == r5) goto L18
            if (r0 == r4) goto Lae
            goto Le1
        L18:
            float r0 = r10.getX()
            float r6 = r9.downX
            float r0 = r0 - r6
            float r6 = r10.getY()
            float r7 = r9.downY
            float r6 = r6 - r7
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r7 = r9.gestureAxis
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r8 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.GestureAxis.UNKNOWN
            if (r7 != r8) goto L63
            float r7 = java.lang.Math.abs(r0)
            int r8 = r9.touchSlop
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L48
            float r7 = java.lang.Math.abs(r0)
            float r8 = java.lang.Math.abs(r6)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L48
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r6 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.GestureAxis.HORIZONTAL
            r9.gestureAxis = r6
            goto L63
        L48:
            float r7 = java.lang.Math.abs(r6)
            int r8 = r9.touchSlop
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L63
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L63
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r6 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.GestureAxis.VERTICAL
            r9.gestureAxis = r6
        L63:
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r6 = r9.gestureAxis
            int[] r7 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.a.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r7[r6]
            if (r6 == r2) goto L99
            if (r6 == r5) goto L8f
            if (r6 != r4) goto L89
            boolean r0 = r9.canScrollHorizontally(r2)
            if (r0 != 0) goto L7f
            boolean r0 = r9.canScrollHorizontally(r1)
            if (r0 == 0) goto Le1
        L7f:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto Le1
            r0.requestDisallowInterceptTouchEvent(r2)
            goto Le1
        L89:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L8f:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto Le1
            r0.requestDisallowInterceptTouchEvent(r3)
            goto Le1
        L99:
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9f
            goto La0
        L9f:
            r1 = r2
        La0:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto Le1
            boolean r1 = r9.canScrollHorizontally(r1)
            r0.requestDisallowInterceptTouchEvent(r1)
            goto Le1
        Lae:
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r0 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.GestureAxis.UNKNOWN
            r9.gestureAxis = r0
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto Le1
            r0.requestDisallowInterceptTouchEvent(r3)
            goto Le1
        Lbc:
            float r0 = r10.getX()
            r9.downX = r0
            float r0 = r10.getY()
            r9.downY = r0
            com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView$GestureAxis r0 = com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.GestureAxis.UNKNOWN
            r9.gestureAxis = r0
            boolean r0 = r9.canScrollHorizontally(r2)
            if (r0 != 0) goto Ld8
            boolean r0 = r9.canScrollHorizontally(r1)
            if (r0 == 0) goto Le1
        Ld8:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto Le1
            r0.requestDisallowInterceptTouchEvent(r2)
        Le1:
            boolean r9 = super.dispatchTouchEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.gestureAxis = GestureAxis.UNKNOWN;
    }

    public /* synthetic */ NestedHorizontalScrollView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
