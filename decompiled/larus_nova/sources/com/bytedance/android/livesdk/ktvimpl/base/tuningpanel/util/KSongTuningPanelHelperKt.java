package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.tuningpanel.ability.a;
import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.KSongTuningMusicControl;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningButtonOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningPanelOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongViceSingerTuningButtonOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.s;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvComponentTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oe2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class KSongTuningPanelHelperKt {
    public static final a d() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L5;
    L8:
        KtvModeTuningDataContext.Companion.getClass();
        return KtvModeTuningDataContext.b.a();
    L5:
        if (KtvContext.a.j() == true) goto L8;
        KtvComponentTuningDataContext.Companion.getClass();
        return KtvComponentTuningDataContext.b.a();
    }

    public static final ec0.a e() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L5;
    L13:
        KtvModeTuningDataContext.Companion.getClass();
        DataContext r100 = d.d(KtvModeTuningDataContext.class);
        if ((r100 instanceof KtvModeTuningDataContext) == true) goto L16;
        r100 = null;
    L16:
        KtvModeTuningDataContext r101 = (KtvModeTuningDataContext) r100;
        if (r101 != null) goto L19;
        return null;
    L19:
        return r101.getMTuningMusicControl();
    L5:
        if (KtvContext.a.j() == true) goto L13;
        KtvComponentTuningDataContext.Companion.getClass();
        DataContext r102 = d.d(KtvComponentTuningDataContext.class);
        if ((r102 instanceof KtvComponentTuningDataContext) == true) goto L10;
        r102 = null;
    L10:
        KtvComponentTuningDataContext r103 = (KtvComponentTuningDataContext) r102;
        if (r103 != null) goto L21;
        return null;
    L21:
        return r103.getMTuningMusicControl();
    }

    public static final void c(String r210) {
        Intrinsics.checkNotNullParameter(r210, "buttonType");
        ec0.a r100 = e();
        if (r100 == null) goto L57;
        MusicPanel r110 = r100.e();
        if (r110 == null) goto L59;
        String r101 = r110.f153577a.getMTitle();
        if (r101 != null) goto L10;
        String r102 = "";
    L11:
        long r103 = r110.f153577a.getMId();
        String r104 = r110.f153577a.getAddSongSource();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        boolean r105 = false;
        if (r110.f153580d.length() <= 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        r104 = r110.f153580d;
    L20:
        String r111 = r104;
        String r107 = com.bytedance.android.live.ktv.common.util.a.b(r110.f153577a);
        if (r107.length() != 0) goto L23;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L27;
        HashMap<String, String> r112 = null;
    L28:
        KtvContext.Companion.getClass();
        b r109 = KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r109 == null) goto L34;
        String r113 = r109.getEnterFrom();
        if (r113 == null) goto L34;
        String r114 = r113;
    L36:
        if (j.i() == false) goto L38;
        String r115 = r114;
    L40:
        if (j.i() == false) goto L42;
        String r116 = "ktv_room_open";
    L43:
        String r117 = r110.f153577a.getMidiUrl();
        if (r117 != null) goto L46;
        Boolean r118 = null;
    L50:
        pb0.a r119 = pb0.b.f528406a;
        String r120 = j.d();
        String r121 = j.a(null);
        String r122 = j.c();
        String r123 = j.g();
        String r124 = r110.b();
        String r125 = r110.f153577a.getMAuthor();
        if (r125 != null) goto L53;
        r125 = "";
    L53:
        Intrinsics.checkNotNullParameter(r210, "buttonType");
        Intrinsics.checkNotNullParameter(r120, "liveType");
        Intrinsics.checkNotNullParameter(r121, "roomType");
        Intrinsics.checkNotNullParameter(r122, "functionType");
        Intrinsics.checkNotNullParameter("tone_tuning", "requestPage");
        Intrinsics.checkNotNullParameter(r102, "songName");
        Intrinsics.checkNotNullParameter(r123, "userType");
        Intrinsics.checkNotNullParameter(r111, "fromRequestType");
        Intrinsics.checkNotNullParameter(r124, "artistId");
        Intrinsics.checkNotNullParameter(r125, "artistName");
        pb0.a r126 = pb0.b.f528406a;
        if (r126 == null) goto L58;
        r126.o(r210, r120, r121, r122, "tone_tuning", r102, r103, r123, r111, r124, r125, r112, r114, r115, r116, r118, null, r110);
        return;
    L58:
        return;
    L46:
        if (r117.length() <= 0) goto L48;
        r105 = true;
    L48:
        r118 = Boolean.valueOf(r105);
        goto L50
    L42:
        r116 = null;
        goto L43
    L38:
        r115 = null;
    L34:
        r114 = "";
        goto L36
    L27:
        r112 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r107)});
        goto L28
    L23:
        r108 = false;
        goto L25
    L17:
        r106 = false;
        goto L18
    L10:
        r102 = r101;
        goto L11
    L59:
        return;
    }

    public static final void a(Context r110, String r210) {
        Intrinsics.checkNotNullParameter(r210, "source");
        FragmentActivity r100 = ContextUtil.contextToFragmentActivity(r110);
        if (r100 == null) goto L61;
        FragmentManager r101 = r100.getSupportFragmentManager();
        if (r101 == null) goto L63;
        Fragment r102 = r101.findFragmentByTag("TuningPanelDialog");
        Function1<ViewGroup, com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.view.a> r103 = null;
        if ((r102 instanceof DialogFragment) == true) goto L10;
        r102 = null;
    L10:
        DialogFragment r104 = (DialogFragment) r102;
        if (r104 == null) goto L19;
        r104.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L19;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        if (r101.findFragmentByTag("TuningPanelDialog") != null) goto L62;
        int r106 = TuningPanelDialog.f70584m;
        ChorusContext.a r107 = ChorusContext.Companion;
        ChorusContext r108 = r107.getContext();
        if (r108 == null) goto L27;
        n<List<MusicPanel>> r109 = r108.getChorusSelectedSongList();
        if (r109 == null) goto L27;
        List<MusicPanel> r111 = r109.getValue();
        if (r111 == null) goto L27;
        int r112 = r111.size();
    L28:
        final a r113 = d();
        KSongTuningPanelOuterCallback r114 = new KSongTuningPanelOuterCallback();
        if (r107.c() == true) goto L31;
    L33:
        MultiChorusContext.a r115 = MultiChorusContext.Companion;
        if (r115.c() == true) goto L36;
    L43:
        ec0.a r116 = e();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.n r117 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.n(r113);
        KSongTuningButtonOuterCallback r118 = new KSongTuningButtonOuterCallback(r113, r114);
        Function1<ViewGroup, View> r119 = new KSongTuningPanelHelperKt$getTuningPanelConfig$3(r113);
        if (r113 != null) goto L46;
    L48:
        ac0.b r120 = new ac0.b(true, r114, r118, r117, new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.j(), r119, r103, r113, r116, false, 8331);
    L49:
        Intrinsics.checkNotNullParameter(r120, "config");
        TuningPanelDialog r121 = new TuningPanelDialog(r120);
        LandscapeRestrictionOperation r122 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r121, "TuningPanelDialog", r122);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r121, r122) == false) goto L57;
    L54:
        pd2.d.f528658n.getClass();
        Intrinsics.checkNotNullParameter(r210, "source");
        pd2.d.w(LinkMonitorData.BusinessAdjustTonePanelShow, new JSONObject().put("source", r210));
        return;
    L57:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L53:
        r121.show(r101, "TuningPanelDialog");
        goto L54
    L46:
        if (r113.O() != true) goto L48;
        r103 = new KSongTuningPanelHelperKt$getTuningPanelConfig$4(r113);
        goto L48
    L36:
        if (r115.a() != 2) goto L43;
    L37:
        s r123 = new s(r113);
        KSongViceSingerTuningButtonOuterCallback r124 = new KSongViceSingerTuningButtonOuterCallback();
        Function1<ViewGroup, View> r125 = new KSongTuningPanelHelperKt$getTuningPanelConfig$1(r113);
        if (r113 != null) goto L40;
    L42:
        r120 = new ac0.b(false, r114, r124, r123, null, r125, r103, r113, null, false, 12682);
        goto L49
    L40:
        if (r113.O() != true) goto L42;
        r103 = new KSongTuningPanelHelperKt$getTuningPanelConfig$2(r113);
        goto L42
    L31:
        if (r107.a() != 2) goto L33;
        if (r112 != 0) goto L37;
    L27:
        r112 = 0;
        goto L28
    L62:
        return;
    L63:
        return;
    }

    public static final Pair<DataContext, Disposable> b(boolean r100, com.bytedance.android.live.pushstream.d r101, WeakReference<Context> r102) {
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == false) goto L10;
        if (r101 == null) goto L17;
        Pair r103 = d.a(KSongTuningPanelHelperKt$initKSongTuningDataContextIfNeed$1.INSTANCE);
        KtvModeTuningDataContext r104 = (KtvModeTuningDataContext) r103.component1();
        Disposable r105 = (Disposable) r103.component2();
        KtvModeOrderSongDataContext.Companion.getClass();
        KSongTuningMusicControl r106 = new KSongTuningMusicControl(KtvModeOrderSongDataContext.Companion.a());
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r107 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r101, r106, r102);
        r107.j0();
        r104.setMTuningCore(r107);
        r104.setMTuningMusicControl(r106);
        com.bytedance.live.datacontext.b.a(r104, KtvModeTuningDataContext.class);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r108 = KtvModeOrderSongDataContext.Companion.a();
        if (r108 == null) goto L8;
        r108.getOrderedSongList(false);
    L8:
        r107.n0();
        return new Pair(r104, r105);
    L17:
        return new Pair(null, null);
    L10:
        if (r101 == null) goto L17;
        Pair r109 = d.a(KSongTuningPanelHelperKt$initKSongTuningDataContextIfNeed$2.INSTANCE);
        KtvComponentTuningDataContext r110 = (KtvComponentTuningDataContext) r109.component1();
        Disposable r111 = (Disposable) r109.component2();
        KtvComponentOrderSongDataContext.Companion.getClass();
        KSongTuningMusicControl r112 = new KSongTuningMusicControl(KtvComponentOrderSongDataContext.Companion.a());
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r113 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r101, r112, r102);
        r113.j0();
        r110.setMTuningCore(r113);
        r110.setMTuningMusicControl(r112);
        com.bytedance.live.datacontext.b.a(r110, KtvComponentTuningDataContext.class);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r114 = KtvComponentOrderSongDataContext.Companion.a();
        if (r114 == null) goto L14;
        r114.getOrderedSongList(false);
    L14:
        r113.n0();
        return new Pair(r110, r111);
    }
}
