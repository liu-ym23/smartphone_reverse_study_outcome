package com.bytedanceos.appstore.buss.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedanceos.appstore.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/MaxHeightRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "a", "I", "maxHeight", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MaxHeightRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9056a;

    public MaxHeightRelativeLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MaxHeightRelativeLayout);
        q.f(r12, "obtainStyledAttributes(...)");
        this.f9056a = r12.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = this.f9056a;
        if (r12 <= 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r10, r11);
    }
}
