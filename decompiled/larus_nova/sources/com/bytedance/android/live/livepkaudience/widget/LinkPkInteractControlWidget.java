package com.bytedance.android.live.livepkaudience.widget;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget;
import com.bytedance.android.live.livepkaudience.base.w;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.dialog.RevLinkDialog;
import com.bytedance.android.live.livepkaudience.rtc.GuestRtcLinkerWidget;
import com.bytedance.android.live.livepkaudience.service.PkAudienceInternalServiceContext;
import com.bytedance.android.live.livepkaudience.window.LinkPkInteractAudienceWindowManagerV2;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/widget/LinkPkInteractControlWidget;", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/livepkaudience/service/e;", "Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAnchorWidget$a;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractControlWidget extends BasePkInteractControlWidget implements Observer<KVData>, com.bytedance.android.live.livepkaudience.service.e, BasePkInteractAnchorWidget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f82421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkPkInteractAudienceAnchorWidget f82422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkPkInteractAudienceGuestWidget f82423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GuestRtcLinkerWidget f82424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f82425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RevLinkDialog f82426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f82427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Room f82428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f82429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f82430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinkPkInteractGuestDataContext f82431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v0 f82432l;

    @Override // com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget, kf1.a
    public final String tag() {
        return "LinkPkInteractControlWidget";
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final String Wc() {
        LinkPkInteractGuestDataContext r100 = this.f82431k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r100.kickedUsersUniqueId();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final boolean getSelfHasAudienceBeforePk() {
        LinkPkInteractGuestDataContext r100 = this.f82431k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r100.getSelfHasAudienceBeforePk();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final boolean handleInteractClick() {
        if (v.a(((Integer) this.dataCenter.get("data_link_state", 0)).intValue(), 4) == false) goto L50;
        RevPkState r100 = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getPkServiceExternal().d();
        if (this.f82427g == false) goto L30;
        if (r100 != null) goto L8;
    L62:
        return false;
    L8:
        if (r100 == RevPkState.DISABLE) goto L62;
        if (us1.b.a() == true) goto L12;
        f2.c(us1.b.b(), 0);
        goto L62
    L12:
        if (v.a(((IInteractService) k.n(IInteractService.class)).getLinkMode(), 32) == false) goto L14;
        DataCenter r101 = this.dataCenter;
        int r102 = RevLinkDialog.f81774u;
        RevLinkDialog r103 = new RevLinkDialog.a(r101, this).a("link_click", -1, null, false);
        this.f82426f = r103;
        Context r104 = this.context;
        if (r104 == null) goto L28;
        FragmentManager r105 = ((FragmentActivity) r104).getSupportFragmentManager();
        LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "RevLinkDialog", r106);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r103, r106) == false) goto L64;
    L26:
        this.dataCenter.put("data_link_pk_interact_show_red_dot", Boolean.TRUE);
        goto L62
    L64:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L25:
        r103.show(r105, "RevLinkDialog");
        goto L26
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L14:
        if (((IInteractService) k.n(IInteractService.class)).getInteractAudienceService() == null) goto L26;
        if (dl0.k.a() == true) goto L18;
        ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) k.n(IInteractService.class)).getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.plantform.base.f.a().K7(PbRequest.SwitchType.PK);
        goto L26
    L18:
        f2.c(s1.B(R.string.ttlive_break_through_interact_reject_link), 0);
        goto L26
    L30:
        IUserService r107 = (IUserService) k.f(IUserService.class);
        if (r107 == null) goto L46;
        com.bytedance.android.livesdk.user.f r108 = r107.user();
        if (r108 == null) goto L46;
        if (r108.c() != true) goto L46;
        IInteractService r109 = (IInteractService) k.f(IInteractService.class);
        if (r109 == null) goto L39;
        int r110 = r109.getLinkMode();
    L41:
        if (v.a(r110, 2) == false) goto L43;
        f2.c(s1.B(R.string.ttlive_can_not_link_for_anchor_low_version), 0);
        goto L62
    L43:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r111 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r111 == null) goto L62;
        r111.v0(0, "bottom", -1, "");
        goto L62
    L39:
        r110 = 0;
    L46:
        LinkPkInteractAudienceGuestWidget r112 = this.f82423c;
        if (r112 == null) goto L62;
        r112.Yq(false);
        goto L62
    L50:
        if (v.a(((IInteractService) k.n(IInteractService.class)).getLinkMode(), 2) == false) goto L62;
        if (this.f82427g == true) goto L62;
        IUserService r113 = (IUserService) k.f(IUserService.class);
        if (r113 == null) goto L62;
        com.bytedance.android.livesdk.user.f r114 = r113.user();
        if (r114 == null) goto L62;
        if (r114.c() == true) goto L62;
        LinkPkInteractAudienceGuestWidget r115 = this.f82423c;
        if (r115 == null) goto L62;
        r115.Yq(true);
        goto L62
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void hideInteractDialog() {
        if (this.f82427g == false) goto L14;
        LinkPkInteractAudienceAnchorWidget r100 = this.f82422b;
        if (r100 == null) goto L14;
        RevLinkDialog r101 = r100.f82372p;
        if (r101 == null) goto L14;
        r101.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L14;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        RevLinkDialog r103 = this.f82426f;
        if (r103 == null) goto L27;
        r103.dismiss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L28;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final com.bytedance.android.live.livepkaudience.service.g ml() {
        LinkPkInteractGuestDataContext r100 = this.f82431k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r100.getPkInteractAudienceParams();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void tryLoadPkAudienceWidget() {
        if (this.f82427g == false) goto L5;
        this.f82430j = R.id.pk_cantainer;
    L6:
        int r100 = this.f82430j;
        enableSubWidgetManager();
        if (this.f82427g == false) goto L17;
        if (this.f82422b != null) goto L23;
        v0 r101 = this.f82432l;
        if (r101 == null) goto L24;
        LinkPkInteractGuestDataContext r102 = this.f82431k;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L15:
        LinkPkInteractAudienceAnchorWidget r103 = new LinkPkInteractAudienceAnchorWidget(r101, r102, this);
        this.f82422b = r103;
        this.subWidgetManager.load(r100, r103);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        if (this.f82423c != null) goto L26;
        LinkPkInteractGuestDataContext r104 = this.f82431k;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L21:
        LinkPkInteractAudienceGuestWidget r105 = new LinkPkInteractAudienceGuestWidget(r104, this);
        this.f82423c = r105;
        this.subWidgetManager.load(r100, r105);
        return;
    L26:
        return;
    L5:
        this.f82430j = this.f82429i;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void tryUnLoadPkAudienceWidget() {
        int r100 = x8.a.f562881a;
        x8.a.b(this.f82421a, "tryUnLoadPkAudienceWidget", false);
        if (this.f82427g == false) goto L7;
        LinkPkInteractAudienceAnchorWidget r101 = this.f82422b;
        if (r101 == null) goto L10;
        this.subWidgetManager.unload(r101);
    L10:
        this.f82422b = null;
        this.f82423c = null;
        return;
    L7:
        LinkPkInteractAudienceGuestWidget r102 = this.f82423c;
        if (r102 == null) goto L10;
        this.subWidgetManager.unload(r102);
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        RoomContext.a r100 = RoomContext.Companion;
        Room r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r103 = r102.isAnchor();
        if (r103 == null) goto L9;
        Boolean r104 = r103.getValue();
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L10:
        this.f82427g = r105;
        RoomContext r106 = RoomContext.a.c(r100, null, 0, 3);
        if (r106 == null) goto L15;
        m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L15;
        r101 = r107.getValue();
    L15:
        this.f82428h = r101;
        this.dataCenter.observe("cmd_interact_audience_invite", this).observe("cmd_video_talk_invite", this);
        enableSubWidgetManager();
        if (this.f82427g == true) goto L18;
        GuestRtcLinkerWidget r108 = new GuestRtcLinkerWidget();
        this.f82424d = r108;
        this.subWidgetManager.load(r108);
    L18:
        Pair r109 = com.bytedance.live.datacontext.d.a(new LinkPkInteractControlWidget$onCreate$dataPair$1(this));
        this.f82431k = (LinkPkInteractGuestDataContext) r109.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r109.getFirst(), "linkpk_interact_guest_data_service");
        this.f82425e.add((Disposable) r109.getSecond());
        Pair r110 = com.bytedance.live.datacontext.d.a(LinkPkInteractControlWidget$onCreate$pair$1.INSTANCE);
        PkAudienceInternalServiceContext r111 = (PkAudienceInternalServiceContext) r110.getFirst();
        r111.getService().d(this);
        com.bytedance.live.datacontext.b.a(r111, PkAudienceInternalServiceContext.TAG);
        this.f82425e.add((Disposable) r110.getSecond());
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L22;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), com.bytedance.android.live.pkaudience.api.c.class, this);
        return;
    L22:
        return;
    L9:
        r105 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), com.bytedance.android.live.pkaudience.api.c.class);
    L5:
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L8;
        r100.removeObserver(this);
    L8:
        LinkPkInteractGuestDataContext r101 = this.f82431k;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L11:
        r101.resetLinkData();
        this.f82425e.clear();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r111 = (KVData) r110;
        if (isViewValid() == false) goto L40;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.getData() == null) goto L49;
        String r100 = r111.getKey();
        int r101 = r100.hashCode();
        if (r101 == (-793150208)) goto L17;
        if (r101 == 1361477747) goto L14;
        return;
    L14:
        if (r100.equals("cmd_video_talk_invite") == false) goto L42;
    L18:
        User r112 = (User) r111.getData();
        if (r112 == null) goto L51;
        long r102 = 0;
        if (this.f82427g == false) goto L30;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r103 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r103 == null) goto L44;
        int r104 = x8.a.f562881a;
        x8.a.b(this.f82421a, "pk anchor invite audience", false);
        Room r105 = this.f82428h;
        if (r105 == null) goto L28;
        r102 = r105.f162599id;
    L28:
        r103.invite(r102, "0", r112.getCastSecUid(), 1, 0);
        return;
    L44:
        return;
    L30:
        if (((IUserService) k.n(IUserService.class)).user().c() == false) goto L46;
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.a.C1255a.a() == null) goto L47;
        int r106 = x8.a.f562881a;
        x8.a.b(this.f82421a, "pk anchor invite audience", false);
        com.bytedance.android.live.livepkaudience.service.a r107 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r107 == null) goto L48;
        Room r108 = this.f82428h;
        if (r108 == null) goto L38;
        r102 = r108.f162599id;
    L38:
        r107.t2(r102, "0", r112.getCastSecUid());
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L51:
        return;
    L42:
        return;
    L17:
        if (r100.equals("cmd_interact_audience_invite") == true) goto L18;
        return;
    L49:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.ILinkControlWidget, com.bytedance.android.live.pkaudience.api.c
    public final void onSei(String r100) {
        LinkPkInteractAudienceGuestWidget r101 = this.f82423c;
        if (r101 == null) goto L40;
        if (r100 == null) goto L41;
        Intrinsics.checkNotNullParameter(r100, "sei");
        LinkPkInteractAudienceWindowManagerV2 r102 = r101.f82397t;
        if (r102 == null) goto L42;
        Intrinsics.checkNotNullParameter(r100, "sei");
        if (r102.f82496s == true) goto L10;
        return;
    L10:
        if (r102.f82493p == false) goto L44;
        w r103 = r102.f82492o;
        if (r103 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return;
    L16:
        if (r100.contains("app_data") == false) goto L51;
        LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L37
        JSONObject r104 = LiveSeiUtil.c(r100);     // Catch: JSONException -> L37
        if (r104.has("info") == false) goto L26;
        if (r104.has("source") == false) goto L26;
        if (TextUtils.equals(r104.optString("source"), "zego") == false) goto L26;
        r104 = (JSONObject) r104.get("info");     // Catch: JSONException -> L37
    L26:
        if (r104.has("app_data") == false) goto L47;
        JSONObject r105 = new JSONObject(JSONObjectProtectorUtils.getString(r104, "app_data").replaceAll("\\\\", ""));     // Catch: JSONException -> L37
        long r106 = r105.optLong("timestamp");     // Catch: JSONException -> L37
        if (r106 > r103.f81573a) goto L31;
        return;
    L31:
        if (r105.has("ver") == false) goto L49;
        int r107 = r105.optInt("ver");     // Catch: JSONException -> L37
        if (r103.f81574b.c(r107) == false) goto L50;
        r103.f81573a = r106;     // Catch: JSONException -> L37
        SeiAppData r108 = w.a(r105);     // Catch: JSONException -> L37
        r103.f81574b.onSeiUpdated(r108);     // Catch: JSONException -> L37
        return;
    L50:
        return;
    L49:
        return;
    L47:
        return;
    L52:
        return;
    L51:
        return;
    L44:
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget
    public final void p3(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Room r101 = (Room) jm2.a.e(r100);
        if (r101 == null) goto L10;
        GuestRtcLinkerWidget r102 = this.f82424d;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "room");
        r102.f82173b = r101;
        com.bytedance.android.live.livepkaudience.rtc.a r103 = r102.f82172a;
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f82199w = r101;
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void unLoadOtherWidget(int r100) {
        if (r100 != 2) goto L8;
        LinkPkInteractAudienceGuestWidget r101 = this.f82423c;
        if (r101 == null) goto L13;
        r101.F3("live_end");
        return;
    L13:
        return;
    L8:
        if (r100 != 32) goto L15;
        LinkPkInteractAudienceGuestWidget r102 = this.f82423c;
        if (r102 == null) goto L16;
        r102.F3("live_end");
        return;
    L16:
        return;
    }

    public LinkPkInteractControlWidget(v0 r100, int r101) {
        this.f82432l = r100;
        this.f82421a = "LinkPkInteractControlWidget";
        this.f82425e = new CompositeDisposable();
        this.f82429i = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kf1.a
    public final boolean qa(Runnable r100, boolean r101) {
        LinkPkInteractAudienceGuestWidget r102 = this.f82423c;
        Integer r103 = null;
        if (r102 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Integer r104 = (Integer) hd0.c.f().f481009b;
        if (r104 != null) goto L8;
    L17:
        Integer r105 = (Integer) hd0.c.f().f481009b;
        if (r105 == null) goto L23;
        if (1 != r105.intValue()) goto L23;
        r102.f81392f = true;
        goto L23
    L8:
        if (2 != r104.intValue()) goto L17;
        DataCenter r106 = r102.dataCenter;
        if (r106 == null) goto L12;
        Boolean r107 = (Boolean) r106.get("cmd_mic_room_jump", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L16;
        r102.f81392f = true;
        goto L23
    L16:
        x0.b r108 = new x0.b(r102.getContext(), 4);
        r108.l(R.string.ttlive_live_interact_player_exit_room_confirm);
        r108.i(0, R.string.ttlive_ok, new d(r102, r100));
        r108.i(1, R.string.ttlive_cancel, e.f82437a);
        r108.n();
        boolean r109 = true;
    L24:
        DataCenter r110 = this.dataCenter;
        if (r110 == null) goto L28;
        r103 = (Integer) r110.get("data_link_state", 0);
    L28:
        if (this.f82427g == true) goto L46;
        if (r109 == true) goto L46;
        Integer r111 = (Integer) hd0.c.f().f481009b;
        if (r111 == null) goto L46;
        if (r111.intValue() != 1) goto L46;
        if (this.f82428h == null) goto L46;
        if (r103 != null) goto L40;
    L41:
        LinkApi r112 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r113 = this.f82428h;
        if (r113 == null) goto L44;
        long r114 = r113.f162599id;
    L45:
        ((SingleSubscribeProxy) r112.leave(r114, "live_end").as(autoDisposeWithTransformer())).subscribe(i.f82445a, new j(this));
        goto L46
    L44:
        r114 = 0;
        goto L45
    L40:
        if (r103.intValue() != 0) goto L41;
    L46:
        return r109;
    L12:
        r107 = null;
    L23:
        r109 = false;
        goto L24
    }
}
