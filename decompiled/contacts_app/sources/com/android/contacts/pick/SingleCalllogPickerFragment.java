package com.android.contacts.pick;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;

/* JADX INFO: loaded from: classes2.dex */
public class SingleCalllogPickerFragment extends CallogPickerFragment {
    public SingleCalllogPickerFragment() {
        setType(CallogPickerFragment.Type.SINGLE);
    }

    @Override // com.android.contacts.pick.PickerFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r2, View r3, int r4, long r5) {
        super.onItemClick(r2, r3, r4, r5);
        if (r2.getId() != R.id.list) goto L11;
        SamContact r6 = ((PickerAdapter) this.mCalllogListView.getAdapter()).getItem(r4);
        if (r6.presentation == 1) goto L8;
        CharSequence r7 = this.mPhoneNumberHelper.getDisplayNumber(r6.number, null, r6.presentation);
        Toast.makeText(getActivity(), getResources().getString(R.string.toast_can_not_pick, new Object[]{r7}), 1).show();
        return;
    L8:
        this.mPickerListener.onPickNumberArray(new String[]{r6.number});
        return;
    }
}
