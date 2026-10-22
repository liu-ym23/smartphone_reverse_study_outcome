package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.api.BcmHostDependManager;
import com.bytedance.android.bcm.impl.model.d;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BcmRuleStore {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f41845e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f41846f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f41847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, com.bytedance.android.bcm.impl.paramcheck.a> f41848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f41849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, d> f41850d;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes43.dex */
    public static final class b implements ic.b {
        public b() {
        }
    }

    static {
        f41845e = LazyKt.lazy(BcmRuleStore$Companion$gson$2.INSTANCE);
        f41846f = LazyKt.lazy(BcmRuleStore$Companion$EMPTY_RULE$2.INSTANCE);
    }

    public final void b() {
        BtmSetting r100 = BtmSetting.f42469d;
        if (r100.c().c().v() == true) goto L5;
        return;
    L5:
        if (this.f41847a.compareAndSet(0, 1) == false) goto L24;
        ALogger r101 = ALogger.f41996d;
        r101.a("ParamsChecker_RuleStore", false, BcmRuleStore$init$1.INSTANCE);
        if (r100.c().c().g().b() != 1) goto L9;
    L12:
        BcmHostDependManager r102 = BcmHostDependManager.f41760e;
        r102.getClass();
        final ic.a r103 = (ic.a) BcmHostDependManager.f41757b.getValue(r102, BcmHostDependManager.f41756a[0]);
    L13:
        if (r103 != null) goto L21;
        r101.a("ParamsChecker_RuleStore", false, BcmRuleStore$init$2.INSTANCE);
        this.f41847a.set(2);
        return;
    L21:
        r101.a("ParamsChecker_RuleStore", false, new BcmRuleStore$init$3(r103));     // Catch: Throwable -> L18
        r103.a(new b());     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        com.bytedance.android.bcm.impl.monitor.b.b(4003, "init BcmParamsChecker failed", null, null, th, null, 188);
        return;
    L9:
        if (BtmHostDependManager.F.c() == false) goto L12;
        BcmHostDependManager.f41760e.getClass();
        r103 = null;
        goto L13
    }

    public BcmRuleStore() {
        this.f41847a = new AtomicInteger(0);
        this.f41848b = new HashMap();
        this.f41849c = new ArrayList();
        this.f41850d = new HashMap();
        new Regex("[>=]");
    }

    public final com.bytedance.android.bcm.impl.paramcheck.a a(String r110) {
        String r100 = null;
        if (this.f41847a.get() != 3) goto L40;
        List<String> r101 = this.f41849c;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator r102 = ((ArrayList) r101).iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        if (StringsKt.startsWith$default(r110, (String) r102.next(), false, 2, null) == false) goto L11;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        return null;
    L18:
        HashMap<String, com.bytedance.android.bcm.impl.paramcheck.a> r104 = this.f41848b;
        Lazy r105 = BtmFormatUtils.f42489a;
        String r106 = "";
        if (r110 == null) goto L21;
        r100 = BtmFormatUtils.f42490b.replace(r110, "");
    L21:
        com.bytedance.android.bcm.impl.paramcheck.a r107 = r104.get(r100);
        if (r107 == null) goto L24;
        return r107;
    L24:
        HashMap<String, com.bytedance.android.bcm.impl.paramcheck.a> r108 = this.f41848b;
        if (r110.length() != 0) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L35;
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r111.size() < 3) goto L34;
        r110 = ((String) ListProtector.get(r111, 0)) + "." + ((String) ListProtector.get(r111, 1)) + "." + ((String) ListProtector.get(r111, 2));
    L34:
        r106 = r110;
    L35:
        com.bytedance.android.bcm.impl.paramcheck.a r112 = r108.get(r106);
        if (r112 == null) goto L39;
        return r112;
    L39:
        return (com.bytedance.android.bcm.impl.paramcheck.a) f41846f.getValue();
    L27:
        r109 = false;
    L15:
        r103 = false;
        goto L16
    L7:
        if (((ArrayList) r101).isEmpty() == false) goto L9;
    L40:
        b();
        return null;
    }
}
