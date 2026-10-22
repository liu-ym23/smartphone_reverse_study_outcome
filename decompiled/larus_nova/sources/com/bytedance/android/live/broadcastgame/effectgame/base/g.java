package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements IFetchEffectListListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f59625a;

    public g(c.b r100) {
        this.f59625a = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener
    public final void onFail(ExceptionResult r100) {
        this.f59625a.onFail(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(List<Effect> r100) {
        List<Effect> r101 = r100;
        List<Effect> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        this.f59625a.onSuccess(CollectionsKt.emptyList());
        return;
    L11:
        com.bytedance.android.live.effect.sticker.d.e(r101).subscribe(new f(this));
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
