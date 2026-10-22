package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import stepos.support.v7.app.AbstractActivityC0866k;

/* loaded from: classes.dex */
public abstract class L extends J {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f3625a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3626b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f3627c;

    /* renamed from: d, reason: collision with root package name */
    public final Z f3628d;

    public L(AbstractActivityC0866k abstractActivityC0866k) {
        Handler handler = new Handler();
        this.f3628d = new Z();
        this.f3625a = abstractActivityC0866k;
        this.f3626b = abstractActivityC0866k;
        this.f3627c = handler;
    }
}
