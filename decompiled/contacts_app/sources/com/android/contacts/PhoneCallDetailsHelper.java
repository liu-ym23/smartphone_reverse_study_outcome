package com.android.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.android.contacts.calllog.CallTypeHelper;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.detail.ContactDetailDisplayUtils;
import com.android.contacts.util.BlockedCallUtil;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes.dex */
public class PhoneCallDetailsHelper {
    private static final int MAX_CALL_TYPE_ICONS = 1;
    private static final long RING_ONCE_MAX_LIMIT = 5;
    private final CallTypeHelper mCallTypeHelper;
    private Context mContext;
    private Long mCurrentTimeMillisForTest;
    private boolean mIsShowSingleContactCalls;
    private final PhoneNumberHelper mPhoneNumberHelper;
    private final Resources mResources;

    public PhoneCallDetailsHelper(Resources r1, CallTypeHelper r2, PhoneNumberHelper r3, Context r4) {
        this.mResources = r1;
        this.mCallTypeHelper = r2;
        this.mPhoneNumberHelper = r3;
        this.mContext = r4;
    }

    public PhoneCallDetailsHelper(Resources r1, CallTypeHelper r2, PhoneNumberHelper r3, Context r4, boolean r5) {
        this.mResources = r1;
        this.mCallTypeHelper = r2;
        this.mPhoneNumberHelper = r3;
        this.mContext = r4;
        this.mIsShowSingleContactCalls = r5;
    }

