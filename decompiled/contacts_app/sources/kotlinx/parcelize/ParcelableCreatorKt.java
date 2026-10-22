package kotlinx.parcelize;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: parcelableCreator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"parcelableCreator", "Landroid/os/Parcelable$Creator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "parcelize-runtime"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ParcelableCreatorKt {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> parcelableCreator() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Parcelable.Creator<T> r3 = null;
        Object r2 = Parcelable.class.getDeclaredField("CREATOR").get(null);
        if ((r2 instanceof Parcelable.Creator) == false) goto L5;
        r3 = (Parcelable.Creator) r2;
    L5:
        if (r3 != null) goto L7;
        StringBuilder r4 = new StringBuilder("Could not access CREATOR field in class ");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw new IllegalArgumentException(r4.append(Reflection.getOrCreateKotlinClass(Parcelable.class).getSimpleName()).toString());
    L7:
        return r3;
    }
}
