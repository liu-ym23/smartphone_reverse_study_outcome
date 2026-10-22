package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* renamed from: stepos.support.v7.app.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0873s extends AbstractC0871p {
    public static C0878x T;

    /* renamed from: Q, reason: collision with root package name */
    public int f14585Q;

    /* renamed from: R, reason: collision with root package name */
    public final boolean f14586R;

    /* renamed from: S, reason: collision with root package name */
    public final C0872q f14587S;

    public AbstractC0873s(Context context, Window window, InterfaceC0867l interfaceC0867l) {
        super(context, window, interfaceC0867l);
        this.f14585Q = -100;
        this.f14586R = true;
        this.f14587S = new C0872q(0, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int C(int r5) {
        /*
            r4 = this;
            r0 = -100
            if (r5 == r0) goto L4a
            if (r5 == 0) goto L7
            return r5
        L7:
            stepos.support.v7.app.x r5 = stepos.support.v7.app.AbstractC0873s.T
            if (r5 != 0) goto L17
            stepos.support.v7.app.x r5 = new stepos.support.v7.app.x
            android.content.Context r4 = r4.f14509a
            r4.getApplicationContext()
            r5.<init>()
            stepos.support.v7.app.AbstractC0873s.T = r5
        L17:
            stepos.support.v7.app.x r4 = stepos.support.v7.app.AbstractC0873s.T
            r4.getClass()
            androidx.appcompat.app.K r4 = stepos.support.v7.app.C0878x.f14594a
            long r0 = r4.f2549b
            long r2 = java.lang.System.currentTimeMillis()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L2d
            boolean r4 = r4.f2548a
            if (r4 == 0) goto L46
            goto L48
        L2d:
            java.lang.String r4 = "TwilightManager"
            java.lang.String r5 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."
            android.util.Log.i(r4, r5)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r5 = 11
            int r4 = r4.get(r5)
            r5 = 6
            if (r4 < r5) goto L48
            r5 = 22
            if (r4 < r5) goto L46
            goto L48
        L46:
            r4 = 1
            goto L49
        L48:
            r4 = 2
        L49:
            return r4
        L4a:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AbstractC0873s.C(int):int");
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final boolean a() {
        int i4 = this.f14585Q;
        if (i4 == -100) {
            i4 = -1;
        }
        int iC = C(i4);
        if (iC == -1) {
            return false;
        }
        Resources resources = this.f14509a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i5 = configuration.uiMode & 48;
        int i6 = iC == 2 ? 32 : 16;
        if (i5 == i6) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i6 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0880z, stepos.support.v7.app.AbstractC0868m
    public final void e(Bundle bundle) {
        super.e(bundle);
        if (bundle == null || this.f14585Q != -100) {
            return;
        }
        this.f14585Q = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.AbstractC0868m
    public final void f(Bundle bundle) {
        int i4 = this.f14585Q;
        if (i4 != -100) {
            bundle.putInt("appcompat:local_night_mode", i4);
        }
    }

    @Override // stepos.support.v7.app.AbstractC0880z
    public final void w(ViewGroup viewGroup) {
        View viewFindViewById = viewGroup.findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof FitsWindowsContentLayout)) {
            return;
        }
        ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.f14587S);
    }
}
