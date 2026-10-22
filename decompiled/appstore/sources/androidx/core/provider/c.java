package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.h;
import androidx.core.util.Consumer;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.d f2594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f2595b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2596c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SimpleArrayMap f2597d = null;

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f2599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q.c f2600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2601d;

        public a(String r10, Context r11, q.c r12, int r13) {
            this.f2598a = r10;
            this.f2599b = r11;
            this.f2600c = r12;
            this.f2601d = r13;
        }

        public e a() {
            return c.c(this.f2598a, this.f2599b, this.f2600c, this.f2601d);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class b implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.core.provider.a f2602a;

        public b(androidx.core.provider.a r10) {
            this.f2602a = r10;
        }

        public void a(e r10) {
            if (r10 != null) goto L4;
            r10 = new e(-3);
        L4:
            this.f2602a.b(r10);
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((e) r10);
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.c$c, reason: collision with other inner class name */
    public class CallableC0018c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f2604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q.c f2605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2606d;

        public CallableC0018c(String r10, Context r11, q.c r12, int r13) {
            this.f2603a = r10;
            this.f2604b = r11;
            this.f2605c = r12;
            this.f2606d = r13;
        }

        public e a() {
            return c.c(this.f2603a, this.f2604b, this.f2605c, this.f2606d);
        L5:
            return new e(-3);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class d implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2607a;

        public d(String r10) {
            this.f2607a = r10;
        }

        public void a(e r10) {
            Object r11 = c.f2596c;
            monitor-enter(r11);
            SimpleArrayMap r12 = c.f2597d;     // Catch: Throwable -> L8
            ArrayList r13 = (ArrayList) r12.get(this.f2607a);     // Catch: Throwable -> L8
            if (r13 != null) goto L10;
            monitor-exit(r11);     // Catch: Throwable -> L8
            return;
        L10:
            r12.remove(this.f2607a);     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            int r14 = 0;
        L14:
            if (r14 >= r13.size()) goto L16;
            ((Consumer) r13.get(r14)).accept(r10);
            r14 = r14 + 1;
            goto L14
        L16:
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((e) r10);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f2608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2609b;

        public e(int r10) {
            this.f2608a = null;
            this.f2609b = r10;
        }

        public boolean a() {
            if (this.f2609b != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public e(Typeface r10) {
            this.f2608a = r10;
            this.f2609b = 0;
        }
    }

    static {
        f2594a = new androidx.collection.d(16);
        f2595b = q.d.a("fonts-androidx", 10, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        f2596c = new Object();
        f2597d = new SimpleArrayMap();
    }

    public static String a(q.c r10, int r11) {
        return r10.d() + "-" + r11;
    }

    public static int b(FontsContractCompat.a r10) {
        int r11 = 1;
        if (r10.c() != 0) goto L5;
        FontsContractCompat.b[] r12 = r10.b();
        if (r12 != null) goto L12;
    L23:
        return r11;
    L12:
        if (r12.length == 0) goto L23;
        int r13 = r12.length;
        r11 = 0;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L23;
        int r15 = r12[r14].b();
        if (r15 != 0) goto L18;
        r14 = r14 + 1;
        goto L15
    L18:
        if (r15 >= 0) goto L21;
        return -3;
    L21:
        return r15;
    L5:
        if (r10.c() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }

    public static e c(String r10, Context r11, q.c r12, int r13) {
        androidx.collection.d r14 = f2594a;
        Typeface r15 = (Typeface) r14.c(r10);
        if (r15 == null) goto L20;
        return new e(r15);
    L20:
        FontsContractCompat.a r16 = androidx.core.provider.b.e(r11, r12, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r17 = b(r16);
        if (r17 != 0) goto L11;
        Typeface r18 = h.b(r11, null, r16.b(), r13);
        if (r18 == null) goto L17;
        r14.d(r10, r18);
        return new e(r18);
    L17:
        return new e(-3);
    L11:
        return new e(r17);
    L19:
        return new e(-1);
    }

    public static Typeface d(Context r10, q.c r11, int r12, Executor r13, androidx.core.provider.a r14) {
        String r15 = a(r11, r12);
        Typeface r16 = (Typeface) f2594a.c(r15);
        if (r16 == null) goto L6;
        r14.b(new e(r16));
        return r16;
    L6:
        b r17 = new b(r14);
        Object r18 = f2596c;
        monitor-enter(r18);
        SimpleArrayMap r19 = f2597d;     // Catch: Throwable -> L13
        ArrayList r20 = (ArrayList) r19.get(r15);     // Catch: Throwable -> L13
        if (r20 == null) goto L15;
        r20.add(r17);     // Catch: Throwable -> L13
        monitor-exit(r18);     // Catch: Throwable -> L13
        return null;
    L15:
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L13
        r21.add(r17);     // Catch: Throwable -> L13
        r19.put(r15, r21);     // Catch: Throwable -> L13
        monitor-exit(r18);     // Catch: Throwable -> L13
        CallableC0018c r22 = new CallableC0018c(r15, r10, r11, r12);
        if (r13 != null) goto L20;
        r13 = f2595b;
    L20:
        q.d.b(r13, r22, new d(r15));
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public static Typeface e(Context r10, q.c r11, androidx.core.provider.a r12, int r13, int r14) {
        String r15 = a(r11, r13);
        Typeface r16 = (Typeface) f2594a.c(r15);
        if (r16 == null) goto L7;
        r12.b(new e(r16));
        return r16;
    L7:
        if (r14 != (-1)) goto L10;
        e r17 = c(r15, r10, r11, r13);
        r12.b(r17);
        return r17.f2608a;
    L10:
        a r18 = new a(r15, r10, r11, r13);
        e r19 = (e) q.d.c(f2595b, r18, r14);     // Catch: InterruptedException -> L13
        r12.b(r19);     // Catch: InterruptedException -> L13
        return r19.f2608a;
    L13:
        r12.b(new e(-3));
        return null;
    }
}
