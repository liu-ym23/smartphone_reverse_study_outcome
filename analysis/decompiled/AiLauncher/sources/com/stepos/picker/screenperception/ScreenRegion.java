package com.stepos.picker.screenperception;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0012J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b'\u0010\u0014¨\u0006*"}, d2 = {"Lcom/stepos/picker/screenperception/ScreenRegion;", "Landroid/os/Parcelable;", "Lcom/stepos/picker/screenperception/ScreenPoint;", "topLeft", "topRight", "bottomRight", "bottomLeft", "<init>", "(Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lcom/stepos/picker/screenperception/ScreenPoint;", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;Lcom/stepos/picker/screenperception/ScreenPoint;)Lcom/stepos/picker/screenperception/ScreenRegion;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/picker/screenperception/ScreenPoint;", "getTopLeft", "getTopRight", "getBottomRight", "getBottomLeft", "CREATOR", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ScreenRegion implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ScreenPoint bottomLeft;
    private final ScreenPoint bottomRight;
    private final ScreenPoint topLeft;
    private final ScreenPoint topRight;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/picker/screenperception/ScreenRegion$a;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/picker/screenperception/ScreenRegion;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/picker/screenperception/ScreenRegion;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/picker/screenperception/ScreenRegion;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.picker.screenperception.ScreenRegion$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ScreenRegion> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScreenRegion createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ScreenRegion(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScreenRegion[] newArray(int size) {
            return new ScreenRegion[size];
        }

        public Companion() {
        }
    }

    public ScreenRegion(ScreenPoint topLeft, ScreenPoint topRight, ScreenPoint bottomRight, ScreenPoint bottomLeft) {
        p.i(topLeft, "topLeft");
        p.i(topRight, "topRight");
        p.i(bottomRight, "bottomRight");
        p.i(bottomLeft, "bottomLeft");
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }

    public static /* synthetic */ ScreenRegion copy$default(ScreenRegion screenRegion, ScreenPoint screenPoint, ScreenPoint screenPoint2, ScreenPoint screenPoint3, ScreenPoint screenPoint4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            screenPoint = screenRegion.topLeft;
        }
        if ((i10 & 2) != 0) {
            screenPoint2 = screenRegion.topRight;
        }
        if ((i10 & 4) != 0) {
            screenPoint3 = screenRegion.bottomRight;
        }
        if ((i10 & 8) != 0) {
            screenPoint4 = screenRegion.bottomLeft;
        }
        return screenRegion.copy(screenPoint, screenPoint2, screenPoint3, screenPoint4);
    }

    /* renamed from: component1, reason: from getter */
    public final ScreenPoint getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final ScreenPoint getTopRight() {
        return this.topRight;
    }

    /* renamed from: component3, reason: from getter */
    public final ScreenPoint getBottomRight() {
        return this.bottomRight;
    }

    /* renamed from: component4, reason: from getter */
    public final ScreenPoint getBottomLeft() {
        return this.bottomLeft;
    }

    public final ScreenRegion copy(ScreenPoint topLeft, ScreenPoint topRight, ScreenPoint bottomRight, ScreenPoint bottomLeft) {
        p.i(topLeft, "topLeft");
        p.i(topRight, "topRight");
        p.i(bottomRight, "bottomRight");
        p.i(bottomLeft, "bottomLeft");
        return new ScreenRegion(topLeft, topRight, bottomRight, bottomLeft);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenRegion)) {
            return false;
        }
        ScreenRegion screenRegion = (ScreenRegion) other;
        return p.d(this.topLeft, screenRegion.topLeft) && p.d(this.topRight, screenRegion.topRight) && p.d(this.bottomRight, screenRegion.bottomRight) && p.d(this.bottomLeft, screenRegion.bottomLeft);
    }

    public final ScreenPoint getBottomLeft() {
        return this.bottomLeft;
    }

    public final ScreenPoint getBottomRight() {
        return this.bottomRight;
    }

    public final ScreenPoint getTopLeft() {
        return this.topLeft;
    }

    public final ScreenPoint getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        return (((((this.topLeft.hashCode() * 31) + this.topRight.hashCode()) * 31) + this.bottomRight.hashCode()) * 31) + this.bottomLeft.hashCode();
    }

    public String toString() {
        return "ScreenRegion(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeParcelable(this.topLeft, flags);
        parcel.writeParcelable(this.topRight, flags);
        parcel.writeParcelable(this.bottomRight, flags);
        parcel.writeParcelable(this.bottomLeft, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ScreenRegion(Parcel parcel) {
        p.i(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(ScreenPoint.class.getClassLoader());
        p.f(parcelable);
        Parcelable parcelable2 = parcel.readParcelable(ScreenPoint.class.getClassLoader());
        p.f(parcelable2);
        Parcelable parcelable3 = parcel.readParcelable(ScreenPoint.class.getClassLoader());
        p.f(parcelable3);
        Parcelable parcelable4 = parcel.readParcelable(ScreenPoint.class.getClassLoader());
        p.f(parcelable4);
        this((ScreenPoint) parcelable, (ScreenPoint) parcelable2, (ScreenPoint) parcelable3, (ScreenPoint) parcelable4);
    }
}
