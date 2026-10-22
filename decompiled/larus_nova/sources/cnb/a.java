package cnb;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.j;
import com.ss.android.lark.biz.im.api.o;
import com.ss.android.lark.biz.im.api.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements r {
    public a() {
    }

    @Override // com.ss.android.lark.biz.im.api.r
    public final void N(Context r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.biz.im.api.r
    public final void U(FragmentActivity r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
    }
}
