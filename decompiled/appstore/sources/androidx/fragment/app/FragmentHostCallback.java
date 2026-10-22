package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback extends FragmentContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f3181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f3183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentManager f3185e;

    public FragmentHostCallback(FragmentActivity r10) {
        this(r10, r10, new Handler(), 0);
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View b(int r10) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean c() {
        return true;
    }

    public Activity d() {
        return this.f3181a;
    }

    public Context e() {
        return this.f3182b;
    }

    public Handler f() {
        return this.f3183c;
    }

    public void g(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
    }

    public abstract Object h();

    public LayoutInflater i() {
        return LayoutInflater.from(this.f3182b);
    }

    public void j(Fragment r10, String[] r11, int r12) {
    }

    public boolean k(String r10) {
        return false;
    }

    public void l(Fragment r10, Intent r11, int r12, Bundle r13) {
        if (r12 != (-1)) goto L7;
        ContextCompat.k(this.f3182b, r11, r13);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void m(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        if (r12 != (-1)) goto L7;
        ActivityCompat.v(this.f3181a, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void n() {
    }

    public FragmentHostCallback(Activity r10, Context r11, Handler r12, int r13) {
        this.f3185e = new x();
        this.f3181a = r10;
        this.f3182b = (Context) androidx.core.util.e.h(r11, "context == null");
        this.f3183c = (Handler) androidx.core.util.e.h(r12, "handler == null");
        this.f3184d = r13;
    }
}
