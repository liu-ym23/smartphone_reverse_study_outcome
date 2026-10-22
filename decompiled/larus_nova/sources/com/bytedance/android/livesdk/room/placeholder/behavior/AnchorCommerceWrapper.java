package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.config.setting.s;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.shopping.LiveShoppingMessageHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/room/placeholder/behavior/AnchorCommerceWrapper;", "Lcom/bytedance/android/livesdk/room/placeholder/behavior/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorCommerceWrapper extends l implements Observer<KVData>, vlc.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f157676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public js2.a f157677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f157678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.room.api.messagewindow.builder.card.c f157679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f157680f;

    public AnchorCommerceWrapper(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        super(r100);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        y3.m(this.f157678d).c(ToolbarButton.COMMERCE.extended());
        return;
    L4:
        y3.m(this.f157678d).i(ToolbarButton.COMMERCE.extended());
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
        if (r102.hashCode() == 919040494) goto L12;
        return;
    L12:
        if (r102.equals("data_live_mini_app_commerce_status") == true) goto L14;
        return;
    L14:
        if (s.b() == true) goto L31;
        Object r103 = r101.getData();
        if ((r103 instanceof p2) == false) goto L26;
        p2 r104 = (p2) r103;
        if (r104.b() != 0) goto L22;
        b(false);
        return;
    L22:
        if (r104.b() != 1) goto L28;
        b(true);
        return;
    L28:
        return;
    L26:
        return;
    L31:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getIntType();
        if (1001 <= r101) goto L8;
        return;
    L8:
        if (2000 < r101) goto L18;
        Integer r102 = LiveShoppingMessageHelper.INSTANCE.getMessageType(r100);
        if (r102 == null) goto L19;
        int r103 = r102.intValue();
        js2.a r104 = this.f157677c;
        if (r104 == null) goto L15;
        r104.a(r103);
    L15:
        if (r103 != 10) goto L20;
        com.bytedance.android.livesdk.business.douplus.h.g(true, this.f157678d);
        int r105 = q4.f117346e;
        q4.a.b(this.f157678d);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        r101.removeObserver(this);
        vlc.d r102 = this.f157676b;
        if (r102 == null) goto L5;
        r102.removeMessageListener(this);
    L5:
        ((p2) r101.get("data_live_mini_app_commerce_status", new p2())).getClass();
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r103 = this.f157679e;
        if (r103 == null) goto L8;
        r103.b();
    L8:
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r104 = this.f157679e;
        if (r104 == null) goto L11;
        r104.f98972a.a();
    L11:
        CompositeDisposable r105 = this.f157680f;
        if (r105 == null) goto L15;
        r105.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.p4(r100, r101);
        this.f157680f = new CompositeDisposable();
        r101.observe("data_live_mini_app_commerce_status", this, true);
        this.f157678d = r101;
        this.f157677c = new js2.a(r101);
        ((p2) r101.get("data_live_mini_app_commerce_status", new p2())).getClass();
        q71.a r102 = ((IMsgWindowService) jc1.k.n(IMsgWindowService.class)).cardStateDispatcher(this.f157678d);
        e3 r103 = new e3();
        r103.areaType = 1;
        r103.areaSubType = 1;
        Unit r104 = Unit.INSTANCE;
        q71.d r105 = q71.a.C7292a.a(r102, r103);
        if (r105 == null) goto L9;
        Observable<T> r106 = r105.a();
        if (r106 == 0) goto L9;
        Disposable r107 = r106.subscribe(new a(this));
        if (r107 == null) goto L9;
        RxUtilKt.c(r107, this.f157680f);
    L9:
        Disposable r108 = xs2.b.a().b(u71.a.class).subscribe(new b(this));
        if (r108 == null) goto L13;
        RxUtilKt.c(r108, this.f157680f);
    L13:
        if (s.b() == false) goto L15;
        return;
    L15:
        vlc.d r109 = (vlc.d) r101.get("data_message_manager", null);
        this.f157676b = r109;
        if (r109 == null) goto L19;
        r109.addMessageListener(1002, this);
        return;
    }
}
