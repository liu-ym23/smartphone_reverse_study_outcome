package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k;
import com.bytedance.android.livesdkapi.message.TextPiece;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class RefreshProcessor extends a {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "RefreshProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r100) {
        if (r100 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public RefreshProcessor() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(final t42.a r100, com.bytedance.android.live.base.model.liteinteraction.a r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r102, "cd");
        final t42.b r103 = r100.f544565a;
        if (r103 != null) goto L6;
        int r104 = k.f133642a;
        Intrinsics.checkNotNullParameter("RefreshProcessor, messageData is null", "msg");
        ALogger.e("LiteInteractionHelper", "RefreshProcessor, messageData is null");
        return;
    L6:
        final TextPiece r105 = r101.b();
        if (r105 != null) goto L10;
        int r106 = k.f133642a;
        Intrinsics.checkNotNullParameter("RefreshProcessor, piece is null", "msg");
        ALogger.e("LiteInteractionHelper", "RefreshProcessor, piece is null");
        return;
    L10:
        int r107 = k.f133642a;
        k.a("processAfterClickText, piece is " + r105);
        b r108 = this.f139196a;
        if (r108 == null) goto L14;
        r108.c(new RefreshProcessor$process$1(r103), new RefreshProcessor$process$2(r103, r100, r105));
        return;
    }
}
