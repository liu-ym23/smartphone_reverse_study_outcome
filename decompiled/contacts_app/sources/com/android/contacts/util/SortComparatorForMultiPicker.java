package com.android.contacts.util;

import android.content.Context;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.ContactBaseData;

/* JADX INFO: loaded from: classes2.dex */
public class SortComparatorForMultiPicker extends NameSortComparator {
    public static final String SPECIAL_LABLE_FOR_SELECTED = "*#*##*#*";
    private String mProfileContactSection;

    @Override // com.android.contacts.util.NameSortComparator, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ContactBaseData r1, ContactBaseData r2) {
        return compare(r1, r2);
    }

    public SortComparatorForMultiPicker(Context r2) {
        this.mProfileContactSection = r2.getResources().getString(R.string.common_i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.contacts.util.NameSortComparator
    public int compare(ContactBaseData r7, ContactBaseData r8) {
        if (r7.section.equals(SPECIAL_LABLE_FOR_SELECTED) == false) goto L21;
        if (r8.section.equals(SPECIAL_LABLE_FOR_SELECTED) == false) goto L21;
        String r0 = ContactsUtils.getContactSection(r7.sortkey, r7.phoneBookLabel);
        String r1 = ContactsUtils.getContactSection(r8.sortkey, r8.phoneBookLabel);
        if (r0.equals(ContactsUtils.CHAR_POUND) == false) goto L12;
        if (r1.equals(ContactsUtils.CHAR_POUND) == false) goto L12;
        return this.mNumberSortComparator.compare2(r7, r8);
    L12:
        if (r0.equals(ContactsUtils.CHAR_POUND) == false) goto L15;
        return 1;
    L15:
        if (r1.equals(ContactsUtils.CHAR_POUND) == false) goto L17;
        return -1;
    L17:
        int r6 = mCollator.compare(r0, r1);
        if (r6 == 0) goto L40;
        return r6;
    L40:
        return r7.sortkey.compareToIgnoreCase(r8.sortkey);
    L21:
        if (r7.section.equals(SPECIAL_LABLE_FOR_SELECTED) == false) goto L24;
        return -1;
    L24:
        if (r8.section.equals(SPECIAL_LABLE_FOR_SELECTED) == false) goto L27;
        return 1;
    L27:
        if (r7.section.equals(this.mProfileContactSection) == false) goto L32;
        if (r8.section.equals(this.mProfileContactSection) == true) goto L32;
        return -1;
    L32:
        if (r7.section.equals(this.mProfileContactSection) == true) goto L37;
        if (r8.section.equals(this.mProfileContactSection) == false) goto L37;
        return 1;
    L37:
        return super.compare2(r7, r8);
    }
}
