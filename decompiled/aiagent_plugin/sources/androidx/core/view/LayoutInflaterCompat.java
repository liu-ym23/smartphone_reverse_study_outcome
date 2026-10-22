package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1387b;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final f mDelegateFactory;

        Factory2Wrapper(f r3) {
            this.mDelegateFactory = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r3, Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
            return this.mDelegateFactory.a(null, r3, r6, r7);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
            return this.mDelegateFactory.a(r3, r4, r7, r8);
        }

        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    private static void b(LayoutInflater r6, LayoutInflater.Factory2 r7) {
        LayoutInflater.Factory2 r8 = (LayoutInflater.Factory2) ZeusTransformUtils.wrapperContextForParams(r7, LayoutInflater.Factory2.class, "com.obric.aiagent.plugin");
        if (f1387b == false) goto L19;
    L10:
        Field r0 = f1386a;
        if (r0 == null) goto L21;
        r0.set(r6, r8);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        a(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r6 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L19:
        Field r3 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        f1386a = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        f1387b = true;
    L7:
        e = move-exception;
        a(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
        goto L9
    }

    public static void a(LayoutInflater r3, LayoutInflater.Factory2 r4) {
        LayoutInflater.Factory2 r5 = (LayoutInflater.Factory2) ZeusTransformUtils.wrapperContextForParams(r4, LayoutInflater.Factory2.class, "com.obric.aiagent.plugin");
        r3.setFactory2(r5);
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        LayoutInflater.Factory r0 = r3.getFactory();
        if (ZeusTransformUtils.instanceOf(r0, LayoutInflater.Factory2.class) == false) goto L7;
        b(r3, (LayoutInflater.Factory2) ZeusTransformUtils.preCheckCast(r0, LayoutInflater.Factory2.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        b(r3, r5);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
