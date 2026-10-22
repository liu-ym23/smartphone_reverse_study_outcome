package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.RoomIntroApi;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.android.uicomponent.button.UIButton;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/view/RoomIntroDialogV2;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroDialogV2 extends LiveDialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f140697u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomIntroDataSource f140698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveSwitchButton f140699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f140700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextCorrectionEditText f140701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f140702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WrapLineFlowLayout f140703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UIButton f140704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WrapLineFlowLayout f140705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f140706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f140707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f140708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f140709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f140710p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f140711q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f140712r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f140713s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f140714t;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomIntroDialogV2 f140715a;

        public b(RoomIntroDialogV2 r100) {
            this.f140715a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r102 = new Pair[5];
            RoomIntroDataSource r103 = this.f140715a.f140698d;
            String r104 = "";
            if (r103 == null) goto L10;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r105 = r103.f140588n;
            if (r105 == null) goto L10;
            Long r106 = r105.d();
            if (r106 == null) goto L10;
            String r107 = String.valueOf(r106.longValue());
            if (r107 == null) goto L10;
        L11:
            r102[0] = TuplesKt.to("room_id", r107);
            RoomIntroDataSource r108 = this.f140715a.f140698d;
            if (r108 == null) goto L18;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r109 = r108.f140588n;
            if (r109 == null) goto L18;
            String r110 = r109.a();
            if (r110 == null) goto L18;
        L19:
            r102[1] = TuplesKt.to("anchor_id", r110);
            RoomIntroDataSource r111 = this.f140715a.f140698d;
            if (r111 == null) goto L28;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r112 = r111.f140588n;
            if (r112 == null) goto L28;
            if (r112.f140637a != null) goto L26;
            String r113 = "live_start";
        L27:
            r104 = r113;
            goto L28
        L26:
            r113 = "live_room";
        L28:
            r102[2] = TuplesKt.to("request_page", r104);
            String r114 = "0";
            r102[3] = TuplesKt.to("is_video", "0");
            RoomIntroDataSource r115 = this.f140715a.f140698d;
            if (r115 == null) goto L37;
            PropertyOwner r116 = r115.f140587m;
            if (r116 == null) goto L37;
            gz.b r117 = (gz.b) r116.f64752a;
            if (r117 == null) goto L37;
            if (r117.f483360a != true) goto L37;
            r114 = "1";
        L37:
            r102[4] = TuplesKt.to("has_poi", r114);
            r101.sendLog("livesdk_room_detail_revise_success", MapsKt.mapOf(r102), new Object[0]);
            RoomIntroDialogV2.W90(this.f140715a, true);
            return;
        L18:
            r110 = "";
        L10:
            r107 = "";
            goto L11
        }
    }

    static {
    }

    public RoomIntroDialogV2() {
        setNoTitleAndCancelOutside(true);
        this.f140713s = new CompositeDisposable();
    }

    public static final boolean S90(RoomIntroDialogV2 r100) {
        Context r101 = r100.getContext();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getSystemService("input_method");
    L7:
        if ((r103 instanceof InputMethodManager) == false) goto L10;
        r102 = r103;
    L10:
        InputMethodManager r104 = (InputMethodManager) r102;
        if (r104 == null) goto L21;
        Integer r105 = (Integer) JavaCalls.callMethod(r104, "getInputMethodWindowVisibleHeight", new Object[0]);
        if (r105 != null) goto L16;
        return false;
    L16:
        if (r105.intValue() <= 0) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void V90(RoomIntroDialogV2 r100) {
        r100.getClass();
        IHostBusiness r101 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r101 == null) goto L35;
        FragmentActivity r102 = r100.getActivity();
        gz.a r103 = new gz.a();
        s1.w();
        RoomIntroDataSource r104 = r100.f140698d;
        String r105 = "";
        if (r104 == null) goto L12;
        PropertyOwner r106 = r104.f140587m;
        if (r106 == null) goto L12;
        gz.b r107 = (gz.b) r106.f64752a;
        if (r107 == null) goto L12;
        String r108 = r107.f483362c;
        if (r108 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        String r109 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getIdString();
        r103.f483359a.put("anchor_id", r109);
        RoomIntroDataSource r110 = r100.f140698d;
        if (r110 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r111 = r110.f140588n;
        if (r111 == null) goto L23;
        if (r111.f140637a != null) goto L20;
        boolean r112 = true;
    L21:
        if (r112 != true) goto L23;
        r103.f483359a.put("live_status", "before");
    L34:
        r103.f483359a.put("enter_from", "room_detail_poi_set");
        Unit r113 = Unit.INSTANCE;
        DialogFragment r114 = r101.getPoiSearchModalDialog(r102, r103, new x(r100));
    L36:
        FragmentActivity r115 = ContextUtil.contextToFragmentActivity(r100.getContext());
        if (r115 == null) goto L50;
        FragmentManager r116 = r115.getSupportFragmentManager();
        if (r116 == null) goto L51;
        if (r114 == null) goto L52;
        LandscapeRestrictionOperation r117 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r114, "RoomIntroDialogV2SelectPoi", r117);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r114, r117) == true) goto L53;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L45:
        r114.showNow(r116, "RoomIntroDialogV2SelectPoi");
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L20:
        r112 = false;
    L23:
        r103.f483359a.put("live_status", "living");
        Map<String, String> r118 = r103.f483359a;
        RoomIntroDataSource r119 = r100.f140698d;
        if (r119 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r120 = r119.f140588n;
        if (r120 == null) goto L33;
        Long r121 = r120.d();
        if (r121 == null) goto L33;
        String r122 = String.valueOf(r121.longValue());
        if (r122 == null) goto L33;
        r105 = r122;
    L33:
        r118.put("room_id", r105);
    L12:
        r108 = "";
        goto L13
    L35:
        r114 = null;
        goto L36
    }

    public final void X90(boolean r100) {
        if (r100 == false) goto L29;
        RoomIntroDataSource r101 = this.f140698d;
        if (r101 != null) goto L7;
    L14:
        View r102 = this.f140706l;
        if (r102 == null) goto L19;
        View r103 = r102.findViewById(R.id.off_switch_anchor_intro_container);
        if (r103 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r103);
    L19:
        View r104 = this.f140706l;
        if (r104 == null) goto L24;
        View r105 = r104.findViewById(R.id.switch_divider_line);
        if (r105 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r105);
    L24:
        View r106 = this.f140706l;
        if (r106 == null) goto L45;
        View r107 = r106.findViewById(R.id.room_intro_bottom_intro_container);
        if (r107 == null) goto L46;
        UtilityKotlinExtentionsKt.w(r107);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        if (r101.f140578d.f64752a.a() == true) goto L9;
        r101.f140578d.a(sh6.c.a(Unit.INSTANCE));
    L9:
        PropertyOwner<sh6.b<Integer>> r108 = r101.f140579e;
        Intrinsics.checkNotNullParameter(r108, "$this$valueNullable");
        Integer r109 = (Integer) com.bytedance.android.live.core.arch.mvvm.f.a(r108);
        if (r109 == null) goto L12;
        int r110 = r109.intValue();
    L13:
        r101.f140579e.a(sh6.c.a(Integer.valueOf(r110 + 1)));
        goto L14
    L12:
        r110 = 0;
        goto L13
    L29:
        View r111 = this.f140706l;
        if (r111 == null) goto L34;
        View r112 = r111.findViewById(R.id.off_switch_anchor_intro_container);
        if (r112 == null) goto L34;
        UtilityKotlinExtentionsKt.w(r112);
    L34:
        View r113 = this.f140706l;
        if (r113 == null) goto L39;
        View r114 = r113.findViewById(R.id.switch_divider_line);
        if (r114 == null) goto L39;
        UtilityKotlinExtentionsKt.w(r114);
    L39:
        View r115 = this.f140706l;
        if (r115 == null) goto L48;
        View r116 = r115.findViewById(R.id.room_intro_bottom_intro_container);
        if (r116 == null) goto L49;
        UtilityKotlinExtentionsKt.t(r116);
        return;
    L49:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L15;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L16;
        View r105 = r104.findViewById(R.id.ttlive_touch_outside);
        if (r105 == null) goto L17;
        r105.setOnClickListener(x0.a(new AnonymousClass2(this)));
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        this.f140713s.clear();     // Catch: Throwable -> L5
        com.bytedance.android.live.core.utils.x0.a(this.f140701g);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void T90(RoomIntroDialogV2 r100, String r101) {
        r100.getClass();
        com.bytedance.android.livesdk.log.g r102 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r103 = new Pair[3];
        RoomIntroDataSource r104 = r100.f140698d;
        String r105 = "";
        if (r104 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r106 = r104.f140588n;
        if (r106 == null) goto L7;
        String r107 = r106.c();
    L8:
        r103[0] = TuplesKt.to("live_type", r107);
        RoomIntroDataSource r108 = r100.f140698d;
        if (r108 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r109 = r108.f140588n;
        if (r109 == null) goto L15;
        String r110 = r109.a();
        if (r110 == null) goto L15;
        r105 = r110;
    L15:
        r103[1] = TuplesKt.to("anchor_id", r105);
        RoomIntroDataSource r111 = r100.f140698d;
        Long r112 = null;
        if (r111 == null) goto L20;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r113 = r111.f140588n;
        if (r113 == null) goto L20;
        Long r114 = r113.d();
    L21:
        if (r114 == null) goto L32;
        RoomIntroDataSource r115 = r100.f140698d;
        if (r115 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r116 = r115.f140588n;
        if (r116 == null) goto L27;
        r112 = r116.d();
    L27:
        if (r112 != null) goto L30;
    L31:
        String r117 = "live_take_detail";
    L33:
        r103[2] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r117);
        r102.sendLog(r101, MapsKt.mutableMapOf(r103), new Object[0]);
        return;
    L30:
        if (r112.longValue() != 0) goto L31;
    L32:
        r117 = "live_take_page";
    L20:
        r114 = null;
    L7:
        r107 = "";
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void U90(RoomIntroDialogV2 r100, String r110) {
        r100.getClass();
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r102 = new Pair[5];
        RoomIntroDataSource r103 = r100.f140698d;
        String r104 = "";
        if (r103 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r105 = r103.f140588n;
        if (r105 == null) goto L7;
        String r106 = r105.c();
    L8:
        r102[0] = TuplesKt.to("live_type", r106);
        RoomIntroDataSource r107 = r100.f140698d;
        if (r107 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r108 = r107.f140588n;
        if (r108 == null) goto L16;
        Long r109 = r108.d();
        if (r109 == null) goto L16;
        String r111 = String.valueOf(r109.longValue());
        if (r111 == null) goto L16;
    L17:
        r102[1] = TuplesKt.to("room_id", r111);
        RoomIntroDataSource r112 = r100.f140698d;
        if (r112 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r113 = r112.f140588n;
        if (r113 == null) goto L24;
        String r114 = r113.a();
        if (r114 == null) goto L24;
        r104 = r114;
    L24:
        r102[2] = TuplesKt.to("anchor_id", r104);
        RoomIntroDataSource r115 = r100.f140698d;
        Long r116 = null;
        if (r115 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r117 = r115.f140588n;
        if (r117 == null) goto L29;
        Long r118 = r117.d();
    L30:
        if (r118 == null) goto L41;
        RoomIntroDataSource r119 = r100.f140698d;
        if (r119 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r120 = r119.f140588n;
        if (r120 == null) goto L36;
        r116 = r120.d();
    L36:
        if (r116 != null) goto L39;
    L40:
        String r121 = "live_take_detail";
    L42:
        r102[3] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r121);
        RoomIntroDataSource r122 = r100.f140698d;
        if (r122 == null) goto L51;
        PropertyOwner r123 = r122.f140587m;
        if (r123 == null) goto L51;
        gz.b r124 = (gz.b) r123.f64752a;
        if (r124 == null) goto L51;
        if (r124.f483360a != true) goto L51;
        String r125 = "1";
    L52:
        r102[4] = TuplesKt.to("has_poi", r125);
        r101.sendLog(r110, MapsKt.mutableMapOf(r102), new Object[0]);
        return;
    L51:
        r125 = "0";
        goto L52
    L39:
        if (r116.longValue() != 0) goto L40;
    L41:
        r121 = "live_take_page";
    L29:
        r118 = null;
    L16:
        r111 = "";
    L7:
        r106 = "";
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void W90(RoomIntroDialogV2 r110, boolean r111) {
        RoomIntroDataSource r100 = r110.f140698d;
        String r101 = null;
        if (r100 == null) goto L7;
        PropertyOwner r102 = r100.f140581g;
        if (r102 == null) goto L7;
        List r103 = (List) r102.f64752a;
    L8:
        if (r100 == null) goto L10;
        String r104 = r100.a();
    L11:
        IInteractService r105 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r106 = true;
        if (r105 == null) goto L22;
        kj0.b r107 = r105.getSelfDisciplineService();
        if (r107 == null) goto L22;
        if (r107.isSelfDisciplineOn() != true) goto L22;
        IInteractService r108 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r108 == null) goto L22;
        kj0.b r109 = r108.getSelfDisciplineService();
        if (r109 == null) goto L22;
        r109.logUpdateRoomIntro(r104);
    L22:
        com.bytedance.android.live.core.utils.x0.a(r110.f140701g);
        if (r103 != null) goto L76;
        String r112 = null;
    L28:
        String r113 = r112;
    L29:
        RoomIntroApi r114 = (RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class);
        RoomIntroDataSource r115 = r110.f140698d;
        if (r115 == null) goto L34;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r116 = r115.f140588n;
        if (r116 == null) goto L34;
        Long r117 = r116.d();
    L35:
        RoomIntroDataSource r118 = r110.f140698d;
        if (r118 == null) goto L40;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r119 = r118.f140588n;
        if (r119 == null) goto L40;
        String r120 = r119.c();
    L41:
        RoomIntroDataSource r121 = r110.f140698d;
        if (r121 == null) goto L46;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r122 = r121.f140588n;
        if (r122 == null) goto L46;
        Long r123 = r122.b();
    L47:
        RoomIntroDataSource r124 = r110.f140698d;
        if (r124 == null) goto L52;
        PropertyOwner r125 = r124.f140585k;
        if (r125 == null) goto L52;
        Boolean r126 = (Boolean) r125.f64752a;
    L53:
        if (r124 == null) goto L57;
        PropertyOwner r127 = r124.f140586l;
        if (r127 == null) goto L57;
        Boolean r128 = (Boolean) r127.f64752a;
    L58:
        if (r124 == null) goto L70;
        PropertyOwner r129 = r124.f140587m;
        if (r129 == null) goto L70;
        gz.b r130 = (gz.b) r129.f64752a;
        if (r130 == null) goto L70;
        if (r130.f483362c.length() == 0) goto L67;
        r106 = false;
    L67:
        if (r106 == false) goto L69;
        r101 = "-1";
        goto L70
    L69:
        r101 = r130.f483362c;
    L70:
        Observable<R> r131 = r114.updateRoomIntro(r117, r111, "", r104, r120, r123, r113, r126, r128, r101).compose(RxUtil.rxSchedulerHelper());
        if (r131 == 0) goto L78;
        ObservableSubscribeProxy r132 = (ObservableSubscribeProxy) r131.as(AutoDispose.bind(r110));
        if (r132 == null) goto L79;
        r132.subscribe(new z(r110, r111), new a0(r110));
        return;
    L79:
        return;
    L78:
        return;
    L57:
        r128 = null;
    L52:
        r126 = null;
    L46:
        r123 = null;
    L40:
        r120 = null;
    L34:
        r117 = null;
        goto L35
    L76:
        r112 = GsonHelper.get().toJson(r103);     // Catch: Exception -> L26
    L26:
        r113 = null;
        goto L29
    L10:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r102 = this.f140706l;
        if (r102 == null) goto L5;
        r102.setOnTouchListener(new y(this));
    L5:
        LiveSwitchButton r103 = this.f140699e;
        if (r103 == null) goto L8;
        r103.setOnCheckedChangeListener(new w(this));
    L8:
        RoomIntroDataSource r104 = this.f140698d;
        if (r104 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r105 = r104.f140589o;
        if (r105 == null) goto L13;
        boolean r106 = r105.k();
    L14:
        LiveSwitchButton r107 = this.f140699e;
        if (r107 == null) goto L17;
        boolean r108 = r107.isChecked();
    L18:
        if (r106 == r108) goto L22;
        LiveSwitchButton r109 = this.f140699e;
        if (r109 == null) goto L22;
        r109.f(false, false);
    L22:
        X90(r106);
        IUserService r110 = (IUserService) jc1.k.f(IUserService.class);
        Unit r111 = null;
        if (r110 == null) goto L29;
        com.bytedance.android.livesdk.user.f r112 = r110.user();
        if (r112 == null) goto L29;
        IUser r113 = r112.b();
        if (r113 == null) goto L29;
        py.k r114 = r113.getAvatarThumb();
    L30:
        ImageUtil.loadRoundImage((ImageView) r100.findViewById(R.id.ttlive_avatar_view), r114);
        u r115 = new u(this);
        HSImageView r116 = this.f140700f;
        if (r116 == null) goto L33;
        r116.setOnClickListener(new t(this, r115));
    L33:
        FrescoLoader.with(getContext()).load("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_broadcast_image_room_intro_demo.png").actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(new ImageLoader.e(null, r115, false)).placeholder(R.drawable.ttlive_broadcast_room_intro_demo_error).into(this.f140700f);
        int r117 = com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m.f140621i;
        RoomIntroDataSource r118 = this.f140698d;
        WrapLineFlowLayout r119 = this.f140705k;
        CompositeDisposable r120 = this.f140713s;
        Intrinsics.checkNotNullParameter(r120, "cd");
        if (r118 == null) goto L37;
        if (r119 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m r121 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m(r118, r119, r120);
    L39:
        if (r121 == null) goto L41;
        Function0<Integer> r122 = new RoomIntroDialogV2$initLabels$1(this);
        Intrinsics.checkNotNullParameter(r122, "getRoomIntroDialogHeightAction");
        r121.f140629h.add(com.bytedance.android.live.core.arch.mvvm.f.b(r121.f140627f.f140583i).subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.o(r121, r122)));
    L41:
        int r123 = com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a.f140603f;
        RoomIntroDataSource r124 = this.f140698d;
        TextCorrectionEditText r125 = this.f140701g;
        TextView r126 = this.f140702h;
        WrapLineFlowLayout r127 = this.f140703i;
        if (r124 != null) goto L44;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r128 = null;
    L45:
        RoomIntroDataSource r129 = this.f140698d;
        if (r129 == null) goto L48;
        r129.f140577c = r128;
    L48:
        if (r128 == null) goto L50;
        r128.c();
    L50:
        RoomIntroDataSource r130 = this.f140698d;
        if (r130 == null) goto L59;
        PropertyOwner r131 = r130.f140585k;
        if (r131 == null) goto L59;
        Observable r132 = com.bytedance.android.live.core.arch.mvvm.f.b(r131);
        if (r132 == null) goto L59;
        Disposable r133 = r132.subscribe(new v(this));
        if (r133 == null) goto L59;
        RxUtilKt.c(r133, this.f140713s);
    L63:
        if (r52.n.f536223a.getValue().a() == false) goto L77;
        RoomIntroDataSource r134 = this.f140698d;
        if (r134 == null) goto L74;
        PropertyOwner r135 = r134.f140586l;
        if (r135 == null) goto L74;
        Observable r136 = com.bytedance.android.live.core.arch.mvvm.f.b(r135);
        if (r136 == null) goto L74;
        Disposable r137 = r136.subscribe(new o(this));
        if (r137 == null) goto L74;
        RxUtilKt.c(r137, this.f140713s);
    L74:
        ALogger.i("RoomIntroDialogV2", "no appointment");
        ViewGroup r138 = this.f140708n;
        if (r138 == null) goto L77;
        UtilityKotlinExtentionsKt.t(r138);
        Unit r139 = Unit.INSTANCE;
    L77:
        RoomIntroDataSource r140 = this.f140698d;
        if (r140 == null) goto L98;
        PropertyOwner r141 = r140.f140587m;
        if (r141 == null) goto L98;
        Observable r142 = com.bytedance.android.live.core.arch.mvvm.f.b(r141);
        if (r142 == null) goto L98;
        Disposable r143 = r142.subscribe(new q(this));
        if (r143 == null) goto L98;
        RxUtilKt.c(r143, this.f140713s);
        RoomIntroDataSource r144 = this.f140698d;
        if (r144 == null) goto L94;
        PropertyOwner r145 = r144.f140580f;
        if (r145 == null) goto L94;
        Observable r146 = com.bytedance.android.live.core.arch.mvvm.f.b(r145);
        if (r146 == null) goto L94;
        Disposable r147 = r146.subscribe(new p(this));
        if (r147 == null) goto L94;
        RxUtilKt.c(r147, this.f140713s);
    L94:
        ViewGroup r148 = this.f140711q;
        if (r148 == null) goto L97;
        r148.setOnClickListener(x0.a(new RoomIntroDialogV2$initLocalLifePoi$$inlined$let$lambda$2(this)));
        r111 = Unit.INSTANCE;
    L97:
        if (r111 == null) goto L98;
    L101:
        UIButton r149 = this.f140704j;
        if (r149 == null) goto L105;
        r149.setOnClickListener(new b(this));
        return;
    L105:
        return;
    L98:
        ALogger.i("RoomIntroDialogV2", "no local life poi");
        ViewGroup r150 = this.f140711q;
        if (r150 == null) goto L101;
        UtilityKotlinExtentionsKt.t(r150);
        Unit r151 = Unit.INSTANCE;
    L59:
        ALogger.i("RoomIntroDialogV2", "no poi");
        ViewGroup r152 = this.f140707m;
        if (r152 == null) goto L63;
        UtilityKotlinExtentionsKt.t(r152);
        Unit r153 = Unit.INSTANCE;
        goto L63
    L44:
        r128 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a(r124, r125, r126, r127);
    L37:
        r121 = null;
    L29:
        r114 = null;
        goto L30
    L17:
        r108 = false;
    L13:
        r106 = false;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_room_intro_v2, r101, false);
        if (r103 == null) goto L5;
        this.f140699e = (LiveSwitchButton) r103.findViewById(R.id.switch_button);
        this.f140700f = (HSImageView) r103.findViewById(R.id.off_switch_intro_image);
        this.f140701g = (TextCorrectionEditText) r103.findViewById(R.id.edit_view);
        this.f140702h = (TextView) r103.findViewById(R.id.edit_view_show_text_view);
        this.f140703i = (WrapLineFlowLayout) r103.findViewById(R.id.intro_guide_container);
        this.f140704j = (UIButton) r103.findViewById(R.id.btn_submit);
        this.f140705k = (WrapLineFlowLayout) r103.findViewById(R.id.tags_container);
        this.f140706l = r103;
        this.f140707m = (ViewGroup) r103.findViewById(R.id.poi_container);
        this.f140708n = (ViewGroup) r103.findViewById(R.id.appointment_container);
        this.f140709o = (TextView) r103.findViewById(R.id.appointment_select_state);
        this.f140710p = (TextView) r103.findViewById(R.id.poi_select_state);
        this.f140711q = (ViewGroup) r103.findViewById(R.id.locallife_poi_container);
        this.f140712r = (TextView) r103.findViewById(R.id.locallife_poi_select_text);
        return r103;
    L5:
        return null;
    }
}
