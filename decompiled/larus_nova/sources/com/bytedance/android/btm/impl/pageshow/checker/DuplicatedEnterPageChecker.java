package com.bytedance.android.btm.impl.pageshow.checker;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DuplicatedEnterPageChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, a> f42418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f42419b = null;

    /* JADX INFO: loaded from: classes43.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f42420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f42422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f42423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f42424e;

        public a(String r100, String r101, String r102, String r103) {
            this.f42420a = r100;
            this.f42421b = r101;
            this.f42422c = r102;
            this.f42423d = r103;
            this.f42424e = null;
        }
    }

    static {
        f42418a = new HashMap();
        f42419b = LazyKt.lazy(DuplicatedEnterPageChecker$enable$2.INSTANCE);
    }

    public static void a(String r100, final String r101) {
        if (r101 == null) goto L15;
        final a r102 = f42418a.get(r100);
        if (r102 == null) goto L16;
        String r103 = r102.f42424e;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L17;
        r102.f42424e = r101;
        Lazy r105 = BtmMonitor.f42159a;
        new DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$1(r102, r101).run();
        return;
    L17:
        return;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L16:
        return;
    }
}
