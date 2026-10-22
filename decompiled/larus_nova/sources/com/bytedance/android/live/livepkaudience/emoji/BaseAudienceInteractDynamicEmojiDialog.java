package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.EmojiListAdapter;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiPermission;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemAdapter;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.message.model.ue;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/BaseAudienceInteractDynamicEmojiDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/d$a;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAudienceInteractDynamicEmojiDialog extends LinkCommonBottomDialog implements d.a, com.bytedance.android.live.liveinteract.videotalk.emoji.s, com.bytedance.android.live.livepkaudience.emoji.panel.f {
    public static long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f81859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f81861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f81862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkPKAudienceInteractPanelItemAdapter f81863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EmojiListAdapter f81864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f81865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.live.livepkaudience.base.i f81866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x0 f81867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f81868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f81869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f81870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f81871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f81872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f81873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f81874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f81875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f81876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f81877s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f81878t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<com.bytedance.android.live.livepkaudience.emoji.panel.g> f81879u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.live.livepkaudience.emoji.panel.g f81880v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CompositeDisposable f81881w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.live.livepkaudience.emoji.a f81882x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DataCenter f81883y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f81884z;

    public static final class a {
    }

    static {
    }

    public abstract void O0();

    public abstract void P0();

    public abstract boolean Q0();

    public int R0() {
        return 1;
    }

    public abstract void T0();

    public abstract void U0();

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void f() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void g() {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_linkpk_dynamic_emoji;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void h() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void w5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void x5(boolean r100, boolean r101) {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void y5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void z5(int r100, boolean r101) {
    }

    public final void S0() {
        x0 r100 = this.f81867i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L27;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r102 == null) goto L20;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L9:
        if (Looper.myLooper() == r101.getLooper()) goto L11;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        d r100 = this.f81865g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        r100.detachView();
        hd0.c.f().e(this.f81882x);
        this.f81881w.clear();
        ALogger.w("ttlive_link", "self panel dismissed");
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void k() {
        el0.j.g(this.f81878t, dl0.n.d());
        W0(R.string.ttlive_live_radio_interact_unsilence);
        d r100 = this.f81865g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        long r101 = this.f81874p;
        String r102 = dl0.n.d();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "toUserId");
        if (r100.f81936c == true) goto L10;
        r100.f81936c = true;
        Disposable r103 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r101, r102, r102).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r100, r102), new l(r100, r102));
        r100.f81939f.add(r103);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void disconnect() {
        M0(this);
        U0();
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void e() {
        if (Q0() == false) goto L18;
        String r100 = this.f81878t;
        com.bytedance.android.live.livepkaudience.base.i r101 = this.f81866h;
        if (r101 == null) goto L7;
        Integer r102 = Integer.valueOf(c.a(r101));
    L8:
        el0.j.h(r100, r102, dl0.n.d());
        W0(R.string.ttlive_live_radio_interact_silence);
        d r103 = this.f81865g;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L11:
        long r104 = this.f81874p;
        String r105 = dl0.n.d();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r105, "toRevUid");
        if (r105 != null) goto L15;
        r105 = "0";
    L15:
        if (r103.f81935b == true) goto L21;
        r103.f81935b = true;
        Disposable r106 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r104, r105, r105).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r103, r105), new j(r103, r105));
        r103.f81939f.add(r106);
        return;
    L21:
        return;
    L7:
        r102 = null;
        goto L8
    L18:
        f2.b(R.string.ttlive_live_interact_anchor_no_guest_link, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.LinkCommonBottomDialog, com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r100 = this.f81878t;
        int r101 = el0.j.f473003b;
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("user_type", "guest");
        r102.put("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        r102.put("request_page", r100);
        r102.put("interact_type", "self");
        int r103 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.l(r102, r103);
        el0.j.j(r102, Integer.valueOf(r103));
        el0.j.o(r102);
        el0.j.n(r102, Integer.valueOf(r103));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_chat_emoji_panel_show", r102, new Object[]{am2.x.class, Room.class});
        hd0.c.f().c(this.f81882x);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void dismissDialog() {
        M0(this);
    }

    public static void M0(BaseAudienceInteractDynamicEmojiDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void D(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        S0();
        M0(this);
        this.f81872n = true;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void E3(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        ((DouyinLoadingLayout) findViewById(R.id.list_loading_webp_view)).setVisibility(8);
        String r101 = (String) new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r101) == false) goto L5;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r102 = null;
    L6:
        if (r102 == null) goto L8;
        Y0(r102);
    L8:
        EmojiListAdapter r103 = this.f81864f;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L12:
        if (r103.getItemCount() != 0) goto L14;
        V0(true);
    L14:
        com.bytedance.android.live.liveinteract.plantform.utils.x.j(r100, false);
        return;
    L5:
        r102 = ((TalkRoomEmojiListResponse) GsonProtectorUtils.fromJson(GsonHelper.get(), r101, TalkRoomEmojiListResponse.class)).emojiList;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void G(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        S0();
        M0(this);
        this.f81872n = false;
    }

    public final void V0(boolean r100) {
        if (r100 == false) goto L5;
        ((TextView) findViewById(R.id.empty_list_tips)).setVisibility(0);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setVisibility(8);
        ((RtlViewPagerShower) findViewById(R.id.pager_bottom_shower)).setVisibility(8);
        return;
    L5:
        ((TextView) findViewById(R.id.empty_list_tips)).setVisibility(8);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setVisibility(0);
    }

    public final void W0(int r100) {
        if (this.f81867i != null) goto L5;
        Context r101 = getContext();
        x0.d r102 = new x0.d();
        r102.f162243b = r101;
        r102.f162242a = 2;
        r102.f162245d = r101.getText(r100);
        r102.f162252k = false;
        this.f81867i = new x0(r102.f162243b, r102);
    L5:
        x0 r103 = this.f81867i;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isShowing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }

    public final boolean X0(Throwable r100) {
        if ((r100 instanceof ApiServerException) == false) goto L8;
        ApiServerException r101 = (ApiServerException) r100;
        if (TextUtils.isEmpty(r101.getPrompt()) == true) goto L8;
        f2.c(r101.getPrompt(), 0);
        return true;
    L8:
        return false;
    }

    public final void Y0(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r100) {
        EmojiListAdapter r101 = this.f81864f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L5:
        r101.y2(r100);
        int r102 = r100.size() / this.f81870l;
        int r103 = 0;
        if ((r100.size() % this.f81870l) <= 0) goto L8;
        int r104 = 1;
    L9:
        this.f81876r = r102 + r104;
        ((RtlViewPagerShower) findViewById(R.id.pager_bottom_shower)).a(this.f81876r, this.f81877s);
        RtlViewPagerShower r105 = (RtlViewPagerShower) findViewById(R.id.pager_bottom_shower);
        if (this.f81876r != 1) goto L12;
        r103 = 4;
    L12:
        r105.setVisibility(r103);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r100) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r101 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = el0.j.f473003b;
        el0.j.c(this.f81871m, this.f81878t, r101, true);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r110) {
        Intrinsics.checkNotNullParameter(r110, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r111 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r110, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r111 != null) goto L5;
        return;
    L5:
        int r100 = el0.j.f473003b;
        el0.j.b(r111, this.f81871m, true, this.f81878t);
        TalkRoomEmojiPermission r101 = r111.emojiPermission;
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.schemaJumpUrl;
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L16;
        ILiveActionHandler r104 = (ILiveActionHandler) jc1.k.n(ILiveActionHandler.class);
        Context r105 = getContext();
        TalkRoomEmojiPermission r112 = r111.emojiPermission;
        if (r112 == null) goto L14;
        r102 = r112.schemaJumpUrl;
    L14:
        r104.handle(r105, r102);
        M0(this);
        return;
    L16:
        TalkRoomEmojiPermission r106 = r111.emojiPermission;
        if (r106 != null) goto L19;
    L24:
        d r107 = this.f81865g;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L27:
        long r108 = this.f81874p;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r111, "emoji");
        if (r107.f81937d == false) goto L30;
    L33:
        A = System.currentTimeMillis();
        return;
    L30:
        if ((System.currentTimeMillis() - r107.f81938e) < 1000) goto L33;
        r107.f81937d = true;
        r107.f81938e = System.currentTimeMillis();
        long r109 = System.currentTimeMillis();
        r107.f81939f.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendTalkRoomEmoji(r108, r111.emojiId).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r107, r111, r109), new h(r107, r111, r109)));
        goto L33
    L19:
        if (r106.hasPermission != true) goto L24;
        if ((System.currentTimeMillis() - A) >= this.f81861c) goto L24;
        f2.c(this.f81862d, 0);
        return;
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        boolean r111 = ((Boolean) this.f81883y.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f81871m = r111;
        ViewGroup.LayoutParams r100 = null;
        if (r111 == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r112 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r112 == null) goto L10;
        com.bytedance.android.live.livepkaudience.base.i r113 = r112.getLinkUserCenter();
    L11:
        this.f81866h = r113;
        int r101 = 0;
        if (r113 == null) goto L22;
        String r102 = dl0.n.d();
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r103 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r103 == null) goto L16;
        String r104 = r103.getAudienceSelfLinkMicId();
    L17:
        LinkPlayerInfo r114 = r113.o(r102, r104);
        if (r114 == null) goto L22;
        if (r114.silenceStatus == 0) goto L22;
        boolean r115 = true;
    L23:
        this.f81872n = r115;
        com.bytedance.android.live.livepkaudience.base.i r116 = this.f81866h;
        if (r116 == null) goto L32;
        String r105 = dl0.n.d();
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r106 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r106 == null) goto L28;
        String r107 = r106.getAudienceSelfLinkMicId();
    L29:
        LinkPlayerInfo r117 = r116.o(r105, r107);
        if (r117 == null) goto L32;
        int r118 = r117.getLinkType();
    L33:
        this.f81873o = r118;
        Room r119 = (Room) this.f81883y.get("data_room");
        if (r119 == null) goto L36;
        long r108 = r119.f162599id;
    L37:
        this.f81874p = r108;
        T0();
        int r120 = this.f81859a;
        this.f81868j = r120;
        int r109 = this.f81860b;
        this.f81869k = r109;
        this.f81870l = r120 * r109;
        if (this.f81884z == false) goto L40;
        ((DouyinLoadingLayout) findViewById(R.id.list_loading_webp_view)).setVisibility(0);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setVisibility(0);
        ((RtlViewPagerShower) findViewById(R.id.pager_bottom_shower)).setVisibility(0);
    L41:
        EmojiListAdapter r121 = new EmojiListAdapter(this.f81859a, this.f81860b, UIUtils.getScreenWidth(getContext()));
        this.f81864f = r121;
        Intrinsics.checkNotNullParameter(this, "listener");
        r121.f79315c = this;
        SSGridLayoutManager r122 = new SSGridLayoutManager(getContext(), this.f81868j, 0);
        RecyclerView r123 = (RecyclerView) findViewById(R.id.talk_room_emoji_list);
        EmojiListAdapter r124 = this.f81864f;
        if (r124 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L44:
        r123.setAdapter(r124);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setLayoutManager(r122);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setHasFixedSize(true);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setItemViewCacheSize(this.f81870l * 2);
        GridPagerSnapHelper r125 = new BaseAudienceInteractDynamicEmojiDialog$attachSnapHelper$snapHelper$1(this);
        r125.h(this.f81868j);
        r125.g(this.f81869k);
        r125.attachToRecyclerView((RecyclerView) findViewById(R.id.talk_room_emoji_list));
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).addOnScrollListener(new BaseAudienceInteractDynamicEmojiDialog$attachSnapHelper$1(this));
        ((RtlViewPagerShower) findViewById(R.id.pager_bottom_shower)).setMargin(s1.j(R.dimen.ttlive_pager_shower_margin));
        RtlViewPagerShower r126 = (RtlViewPagerShower) findViewById(R.id.pager_bottom_shower);
        Drawable r127 = s1.m(R.drawable.ttlive_dynamic_emoji_panel_dot_normal);
        Drawable r128 = s1.m(R.drawable.ttlive_dynamic_emoji_panel_dot_selected);
        r126.f112524c = r127;
        r126.f112525d = r128;
        if (this.f81884z == false) goto L51;
        d r129 = this.f81865g;
        if (r129 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L49:
        long r130 = this.f81874p;
        int r131 = R0();
        r129.getClass();
        long r132 = System.currentTimeMillis();
        r129.f81939f.add(LinkApi.a.a((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class), r130, 8, 1, r131).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r129, r131, r132), new f(r129, r131, r132)));
    L51:
        if (this.f81871m == false) goto L53;
        char r133 = '\b';
    L55:
        if (r133 != 0) goto L63;
        ((TextView) findViewById(R.id.tv_disconnect)).setVisibility(0);
        ViewGroup.LayoutParams r134 = ((TextView) findViewById(R.id.title)).getLayoutParams();
        if ((r134 instanceof FrameLayout.LayoutParams) == false) goto L60;
        r100 = r134;
    L60:
        FrameLayout.LayoutParams r135 = (FrameLayout.LayoutParams) r100;
        if (r135 == null) goto L70;
        r135.gravity = 8388627;
        ((TextView) findViewById(R.id.title)).setLayoutParams(r135);
    L70:
        ((TextView) findViewById(R.id.tv_disconnect)).setOnClickListener(new b(this));
        P0();
        O0();
        this.f81863e = new LinkPKAudienceInteractPanelItemAdapter(this.f81879u);
        ((RecyclerView) findViewById(R.id.talk_room_action_list)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) findViewById(R.id.talk_room_action_list)).setAdapter(this.f81863e);
        ((RecyclerView) findViewById(R.id.talk_room_action_list)).setHasFixedSize(true);
        RecyclerView r136 = (RecyclerView) findViewById(R.id.talk_room_action_list);
        if (((ArrayList) this.f81879u).size() > 0) goto L74;
        r101 = 8;
    L74:
        r136.setVisibility(r101);
        findViewById(R.id.guide_line).setVisibility(((RecyclerView) findViewById(R.id.talk_room_action_list)).getVisibility());
        TextView r137 = (TextView) findViewById(R.id.title);
        if (r137 == null) goto L78;
        r137.setText(getContext().getString(R.string.ttlive_talk_room_emoji_dialog_interact_title));
        return;
    L78:
        return;
    L63:
        ((TextView) findViewById(R.id.tv_disconnect)).setVisibility(8);
        ViewGroup.LayoutParams r138 = ((TextView) findViewById(R.id.title)).getLayoutParams();
        if ((r138 instanceof FrameLayout.LayoutParams) == false) goto L67;
        r100 = r138;
    L67:
        FrameLayout.LayoutParams r139 = (FrameLayout.LayoutParams) r100;
        if (r139 == null) goto L70;
        r139.gravity = 17;
        ((TextView) findViewById(R.id.title)).setLayoutParams(r139);
        goto L70
    L53:
        r133 = 0;
        goto L55
    L40:
        ((DouyinLoadingLayout) findViewById(R.id.list_loading_webp_view)).setVisibility(8);
        ((RecyclerView) findViewById(R.id.talk_room_emoji_list)).setVisibility(8);
        ((RtlViewPagerShower) findViewById(R.id.pager_bottom_shower)).setVisibility(8);
        goto L41
    L36:
        r108 = 0;
        goto L37
    L28:
        r107 = null;
    L32:
        r118 = 2;
        goto L33
    L16:
        r104 = null;
    L22:
        r115 = false;
    L10:
        r113 = null;
        goto L11
    L7:
        com.bytedance.android.live.livepkaudience.service.d.f82252x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r140 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r140 == null) goto L10;
        r113 = r140.getLinkUserCenter();
        goto L11
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void vM(TalkRoomEmojiListResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        ((DouyinLoadingLayout) findViewById(R.id.list_loading_webp_view)).setVisibility(8);
        if (Lists.isEmpty(r100.emojiList) == true) goto L5;
        V0(false);
        Y0(r100.emojiList);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r100));
    L6:
        long r101 = r100.sendLimitTime;
        if (r101 > 1000) goto L10;
        r101 = 1000;
    L10:
        this.f81861c = r101;
        String r102 = r100.getSendLimitDesc();
        if (r102 == null) goto L14;
        this.f81862d = r102;
        return;
    L14:
        return;
    L5:
        V0(true);
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        w8 r100 = r110.a();
        if (r100 == null) goto L10;
        ue r101 = (ue) r100;
        M0(this);
        vlc.d r102 = (vlc.d) this.f81883y.get("data_message_manager", null);
        r101.setCurrUserIsAnchor(this.f81871m);
        if (r102 == null) goto L7;
        r102.B(r101);
    L7:
        el0.j.d(this.f81871m, this.f81878t, dl0.n.a(), r101.getDynamicEmoji(), null, null);
        w8 r111 = r110.a();
        Intrinsics.checkNotNull(r111);
        com.bytedance.android.live.liveinteract.plantform.utils.x.s0(r111.getMessageId(), r101.getDynamicEmoji());
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkMicDynamicEmojiMessage");
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void w6(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (X0(r100) == true) goto L5;
        ExceptionUtils.handleException(getContext(), r100);
        M0(this);
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.x.r0(r100, false);
    }

    public static final void N0(BaseAudienceInteractDynamicEmojiDialog r100, int r101) {
        int r102 = r101 / r100.f81870l;
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= r100.f81876r) goto L10;
        r100.f81877s = r102;
        ((RtlViewPagerShower) r100.findViewById(R.id.pager_bottom_shower)).b(r100.f81877s);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void F(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        X0(r101);
        S0();
        M0(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void r(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        X0(r101);
        S0();
        M0(this);
    }

    public BaseAudienceInteractDynamicEmojiDialog(Context r100, DataCenter r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100);
        this.f81883y = r101;
        this.f81884z = r102;
        this.f81859a = 2;
        this.f81860b = 6;
        this.f81861c = 1000;
        this.f81862d = s1.B(R.string.ttlive_talk_room_emoji_send_limit_tip);
        this.f81873o = 2;
        this.f81878t = "";
        this.f81879u = new ArrayList();
        this.f81881w = new CompositeDisposable();
        this.f81882x = new com.bytedance.android.live.livepkaudience.emoji.a(this);
    }
}
