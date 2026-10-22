package stepos.support.v7.app;

import android.os.Parcel;

/* renamed from: stepos.support.v7.app.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0878x {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.appcompat.app.K f14594a = new androidx.appcompat.app.K();

    public static Object a(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImplV7$PanelFeatureState$SavedState appCompatDelegateImplV7$PanelFeatureState$SavedState = new AppCompatDelegateImplV7$PanelFeatureState$SavedState();
        appCompatDelegateImplV7$PanelFeatureState$SavedState.f14263a = parcel.readInt();
        boolean z4 = parcel.readInt() == 1;
        appCompatDelegateImplV7$PanelFeatureState$SavedState.f14264b = z4;
        if (z4) {
            appCompatDelegateImplV7$PanelFeatureState$SavedState.f14265c = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImplV7$PanelFeatureState$SavedState;
    }

    public static Object[] b(int i4) {
        return new AppCompatDelegateImplV7$PanelFeatureState$SavedState[i4];
    }
}
