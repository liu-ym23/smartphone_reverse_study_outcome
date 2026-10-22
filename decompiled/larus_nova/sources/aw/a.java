package aw;

import android.util.LruCache;
import kotlin.Pair;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0239a f16401a = null;

    /* JADX INFO: renamed from: aw.a$a, reason: collision with other inner class name */
    public static final class C0239a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LruCache<String, Pair<Boolean, Object>> f16402a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C0239a f16403b = null;

        public C0239a() {
        }

        static {
            f16403b = new C0239a();
            f16402a = new LruCache(3);
        }
    }

    static {
        f16401a = C0239a.f16403b;
    }
}
