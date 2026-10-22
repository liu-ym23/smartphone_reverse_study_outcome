package com.bytedance.android.livesdk.interactivity.interactive.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VsMsgBoardBottomTipSectionProvider;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.VsMsgBoardBottomTipSectionProvider$sectionBridge$1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.i;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.q;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import fq1.s;
import fq1.t;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.e;
import nq1.d;
import pm1.f;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/VSMsgBoardPortraitInputDialog;", "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/VSMsgBoardInputDialog;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardPortraitInputDialog extends VSMsgBoardInputDialog {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f137194x = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f137195m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f137196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VSInputPanelSectionContainer f137197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VSInputPanelSectionContainer f137198p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VSInputPanelSectionContainer f137199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VSInputPanelSectionContainer f137200r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VSInputPanelSectionContainer f137201s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VSInputPanelSectionContainer f137202t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f137203u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SkinSelection f137204v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CompositeDisposable f137205w;

    public static final class a {
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f137206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VSMsgBoardPortraitInputDialog f137207b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f137208a;

            public a(b r100) {
                this.f137208a = r100;
            }

            public final void a() {
                if (this.f137208a.f137207b.isAdded() == true) goto L5;
                return;
            L5:
                if (this.f137208a.f137207b.getContext() == null) goto L35;
                FragmentActivity r100 = this.f137208a.f137207b.getActivity();
                if (r100 == null) goto L12;
                Window r101 = r100.getWindow();
                if (r101 == null) goto L12;
                r101.setSoftInputMode(48);
            L12:
                VSInputPanelSectionContainer r102 = this.f137208a.f137207b.f137201s;
                if (r102 == null) goto L15;
                VSInputSectionType r103 = r102.getCurrentSectionType();
            L17:
                if (r103 == VSInputSectionType.NONE) goto L25;
                VSInputPanelSectionContainer r104 = this.f137208a.f137207b.f137201s;
                if (r104 == null) goto L30;
                VSInputSectionType r105 = r104.getCurrentSectionType();
                if (r105 == null) goto L31;
                VSInputPanelSectionContainer r106 = this.f137208a.f137207b.f137201s;
                if (r106 == null) goto L32;
                VSInputPanelSectionContainer.d(r106, r105, null, 6);
                return;
            L32:
                return;
            L31:
                return;
            L30:
                return;
            L25:
                VSInputPanelSectionContainer r107 = this.f137208a.f137207b.f137201s;
                if (r107 == null) goto L34;
                VSInputPanelSectionContainer.d(r107, VSInputSectionType.KEYBOARD, null, 6);
                return;
            L34:
                return;
            L15:
                r103 = null;
                goto L17
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
        }

        public b(EditText r100, VSMsgBoardPortraitInputDialog r101) {
            this.f137206a = r100;
            this.f137207b = r101;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            r100.postDelayed(new a(this), this.f137207b.f137195m);
            this.f137206a.setOnFocusChangeListener(null);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f137209a;

        public c(EditText r100) {
            this.f137209a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f137209a.requestFocus();     // Catch: Throwable -> L4 Exception -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            ALogger.e("VSMsgBoardInputPanel", e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    public final Map<String, String> W90() {
        Pair[] r100 = new Pair[3];
        SkinSelection r101 = this.f137204v;
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.f137175a;
        if (r103 == null) goto L6;
    L7:
        r100[0] = TuplesKt.to("skin_id", r103);
        SkinSelection r104 = this.f137204v;
        if (r104 == null) goto L11;
        String r105 = r104.f137176b;
        if (r105 == null) goto L11;
    L12:
        r100[1] = TuplesKt.to("badge_id", r105);
        int r106 = n82.c.f518247a;
        t9 r107 = this.f137180d;
        String r108 = null;
        if (r107 == null) goto L15;
        DataCenter r109 = r107.f114228l;
    L16:
        e r110 = f.c();
        if (r110 == null) goto L21;
        ReplayDataContext r111 = r110.h(r109);
        if (r111 == null) goto L21;
        j<Object> r112 = r111.getVsMsgBoardDataContext();
    L23:
        if ((r112 instanceof j) == true) goto L26;
        r112 = null;
    L26:
        if (r112 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.msgboard.a r113 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r112.getValue();
        if (r113 == null) goto L29;
    L38:
        if (r113 == null) goto L51;
        IRoom r114 = r113.getRoom();
        if (r114 == null) goto L51;
        IEpisodeExtraInfo r115 = r114.getEpisodeExtra();
        if (r115 == null) goto L51;
        Map<String, PrivilegeInfo> r116 = r115.getPrivilegeInfo();
        if (r116 == null) goto L51;
        PrivilegeInfo r117 = r116.get(String.valueOf(5));
        if (r117 == null) goto L51;
        String r118 = String.valueOf(r117.entityid);
        if (r118 == null) goto L51;
        r108 = r118;
    L61:
        if (r108 == null) goto L64;
        r102 = r108;
    L64:
        r100[2] = TuplesKt.to(PickerReporterConstants.KEY.ENTITY_ID, r102);
        return MapsKt.mapOf(r100);
    L51:
        if (r113 == null) goto L61;
        Episode r119 = r113.getEpisode();
        if (r119 == null) goto L61;
        IMainEpisode r120 = (IMainEpisode) r119.castToOrNull(IMainEpisode.class);
        if (r120 == null) goto L61;
        Map<Integer, PrivilegeInfo> r121 = r120.getPrivilegeInfo();
        if (r121 == null) goto L61;
        PrivilegeInfo r122 = r121.get(5);
        if (r122 == null) goto L61;
        r108 = String.valueOf(r122.entityid);
    L29:
        u r123 = r.u(r109, null, 2);
        if (r123 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.msgboard.a r124 = r123.L0();
    L34:
        if ((r124 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L36;
        r113 = null;
        goto L38
    L36:
        r113 = r124;
        goto L38
    L32:
        r124 = null;
    L21:
        r112 = null;
        goto L23
    L15:
        r109 = null;
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    static {
        f137194x = s1.f(15.0f);
    }

    public final void X90() {
        t9 r100 = this.f137180d;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        SkinSelection r102 = this.f137204v;
        DataCenter r103 = null;
        if (r102 == null) goto L28;
        Set<String> r104 = r102.f137177c;
        if (r104 == null) goto L28;
        Set<String> r105 = r104;
        if ((r105 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L26;
        String r107 = (String) r106.next();
        int r108 = n82.c.f518247a;
        t9 r109 = this.f137180d;
        if (r109 == null) goto L22;
        DataCenter r110 = r109.f114228l;
    L24:
        if ((!n82.c.c(r107, r110)) == false) goto L18;
    L27:
        Boolean r111 = Boolean.valueOf(r101);
    L29:
        StringBuilder r112 = new StringBuilder();
        s r113 = t.a();
        if (r113 == null) goto L32;
        String r114 = r113.getCurrentUserId();
    L33:
        r112.append(r114);
        r112.append('_');
        int r115 = n82.c.f518247a;
        t9 r116 = this.f137180d;
        if (r116 == null) goto L36;
        r103 = r116.f114228l;
    L36:
        r112.append(n82.c.f(r103));
        String r117 = r112.toString();
        String r118 = "";
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L39;
        d.f520116y.getValue().put(r117, "");
        d.f520117z.getValue().put(r117, "");
        return;
    L39:
        com.bytedance.android.livesdk.sharedpref.e<HashMap<String, String>> r119 = d.f520116y;
        HashMap<String, String> r120 = r119.getValue();
        SkinSelection r121 = this.f137204v;
        if (r121 == null) goto L43;
        String r122 = r121.f137175a;
        if (r122 == null) goto L43;
    L44:
        r120.put(r117, r122);
        com.bytedance.android.livesdk.sharedpref.f.d(r119, r120);
        com.bytedance.android.livesdk.sharedpref.e<HashMap<String, String>> r123 = d.f520117z;
        HashMap<String, String> r124 = r123.getValue();
        SkinSelection r125 = this.f137204v;
        if (r125 == null) goto L50;
        String r126 = r125.f137176b;
        if (r126 == null) goto L50;
        r118 = r126;
    L50:
        r124.put(r117, r118);
        com.bytedance.android.livesdk.sharedpref.f.d(r123, r124);
        return;
    L43:
        r122 = "";
        goto L44
    L32:
        r114 = null;
        goto L33
    L22:
        r110 = null;
    L26:
        r101 = false;
        goto L27
    L14:
        if (r105.isEmpty() == false) goto L16;
    L28:
        r111 = null;
        goto L29
    L5:
        if (r100.f114232p != true) goto L7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final int getLayoutId() {
        t9 r100 = this.f137180d;
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L9;
    L11:
        return R.layout.ttlive_fragment_vs_msg_board_input_fragment_landscape;
    L9:
        if (r100.f114223g != true) goto L11;
        return R.layout.ttlive_fragment_vs_msg_board_input_fragment;
    L5:
        if (r100.f114224h != true) goto L7;
        return R.layout.ttlive_fragment_vs_msg_board_input_fragment_pad;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog, com.bytedance.android.livesdkapi.interact.IVSInputDialog
    public final void hideSoftKeyBoard() {
        k82.a r100 = this.f137183g;
        if (r100 == null) goto L10;
        EditText r101 = r100.f502082a;
        if (r101 == null) goto L11;
        VSInputPanelSectionContainer r102 = this.f137201s;
        if (r102 == null) goto L12;
        VSInputPanelSectionContainer.d(r102, VSInputSectionType.NONE, r101, 4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public VSMsgBoardPortraitInputDialog() {
        this.f137195m = 100;
        this.f137196n = 200;
        this.f137204v = new SkinSelection();
        this.f137205w = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog, com.bytedance.android.livesdkapi.interact.IVSInputDialog
    public final void dismissInputDialog() {
        super.dismissInputDialog();
        X90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r100 = this.f137205w;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        CompositeDisposable r101 = this.f137205w;
        if (r101 == null) goto L9;
        r101.clear();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        VSInputPanelSectionContainer r100 = this.f137201s;
        if (r100 == null) goto L10;
        MeasureLinearLayout r101 = this.f137182f;
        if (r101 == null) goto L10;
        i40.b r102 = r101.getKeyBoardObservable();
        if (r102 == null) goto L10;
        r102.b(r100);
    L10:
        if (this.f137187k == false) goto L18;
        VSInputPanelSectionContainer r103 = this.f137201s;
        if (r103 == null) goto L14;
        VSInputSectionType r104 = r103.getCurrentSectionType();
    L16:
        if (r104 == VSInputSectionType.KEYBOARD) goto L18;
        this.f137187k = false;
        V90(this.f137196n, 1, 5);
        return;
    L14:
        r104 = null;
    L18:
        k82.a r105 = this.f137183g;
        if (r105 == null) goto L25;
        EditText r106 = r105.f502082a;
        if (r106 == null) goto L26;
        r106.post(new c(r106));
        r106.setOnFocusChangeListener(new b(r106, this));
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog, com.bytedance.android.livesdkapi.interact.IVSInputDialog
    public final void onSendSuccess() {
        super.onSendSuccess();
        this.f137204v = new SkinSelection();
        X90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void T90(MeasureLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        this.f137197o = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_shadow_view);
        this.f137198p = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_content_view);
        this.f137199q = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_publish_to_story_view);
        this.f137200r = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_control_view);
        this.f137201s = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_bottom_view);
        this.f137202t = (VSInputPanelSectionContainer) r100.findViewById(R.id.input_panel_bottom_tip_view);
        this.f137203u = r100.findViewById(R.id.container_body);
        int r101 = n82.c.f518247a;
        t9 r102 = this.f137180d;
        if (r102 == null) goto L7;
        u9 r103 = r102.f114219c;
        if (r103 == null) goto L7;
        String r104 = r103.f114253c;
    L8:
        int r105 = n82.c.k(r104, -1);
        View r106 = this.f137203u;
        if (r106 == null) goto L12;
        r106.setBackgroundColor(r105);
        return;
    L12:
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog
    public final void U90(MeasureLinearLayout r310) {
        Intrinsics.checkNotNullParameter(r310, "layout");
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a r110 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a();
        q r111 = new q(getContext());
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j r112 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j();
        i r113 = new i();
        v r114 = new v(getContext());
        VsMsgBoardBottomTipSectionProvider r100 = new VsMsgBoardBottomTipSectionProvider(getContext());
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.t r101 = new com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.t();
        HashSet r102 = new HashSet();
        VSInputSectionType r103 = VSInputSectionType.SHADOW;
        r102.add(r103);
        VSInputPanelSectionContainer r104 = this.f137197o;
        if (r104 == null) goto L5;
        r104.setSupportSections(r102);
    L5:
        HashSet r105 = new HashSet();
        VSInputSectionType r106 = VSInputSectionType.CONTENT;
        r105.add(r106);
        VSInputPanelSectionContainer r107 = this.f137198p;
        if (r107 == null) goto L8;
        r107.setSupportSections(r105);
    L8:
        nq1.b r115 = nq1.b.f520090a;
        if (r115.getValue().booleanValue() == false) goto L13;
        HashSet r108 = new HashSet();
        r108.add(VSInputSectionType.PUBLISH);
        VSInputPanelSectionContainer r109 = this.f137199q;
        if (r109 == null) goto L13;
        r109.setSupportSections(r108);
    L13:
        HashSet r116 = new HashSet();
        VSInputSectionType r117 = VSInputSectionType.CONTROL_PORTRAIT;
        r116.add(r117);
        VSInputPanelSectionContainer r118 = this.f137200r;
        if (r118 == null) goto L16;
        r118.setSupportSections(r116);
    L16:
        HashSet r119 = new HashSet();
        r119.add(VSInputSectionType.EMOJI);
        r119.add(VSInputSectionType.KEYBOARD);
        int r120 = n82.c.f518247a;
        t9 r121 = this.f137180d;
        if (r121 == null) goto L19;
        DataCenter r122 = r121.f114228l;
    L21:
        if (n82.c.d(r122) == false) goto L25;
        r119.add(VSInputSectionType.PAID_LIVE_PACKAGE);
        r119.add(VSInputSectionType.BOTTOM_TIP);
        VSInputPanelSectionContainer r123 = this.f137202t;
        if (r123 == null) goto L25;
        r123.setSupportSections(r119);
    L25:
        VSInputPanelSectionContainer r124 = this.f137201s;
        if (r124 == null) goto L28;
        r124.setSupportSections(r119);
    L28:
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.c r125 = r110.f137252e;
        if (r125 == null) goto L97;
        q.c r126 = r111.f137326e;
        if (r126 == null) goto L95;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j.c r127 = r112.f137301c;
        if (r127 == null) goto L93;
        i.a r128 = r113.f137294c;
        if (r128 == null) goto L91;
        v.b r129 = r114.f137344g;
        if (r129 == null) goto L89;
        VsMsgBoardBottomTipSectionProvider$sectionBridge$1 r130 = r100.f137243h;
        if (r130 == null) goto L87;
        Observable r131 = xs2.b.a().b(RefreshVSMessageBoardDataEvent.class);
        if (r131 == null) goto L45;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.j.c r210 = r127;
        q.c r211 = r126;
        com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.a.c r212 = r125;
        VSInputSectionType r213 = r106;
        VSInputSectionType r214 = r117;
        Disposable r132 = r131.subscribe(new h82.a(this, r129, r125, r130, r210));
        if (r132 == null) goto L46;
        RxUtilKt.c(r132, this.f137205w);
    L46:
        VSInputSectionType r215 = r213;
        h82.b r133 = new h82.b(this, r130, r212, r210, r129, r211, r128, r212, r211, r128, r210, r129, r130);
        this.f137183g = r133;
        VSInputPanelSectionContainer r134 = this.f137198p;
        if (r134 == null) goto L49;
        r134.a(r133, r110);
    L49:
        VSInputPanelSectionContainer r135 = this.f137198p;
        if (r135 == null) goto L52;
        EditText r136 = null;
        VSInputPanelSectionContainer.d(r135, r215, null, 6);
    L54:
        if (r115.getValue().booleanValue() == false) goto L61;
        VSInputPanelSectionContainer r137 = this.f137199q;
        if (r137 == null) goto L58;
        r137.a(r133, r111);
    L58:
        VSInputPanelSectionContainer r138 = this.f137199q;
        if (r138 == null) goto L61;
        VSInputPanelSectionContainer.d(r138, VSInputSectionType.PUBLISH, r136, 6);
    L61:
        VSInputPanelSectionContainer r139 = this.f137200r;
        if (r139 == null) goto L64;
        r139.a(r133, r112);
    L64:
        VSInputPanelSectionContainer r140 = this.f137200r;
        if (r140 == null) goto L67;
        VSInputPanelSectionContainer.d(r140, r214, r136, 6);
    L67:
        VSInputPanelSectionContainer r141 = this.f137201s;
        if (r141 == null) goto L70;
        r141.a(r133, r113);
    L70:
        VSInputPanelSectionContainer r142 = this.f137201s;
        if (r142 == null) goto L73;
        r142.a(r133, r114);
    L73:
        VSInputPanelSectionContainer r143 = this.f137202t;
        if (r143 == null) goto L76;
        r143.a(r133, r100);
    L76:
        VSInputPanelSectionContainer r144 = this.f137201s;
        if (r144 == null) goto L79;
        h82.c r145 = new h82.c(this);
        Intrinsics.checkNotNullParameter(r145, "listener");
        r144.f137231j.add(r145);
    L79:
        VSInputPanelSectionContainer r146 = this.f137197o;
        if (r146 == null) goto L82;
        r146.a(r133, r101);
    L82:
        VSInputPanelSectionContainer r147 = this.f137197o;
        if (r147 == null) goto L98;
        VSInputPanelSectionContainer.d(r147, r103, r136, 6);
        return;
    L98:
        return;
    L52:
        r136 = null;
        goto L54
    L45:
        r210 = r127;
        r211 = r126;
        r212 = r125;
        r214 = r117;
        r213 = r106;
        goto L46
    L87:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardTipSectionBridge");
    L89:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardSkinSectionBridge");
    L91:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardEmojiSectionBridge");
    L93:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardPortraitControlSectionBridge");
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardPublishSectionBridge");
    L97:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.interactive.dialog.bridge.VSMsgBoardContentSectionBridge");
    L19:
        r122 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardInputDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }
}
