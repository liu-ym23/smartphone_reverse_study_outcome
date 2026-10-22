package a4;

import java.util.ArrayList;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final t3.c f92a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f93b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f94c;
    public final b d;

    public c(r4.a key, t3.c client, Object pluginConfig) {
        p.e(key, "key");
        p.e(client, "client");
        p.e(pluginConfig, "pluginConfig");
        this.f92a = client;
        this.f93b = pluginConfig;
        this.f94c = new ArrayList();
        this.d = new b(0);
    }

    public final void a(a aVar, h5.i iVar) {
        this.f94c.add(new f(aVar, iVar));
    }
}
