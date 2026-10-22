package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.y;
import kotlinx.serialization.json.JsonElement;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3706a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3707b;

    public /* synthetic */ a(int i8, Object obj) {
        this.f3706a = i8;
        this.f3707b = obj;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f3706a;
        Object obj2 = this.f3707b;
        switch (i8) {
            case 0:
                return AbstractJsonTreeEncoder.beginStructure$lambda$0((AbstractJsonTreeEncoder) obj2, (JsonElement) obj);
            default:
                return TreeJsonEncoderKt.writeJson$lambda$0((y) obj2, (JsonElement) obj);
        }
    }
}
