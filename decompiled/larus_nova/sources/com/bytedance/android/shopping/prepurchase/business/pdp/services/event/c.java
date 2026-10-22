package com.bytedance.android.shopping.prepurchase.business.pdp.services.event;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalTestEventRecorder f182093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f182094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StackTraceElement[] f182095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f182096d;

    public c(LocalTestEventRecorder r100, Map r101, StackTraceElement[] r102, String r103) {
        this.f182093a = r100;
        this.f182094b = r101;
        this.f182095c = r102;
        this.f182096d = r103;
    }

    public final void a() {
        ArrayList r100 = new ArrayList();
        Map r101 = this.f182094b;
        if (r101 == null) goto L8;
        Iterator r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.add(((Map.Entry) r102.next()).getKey());
    L8:
        ArrayList r103 = new ArrayList();
        StackTraceElement[] r104 = this.f182095c;
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L9:
        Object r108 = null;
        if (r107 >= r105) goto L37;
        StackTraceElement r110 = r104[r107];
        int r111 = r106 + 1;
        if (r103.size() > 10) goto L36;
        if (r106 < 4) goto L36;
        if (r110 == null) goto L36;
        if (r110.getFileName() == null) goto L36;
        StringBuilder r109 = new StringBuilder();     // Catch: Exception -> L34
        String r112 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r110.getFileName(), new String[]{"."}, false, 0, 6, null), 0);     // Catch: Exception -> L34
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r109.append(r112);     // Catch: Exception -> L34
        r109.append(".");     // Catch: Exception -> L34
        r109.append(r110.getMethodName());     // Catch: Exception -> L34
        String r113 = r109.toString();     // Catch: Exception -> L34
        String r114 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r110.getFileName(), new String[]{"."}, false, 0, 6, null), 0);     // Catch: Exception -> L34
        if (r114 != null) goto L25;
        r114 = "";
    L25:
        String r115 = (String) CollectionsKt.lastOrNull(r103);     // Catch: Exception -> L34
        if (r115 == null) goto L31;
        List r116 = StringsKt.split$default(r115, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L34
        if (r116 == null) goto L31;
        r108 = (String) CollectionsKt.getOrNull(r116, 0);     // Catch: Exception -> L34
    L31:
        if ((true ^ Intrinsics.areEqual(r114, r108)) == false) goto L36;
        r103.add(r113);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L36:
        r107 = r107 + 1;
        r106 = r111;
        goto L9
    L37:
        Map r117 = this.f182094b;
        if (r117 == null) goto L40;
        Object r118 = r117.get("btm");
    L42:
        if ((r118 instanceof String) == false) goto L45;
        r108 = r118;
    L45:
        String r119 = (String) r108;
        if (r119 != null) goto L49;
        r119 = "";
    L49:
        if (r119.length() != 0) goto L51;
        boolean r120 = true;
    L52:
        if (r120 == false) goto L54;
        return;
    L54:
        List r121 = (List) this.f182093a.f182067a.getValue();
        com.bytedance.android.shopping.anchorv4.tracker.b r122 = new com.bytedance.android.shopping.anchorv4.tracker.b(this.f182096d, r119, r100, r103);
        monitor-enter(r121);
        Iterator r123 = r121.iterator();     // Catch: Throwable -> L69
        boolean r124 = false;
    L58:
        if (r123.hasNext() == false) goto L64;
        com.bytedance.android.shopping.anchorv4.tracker.b r125 = (com.bytedance.android.shopping.anchorv4.tracker.b) r123.next();     // Catch: Throwable -> L69
        String r126 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r122.a(), new String[]{"_i"}, false, 0, 6, null), 0);     // Catch: Throwable -> L69
        String r127 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r125.a(), new String[]{"_i"}, false, 0, 6, null), 0);     // Catch: Throwable -> L69
        if (Intrinsics.areEqual(r125.b(), r122.b()) == false) goto L58;
        if (Intrinsics.areEqual(r126, r127) == false) goto L58;
        r124 = true;
        goto L58
    L64:
        if (r124 == true) goto L66;
        r121.add(r122);     // Catch: Throwable -> L69
    L66:
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(r121);
        return;
    L69:
        th = move-exception;
        throw th;
    L51:
        r120 = false;
        goto L52
    L40:
        r118 = null;
        goto L42
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
