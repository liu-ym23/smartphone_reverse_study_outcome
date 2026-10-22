package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AppIntentCardData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIntentCardData implements Parcelable {
    public static final Parcelable.Creator<AppIntentCardData> CREATOR = null;
    public static final a Companion = null;
    public static final int TYPE_ENTITY = 0;
    public static final int TYPE_REMOTE = 1;
    private final AppEntity appEntity;
    private final CardProvider cardProvider;
    private final boolean isDeleted;
    private final boolean isRefreshed;
    private final int type;

    /* JADX INFO: compiled from: AppIntentCardData.kt */
    public static final class Creator implements Parcelable.Creator<AppIntentCardData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppIntentCardData createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            int r1 = r8.readInt();
            AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(r8.readParcelable(AppIntentCardData.class.getClassLoader()), AppEntity.class, "com.obric.aiagent.plugin");
            CardProvider r3 = (CardProvider) ZeusTransformUtils.preCheckCast(r8.readParcelable(AppIntentCardData.class.getClassLoader()), CardProvider.class, "com.obric.aiagent.plugin");
            boolean r5 = false;
            if (r8.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            if (r8.readInt() == 0) goto L10;
            r5 = true;
        L10:
            return new AppIntentCardData(r1, r2, r3, r6, r5);
        L5:
            r6 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentCardData createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppIntentCardData[] newArray(int r1) {
            return new AppIntentCardData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentCardData[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: AppIntentCardData.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final AppIntentCardData a(AppEntity r9) {
            o.e(r9, "appEntity");
            return new AppIntentCardData(0, r9, null, false, false, 28, null);
        }

        public final AppIntentCardData a(CardProvider r9) {
            o.e(r9, "cardProvider");
            return new AppIntentCardData(1, null, r9, false, false, 26, null);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ AppIntentCardData copy$default(AppIntentCardData r3, int r4, AppEntity r5, CardProvider r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.appEntity;
    L8:
        AppEntity r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.cardProvider;
    L11:
        CardProvider r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isDeleted;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isRefreshed;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.type;
    }

    public final AppEntity component2() {
        return this.appEntity;
    }

    public final CardProvider component3() {
        return this.cardProvider;
    }

    public final boolean component4() {
        return this.isDeleted;
    }

    public final boolean component5() {
        return this.isRefreshed;
    }

    public final AppIntentCardData copy(int r7, AppEntity r8, CardProvider r9, boolean r10, boolean r11) {
        return new AppIntentCardData(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppIntentCardData.class) == true) goto L8;
        return false;
    L8:
        AppIntentCardData r6 = (AppIntentCardData) ZeusTransformUtils.preCheckCast(r5, AppIntentCardData.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.appEntity, r6.appEntity) == true) goto L15;
        return false;
    L15:
        if (o.a(this.cardProvider, r6.cardProvider) == true) goto L18;
        return false;
    L18:
        if (this.isDeleted == r6.isDeleted) goto L21;
        return false;
    L21:
        if (this.isRefreshed == r6.isRefreshed) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.type) * 31;
        AppEntity r1 = this.appEntity;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        CardProvider r5 = this.cardProvider;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((r4 + r2) * 31) + Boolean.hashCode(this.isDeleted)) * 31) + Boolean.hashCode(this.isRefreshed);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppIntentCardData(type=" + this.type + ", appEntity=" + this.appEntity + ", cardProvider=" + this.cardProvider + ", isDeleted=" + this.isDeleted + ", isRefreshed=" + this.isRefreshed + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeInt(this.type);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.appEntity, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.cardProvider, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeInt(this.isDeleted ? 1 : 0);
        r4.writeInt(this.isRefreshed ? 1 : 0);
    }

    public AppIntentCardData(int r1, AppEntity r2, CardProvider r3, boolean r4, boolean r5) {
        this.type = r1;
        this.appEntity = r2;
        this.cardProvider = r3;
        this.isDeleted = r4;
        this.isRefreshed = r5;
    }

    public /* synthetic */ AppIntentCardData(int r8, AppEntity r9, CardProvider r10, boolean r11, boolean r12, int r13, h r14) {
        if ((r13 & 2) == 0) goto L5;
        AppEntity r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        CardProvider r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r13 & 16) == 0) goto L17;
        boolean r6 = false;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final int getType() {
        return this.type;
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final CardProvider getCardProvider() {
        return this.cardProvider;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final boolean isRefreshed() {
        return this.isRefreshed;
    }
}
