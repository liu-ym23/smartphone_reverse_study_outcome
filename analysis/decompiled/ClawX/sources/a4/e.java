package a4;

import java.io.Closeable;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final r4.a f98a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f99b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.l f100c;
    public p5.a d;

    public e(r4.a key, Object config, p5.l lVar) {
        p.e(key, "key");
        p.e(config, "config");
        this.f98a = key;
        this.f99b = config;
        this.f100c = lVar;
        this.d = new b(0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.d.invoke();
    }
}
