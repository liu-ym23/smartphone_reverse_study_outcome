package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.EasterEggAnimationDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/LikeEggTemplatePreviewDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggTemplatePreviewDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int W = 0;
    public View B;
    public View C;
    public HSImageView D;
    public TextView E;
    public TextView F;
    public RecyclerView G;
    public View H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public TextView f139963J;
    public final List<n.a> K;
    public Function2<? super k, ? super Integer, Unit> L;
    public Function2<? super Integer, ? super Function0<Unit>, Unit> M;
    public k N;
    public String O;
    public DataCenter P;
    public int Q;
    public int R;
    public final CompositeDisposable S;
    public boolean T;
    public boolean U;
    public final Lazy V;

    public static final class a {
        public static void a(Context r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101, Function2 r102, Function2 r103, int r104, DataCenter r105) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "saveAction");
            Intrinsics.checkNotNullParameter(r103, "pickAction");
            ALogger.d("LikeEggTemplatePreviewDialog", "start launch");
            LikeEggTemplatePreviewDialog r106 = new LikeEggTemplatePreviewDialog(r100);
            List<n.a> r107 = r106.K;
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r108 = r101.jumpDetail;
            if (r108 == null) goto L9;
            n r109 = r108.templatePhotoJumpDetail;
            if (r109 == null) goto L9;
            List<n.a> r110 = r109.a();
            if (r110 == null) goto L9;
        L10:
            ((ArrayList) r107).addAll(r110);
            r106.L = r102;
            r106.M = r103;
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r111 = r101.jumpDetail;
            String r112 = null;
            if (r111 == null) goto L15;
            n r113 = r111.templatePhotoJumpDetail;
            if (r113 == null) goto L15;
            k r114 = r113.bgPhoto;
        L16:
            r106.N = r114;
            if (r111 == null) goto L21;
            n r115 = r111.templatePhotoJumpDetail;
            if (r115 == null) goto L21;
            r112 = r115.templatePanelTitle;
        L21:
            r106.O = r112;
            r106.Q = r104;
            r106.P = r105;
            if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r106);
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L25:
            DialogLancet.beforeDialogShow(r106);
            r106.show();
            DialogLancet.afterDialogShow(r106);
            return;
        L15:
            r114 = null;
        L9:
            r110 = CollectionsKt.emptyList();
            goto L10
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LikeEggTemplatePreviewDialog f139964a;

        public b(LikeEggTemplatePreviewDialog r100) {
            this.f139964a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            LikeEggTemplatePreviewDialog r102 = this.f139964a;
            int r103 = LikeEggTemplatePreviewDialog.W;
            r102.X0();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final boolean V0() {
        return true;
    }

    public final LikeEggTemplatePreviewDialog$mLayoutManager$2.AnonymousClass1 W0() {
        return (LikeEggTemplatePreviewDialog$mLayoutManager$2.AnonymousClass1) this.V.getValue();
    }

    public final void X0() {
        TokenCert r100 = LikeEggHelper.f140022a;
        int r101 = LikeEggHelper.a(this.P);
        View r102 = this.B;
        if (r102 == null) goto L5;
        a1.k(r102, r101);
    L5:
        int r103 = r101 - UtilityKotlinExtentionsKt.i(180);
        this.R = ((int) (((double) r103) * 0.66d)) + UtilityKotlinExtentionsKt.i(14);
        RecyclerView r104 = this.G;
        if (r104 != null) goto L8;
        return;
    L8:
        if ((r103 * 3) >= r104.getMeasuredWidth()) goto L12;
        a1.o(r104, UtilityKotlinExtentionsKt.i(38));
        a1.l(r104, UtilityKotlinExtentionsKt.i(93));
        this.R = ((int) (((double) ((r101 - UtilityKotlinExtentionsKt.i(38)) - UtilityKotlinExtentionsKt.i(93))) * 0.66d)) + UtilityKotlinExtentionsKt.i(14);
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.U == true) goto L5;
        this.U = true;
        StringBuilder r100 = new StringBuilder("likeEggDialogCount decrement: ");
        EasterEggAnimationDialog.f139896i.getClass();
        r100.append(EasterEggAnimationDialog.f139895h.decrementAndGet());
        ALogger.d("LikeEggTemplatePreviewDialog", r100.toString());
    L5:
        this.S.dispose();
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, android.app.Dialog
    public final void show() {
        ALogger.d("LikeEggTemplatePreviewDialog", "start show");
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return R.layout.ttlive_like_egg_image_preview_dialog_pad;
    L5:
        return R.layout.ttlive_like_egg_image_preview_dialog;
    }

    public LikeEggTemplatePreviewDialog(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.K = new ArrayList();
        this.S = new CompositeDisposable();
        this.V = LazyKt.lazy(new LikeEggTemplatePreviewDialog$mLayoutManager$2(r100));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setDimAmount(0.0f);
        r101.setLayout(-1, -1);
    L5:
        boolean r102 = false;
        setCanceledOnTouchOutside(false);
        View r103 = findViewById(R.id.ttlive_design_bottom_sheet);
        if (r103 == null) goto L8;
        a1.k(r103, -1);
    L8:
        this.B = findViewById(R.id.dialog_root);
        this.C = findViewById(R.id.click_outside);
        this.E = (TextView) findViewById(R.id.image_save_button);
        this.D = (HSImageView) findViewById(R.id.dialog_background);
        this.F = (TextView) findViewById(R.id.image_pick_button);
        this.G = (RecyclerView) findViewById(R.id.image_preview_recycler_view);
        this.H = findViewById(R.id.btn_close);
        this.I = (TextView) findViewById(R.id.template_author);
        this.f139963J = (TextView) findViewById(R.id.title);
        k r104 = this.N;
        if (r104 != null) goto L11;
    L13:
        String r105 = this.O;
        if (r105 != null) goto L16;
    L23:
        n.a r106 = (n.a) CollectionsKt.getOrNull(this.K, this.Q);
        if (r106 == null) goto L26;
        String r107 = r106.authorName;
    L27:
        if (r107 != null) goto L29;
    L35:
        TextView r108 = this.I;
        if (r108 == null) goto L38;
        r108.setText(null);
    L38:
        TextView r109 = this.E;
        if (r109 == null) goto L41;
        r109.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview.b(this));
    L41:
        TextView r110 = this.F;
        if (r110 == null) goto L44;
        r110.setOnClickListener(new LikeEggTemplatePreviewDialog$initViews$2(this));
    L44:
        View r111 = this.H;
        if (r111 == null) goto L47;
        r111.setOnClickListener(new c(this));
    L47:
        RecyclerView r112 = this.G;
        if (r112 == null) goto L57;
        PreviewItemAdapter r113 = new PreviewItemAdapter();
        List<k> r114 = r113.f139968a;
        List<n.a> r115 = this.K;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r117 = ((ArrayList) r115).iterator();
    L51:
        if (r117.hasNext() == false) goto L56;
        k r118 = ((n.a) r117.next()).templatePhoto;
        if (r118 != null) goto L55;
        r118 = (k) f.c(k.class);
    L55:
        r116.add(r118);
        goto L51
    L56:
        ((ArrayList) r114).addAll(r116);
        Function2<Integer, k, Unit> r119 = new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r119, "action");
        r113.f139969b = r119;
        Unit r120 = Unit.INSTANCE;
        r112.setAdapter(r113);
        r112.setLayoutManager(W0());
        new PagerSnapHelper().attachToRecyclerView(r112);
        r112.addItemDecoration(new CenterItemDecoration(new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$2(this)));
        r112.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview.a(r112, this));
        r112.addOnScrollListener(new LikeEggTemplatePreviewDialog$initRecyclerView$$inlined$apply$lambda$4(this));
    L57:
        W0().smoothScrollToPosition(this.G, new RecyclerView.State(), this.Q);
        X0();
        if (PadConfigUtils.c() == false) goto L69;
        u r121 = r.u(this.P, null, 2);
        if (r121 == null) goto L69;
        com.bytedance.live.datacontext.n<PadOrientation> r122 = r121.w();
        if (r122 == null) goto L69;
        Observable<sh6.b<PadOrientation>> r123 = r122.a();
        if (r123 == null) goto L69;
        Disposable r124 = r123.subscribe(new b(this));
        if (r124 == null) goto L69;
        RxUtilKt.c(r124, this.S);
    L69:
        if (this.T == true) goto L75;
        this.T = true;
        StringBuilder r125 = new StringBuilder("likeEggDialogCount increment: ");
        EasterEggAnimationDialog.f139896i.getClass();
        r125.append(EasterEggAnimationDialog.f139895h.incrementAndGet());
        ALogger.d("LikeEggTemplatePreviewDialog", r125.toString());
        return;
    L75:
        return;
    L29:
        if (r107.length() <= 0) goto L31;
        r102 = true;
    L31:
        if (r102 != true) goto L35;
        TextView r126 = this.I;
        if (r126 == null) goto L38;
        r126.setText("作者：".concat(r107));
        goto L38
    L26:
        r107 = null;
        goto L27
    L16:
        if (r105.length() != 0) goto L18;
        boolean r127 = true;
    L19:
        if (r127 == true) goto L23;
        TextView r128 = this.f139963J;
        if (r128 == null) goto L23;
        r128.setText(this.O);
        goto L23
    L18:
        r127 = false;
        goto L19
    L11:
        if (r104.isValid() != true) goto L13;
        ImageLoader.bindImage(this.D, this.N);
        goto L13
    }
}
