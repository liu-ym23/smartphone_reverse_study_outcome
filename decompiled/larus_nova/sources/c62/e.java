package c62;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements amc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f22573a;

    public static final class a<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f22574a;

        public a(e r100) {
            this.f22574a = r100;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.f22574a.f22573a.f22567n);
        }
    }

    @Override // amc.b
    public final long a() {
        return 200;
    }

    @Override // amc.b
    public final boolean c() {
        return true;
    }

    @Override // amc.b
    public final long d() {
        return AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }

    @Override // amc.b
    public final void e() {
    }

    @Override // amc.b
    public final com.ss.ugc.live.sdk.msg.dispatch.g g() {
        return null;
    }

    @Override // amc.b
    public final int j() {
        return 512;
    }

    @Override // amc.b
    public final vlc.k f() {
        return new gm2.l(new a(this));
    }

    @Override // amc.b
    public final List<vlc.b> getInterceptors() {
        return this.f22573a.f22570q;
    }

    @Override // amc.b
    public final Set<String> h() {
        return this.f22573a.f22563j;
    }

    @Override // amc.b
    public final List<vlc.j> i() {
        return this.f22573a.f22571r;
    }

    @Override // amc.b
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return CollectionsKt.emptyList();
    }

    public e(d r100) {
        this.f22573a = r100;
    }
}
