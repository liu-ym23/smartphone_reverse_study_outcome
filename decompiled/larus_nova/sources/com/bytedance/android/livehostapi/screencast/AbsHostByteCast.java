package com.bytedance.android.livehostapi.screencast;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend;
import com.bytedance.android.livehostapi.hostdefault.HostLiveByteCastDefault;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livehostapi/screencast/AbsHostByteCast;", "Lcom/bytedance/android/livehostapi/hostdefault/HostLiveByteCastDefault;", "()V", "enableCastPreSearch", "", "isValid", "liveClarityStrategy", "", "startCast", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "depend", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend;", "isLandscape", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsHostByteCast extends HostLiveByteCastDefault {
    @Override // com.bytedance.android.livehostapi.hostdefault.HostLiveByteCastDefault, com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean enableCastPreSearch() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostLiveByteCastDefault, com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean isValid() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostLiveByteCastDefault, com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public String liveClarityStrategy() {
        return "";
    }

    public AbsHostByteCast() {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostLiveByteCastDefault, com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public int startCast(Context r100, ILiveCastSourceUIDepend r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (v.a() == false) goto L5;
        f2.c("调用到了投屏空实现！如已实现请勿call super。", 0);
    L5:
        return 0;
    }
}
