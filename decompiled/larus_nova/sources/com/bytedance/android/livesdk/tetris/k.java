package com.bytedance.android.livesdk.tetris;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerLayout;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends s22.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenTetrominoV2 f158594a;

    public k(PublicScreenTetrominoV2 r100) {
        this.f158594a = r100;
    }

    @Override // s22.e.a
    public final void b(long r100) {
        PublicScreenTetrominoV2 r101 = this.f158594a;
        PublicScreenAreaPageType r102 = PublicScreenAreaPageType.ChatChannel;
        int r103 = PublicScreenTetrominoV2.f158534p0;
        r101.getClass();
        RoomContext r104 = r101.f158538p;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataContext");
    L5:
        s22.e r105 = ChatChannelUtils.b(r104);
        if (r105 == null) goto L10;
        List<s22.a> r106 = r105.getAllChannel();
        if (r106 == null) goto L10;
        int r107 = r106.size();
    L11:
        if (r107 > 0) goto L18;
        PublicScreenAreaPagerLayout r108 = r101.f158544v;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("publicScreenAreaPager");
    L15:
        r108.j(r102);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r109 = r101.b0();
        if (r109 == null) goto L18;
        r109.resetPage(PublicScreenAreaPageChangeSource.PageInvalid);
    L18:
        this.f158594a.g0("ChatChannelRemoved");
        return;
    L10:
        r107 = 0;
        goto L11
    }

    @Override // s22.e.a
    public final void a(s22.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "chatChannel");
        PublicScreenTetrominoV2 r102 = this.f158594a;
        PublicScreenAreaPageType r103 = PublicScreenAreaPageType.ChatChannel;
        long r104 = r100.getChannelId();
        int r105 = PublicScreenTetrominoV2.f158534p0;
        r102.getClass();
        PublicScreenAreaPagerLayout r106 = r102.f158544v;
        if (r106 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("publicScreenAreaPager");
    L6:
        if (r106.i(r103) == false) goto L11;
        if (r101 == false) goto L19;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r107 = r102.b0();
        if (r107 == null) goto L19;
        r107.tryChangePage(r103, r104, PublicScreenAreaPageChangeSource.ChannelCreate);
    L19:
        this.f158594a.g0("ChatChannelAdded");
        return;
    L11:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.d r108 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.d) ((LinkedHashMap) r102.O).get(r103);
        if (r108 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c r109 = r108.a(r103, r104);
        if (r109 == null) goto L19;
        PublicScreenAreaPagerLayout r110 = r102.f158544v;
        if (r110 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("publicScreenAreaPager");
    L18:
        r110.h(r109);
        int r111 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.f133002a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_live_message_tab_entrance_show", MapsKt.emptyMap());
        goto L19
    }
}
