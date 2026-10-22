package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class DomainPreConnect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, a> f44727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44728b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DomainPreConnect f44729c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f44730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f44731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f44732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f44733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f44734e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f44733d, r101.f44733d) == true) goto L8;
            return false;
        L8:
            if (this.f44734e == r101.f44734e) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f44733d;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.f44734e;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "PreConnectConfig(domainUrl=" + this.f44733d + ", minIntervalNanoTime=" + this.f44734e + ")";
        }

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "domainUrl");
            this.f44733d = r100;
            this.f44734e = r101;
        }
    }

    public DomainPreConnect() {
    }

    static {
        f44729c = new DomainPreConnect();
        f44728b = LazyKt.lazy(DomainPreConnect$preConnectHandler$2.INSTANCE);
    }

    public final void a(com.bytedance.android.ec.core.imagex.r r100) {
        a r101 = null;
        if ((r100 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r102 = (com.bytedance.android.ec.core.imagex.u) r100;
        if (r102 == null) goto L10;
        com.bytedance.android.shopping.api.image.r r103 = r102.f45062z;
        if (r103 == null) goto L10;
        String r104 = r103.getDomain();
    L11:
        f44729c.getClass();
        ImageDomainPreConnectConfig r105 = ImageDomainPreConnectConfig.f44797d;
        r105.getClass();
        if (((Boolean) ImageDomainPreConnectConfig.f44795b.getValue()).booleanValue() == true) goto L14;
        return;
    L14:
        if (((com.bytedance.android.shopping.api.image.a0) ImageDomainPreConnectConfig.f44796c.getValue(r105, ImageDomainPreConnectConfig.f44794a[0])) == null) goto L31;
        if (r104 == null) goto L20;
        HashMap<String, a> r106 = f44727a;
        if (r106 == null) goto L20;
        r101 = r106.get(r104);
    L20:
        if (r101 != null) goto L22;
        return;
    L22:
        if (r101.f44731b == true) goto L29;
        long r107 = System.nanoTime();
        if ((r107 - r101.f44732c) <= r101.f44734e) goto L30;
        r101.f44731b = true;
        r101.f44730a = r107;
        ((DomainPreConnect$preConnectHandler$2.a) f44728b.getValue()).post(new o(r101, r107));
        Logger.d("ImageDomainPreConnectConfig", "duration " + ThreadMethodProxy.currentThread().getName() + ' ' + com.bytedance.android.ec.core.imagex.common.e.a(r107));
        return;
    L30:
        return;
    L29:
        return;
    L31:
        return;
    L10:
        r104 = null;
        goto L11
    }
}
