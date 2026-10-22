package com.bytedance.filemanager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tH\u0014R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/filemanager/widget/TopBlurHeadersListView;", "Lcom/android/contacts/PinnedHeaderList/HeadersListView;", "Lcom/bytedance/filemanager/widget/TopBlurList;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "needDrawExtra", "", "getNeedDrawExtra", "()Z", "drawExtra", "", "canvas", "Landroid/graphics/Canvas;", "drawHeader", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "setMyClippingToPadding", "clipToPadding", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopBlurHeadersListView extends HeadersListView implements TopBlurList {
    @Override // com.bytedance.filemanager.widget.TopBlurList
    public int getBlurHeight() {
        return TopBlurList.DefaultImpls.getBlurHeight(this);
    }

    @Override // com.bytedance.filemanager.widget.TopBlurList
    public TopBlurListContainer getContainer() {
        return TopBlurList.DefaultImpls.getContainer(this);
    }

    @Override // com.bytedance.filemanager.widget.TopBlurList
    public void reMeasure() {
        TopBlurList.DefaultImpls.reMeasure(this);
    }

    public TopBlurHeadersListView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r1, int r2) {
        reMeasure();
        super.onMeasure(r1, r2);
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersListView
    protected void setMyClippingToPadding(boolean r1) {
        super.setMyClippingToPadding(true);
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersListView
    protected void drawHeader(Canvas r1) {
        if (canDrawHeader() == false) goto L8;
        TopBlurListContainer r0 = getContainer();
        if (r0 == null) goto L9;
        r0.invalidate();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.filemanager.widget.TopBlurList
    public boolean getNeedDrawExtra() {
        return canDrawHeader();
    }

    @Override // com.bytedance.filemanager.widget.TopBlurList
    public void drawExtra(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.drawHeader(r2);
    }
}
