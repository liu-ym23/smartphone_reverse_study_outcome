package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowHeaderBubbleItemPresenter f188135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uq3.e f188136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f188137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f188138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0 f188139e;

    public j(WindowHeaderBubbleItemPresenter r100, uq3.e r101, View r102, int r103, Function0 r104) {
        this.f188135a = r100;
        this.f188136b = r101;
        this.f188137c = r102;
        this.f188138d = r103;
        this.f188139e = r104;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        WindowHeaderBubbleItemPresenter r102 = this.f188135a;
        if (r102.f188070l != null) goto L23;
        String r103 = this.f188136b.f551224g;
        if (r103 == null) goto L24;
        View r104 = this.f188137c;
        int r105 = this.f188138d;
        if (r105 != 1) goto L11;
        List r106 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.o());
    L18:
        r102.f188070l = new com.bytedance.android.ec.window.base.common.bubble.r(r104, r103, null, r106, new i(this), MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN);
        com.bytedance.android.ec.window.base.common.bubble.r r107 = this.f188135a.f188070l;
        if (r107 == null) goto L21;
        r107.b();
    L21:
        SharedPrefHelper r108 = (SharedPrefHelper) this.f188135a.f188068j.getValue();
        r108.l("sp_key_guide_bubble_show", Boolean.TRUE);
        r108.a();
        return;
    L11:
        if (r105 != 2) goto L13;
        r106 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.a());
        goto L18
    L13:
        if (r105 == 3) goto L15;
        r106 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.a());
        goto L18
    L15:
        r106 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.p());
        goto L18
    L24:
        return;
    }
}
