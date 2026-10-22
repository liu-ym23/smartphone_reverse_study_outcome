package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard;", "Landroid/os/Parcelable;", "isIndependent", "", "cardProviders", "", "Lcom/obric/capabilitykit/common/CardProvider;", "(Ljava/lang/Boolean;[Lcom/obric/capabilitykit/common/CardProvider;)V", "getCardProviders", "()[Lcom/obric/capabilitykit/common/CardProvider;", "setCardProviders", "([Lcom/obric/capabilitykit/common/CardProvider;)V", "[Lcom/obric/capabilitykit/common/CardProvider;", "()Ljava/lang/Boolean;", "setIndependent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class RemoteCard implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @Nullable
    private CardProvider[] cardProviders;

    @Nullable
    private Boolean isIndependent;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/RemoteCard;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/RemoteCard;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<RemoteCard> {
        private a() {
        }

        @NotNull
        public RemoteCard a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            kotlin.jvm.internal.q.g(r10, "parcel");
            Object r12 = r10.readValue(CardProvider.class.getClassLoader());
            if ((r12 instanceof Boolean) == false) goto L5;
            Boolean r13 = (Boolean) r12;
        L6:
            int r14 = r10.readInt();
            CardProvider[] r15 = new CardProvider[r14];
            int r16 = 0;
        L7:
            if (r16 >= r14) goto L9;
            r15[r16] = (CardProvider) r10.readParcelable(CardProvider.class.getClassLoader());
            r16 = r16 + 1;
            goto L7
        L9:
            RemoteCard r17 = new RemoteCard(r13, r15);
            int r18 = Math.min(r11, 0);
            ClassLoader r19 = a.class.getClassLoader();
            int r20 = 1;
        L10:
            if (r20 > r18) goto L12;
            r20 = r20 + 1;
        L12:
            if (r20 > r11) goto L14;
            be.a.d(r10, r19);
            r20 = r20 + 1;
            goto L12
        L14:
            return r17;
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteCard createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteCard[] newArray(int r10) {
            return a(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @NotNull
        public RemoteCard[] a(int r10) {
            return new RemoteCard[r10];
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCard() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final CardProvider[] getCardProviders() {
        return this.cardProviders;
    }

    @Nullable
    public final Boolean isIndependent() {
        return this.isIndependent;
    }

    public final void setCardProviders(@Nullable CardProvider[] r10) {
        this.cardProviders = r10;
    }

    public final void setIndependent(@Nullable Boolean r10) {
        this.isIndependent = r10;
    }

    @NotNull
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("RemoteCard(isIndependent=");
        r10.append(this.isIndependent);
        r10.append(", cardProviders=");
        String r11 = Arrays.toString(this.cardProviders);
        kotlin.jvm.internal.q.f(r11, "java.util.Arrays.toString(this)");
        r10.append(r11);
        r10.append(')');
        return r10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeValue(this.isIndependent);
        CardProvider[] r13 = this.cardProviders;
        if (r13 == null) goto L5;
        int r14 = r13.length;
    L6:
        r10.writeInt(r14);
        CardProvider[] r15 = this.cardProviders;
        if (r15 == null) goto L11;
        int r16 = r15.length;
    L9:
        if (r12 >= r16) goto L13;
        r10.writeParcelable(r15[r12], r11);
        r12 = r12 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r14 = 0;
        goto L6
    }

    public RemoteCard(@Nullable Boolean r10, @Nullable CardProvider[] r11) {
        this.isIndependent = r10;
        this.cardProviders = r11;
    }

    public /* synthetic */ RemoteCard(Boolean r10, CardProvider[] r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = Boolean.TRUE;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
