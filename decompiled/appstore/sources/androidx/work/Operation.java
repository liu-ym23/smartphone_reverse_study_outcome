package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface Operation {

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final b.C0055b IN_PROGRESS = null;

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final b.c SUCCESS = null;

    public static /* synthetic */ class a {
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f5365a;

            public a(Throwable r10) {
                this.f5365a = r10;
            }

            public Throwable a() {
                return this.f5365a;
            }

            public String toString() {
                return "FAILURE (" + this.f5365a.getMessage() + ")";
            }
        }

        /* JADX INFO: renamed from: androidx.work.Operation$b$b, reason: collision with other inner class name */
        public static final class C0055b extends b {
            public /* synthetic */ C0055b(a r10) {
                this();
            }

            public String toString() {
                return "IN_PROGRESS";
            }

            public C0055b() {
            }
        }

        public static final class c extends b {
            public /* synthetic */ c(a r10) {
                this();
            }

            public String toString() {
                return "SUCCESS";
            }

            public c() {
            }
        }

        public b() {
        }
    }

    static {
        a r10 = null;
        SUCCESS = new b.c(r10);
        IN_PROGRESS = new b.C0055b(r10);
    }

    @NonNull
    ListenableFuture<b.c> getResult();

    @NonNull
    LiveData getState();
}
