package com.bytedance.android.shopping.anchorv4.perf.helper;

import android.net.Uri;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpFastUriWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f167187c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f167189b;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f167187c = LazyKt.lazy(PdpFastUriWrapper$Companion$decodeMethod$2.INSTANCE);
    }

    public PdpFastUriWrapper(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "originUri");
        this.f167189b = r100;
        this.f167188a = LazyKt.lazy(PdpFastUriWrapper$cache$2.INSTANCE);
    }

    public final String a(String r100) {
        Lazy r101 = PdpPerfOpt.f43774a;
        Method r102 = (Method) f167187c.getValue();
        return UriProtector.getQueryParameter(this.f167189b, r100);
    }
}
