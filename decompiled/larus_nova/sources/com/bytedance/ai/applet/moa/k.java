package com.bytedance.ai.applet.moa;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f34855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f34856b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<i, g> f34857c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f34858d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<i, Boolean> f34859e = null;

    public static final class a implements AppLifecycleCallbacks {
        public a() {
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppAttached(AppletApplication r100) {
            Intrinsics.checkNotNullParameter(r100, "app");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppDestroyed(AppletApplication r100) {
            Intrinsics.checkNotNullParameter(r100, "app");
            k r101 = k.f34855a;
            final String r102 = r100.getAppId();
            r101.getClass();
            h r103 = k.f34858d.get(r102);
            if (r103 == null) goto L5;
            k.l(r103);
        L5:
            Collection<g> r104 = k.f34857c.values();
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r104.iterator();
        L7:
            if (r106.hasNext() == false) goto L11;
            Object r107 = r106.next();
            if (Intrinsics.areEqual(((g) r107).f34838a.f34852a, r102) == false) goto L7;
            r105.add(r107);
            goto L7
        L11:
            Iterator r108 = r105.iterator();
        L13:
            if (r108.hasNext() == false) goto L15;
            g r109 = (g) r108.next();
            k r110 = k.f34855a;
            Intrinsics.checkNotNull(r109);
            MoaGrantingResult r111 = MoaGrantingResult.FAILED;
            r110.getClass();
            k.c(r109, r111);
            goto L13
        L15:
            CollectionsKt.removeAll(k.f34859e, new j(r102));
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppCreated(AppletApplication r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppDestroyView(AppletApplication r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppResumed(AppletApplication r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppStopped(AppletApplication r100, Context r101) {
            AppLifecycleCallbacks.a.a(r100, r101);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppTaskBackground(AppletApplication r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppTaskForeground(AppletApplication r100, Context r101) {
            AppLifecycleCallbacks.a.b(r100, r101);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u2.e f34860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f34861b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f34860a, r101.f34860a) == true) goto L12;
            return false;
        L12:
            if (this.f34861b == r101.f34861b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f34860a.hashCode() * 31;
            if (this.f34861b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ParsedGrantingData(data=" + this.f34860a + ", autoAdvanceApprovedItems=" + this.f34861b + ')';
        }

        public b(u2.e r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f34860a = r100;
            this.f34861b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34862a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f34863b = null;

        static {
            int[] r100 = new int[MoaStepResult.values().length];
            r100[MoaStepResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r100[MoaStepResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L38:
            r100[MoaStepResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L28:
            r100[MoaStepResult.WAITING_ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r100[MoaStepResult.REQUIRES_CONFIRMATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L10:
            f34862a = r100;
            int[] r101 = new int[MoaGrantingResult.values().length];
            r101[MoaGrantingResult.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L24:
            r101[MoaGrantingResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L32:
            r101[MoaGrantingResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L14:
            f34863b = r101;
        }
    }

    public k() {
    }

    static {
        f34855a = new k();
        f34856b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f34857c = new ConcurrentHashMap();
        f34858d = new ConcurrentHashMap();
        f34859e = ConcurrentHashMap.newKeySet();
        AppletAppManagerService.INSTANCE.registerAppLifecycleCallbacks(new a());
    }

    public static void b(g r100) {
    L3:
        if (r100.a() == null) goto L35;
        u2.f r101 = r100.a();
        if (r101 == null) goto L50;
        if (r100.f34842e == true) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == true) goto L51;
        String r103 = r101.c();
        if (r103 == null) goto L52;
        int r104 = r103.hashCode();
        if (r104 != 280295099) goto L19;
        if (r103.equals("granted") == false) goto L57;
        r100.f34844g++;
        goto L3
    L57:
        return;
    L19:
        if (r104 == 854280074) goto L27;
        if (r104 != 1085547216) goto L53;
        if (r103.equals("refused") == false) goto L54;
    L30:
        if (r101.f() == true) goto L56;
        r100.f34844g++;
        goto L3
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L27:
        if (r103.equals("granted_without_system") == true) goto L30;
        return;
    L52:
        return;
    L51:
        return;
    L10:
        if (Intrinsics.areEqual(r101.b(), "permission") == false) goto L12;
        r102 = true;
        goto L13
    L50:
        return;
    }

    public static boolean e(h r100) {
        g r101 = r100.getContext();
        if (f34857c.get(r101.f34838a) != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L10:
        return false;
    L8:
        if (f34858d.get(r100.getContext().f34838a.f34852a) != r100) goto L10;
        return true;
    L5:
        r102 = false;
        goto L6
    }

    public static b j(JsonObject r210) {
        JsonElement r100 = r210.get("version");
        if (r100 != null) goto L5;
    L10:
        Integer r101 = null;
    L12:
        if (r101 != null) goto L14;
    L16:
        String r102 = g(r210, "type");
        if (r102 != null) goto L19;
        return null;
    L19:
        String r110 = g(r210, "doubaoAppletKey");
        if (r110 != null) goto L22;
        return null;
    L22:
        int r103 = r102.hashCode();
        if (r103 == (-517618225)) goto L40;
        if (r103 == 103149417) goto L37;
        if (r103 == 969075185) goto L30;
    L41:
        return null;
    L30:
        if (r102.equals("aweme_login") == false) goto L41;
        if (g(r210, "authLink") != null) goto L35;
        return null;
    L35:
        List r104 = CollectionsKt.listOf(new u2.f(0, r102, true, AiBotPollingAuthResult.STATUS_PENDING, r210.toString()));
    L101:
        return new b(new u2.e(r110, g(r210, "doubaoAppletVersion"), r104, 118), Intrinsics.areEqual(r102, "permission"));
    L37:
        if (r102.equals("login") == false) goto L41;
        r104 = CollectionsKt.listOf(new u2.f(0, r102, true, AiBotPollingAuthResult.STATUS_PENDING, r210.toString()));
        goto L101
    L40:
        if (r102.equals("permission") == false) goto L41;
        JsonArray r105 = r210.getAsJsonArray(ComplianceResult.JsonKey.PERMISSIONS);
        if (r105 != null) goto L45;
        return null;
    L45:
        ArrayList r106 = new ArrayList();
        Iterator<JsonElement> r107 = r105.iterator();
        int r108 = 0;
    L47:
        if (r107.hasNext() == false) goto L94;
        JsonElement r109 = r107.next();
        int r111 = r108 + 1;
        if (r108 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        JsonElement r112 = r109;
        if (r112.isJsonObject() == true) goto L55;
        r112 = null;
    L55:
        if (r112 == null) goto L92;
        JsonObject r113 = r112.getAsJsonObject();
        if (r113 == null) goto L92;
        f34855a.getClass();
        String r114 = g(r113, "scopeName");
        if (r114 == null) goto L61;
        JsonElement r115 = r113.get("priorityLevel");
        if (r115 != null) goto L65;
    L70:
        Integer r116 = null;
    L71:
        if (r116 == null) goto L73;
        r108 = r116.intValue();
    L73:
        int r117 = r108;
        JsonElement r118 = r113.get("required");
        if (r118 != null) goto L76;
    L81:
        Boolean r119 = null;
    L82:
        if (r119 == null) goto L84;
        boolean r120 = r119.booleanValue();
    L85:
        String r121 = g(r113, "permissionStatus");
        if (r121 != null) goto L88;
        r121 = AiBotPollingAuthResult.STATUS_PENDING;
    L88:
        String r122 = r121;
        JsonObject r123 = new JsonObject();
        r123.addProperty("scopeName", r114);
        String r124 = g(r113, "scopeDescription");
        if (r124 == null) goto L91;
        r123.addProperty("scopeDescription", r124);
    L91:
        Unit r125 = Unit.INSTANCE;
        r106.add(new u2.f(r117, "permission", r120, r122, r123.toString()));
        r108 = r111;
        goto L47
    L84:
        r120 = false;
        goto L85
    L76:
        if (r118.isJsonNull() == false) goto L79;
        r118 = null;
    L79:
        if (r118 == null) goto L81;
        r119 = Boolean.valueOf(r118.getAsBoolean());
        goto L82
    L65:
        if (r115.isJsonNull() == false) goto L68;
        r115 = null;
    L68:
        if (r115 == null) goto L70;
        r116 = Integer.valueOf(r115.getAsInt());
        goto L71
    L61:
        return null;
    L92:
        return null;
    L94:
        if ((true ^ r106.isEmpty()) == true) goto L97;
        r106 = null;
    L97:
        if (r106 != null) goto L99;
        return null;
    L99:
        r104 = r106;
        goto L101
    L14:
        if (r101.intValue() == 1) goto L16;
        return null;
    L5:
        if (r100.isJsonNull() == false) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r101 = Integer.valueOf(r100.getAsInt());
        goto L12
    }

    public static void k(f3.h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f3.h.a.a(r100, "Error: MOA login flow is no longer active", f3.a.f475265f, null, 10);
    }

    public static void l(h r100) {
        if (f34858d.remove(r100.getContext().f34838a.f34852a, r100) == true) goto L5;
        return;
    L5:
        Job r101 = r100.f34851g;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        r100.f34851g = null;
        n r102 = r100.f34850f;
        if (r102 == null) goto L11;
        r102.a(r100.a());
    L11:
        r100.f34850f = null;
        r100.f34848d = null;
        r100.f34849e = null;
    }

    public static void m(h r100) {
        Function0<Unit> r101 = r100.f34849e;
        l(r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.invoke();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "MOA waiting-action callback failed", r105);
        return;
    L17:
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void c(g r100, MoaGrantingResult r101) {
        if (f34857c.remove(r100.f34838a, r100) == true) goto L5;
        return;
    L5:
        int r102 = c.f34863b[r101.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L8;
    L14:
        f34859e.add(r100.f34838a);
    L15:
        h r104 = f34858d.get(r100.f34838a.f34852a);
        if (r104 != null) goto L18;
    L26:
        com.bytedance.ai.utils.g.f37637a.i("MoaGrantingManager", "finish authorizationID=" + r100.f34839b.f34865b + ", appletId=" + r100.f34840c.d() + ", result=" + r101.getValue());
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L29
        ((com.bytedance.applet.impl.moa.a) r100.f34843f).a(r100.f34839b, r101);     // Catch: Throwable -> L29
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L37;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "MOA callback failed", r107);
        return;
    L37:
        return;
    L29:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L18:
        if (r104.getContext() == r100) goto L21;
        r103 = false;
    L21:
        if (r103 == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L26;
        f34855a.getClass();
        l(r104);
        goto L26
    L8:
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public static boolean f(g r100, i r101) {
        if (Intrinsics.areEqual(r100.f34838a, r101) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f34839b.f34864a, r101.f34852a) == false) goto L11;
        if (Intrinsics.areEqual(r100.f34839b.f34865b, r101.f34853b) == false) goto L11;
        if (Intrinsics.areEqual(r100.f34840c.d(), r101.f34852a) == false) goto L11;
        return true;
    }

    public static String g(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.isJsonNull() == false) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L19;
        String r103 = StringsKt.trim(r102.getAsString()).toString();
        if (r103.length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        return null;
    L16:
        return r103;
    L13:
        r104 = false;
        goto L14
    L19:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0202 -> B:112:0x022a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0215 -> B:107:0x021a). Please report as a decompilation issue!!! */
    public static final Object a(k r110, h r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MoaGrantingManager$runExecution$1) == false) goto L7;
        MoaGrantingManager$runExecution$1 r100 = (MoaGrantingManager$runExecution$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "MoaGrantingManager";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        n r106 = (n) r100.L$2;
        g r107 = (g) r100.L$1;
        h r113 = (h) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L107:
        MoaStepResult r108 = (MoaStepResult) r102;
        if (e(r113) == false) goto L162;
        if (r113.f34850f != r106) goto L162;
    L112:
        MoaGrantingManager$runExecution$1 r109 = r100;
        h r114 = r113;
        String r115 = r105;
        Object r116 = r103;
        g r117 = r107;
        String r118 = r115;
        if (r114.f34847c == true) goto L115;
        c(r117, MoaGrantingResult.REFUSED);
        return Unit.INSTANCE;
    L115:
        int r119 = c.f34862a[r108.ordinal()];
        if (r119 != 1) goto L118;
        r106.a(r114.a());
        r114.f34850f = null;
        r117.f34844g++;
        b(r117);
        if (f34857c.get(r117.f34838a) != r117) goto L132;
        boolean r120 = true;
    L133:
        if (r120 == true) goto L136;
        return Unit.INSTANCE;
    L136:
        if (r117.a() != null) goto L139;
        c(r117, MoaGrantingResult.GRANTED);
        return Unit.INSTANCE;
    L139:
        if (r117.f34842e == true) goto L141;
        m(r114);
        return Unit.INSTANCE;
    L141:
        MoaGrantingManager$runExecution$1 r121 = r109;
    L18:
        if (e(r114) == false) goto L143;
        b(r117);
        u2.f r122 = r117.a();
        if (r122 != null) goto L22;
        c(r117, MoaGrantingResult.GRANTED);
        return Unit.INSTANCE;
    L22:
        p.f34870a.getClass();
        Intrinsics.checkNotNullParameter(r122, MapController.ITEM_LAYER_TAG);
        String r123 = r122.b();
        if (r123 != null) goto L25;
        n r124 = null;
    L93:
        if (r124 != null) goto L95;
        com.bytedance.ai.utils.g.f37637a.e(r118, "No MOA handler for grantingName=" + r122.b());
        m(r114);
        return Unit.INSTANCE;
    L95:
        r114.f34850f = r124;
        o r125 = r114.a();
        boolean r126 = r114.f34847c;
        r121.L$0 = r114;
        r121.L$1 = r117;
        r121.L$2 = r124;
        r121.label = 1;
        r102 = r124.g(r125, r126, r121);
        if (r102 == r116) goto L169;
        r113 = r114;
        r100 = r121;
        r106 = r124;
        String r127 = r118;
        r107 = r117;
        r103 = r116;
        r105 = r127;
    L99:
        r108 = (MoaStepResult) r102;
        if (e(r113) == true) goto L103;
        return Unit.INSTANCE;
    L103:
        if (r108 != MoaStepResult.REQUIRES_CONFIRMATION) goto L112;
        o r128 = r113.a();
        r100.L$0 = r113;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.label = 2;
        r102 = r106.c(r128, r100);
        if (r102 != r103) goto L107;
        return r103;
    L169:
        return r116;
    L25:
        switch(r123.hashCode()) {
            case -517618225: goto L87;
            case -314498168: goto L81;
            case 103149417: goto L34;
            case 969075185: goto L28;
            default: goto L152;
        };
    L152:
        r124 = null;
        goto L93
    L28:
        if (r123.equals("aweme_login") == false) goto L153;
        u2.d r129 = (u2.d) p.a(r122, u2.d.class);
        if (r129 == null) goto L146;
        int r130 = MoaExternalLoginGrantingStep.f34789d;
        Intrinsics.checkNotNullParameter(r122, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r129, "relatedData");
        r124 = new MoaExternalLoginGrantingStep(r122, r129, null);
        goto L93
    L146:
        r124 = null;
        goto L93
    L153:
        r124 = null;
        goto L93
    L34:
        if (r123.equals("login") == false) goto L154;
        String r131 = r122.e();
        if (r131 != null) goto L39;
    L42:
        boolean r132 = true;
    L43:
        if (r132 == false) goto L144;
        JsonObject r133 = null;
    L56:
        if (r133 == null) goto L155;
        JsonElement r134 = r133.get("type");
        if (r134 != null) goto L61;
    L66:
        String r135 = null;
    L68:
        if (Intrinsics.areEqual(r135, "login") == false) goto L70;
    L77:
        u2.j r136 = (u2.j) p.a(r122, u2.j.class);
        if (r136 == null) goto L149;
        int r137 = MoaLoginGrantingStep.f34797m;
        Intrinsics.checkNotNullParameter(r122, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r136, "relatedData");
        r124 = new MoaLoginGrantingStep(r122, r136, MoaLoginGrantingStep.Type.LOGIN);
        goto L93
    L149:
        r124 = null;
        goto L93
    L70:
        if (r133.has("bizLoginDescription") == true) goto L77;
        if (r133.has("authLink") == false) goto L147;
        u2.l r138 = (u2.l) p.a(r122, u2.l.class);
        if (r138 == null) goto L148;
        int r139 = MoaExternalLoginGrantingStep.f34789d;
        Intrinsics.checkNotNullParameter(r122, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r138, "relatedData");
        r124 = new MoaExternalLoginGrantingStep(r122, null, r138);
        goto L93
    L148:
        r124 = null;
        goto L93
    L147:
        r124 = null;
        goto L93
    L61:
        if (r134.isJsonNull() == false) goto L64;
        r134 = null;
    L64:
        if (r134 == null) goto L66;
        r135 = r134.getAsString();
        goto L68
    L155:
        r124 = null;
        goto L93
    L144:
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L47
        Lazy r141 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L47
        Object r142 = Result.m9449constructorimpl((JsonObject) com.bytedance.ai.applet.base.gson.e.a(r131, JsonObject.class));     // Catch: Throwable -> L47
    L49:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L53;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingStepFactory", "Failed to parse relatedData", r143);
    L53:
        if (Result.m9455isFailureimpl(r142) == false) goto L55;
        r142 = null;
    L55:
        r133 = (JsonObject) r142;
    L47:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L39:
        if (StringsKt.isBlank(r131) == true) goto L42;
        r132 = false;
        goto L43
    L154:
        r124 = null;
        goto L93
    L81:
        if (r123.equals("privacy") == false) goto L156;
        u2.j r145 = (u2.j) p.a(r122, u2.j.class);
        if (r145 == null) goto L150;
        int r146 = MoaLoginGrantingStep.f34797m;
        Intrinsics.checkNotNullParameter(r122, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r145, "relatedData");
        r124 = new MoaLoginGrantingStep(r122, r145, MoaLoginGrantingStep.Type.PRIVACY);
        goto L93
    L150:
        r124 = null;
        goto L93
    L156:
        r124 = null;
        goto L93
    L87:
        if (r123.equals("permission") == false) goto L157;
        u2.k r147 = (u2.k) p.a(r122, u2.k.class);
        if (r147 == null) goto L151;
        r124 = new MoaPermissionGrantingStep(r122, r147);
        goto L93
    L151:
        r124 = null;
        goto L93
    L157:
        r124 = null;
        goto L93
    L143:
        return Unit.INSTANCE;
    L132:
        r120 = false;
        goto L133
    L118:
        if (r119 != 2) goto L120;
    L128:
        m(r114);
        return Unit.INSTANCE;
    L120:
        if (r119 == 3) goto L128;
        if (r119 == 4) goto L128;
        if (r119 != 5) goto L127;
        com.bytedance.ai.utils.g.f37637a.e(r118, "Step still requires confirmation after requestConfirmation(), keeping the authorization retryable");
        m(r114);
        return Unit.INSTANCE;
    L127:
        throw new NoWhenBranchMatchedException();
    L162:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r106 = (n) r100.L$2;
        r107 = (g) r100.L$1;
        r113 = (h) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L99
    L16:
        ResultKt.throwOnFailure(r102);
        r121 = r100;
        r118 = "MoaGrantingManager";
        r114 = r111;
        r116 = r103;
        r117 = r111.getContext();
    L7:
        r100 = new MoaGrantingManager$runExecution$1(r110, r112);
        goto L8
    }

    public static void h(m r100, MoaGrantingResult r101, com.bytedance.applet.impl.moa.a r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
        r102.a(r100, r101);     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L12;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "MOA callback failed", r105);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static boolean i(String r110, String r111, boolean r112, WeakReference r113, Function0 r114) {
        Intrinsics.checkNotNullParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r111, "authorizationID");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "operateMoaGranting must be called on the main thread");
        return false;
    L6:
        String r115 = StringsKt.trim(r110).toString();
        String r116 = StringsKt.trim(r111).toString();
        if (StringsKt.isBlank(r115) == false) goto L9;
    L48:
        return false;
    L9:
        if (StringsKt.isBlank(r116) == true) goto L48;
        i r100 = new i(r115, r116);
        ConcurrentHashMap<i, g> r101 = f34857c;
        g r102 = r101.get(r100);
        if (r102 != null) goto L20;
        if (f34859e.contains(r100) == true) goto L16;
        return false;
    L16:
        if (r114 == null) goto L18;
        r114.invoke();
    L18:
        return true;
    L20:
        if (f(r102, r100) == true) goto L24;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "operateMoaGranting: session identity does not match its key");
        return false;
    L24:
        if (f34859e.remove(r100) == false) goto L26;
        com.bytedance.ai.utils.g.f37637a.i("MoaGrantingManager", "Retry completed authorizationID=" + r116 + ", appletId=" + r115);
    L26:
        ConcurrentHashMap<String, h> r117 = f34858d;
        h r103 = r117.get(r115);
        if (r103 != null) goto L29;
        b(r102);
        if (r101.get(r102.f34838a) != r102) goto L35;
        boolean r104 = true;
    L36:
        if (r104 == true) goto L39;
        return true;
    L39:
        if (r102.a() != null) goto L42;
        c(r102, MoaGrantingResult.GRANTED);
        return true;
    L42:
        h r105 = new h(r102, "moa_granting_" + UUID.randomUUID(), r112, r113, r114);
        if (r117.putIfAbsent(r115, r105) == null) goto L46;
        com.bytedance.ai.utils.g.f37637a.w("MoaGrantingManager", "operateMoaGranting: another authorization owns applet UI, appletId=".concat(r115));
        return false;
    L46:
        r105.f34851g = BuildersKt.launch$default(f34856b, null, null, new MoaGrantingManager$startExecution$1(r105, null), 3, null);
        return true;
    L35:
        r104 = false;
        goto L36
    L29:
        if (r103.getContext() != r102) goto L49;
        return true;
    L49:
        return false;
    }

    public static boolean d(String r100, String r101, String r110, String r111, Function1 r112, Function0 r113) {
        Intrinsics.checkNotNullParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r111, "label");
        Intrinsics.checkNotNullParameter(r112, "onHandled");
        Intrinsics.checkNotNullParameter(r113, "onRejected");
        if (r100 == null) goto L105;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L105;
        if (StringsKt.startsWith$default(r102, "moa_granting_", false, 2, null) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L105;
    L30:
        ConcurrentHashMap<String, h> r103 = f34858d;
        h r104 = r103.get(StringsKt.trim(r110).toString());
        if (r104 != null) goto L34;
    L36:
        r104 = null;
    L37:
        if (r104 == null) goto L42;
        n r105 = r104.f34850f;
        if ((r105 instanceof q) == false) goto L42;
        q r106 = (q) r105;
    L44:
        if (r106 == null) goto L46;
        Object r107 = new com.bytedance.ai.applet.moa.b(r106);
    L87:
        if ((r107 instanceof com.bytedance.ai.applet.moa.b) == false) goto L89;
        r112.invoke(((com.bytedance.ai.applet.moa.b) r107).f34834a);
    L103:
        return true;
    L89:
        d r108 = d.f34836a;
        if (Intrinsics.areEqual(r107, r108) == false) goto L92;
    L99:
        if (r107 != r108) goto L101;
        String r109 = "not attributable to the live attempt";
    L102:
        com.bytedance.ai.utils.g.f37637a.w("MoaGrantingManager", "reject MOA " + r111 + " (" + r109 + "): applet=" + r110);
        r113.invoke();
        goto L103
    L101:
        r109 = "stale attempt";
        goto L102
    L92:
        if (Intrinsics.areEqual(r107, com.bytedance.ai.applet.moa.c.f34835a) == true) goto L99;
        if (Intrinsics.areEqual(r107, com.bytedance.ai.applet.moa.a.f34833a) == false) goto L98;
        return false;
    L98:
        throw new NoWhenBranchMatchedException();
    L46:
        String r114 = StringsKt.trim(r110).toString();
        if (r114.length() <= 0) goto L49;
        boolean r115 = true;
    L50:
        if (r115 == true) goto L52;
    L54:
        boolean r116 = false;
    L55:
        if (r116 == false) goto L57;
        r107 = d.f34836a;
        goto L87
    L57:
        String r117 = StringsKt.trim(r110).toString();
        h r118 = r103.get(r117);
        if (r118 == null) goto L62;
        if (r102 != null) goto L61;
        com.bytedance.ai.utils.g.f37637a.w("MoaGrantingManager", "MOA callback carries no attempt id while applet=" + r117 + " is executing");
    L61:
        boolean r119 = !Intrinsics.areEqual(r118.f34846b, r102);
    L83:
        if (r119 == false) goto L85;
        r107 = com.bytedance.ai.applet.moa.c.f34835a;
        goto L87
    L85:
        r107 = com.bytedance.ai.applet.moa.a.f34833a;
        goto L87
    L62:
        if (r102 != null) goto L64;
    L66:
        boolean r120 = false;
    L67:
        if (r120 == true) goto L69;
        r119 = false;
        goto L83
    L69:
        Set<i> r121 = f34857c.keySet();
        if ((r121 instanceof Collection) == true) goto L72;
    L74:
        Iterator<T> r122 = r121.iterator();
    L76:
        if (r122.hasNext() == false) goto L80;
        if (Intrinsics.areEqual(((i) r122.next()).f34852a, r117) == false) goto L76;
        r119 = true;
    L81:
        if (r119 == true) goto L83;
        com.bytedance.ai.utils.g.f37637a.i("MoaGrantingManager", "Ignore attempt id of an ended MOA authorization: applet=" + r117);
    L80:
        r119 = false;
        goto L81
    L72:
        if (r121.isEmpty() == false) goto L74;
    L64:
        if (StringsKt.startsWith$default(r102, "moa_granting_", false, 2, null) != true) goto L66;
        r120 = true;
        goto L67
    L52:
        if (r103.get(r114) == null) goto L54;
        r116 = true;
        goto L55
    L49:
        r115 = false;
    L42:
        r106 = null;
        goto L44
    L34:
        if (Intrinsics.areEqual(r104.f34846b, r102) == false) goto L36;
    L105:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L24
        if (r101 == null) goto L21;
        Uri r124 = UriProtector.parse(r101);     // Catch: Throwable -> L24
        if (r124 == null) goto L21;
        String r125 = UriProtector.getQueryParameter(r124, "__moa_attempt_id");     // Catch: Throwable -> L24
        if (r125 == null) goto L21;
        if (StringsKt.startsWith$default(r125, "moa_granting_", false, 2, null) == false) goto L21;
    L22:
        Object r126 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r126) == false) goto L29;
        r126 = null;
    L29:
        r102 = (String) r126;
    L21:
        r125 = null;
    L24:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
