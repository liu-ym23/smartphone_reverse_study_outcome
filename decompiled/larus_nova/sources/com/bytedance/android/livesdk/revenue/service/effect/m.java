package com.bytedance.android.livesdk.revenue.service.effect;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.k3;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements IFetchEffectListListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f157308a;

    public m(k3 r100) {
        this.f157308a = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener
    public final void onFail(ExceptionResult r100) {
        d r101 = this.f157308a;
        if (r100 == null) goto L5;
        r100.getMsg();
    L5:
        r101.onFail();
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(List<Effect> r100) {
        List<Effect> r101 = r100;
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L8;
        Iterator<Effect> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(new i(r103.next()));
    L8:
        this.f157308a.onSuccess(r102);
    }
}
