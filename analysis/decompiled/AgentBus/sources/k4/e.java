package k4;

import java.util.Set;
import p7.n;
import q7.k;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5611f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5612g;

    public /* synthetic */ e(String str, int i2) {
        this.f5611f = i2;
        this.f5612g = str;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        Set set = (Set) obj2;
        switch (this.f5611f) {
            case 0:
                k.e(str, "<unused var>");
                k.e(set, "ids");
                set.remove(this.f5612g);
                if (set.isEmpty()) {
                }
                break;
            default:
                k.e(str, "<unused var>");
                k.e(set, "ids");
                set.remove(this.f5612g);
                if (set.isEmpty()) {
                }
                break;
        }
        return set;
    }
}
