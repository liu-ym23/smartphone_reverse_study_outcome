package com.android.contacts.calllog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetailsViews;
import com.android.contacts.R;
import com.android.contacts.calllog.record.SuggestionMaxWidthTextView;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes.dex */
public final class CallLogListItemViews extends RelativeLayout {
    public TextView blockedLabel;
    public ImageView callIcon;
    public OCheckBox checkBoxFrame;
    public TextView dataView;
    public View dividerView;
    public LinearLayout infoContainer;
    public TextView name;
    public PhoneCallDetailsViews phoneCallDetailsViews;
    public View primaryActionView;
    public ImageView recordIcon;
    public ImageView secondaryActionView;
    public ImageView simIcon;
    public SuggestionMaxWidthTextView summaryText;
    public ImageView videoIcon;
    public TextView viewRecord;

    public CallLogListItemViews(Context r1) {
        super(r1);
    }

    public CallLogListItemViews(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.primaryActionView = findViewById(R.id.primary_action_view);
        this.secondaryActionView = (ImageView) findViewById(R.id.secondary_action_icon);
        this.dividerView = findViewById(R.id.divider);
        this.phoneCallDetailsViews = PhoneCallDetailsViews.fromView(this);
        this.dataView = (TextView) findViewById(R.id.call_count_and_date);
        this.name = (TextView) findViewById(R.id.name);
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        this.simIcon = (ImageView) findViewById(R.id.sim_id_icon);
    L5:
        this.viewRecord = (TextView) findViewById(R.id.view_record);
        this.videoIcon = (ImageView) findViewById(R.id.video_icon);
        this.blockedLabel = (TextView) findViewById(R.id.blocked_label);
        this.recordIcon = (ImageView) findViewById(R.id.iv_record_icon);
        this.summaryText = (SuggestionMaxWidthTextView) findViewById(R.id.tv_item_summary);
        this.callIcon = (ImageView) findViewById(R.id.ic_call);
        this.infoContainer = (LinearLayout) findViewById(R.id.call_info_container);
    }

    public void inflateCheckBoxFrame() {
        this.checkBoxFrame = (OCheckBox) findViewById(R.id.checkBoxStub);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        View r6 = this.dividerView;
        if (this.primaryActionView == null) goto L9;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getHeight() != 0) goto L11;
        int r0 = this.primaryActionView.getMeasuredHeight();
        r6.setBottom(r6.getTop() + r0);
        return;
    L11:
        return;
    }
}
