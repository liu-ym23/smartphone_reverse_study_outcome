package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"openHandle", "", "url", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 $reportClick$1;

    public LiveMgMountContextService$showStarAtlasAgreementDialog$2(LiveMgMountContextService$showStarAtlasAgreementDialog$1 r100) {
        this.$reportClick$1 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Activity r101 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r101, r100);
        this.$reportClick$1.invoke2("knowmore");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
