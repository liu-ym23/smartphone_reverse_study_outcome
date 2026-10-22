package androidx.compose.runtime.saveable;

import S7.k;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1804a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f1804a = i;
        this.b = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1804a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return Boolean.valueOf(SaveableStateHolderImpl.canBeSaved$lambda$0((SaveableStateHolderImpl) obj2, obj));
            default:
                return MapSaverKt.mapSaver$lambda$4((k) obj2, (List) obj);
        }
    }
}
