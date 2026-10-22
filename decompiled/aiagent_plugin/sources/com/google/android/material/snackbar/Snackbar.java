package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f13607d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f13608e = null;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.Snackbar$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ Snackbar this$0;
        final /* synthetic */ View.OnClickListener val$listener;

        AnonymousClass1(Snackbar r3, View.OnClickListener r4) {
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.val$listener = r5;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            this.val$listener.onClick(r2);
            this.this$0.a(1);
        }
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable r1) {
            super.setBackground(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable r1) {
            super.setBackgroundDrawable(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList r1) {
            super.setBackgroundTintList(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode r1) {
            super.setBackgroundTintMode(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams r1) {
            super.setLayoutParams(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* synthetic */ void setOnClickListener(View.OnClickListener r3) {
            super.setOnClickListener((View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin"));
        }

        public SnackbarLayout(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        }

        public SnackbarLayout(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int r6, int r7) {
            super.onMeasure(r6, r7);
            int r8 = getChildCount();
            int r9 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L8;
            View r1 = getChildAt(r0);
            if (r1.getLayoutParams().width != (-1)) goto L7;
            r1.measure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), View.MeasureSpec.makeMeasureSpec(r1.getMeasuredHeight(), 1073741824));
        L7:
            r0 = r0 + 1;
            goto L3
        }
    }

    static {
        f13607d = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarButtonStyle, "attr", "snackbarButtonStyle")};
        f13608e = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarButtonStyle, "attr", "snackbarButtonStyle"), ZeusTransformUtils.mapRes(R.attr.snackbarTextViewStyle, "attr", "snackbarTextViewStyle")};
    }
}
