package com.android.contacts.common.list;

import android.text.TextUtils;
import android.widget.SectionIndexer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ContactsSectionIndexer implements SectionIndexer {
    private static final String BLANK_HEADER_STRING = " ";
    private int mCount;
    private int[] mPositions;
    private String[] mSections;

    public ContactsSectionIndexer(String[] r4, int[] r5) {
        if (r4 == null) goto L22;
        if (r5 == null) goto L22;
        if (r4.length != r5.length) goto L20;
        this.mSections = r4;
        this.mPositions = new int[r5.length];
        int r6 = 0;
        int r0 = 0;
    L9:
        if (r6 >= r5.length) goto L17;
        if (TextUtils.isEmpty(this.mSections[r6]) == false) goto L14;
        this.mSections[r6] = " ";
    L16:
        this.mPositions[r6] = r0;
        r0 = r0 + r5[r6];
        r6 = r6 + 1;
        goto L9
    L14:
        if (this.mSections[r6].equals(" ") == true) goto L16;
        String[] r1 = this.mSections;
        r1[r6] = r1[r6].trim();
        goto L16
    L17:
        this.mCount = r0;
        return;
    L20:
        throw new IllegalArgumentException("The sections and counts arrays must have the same length");
    L22:
        throw null;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.mSections;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int r2) {
        if (r2 >= 0) goto L4;
        return -1;
    L4:
        if (r2 < this.mSections.length) goto L7;
        return -1;
    L7:
        return this.mPositions[r2];
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int r2) {
        if (r2 >= 0) goto L4;
        return -1;
    L4:
        if (r2 >= this.mCount) goto L14;
        int r1 = Arrays.binarySearch(this.mPositions, r2);
        if (r1 < 0) goto L10;
        return r1;
    L10:
        return (-r1) - 2;
    L14:
        return -1;
    }

    public void setProfileHeader(String r7) {
        String[] r0 = this.mSections;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length > 0) goto L7;
    L9:
        String[] r1 = new String[this.mSections.length + 1];
        int[] r3 = new int[this.mPositions.length + 1];
        r1[0] = r7;
        r3[0] = 0;
        int r8 = 1;
    L10:
        int[] r2 = this.mPositions;
        if (r8 > r2.length) goto L13;
        int r5 = r8 - 1;
        r1[r8] = this.mSections[r5];
        r3[r8] = r2[r5] + 1;
        r8 = r8 + 1;
        goto L10
    L13:
        this.mSections = r1;
        this.mPositions = r3;
        this.mCount++;
        return;
    L7:
        if (r7.equals(r0[0]) == false) goto L9;
    }
}
