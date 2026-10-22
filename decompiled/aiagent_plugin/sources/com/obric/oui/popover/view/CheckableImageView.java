package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CheckableImageView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CheckableImageView extends AppCompatImageView implements Checkable {
    private boolean isChecked;

    public CheckableImageView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.isChecked = r1;
        invalidate();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r2) {
        if (this.isChecked == false) goto L6;
        super.onDraw(r2);
        return;
    }
}
