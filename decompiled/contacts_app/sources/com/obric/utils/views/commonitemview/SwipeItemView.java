package com.obric.utils.views.commonitemview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.obric.oui.button.OIconButton;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SwipeItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0002J \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J,\u0010\u0014\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/utils/views/commonitemview/SwipeItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentBtnList", "", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "bindButtonData", "", "btn", "Lcom/obric/oui/button/OIconButton;", "item", "index", "", "listSize", "swipeListener", "Lkotlin/Function1;", "getSwipeItemList", "swipeBtnList", "setSwipeItemButtonView", "Landroid/view/ViewGroup;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeItemView extends LinearLayout {
    private List<? extends SwipeItemButtonType> currentBtnList;

    /* JADX INFO: compiled from: SwipeItemView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            r0[SwipeItemButtonType.SWIPE_PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[SwipeItemButtonType.SWIPE_PHONE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[SwipeItemButtonType.SWIPE_PHONE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[SwipeItemButtonType.SWIPE_STAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[SwipeItemButtonType.SWIPE_UNSTAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[SwipeItemButtonType.SWIPE_DELETE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[SwipeItemButtonType.SWIPE_MESSAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[SwipeItemButtonType.SWIPE_RESTORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[SwipeItemButtonType.SWIPE_EDIT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$HM4iTBdd7nuaVJ_d5AJrnXTEcBQ(Function1 r0, View r1) {
        bindButtonData$lambda$2(r0, r1);
    }

    public SwipeItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setOrientation(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewGroup setSwipeItemButtonView$default(SwipeItemView r0, List r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.setSwipeItemButtonView(r1, r2);
    }

    public final ViewGroup setSwipeItemButtonView(List<? extends SwipeItemButtonType> r12, Function1<? super SwipeItemButtonType, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "swipeBtnList");
        List<SwipeItemButtonType> r14 = getSwipeItemList(r12);
        int r1 = 0;
        if (r14 != null) goto L5;
    L18:
        this.currentBtnList = r14;
        removeAllViews();
        if (r14 == null) goto L24;
        Iterator<T> r2 = r14.iterator();
        int r9 = 0;
    L22:
        if (r2.hasNext() == false) goto L24;
        SwipeItemButtonType r5 = (SwipeItemButtonType) r2.next();
        View r3 = LayoutInflater.from(getContext()).inflate(R.layout.item_swip_btn, null, false);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.oui.button.OIconButton");
        OIconButton r10 = (OIconButton) r3;
        bindButtonData(r10, r5, r9, r14.size(), r13);
        addView(r10);
        r9 = r9 + 1;
    L24:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-1, -1);
        r15.gravity = 16;
        setLayoutParams(r15);
        return this;
    L5:
        if (r14.size() != getChildCount()) goto L18;
        Iterator<T> r4 = r14.iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        SwipeItemButtonType r6 = (SwipeItemButtonType) r4.next();
        View r7 = getChildAt(r1);
        if ((r7 instanceof OIconButton) == false) goto L12;
        OIconButton r8 = (OIconButton) r7;
    L13:
        if (r8 == null) goto L15;
        bindButtonData(r8, r6, r1, r14.size(), r13);
    L15:
        r1 = r1 + 1;
        goto L8
    L12:
        r8 = null;
        goto L13
    L16:
        this.currentBtnList = r14;
        return this;
    }

    private final void bindButtonData(OIconButton r4, SwipeItemButtonType r5, int r6, int r7, final Function1<? super SwipeItemButtonType, Unit> r8) {
        r4.setImageResource(r5.getDrawable());
        r4.setImageTintList(ContextCompat.getColorStateList(getContext(), r5.getColor()));
        r4.setOnClickListener(new SwipeItemView$$ExternalSyntheticLambda0(r8));
        r4.setTag(r5);
        ViewGroup.LayoutParams r3 = r4.getLayoutParams();
        if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r3;
    L7:
        if (r9 != null) goto L10;
        float r0 = 40;
        r9 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())));
        r9.gravity = 16;
    L10:
        if (r6 != 0) goto L12;
        float r10 = 16;
        DisplayMetrics r1 = Resources.getSystem().getDisplayMetrics();
    L13:
        r9.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r10, r1)));
        if (r6 != (r7 - 1)) goto L16;
        float r11 = 8;
        DisplayMetrics r12 = Resources.getSystem().getDisplayMetrics();
    L17:
        r9.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12)));
        r4.setLayoutParams(r9);
        return;
    L16:
        r11 = 0;
        r12 = Resources.getSystem().getDisplayMetrics();
        goto L17
    L12:
        r10 = 8;
        r1 = Resources.getSystem().getDisplayMetrics();
        goto L13
    L5:
        r9 = null;
        goto L7
    }

    private static final void bindButtonData$lambda$2(Function1 r1, View r2) {
        if (r1 == null) goto L5;
        Object r3 = r2.getTag();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.utils.views.commonitemview.bean.SwipeItemButtonType");
        r1.invoke((SwipeItemButtonType) r3);
        return;
    }

    private final List<SwipeItemButtonType> getSwipeItemList(List<? extends SwipeItemButtonType> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r3 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L22;
        SwipeItemButtonType r0 = (SwipeItemButtonType) r5.next();
        switch(WhenMappings.$EnumSwitchMapping$0[r0.ordinal()]) {
            case 1: goto L19;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L11;
            default: goto L7;
        };
    L11:
        r3.add(r0);
        goto L7
    L13:
        if (DSUtils.useDSFeature() == false) goto L7;
        r3.add(r0);
        goto L7
    L16:
        if (DSUtils.useDSFeature() == false) goto L7;
        r3.add(r0);
        goto L7
    L19:
        if (DSUtils.useDSFeature() == true) goto L7;
        r3.add(r0);
        goto L7
    L22:
        return r3;
    }
}
