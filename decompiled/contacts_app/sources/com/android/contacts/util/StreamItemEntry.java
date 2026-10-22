package com.android.contacts.util;

import android.database.Cursor;
import com.android.contacts.interactions.GroupDeletionDialogFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StreamItemEntry implements Comparable<StreamItemEntry> {
    private final String mAccountName;
    private final String mAccountType;
    private final String mComments;
    private final String mDataSet;
    private final String mIconRes;
    private final long mId;
    private final String mLabelRes;
    private List<StreamItemPhotoEntry> mPhotos;
    private final String mResPackage;
    private final String mText;
    private final long mTimestamp;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(StreamItemEntry r1) {
        return compareTo2(r1);
    }

    public StreamItemEntry(long r1, String r3, String r4, long r5, String r7, String r8, String r9, String r10, String r11, String r12) {
        this.mId = r1;
        this.mText = r3;
        this.mComments = r4;
        this.mTimestamp = r5;
        this.mAccountType = r7;
        this.mAccountName = r8;
        this.mDataSet = r9;
        this.mResPackage = r10;
        this.mIconRes = r11;
        this.mLabelRes = r12;
        this.mPhotos = new ArrayList();
    }

    public StreamItemEntry(Cursor r3) {
        this.mId = getLong(r3, "_id");
        this.mText = getString(r3, "text");
        this.mComments = getString(r3, "comments");
        this.mTimestamp = getLong(r3, "timestamp");
        this.mAccountType = getString(r3, "account_type");
        this.mAccountName = getString(r3, "account_name");
        this.mDataSet = getString(r3, "data_set");
        this.mResPackage = getString(r3, "res_package");
        this.mIconRes = getString(r3, "icon");
        this.mLabelRes = getString(r3, GroupDeletionDialogFragment.ARG_LABEL);
        this.mPhotos = new ArrayList();
    }

    public void addPhoto(StreamItemPhotoEntry r1) {
        this.mPhotos.add(r1);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(StreamItemEntry r4) {
        long r0 = this.mTimestamp;
        long r3 = r4.mTimestamp;
        if (r0 != r3) goto L6;
        return 0;
    L6:
        if (r0 <= r3) goto L8;
        return -1;
    L8:
        return 1;
    }

    public long getId() {
        return this.mId;
    }

    public String getText() {
        return this.mText;
    }

    public String getComments() {
        return this.mComments;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public String getAccountType() {
        return this.mAccountType;
    }

    public String getAccountName() {
        return this.mAccountName;
    }

    public String getDataSet() {
        return this.mDataSet;
    }

    public String getResPackage() {
        return this.mResPackage;
    }

    public String getIconRes() {
        return this.mIconRes;
    }

    public String getLabelRes() {
        return this.mLabelRes;
    }

    public List<StreamItemPhotoEntry> getPhotos() {
        Collections.sort(this.mPhotos);
        return this.mPhotos;
    }

    private static String getString(Cursor r0, String r1) {
        return r0.getString(r0.getColumnIndex(r1));
    }

    private static long getLong(Cursor r0, String r1) {
        return r0.getLong(r0.getColumnIndex(r1));
    }
}
