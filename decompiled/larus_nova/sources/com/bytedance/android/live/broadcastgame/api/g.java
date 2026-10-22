package com.bytedance.android.live.broadcastgame.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59289a = 0;

    static {
    }

    public static FragmentActivity a(Context r100) {
        IAudienceGameDataService r101 = (IAudienceGameDataService) k.f(IAudienceGameDataService.class);
        if (r101 == null) goto L14;
        if (r101.isGameFullPanelShowing() != true) goto L14;
        Activity r102 = ((IMiddlewareHostApp) k.n(IMiddlewareHostApp.class)).getTopActivity();
        if ((r102 instanceof FragmentActivity) == true) goto L9;
        r102 = null;
    L9:
        FragmentActivity r103 = (FragmentActivity) r102;
        if (r103 == null) goto L12;
        return r103;
    L12:
        return ContextUtil.contextToFragmentActivity(r100);
    L14:
        return ContextUtil.contextToFragmentActivity(r100);
    }
}
