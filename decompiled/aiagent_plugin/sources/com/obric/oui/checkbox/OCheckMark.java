package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OCheckMark.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OCheckMark extends AppCompatImageView implements Checkable {
    private boolean isChecked;
    private Drawable markDrawable;

    public OCheckMark(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "attrs");
        super(r5, r6);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r7, "attrs");
        super(r6, r7, r5);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    private final void init() {
        setMinimumWidth(this.markDrawable.getMinimumWidth());
        setMinimumHeight(this.markDrawable.getMinimumHeight());
        setBackgroundDrawable(this.markDrawable);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.isChecked != r2) goto L5;
        return;
    L5:
        this.isChecked = r2;
        if (r2 == false) goto L8;
        Drawable r3 = this.markDrawable;
    L9:
        setBackgroundDrawable(r3);
        invalidate();
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }
}
