package com.android.contacts.util;

import android.database.Cursor;
import com.obric.oui.material.MaterialConfigFormatNames;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes2.dex */
public class StreamItemPhotoEntry implements Comparable<StreamItemPhotoEntry> {
    private final int mFileSize;
    private final int mHeight;
    private final long mId;
    private final long mPhotoFileId;
    private final String mPhotoUri;
    private final int mSortIndex;
    private final int mWidth;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(StreamItemPhotoEntry r1) {
        return compareTo2(r1);
    }

    public StreamItemPhotoEntry(long r1, int r3, long r4, String r6, int r7, int r8, int r9) {
        this.mId = r1;
        this.mSortIndex = r3;
        this.mPhotoFileId = r4;
        this.mPhotoUri = r6;
        this.mHeight = r7;
        this.mWidth = r8;
        this.mFileSize = r9;
    }

    public StreamItemPhotoEntry(Cursor r5) {
        this.mId = getLong(r5, "_id");
        this.mSortIndex = getInt(r5, "sort_index", -1);
        this.mPhotoFileId = getLong(r5, "photo_file_id");
        this.mPhotoUri = getString(r5, "photo_uri");
        this.mHeight = getInt(r5, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, -1);
        this.mWidth = getInt(r5, MaterialConfigFormatNames.WIDTH, -1);
        this.mFileSize = getInt(r5, "filesize", -1);
    }

    public long getId() {
        return this.mId;
    }

    public int getSortIndex() {
        return this.mSortIndex;
    }

    public long getPhotoFileId() {
        return this.mPhotoFileId;
    }

    public String getPhotoUri() {
        return this.mPhotoUri;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(StreamItemPhotoEntry r7) {
        int r0 = this.mSortIndex;
        int r1 = r7.mSortIndex;
        if (r0 != r1) goto L13;
        if (r0 != (-1)) goto L23;
        long r2 = this.mId;
        long r6 = r7.mId;
        if (r2 != r6) goto L9;
        return 0;
    L9:
        if (r2 >= r6) goto L12;
        return -1;
    L12:
        return 1;
    L23:
        return 0;
    L13:
        if (r0 != (-1)) goto L15;
        return 1;
    L15:
        if (r1 != (-1)) goto L17;
        return -1;
    L17:
        if (r0 == r1) goto L27;
        if (r0 >= r1) goto L22;
        return -1;
    L22:
        return 1;
    L27:
        return 0;
    }

    private static String getString(Cursor r0, String r1) {
        return r0.getString(r0.getColumnIndex(r1));
    }

    private static int getInt(Cursor r1, String r2, int r3) {
        int r4 = r1.getColumnIndex(r2);
        if (r1.isNull(r4) == false) goto L6;
        return r3;
    L6:
        return r1.getInt(r4);
    }

    private static long getLong(Cursor r0, String r1) {
        return r0.getLong(r0.getColumnIndex(r1));
    }
}
