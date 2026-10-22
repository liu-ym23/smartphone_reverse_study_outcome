package bm4;

import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    static {
    }

    public static Context a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = d.f473061a;
        Intrinsics.checkNotNullParameter("dux.ThemeHelper", "tag");
        Intrinsics.checkNotNullParameter("createForceNightModeContext(): using original method", "msg");
        Configuration r103 = new Configuration();
        r103.setTo(r100.getResources().getConfiguration());
        if (r101 == false) goto L5;
        int r104 = 32;
    L6:
        r103.uiMode = r104 | (r103.uiMode & (-49));
        Context r105 = r100.createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r105);
        return r105;
    L5:
        r104 = 16;
        goto L6
    }
}
