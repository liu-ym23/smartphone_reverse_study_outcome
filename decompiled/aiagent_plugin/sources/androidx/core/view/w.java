package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PointerIconCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f1523a;

    /* JADX INFO: compiled from: PointerIconCompat.java */
    static class a {
        static PointerIcon a(Context r2, int r3) {
            return PointerIcon.getSystemIcon((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        }

        static PointerIcon a(Bitmap r0, float r1, float r2) {
            return PointerIcon.create(r0, r1, r2);
        }

        static PointerIcon a(Resources r0, int r1) {
            return PointerIcon.load(r0, r1);
        }
    }

    private w(PointerIcon r1) {
        this.f1523a = r1;
    }

    public Object a() {
        return this.f1523a;
    }

    public static w a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return new w(a.a(r4, r3));
    L7:
        return new w(null);
    }
}
