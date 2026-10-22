package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/DragLinearLayout;", "Landroid/widget/LinearLayout;", "", "percent", "", "setPosPercent", "", "draggable", "setDraggable", "b", FaceService.girlLabel, "getDifferenceY", "()F", "setDifferenceY", "(F)V", "differenceY", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "getRegionConfirmListener", "()Lkotlin/jvm/functions/Function1;", "setRegionConfirmListener", "(Lkotlin/jvm/functions/Function1;)V", "regionConfirmListener", "", "d", "I", "getBottomEdget", "()I", "setBottomEdget", "(I)V", "bottomEdget", "getTransLationSpace", "transLationSpace", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DragLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f144895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f144896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Float, Unit> f144897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f144898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f144899e;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragLinearLayout f144900a;

        public a(DragLinearLayout r100) {
            this.f144900a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            DragLinearLayout r102 = this.f144900a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            if (r101 == null) goto L39;
            r102.onTouchEvent(r101);
            int r103 = r101.getAction();
            if (r103 == 0) goto L28;
            if (r103 != 1) goto L9;
        L25:
            Function1<? super Float, Unit> r104 = r102.f144897c;
            if (r104 == null) goto L39;
            r104.invoke(Float.valueOf(r102.getTranslationY() / r102.getTransLationSpace()));
            goto L39
        L9:
            if (r103 == 2) goto L14;
            if (r103 == 3) goto L25;
        L14:
            if (r102.f144899e == false) goto L39;
            r102.f144896b = r101.getRawY() - r102.f144895a;
            r102.f144895a = r101.getRawY();
            float r105 = (r102.getY() + r102.getHeight()) + r102.f144896b;
            int r106 = r102.f144898d;
            if (r105 <= r106) goto L19;
            if (r106 <= 0) goto L19;
            r102.setY(r106 - r102.getHeight());
        L19:
            float r107 = 0;
            if (r102.getTranslationY() <= r107) goto L22;
        L24:
            r102.setTranslationY(r102.getTranslationY() + r102.f144896b);
            goto L39
        L22:
            if (r102.f144896b >= r107) goto L24;
            r102.setTranslationY(0.0f);
            goto L39
        L28:
            r102.getY();
            r100.getParent().requestDisallowInterceptTouchEvent(true);
            ViewParent r108 = r100.getParent();
        L29:
            boolean r109 = r108 instanceof cs1.a;
            if (r109 == true) goto L36;
            if (r108 == null) goto L33;
            ViewParent r110 = r108.getParent();
        L34:
            if (r110 == null) goto L36;
            r108 = r108.getParent();
            goto L29
        L33:
            r110 = null;
        L36:
            if (r109 == false) goto L38;
            ((cs1.a) r108).setDisallowInterceptOnce(true);
        L38:
            r102.f144895a = r101.getRawY();
        L39:
            return true;
        }
    }

    public final void a() {
        UtilityKotlinExtentionsKt.s(0, false, true, new DragLinearLayout$checkLayoutPosition$1(this), 3);
    }

    public final int getTransLationSpace() {
        Integer r100 = Integer.valueOf((this.f144898d - getTop()) - getHeight());
        if (r100.intValue() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return r100.intValue();
    L5:
        r101 = false;
        goto L6
    }

    public final int getBottomEdget() {
        return this.f144898d;
    }

    public final float getDifferenceY() {
        return this.f144896b;
    }

    public final Function1<Float, Unit> getRegionConfirmListener() {
        return this.f144897c;
    }

    public final void setBottomEdget(int r100) {
        this.f144898d = r100;
    }

    public final void setDifferenceY(float r100) {
        this.f144896b = r100;
    }

    public final void setDraggable(boolean r100) {
        this.f144899e = r100;
    }

    public final void setPosPercent(float r100) {
        double r101 = r100;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return;
    L5:
        if (r101 > 1.0d) goto L9;
        setTranslationY(getTransLationSpace() * r100);
        return;
    }

    public final void setRegionConfirmListener(Function1<? super Float, Unit> r100) {
        this.f144897c = r100;
    }

    public DragLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        setOnTouchListener(new a(this));
    }
}
