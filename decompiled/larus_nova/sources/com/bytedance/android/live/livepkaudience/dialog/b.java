package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b extends b0<BasePkAudienceInviteListContract$View> {
    public abstract void d(boolean r100, boolean r101);

    public abstract void e(boolean r100);

    public abstract void f();

    public abstract void g(LinkPlayerInfo r100);

    public abstract void h(List r100, BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1.AnonymousClass1.a.C1249a r101);

    public abstract void i(Activity r100);

    public b(BasePkAudienceInviteListContract$View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
