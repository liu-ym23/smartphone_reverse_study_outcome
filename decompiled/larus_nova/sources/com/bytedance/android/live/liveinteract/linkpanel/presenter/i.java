package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRoom f75011d;

    public i(IRoom r100, BaseTalkInviteListContract$View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100, r101);
        this.f75011d = r100;
    }
}
