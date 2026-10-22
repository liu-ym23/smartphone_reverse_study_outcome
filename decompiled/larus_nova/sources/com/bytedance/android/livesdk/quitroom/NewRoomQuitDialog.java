package com.bytedance.android.livesdk.quitroom;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.HostInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import com.bytedance.android.livesdk.interactivity.impl.exitroom.CloseInterceptorService;
import com.bytedance.android.livesdk.quitroom.api.QuitRoomApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/quitroom/NewRoomQuitDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class NewRoomQuitDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f156884e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f156885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f156886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f156887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f156888d;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        void d(FeedItem r100, FeedExtra r101);

        void e();

        void onLoadFail();

        void onLoadSuccess();
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewRoomQuitDialog f156889a;

        public c(NewRoomQuitDialog r100) {
            this.f156889a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f156889a.f156888d.c();
            NewRoomQuitDialog r101 = this.f156889a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewRoomQuitDialog f156890a;

        public d(NewRoomQuitDialog r100) {
            this.f156890a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f156890a.f156888d.e();
            NewRoomQuitDialog r101 = this.f156890a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewRoomQuitDialog f156891a;

        public e(NewRoomQuitDialog r100) {
            this.f156891a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f156891a.f156888d.a();
            NewRoomQuitDialog r101 = this.f156891a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    static {
    }

    public final void L0(int r110) {
        if (r110 != 1) goto L5;
        M0(0, new View[]{findViewById(R.id.lottie_animation_view)});
        M0(4, new View[]{findViewById(R.id.tv_title), findViewById(R.id.group_live_cover_1), findViewById(R.id.group_live_cover_2), findViewById(R.id.tv_positive_btn), findViewById(R.id.tv_negative_btn), findViewById(R.id.iv_empty_icon), findViewById(R.id.tv_empty_tip)});
        return;
    L5:
        if (r110 == 2) goto L20;
        if (r110 != 3) goto L39;
        M0(0, new View[]{findViewById(R.id.iv_empty_icon), findViewById(R.id.tv_empty_tip), findViewById(R.id.tv_positive_btn)});
        M0(4, new View[]{findViewById(R.id.lottie_animation_view), findViewById(R.id.tv_title), findViewById(R.id.group_live_cover_1), findViewById(R.id.group_live_cover_2), findViewById(R.id.iv_live_cover_1), findViewById(R.id.iv_live_cover_2)});
        M0(8, new View[]{findViewById(R.id.tv_negative_btn)});
        wl2.a r100 = wl2.a.f560186a;
        if (wl2.a.a(this.f156887c) == false) goto L13;
        TextView r101 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r101 == null) goto L16;
        r101.setText(R.string.ttlive_new_room_quit_dialog_live_tab_tip);
    L16:
        TextView r102 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r102 == null) goto L19;
        r102.setOnClickListener(new e(this));
    L19:
        this.f156888d.onLoadFail();
        return;
    L13:
        TextView r103 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r103 == null) goto L16;
        r103.setText(R.string.ttlive_new_room_quit_dialog_no_data_tip);
        goto L16
    L39:
        return;
    L20:
        M0(0, new View[]{findViewById(R.id.tv_title), findViewById(R.id.group_live_cover_1), findViewById(R.id.group_live_cover_2), findViewById(R.id.tv_positive_btn), findViewById(R.id.tv_negative_btn)});
        M0(4, new View[]{findViewById(R.id.lottie_animation_view), findViewById(R.id.iv_empty_icon), findViewById(R.id.tv_empty_tip)});
        wl2.a r104 = wl2.a.f560186a;
        if (wl2.a.a(this.f156887c) == false) goto L25;
        TextView r105 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r105 == null) goto L28;
        r105.setText(R.string.ttlive_new_room_quit_dialog_live_tab_tip);
    L28:
        TextView r106 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r106 == null) goto L31;
        r106.setOnClickListener(new c(this));
    L31:
        View r107 = findViewById(R.id.tv_negative_btn);
        if (r107 == null) goto L34;
        r107.setOnClickListener(new d(this));
    L34:
        this.f156888d.onLoadSuccess();
        return;
    L25:
        TextView r108 = (TextView) findViewById(R.id.tv_positive_btn);
        if (r108 == null) goto L28;
        r108.setText(R.string.ttlive_new_room_quit_dialog_more_live_tip);
        goto L28
    }

    public static final ImageModel I0(NewRoomQuitDialog r100, Room r101) {
        r100.getClass();
        RoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 != null) goto L5;
    L11:
        User r103 = r101.mo8271getOwner();
        if (r103 != null) goto L18;
        return null;
    L18:
        return r103.getAvatarThumb();
    L5:
        if (r102.useHostInfo != 1) goto L11;
        User r104 = r101.mo8271getOwner();
        Intrinsics.checkNotNull(r104);
        HostInfo r105 = r104.getHostInfo();
        if (r105 == null) goto L10;
        ImageModel r106 = r105.get_avatarThumb();
        if (r106 == null) goto L10;
        return r106;
    L10:
        User r107 = r101.mo8271getOwner();
        Intrinsics.checkNotNull(r107);
        return r107.getAvatarThumb();
    }

    public static final String J0(NewRoomQuitDialog r100, Room r101) {
        r100.getClass();
        RoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 != null) goto L5;
    L11:
        User r103 = r101.mo8271getOwner();
        if (r103 != null) goto L18;
        return null;
    L18:
        return r103.getRealNickName();
    L5:
        if (r102.useHostInfo != 1) goto L11;
        User r104 = r101.mo8271getOwner();
        Intrinsics.checkNotNull(r104);
        HostInfo r105 = r104.getHostInfo();
        if (r105 == null) goto L10;
        String r106 = r105.get_realNickName();
        if (r106 == null) goto L10;
        return r106;
    L10:
        User r107 = r101.mo8271getOwner();
        Intrinsics.checkNotNull(r107);
        return r107.getRealNickName();
    }

    public static void M0(int r100, View... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r101[r103];
        if (r104 == null) goto L7;
        r104.setVisibility(r100);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public NewRoomQuitDialog(Context r110, DataCenter r111, CloseInterceptorService.a r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "listener");
        super(r110, R.style.NewQuitRoomDialog);
        this.f156887c = r111;
        this.f156888d = r210;
        View r100 = LayoutInflater.from(r110).inflate(R.layout.ttlive_dialog_new_room_quit, null);
        this.f156885a = r100;
        setContentView(r100);
        View r101 = findViewById(R.id.iv_close_btn);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new f(this));
    L5:
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new com.bytedance.android.livesdk.quitroom.c(this));
        NewRoomQuitDialog$fetchRoom$1 r102 = NewRoomQuitDialog$fetchRoom$1.INSTANCE;
        NewRoomQuitDialog$fetchRoom$2 r103 = new NewRoomQuitDialog$fetchRoom$2(this);
        NewRoomQuitDialog$fetchRoom$3 r104 = new NewRoomQuitDialog$fetchRoom$3(this);
        long r105 = LiveConfigSettingKeys.LIVE_NEW_REMAIN_DIALOG_CONFIG.getValue().d();
        L0(1);
        boolean r106 = y3.l().n(ToolbarButton.COMMERCE);
        ALogger.d(ICloseInterceptorService.TAG_QUIT_DIALOG, "fetchRoom() >>> isCommerceShow=" + r106);
        QuitRoomApi r107 = (QuitRoomApi) com.bytedance.android.live.network.c.b().e(QuitRoomApi.class);
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r108 == null) goto L12;
        m<Room> r109 = r108.getRoom();
        if (r109 == null) goto L12;
        Room r112 = r109.getValue();
        if (r112 == null) goto L12;
        long r113 = r112.f162599id;
    L13:
        this.f156886b = r107.getRemainDialogRoom(0, 2, "exit_room_pop-live_cover", r113, "retain_popup_window", r106 ? 1 : 0).timeout(r105, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.quitroom.d(this, r103, r104), new com.bytedance.android.livesdk.quitroom.e(this));
        return;
    L12:
        r113 = 0;
        goto L13
    }
}
