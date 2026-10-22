package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutinesRoom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f4446a = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Flow a(RoomDatabase r10, boolean r11, String[] r12, Callable r13) {
            return kotlinx.coroutines.flow.c.A(new CoroutinesRoom$Companion$createFlow$1(r11, r10, r12, r13, null));
        }

        public final Object b(RoomDatabase r10, boolean r11, final CancellationSignal r12, Callable r13, Continuation r14) {
            if (r10.z() == true) goto L5;
        L8:
            w0 r15 = (w0) r14.getContext().get(w0.f4708c);
            if (r15 == null) goto L14;
            ContinuationInterceptor r16 = r15.b();
            if (r16 == null) goto L14;
        L13:
            ContinuationInterceptor r17 = r16;
            kotlinx.coroutines.n r18 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r14), 1);
            r18.initCancellability();
            final Job r19 = kotlinx.coroutines.h.d(kotlinx.coroutines.y0.f21772a, r17, null, new CoroutinesRoom$Companion$execute$4$job$1(r13, r18, null), 2, null);
            r18.invokeOnCancellation(new CoroutinesRoom$Companion$execute$4$1(r12, r19));
            Object r20 = r18.q();
            if (r20 != kotlin.coroutines.intrinsics.a.d()) goto L20;
            tf.d.c(r14);
        L20:
            return r20;
        L14:
            if (r11 == false) goto L16;
            r16 = g.b(r10);
            goto L13
        L16:
            r16 = g.a(r10);
            goto L13
        L5:
            if (r10.t() == false) goto L8;
            return r13.call();
        }

        public final Object c(RoomDatabase r10, boolean r11, Callable r12, Continuation r13) {
            if (r10.z() == true) goto L5;
        L8:
            w0 r14 = (w0) r13.getContext().get(w0.f4708c);
            if (r14 == null) goto L12;
            ContinuationInterceptor r15 = r14.b();
            if (r15 == null) goto L12;
        L16:
            return kotlinx.coroutines.h.g(r15, new CoroutinesRoom$Companion$execute$2(r12, null), r13);
        L12:
            if (r11 == false) goto L14;
            r15 = g.b(r10);
            goto L16
        L14:
            r15 = g.a(r10);
            goto L16
        L5:
            if (r10.t() == false) goto L8;
            return r12.call();
        }

        public Companion() {
        }
    }

    static {
        f4446a = new Companion(null);
    }

    public static final Flow a(RoomDatabase r10, boolean r11, String[] r12, Callable r13) {
        return f4446a.a(r10, r11, r12, r13);
    }

    public static final Object b(RoomDatabase r10, boolean r11, CancellationSignal r12, Callable r13, Continuation r14) {
        return f4446a.b(r10, r11, r12, r13, r14);
    }

    public static final Object c(RoomDatabase r10, boolean r11, Callable r12, Continuation r13) {
        return f4446a.c(r10, r11, r12, r13);
    }
}
