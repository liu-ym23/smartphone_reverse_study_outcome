package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.InputLinearLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "Llq1/a;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter$IView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", ce.f26395j, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "()V", "IView", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DanmuPanelBasePresenter extends lq1.a<IView> implements Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f109093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VSInputPanelLayout f109094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f109095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f109096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InputLinearLayout f109097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IView f109098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f109099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public nl1.a f109100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f109101l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/IReplayWidgetView;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IReplayWidgetView {
        boolean L6();

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView
        /* synthetic */ Context getContext();

        VSInputPanelLayout uJ();
    }

    public final int j() {
        int[] r100 = {0, 0};
        View r101 = this.f109095f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelContainer");
    L5:
        r101.getLocationOnScreen(r100);
        int r102 = t.g() - r100[1];
        View r103 = this.f109095f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelContainer");
    L8:
        int r104 = r102 - r103.getMeasuredHeight();
        if (r100[1] > (t.g() / 8)) goto L11;
        return 0;
    L11:
        if (t.i() == true) goto L13;
        return r104;
    L13:
        return r104 + s1.A();
    }

    public abstract List<String> k();

    public void m(KVData r100) {
    }

    public final Context getContext() {
        Context r100 = this.f109099j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final VSInputPanelLayout h() {
        VSInputPanelLayout r100 = this.f109094e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomPanelContainer");
    L5:
        return r100;
    }

    public final View i() {
        View r100 = this.f109095f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputPanelContainer");
    L5:
        return r100;
    }

    public final IView l() {
        IView r100 = this.f109098i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r100;
    }

    public DanmuPanelBasePresenter() {
        this.f109096g = 10;
        this.f109101l = s1.f(14.0f);
    }

    public void g(IView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        e(r100);
        this.f109098i = r100;
        this.f109099j = r100.getContext();
        LifecycleOwner r101 = this.f109098i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        if (r101 == null) goto L56;
        ViewGroup r102 = ((Widget) r101).containerView;
        this.f109093d = r102;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L10:
        if ((UtilityKotlinExtentionsKt.f(r102) instanceof InputLinearLayout) == false) goto L19;
        ViewGroup r103 = this.f109093d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L14:
        ViewGroup r104 = UtilityKotlinExtentionsKt.f(r103);
        if (r104 == null) goto L18;
        this.f109097h = (InputLinearLayout) r104;
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.base.view.InputLinearLayout");
    L19:
        ViewGroup r105 = this.f109093d;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L22:
        this.f109095f = r105.findViewById(R.id.content_layout);
        ViewGroup r106 = this.f109093d;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L25:
        this.f109094e = (VSInputPanelLayout) r106.findViewById(R.id.panel_container);
        DataCenter r107 = this.f510285b;
        if (r107 == null) goto L28;
        nl1.a r108 = (nl1.a) r107.get("VSDanmakuInputDialogCallerContext");
    L29:
        this.f109100k = r108;
        DataCenter r109 = this.f510285b;
        if (r109 == null) goto L37;
        List<String> r110 = k();
        if (r110 == null) goto L37;
        Iterator<T> r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L37;
        r109.observe((String) r111.next(), this);
    L37:
        DataCenter r112 = this.f510285b;
        if (r112 == null) goto L42;
        Integer r113 = (Integer) r112.get("VSDanmuInputSource");
        if (r113 == null) goto L42;
        r113.intValue();
    L42:
        fq1.a r114 = fq1.b.a();
        if (r114 == null) goto L47;
        Episode r115 = r114.f478400a;
        if (r115 == null) goto L47;
        r115.getId();
    L47:
        nl1.a r116 = this.f109100k;
        if (r116 == null) goto L58;
        BehaviorSubject<Boolean> r117 = r116.f519539a;
        if (r117 == null) goto L59;
        ObservableSubscribeProxy r118 = (ObservableSubscribeProxy) r117.as(AutoDispose.bind(this.f510284a));
        if (r118 == null) goto L60;
        r118.subscribe(new a(this));
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L28:
        r108 = null;
        goto L29
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        m((KVData) r100);
    }
}
