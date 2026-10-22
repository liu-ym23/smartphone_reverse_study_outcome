package com.bytedance.android.livesdk.chatroom.record;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.u7;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdk.chatroom.widget.z0;
import com.bytedance.android.livesdk.config.bd0;
import com.bytedance.android.livesdk.config.hv;
import com.bytedance.android.livesdk.config.nb;
import com.bytedance.android.livesdk.config.rq;
import com.bytedance.android.livesdk.message.model.AdminRecordMessage;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.record.admin.AdminRecordManager;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\n\u000bB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/record/LiveRecordPreviewDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/chatroom/record/h;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/ss/ttm/player/MediaPlayer$OnCompletionListener;", "Lcom/ss/ttm/player/MediaPlayer$OnPreparedListener;", "Lcom/ss/ttm/player/MediaPlayer$OnErrorListener;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecordPreviewDialog extends LiveDialogFragment implements com.bytedance.android.livesdk.chatroom.record.h, SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, WeakHandler.IHandler {
    public static final /* synthetic */ int C = 0;
    public final c A;
    public boolean B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f108006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f108007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z0.b f108008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f108009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f108010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f108011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Room f108012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f108013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataCenter f108014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x f108015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f108016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f108017o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f108018p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f108019q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f108020r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Bitmap f108021s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f108022t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f108023u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f108024v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f108025w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f108026x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f108027y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CompositeDisposable f108028z;

    public static final class a {
    }

    public static final class b extends LiveBottomSheetDialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f108029a;

        public static final class a implements lm3.c.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f108030b;

            public a(b r100) {
                this.f108030b = r100;
            }

            @Override // lm3.c.a
            public final void onAction(lm3.d r100) {
                b.M0(this.f108030b);
            }
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.content.DialogInterface
        public final void cancel() {
            lm3.d.a r100 = new lm3.d.a(this.f108029a);
            r100.f509870a = this.f108029a.getString(R.string.ttlive_record_exit_dialog_title);
            r100.f509871b = this.f108029a.getString(R.string.ttlive_record_exit_dialog_content);
            lm3.c r101 = new lm3.c();
            r101.f509864b = this.f108029a.getString(R.string.ttlive_record_exit_dialog_confirm);
            r101.f509865c = new a(this);
            Unit r102 = Unit.INSTANCE;
            lm3.c r103 = new lm3.c();
            r103.f509864b = this.f108029a.getString(R.string.ttlive_record_exit_dialog_think);
            r103.f509865c = lm3.c.a.f509867a;
            r100.f509874e = CollectionsKt.listOf(new lm3.c[]{r101, r103});
            r100.a();
        }

        public static final void M0(b r100) {
            super.cancel();
        }

        public b(FragmentActivity r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            super(r100, r101);
            this.f108029a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRecordPreviewDialog f108031a;

        public final void a() {
            x r100 = this.f108031a.f108015m;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isPlaying() != true) goto L17;
            x r101 = this.f108031a.f108015m;
            if (r101 == null) goto L9;
            int r102 = r101.getCurrentPosition();
        L10:
            LiveRecordPreviewDialog r103 = this.f108031a;
            if (r103.isVisible() == false) goto L14;
            String r104 = p6.a(((long) r102) / 1000);
            String r105 = p6.a(((long) r103.f108016n) / 1000);
            ((TextView) r103.S90(R.id.video_time)).setText(r104 + '/' + r105);
        L14:
            this.f108031a.Y90().postDelayed(this, 1000);
            return;
        L9:
            r102 = 0;
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LiveRecordPreviewDialog r100) {
            this.f108031a = r100;
        }
    }

    public static final class d implements jz.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f108032a;

        public d(Function0 r100) {
            this.f108032a = r100;
        }
    }

    public static final class e implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f108033a = null;

        static {
            f108033a = new e();
        }

        public e() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static final class f implements com.bytedance.android.livesdk.pannel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f108034a;

        public static final class a implements lm3.c.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0 f108035b;

            public a(Function0 r100) {
                this.f108035b = r100;
            }

            @Override // lm3.c.a
            public final void onAction(lm3.d r100) {
                this.f108035b.invoke();
            }
        }

        public f(FragmentActivity r100) {
            this.f108034a = r100;
        }

        @Override // com.bytedance.android.livesdk.pannel.a
        public final void I2(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onConfirm");
            lm3.d.a r101 = new lm3.d.a(this.f108034a);
            r101.f509870a = this.f108034a.getString(R.string.ttlive_record_exit_dialog_title);
            r101.f509871b = this.f108034a.getString(R.string.ttlive_record_exit_dialog_content);
            lm3.c r102 = new lm3.c();
            r102.f509864b = this.f108034a.getString(R.string.ttlive_record_exit_dialog_confirm);
            r102.f509865c = new a(r100);
            Unit r103 = Unit.INSTANCE;
            lm3.c r104 = new lm3.c();
            r104.f509864b = this.f108034a.getString(R.string.ttlive_record_exit_dialog_think);
            r104.f509865c = lm3.c.a.f509867a;
            r101.f509874e = CollectionsKt.listOf(new lm3.c[]{r102, r104});
            r101.a();
        }
    }

    public static final class g implements jz.b {
        public g() {
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRecordPreviewDialog f108036a;

        public h(LiveRecordPreviewDialog r100) {
            this.f108036a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveRecordPreviewDialog.U90(this.f108036a);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRecordPreviewDialog f108037a;

        public i(LiveRecordPreviewDialog r100) {
            this.f108037a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveRecordPreviewDialog.T90(this.f108037a);
        }
    }

    static {
    }

    public final WeakHandler Y90() {
        return (WeakHandler) this.f108017o.getValue();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public final void aa0() {
        if (Intrinsics.areEqual(this.f108027y, Boolean.TRUE) == false) goto L5;
        ((TextView) S90(R.id.text_primary_button)).setText(R.string.ttlive_record_btn_save_draft);
        ((ImageView) S90(R.id.icon_primary_button)).setImageResource(R.drawable.ttlive_ic_record_save_draft);
        ((ConstraintLayout) S90(R.id.primary_button)).setOnClickListener(new h(this));
        return;
    L5:
        ((TextView) S90(R.id.text_primary_button)).setText(R.string.ttlive_record_publish_video);
        ((ImageView) S90(R.id.icon_primary_button)).setImageResource(R.drawable.ttlive_ic_record_publish_video);
        ((ConstraintLayout) S90(R.id.primary_button)).setOnClickListener(new i(this));
    }

    public LiveRecordPreviewDialog() {
        this.f108006d = new LinkedHashMap();
        this.f108007e = LazyKt.lazy(new LiveRecordPreviewDialog$progressDialog$2(this));
        this.f108009g = "";
        this.f108010h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f108011i = true;
        this.f108013k = true;
        this.f108017o = LazyKt.lazy(new LiveRecordPreviewDialog$handler$2(this));
        this.f108022t = true;
        this.f108027y = Boolean.FALSE;
        this.f108028z = new CompositeDisposable();
        this.A = new c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f108028z.clear();
        x r100 = this.f108015m;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        x r101 = this.f108015m;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f108006d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        S90(R.id.video_player_btn).setVisibility(0);
        x r100 = this.f108015m;
        if (r100 == null) goto L5;
        r100.pause();
    L5:
        S90(R.id.first_frame).setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ((SurfaceView) S90(R.id.video)).getHolder().addCallback(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.record.h
    public final boolean p() {
        if (isShowing() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAdded() == true) goto L8;
        return false;
    }

    public static final void T90(final LiveRecordPreviewDialog r100) {
        r100.getClass();
        ALogger.d("LiveRecordPreviewDialog", "publish video file:" + r100.f108009g);
        if (((IHostBusiness) jc1.k.n(IHostBusiness.class)).videoIsPublishable() == true) goto L5;
        f2.b(R.string.ttlive_record_not_publishable_toast, 0);
        return;
    L5:
        Pair[] r101 = new Pair[1];
        if ((!e5.n()) == false) goto L8;
        String r102 = "0";
    L9:
        r101[0] = TuplesKt.to("room_orientation", r102);
        HashMap r103 = MapsKt.hashMapOf(r101);
        AdminRecordManager.k(r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_record_publish", r103, new Object[]{Room.class, new am2.x()});
        r100.W90(new LiveRecordPreviewDialog$doDirectPublishVideo$1(r100));
        return;
    L8:
        r102 = "1";
        goto L9
    }

    public static final void U90(final LiveRecordPreviewDialog r100) {
        r100.getClass();
        ALogger.d("LiveRecordPreviewDialog", "save draft file:" + r100.f108009g);
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        HashMap r102 = new HashMap();
        AdminRecordManager.k(r102);
        if ((!e5.n()) == false) goto L5;
        String r103 = "0";
    L6:
        r102.put("room_orientation", r103);
        Unit r104 = Unit.INSTANCE;
        r101.sendLog("livesdk_draft_save", r102, new Object[]{Room.class, new am2.x()});
        r100.W90(new LiveRecordPreviewDialog$doSaveDraft$2(r100));
        return;
    L5:
        r103 = "1";
        goto L6
    }

    public final View S90(int r100) {
        if (this.f108006d != null) goto L5;
        this.f108006d = new LinkedHashMap();
    L5:
        View r101 = this.f108006d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f108006d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void W90(Function0<Unit> r100) {
        if (getContext() != null) goto L5;
        return;
    L5:
        IHostBusiness r101 = (IHostBusiness) jc1.k.n(IHostBusiness.class);
        Context r102 = getContext();
        jz.f r103 = new jz.f();
        String r104 = this.f108009g;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f501074c = r104;
        r103.f501075d = 360000;
        Unit r105 = Unit.INSTANCE;
        r101.checkImportVideo(r102, r103, new d(r100));
    }

    public final void ba0(boolean r100) {
        if (r100 == true) goto L24;
        if (((u7) this.f108007e.getValue()).isShowing() == false) goto L22;
        u7 r101 = (u7) this.f108007e.getValue();
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    L22:
        return;
    L24:
        if (((u7) this.f108007e.getValue()).isShowing() == true) goto L39;
        u7 r104 = (u7) this.f108007e.getValue();
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L35;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L35:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        Integer r101 = null;
        if (r100 == null) goto L13;
        Object r102 = r100.obj;
    L15:
        if ((r102 instanceof Uri) == true) goto L17;
        r102 = null;
    L17:
        Uri r103 = (Uri) r102;
        if (r100 == null) goto L21;
        r101 = Integer.valueOf(r100.what);
    L21:
        if (r101 != null) goto L24;
    L36:
        if (r101 != null) goto L39;
        return;
    L39:
        if (r101.intValue() != 1) goto L59;
        if (r103 != null) goto L45;
        z0.b r104 = this.f108008f;
        if (r104 == null) goto L56;
        ((LiveRecordWidget.e) r104).a(r100.obj);
        return;
    L56:
        return;
    L45:
        Context r105 = getContext();
        if (r105 == null) goto L48;
        r105.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r103));
    L48:
        this.f108019q = true;
        ILiveActionHandler r106 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);
        if (r106 == null) goto L51;
        r106.handle(getContext(), "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fanchor_center_pages%2Ftemplate%2Findex.html?enter_from=audience_live_record&hide_nav_bar=1&hide_status_bar=0&status_bar_color=white");
    L51:
        View r107 = getView();
        if (r107 == null) goto L60;
        r107.postDelayed(l.f108067a, 300);
        return;
    L60:
        return;
    L59:
        return;
    L24:
        if (r101.intValue() != 0) goto L36;
        if (r103 != null) goto L30;
        f2.b(R.string.ttlive_live_record_save_failed, 0);
        z0.b r108 = this.f108008f;
        if (r108 == null) goto L55;
        ((LiveRecordWidget.e) r108).a(r100.obj);
        return;
    L55:
        return;
    L30:
        Context r109 = getContext();
        if (r109 == null) goto L33;
        r109.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r103));
    L33:
        f2.b(R.string.ttlive_live_record_save_success, 0);
        this.f108019q = true;
        z0.b r110 = this.f108008f;
        if (r110 == null) goto L57;
        ((LiveRecordWidget.e) r110).b();
        return;
    L57:
        return;
    L13:
        r102 = null;
        goto L15
    L8:
        if (r100.what != 1) goto L10;
    L9:
        this.f108018p = false;
        ba0(false);
        goto L10
    L5:
        if (r100.what == 0) goto L9;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L19;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L20;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        if (PadConfigUtils.c() == false) goto L9;
        return;
    L9:
        if (this.f108011i == false) goto L11;
        r102.setLayout(-1, -2);
        r102.setGravity(80);
        return;
    L11:
        boolean r103 = !e5.n();
        int r104 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r103) == false) goto L14;
        r102.setLayout((int) UtilityKotlinExtentionsKt.h(480.0f), -1);
    L15:
        r102.setGravity(GravityCompat.END);
        setBottomSheetSlideProcessor(e.f108033a);
        View r105 = getView();
        if (r105 == null) goto L23;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.height = s1.w();
        r105.setLayoutParams(r106);
        return;
    L23:
        return;
    L14:
        r102.setLayout((int) UtilityKotlinExtentionsKt.h(375.0f), -1);
        goto L15
    L20:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        r100.start();
        this.f108016n = r100.getDuration();
        Y90().post(this.A);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f108011i == false) goto L5;
        setStyle(1, R.style.ttlive_record_preview_bottom_dialog);
    L6:
        this.B = false;
        DataCenter r101 = this.f108014l;
        if (r101 == null) goto L9;
        Boolean r102 = (Boolean) r101.get("from_promote_live", Boolean.FALSE);
    L10:
        this.f108027y = r102;
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        setStyle(1, R.style.ttlive_record_preview_right_dialog);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r110) {
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        FragmentActivity r100 = getActivity();
        Intrinsics.checkNotNull(r100);
        Dialog r111 = new LiveStandardSheetDialog(r100, false, false, false, false, 28);
    L10:
        if ((r111 instanceof SheetBaseDialog) == false) goto L14;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L14;
        f r102 = new f(r101);
        ((SheetBaseDialog) r111).f154345j = r102;
    L14:
        r111.requestWindowFeature(1);
        r111.setCanceledOnTouchOutside(true);
        return r111;
    L5:
        if (bd0.f119859a.getValue().booleanValue() == true) goto L8;
        FragmentActivity r103 = getActivity();
        Intrinsics.checkNotNull(r103);
        r111 = new b(r103, getTheme());
        goto L10
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L8
        if (this.B == true) goto L5;
        com.bytedance.android.livesdk.service.l.d().e().deleteLastVideo();     // Catch: Throwable -> L8
    L5:
        super.onDismiss(r100);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L8;
        return;
    L8:
        if (this.f108021s != null) goto L16;
        MediaMetadataRetriever r101 = new MediaMetadataRetriever();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        r101.setDataSource(this.f108009g);     // Catch: Throwable -> L13
        this.f108021s = r101.getFrameAtTime(0, 3);     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        if (this.f108021s != null) goto L18;
    L20:
        this.f108022t = false;
        this.f108020r = true;
        return;
    L18:
        if (this.f108022t == false) goto L20;
        BitmapDrawable r104 = new BitmapDrawable(getResources(), this.f108021s);
        S90(R.id.first_frame).setBackground(r104);
        S90(R.id.first_frame).setVisibility(0);
        goto L20
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        x r101 = this.f108015m;
        if (r101 == null) goto L6;
        r101.stop();
        return;
    }

    public static final void V90(final LiveRecordPreviewDialog r100, final Function0 r110) {
        final int r101 = 0;
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r100.X90(0, r110);
        return;
    L5:
        Activity r102 = ContextUtil.contextToActivity(r100.getContext());
        if (r102 == null) goto L10;
        TimonMedia.withWritePermission$default(r102, new TimonMedia.ExtraInfo("bpea-live_LiveRecordPreviewDialog_doSaveVideoBefore", true, true, 24), null, new LiveRecordPreviewDialog$doSaveVideoBefore$$inlined$let$lambda$1(r100, r101, r110), 4, null);
        return;
    }

    public final void X90(final int r110, Function0<Unit> r111) {
        ALogger.d("LiveRecordPreviewDialog", "save local file:" + this.f108009g);
        if (this.f108018p == false) goto L6;
        return;
    L6:
        if (this.f108019q == false) goto L9;
        r111.invoke();
        return;
    L9:
        this.f108018p = true;
        ba0(true);
        if (nb.f120818a.getValue().booleanValue() == false) goto L18;
        com.bytedance.android.livesdk.chatroom.record.d r100 = new com.bytedance.android.livesdk.chatroom.record.d();
        String r101 = this.f108009g;
        Room r112 = this.f108012j;
        if (r112 == null) goto L14;
        long r102 = r112.f162599id;
    L15:
        Disposable r113 = r100.b(r101, r102, this.f108025w, this.f108026x, new LiveRecordPreviewDialog$doSaveVideo$1(this, r110));
        if (r113 == null) goto L20;
        RxUtilKt.c(r113, this.f108028z);
        return;
    L20:
        return;
    L14:
        r102 = -1;
        goto L15
    L18:
        new a0(Y90(), r110).execute1(new String[]{this.f108009g});
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        boolean r100 = true;
        if (PadConfigUtils.c() == true) goto L7;
        boolean r112 = !e5.n();
        int r101 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r112) == false) goto L7;
        S90(R.id.finish_record_panel_view).setVisibility(0);
        S90(R.id.finish_record_panel_view).setBackground(s1.m(R.drawable.ttlive_bg_base_panel_gradient_new));
        S90(R.id.finish_record_panel_view).setOnClickListener(new j(this));
    L7:
        Boolean r113 = this.f108027y;
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r113, r102) == false) goto L11;
        ((TextView) S90(R.id.text_primary_button)).setText(R.string.ttlive_record_btn_save_draft);
        ((ImageView) S90(R.id.icon_primary_button)).setImageResource(R.drawable.ttlive_ic_record_save_draft);
        ((ConstraintLayout) S90(R.id.primary_button)).setOnClickListener(new o(this));
    L18:
        if (this.f108013k == false) goto L25;
        if (tb1.c.f545229a == true) goto L22;
    L23:
        ((ConstraintLayout) S90(R.id.secondary_button)).setVisibility(8);
    L33:
        ArrayList<AdminRecordMessage> r114 = AdminRecordManager.f157056a;
        boolean r115 = tb1.c.f545229a;
        if (r115 == true) goto L36;
    L38:
        boolean r103 = false;
    L39:
        if (r103 == true) goto L41;
    L48:
        View r104 = S90(R.id.save_draft_top);
        if (this.f108013k == false) goto L51;
        if (r115 == false) goto L51;
    L61:
        UtilityKotlinExtentionsKt.z(r104, r100);
        if (((TextView) S90(R.id.save_draft_top)).getVisibility() != 0) goto L65;
        ((TextView) S90(R.id.save_draft_top)).setOnClickListener(new m(this));
    L65:
        if (Intrinsics.areEqual(this.f108027y, r102) == false) goto L68;
        ((TextView) S90(R.id.text_video_message)).setVisibility(0);
        ((TextView) S90(R.id.text_video_message)).setText(getString(R.string.ttlive_record_task_preview_hint));
        ((TextView) S90(R.id.text_video_message)).setTextSize(13.0f);
        getContext();
        TextView r116 = (TextView) S90(R.id.text_video_message);
        Context r117 = getContext();
        Intrinsics.checkNotNull(r117);
        r116.setTextColor(ContextCompat.getColor(r117, R.color.white));
        ((TextView) S90(R.id.save_draft_top)).setVisibility(8);
    L68:
        if (this.f108011i == false) goto L70;
        int r118 = 108;
    L71:
        S90(R.id.video_background).getLayoutParams().height = s1.f(r118 * (this.f108024v / this.f108023u));
        ((SurfaceView) S90(R.id.video)).setOnClickListener(new k(this));
        return;
    L70:
        r118 = 249;
    L51:
        if (r115 == true) goto L53;
    L55:
        boolean r119 = false;
    L56:
        if (r119 == true) goto L58;
    L60:
        r100 = false;
        goto L61
    L58:
        if (AdminRecordManager.h(this.f108014l) == false) goto L60;
    L53:
        if (hv.f120406a.getValue().booleanValue() == false) goto L55;
        r119 = true;
        goto L56
    L41:
        if (this.f108013k == false) goto L43;
    L44:
        ((ConstraintLayout) S90(R.id.secondary_button)).setVisibility(0);
        ((TextView) S90(R.id.text_secondary_button)).setText(R.string.ttlive_share_fans_group);
        ((ImageView) S90(R.id.icon_secondary_button)).setImageResource(R.drawable.ttlive_ic_share_fans_group);
        ((ConstraintLayout) S90(R.id.secondary_button)).setOnClickListener(new n(this));
    L46:
        if (AdminRecordManager.h(this.f108014l) == false) goto L48;
        aa0();
        goto L48
    L43:
        if (AdminRecordManager.h(this.f108014l) == false) goto L46;
    L36:
        if (hv.f120406a.getValue().booleanValue() == false) goto L38;
        r103 = true;
        goto L39
    L22:
        if (rq.f121150a.getValue().booleanValue() == false) goto L23;
    L25:
        if (this.f108013k == true) goto L30;
        if (tb1.c.f545229a == false) goto L30;
        ((ConstraintLayout) S90(R.id.secondary_button)).setVisibility(0);
        ((TextView) S90(R.id.text_secondary_button)).setText(R.string.ttlive_record_header_save_draft);
        ((ImageView) S90(R.id.icon_secondary_button)).setImageResource(R.drawable.ttlive_ic_record_save_draft);
        ((ConstraintLayout) S90(R.id.secondary_button)).setOnClickListener(new q(this));
    L30:
        if (Intrinsics.areEqual(this.f108027y, r102) == false) goto L32;
        ((ConstraintLayout) S90(R.id.secondary_button)).setVisibility(0);
        ((TextView) S90(R.id.text_secondary_button)).setText(R.string.ttlive_record_save_local);
        ((ImageView) S90(R.id.icon_secondary_button)).setImageResource(R.drawable.ttlive_ic_record_save_local);
        ((ConstraintLayout) S90(R.id.secondary_button)).setOnClickListener(new LiveRecordPreviewDialog$setupSecondaryButton$2(this));
        goto L33
    L32:
        ((ConstraintLayout) S90(R.id.secondary_button)).setVisibility(0);
        ((TextView) S90(R.id.text_secondary_button)).setText(R.string.ttlive_record_btn_save_draft);
        ((ImageView) S90(R.id.icon_secondary_button)).setImageResource(R.drawable.ttlive_ic_record_save_draft);
        ((ConstraintLayout) S90(R.id.secondary_button)).setOnClickListener(new r(this));
        goto L33
    L11:
        if (this.f108013k == false) goto L14;
        ((TextView) S90(R.id.text_primary_button)).setText(R.string.ttlive_record_save_local);
        ((ImageView) S90(R.id.icon_primary_button)).setImageResource(R.drawable.ttlive_ic_record_save_local);
        ((ConstraintLayout) S90(R.id.primary_button)).setOnClickListener(new LiveRecordPreviewDialog$setupPrimaryButton$2(this));
        goto L18
    L14:
        if (tb1.c.f545229a == false) goto L16;
        ((TextView) S90(R.id.text_primary_button)).setText(R.string.ttlive_text_direct_publish);
        ((ImageView) S90(R.id.icon_primary_button)).setImageResource(R.drawable.ttlive_ic_record_publish_video);
        ((ConstraintLayout) S90(R.id.primary_button)).setOnClickListener(new p(this));
        goto L18
    L16:
        aa0();
        goto L18
    }

    public final void Z90(int r110, String r111, boolean r112) {
        com.bytedance.android.livesdk.service.l.d().e().removeVideo(r111);
        boolean r113 = true;
        if (r110 != 1) goto L5;
        xs2.b.a().post(new h1(32));
    L5:
        DataCenter r100 = this.f108014l;
        String r101 = null;
        if (r100 == null) goto L8;
        String r102 = (String) r100.get("data_enter_extra_public_mission", "");
    L9:
        IHostBusiness r103 = (IHostBusiness) jc1.k.n(IHostBusiness.class);
        Context r104 = getContext();
        jz.f r105 = new jz.f();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r105.f501074c = r111;
        Room r114 = this.f108012j;
        if (r114 == null) goto L12;
        User r115 = r114.mo8271getOwner();
    L13:
        r105.f501072a = r115;
        r105.f501073b = r110;
        RectF r116 = this.f108010h;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r105.f501076e = r116;
        r105.f501077f = this.f108012j;
        r105.f501078g = this.f108013k;
        r105.f501079h = this.f108025w;
        r105.f501080i = this.f108026x;
        r105.f501075d = 360000;
        ArrayList<AdminRecordMessage> r117 = AdminRecordManager.f157056a;
        DataCenter r118 = this.f108014l;
        if (r118 == null) goto L16;
        LiveMode r106 = (LiveMode) r118.get("data_live_mode", null);
    L17:
        List r107 = CollectionsKt.listOf(new String[]{LiveMode.VIDEO.getLogStreamingType(), LiveMode.AUDIO.getLogStreamingType(), LiveMode.THIRD_PARTY.getLogStreamingType()});
        if (r106 != null) goto L20;
    L29:
        if (r102 != null) goto L31;
    L34:
        if (r113 == true) goto L37;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
    L37:
        if (Intrinsics.areEqual(this.f108027y, Boolean.TRUE) == false) goto L62;
        if (r110 != 2) goto L62;
        DataCenter r119 = this.f108014l;
        if (r119 == null) goto L42;
        LiveHashTag r120 = (LiveHashTag) r119.get("cmd_update_live_challenge", null);
    L43:
        StringBuilder r121 = new StringBuilder();
        if (r120 == null) goto L46;
        String r122 = r120.getName();
    L48:
        if (TextUtils.isEmpty(r122) == true) goto L54;
        r121.append("#");
        if (r120 == null) goto L52;
        String r123 = r120.getName();
    L53:
        r121.append(Intrinsics.stringPlus(r123, " "));
        goto L54
    L52:
        r123 = null;
    L54:
        r121.append(getString(R.string.ttlive_join_national_mission) + ",");
        r121.append(getString(R.string.ttlive_win_cash_prize_and_join_us));
        JSONObject r124 = new JSONObject();
        if (r120 == null) goto L57;
        String r108 = r120.getTaskId();
    L58:
        r124.putOpt("task_id", String.valueOf(r108));
        if (r120 == null) goto L61;
        r101 = r120.getTaskId();
    L61:
        r124.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_PUBLIC_MISSION_BUNDLE, String.valueOf(r101));
        r124.putOpt("mission_type", "3");
        Intrinsics.checkNotNullParameter(r124.toString(), "<set-?>");
        Intrinsics.checkNotNullParameter(r121.toString(), "<set-?>");
        goto L62
    L57:
        r108 = null;
        goto L58
    L46:
        r122 = null;
        goto L48
    L42:
        r120 = null;
    L62:
        Unit r125 = Unit.INSTANCE;
        r103.publishVideo(r104, r105, new g());
        dismiss();     // Catch: Exception -> L65
        return;
    L65:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r126 = DialogFragmentLancet.sLastShowStack;
        if (r126 == null) goto L72;
        com.bytedance.crash.d.d(r126, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L72:
        return;
    L31:
        if (r102.length() == 0) goto L34;
        r113 = false;
        goto L34
    L20:
        if (r107.contains(r106.getLogStreamingType()) == false) goto L29;
        if (r118 == null) goto L29;
        User r127 = (User) r118.get("data_user_in_room", null);
        if (r127 == null) goto L29;
        py.t r128 = r127.getUserAttr();
        if (r128 == null) goto L29;
        r128.isAdmin();
        goto L29
    L16:
        r106 = null;
        goto L17
    L12:
        r115 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (PadConfigUtils.c() == false) goto L6;
        int r103 = R.layout.ttlive_dialog_live_record_preview_hd;
    L9:
        View r104 = r100.inflate(r103, r101, false);
        if (PadConfigUtils.c() == true) goto L15;
        boolean r105 = !e5.n();
        int r106 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r105) == false) goto L15;
        if (r104 == null) goto L15;
        r104.setBackground(s1.m(R.drawable.ttlive_bg_base_panel_gradient_new));
    L15:
        return r104;
    L6:
        if (this.f108011i == false) goto L8;
        r103 = R.layout.ttlive_dialog_live_record_preview;
        goto L9
    L8:
        r103 = R.layout.ttlive_dialog_live_record_preview_land;
        goto L9
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r100, int r101, int r102) {
        ALogger.e("LiveRecordPreviewDialog", "MediaPlayer onError, what = " + r101 + " extra = " + r102 + " ,fileExist=" + FileUtils.checkFileExists(this.f108009g));
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f108015m = null;
        f2.b(R.string.ttlive_live_record_video_play_failed, 0);
        return false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        x r104 = this.f108015m;
        if (r104 == null) goto L5;
        r104.reset();
    L6:
        x r105 = this.f108015m;
        if (r105 == null) goto L31;
        r105.setSurface(r100.getSurface());
    L31:
        x r106 = this.f108015m;     // Catch: IOException -> L28
        if (r106 == null) goto L12;
        r106.setIntOption(36, 1);     // Catch: IOException -> L28
    L12:
        x r107 = this.f108015m;     // Catch: IOException -> L28
        if (r107 == null) goto L15;
        r107.setOnCompletionListener(this);     // Catch: IOException -> L28
    L15:
        x r108 = this.f108015m;     // Catch: IOException -> L28
        if (r108 == null) goto L18;
        r108.setOnPreparedListener(this);     // Catch: IOException -> L28
    L18:
        x r109 = this.f108015m;     // Catch: IOException -> L28
        if (r109 == null) goto L21;
        r109.setOnErrorListener(this);     // Catch: IOException -> L28
    L21:
        x r110 = this.f108015m;     // Catch: IOException -> L28
        if (r110 == null) goto L24;
        r110.setDataSource(this.f108009g);     // Catch: IOException -> L28
    L24:
        x r111 = this.f108015m;     // Catch: IOException -> L28
        if (r111 == null) goto L33;
        r111.prepareAsync();     // Catch: IOException -> L28
        return;
    L33:
        return;
    L28:
        e = move-exception;
        this.f108015m = null;
        Logger.e("LiveRecordPreviewDialog", e.toString());
        f2.b(R.string.ttlive_live_record_video_play_failed, 0);
        ALogger.e("LiveRecordPreviewDialog", "surfaceChanged-exception", e);
        return;
    L5:
        this.f108015m = x.b(getContext());
        goto L6
    }
}
