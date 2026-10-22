package h;

import b8.h;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends h {
    public static volatile a d;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2997c;

    public a(int i8) {
        switch (i8) {
            case 1:
                this.f2997c = new Object();
                Executors.newFixedThreadPool(4, new b());
                break;
            default:
                this.f2997c = new a(1);
                break;
        }
    }
}
