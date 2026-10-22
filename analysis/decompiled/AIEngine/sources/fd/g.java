package fd;

import ad.l;
import ad.t;
import kotlin.text.Regex;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends t {

    /* renamed from: b, reason: collision with root package name */
    public final String f8843b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8844c;

    /* renamed from: d, reason: collision with root package name */
    public final z f8845d;

    public g(String str, long j10, z zVar) {
        this.f8843b = str;
        this.f8844c = j10;
        this.f8845d = zVar;
    }

    @Override // ad.t
    public final long a() {
        return this.f8844c;
    }

    @Override // ad.t
    public final l o() {
        String str = this.f8843b;
        if (str == null) {
            return null;
        }
        Regex regex = bd.d.f3219a;
        try {
            return bd.d.a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // ad.t
    public final sd.h w() {
        return this.f8845d;
    }
}
