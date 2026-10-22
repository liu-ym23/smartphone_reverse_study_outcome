package stepos.support.v7.app;

import android.os.Parcel;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import java.security.InvalidParameterException;

/* renamed from: stepos.support.v7.app.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1973w implements ParcelableCompatCreatorCallbacks, stepos.support.v7.widget.U {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6342a;

    public /* synthetic */ C1973w(int i) {
        this.f6342a = i;
    }

    public void a(int i, U.f fVar) {
        switch (this.f6342a) {
            case 2:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
            case 3:
            default:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
            case 4:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
        }
    }

    @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImplV7$PanelFeatureState$SavedState.readFromParcel(parcel, classLoader);
    }

    @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
    public Object[] newArray(int i) {
        return new AppCompatDelegateImplV7$PanelFeatureState$SavedState[i];
    }
}
