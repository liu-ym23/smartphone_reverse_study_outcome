package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.api.LiveAdjustPositionApi;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.GetPositionPanelResponse;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.PositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkAudiHamletFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkHeightFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkWidthFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.adapter.AdjustGuestPositionListAdapter;
import com.bytedance.android.livesdk.config.ya0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class AdjustGuestPositionDialog extends com.bytedance.android.livesdk.common.b implements View.OnClickListener, com.bytedance.android.live.liveinteract.videotalk.adapter.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f71858v = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m f71861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f71862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f71863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f71864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f71865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdjustGuestPositionListAdapter f71866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IRoom f71867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f71868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f71869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f71870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f71871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f71872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<Long, PositionItem> f71873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f71874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> f71875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f71876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f71877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f71878u;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71879a;

        public a(AdjustGuestPositionDialog r100) {
            this.f71879a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.chatroom.viewmodel.j r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r100;
            AdjustGuestPositionDialog r102 = this.f71879a;
            if (r102.f71876s == false) goto L21;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r104 == null) goto L18;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L7:
            if (Looper.myLooper() == r103.getLooper()) goto L9;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f71880a = null;

        static {
            f71880a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71881a;

        public c(AdjustGuestPositionDialog r100) {
            this.f71881a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r100;
            AdjustGuestPositionDialog r102 = this.f71881a;
            if (r102.f71876s == false) goto L21;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r104 == null) goto L18;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L7:
            if (Looper.myLooper() == r103.getLooper()) goto L9;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f71882a = null;

        static {
            f71882a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71883a;

        public e(AdjustGuestPositionDialog r100) {
            this.f71883a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            StateMachine.c.b r101 = (StateMachine.c.b) r100;
            if (TeamFightContext.Companion.h() == false) goto L21;
            AdjustGuestPositionDialog r102 = this.f71883a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r104 == null) goto L18;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L7:
            if (Looper.myLooper() == r103.getLooper()) goto L9;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        }
    }

    public static final class f {
    }

    public static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AdjustGuestPositionDialog> f71884a;

        public g(AdjustGuestPositionDialog r100) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            super(Looper.getMainLooper());
            this.f71884a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            WeakReference<AdjustGuestPositionDialog> r101 = this.f71884a;
            if (r101 == null) goto L11;
            AdjustGuestPositionDialog r102 = r101.get();
            if (r102 != null) goto L7;
            return;
        L7:
            if (r100.what != 5) goto L13;
            r102.f71869l.dispose();
            Disposable r103 = du2.a.b(1, 5, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.c(r102));
            RxUtilKt.c(r103, r102.f71868k);
            r102.f71869l = r103;
            return;
        L13:
            return;
        }
    }

    public static final class h implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71885a;

        public h(AdjustGuestPositionDialog r100) {
            this.f71885a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            AdjustGuestPositionDialog r101 = this.f71885a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r110, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r111) {
            Intrinsics.checkNotNullParameter(r110, "request");
            Intrinsics.checkNotNullParameter(r111, "response");
            if (r111.f75661a.getUiLayout() != 30) goto L24;
            AdjustGuestPositionDialog r112 = this.f71885a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r113 = r111.f75661a;
            r112.getClass();
            if (r113.getUiLayout() != 30) goto L25;
            r113 = r113.b();
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r114 = r113.d();
            int r100 = 0;
            if (r114 == null) goto L10;
            int r115 = r114.b();
        L11:
            List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r101 = r113.h();
            if (r101 == null) goto L25;
            Iterator<T> r102 = r101.iterator();
        L15:
            if (r102.hasNext() == false) goto L25;
            Object r103 = r102.next();
            int r104 = r100 + 1;
            if (r100 >= 0) goto L19;
            CollectionsKt.throwIndexOverflow();
        L19:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r105 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r103;
            if (r100 != 0) goto L22;
            r105.l((((double) r115) - r105.b()) / ((double) 2));
        L23:
            r100 = r104;
            goto L15
        L22:
            double r106 = r105.b() - r105.d();
            r105.j(r105.b());
            r105.k(r105.e() - r106);
            goto L23
        L10:
            r115 = 0;
        L25:
            AdjustGuestPositionDialog r116 = this.f71885a;
            r116.f71861d = r113;
            int r107 = s1.y();
            int r108 = s1.w();
            View r109 = r116.f71877t;
            if (r109 == null) goto L30;
            ViewGroup.LayoutParams r117 = r109.getLayoutParams();
            if (r117 == null) goto L30;
            float r118 = r117.height;
        L31:
            RecyclerView r119 = r116.f71865h;
            ViewGroup.LayoutParams r120 = null;
            if (r119 == null) goto L34;
            ViewGroup.LayoutParams r121 = r119.getLayoutParams();
        L36:
            if ((r121 instanceof ViewGroup.MarginLayoutParams) == true) goto L38;
            r121 = null;
        L38:
            ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
            if (r122 == null) goto L41;
            float r123 = r122.topMargin;
        L42:
            Button r124 = r116.f71864g;
            if (r124 == null) goto L45;
            ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        L47:
            if ((r125 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
            r120 = r125;
        L50:
            ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r120;
            if (r126 == null) goto L53;
            float r127 = r126.height;
        L54:
            if (r126 == null) goto L56;
            float r128 = r126.topMargin;
        L57:
            if (r126 == null) goto L59;
            float r129 = r126.bottomMargin;
        L60:
            Integer r130 = je0.d.h();
            if (r130 != null) goto L64;
        L65:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r131 = r113.d();
            float r132 = 0.0f;
            if (r131 == null) goto L68;
            float r133 = r131.b();
        L69:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r134 = r113.d();
            if (r134 == null) goto L72;
            r132 = r134.c();
        L72:
            float r135 = r133 / r132;
        L74:
            float r136 = s1.y() - (s1.f(64.0f) * 2);
            float r137 = r135 * r136;
            float r138 = r108;
            float r139 = r138 / r107;
            if (ya0.f121670a.getValue().booleanValue() == false) goto L82;
            if (r107 <= r108) goto L78;
        L81:
            r137 = (((((r138 - UtilityKotlinExtentionsKt.h(r116.f71878u)) - r118) - r123) - r127) - r128) - r129;
            r136 = (1 / r135) * r137;
            goto L82
        L78:
            if (r137 > r138) goto L81;
            if (r139 < r135) goto L81;
        L82:
            RecyclerView r140 = r116.f71865h;
            if (r140 == null) goto L87;
            ViewGroup.LayoutParams r141 = r140.getLayoutParams();
            if (r141 == null) goto L87;
            r141.width = (int) r136;
            r141.height = (int) r137;
        L87:
            this.f71885a.c();
            return;
        L68:
            r133 = 0.0f;
            goto L69
        L64:
            if (r130.intValue() != 28) goto L65;
            r135 = 1.4f;
            goto L74
        L59:
            r129 = UtilityKotlinExtentionsKt.h(34);
            goto L60
        L56:
            r128 = UtilityKotlinExtentionsKt.h(20);
            goto L57
        L53:
            r127 = UtilityKotlinExtentionsKt.h(44);
            goto L54
        L45:
            r125 = null;
            goto L47
        L41:
            r123 = UtilityKotlinExtentionsKt.h(18);
            goto L42
        L34:
            r121 = null;
        L30:
            r118 = UtilityKotlinExtentionsKt.h(20);
            goto L31
        L24:
            r113 = r111.f75661a;
            goto L25
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71886a;

        public i(AdjustGuestPositionDialog r100) {
            this.f71886a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            DATA r102 = r101.data;
            if (r102 == 0) goto L72;
            this.f71886a.f71870m = ((GetPositionPanelResponse) r102).getUserPosition();
            this.f71886a.f71873p = ((GetPositionPanelResponse) r101.data).getPositionMap();
            AdjustGuestPositionDialog r103 = this.f71886a;
            Map<Long, PositionItem> r104 = ((GetPositionPanelResponse) r101.data).getPositionMap();
            String r105 = AdjustGuestPositionDialog.b(r103.f71863f);
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r106 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
            int r107 = r103.f71862e;
            if (r107 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L7;
        L10:
            if (r104 == null) goto L15;
            Iterator<Map.Entry<Long, PositionItem>> r108 = r104.entrySet().iterator();
        L13:
            if (r108.hasNext() == false) goto L15;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a.add(r108.next().getValue());
        L15:
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r109 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f71984a;
        L16:
            if (r109 == null) goto L74;
            r103.f71875r = r109;
            r103.f71866i = new AdjustGuestPositionListAdapter(r103.getContext(), r103.f71862e, r103.f71875r, r103.f71860c);
            int r110 = r103.f71862e;
            boolean r111 = true;
            if (r110 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L21;
        L22:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r112 = r103.f71861d;
            if (r112 == null) goto L42;
            RecyclerView r113 = r103.f71865h;
            if (r113 == null) goto L42;
            Integer r114 = je0.d.h();
            if (r114 != null) goto L30;
        L32:
            int r115 = ug0.b.f549981a;
            Intrinsics.checkNotNullParameter(r112, "layoutConfig");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.a r116 = r112.c();
            if (r116 != null) goto L35;
        L37:
            boolean r117 = false;
        L38:
            if (r117 == false) goto L40;
            RecyclerView.LayoutManager r118 = new MultiLinkHeightFitRecyclerLayoutManager(r112);
        L41:
            r113.setLayoutManager(r118);
            goto L42
        L40:
            r118 = new MultiLinkWidthFitRecyclerLayoutManager(r112);
            goto L41
        L35:
            if (r116.e() != 2) goto L37;
            r117 = true;
            goto L38
        L30:
            if (r114.intValue() != 28) goto L32;
            r118 = new MultiLinkAudiHamletFitRecyclerLayoutManager(r112);
        L42:
            AdjustGuestPositionListAdapter r119 = r103.f71866i;
            if (r119 == null) goto L45;
            r119.f79045e = r103;
        L45:
            RecyclerView r120 = r103.f71865h;
            if (r120 == null) goto L48;
            r120.setAdapter(r119);
        L48:
            ALogger.i("AdjustGuestPositionDialog", "选中用户uid -> ".concat(r105));
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r121 = r103.f71875r;
            Intrinsics.checkNotNullParameter(r121, "adapterList");
            if (r105.length() == 0) goto L53;
            r111 = false;
        L53:
            if (r111 == true) goto L61;
            int r122 = r121.size();
            int r123 = 0;
        L56:
            if (r123 >= r122) goto L61;
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.multilink.base.model.c0) ListProtector.get(r121, r123)).getUserId().toString(), r105) == true) goto L62;
            r123 = r123 + 1;
        L62:
            r103.f71871n = r123;
            if (r123 != 10) goto L65;
            f2.c("麦位拉取失败，请重试", 0);
        L65:
            ALogger.i("AdjustGuestPositionDialog", "当前设置高亮位置 ： " + r103.f71871n);
            AdjustGuestPositionListAdapter r124 = r103.f71866i;
            if (r124 == null) goto L73;
            r124.f79044d = r103.f71871n;
            return;
        L73:
            return;
        L61:
            r123 = 10;
            goto L62
        L21:
            if (r110 != MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L42;
        L74:
            return;
        L7:
            if (r107 == MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L10;
            r109 = null;
            goto L16
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71887a;

        public j(AdjustGuestPositionDialog r100) {
            this.f71887a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "error");
            if ((r101 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r102 = (CustomApiServerException) r101;
            if (TextUtils.isEmpty(r102.getPrompt()) == true) goto L7;
            f2.c(r102.getPrompt(), 0);
        L7:
            int r103 = AdjustGuestPositionDialog.f71858v;
            ALogger.e("AdjustGuestPositionDialog", String.valueOf(r102.getErrorCode()));
        L9:
            AdjustGuestPositionDialog r104 = this.f71887a;
            Handler r105 = DialogLancet.resolveDialogHandler(r104);
            if (r105 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r104);
            r104.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r104);
            return;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r106 == null) goto L23;
            com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r104);
            throw th;
        L12:
            if (Looper.myLooper() == r105.getLooper()) goto L14;
            r105.post(DialogLancet.createDismissRunnable(r104));
            return;
        L8:
            int r107 = AdjustGuestPositionDialog.f71858v;
            ALogger.e("AdjustGuestPositionDialog", r101.getMessage());
            goto L9
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkmicAdjustPositionPingType f71889b;

        public k(AdjustGuestPositionDialog r100, LinkmicAdjustPositionPingType r101) {
            this.f71888a = r100;
            this.f71889b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
            if (this.f71889b != LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel) goto L6;
            AdjustGuestPositionDialog r102 = this.f71888a;
            ((g) r102.f71874q.getValue()).removeCallbacksAndMessages(null);
            r102.f71875r.clear();
            r102.f71868k.dispose();
            return;
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustGuestPositionDialog f71890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkmicAdjustPositionPingType f71891b;

        public l(AdjustGuestPositionDialog r100, LinkmicAdjustPositionPingType r101) {
            this.f71890a = r100;
            this.f71891b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "error");
            if ((r101 instanceof CustomApiServerException) == false) goto L5;
            int r102 = AdjustGuestPositionDialog.f71858v;
            ALogger.e("AdjustGuestPositionDialog", String.valueOf(((CustomApiServerException) r101).getErrorCode()));
        L7:
            if (this.f71891b != LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel) goto L10;
            AdjustGuestPositionDialog r103 = this.f71890a;
            ((g) r103.f71874q.getValue()).removeCallbacksAndMessages(null);
            r103.f71875r.clear();
            r103.f71868k.dispose();
            return;
        L10:
            return;
        L5:
            int r104 = AdjustGuestPositionDialog.f71858v;
            ALogger.e("AdjustGuestPositionDialog", r101.getMessage());
            goto L7
        }
    }

    static {
    }

    public final void c() {
        String r100 = b(this.f71863f);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (this.f71867j != null) goto L12;
        return;
    L12:
        if (r2.a(r100) == false) goto L14;
        Disposable r102 = ((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).getPositionPanel(this.f71867j.getId(), d5.c(r100), r100).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this), new j(this));
        this.f71868k.add(r102);
    L14:
        g r103 = (g) this.f71874q.getValue();
        if (r103 == null) goto L18;
        r103.sendEmptyMessageDelayed(5, 5000);
        return;
    L18:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        d(LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel);
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

    public static String b(int r100) {
        List<T> r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        if (r101 != 0) goto L5;
        return "0";
    L5:
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L21;
        ILinkPlayerInfoBridge r104 = (ILinkPlayerInfoBridge) ListProtector.get(r101, r103);
        if (r104 == null) goto L20;
        if (r104.getUserPositionFlex() != r100) goto L20;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) ListProtector.get(r101, r103);
        if (r105 == null) goto L26;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L27;
        String r107 = r106.getIdString();
        if (r107 != null) goto L19;
        return "0";
    L19:
        return r107;
    L27:
        return "0";
    L26:
        return "0";
    L20:
        r103 = r103 + 1;
        goto L6
    L21:
        return "0";
    }

    public final int a(com.bytedance.android.livesdk.multilink.base.model.c0 r100) {
        Map<Long, PositionItem> r101 = this.f71873p;
        if (r101 == null) goto L11;
        Iterator<Map.Entry<Long, PositionItem>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<Long, PositionItem> r103 = r102.next();
        if (r103.getValue().equals(r100) == false) goto L6;
        return (int) r103.getKey().longValue();
    L16:
        return 0;
    L11:
        return 0;
    }

    public final void d(LinkmicAdjustPositionPingType r100) {
        if (this.f71867j != null) goto L5;
        return;
    L5:
        Disposable r101 = ((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).pingAdjustPosition(this.f71867j.getId(), r100.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this, r100), new l(this, r100));
        this.f71868k.add(r101);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getId());
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.intValue() != R.id.confirm_btn_adjust_guest_position) goto L34;
        AdjustGuestPositionListAdapter r103 = this.f71866i;
        if (r103 == null) goto L13;
        com.bytedance.android.livesdk.multilink.base.model.c0 r104 = r103.f79046f;
    L14:
        if (r104 == null) goto L17;
        String r105 = b(this.f71870m);
        r101.put(r105, String.valueOf(a(r104)));
        ALogger.i("AdjustGuestPositionDialog", "即将换位的用户uid -> " + r105 + ", 即将换位的位置 ——> " + a(r104));
        this.f71872o = a(r104);
    L17:
        if (r104 == null) goto L27;
        int r106 = a(r104);
        int r107 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.f.f72000a;
        int r108 = this.f71863f;
        HashMap r109 = new HashMap();
        TalkRoomLogUtils.B0(r109, Integer.valueOf(je0.d.f()), null, 4);
        r109.put("seat_num", String.valueOf(r108));
        r109.put("to_seat_num", String.valueOf(r106));
        r109.put("is_guest", "1");
        Integer r110 = je0.d.h();
        if (r110 != null) goto L22;
    L24:
        String r111 = WakeupSoundEffectSettings.CLASSIC;
    L25:
        r109.put("play_layout", r111);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_order_submit", r109, new Object[]{IRoom.class, am2.x.class});
        goto L27
    L22:
        if (r110.intValue() != 28) goto L24;
        r111 = "avatar";
    L27:
        if (this.f71867j == null) goto L30;
        this.f71868k.add(((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).adjustPosition(this.f71867j.getId(), new JSONObject(r101).toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.a(this), new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.b(this)));
    L30:
        Button r112 = (Button) findViewById(R.id.confirm_btn_adjust_guest_position);
        if (r112 == null) goto L35;
        r112.setEnabled(false);
        return;
    L35:
        return;
    L13:
        r104 = null;
        goto L14
    L34:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        int r100 = this.f71859b;
        if (yg0.h.i(this.f71860c) == true) goto L5;
        int r101 = 0;
    L9:
        this.f71862e = r101;
        ALogger.i("AdjustGuestPositionDialog", "当前布局 -> " + this.f71862e);
        int r102 = this.f71862e;
        if (r102 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L12;
    L13:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_window_layout_adjust_guest_position, null));
    L14:
        Window r103 = getWindow();
        if (r103 == null) goto L22;
        r103.setGravity(80);
        int r104 = s1.y();
        int r105 = s1.w();
        if (ya0.f121670a.getValue().booleanValue() == false) goto L20;
        if (r104 <= r105) goto L20;
        int r106 = (int) (r105 - UtilityKotlinExtentionsKt.h(this.f71878u));
    L21:
        r103.setLayout(-1, r106);
    L20:
        r106 = -2;
    L22:
        this.f71877t = findViewById(R.id.title);
        Button r107 = (Button) findViewById(R.id.confirm_btn_adjust_guest_position);
        this.f71864g = r107;
        if (r107 == null) goto L25;
        r107.setOnClickListener(this);
    L25:
        this.f71865h = (RecyclerView) findViewById(R.id.rv_adjust_guest_position);
        Button r108 = this.f71864g;
        if (r108 == null) goto L28;
        r108.setBackgroundResource(R.drawable.ttlive_bg_adjust_guest_position_comfirm_btn_unselected);
    L28:
        Button r109 = this.f71864g;
        if (r109 == null) goto L31;
        r109.setEnabled(false);
    L31:
        int r111 = this.f71860c;
        if (r111 != 21) goto L34;
        int r112 = 27;
    L36:
        if (yg0.h.i(r112) == false) goto L38;
        Triple r113 = new Triple(0, 0, "AdjustGuestPositionDialog#onCreate");
        ln0.a r114 = yg0.h.f567472a;
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r112, 0, null, false, 0, false, null, r113, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION_REASON3), new h(this), null);
        return;
    L38:
        c();
        return;
    L34:
        r112 = r111;
        goto L36
    L12:
        if (r102 != MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L14;
    L5:
        if (r100 != 5) goto L7;
        r101 = MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal();
        goto L9
    L7:
        r101 = MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal();
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.adapter.b
    public final void onItemClick(int r100) {
        if (r100 != this.f71871n) goto L10;
        Button r101 = this.f71864g;
        if (r101 == null) goto L7;
        r101.setBackgroundResource(R.drawable.ttlive_bg_adjust_guest_position_comfirm_btn_unselected);
    L7:
        Button r102 = this.f71864g;
        if (r102 == null) goto L17;
        r102.setEnabled(false);
        return;
    L17:
        return;
    L10:
        Button r103 = this.f71864g;
        if (r103 == null) goto L13;
        r103.setBackgroundResource(R.drawable.ttlive_bg_adjust_guest_position_comfirm_btn_selected);
    L13:
        Button r104 = this.f71864g;
        if (r104 == null) goto L19;
        r104.setEnabled(true);
        return;
    }

    public AdjustGuestPositionDialog(Context r100, int r101, int r102, IRoom r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, true);
        this.f71859b = r101;
        this.f71860c = r102;
        this.f71863f = r104;
        this.f71867j = r103;
        CompositeDisposable r105 = new CompositeDisposable();
        this.f71868k = r105;
        this.f71869l = Disposables.disposed();
        this.f71874q = LazyKt.lazy(new AdjustGuestPositionDialog$weakHandler$2(this));
        this.f71875r = new ArrayList();
        this.f71878u = 70;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r106 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r106 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r107 = r106.getValue();
        if (r107 == null) goto L11;
        BehaviorSubject r108 = r107.a();
        if (r108 == null) goto L11;
        Disposable r109 = r108.subscribe(new a(this), b.f71880a);
        if (r109 == null) goto L11;
        r105.add(r109);
    L11:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r110 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r110 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r111 = r110.getValue();
        if (r111 == null) goto L20;
        BehaviorSubject r112 = r111.a();
        if (r112 == null) goto L20;
        Disposable r113 = r112.subscribe(new c(this), d.f71882a);
        if (r113 == null) goto L20;
        r105.add(r113);
    L20:
        TeamFightContext r114 = TeamFightContext.Companion.getContext();
        if (r114 == null) goto L29;
        com.bytedance.live.datacontext.k<StateMachine.c.b<com.bytedance.android.live.liveinteract.revenue.fight.e.b, com.bytedance.android.live.liveinteract.revenue.fight.e.a, Object>> r115 = r114.getStateChangeEffect();
        if (r115 == null) goto L29;
        PublishSubject r116 = r115.onEvent();
        if (r116 == null) goto L29;
        Disposable r117 = r116.subscribe(new e(this));
        if (r117 == null) goto L29;
        r105.add(r117);
    L29:
        this.f71876s = true;
    }
}
