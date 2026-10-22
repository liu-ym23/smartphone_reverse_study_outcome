package com.obric.aiagent.platform.utils;

import android.app.Application;
import android.content.ContentResolver;
import android.provider.Settings;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.a;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.n;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PriorityConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public class PriorityConfig<T> {
    public static final Companion Companion = null;
    public static final int DEFINE_DEFAULT = 0;
    public static final int DEFINE_ON_CLOUD = 10;
    public static final int DEFINE_ON_DEBUG = 99;
    public static final int DEFINE_ON_RUNTIME = 50;
    private static final String TAG = "PriorityConfig";
    private final ContentResolver cr;
    private final T defaultValue;
    private final ArrayList<m<Integer, a<T>>> supplierPoll;
    private final String tag;

    /* JADX INFO: compiled from: PriorityConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final Object addDefaultValue$lambda$1(Object r0) {
        return r0;
    }

    public static /* synthetic */ Object lambda$1hWAo4GYSq58xmoOdV3RzYCSzSA(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$3(r0, r1);
    }

    public static /* synthetic */ Object lambda$6VJXcE8UYccXMIL5mmnor8RqV8w(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$4(r0, r1);
    }

    public static /* synthetic */ Object lambda$BBfHwXVD26RahtKWHMylsHvMDP4(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$6(r0, r1);
    }

    public static /* synthetic */ Object lambda$aSS2gJ3MTib3a7SMuvQKRygOyAI(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$f8JqwNNLgEbgFqBa-9pkIEYTNL4, reason: not valid java name */
    public static /* synthetic */ Object m200lambda$f8JqwNNLgEbgFqBa9pkIEYTNL4(Object r0) {
        return addDefaultValue$lambda$1(r0);
    }

    public static /* synthetic */ Object lambda$fo3fd11RB0WOzj52iK04jDiyBuo(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$5(r0, r1);
    }

    public static /* synthetic */ Object lambda$yl5d1JkEBILhB2ABeqNIXI3g6GI(PriorityConfig r0, String r1) {
        return addBySystemDebug$lambda$7(r0, r1);
    }

    public PriorityConfig(T r3) {
        this.defaultValue = r3;
        this.cr = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver();
        this.supplierPoll = new ArrayList();
    }

    private final void addToPoll(m<Integer, ? extends a<? extends T>> r7) {
        ArrayList<m<Integer, a<T>>> r0 = this.supplierPoll;
        monitor-enter(r0);
        int r1 = p.b((List) ZeusTransformUtils.preCheckCast(this.supplierPoll, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L6:
        if ((-1) >= r1) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).intValue() >= ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(this.supplierPoll.get(r1), m.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L9;
        r1 = r1 - 1;     // Catch: Throwable -> L15
        goto L6
    L9:
        this.supplierPoll.add(r1 + 1, r7);     // Catch: Throwable -> L15
    L12:
        x r6 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L11:
        this.supplierPoll.add(0, r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public String getTag() {
        return this.tag;
    }

    private final String getLogTag() {
        String r0 = getTag();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getClass().getSimpleName();
    }

    public final T get() {
        int r0 = p.b((List) ZeusTransformUtils.preCheckCast(this.supplierPoll, List.class, "com.obric.aiagent.plugin"));
    L4:
        if ((-1) >= r0) goto L10;
        m<Integer, a<T>> r1 = this.supplierPoll.get(r0);
        o.c(r1, "get(...)");
        m r2 = (m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin");
        T r3 = (T) ((a) ZeusTransformUtils.preCheckCast(r2.b(), a.class, "com.obric.aiagent.plugin")).invoke();
        if (r3 != null) goto L7;
        r0 = r0 - 1;
        goto L4
    L7:
        dump("get[" + ((Number) ZeusTransformUtils.preCheckCast(r2.a(), Number.class, "com.obric.aiagent.plugin")).intValue() + ',' + r0 + "] -> " + r3);
        return r3;
    L10:
        dump("get[0,0] -> " + this.defaultValue);
        return this.defaultValue;
    }

    public final void add(int r3, a<? extends T> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r5, "supplier");
        addToPoll(s.a(Integer.valueOf(r3), r5));
    }

    public final void addDefaultValue(final T r2) {
        add(0, new $$Lambda$PriorityConfig$f8JqwNNLgEbgFqBa9pkIEYTNL4(r2));
    }

    public final void addByDefault(a<? extends T> r3) {
        a<? extends T> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "supplier");
        add(0, r4);
    }

    public final void addByCloud(a<? extends T> r3) {
        a<? extends T> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "supplier");
        add(10, r4);
    }

    public final void addByRuntime(a<? extends T> r3) {
        a<? extends T> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "supplier");
        add(50, r4);
    }

    public static /* synthetic */ void addBySystemDebug$default(PriorityConfig r0, String r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.addBySystemDebug(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBySystemDebug");
    }

    public final void addBySystemDebug(final String r2, boolean r3) {
        o.e(r2, "sysKey");
        if (r3 == false) goto L17;
        T r4 = this.defaultValue;
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L7;
    L16:
        a<? extends T> r5 = new $$Lambda$PriorityConfig$aSS2gJ3MTib3a7SMuvQKRygOyAI(this, r2);
    L30:
        add(99, r5);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L13;
        r5 = new $$Lambda$PriorityConfig$1hWAo4GYSq58xmoOdV3RzYCSzSA(this, r2);
        goto L30
    L13:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L15;
        r5 = new $$Lambda$PriorityConfig$6VJXcE8UYccXMIL5mmnor8RqV8w(this, r2);
        goto L30
    L15:
        return;
    L17:
        T r6 = this.defaultValue;
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L20;
    L29:
        r5 = new $$Lambda$PriorityConfig$fo3fd11RB0WOzj52iK04jDiyBuo(this, r2);
        goto L30
    L20:
        if (ZeusTransformUtils.instanceOf(r6, Long.class) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L26;
        r5 = new $$Lambda$PriorityConfig$BBfHwXVD26RahtKWHMylsHvMDP4(this, r2);
        goto L30
    L26:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L28;
        r5 = new $$Lambda$PriorityConfig$yl5d1JkEBILhB2ABeqNIXI3g6GI(this, r2);
        goto L30
    }

    private static final Object addBySystemDebug$lambda$2(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getIntFromSettingsSecure(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private static final Object addBySystemDebug$lambda$3(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getBooleanFromSettingsSecure(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private static final Object addBySystemDebug$lambda$4(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getStringFromSettingsSecure(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private static final Object addBySystemDebug$lambda$5(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getIntFromSettingsGlobal(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private static final Object addBySystemDebug$lambda$6(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getBooleanFromSettingsGlobal(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private static final Object addBySystemDebug$lambda$7(PriorityConfig r1, String r2) {
        return ZeusTransformUtils.preCheckCast(r1.getStringFromSettingsGlobal(r2), Object.class, "com.obric.aiagent.plugin");
    }

    private final Integer getIntFromSettingsGlobal(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r2 = n.f(Integer.valueOf(Settings.Global.getInt(((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin")).cr, r3)));     // Catch: Throwable -> L5
    L8:
        if (n.b(r2) == false) goto L11;
        r2 = null;
    L11:
        return (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L8
    }

    private final Integer getIntFromSettingsSecure(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r2 = n.f(Integer.valueOf(Settings.Secure.getInt(((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin")).cr, r3)));     // Catch: Throwable -> L5
    L8:
        if (n.b(r2) == false) goto L11;
        r2 = null;
    L11:
        return (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L8
    }

    private final Boolean getBooleanFromSettingsGlobal(String r1) {
        String r0 = getStringFromSettingsGlobal(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (o.a(r0, "1") == false) goto L7;
    L14:
        boolean r2 = true;
    L18:
        return Boolean.valueOf(r2);
    L7:
        if (o.a(r0, "true") == true) goto L14;
        if (o.a(r0, "True") == true) goto L14;
        if (o.a(r0, "TRUE") == true) goto L14;
        r2 = false;
        goto L18
    }

    private final Boolean getBooleanFromSettingsSecure(String r1) {
        String r0 = getStringFromSettingsSecure(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (o.a(r0, "1") == false) goto L7;
    L14:
        boolean r2 = true;
    L18:
        return Boolean.valueOf(r2);
    L7:
        if (o.a(r0, "true") == true) goto L14;
        if (o.a(r0, "True") == true) goto L14;
        if (o.a(r0, "TRUE") == true) goto L14;
        r2 = false;
        goto L18
    }

    private final String getStringFromSettingsGlobal(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r2 = n.f(Settings.Global.getString(((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin")).cr, r3));     // Catch: Throwable -> L5
    L8:
        if (n.b(r2) == false) goto L10;
        r2 = null;
    L10:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
        return null;
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        return null;
    L18:
        return r4;
    L15:
        r5 = false;
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L8
    }

    private final String getStringFromSettingsSecure(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r2 = n.f(Settings.Secure.getString(((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin")).cr, r3));     // Catch: Throwable -> L5
    L8:
        if (n.b(r2) == false) goto L10;
        r2 = null;
    L10:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
        return null;
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        return null;
    L18:
        return r4;
    L15:
        r5 = false;
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r2 = n.f(d.o.a(th));
        goto L8
    }

    private final void dump(String r4) {
        ISysLogDepend.Companion r0 = ISysLogDepend.Companion;
        String r1 = getLogTag();
        o.c(r1, "<get-logTag>(...)");
        r0.d(r1, r4);
        ILogDepend.Companion r2 = ILogDepend.Companion;
        String r3 = getLogTag();
        o.c(r3, "<get-logTag>(...)");
        r2.d(r3, r4);
    }
}
