package com.bytedance.android.livesdk.interactivity.seek.v2;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import gm2.l;
import java.util.List;
import java.util.Set;
import vlc.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements amc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f140827a;

    public static final class a<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f140828a;

        public a(d r100) {
            this.f140828a = r100;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.f140828a.f140827a.f140818s);
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
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return this.f140827a.f140811l;
    }

    @Override // amc.b
    public final k f() {
        return new l(new a(this));
    }

    @Override // amc.b
    public final List<vlc.b> getInterceptors() {
        return this.f140827a.f140825z;
    }

    @Override // amc.b
    public final Set<String> h() {
        return this.f140827a.f140812m;
    }

    @Override // amc.b
    public final List<vlc.j> i() {
        return this.f140827a.A;
    }

    public d(b r100) {
        this.f140827a = r100;
    }
}
