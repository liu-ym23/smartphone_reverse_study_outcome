package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class p<E> extends AbstractC0518m {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f10708a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f10709b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f10710c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10711d;

    /* renamed from: e, reason: collision with root package name */
    final x f10712e;

    p(ActivityC0516k activityC0516k) {
        this(activityC0516k, activityC0516k, new Handler(), 0);
    }

    @Override // androidx.fragment.app.AbstractC0518m
    public View c(int i5) {
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0518m
    public boolean d() {
        return true;
    }

    Activity e() {
        return this.f10708a;
    }

    Context f() {
        return this.f10709b;
    }

    public Handler g() {
        return this.f10710c;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f10709b);
    }

    @Deprecated
    public void k(ComponentCallbacksC0511f componentCallbacksC0511f, String[] strArr, int i5) {
    }

    public void l(ComponentCallbacksC0511f componentCallbacksC0511f, Intent intent, int i5, Bundle bundle) {
        if (i5 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.l(this.f10709b, intent, bundle);
    }

    @Deprecated
    public void m(ComponentCallbacksC0511f componentCallbacksC0511f, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        if (i5 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.a.u(this.f10708a, intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public void n() {
    }

    p(Activity activity, Context context, Handler handler, int i5) {
        this.f10712e = new y();
        this.f10708a = activity;
        this.f10709b = (Context) D.h.f(context, "context == null");
        this.f10710c = (Handler) D.h.f(handler, "handler == null");
        this.f10711d = i5;
    }
}
