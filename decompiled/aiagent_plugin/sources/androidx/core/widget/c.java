package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EdgeEffectCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: compiled from: EdgeEffectCompat.java */
    static class a {
        static void a(EdgeEffect r0, float r1, float r2) {
            r0.onPull(r1, r2);
        }
    }

    /* JADX INFO: compiled from: EdgeEffectCompat.java */
    private static class b {
        public static EdgeEffect a(Context r2, AttributeSet r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            return new EdgeEffect(r4, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
        L6:
            return new EdgeEffect(r4);
        }

        public static float a(EdgeEffect r0, float r1, float r2) {
            return r0.onPullDistance(r1, r2);
        L4:
            r0.onPull(r1, r2);
            return 0.0f;
        }

        public static float a(EdgeEffect r0) {
            return r0.getDistance();
        L4:
            return 0.0f;
        }
    }

    public static EdgeEffect a(Context r2, AttributeSet r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return b.a(r4, r5);
    L7:
        return new EdgeEffect(r4);
    }

    public static float a(EdgeEffect r2) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return 0.0f;
    L5:
        return b.a(r2);
    }

    public static void a(EdgeEffect r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        a.a(r2, r3, r4);
        return;
    L5:
        r2.onPull(r3);
    }

    public static float b(EdgeEffect r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        a(r2, r3, r4);
        return r3;
    L5:
        return b.a(r2, r3, r4);
    }
}
