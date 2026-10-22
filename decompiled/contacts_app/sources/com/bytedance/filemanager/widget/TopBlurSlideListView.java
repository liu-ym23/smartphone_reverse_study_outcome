package com.bytedance.filemanager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.android.contacts.list.SlideListView;
import kotlin.Metadata;

/* JADX INFO: compiled from: TopBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/filemanager/widget/TopBlurSlideListView;", "Lcom/android/contacts/list/SlideListView;", "Lcom/bytedance/filemanager/widget/TopBlurList;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "needDrawExtra", "", "getNeedDrawExtra", "()Z", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopBlurSlideListView extends SlideListView implements TopBlurList {
    @Override // com.bytedance.filemanager.widget.TopBlurList
    public boolean getNeedDrawExtra() {
        return false;
    }

    @Override // com.bytedance.filemanager.widget.TopBlurList
    public void drawExtra(Canvas r1) {
        TopBlurList.DefaultImpls.drawExtra(this, r1);
    }

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

    public TopBlurSlideListView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r1, int r2) {
        reMeasure();
        super.onMeasure(r1, r2);
    }
}
