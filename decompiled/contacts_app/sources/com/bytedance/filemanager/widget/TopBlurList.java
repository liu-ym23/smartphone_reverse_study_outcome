package com.bytedance.filemanager.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/filemanager/widget/TopBlurList;", "", "blurHeight", "", "getBlurHeight", "()I", "container", "Lcom/bytedance/filemanager/widget/TopBlurListContainer;", "getContainer", "()Lcom/bytedance/filemanager/widget/TopBlurListContainer;", "needDrawExtra", "", "getNeedDrawExtra", "()Z", "drawExtra", "", "canvas", "Landroid/graphics/Canvas;", "reMeasure", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TopBlurList {

    /* JADX INFO: compiled from: TopBlurView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void drawExtra(TopBlurList r0, Canvas r1) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TopBlurListContainer getContainer(TopBlurList r2) {
            if ((r2 instanceof View) == false) goto L5;
            View r3 = (View) r2;
        L6:
            if (r3 == null) goto L8;
            ViewParent r4 = r3.getParent();
        L10:
            if ((r4 instanceof TopBlurListContainer) == true) goto L12;
            return null;
        L12:
            return (TopBlurListContainer) r4;
        L8:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        public static int getBlurHeight(TopBlurList r0) {
            TopBlurListContainer r1 = r0.getContainer();
            if (r1 != null) goto L7;
            return 0;
        L7:
            return r1.getBlurHeight();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void reMeasure(TopBlurList r5) {
            if ((r5 instanceof View) == true) goto L5;
            return;
        L5:
            View r0 = (View) r5;
            if (r0.getPaddingTop() == r5.getBlurHeight()) goto L8;
            r0.setPadding(r0.getPaddingLeft(), r5.getBlurHeight(), r0.getPaddingRight(), r0.getPaddingBottom());
        L8:
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        L12:
            if (r2 != null) goto L14;
            return;
        L14:
            if (r2.topMargin == (-r5.getBlurHeight())) goto L18;
            r2.topMargin = -r5.getBlurHeight();
            return;
        L18:
            return;
        L11:
            r2 = null;
            goto L12
        }
    }

    void drawExtra(Canvas r1);

    int getBlurHeight();

    TopBlurListContainer getContainer();

    boolean getNeedDrawExtra();

    void reMeasure();
}
