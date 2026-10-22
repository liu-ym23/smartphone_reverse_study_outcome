package X6;

import android.os.Parcel;
import java.util.function.BiConsumer;
import stepai.android.mindx.base.LLMInterface;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1516a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m(Object obj, int i) {
        this.f1516a = i;
        this.b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f1516a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                ((c) obj3).d((String) obj, (String) obj2);
                break;
            case 1:
                ((c) obj3).c((String) obj, (String) obj2);
                break;
            default:
                LLMInterface.Stub.lambda$onTransact$0((Parcel) obj3, (String) obj, (String) obj2);
                break;
        }
    }
}
