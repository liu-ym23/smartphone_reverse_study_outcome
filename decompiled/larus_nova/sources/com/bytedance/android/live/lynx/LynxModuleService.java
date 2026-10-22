package com.bytedance.android.live.lynx;

import android.view.View;
import com.bytedance.android.live.lynx.element.pullrefresh.LynxPullRefreshView;
import com.bytedance.android.live.lynx.ui.MultiLinkCustomClipImage;
import com.bytedance.android.live.lynx.ui.MultiLinkCustomUIImage;
import com.bytedance.android.live.lynx.ui.WebcastImage;
import com.bytedance.ies.xelement.LynxImpressionView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.input.LynxInputView;
import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.bytedance.ies.xelement.pickview.LynxPickView;
import com.bytedance.ies.xelement.pickview.LynxPickerViewColumn;
import com.bytedance.ies.xelement.text.inlineimage.LynxInlineImageShadowNode;
import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextUI;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.ui.image.FrescoInlineImageShadowNode;
import com.lynx.tasm.ui.image.UIFilterImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/lynx/LynxModuleService;", "Lcom/bytedance/android/live/lynx/ILynxModuleService;", "", "Lcom/lynx/tasm/behavior/a;", "getBehaviorList", "()Ljava/util/List;", "behaviorList", "getLynxPullRefreshView", "()Lcom/lynx/tasm/behavior/a;", "lynxPullRefreshView", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LynxModuleService implements ILynxModuleService {

    public static final class a extends com.lynx.tasm.behavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f82526a;

        public a(List r100) {
            this.f82526a = r100;
            super("x-swiper", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxSwiperView(r100);
        }
    }

    public static final class b extends com.lynx.tasm.behavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f82527a;

        public b(List r100) {
            this.f82527a = r100;
            super("x-swiper-item", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new UIView(r100);
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("m-clips-background");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<View> createUI(LynxContext r100) {
            return new MultiLinkCustomClipImage(r100);
        }
    }

    public static final class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("textarea");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxTextAreaView(r100);
        }
    }

    public static final class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("m-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<View> createUI(LynxContext r100) {
            return new MultiLinkCustomUIImage(r100);
        }
    }

    public static final class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("x-picker-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxPickView(r100);
        }
    }

    public static final class g extends com.lynx.tasm.behavior.a {

        public static final class a implements y76.a {
            public a() {
            }

            @Override // y76.a
            public final Map<String, String> a() {
                return MapsKt.emptyMap();
            }
        }

        public g() {
            super("x-picker-view-column");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            a r101 = new a();
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxPickerViewColumn(r100, r101, null);
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("x-impression-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxImpressionView(r100);
        }
    }

    public static final class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("x-text", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxTextShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxTextUI(r100);
        }
    }

    public static final class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("x-inline-text");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxInlineTextShadowNode();
        }
    }

    public static final class k extends com.lynx.tasm.behavior.a {
        public k() {
            super("x-inline-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new LynxInlineImageShadowNode();
        }
    }

    public static final class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("filter-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new UIFilterImage(r100);
        }
    }

    public static final class m extends com.lynx.tasm.behavior.a {
        public m() {
            super("inline-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new FrescoInlineImageShadowNode();
        }
    }

    public static final class n extends com.lynx.tasm.behavior.a {
        public n() {
            super("swiper", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxSwiperView(r100);
        }
    }

    public static final class o extends com.lynx.tasm.behavior.a {
        public o() {
            super("swiper-item");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new UIView(r100);
        }
    }

    public static final class p extends com.lynx.tasm.behavior.a {
        public p() {
            super("input");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxInputView(r100);
        }
    }

    public static final class q extends com.lynx.tasm.behavior.a {
        public q() {
            super("x-input");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxInputView(r100);
        }
    }

    public static final class r extends com.lynx.tasm.behavior.a {
        public r() {
            super("webcast-image");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new WebcastImage(r100);
        }
    }

    public static final class s extends com.lynx.tasm.behavior.a {
        public s() {
            super("svg", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            return new UISvg(r100, null);
        }
    }

    public static final class t extends com.lynx.tasm.behavior.a {
        public t() {
            super("live-open-refresh-view");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new LynxPullRefreshView(r100);
        }
    }

    public LynxModuleService() {
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v15, types: [T, kotlin.Unit] */
    @Override // com.bytedance.android.live.lynx.ILynxModuleService
    public List<com.lynx.tasm.behavior.a> getBehaviorList() {
        final boolean r100 = true;
        final List<com.lynx.tasm.behavior.a> r101 = CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new l(), new m(), new LynxModuleService$behaviorList$list$3(), new n(), new o(), new p(), new q(), new r(), new s(), new f(), new g(), new h(), new i(), new j(), new k()});
        kjc.c r102 = new kjc.c();
        if (2 != kjc.a.a()) goto L5;
        kjc.b<T> r103 = r102.f503730a;
        r101.add(new a(r101));
        r101.add(new b(r101));
        r103.f503729a = Unit.INSTANCE;
        r102.f503731b = true;
    L5:
        com.bytedance.android.livesdk.paas.a.a(r102, new LynxModuleService$behaviorList$$inlined$call$lambda$3(r101, r100));
        if (r102.f503731b == true) goto L8;
        r102.f503730a.f503729a = Unit.INSTANCE;
    L8:
        T r104 = r102.f503730a.f503729a;
        r101.add(new d());
        r101.add(new e());
        r101.add(new c());
        return r101;
    }

    @Override // com.bytedance.android.live.lynx.ILynxModuleService
    public com.lynx.tasm.behavior.a getLynxPullRefreshView() {
        return new t();
    }
}
