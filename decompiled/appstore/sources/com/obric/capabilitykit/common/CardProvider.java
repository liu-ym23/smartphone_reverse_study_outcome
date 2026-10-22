package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/CardProvider;", "Landroid/os/Parcelable;", "cardUri", "", "viewHeight", "", "title", "extraParams", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCardUri", "()Ljava/lang/String;", "setCardUri", "(Ljava/lang/String;)V", "getExtraParams", "setExtraParams", "getTitle", "setTitle", "getViewHeight", "()Ljava/lang/Integer;", "setViewHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CardProvider implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @Nullable
    private String cardUri;

    @Nullable
    private String extraParams;

    @Nullable
    private String title;

    @Nullable
    private Integer viewHeight;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/CardProvider$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/CardProvider;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/CardProvider;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<CardProvider> {
        private a() {
        }

        @NotNull
        public CardProvider a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            kotlin.jvm.internal.q.g(r10, "parcel");
            String r12 = r10.readString();
            Object r13 = r10.readValue(Integer.TYPE.getClassLoader());
            if ((r13 instanceof Integer) == false) goto L5;
            Integer r14 = (Integer) r13;
        L6:
            CardProvider r15 = new CardProvider(r12, r14, r10.readString(), r10.readString());
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = a.class.getClassLoader();
            int r18 = 1;
        L7:
            if (r18 > r16) goto L9;
            r18 = r18 + 1;
        L9:
            if (r18 > r11) goto L11;
            be.a.d(r10, r17);
            r18 = r18 + 1;
            goto L9
        L11:
            return r15;
        L5:
            r14 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CardProvider createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CardProvider[] newArray(int r10) {
            return a(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @NotNull
        public CardProvider[] a(int r10) {
            return new CardProvider[r10];
        }
    }

    static {
        CREATOR = new a(null);
    }

    public CardProvider() {
        String r10 = null;
        Integer r11 = null;
        String r12 = null;
        String r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getCardUri() {
        return this.cardUri;
    }

    @Nullable
    public final String getExtraParams() {
        return this.extraParams;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getViewHeight() {
        return this.viewHeight;
    }

    public final void setCardUri(@Nullable String r10) {
        this.cardUri = r10;
    }

    public final void setExtraParams(@Nullable String r10) {
        this.extraParams = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    public final void setViewHeight(@Nullable Integer r10) {
        this.viewHeight = r10;
    }

    @NotNull
    public String toString() {
        return "CardProvider(cardUri=" + this.cardUri + ", viewHeight=" + this.viewHeight + ", title=" + this.title + ", extraParams=" + this.extraParams + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeString(this.cardUri);
        r10.writeValue(this.viewHeight);
        r10.writeString(this.title);
        r10.writeString(this.extraParams);
    }

    public CardProvider(@Nullable String r10, @Nullable Integer r11, @Nullable String r12, @Nullable String r13) {
        this.cardUri = r10;
        this.viewHeight = r11;
        this.title = r12;
        this.extraParams = r13;
    }

    public /* synthetic */ CardProvider(String r10, Integer r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
