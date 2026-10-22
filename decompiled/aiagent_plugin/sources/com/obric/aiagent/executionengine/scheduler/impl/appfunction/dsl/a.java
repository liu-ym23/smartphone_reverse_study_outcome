package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import android.app.Application;
import com.obric.aiagent.executionengine.utils.e;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.f.t;
import d.g;
import d.h.b.o;
import d.n;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfigRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AppFuncDslConfigRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f18158b = null;

    public static /* synthetic */ AppFunctionCompatConfig lambda$VI2Dmd_jau5daUG8Irc93YyqfUg() {
        return d();
    }

    private a() {
    }

    static {
        f18157a = new a();
        f18158b = g.a($$Lambda$a$VI2Dmd_jau5daUG8Irc93YyqfUg.INSTANCE);
    }

    private final AppFunctionCompatConfig b() {
        return (AppFunctionCompatConfig) ZeusTransformUtils.preCheckCast(f18158b.b(), AppFunctionCompatConfig.class, "com.obric.aiagent.plugin");
    }

    private static final AppFunctionCompatConfig d() {
        return f18157a.c();
    }

    public final Map<String, AppFunctionIntentMapping> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        AppFunctionCompatConfig r7 = b();
        if (r7 == null) goto L5;
        List<AppFunctionProductConfig> r8 = r7.getProductConfigList();
    L6:
        if (r8 != null) goto L8;
        r8 = p.b();
    L8:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r9.hasNext() == false) goto L22;
        AppFunctionProductConfig r1 = (AppFunctionProductConfig) ZeusTransformUtils.preCheckCast(r9.next(), AppFunctionProductConfig.class, "com.obric.aiagent.plugin");
        if (f18157a.a(r1) == false) goto L10;
        Iterator<Map.Entry<String, AppFunctionIntentMapping>> r2 = r1.getIntents().entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        AppFunctionIntentMapping r5 = (AppFunctionIntentMapping) ZeusTransformUtils.preCheckCast(r3.getValue(), AppFunctionIntentMapping.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5.getFunctions(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        if (r0.containsKey(r4) == true) goto L15;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r4, r5);
        goto L15
    L22:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    L5:
        r8 = null;
        goto L6
    }

    public final AppFunctionIntentMapping a(String r6) {
        o.e(r6, "intentName");
        AppFunctionCompatConfig r5 = b();
        if (r5 == null) goto L5;
        List<AppFunctionProductConfig> r7 = r5.getProductConfigList();
    L6:
        if (r7 != null) goto L8;
        r7 = p.b();
    L8:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L20;
        AppFunctionProductConfig r1 = (AppFunctionProductConfig) ZeusTransformUtils.preCheckCast(r8.next(), AppFunctionProductConfig.class, "com.obric.aiagent.plugin");
        if (f18157a.a(r1) == false) goto L10;
        AppFunctionIntentMapping r2 = (AppFunctionIntentMapping) ZeusTransformUtils.preCheckCast(r1.getIntents().get(r6), AppFunctionIntentMapping.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        if (r2.getFunctions().isEmpty() == false) goto L19;
        ILogDepend.Companion.w(TAG, "empty AppFunction DSL mapping for intent=" + r6);
        goto L10
    L19:
        return r2;
    L20:
        return null;
    L5:
        r7 = null;
        goto L6
    }

    private final AppFunctionCompatConfig c() {
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L23
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        InputStream r7 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getAssets().open("o_intent_to_function_config.json");     // Catch: Throwable -> L23
        o.c(r7, "open(...)");     // Catch: Throwable -> L23
        Reader r8 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r7, d.o.d.f38623b), Reader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r8, BufferedReader.class) == false) goto L6;
        BufferedReader r9 = (BufferedReader) ZeusTransformUtils.preCheckCast(r8, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
    L7:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        String r3 = t.a((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r10, BufferedReader.class, "com.obric.aiagent.plugin"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        d.f.c.a(r10, null);     // Catch: Throwable -> L23
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        AppFunctionCompatConfig r11 = (AppFunctionCompatConfig) ZeusTransformUtils.preCheckCast(e.a().fromJson(r3, AppFunctionCompatConfig.class), AppFunctionCompatConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
    L16:
        Object r12 = n.f(r11);     // Catch: Throwable -> L23
    L25:
        Throwable r4 = n.c(r12);
        if (r4 == null) goto L29;
        ILogDepend.Companion.w(TAG, "load AppFunction DSL config failed: " + r4.getMessage());
    L29:
        if (n.b(r12) == true) goto L33;
        r1 = r12;
    L33:
        return (AppFunctionCompatConfig) ZeusTransformUtils.preCheckCast(r1, AppFunctionCompatConfig.class, "com.obric.aiagent.plugin");
    L15:
        r11 = null;
        goto L16
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        d.f.c.a(r10, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L6:
        r9 = new BufferedReader(r8, 8192);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        n.a r5 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L25
    }

    private final boolean a(AppFunctionProductConfig r6) {
        if (r6.getMatchAll() == false) goto L5;
        return true;
    L5:
        String r5 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L27;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r6.getProductNames(), Collection.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L27;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6.getProductNames(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L19;
    L21:
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L26;
        if (d.o.o.a((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), r5, true) == false) goto L23;
        return true;
    L26:
        return false;
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
    L10:
        if (r1.isEmpty() == true) goto L13;
        r2 = false;
    L27:
        return false;
    }
}
