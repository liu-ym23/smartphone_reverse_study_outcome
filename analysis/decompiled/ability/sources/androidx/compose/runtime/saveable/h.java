package androidx.compose.runtime.saveable;

import S7.k;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1808a;

    public /* synthetic */ h(int i) {
        this.f1808a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1808a) {
            case 0:
                return SaveableStateHolderImpl.Saver$lambda$12((Map) obj);
            default:
                return SaverKt.AutoSaver$lambda$1(obj);
        }
    }
}
