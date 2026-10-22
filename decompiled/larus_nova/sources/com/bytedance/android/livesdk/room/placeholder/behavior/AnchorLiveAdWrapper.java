package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.s3;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/room/placeholder/behavior/AnchorLiveAdWrapper;", "Lcom/bytedance/android/livesdk/room/placeholder/behavior/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLiveAdWrapper extends l implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f157689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f157690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f157691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IExternalButton f157692e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorLiveAdWrapper f157693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f157694b;

        public a(AnchorLiveAdWrapper r100, View r101) {
            this.f157693a = r100;
            this.f157694b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f157693a.f157692e.onViewAttached(l.a(this.f157694b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        View r100 = this.f157690c;
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        r101.setClipChildren(false);
        if (r101.getChildCount() > 0) goto L7;
    L9:
        View r102 = this.f157692e.getView();
        this.f157692e.onViewWillAttach(l.a(r100));
        ViewGroup r103 = (ViewGroup) r100;
        if (c(r103) == false) goto L12;
        this.f157692e.getView().setAlpha(0.0f);
    L12:
        r103.addView(r102);
        r100.post(new a(this, r100));
        return;
    L7:
        if (c(r101) == true) goto L9;
        b();
        goto L9
    }

    public AnchorLiveAdWrapper(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        super(r100);
        this.f157692e = r100;
    }

    public final boolean c(ViewGroup r100) {
        if (r100.getChildCount() == 1) goto L5;
    L9:
        return false;
    L5:
        if ((r100.getChildAt(0).getTag() instanceof String) == false) goto L9;
        if (Intrinsics.areEqual("skin_animation_view", r100.getChildAt(0).getTag()) == false) goto L9;
        return true;
    }

    public final void d(boolean r100) {
        if (ux.f121407a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f157691d == false) goto L7;
        return;
    L7:
        if (r100 == true) goto L9;
        DataCenter r101 = this.f157689b;
        if (r101 == null) goto L20;
        r101.put("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", Boolean.FALSE);
    L20:
        if (r100 == false) goto L33;
        View r102 = this.f157690c;
        if ((r102 instanceof ViewGroup) == false) goto L32;
        ViewGroup r103 = (ViewGroup) r102;
        r103.setClipChildren(false);
        if (r103.getChildCount() > 0) goto L26;
    L28:
        View r104 = this.f157692e.getView();
        this.f157692e.onViewWillAttach(l.a(r102));
        ViewGroup r105 = (ViewGroup) r102;
        if (c(r105) == false) goto L31;
        this.f157692e.getView().setAlpha(0.0f);
    L31:
        r105.addView(r104);
        r102.post(new c(this, r102));
        goto L32
    L26:
        if (c(r103) == true) goto L28;
        b();
    L32:
        y3.m(this.f157689b).c(ToolbarButton.COMMERCE_LIVE_AD.extended());
        return;
    L33:
        b();
        y3.m(this.f157689b).i(ToolbarButton.COMMERCE_LIVE_AD.extended());
        return;
    L9:
        if (com.bytedance.android.livesdk.commerce.b.a(this.f157689b).booleanValue() == false) goto L14;
        DataCenter r106 = this.f157689b;
        if (r106 == null) goto L13;
        r106.put("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", Boolean.valueOf(r100));
    L13:
        r100 = false;
        goto L20
    L14:
        DataCenter r107 = this.f157689b;
        if (r107 == null) goto L20;
        r107.put("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", Boolean.FALSE);
        goto L20
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-414927467)) goto L12;
        return;
    L12:
        if (r102.equals("data_audience_interact_game") == true) goto L14;
        return;
    L14:
        if (r101.getData() != null) goto L16;
        y3.m(this.f157689b).i(ToolbarButton.GAME_GUESS.extended());
    L16:
        DataCenter r103 = this.f157689b;
        if (r103 == null) goto L23;
        Boolean r104 = (Boolean) r103.get("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", Boolean.FALSE);
        if (r104 == null) goto L24;
        d(r104.booleanValue());
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        DataCenter r102 = this.f157689b;
        if (r102 == null) goto L6;
        r102.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.p4(r100, r101);
        this.f157689b = r101;
        this.f157690c = r100;
        this.f157691d = z.b(r101).f66429c;
        this.f157692e.onLoad();
        if (ux.f121407a.getValue().booleanValue() == false) goto L15;
        DataCenter r102 = this.f157689b;
        if (r102 == null) goto L7;
        Boolean r103 = (Boolean) r102.get("data_is_anchor", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L15;
        DataCenter r104 = this.f157689b;
        if (r104 == null) goto L14;
        r104.observe("data_audience_interact_game", this);
    L14:
        y3.f(this.f157689b).k(ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE, new s3(this));
        goto L15
    L7:
        r103 = null;
    L15:
        d(true);
    }
}
