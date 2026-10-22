package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.business.IHostSocial;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/livepkaudience/dialog/BasePkAudienceInviteListFragment$onViewCreated$2$1"}, k = 3, mv = {1, 4, 3})
public final class BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ BasePkAudienceInviteListFragment this$0;

    public BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1(BasePkAudienceInviteListFragment r100, View r101) {
        this.this$0 = r100;
        this.$view$inlined = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = al0.d.f4121a;
        Pair[] r101 = new Pair[3];
        if (this.this$0.da0() == false) goto L5;
        String r102 = "voice_live";
    L6:
        r101[0] = TuplesKt.to("live_type", r102);
        r101[1] = al0.d.a();
        r101[2] = TuplesKt.to("request_page", "invite");
        Map r103 = MapsKt.mutableMapOf(r101);
        el0.j.k(r103);
        el0.j.n(r103, Integer.valueOf(dl0.n.a()));
        Unit r104 = Unit.INSTANCE;
        al0.d.g("anchor_invite_user_button_click", r103, new Object[0]);
        ((IRoomService) jc1.k.n(IRoomService.class)).setOnNeedMuteAudioFullPage(true);
        ((IHostSocial) jc1.k.n(IHostSocial.class)).showInviteFriendActivity(this.$view$inlined.getContext(), new AnonymousClass1(this));
        return;
    L5:
        r102 = "video_live";
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
