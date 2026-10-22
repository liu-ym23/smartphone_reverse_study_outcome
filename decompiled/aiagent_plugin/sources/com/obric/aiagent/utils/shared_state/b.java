package com.obric.aiagent.utils.shared_state;

import android.content.Context;
import com.google.gson.Gson;
import com.obric.aiagent.assistant.utils.c;
import com.obric.aiagent.assistant.utils.d;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SharedStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "SharedStateManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f22345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f22346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f22347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f22348e = null;

    public static /* synthetic */ Gson lambda$_GbnQXJOn1oYHBz0wO3O1bXz1_M() {
        return i();
    }

    public static /* synthetic */ void lambda$aNXZxHdeZhkKaKcHxxc0nZqVPbk(String r0, SharedValue r1) {
        a(r0, r1);
    }

    private b() {
    }

    static {
        f22344a = new b();
        f22345b = new AtomicBoolean(false);
        f22346c = g.a($$Lambda$b$_GbnQXJOn1oYHBz0wO3O1bXz1_M.INSTANCE);
        f22347d = new ConcurrentHashMap();
        f22348e = p.b(new String[]{"doubao_account_uid", "doubao_account_nick_name", "doubao_account_avatar_url", "doubao_account_token_map", "doubao_login_state"});
    }

    private final Gson g() {
        return (Gson) ZeusTransformUtils.preCheckCast(f22346c.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson i() {
        return new Gson();
    }

    public final void a(Context r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        AtomicBoolean r0 = f22345b;
        if (r0.get() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (r0.get() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        SharedStateLogger.INSTANCE.setDebug(IAppContext.Companion.isDebug());     // Catch: Throwable -> L21
        SharedState.INSTANCE.init(r9);     // Catch: Throwable -> L21
        SharedState r10 = SharedState.INSTANCE;     // Catch: Throwable -> L21
        List<String> r1 = f22348e;     // Catch: Throwable -> L21
        r10.registerObserver(r1, $$Lambda$b$aNXZxHdeZhkKaKcHxxc0nZqVPbk.INSTANCE);     // Catch: Throwable -> L21
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L12:
        if (r11.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (o.a(r2, "doubao_login_state") == false) goto L16;
        Object r3 = Boolean.valueOf(SharedState.INSTANCE.getBoolean(r2, false));     // Catch: Throwable -> L21
    L17:
        ((Map) ZeusTransformUtils.preCheckCast(f22347d, Map.class, "com.obric.aiagent.plugin")).put(r2, r3);     // Catch: Throwable -> L21
        ISecureLogDepend.Companion.d(TAG, "Init Shared State: key=" + r2 + ", value=" + r3);     // Catch: Throwable -> L21
        goto L12
    L16:
        r3 = SharedState.INSTANCE.getString(r2, "");     // Catch: Throwable -> L21
        goto L17
    L18:
        SharedState.INSTANCE.putInt("zeus_aiagent_version", r8);     // Catch: Throwable -> L21
        f22345b.set(true);     // Catch: Throwable -> L21
        ILogDepend.Companion.i(TAG, "SharedStateManager initialized");     // Catch: Throwable -> L21
        x r12 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
    }

    private static final void a(String r4, SharedValue r5) {
        SharedValue r6 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r5, SharedValue.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        o.e(r6, "value");
        ISecureLogDepend.Companion.d(TAG, "onStateChanged: key=" + r4 + ", value=" + r6.getValue());
        ((Map) ZeusTransformUtils.preCheckCast(f22347d, Map.class, "com.obric.aiagent.plugin")).put(r4, r6.getValue());
    }

    public final boolean a() {
        return f22345b.get();
    }

    private final boolean h() {
        if (f22345b.get() == false) goto L7;
        return true;
    L7:
        if (IAppContext.Companion.isDebug() == true) goto L11;
        ILogDepend.Companion.e(TAG, "SharedStateManager is not initialized! Please call init() first.");
        return false;
    L11:
        throw new IllegalStateException("SharedStateManager is not initialized! Please call init() first.");
    }

    public final String b() {
        String r0 = null;
        if (h() == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, Object> r5 = f22347d;
        Object r2 = r5.get("doubao_account_uid");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L8;
        r0 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L8:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        return r0;
    L17:
        String r1 = SharedState.INSTANCE.getString("doubao_account_uid", "");
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin")).put("doubao_account_uid", r1);
        return r1;
    L11:
        if (r3.length() == 0) goto L14;
        r4 = false;
        goto L15
    }

    public final String c() {
        CharSequence r0 = null;
        if (h() == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, Object> r1 = f22347d;
        Object r2 = r1.get("doubao_account_nick_name");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L9:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(SharedState.INSTANCE.getString("doubao_account_nick_name", ""), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("doubao_account_nick_name", r6);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r7) == true) goto L24;
        r0 = r7;
    L24:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L18:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L12:
        if (d.o.o.d(r4) == true) goto L15;
        r5 = false;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    public final String d() {
        CharSequence r0 = null;
        if (h() == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, Object> r1 = f22347d;
        Object r2 = r1.get("doubao_account_avatar_url");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L9:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(SharedState.INSTANCE.getString("doubao_account_avatar_url", ""), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("doubao_account_avatar_url", r6);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r7) == true) goto L24;
        r0 = r7;
    L24:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L18:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L12:
        if (d.o.o.d(r4) == true) goto L15;
        r5 = false;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    public final Map<String, String> e() {
        if (h() == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, Object> r2 = f22347d;
        Object r3 = r2.get("doubao_account_token_map");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L9:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L23;
        r4 = SharedState.INSTANCE.getString("doubao_account_token_map", "");
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put("doubao_account_token_map", r4);
    L23:
        return (Map) ZeusTransformUtils.preCheckCast(g().fromJson(r4, new SharedStateManager$getFlowTokenMap$1().getType()), Map.class, "com.obric.aiagent.plugin");
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getFlowTokenMap parse error: " + e.getMessage());
        return null;
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public final boolean f() {
        if (h() == true) goto L5;
        return false;
    L5:
        ConcurrentHashMap<String, Object> r5 = f22347d;
        Object r2 = r5.get("doubao_login_state");
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L8;
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");
    L9:
        if (r3 != null) goto L11;
        boolean r0 = SharedState.INSTANCE.getBoolean("doubao_login_state", false);
        Boolean r4 = Boolean.valueOf(r0);
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin")).put("doubao_login_state", r4);
        return r0;
    L11:
        return r3.booleanValue();
    L8:
        r3 = null;
        goto L9
    }

    public final boolean a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        c r3 = d.f16317a.a(r1, false);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.b() == true) goto L7;
        return false;
    L7:
        return true;
    }
}
