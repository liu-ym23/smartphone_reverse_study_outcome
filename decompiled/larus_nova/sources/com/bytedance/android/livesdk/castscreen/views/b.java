package com.bytedance.android.livesdk.castscreen.views;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ICastDanmakuManager;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.DanmakuRenderEngineView;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends Presentation {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f104777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f104778e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f104779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f104780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LivePlayerView f104781c;

    public static final class a {
        public static void b() {
            b r100 = b.f104777d;
            if (r100 == null) goto L6;
            a(r100);
            Unit r101 = Unit.INSTANCE;
            return;
        }

        public static Boolean c() {
            b r100 = b.f104777d;
            if (r100 != null) goto L7;
            return null;
        L7:
            return Boolean.valueOf(r100.isShowing());
        }

        public a() {
        }

        public static void a(b r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.castscreen.views.b$b, reason: collision with other inner class name */
    public static final class C1578b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f104782a;

        public C1578b(b r100) {
            this.f104782a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ICastDanmakuManager r101 = (ICastDanmakuManager) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L14;
            View r102 = r101.getRenderEngineView();
            if (r102 == null) goto L20;
            b r103 = this.f104782a;
            r103.getClass();
            if (r102.getParent() == null) goto L13;
            ViewParent r104 = r102.getParent();
            if (r104 == null) goto L12;
            ((ViewGroup) r104).removeView(r102);
            goto L13
        L12:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L13:
            r103.f104779a.addView(r102, new FrameLayout.LayoutParams(-1, -1));
            r102.setVisibility(0);
            return;
        L20:
            return;
        L14:
            b r105 = this.f104782a;
            int r106 = r105.f104779a.getChildCount() - 1;
        L15:
            if (r106 < 0) goto L25;
            if ((r105.f104779a.getChildAt(r106) instanceof DanmakuRenderEngineView) == false) goto L19;
            r105.f104779a.removeViewAt(r106);
        L19:
            r106 = r106 - 1;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f104783a = null;

        static {
            f104783a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("RemotePresentation", "get danmakuCastManager error : " + ((Throwable) r100));
        }
    }

    static {
        f104778e = new a();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        LivePlayerView r100 = this.f104781c;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L10;
        m<Boolean> r102 = r101.isInExtendedCastMode();
        if (r102 == null) goto L10;
        r102.setValue(Boolean.FALSE);
    L10:
        Disposable r103 = this.f104780b;
        if (r103 == null) goto L13;
        r103.dispose();
    L13:
        this.f104780b = null;
        this.f104779a.removeAllViews();
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(this);
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r105 == null) goto L27;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L16:
        if (Looper.myLooper() == r104.getLooper()) goto L18;
        r104.post(DialogLancet.createDismissRunnable(this));
    }

    public final void a(LivePlayerView r100) {
        if (Intrinsics.areEqual(r100, this.f104781c) == false) goto L5;
        return;
    L5:
        this.f104781c = r100;
        this.f104779a.removeAllViews();
        this.f104779a.addView(r100, 0);
        MiddlewareRoomContext.a r101 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r102 = MiddlewareRoomContext.a.c(r101, null, 0, 3);
        if (r102 == null) goto L12;
        n<ICastDanmakuManager> r103 = r102.getDanmakuCastManager();
        if (r103 == null) goto L12;
        Observable<sh6.b<ICastDanmakuManager>> r104 = r103.a();
        if (r104 == null) goto L12;
        Disposable r105 = r104.subscribe(new C1578b(this), c.f104783a);
    L13:
        this.f104780b = r105;
        MiddlewareRoomContext r106 = MiddlewareRoomContext.a.c(r101, null, 0, 3);
        if (r106 == null) goto L19;
        m<Boolean> r107 = r106.isInExtendedCastMode();
        if (r107 == null) goto L20;
        r107.setValue(Boolean.TRUE);
        return;
    L20:
        return;
    L19:
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f104779a.setBackgroundColor(-16777216);
        setContentView(this.f104779a);
    }

    public b(Context r100, Display r101) {
        super(r100, r101);
        this.f104779a = new FrameLayout(getContext());
    }
}
