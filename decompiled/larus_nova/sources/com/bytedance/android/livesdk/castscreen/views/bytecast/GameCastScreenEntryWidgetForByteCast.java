package com.bytedance.android.livesdk.castscreen.views.bytecast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastLiveScreenMode;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIEventHelper;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIHelper;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.castscreen.views.GameCastScreenEntryBaseWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.u5;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.h1;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.i8;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.CastOttPermission;
import com.bytedance.android.livesdkapi.depend.model.live.CastScreenData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.CastScreenEntry, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/bytecast/GameCastScreenEntryWidgetForByteCast;", "Lcom/bytedance/android/livesdk/castscreen/views/GameCastScreenEntryBaseWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/castscreen/utils/b;", "event", "", "onEvent", "Lcom/bytedance/android/livesdkapi/eventbus/ChangeCameraStreamEvent;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GameCastScreenEntryWidgetForByteCast extends GameCastScreenEntryBaseWidget implements Observer<KVData>, l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f104789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f104790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f104791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompositeDisposable f104792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vlc.d f104793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f104794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f104795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f104796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f104797l;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104798a;

        public a(GameCastScreenEntryWidgetForByteCast r100) {
            this.f104798a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L20;
            String r101 = LiveByteCastUIManager.f104549a;
            if (LiveByteCastUIManager.r() == false) goto L21;
            CastScreenViewModel.Companion.getClass();
            CastScreenViewModel r102 = CastScreenViewModel.a.a();
            if (r102 == null) goto L13;
            m<Boolean> r103 = r102.getCastOrMirrorScreenMode();
            if (r103 == null) goto L13;
            if (r103.getValue().booleanValue() != true) goto L13;
            return;
        L13:
            if (this.f104798a.yq() == true) goto L23;
            View r104 = this.f104798a.contentView;
            if (LivePlatformPlayerManager.i() == false) goto L17;
            int r105 = 0;
        L18:
            r104.setVisibility(r105);
            return;
        L17:
            r105 = 8;
            goto L18
        L23:
            return;
        L21:
            return;
        }
    }

    public static final class b extends u5 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104799d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ RoomContext f104800e;

        @Override // com.bytedance.android.livesdk.chatroom.ui.u5
        public final void a(View r100) {
            boolean r101 = true;
            if ((!com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f104799d.dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_CASTSCREEN)) == false) goto L5;
            return;
        L5:
            LiveByteCastUIManager r102 = LiveByteCastUIManager.f104560l;
            com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.a r103 = LiveByteCastUIManager.l();
            Integer r104 = null;
            if (r103 == null) goto L8;
            LiveCastLiveScreenMode r105 = r103.g();
        L10:
            if (r105 != LiveCastLiveScreenMode.FULL_SCREEN) goto L12;
            String r106 = "click_cast_landscape_control";
        L13:
            Intrinsics.checkNotNullParameter(r106, "from");
            LiveByteCastUIManager.f104558j = r106;
            LiveByteCastUIManager.f(this.f104799d.dataCenter);
            Lazy r107 = LiveByteCastUIEventHelper.f104521a;
            DataCenter r108 = this.f104799d.dataCenter;
            JSONObject r109 = new JSONObject();
            r109.put("is_cast", LiveByteCastUIHelper.a(r108) ? 1 : 0);
            LiveByteCastUIEventHelper.f("castsdk_mobile_screen_cast_click", r108, r109);
            DataCenter r110 = this.f104799d.dataCenter;
            if (r110 == null) goto L23;
            IAbilityCenter r111 = a0.a(r110);
            if (r111 == null) goto L23;
            IRoomRecordService r112 = (IRoomRecordService) r111.getAbility(IRoomRecordService.class);
            if (r112 == null) goto L23;
            if (r112.isRecording() != true) goto L23;
            f2.b(R.string.ttlive_record_ban_toolbar_click_tip, 0);
            LiveByteCastUIEventHelper.e(this.f104799d.dataCenter, "recording");
            return;
        L23:
            GameCastScreenEntryWidgetForByteCast r113 = this.f104799d;
            DataCenter r114 = r113.dataCenter;
            if (r114 == null) goto L26;
            r104 = (Integer) r114.get("live_cast_screen_remind_notice_type", 0);
        L26:
            if (r104 != null) goto L29;
        L30:
            DataCenter r115 = r113.dataCenter;
            if (r115 == null) goto L37;
            Room r116 = z.o(r115);
            if (r116 == null) goto L37;
            if (r116.getMosaicStatus() != 1) goto L37;
        L38:
            if (r101 == false) goto L42;
            f2.b(R.string.ttlive_live_banned_disable_cast_tip, 0);
            return;
        L42:
            if (LiveByteCastUIHelper.a(this.f104799d.dataCenter) == true) goto L56;
            DataCenter r117 = this.f104799d.dataCenter;
            if (r117 == null) goto L53;
            Room r118 = z.o(r117);
            if (r118 == null) goto L53;
            CastScreenData r119 = r118.castScreen;
            if (r119 == null) goto L53;
            CastOttPermission r120 = r119.getPermission();
            if (r120 == null) goto L53;
            String r121 = r120.getTips();
            if (r121 == null) goto L53;
        L54:
            f2.c(r121, 0);
            LiveByteCastUIEventHelper.e(this.f104799d.dataCenter, "disable");
            return;
        L53:
            r121 = "当前直播暂不支持投屏";
            goto L54
        L56:
            GameCastScreenEntryWidgetForByteCast r122 = this.f104799d;
            r102.c(r122.context, r122.dataCenter, false, "click_cast_portrait_control");
            if (ClearScreenHelper.f(this.f104800e, this.f104799d.dataCenter) == true) goto L64;
            RoomContext r123 = this.f104800e;
            if (r123 == null) goto L65;
            m<Boolean> r124 = r123.isShowCastScreenUIByClickScreen();
            if (r124 == null) goto L66;
            r124.setValue(Boolean.FALSE);
            return;
        L66:
            return;
        L65:
            return;
        L64:
            return;
        L37:
            r101 = false;
            goto L38
        L29:
            if (r104.intValue() == 2) goto L38;
        L12:
            r106 = "click_cast_portrait_control";
            goto L13
        L8:
            r105 = null;
            goto L10
        }

        public b(GameCastScreenEntryWidgetForByteCast r100, RoomContext r101) {
            this.f104799d = r100;
            this.f104800e = r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104801a;

        public c(GameCastScreenEntryWidgetForByteCast r100) {
            this.f104801a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            GameCastScreenEntryWidgetForByteCast r101 = this.f104801a;
            boolean r102 = ((Boolean) r100).booleanValue();
            r101.getClass();
            if (LiveByteCastManager.b() == false) goto L6;
            return;
        L6:
            if (r101.Cq() == true) goto L8;
            return;
        L8:
            if (r101.yq() == true) goto L35;
            ListenLiveStatus r103 = (ListenLiveStatus) r101.dataCenter.get("cmd_change_listen_live_status", null);
            if (r103 != null) goto L13;
        L15:
            Disposable r104 = r101.f104794i;
            if (r104 != null) goto L18;
        L22:
            CastScreenViewModel.Companion.getClass();
            CastScreenViewModel r105 = CastScreenViewModel.a.a();
            if (r105 == null) goto L28;
            m<Boolean> r106 = r105.getCastOrMirrorScreenMode();
            if (r106 == null) goto L28;
            if (r106.getValue().booleanValue() != true) goto L28;
        L30:
            r101.Fq(false);
            return;
        L28:
            if (r102 == false) goto L30;
            r101.contentView.setVisibility(0);
            Lazy r107 = LiveByteCastUIEventHelper.f104521a;
            LiveByteCastUIEventHelper.f("castsdk_mobile_screen_cast_show", r101.dataCenter, new JSONObject());
            r101.Fq(true);
            return;
        L18:
            if (r104.isDisposed() == true) goto L22;
            Disposable r108 = r101.f104794i;
            if (r108 == null) goto L22;
            r108.dispose();
            goto L22
        L13:
            if (r103.isOpen() != true) goto L15;
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104802a;

        public d(GameCastScreenEntryWidgetForByteCast r100) {
            this.f104802a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            UtilityKotlinExtentionsKt.t(this.f104802a.contentView);
            return;
        L6:
            if (this.f104802a.yq() == true) goto L14;
            UtilityKotlinExtentionsKt.w(this.f104802a.contentView);
            View r101 = this.f104802a.f104791f;
            if (r101 == null) goto L13;
            UtilityKotlinExtentionsKt.w(r101);
            return;
        L13:
            return;
        }
    }

    public final class e implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f104803a;

        public e(Function1 r100) {
            this.f104803a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f104803a.invoke(r100);
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f104805b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            if (this.f104805b == true) goto L5;
            this.f104804a.contentView.setVisibility(8);
        L5:
            this.f104804a.Bq(this.f104805b);
        }

        public f(GameCastScreenEntryWidgetForByteCast r100, boolean r101) {
            this.f104804a = r100;
            this.f104805b = r101;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCastScreenEntryWidgetForByteCast f104806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomContext f104807b;

        public g(GameCastScreenEntryWidgetForByteCast r100, RoomContext r101) {
            this.f104806a = r100;
            this.f104807b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            if (ClearScreenHelper.f(this.f104807b, this.f104806a.dataCenter) == true) goto L10;
            RoomContext r102 = this.f104807b;
            if (r102 == null) goto L11;
            m<Boolean> r103 = r102.isShowCastScreenUIByClickScreen();
            if (r103 == null) goto L12;
            r103.setValue(Boolean.FALSE);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.castscreen.views.bytecast.GameCastScreenEntryWidgetForByteCast$onLoad$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/utils/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/castscreen/utils/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.castscreen.utils.b, Unit> {
        public AnonymousClass6(GameCastScreenEntryWidgetForByteCast r100) {
            super(1, r100, GameCastScreenEntryWidgetForByteCast.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/castscreen/utils/GameCastConnectShowEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.castscreen.utils.b r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.bytedance.android.livesdk.castscreen.utils.b r100) {
            ((GameCastScreenEntryWidgetForByteCast) this.receiver).onEvent(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.castscreen.views.bytecast.GameCastScreenEntryWidgetForByteCast$onLoad$7, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdkapi/eventbus/ChangeCameraStreamEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<ChangeCameraStreamEvent, Unit> {
        public AnonymousClass7(GameCastScreenEntryWidgetForByteCast r100) {
            super(1, r100, GameCastScreenEntryWidgetForByteCast.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdkapi/eventbus/ChangeCameraStreamEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChangeCameraStreamEvent r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChangeCameraStreamEvent r100) {
            ((GameCastScreenEntryWidgetForByteCast) this.receiver).onEvent(r100);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_cast_screen_entry_classic;
    }

    public final boolean Cq() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r100 != null) goto L5;
    L10:
        return true;
    L5:
        if (r100.isCommentaryRoom() != true) goto L10;
        if (LivePlatformPlayerManager.i() == true) goto L10;
        return false;
    }

    public GameCastScreenEntryWidgetForByteCast() {
        this.f104789d = new CompositeDisposable();
        this.f104792g = new CompositeDisposable();
        this.f104797l = new a(this);
    }

    public final boolean Aq() {
        if (LiveByteCastManager.a() == true) goto L5;
        return false;
    L5:
        RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        IHostLiveByteCast r100 = (IHostLiveByteCast) LiveByteCastUIHelper.f104523a.getValue();
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L14;
        return false;
    L14:
        if (LiveByteCastManager.b() == false) goto L17;
        return false;
    L17:
        if (xq() == false) goto L27;
        ListenLiveStatus r102 = (ListenLiveStatus) this.dataCenter.get("cmd_change_listen_live_status", null);
        if (r102 != null) goto L21;
    L23:
        boolean r103 = false;
    L24:
        if (r103 == true) goto L28;
        return true;
    L28:
        return false;
    L21:
        if (r102.isOpen() != true) goto L23;
        r103 = true;
        goto L24
    L27:
        return false;
    L8:
        if (r100.canShowBtn() != true) goto L10;
        r101 = true;
        goto L11
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        if (Cq() == true) goto L5;
        return;
    L5:
        if (yq() == true) goto L13;
        super.onResume();
        if (lj.f120685a.getValue().b() != 2) goto L12;
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        Fq(true);
        Gq(r100);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.GameCastScreenEntryBaseWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        this.f104792g.dispose();
        this.f104789d.dispose();
        Disposable r100 = this.f104794i;
        if (r100 != null) goto L5;
    L9:
        vlc.d r101 = this.f104793h;
        if (r101 == null) goto L12;
        r101.removeMessageListener(this);
    L12:
        ObjectAnimator r102 = this.f104795j;
        if (r102 == null) goto L15;
        r102.removeAllListeners();
    L15:
        ObjectAnimator r103 = this.f104795j;
        if (r103 == null) goto L18;
        r103.cancel();
    L18:
        Disposable r104 = null;
        this.f104795j = null;
        ILivePlayerClient r105 = LivePlatformPlayerManager.f();
        if (r105 == null) goto L27;
        ILivePlayerExtraRenderController r106 = r105.extraRenderController();
        if (r106 == null) goto L27;
        ILivePlayerExtraRenderController.EventHub r107 = r106.eventHub();
        if (r107 == null) goto L27;
        MutableLiveData<Boolean> r108 = r107.getMainFrameChanged();
        if (r108 == null) goto L27;
        r108.removeObserver(this.f104797l);
    L27:
        Disposable r109 = this.f104796k;
        if (r109 != null) goto L30;
        return;
    L30:
        if ((!r109.isDisposed()) == false) goto L32;
        r104 = r109;
    L32:
        if (r104 == null) goto L36;
        r104.dispose();
        return;
    L36:
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r110 = this.f104794i;
        if (r110 == null) goto L9;
        r110.dispose();
        goto L9
    }

    public final void Bq(boolean r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L22;
        boolean r102 = true;
        float r103 = 1.0f;
        float r104 = r101.getAlpha();
        if (r100 == false) goto L10;
        if (r104 != 1.0f) goto L13;
    L12:
        r102 = false;
    L13:
        if (r102 == true) goto L16;
        r101 = null;
    L16:
        if (r101 == null) goto L23;
        if (r100 == true) goto L20;
        r103 = 0.0f;
    L20:
        r101.setAlpha(r103);
        return;
    L23:
        return;
    L10:
        if (r104 == 0.0f) goto L12;
    }

    public final void Fq(boolean r100) {
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L5;
        return;
    L5:
        ObjectAnimator r101 = this.f104795j;
        if (r101 == null) goto L13;
        if (r101.isRunning() != true) goto L13;
        ObjectAnimator r102 = this.f104795j;
        if (r102 == null) goto L13;
        r102.cancel();
    L13:
        if (r100 == false) goto L15;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.contentView, "alpha", new float[]{0.0f, 1.0f});
    L16:
        this.f104795j = r103;
        if (r103 == null) goto L19;
        r103.setDuration(200);
    L19:
        ObjectAnimator r104 = this.f104795j;
        if (r104 == null) goto L22;
        r104.removeAllListeners();
    L22:
        ObjectAnimator r105 = this.f104795j;
        if (r105 == null) goto L25;
        r105.start();
    L25:
        ObjectAnimator r106 = this.f104795j;
        if (r106 == null) goto L29;
        r106.addListener(new f(this, r100));
        return;
    L29:
        return;
    L15:
        r103 = ObjectAnimator.ofFloat(this.contentView, "alpha", new float[]{1.0f, 0.0f});
        goto L16
    }

    public final void Gq(RoomContext r100) {
        Disposable r101 = this.f104794i;
        if (r101 != null) goto L5;
    L9:
        LiveVisibilityControlContext.Companion.getClass();
        Disposable r102 = null;
        if (LiveVisibilityControlContext.a.a() == false) goto L17;
        h1.a r103 = h1.f114487b;
        DataCenter r104 = this.dataCenter;
        r103.getClass();
        if (h1.a.g(r104) == null) goto L17;
        IVisibilityControlService r105 = h1.a.g(this.dataCenter);
        if (r105 == null) goto L16;
        Observable r106 = r105.startVisibilityTimer();
    L18:
        if (r106 == null) goto L22;
        Observable r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L22;
        r102 = r107.subscribe(new g(this, r100));
    L22:
        this.f104794i = r102;
        return;
    L16:
        r106 = null;
    L17:
        r106 = Observable.timer(lj.f120685a.getValue().a(), TimeUnit.SECONDS).map(com.bytedance.android.livesdk.castscreen.views.bytecast.c.f104885a);
        goto L18
    L5:
        if (r101.isDisposed() == true) goto L9;
        Disposable r108 = this.f104794i;
        if (r108 == null) goto L9;
        r108.dispose();
        goto L9
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 == null) goto L43;
        int r103 = r102.hashCode();
        if (r103 == 193203799) goto L28;
        if (r103 == 309908432) goto L14;
        return;
    L14:
        if (r102.equals("data_media_introduction_showing") == false) goto L35;
        Boolean r104 = Boolean.FALSE;
        Boolean r105 = (Boolean) r101.getData(r104);
        if (r105 == null) goto L20;
        r104 = r105;
    L20:
        if (r104.booleanValue() == false) goto L24;
        View r106 = this.contentView;
        if (r106 == null) goto L36;
        r106.setImportantForAccessibility(4);
        return;
    L36:
        return;
    L24:
        View r107 = this.contentView;
        if (r107 == null) goto L38;
        r107.setImportantForAccessibility(0);
        return;
    L38:
        return;
    L35:
        return;
    L28:
        if (r102.equals("cmd_change_listen_live_status") == false) goto L40;
        ListenLiveStatus r108 = (ListenLiveStatus) r101.getData(new ListenLiveStatus());
        if (r108 != null) goto L32;
        return;
    L32:
        if (r108.isOpen() != true) goto L42;
        this.contentView.setVisibility(8);
        return;
    L42:
        return;
    L40:
        return;
    L43:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        if (PadConfigUtils.c() == false) goto L5;
        UtilityKotlinExtentionsKt.A(this.contentView, Aq());
    L5:
        super.onConfigurationChanged(r100);
    }

    public final void onEvent(ChangeCameraStreamEvent r100) {
        if (r100 != null) goto L4;
    L11:
        View r101 = this.contentView;
        if (r101 == null) goto L14;
        r101.setVisibility(0);
    L14:
        View r102 = this.f104791f;
        if (r102 == null) goto L20;
        UtilityKotlinExtentionsKt.w(r102);
        return;
    L20:
        return;
    L4:
        if (r100.getCameraScene() != 1) goto L11;
        View r103 = this.contentView;
        if (r103 == null) goto L8;
        r103.setVisibility(8);
    L8:
        View r104 = this.f104791f;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f104790e = (ImageView) findViewById(R.id.ttlive_tv_entry_icon);
        this.f104791f = findViewById(R.id.ttlive_tv_entry_icon_container);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.GameCastScreenEntryBaseWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L7;
        ImageView r102 = this.f104790e;
        if (r102 == null) goto L10;
        r102.setBackgroundResource(R.drawable.ttlive_cast_screen_entry_match_p);
    L10:
        Lazy r103 = LiveByteCastUIHelper.f104523a;
        if (LiveByteCastUIHelper.a(this.dataCenter) == false) goto L15;
        ImageView r104 = this.f104790e;
        if (r104 == null) goto L18;
        r104.setAlpha(1.0f);
    L18:
        Disposable r105 = null;
        if (r101 == null) goto L28;
        m<Boolean> r106 = r101.isShowCastScreenUIByClickScreen();
        if (r106 == null) goto L28;
        if ((!VSMediaUIConfigHelper.b(this.dataCenter)) == true) goto L26;
        r106 = null;
    L26:
        if (r106 == null) goto L28;
        r106.setValue(Boolean.TRUE);
    L28:
        Bq(true);
        this.f104792g = new CompositeDisposable();
        if (Aq() == false) goto L40;
        this.contentView.setVisibility(0);
        StringBuilder r107 = new StringBuilder("visible. alpha:");
        View r108 = this.contentView;
        if (r108 == null) goto L33;
        Float r109 = Float.valueOf(r108.getAlpha());
    L34:
        r107.append(r109);
        ALogger.i("ldg-cast", r107.toString());
        Lazy r110 = LiveByteCastUIEventHelper.f104521a;
        LiveByteCastUIEventHelper.f("castsdk_mobile_screen_cast_show", this.dataCenter, new JSONObject());
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L37;
    L45:
        if (r101 != null) goto L47;
    L57:
        ImageView r111 = this.f104790e;
        if (r111 == null) goto L61;
        r111.setOnClickListener(new b(this, r101));
    L61:
        if (z.m(this.dataCenter, true) == true) goto L63;
    L76:
        if (r101 == null) goto L84;
        m<Boolean> r112 = r101.isShowCastScreenUIByClickScreen();
        if (r112 == null) goto L84;
        Observable<Boolean> r113 = r112.a();
        if (r113 == null) goto L84;
        ObservableSubscribeProxy r114 = (ObservableSubscribeProxy) r113.as(autoDispose());
        if (r114 == null) goto L84;
        r114.subscribe(new c(this));
    L84:
        Eq(com.bytedance.android.livesdk.castscreen.utils.b.class, new AnonymousClass6(this));
        DataCenter r115 = this.dataCenter;
        if (r115 == null) goto L87;
        r115.observe("data_media_introduction_showing", this);
    L87:
        DataCenter r116 = this.dataCenter;
        if (r116 == null) goto L90;
        r116.observe("cmd_change_listen_live_status", this);
    L90:
        DataCenter r117 = this.dataCenter;
        if (r117 == null) goto L93;
        vlc.d r118 = (vlc.d) r117.get("data_message_manager", null);
    L94:
        this.f104793h = r118;
        if (r118 == null) goto L97;
        r118.addMessageListener(MessageType.REMIND.getIntType(), this);
    L97:
        ILiveExpOptService r119 = (ILiveExpOptService) jc1.k.f(ILiveExpOptService.class);
        if (r119 == null) goto L100;
        r105 = r119.registerExpBizListener(l61.d.a.f.f507612e, new com.bytedance.android.livesdk.castscreen.views.bytecast.d(this));
    L100:
        this.f104796k = r105;
        if (i8.f132645a.getValue().booleanValue() == false) goto L104;
        Eq(ChangeCameraStreamEvent.class, new AnonymousClass7(this));
        return;
    L104:
        return;
    L93:
        r118 = null;
        goto L94
    L63:
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L76;
        if (VSMediaUIConfigHelper.b(this.dataCenter) == false) goto L84;
        CastScreenViewModel.a r120 = CastScreenViewModel.Companion;
        DataCenter r121 = this.dataCenter;
        r120.getClass();
        CastScreenViewModel r122 = CastScreenViewModel.a.b(r121);
        if (r122 == null) goto L84;
        m<Boolean> r123 = r122.getCastOrMirrorScreenMode();
        if (r123 == null) goto L84;
        Observable<Boolean> r124 = r123.a();
        if (r124 == null) goto L84;
        Disposable r125 = r124.subscribe(new d(this));
        if (r125 == null) goto L84;
        RxUtilKt.c(r125, this.f104792g);
        goto L84
    L47:
        if (r101.isCommentaryRoom() != true) goto L57;
        ILivePlayerClient r126 = LivePlatformPlayerManager.f();
        if (r126 == null) goto L57;
        ILivePlayerExtraRenderController r127 = r126.extraRenderController();
        if (r127 == null) goto L57;
        ILivePlayerExtraRenderController.EventHub r128 = r127.eventHub();
        if (r128 == null) goto L57;
        MutableLiveData<Boolean> r129 = r128.getMainFrameChanged();
        if (r129 == null) goto L57;
        r129.observe(this, this.f104797l);
        goto L57
    L37:
        if (ClearScreenHelper.f(r101, this.dataCenter) == true) goto L45;
        Gq(r101);
        goto L45
    L33:
        r109 = null;
        goto L34
    L40:
        this.contentView.setVisibility(8);
        StringBuilder r130 = new StringBuilder("gone. alpha:");
        View r131 = this.contentView;
        if (r131 == null) goto L43;
        Float r132 = Float.valueOf(r131.getAlpha());
    L44:
        r130.append(r132);
        ALogger.i("ldg-cast", r130.toString());
        goto L45
    L43:
        r132 = null;
        goto L44
    L15:
        ImageView r133 = this.f104790e;
        if (r133 == null) goto L18;
        r133.setAlpha(0.6f);
        goto L18
    L7:
        ImageView r134 = this.f104790e;
        if (r134 == null) goto L10;
        r134.setBackgroundResource(R.drawable.ttlive_ic_portraint_cast_screen);
        goto L10
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof kj) == false) goto L10;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L11;
        r101.put("live_cast_screen_remind_notice_type", Integer.valueOf(((kj) r100).s()));
        return;
    L11:
        return;
    }

    public final void onEvent(com.bytedance.android.livesdk.castscreen.utils.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f104733a != true) goto L19;
        ObjectAnimator r101 = this.f104795j;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        ObjectAnimator r102 = this.f104795j;
        if (r102 == null) goto L11;
        r102.end();
    L11:
        ObjectAnimator r103 = this.f104795j;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        View r104 = this.contentView;
        if (r104 == null) goto L20;
        r104.setVisibility(8);
        return;
    L20:
        return;
    }

    public final <T> void Eq(Class<T> r100, Function1<? super T, Unit> r101) {
        RxUtilKt.c(xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r101)), this.f104792g);
    }
}
