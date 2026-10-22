package com.android.contacts.calllog;

import android.content.res.Resources;
import android.text.TextUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.PhoneCallDetailsHelper;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class CallLogListItemHelper {
    private final PhoneCallDetailsHelper mPhoneCallDetailsHelper;
    private final PhoneNumberHelper mPhoneNumberHelper;
    private final Resources mResources;

    public CallLogListItemHelper(PhoneCallDetailsHelper r1, PhoneNumberHelper r2, Resources r3) {
        this.mPhoneCallDetailsHelper = r1;
        this.mPhoneNumberHelper = r2;
        this.mResources = r3;
    }

    public void setPhoneCallDetails(CallLogListItemViews r7, PhoneCallDetails r8, boolean r9, int r10, int r11) {
        this.mPhoneCallDetailsHelper.setPhoneCallDetails(r7.phoneCallDetailsViews, r8, r9, r10, r11);
    }

    public void setPhoneCallDetails(CallLogListItemViews r1, PhoneCallDetails r2, boolean r3, int r4, int r5, int r6, boolean r7) {
        setPhoneCallDetails(r1, r2, r3, r4, r5);
        if (DSUtils.useDSFeature() == true) goto L7;
        if (r7 == true) goto L7;
        r1.simIcon.setVisibility(8);
        return;
    L7:
        int r0 = DSUtils.getSimIconResource(r6);
        if (r0 <= 0) goto L10;
        r1.simIcon.setVisibility(0);
        r1.simIcon.setImageResource(r0);
        return;
    L10:
        r1.simIcon.setVisibility(8);
    }

    private void configureCallSecondaryAction(CallLogListItemViews r3, PhoneCallDetails r4) {
        r3.secondaryActionView.setVisibility(0);
        r3.secondaryActionView.setContentDescription(getCallActionDescription(r4));
    }

    private CharSequence getCallActionDescription(PhoneCallDetails r4) {
        if (TextUtils.isEmpty(r4.name) == true) goto L5;
        CharSequence r5 = r4.name;
    L7:
        return this.mResources.getString(R.string.description_call, new Object[]{r5});
    L5:
        r5 = this.mPhoneNumberHelper.getDisplayNumber(r4.number, r4.formattedNumber, r4.presentation);
        goto L7
    }

    private void configurePlaySecondaryAction(CallLogListItemViews r2, boolean r3) {
        r2.secondaryActionView.setVisibility(0);
        r2.secondaryActionView.setContentDescription(this.mResources.getString(R.string.description_call_log_play_button));
    }
}
