package androidx.compose.runtime.saveable;

import S7.n;
import androidx.compose.runtime.MutableState;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1801a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1801a = i;
        this.b = obj;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1801a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                return ListSaverKt.listSaver$lambda$1((n) obj3, (SaverScope) obj, obj2);
            case 1:
                return MapSaverKt.mapSaver$lambda$2((n) obj3, (SaverScope) obj, obj2);
            default:
                return RememberSaveableKt.mutableStateSaver$lambda$6$lambda$5((Saver) obj3, (SaverScope) obj, (MutableState) obj2);
        }
    }
}
