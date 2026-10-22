package cn7;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.ug.sdk.luckycat.api.depend.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final an7.c f24553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bn7.a f24554b;

    public final ti7.a a() {
        an7.c r100 = this.f24553a;
        if (r100 == null) goto L10;
        an7.b r101 = r100.f4553b;
        if (r101 == null) goto L12;
        bn7.b r102 = r101.f4550a;
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.a();
    L12:
        return null;
    L10:
        return null;
    }

    public a(an7.c r100) {
        this.f24553a = r100;
        an7.a r101 = r100.f4552a;
        if (r101 == null) goto L6;
        this.f24554b = r101.f4545b;
        return;
    }
}
