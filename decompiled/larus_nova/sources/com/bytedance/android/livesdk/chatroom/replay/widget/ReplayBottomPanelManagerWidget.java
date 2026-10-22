package com.bytedance.android.livesdk.chatroom.replay.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.model.message.u5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheDialog;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.util.w;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/ReplayBottomPanelManagerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayBottomPanelManagerWidget extends LiveWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridDialog f110312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f110313b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.widget.ReplayBottomPanelManagerWidget$onCreate$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "p1", "Landroid/net/Uri;", "p2", "", "p3", "Landroid/content/DialogInterface$OnDismissListener;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Uri, Integer, DialogInterface.OnDismissListener, Unit> {
        public AnonymousClass1(ReplayBottomPanelManagerWidget r100) {
            super(3, r100, ReplayBottomPanelManagerWidget.class, "showVsPanel", "showVsPanel(Landroid/net/Uri;ILandroid/content/DialogInterface$OnDismissListener;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v25, types: [T, android.net.Uri] */
        /* JADX WARN: Type inference failed for: r11v8, types: [T, android.net.Uri] */
        /* JADX WARN: Type inference failed for: r2v17, types: [T, android.net.Uri] */
        public final void invoke(Uri r110, int r111, DialogInterface.OnDismissListener r112) {
            Intrinsics.checkNotNullParameter(r110, "p1");
            ReplayBottomPanelManagerWidget r100 = (ReplayBottomPanelManagerWidget) this.receiver;
            r100.getClass();
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
            ReplayAdaptiveDialogUIState r102 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
            WidgetInfo r103 = r100.getWidgetInfo(ReplayShadowPlayerBottomWidget.class);
            if (r103 == null) goto L5;
            int r104 = r103.getContentViewHeight();
        L6:
            int r105 = r102.p(Integer.valueOf(r104));
            String r106 = UriProtector.getQueryParameter(r110, "url");
            if (r106 == null) goto L37;
            Uri r107 = w.a(UriProtector.parse(r106), r100.dataCenter);
            if (r107 == null) goto L13;
            String r108 = r107.toString();
            if (r108 == null) goto L13;
        L14:
            Ref.ObjectRef r109 = new Ref.ObjectRef();
            if (r111 != 1) goto L17;
            T r113 = x6.a.d(r108);
        L18:
            r109.element = r113;
            Iterator<String> r114 = UriProtector.getQueryParameterNames(r110).iterator();
        L20:
            if (r114.hasNext() == false) goto L22;
            String r115 = r114.next();
            r109.element = UriProtector.parse(((Uri) r109.element).toString()).buildUpon().appendQueryParameter(r115, UriProtector.getQueryParameter(r110, r115)).build();
            goto L20
        L22:
            ?? r116 = UriProtector.parse(((Uri) r109.element).toString()).buildUpon().appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom").build();
            r109.element = r116;
            if (TextUtils.isEmpty(UriProtector.getQueryParameter(r116, "height")) == false) goto L25;
            r109.element = UriProtector.parse(((Uri) r109.element).toString()).buildUpon().appendQueryParameter("height", String.valueOf(r105)).build();
        L25:
            HybridDialog r117 = fq1.f.a().showHybridDialog(r100.context, (Uri) r109.element, new h(r100, r109), null, r112);
            if (r117 == null) goto L34;
            r100.f110312a = r117;
            if (ContextUtil.contextToFragmentActivity(r100.context) == null) goto L35;
            ALogger.i("VsBottomPanelManagerWidget", "registerMessageListener");
            vlc.d r118 = (vlc.d) r100.dataCenter.get("data_message_manager");
            r100.f110313b = r118;
            if (r118 == null) goto L36;
            r118.addMessageListener(xq1.b.a(ku2.e.f506189a), r100);
            return;
        L36:
            return;
        L35:
            return;
        L34:
            return;
        L17:
            r113 = x6.a.b(r108);
        L13:
            r108 = "";
            goto L14
        L37:
            return;
        L5:
            r104 = 0;
            goto L6
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Uri r100, Integer r101, DialogInterface.OnDismissListener r102) {
            invoke(r100, r101.intValue(), r102);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.widget.ReplayBottomPanelManagerWidget$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(ReplayBottomPanelManagerWidget r100) {
            super(0, r100, ReplayBottomPanelManagerWidget.class, "showCachePanel", "showCachePanel()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReplayBottomPanelManagerWidget r100 = (ReplayBottomPanelManagerWidget) this.receiver;
            r100.getClass();
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
            ReplayAdaptiveDialogUIState r102 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
            WidgetInfo r103 = r100.getWidgetInfo(ReplayShadowPlayerBottomWidget.class);
            if (r103 == null) goto L5;
            int r104 = r103.getContentViewHeight();
        L6:
            int r105 = s1.f(r102.p(Integer.valueOf(r104)));
            mq1.c r106 = q.a();
            if (r106 == null) goto L19;
            ReplayCacheDialog r107 = r106.f(r100.context, r100.dataCenter, Integer.valueOf(r105));
            if (r107 == null) goto L23;
            Context r108 = r100.context;
            if (r108 == null) goto L18;
            FragmentManager r109 = ((FragmentActivity) r108).getSupportFragmentManager();
            LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r107, "VSCache", r110);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r109, r107, r110) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L16:
            r107.show(r109, "VSCache");
            return;
        L25:
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L19:
            return;
        L5:
            r104 = 0;
            goto L6
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.widget.ReplayBottomPanelManagerWidget$onCreate$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Integer> {
        public AnonymousClass3(ReplayBottomPanelManagerWidget r100) {
            super(0, r100, ReplayBottomPanelManagerWidget.class, "getShadowPlayerBottomHeight", "getShadowPlayerBottomHeight()I", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            ReplayBottomPanelManagerWidget r100 = (ReplayBottomPanelManagerWidget) this.receiver;
            r100.getClass();
            WidgetInfo r101 = r100.getWidgetInfo(ReplayShadowPlayerBottomWidget.class);
            if (r101 != null) goto L7;
            return 0;
        L7:
            return r101.getContentViewHeight();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        r.y().f(this, new AnonymousClass1(this));
        r.y().a(this, new AnonymousClass2(this));
        ALogger.i("VsBottomPanelManagerWidget", WidgetCostModule.TYPE_ON_CREATE);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayAdaptiveDialogUIState r101 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        AnonymousClass3 r102 = new AnonymousClass3(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "height");
        r101.f118167c = r102;
    }

    public ReplayBottomPanelManagerWidget() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        StringBuilder r101 = new StringBuilder("onMessage-");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getIntType());
    L6:
        r101.append(r102);
        r101.append(",show=");
        HybridDialog r103 = this.f110312a;
        boolean r104 = true;
        if (r103 == null) goto L13;
        Dialog r105 = r103.getDialog();
        if (r105 == null) goto L13;
        if (r105.isShowing() != true) goto L13;
        boolean r106 = true;
    L14:
        r101.append(r106);
        ALogger.i("VsBottomPanelManagerWidget", r101.toString());
        if (r100 == null) goto L30;
        HybridDialog r107 = this.f110312a;
        if (r107 == null) goto L23;
        Dialog r108 = r107.getDialog();
        if (r108 == null) goto L23;
        if (r108.isShowing() != true) goto L23;
    L24:
        if (r104 == true) goto L27;
        return;
    L27:
        if ((r100 instanceof u5) == false) goto L31;
        ((SingleSubscribeProxy) Single.just(((u5) r100).getExtra()).observeOn(Schedulers.io()).map(e.f110371a).map(f.f110372a).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new g(this));
        return;
    L31:
        return;
    L23:
        r104 = false;
        goto L24
    L30:
        return;
    L13:
        r106 = false;
        goto L14
    L5:
        r102 = null;
        goto L6
    }
}
