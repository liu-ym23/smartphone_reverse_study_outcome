package s5;

import java.util.Random;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: b, reason: collision with root package name */
    public final a2.b f5239b = new a2.b(6);

    @Override // s5.a
    public final Random a() {
        Object obj = this.f5239b.get();
        p.d(obj, "get(...)");
        return (Random) obj;
    }
}
