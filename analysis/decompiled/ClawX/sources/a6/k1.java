package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class k1 extends kotlin.jvm.internal.n implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f186a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k1(int i8, Object obj, Class cls, String str, String str2, int i9, int i10) {
        super(i8, obj, cls, str, str2, i9);
        this.f186a = i10;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f186a) {
            case 0:
                ((l1) this.receiver).l((Throwable) obj);
                return b5.a0.f883a;
            default:
                return ((io.ktor.utils.io.m) ((io.ktor.utils.io.d0) this.receiver)).h((f5.c) obj);
        }
    }
}
