package com.bytedance.android.anniex.lite;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.container.ui.e;
import com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.crash.d;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.l0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ia.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ies/bullet/service/base/l0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLiteFragment extends AppCompatDialogFragment implements l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.anniex.base.builder.a f40781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f40782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f40783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f40784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f40785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnnieXLitePageContainer f40786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f40787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f40788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnnieXLiteFragment$lifecycleObserver$1 f40789l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.service.base.l0
    public final String MW() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setArguments(Bundle r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.service.base.l0
    public final String B() {
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L16;
        String r101 = null;
        String r102 = (String) new p(r100.getAnnieXContext().f532202f.f544443a, "bundle", null).f565862b;
        if (r102 != null) goto L15;
        com.bytedance.android.anniex.base.builder.a r103 = this.f40781d;
        if (r103 == null) goto L11;
        Bundle r104 = r103.f40260c;
        if (r104 == null) goto L11;
        r101 = r104.getString("__x_param_bundle");
    L11:
        if (r101 != null) goto L17;
        return "";
    L17:
        return r101;
    L15:
        return r102;
    L16:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.l0
    public final String getBid() {
        com.bytedance.android.anniex.base.builder.a r100 = this.f40781d;
        if (r100 == null) goto L7;
        String r101 = r100.f40259b;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f40782e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.service.base.l0
    public final String getChannel() {
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L16;
        String r101 = null;
        String r102 = (String) new p(r100.getAnnieXContext().f532202f.f544443a, "channel", null).f565862b;
        if (r102 != null) goto L15;
        com.bytedance.android.anniex.base.builder.a r103 = this.f40781d;
        if (r103 == null) goto L11;
        Bundle r104 = r103.f40260c;
        if (r104 == null) goto L11;
        r101 = r104.getString("__x_param_channel");
    L11:
        if (r101 != null) goto L17;
        return "";
    L17:
        return r101;
    L15:
        return r102;
    L16:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.l0
    public final String getContainerId() {
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L6;
        String r101 = r100.getContainerId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.l0
    public final Uri getSchema() {
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L5;
        String r101 = r100.getCurrentUrl();
    L7:
        return UriProtector.parse(r101);
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.anniex.lite.AnnieXLiteFragment$lifecycleObserver$1] */
    public AnnieXLiteFragment() {
        this.f40782e = "default_bid";
        this.f40788k = LazyKt.lazy(new AnnieXLiteFragment$pageDelegate$2(this));
        this.f40789l = new AnnieXLiteFragment$lifecycleObserver$1(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.l0
    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L11;
        d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f40786i = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L5;
        r100.onPause();
    L5:
        AnnieXLitePageContainer r101 = this.f40786i;
        if (r101 == null) goto L9;
        r101.enterBackground();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L5;
        r100.onResume();
    L5:
        AnnieXLitePageContainer r101 = this.f40786i;
        if (r101 == null) goto L9;
        r101.enterForeground();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        AnnieXLitePageContainer r100 = this.f40786i;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
    }

    public final void S90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        List<AnnieXLiteFragment> r101 = LitePageService.f40791a;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        ((ArrayList) LitePageService.f40791a).remove(this);
        AnnieXLitePageContainer r102 = this.f40786i;
        if (r102 == null) goto L5;
        r102.release();
    L5:
        na.b r103 = (na.b) this.f40788k.getValue();
        if (r103 == null) goto L8;
        r103.onRelease();
    L8:
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L14;
        Lifecycle r105 = r104.getLifecycle();
        if (r105 == null) goto L15;
        r105.removeObserver(this.f40789l);
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L5;
        Intent r102 = r101.getIntent();
    L6:
        this.f40785h = r102;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L12;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L13;
        r104.addObserver(this.f40789l);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L8;
        String r101 = r100.getString("bid");
        if (r101 != null) goto L7;
        r101 = "default_bid";
    L7:
        this.f40782e = r101;
        this.f40783f = r100.getString("__x_inner_schema");
        this.f40784g = r100.getString("__x_session_id");
        com.bytedance.android.anniex.base.builder.a r102 = new com.bytedance.android.anniex.base.builder.a();
        String r103 = this.f40782e;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f40259b = r103;
        FragmentActivity r104 = requireActivity();
        Intrinsics.checkNotNullParameter(r104, "activity");
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f40258a = r104;
        r102.b(r100);
        this.f40781d = r102;
    L8:
        e.a r105 = e.f40565c;
        Context r106 = getContext();
        String r107 = this.f40782e;
        r105.getClass();
        boolean r108 = e.a.a(r106, r107, "AnnieXLiteFragment");
        AnnieXLitePageContainer r109 = null;
        if (r108 == true) goto L21;
        if (h.p() == false) goto L21;
        HybridLogger r110 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXLiteFragment", "tryInitAnnieXIfNeed failed, bid = " + this.f40782e, null, null, 12);
        dismissAllowingStateLoss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r111 = DialogFragmentLancet.sLastShowStack;
        if (r111 == null) goto L45;
        d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L45:
        return;
    L21:
        if (this.f40786i != null) goto L28;
        com.bytedance.android.anniex.base.builder.a r112 = this.f40781d;
        if (r112 == null) goto L25;
        r109 = new AnnieXLitePageContainer(r112);
    L25:
        this.f40786i = r109;
        if (r109 == null) goto L28;
        r109.f40853g = (na.b) this.f40788k.getValue();
    L28:
        AnnieXLitePageContainer r113 = this.f40786i;
        if (r113 == null) goto L39;
        na.b r114 = (na.b) this.f40788k.getValue();
        if (r114 == null) goto L38;
        com.bytedance.android.anniex.base.builder.a r115 = this.f40781d;
        if (r115 != null) goto L35;
    L36:
        new Bundle();
    L37:
        r114.c();
        goto L38
    L35:
        if (r115.f40260c != null) goto L37;
    L38:
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r113.f40848b = this;
    L39:
        AnnieXLitePageContainer r116 = this.f40786i;
        if (r116 == null) goto L47;
        r116.onCreate(r100);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.addFlags(256);
    L5:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        S90(r100);     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putString("bid", this.f40782e);
        r100.putString("__x_inner_schema", this.f40783f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        AnnieXLitePageContainer r101 = this.f40786i;
        if (r101 == null) goto L6;
        r101.setUserVisibleHint(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (getActivity() != null) goto L7;
        String r102 = this.f40784g;
        if (r102 == null) goto L7;
        Map<String, i36.d> r103 = MonitorManager.f40977a;
        MonitorManager.i(this.f40782e, r102, AbsBulletMonitorCallback.ErrStage.Container);
    L7:
        View r104 = this.f40787j;
        if (r104 != null) goto L10;
    L12:
        String r105 = this.f40783f;
        if (r105 == null) goto L18;
        AnnieXLitePageContainer r106 = this.f40786i;
        if (r106 == null) goto L19;
        r106.loadSchema(r105, null);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (this.f40786i == null) goto L12;
        Intrinsics.checkNotNullParameter(r104, "view");
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        na.b r103 = (na.b) this.f40788k.getValue();
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.annie_x_fragment, r101, false);
        this.f40787j = r103;
        AnnieXLitePageContainer r104 = this.f40786i;
        if (r104 == null) goto L6;
        r104.a(r103);
    L6:
        if (this.f40787j == null) goto L17;
        if (this.f40786i == null) goto L17;
        na.b r105 = (na.b) this.f40788k.getValue();
        if (r105 == null) goto L17;
        Intrinsics.checkNotNull(this.f40787j);
        f.a r106 = r105.b();
        if (r106 == null) goto L17;
        AnnieXLitePageContainer r107 = this.f40786i;
        if (r107 == null) goto L17;
        r107.d(r106);
    L17:
        return this.f40787j;
    }
}
