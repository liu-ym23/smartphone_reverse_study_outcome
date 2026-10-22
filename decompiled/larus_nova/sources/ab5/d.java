package ab5;

import androidx.fragment.app.FragmentActivity;
import bb5.g;
import com.bytedance.ee.util.ui.j;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements ab5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f2485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Long, Long> f2486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ip5.b f2487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDDialog f2489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FragmentActivity f2490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f2492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Integer, Float> f2493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2494k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.FloatRef f2496b;

        public a(d r100, Ref.FloatRef r101) {
            this.f2495a = r100;
            this.f2496b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2495a.f2487d.b((int) this.f2496b.element);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // ab5.a
    public final void cancel() {
        UDDialog r100 = this.f2489f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        r100 = null;
    L5:
        r100.cancel();
    }

    public d(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f2484a = new AtomicInteger(0);
        this.f2485b = new AtomicInteger(0);
        this.f2486c = new ConcurrentHashMap();
        this.f2488e = 303;
        this.f2490g = r100;
        this.f2491h = "VIDEO_COMPRESS";
        this.f2493j = new LinkedHashMap();
        this.f2494k = 9;
        this.f2487d = new ip5.b(r100);
    }

    @Override // ab5.a
    public final void a(int r100, float r101) {
        this.f2493j.put(Integer.valueOf(r100), Float.valueOf(r101));     // Catch: Exception -> L8
        Ref.FloatRef r102 = new Ref.FloatRef();     // Catch: Exception -> L8
        Iterator r103 = ((LinkedHashMap) this.f2493j).entrySet().iterator();     // Catch: Exception -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.element += ((Number) ((Map.Entry) r103.next()).getValue()).floatValue();     // Catch: Exception -> L8
        goto L4
    L6:
        r102.element = (r102.element * 100) / this.f2494k;     // Catch: Exception -> L8
        j.c(new a(this, r102));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.d(this.f2491h, "updateProgress:" + e);
    }
}
