package stepos.support.v7.app;

import android.R;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* renamed from: stepos.support.v7.app.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1968q extends AbstractC1975y {

    /* renamed from: Z, reason: collision with root package name */
    public static C1973w f6332Z;

    /* renamed from: V, reason: collision with root package name */
    public int f6333V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f6334W;

    /* renamed from: X, reason: collision with root package name */
    public B1.c f6335X;

    /* renamed from: Y, reason: collision with root package name */
    public final UiModeManager f6336Y;

    public C1968q(Context context, Window window, InterfaceC1963l interfaceC1963l) {
        super(context, window, interfaceC1963l);
        this.f6333V = -100;
        this.f6334W = true;
        this.f6335X = new B1.c(this);
        this.f6336Y = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    @Override // stepos.support.v7.app.AbstractC1964m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r5 = this;
            int r0 = r5.f6333V
            r1 = -100
            r2 = -1
            if (r0 != r1) goto L8
            r0 = r2
        L8:
            if (r0 != 0) goto L14
            android.app.UiModeManager r1 = r5.f6336Y
            int r1 = r1.getNightMode()
            if (r1 != 0) goto L14
        L12:
            r0 = -1
            goto L58
        L14:
            r1 = -100
            if (r0 == r1) goto L12
            if (r0 == 0) goto L1b
            goto L58
        L1b:
            stepos.support.v7.app.w r0 = stepos.support.v7.app.C1968q.f6332Z
            if (r0 != 0) goto L2c
            stepos.support.v7.app.w r0 = new stepos.support.v7.app.w
            android.content.Context r1 = r5.f6316a
            r1.getApplicationContext()
            r1 = 5
            r0.<init>(r1)
            stepos.support.v7.app.C1968q.f6332Z = r0
        L2c:
            stepos.support.v7.app.w r0 = stepos.support.v7.app.C1968q.f6332Z
            r0.getClass()
            r0 = 0
            long r3 = java.lang.System.currentTimeMillis()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L3c
            goto L55
        L3c:
            java.lang.String r0 = "TwilightManager"
            java.lang.String r1 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."
            android.util.Log.i(r0, r1)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r1 = 11
            int r0 = r0.get(r1)
            r1 = 6
            if (r0 < r1) goto L57
            r1 = 22
            if (r0 < r1) goto L55
            goto L57
        L55:
            r0 = 1
            goto L58
        L57:
            r0 = 2
        L58:
            if (r0 == r2) goto L84
            android.content.Context r5 = r5.f6316a
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Configuration r1 = r5.getConfiguration()
            int r2 = r1.uiMode
            r2 = r2 & 48
            r3 = 2
            if (r0 != r3) goto L6e
            r0 = 32
            goto L70
        L6e:
            r0 = 16
        L70:
            if (r2 == r0) goto L84
            android.content.res.Configuration r2 = new android.content.res.Configuration
            r2.<init>(r1)
            int r1 = r2.uiMode
            r1 = r1 & (-49)
            r0 = r0 | r1
            r2.uiMode = r0
            r0 = 0
            r5.updateConfiguration(r2, r0)
            r5 = 1
            return r5
        L84:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.C1968q.a():boolean");
    }

    @Override // stepos.support.v7.app.AbstractC1975y, stepos.support.v7.app.AbstractC1964m
    public final void c(Bundle bundle) {
        super.c(bundle);
        if (bundle == null || this.f6333V != -100) {
            return;
        }
        this.f6333V = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.AbstractC1964m
    public final void d(Bundle bundle) {
        int i = this.f6333V;
        if (i != -100) {
            bundle.putInt("appcompat:local_night_mode", i);
        }
    }

    @Override // stepos.support.v7.app.AbstractC1966o
    public final Window.Callback n(Window.Callback callback) {
        return new C1967p(this, callback);
    }

    @Override // stepos.support.v7.app.AbstractC1975y
    public final View p(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // stepos.support.v7.app.AbstractC1975y
    public final void w(ViewGroup viewGroup) {
        View viewFindViewById = viewGroup.findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof FitsWindowsContentLayout)) {
            return;
        }
        ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.f6335X);
    }
}
