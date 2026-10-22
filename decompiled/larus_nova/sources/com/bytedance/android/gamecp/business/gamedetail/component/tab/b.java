package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.a1;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55056g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f55057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f55058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f55059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dv.e f55060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f55061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabLayout f55062f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f55063a;

        public a(b r100) {
            this.f55063a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Unit r111 = (Unit) r110;
            b r112 = this.f55063a;
            TabLayout r100 = r112.f55062f;
            Object r101 = null;
            if (r100 == null) goto L5;
            TabLayout.Tab r102 = r100.getTabAt(r100.getSelectedTabPosition());
        L41:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L21
            Field r104 = TabLayout.Tab.class.getDeclaredField("view");     // Catch: Throwable -> L21
            if (r104 == null) goto L10;
            r104.setAccessible(true);     // Catch: Throwable -> L21
        L10:
            if (r104 == null) goto L12;
            Object r105 = r104.get(r102);     // Catch: Throwable -> L21
        L13:
            if (r105 == null) goto L20;
            View r106 = (View) r105;     // Catch: Throwable -> L21
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L24:
            View r107 = r106;
            if (r107 == null) goto L42;
            dv.e r108 = new dv.e(r112.f55061e);     // Catch: Throwable -> L28
            r108.f470089c = r112.f55057a;     // Catch: Throwable -> L28
            r108.f470096j = 10;     // Catch: Throwable -> L28
            r108.f470094h = true;     // Catch: Throwable -> L28
            r108.f470090d = false;     // Catch: Throwable -> L28
            r108.f470091e = false;     // Catch: Throwable -> L28
            r108.f470095i = 5;     // Catch: Throwable -> L28
            r108.a();     // Catch: Throwable -> L28
            r112.f55060d = r108;     // Catch: Throwable -> L28
            r108.e(r107);     // Catch: Throwable -> L28
            r112.f55058b.addOnAttachStateChangeListener(new com.bytedance.android.gamecp.business.gamedetail.component.tab.c(r112, r107));     // Catch: Throwable -> L28
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
        L30:
            HashMap<String, String> r109 = GamecpTracker.f56755a;
            TabLayout r113 = r112.f55062f;
            if (r113 == null) goto L35;
            TabLayout.Tab r114 = r113.getTabAt(r113.getSelectedTabPosition());
            if (r114 == null) goto L35;
            r101 = r114.getTag();
        L35:
            GamecpTracker.r(r107, String.valueOf(r101).concat("_back_to_top"), MapsKt.emptyMap(), new d(), false, 112);
            return;
        L28:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L30
        L42:
            return;
        L17:
            Throwable th10 = th;
        L23:
            Result.Companion r116 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th10));
            goto L24
        L20:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");     // Catch: Throwable -> L21
        L12:
            r105 = null;
        L21:
            th = move-exception;
            th10 = th;
            r106 = null;
            goto L23
        L5:
            r102 = null;
            goto L41
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.tab.b$b, reason: collision with other inner class name */
    public static final class C0894b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0894b f55064a = null;

        static {
            f55064a = new C0894b();
        }

        public C0894b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c {
        public static void a(Long r100) {
            if (a1.b().getBoolean("live.pref.SHOW_GAME_PROMOTE_BACK_TO_TOP_POPUP", false) == false) goto L5;
            return;
        L5:
            if (r100 != null) goto L7;
            return;
        L7:
            if (r100.longValue() <= (b.f55056g * 2)) goto L18;
            yr.c.e("GameBackToTopPopupWindow", "show ppw");
            a1.a().putBoolean("live.pref.SHOW_GAME_PROMOTE_BACK_TO_TOP_POPUP", true).apply();
            DataContext r101 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
            if ((r101 instanceof AudienceGamePromoteDetailViewModel) == true) goto L11;
            r101 = null;
        L11:
            AudienceGamePromoteDetailViewModel r102 = (AudienceGamePromoteDetailViewModel) r101;
            if (r102 == null) goto L19;
            k<Unit> r103 = r102.getPopupTip();
            if (r103 == null) goto L20;
            r103.post(Unit.INSTANCE);
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    static {
        Resources r100 = Resources.getSystem();
        f55056g = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
    }

    public final Context getContext() {
        return this.f55061e;
    }

    public b(Context r100, TabLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CompositeDisposable r102 = new CompositeDisposable();
        this.f55061e = r100;
        this.f55062f = r101;
        DataContext r103 = null;
        View r104 = View.inflate(r100, R.layout.gamecp_game_detail_popup_tip, null);
        this.f55057a = r104;
        this.f55058b = r104.findViewById(R.id.gamecp_game_detail_popup_tip_arrow);
        this.f55059c = r104.findViewById(R.id.gamecp_game_detail_popup_tip_textView);
        DataContext r105 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r105 instanceof AudienceGamePromoteDetailViewModel) == false) goto L6;
        r103 = r105;
    L6:
        AudienceGamePromoteDetailViewModel r106 = (AudienceGamePromoteDetailViewModel) r103;
        if (r106 == null) goto L15;
        k<Unit> r107 = r106.getPopupTip();
        if (r107 == null) goto L15;
        PublishSubject r108 = r107.onEvent();
        if (r108 == null) goto L15;
        Disposable r109 = r108.subscribe(new a(this), C0894b.f55064a);
        if (r109 == null) goto L15;
        Intrinsics.checkNotNullParameter(r109, "$this$autoDispose");
        Intrinsics.checkNotNullParameter(r109, "$this$autoDispose");
        r102.add(r109);
    L15:
        yr.c.e("GameBackToTopPopupWindow", "ppw init");
    }
}
