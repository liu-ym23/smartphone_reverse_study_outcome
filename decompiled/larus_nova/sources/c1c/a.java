package c1c;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.storage.kv.repo.a f22112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22113b;

    /* JADX INFO: renamed from: c1c.a$a, reason: collision with other inner class name */
    public static class C0391a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f22114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f22115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f22116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f22117d;

        public C0391a() {
        }

        public final String toString() {
            return this.f22114a + "#" + this.f22115b + "#" + this.f22116c + "#" + this.f22117d;
        }
    }

    public final KVRepo a() {
        if (this.f22112a != null) goto L6;
        this.f22112a = LarkKVStorage.p(new com.ss.android.lark.storage.a("core"), "launch_preload_config", false);
    L6:
        return this.f22112a;
    }

    public a() {
    }
}
