package kotlinx.serialization;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f3695b;

    public /* synthetic */ e(int i8, List list) {
        this.f3694a = i8;
        this.f3695b = list;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f3694a;
        List list = this.f3695b;
        switch (i8) {
            case 0:
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$0$0(list);
            default:
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0$0(list);
        }
    }
}
