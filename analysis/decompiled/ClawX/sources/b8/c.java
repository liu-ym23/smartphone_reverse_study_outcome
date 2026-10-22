package b8;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f999a;

    /* renamed from: b, reason: collision with root package name */
    public final z7.a f1000b;

    public c(int i8) {
        this.f999a = i8;
        switch (i8) {
            case 1:
                this.f1000b = new f();
                new ConcurrentHashMap();
                new ThreadLocal();
                new a();
                break;
            default:
                this.f1000b = new t1.f(8);
                new ConcurrentHashMap();
                break;
        }
    }
}
