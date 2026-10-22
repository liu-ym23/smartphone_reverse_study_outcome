package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class RemoteCard implements Parcelable {
    public static final a CREATOR = null;
    private CardProvider[] cardProviders;
    private Boolean isIndependent;

    public static final class a implements Parcelable.Creator<RemoteCard> {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public RemoteCard a(Parcel r9) {
            int r8 = r9.readInt();
            d.h.b.o.e(r9, "parcel");
            Object r0 = r9.readValue(CardProvider.class.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == false) goto L5;
            Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin");
        L6:
            int r2 = r9.readInt();
            CardProvider[] r3 = new CardProvider[r2];
            int r5 = 0;
        L7:
            if (r5 >= r2) goto L9;
            r3[r5] = (CardProvider) ZeusTransformUtils.preCheckCast(r9.readParcelable(CardProvider.class.getClassLoader()), CardProvider.class, "com.obric.aiagent.plugin");
            r5 = r5 + 1;
            goto L7
        L9:
            RemoteCard r4 = new RemoteCard(r1, r3);
            int r6 = Math.min(r8, 0);
            ClassLoader r7 = a.class.getClassLoader();
            int r10 = 1;
        L10:
            if (r10 > r6) goto L12;
            r10 = r10 + 1;
        L12:
            if (r10 > r8) goto L14;
            com.obric.a.a.a(r9, r7);
            r10 = r10 + 1;
            goto L12
        L14:
            return r4;
        L5:
            r1 = null;
            goto L6
        }

        public RemoteCard[] a(int r1) {
            return new RemoteCard[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RemoteCard createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RemoteCard[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCard() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public RemoteCard(Boolean r1, CardProvider[] r2) {
        this.isIndependent = r1;
        this.cardProviders = r2;
    }

    public /* synthetic */ RemoteCard(Boolean r1, CardProvider[] r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CardProvider[] getCardProviders() {
        return this.cardProviders;
    }

    public final Boolean isIndependent() {
        return this.isIndependent;
    }

    public final void setCardProviders(CardProvider[] r1) {
        this.cardProviders = r1;
    }

    public final void setIndependent(Boolean r1) {
        this.isIndependent = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("RemoteCard(isIndependent=").append(this.isIndependent).append(", cardProviders=");
        String r2 = Arrays.toString(this.cardProviders);
        d.h.b.o.c(r2, "java.util.Arrays.toString(this)");
        return r0.append(r2).append(')').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        d.h.b.o.e(r4, "parcel");
        r4.writeValue(this.isIndependent);
        CardProvider[] r1 = this.cardProviders;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L6:
        r4.writeInt(r2);
        CardProvider[] r3 = this.cardProviders;
        if (r3 == null) goto L11;
        int r6 = r3.length;
    L9:
        if (r0 >= r6) goto L13;
        r4.writeParcelable(r3[r0], r5);
        r0 = r0 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
