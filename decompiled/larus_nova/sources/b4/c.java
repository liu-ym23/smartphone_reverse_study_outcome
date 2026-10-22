package b4;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f17428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f17429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<InputStream> f17430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f17431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f17432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f17433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<WeakReference<Call<TypedInput>>> f17434g;

    @Override // b4.k
    public final void a() {
        InputStream r100 = this.f17430c.element;     // Catch: Throwable -> L7
        if (r100 == null) goto L20;
        r100.close();     // Catch: Throwable -> L7
    L20:
        WeakReference<Call<TypedInput>> r101 = this.f17434g.element;     // Catch: Throwable -> L17
        if (r101 == null) goto L24;
        Call<TypedInput> r102 = r101.get();     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isCanceled() == true) goto L26;
        r102.cancel();     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close call failed", th);
        return;
    L7:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close inputStream failed", th);
        goto L20
    }

    public final String b() {
        return this.f17431d.element;
    }

    public final Throwable c() {
        return this.f17432e.element;
    }

    public final InputStream d() {
        return this.f17430c.element;
    }

    public c(Map<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<InputStream> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105, Ref.ObjectRef<WeakReference<Call<TypedInput>>> r106) {
        this.f17428a = r100;
        this.f17429b = r101;
        this.f17430c = r102;
        this.f17431d = r103;
        this.f17432e = r104;
        this.f17433f = r105;
        this.f17434g = r106;
    }
}
