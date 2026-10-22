package androidx.recyclerview.base;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4029a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final VelocityTracker a(Context r10) {
            q.g(r10, "context");
            return b(r10, 1);
        }

        public final VelocityTracker b(Context r10, int r11) {
            q.g(r10, "context");
            if (r11 == 1) goto L11;
            if (r11 != 2) goto L9;
            return new d(r10);
        L9:
            throw new RuntimeException("impl is not supported");
        L11:
            return new f();
        }

        public a() {
        }
    }

    static {
        f4029a = new a(null);
    }

    public static final VelocityTracker a(Context r10) {
        return f4029a.a(r10);
    }
}
