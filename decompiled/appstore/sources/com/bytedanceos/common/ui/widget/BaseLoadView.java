package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;

/* JADX INFO: loaded from: classes2.dex */
public class BaseLoadView extends RelativeLayout {
    private static final int LINE_HEIGHT = 2;
    private static final int LOAD_VIEW_HEIGHT = 0;
    public static final int TYPE_LOADING = 1;
    public static final int TYPE_RETRY = 0;
    private ProgressBar mProgressBar;
    private TextView mTextView;

    static {
        LOAD_VIEW_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.LOAD_MORE_HEIGHT);
    }

    public BaseLoadView(Context r10) {
        this(r10, null);
    }

    private void addLine() {
        ImageView r10 = new ImageView(getContext());
        r10.setImageResource(R$drawable.line);
        r10.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-1, -2);
        r11.addRule(10);
        addView(r10, r11);
    }

    private void addProgressView() {
        if (this.mProgressBar != null) goto L6;
        ProgressBar r10 = new ProgressBar(getContext());
        this.mProgressBar = r10;
        r10.setId(R$id.footer_progress_bar);
        int r11 = getResources().getDimensionPixelSize(R$dimen.footer_progress_bar_width);
        int r12 = getResources().getDimensionPixelSize(R$dimen.footer_progress_bar_margin_right);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(r11, r11);
        r13.rightMargin = r12;
        r13.addRule(15);
        r13.addRule(0, R$id.footer_text);
        addView(this.mProgressBar, r13);
        return;
    }

    private void addTextView() {
        if (this.mTextView != null) goto L6;
        TextView r10 = new TextView(getContext());
        this.mTextView = r10;
        r10.setId(R$id.footer_text);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -2);
        r11.addRule(13);
        addView(this.mTextView, r11);
        this.mTextView.setGravity(17);
        this.mTextView.setTextColor(getContext().getResources().getColor(R$color.footer_text));
        this.mTextView.setTextSize(2, 13.5f);
        return;
    }

    private int getTipStringId(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return R$string.listview_footer_hint_end;
    L8:
        return R$string.listview_footer_hint_normal;
    L10:
        return R$string.listview_footer_hint_ready;
    }

    private void init() {
        initSelf();
        addTextView();
        addProgressView();
        addLine();
    }

    private void initSelf() {
        setBackgroundResource(R$drawable.app_list_selector);
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-1, LOAD_VIEW_HEIGHT);
        r10.topMargin = 2;
        setLayoutParams(r10);
    }

    private void setProgressVisible(boolean r10) {
        ProgressBar r11 = this.mProgressBar;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    private void setTextVisible(boolean r10) {
        TextView r11 = this.mTextView;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public void setLoadType(int r10) {
        if (r10 == 0) goto L7;
        if (r10 != 1) goto L10;
        setTextVisible(true);
        setProgressVisible(true);
        this.mTextView.setText(getTipStringId(r10));
        return;
    L10:
        return;
    L7:
        setTextVisible(true);
        setProgressVisible(false);
        this.mTextView.setText(getTipStringId(r10));
    }

    public BaseLoadView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BaseLoadView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        init();
    }
}
