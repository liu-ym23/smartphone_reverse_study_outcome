package m0;

import java.util.Map;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends q implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3888b = new a(1);

    @Override // p5.l
    public final Object invoke(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        p.e(entry, "entry");
        Object value = entry.getValue();
        return "  " + ((c) entry.getKey()).f3891a + " = " + (value instanceof byte[] ? c5.l.h0((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
    }
}
