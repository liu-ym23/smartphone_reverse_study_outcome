package bh7;

import android.content.Context;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.bytedance.timon.permission.storage.manager.TimonMediaInternal;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19051a = 0;

    static {
    }

    public static void a(Context r100, TimonMedia.ExtraInfo r101, TimonMediaInternal.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(null, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "extraInfo");
        Intrinsics.checkNotNullParameter(r102, "callback");
        throw null;
    }
}
