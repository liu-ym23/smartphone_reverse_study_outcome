package c62;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.yj1;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.d4;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements amc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f22555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final im2.d f22556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f22557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final im2.n f22558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vlc.c f22559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bc2.e f22560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.l f22561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f22562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f22563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f22564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f22565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f22566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f22567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f22568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f22569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<vlc.b> f22570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<vlc.j> f22571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final vlc.c f22572s;

    public static final class a {
    }

    static {
    }

    @Override // amc.e
    public final List<cmc.b<?>> e() {
        return null;
    }

    @Override // amc.e
    public final amc.b b() {
        return this.f22564k;
    }

    @Override // amc.e
    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.f22565l;
    }

    @Override // amc.e
    public final amc.i d() {
        return this.f22566m;
    }

    @Override // amc.e
    public final im2.n g() {
        return this.f22558e;
    }

    @Override // amc.e
    public final vlc.c getLogger() {
        return this.f22559f;
    }

    @Override // amc.e
    public final bc2.e getMonitor() {
        return this.f22560g;
    }

    @Override // amc.e
    public final amc.g getNetworkConfig() {
        return this.f22562i;
    }

    @Override // amc.e
    public final long getRoomId() {
        return this.f22567n;
    }

    public d(Context r100, long r101, String r110, boolean r111, List r112, List r113, com.bytedance.android.livesdk.interactivity.base.im.b r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r114, "channelLogger");
        this.f22567n = r101;
        this.f22568o = r110;
        this.f22569p = null;
        this.f22570q = r112;
        this.f22571r = r113;
        this.f22572s = r114;
        if (r111 == false) goto L5;
        String r102 = "anchor";
    L6:
        this.f22554a = r102;
        this.f22555b = new HashMap();
        this.f22556c = new im2.d(r111);
        Context r103 = r100.getApplicationContext();
        this.f22558e = new im2.n();
        this.f22559f = r114;
        this.f22560g = new bc2.e();
        if (yj1.f121695a.getValue().booleanValue() == true) goto L9;
    L11:
        com.ss.ugc.live.sdk.msg.network.l r104 = new im2.k(10010, r103, m.f22584a, new j(this), new k(this), new l(this));
    L12:
        this.f22561h = r104;
        this.f22562i = new g(this);
        this.f22563j = CollectionsKt.toSet(d4.m());
        this.f22564k = new e(this);
        this.f22565l = new f(this);
        this.f22566m = new i();
        return;
    L9:
        if (v.a() == false) goto L11;
        r104 = new com.ss.ugc.live.sdk.msg.network.a();
        goto L12
    L5:
        r102 = SourceType.DEFAULT;
        goto L6
    }
}
