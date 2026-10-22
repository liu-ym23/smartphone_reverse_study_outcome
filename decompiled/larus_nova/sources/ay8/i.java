package ay8;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f16770a;

    public i() {
        this.f16770a = new ArrayList();
    }

    public final void a(Function1<? super e, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        List<e> r101 = this.f16770a;
        e r102 = new e();
        r100.invoke(r102);
        if (r102.f16765e != (-1)) goto L5;
        r102.f16765e = r102.f16761a;
    L5:
        ((ArrayList) r101).add(r102);
    }
}
