package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.ConcertTuningVolumeOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningPanelOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ConcertTuner implements ld2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f146522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f146523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ld2.b f146524c;

    @Override // ld2.a
    public final void c() {
        KtvModeTuningDataContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = KtvModeTuningDataContext.b.a();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // ld2.a
    public final void destroy() {
        Disposable r100 = this.f146522a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        r100.dispose();
        return;
    }

    @Override // ld2.a
    public final void a(com.bytedance.android.live.pushstream.d r100) {
        Pair r101 = com.bytedance.live.datacontext.d.a(ConcertTuner$initTuningContext$1.INSTANCE);
        KtvModeTuningDataContext r102 = (KtvModeTuningDataContext) r101.component1();
        Disposable r103 = (Disposable) r101.component2();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r104 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r100, null, new WeakReference(this.f146523b));
        r104.j0();
        r102.setMTuningCore(r104);
        com.bytedance.live.datacontext.b.a(r102, KtvModeTuningDataContext.class);
        this.f146522a = r103;
    }

    public ConcertTuner(Context r100, ld2.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f146523b = r100;
        this.f146524c = r101;
    }

    @Override // ld2.a
    public final void b(String r110, int r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "source");
        FragmentActivity r100 = ContextUtil.contextToFragmentActivity(this.f146523b);
        if (r100 == null) goto L32;
        FragmentManager r101 = r100.getSupportFragmentManager();
        if (r101 == null) goto L34;
        Fragment r102 = r101.findFragmentByTag("TuningPanelDialog");
        if ((r102 instanceof DialogFragment) == true) goto L10;
        r102 = null;
    L10:
        DialogFragment r103 = (DialogFragment) r102;
        if (r103 == null) goto L19;
        r103.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L19;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        if (r101.findFragmentByTag("TuningPanelDialog") != null) goto L33;
        int r105 = TuningPanelDialog.f70584m;
        KtvModeTuningDataContext.Companion.getClass();
        final com.bytedance.android.live.ktv.common.tuningpanel.ability.a r111 = KtvModeTuningDataContext.b.a();
        KSongTuningPanelOuterCallback r106 = new KSongTuningPanelOuterCallback();
        ConcertTuningVolumeOuterCallback r112 = new ConcertTuningVolumeOuterCallback(r111, this.f146524c, r211, r210);
        ac0.b r107 = new ac0.b(false, r106, new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.a(), r112, null, new ConcertTuner$buildTuningPanelConfig$1(r111), null, r111, null, false, 13706);
        Intrinsics.checkNotNullParameter(r107, "config");
        TuningPanelDialog r108 = new TuningPanelDialog(r107);
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r108, "TuningPanelDialog", r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r108, r109) == false) goto L30;
    L25:
        pd2.d.f528658n.getClass();
        Intrinsics.checkNotNullParameter(r110, "source");
        JSONObject r113 = new JSONObject().put("source", r110);
        pd2.d.w(LinkMonitorData.BusinessAdjustTonePanelShow, r113);
        return;
    L30:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L24:
        r108.show(r101, "TuningPanelDialog");
        goto L25
    L33:
        return;
    L34:
        return;
    }
}
