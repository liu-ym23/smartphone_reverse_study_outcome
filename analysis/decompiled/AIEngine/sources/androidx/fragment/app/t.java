package androidx.fragment.app;

import android.os.Handler;
import android.view.LayoutInflater;
import java.io.PrintWriter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class t<E> extends q {

    /* renamed from: a, reason: collision with root package name */
    public final o f2193a;

    /* renamed from: b, reason: collision with root package name */
    public final o f2194b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f2195c;

    /* renamed from: d, reason: collision with root package name */
    public final y f2196d;

    public t(o oVar) {
        Handler handler = new Handler();
        this.f2196d = new y();
        this.f2193a = oVar;
        this.f2194b = oVar;
        this.f2195c = handler;
    }

    public abstract void d(PrintWriter printWriter, String[] strArr);

    public abstract o e();

    public abstract LayoutInflater f();

    public abstract boolean g(String str);

    public abstract void h();
}
