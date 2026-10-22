package com.android.contacts.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.util.BytedanceApi;

/* JADX INFO: loaded from: classes2.dex */
public class Titlebar extends RelativeLayout {
    private static final int DEVIATION = 4;
    public static final String EXTRA_BACK_BTN_RES_ID = "back_text_id";
    public static final String EXTRA_BACK_BTN_TEXT = "back_text";
    private static int MAX_BACK_BTN_WIDTH = 305;
    private int backBtnBgWidth;
    private TextView mBackButton;
    private View mPlaceHolderView;
    private TextView mTitle;
    private int screenWidth;

    static {
    }

    public Titlebar(Context r1) {
        super(r1);
    }

    public Titlebar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public Titlebar(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(R.layout.contacts_setting_titlebar, this, true);
        this.mTitle = (TextView) r5.findViewById(R.id.title);
        this.mBackButton = (TextView) r5.findViewById(R.id.btn_back);
        this.mPlaceHolderView = r5.findViewById(R.id.place_holder);
        this.screenWidth = r2.getResources().getDisplayMetrics().widthPixels;
        this.backBtnBgWidth = getResources().getDrawable(R.drawable.btn_back_in_setting).getIntrinsicWidth() - 4;
    }

    private void setTitleAlign() {
        float r0 = Math.min(caculateTextWidth(this.mBackButton), MAX_BACK_BTN_WIDTH - this.backBtnBgWidth) + this.backBtnBgWidth;
        if ((this.screenWidth - (2.0f * r0)) <= (caculateTextWidth(this.mTitle) + 5.0f)) goto L5;
        this.mPlaceHolderView.setMinimumWidth((int) r0);
        this.mTitle.setGravity(17);
    L6:
        BytedanceApi.setMaxTextSize(this.mBackButton, getResources().getDimensionPixelSize(R.dimen.title_back_max_size));
        return;
    L5:
        this.mTitle.setGravity(3);
        this.mTitle.setPadding(10, 0, 0, 0);
        this.mPlaceHolderView.setMinimumWidth(20);
        goto L6
    }

    private float caculateTextWidth(TextView r2) {
        Paint r1 = new Paint();
        r1.setTextSize(r2.getTextSize());
        if (r2.getText() != null) goto L7;
        return 0.0f;
    L7:
        return r1.measureText(r2.getText().toString());
    }

    public void setTitle(CharSequence r2) {
        this.mTitle.setText(r2);
        setTitleAlign();
    }

    public TextView getCancelButton() {
        return this.mBackButton;
    }

    public void setBackButtonTextByIntent(Intent r3) {
        if (r3 == null) goto L8;
        String r0 = r3.getStringExtra("back_text");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        setBackButtonText(r0);
        return;
    L6:
        setBackButtonText(r3.getIntExtra("back_text_id", -1));
        return;
    }

    public void setBackButtonText(int r3) {
        TextView r0 = this.mBackButton;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L9;
        r0.setText(r3);
        setTitleAlign();
        return;
    }

    public void setBackButtonText(CharSequence r2) {
        TextView r0 = this.mBackButton;
        if (r0 == null) goto L6;
        r0.setText(r2);
        setTitleAlign();
        return;
    }

    public void setBackButtonListener(View.OnClickListener r1) {
        this.mBackButton.setOnClickListener(r1);
    }
}
