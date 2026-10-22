package androidx.compose.runtime;

import S7.n;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaNImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1751a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(int i, int i6, Object obj, Object obj2) {
        this.f1751a = i6;
        this.d = obj;
        this.b = obj2;
        this.c = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1751a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return CompositionLocalKt.CompositionLocalProvider$lambda$1((ProvidedValue) this.d, (n) this.b, this.c, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return CompositionLocalKt.CompositionLocalProvider$lambda$0((ProvidedValue[]) this.d, (n) this.b, this.c, (Composer) obj, iIntValue2);
            case 2:
                int iIntValue3 = ((Integer) obj2).intValue();
                return CompositionLocalKt.CompositionLocalProvider$lambda$3((CompositionLocalContext) this.d, (n) this.b, this.c, (Composer) obj, iIntValue3);
            case 3:
                int iIntValue4 = ((Integer) obj2).intValue();
                return ComposableLambdaImpl.invoke$lambda$0((ComposableLambdaImpl) this.d, this.b, this.c, (Composer) obj, iIntValue4);
            default:
                int iIntValue5 = ((Integer) obj2).intValue();
                return ComposableLambdaNImpl.invoke$lambda$0((Object[]) this.d, this.c, (ComposableLambdaNImpl) this.b, (Composer) obj, iIntValue5);
        }
    }

    public /* synthetic */ e(Object[] objArr, int i, ComposableLambdaNImpl composableLambdaNImpl) {
        this.f1751a = 4;
        this.d = objArr;
        this.c = i;
        this.b = composableLambdaNImpl;
    }
}
