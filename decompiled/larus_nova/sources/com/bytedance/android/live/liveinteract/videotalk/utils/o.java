package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f79815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f79817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f79818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f79819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRoom f79820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f79821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LifecycleOwner f79823i;

    public static final class a implements Observer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f79824a;

        public a(o r100) {
            this.f79824a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Integer r100) {
            Integer r101 = r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != 0) goto L9;
            ALogger.e("ttlive_link", "close video interact and open video talk");
            this.f79824a.f79818d.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this);
            this.f79824a.c(false);
            return;
        }
    }

    public final void b() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
    L7:
        c(false);
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(2) == false) goto L7;
        this.f79818d.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.f79817c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.bytedance.android.livesdkapi.depend.model.live.Room] */
    /* JADX WARN: Type inference failed for: r0v26, types: [T, com.bytedance.android.livesdkapi.depend.model.live.IRoom] */
    public final void c(boolean r110) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        long r101 = System.currentTimeMillis();
        if (((IRoom) r100.element) != null) goto L10;
        DataCenter r102 = this.f79818d;
        if (r102 == null) goto L8;
        r100.element = (IRoom) r102.get("data_room", null);
    L8:
        if (((IRoom) r100.element) != null) goto L10;
        return;
    L10:
        IService r103 = jc1.k.f(IMultiLinkServiceExternal.class);
        Intrinsics.checkNotNull(r103);
        if (((IMultiLinkServiceExternal) r103).getMultiDataHolderExternal().getChannelId() == 0) goto L15;
        f2.b(R.string.ttlive_interact_audience_pk_reject, 0);
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L15:
        if (this.f79816b == false) goto L17;
        return;
    L17:
        this.f79816b = true;
        int r104 = com.bytedance.android.live.liveinteract.plantform.utils.f.f77476a;
        com.bytedance.android.live.liveinteract.plantform.utils.f.a((LiveMode) this.f79818d.get("data_live_mode", LiveMode.UNDEFINED));
        int r105 = this.f79821g;
        wf0.b.i(r105);
        Single<com.bytedance.android.live.network.response.e<j0>> r106 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(((IRoom) r100.element).getId(), 4, 16, false, r105, "8,12", 0, this.f79822h, 2);
        IService r107 = jc1.k.f(IInteractService.class);
        Intrinsics.checkNotNull(r107);
        ((IInteractService) r107).setDynamicFromAudience(false);
        TalkRoomBusinessFullLinkMonitor r108 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r109 = this.f79822h;
        r108.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("click_bottom_bar_icon", r105, r109);
        InteractLinkFullLinkMonitor.i("8,12", r105, "click_bottom_bar_icon");
        r106.compose(RxUtil.rxSchedulerHelper()).subscribe(new r(this, r101, r105, r100), new s(this, r110, r101));
    }

    public static void a(LinkDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "LinkDialog", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "LinkDialog");
    }

    public o(DataCenter r100, Context r101, IRoom r102, int r103, int r104, LifecycleOwner r105) {
        Intrinsics.checkNotNullParameter(r100, "mDataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "mRoom");
        Intrinsics.checkNotNullParameter(r105, "lifecycleOwner");
        this.f79818d = r100;
        this.f79819e = r101;
        this.f79820f = r102;
        this.f79821g = r103;
        this.f79822h = r104;
        this.f79823i = r105;
        this.f79817c = new a(this);
    }
}
