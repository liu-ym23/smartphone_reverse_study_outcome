package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelperFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class b implements androidx.sqlite.db.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.d.c f2615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2616b;

    @Override // androidx.sqlite.db.d.c
    public /* synthetic */ androidx.sqlite.db.d b(androidx.sqlite.db.d.b r1) {
        return a(r1);
    }

    b(androidx.sqlite.db.d.c r3, a r4) {
        this.f2615a = (androidx.sqlite.db.d.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.d.c.class, "com.obric.aiagent.plugin");
        this.f2616b = r4;
    }

    public AutoClosingRoomOpenHelper a(androidx.sqlite.db.d.b r3) {
        return new AutoClosingRoomOpenHelper(this.f2615a.b(r3), this.f2616b);
    }
}
