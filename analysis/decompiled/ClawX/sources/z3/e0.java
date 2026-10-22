package z3;

import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6436a;

    public /* synthetic */ e0(int i8) {
        this.f6436a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6436a) {
            case 0:
                return a.a.l(x.f.V((Charset) obj), x.f.V((Charset) obj2));
            default:
                return a.a.l((Float) ((b5.g) obj2).f893b, (Float) ((b5.g) obj).f893b);
        }
    }
}
