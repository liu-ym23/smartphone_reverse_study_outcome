package an6;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements iu6.b {
    public b() {
    }

    @Override // ns6.a
    public final List<String> a() {
        return null;
    }

    @Override // iu6.b
    public final c k0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new c(r100);
    }
}
