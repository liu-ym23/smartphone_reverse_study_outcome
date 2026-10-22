package com.android.contacts.setting;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.R;
import com.android.contacts.preference.ContactsPreferences;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import obric.widget.TipsView;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayOrderFragment extends Fragment implements View.OnClickListener {
    private ContactsPreferences mContactsPreferences;
    private Context mContext;
    private int mDisplayOrder;
    private OCardListItem mFamilyName;
    private OCheckMark mFamilyNameMark;
    private OCardListItem mGivenName;
    private OCheckMark mGivenNameMark;
    private TipsView mTipsView;

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    public DisplayOrderFragment() {
    }

    static /* synthetic */ int access$000(DisplayOrderFragment r0) {
        return r0.mDisplayOrder;
    }

    static /* synthetic */ int access$002(DisplayOrderFragment r0, int r1) {
        r0.mDisplayOrder = r1;
        return r1;
    }

    static /* synthetic */ ContactsPreferences access$100(DisplayOrderFragment r0) {
        return r0.mContactsPreferences;
    }

    static /* synthetic */ OCheckMark access$200(DisplayOrderFragment r0) {
        return r0.mFamilyNameMark;
    }

    static /* synthetic */ OCheckMark access$300(DisplayOrderFragment r0) {
        return r0.mGivenNameMark;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity r2) {
        super.onAttach(r2);
        this.mContext = r2;
        this.mContactsPreferences = new ContactsPreferences(this.mContext);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        View r7 = View.inflate(this.mContext, R.layout.option_detail_fragment, null);
        TipsView r8 = (TipsView) r7.findViewById(R.id.option_tips);
        this.mTipsView = r8;
        r8.setText(R.string.setting_display_option_tips);
        OCardListItem r9 = (OCardListItem) r7.findViewById(R.id.option_1);
        this.mFamilyName = r9;
        r9.setCardType(0);
        this.mFamilyName.setCardPosition(1);
        this.mFamilyName.setTitle(this.mContext.getString(R.string.setting_display_option_family_name));
        this.mFamilyName.setDefaultCustomEndView(2);
        this.mFamilyName.showCustomEnd(true);
        this.mFamilyName.setOnContentClickListener(new AnonymousClass1(this));
        OCardListItem r10 = (OCardListItem) r7.findViewById(R.id.option_2);
        this.mGivenName = r10;
        r10.setCardType(0);
        this.mGivenName.setCardPosition(3);
        this.mGivenName.setTitle(this.mContext.getString(R.string.setting_display_option_given_name));
        this.mGivenName.setDefaultCustomEndView(2);
        this.mGivenName.showCustomEnd(true);
        this.mGivenName.setOnContentClickListener(new AnonymousClass2(this));
        return r7;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mFamilyNameMark = this.mFamilyName.getEndMark();
        this.mGivenNameMark = this.mGivenName.getEndMark();
        int r5 = this.mContactsPreferences.getDisplayOrder();
        this.mDisplayOrder = r5;
        if (1 != r5) goto L11;
        OCheckMark r6 = this.mFamilyNameMark;
        if (r6 == null) goto L7;
        r6.setChecked(false);
    L7:
        OCheckMark r2 = this.mGivenNameMark;
        if (r2 == null) goto L19;
        r2.setChecked(true);
        return;
    L19:
        return;
    L11:
        if (2 != r5) goto L21;
        OCheckMark r7 = this.mFamilyNameMark;
        if (r7 == null) goto L15;
        r7.setChecked(true);
    L15:
        OCheckMark r8 = this.mGivenNameMark;
        if (r8 == null) goto L22;
        r8.setChecked(false);
        return;
    L22:
        return;
    }
}
