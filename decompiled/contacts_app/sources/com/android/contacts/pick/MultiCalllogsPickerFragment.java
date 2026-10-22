package com.android.contacts.pick;

import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public class MultiCalllogsPickerFragment extends CallogPickerFragment implements PickerFragment.MultiSlideCheckListener {
    public MultiCalllogsPickerFragment() {
        setType(CallogPickerFragment.Type.MULTIPLE);
        setMultiSlideCheckListener(this);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        super.onItemClick(r1, r2, r3, r4);
        if (r1.getId() != R.id.list) goto L7;
        MultiCalllogsPickerAdapter r0 = (MultiCalllogsPickerAdapter) this.mCalllogListView.getAdapter();
        r0.setChecked(r0.getItem(r3).number);
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public void setSlideChecked(SlideListView r3, int r4, boolean r5) {
        MultiCalllogsPickerAdapter r2 = (MultiCalllogsPickerAdapter) r3.getAdapter();
        String r0 = r2.getItem(r4).number;
        ((OCheckBox) r3.getChildAt(r4 - r3.getFirstVisiblePosition()).findViewById(R.id.checkBox)).setChecked(r5);
        if (r5 == false) goto L8;
        if (r2.getSelectedChecked().contains(r0) == true) goto L11;
        r2.getSelectedChecked().add(r0);
        return;
    L11:
        return;
    L8:
        if (r2.getSelectedChecked().contains(r0) == false) goto L13;
        r2.getSelectedChecked().remove(r0);
        return;
    }

    @Override // com.android.contacts.pick.PickerFragment.MultiSlideCheckListener
    public boolean isSlideChecked(SlideListView r1, int r2) {
        MultiCalllogsPickerAdapter r0 = (MultiCalllogsPickerAdapter) r1.getAdapter();
        SamContact r3 = r0.getItem(r2);
        return r0.getSelectedChecked().contains(r3.number);
    }
}
