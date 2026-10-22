package cc4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f23261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f23262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f23263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f23264g;

    public final int hashCode() {
        if (TextUtils.isEmpty(this.f23258a) == false) goto L7;
        return super.hashCode();
    L7:
        return this.f23258a.hashCode();
    }

    public d(String r100) {
        this.f23258a = r100;
        System.currentTimeMillis();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof d) == false) goto L11;
        String r101 = this.f23258a;
        if (r101 == null) goto L11;
        return r101.equals(((d) r100).f23258a);
    L11:
        return false;
    }
}
