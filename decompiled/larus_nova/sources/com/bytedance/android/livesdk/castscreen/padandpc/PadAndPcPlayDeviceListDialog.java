package com.bytedance.android.livesdk.castscreen.padandpc;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.castscreen.guide.PadAndPcPlayGuideNew;
import com.bytedance.android.livesdk.castscreen.padandpc.adapter.PadAndPcDeviceListAdapter;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcLogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.q61;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import jta.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/PadAndPcPlayDeviceListDialog;", "Lcom/bytedance/android/livesdk/castscreen/views/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAndPcPlayDeviceListDialog extends com.bytedance.android.livesdk.castscreen.views.a implements Observer<KVData> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f104624w = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f104625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f104626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f104627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f104628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f104629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f104630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f104631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f104632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f104633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HSImageView f104634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f104635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.livesdk.castscreen.guide.d f104636n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PadAndPcDeviceListAdapter f104637o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f104638p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.castscreen.padandpc.vm.a f104639q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeDisposable f104640r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f104641s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f104642t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f104643u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f104644v;

    public final boolean d() {
        return ((Boolean) this.f104644v.getValue()).booleanValue();
    }

    public final void f() {
        boolean r100 = false;
        a(false);
        c();
        RecyclerView r101 = this.f104631i;
        ViewGroup r102 = null;
        if (r101 == null) goto L14;
        if (r101.getVisibility() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r101);
        goto L14
    L7:
        r103 = false;
    L14:
        if (((q61) this.f104641s.getValue()).a() == false) goto L35;
        FrameLayout r104 = this.f104633k;
        if (r104 != null) goto L18;
    L26:
        ViewGroup r105 = this.f104630h;
        if (r105 != null) goto L29;
        return;
    L29:
        if (r105.getVisibility() != 0) goto L31;
        r100 = true;
    L31:
        if (r100 == false) goto L33;
        r102 = r105;
    L33:
        if (r102 == null) goto L57;
        UtilityKotlinExtentionsKt.t(r102);
        return;
    L57:
        return;
    L18:
        if (r104.getVisibility() == 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r104);
        goto L26
    L20:
        r106 = false;
        goto L21
    L35:
        FrameLayout r107 = this.f104633k;
        if (r107 != null) goto L38;
    L46:
        ViewGroup r108 = this.f104630h;
        if (r108 != null) goto L49;
        return;
    L49:
        if (r108.getVisibility() == 0) goto L51;
        r100 = true;
    L51:
        if (r100 == false) goto L53;
        r102 = r108;
    L53:
        if (r102 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r102);
        return;
    L60:
        return;
    L38:
        if (r107.getVisibility() != 0) goto L40;
        boolean r109 = true;
    L41:
        if (r109 == true) goto L44;
        r107 = null;
    L44:
        if (r107 == null) goto L46;
        UtilityKotlinExtentionsKt.t(r107);
        goto L46
    L40:
        r109 = false;
        goto L41
    }

    public final void b() {
        ViewGroup r100 = this.f104630h;
        FrameLayout r101 = null;
        boolean r102 = true;
        if (r100 != null) goto L5;
    L13:
        FrameLayout r103 = this.f104633k;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.getVisibility() == 0) goto L19;
        r102 = false;
    L19:
        if (r102 == false) goto L21;
        r101 = r103;
    L21:
        if (r101 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r101);
        return;
    L25:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r100);
        goto L13
    L7:
        r104 = false;
        goto L8
    }

    public final void c() {
        ViewGroup r100 = this.f104628f;
        boolean r101 = true;
        ImageView r102 = null;
        if (r100 != null) goto L5;
    L13:
        LiveDoubleColorBallAnimationView r103 = this.f104629g;
        if (r103 != null) goto L16;
    L21:
        ImageView r104 = this.f104626d;
        if (r104 != null) goto L24;
        return;
    L24:
        if (r104.getVisibility() != 0) goto L27;
        r101 = false;
    L27:
        if (r101 == false) goto L29;
        r102 = r104;
    L29:
        if (r102 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r102);
        return;
    L33:
        return;
    L16:
        if (r103.a() == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L21;
        r103.c();
        goto L21
    L5:
        if (r100.getVisibility() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r100);
        goto L13
    L7:
        r105 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.a, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f104640r.clear();
        com.bytedance.android.livesdk.castscreen.guide.d r100 = this.f104636n;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        PadAndPcDeviceListAdapter r101 = this.f104637o;
        if (r101 == null) goto L8;
        r101.f104649d.clear();
    L8:
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r102 = this.f104639q;
        if (r102 == null) goto L11;
        r102.release();
    L11:
        DataCenter r103 = this.f104638p;
        if (r103 == null) goto L14;
        r103.removeObserver(this);
    L14:
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(this);
        return;
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r105 == null) goto L28;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        goto L28
    L17:
        if (Looper.myLooper() == r104.getLooper()) goto L19;
        r104.post(DialogLancet.createDismissRunnable(this));
    }

    public final void e() {
        DataCenter r100 = this.f104638p;
        if (r100 == null) goto L30;
        Room r101 = z.o(r100);
        if (r101 == null) goto L31;
        long r102 = r101.f162599id;
        DataCenter r103 = this.f104638p;
        if (r103 == null) goto L32;
        Room r104 = z.o(r103);
        if (r104 == null) goto L33;
        String r105 = r104.getOwnerUserIdString();
        if (r105 == null) goto L35;
        LivePadPcLogger.a("livesdk_screen_share_search_start", this.f104638p, PadAndPcPlayDeviceListDialog$scanDevices$1.INSTANCE);
        LivePadPcLogger.c("continued_broadcast_searching", this.f104638p, PadAndPcPlayDeviceListDialog$scanDevices$2.INSTANCE);
        JSONObject r106 = new JSONObject();
        ii1.a r107 = (ii1.a) this.f104642t.getValue();
        String r108 = null;
        if (r107 == null) goto L16;
        String r109 = r107.h();
    L17:
        r106.put("enter_from_on_cellphone", r109);
        ii1.a r110 = (ii1.a) this.f104642t.getValue();
        if (r110 == null) goto L20;
        r108 = r110.b();
    L20:
        r106.put("previous_page_on_cellphone", r108);
        DataCenter r111 = this.f104638p;
        if (r111 == null) goto L25;
        int r112 = 1;
        if (z.m(r111, true) == true) goto L25;
    L26:
        r106.put("is_landscape_status_on_cellphone", r112);
        r106.put("enter_method_on_cellphone", "more_pannel");
        r106.put("scene", "live");
        r106.put("room_id", r102);
        r106.put("from_device_id", g.d());
        o0.a r113 = o0.f58946a;
        String r114 = ((IUserService) k.n(IUserService.class)).user().n();
        r113.getClass();
        r106.put("from_user_id", o0.a.f(r114));
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r115 = this.f104639q;
        if (r115 == null) goto L34;
        r115.startScanDevices(r102, r105, r106.toString());
        return;
    L34:
        return;
    L25:
        r112 = 0;
        goto L26
    L16:
        r109 = null;
        goto L17
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void g() {
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r100 = this.f104639q;
        boolean r101 = false;
        if (r100 == null) goto L9;
        com.bytedance.android.live.core.arch.mvvm.d<List<pf1.a>> r102 = r100.getDeviceList();
        if (r102 == null) goto L9;
        List<pf1.a> r103 = r102.getValue();
        if (r103 == null) goto L9;
        int r104 = r103.size();
    L11:
        if (r104 <= 3) goto L13;
        boolean r105 = true;
    L14:
        a(r105);
        c();
        b();
        RecyclerView r106 = this.f104631i;
        if (r106 != null) goto L17;
        return;
    L17:
        if (r106.getVisibility() == 0) goto L19;
        r101 = true;
    L19:
        if (r101 == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r106);
        return;
    L26:
        return;
    L13:
        r105 = false;
    L9:
        r104 = 0;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.a, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.setDimAmount(0.0f);
    L5:
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r101 = this.f104639q;
        if (r101 == null) goto L8;
        r101.prepare();
    L8:
        e();
    }

    public final void a(boolean r100) {
        if (LivePadAndPcPlayUtil.h() == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        int r101 = 483;
    L8:
        int r102 = UtilityKotlinExtentionsKt.i(r101);
        ViewGroup r103 = this.f104625c;
        if (r103 == null) goto L24;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.height == r102) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L26;
        r104.height = r102;
        ViewGroup r106 = this.f104625c;
        if (r106 == null) goto L27;
        r106.setLayoutParams(r104);
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r105 = false;
        goto L16
    L24:
        return;
    L7:
        r101 = 430;
        goto L8
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-170252752)) goto L12;
        return;
    L12:
        if (r102.equals("cmd_on_live_end_fragment_show") == false) goto L30;
        Handler r103 = DialogLancet.resolveDialogHandler(this);
        if (r103 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(this);
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r104 == null) goto L27;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L16:
        if (Looper.myLooper() == r103.getLooper()) goto L18;
        r103.post(DialogLancet.createDismissRunnable(this));
        return;
    L30:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.ttlive_layout_dialog_pad_and_pc_play_device_list);
        this.f104625c = (ViewGroup) findViewById(R.id.cast_screen_device_list_root);
        this.f104626d = (ImageView) findViewById(R.id.ivRefresh);
        this.f104627e = (TextView) findViewById(R.id.tvTitle);
        this.f104631i = (RecyclerView) findViewById(R.id.rvList);
        this.f104628f = (ViewGroup) findViewById(R.id.flLoading);
        this.f104629g = (LiveDoubleColorBallAnimationView) findViewById(R.id.loadingProgress);
        this.f104630h = (ViewGroup) findViewById(R.id.flDeviceNotFound);
        this.f104632j = (FrameLayout) findViewById(R.id.flGuideContainer);
        this.f104633k = (FrameLayout) findViewById(R.id.flScanQrCode);
        this.f104634l = (HSImageView) findViewById(R.id.ivQrCode);
        this.f104635m = (TextView) findViewById(R.id.tvQrCodeTitle);
        int r100 = 0;
        String r101 = null;
        if (LivePadAndPcPlayUtil.h() == true) goto L6;
    L86:
        PadAndPcPlayGuideNew r102 = new PadAndPcPlayGuideNew(this.f104638p, this.f104639q);
        Function1<Boolean, Unit> r103 = new PadAndPcPlayDeviceListDialog$initGuideView$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f104478q = r103;
        Unit r104 = Unit.INSTANCE;
        Iterator r105 = CollectionsKt.listOf(new com.bytedance.android.livesdk.castscreen.guide.d[]{new com.bytedance.android.livesdk.castscreen.guide.g(), r102}).iterator();
    L88:
        if (r105.hasNext() == false) goto L92;
        Object r106 = r105.next();
        if (((com.bytedance.android.livesdk.castscreen.guide.d) r106).canShowGuide() == false) goto L88;
    L93:
        com.bytedance.android.livesdk.castscreen.guide.d r107 = (com.bytedance.android.livesdk.castscreen.guide.d) r106;
        if (r107 == null) goto L96;
        this.f104636n = r107;
        r107.a(this.f104632j);
    L96:
        PadAndPcDeviceListAdapter r108 = new PadAndPcDeviceListAdapter(this.f104638p);
        r108.f104646a = this.f104639q;
        Unit r109 = Unit.INSTANCE;
        RecyclerView r111 = this.f104631i;
        if (r111 == null) goto L99;
        r111.setAdapter(r108);
    L99:
        this.f104637o = r108;
        if (LivePadAndPcPlayUtil.h() == false) goto L111;
        RecyclerView r112 = this.f104631i;
        if (r112 == null) goto L104;
        r112.setMinimumHeight(0);
    L104:
        RecyclerView r113 = this.f104631i;
        if ((r113 instanceof MaxHeightRecyclerView) == true) goto L107;
        r113 = null;
    L107:
        MaxHeightRecyclerView r114 = (MaxHeightRecyclerView) r113;
        if (r114 == null) goto L111;
        r114.setMaxHeight(-1);
    L111:
        if (((q61) this.f104641s.getValue()).a() == false) goto L145;
        String r115 = ((q61) this.f104641s.getValue()).e();
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r115) == true) goto L117;
        r115 = null;
    L117:
        if (r115 == null) goto L121;
        TextView r116 = this.f104635m;
        if (r116 == null) goto L121;
        r116.setText(r115);
    L121:
        DataCenter r117 = this.f104638p;
        if (r117 == null) goto L145;
        Room r118 = z.o(r117);
        if (r118 == null) goto L145;
        com.bytedance.android.livesdk.user.f r119 = ((IUserService) k.n(IUserService.class)).user();
        o r120 = u.l().c(x.class);
        JSONObject r121 = new JSONObject();
        r121.put("from_device_id", ((IHostContext) k.n(IHostContext.class)).getServerDeviceId().toString());
        r121.put("from_user_id", r119.n());
        long r122 = r118.getRoomId();
        Pair[] r123 = new Pair[2];
        if (r120 == null) goto L131;
        Map<String, String> r124 = r120.getMap();
        if (r124 == null) goto L131;
        r101 = r124.get("action_type");
    L131:
        r123[0] = TuplesKt.to("action_type", r101);
        r123[1] = TuplesKt.to("extra_params", r121.toString());
        ArrayList<String> r125 = com.bytedance.android.livesdk.castscreen.utils.d.f104735a;
        Intrinsics.checkNotNullParameter(r123, "params");
        Uri.Builder r126 = UriProtector.parse("sslocal://webcast_room").buildUpon();
        String r127 = String.valueOf(r122);
        if (r127 != null) goto L134;
        r127 = "";
    L134:
        r126.appendQueryParameter("room_id", r127);
        r126.appendQueryParameter("enter_from_merge", "scan_share_to_pad");
        r126.appendQueryParameter("enter_method", "scan");
    L135:
        if (r100 >= 2) goto L140;
        Pair r128 = r123[r100];
        Object r129 = r128.getSecond();
        if (r129 == null) goto L139;
        r126.appendQueryParameter((String) r128.getFirst(), r129.toString());
    L139:
        r100 = r100 + 1;
        goto L135
    L140:
        String r130 = r126.build().toString();
        ILiveShareService r131 = (ILiveShareService) k.n(ILiveShareService.class);
        int r132 = this.f104643u;
        Charset r133 = Charsets.UTF_8;
        if (r130 == null) goto L144;
        r131.getQrCodeFromUrl(r132, Base64.encodeToString(r130.getBytes(r133), 2), "", new PadAndPcPlayDeviceListDialog$initQrCodeView$3(this));
        goto L145
    L144:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L145:
        ImageView r134 = this.f104626d;
        if (r134 == null) goto L148;
        r134.setOnClickListener(new a(this));
    L148:
        com.bytedance.android.livesdk.castscreen.padandpc.vm.a r135 = this.f104639q;
        if (r135 == null) goto L151;
        RxUtilKt.c(RxUtilKt.h(r135.getScanning()).subscribe(new b(this)), this.f104640r);
        RxUtilKt.c(RxUtilKt.h(r135.getPanelTitle()).subscribe(new c(this)), this.f104640r);
        RxUtilKt.c(RxUtilKt.h(r135.getDeviceList()).subscribe(new d(r135, this)), this.f104640r);
        RxUtilKt.c(RxUtilKt.h(r135.getPlaySuccess().onEvent()).subscribe(new e(this)), this.f104640r);
        RxUtilKt.c(RxUtilKt.h(r135.getCastResult().onEvent()).subscribe(new f(this)), this.f104640r);
    L151:
        DataCenter r136 = this.f104638p;
        if (r136 == null) goto L161;
        r136.observe("cmd_on_live_end_fragment_show", this);
        return;
    L161:
        return;
    L92:
        r106 = null;
        goto L93
    L6:
        if (LivePadAndPcPlayUtil.h() == true) goto L8;
    L10:
        boolean r137 = false;
    L11:
        ViewGroup r138 = this.f104625c;
        if (r138 == null) goto L17;
        if (r137 == false) goto L15;
        int r139 = R.color.ttlive_color_F8F8F8;
    L16:
        r138.setBackgroundColor(s1.h(r139));
        goto L17
    L15:
        r139 = R.color.black;
    L17:
        ImageView r140 = this.f104626d;
        if (r140 == null) goto L23;
        if (r137 == false) goto L21;
        int r141 = R.drawable.ttlive_ic_pad_pc_play_refresh_light_theme;
    L22:
        r140.setBackground(s1.m(r141));
        goto L23
    L21:
        r141 = R.drawable.ttlive_ic_pad_pc_play_refresh_dark_theme;
    L23:
        TextView r142 = this.f104627e;
        if (r142 == null) goto L28;
        TextPaint r143 = r142.getPaint();
        if (r143 == null) goto L28;
        r143.getFlags();
    L28:
        UtilityKotlinExtentionsKt.t(findViewById(R.id.vLoadingDivider));
        UtilityKotlinExtentionsKt.t(findViewById(R.id.vEmptyDivider));
        LivePadAndPcPlayUtil.e((TextView) findViewById(R.id.tvTitle), r137);
        TextView r144 = (TextView) findViewById(R.id.tvSearching);
        r144.setText("搜索设备...");
        int r145 = R.color.ttlive_color_80_161823;
        if (r137 == false) goto L31;
        int r146 = R.color.ttlive_color_80_161823;
    L32:
        r144.setTextColor(s1.h(r146));
        LivePadAndPcPlayUtil.e((TextView) findViewById(R.id.tvQrCodeTitle), r137);
        ImageView r147 = (ImageView) findViewById(R.id.ivDeviceNotFound);
        if (r147 == null) goto L38;
        if (r137 == false) goto L36;
        int r148 = R.drawable.ttlive_ic_pad_pc_play_not_found_light_theme;
    L37:
        r147.setBackground(s1.m(r148));
        goto L38
    L36:
        r148 = R.drawable.ttlive_ic_pad_pc_play_not_found_dark_theme;
    L38:
        findViewById(R.id.llNotfoundContainer).setAlpha(1.0f);
        TextView r149 = (TextView) findViewById(R.id.tvDeviceNotFound);
        if (r137 == true) goto L42;
        r145 = R.color.ttlive_color_66_FFFFFF;
    L42:
        int r150 = s1.h(r145);
        if (r149 == null) goto L46;
        r149.setTextColor(r150);
    L46:
        if (d() == false) goto L53;
        int r151 = UtilityKotlinExtentionsKt.i(8);
        ViewParent r152 = this.f104625c;
        if ((r152 instanceof qv2.a) == true) goto L50;
        r152 = null;
    L50:
        qv2.a r153 = (qv2.a) r152;
        if (r153 == null) goto L64;
        r153.J(r151, 0, r151, 0);
    L64:
        ViewGroup r154 = this.f104628f;
        if (r154 == null) goto L67;
        UIUtils.updateLayout(r154, -3, -2);
    L67:
        ViewGroup r155 = this.f104628f;
        if (d() == false) goto L70;
        int r156 = 56;
    L71:
        int r157 = UtilityKotlinExtentionsKt.i(r156);
        if (r155 == null) goto L74;
        UIUtils.updateLayoutMargin(r155, -3, r157, -3, -3);
    L74:
        UIUtils.updateLayoutMargin(r144, -3, UtilityKotlinExtentionsKt.i(8), -3, -3);
        ViewGroup r158 = this.f104630h;
        if (r158 == null) goto L77;
        UIUtils.updateLayout(r158, -3, -2);
    L77:
        ViewGroup r159 = this.f104630h;
        if (d() == false) goto L80;
        int r160 = 36;
    L81:
        int r161 = UtilityKotlinExtentionsKt.i(r160);
        if (r159 == null) goto L84;
        UIUtils.updateLayoutMargin(r159, -3, r161, -3, -3);
    L84:
        if (r149 == null) goto L86;
        UIUtils.updateLayoutMargin(r149, -3, UtilityKotlinExtentionsKt.i(10), -3, -3);
        goto L86
    L80:
        r160 = 20;
        goto L81
    L70:
        r156 = 27;
        goto L71
    L53:
        ViewGroup r162 = this.f104625c;
        if (r162 == null) goto L58;
        ViewGroup.LayoutParams r163 = r162.getLayoutParams();
        if (r163 == null) goto L58;
        r163.width = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        r163.height = -1;
    L58:
        ViewParent r164 = this.f104625c;
        if ((r164 instanceof qv2.a) == true) goto L61;
        r164 = null;
    L61:
        qv2.a r165 = (qv2.a) r164;
        if (r165 == null) goto L64;
        r165.J(0, 0, 0, 0);
        goto L64
    L31:
        r146 = R.color.ttlive_color_66_FFFFFF;
        goto L32
    L8:
        if (d() == false) goto L10;
        r137 = true;
        goto L11
    }

    public PadAndPcPlayDeviceListDialog(Context r100, RoomContext r101, DataCenter r102) {
        if (r102 == null) goto L6;
        Boolean r103 = (Boolean) r102.get("data_is_portrait", Boolean.TRUE);
        if (r103 == null) goto L6;
        boolean r104 = r103.booleanValue();
    L7:
        super(r100, r104, Integer.valueOf(R.style.ttlive_CommonBottomDialog_New_Portrait_Style));
        this.f104640r = new CompositeDisposable();
        this.f104641s = LazyKt.lazy(PadAndPcPlayDeviceListDialog$padGuideSetting$2.INSTANCE);
        this.f104642t = LazyKt.lazy(new PadAndPcPlayDeviceListDialog$roomLogger$2(this));
        this.f104643u = 11;
        this.f104644v = LazyKt.lazy(new PadAndPcPlayDeviceListDialog$isPortrait$2(this));
        this.f104638p = r102;
        Object r105 = null;
        if (r101 == null) goto L12;
        j<DataContext> r106 = r101.getPadAndPcPlayVm();
        if (r106 == null) goto L12;
        DataContext r107 = r106.getValue();
    L14:
        if ((r107 instanceof com.bytedance.android.livesdk.castscreen.padandpc.vm.a) == false) goto L17;
        r105 = r107;
    L17:
        this.f104639q = (com.bytedance.android.livesdk.castscreen.padandpc.vm.a) r105;
        return;
    L12:
        r107 = null;
    L6:
        r104 = true;
        goto L7
    }
}
