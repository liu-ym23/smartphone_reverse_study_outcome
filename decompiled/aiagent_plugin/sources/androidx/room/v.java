package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SharedSQLiteStatement.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f2705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f2706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile androidx.sqlite.db.g f2707c;

    public abstract String a();

    public v(p r3) {
        this.f2705a = new AtomicBoolean(false);
        this.f2706b = r3;
    }

    public void b() {
        this.f2706b.h();
    }

    private androidx.sqlite.db.g d() {
        String r0 = a();
        return this.f2706b.a(r0);
    }

    private androidx.sqlite.db.g a(boolean r1) {
        if (r1 == false) goto L8;
        if (this.f2707c != null) goto L9;
        this.f2707c = d();
    L9:
        return this.f2707c;
    L8:
        return d();
    }

    public androidx.sqlite.db.g c() {
        b();
        return a(this.f2705a.compareAndSet(false, true));
    }

    public void a(androidx.sqlite.db.g r3) {
        if (((androidx.sqlite.db.g) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.g.class, "com.obric.aiagent.plugin")) != this.f2707c) goto L6;
        this.f2705a.set(false);
        return;
    }
}
