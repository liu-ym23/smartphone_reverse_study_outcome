package com.bytedance.android.gamecp.business.gamedetail;

import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "废弃，不要在代码里通过该方法做场景差异逻辑，通过SceneStrategy实现")
public final class h {
    public static boolean a() {
        DataContext r100 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r100 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r100 = null;
    L5:
        AudienceGamePromoteDetailViewModel r101 = (AudienceGamePromoteDetailViewModel) r100;
        if (r101 != null) goto L8;
    L11:
        return true;
    L8:
        if (r101.getPromoteScene() != 0) goto L11;
        return false;
    }

    static {
    }
}
