package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f209a;

        public a(Object r10) {
            this.f209a = r10;
        }

        public final Object a() {
            return this.f209a;
        }
    }

    public ActivityResultContract() {
    }

    public abstract Intent a(Context r10, Object r11);

    public a b(Context r10, Object r11) {
        q.g(r10, "context");
        return null;
    }

    public abstract Object c(int r10, Intent r11);
}
