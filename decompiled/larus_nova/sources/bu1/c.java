package bu1;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f20722a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super String, Unit> r100) {
        this.f20722a = r100;
    }

    @Override // bu1.a
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.b r100, IAction r101, View r102, j r103) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        Intrinsics.checkNotNullParameter(r103, "curTemplateHolder");
        Map<String, Object> r104 = r101.getParams();
        if (r104 == null) goto L10;
        String r105 = com.bytedance.android.livesdk.dsl.util.c.d(r104, "scheme");
        if (r105 == null) goto L11;
        Function1<String, Unit> r106 = this.f20722a;
        if (r106 == null) goto L12;
        Unit r107 = r106.invoke(r105);
        return;
    L12:
        return;
    L11:
        return;
    }
}
