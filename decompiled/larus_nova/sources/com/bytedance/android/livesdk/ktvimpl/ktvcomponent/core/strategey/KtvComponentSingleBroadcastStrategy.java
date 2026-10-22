package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.c2;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rj0.m;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvComponentSingleBroadcastStrategy implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f144057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f144058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f144059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f144060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f144061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a f144062f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy f144063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h80.a f144064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f144065c;

        public b(KtvComponentSingleBroadcastStrategy r100, h80.a r101, long r102) {
            this.f144063a = r100;
            this.f144064b = r101;
            this.f144065c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_cancel_prepare_apply, success, " + r101.logId);
            h80.a r102 = this.f144064b;
            if (r102 == null) goto L5;
            r102.accept(Boolean.TRUE);
        L5:
            this.f144063a.f144058b = false;
            mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiCancelAddSongPrepareApply, System.currentTimeMillis() - this.f144065c, r101.logId);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy f144066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h80.a f144067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f144068c;

        public c(KtvComponentSingleBroadcastStrategy r100, h80.a r101, long r102) {
            this.f144066a = r100;
            this.f144067b = r101;
            this.f144068c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_cancel_prepare_apply, failure, logId=" + ke2.a.c(r101));
            ExceptionUtils.handleException(this.f144066a.f144062f.getContext(), r101);
            h80.a r102 = this.f144067b;
            if (r102 == null) goto L5;
            r102.accept(Boolean.FALSE);
        L5:
            mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.ApiCancelAddSongPrepareApply, System.currentTimeMillis() - this.f144068c, r101);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentSingleBroadcastStrategy f144069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f144070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f144071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h80.a f144072d;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f144073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f144074b;

            public a(d r100, long r101) {
                this.f144073a = r100;
                this.f144074b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
                ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply_permit, success, " + r101.logId);
                d r102 = this.f144073a;
                KtvComponentSingleBroadcastStrategy r103 = r102.f144069a;
                r102.f144071c.getIdString();
                DataCenter r104 = r103.f144062f.getDataCenter();
                if (r104 == null) goto L5;
                r104.put("cmd_ktv_component_init_link", new c2(8, 6));
            L5:
                f2.b(R.string.ttlive_ktv_component_anchor_permit_link_not_open, 0);
                this.f144073a.f144072d.accept(Boolean.TRUE);
                mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiAddSongPrepareApplyPermit, System.currentTimeMillis() - this.f144074b, r101.logId);
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f144075a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f144076b;

            public b(d r100, long r101) {
                this.f144075a = r100;
                this.f144076b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply_permit, failure, logId=" + ke2.a.c(r101));
                ExceptionUtils.handleException(this.f144075a.f144069a.f144062f.getContext(), r101);
                mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.ApiAddSongPrepareApplyPermit, System.currentTimeMillis() - this.f144076b, r101);
            }
        }

        public d(KtvComponentSingleBroadcastStrategy r100, long r101, IBaseUser r102, h80.a r103) {
            this.f144069a = r100;
            this.f144070b = r101;
            this.f144071c = r102;
            this.f144072d = r103;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            int r102 = ke2.b.f503019a;
            ke2.b.a("accept");
            long r103 = System.currentTimeMillis();
            KtvComponentApi r104 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
            if (r104 == null) goto L12;
            Observable<com.bytedance.android.live.network.response.e<Object>> r105 = r104.addSongPrepareApplyPermit(this.f144070b, d5.c(this.f144071c.getIdString()), this.f144071c.getIdString());
            if (r105 == null) goto L13;
            Observable<R> r106 = r105.compose(RxUtil.rxSchedulerHelper());
            if (r106 == 0) goto L14;
            Disposable r107 = r106.subscribe(new a(this, r103), new b(this, r103));
            if (r107 == null) goto L15;
            RxUtilKt.c(r107, this.f144069a.f144057a);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f144077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h80.a f144078b;

        public e(IBaseUser r100, h80.a r101) {
            this.f144077a = r100;
            this.f144078b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            this.f144078b.accept(Boolean.FALSE);
            int r102 = ke2.b.f503019a;
            ke2.b.a("cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void release() {
        this.f144057a.dispose();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return com.bytedance.android.livesdk.ktvimpl.base.util.e.a.a();
    }

    public KtvComponentSingleBroadcastStrategy(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ktvUIStrategy");
        this.f144062f = r100;
        this.f144057a = new CompositeDisposable();
        this.f144060d = LazyKt.lazy(new KtvComponentSingleBroadcastStrategy$kSongSettingKeyObserver$2(this));
        this.f144061e = LazyKt.lazy(new KtvComponentSingleBroadcastStrategy$linkPlayerStateObserver$2(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r100) {
        long r101 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        long r102 = System.currentTimeMillis();
        RxUtilKt.c(((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).cancelAddSongPrepareApply(r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r100, r102), new c(this, r100, r102)), this.f144057a);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void Fh(IBaseUser r100, h80.a<Boolean> r110) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r110, "consumer");
        long r101 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        FragmentActivity r102 = ContextUtil.contextToFragmentActivity(this.f144062f.getContext());
        if (r102 == null) goto L6;
        c9.a r103 = new c9.a(r102);
        r103.d(R.string.ttlive_ktv_component_anchor_permit_dialog_title);
        r103.a(R.string.ttlive_ktv_component_anchor_permit_dialog_content);
        r103.c(R.string.ttlive_confirm, new d(this, r101, r100, r110));
        r103.b(R.string.ttlive_cancel, new e(r100, r110));
        r103.e();
        int r104 = ke2.b.f503019a;
        LinkedHashMap r105 = new LinkedHashMap();
        ke2.b.j(r105);
        ke2.b.m(r105);
        ke2.b.l(r105);
        ke2.b.k(r105);
        j0.l().sendLog("livesdk_anchor_ksong_popup_show", r105, new Object[]{IRoom.class});
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r100, rj0.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a.C2249a.a((BaseOrderSongViewModel.e) r101);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r100, IRoom r101, rj0.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "listener");
        r102.onSuccess();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r100, String r101, LinkApplyType r102, tf0.b r110) {
        Intrinsics.checkNotNullParameter(r102, "applyType");
        boolean r103 = false;
        Object r104 = null;
        if (this.f144059c == true) goto L9;
        this.f144059c = true;
        KtvComponentOrderedSongDataContext r111 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r111 == null) goto L9;
        Disposable r112 = r111.observerKtvSongUniqueInfoListChange(null, false, new f(this));
        if (r112 == null) goto L9;
        RxUtilKt.c(r112, this.f144057a);
    L9:
        String r113 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
        KtvComponentOrderedSongDataContext r105 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r105 == null) goto L20;
        List<SongUniqueInfo> r106 = r105.getKtvPrivateSongUniqueInfoList();
        if (r106 == null) goto L20;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L19;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r108).getUserId(), r113) == false) goto L15;
        r104 = r108;
    L19:
        r104 = (SongUniqueInfo) r104;
    L20:
        if (r104 == null) goto L22;
        r103 = true;
    L22:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: ktvApply, isInSelfSeeSelectedMusicList=" + r103 + " ;; isApplying = " + this.f144058b);
        if (r103 == false) goto L25;
        return;
    L25:
        if (this.f144058b == false) goto L28;
        return;
    L28:
        if (r102 != LinkApplyType.KTV_MULTI_CHORUS) goto L30;
        String r114 = "live_chorus";
    L31:
        int r109 = ke2.b.f503019a;
        ke2.b.i(r114);
        IInteractService r115 = (IInteractService) k.f(IInteractService.class);
        if (r115 == null) goto L38;
        m r116 = r115.getVideoTalkService();
        if (r116 == null) goto L38;
        if (r101 != null) goto L37;
        r101 = "推荐";
    L37:
        r116.x(r101, r102);
    L38:
        Context r117 = this.f144062f.getContext();
        if (r117 == null) goto L46;
        OperateType r118 = OperateType.PRE_APPLY;
        ArrayList r119 = new ArrayList();
        r119.add(qh0.g.a(r118, 2));
        r119.add(new qh0.f.g(r117, r118, 2));
        r119.add(new qh0.f.c(r117, r118, 2));
        r119.add(new qh0.f.a(r117));
        r119.add(new qh0.f.d(r117, r118, 2, true));
        r119.add(new qh0.f.C7326f(r117, r118, 2, true));
        r119.add(new qh0.f.e(r117, r118));
        qh0.f.a(r119).a(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.e(this, r100));
        return;
    L46:
        return;
    L30:
        r114 = "live_song";
        goto L31
    }
}
