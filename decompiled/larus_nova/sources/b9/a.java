package b9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ss.android.lark.utils.statistics.PerfLog;
import h8.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // b9.b
    public final HybridFragment B1(Context r100, Uri r101, b7.b r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r101, "rawUri");
        return null;
    }

    @Override // b9.b
    public final HybridCard J0(Context r100, Uri r101, b7.b r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rawUri");
        return null;
    }

    @Override // b9.b
    public final void f0(KitType r100, Uri r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "kitType");
        Intrinsics.checkNotNullParameter(r101, "rawUri");
    }

    @Override // b9.b
    public final void init() {
    }

    @Override // b9.b
    public final HybridDialog o1(Context r100, Uri r101, b7.b r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rawUri");
        return null;
    }

    @Override // b9.b
    public final boolean p1(Context r100, Uri r101, c r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rawUri");
        return false;
    }
}
