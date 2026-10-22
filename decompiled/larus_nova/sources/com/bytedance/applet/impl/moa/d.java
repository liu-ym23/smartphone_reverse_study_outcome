package com.bytedance.applet.impl.moa;

import android.content.Context;
import android.os.Looper;
import com.bytedance.ai.applet.moa.MoaGrantingResult;
import com.bytedance.ai.applet.moa.i;
import com.bytedance.ai.applet.moa.k;
import com.bytedance.ai.applet.moa.l;
import com.bytedance.ai.applet.moa.m;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f191977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f191978b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191979a = null;

        static {
            int[] r100 = new int[MoaGrantingResult.values().length];
            r100[MoaGrantingResult.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MoaGrantingResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MoaGrantingResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f191979a = r100;
        }
    }

    public d() {
    }

    static {
        f191977a = new d();
        f191978b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static void a(mi8.g r100) {
        int r101 = f.f191984a;
        e r102 = f.a(r100.f514120a);
        if (r102 != null) goto L9;
        FLogger.f375446a.e("MoaGrantingApplet", "operate failed: invalid MOA payload, msgId=" + r100.f514122c.f514119a);
        Function0<Unit> r103 = r100.f514124e;
        if (r103 == null) goto L27;
        r103.invoke();
        return;
    L27:
        return;
    L9:
        if (r100.f514121b != MoaGrantingDecision.UNSUPPORTED) goto L14;
        FLogger.f375446a.e("MoaGrantingApplet", "operate failed: unsupported MOA decision, authorizationID=" + r102.f191981b);
        Function0<Unit> r104 = r100.f514124e;
        if (r104 == null) goto L28;
        r104.invoke();
        return;
    L28:
        return;
    L14:
        m r105 = b(r102, r100.f514124e);
        if (r105 != null) goto L17;
        return;
    L17:
        k r106 = k.f34855a;
        String r107 = r105.f34864a;
        String r108 = r105.f34865b;
        if (r100.f514121b != MoaGrantingDecision.ALLOW) goto L20;
        boolean r109 = true;
    L21:
        WeakReference<Context> r110 = r100.f514123d;
        Function0<Unit> r111 = r100.f514124e;
        r106.getClass();
        if (k.i(r107, r108, r109, r110, r111) == true) goto L29;
        FLogger.f375446a.e("MoaGrantingApplet", "operate rejected by SDK, authorizationID=" + r105.f34865b);
        Function0<Unit> r112 = r100.f514124e;
        if (r112 == null) goto L30;
        r112.invoke();
        return;
    L30:
        return;
    L29:
        return;
    L20:
        r109 = false;
        goto L21
    }

    public static m b(e r100, Function0 r110) {
        com.bytedance.applet.impl.moa.a r101 = new com.bytedance.applet.impl.moa.a(r100, r110);
        String r102 = r100.f191982c;
        String r103 = r100.f191980a;
        if (r103 != null) goto L5;
    L11:
        m r104 = null;
    L12:
        if (r102 == null) goto L85;
        if (r104 == null) goto L85;
        k.f34855a.getClass();
        Intrinsics.checkNotNullParameter(r102, "authExt");
        Intrinsics.checkNotNullParameter(r104, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "prepareMoaGrantingData must be called on the main thread");
        r101.a(r104, MoaGrantingResult.FAILED);
        return null;
    L18:
        String r105 = StringsKt.trim(r104.f34864a).toString();
        String r106 = StringsKt.trim(r104.f34865b).toString();
        Intrinsics.checkNotNullParameter(r105, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r106, "authorizationID");
        m r107 = new m(r105, r106);
        String r108 = r107.f34864a;
        String r109 = r107.f34865b;
        if (StringsKt.isBlank(r108) == false) goto L21;
    L83:
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "prepareMoaGrantingData: appletId or authorizationID is blank");
        r101.a(r107, MoaGrantingResult.FAILED);
        return null;
    L21:
        if (StringsKt.isBlank(r109) == true) goto L83;
        i r111 = new i(r108, r109);
        if (k.f34859e.contains(r111) == false) goto L26;
        com.bytedance.ai.utils.g.f37637a.i("MoaGrantingManager", "Prepare retry for completed authorizationID=" + r109 + ", appletId=" + r108);
    L26:
        com.bytedance.ai.applet.moa.g r112 = k.f34857c.get(r111);
        if (r112 == null) goto L33;
        if (k.f(r112, r111) == true) goto L31;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "MOA session identity does not match its composite key");
        k.h(r107, MoaGrantingResult.FAILED, r101);
        return null;
    L31:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r112.f34843f = r101;
        return r112.f34839b;
    L33:
        if (StringsKt.isBlank(r102) == false) goto L88;
        k.b r113 = null;
    L46:
        if (r113 == null) goto L48;
        u2.e r114 = r113.f34860a;
    L49:
        if (r114 == null) goto L53;
        String r115 = r114.d();
        if (r115 == null) goto L53;
        String r116 = StringsKt.trim(r115).toString();
    L54:
        if (r116 != null) goto L56;
        r116 = "";
    L56:
        if (r114 == null) goto L65;
        List<u2.f> r117 = r114.h();
        if (r117 == null) goto L65;
        if (r117.isEmpty() == false) goto L63;
        r117 = null;
    L63:
        if (r117 == null) goto L65;
        List r118 = CollectionsKt.sortedWith(r117, new l());
    L66:
        if (r113 == null) goto L82;
        if (r114 == null) goto L82;
        if (r118 == null) goto L82;
        if (StringsKt.isBlank(r116) == false) goto L74;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "prepareMoaGrantingData: appletId is blank");
        k.h(r107, MoaGrantingResult.FAILED, r101);
        return null;
    L74:
        if (Intrinsics.areEqual(r108, r116) == true) goto L76;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "prepareMoaGrantingData: request appletId does not match granting data");
        k.h(r107, MoaGrantingResult.FAILED, r101);
        return null;
    L76:
        com.bytedance.ai.applet.moa.g r119 = new com.bytedance.ai.applet.moa.g(r111, r107, r114, r118, r113.f34861b, r101);
        ConcurrentHashMap<i, com.bytedance.ai.applet.moa.g> r120 = k.f34857c;
        r120.put(r111, r119);
        k.b(r119);
        if (r119.a() != null) goto L79;
        k.c(r119, MoaGrantingResult.GRANTED);
        return null;
    L79:
        com.bytedance.ai.applet.moa.g r121 = r120.get(r111);
        if (r121 != null) goto L97;
        return null;
    L97:
        return r121.f34839b;
    L82:
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "prepareMoaGrantingData: auth Ext is invalid");
        k.h(r107, MoaGrantingResult.FAILED, r101);
        return null;
    L65:
        r118 = null;
    L53:
        r116 = null;
        goto L54
    L48:
        r114 = null;
        goto L49
    L88:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L37
        Lazy r123 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L37
        Object r124 = Result.m9449constructorimpl(k.j((JsonObject) com.bytedance.ai.applet.base.gson.e.a(r102, JsonObject.class)));     // Catch: Throwable -> L37
    L39:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L43;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingManager", "Failed to parse auth Ext", r125);
    L43:
        if (Result.m9455isFailureimpl(r124) == false) goto L45;
        r124 = null;
    L45:
        r113 = (k.b) r124;
    L37:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L85:
        if (r110 == null) goto L87;
        r110.invoke();
    L87:
        return null;
    L5:
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L11;
        r104 = new m(r103, r100.f191981b);
        goto L12
    }
}
