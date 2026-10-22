package kotlinx.coroutines.a;

import kotlinx.coroutines.internal.am;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface d<E> extends s<E>, t<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38805b = null;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f38806a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f38807b = 0;

        private a() {
        }

        static {
            f38806a = new a();
            f38807b = am.a("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
        }

        public final int a() {
            return f38807b;
        }
    }

    static {
        f38805b = a.f38806a;
    }
}
