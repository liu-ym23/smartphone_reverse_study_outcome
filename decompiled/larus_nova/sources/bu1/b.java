package bu1;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements a {
    public b() {
    }

    @Override // bu1.a
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.b r100, IAction r101, View r102, j r103) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        Intrinsics.checkNotNullParameter(r103, "curTemplateHolder");
        Map<String, Object> r104 = r101.getParams();
        if (r104 == null) goto L7;
        if (r100 == null) goto L8;
        r100.b(r104);
        return;
    L8:
        return;
    }
}
