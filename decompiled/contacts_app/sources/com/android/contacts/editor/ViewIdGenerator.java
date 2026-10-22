package com.android.contacts.editor;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;

/* JADX INFO: loaded from: classes.dex */
public final class ViewIdGenerator implements Parcelable {
    public static final Parcelable.Creator<ViewIdGenerator> CREATOR = null;
    private static final int INITIAL_VIEW_ID = 1;
    private static final int INVALID_VIEW_ID = 0;
    private static final char KEY_SEPARATOR = '*';
    public static final int NO_VIEW_INDEX = -1;
    private static final StringBuilder sWorkStringBuilder = null;
    private Bundle mIdMap;
    private int mNextId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ void access$000(ViewIdGenerator r0, Parcel r1) {
        r0.readFromParcel(r1);
    }

    static {
        sWorkStringBuilder = new StringBuilder();
        CREATOR = new AnonymousClass1();
    }

    public ViewIdGenerator() {
        this.mIdMap = new Bundle();
        this.mNextId = 1;
    }

    public int getId(EntityDelta r1, DataKind r2, EntityDelta.ValuesDelta r3, int r4) {
        String r5 = getMapKey(r1, r2, r3, r4);
        int r6 = this.mIdMap.getInt(r5, 0);
        if (r6 != 0) goto L6;
        int r7 = this.mNextId;
        this.mNextId = r7 + 1;
        int r8 = r7 & 65535;
        this.mIdMap.putInt(r5, r8);
        return r8;
    L6:
        return r6;
    }

    private static String getMapKey(EntityDelta r2, DataKind r3, EntityDelta.ValuesDelta r4, int r5) {
        StringBuilder r0 = sWorkStringBuilder;
        r0.setLength(0);
        if (r2 == null) goto L12;
        r0.append(r2.getValues().getId());
        if (r3 == null) goto L12;
        r0.append(KEY_SEPARATOR);
        r0.append(r3.mimeType);
        if (r4 == null) goto L12;
        r0.append(KEY_SEPARATOR);
        r0.append(r4.getId());
        if (r5 == (-1)) goto L12;
        r0.append(KEY_SEPARATOR);
        r0.append(r5);
    L12:
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mNextId);
        r1.writeBundle(this.mIdMap);
    }

    private void readFromParcel(Parcel r2) {
        this.mNextId = r2.readInt();
        this.mIdMap = r2.readBundle();
    }
}
