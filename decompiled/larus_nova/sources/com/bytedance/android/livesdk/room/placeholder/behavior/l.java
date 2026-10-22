package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
public class l implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalButton f157748a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f157749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f157750b;

        public a(l r100, View r101) {
            this.f157749a = r100;
            this.f157750b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f157749a.f157748a.onViewAttached(l.a(this.f157750b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public l(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        this.f157748a = r100;
    }

    public static Rect a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return new Rect(MathKt.roundToInt(r100.getX()), MathKt.roundToInt(r100.getY()), r100.getWidth(), r100.getHeight());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f157748a.getView())) == false) goto L6;
        this.f157748a.getView().callOnClick();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if ((r100 instanceof ViewGroup) == false) goto L10;
        this.f157748a.onViewWillDetach();
        ((ViewGroup) r100).removeView(this.f157748a.getView());     // Catch: Exception -> L7
    L9:
        this.f157748a.onViewDetached();
    L7:
        e = move-exception;
        ALogger.e("ExternalButtonBehaviorWrapper", e);
    L10:
        this.f157748a.onUnload();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f157748a.onLoad();
        if ((r100 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r100).setClipChildren(false);
        View r102 = this.f157748a.getView();
        this.f157748a.onViewWillAttach(a(r100));
        ((ViewGroup) r100).addView(r102);
        r100.post(new a(this, r100));
        return;
    }
}
