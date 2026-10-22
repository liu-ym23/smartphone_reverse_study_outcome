package com.android.contacts.detail;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.provider.CallLog;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.bytedance.common.utility.UIUtils;
import com.obric.callsummary.bean.CallSummary;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.utils.commonitemview.CallLogItemCardView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailCallLogView extends LinearLayout implements LongMenuHelper.OnMenuItemClickedListener {
    private static final int LIMIT = 3;
    public static final String TAG = "ContactDetailCallLogView";
    private final int CALL_LOG_MAX_COUNT;
    LongMenuHelper.MenuType[] longMenuItem;
    private LinearLayout mContent;
    private Context mContext;
    private int mInterceptType;
    private OCardListItem mMoreItem;
    private PhoneCallDetails[] mPhoneCallDetails;
    private List<String> mPhoneNumberList;
    private LongMenuHelper menuHelper;

    private class CallLogItem {
        LinearLayout item;
        CallLogItemCardView itemBody;
        ContactsCommonListItem summaryDetail;
        private final ViewGroup summaryParagraph;
        private final TextView summaryText;
        ViewGroup summaryTitleLayout;
        final /* synthetic */ ContactDetailCallLogView this$0;

        public CallLogItem(ContactDetailCallLogView r6, ViewGroup r7) {
            this.this$0 = r6;
            LinearLayout r0 = (LinearLayout) LayoutInflater.from(ContactDetailCallLogView.access$100(r6)).inflate(R.layout.detail_calllog_item, r7, false);
            this.item = r0;
            this.itemBody = (CallLogItemCardView) r0.findViewById(R.id.call_log_details);
            this.summaryDetail = (ContactsCommonListItem) this.item.findViewById(R.id.summary_detail);
            ViewGroup r1 = (ViewGroup) LayoutInflater.from(ContactDetailCallLogView.access$100(r6)).inflate(R.layout.layout_call_summary_detail, null);
            this.summaryTitleLayout = r1;
            this.summaryText = (TextView) r1.findViewById(R.id.tv_call_summary);
            this.summaryParagraph = (ViewGroup) this.summaryTitleLayout.findViewById(R.id.ll_call_content_paragraph);
            this.summaryDetail.setCenterContainer(this.summaryTitleLayout);
            this.summaryDetail.setDisableClick();
            this.summaryDetail.setClickable(false);
            this.summaryDetail.showCustomEnd(false);
            View r2 = this.summaryDetail.findViewById(R.id.content_container);
            if (r2 == null) goto L5;
            r2.setPadding(r2.getPaddingLeft(), r2.getPaddingTop(), 0, r2.getPaddingBottom());
        L5:
            View r3 = this.summaryDetail.findViewById(R.id.title_container);
            if (r3 == null) goto L10;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if (r7.getMeasuredWidth() == 0) goto L10;
            r4.width = r7.getMeasuredWidth() - ((int) UIUtils.dip2Px(r6.getContext(), 40.0f));
            r3.setLayoutParams(r4);
        L10:
            ViewGroup r8 = this.summaryDetail.getItemTitleContainer();
            if (r8 == null) goto L13;
            r8.setPadding(0, 0, 0, 0);
        L13:
            FrameLayout r5 = this.summaryDetail.getCardContainer();
            if (r5 == null) goto L17;
            r5.setPadding(r5.getPaddingLeft(), 0, r5.getPaddingRight(), r5.getPaddingBottom());
            return;
        }

        public boolean updateSummaryView(PhoneCallDetails r10) {
            CallFeatureBean r0 = CallFeatureModel.INSTANCE.getCallFeature(r10.date, String.valueOf(r10.number));
            boolean r2 = false;
            if (r10.duration <= 0) goto L27;
            if (r0 == null) goto L27;
            if (r0.isFeatureCallRecordEnabled() == false) goto L8;
        L9:
            this.summaryDetail.setVisibility(0);
            CallSummary r11 = r0.getSummary();
            if (r11.isEmpty() == true) goto L23;
            this.summaryDetail.setVisibility(0);
            if (TextUtils.isEmpty(r0.getSummary().getSummary()) == false) goto L14;
            this.summaryText.setVisibility(8);
        L16:
            if (r11.getItems().isEmpty() == true) goto L18;
            this.summaryText.setMaxLines(2);
        L18:
            Iterator<String> r1 = r11.getItems().iterator();
        L20:
            if (r1.hasNext() == false) goto L22;
            String r4 = r1.next();
            View r5 = View.inflate(this.this$0.getContext(), R.layout.detail_calllog_content_paragraph, null);
            r5.setPadding(0, ContactsUtils.dipTopx(this.this$0.getContext(), 6.0d), 0, 0);
            TextView r6 = (TextView) r5.findViewById(R.id.tv_summary_paragraph);
            r6.setText(r4);
            r6.setTextSize(12.0f);
            r6.setMaxLines(2);
            this.summaryParagraph.addView(r5);
            goto L20
        L22:
            r2 = true;
        L25:
            if (r11.isUnableToSummarize(ContactDetailCallLogView.access$100(this.this$0)) == false) goto L28;
            this.summaryDetail.setVisibility(8);
        L28:
            return r2;
        L14:
            this.summaryText.setText(r0.getSummary().getSummary());
            goto L16
        L23:
            this.summaryDetail.setVisibility(8);
            goto L25
        L8:
            if (r0.isFeatureCallSummaryEnabled() == true) goto L9;
        L27:
            this.summaryDetail.setVisibility(8);
            goto L28
        }

        public void updateViewStatus(int r4, int r5) {
            if (1 > r4) goto L6;
            this.itemBody.setCardPosition(2);
        L6:
            if (r4 != (r5 - 1)) goto L9;
            showDivider();
            return;
        }

        public void showDivider() {
            if (this.summaryDetail.getVisibility() != 0) goto L5;
            this.summaryDetail.showDivider(true);
            this.itemBody.showDivider(false);
            return;
        L5:
            this.itemBody.showDivider(true);
        }
    }

    static /* synthetic */ LongMenuHelper access$000(ContactDetailCallLogView r0) {
        return r0.menuHelper;
    }

    static /* synthetic */ Context access$100(ContactDetailCallLogView r0) {
        return r0.mContext;
    }

    public ContactDetailCallLogView(Context r4) {
        super(r4);
        this.CALL_LOG_MAX_COUNT = 3;
        this.mInterceptType = 0;
        this.longMenuItem = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
        this.mContext = r4;
    }

    public ContactDetailCallLogView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.CALL_LOG_MAX_COUNT = 3;
        this.mInterceptType = 0;
        this.longMenuItem = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
        this.mContext = r2;
    }

    public ContactDetailCallLogView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.CALL_LOG_MAX_COUNT = 3;
        this.mInterceptType = 0;
        this.longMenuItem = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_DELETE};
        this.mContext = r3;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mContent = (LinearLayout) findViewById(R.id.content);
        OCardListItem r0 = (OCardListItem) findViewById(R.id.detail_call_log_btn);
        this.mMoreItem = r0;
        if (r0 == null) goto L6;
        Typeface r1 = Typeface.create(Typeface.DEFAULT, getResources().getInteger(R.integer.oui_font_weight_medium), false);
        this.mMoreItem.getTitleView().setTypeface(r1, 0);
        return;
    }

    public void setData(PhoneCallDetails[] r3, List<String> r4, int r5, Activity r6) {
        StringBuilder r0 = new StringBuilder("setData ");
        if (r3 != null) goto L5;
        Object r1 = "null";
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r0.append(r1).toString());
        this.mInterceptType = r5;
        if (r3 != null) goto L9;
    L12:
        ViewGroup.LayoutParams r7 = getLayoutParams();
        r7.height = ContactsUtils.dipTopx(this.mContext, 0.4d);
        setVisibility(8);
        return;
    L9:
        if (r3.length == 0) goto L12;
        getLayoutParams().height = -2;
        setVisibility(0);
        this.mPhoneCallDetails = r3;
        this.mPhoneNumberList = r4;
        this.menuHelper = new LongMenuHelper(r6, this);
        createCallLogView(this.mPhoneCallDetails);
        return;
    L5:
        r1 = Integer.valueOf(r3.length);
        goto L6
    }

    public void setMoreItemClickListener(View.OnClickListener r1) {
        OCardListItem r0 = this.mMoreItem;
        if (r0 == null) goto L6;
        r0.setOnContentClickListener(r1);
        return;
    }

    private void createCallLogView(PhoneCallDetails[] r2) {
        this.mContent.removeAllViews();
        addView(r2, this, this.mContent);
        this.mContent.requestLayout();
    }

    private void addView(PhoneCallDetails[] r21, ViewGroup r22, LinearLayout r23) {
        PhoneCallDetails[] r1 = r21;
        int r2 = Math.min(r1.length, 3);
        List<String> r3 = this.mPhoneNumberList;
        char r5 = 0;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        int r6 = 0;
        boolean r17 = false;
    L9:
        if (r6 >= r2) goto L21;
        final PhoneCallDetails r14 = r1[r6];
        if (r14 != null) goto L13;
    L19:
        char r7 = r5;
    L20:
        r6 = r6 + 1;
        r1 = r21;
        r5 = r7;
        goto L9
    L13:
        if (r14.callTypes.length == 0) goto L19;
        int r10 = r14.callTypes[r5];
        final CallLogItem r15 = new CallLogItem(this, r22);
        r15.itemBody.showSingleContactCallNumber(r4, r14, r10, r14.date, (String) r14.number, r14.duration, this.mInterceptType);
        r15.itemBody.setPhoneSimStatus(r14.simId, r14.showSimId);
        r7 = 0;
        r15.itemBody.showDivider(false);
        r15.itemBody.setShowCardBg(true);
        if (r17 == true) goto L18;
        r17 = r15.updateSummaryView(r14);
    L18:
        r15.updateViewStatus(r6, r2);
        r15.itemBody.setOnClickListener(new AnonymousClass1(this, r14, r15));
        r15.summaryTitleLayout.setOnClickListener(new AnonymousClass2(this, r14));
        r23.addView(r15.item);
        goto L20
    L21:
        return;
    L5:
        if (r3.size() < 2) goto L7;
        r4 = true;
        goto L8
    }

    @Override // com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r1, View r2, Object r3) {
        if (r1 != LongMenuHelper.MenuType.MENU_DELETE) goto L7;
        deleteCallLog((PhoneCallDetails) r3);
        return false;
    L7:
        return false;
    }

    private void deleteCallLog(PhoneCallDetails r5) {
        this.mContext.getContentResolver().delete(CallLog.Calls.CONTENT_URI, "number = ? AND date = ?", new String[]{r5.number.toString(), String.valueOf(r5.date)});
    }
}
