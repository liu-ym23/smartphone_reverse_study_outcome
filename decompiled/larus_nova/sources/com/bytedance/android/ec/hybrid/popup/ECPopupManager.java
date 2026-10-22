package com.bytedance.android.ec.hybrid.popup;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ECPopupManager implements ik.b, ck.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f47572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super String, ? super String, ? super String, Unit> f47573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<g> f47574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, j> f47575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f47576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f47577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f47578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<j> f47579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<j> f47580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<j> f47582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f47583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.ec.hybrid.card.api.f> f47584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FrameLayout f47585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout f47586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ik.a f47587p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e f47588q;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECPopupManager f47589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f47590b;

        public a(ECPopupManager r100, boolean r101) {
            this.f47589a = r100;
            this.f47590b = r101;
        }

        public final void a() {
            ECPopupManager r100 = this.f47589a;
            if (r100.f47581j == true) goto L30;
            if (this.f47590b == true) goto L30;
            Iterator r101 = ((ArrayList) r100.f47582k).iterator();     // Catch: Throwable -> L28
        L7:
            if (r101.hasNext() == false) goto L30;
            j r102 = (j) r101.next();     // Catch: Throwable -> L28
            String r103 = r102.getBtm();     // Catch: Throwable -> L28
            if (r103 != null) goto L13;
            r103 = "";
        L13:
            if ((r102 instanceof fk.e) == true) goto L15;
            j r104 = null;
        L16:
            fk.e r105 = (fk.e) r104;     // Catch: Throwable -> L28
            if (r105 == null) goto L20;
            String r106 = r105.getSchema();     // Catch: Throwable -> L28
            if (r106 == null) goto L20;
        L21:
            ECPopupManager r107 = this.f47589a;     // Catch: Throwable -> L28
            g r108 = r107.k(r102);     // Catch: Throwable -> L28
            if (r108 == null) goto L26;
            FrameLayout r109 = r108.c();     // Catch: Throwable -> L28
            if (r109 == null) goto L26;
            r109.setVisibility(4);     // Catch: Throwable -> L28
        L26:
            ECPopupManager.i((hk.a) r107.f47576e.getValue());     // Catch: Throwable -> L28
            this.f47589a.f47573b.invoke(r103, r106, "hide_by_drift");     // Catch: Throwable -> L28
        L20:
            r106 = "";
            goto L21
        L15:
            r104 = r102;
        L30:
            if (this.f47590b == false) goto L52;
            Iterator r110 = ((ArrayList) this.f47589a.f47582k).iterator();
        L33:
            if (r110.hasNext() == false) goto L63;
            j r111 = (j) r110.next();
            String r112 = r111.getBtm();
            if (r112 != null) goto L38;
            r112 = "";
        L38:
            if ((r111 instanceof fk.e) == true) goto L40;
            j r113 = null;
        L41:
            fk.e r114 = (fk.e) r113;
            if (r114 == null) goto L45;
            String r115 = r114.getSchema();
            if (r115 == null) goto L45;
        L46:
            g r116 = this.f47589a.k(r111);
            if (r116 == null) goto L51;
            FrameLayout r117 = r116.c();
            if (r117 == null) goto L51;
            r117.setVisibility(0);
        L51:
            this.f47589a.f47573b.invoke(r112, r115, "re_show");
        L45:
            r115 = "";
            goto L46
        L40:
            r113 = r111;
            goto L41
        L63:
            return;
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

    @Override // ck.a
    public final void release() {
        j(false);
        ik.a r100 = this.f47587p;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.f490167a.remove(this);
        this.f47573b = AnonymousClass1.INSTANCE;
    }

    @Override // ck.b
    public final ViewGroup b() {
        return this.f47586o;
    }

    public static void i(hk.a r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // ck.b
    public final Pair a(gk.b r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (r100.a() == true) goto L5;
    L7:
        h r101 = r100.getGroup();
        Iterator<T> r102 = this.f47574c.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((g) r103).getName(), r101.getName()) == false) goto L9;
    L14:
        g r104 = (g) r103;
        if (r104 == null) goto L17;
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup : submit " + r100 + ", find active " + r104);
    L18:
        Boolean r106 = Boolean.valueOf(r104.a(r100));
        if (r106.booleanValue() == false) goto L22;
        this.f47575d.put(r100.f481521d, r100);
    L22:
        return TuplesKt.to(r106, r100.f481521d);
    L17:
        int r107 = c.a.f47595a;
        Context r108 = this.f47586o.getContext();
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "manager");
        ek.c r109 = new ek.c(r101, r108, this);
        this.f47574c.add(r109);
        Lazy r110 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup : submit " + r100 + ", create " + r109);
        r104 = r109;
        goto L18
    L13:
        r103 = null;
        goto L14
    L5:
        if (this.f47572a == false) goto L7;
        ((ArrayList) this.f47582k).add(r100);
        goto L7
    }

    @Override // ik.b
    public final void d(boolean r100) {
        this.f47581j = !r100;
    }

    @Override // ck.b
    public final void f(j r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (r100.a() == false) goto L5;
        Pair r101 = TuplesKt.to(this.f47579h, this.f47577f);
    L6:
        List r102 = (List) r101.component1();
        if (((ArrayList) this.f47582k).contains(r100) == false) goto L9;
        ((ArrayList) this.f47582k).remove(r100);
    L9:
        r102.remove(r100);
        long r103 = r100.stop();
        Iterator<T> r104 = this.f47574c.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((g) r105).getName(), r100.getGroup().getName()) == false) goto L11;
    L16:
        g r106 = (g) r105;
        if (r106 != null) goto L20;
        Lazy r107 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup: manager finish task-" + r100.getId() + ", cannot find group-" + r100.getGroup().getName());
        return;
    L20:
        l r108 = new l(r106, this);
        if (r103 <= 0) goto L23;
        this.f47586o.postDelayed(r108, r103);
    L24:
        this.f47575d.remove(r100.getId());
        return;
    L23:
        r108.run();
        goto L24
    L15:
        r105 = null;
        goto L16
    L5:
        r101 = TuplesKt.to(this.f47580i, this.f47578g);
        goto L6
    }

    @Override // ck.b
    public final void finish(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        j r101 = (j) ((LinkedHashMap) this.f47575d).get(r100);
        if (r101 == null) goto L6;
        f(r101);
        return;
    }

    @Override // ck.a
    public final void g(boolean r100) {
        if (this.f47572a == true) goto L5;
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new a(this, r100));
    }

    public final void j(boolean r100) {
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup :manager clear task-groups, idle? " + r100);
        LinkedList<g> r102 = this.f47574c;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        g r106 = (g) r105;
        if (r100 == true) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        if (r106.isActive() == false) goto L11;
        r107 = false;
        goto L12
    L14:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r103.iterator();
    L15:
        ViewParent r110 = null;
        if (r109.hasNext() == false) goto L24;
        g r111 = (g) r109.next();
        r108.addAll(r111.clear());
        ViewParent r112 = r111.c().getParent();
        if ((r112 instanceof ViewGroup) == false) goto L21;
        r110 = r112;
    L21:
        ViewGroup r113 = (ViewGroup) r110;
        if (r113 == null) goto L15;
        r113.removeView(r111.c());
        goto L15
    L24:
        Iterator r114 = r108.iterator();
    L26:
        if (r114.hasNext() == false) goto L28;
        j r115 = (j) r114.next();
        ((ArrayList) this.f47579h).remove(r115);
        ((ArrayList) this.f47580i).remove(r115);
        goto L26
    L28:
        this.f47574c.removeAll(CollectionsKt.toSet(r103));
        e r116 = this.f47588q;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r108, "removeTasks");
        Iterator<T> r117 = r116.f47596a.iterator();
    L30:
        if (r117.hasNext() == false) goto L33;
        ((i) r117.next()).PY(r108);
        goto L30
    L33:
        if (this.f47574c.isEmpty() == false) goto L57;
        Lazy r118 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup :manager clear task-groups, try remove global-manager-layout");
        if (((ArrayList) this.f47579h).isEmpty() == false) goto L58;
        ViewParent r119 = this.f47577f.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L40;
        r110 = r119;
    L40:
        ViewGroup r120 = (ViewGroup) r110;
        if (r120 == null) goto L43;
        r120.removeView(this.f47577f);
    L43:
        i((hk.a) this.f47576e.getValue());
        return;
    L58:
        return;
    }

    public final g k(j r100) {
        Iterator<T> r101 = this.f47574c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((g) r102).getName(), r100.getGroup().getName()) == false) goto L4;
    L9:
        g r103 = (g) r102;
        if (r103 != null) goto L13;
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, "ec_popup :manager execute task cannot find active group-" + r100.getGroup().getName());
        return null;
    L13:
        return r103;
    L8:
        r102 = null;
        goto L9
    }

    @Override // ik.b
    public final void c(int r100, int r101) {
        Iterator r102 = ((ArrayList) this.f47580i).iterator();
    L3:
        com.bytedance.android.ec.hybrid.card.api.e r103 = null;
        if (r102.hasNext() == false) goto L14;
        j r104 = (j) r102.next();
        if ((r104 instanceof fk.e) == false) goto L3;
        com.bytedance.android.ec.hybrid.card.api.e r105 = ((fk.e) r104).f477558h;
        if ((r105 instanceof ECLynxCard) == false) goto L11;
        r103 = r105;
    L11:
        ECLynxCard r106 = (ECLynxCard) r103;
        if (r106 == null) goto L3;
        r106.c(r100, r101);
        goto L3
    L14:
        Iterator r107 = ((ArrayList) this.f47579h).iterator();
    L16:
        if (r107.hasNext() == false) goto L25;
        j r108 = (j) r107.next();
        if ((r108 instanceof fk.e) == false) goto L16;
        com.bytedance.android.ec.hybrid.card.api.e r109 = ((fk.e) r108).f477558h;
        if ((r109 instanceof ECLynxCard) == true) goto L22;
        r109 = null;
    L22:
        ECLynxCard r110 = (ECLynxCard) r109;
        if (r110 == null) goto L16;
        r110.c(r100, r101);
        goto L16
    }

    @Override // ck.b
    public final Pair e(o r100, f r110, d r111) {
        Intrinsics.checkNotNullParameter(r100, "taskConfig");
        Intrinsics.checkNotNullParameter(r110, "popupConfig");
        if ((r110 instanceof fk.g) == false) goto L11;
        com.bytedance.android.ec.hybrid.card.api.f r101 = this.f47584m.get();
        if (r101 != null) goto L9;
        return TuplesKt.to(Boolean.FALSE, "");
    L9:
        return a(new fk.e(this, r100, (fk.g) r110, r101, r111));
    L11:
        return TuplesKt.to(Boolean.FALSE, "");
    }

    public ECPopupManager(com.bytedance.android.ec.hybrid.card.api.f r100, FrameLayout r101, FrameLayout r102, ik.a r103, e r104, String r105, boolean r106, Function3<? super String, ? super String, ? super String, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "lynxCardLoader");
        Intrinsics.checkNotNullParameter(r101, "globalLayout");
        Intrinsics.checkNotNullParameter(r102, "localLayout");
        Intrinsics.checkNotNullParameter(r103, "appStateManager");
        Intrinsics.checkNotNullParameter(r104, "popupStateManager");
        Intrinsics.checkNotNullParameter(r105, "sceneId");
        Intrinsics.checkNotNullParameter(r107, "reportPopupHideByDrift");
        this.f47585n = r101;
        this.f47586o = r102;
        this.f47587p = r103;
        this.f47588q = r104;
        this.f47573b = ECPopupManager$reportPopupHideByDrift$1.INSTANCE;
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r103.f490167a.add(this);
        this.f47572a = r106;
        this.f47573b = r107;
        this.f47574c = new LinkedList();
        this.f47575d = new LinkedHashMap();
        this.f47576e = LazyKt.lazy(new ECPopupManager$interceptBackDialog$2(this));
        FrameLayout r108 = new FrameLayout(r102.getContext());
        r108.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r109 = Unit.INSTANCE;
        this.f47577f = r108;
        this.f47578g = r102;
        this.f47579h = new ArrayList();
        this.f47580i = new ArrayList();
        this.f47582k = new ArrayList();
        int r110 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
        Object r111 = Boolean.TRUE;
        int r112 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L84
        Object r114 = null;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_hybrid_global_popup_refactor_enable");     // Catch: Throwable -> L57
        if (r115 != null) goto L9;
    L54:
        Object r116 = null;
    L55:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L57
    L59:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L84
        if (r118 == null) goto L63;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L84
    L63:
        if (Result.m9455isFailureimpl(r117) == false) goto L66;
        r117 = null;
    L66:
        if ((r117 instanceof Boolean) == true) goto L68;
        r117 = null;
    L68:
        Boolean r119 = (Boolean) r117;     // Catch: Throwable -> L84
        if (r119 == null) goto L71;
        r111 = r119;
    L92:
        this.f47583l = ((Boolean) r111).booleanValue();
        this.f47584m = new WeakReference(r100);
        return;
    L71:
        IHybridHostService r120 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L84
        if (r120 == null) goto L74;
        Object r121 = r120.getHostABValue("ec_hybrid_global_popup_refactor_enable", r111);     // Catch: Throwable -> L84
    L75:
        if (r121 == null) goto L92;
        if ((r121 instanceof Boolean) == false) goto L80;
        r114 = r121;
    L80:
        Boolean r122 = (Boolean) r114;     // Catch: Throwable -> L84
        if (r122 == null) goto L92;
        r111 = r122;
        goto L92
    L74:
        r121 = null;
        goto L75
    L9:
        if ((r115 instanceof Boolean) == true) goto L11;
        Object r123 = null;
    L12:
        r116 = (Boolean) r123;     // Catch: Throwable -> L57
        if (r116 != null) goto L55;
        if ((r115 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r124 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L57
        if ((r124 instanceof Boolean) == true) goto L22;
        r124 = null;
    L22:
        r116 = (Boolean) r124;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r125 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L57
        if ((r125 instanceof Boolean) == true) goto L28;
        r125 = null;
    L28:
        r116 = (Boolean) r125;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r126 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L57
        if ((r126 instanceof Boolean) == true) goto L34;
        r126 = null;
    L34:
        r116 = (Boolean) r126;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r127 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L57
        if ((r127 instanceof Boolean) == true) goto L40;
        r127 = null;
    L40:
        r116 = (Boolean) r127;     // Catch: Throwable -> L57
    L42:
        if ((r115 instanceof JSONObject) == false) goto L44;
    L98:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r128 = SDKSettingsCacheManager.a().fromJson(r115.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r128 instanceof Boolean) == true) goto L48;
        r128 = null;
    L48:
        Object r129 = Result.m9449constructorimpl((Boolean) r128);     // Catch: Throwable -> L50
    L52:
        r116 = r129;
        if (Result.m9455isFailureimpl(r116) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L57
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r115 instanceof JSONArray) == false) goto L54;
    L11:
        r123 = r115;
    L57:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L84
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        Object r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L89;
        EnsureManager.ensureNotReachHere(r134);
    L89:
        if (Result.m9455isFailureimpl(r133) == true) goto L92;
        r111 = r133;
        goto L92
    }
}
