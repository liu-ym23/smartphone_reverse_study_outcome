package com.bytedance.android.gamecp.business.gamedetail.page.comment;

import com.bytedance.android.gamecp.business.gamedetail.base.track.GameDetailTrackV2;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameCommentTabWidget f55345a;

    public d(GameCommentTabWidget r100) {
        this.f55345a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        if (Intrinsics.areEqual(this.f55345a.f55334n, "tab_comment") == true) goto L5;
    L7:
        this.f55345a.f55334n = r101;
        return;
    L5:
        if ((!Intrinsics.areEqual(r101, this.f55345a.f55334n)) == false) goto L7;
        AudienceGamePromoteDetailViewModel r102 = GameDetailTrackV2.f53492a;
        long r103 = System.currentTimeMillis();
        GameCommentTabWidget r104 = this.f55345a;
        GameDetailTrackV2.d(r103 - r104.f55333m, r104.f55336p);
        goto L7
    }
}
