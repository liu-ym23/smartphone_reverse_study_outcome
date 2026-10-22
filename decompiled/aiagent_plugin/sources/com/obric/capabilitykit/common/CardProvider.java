package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class CardProvider implements Parcelable {
    public static final a CREATOR = null;
    private String cardUri;
    private String extraParams;
    private String title;
    private Integer viewHeight;

    public static final class a implements Parcelable.Creator<CardProvider> {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public CardProvider a(Parcel r6) {
            int r5 = r6.readInt();
            d.h.b.o.e(r6, "parcel");
            String r1 = r6.readString();
            Object r2 = r6.readValue(Integer.TYPE.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L5;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
        L6:
            CardProvider r0 = new CardProvider(r1, r3, r6.readString(), r6.readString());
            int r4 = Math.min(r5, 0);
            ClassLoader r7 = a.class.getClassLoader();
            int r8 = 1;
        L7:
            if (r8 > r4) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 > r5) goto L11;
            com.obric.a.a.a(r6, r7);
            r8 = r8 + 1;
            goto L9
        L11:
            return r0;
        L5:
            r3 = null;
            goto L6
        }

        public CardProvider[] a(int r1) {
            return new CardProvider[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardProvider createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardProvider[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public CardProvider() {
        this(null, null, null, null, 15, null);
    }

    public CardProvider(String r1, Integer r2, String r3, String r4) {
        this.cardUri = r1;
        this.viewHeight = r2;
        this.title = r3;
        this.extraParams = r4;
    }

    public /* synthetic */ CardProvider(String r2, Integer r3, String r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getCardUri() {
        return this.cardUri;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getViewHeight() {
        return this.viewHeight;
    }

    public final void setCardUri(String r1) {
        this.cardUri = r1;
    }

    public final void setExtraParams(String r1) {
        this.extraParams = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setViewHeight(Integer r1) {
        this.viewHeight = r1;
    }

    public String toString() {
        return "CardProvider(cardUri=" + this.cardUri + ", viewHeight=" + this.viewHeight + ", title=" + this.title + ", extraParams=" + this.extraParams + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        d.h.b.o.e(r1, "parcel");
        r1.writeString(this.cardUri);
        r1.writeValue(this.viewHeight);
        r1.writeString(this.title);
        r1.writeString(this.extraParams);
    }
}
