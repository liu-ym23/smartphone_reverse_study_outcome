package com.obric.autoaction.app.launcherpage.detail.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.p;
import com.obric.event.task.base.report.ActionReportSession;
import com.obric.oui.sheet.v2.OSheet;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseOSheetDialogFragment<R> extends DialogFragment {
    public static final a Companion = null;
    private final com.obric.autoaction.common.base.a extensionHolder;
    private d.h.a.a<x> onDismiss;
    private d.h.a.b<? super R, x> onResult;
    private ActionReportSession pageEnterSession;

    /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
        static final class C0504a implements d.h.a.b<R, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f23227a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<R> f23228b;

            C0504a(AtomicBoolean r3, n<? super R> r4) {
                n<R> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f23227a = r3;
                this.f23228b = r5;
            }

            public final void a(R r2) {
                a.a(this.f23227a, this.f23228b, r2);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Object r1) {
                a(r1);
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
        static final class b implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f23229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<R> f23230b;

            b(AtomicBoolean r3, n<? super R> r4) {
                n<R> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f23229a = r3;
                this.f23230b = r5;
            }

            public final void a() {
                a.a(this.f23229a, this.f23230b, null);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }
        }

        /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
        static final class c implements d.h.a.b<Throwable, x> {

            /* JADX INFO: Incorrect field signature: TT; */
            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BaseOSheetDialogFragment f23231a;

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            c(BaseOSheetDialogFragment r1) {
                this.f23231a = r1;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r2) {
                BaseOSheetDialogFragment r1 = this.f23231a;
                d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L8
                if (((Fragment) ZeusTransformUtils.preCheckCast(r1, Fragment.class, "com.obric.aiagent.plugin")).isAdded() == false) goto L6;
                ((DialogFragment) ZeusTransformUtils.preCheckCast(r1, DialogFragment.class, "com.obric.aiagent.plugin")).dismissAllowingStateLoss();     // Catch: Throwable -> L8
            L6:
                d.n.f(x.f38692a);     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                d.n.a r3 = d.n.f38560a;
                d.n.f(o.a(th));
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(AtomicBoolean r2, n r3, Object r4) {
            b(r2, (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin"), r4);
        }

        private static final <R> void b(AtomicBoolean r2, n<? super R> r3, R r4) {
            n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            if (r2.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (r5.a() == false) goto L9;
            d.n.a r6 = d.n.f38560a;
            r5.resumeWith(d.n.f(r4));
            return;
        }

        public final <R, T extends BaseOSheetDialogFragment<R>> Object a(T r6, FragmentActivity r7, String r8, d.c.d<? super R> r9) {
            FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r7, FragmentActivity.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.o r11 = new kotlinx.coroutines.o(d.c.a.b.a(r10), 1);
            r11.e();
            n r1 = (n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin");
            AtomicBoolean r2 = new AtomicBoolean(false);
            r6.setOnResult((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0504a(r2, r1), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.setOnDismiss((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2, r1), d.h.a.a.class, "com.obric.aiagent.plugin"));
            r1.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r6), d.h.a.b.class, "com.obric.aiagent.plugin"));
            ((DialogFragment) ZeusTransformUtils.preCheckCast(r6, DialogFragment.class, "com.obric.aiagent.plugin")).show(r5.getSupportFragmentManager(), r8);
            Object r12 = r11.h();
            if (r12 != d.c.a.b.a()) goto L5;
            d.c.b.a.h.c(r10);
        L5:
            return r12;
        }
    }

    /* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
    public static final class b implements com.obric.oui.dialog.a.c {
        @Override // com.obric.oui.dialog.a.c
        public void b(Dialog r1) {
            d.h.b.o.e(r1, "dialog");
        }

        b() {
        }

        @Override // com.obric.oui.dialog.a.c
        public void a(Dialog r2) {
            d.h.b.o.e(r2, "dialog");
            if (Build.VERSION.SDK_INT < 29) goto L8;
            Window r1 = r2.getWindow();
            if (r1 == null) goto L9;
            r1.setNavigationBarContrastEnforced(true);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: compiled from: View.kt */
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f23232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseOSheetDialogFragment f23233b;

        public c(View r1, BaseOSheetDialogFragment r2) {
            this.f23232a = r1;
            this.f23233b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionReportSession r0 = BaseOSheetDialogFragment.access$getPageEnterSession$p(this.f23233b);
            if (r0 == null) goto L5;
            ActionReportSession.a(r0, null, 1, null);
        L5:
            BaseOSheetDialogFragment.access$setPageEnterSession$p(this.f23233b, null);
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$Ez5ZnmILX_xHf08ml-qJ1foJaSQ, reason: not valid java name */
    public static /* synthetic */ x m466lambda$Ez5ZnmILX_xHf08mlqJ1foJaSQ(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$BaseOSheetDialogFragment$Ez5ZnmILX_xHf08mlqJ1foJaSQ.INSTANCE;
    }

    public abstract void configureSheet(OSheet r1, Bundle r2);

    public String getPageEnterFrom() {
        return DownloadSettingKeys.BugFix.DEFAULT;
    }

    public String getPageEnterPageName() {
        return null;
    }

    public void onSheetDismissed() {
    }

    public BaseOSheetDialogFragment() {
        this.extensionHolder = new com.obric.autoaction.common.base.a();
    }

    public static final /* synthetic */ ActionReportSession access$getPageEnterSession$p(BaseOSheetDialogFragment r0) {
        return r0.pageEnterSession;
    }

    public static final /* synthetic */ void access$setPageEnterSession$p(BaseOSheetDialogFragment r0, ActionReportSession r1) {
        r0.pageEnterSession = r1;
    }

    public final d.h.a.b<R, x> getOnResult() {
        return this.onResult;
    }

    public final void setOnResult(d.h.a.b<? super R, x> r3) {
        this.onResult = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.a<x> getOnDismiss() {
        return this.onDismiss;
    }

    public final void setOnDismiss(d.h.a.a<x> r3) {
        this.onDismiss = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r1) {
        d.h.b.o.e(r1, "<this>");
        return x.f38692a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (r10 == null) goto L6;
        dismissAllowingStateLoss();
        return;
    L6:
        JSONObject r11 = buildPageEnterParams();
        if (r11 == null) goto L9;
        ActionReportSession r8 = new ActionReportSession("obric_tech_event_task_page_enter", r11);
        ActionReportSession.a(r8, (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"), 0, null, 6, null);
        this.pageEnterSession = r8;
    L9:
        configExtension().invoke(this.extensionHolder);
        this.extensionHolder.a((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        OSheet r0 = createSheet();
        r0.setHeaderView(null);
        r0.setHeightMode(OSheet.c.f36215a);
        r0.enableIgnoreInsetBottom(false);
        r0.setOnShowAnimListener((com.obric.oui.dialog.a.c) ZeusTransformUtils.preCheckCast(new b(), com.obric.oui.dialog.a.c.class, "com.obric.aiagent.plugin"));
        configureSheet(r0, r5);
        return (Dialog) ZeusTransformUtils.preCheckCast(r0, Dialog.class, "com.obric.aiagent.plugin");
    }

    public OSheet createSheet() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "requireContext(...)");
        return (OSheet) ZeusTransformUtils.preCheckCast(new BottomImmersionOSheet(r3), OSheet.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "dialog");
        super.onDismiss(r4);
        d.h.a.a<x> r5 = this.onDismiss;
        this.onDismiss = null;
        this.onResult = null;
        if (r5 == null) goto L5;
        r5.invoke();
    L5:
        onSheetDismissed();
    }

    public static /* synthetic */ void reportPageEnterFail$default(BaseOSheetDialogFragment r0, String r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        r0.reportPageEnterFail(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportPageEnterFail");
    }

    public final void reportPageEnterFail(String r8, int r9) {
        d.h.b.o.e(r8, "errorMessage");
        ActionReportSession r1 = this.pageEnterSession;
        if (r1 == null) goto L5;
        ActionReportSession.a(r1, r9, r8, null, 4, null);
    L5:
        this.pageEnterSession = null;
    }

    public final void dismissWithAnimation() {
        Dialog r0 = getDialog();
        if (ZeusTransformUtils.instanceOf(r0, OSheet.class) == false) goto L5;
        OSheet r1 = (OSheet) ZeusTransformUtils.preCheckCast(r0, OSheet.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.dismiss();
        return;
    L8:
        dismissAllowingStateLoss();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void deliverResultAndDismiss(R r3) {
        d.h.a.b<? super R, x> r0 = this.onResult;
        this.onResult = null;
        if (r0 == null) goto L5;
        r0.invoke(r3);
    L5:
        dismissAllowingStateLoss();
    }

    private final JSONObject buildPageEnterParams() {
        String r0 = getPageEnterPageName();
        if (r0 != null) goto L6;
        return null;
    L6:
        String r3 = getPageEnterFrom();
        JSONObject r1 = new JSONObject();
        r1.put("page_name", r0);
        r1.put("enter_from", r3);
        return r1;
    }

    public final void reportPageEnterSuccessOnPreDraw(View r3) {
        if (r3 == null) goto L5;
        OneShotPreDrawListener.add(r3, (Runnable) ZeusTransformUtils.preCheckCast(new c(r3, this), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    }
}
