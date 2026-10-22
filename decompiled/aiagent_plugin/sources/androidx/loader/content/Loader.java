package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class Loader<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a<D> f2097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f2098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2100e;
    boolean f;
    boolean g;
    boolean h;

    public final class ForceLoadContentObserver extends ContentObserver {
        final /* synthetic */ Loader this$0;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        public ForceLoadContentObserver(Loader r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            this.this$0.m();
        }
    }

    public interface a<D> {
    }

    public void b() {
    }

    public boolean d() {
        return false;
    }

    public void f() {
    }

    public void h() {
    }

    public void j() {
    }

    public void l() {
    }

    public Context getContext() {
        return this.f2098c;
    }

    public void a(a<D> r3) {
        a<D> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        a<D> r0 = this.f2097b;
        if (r0 == null) goto L10;
        if (r0 != r4) goto L8;
        this.f2097b = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    public final void a() {
        this.f2099d = true;
        this.f = false;
        this.f2100e = false;
        b();
    }

    public boolean c() {
        return d();
    }

    public void e() {
        f();
    }

    public void g() {
        this.f2099d = false;
        h();
    }

    public void i() {
        this.f2100e = true;
        j();
    }

    public void k() {
        l();
        this.f = true;
        this.f2099d = false;
        this.f2100e = false;
        this.g = false;
        this.h = false;
    }

    public void m() {
        if (this.f2099d == false) goto L5;
        e();
        return;
    L5:
        this.g = true;
    }

    public String a(D r2) {
        StringBuilder r1 = new StringBuilder(64);
        b.a(r2, r1);
        r1.append("}");
        return r1.toString();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        b.a(this, r0);
        r0.append(" id=");
        r0.append(this.f2096a);
        r0.append("}");
        return r0.toString();
    }

    @Deprecated
    public void a(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        r3.print(r1);
        r3.print("mId=");
        r3.print(this.f2096a);
        r3.print(" mListener=");
        r3.println(this.f2097b);
        if (this.f2099d == false) goto L5;
    L8:
        r3.print(r1);
        r3.print("mStarted=");
        r3.print(this.f2099d);
        r3.print(" mContentChanged=");
        r3.print(this.g);
        r3.print(" mProcessingChange=");
        r3.println(this.h);
    L10:
        if (this.f2100e == false) goto L12;
    L13:
        r3.print(r1);
        r3.print("mAbandoned=");
        r3.print(this.f2100e);
        r3.print(" mReset=");
        r3.println(this.f);
        return;
    L12:
        if (this.f == true) goto L13;
        return;
    L5:
        if (this.g == true) goto L8;
        if (this.h == false) goto L10;
        goto L8
    }
}
