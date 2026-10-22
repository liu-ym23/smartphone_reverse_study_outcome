package td;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final x f13085a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13086b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13087c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13088d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13089e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13090f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13091g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final int f13092i;

    /* renamed from: j, reason: collision with root package name */
    public final int f13093j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f13094k;

    /* renamed from: l, reason: collision with root package name */
    public final Long f13095l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f13096m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f13097n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f13098o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f13099p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f13100q;

    public f(x canonicalPath, boolean z, String comment, long j10, long j11, long j12, int i10, long j13, int i11, int i12, Long l10, Long l11, Long l12, Integer num, Integer num2, Integer num3) {
        kotlin.jvm.internal.g.f(canonicalPath, "canonicalPath");
        kotlin.jvm.internal.g.f(comment, "comment");
        this.f13085a = canonicalPath;
        this.f13086b = z;
        this.f13087c = comment;
        this.f13088d = j10;
        this.f13089e = j11;
        this.f13090f = j12;
        this.f13091g = i10;
        this.h = j13;
        this.f13092i = i11;
        this.f13093j = i12;
        this.f13094k = l10;
        this.f13095l = l11;
        this.f13096m = l12;
        this.f13097n = num;
        this.f13098o = num2;
        this.f13099p = num3;
        this.f13100q = new ArrayList();
    }

    public /* synthetic */ f(x xVar, boolean z, String str, long j10, long j11, long j12, int i10, long j13, int i11, int i12, Long l10, Long l11, Long l12, int i13) {
        this(xVar, z, (i13 & 4) != 0 ? "" : str, (i13 & 8) != 0 ? -1L : j10, (i13 & 16) != 0 ? -1L : j11, (i13 & 32) != 0 ? -1L : j12, (i13 & 64) != 0 ? -1 : i10, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? -1L : j13, (i13 & 256) != 0 ? -1 : i11, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? -1 : i12, (i13 & 1024) != 0 ? null : l10, (i13 & 2048) != 0 ? null : l11, (i13 & 4096) != 0 ? null : l12, null, null, null);
    }
}
