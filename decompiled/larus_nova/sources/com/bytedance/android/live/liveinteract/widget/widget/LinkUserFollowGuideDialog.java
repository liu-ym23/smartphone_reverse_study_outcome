package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/LinkUserFollowGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkUserFollowGuideDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f81001h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f81002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f81004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f81005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ILinkerFollowStrongGuideContent f81006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gd0.u f81007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f81008g;

    public interface a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkUserFollowGuideDialog f81009a;

        public b(LinkUserFollowGuideDialog r100) {
            this.f81009a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            LinkUserFollowGuideDialog r111 = this.f81009a;
            int r100 = LinkUserFollowGuideDialog.f81001h;
            r111.getClass();
            if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isLogin() == true) goto L5;
            com.bytedance.android.livesdk.user.e r101 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
            Context r112 = r111.getContext();
            com.bytedance.android.livesdk.user.l.a r102 = new com.bytedance.android.livesdk.user.l.a();
            r102.f158685a = CoreSettingUtil.getLoginPromptForFollow();
            r102.f158686b = CoreSettingUtil.getLoginImageForFollow();
            r102.f158689e = "live_detail";
            r102.f158691g = "follow";
            r102.f158688d = "live";
            r102.f158687c = 1;
            r101.login(r112, new com.bytedance.android.livesdk.user.l(r102)).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L5:
            Room r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            String r104 = "";
            if (r103 == null) goto L21;
            long r105 = r103.getRoomId();
            com.bytedance.android.livesdk.user.e r106 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
            com.bytedance.android.livesdk.user.b.c r107 = new com.bytedance.android.livesdk.user.b.c();
            ILinkerFollowStrongGuideContent r108 = r111.f81006e;
            if (r108 == null) goto L12;
            IBaseUser r109 = r108.getUser();
            if (r109 == null) goto L12;
            String r113 = r109.getIdString();
        L13:
            com.bytedance.android.livesdk.user.b.a r114 = r107.c(r113);
            ILinkerFollowStrongGuideContent r115 = r111.f81006e;
            if (r115 == null) goto L19;
            IBaseUser r116 = r115.getUser();
            if (r116 == null) goto L19;
            Intrinsics.checkNotNullParameter(r116, "$this$secUidExt");
            String r117 = r116.getCastSecUid();
            if (r117 == null) goto L19;
        L20:
            com.bytedance.android.livesdk.user.b.c r118 = ((com.bytedance.android.livesdk.user.b.c) r114.b(r117).h(r105)).f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.FOLLOW_BACK));
            r118.getClass();
            ((ObservableSubscribeProxy) r106.h(new com.bytedance.android.livesdk.user.b(r118)).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r111.f81005d))).subscribe(new t(r111), new u(r111));
        L19:
            r117 = "";
        L12:
            r113 = null;
        L21:
            HashMap r119 = new HashMap();
            TalkRoomLogUtils.B0(r119, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
            TalkRoomLogUtils.J0(r119);
            TalkRoomLogUtils.f1(r119, r111.f81006e.getFromUserType());
            IBaseUser r120 = r111.f81006e.getUser();
            if (r120 == null) goto L27;
            String r121 = r120.getIdString();
            if (r121 == null) goto L27;
            r104 = r121;
        L27:
            r119.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r104);
            r119.put("request_page", "link_user_popup");
            com.bytedance.live.datacontext.m<Boolean> r122 = com.bytedance.android.live.liveinteract.api.utils.m.i().isCleanMode();
            if (r122 != null) goto L30;
        L32:
            String r123 = "0";
        L33:
            r119.put("if_clear_mode", r123);
            j0.l().sendLog("livesdk_follow", r119, new Object[]{IRoom.class});
            Handler r124 = DialogLancet.resolveDialogHandler(r111);
            if (r124 != null) goto L36;
        L38:
            DialogLancet.beforeDialogDismiss(r111);
            r111.dismiss();     // Catch: Throwable -> L41 Exception -> L43
        L47:
            DialogLancet.afterDialogDismiss(r111);
            return;
        L43:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L41
            Throwable r125 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L41
            if (r125 == null) goto L47;
            com.bytedance.crash.d.d(r125, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r111);
            throw th;
        L36:
            if (Looper.myLooper() == r124.getLooper()) goto L38;
            r124.post(DialogLancet.createDismissRunnable(r111));
            return;
        L30:
            if (r122.getValue().booleanValue() != true) goto L32;
            r123 = "1";
            goto L33
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_link_user_follow_guide;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        ((LinkMultiControlPresenter) this.f81008g).f83258p = false;
        this.f81004c.dispose();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f81004c.isDisposed() == true) goto L6;
        this.f81004c.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        ((Button) findViewById(R.id.btn_follow)).setOnClickListener(new b(this));
        if (this.f81006e.getFromUserType() != UserType.ANCHOR.getValue()) goto L6;
        this.f81002a = getContext().getString(R.string.ttlive_interact_anchor);
    L8:
        ImageView r101 = (ImageView) findViewById(R.id.iv_avatar);
        IBaseUser r102 = this.f81006e.getUser();
        String r103 = null;
        if (r102 == null) goto L11;
        py.k r104 = r102.getAvatarThumbKt();
    L12:
        ImageUtil.loadRoundImage(r101, r104);
        TextView r105 = (TextView) findViewById(R.id.tv_userName);
        IBaseUser r106 = this.f81006e.getUser();
        if (r106 == null) goto L15;
        r103 = r106.getNickName();
    L15:
        r105.setText(r103);
        TextView r107 = (TextView) findViewById(R.id.tv_identity);
        String r108 = this.f81002a;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("identityText");
    L18:
        r107.setText(r108);
        this.f81004c.add(du2.a.d(1, TimeUnit.SECONDS).take(this.f81003b).map(new r(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this)));
        return;
    L11:
        r104 = null;
        goto L12
    L6:
        if (this.f81006e.getFromUserType() != UserType.AUDIENCE.getValue()) goto L8;
        this.f81002a = getContext().getString(R.string.ttlive_interact_audience);
        goto L8
    }

    public LinkUserFollowGuideDialog(Context r100, LifecycleOwner r101, ILinkerFollowStrongGuideContent r102, gd0.u r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "linkerFollowStringGuideContent");
        Intrinsics.checkNotNullParameter(r103, "linkUserFollowGuideCallback");
        Intrinsics.checkNotNullParameter(r104, "dismissCallback");
        super(r100);
        this.f81005d = r101;
        this.f81006e = r102;
        this.f81007f = r103;
        this.f81008g = r104;
        this.f81003b = 10;
        this.f81004c = new CompositeDisposable();
    }
}
