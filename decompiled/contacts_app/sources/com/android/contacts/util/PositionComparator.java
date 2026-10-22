package com.android.contacts.util;

import com.android.contacts.list.ContactBaseData;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class PositionComparator implements Comparator<ContactBaseData> {
    private NameSortComparator.NumberSortComparator mNumberSortComparator;

    public PositionComparator() {
        this.mNumberSortComparator = new NameSortComparator.NumberSortComparator();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ContactBaseData r1, ContactBaseData r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(ContactBaseData r9, ContactBaseData r10) {
        if (r9.index < 0) goto L32;
        if (r10.index < 0) goto L32;
        if (r9.section.equals(r10.section) == false) goto L30;
        boolean r0 = false;
        int r8 = r9.name.codePointAt(0);
        int r3 = r10.name.codePointAt(0);
        if (65 > r8) goto L12;
        if (r8 > 90) goto L12;
    L14:
        boolean r11 = true;
    L16:
        if (65 > r3) goto L18;
        if (r3 > 90) goto L18;
    L20:
        r0 = true;
    L21:
        if (r11 == true) goto L24;
        if (r0 == false) goto L24;
        return 1;
    L24:
        if (r11 == false) goto L28;
        if (r0 == true) goto L28;
        return -1;
    L28:
        return r9.index - r10.index;
    L18:
        if (97 > r3) goto L21;
        if (r3 > 122) goto L21;
    L12:
        if (97 > r8) goto L15;
        if (r8 <= 122) goto L14;
    L15:
        r11 = false;
        goto L16
    L30:
        return r9.index - r10.index;
    L32:
        if (r9.index <= 0) goto L35;
        return -1;
    L35:
        if (r10.index <= 0) goto L38;
        return 1;
    L38:
        return this.mNumberSortComparator.compare2(r9, r10);
    }
}
