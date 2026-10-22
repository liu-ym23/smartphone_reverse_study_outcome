package anb;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements rza.a {
    public a() {
    }

    @Override // rza.a
    public final void w0(Context r100, ActivityResultLauncher<String> r101, ActivityResultLauncher<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickLauncher");
        Intrinsics.checkNotNullParameter(r102, "pickSDKLauncher");
        Log.i("pickAvatar");
    }
}
