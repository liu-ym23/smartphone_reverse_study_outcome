package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AbsAudienceToolbarButtonMoreDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/d2;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/s;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b2;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsAudienceToolbarButtonMoreDialog extends CommonStandardBottomDialog implements View.OnClickListener, d2, Observer<KVData>, s<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e>, b2 {
    public final String B;
    public final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> C;
    public ToolbarDisableController D;
    public final TreeSet<RedDotDelegate> E;
    public DataCenter F;
    public final ArrayList<Pair<ViewGroup, Integer>> G;
    public RecyclerView H;
    public x3 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CompositeDisposable f115587J;
    public MorePanelButtonDiffUpdater<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> K;
    public boolean L;
    public final Lazy M;
    public final a N;
    public String O;
    public final float P;

    public static final class a implements com.bytedance.android.live.room.api.panel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog f115588a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog$a$a, reason: collision with other inner class name */
        public static final class RunnableC1714a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f115589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f115590b;

            public RunnableC1714a(View r100, Function1 r101) {
                this.f115589a = r100;
                this.f115590b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f115590b.invoke(Integer.valueOf(this.f115589a.getHeight()));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final int getUnionId() {
            return hashCode();
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final PanelName getPanelName() {
            return PanelName.More;
        }

        public a(AbsAudienceToolbarButtonMoreDialog r100) {
            this.f115588a = r100;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final void a(Function1<? super Integer, Unit> r100, Function1<? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "continueAction");
            Intrinsics.checkNotNullParameter(r101, "stopAction");
            AbsAudienceToolbarButtonMoreDialog r102 = this.f115588a;
            r102.getClass();
            View r103 = r102.findViewById(R.id.ttlive_design_bottom_sheet);
            if (r103 == null) goto L5;
            r103.post(new RunnableC1714a(r103, r100));
            return;
        L5:
            r101.invoke("rootView is null");
        }
    }

    public void X0(ExtendedToolbarButton r100, c0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "behavior");
    }

    public final jp1.c a1() {
        return (jp1.c) this.M.getValue();
    }

    public abstract x3 b1();

    public void g1() {
    }

    public void h1() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void f1() {
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r100 = this.C;
        jp1.c r101 = a1();
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        ALogger.i(this.B, "isPaused:" + c1());
        x3 r102 = this.I;
        if (r102 == null) goto L16;
        if (c1() == false) goto L12;
        ArrayList<ExtendedToolbarButton> r103 = Y0(r100);
        ToolbarDisableController r104 = this.D;
        if (r104 == null) goto L16;
        r104.a(r102, r103, AbsAudienceToolbarButtonMoreDialog$adaptiveToolbarsDisable$1$1.INSTANCE);
        goto L16
    L12:
        ToolbarDisableController r105 = this.D;
        if (r105 == null) goto L16;
        r105.b(r102);
    L16:
        if (this.G.isEmpty() == false) goto L19;
        return;
    L19:
        if (c4.a(false) == false) goto L21;
        this.E.clear();
        RedDotHelper.b(Y0(r100), this.I, this.E);
    L21:
        MorePanelButtonDiffUpdater<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r106 = this.K;
        if (r106 == null) goto L102;
        Intrinsics.checkNotNullParameter(r100, "buttons");
        ArrayList r107 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r108 = r100.iterator();
    L24:
        boolean r109 = true;
        if (r108.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r110 = r108.next();
        if (r110.getGroupType() == 1) goto L30;
        r109 = false;
    L30:
        if (r109 == false) goto L24;
        r107.add(r110);
        goto L24
    L32:
        RecyclerView r111 = r106.f115687b;
        if (r111 != null) goto L36;
    L46:
        HashMap r112 = new HashMap();
        Iterator<T> r113 = r106.f115686a.iterator();
    L48:
        if (r113.hasNext() == false) goto L72;
        Pair r114 = (Pair) r113.next();
        ViewGroup r115 = (ViewGroup) r114.getFirst();
        ArrayList r116 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r117 = r100.iterator();
    L51:
        if (r117.hasNext() == false) goto L58;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r118 = r117.next();
        if (r118.getGroupType() != ((Number) r114.getSecond()).intValue()) goto L55;
        boolean r119 = true;
    L56:
        if (r119 == false) goto L51;
        r116.add(r118);
        goto L51
    L55:
        r119 = false;
        goto L56
    L58:
        int r120 = r115.getChildCount();
        int r121 = 0;
    L59:
        if (r121 >= r120) goto L48;
        View r122 = r115.getChildAt(r121);
        Iterator r123 = r116.iterator();
    L62:
        if (r123.hasNext() == false) goto L67;
        Object r124 = r123.next();
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.e) r124, r122.getTag()) == false) goto L62;
    L68:
        com.bytedance.android.livesdk.chatroom.e r125 = (com.bytedance.android.livesdk.chatroom.e) r124;
        if (r125 == null) goto L71;
        View r126 = (View) r112.put(r125, r122);
    L71:
        r121 = r121 + 1;
        goto L59
    L67:
        r124 = null;
        goto L68
    L72:
        Iterator<T> r127 = r106.f115686a.iterator();
    L74:
        if (r127.hasNext() == false) goto L76;
        ((ViewGroup) ((Pair) r127.next()).getFirst()).removeAllViews();
        goto L74
    L76:
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r128 = r100.iterator();
    L78:
        if (r128.hasNext() == false) goto L102;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r129 = r128.next();
        Iterator<T> r130 = r106.f115686a.iterator();
    L81:
        if (r130.hasNext() == false) goto L88;
        Object r131 = r130.next();
        if (((Number) ((Pair) r131).getSecond()).intValue() != r129.getGroupType()) goto L85;
        boolean r132 = true;
    L86:
        if (r132 == false) goto L81;
    L89:
        Pair r133 = (Pair) r131;
        if (r133 == null) goto L92;
        ViewGroup r134 = (ViewGroup) r133.getFirst();
    L93:
        if (r134 == null) goto L78;
        View r135 = (View) r112.get(r129);
        if (r135 == null) goto L97;
    L101:
        r134.addView(r135);
        goto L78
    L97:
        if (com.bytedance.android.livesdk.config.setting.o.b() == false) goto L99;
        float r136 = 5.0f;
    L100:
        r135 = r106.f115688c.x(r134, r136, r129);
        r106.f115688c.o(null, r129, r135, 0);
        goto L101
    L99:
        r136 = 4;
        goto L100
    L92:
        r134 = null;
        goto L93
    L85:
        r132 = false;
        goto L86
    L88:
        r131 = null;
        goto L89
    L36:
        if (r111.getAdapter() != null) goto L38;
        r111.setAdapter(new MorePanelButtonDiffUpdater.DynamicItemAdapter(r106));
    L38:
        RecyclerView.Adapter r137 = r111.getAdapter();
        if ((r137 instanceof MorePanelButtonDiffUpdater.DynamicItemAdapter) == true) goto L41;
        r137 = null;
    L41:
        MorePanelButtonDiffUpdater.DynamicItemAdapter r138 = (MorePanelButtonDiffUpdater.DynamicItemAdapter) r137;
        if (r138 == null) goto L44;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r138.f115689a = r107;
    L44:
        if (r138 == null) goto L46;
        r138.notifyDataSetChanged();
    L102:
        g1();
    }

    public final int Z0() {
        Iterator<T> r100 = this.G.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        Pair r102 = (Pair) r100.next();
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r103 = this.C;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r106).f115917i != ((Number) r102.getSecond()).intValue()) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        r107 = false;
        goto L12
    L14:
        r101 = Math.max(r104.size(), r101);
        goto L4
    L15:
        return r101;
    }

    public final boolean c1() {
        DataCenter r100 = this.F;
        zg1.m r101 = null;
        if (r100 == null) goto L5;
        r101 = (zg1.m) r100.get("data_broadcast_pause_state", null);
    L5:
        if (r101 == null) goto L11;
        int r102 = r101.f571877a;
        if (r102 != 1) goto L9;
        return true;
    L9:
        if (r102 != 2) goto L11;
        return true;
    L11:
        return false;
    }

    public void i1() {
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r100 = this.C.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r101 = r100.next();
        x3 r102 = this.I;
        if (r102 == null) goto L8;
        c0.b r103 = r102.s(r101.f115921m);
    L10:
        if ((r103 instanceof n) == false) goto L4;
        ((n) r103).onShow();
        goto L4
    L8:
        r103 = null;
        goto L10
    L12:
        DataCenter r104 = this.F;
        if (r104 == null) goto L15;
        r104.observe("cmd_live_toolbarmore_dialog_dismiss", this);
    L15:
        xs2.b r105 = xs2.b.a();
        ds0.b r106 = new ds0.b();
        r106.a(LivePanelType.TOOL_BAR_MORE);
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r106.f469805b = "open";
        WeakReference<Dialog> r107 = new WeakReference(this);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f469807d = r107;
        r106.f469808e = R.id.ttlive_design_bottom_sheet;
        Unit r108 = Unit.INSTANCE;
        r105.post(r106);
        int r109 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r110 = com.bytedance.android.live.room.api.panel.d.c(this.F, 2);
        if (r110 == null) goto L24;
        r110.notifyPanelOpen(PanelName.More, this.N);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r100 = this.C;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r103).f115917i != 3) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        Iterator r105 = r101.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        s<Object> r106 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r105.next()).f115919k;
        if (r106 == null) goto L13;
        r106.j();
        goto L13
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f115587J.clear();
        DataCenter r100 = this.F;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        j();
        IFloatWindowDegradeManager r101 = (IFloatWindowDegradeManager) jc1.k.f(IFloatWindowDegradeManager.class);
        if (r101 == null) goto L8;
        r101.checkRecoverForNative("more_panel", "dismiss");
    L8:
        Iterator<T> r102 = this.C.iterator();
    L10:
        if (r102.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r103 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r102.next();
        x3 r104 = this.I;
        if (r104 == null) goto L14;
        c0.b r105 = r104.s(r103.f115921m);
    L15:
        if (r105 == null) goto L10;
        r105.Y6();
        goto L10
    L14:
        r105 = null;
        goto L15
    L17:
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        jp1.c r101 = a1();
        if (r101 == null) goto L20;
        r101.release();
    L20:
        com.bytedance.android.livesdk.f.d().g("MORE");
        xs2.b r102 = xs2.b.a();
        ds0.b r103 = new ds0.b();
        r103.a(LivePanelType.TOOL_BAR_MORE);
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r103.f469805b = "close";
        Unit r104 = Unit.INSTANCE;
        r102.post(r103);
        int r105 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r106 = com.bytedance.android.live.room.api.panel.d.c(this.F, 2);
        if (r106 == null) goto L29;
        r106.notifyPanelClose(PanelName.More, this.N);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r107 == null) goto L16;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = false;
        DataCenter r100 = this.F;
        if (r100 == null) goto L5;
        int r101 = z3.f116864a;
        z3.c(r100, !this.f154353r);
    L5:
        f1();
        IFloatWindowDegradeManager r102 = (IFloatWindowDegradeManager) jc1.k.f(IFloatWindowDegradeManager.class);
        if (r102 == null) goto L9;
        r102.checkDegradeForNative("more_panel");
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, android.app.Dialog
    public void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().b("MORE", this);
        i1();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final void c() {
        W0(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final CompositeDisposable getCompositeDisposable() {
        return this.f115587J;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final DataCenter getDataCenter() {
        return this.F;
    }

    public static void W0(AbsAudienceToolbarButtonMoreDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final ArrayList<ExtendedToolbarButton> Y0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r100) {
        ArrayList<ExtendedToolbarButton> r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r102.next()).f115921m);
        goto L4
    L6:
        return r101;
    }

    public final boolean e1(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        Iterator<T> r101 = this.C.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        ExtendedToolbarButton r102 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r101.next()).f115921m;
        if ((r102 instanceof ExtendedToolbarButton.b) == false) goto L4;
        if (((ExtendedToolbarButton.b) r102).f115626i != r100) goto L4;
        return true;
    L11:
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L9;
        W0(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        View r101 = null;
        String r102 = null;
        String r103 = null;
        if (r100 == null) goto L5;
        Object r104 = r100.getTag();
    L7:
        if ((r104 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r104 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r105 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r104;
        if (r105 == null) goto L12;
        ExtendedToolbarButton r106 = r105.f115921m;
    L13:
        if (r106 != null) goto L15;
        return;
    L15:
        if (c1() == false) goto L22;
        x3 r107 = this.I;
        if (r107 == null) goto L22;
        if (r107.x(r106) != true) goto L22;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_broadcast_voluntary_pause_feature_enable_toast, 0);
        return;
    L22:
        x3 r108 = this.I;
        if (r108 == null) goto L25;
        c0.b r109 = r108.s(r106);
    L26:
        x3 r110 = this.I;
        if (r110 != null) goto L29;
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r111 = r105.f115918j;
        if (r111 != null) goto L40;
    L48:
        if (r109 != null) goto L50;
        return;
    L50:
        if (c4.a(false) == false) goto L56;
        if (r100 == null) goto L54;
        r101 = r100.findViewById(R.id.red_dot);
    L54:
        if ((r101 instanceof RedDotView) == false) goto L56;
        ((RedDotView) r101).l();
    L56:
        r109.onClick(r100);
        b4.c.f115769a.b(r106.f());
        X0(r106, r109);
        return;
    L40:
        if (r111.a() != true) goto L48;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r112 = r105.f115918j;
        if (r112 == null) goto L45;
        r103 = r112.f115931b;
    L45:
        if (TextUtils.isEmpty(r103) == true) goto L59;
        com.bytedance.android.live.core.utils.f2.c(r103, 0);
        return;
    L59:
        return;
    L29:
        if (r110.x(r106) != true) goto L37;
        x3 r113 = this.I;
        if (r113 == null) goto L34;
        r102 = r113.u(r106);
    L34:
        if (TextUtils.isEmpty(r102) == true) goto L58;
        com.bytedance.android.live.core.utils.f2.c(r102, 0);
        return;
    L58:
        return;
    L25:
        r109 = null;
        goto L26
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        h1();
        this.D = new ToolbarDisableController(getContext());
        this.I = b1();
        this.K = new MorePanelButtonDiffUpdater(this.G, this.H, this);
        jp1.c r101 = a1();
        if (r101 == null) goto L6;
        hp1.c.a.C6181a r102 = hp1.c.a.f486370e;
        DataCenter r103 = this.F;
        Function1<hp1.c.a, Unit> r104 = new AbsAudienceToolbarButtonMoreDialog$createComposeSession$1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "b");
        hp1.c.a r105 = new hp1.c.a(r103);
        r104.invoke(r105);
        Intrinsics.checkNotNullParameter(r105, "$this$build");
        r101.c(new hp1.c(r105));
        return;
    }

    @Override // com.bytedance.android.livesdk.utils.y1
    public final void setDataCenter(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.F = r100;
        if (r100 == null) goto L6;
        Room r101 = (Room) r100.get("data_room", null);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void setEnterFrom(String r100) {
        this.O = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void l0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r110, boolean r111) {
        if (r110 == null) goto L75;
        List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r100 = r110;
        if ((!r100.isEmpty()) != true) goto L78;
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r101 = this.C;
        if (r101.size() == r110.size()) goto L9;
    L8:
        boolean r112 = false;
    L16:
        if (r112 == false) goto L19;
        ALogger.i("AbsAudienceToolbarButtonMoreDialog", "all button same");
        return;
    L19:
        this.C.clear();
        this.C.addAll(r100);
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r113 = this.C;
        jp1.c r102 = a1();
        if (r102 == null) goto L64;
        jp1.d<Object> r103 = r102.d();
        if (r103 == null) goto L64;
        List<com.bytedance.android.livesdk.chatroom.e> r104 = r103.b(r113);
        if (r104 == null) goto L64;
        List r105 = CollectionsKt.filterIsInstance(r104, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e.class);
        if (r105 == null) goto L64;
        List r106 = r105;
        if ((!r106.isEmpty()) == false) goto L30;
        this.C.clear();
        this.C.addAll(r106);
    L30:
        String r107 = this.B;
        StringBuilder r108 = new StringBuilder("面板初始按钮:");
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L32:
        if (r114.hasNext() == false) goto L34;
        r109.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r114.next()).f115914f);
        goto L32
    L34:
        Object[] r115 = r109.toArray(new String[0]);
        if (r115 == null) goto L63;
        r108.append(Arrays.toString(r115));
        r108.append("\n面板UI按钮：");
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r116 = this.C;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L38:
        if (r118.hasNext() == false) goto L40;
        r117.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r118.next()).f115914f);
        goto L38
    L40:
        Object[] r119 = r117.toArray(new String[0]);
        if (r119 == null) goto L61;
        r108.append(Arrays.toString(r119));
        ALogger.i(r107, r108.toString());
        List r120 = CollectionsKt.minus(r113, r105);
        if ((!r120.isEmpty()) == true) goto L46;
        r120 = null;
    L46:
        if (r120 == null) goto L64;
        JSONArray r121 = new JSONArray();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r122 = r113.iterator();
    L49:
        if (r122.hasNext() == false) goto L51;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r123 = r122.next();
        JSONObject r124 = new JSONObject();
        r124.put("id", r123.f115915g);
        r124.put("title", r123.f115914f);
        r121.put(r124);
        goto L49
    L51:
        Single.create(new c(this, r121)).subscribeOn(Schedulers.io()).subscribe();
        List r125 = r120;
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r127 = r125.iterator();
    L53:
        if (r127.hasNext() == false) goto L55;
        r126.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r127.next()).f115914f);
        goto L53
    L55:
        Object[] r128 = r126.toArray(new String[0]);
        if (r128 == null) goto L59;
        ALogger.i(this.B, "diff buttons:" + Arrays.toString((String[]) r128));
        goto L64
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L64:
        if (r111 == true) goto L66;
        return;
    L66:
        if (isShowing() == false) goto L77;
        f1();
        return;
    L77:
        return;
    L9:
        int r129 = r101.size();
        int r130 = 0;
    L10:
        if (r130 >= r129) goto L15;
        if ((!Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r101, r130), (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r110, r130))) == true) goto L8;
        r130 = r130 + 1;
        goto L10
    L15:
        r112 = true;
        goto L16
    L78:
        return;
    }

    public AbsAudienceToolbarButtonMoreDialog(final Context r100, boolean r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false, r110, 4);
        this.B = "AbsAudienceToolbarButtonMoreDialog";
        this.C = new ArrayList();
        this.E = new TreeSet();
        this.G = new ArrayList();
        this.f115587J = new CompositeDisposable();
        this.M = LazyKt.lazy(new AbsAudienceToolbarButtonMoreDialog$panelComposer$2(this, r100));
        this.N = new a(this);
        this.P = 0.64f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void o(WeakReference r110, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r111, View r112, int r113) {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r114 = r111;
        Intrinsics.checkNotNullParameter(r114, "button");
        Intrinsics.checkNotNullParameter(r112, "itemView");
        s<Object> r115 = r114.f115919k;
        if (r115 == null) goto L5;
        r115.o(new WeakReference(this), r114, r112, r113);
        return;
    L5:
        View r116 = r112.findViewById(R.id.icon);
        TextView r100 = (TextView) r112.findViewById(R.id.name);
        View r101 = r112.findViewById(R.id.red_dot);
        View r102 = r112.findViewById(R.id.action_area);
        TextView r103 = (TextView) r112.findViewById(R.id.icon_description);
        if (r116 == null) goto L8;
        r116.setBackgroundResource(r114.f115910b);
    L8:
        if (r100 == null) goto L10;
        r100.setText(r114.f115914f);
    L10:
        if (r100 == null) goto L13;
        r100.setAccessibilityDelegate(com.bytedance.android.live.core.utils.t.f66402a);
    L13:
        if (com.bytedance.android.livesdk.config.setting.o.b() == true) goto L15;
    L18:
        int r104 = 0;
        if (r114.f115909a == false) goto L30;
        List<String> r105 = r114.f115911c;
        if (r105 == null) goto L30;
        if ((!r105.isEmpty()) != true) goto L30;
        CompositeDisposable r106 = this.f115587J;
        List<String> r107 = r114.f115911c;
        if (r107 == null) goto L28;
        String r108 = (String) ListProtector.get(r107, 0);
        if (r108 == null) goto L28;
    L29:
        r106.add(com.bytedance.android.livesdk.utils.g3.a(r108).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a(this)).onErrorComplete().subscribe(new b(this, r116)));
    L28:
        r108 = "";
    L30:
        if (r103 != null) goto L32;
    L34:
        if (r103 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r103);
    L37:
        if (r114.f115912d == false) goto L46;
        ImageView r109 = new ImageView(r116.getContext());
        if (r114.f115913e == false) goto L41;
        int r117 = R.drawable.ttlive_ic_toolbar_switch_on;
    L42:
        r109.setBackgroundResource(r117);
        LiveViewStub r118 = (LiveViewStub) r112.findViewById(R.id.icon_switch);
        if (r118 == null) goto L46;
        r118.a(r109);
        goto L46
    L41:
        r117 = R.drawable.ttlive_ic_toolbar_switch_off;
    L46:
        if (r102 == null) goto L48;
        r102.setAlpha(1.0f);
    L48:
        x3 r119 = this.I;
        if (r119 != null) goto L51;
    L52:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r120 = r114.f115918j;
        if (r120 != null) goto L55;
    L63:
        if (r116 == null) goto L65;
        r116.setAlpha(1.0f);
    L65:
        if (r100 == null) goto L67;
        r100.setAlpha(1.0f);
    L67:
        if (r101 == null) goto L69;
        r101.setAlpha(1.0f);
    L69:
        boolean r121 = false;
    L71:
        if (c4.a(false) == true) goto L73;
    L77:
        if (r116 == null) goto L108;
        ExtendedToolbarButton r122 = r114.f115921m;
        if (r101 == null) goto L108;
        if (TextUtils.isEmpty(r122.f()) == true) goto L108;
        if (c4.a(false) == true) goto L86;
        boolean r123 = b4.c.f115769a.d(r122, this.I);
    L91:
        if (r123 == false) goto L93;
        int r124 = 0;
    L94:
        r101.setVisibility(r124);
        if ((r122 instanceof ExtendedToolbarButton.c) == true) goto L97;
    L103:
        DataCenter r125 = this.F;
        if (r125 == null) goto L108;
        if (com.bytedance.android.live.core.utils.z.h(r125) != true) goto L108;
        r101.setVisibility(8);
        goto L108
    L97:
        if (((ExtendedToolbarButton.c) r122).f115636r == true) goto L99;
    L101:
        r104 = 8;
    L102:
        r101.setVisibility(r104);
        goto L103
    L99:
        if (h3.a(r122.f()) == true) goto L101;
    L93:
        r124 = 8;
        goto L94
    L86:
        if ((r101 instanceof RedDotView) == false) goto L88;
        r123 = ((RedDotView) r101).j();
        goto L91
    L88:
        r123 = false;
    L108:
        r112.setTag(r114);
        x3 r126 = this.I;
        if (r126 == null) goto L113;
        Map<ExtendedToolbarButton, View> r127 = r126.f116829c;
        if (r127 == null) goto L113;
        View r128 = (View) ((HashMap) r127).put(r114.f115921m, r112);
    L113:
        x3 r129 = this.I;
        if (r129 == null) goto L116;
        r129.D(r114.f115921m, r112);
    L116:
        r112.setOnClickListener(this);
        DataCenter r130 = this.F;
        Long r131 = null;
        if (r130 == null) goto L119;
        Long r132 = (Long) r130.get("data_anchor_current_game_id", -1L);
    L120:
        ExtendedToolbarButton r133 = r114.f115921m;
        if ((r133 instanceof ExtendedToolbarButton.c) == true) goto L123;
        r133 = null;
    L123:
        ExtendedToolbarButton.c r134 = (ExtendedToolbarButton.c) r133;
        if (r134 == null) goto L126;
        r131 = Long.valueOf(r134.f115631m);
    L126:
        boolean r135 = Intrinsics.areEqual(r132, r131);
        int r136 = z3.f116864a;
        z3.b(this.F, r114, r135, r121, r113);
        return;
    L119:
        r132 = null;
        goto L120
    L73:
        if ((r101 instanceof RedDotView) == false) goto L77;
        RedDotDelegate r137 = r114.f115921m.f115621c;
        if (r137 == null) goto L77;
        ((RedDotView) r101).n(r137, Boolean.FALSE);
        goto L77
    L55:
        if (r120.a() != true) goto L63;
    L56:
        if (r116 == null) goto L58;
        r116.setAlpha(this.P);
    L58:
        if (r100 == null) goto L60;
        r100.setAlpha(this.P);
    L60:
        if (r101 == null) goto L62;
        r101.setAlpha(0.0f);
    L62:
        r121 = true;
        goto L71
    L51:
        if (r119.x(r114.f115921m) == true) goto L56;
    L32:
        if (TextUtils.isEmpty(r114.f115916h) == true) goto L34;
        UtilityKotlinExtentionsKt.w(r103);
        r103.setText(r114.f115916h);
        goto L37
    L15:
        if (com.bytedance.android.live.core.utils.s1.y() >= com.bytedance.android.live.core.utils.s1.f(360.0f)) goto L18;
        if (r100 == null) goto L18;
        r100.setTextSize(1, 10.0f);
        goto L18
    }
}
