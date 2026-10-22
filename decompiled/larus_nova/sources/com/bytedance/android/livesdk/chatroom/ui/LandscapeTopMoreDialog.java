package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LandscapeTopMoreAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.bytedance.android.livesdk.widget.GridItemDecoration;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeTopMoreDialog;", "Landroid/app/Dialog;", "Lcom/bytedance/android/livesdk/utils/y1;", "Lcom/bytedance/android/livesdk/utils/c2;", "Lcom/bytedance/android/livesdk/utils/z1;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopMoreDialog extends Dialog implements com.bytedance.android.livesdk.utils.y1, com.bytedance.android.livesdk.utils.c2, com.bytedance.android.livesdk.utils.z1, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f112235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f112236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LandscapeTopMoreAdapter f112237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LandscapeTopMoreAdapter f112238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<List<ExtendedToolbarButton>> f112239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f112240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Stack<ExtendedToolbarButton> f112241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f112242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f112243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f112244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f112245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<ExtendedToolbarButton> f112246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<ToolbarButton> f112247m;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopMoreDialog f112248a;

        public a(LandscapeTopMoreDialog r100) {
            this.f112248a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List<? extends ExtendedToolbarButton> r101 = (List) r100;
            LandscapeTopMoreDialog r102 = this.f112248a;
            LandscapeTopMoreAdapter r103 = r102.f112238d;
            if (r103 == null) goto L31;
            Intrinsics.checkNotNull(r103);
            com.bytedance.android.livesdk.utils.e2.c(r101, r103.f115645c);
            com.bytedance.android.livesdk.utils.e2.f(r101, r102.f112240f, r102.f112241g);
            Intrinsics.checkNotNullParameter(r101, "$this$sortBySpecificRule");
            Collections.sort(r101, com.bytedance.android.livesdk.utils.d2.f158928a);
            LandscapeTopMoreAdapter r104 = r102.f112238d;
            Intrinsics.checkNotNull(r104);
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r105 = r104.f115645c;
            Intrinsics.checkNotNullParameter(r101, "$this$releaseOldView");
            Intrinsics.checkNotNullParameter(r105, "toolbarManager");
            Iterator<? extends ExtendedToolbarButton> r106 = r101.iterator();
        L6:
            if (r106.hasNext() == false) goto L12;
            ExtendedToolbarButton r107 = r106.next();
            View r108 = (View) ((HashMap) r105.f116829c).get(r107);
            if (r108 == null) goto L6;
            r105.C(r107, r108);
            ((HashMap) r105.f116829c).remove(r107);
            goto L6
        L12:
            if (r101.isEmpty() == true) goto L24;
            LandscapeTopMoreAdapter r109 = r102.f112238d;
            if (r109 == null) goto L24;
            Intrinsics.checkNotNull(r109);
            if (com.bytedance.android.livesdk.utils.e2.e(r101, r109.f115645c) == false) goto L24;
            UtilityKotlinExtentionsKt.w(r102.findViewById(R.id.divider));
            UtilityKotlinExtentionsKt.w(r102.findViewById(R.id.temp_area_button_list));
            LandscapeTopMoreAdapter r110 = r102.f112238d;
            if (r110 == null) goto L21;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r110.f115651i = r101;
        L21:
            LandscapeTopMoreAdapter r111 = r102.f112238d;
            if (r111 == null) goto L32;
            r111.notifyDataSetChanged();
            return;
        L32:
            return;
        L24:
            UtilityKotlinExtentionsKt.t(r102.findViewById(R.id.divider));
            UtilityKotlinExtentionsKt.t(r102.findViewById(R.id.temp_area_button_list));
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f112249a = null;

        static {
            f112249a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final /* synthetic */ void A() {
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void onUnload() {
        Disposable r100 = this.f112244j;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.f.d().f();
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

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        CustomShaderRectView r100 = (CustomShaderRectView) findViewById(R.id.divider);
        if (r100 == null) goto L5;
        r100.post(new a7(this));
    L5:
        DataCenter r101 = this.f112235a;
        if (r101 == null) goto L10;
        Boolean r102 = (Boolean) r101.get("data_is_anchor", Boolean.FALSE);
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        this.f112242h = r103;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(r103) == false) goto L21;
        LandscapeTopMoreAdapter r104 = this.f112237c;
        if (r104 != null) goto L16;
    L18:
        LandscapeTopMoreAdapter r105 = this.f112237c;
        if (r105 == null) goto L21;
        r105.notifyDataSetChanged();
        goto L21
    L16:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(r104.f115643a) == false) goto L18;
        r104.f115644b.clear();
        RedDotHelper.b(r104.f115651i, r104.f115645c, r104.f115644b);
    L21:
        DataCenter r106 = this.f112235a;
        if (r106 == null) goto L24;
        r106.observe("cmd_live_toolbarmore_dialog_dismiss", this);
    L24:
        DataCenter r107 = this.f112235a;
        if (r107 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z3.c(r107, false);
        return;
    L28:
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((CompositeDisposable) this.f112243i.getValue()).clear();
        DataCenter r100 = this.f112235a;
        if (r100 == null) goto L6;
        r100.removeObserver(this);
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        DataCenter r100 = this.f112235a;
        if (r100 == null) goto L14;
        r100.put("data_predictor_more_entrance_shwo", Boolean.TRUE);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void K(ExtendedToolbarButton.c r100) {
        Intrinsics.checkNotNullParameter(r100, "tempAreaStateItem");
        if (com.bytedance.android.livesdk.utils.e2.d(this.f112246l, r100) == false) goto L5;
        return;
    L5:
        List<ExtendedToolbarButton> r101 = this.f112246l;
        com.bytedance.android.livesdk.utils.e2.b(r101, r100);
        ListProtector.add(r101, 0, r100);
        this.f112239e.onNext(this.f112246l);
    }

    @Override // com.bytedance.android.livesdk.utils.z1
    public final void V1(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        ((CompositeDisposable) this.f112243i.getValue()).add(r100);
    }

    public final void a(ViewGroup.MarginLayoutParams r100) {
        int r101 = this.f112247m.size();
        if (r101 != 1) goto L5;
    L7:
        r100.rightMargin = UtilityKotlinExtentionsKt.i(45);
        return;
    L5:
        if (r101 == 2) goto L7;
        r100.rightMargin = UtilityKotlinExtentionsKt.i(20);
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void f0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Iterator<ExtendedToolbarButton> r101 = this.f112246l.iterator();
        int r102 = -1;
    L4:
        if (r101.hasNext() == false) goto L29;
        ExtendedToolbarButton r103 = r101.next();
        r102 = r102 + 1;
        if ((r103 instanceof ExtendedToolbarButton.c) == false) goto L4;
        if (Intrinsics.areEqual(((ExtendedToolbarButton.c) r103).f115637s, r100) == false) goto L4;
        this.f112246l.remove(r103);
        LandscapeTopMoreAdapter r104 = this.f112238d;
        if (r104 == null) goto L13;
        r104.notifyItemRemoved(r102);
    L13:
        if ((!this.f112241g.isEmpty()) == true) goto L15;
    L21:
        this.f112239e.onNext(this.f112246l);
        return;
    L15:
        if (this.f112241g.contains(r103) == false) goto L18;
        this.f112241g.remove(r103);
        goto L21
    L18:
        if (this.f112246l.size() > this.f112240f) goto L20;
        this.f112241g.clear();
        goto L21
    L20:
        this.f112241g.pop();
        goto L21
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L27;
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_landscape_more, null);
        r111.setBackground(com.bytedance.android.live.core.utils.s1.m(this.f112245k));
        int r100 = r111.getPaddingTop();
        int r101 = r111.getPaddingBottom();
        boolean r102 = false;
        r111.setPadding(UtilityKotlinExtentionsKt.i(0), r100, UtilityKotlinExtentionsKt.i(0), r101);
        setContentView(r111);
        Window r112 = getWindow();
        if (r112 == null) goto L5;
        r112.setDimAmount(0.0f);
        r112.setLayout(-2, -1);
        r112.setGravity(GravityCompat.END);
    L5:
        DataCenter r113 = this.f112235a;
        if (r113 == null) goto L10;
        Boolean r114 = (Boolean) r113.get("data_is_anchor", Boolean.FALSE);
        if (r114 == null) goto L10;
        r102 = r114.booleanValue();
    L10:
        this.f112242h = r102;
        LandscapeTopMoreAdapter r115 = new LandscapeTopMoreAdapter(getContext(), this.f112235a, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.t.a(this.f112247m), 0, 0, new LandscapeTopMoreDialog$initView$1(this));
        this.f112237c = r115;
        r115.f115643a = this.f112242h;
        LandscapeTopMoreAdapter r116 = new LandscapeTopMoreAdapter(getContext(), this.f112235a, this.f112246l, 0, 0, this, new LandscapeTopMoreDialog$initView$2(this));
        r116.f115643a = this.f112242h;
        r116.f115647e = 32;
        r116.f115646d = 32;
        r116.f115648f = true;
        Unit r103 = Unit.INSTANCE;
        this.f112238d = r116;
        if (findViewById(R.id.stable_area_button_list) == null) goto L18;
        ViewGroup.LayoutParams r104 = ((RecyclerView) findViewById(R.id.stable_area_button_list)).getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        a((ViewGroup.MarginLayoutParams) r104);
        ((RecyclerView) findViewById(R.id.stable_area_button_list)).setLayoutParams(r104);
    L17:
        ((RecyclerView) findViewById(R.id.temp_area_button_list)).setLayoutParams(((RecyclerView) findViewById(R.id.stable_area_button_list)).getLayoutParams());
        goto L18
    L16:
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(r104);
        a(r105);
        ((RecyclerView) findViewById(R.id.stable_area_button_list)).setLayoutParams(r105);
    L18:
        ((RecyclerView) findViewById(R.id.stable_area_button_list)).addItemDecoration(new GridItemDecoration(this.f112236b));
        ((RecyclerView) findViewById(R.id.stable_area_button_list)).setAdapter(this.f112237c);
        Context r106 = getContext();
        int r107 = this.f112247m.size();
        int r108 = this.f112236b;
        if (r107 > r108) goto L22;
        r108 = this.f112247m.size();
    L22:
        GridLayoutManager r109 = new GridLayoutManager(r106, r108);
        ((RecyclerView) findViewById(R.id.stable_area_button_list)).setLayoutManager(r109);
        ((RecyclerView) findViewById(R.id.temp_area_button_list)).addItemDecoration(new GridItemDecoration(this.f112236b));
        ((RecyclerView) findViewById(R.id.temp_area_button_list)).setAdapter(this.f112238d);
        Context r117 = getContext();
        int r118 = this.f112247m.size();
        int r119 = this.f112236b;
        if (r118 > r119) goto L26;
        r119 = this.f112247m.size();
    L26:
        GridLayoutManager r120 = new GridLayoutManager(r117, r119);
        ((RecyclerView) findViewById(R.id.temp_area_button_list)).setLayoutManager(r120);
        this.f112244j = RxUtilKt.h(this.f112239e).subscribe(new a(this), b.f112249a);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == false) goto L16;
        Window r101 = getWindow();
        int r102 = com.bytedance.android.livesdk.utils.y3.f159220a;
        if (r101 == null) goto L17;
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        if (r103 == null) goto L13;
        Boolean r105 = Boolean.valueOf(r103.post(new com.bytedance.android.livesdk.utils.x3(r103, r101)));
    L14:
        r105.booleanValue();
        return;
    L13:
        r105 = null;
        goto L14
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.utils.y1
    public final void setDataCenter(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f112235a = r100;
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void t(List<? extends ExtendedToolbarButton.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "tempAreaStateData");
        com.bytedance.android.livesdk.utils.e2.a(this.f112246l);
        this.f112241g.clear();
        this.f112246l.addAll(r100);
        this.f112239e.onNext(this.f112246l);
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void z(long r100) {
        this.f112240f = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LandscapeTopMoreDialog(Context r100, List<ExtendedToolbarButton> r101, List<? extends ToolbarButton> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "tempStateAreaConfigList");
        Intrinsics.checkNotNullParameter(r102, "stableStateAreaConfigList");
        super(r100, R.style.ttlive_CommonRightDialog);
        this.f112246l = r101;
        this.f112247m = r102;
        this.f112236b = 3;
        this.f112239e = PublishSubject.create();
        this.f112240f = 16;
        this.f112241g = new Stack();
        this.f112243i = LazyKt.lazy(LandscapeTopMoreDialog$compositeDispose$2.INSTANCE);
        int r103 = r102.size();
        if (r103 != 1) goto L5;
        int r104 = R.drawable.ttlive_bg_more_single_icon_dialog_gradient;
    L9:
        this.f112245k = r104;
        return;
    L5:
        if (r103 == 2) goto L7;
        r104 = R.drawable.ttlive_bg_more_many_icon_dialog_gradient;
        goto L9
    L7:
        r104 = R.drawable.ttlive_bg_more_two_icon_dialog_gradient;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.utils.c2
    public final void N(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "iconUrl");
        Intrinsics.checkNotNullParameter(r102, "iconName");
        Intrinsics.checkNotNullParameter(r103, "iconDescription");
        int r104 = com.bytedance.android.livesdk.utils.e2.g(this.f112246l, String.valueOf(r100), r101, r102, r103);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.f112246l.size()) goto L11;
        LandscapeTopMoreAdapter r105 = this.f112238d;
        if (r105 == null) goto L12;
        r105.notifyItemChanged(r104);
        return;
    L12:
        return;
    }
}
