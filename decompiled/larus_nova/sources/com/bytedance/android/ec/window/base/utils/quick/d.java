package com.bytedance.android.ec.window.base.utils.quick;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final void a(QUIManager r100, QUIModule r101, Context r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$initSync");
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 == null) goto L5;
        r100.f450906a = r103;
    L5:
        r100.l(r101, r102, true);
    }
}
