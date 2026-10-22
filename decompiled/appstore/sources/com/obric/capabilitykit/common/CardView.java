package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/capabilitykit/common/CardView;", "Landroid/os/Parcelable;", "remoteViews", "Landroid/widget/RemoteViews;", "backBackgroundResId", "", "iconResId", "description", "", "frontPanelResId", "(Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getBackBackgroundResId", "()Ljava/lang/Integer;", "setBackBackgroundResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getFrontPanelResId", "setFrontPanelResId", "getIconResId", "setIconResId", "describeContents", "getContentViews", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardView implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @Nullable
    private Integer backBackgroundResId;

    @Nullable
    private String description;

    @Nullable
    private Integer frontPanelResId;

    @Nullable
    private Integer iconResId;

    @Nullable
    private RemoteViews remoteViews;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/CardView$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/CardView;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/CardView;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<CardView> {
        private a() {
        }

        @NotNull
        public CardView a(@NotNull Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "parcel");
            RemoteViews r11 = (RemoteViews) r10.readParcelable(RemoteViews.class.getClassLoader());
            Class r12 = Integer.TYPE;
            Object r13 = r10.readValue(r12.getClassLoader());
            if ((r13 instanceof Integer) == false) goto L5;
            Integer r14 = (Integer) r13;
        L6:
            Object r15 = r10.readValue(r12.getClassLoader());
            if ((r15 instanceof Integer) == false) goto L9;
            Integer r16 = (Integer) r15;
        L10:
            String r17 = r10.readString();
            Object r18 = r10.readValue(r12.getClassLoader());
            if ((r18 instanceof Integer) == false) goto L13;
            Integer r19 = (Integer) r18;
        L15:
            return new CardView(r11, r14, r16, r17, r19);
        L13:
            r19 = null;
            goto L15
        L9:
            r16 = null;
            goto L10
        L5:
            r14 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CardView createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CardView[] newArray(int r10) {
            return a(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @NotNull
        public CardView[] a(int r10) {
            return new CardView[r10];
        }
    }

    static {
        CREATOR = new a(null);
    }

    public CardView() {
        RemoteViews r10 = null;
        Integer r11 = null;
        Integer r12 = null;
        String r13 = null;
        Integer r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getBackBackgroundResId() {
        return this.backBackgroundResId;
    }

    @Nullable
    public final RemoteViews getContentViews() {
        return this.remoteViews;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getFrontPanelResId() {
        return this.frontPanelResId;
    }

    @Nullable
    public final Integer getIconResId() {
        return this.iconResId;
    }

    public final void setBackBackgroundResId(@Nullable Integer r10) {
        this.backBackgroundResId = r10;
    }

    public final void setDescription(@Nullable String r10) {
        this.description = r10;
    }

    public final void setFrontPanelResId(@Nullable Integer r10) {
        this.frontPanelResId = r10;
    }

    public final void setIconResId(@Nullable Integer r10) {
        this.iconResId = r10;
    }

    @NotNull
    public String toString() {
        return "CardView(remoteViews=" + this.remoteViews + ", backBackground=" + this.backBackgroundResId + ", icon=" + this.iconResId + ", description=" + this.description + ", frontPanel=" + this.frontPanelResId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeParcelable(this.remoteViews, r11);
        r10.writeValue(this.backBackgroundResId);
        r10.writeValue(this.iconResId);
        r10.writeString(this.description);
        r10.writeValue(this.frontPanelResId);
    }

    public CardView(@Nullable RemoteViews r10, @Nullable Integer r11, @Nullable Integer r12, @Nullable String r13, @Nullable Integer r14) {
        this.remoteViews = r10;
        this.backBackgroundResId = r11;
        this.iconResId = r12;
        this.description = r13;
        this.frontPanelResId = r14;
    }

    public /* synthetic */ CardView(RemoteViews r10, Integer r11, Integer r12, String r13, Integer r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = null;
    L17:
        this(r10, r11, r12, r13, r14);
    }
}
