package i2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import stepos.support.v7.app.d;
import stepos.support.v7.widget.m;

/* renamed from: i2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0758a extends d {
    protected void A() {
    }

    protected void B() {
    }

    protected void C() {
    }

    protected void D() {
        TypedArray typedArrayObtainStyledAttributes = getTheme().obtainStyledAttributes(P1.d.f4760n4);
        setTheme(typedArrayObtainStyledAttributes.getResourceId(P1.d.f4766o4, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D();
        z();
        A();
        C();
        B();
        View viewX = x();
        if (viewX != null) {
            setContentView(viewX);
        }
        y(viewX, bundle);
    }

    public int t() {
        return u() + v();
    }

    public int u() {
        return T1.a.a(this);
    }

    public int v() {
        return T1.a.c(this);
    }

    protected void w(View view) {
        if (view == null || view.getFitsSystemWindows()) {
            return;
        }
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setPaddingRelative(view.getPaddingStart(), t() + paddingTop, view.getPaddingEnd(), paddingBottom);
    }

    public abstract View x();

    public void y(View view, Bundle bundle) {
        w(view);
    }

    protected void z() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.y(null);
        m mVarP = supportActionBar.p();
        if (mVarP == null) {
            return;
        }
        mVarP.g(null);
    }
}
