package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/BaseMatchNativeWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/s$a;", "Lou2/b;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMatchNativeWidget extends LiveRecyclableWidget implements s.a, ou2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f159783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IComponentManager f159784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayerDescriptorList f159785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h70.b f159786d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f159787a = null;

        static {
            f159787a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw new IllegalStateException("MultiTabPendingDescHandler is null, please check.");     // Catch: Throwable -> L4
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r100) {
    }

    public abstract void xq(boolean r100);

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        wq("onUnload");
        if ((this.contentView instanceof FrameLayout) == true) goto L5;
        return;
    L5:
        this.f159784b = null;
        this.f159785c.clear();
    }

    @Override // ou2.b
    public final void pY() {
        wq("reloadAllElement");
    }

    public BaseMatchNativeWidget() {
        this.f159783a = true;
        this.f159785c = new LayerDescriptorList();
    }

    @Override // ou2.b
    public final void sv() {
        wq("unLoadAllElement");
        Iterator<j70.h<? extends h70.b>> r100 = this.f159785c.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        j70.h<? extends h70.b> r101 = r100.next();
        h70.b r102 = this.f159786d;
        if (r102 == null) goto L4;
        if (r101 == null) goto L12;
        j70.f r103 = r101.C(r102);
        ALogger.i("LiveMultiTab", "unLoad " + r103 + " because of multi camera change.");
        IComponentManager r104 = this.f159784b;
        if (r104 == null) goto L4;
        r104.dl(r103);
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    }

    private final void wq(String r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(' ');
        r101.append(Ad());
        r101.append(" height");
        ViewGroup r102 = this.containerView;
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.getHeight());
    L6:
        r101.append(r104);
        r101.append("&width");
        ViewGroup r105 = this.containerView;
        if (r105 == null) goto L9;
        r103 = Integer.valueOf(r105.getWidth());
    L9:
        r101.append(r103);
        ALogger.i("BaseMatchNativeWidget", r101.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // s70.a.InterfaceC7579a
    public final void To(LayerDescriptorList r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptorList");
        if (this.f159784b != null) goto L28;
        vr1.u r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.dataCenter, null, 2);
        if (r101 == null) goto L27;
        com.bytedance.live.datacontext.n<h80.d<com.bytedance.android.live.core.tetris.layer.view.a>> r102 = r101.n();
        if (r102 == null) goto L43;
        h80.d<com.bytedance.android.live.core.tetris.layer.view.a> r103 = r102.getValue();
        if (r103 == null) goto L44;
        com.bytedance.android.live.core.tetris.layer.view.a r104 = r103.get();
        if (r104 == null) goto L48;
        this.f159786d = r104.a();
        com.bytedance.live.datacontext.n<h80.d<Pair<Fragment, FragmentManager>>> r105 = r101.s();
        if (r105 == null) goto L45;
        h80.d<Pair<Fragment, FragmentManager>> r106 = r105.getValue();
        if (r106 == null) goto L46;
        Pair<Fragment, FragmentManager> r107 = r106.get();
        if (r107 == null) goto L47;
        Fragment r108 = r107.getFirst();
        if (r108 == null) goto L49;
        com.bytedance.android.live.core.tetris.a r109 = com.bytedance.android.live.core.tetris.a.f65492a;
        View r110 = this.contentView;
        if (r110 == null) goto L26;
        this.f159784b = r109.c((FrameLayout) r110, r108, r104, null, "Match");
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L49:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L48:
        return;
    L44:
        return;
    L43:
        return;
    L27:
        return;
    L28:
        LayerDescriptorList r111 = this.f159785c;
        ArrayList r112 = new ArrayList();
        Iterator<j70.h<? extends h70.b>> r113 = r100.iterator();
    L30:
        if (r113.hasNext() == false) goto L34;
        j70.h<? extends h70.b> r114 = r113.next();
        if ((!this.f159785c.contains(r114)) == false) goto L30;
        r112.add(r114);
        goto L30
    L34:
        r111.addAll(r112);
        IComponentManager r115 = this.f159784b;
        if (r115 == null) goto L50;
        r115.dd(this.f159785c);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r110) {
        wq(WidgetCostModule.TYPE_ON_LOAD);
        View r111 = this.contentView;
        if ((r111 instanceof ViewGroup) == true) goto L5;
        r111 = null;
    L5:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L8;
        r112.removeAllViews();
    L8:
        this.f159785c = new LayerDescriptorList();
        MultiTabType r113 = Ad();
        BaseMatchNativeWidget$adjustPad$1 r100 = new BaseMatchNativeWidget$adjustPad$1(this);
        if (PadConfigUtils.c() == false) goto L33;
        vr1.u r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.dataCenter, null, 2);
        if (r101 == null) goto L33;
        com.bytedance.live.datacontext.n<PadOrientation> r102 = r101.w();
        if (r102 == null) goto L21;
        Observable<sh6.b<PadOrientation>> r103 = r102.a();
        if (r103 == null) goto L21;
        ObservableSubscribeProxy r104 = (ObservableSubscribeProxy) r103.as(autoDispose());
        if (r104 == null) goto L21;
        r104.subscribe(new b(this, r100));
    L21:
        if (this.f159783a == false) goto L33;
        com.bytedance.live.datacontext.n<xn1.a> r105 = r101.K();
        if (r105 == null) goto L25;
        xn1.a r106 = r105.getValue();
    L26:
        if (r106 == null) goto L28;
        r106.D(r113.getTabId(), r113.getTitle(), this.contentView, null);
        goto L33
    L28:
        com.bytedance.live.datacontext.n<xn1.a> r107 = r101.K();
        if (r107 == null) goto L33;
        Observable r108 = com.bytedance.android.live.core.utils.d0.c(r107);
        if (r108 == null) goto L33;
        r108.subscribe(new c(this, r113, null));
        goto L33
    L25:
        r106 = null;
    L33:
        vr1.u r114 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.dataCenter, null, 2);
        if (r114 == null) goto L53;
        com.bytedance.live.datacontext.n<h80.d<Pair<Fragment, FragmentManager>>> r115 = r114.s();
        if (r115 == null) goto L54;
        h80.d<Pair<Fragment, FragmentManager>> r116 = r115.getValue();
        if (r116 == null) goto L55;
        Pair<Fragment, FragmentManager> r117 = r116.get();
        if (r117 == null) goto L56;
        Fragment r118 = r117.getFirst();
        if (r118 == null) goto L59;
        Map<Integer, s> r109 = t.f160003a;
        Intrinsics.checkNotNullParameter(r118, WidgetService.PARAM_FRAGMENT);
        s r119 = (s) ((LinkedHashMap) t.f160003a).get(Integer.valueOf(r118.hashCode()));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L48;
        if (r119 != null) goto L48;
        this.contentView.post(a.f159787a);
    L48:
        if (r119 == null) goto L57;
        Intrinsics.checkNotNullParameter(this, "multiTabPendingListener");
        MultiTabType r120 = Ad();
        r119.f160002c.put(r120, this);
        LayerDescriptorList r121 = (LayerDescriptorList) ((LinkedHashMap) r119.f160001b).get(r120);
        if (r121 == null) goto L58;
        To(r121);
        return;
    L58:
        return;
    L57:
        return;
    L59:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    }
}
