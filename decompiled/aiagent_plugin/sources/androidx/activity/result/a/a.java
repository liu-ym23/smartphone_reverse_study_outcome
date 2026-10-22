package androidx.activity.result.a;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActivityResultContract.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: androidx.activity.result.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityResultContract.kt */
    public static final class C0004a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f163a;

        public C0004a(T r1) {
            this.f163a = r1;
        }

        public final T a() {
            return this.f163a;
        }
    }

    public abstract Intent a(Context r1, I r2);

    public abstract O a(int r1, Intent r2);

    public C0004a<O> b(Context r1, I r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin"), "context");
        return null;
    }

    public a() {
    }
}
