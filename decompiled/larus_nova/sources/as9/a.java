package as9;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0219a f16138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<Float, Float>> f16142e;

    /* JADX INFO: renamed from: as9.a$a, reason: collision with other inner class name */
    public interface InterfaceC0219a {
        void onStatusGenerate(int r100, float r101);
    }

    public abstract boolean a();

    public abstract int c();

    public abstract void e();

    public final synchronized void f() {
        monitor-enter(this);
        this.f16138a = null;     // Catch: Throwable -> L7
        e();     // Catch: Throwable -> L7
        toString();     // Catch: Throwable -> L7
        boolean r100 = bs9.a.f20322a;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public float b() {
        return this.f16140c;
    }

    public final synchronized boolean g(c.b r100) {
        monitor-enter(this);
        this.f16138a = r100;     // Catch: Throwable -> L6
        boolean r101 = a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public a(Context r100, Looper r101) {
        this.f16140c = -99.0f;
        this.f16141d = -1;
        this.f16142e = new ArrayList();
        this.f16139b = r100;
        if (r101 != null) goto L6;
        r100.getMainLooper();
        return;
    }

    public final int d(float r100, boolean r101) {
        int r102 = ((ArrayList) this.f16142e).size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L18;
        Pair r105 = (Pair) ListProtector.get(this.f16142e, r103);
        if (r105 == null) goto L16;
        if (r101 == false) goto L8;
        Object r106 = r105.first;
    L10:
        if (r100 < ((Float) r106).floatValue()) goto L18;
        if (r101 == false) goto L13;
    L15:
        r104 = r103;
        goto L16
    L13:
        if (r103 != this.f16141d) goto L15;
        return r103;
    L8:
        r106 = r105.second;
    L16:
        r103 = r103 + 1;
    L18:
        return r104;
    }
}
