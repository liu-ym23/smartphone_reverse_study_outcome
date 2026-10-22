package com.bytedance.android.latch;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes44.dex */
public class LatchOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScriptContentLoader f58198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f58199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f58200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58201d;

    public interface ScriptContentLoader {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/latch/LatchOptions$ScriptContentLoader$Source;", "", "", "value", "I", "getValue", "()I", "OFFLINE", "CDN", "latch-core_release"}, k = 1, mv = {1, 4, 3})
        public static final enum Source extends Enum<Source> {
            public static final Source CDN = null;
            public static final Source OFFLINE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Source[] f58202a = null;
            private final int value;

            public static Source valueOf(String r100) {
                return (Source) r27.a.a(Source.class, r100);
            }

            public static Source[] values() {
                return (Source[]) f58202a.clone();
            }

            static {
                Source r100 = new Source("OFFLINE", 0, 0);
                OFFLINE = r100;
                Source r101 = new Source("CDN", 1, 1);
                CDN = r101;
                f58202a = new Source[]{r100, r101};
            }

            public final int getValue() {
                return this.value;
            }

            public Source(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static abstract class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f58203a;

            /* JADX INFO: renamed from: com.bytedance.android.latch.LatchOptions$ScriptContentLoader$a$a, reason: collision with other inner class name */
            public static final class C0924a extends a {
                public C0924a(String r100) {
                    Intrinsics.checkNotNullParameter(r100, "pageUrl");
                    super(r100);
                }
            }

            public static final class b extends a {
                public b(String r100) {
                    Intrinsics.checkNotNullParameter(r100, "pageUrl");
                    super(r100);
                }
            }

            public a(String r100) {
                this.f58203a = r100;
            }
        }

        void a(Context r100, a r101, Function2<? super String, ? super Source, Unit> r102);
    }

    public interface a {
        void a(String r100, int r101, long r102);

        void b(String r100, int r101, String r102, Map<String, ? extends Object> r103);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.latch.devtool.LatchDebuggerImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.latch.devtool.LatchDebuggerImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.latch.devtool.LatchDebuggerImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.latch.devtool.LatchDebuggerImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.latch.devtool.LatchDebuggerImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.latch.devtool.LatchDebuggerImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.latch.devtool.LatchDebuggerImpl");
    }

    public LatchOptions(ScriptContentLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "scriptContentLoader");
        this.f58198a = r100;
        this.f58199b = cx.a.f465672a;
        this.f58200c = SetsKt.emptySet();
    }

    public static void b(boolean r100) {
        if (r100 == false) goto L10;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Field r102 = a().getField("INSTANCE");     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        bx.a.C0370a r103 = bx.a.f21272a;     // Catch: Throwable -> L5
        Object r104 = r102.get(null);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.android.latch.internal.debug.ILatchDebugger");     // Catch: Throwable -> L5
        r103.getClass();     // Catch: Throwable -> L5
        bx.a.C0370a.f21274b = (bx.a) r104;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
