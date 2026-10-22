package com.obric.appstore.network;

import android.os.Environment;
import com.obric.appstore.util.o;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.i;

/* JADX INFO: loaded from: classes3.dex */
public final class StoreHttpEngine extends BaseHttpEngine {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StoreHttpEngine f10958b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f10959c = null;

    static {
        f10958b = new StoreHttpEngine();
        f10959c = kotlin.b.b(StoreHttpEngine$service$2.INSTANCE);
    }

    public StoreHttpEngine() {
    }

    @Override // com.obric.appstore.network.BaseHttpEngine
    public void f(OkHttpClient.Builder r10) {
        q.g(r10, "builder");
        super.f(r10);
        r10.a(new wa.b());
        g(r10);
        r10.b(new wa.c());
    }

    public final void g(OkHttpClient.Builder r10) {
        File r11 = new File(Environment.getExternalStorageDirectory(), "/Android/data/" + pa.a.f23414a.a().getPackageName() + "/cache/obric_ok_cache");
        long r12 = o.a(10);
        Cache r13 = new Cache(r11, r12);
        com.bytedance.apm.util.q.c(r13, "internalCache", new i(r11, r12).f22967a);
        r10.d(r13);
        r10.b(new wa.e());
    }

    public final StoreService h() {
        return (StoreService) f10959c.getValue();
    }
}
