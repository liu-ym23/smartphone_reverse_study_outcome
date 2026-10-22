package com.bytedanceos.appstore.buss.network;

import android.os.Environment;
import com.bytedanceos.appstore.buss.network.base.BaseHttpEngine;
import com.bytedanceos.appstore.buss.utilities.l;
import com.bytedanceos.common.BaseApplication;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public final class AssistantHttpEngine extends BaseHttpEngine {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AssistantHttpEngine f8771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8772c = null;

    static {
        f8771b = new AssistantHttpEngine();
        f8772c = kotlin.b.b(AssistantHttpEngine$service$2.INSTANCE);
    }

    public AssistantHttpEngine() {
    }

    public static final /* synthetic */ Object e(AssistantHttpEngine r10, Class r11, String r12) {
        return r10.c(r11, r12);
    }

    @Override // com.bytedanceos.appstore.buss.network.base.BaseHttpEngine
    public void d(OkHttpClient.Builder r10) {
        q.g(r10, "builder");
        super.d(r10);
        r10.a(new q7.b());
        r10.a(new q7.f());
        f(r10);
    }

    public final void f(OkHttpClient.Builder r10) {
        r10.d(new Cache(new File(Environment.getExternalStorageDirectory(), "/Android/data/" + BaseApplication.c().getPackageName() + "/cache/ok_cache"), l.a(10)));
        r10.b(new q7.a());
    }

    public final StoreService g() {
        return (StoreService) f8772c.getValue();
    }
}