    public void setPhoneCallDetails(PhoneCallDetailsViews r20, PhoneCallDetails r21, boolean r22, int r23, int r24) {
        r20.callTypeIcons.clear();
        int r4 = r21.callTypes.length;
        r20.callTypeIcons.add(r23);
        r20.callTypeIcons.setVisibility(0);
        SpannableString r5 = null;
        if (r4 <= 1) goto L5;
        Integer r6 = Integer.valueOf(r4);
    L6:
        if (r22 == false) goto L8;
        Integer r8 = this.mCallTypeHelper.getHighlightedColor(r21.callTypes[0]);
    L10:
        if (this.mIsShowSingleContactCalls == true) goto L12;
        String r9 = CallLogTimeRangeUtil.getCallLogListFormatTime(r21.date);
    L13:
        setCallCountAndDate(r20, r6, r9, r8);
        if (TextUtils.isEmpty(r21.number) == false) goto L16;
    L18:
        CharSequence r10 = null;
    L19:
        CharSequence r11 = this.mPhoneNumberHelper.getDisplayNumber(r21.number, r21.formattedNumber, r21.presentation, true);
        if (this.mIsShowSingleContactCalls == true) goto L30;
        if (TextUtils.isEmpty(r21.name) == false) goto L24;
        String r2 = (String) r21.numberLabel;
    L44:
        if (this.mIsShowSingleContactCalls == true) goto L48;
        if (r23 != 3) goto L47;
        r20.nameView.setTextColor(this.mContext.getColor(R.color.oui_red_6));
    L51:
        if (r23 != 1) goto L54;
        r20.callTypeIcons.setContentDescription(this.mContext.getResources().getString(R.string.type_incoming));
    L61:
        if (r6 == null) goto L63;
        r11 = r11 + " (" + r6 + ")";
    L63:
        r20.nameView.setText(r11);
        if (r23 != 3) goto L69;
        if (BlockedCallUtil.isBlocked(r24) == false) goto L69;
        String r3 = BlockedCallUtil.getBlockedLabel(this.mContext, r24);
        r5 = new SpannableString(r3);
        r5.setSpan(new TextAppearanceSpan(null, 0, 0, this.mResources.getColorStateList(R.color.call_log_blocked_label_color), null), 0, r3.length(), 18);
    L69:
        if (this.mIsShowSingleContactCalls == false) goto L72;
        r20.labelView.setText(r2);
        return;
    L72:
        if (TextUtils.isEmpty(r2) == true) goto L74;
        r2 = r2.replaceAll("(?<!中国)(移动|联通|电信)$", "").trim();
    L74:
        ContactDetailDisplayUtils.setCombinedTextWithDivider(this.mContext, r20.labelView, r2, r5);
        return;
    L54:
        if (r23 != 7) goto L57;
        r20.callTypeIcons.setContentDescription(this.mContext.getResources().getString(R.string.type_answered_elsewhere));
        goto L61
    L57:
        if (r23 != 2) goto L59;
        r20.callTypeIcons.setContentDescription(this.mContext.getResources().getString(R.string.type_outgoing));
        goto L61
    L59:
        if (r23 != 3) goto L61;
        r20.callTypeIcons.setContentDescription(this.mContext.getResources().getString(R.string.type_missed));
        goto L61
    L47:
        r20.nameView.setTextColor(this.mContext.getColor(R.color.oui_text_1));
        goto L51
    L48:
        if (r23 != 3) goto L50;
        r20.callTypeAndDate.setTextColor(this.mContext.getColor(R.color.oui_red_6));
        goto L51
    L50:
        r20.callTypeAndDate.setTextColor(this.mContext.getColor(R.color.oui_text_1));
        goto L51
    L24:
        CharSequence r7 = r21.name;
        if (r10 == null) goto L27;
        String r12 = r10.toString();
    L28:
        r11 = r7;
        r2 = r12;
        goto L44
    L27:
        r12 = r11.toString();
        goto L28
    L30:
        if (r21.callTypes[0] != 3) goto L33;
        r7 = this.mContext.getResources().getString(R.string.type_missed);
    L39:
        String r13 = r11.toString();
        if (r10 == null) goto L42;
        r12 = r13 + "  " + r10;
        goto L28
    L42:
        r11 = r7;
        r2 = r13;
        goto L44
    L33:
        if (r21.duration != 0) goto L35;
        r7 = this.mContext.getResources().getString(R.string.cancelled);
        goto L39
    L35:
        if (ContactsUtils.FEATURE_CMCC == false) goto L37;
        r7 = "";
        goto L39
    L37:
        r7 = DateUtils.formatDuration(r21.duration, this.mContext);
        goto L39
    L16:
        if (PhoneNumberUtils.isUriNumber(r21.number.toString()) == true) goto L18;
        r10 = ContactTypeLabelUtils.getPhoneTypeLabel(this.mContext, Integer.valueOf(r21.numberType), r21.numberLabel);
        goto L19
    L12:
        r9 = ContactsUtils.getDateFormat().format(Long.valueOf(r21.date)) + HanziToPinyin.Token.SEPARATOR + ContactsUtils.getTimeFormat().format(Long.valueOf(r21.date));
        goto L13
    L8:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    private static final String getMissCallRingTimeText(Context r2, long r3) {
        if (r3 > 0) goto L6;
        return null;
    L6:
        if (r3 <= 0) goto L12;
        if (r3 >= 5) goto L12;
        return r2.getResources().getString(R.string.common_one_ring);
    L12:
        return r2.getResources().getString(R.string.miss_call_ring_time_seconds, new Object[]{Long.valueOf(r3)});
    }

    private int getCallTypeColor(int r3) {
        if (r3 != 3) goto L7;
        return this.mResources.getColor(R.color.call_incoming);
    L7:
        throw new IllegalArgumentException("invalid call type: " + r3);
    }

    public void setCallDetailsHeader(TextView r4, PhoneCallDetails r5) {
        CharSequence r3 = this.mPhoneNumberHelper.getDisplayNumber(r5.number, this.mResources.getString(R.string.recentCalls_addToContact), r5.presentation);
        if (TextUtils.isEmpty(r5.name) == true) goto L6;
        r3 = r5.name;
    L6:
        r4.setText(r3);
    }

    public void setCurrentTimeForTest(long r1) {
        this.mCurrentTimeMillisForTest = Long.valueOf(r1);
    }

    private long getCurrentTimeMillis() {
        Long r2 = this.mCurrentTimeMillisForTest;
        if (r2 != null) goto L7;
        return System.currentTimeMillis();
    L7:
        return r2.longValue();
    }

    private void setCallCountAndDate(PhoneCallDetailsViews r1, Integer r2, CharSequence r3, Integer r4) {
        if (r4 == null) goto L4;
        CharSequence r0 = addBoldAndColor(r3, r4.intValue());
    L5:
        r1.callTypeAndDate.setText(r0);
        r1.callTypeAndDate.setContentDescription(r3);
        return;
    L4:
        r0 = r3;
        goto L5
    }

    private CharSequence addBoldAndColor(CharSequence r5, int r6) {
        SpannableString r4 = new SpannableString(r5);
        r4.setSpan(new StyleSpan(1), 0, r5.length(), 18);
        r4.setSpan(new ForegroundColorSpan(r6), 0, r5.length(), 18);
        return r4;
    }
}
