package com.android.contacts.pick;

import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MultiEmailsPickerFragment extends EmailPickerFragment implements PickerFragment.MultiSlideCheckListener {
    public MultiEmailsPickerFragment() {
        setType(EmailPickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    public MultiEmailsPickerFragment(ArrayList<Long> r1) {
        this.mSelectedIds2Remove = r1;
        setType(EmailPickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        super.onItemClick(r3, r4, r5, r6);
        MultiEmailsPickerAdapter r7 = (MultiEmailsPickerAdapter) r3.getAdapter();
        if (r7 == null) goto L12;
        SamContact r8 = r7.getItem(r5);
        if (this.mSelectContactIds.contains(Long.valueOf(r8.phoneId)) == false) goto L7;
        this.mSelectContactIds.remove(Long.valueOf(r8.phoneId));
        boolean r2 = false;
    L8:
        OCheckBox r9 = (OCheckBox) r3.getChildAt(r5 - r3.getFirstVisiblePosition()).findViewById(R.id.checkBox);
        if (r9 == null) goto L13;
        r9.setChecked(r2);
        return;
    L13:
        return;
    L7:
        this.mSelectContactIds.add(Long.valueOf(r8.phoneId));
        r2 = true;
        goto L8
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public void setSlideChecked(SlideListView r3, int r4, boolean r5) {
        SamContact r0 = ((MultiEmailsPickerAdapter) r3.getAdapter()).getItem(r4);
        View r6 = r3.getChildAt(r4 - r3.getFirstVisiblePosition());
        if (r6 != null) goto L5;
        return;
    L5:
        View r7 = r6.findViewById(R.id.checkBox);
        if (r7 == null) goto L8;
        ((OCheckBox) r7).setChecked(r5);
    L8:
        if (r5 == false) goto L13;
        if (this.mSelectContactIds.contains(Long.valueOf(r0.phoneId)) == true) goto L16;
        this.mSelectContactIds.add(Long.valueOf(r0.phoneId));
        return;
    L16:
        return;
    L13:
        if (this.mSelectContactIds.contains(Long.valueOf(r0.phoneId)) == false) goto L18;
        this.mSelectContactIds.remove(Long.valueOf(r0.phoneId));
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public boolean isSlideChecked(SlideListView r1, int r2) {
        hideSoftKeyboard();
        SamContact r3 = ((MultiEmailsPickerAdapter) r1.getAdapter()).getItem(r2);
        return this.mSelectContactIds.contains(Long.valueOf(r3.phoneId));
    }
}
