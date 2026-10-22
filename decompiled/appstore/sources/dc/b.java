package dc;

import androidx.recyclerview.widget.RecyclerView;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.IFPSCallBack;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f19147a = null;

    static {
        f19147a = new b();
    }

    public b() {
    }

    public static final c a(String r10, RecyclerView r11, boolean r12, IFPSCallBack r13) {
        q.g(r10, "scene");
        q.g(r11, "view");
        c r14 = new c(r10, r12, r13);
        r11.addOnScrollListener(r14);
        return r14;
    }
}
