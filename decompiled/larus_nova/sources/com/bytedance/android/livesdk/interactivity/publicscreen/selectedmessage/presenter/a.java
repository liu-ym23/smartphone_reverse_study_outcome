package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import android.os.Handler;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f0;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends q46.b<InterfaceC2204a> implements fa2.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f139425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectedMsgBuffer f139426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f139427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a f139429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final lc2.b f139430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e52.a f139431h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a$a, reason: collision with other inner class name */
    public interface InterfaceC2204a extends q46.a {
        void DI(int r100, long r101);

        void fc(int r100, int r101);

        void pa(int r100);
    }

    @Override // fa2.c
    public final void B(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f139425b == true) goto L5;
        return;
    L5:
        this.f139426c.b(r100);
    }

    @Override // fa2.c
    public final void K(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f139425b == true) goto L5;
        return;
    L5:
        this.f139430g.a(r100);
    }

    public final void c0(List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100) {
        int r101 = ((ArrayList) this.f139428e).size();
        f0 r102 = this.f139427d;
        if (r101 < r102.listMaxSizeWhenShow) goto L8;
        int r103 = RangesKt.coerceAtMost(r102.dropNumWhenMessageListFull, r100.size());
        ((ArrayList) this.f139428e).subList(0, r103).clear();
        T r104 = this.f531633a;
        if (r104 == 0) goto L7;
        ((InterfaceC2204a) r104).pa(r103);
    L7:
        ga2.d.b(r103, "list full");
    L8:
        int r105 = ((ArrayList) this.f139428e).size();
        Iterator<T> r106 = r100.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.interactivity.api.entity.f r107 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r106.next();
        ((ArrayList) this.f139428e).add(r107);
        goto L10
    L12:
        InterfaceC2204a r108 = (InterfaceC2204a) this.f531633a;
        if (r108 == null) goto L17;
        r108.fc(r105, r100.size());
        return;
    }

    @Override // fa2.c
    public final void s(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f139425b == true) goto L5;
        return;
    L5:
        Object r101 = r100.f133141b;
        if ((r101 instanceof u3) == true) goto L8;
        r101 = null;
    L8:
        u3 r102 = (u3) r101;
        if (r102 != null) goto L11;
    L17:
        SelectedMsgBuffer r103 = this.f139426c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "message");
        ((PriorityQueue) r103.f139439c).add(r100);
        Iterator r104 = ((ArrayList) r103.f139437a).iterator();
    L19:
        if (r104.hasNext() == false) goto L21;
        ((SelectedMsgBuffer.a) r104.next()).b(r100, ((PriorityQueue) r103.f139439c).size());
        goto L19
    L21:
        return;
    L11:
        if (r102.getOrInitPublicAreaCommon().getIndividualPriority() >= 0) goto L17;
        if (this.f139425b == false) goto L23;
        this.f139430g.a(r100);
        this.f139430g.b();
        return;
    }

    @Override // fa2.c
    public final void y(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f139425b == true) goto L5;
        return;
    L5:
        c0(CollectionsKt.listOf(r100));
    }

    public a(e52.a r100, Handler r101, DataCenter r102, SelectedMsgViewManager r103) {
        Intrinsics.checkNotNullParameter(r100, "mTextMessageConfig");
        Intrinsics.checkNotNullParameter(r101, "mMainHandler");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "selectedDataSource");
        this.f139431h = r100;
        this.f139425b = true;
        SelectedMsgBuffer r104 = new SelectedMsgBuffer(r103);
        this.f139426c = r104;
        this.f139427d = SelectedMsgABHelper.b();
        this.f139428e = new ArrayList();
        c r105 = new c(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a r106 = new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a(r102, PublicScreenABHelper.d(a0.d(r102, false)), r105);
        this.f139429f = r106;
        d r107 = new d(this);
        List<lc2.d> r108 = lc2.c.f508405a;
        this.f139430g = new lc2.b(r100, r101, new PSSelectedMsgPresenter$asyncMsgProcessorAdapter$1(this));
        b r109 = new b();
        Intrinsics.checkNotNullParameter(r109, "listener");
        ((ArrayList) r104.f139437a).add(r109);
        r106.b(r107);
    }
}
