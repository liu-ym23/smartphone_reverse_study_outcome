package c1;

import B0.f;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;

/* renamed from: c1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0390a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iD0 = f.D0(parcel);
        int iO0 = 0;
        int iO02 = 0;
        boolean zI0 = false;
        int iO03 = 0;
        boolean zI02 = false;
        int iO04 = 0;
        String strQ = null;
        String strQ2 = null;
        zaa zaaVar = null;
        while (parcel.dataPosition() < iD0) {
            int i4 = parcel.readInt();
            switch ((char) i4) {
                case 1:
                    iO0 = f.o0(parcel, i4);
                    break;
                case 2:
                    iO02 = f.o0(parcel, i4);
                    break;
                case 3:
                    zI0 = f.i0(parcel, i4);
                    break;
                case 4:
                    iO03 = f.o0(parcel, i4);
                    break;
                case 5:
                    zI02 = f.i0(parcel, i4);
                    break;
                case 6:
                    strQ = f.q(parcel, i4);
                    break;
                case 7:
                    iO04 = f.o0(parcel, i4);
                    break;
                case '\b':
                    strQ2 = f.q(parcel, i4);
                    break;
                case '\t':
                    zaaVar = (zaa) f.p(parcel, i4, zaa.CREATOR);
                    break;
                default:
                    f.z0(parcel, i4);
                    break;
            }
        }
        f.t(parcel, iD0);
        return new FastJsonResponse$Field(iO0, iO02, zI0, iO03, zI02, strQ, iO04, strQ2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new FastJsonResponse$Field[i4];
    }
}
