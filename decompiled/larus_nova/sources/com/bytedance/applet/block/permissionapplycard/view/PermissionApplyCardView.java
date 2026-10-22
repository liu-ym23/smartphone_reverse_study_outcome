package com.bytedance.applet.block.permissionapplycard.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.applet.databinding.LarusPermissionApplyCardViewBinding;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.api.AppletGrantingWidgetDelegate;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001!\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0004H\u0016J\u0018\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\rH\u0002Jx\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010\u00102\b\u0010/\u001a\u0004\u0018\u00010\u00102\b\u00100\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010\u00102\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u00020&082\f\u00109\u001a\b\u0012\u0004\u0012\u00020&08H\u0002J\u0018\u0010:\u001a\u00020&2\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0016J\u0006\u0010=\u001a\u00020&R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardViewInput;", "Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardViewOutput;", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingCardView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentCardModel", "Lcom/larus/bmhome/chat/api/CardModel;", "isLastMessage", "Lkotlin/Function1;", "", "", "moaOutput", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingCardViewOutput;", "currentAllowTitle", "currentRefuseTitle", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "binding", "Lcom/bytedance/applet/databinding/LarusPermissionApplyCardViewBinding;", "getBinding", "()Lcom/bytedance/applet/databinding/LarusPermissionApplyCardViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "callback", "com/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView$callback$2$1", "getCallback", "()Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView$callback$2$1;", "callback$delegate", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "bind", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingCardViewInput;", "updateView", "cardModel", ChameleonOpenTracker.Stage.RENDER, "iconURL", "sourceName", "title", "subtitle", "showOperateButton", "allowTitle", "refuseTitle", "allowLoading", "refuseLoading", "onAllow", "Lkotlin/Function0;", "onRefuse", "setLoading", "hide", "recycle", "onRecycler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionApplyCardView extends ConstraintLayout implements mi8.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f191461h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.bmhome.chat.api.f f191462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Boolean> f191463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mi8.e f191464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f191465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f191466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f191467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f191468g;

    public static final class a implements com.larus.bmhome.chat.api.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionApplyCardView f191469a;

        public a(PermissionApplyCardView r100) {
            this.f191469a = r100;
        }

        @Override // com.larus.bmhome.chat.api.k
        public final boolean c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msgID");
            return this.f191469a.f191463b.invoke(r100).booleanValue();
        }

        @Override // com.larus.bmhome.chat.api.k
        public final void d(String r100, final com.larus.bmhome.chat.api.f r101) {
            Intrinsics.checkNotNullParameter(r100, "msgID");
            Intrinsics.checkNotNullParameter(r101, "cardModel");
            if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
            this.f191469a.f191462a = r101;
            PermissionApplyCardView.R5(this.f191469a, r101);
            return;
        L5:
            final PermissionApplyCardView r102 = this.f191469a;
            r102.post(new o(r102, r101));
        }
    }

    @Override // mi8.a
    public View getView() {
        return this;
    }

    private final LarusPermissionApplyCardViewBinding getBinding() {
        return (LarusPermissionApplyCardViewBinding) this.f191467f.getValue();
    }

    private final a getCallback() {
        return (a) this.f191468g.getValue();
    }

    @Override // mi8.a
    public final void recycle() {
        mi8.e r100 = this.f191464c;
        if (r100 == null) goto L5;
        r100.onHidden();
    L5:
        this.f191464c = null;
        this.f191465d = "";
        this.f191466e = "";
    }

    @Override // mi8.a
    public final void hide() {
        e1.o(this);
    }

    public PermissionApplyCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public PermissionApplyCardView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f191463b = new com.bytedance.applet.block.permissionapplycard.view.a();
        this.f191465d = "";
        this.f191466e = "";
        this.f191467f = LazyKt.lazy(new f(r100, this));
        setBackgroundResource(R.drawable.larus_permission_background_white);
        this.f191468g = LazyKt.lazy(new g(this));
    }

    public static final void R5(final PermissionApplyCardView r100, final com.larus.bmhome.chat.api.f r101) {
        LarusPermissionApplyCardViewBinding r102 = r100.getBinding();
        TextView r103 = r102.f191565j;
        String r104 = r101.f297194e;
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.setText(r104);
        TextView r106 = r102.f191564i;
        String r107 = r101.f297195f;
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        r106.setText(r107);
        TextView r108 = r102.f191563h;
        String r109 = r101.f297193d;
        if (r109 != null) goto L11;
        r109 = "";
    L11:
        r108.setText(r109);
        ImageLoaderKt.u(r102.f191560e, r101.f297192c, EffectConstants.CHANNEL_TEST);
        e1.d(r102.f191557b, new d(r100, r101));
        e1.d(r102.f191558c, new e(r100, r101));
        if (r101.f297196g == false) goto L14;
        e1.x(r102.f191557b);
        e1.x(r102.f191558c);
    L16:
        if (r101.f297199j == false) goto L18;
        e1.x(r102.f191562g);
        r102.f191558c.setText("");
        r102.f191558c.setEnabled(false);
    L23:
        if (r101.f297200k == false) goto L25;
        e1.x(r102.f191561f);
        r102.f191557b.setText("");
        r102.f191557b.setEnabled(false);
        return;
    L25:
        e1.q(r102.f191561f);
        RoundTextView r110 = r102.f191557b;
        String r111 = r101.f297198i;
        if (r111 == null) goto L29;
        r105 = r111;
    L29:
        r110.setText(r105);
        r102.f191557b.setEnabled(true);
        return;
    L18:
        e1.q(r102.f191562g);
        RoundTextView r112 = r102.f191558c;
        String r113 = r101.f297197h;
        if (r113 != null) goto L21;
        r113 = "";
    L21:
        r112.setText(r113);
        r102.f191558c.setEnabled(true);
        goto L23
    L14:
        e1.o(r102.f191557b);
        e1.o(r102.f191558c);
        goto L16
    }

    @Override // mi8.a
    public final void P2(boolean r100, boolean r101) {
        LarusPermissionApplyCardViewBinding r102 = getBinding();
        if (r100 == false) goto L5;
        e1.x(r102.f191562g);
        r102.f191558c.setText("");
    L6:
        if (r101 == false) goto L8;
        e1.x(r102.f191561f);
        r102.f191557b.setText("");
    L9:
        if (r100 == true) goto L12;
        if (r101 == true) goto L12;
        boolean r103 = true;
    L13:
        r102.f191558c.setEnabled(r103);
        r102.f191557b.setEnabled(r103);
        return;
    L12:
        r103 = false;
        goto L13
    L8:
        e1.q(r102.f191561f);
        r102.f191557b.setText(this.f191466e);
        goto L9
    L5:
        e1.q(r102.f191562g);
        r102.f191558c.setText(this.f191465d);
        goto L6
    }

    @Override // mi8.a
    public final void P5(final mi8.d r110, final qm8.b r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f191464c = r111;
        e1.x(this);
        boolean r100 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L7;
        String r101 = r110.f514113c;
        if (r101 != null) goto L10;
        r101 = r110.f514112b;
    L10:
        String r102 = r110.f514114d;
        String r103 = r110.f514115e;
        String r104 = r110.f514116f;
        String r105 = r110.f514118h;
        String r106 = r110.f514117g;
        final PermissionApplyCardView$bind$1 r107 = new PermissionApplyCardView$bind$1(r111);
        final PermissionApplyCardView$bind$2 r108 = new PermissionApplyCardView$bind$2(r111);
        LarusPermissionApplyCardViewBinding r109 = getBinding();
        if (r105 != null) goto L13;
        String r112 = "";
    L14:
        this.f191465d = r112;
        if (r106 != null) goto L17;
        String r113 = "";
    L18:
        this.f191466e = r113;
        TextView r114 = r109.f191565j;
        if (r103 != null) goto L21;
        r103 = "";
    L21:
        r114.setText(r103);
        TextView r115 = r109.f191564i;
        if (r104 != null) goto L24;
        r104 = "";
    L24:
        r115.setText(r104);
        TextView r116 = r109.f191563h;
        if (r102 != null) goto L27;
        r102 = "";
    L27:
        r116.setText(r102);
        ImageLoaderKt.u(r109.f191560e, r101, EffectConstants.CHANNEL_TEST);
        e1.d(r109.f191557b, new m(r108));
        e1.d(r109.f191558c, new n(r107));
        e1.x(r109.f191557b);
        e1.x(r109.f191558c);
        e1.q(r109.f191562g);
        RoundTextView r117 = r109.f191558c;
        if (r105 != null) goto L30;
        r105 = "";
    L30:
        r117.setText(r105);
        r109.f191558c.setEnabled(true);
        e1.q(r109.f191561f);
        RoundTextView r118 = r109.f191557b;
        if (r106 != null) goto L33;
        r106 = "";
    L33:
        r118.setText(r106);
        r109.f191557b.setEnabled(true);
        ExposeXTrackerExtKt.b(this, new i(r110, r111));
        return;
    L17:
        r113 = r106;
        goto L18
    L13:
        r112 = r105;
        goto L14
    L7:
        r101 = r110.f514112b;
        if (r101 != null) goto L10;
        r101 = r110.f514113c;
        goto L10
    }

    public final void S5(final p r100, ew3.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f191463b = r100.f191490c;
        AppletGrantingWidgetDelegate r102 = AppletGrantingWidgetDelegate.f297128a;     // Catch: Exception -> L8
        String r103 = r100.f191488a;     // Catch: Exception -> L8
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        r102.c(r103, r100.f191489b, new WeakReference(getCallback()));     // Catch: Exception -> L8
        ExposeXTrackerExtKt.b(this, new l(r100));     // Catch: Exception -> L8
        return;
    }
}
