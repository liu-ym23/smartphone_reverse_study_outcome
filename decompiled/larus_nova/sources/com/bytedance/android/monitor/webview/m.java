package com.bytedance.android.monitor.webview;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends dz2.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ JSONObject f162957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f162958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ py2.b f162959j;

    public class a extends dz2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f162960c;

        @Override // dz2.a
        public final void c() {
        }

        @Override // ny2.a
        public final void b(JSONObject r100) {
            bz2.e.a(r100, this.f162960c.f162957h);
        }

        public a(m r100, String r101) {
            this.f162960c = r100;
            super(r101);
            this.f470571b = true;
        }
    }

    @Override // dz2.c
    public final dz2.a i() {
        if (this.f162957h != null) goto L7;
        return null;
    L7:
        return new a(this, this.f162958i);
    }

    @Override // dz2.c, ny2.g
    public final /* bridge */ /* synthetic */ ny2.b f() {
        return i();
    }

    @Override // ny2.g
    public final ny2.f d() {
        return this.f162959j;
    }

    public m(ez2.c r100, String r101, String r102, JSONObject r103, String r104, py2.b r105) {
        this.f162957h = r103;
        this.f162958i = r104;
        this.f162959j = r105;
        super(r100, r101, r102);
    }
}
