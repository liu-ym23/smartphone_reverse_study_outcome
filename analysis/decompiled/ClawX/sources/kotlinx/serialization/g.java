package kotlinx.serialization;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3696a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3697b;

    public /* synthetic */ g(int i8, Object obj) {
        this.f3696a = i8;
        this.f3697b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f3696a;
        Object obj = this.f3697b;
        switch (i8) {
            case 0:
                return SerializersKt__SerializersKt.serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt((ArrayList) obj);
            default:
                return PolymorphicSerializer.descriptor_delegate$lambda$0((PolymorphicSerializer) obj);
        }
    }
}
