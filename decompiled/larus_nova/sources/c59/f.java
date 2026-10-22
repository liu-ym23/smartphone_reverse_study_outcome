package c59;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f22510a;

    public f(b r100) {
        this.f22510a = r100;
    }

    @Override // c59.d
    public final boolean a(Context r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        int r102 = com.larus.dora.impl.util.h0.f338139a;
        return com.larus.dora.impl.util.h0.b(this.f22510a.e());
    }
}
