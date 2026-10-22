package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDetailTabBar extends LinearLayout implements View.OnClickListener {
    public static final int TAB_MAIL = 1;
    public static final int TAB_MESSAGE = 0;
    private TextView mBtnMail;
    private TextView mBtnMessage;
    private OnGroupDetailTabClickListener mListener;

    public interface OnGroupDetailTabClickListener {
        void onTabOnclicked(int r1);
    }

    public GroupDetailTabBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        LayoutInflater.from(r1).inflate(R.layout.group_detail_tabs_layout, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBtnMessage = (TextView) findViewById(R.id.message);
        this.mBtnMail = (TextView) findViewById(R.id.mail);
        this.mBtnMessage.setOnClickListener(this);
        this.mBtnMail.setOnClickListener(this);
    }

    public void setMessageTabText(String r1) {
        this.mBtnMessage.setText(r1);
    }

    public void setMailTabText(String r1) {
        this.mBtnMail.setText(r1);
    }

    public void setMessageTabText(int r1) {
        this.mBtnMessage.setText(r1);
    }

    public void setMailTabText(int r1) {
        this.mBtnMail.setText(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.mail) goto L5;
        callTabListener(1);
        return;
    L5:
        if (r3 != R.id.message) goto L11;
        callTabListener(0);
        return;
    }

    public void setOnGroupDetailTabClickListener(OnGroupDetailTabClickListener r1) {
        this.mListener = r1;
    }

    private void callTabListener(int r1) {
        OnGroupDetailTabClickListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onTabOnclicked(r1);
        return;
    }
}
