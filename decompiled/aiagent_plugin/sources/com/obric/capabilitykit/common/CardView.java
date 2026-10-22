package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class CardView implements Parcelable {
    public static final a CREATOR = null;
    private Integer backBackgroundResId;
    private String description;
    private Integer frontPanelResId;
    private Integer iconResId;
    private RemoteViews remoteViews;

    public static final class a implements Parcelable.Creator<CardView> {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public CardView a(Parcel r8) {
            d.h.b.o.e(r8, "parcel");
            RemoteViews r1 = (RemoteViews) ZeusTransformUtils.preCheckCast(r8.readParcelable(RemoteViews.class.getClassLoader()), RemoteViews.class, "com.obric.aiagent.plugin");
            Class r0 = Integer.TYPE;
            Object r3 = r8.readValue(r0.getClassLoader());
            Integer r5 = null;
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L5;
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin");
        L6:
            Object r6 = r8.readValue(r0.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L9;
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
        L10:
            String r9 = r8.readString();
            Object r10 = r8.readValue(r0.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L14;
            r5 = (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin");
        L14:
            return new CardView(r1, r4, r7, r9, r5);
        L9:
            r7 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        public CardView[] a(int r1) {
            return new CardView[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardView createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardView[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public CardView() {
        this(null, null, null, null, null, 31, null);
    }

    public CardView(RemoteViews r1, Integer r2, Integer r3, String r4, Integer r5) {
        this.remoteViews = r1;
        this.backBackgroundResId = r2;
        this.iconResId = r3;
        this.description = r4;
        this.frontPanelResId = r5;
    }

    public /* synthetic */ CardView(RemoteViews r2, Integer r3, Integer r4, String r5, Integer r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Integer getBackBackgroundResId() {
        return this.backBackgroundResId;
    }

    public final RemoteViews getContentViews() {
        return this.remoteViews;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getFrontPanelResId() {
        return this.frontPanelResId;
    }

    public final Integer getIconResId() {
        return this.iconResId;
    }

    public final void setBackBackgroundResId(Integer r1) {
        this.backBackgroundResId = r1;
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }

    public final void setFrontPanelResId(Integer r1) {
        this.frontPanelResId = r1;
    }

    public final void setIconResId(Integer r1) {
        this.iconResId = r1;
    }

    public String toString() {
        return "CardView(remoteViews=" + this.remoteViews + ", backBackground=" + this.backBackgroundResId + ", icon=" + this.iconResId + ", description=" + this.description + ", frontPanel=" + this.frontPanelResId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        d.h.b.o.e(r2, "parcel");
        r2.writeParcelable(this.remoteViews, r3);
        r2.writeValue(this.backBackgroundResId);
        r2.writeValue(this.iconResId);
        r2.writeString(this.description);
        r2.writeValue(this.frontPanelResId);
    }
}
