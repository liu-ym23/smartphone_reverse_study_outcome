package com.android.contacts.calllog;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class CallDetailHistoryAdapter extends BaseAdapter {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_HISTORY_ITEM = 1;
    private final CallTypeHelper mCallTypeHelper;
    private final Context mContext;
    private final View mControls;
    private View.OnFocusChangeListener mHeaderFocusChangeListener;
    private final LayoutInflater mLayoutInflater;
    private final PhoneCallDetails[] mPhoneCallDetails;
    private final boolean mShowCallAndSms;
    private final boolean mShowVoicemail;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        if (r1 != 0) goto L6;
        return -1;
    L6:
        return r1 - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    static /* synthetic */ View access$000(CallDetailHistoryAdapter r0) {
        return r0.mControls;
    }

    public CallDetailHistoryAdapter(Context r2, LayoutInflater r3, CallTypeHelper r4, PhoneCallDetails[] r5, boolean r6, boolean r7, View r8) {
        this.mHeaderFocusChangeListener = new AnonymousClass1(this);
        this.mContext = r2;
        this.mLayoutInflater = r3;
        this.mCallTypeHelper = r4;
        this.mPhoneCallDetails = r5;
        this.mShowVoicemail = r6;
        this.mShowCallAndSms = r7;
        this.mControls = r8;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mPhoneCallDetails.length + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        if (r1 != 0) goto L6;
        return null;
    L6:
        return this.mPhoneCallDetails[r1 - 1];
    }

    @Override // android.widget.Adapter
    public View getView(int r13, View r14, ViewGroup r15) {
        int r1 = 8;
        if (r13 != 0) goto L15;
        if (r14 != null) goto L6;
        r14 = this.mLayoutInflater.inflate(R.layout.call_detail_history_header, r15, false);
    L6:
        View r16 = r14.findViewById(R.id.header_voicemail_container);
        if (this.mShowVoicemail == false) goto L9;
        int r17 = 0;
    L10:
        r16.setVisibility(r17);
        View r18 = r14.findViewById(R.id.header_call_and_sms_container);
        if (this.mShowCallAndSms == false) goto L13;
        r1 = 0;
    L13:
        r18.setVisibility(r1);
        r14.setFocusable(true);
        r14.setOnFocusChangeListener(this.mHeaderFocusChangeListener);
        return r14;
    L9:
        r17 = 8;
        goto L10
    L15:
        if (r14 != null) goto L17;
        r14 = this.mLayoutInflater.inflate(R.layout.call_detail_history_item, r15, false);
    L17:
        PhoneCallDetails r19 = this.mPhoneCallDetails[r13 - 1];
        CallTypeIconsView r110 = (CallTypeIconsView) r14.findViewById(R.id.call_type_icon);
        TextView r0 = (TextView) r14.findViewById(R.id.call_type_text);
        TextView r3 = (TextView) r14.findViewById(R.id.date);
        TextView r4 = (TextView) r14.findViewById(R.id.duration);
        int r5 = r19.callTypes[0];
        r110.clear();
        r110.add(r5);
        r0.setText(this.mCallTypeHelper.getCallTypeText(r5));
        r3.setText(DateUtils.formatDateRange(this.mContext, r19.date, r19.date, 23));
        if (r5 != 3) goto L20;
    L23:
        r4.setVisibility(8);
    L24:
        return r14;
    L20:
        if (r5 == 4) goto L23;
        r4.setVisibility(0);
        r4.setText(formatDuration(r19.duration));
        goto L24
    }

    private String formatDuration(long r5) {
        if (r5 < 60) goto L5;
        long r2 = r5 / 60;
        r5 = r5 - (60 * r2);
    L7:
        return this.mContext.getString(R.string.callDetailsDurationFormatMinutes, new Object[]{Long.valueOf(r2), Long.valueOf(r5)});
    L5:
        r2 = 0;
        goto L7
    }
}
