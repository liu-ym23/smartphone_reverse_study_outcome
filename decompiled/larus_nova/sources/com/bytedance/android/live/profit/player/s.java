package com.bytedance.android.live.profit.player;

import com.lynx.tasm.LynxError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f88364a = 0;

    public static final class a {
        public static b a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            return new b(r100);
        }
    }

    public static final class b<T> extends s<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f88365b;

        public b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f88365b = r100;
        }
    }

    public static final class c<T> extends s<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f88366b;

        public c(T r100) {
            this.f88366b = r100;
        }
    }

    static {
    }

    public s() {
    }

    public final Throwable a() {
        if ((this instanceof c) == false) goto L6;
        return null;
    L6:
        if ((this instanceof b) == false) goto L10;
        return ((b) this).f88365b;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final T b() {
        if ((this instanceof c) == false) goto L6;
        return ((c) this).f88366b;
    L6:
        if ((this instanceof b) == false) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
