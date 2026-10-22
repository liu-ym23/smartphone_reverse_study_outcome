package com.obric.cae.libs.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CaeNfcCardQueryResult implements Parcelable {
    public static final Parcelable.Creator<CaeNfcCardQueryResult> CREATOR = null;
    public static final int RESULT_INVALID_ARGUMENT = 1;
    public static final int RESULT_QUERY_FAILED = 3;
    public static final int RESULT_SE_UNAVAILABLE = 2;
    public static final int RESULT_SUCCESS = 0;
    private final ArrayList<CaeNfcCardInfo> mCards;
    private final int mResultCode;
    private final boolean mSourceComplete;

    public class a implements Parcelable.Creator<CaeNfcCardQueryResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardQueryResult createFromParcel(Parcel r2) {
            return new CaeNfcCardQueryResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardQueryResult[] newArray(int r1) {
            return new CaeNfcCardQueryResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeNfcCardQueryResult(int r1, boolean r2, List<CaeNfcCardInfo> r3) {
        this.mResultCode = r1;
        this.mSourceComplete = r2;
        if (r3 != null) goto L5;
        ArrayList<CaeNfcCardInfo> r4 = new ArrayList();
    L6:
        this.mCards = r4;
        return;
    L5:
        r4 = new ArrayList(r3);
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CaeNfcCardInfo> getCards() {
        return Collections.unmodifiableList(this.mCards);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public boolean isCardSwitchSupported() {
        if (this.mResultCode == 0) goto L5;
    L16:
        return false;
    L5:
        if (this.mSourceComplete == false) goto L16;
        Iterator<CaeNfcCardInfo> r0 = this.mCards.iterator();
        int r2 = 0;
    L9:
        if (r0.hasNext() == false) goto L16;
        if (r0.next().isSwitchable() == false) goto L9;
        r2 = r2 + 1;
        if (r2 < 2) goto L9;
        return true;
    }

    public boolean isSourceComplete() {
        return this.mSourceComplete;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mResultCode);
        r1.writeBoolean(this.mSourceComplete);
        r1.writeTypedList(this.mCards);
    }

    public CaeNfcCardQueryResult(Parcel r2) {
        this.mResultCode = r2.readInt();
        this.mSourceComplete = r2.readBoolean();
        ArrayList<CaeNfcCardInfo> r3 = r2.createTypedArrayList(CaeNfcCardInfo.CREATOR);
        if (r3 != null) goto L5;
        r3 = new ArrayList();
    L5:
        this.mCards = r3;
    }
}
