package stepos.support.v7.app;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.Calendar;
import stepos.support.v7.app.i;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class k extends j {
    public static jd.b T;
    public int Q;
    public boolean R;
    public a S;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements FitsWindowsContentLayout.a {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends i.b {
        public b(Window.Callback callback) {
            super(callback);
        }
    }

    public int B(int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != 0) {
            return i10;
        }
        if (T == null) {
            this.f12125a.getApplicationContext();
            T = new jd.b();
        }
        T.getClass();
        if (0 > System.currentTimeMillis()) {
            return 1;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i11 = Calendar.getInstance().get(11);
        return (i11 < 6 || i11 >= 22) ? 2 : 1;
    }

    @Override // stepos.support.v7.app.h
    public final boolean c() {
        int i10 = this.Q;
        if (i10 == -100) {
            i10 = -1;
        }
        int iB = B(i10);
        if (iB == -1) {
            return false;
        }
        Resources resources = this.f12125a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i11 = configuration.uiMode & 48;
        int i12 = iB == 2 ? 32 : 16;
        if (i11 == i12) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i12 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    @Override // stepos.support.v7.app.AppCompatDelegateImplV7, stepos.support.v7.app.h
    public final void e(Bundle bundle) {
        super.e(bundle);
        if (bundle == null || this.Q != -100) {
            return;
        }
        this.Q = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.h
    public final void f(Bundle bundle) {
        int i10 = this.Q;
        if (i10 != -100) {
            bundle.putInt("appcompat:local_night_mode", i10);
        }
    }

    @Override // stepos.support.v7.app.AppCompatDelegateImplV7
    public final void v(ViewGroup viewGroup) {
        View viewFindViewById = viewGroup.findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof FitsWindowsContentLayout)) {
            return;
        }
        ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.S);
    }
}
