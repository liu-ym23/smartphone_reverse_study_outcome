package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.shopping.anchorv4.components.ScreenCaptureManager;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottomConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GallerySliceVisibilityConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantGravity;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.VideoCtrlContainerComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.GalleryJsEventHandler$register$2;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.GalleryVideoVH;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$1;
import com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$2;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\tJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/GalleryFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/GalleryViewerDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/k0;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/f;", "Lee3/e;", "Lhl/b;", "event", "", "addShopCartSuccessEvent", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryFragment extends GalleryViewerDialogFragment implements k0, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f, ee3.e {
    public static Integer M;
    public static final b N = null;
    public boolean A;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l B;
    public List<? extends com.bytedance.android.ec.model.k> C;
    public List<c0> D;
    public boolean E;
    public final Lazy F;
    public final HashMap<String, Boolean> G;
    public PendantContainerVO H;
    public ScreenCaptureManager I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f169220J;
    public final i0 K;
    public final Rect L;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.shopping.base.arch.viewmodel.a f169221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final m f169222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f169223t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f169224u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f169225v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public w0 f169226w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final GalleryLayerItemStateManager f169227x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f169228y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Function0<Rect> f169229z;

    public static final class a implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169230a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final GalleryLayerItemStateManager a() {
            return this.f169230a.f169227x;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l c() {
            return this.f169230a.B;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final int d() {
            int r100 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.m.f169521n;
            b r101 = GalleryFragment.N;
            Context r102 = this.f169230a.requireContext();
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Integer r103 = GalleryFragment.M;
            if (r103 == null) goto L5;
            int r104 = r103.intValue();
        L7:
            return r100 + r104;
        L5:
            r104 = eh.b.b(r102);
            GalleryFragment.M = Integer.valueOf(r104);
            goto L7
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final int f() {
            w0 r100 = this.f169230a.f169226w;
            if (r100 == null) goto L12;
            GalleryVO r101 = r100.f169453e;
            if (r101 != null) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 != true) goto L12;
            return com.bytedance.android.shopping.extensions.b.a(116);
        L7:
            if (r101.getHasSkuPreview() != true) goto L9;
            r102 = true;
        L12:
            w0 r103 = this.f169230a.f169226w;
            if (r103 == null) goto L24;
            GalleryVO r104 = r103.f169453e;
            if (r104 != null) goto L17;
        L19:
            boolean r105 = false;
        L20:
            if (r105 == true) goto L22;
            return 0;
        L22:
            return com.bytedance.android.shopping.extensions.b.a(52);
        L17:
            if (r104.getHasBottomButton() != true) goto L19;
            r105 = true;
            goto L20
        L24:
            return 0;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final Function0<Rect> g() {
            GalleryFragment r100 = this.f169230a;
            if (r100.L != null) goto L7;
            return null;
        L7:
            return r100.f169229z;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final RecyclerView getRecyclerView() {
            return this.f169230a.V90();
        }

        public a(GalleryFragment r100) {
            this.f169230a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final void b(Integer r100) {
            if (r100 == null) goto L4;
            int r101 = r100.intValue();
        L5:
            GalleryFragment r102 = this.f169230a;
            i0 r103 = r102.K;
            if (r103 == null) goto L9;
            r103.b(r102.fa0(r101));
            return;
        L9:
            return;
        L4:
            r101 = this.f169230a.f168623h;
            goto L5
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final void e(View r100, RectF r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
            n0 r102 = new n0(r101.top - r100.getTop(), r100.getBottom() - r101.bottom, r101.left - r100.getLeft(), r100.getRight() - r101.right);
            GalleryFragment r103 = this.f169230a;
            Integer r104 = GalleryFragment.M;
            GalleryViewModel r105 = r103.ja0();
            AnchorContainer r106 = AnchorContainer.GALLERY_PIC;
            State r107 = State.SHOW;
            r105.setAnchorContainerState(r106, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j(r107, r102));
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r108 = this.f169230a.ha0();
            if (r108 == null) goto L29;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j r109 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j(r107, r102);
            Intrinsics.checkNotNullParameter(r106, "anchorContainer");
            Intrinsics.checkNotNullParameter(r109, "data");
            if (r108.f166775c == null) goto L29;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L24
            Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r111 = r108.f166773a.entrySet().iterator();     // Catch: Throwable -> L24
        L9:
            if (r111.hasNext() == false) goto L22;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r112 = r111.next().getValue();     // Catch: Throwable -> L24
            if (r112 == null) goto L9;
            LynxElementVO r113 = r112.f166771f;     // Catch: Throwable -> L24
            if (r113 == null) goto L9;
            AnchorContainer.a r114 = AnchorContainer.Companion;     // Catch: Throwable -> L24
            ConfigModel r115 = r113.getConfig();     // Catch: Throwable -> L24
            if (r115 == null) goto L18;
            String r116 = r115.getAnchorContainer();     // Catch: Throwable -> L24
        L19:
            r114.getClass();     // Catch: Throwable -> L24
            if (AnchorContainer.a.a(r116) != r106) goto L9;
            r113.updateReactMargin(r109.f169318b);     // Catch: Throwable -> L24
            goto L9
        L18:
            r116 = null;
            goto L19
        L22:
            Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
            if (r118 == null) goto L29;
            ECExceptionMonitor.e(r118);
        L24:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L29:
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r120 = this.f169230a.ha0();
            if (r120 != null) goto L32;
            return;
        L32:
            if (r120.f166775c == null) goto L113;
            Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L70
            Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r122 = r120.f166773a.entrySet().iterator();     // Catch: Throwable -> L70
        L36:
            if (r122.hasNext() == false) goto L68;
            Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r123 = r122.next();     // Catch: Throwable -> L70
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r124 = r123.getValue();     // Catch: Throwable -> L70
            if (r124 == null) goto L42;
            View r125 = r124.f166766a;     // Catch: Throwable -> L70
            if (r125 == null) goto L42;
            ViewGroup.LayoutParams r126 = r125.getLayoutParams();     // Catch: Throwable -> L70
        L44:
            if ((r126 instanceof FrameLayout.LayoutParams) == true) goto L46;
            r126 = null;
        L46:
            FrameLayout.LayoutParams r127 = (FrameLayout.LayoutParams) r126;     // Catch: Throwable -> L70
            if (r127 == null) goto L36;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r128 = r123.getValue();     // Catch: Throwable -> L70
            if (r128 == null) goto L51;
            LynxElementVO r129 = r128.f166771f;     // Catch: Throwable -> L70
        L52:
            if (r129 == null) goto L36;
            PendantGravity r130 = r129.getGravity();     // Catch: Throwable -> L70
            if (r130 == null) goto L36;
            int r131 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.f.f166791c[r130.ordinal()];     // Catch: Throwable -> L70
            if (r131 != 1) goto L58;
            r127.bottomMargin = r129.getUseBottomMargin();     // Catch: Throwable -> L70
            r127.leftMargin = r129.getUseLeftMargin();     // Catch: Throwable -> L70
            r127.gravity = 8388691;     // Catch: Throwable -> L70
            goto L36
        L58:
            if (r131 != 2) goto L60;
            r127.topMargin = r129.getUseTopMargin();     // Catch: Throwable -> L70
            r127.rightMargin = r129.getUseRightMargin();     // Catch: Throwable -> L70
            r127.gravity = 8388661;     // Catch: Throwable -> L70
            goto L36
        L60:
            if (r131 != 3) goto L62;
            r127.bottomMargin = r129.getUseBottomMargin();     // Catch: Throwable -> L70
            r127.rightMargin = r129.getUseRightMargin();     // Catch: Throwable -> L70
            r127.gravity = VideoPlayDataContext.PLAYING_GRAVITY;     // Catch: Throwable -> L70
            goto L36
        L62:
            if (r131 != 4) goto L36;
            r127.topMargin = r129.getUseTopMargin();     // Catch: Throwable -> L70
            r127.leftMargin = r129.getUseLeftMargin();     // Catch: Throwable -> L70
            r127.gravity = 8388659;     // Catch: Throwable -> L70
            goto L36
        L51:
            r129 = null;
        L42:
            r126 = null;
            goto L44
        L68:
            Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
        L72:
            Throwable r133 = Result.m9452exceptionOrNullimpl(r132);
            if (r133 == null) goto L75;
            ECExceptionMonitor.e(r133);
        L75:
            r120.e();
            return;
        L70:
            th = move-exception;
            Result.Companion r134 = Result.Companion;
            r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L72
        }
    }

    public static final class b {
        public b() {
        }

        public static Integer a(q r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (r100.f169371i == null) goto L6;
            return 8;
        L6:
            if (r100.f169366d == null) goto L9;
            return 2;
        L9:
            if (r100.f169363a != null) goto L11;
            return null;
        L11:
            if (com.bytedance.android.shopping.extensions.k.c(r100.f169364b) == false) goto L14;
            int r101 = 7;
        L22:
            return Integer.valueOf(r101);
        L14:
            if (com.bytedance.android.shopping.extensions.k.c(r100.f169367e) == false) goto L16;
            r101 = 5;
            goto L22
        L16:
            r101 = 1;
            goto L22
        }

        public static Rect b(View r100) {
            View r101 = null;
            if (r100 != null) goto L6;
            return null;
        L6:
            if ((r100 instanceof GenericDraweeView) == false) goto L9;
            r101 = r100;
        L9:
            GenericDraweeView r102 = (GenericDraweeView) r101;
            if (r102 == null) goto L14;
            GenericDraweeHierarchy r103 = r102.getHierarchy();
            if (r103 == null) goto L14;
            RectF r104 = new RectF();
            r103.getActualImageBounds(r104);
            int r105 = (int) r104.width();
            int r106 = (int) r104.height();
        L15:
            if (r106 == 0) goto L17;
            if (r105 == 0) goto L17;
        L19:
            return TransitionUtils.calculateStartRect(r100, r105, r106, true);
        L17:
            r105 = r100.getWidth();
            r106 = r100.getHeight();
        L14:
            r105 = 0;
            r106 = 0;
            goto L15
        }
    }

    public static final class c extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f169231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Pair f169232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169233e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ i0 f169234f;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r100) {
            GalleryVO r101 = this.f169234f.s0();
            if (r101 == null) goto L11;
            GalleryPendants r102 = r101.getPendants();
            if (r102 == null) goto L11;
            GalleryConfig r103 = r102.getConfig();
            if (r103 == null) goto L11;
            Map<String, GallerySliceVisibilityConfig> r104 = r103.getVisibility();
            if (r104 == null) goto L11;
            GallerySliceVisibilityConfig r105 = r104.get(this.f169232d.getFirst());
        L12:
            if (r105 == null) goto L14;
            GalleryFragment r106 = this.f169233e;
            Integer r107 = GalleryFragment.M;
            r106.getClass();
            return GalleryFragment.da0(r105, r100);
        L14:
            return false;
        L11:
            r105 = null;
            goto L12
        }

        public c(View r100, View r101, m0 r102, Pair r103, GalleryFragment r104, i0 r105) {
            this.f169231c = r100;
            this.f169232d = r103;
            this.f169233e = r104;
            this.f169234f = r105;
            super(r101, r102);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169235a;

        public d(GalleryFragment r100) {
            this.f169235a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GalleryFragment.ba0(this.f169235a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ State f169237b;

        public e(GalleryFragment r100, State r101) {
            this.f169236a = r100;
            this.f169237b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GalleryFragment r100 = this.f169236a;     // Catch: Throwable -> L4
            Integer r101 = GalleryFragment.M;     // Catch: Throwable -> L4
            r100.ja0().setShowDependsState(ShowDependsOn.GALLERY_FIND_SIMILAR, this.f169237b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169238a;

        public f(GalleryFragment r100) {
            this.f169238a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GalleryFragment r101 = this.f169238a;
            int r102 = r101.f168623h;
            Integer r103 = GalleryFragment.M;
            r101.ka0(r101.fa0(r102), this.f169238a.f169222s, "bottom_left_find_same");
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169239a;

        public g(GalleryFragment r100) {
            this.f169239a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GalleryFragment r101 = this.f169239a;
            int r102 = r101.f168623h;
            Integer r103 = GalleryFragment.M;
            r101.ka0(r101.fa0(r102), this.f169239a.f169222s, "bottom_left_find_same");
        }
    }

    public static final class h implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169240a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d
        public final void b() {
            GalleryFragment r100 = this.f169240a;
            GalleryAdapter r101 = r100.f168618p;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r102 = null;
            if ((r101 instanceof GalleryCompatAdapter) == true) goto L5;
            r101 = null;
        L5:
            GalleryCompatAdapter r103 = (GalleryCompatAdapter) r101;
            if (r103 != null) goto L8;
            return;
        L8:
            int r104 = r100.f168623h;
            h0 r105 = r103.f169214g;
            if (r105 == null) goto L13;
            RecyclerView r106 = r105.getRecyclerView();
            if (r106 == null) goto L13;
            Object r107 = r106.findViewHolderForAdapterPosition(r104);
        L15:
            if ((r107 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L17;
            r107 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r108 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r107;
            if ((r108 instanceof GalleryVideoVH) == false) goto L21;
            r102 = r108;
        L21:
            GalleryVideoVH r109 = (GalleryVideoVH) r102;
            if (r109 != null) goto L24;
            return;
        L24:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r110 = r109.f169433q;
            if (r110 == null) goto L28;
            r110.f169328f.setMoreVideoExpanded(!r109.X3());
            r109.f169433q.f169329g.g(r109.X3());
            return;
        L28:
            return;
        L13:
            r107 = null;
            goto L15
        }

        public h(GalleryFragment r100) {
            this.f169240a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d
        public final void a(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0 r100) {
            Intrinsics.checkNotNullParameter(r100, "playerEventInfo");
            GalleryFragment r101 = this.f169240a;
            GalleryAdapter r102 = r101.f168618p;
            Object r103 = null;
            if ((r102 instanceof GalleryCompatAdapter) == true) goto L5;
            r102 = null;
        L5:
            GalleryCompatAdapter r104 = (GalleryCompatAdapter) r102;
            if (r104 != null) goto L8;
            return;
        L8:
            int r105 = r101.f168623h;
            h0 r106 = r104.f169214g;
            if (r106 == null) goto L13;
            RecyclerView r107 = r106.getRecyclerView();
            if (r107 == null) goto L13;
            Object r108 = r107.findViewHolderForAdapterPosition(r105);
        L15:
            if ((r108 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L17;
            r108 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r109 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r108;
            if ((r109 instanceof GalleryVideoVH) == true) goto L20;
            r109 = null;
        L20:
            GalleryVideoVH r110 = (GalleryVideoVH) r109;
            if (r110 != null) goto L24;
            return;
        L24:
            if (Intrinsics.areEqual(r100.f169059b, "PDPPlayerControl") == false) goto L87;
            Object r111 = r100.f169060c.get("command");
            if ((r111 instanceof String) == false) goto L29;
            r103 = r111;
        L29:
            String r112 = (String) r103;
            if (r112 != null) goto L33;
            r112 = "";
        L33:
            switch(r112.hashCode()) {
                case 3363353: goto L64;
                case 3443508: goto L56;
                case 3526264: goto L45;
                case 3540994: goto L43;
                case 106440182: goto L36;
                default: goto L101;
            };
        L43:
            r112.equals("stop");
            return;
        L101:
            return;
        L36:
            if (r112.equals("pause") == false) goto L88;
            x73.a r113 = r110.f169417a;
            if (r113 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L41:
            if (r113.isPlaying() == false) goto L89;
            r110.pausePlay();
            return;
        L89:
            return;
        L88:
            return;
        L45:
            if (r112.equals("seek") == false) goto L92;
            Object r114 = r100.f169060c.get("progress");
            float r115 = 0.0f;
            if (r114 == null) goto L49;
            r115 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r114, 0.0f);
        L49:
            dm.a.a("GalleryFragment").i("handelLynxPlayerEvent, progress seekTo: " + r115);
            if (r115 <= 0) goto L93;
            x73.a r116 = r110.f169417a;
            if (r116 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L54:
            r116.seek(r115);
            return;
        L93:
            return;
        L92:
            return;
        L56:
            if (r112.equals("play") == false) goto L95;
            x73.a r117 = r110.f169417a;
            if (r117 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L61:
            if (r117.isPlaying() == true) goto L96;
            r110.startPlay();
            return;
        L96:
            return;
        L95:
            return;
        L64:
            if (r112.equals(ITTVideoEngineEventSource.KEY_MUTE) == false) goto L98;
            boolean r118 = Intrinsics.areEqual(r100.f169060c.get(ITTVideoEngineEventSource.KEY_MUTE), 1);
            dm.a.a("GalleryFragment").i("onPlayerEvent, isMute: " + r118);
            x73.a r119 = r110.f169417a;
            if (r119 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L68:
            r119.f(r118, false);
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r120 = r110.f169433q;
            if (r120 == null) goto L73;
            GalleryViewModel r121 = r120.f169328f;
            if (r121 == null) goto L73;
            r121.setVideoManualMuteState(Boolean.valueOf(r118));
        L73:
            GalleryVideoVH.a r122 = r110.f169429m;
            if (r122 == null) goto L76;
            r122.n(r118, true);
        L76:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r123 = r110.f169433q;
            if (r123 == null) goto L81;
            m r124 = r123.f169329g;
            if (r124 == null) goto L81;
            r124.h(r110.getAdapterPosition(), r118);
        L81:
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r125 = r110.f169428l.f497679g;
            if (r125 == null) goto L99;
            VideoCtrlContainerComponent r126 = r125.f166804c;
            if (r126 == null) goto L100;
            int r127 = VideoCtrlContainerComponent.f166794g;
            r126.c(0);
            return;
        L100:
            return;
        L99:
            return;
        L98:
            return;
        L87:
            return;
        L13:
            r108 = null;
            goto L15
        }
    }

    public static final class i extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169241c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r100) {
            GalleryFragment r101 = this.f169241c;
            Integer r102 = GalleryFragment.M;
            q r103 = r101.fa0(r100);
            if (r103 == null) goto L19;
            String r104 = r103.f169365c;
            if (r104 != null) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L13;
        L15:
            boolean r106 = false;
        L16:
            if (r106 != true) goto L20;
            return true;
        L20:
            return false;
        L13:
            if (r103.f169371i != null) goto L15;
            r106 = true;
            goto L16
        L7:
            if (r104.length() == 0) goto L10;
            r105 = false;
            goto L11
        L19:
            return false;
        }

        public i(GalleryFragment r100, IndexIndicator r101, m0 r102) {
            this.f169241c = r100;
            super(r101, r102);
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169242a;

        public j(GalleryFragment r100) {
            this.f169242a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            GalleryFragment r101 = this.f169242a;
            int r102 = ((Integer) r100).intValue();
            Integer r103 = GalleryFragment.M;
            if (r102 != 3) goto L7;
            q r104 = r101.fa0(r101.f168623h);
            i0 r105 = r101.K;
            if (r105 == null) goto L9;
            r105.e(r101.f168623h, r104, true);
            return;
        L9:
            return;
        L7:
            r101.getClass();
        }
    }

    public static final class k implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169243a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final String a() {
            return this.f169243a.K.y0();
        }

        public final ActionContext d() {
            return this.f169243a.K.n0();
        }

        public final ng3.a e() {
            return this.f169243a.K.r0();
        }

        public k(GalleryFragment r100) {
            this.f169243a = r100;
        }

        public final com.bytedance.android.ecom.arch.slice.action.p b(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return this.f169243a.K.u0(r100);
        }

        public final com.bytedance.android.ecom.arch.slice.action.j c(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return this.f169243a.K.t0(r100);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final void k0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sliceId");
            this.f169243a.K.k0(r100);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final void l0(int r100, String r101) {
            this.f169243a.K.l0(r100, r101);
        }
    }

    public static final class l<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryFragment f169244a;

        public l(GalleryFragment r100) {
            this.f169244a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            Pair r100 = (Pair) r210;
            Map r101 = (Map) r100.component1();
            Map r102 = (Map) r100.component2();
            GalleryFragment r103 = this.f169244a;
            PendantContainerVO r104 = r103.H;
            if (r104 == null) goto L284;
            ArrayList r105 = new ArrayList();
            ArrayList r106 = new ArrayList();
            ArrayList r107 = new ArrayList();
            ArrayList r108 = new ArrayList();
            if (r101 == null) goto L117;
            Iterator r109 = r101.entrySet().iterator();
        L9:
            if (r109.hasNext() == false) goto L116;
            Map.Entry r110 = (Map.Entry) r109.next();
            AnchorContainer r111 = (AnchorContainer) r110.getKey();
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j r112 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j) r110.getValue();
            if (r112.f169317a != State.SHOW) goto L9;
            List<LynxElementVO> r113 = r104.getLeftBottom();
            if (r113 == null) goto L38;
            ArrayList r114 = new ArrayList();
            Iterator<T> r115 = r113.iterator();
        L16:
            if (r115.hasNext() == false) goto L29;
            T r116 = r115.next();
            LynxElementVO r117 = (LynxElementVO) r116;
            AnchorContainer.a r118 = AnchorContainer.Companion;
            if (r117 == null) goto L22;
            ConfigModel r119 = r117.getConfig();
            if (r119 == null) goto L22;
            String r120 = r119.getAnchorContainer();
        L23:
            r118.getClass();
            if (AnchorContainer.a.a(r120) != r111) goto L26;
            boolean r121 = true;
        L27:
            if (r121 == false) goto L16;
            r114.add(r116);
            goto L16
        L26:
            r121 = false;
        L22:
            r120 = null;
            goto L23
        L29:
            ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator r123 = r114.iterator();
        L31:
            if (r123.hasNext() == false) goto L37;
            LynxElementVO r124 = (LynxElementVO) r123.next();
            if (r124 == null) goto L35;
            r124.updateReactMargin(r112.f169318b);
        L36:
            r122.add(r124);
            goto L31
        L35:
            r124 = null;
            goto L36
        L37:
            r105.addAll(r122);
        L38:
            List<LynxElementVO> r125 = r104.getRightBottom();
            if (r125 == null) goto L64;
            ArrayList r126 = new ArrayList();
            Iterator<T> r127 = r125.iterator();
        L42:
            if (r127.hasNext() == false) goto L55;
            T r128 = r127.next();
            LynxElementVO r129 = (LynxElementVO) r128;
            AnchorContainer.a r130 = AnchorContainer.Companion;
            if (r129 == null) goto L48;
            ConfigModel r131 = r129.getConfig();
            if (r131 == null) goto L48;
            String r132 = r131.getAnchorContainer();
        L49:
            r130.getClass();
            if (AnchorContainer.a.a(r132) != r111) goto L52;
            boolean r133 = true;
        L53:
            if (r133 == false) goto L42;
            r126.add(r128);
            goto L42
        L52:
            r133 = false;
        L48:
            r132 = null;
            goto L49
        L55:
            ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
            Iterator r135 = r126.iterator();
        L57:
            if (r135.hasNext() == false) goto L63;
            LynxElementVO r136 = (LynxElementVO) r135.next();
            if (r136 == null) goto L61;
            r136.updateReactMargin(r112.f169318b);
        L62:
            r134.add(r136);
            goto L57
        L61:
            r136 = null;
            goto L62
        L63:
            r106.addAll(r134);
        L64:
            List<LynxElementVO> r137 = r104.getTopRight();
            if (r137 == null) goto L90;
            ArrayList r138 = new ArrayList();
            Iterator<T> r139 = r137.iterator();
        L68:
            if (r139.hasNext() == false) goto L81;
            T r140 = r139.next();
            LynxElementVO r141 = (LynxElementVO) r140;
            AnchorContainer.a r142 = AnchorContainer.Companion;
            if (r141 == null) goto L74;
            ConfigModel r143 = r141.getConfig();
            if (r143 == null) goto L74;
            String r144 = r143.getAnchorContainer();
        L75:
            r142.getClass();
            if (AnchorContainer.a.a(r144) != r111) goto L78;
            boolean r145 = true;
        L79:
            if (r145 == false) goto L68;
            r138.add(r140);
            goto L68
        L78:
            r145 = false;
        L74:
            r144 = null;
            goto L75
        L81:
            ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r138, 10));
            Iterator r147 = r138.iterator();
        L83:
            if (r147.hasNext() == false) goto L89;
            LynxElementVO r148 = (LynxElementVO) r147.next();
            if (r148 == null) goto L87;
            r148.updateReactMargin(r112.f169318b);
        L88:
            r146.add(r148);
            goto L83
        L87:
            r148 = null;
            goto L88
        L89:
            r107.addAll(r146);
        L90:
            List<LynxElementVO> r149 = r104.getTopLeft();
            if (r149 == null) goto L9;
            ArrayList r150 = new ArrayList();
            Iterator<T> r151 = r149.iterator();
        L94:
            if (r151.hasNext() == false) goto L107;
            T r152 = r151.next();
            LynxElementVO r153 = (LynxElementVO) r152;
            AnchorContainer.a r154 = AnchorContainer.Companion;
            if (r153 == null) goto L100;
            ConfigModel r155 = r153.getConfig();
            if (r155 == null) goto L100;
            String r156 = r155.getAnchorContainer();
        L101:
            r154.getClass();
            if (AnchorContainer.a.a(r156) != r111) goto L104;
            boolean r157 = true;
        L105:
            if (r157 == false) goto L94;
            r150.add(r152);
            goto L94
        L104:
            r157 = false;
        L100:
            r156 = null;
            goto L101
        L107:
            ArrayList r158 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
            Iterator r159 = r150.iterator();
        L109:
            if (r159.hasNext() == false) goto L115;
            LynxElementVO r160 = (LynxElementVO) r159.next();
            if (r160 == null) goto L113;
            r160.updateReactMargin(r112.f169318b);
        L114:
            r158.add(r160);
            goto L109
        L113:
            r160 = null;
            goto L114
        L115:
            r108.addAll(r158);
            goto L9
        L116:
            Unit r161 = Unit.INSTANCE;
        L117:
            GalleryFragment$onPendantContainerStateChange$2 r162 = GalleryFragment$onPendantContainerStateChange$2.INSTANCE;
            ArrayList r163 = new ArrayList();
            ArrayList r164 = new ArrayList();
            ArrayList r165 = new ArrayList();
            ArrayList r166 = new ArrayList();
            ArrayList r167 = new ArrayList();
            Iterator r168 = r105.iterator();
        L119:
            if (r168.hasNext() == false) goto L131;
            Object r169 = r168.next();
            LynxElementVO r170 = (LynxElementVO) r169;
            if (r170 == null) goto L125;
            ConfigModel r171 = r170.getConfig();
            if (r171 == null) goto L125;
            String r172 = r171.getShowDependsOn();
        L126:
            if (r172 != null) goto L128;
            boolean r173 = true;
        L129:
            if (r173 == false) goto L119;
            r167.add(r169);
            goto L119
        L128:
            r173 = false;
        L125:
            r172 = null;
            goto L126
        L131:
            r163.addAll(r167);
            ArrayList r174 = new ArrayList();
            Iterator r175 = r106.iterator();
        L133:
            if (r175.hasNext() == false) goto L145;
            Object r176 = r175.next();
            LynxElementVO r177 = (LynxElementVO) r176;
            if (r177 == null) goto L139;
            ConfigModel r178 = r177.getConfig();
            if (r178 == null) goto L139;
            String r179 = r178.getShowDependsOn();
        L140:
            if (r179 != null) goto L142;
            boolean r180 = true;
        L143:
            if (r180 == false) goto L133;
            r174.add(r176);
            goto L133
        L142:
            r180 = false;
        L139:
            r179 = null;
            goto L140
        L145:
            r164.addAll(r174);
            ArrayList r181 = new ArrayList();
            Iterator r182 = r107.iterator();
        L147:
            if (r182.hasNext() == false) goto L159;
            Object r183 = r182.next();
            LynxElementVO r184 = (LynxElementVO) r183;
            if (r184 == null) goto L153;
            ConfigModel r185 = r184.getConfig();
            if (r185 == null) goto L153;
            String r186 = r185.getShowDependsOn();
        L154:
            if (r186 != null) goto L156;
            boolean r187 = true;
        L157:
            if (r187 == false) goto L147;
            r181.add(r183);
            goto L147
        L156:
            r187 = false;
        L153:
            r186 = null;
            goto L154
        L159:
            r165.addAll(r181);
            ArrayList r188 = new ArrayList();
            Iterator r189 = r108.iterator();
        L161:
            if (r189.hasNext() == false) goto L173;
            Object r190 = r189.next();
            LynxElementVO r191 = (LynxElementVO) r190;
            if (r191 == null) goto L167;
            ConfigModel r192 = r191.getConfig();
            if (r192 == null) goto L167;
            String r193 = r192.getShowDependsOn();
        L168:
            if (r193 != null) goto L170;
            boolean r194 = true;
        L171:
            if (r194 == false) goto L161;
            r188.add(r190);
            goto L161
        L170:
            r194 = false;
        L167:
            r193 = null;
            goto L168
        L173:
            r166.addAll(r188);
            if (r102 == null) goto L184;
            Iterator r195 = r102.entrySet().iterator();
        L177:
            if (r195.hasNext() == false) goto L183;
            Map.Entry r196 = (Map.Entry) r195.next();
            ShowDependsOn r197 = (ShowDependsOn) r196.getKey();
            State r198 = (State) r196.getValue();
            if (r198 == State.SHOW) goto L182;
            if (r198 != State.ANIM_END) goto L177;
        L182:
            GalleryFragment$onPendantContainerStateChange$2 r199 = GalleryFragment$onPendantContainerStateChange$2.INSTANCE;
            r163.addAll(r199.invoke2(r105, r197, r198));
            r164.addAll(r199.invoke2(r106, r197, r198));
            r165.addAll(r199.invoke2(r107, r197, r198));
            r166.addAll(r199.invoke2(r108, r197, r198));
            goto L177
        L183:
            Unit r200 = Unit.INSTANCE;
        L184:
            PendantContainerVO.Companion r201 = PendantContainerVO.Companion;
            List<LynxElementVO> r202 = r104.getLeftBottom();
            r201.getClass();
            PendantContainerVO r203 = r104.copy(PendantContainerVO.Companion.d(r202, r163), PendantContainerVO.Companion.d(r104.getRightBottom(), r164), PendantContainerVO.Companion.d(r104.getTopRight(), r165), PendantContainerVO.Companion.d(r104.getTopLeft(), r166));
            if (r203.getLeftBottom() == null) goto L189;
            if (r203.getLeftBottom().isEmpty() == true) goto L189;
        L200:
            boolean r1100 = true;
        L202:
            if (r1100 == true) goto L205;
            r203 = null;
        L205:
            r103.H = r203;
            if (r163.isEmpty() == true) goto L208;
        L214:
            PendantContainerVO r204 = new PendantContainerVO(r163, r164, r165, r166);
            i0 r205 = r103.K;
            if (r205 == null) goto L283;
            r103.ca0(r204, r205);
            return;
        L283:
            return;
        L208:
            if (r164.isEmpty() == false) goto L214;
            if (r165.isEmpty() == false) goto L214;
            if (r166.isEmpty() == false) goto L214;
            return;
        L189:
            if (r203.getRightBottom() == null) goto L193;
            if (r203.getRightBottom().isEmpty() == false) goto L200;
        L193:
            if (r203.getTopRight() == null) goto L197;
            if (r203.getTopRight().isEmpty() == false) goto L200;
        L197:
            if (r203.getTopLeft() != null) goto L199;
        L201:
            r1100 = false;
            goto L202
        L199:
            if (r203.getTopLeft().isEmpty() == true) goto L201;
        }
    }

    public GalleryFragment() {
        this(null, null);
    }

    public final com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e ha0() {
        return (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e) this.F.getValue();
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g ia0() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g) this.f169223t.getValue();
    }

    public final GalleryViewModel ja0() {
        return (GalleryViewModel) this.f169221r.getValue();
    }

    static {
        N = new b();
    }

    @Override // ee3.e
    public final void M0() {
        m r100 = this.f169222s;
        if (r100 == null) goto L6;
        m.d(r100, "pdp_long_press", null, null, "a1.b34986.c0.d0", 30);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void Y90() {
        GalleryAdapter r100 = this.f168618p;
        if ((r100 instanceof GalleryCompatAdapter) == true) goto L5;
        r100 = null;
    L5:
        GalleryCompatAdapter r101 = (GalleryCompatAdapter) r100;
        if (r101 == null) goto L8;
        r101.C2();
    L8:
        Lazy r102 = UIUtils.f45548a;
        UIUtils.c().post(new d(this));
    }

    public final boolean ea0() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L17;
        RecyclerView.ViewHolder r100 = V90().findViewHolderForAdapterPosition(this.f168623h);
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof TransitionViewHolder) == true) goto L9;
        r100 = null;
    L9:
        TransitionViewHolder r101 = (TransitionViewHolder) r100;
        if (r101 == null) goto L20;
        TransitionLayout r102 = r101.getTransitionLayout();
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.isEnableDismissTransition() == false) goto L22;
        r102.dismissAnimated();
        return true;
    L22:
        return false;
    L20:
        return false;
    L17:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        cl.d.f24079a.getClass();
        cl.d r100 = cl.d.a.b();
        if (r100 == null) goto L6;
        r100.f();
    L6:
        if (this.E == false) goto L10;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r101 = ha0();
        if (r101 == null) goto L10;
        r101.f();
    L10:
        m r102 = this.f169222s;
        Long r103 = r102.f169337c;
        if (r103 == null) goto L13;
        long r104 = (System.currentTimeMillis() - r103.longValue()) / ((long) 1000);
    L14:
        Pair[] r105 = new Pair[2];
        r105[0] = TuplesKt.to("duration", Long.valueOf(r104));
        if (r102.f169338d == false) goto L17;
        String r106 = "back";
    L18:
        r105[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r106);
        m.d(r102, "pdp_big_picture_click", MapsKt.mapOf(r105), null, "a1.b34986.c0.d0", 28);
        w0 r107 = this.f169226w;
        if (r107 == null) goto L32;
        v0 r108 = r107.f169449a;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r109 = r108.f169408b;
        if (r109 == null) goto L23;
        r109.release();
    L23:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r110 = r108.f169415i;
        if (r110 == null) goto L28;
        EventChain r111 = r110.f169334l;
        if (r111 == null) goto L28;
        r111.b();
    L28:
        SlcContext r112 = r108.f169407a;
        if (r112 == null) goto L32;
        r112.d();
    L32:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L34;
        com.bytedance.android.ec.core.utils.s0.e(this);
    L34:
        i0 r113 = this.K;
        GalleryAdapter r114 = null;
        if (r113 == null) goto L43;
        q r115 = fa0(this.f168623h);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r116 = this.B;
        if (r116 == null) goto L41;
        z0 r117 = r116.f169323a;
        if (r117 == null) goto L41;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h r118 = r117.f169571b;
    L42:
        r113.d(r115, r118);
    L41:
        r118 = null;
    L43:
        GalleryAdapter r119 = this.f168618p;
        if ((r119 instanceof GalleryCompatAdapter) == false) goto L47;
        r114 = r119;
    L47:
        GalleryCompatAdapter r120 = (GalleryCompatAdapter) r114;
        if (r120 == null) goto L50;
        r120.C2();
    L50:
        this.G.clear();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L56;
        Iterator r121 = ((LinkedHashMap) ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.f169220J.getValue()).f169303a).entrySet().iterator();
    L54:
        if (r121.hasNext() == false) goto L58;
        Map.Entry r122 = (Map.Entry) r121.next();
        ECLiveHybridUtil.p((String) r122.getKey(), (ti.j) r122.getValue());
        goto L54
    L58:
        return;
    L56:
        return;
    L17:
        r106 = "blank";
        goto L18
    L13:
        r104 = 0;
        goto L14
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g r100 = ia0();
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        GalleryAdapter r100 = this.f168618p;
        if ((r100 instanceof GalleryCompatAdapter) == true) goto L5;
        r100 = null;
    L5:
        GalleryCompatAdapter r101 = (GalleryCompatAdapter) r100;
        if (r101 == null) goto L11;
        Iterator r102 = ((ArrayList) r101.f169213f).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r102.next()).t0();
    L11:
        ScreenCaptureManager r103 = this.I;
        if (r103 == null) goto L16;
        r103.f();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        GalleryAdapter r100 = this.f168618p;
        if ((r100 instanceof GalleryCompatAdapter) == true) goto L5;
        r100 = null;
    L5:
        GalleryCompatAdapter r101 = (GalleryCompatAdapter) r100;
        if (r101 == null) goto L11;
        Iterator r102 = ((ArrayList) r101.f169213f).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r102.next()).Y2();
    L11:
        ScreenCaptureManager r103 = this.I;
        if (r103 == null) goto L16;
        r103.g();
        return;
    }

    public static final /* synthetic */ void ba0(GalleryFragment r100) {
        super.Y90();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void Bt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        q r101 = fa0(this.f168623h);
        if (r101 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r101.f169364b) == false) goto L8;
        int r102 = 2;
    L10:
        if (r101.f169366d == null) goto L12;
        String r103 = "video";
    L14:
        if (Intrinsics.areEqual(r100, "top_right_find_same") == false) goto L17;
        String r104 = "1";
    L20:
        this.f169222s.a(r102, r103, r104);
        return;
    L17:
        if (Intrinsics.areEqual(r100, "bottom_left_find_same") == false) goto L19;
        r104 = "2";
        goto L20
    L19:
        r104 = null;
        goto L20
    L12:
        r103 = "image";
        goto L14
    L8:
        r102 = 1;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void T90(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        GalleryLayerItemStateManager r101 = this.f169227x;
        if (r101 == null) goto L6;
        r101.d(r100, r101.f169254i);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void X90(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<? extends com.bytedance.android.ec.model.k> r100 = this.C;
        List<c0> r101 = this.D;
        GalleryViewModel r102 = ja0();
        m r103 = this.f169222s;
        i0 r104 = this.K;
        GalleryLayerItemStateManager r105 = this.f169227x;
        FragmentActivity r106 = getActivity();
        if ((r106 instanceof FullScreenGalleryDialogActivity) == true) goto L5;
        r106 = null;
    L5:
        FullScreenGalleryDialogActivity r107 = (FullScreenGalleryDialogActivity) r106;
        if (r107 == null) goto L8;
        GalleryViewerParams r111 = r107.f166175k;
    L9:
        this.B = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l(r100, r101, r110, this, r102, r103, r104, r105, r111, PageFinder.via(this));
        super.X90(r110);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L15;
        FrameLayout r108 = W90();
        View r109 = new View(r110);
        r109.setBackgroundResource(R.drawable.anchor_v4_gallery_video_cover_top);
        GalleryLayerItemStateManager r112 = this.f169227x;
        if (r112 == null) goto L14;
        r112.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r109, false, true, false, 16));
    L14:
        Unit r113 = Unit.INSTANCE;
        r108.addView(r109, new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.a(100)));
    L15:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r114 = this.B;
        if (r114 != null) goto L18;
    L20:
        ia0().c(W90(), this.B);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a == false) goto L34;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.h r115 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.h(r110);
        FrameLayout r116 = W90();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r117 = this.B;
        Intrinsics.checkNotNullParameter(r116, KtvSubElement.CONTAINER);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-2, -2);
        r118.gravity = 8388629;
        Unit r119 = Unit.INSTANCE;
        r116.addView(r115, r118);
        if (r117 == null) goto L29;
        GalleryViewModel r120 = r117.f169328f;
        if (r120 == null) goto L29;
        LiveData<Integer> r121 = r120.getCurPlayingVideoPosition();
        if (r121 == null) goto L29;
        r121.observe(r117.f169327e, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.k(r115, r117));
    L29:
        if (r117 == null) goto L35;
        GalleryLayerItemStateManager r122 = r117.f169331i;
        if (r122 == null) goto L36;
        r122.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.l(r115, r115));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L18:
        if (r114.b() != true) goto L20;
        ja0().setMoreVideoExpanded(true);
        goto L20
    L8:
        r111 = null;
        goto L9
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void addShopCartSuccessEvent(hl.b r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (isResumed() == true) goto L5;
        return;
    L5:
        if (r110.f485629o == true) goto L45;
        w0 r100 = this.f169226w;
        String r101 = null;
        if (r100 == null) goto L25;
        GalleryVO r102 = r100.f169453e;
        if (r102 == null) goto L25;
        GalleryBottom r103 = r102.getBottom();
        if (r103 == null) goto L25;
        GalleryBottomConfig r104 = r103.getConfig();
        if (r104 == null) goto L25;
        IAction r105 = r104.getAddCartToast();
        if (r105 == null) goto L25;
        int r106 = com.bytedance.android.shopping.anchorv4.event_chain.c.f166550a;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r107 = r100.f169457i;
        if (r107 == null) goto L19;
        EventChain r108 = r107.f169334l;
    L20:
        SlcContext r109 = r100.f169449a.f169407a;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r111 = r100.f169450b;
        if (r111 == null) goto L23;
        LinearLayout r112 = r111.f169281a;
    L24:
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(r108, null, r109, r105, r112, null);
        goto L25
    L23:
        r112 = null;
        goto L24
    L19:
        r108 = null;
    L25:
        String r113 = r110.f485630p;
        if (r113 != null) goto L28;
    L31:
        boolean r114 = true;
    L32:
        if (r114 == true) goto L46;
        JSONObject r115 = new JSONObject();     // Catch: JSONException -> L39
        r115.put("cart_id", r113);     // Catch: JSONException -> L39
        i0 r116 = this.K;     // Catch: JSONException -> L39
        if (r116 == null) goto L37;
        r101 = r116.v0();     // Catch: JSONException -> L39
    L37:
        r115.put("pdp_event_transparent_id", String.valueOf(r101));     // Catch: JSONException -> L39
        Unit r117 = Unit.INSTANCE;     // Catch: JSONException -> L39
        ECLiveHybridUtil.f("ecom.pdp.add_cart", r115);     // Catch: JSONException -> L39
        return;
    L39:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L46:
        return;
    L28:
        if (r113.length() == 0) goto L31;
        r114 = false;
        goto L32
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final boolean ey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        if (Intrinsics.areEqual(r100, "top_right_find_same") == false) goto L7;
        return ia0().a();
    L7:
        if (Intrinsics.areEqual(r100, "bottom_left_find_same") == false) goto L15;
        LinearLayout r101 = this.f169228y;
        if ((r101 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) == true) goto L11;
        r101 = null;
    L11:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r102 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) r101;
        if (r102 != null) goto L14;
        return false;
    L14:
        return r102.getBubbleIsShown();
    L15:
        return false;
    }

    public final q fa0(int r100) {
        g0 r101 = ga0(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f169311p;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void gD(State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().post(new e(this, r100));
    }

    public final g0 ga0(int r100) {
        List<? extends com.bytedance.android.ec.model.l> r101 = this.f168618p.f176135b;
        com.bytedance.android.ec.model.l r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.ec.model.l r103 = (com.bytedance.android.ec.model.l) CollectionsKt.getOrNull(r101, r100);
    L7:
        if ((r103 instanceof g0) == false) goto L11;
        r102 = r103;
    L11:
        return (g0) r102;
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void k0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceId");
        if (this.A == true) goto L5;
        return;
    L5:
        w0 r101 = this.f169226w;
        if (r101 == null) goto L50;
        int r102 = w0.f169448k;
        Intrinsics.checkNotNullParameter(r100, "sliceId");
        GalleryVO r103 = r101.f169453e;
        com.bytedance.android.ecom.arch.slice.g r104 = null;
        Object r105 = null;
        r104 = null;
        r104 = null;
        if (r103 == null) goto L21;
        GalleryBottom r106 = r103.getBottom();
        if (r106 == null) goto L21;
        List<com.bytedance.android.ecom.arch.slice.g> r107 = r106.getSlices();
        if (r107 == null) goto L21;
        Iterator<T> r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r109).getSliceId(), r100) == false) goto L15;
    L20:
        com.bytedance.android.ecom.arch.slice.g r110 = (com.bytedance.android.ecom.arch.slice.g) r109;
    L23:
        if (r110 == null) goto L27;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r111 = r101.f169450b;
        if (r111 == null) goto L51;
        Intrinsics.checkNotNullParameter(r110, "slice");
        r111.f169282b.c(r110);
        return;
    L51:
        return;
    L27:
        if (r103 == null) goto L39;
        GalleryPendants r112 = r103.getPendants();
        if (r112 == null) goto L39;
        List<com.bytedance.android.ecom.arch.slice.g> r113 = r112.getSlices();
        if (r113 == null) goto L39;
        Iterator<T> r114 = r113.iterator();
    L34:
        if (r114.hasNext() == false) goto L38;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r115).getSliceId(), r100) == false) goto L34;
        r105 = r115;
    L38:
        r104 = (com.bytedance.android.ecom.arch.slice.g) r105;
    L39:
        if (r104 == null) goto L53;
        t0 r116 = r101.f169452d;
        if (r116 == null) goto L54;
        Intrinsics.checkNotNullParameter(r104, "slice");
        r116.f169402b.c(r104);
        return;
    L54:
        return;
    L53:
        return;
    L19:
        r109 = null;
    L21:
        r110 = null;
        goto L23
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void k10(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        ka0(fa0(this.f168623h), this.f169222s, r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l9(GalleryVO r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryVO");
        if (this.A == true) goto L5;
        return;
    L5:
        w0 r101 = this.f169226w;
        if (r101 == null) goto L9;
        r101.b(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.K != null) goto L14;
        dismiss();     // Catch: Exception -> L6
    L10:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L14;
        r101.finish();
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L22;
        com.bytedance.android.ec.core.utils.s0.c(this);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c r103 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.f169220J.getValue();
        r103.f169303a.put("triggerPdpEvent", new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.a(r103));
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == false) goto L18;
        r103.f169303a.put("PDPPlayerControl", new GalleryJsEventHandler$register$2(r103));
        r103.f169303a.put("PDPGalleryChangeVideoListFoldStatus", new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.b(r103));
    L18:
        Iterator r104 = ((LinkedHashMap) r103.f169303a).entrySet().iterator();
    L20:
        if (r104.hasNext() == false) goto L22;
        Map.Entry r105 = (Map.Entry) r104.next();
        ECLiveHybridUtil.m((String) r105.getKey(), (ti.j) r105.getValue());
    L22:
        cl.d.f24079a.getClass();
        cl.d r106 = cl.d.a.b();
        if (r106 == null) goto L29;
        r106.f();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L6;
        onPageSelected(this.f168623h, false);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void w5(Map<Integer, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryFindSameSchemaMap");
        List<? extends com.bytedance.android.ec.model.l> r101 = this.f168618p.f176135b;
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L21;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.ec.model.l r106 = (com.bytedance.android.ec.model.l) r104;
        if ((r106 instanceof g0) == true) goto L13;
        r106 = null;
    L13:
        g0 r107 = (g0) r106;
        if (r107 == null) goto L16;
        LinkedHashMap r108 = (LinkedHashMap) r100;
        r107.f47882k = (String) r108.get(Integer.valueOf(r103));
    L16:
        r103 = r105;
        goto L6
    L21:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void y5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "specId");
        if (this.A == true) goto L5;
        return;
    L5:
        q r101 = fa0(this.f168623h);
        if (r100.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        if (r101 == null) goto L20;
        String r103 = r101.f169365c;
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        int r105 = this.f168623h;
    L49:
        if (r105 >= 0) goto L51;
        return;
    L51:
        if (r105 == this.f168623h) goto L58;
        V90().scrollToPosition(r105);
        return;
    L58:
        return;
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
    L20:
        List<? extends com.bytedance.android.ec.model.l> r106 = this.f168618p.f176135b;
        if (r106 == null) goto L48;
        int r107 = r106.size();
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L48;
        Object r109 = ListProtector.get(r106, r108);
        String r110 = null;
        if ((r109 instanceof g0) == true) goto L27;
        r109 = null;
    L27:
        g0 r111 = (g0) r109;
        if (r111 == null) goto L33;
        q r112 = r111.f169311p;
        if (r112 == null) goto L33;
        r110 = r112.f169365c;
    L33:
        if (r100.length() != 0) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == false) goto L45;
        if (r110 != null) goto L39;
    L42:
        boolean r114 = true;
    L43:
        if (r114 == false) goto L45;
    L46:
        r105 = r108;
        goto L49
    L39:
        if (r110.length() == 0) goto L42;
        r114 = false;
    L45:
        if (Intrinsics.areEqual(r100, r110) == true) goto L46;
        r108 = r108 + 1;
        goto L23
    L35:
        r113 = false;
    L48:
        r105 = -1;
        goto L49
    L8:
        r102 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$2, java.lang.Object] */
    public GalleryFragment(i0 r100, Rect r101) {
        super(new GalleryCompatAdapter());
        this.K = r100;
        this.L = r101;
        GalleryFragment$viewModel$2 r102 = GalleryFragment$viewModel$2.INSTANCE;
        final Function0<Fragment> r103 = new FragmentViewModelLazyKt$viewModels$1(this);
        KClass r104 = Reflection.getOrCreateKotlinClass(GalleryViewModel.class);
        ?? r105 = new FragmentViewModelLazyKt$viewModels$2(r103);
        Intrinsics.checkNotNullParameter(this, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(r104, "viewModelClass");
        Intrinsics.checkNotNullParameter(r105, "storeProducer");
        Intrinsics.checkNotNullParameter(r102, "factoryProducer");
        this.f169221r = new com.bytedance.android.shopping.base.arch.viewmodel.a(r104, r105, r102);
        GalleryAdapter r106 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r107 = r100.o0();
    L6:
        if (r100 == null) goto L8;
        GalleryFromType r108 = r100.c();
    L9:
        m r109 = new m(r107, r108);
        GalleryAdapter r110 = this.f168618p;
        if ((r110 instanceof GalleryCompatAdapter) == true) goto L12;
        r110 = null;
    L12:
        GalleryCompatAdapter r111 = (GalleryCompatAdapter) r110;
        if (r111 == null) goto L15;
        r111.f169215h = r109;
    L15:
        Unit r112 = Unit.INSTANCE;
        this.f169222s = r109;
        this.f169223t = LazyKt.lazy(new GalleryFragment$tabIndicator$2(this));
        this.f169224u = -1;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L18;
        GalleryLayerItemStateManager r113 = null;
    L23:
        this.f169227x = r113;
        this.f169229z = new GalleryFragment$exitRectGetter$1(this);
        this.F = LazyKt.lazy(new GalleryFragment$pendantContainerComponent$2(this));
        this.G = new HashMap();
        this.f169220J = LazyKt.lazy(GalleryFragment$jsEventHandler$2.INSTANCE);
        GalleryAdapter r114 = this.f168618p;
        if ((r114 instanceof GalleryCompatAdapter) == false) goto L27;
        r106 = r114;
    L27:
        GalleryCompatAdapter r115 = (GalleryCompatAdapter) r106;
        if (r115 == null) goto L31;
        r115.f169214g = new a(this);
        return;
    L31:
        return;
    L18:
        if (r101 == null) goto L20;
        boolean r116 = true;
    L21:
        r113 = new GalleryLayerItemStateManager(r116, new GalleryFragment$layerStateManager$1(this));
        goto L23
    L20:
        r116 = false;
        goto L21
    L8:
        r108 = null;
        goto L9
    L5:
        r107 = null;
        goto L6
    }

    public static boolean da0(GallerySliceVisibilityConfig r100, int r101) {
        List<Integer> r102 = r100.getShow();
        if (r102 != null) goto L5;
    L7:
        List<Integer> r103 = r100.getHide();
        if (r103 != null) goto L10;
        return true;
    L10:
        if ((!r103.isEmpty()) == true) goto L12;
        return true;
    L12:
        if (r100.getHide().contains(Integer.valueOf(r101)) == false) goto L19;
        return false;
    L19:
        return true;
    L5:
        if ((!r102.isEmpty()) != true) goto L7;
        return r100.getShow().contains(Integer.valueOf(r101));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void U90(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        GalleryLayerItemStateManager r102 = this.f169227x;
        if (r102 == null) goto L34;
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r101 != 0) goto L30;
        int r103 = r100.getChildCount();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L13;
        View r105 = r100.getChildAt(r104);
        if (r105.getX() >= 0.0f) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        float r106 = r105.getX();
    L15:
        if (r106 != 0.0f) goto L35;
        r102.d(r100, r102.f169254i);
        if (r102.f169246a == false) goto L29;
        RecyclerView.ViewHolder r107 = r100.findViewHolderForAdapterPosition(r102.f169260o);
        Float r108 = null;
        if ((r107 instanceof PhotoVH) == true) goto L21;
        r107 = null;
    L21:
        PhotoVH r109 = (PhotoVH) r107;
        if (r109 == null) goto L27;
        TransitionPhotoDraweeView r110 = r109.f176147a;
        if (r110 == null) goto L27;
        r108 = Float.valueOf(r110.getScaleFactor());
    L27:
        if (Intrinsics.areEqual(r108, 1.0f) == false) goto L29;
        r102.g(1.0f);
    L29:
        r102.e(false);
        return;
    L35:
        return;
    L13:
        r106 = 0.0f;
        goto L15
    L30:
        r102.e(true);
        return;
    }

    public final void ca0(PendantContainerVO r210, i0 r211) {
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r100 = ha0();
        if (r100 == null) goto L5;
        r100.a(r210);
    L5:
        if (r210 == null) goto L83;
        List<String> r101 = r210.getComponentCacheKey();
        if (r101 == null) goto L99;
        List<String> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L9:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r105 = null;
        if (r104.hasNext() == false) goto L17;
        String r106 = (String) r104.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r107 = ha0();
        if (r107 == null) goto L16;
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r108 = r107.f166773a;
        if (r108 == null) goto L16;
        r105 = r108.get(r106);
    L16:
        r103.add(TuplesKt.to(r106, r105));
        goto L9
    L17:
        Iterator r109 = r103.iterator();
    L19:
        if (r109.hasNext() == false) goto L100;
        Pair r110 = (Pair) r109.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r111 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond();
        if (r111 == null) goto L65;
        View r112 = r111.f166766a;
        if (r112 == null) goto L65;
        Object r113 = r112.getTag();
        if ((r113 instanceof LynxElementVO) == true) goto L27;
        r113 = null;
    L27:
        LynxElementVO r114 = (LynxElementVO) r113;
        GalleryVO r115 = r211.s0();
        if (r115 == null) goto L36;
        GalleryPendants r116 = r115.getPendants();
        if (r116 == null) goto L36;
        GalleryConfig r117 = r116.getConfig();
        if (r117 == null) goto L36;
        Map<String, GallerySliceVisibilityConfig> r118 = r117.getVisibility();
        if (r118 == null) goto L36;
        GallerySliceVisibilityConfig r119 = r118.get(r110.getFirst());
    L37:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r120 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond();
        if (r120 == null) goto L42;
        String r121 = r120.f166768c;
        if (r121 == null) goto L42;
        this.G.put(r121, Boolean.TRUE);
    L42:
        GalleryLayerItemStateManager r122 = this.f169227x;
        if (r122 == null) goto L65;
        ShowDependsOn.a r123 = ShowDependsOn.Companion;
        if (r114 == null) goto L49;
        ConfigModel r124 = r114.getConfig();
        if (r124 == null) goto L49;
        String r125 = r124.getShowDependsOn();
    L50:
        r123.getClass();
        ShowDependsOn[] r126 = ShowDependsOn.values();
        int r127 = r126.length;
        int r128 = 0;
    L51:
        if (r128 >= r127) goto L56;
        ShowDependsOn r129 = r126[r128];
        if (Intrinsics.areEqual(r129.getValue(), r125) == true) goto L54;
        r128 = r128 + 1;
        goto L51
    L54:
        ShowDependsOn r130 = r129;
    L58:
        if (r130 != ShowDependsOn.GALLERY_FIND_SIMILAR) goto L60;
        boolean r131 = true;
    L61:
        if (r119 == null) goto L63;
        int r132 = r119.getAnimType();
    L64:
        r122.c(new c(r112, r112, new m0(true, true, r131, r132, false, 48), r110, this, r211));
        goto L65
    L63:
        r132 = 1;
        goto L64
    L60:
        r131 = false;
        goto L61
    L56:
        r130 = null;
    L49:
        r125 = null;
    L36:
        r119 = null;
    L65:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r133 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond();
        if (r133 == null) goto L68;
        State r134 = r133.f166769d;
    L69:
        if (r134 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r135 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond();
        if (r135 == null) goto L73;
        State r136 = r135.f166769d;
    L75:
        if (r136 == State.NORMAL) goto L19;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r137 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond();
        if (r137 == null) goto L79;
        State r138 = r137.f166769d;
    L81:
        if (r138 == State.SHOW) goto L19;
        la0((String) r110.getFirst(), (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r110.getSecond());
        goto L19
    L79:
        r138 = null;
        goto L81
    L73:
        r136 = null;
        goto L75
    L68:
        r134 = null;
        goto L69
    L100:
        return;
    L99:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l0(int r100, String r110) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (r100 >= 0) goto L63;
        if (r110 != null) goto L10;
    L13:
        boolean r101 = true;
    L14:
        int r102 = -1;
        String r103 = null;
        if (r101 == false) goto L44;
        List<? extends com.bytedance.android.ec.model.l> r104 = this.f168618p.f176135b;
        if (r104 == null) goto L41;
        int r111 = r104.size();
        int r105 = 0;
    L19:
        if (r105 >= r111) goto L41;
        com.bytedance.android.ec.model.l r106 = (com.bytedance.android.ec.model.l) ListProtector.get(r104, r105);
        if (r106.getType() == 2) goto L40;
        if (r106.getType() == 8) goto L40;
        if ((r106 instanceof g0) == true) goto L27;
        r106 = null;
    L27:
        g0 r107 = (g0) r106;
        if (r107 == null) goto L32;
        q r108 = r107.f169311p;
        if (r108 == null) goto L32;
        r103 = r108.f169365c;
    L32:
        if (r103 != null) goto L34;
    L37:
        boolean r109 = true;
    L38:
        if (r109 == false) goto L41;
        r102 = r105;
        goto L41
    L34:
        if (r103.length() == 0) goto L37;
        r109 = false;
    L40:
        r105 = r105 + 1;
    L41:
        if (r102 >= 0) goto L43;
        r100 = 0;
        goto L63
    L43:
        r100 = r102;
        goto L63
    L44:
        List<? extends com.bytedance.android.ec.model.l> r112 = this.f168618p.f176135b;
        if (r112 == null) goto L62;
        Iterator<? extends com.bytedance.android.ec.model.l> r113 = r112.iterator();
        int r114 = 0;
    L48:
        if (r113.hasNext() == false) goto L62;
        com.bytedance.android.ec.model.l r115 = r113.next();
        if ((r115 instanceof g0) == true) goto L52;
        r115 = null;
    L52:
        g0 r116 = (g0) r115;
        if (r116 == null) goto L57;
        q r117 = r116.f169311p;
        if (r117 == null) goto L57;
        String r118 = r117.f169365c;
    L59:
        if (Intrinsics.areEqual(r118, r110) == true) goto L60;
        r114 = r114 + 1;
        goto L48
    L60:
        r100 = r114;
    L57:
        r118 = null;
    L62:
        r100 = -1;
        goto L63
    L10:
        if (r110.length() == 0) goto L13;
        r101 = false;
    L63:
        if (r100 >= 0) goto L65;
        return;
    L65:
        int r119 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, 0), this.f168618p.getItemCount() - 1);
        if (r119 < 0) goto L75;
        V90().scrollToPosition(r119);
        return;
    }

    public final void la0(String r100, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r101) {
        i0 r102 = this.K;
        String r103 = null;
        if (r102 == null) goto L13;
        GalleryVO r104 = r102.s0();
        if (r104 == null) goto L13;
        GalleryPendants r105 = r104.getPendants();
        if (r105 == null) goto L13;
        GalleryConfig r106 = r105.getConfig();
        if (r106 == null) goto L13;
        Map<String, GallerySliceVisibilityConfig> r107 = r106.getVisibility();
        if (r107 == null) goto L13;
        GallerySliceVisibilityConfig r108 = r107.get(r100);
    L14:
        if (r108 == null) goto L16;
        boolean r109 = da0(r108, this.f168623h);
    L17:
        if (r101 != null) goto L19;
        return;
    L19:
        if (r101.f166770e == r109) goto L46;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r110 = ha0();
        if (r110 == null) goto L27;
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r111 = r110.f166773a;
        if (r111 == null) goto L27;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r112 = r111.get(r100);
        if (r112 == null) goto L27;
        r112.f166770e = r109;
    L27:
        String r113 = r101.f166768c;
        String r114 = "1";
        if (r113 == null) goto L33;
        if (r109 == false) goto L33;
        if (Intrinsics.areEqual(this.G.get(r113), Boolean.TRUE) == false) goto L33;
        this.G.put(r113, Boolean.FALSE);
        Object r115 = "1";
    L34:
        ti.l r116 = r101.f166767b;
        if (r116 == null) goto L47;
        JSONObject r117 = new JSONObject();
        i0 r118 = this.K;
        if (r118 == null) goto L39;
        r103 = r118.getSessionId();
    L39:
        KtSafeMethodExtensionKt.safePut(r117, "session_id", r103);
        if (r109 == true) goto L43;
        r114 = "0";
    L43:
        KtSafeMethodExtensionKt.safePut(r117, "visible", r114);
        KtSafeMethodExtensionKt.safePut(r117, "first_show", r115);
        KtSafeMethodExtensionKt.safePut(r117, "component_name", r101.f166768c);
        Unit r119 = Unit.INSTANCE;
        r116.sendJsEvent("pdp_gallery_lynx_pendant_visible_status", r117);
        return;
    L47:
        return;
    L33:
        r115 = "0";
        goto L34
    L46:
        return;
    L16:
        r109 = false;
    L13:
        r108 = null;
        goto L14
    }

    public final void ma0(List<q> r100, List<c0> r101) {
        Intrinsics.checkNotNullParameter(r100, "galleryList");
        Intrinsics.checkNotNullParameter(r101, "groupList");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L41;
        q r104 = (q) r103.next();
        N.getClass();
        Integer r105 = b.a(r104);
        if (r105 == null) goto L4;
        int r106 = r105.intValue();
        g0 r107 = new g0();
        r107.f47872a = r106;
        ECUrlModel r108 = r104.f169363a;
        Integer r109 = null;
        if (r108 == null) goto L10;
        String r110 = r108.getFirstUrl();
    L11:
        r107.f47873b = r110;
        ECUrlModel r111 = r104.f169363a;
        if (r111 == null) goto L14;
        Integer r112 = Integer.valueOf(r111.getWidth());
    L15:
        r107.f47878g = r112;
        ECUrlModel r113 = r104.f169363a;
        if (r113 == null) goto L18;
        Integer r114 = Integer.valueOf(r113.getHeight());
    L19:
        r107.f47879h = r114;
        r107.f47883l = r104.f169369g;
        r107.f47884m = r104.f169364b;
        r107.f47882k = r104.f169367e;
        if (r106 != 2) goto L40;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r115 = r104.f169366d;
        if (r115 == null) goto L24;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r116 = r115.getPlayInfo();
    L25:
        if (r116 == null) goto L27;
        String r117 = r116.e();
    L28:
        r107.f47873b = r117;
        if (r116 == null) goto L31;
        String r118 = r116.f();
    L32:
        r107.f47877f = r118;
        if (r116 == null) goto L35;
        Integer r119 = r116.l();
    L36:
        r107.f47878g = r119;
        if (r116 == null) goto L39;
        r109 = r116.c();
    L39:
        r107.f47879h = r109;
        goto L40
    L35:
        r119 = null;
        goto L36
    L31:
        r118 = null;
        goto L32
    L27:
        r117 = null;
        goto L28
    L24:
        r116 = null;
    L40:
        r107.f169311p = r104;
        r107.f169310o = r104.f169366d;
        r107.f169312q = r104.f169371i;
        r102.add(r107);
        goto L4
    L18:
        r114 = null;
        goto L19
    L14:
        r112 = null;
        goto L15
    L10:
        r110 = null;
        goto L11
    L41:
        this.f168618p.f176135b = r102;
        ia0().setData(r101);
        this.D = r101;
        this.C = r102;
        Iterator r120 = r102.iterator();
        int r121 = 0;
    L43:
        if (r120.hasNext() == false) goto L51;
        if (((com.bytedance.android.ec.model.k) r120.next()).getType() != 7) goto L47;
        boolean r122 = true;
    L48:
        if (r122 == true) goto L52;
        r121 = r121 + 1;
    L52:
        this.f169224u = r121;
        this.f168618p.f176134a = 1;
        return;
    L47:
        r122 = false;
        goto L48
    L51:
        r121 = -1;
        goto L52
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onPageSelected(final int r110, boolean r111) {
        ia0().onPageSelected(r110);
        LinearLayout r100 = this.f169228y;
        if ((r100 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) == true) goto L5;
        LinearLayout r101 = null;
    L6:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r102 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) r101;
        final boolean r103 = false;
        if (r102 == null) goto L12;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f r104 = r102.f169501w;
        String r105 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.f169478y;
        if (r104.wW(r105, Integer.valueOf(r110)) == false) goto L21;
        r102.f169501w.Bt(r105);
    L21:
        if (this.f169224u < 0) goto L34;
        List<? extends com.bytedance.android.ec.model.l> r106 = this.f168618p.f176135b;
        if (r106 == null) goto L25;
        int r107 = r106.size();
    L26:
        int r108 = this.f169224u;
        if (r108 != (-1)) goto L29;
        int r109 = r107;
    L30:
        if (r110 >= r108) goto L32;
        Pair r112 = new Pair(Integer.valueOf(r110), Integer.valueOf(r109));
    L33:
        aa0().setCurrentPos(((Number) r112.getFirst()).intValue());
        aa0().setCount(((Number) r112.getSecond()).intValue());
        goto L34
    L32:
        r112 = new Pair(Integer.valueOf(r110 - r108), Integer.valueOf(r107 - r109));
        goto L33
    L29:
        r109 = r108;
        goto L30
    L25:
        r107 = 0;
    L34:
        q r113 = fa0(r110);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L43;
        IndexIndicator r114 = aa0();
        r114.getClass();
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, -2);
        r114.setPadding(vf4.a.b(5), 0, vf4.a.b(5), 0);
        r115.rightMargin = vf4.a.b(16);
        r115.bottomMargin = vf4.a.b(62);
        r115.gravity = 85;
        Unit r116 = Unit.INSTANCE;
        r114.setLayoutParams(r115);
        IndexIndicator r117 = aa0();
        g0 r118 = ga0(r110);
        if (r118 == null) goto L41;
        int r119 = 8;
        if (r118.getType() != 8) goto L41;
    L42:
        r117.setVisibility(r119);
    L41:
        r119 = 0;
    L43:
        final GalleryLayerItemStateManager r120 = this.f169227x;
        if (r120 == null) goto L64;
        r120.f169260o = r110;
        if (r120.f169261p == false) goto L64;
        if (r120.f169258m <= 0) goto L62;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b> r121 = r120.f169254i;
        final ArrayList r122 = new ArrayList();
        Iterator r123 = ((ArrayList) r121).iterator();
    L51:
        if (r123.hasNext() == false) goto L59;
        Object r124 = r123.next();
        if (((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b) r124).f169278b.f169345d != 1) goto L55;
        boolean r125 = true;
    L56:
        if (r125 == false) goto L51;
        r122.add(r124);
        goto L51
    L55:
        r125 = false;
        goto L56
    L59:
        if ((!r122.isEmpty()) == false) goto L62;
        r120.f169252g = GalleryLayerItemStateManager.i(r120, r120.f169252g, 0.0f, 0.0f, false, new GalleryLayerItemStateManager$updateAlphaOnScroll$$inlined$also$lambda$1(r122, r120, r103, r110), 6);
    L62:
        if (r120.f169263r.invoke().getScrollState() != 0) goto L64;
        r120.j(r120.f169254i);
    L64:
        w0 r126 = this.f169226w;
        String r127 = "";
        if (r126 == null) goto L72;
        if (r113 == null) goto L68;
        String r128 = r113.f169365c;
    L69:
        if (r128 != null) goto L71;
        r128 = "";
    L71:
        r126.c(r128);
        goto L72
    L68:
        r128 = null;
    L72:
        Integer r129 = this.f169225v;
        if (r129 != null) goto L75;
    L76:
        if (r111 == false) goto L94;
    L77:
        i0 r130 = this.K;
        if (r130 == null) goto L80;
        r130.e(r110, r113, false);
    L80:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r131 = this.B;
        if (r131 == null) goto L94;
        m r132 = r131.f169329g;
        if (r132 == null) goto L94;
        if (r113 == null) goto L88;
        c0 r133 = r113.f169375m;
        if (r133 == null) goto L88;
        String r134 = r133.f169288d;
    L89:
        Pair[] r135 = new Pair[3];
        r135[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ITEM_ORDER, Integer.valueOf(r110 + 1));
        r135[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE);
        if (r134 == null) goto L93;
        r127 = r134;
    L93:
        r135[2] = TuplesKt.to("type", r127);
        m.d(r132, "slide_product_big_picture", MapsKt.mutableMapOf(r135), null, null, 60);
    L88:
        r134 = null;
    L94:
        this.f169225v = Integer.valueOf(r110);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r136 = this.B;
        if (r136 == null) goto L144;
        r136.f169328f.setSelectedPosition(r110);
        List<c0> r137 = r136.f169325c;
        if (r137 != null) goto L100;
        r137 = CollectionsKt.emptyList();
    L100:
        if (r137.isEmpty() == false) goto L102;
        c0 r138 = null;
    L110:
        if (r138 == null) goto L144;
        GalleryViewModel r139 = r136.f169328f;
        Integer r140 = Integer.valueOf(r138.f169285a);
        int r141 = r138.f169285a;
        int r142 = r138.f169286b + r141;
        List<s> r143 = r136.f169328f.getFullThumbList().getValue();
        if (r143 != null) goto L114;
        r143 = CollectionsKt.emptyList();
    L114:
        ArrayList r144 = new ArrayList();
        boolean r145 = false;
        boolean r146 = false;
    L115:
        if (r141 >= r142) goto L123;
        s r147 = (s) CollectionsKt.getOrNull(r143, r141);
        if (r147 == null) goto L122;
        r144.add(r147);
        if (r147.f169389d == false) goto L121;
        r145 = true;
        goto L122
    L121:
        r146 = true;
    L122:
        r141 = r141 + 1;
        goto L115
    L123:
        if (r145 == false) goto L126;
        if (r146 == false) goto L126;
        boolean r148 = true;
    L127:
        Iterator r149 = r144.iterator();
    L129:
        if (r149.hasNext() == false) goto L142;
        s r150 = (s) r149.next();
        if (r148 == true) goto L133;
    L140:
        String r151 = r150.f169390e;
    L141:
        r150.getClass();
        Intrinsics.checkNotNullParameter(r151, "<set-?>");
        r150.f169386a = r151;
        goto L129
    L133:
        if (r150.f169389d == false) goto L140;
        if (r150.f169390e.length() != 0) goto L137;
        boolean r152 = true;
    L138:
        if (r152 == false) goto L140;
        r151 = "视频";
        goto L141
    L137:
        r152 = false;
        goto L138
    L142:
        r139.setThumbList(r140, r144);
    L126:
        r148 = false;
        goto L127
    L102:
        Iterator<T> r153 = r137.iterator();
    L104:
        if (r153.hasNext() == false) goto L108;
        Object r154 = r153.next();
        if (f0.b(r110, (c0) r154) == false) goto L104;
    L109:
        r138 = (c0) r154;
        goto L110
    L108:
        r154 = null;
    L144:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.c() == false) goto L165;
        Iterator<T> r155 = com.bytedance.commerce.base.view.b.a(V90()).iterator();
    L147:
        if (r155.hasNext() == false) goto L154;
        Object r156 = V90().findContainingViewHolder((View) r155.next());
        if ((r156 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L151;
        r156 = null;
    L151:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r157 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r156;
        if (r157 == null) goto L147;
        r157.onPageSelected(r110);
        goto L147
    L154:
        g0 r158 = ga0(r110);
        if (r158 == null) goto L165;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r159 = r158.f169310o;
        if (r159 == null) goto L165;
        if (r159.getPlayInfo() == null) goto L165;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r160 = this.B;
        if (r160 == null) goto L165;
        m r161 = r160.f169329g;
        if (r161 == null) goto L165;
        m.d(r161, "pd_video_show", r161.b(r110), String.valueOf(r110), null, 36);
    L165:
        if (r111 == true) goto L174;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r162 = ha0();
        if (r162 == null) goto L196;
        ConcurrentHashMap<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r163 = r162.f166773a;
        if (r163 == null) goto L197;
        Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r164 = r163.entrySet().iterator();
    L172:
        if (r164.hasNext() == false) goto L198;
        Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c> r165 = r164.next();
        la0(r165.getKey(), r165.getValue());
        goto L172
    L198:
        return;
    L197:
        return;
    L196:
        return;
    L174:
        return;
    L75:
        if (r129.intValue() != r110) goto L77;
    L12:
        if ((r100 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c) == true) goto L14;
        r100 = null;
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c r166 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c) r100;
        if (r166 == null) goto L21;
        if (r166.f169475d.wW("bottom_left_find_same", Integer.valueOf(r110)) == false) goto L19;
        r166.setVisibility(0);
        r166.f169475d.Bt("bottom_left_find_same");
        goto L21
    L19:
        ExtensionsKt.gone(r166);
        goto L21
    L5:
        r101 = r100;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        this.A = true;
        GalleryLayerItemStateManager r100 = this.f169227x;
        if (r100 == null) goto L5;
        GalleryViewModel r101 = ja0();
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        r100.f169249d = r101;
    L5:
        FragmentActivity r102 = getActivity();
        GalleryAdapter r103 = null;
        if ((r102 instanceof FullScreenGalleryDialogActivity) == true) goto L8;
        r102 = null;
    L8:
        FullScreenGalleryDialogActivity r104 = (FullScreenGalleryDialogActivity) r102;
        if (r104 == null) goto L11;
        GalleryViewerParams r105 = r104.f166175k;
    L12:
        int r106 = 0;
        if (r105 != null) goto L15;
    L22:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r107 = this.B;
        if (r107 == null) goto L51;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a == false) goto L51;
        final t r110 = new t(r107, W90(), new GalleryFragment$onViewCreated$$inlined$also$lambda$1(this));
        RecyclerView r108 = V90();
        Intrinsics.checkNotNullParameter(r108, "pager");
        List<s> r111 = r110.f169396d.f169328f.getThumbList().getValue();
        if (r111 != null) goto L29;
        r111 = CollectionsKt.emptyList();
    L29:
        final List<s> r112 = r110.f(r111);
        FrameLayout r113 = r110.f169397e;
        final EdgeGradientFrameLayout r114 = new EdgeGradientFrameLayout(r110.f169397e.getContext(), null, 6, 0);
        r110.f169393a = r114;
        if (((ArrayList) r112).isEmpty() == false) goto L32;
        r114.setVisibility(8);
    L32:
        r114.setPadding(0, com.bytedance.android.shopping.extensions.b.a(2), 0, com.bytedance.android.shopping.extensions.b.a(12));
        final RecyclerView r109 = new RecyclerView(r114.getContext());
        r110.f169394b = r109;
        r109.setOverScrollMode(2);
        r109.setLayoutManager(new LinearLayoutManager(r114.getContext(), 0, false));
        r109.setAdapter(new p0(r112, r110.f169396d, new GalleryMoreVideoManager$setupMoreVideoView$$inlined$also$lambda$1(r109, r114, r110, r112)));
        Unit r115 = Unit.INSTANCE;
        r114.addView(r109, new ViewGroup.LayoutParams(-1, -2));
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-1, -2);
        r116.gravity = 80;
        r116.leftMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r116.rightMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r113.addView(r114, r116);
        EdgeGradientFrameLayout r117 = r110.f169393a;
        if (r117 == null) goto L35;
        r117.addOnLayoutChangeListener(new z(r110));
    L35:
        RecyclerView r118 = r110.f169394b;
        if (r118 == null) goto L38;
        r118.addOnScrollListener(new GalleryMoreVideoManager$setupMoreVideoView$4(r110));
    L38:
        RecyclerView r119 = r110.f169394b;
        if (r119 == null) goto L41;
        r119.post(new a0(r110));
    L41:
        RecyclerView r120 = r110.f169394b;
        if (r120 == null) goto L44;
        r120.setVisibility(4);
    L44:
        r110.f169396d.f169328f.isMoreVideoExpanded().observe(r110.f169396d.f169327e, new v(r110));
        r110.f169396d.f169328f.getBottomBarHeight().observe(r110.f169396d.f169327e, new w(r110));
        r110.f169396d.f169328f.getSelectedPosition().observe(r110.f169396d.f169327e, new x(r110));
        r110.f169396d.f169328f.getThumbList().observe(r110.f169396d.f169327e, new y(r110));
        EdgeGradientFrameLayout r121 = r110.f169393a;
        if (r121 == null) goto L49;
        GalleryLayerItemStateManager r122 = r110.f169396d.f169331i;
        if (r122 == null) goto L49;
        r122.c(new u(r121, new m0(true, true, false, 0, false, 52), r110));
    L49:
        r108.addOnScrollListener(new GalleryMoreVideoManager$watchPagerScroll$1(r110));
    L51:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L53;
    L161:
        m r123 = this.f169222s;
        r123.getClass();
        r123.f169337c = Long.valueOf(System.currentTimeMillis());
        m.d(r123, "pdp_big_picture_show", null, null, "a1.b34986.c0.d0", 30);
        GalleryAdapter r124 = this.f168618p;
        if ((r124 instanceof GalleryCompatAdapter) == false) goto L165;
        r103 = r124;
    L165:
        GalleryCompatAdapter r125 = (GalleryCompatAdapter) r103;
        if (r125 == null) goto L169;
        r125.f176138e = this;
    L169:
        if (this.L == null) goto L171;
        ja0().getEnterAnimStatus().observe(getViewLifecycleOwner(), new j(this));
    L172:
        Context r126 = r210.getContext();
        i0 r127 = this.K;
        if (r127 == null) goto L186;
        GalleryVO r128 = r127.s0();
        if (r128 == null) goto L187;
        GalleryConfig r129 = r128.getConfig();
        if (r129 != null) goto L179;
        return;
    L179:
        if (r129.getEnableScreenShot() != true) goto L189;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r130 = this.B;
        if (r130 != null) goto L183;
        return;
    L183:
        if (r130.a() != true) goto L191;
        this.I = new ScreenCaptureManager(r126, this.K.p0(), PageFinder.via(this), new o(this));
        return;
    L191:
        return;
    L189:
        return;
    L187:
        return;
    L186:
        return;
    L171:
        onPageSelected(this.f168623h, false);
        goto L172
    L53:
        if (this.K == null) goto L161;
        final w0 r131 = new w0(requireActivity(), this.f169227x, this.B, new k(this));
        this.f169226w = r131;
        final v0 r132 = r131.f169449a;
        r132.getClass();
        SlcGeckoTemplateMgr r133 = SlcGeckoTemplateMgr.f51232l;
        FragmentActivity r134 = r132.f169412f;
        r133.getClass();
        r132.f169408b = SlcGeckoTemplateMgr.e(r134, "pdp");
        FragmentActivity r135 = r132.f169412f;
        com.bytedance.android.ecom.arch.slice.adapter.e r136 = new com.bytedance.android.ecom.arch.slice.adapter.e(1000);
        SlcExprContext r137 = new SlcExprContext(r106);
        FragmentActivity r138 = r132.f169412f;
        ActionContext r139 = new ActionContext(r138, r138.getSupportFragmentManager(), r132.f169410d);
        ActionContext r140 = r132.f169414h;
        if (r140 == null) goto L57;
        Intrinsics.checkNotNullParameter(r140, "from");
        r139.f49966a.putAll(r140.f49966a);
    L57:
        Unit r141 = Unit.INSTANCE;
        SlcContext r142 = new SlcContext(r135, r139, r136, r137, new com.bytedance.android.ecom.arch.slice.a(), new com.bytedance.android.shopping.anchorv4.voavhs.i(null));
        r142.f50196v = 0;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r143 = r132.f169408b;
        if (r143 == null) goto L60;
        r142.f49954o0 = r143;
    L61:
        r132.f169407a = r142;
        final com.bytedance.android.ecom.arch.slice.action.j r144 = r132.f169409c;
        if (r144 == null) goto L66;
        PageFinder r145 = PageFinder.via(r132);
        if (r145 == null) goto L66;
        FragmentActivity r146 = r132.f169412f;
        EventChain r147 = qg3.a.a(r146, "gallery_fragment", new com.bytedance.android.shopping.anchorv4.event_chain.a(r146, r144, r145, r132.f169411e), new com.bytedance.kmp.ec.yata.common.init.c());
        r132.f169409c.b(r147, r144, r132.f169412f);
        r147.g(new com.bytedance.android.shopping.anchorv4.event_chain.custom_event.l(r144, r132.f169412f, null, new SliceEnv$initEventChain$$inlined$apply$lambda$1(r132, r144)));
        r147.g(new id3.a(r144, r132.f169412f, new SliceEnv$initEventChain$$inlined$apply$lambda$2(r132, r144)));
    L68:
        if (r147 != null) goto L70;
        boolean r148 = false;
    L82:
        if (r148 == false) goto L92;
        SlcContext r149 = r131.f169449a.f169407a;
        if (r149 == null) goto L88;
        com.bytedance.android.ecom.arch.slice.d r150 = r149.f49961v0;
        if (r150 == null) goto L88;
        r150.G("gallery", new SliceViewManager$init$1(r131));
    L88:
        SlcContext r151 = r131.f169449a.f169407a;
        if (r151 == null) goto L92;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r152 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c(r131.f169455g, r151);
        r152.f169281a.addOnLayoutChangeListener(new y0(r131));
        r131.f169450b = r152;
        r131.f169452d = new t0(r131.f169455g, r151, new SliceViewManager$init$$inlined$let$lambda$2(r131));
    L92:
        if (r148 == true) goto L96;
        FragmentActivity r153 = getActivity();
        if (r153 == null) goto L96;
        r153.finish();
    L96:
        w0 r154 = this.f169226w;
        if (r154 == null) goto L104;
        FrameLayout r155 = W90();
        Intrinsics.checkNotNullParameter(r155, "rootView");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r156 = r154.f169450b;
        if (r156 == null) goto L101;
        LinearLayout r157 = r156.f169281a;
        FrameLayout.LayoutParams r158 = new FrameLayout.LayoutParams(-1, -2);
        r158.gravity = 80;
        r155.addView(r157, r158);
    L101:
        t0 r159 = r154.f169452d;
        if (r159 == null) goto L104;
        r155.addView(r159.f169401a, new FrameLayout.LayoutParams(-1, -1));
    L104:
        w0 r160 = this.f169226w;
        if (r160 == null) goto L107;
        r160.b(this.K.s0());
    L107:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c r161 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.f169220J.getValue();
        w0 r162 = this.f169226w;
        if (r162 == null) goto L110;
        SlcContext r163 = r162.f169449a.f169407a;
    L111:
        r161.f169304b = r163;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == false) goto L114;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.f169220J.getValue()).f169305c = new h(this);
    L114:
        i0 r164 = this.K;
        GalleryVO r165 = r164.s0();
        if (r165 == null) goto L123;
        GalleryPendants r166 = r165.getPendants();
        if (r166 == null) goto L123;
        PendantContainer r167 = r166.getLynxs();
        if (r167 == null) goto L123;
        PendantContainerVO.Companion.getClass();
        Pair r168 = PendantContainerVO.Companion.b(PendantContainerVO.Companion.c(r167));
        if (r168 == null) goto L123;
        PendantContainerVO r169 = (PendantContainerVO) r168.component1();
        this.H = (PendantContainerVO) r168.component2();
        ca0(r169, r164);
    L123:
        ja0().getPendantContainerState().observe(getViewLifecycleOwner(), new l(this));
        int r170 = f0.f169307a;
        int r171 = pi3.a.f529323a;
        long r172 = com.bytedance.android.ec.sdk.helper.q.f48131a.getLong("anchor_v4_find_similar_button_last_show_time", -1);
        long r173 = System.currentTimeMillis() / ((long) 1000);
        if (r172 > 0) goto L126;
    L128:
        boolean r174 = true;
    L129:
        if (r174 == false) goto L134;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r175 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d(requireActivity(), this);
        FrameLayout r176 = W90();
        FrameLayout.LayoutParams r177 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.f169477x);
        r177.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r176.addView(r175, r177);
        GalleryLayerItemStateManager r178 = this.f169227x;
        if (r178 == null) goto L133;
        r178.c(r175.getLayerItem());
    L133:
        r175.setOnClickListener(new f(this));
        this.f169228y = r175;
    L138:
        IndexIndicator r179 = aa0();
        r179.setTextColor(1946157055);
        ViewGroup.LayoutParams r180 = r179.getLayoutParams();
        if ((r180 instanceof FrameLayout.LayoutParams) == true) goto L141;
        r180 = null;
    L141:
        FrameLayout.LayoutParams r181 = (FrameLayout.LayoutParams) r180;
        if (r181 == null) goto L148;
        r181.gravity = 8388661;
        int r182 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.m.f169521n;
        b r183 = N;
        Context r184 = r179.getContext();
        r183.getClass();
        Intrinsics.checkNotNullParameter(r184, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r185 = M;
        if (r185 == null) goto L146;
        int r186 = r185.intValue();
    L147:
        r181.topMargin = (r182 + r186) + com.bytedance.android.shopping.extensions.b.a(20);
        r181.rightMargin = com.bytedance.android.shopping.extensions.b.a(20);
        r179.setLayoutParams(r181);
        goto L148
    L146:
        r186 = eh.b.b(r184);
        M = Integer.valueOf(r186);
    L148:
        aa0().setDisableUpdateVisibilityInternal(true);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r187 = this.B;
        if (r187 != null) goto L151;
    L153:
        GalleryLayerItemStateManager r188 = this.f169227x;
        if (r188 == null) goto L156;
        r188.c(new i(this, aa0(), new m0(true, true, false, 1, false, 52)));
    L156:
        View r189 = ia0().b();
        if (r189 == null) goto L161;
        GalleryLayerItemStateManager r190 = this.f169227x;
        if (r190 == null) goto L161;
        r190.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r189, false, false, false, 16));
        goto L161
    L151:
        if (r187.b() != true) goto L153;
        aa0().setVisibility(8);
        goto L156
    L134:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c r191 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c(requireActivity(), this);
        FrameLayout r192 = W90();
        FrameLayout.LayoutParams r193 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c.f169471e);
        r193.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r192.addView(r191, r193);
        GalleryLayerItemStateManager r194 = this.f169227x;
        if (r194 == null) goto L137;
        r194.c(r191.getLayerItem());
    L137:
        r191.setOnClickListener(new g(this));
        ja0().setShowDependsState(ShowDependsOn.GALLERY_FIND_SIMILAR, State.SHOW);
        this.f169228y = r191;
        goto L138
    L126:
        if ((r173 - r172) >= 86400) goto L128;
        r174 = false;
        goto L129
    L110:
        r163 = null;
        goto L111
    L70:
        SlcContext r195 = r132.f169407a;
        if (r195 == null) goto L73;
        r195.o("eventChain", r147);
    L73:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r196 = r132.f169415i;
        if (r196 == null) goto L76;
        r196.f169334l = r147;
    L76:
        SlcContext r197 = r132.f169407a;
        if (r197 == null) goto L81;
        ActionContext r198 = r197.f49957r0;
        if (r198 == null) goto L81;
        u0 r199 = new u0(r132);
        Intrinsics.checkNotNullParameter(r199, "interceptor");
        r198.f49969d = r199;
    L81:
        r148 = true;
    L66:
        r147 = null;
        goto L68
    L60:
        r142.v(true);
        goto L61
    L15:
        if (r105.getGalleryIndex() < this.f168628m.getItemCount()) goto L17;
        int r200 = 0;
    L18:
        Z90(r200);
        V90().scrollToPosition(r105.getGalleryIndex());
        Rect r201 = this.L;
        if (r201 == null) goto L21;
        this.f168628m.setEnterAnimationParams(r105.getGalleryIndex(), r201);
    L21:
        this.f168628m.setOptEnterTransition(true);
        goto L22
    L17:
        r200 = r105.getGalleryIndex();
        goto L18
    L11:
        r105 = null;
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final boolean wW(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        i0 r102 = this.K;
        if (r102 == null) goto L11;
        GalleryVO r103 = r102.s0();
        if (r103 == null) goto L11;
        GalleryConfig r104 = r103.getConfig();
        if (r104 == null) goto L11;
        Map<String, GallerySliceVisibilityConfig> r105 = r104.getVisibility();
        if (r105 == null) goto L11;
        GallerySliceVisibilityConfig r106 = r105.get(r100);
    L13:
        if (r106 == null) goto L30;
        if (r101 == null) goto L16;
        int r107 = r101.intValue();
    L17:
        List<Integer> r108 = r106.getShow();
        if (r108 != null) goto L20;
    L22:
        List<Integer> r109 = r106.getHide();
        if (r109 != null) goto L25;
        return false;
    L25:
        if ((!r109.isEmpty()) == true) goto L27;
        return false;
    L27:
        if (r106.getHide().contains(Integer.valueOf(r107)) == true) goto L34;
        return true;
    L34:
        return false;
    L20:
        if ((!r108.isEmpty()) != true) goto L22;
        return r106.getShow().contains(Integer.valueOf(r107));
    L16:
        r107 = this.f168623h;
        goto L17
    L30:
        return false;
    L11:
        r106 = null;
        goto L13
    }

    public final void ka0(q r100, m r101, String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8094.c86220.d94403", PageFinder.via(this), null, 4, null);
        ECUrlModel r103 = r100.f169363a;
        String r104 = null;
        if (r103 == null) goto L9;
        List<String> r105 = r103.getUrlList();
        if (r105 == null) goto L9;
        String r106 = (String) CollectionsKt.firstOrNull(r105);
    L10:
        String r107 = r100.f169367e;
        int r108 = 1;
        if (r107 != null) goto L41;
        i0 r109 = this.K;
        if (r109 == null) goto L39;
        GalleryVO r111 = r109.s0();
        if (r111 == null) goto L39;
        com.bytedance.android.shopping.anchorv4.dto.business.b r112 = r111.getMeta();
        if (r112 == null) goto L39;
        r107 = r112.a();
        if (r107 == null) goto L39;
        if (r100.f169371i == null) goto L24;
    L26:
        boolean r113 = false;
    L27:
        if (r113 != true) goto L31;
        ECUrlModel r114 = r100.f169363a;
        if (r114 == null) goto L36;
        String r115 = r114.getFirstUrl();
    L37:
        if (r115 == null) goto L41;
        r107 = com.bytedance.android.ec.core.utils.p0.d(r107, "search_image_url", r115);
    L36:
        r115 = null;
        goto L37
    L31:
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r116 = r100.f169366d;
        if (r116 == null) goto L36;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r117 = r116.getPlayInfo();
        if (r117 == null) goto L36;
        r115 = r117.f();
        goto L37
    L24:
        if (r100.f169366d != null) goto L26;
        r113 = true;
    L39:
        r107 = null;
    L41:
        if (com.bytedance.android.shopping.extensions.k.c(r100.f169364b) == false) goto L44;
        r108 = 2;
    L44:
        if (r100.f169366d == null) goto L46;
        String r118 = "video";
    L48:
        if (Intrinsics.areEqual(r110, "top_right_find_same") == false) goto L52;
        String r119 = "1";
    L50:
        r104 = r119;
    L54:
        Activity r120 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r120 != null) goto L57;
        return;
    L57:
        if (we.a.f559330a == false) goto L63;
        if (r107 == null) goto L70;
        Uri.Builder r121 = UriProtector.parse(r107).buildUpon();
        r121.appendQueryParameter(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
        com.bytedance.android.ec.sdk.helper.p.f48130a.d(com.bytedance.android.ec.core.btm.c.d(r121.build().toString(), r102), r120);
        if (r101 == null) goto L71;
        r101.c(r108, r118, r104);
        return;
    L71:
        return;
    L70:
        return;
    L63:
        if (r106 == null) goto L65;
        com.bytedance.android.ec.sdk.helper.h.f48123a.a(r120, r106, new n(r101));
        return;
    L65:
        if (r107 == null) goto L74;
        Uri.Builder r122 = UriProtector.parse(r107).buildUpon();
        r122.appendQueryParameter(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
        com.bytedance.android.ec.sdk.helper.p.f48130a.d(com.bytedance.android.ec.core.btm.c.d(r122.build().toString(), r102), r120);
        if (r101 == null) goto L75;
        r101.c(r108, r118, r104);
        return;
    L75:
        return;
    L74:
        return;
    L52:
        if (Intrinsics.areEqual(r110, "bottom_left_find_same") == false) goto L54;
        r119 = "2";
        goto L50
    L46:
        r118 = "image";
    L9:
        r106 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.L == null) goto L6;
        this.f168624i = true;
    L6:
        return super.onCreateView(r100, r101, r102);
    }
}
