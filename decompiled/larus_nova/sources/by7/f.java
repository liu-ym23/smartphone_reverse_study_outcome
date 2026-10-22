package by7;

import com.ixigua.lib.track.TrackParams;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackParams f21467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f21468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f21469c;

    @Override // by7.e
    public final e referrerTrackNode() {
        e r100 = this.f21469c;
        if (r100 != null) goto L11;
        e r101 = this.f21468b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.referrerTrackNode();
    L11:
        return r100;
    }

    public f() {
        this.f21468b = null;
        this.f21469c = null;
        this.f21467a = new TrackParams();
    }

    @Override // by7.e
    public final e parentTrackNode() {
        return this.f21468b;
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        r100.merge(this.f21467a);
    }
}
