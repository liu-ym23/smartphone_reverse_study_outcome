package com.bytedanceos.common.ui.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$string;

/* JADX INFO: loaded from: classes2.dex */
public class FooterView extends TextView {
    private static final int PADDING_TOP = 0;

    static {
        PADDING_TOP = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.footer_text_padding_top);
    }

    public FooterView(Context r10) {
        this(r10, null);
    }

    private void init() {
        setPadding(0, PADDING_TOP, 0, 0);
        setGravity(1);
        setTextColor(getContext().getResources().getColor(R$color.footer_text));
        setTextSize(2, 13.5f);
        setBackgroundResource(R.color.transparent);
        showTips();
    }

    public void hideTips() {
        setText(null);
    }

    public void showTips() {
        setText(R$string.listview_footer_hint_end);
    }

    public FooterView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public FooterView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        init();
    }
}
