package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "Landroidx/compose/runtime/o;", "Landroid/os/Parcelable;", "", UxipConstants.f30680s, "<init>", "(J)V", "Landroid/os/Parcel;", "parcel", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Companion", Const.INTENT_KEY_PKGNAME, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class ParcelableSnapshotMutableLongState extends MutableLongState implements Parcelable {
    public static final Parcelable.Creator<ParcelableSnapshotMutableLongState> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/compose/runtime/ParcelableSnapshotMutableLongState$a", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ParcelableSnapshotMutableLongState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSnapshotMutableLongState createFromParcel(Parcel parcel) {
            return new ParcelableSnapshotMutableLongState(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSnapshotMutableLongState[] newArray(int size) {
            return new ParcelableSnapshotMutableLongState[size];
        }
    }

    public ParcelableSnapshotMutableLongState(long j10) {
        super(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.d
    /* renamed from: getValue */
    public /* bridge */ /* synthetic */ Long mo4getValue() {
        return super.mo4getValue();
    }

    @Override // androidx.compose.runtime.d
    public /* bridge */ /* synthetic */ void setValue(long j10) {
        super.setValue(j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(getLongValue());
    }

    @Override // androidx.compose.runtime.d
    /* renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo4getValue() {
        return super.mo4getValue();
    }

    @Override // androidx.compose.runtime.d
    public /* bridge */ /* synthetic */ void setValue(Object obj) {
        super.setValue(obj);
    }
}
