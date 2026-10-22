package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/ExtendedHotAreaCheckBox;", "Landroid/widget/FrameLayout;", "", "isChecked", "", "setChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "callback", "setOnCheckStatusChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtendedHotAreaCheckBox extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckBox f165182a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtendedHotAreaCheckBox f165183a;

        public a(ExtendedHotAreaCheckBox r100) {
            this.f165183a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CheckBox r100 = this.f165183a.f165182a;     // Catch: Throwable -> L7
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L7
            if (r101 == null) goto L6;
            FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;     // Catch: Throwable -> L7
            r102.gravity = 17;     // Catch: Throwable -> L7
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
            r100.setLayoutParams(r102);     // Catch: Throwable -> L7
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public ExtendedHotAreaCheckBox(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExtendedHotAreaCheckBox(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
    L9:
        performClick();
        return true;
    L5:
        if (r100.getAction() != 1) goto L9;
        if (this.f165182a.isEnabled() == false) goto L9;
        CheckBox r101 = this.f165182a;
        r101.setChecked(!r101.isChecked());
        goto L9
    }

    public final void setChecked(boolean r100) {
        this.f165182a.setChecked(r100);
    }

    public final void setOnCheckStatusChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        this.f165182a.setOnCheckedChangeListener(r100);
    }

    public ExtendedHotAreaCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        th.a.c(r100, R.layout.shopping_extended_area_check_box, this, true);
        this.f165182a = (CheckBox) findViewById(R.id.check_box);
        post(new a(this));
    }

    public /* synthetic */ ExtendedHotAreaCheckBox(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
