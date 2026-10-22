package c82;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView;
import com.bytedance.android.livesdk.config.tn;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends FrameLayout implements ILiveIMDynamicView, IHybridComponent.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridCard f22703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f22705c;

    /* JADX INFO: renamed from: c82.a$a, reason: collision with other inner class name */
    public static final class C0413a {
    }

    public static final class b extends b7.a {
        public b() {
        }

        @Override // b7.a, b7.b
        public final void onBeforeOpenContainer() {
            super.onBeforeOpenContainer();
        }

        @Override // b7.a, b7.b
        public final void onContainerInitEnd() {
            super.onContainerInitEnd();
        }

        @Override // b7.a, b7.b
        public final void onContainerInitStart() {
            super.onContainerInitStart();
        }

        @Override // b7.a, b7.b
        public final void onPrepareComponentEnd() {
            super.onPrepareComponentEnd();
        }

        @Override // b7.a, b7.b
        public final void onPrepareComponentStart() {
            super.onPrepareComponentStart();
        }

        @Override // b7.a, b7.b
        public final void onPrepareInitDataEnd() {
            super.onPrepareInitDataEnd();
        }

        @Override // b7.a, b7.b
        public final void onPrepareTemplateStart() {
            super.onPrepareTemplateStart();
        }

        @Override // b7.a, b7.b
        public final void onRelease() {
            super.onRelease();
        }

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r100) {
            super.onLoadSuccess(r100);
        }

        @Override // b7.a, b7.b
        public final void onPrepareTemplateEnd(boolean r100) {
            super.onPrepareTemplateEnd(r100);
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = b82.a.f18011a;
            b82.a.a("on hybrid fall back. code " + r100 + ",  msg : " + r101, null);
            return super.onFallback(r100, r101);
        }

        @Override // b7.a, b7.b
        public final void onInnerFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = b82.a.f18011a;
            b82.a.a("on hybrid inner im fall back. code " + r100 + ",  msg : " + r101, null);
            super.onInnerFallback(r100, r101);
        }

        @Override // b7.a, b7.b
        public final void onLoadStart(View r100, boolean r101) {
            super.onLoadStart(r100, r101);
        }

        @Override // b7.a, b7.b
        public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "hybridType");
            super.onAttachView(r100, r101, r102);
        }

        @Override // b7.a, b7.b
        public final void onContainerError(View r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            int r103 = b82.a.f18011a;
            b82.a.a("on hybrid onContainerError im fall back. view: " + r100 + " code  " + r101 + ",  msg : " + r102, null);
            super.onContainerError(r100, r101, r102);
        }

        @Override // b7.a, b7.b
        public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "scheme");
            Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
            super.onPrepareInitDataStart(r100, r101, r102);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView
    public final void onPause() {
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView
    public final void onResume() {
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView
    public final void release() {
        if (tn.f121312a.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        HybridCard r100 = this.f22703a;
        if (r100 == null) goto L9;
        r100.release();
        return;
    }

    public final boolean getInited() {
        return this.f22704b;
    }

    public final Function2<Integer, Integer, Unit> getSizeChangeCallback() {
        return this.f22705c;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
    public final void onJSBridgeCreated(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        r100.registerMethod("setIMCardSize", new a82.a(this));
    }

    public final void setInited(boolean r100) {
        this.f22704b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r100, Function2<? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f22705c = r101;
        b r102 = new b();
        IBrowserService r103 = (IBrowserService) k.f(IBrowserService.class);
        if (r103 == null) goto L5;
        HybridCard r104 = r103.getHybridCard(r100, x6.a.d(""), r102);
    L6:
        this.f22703a = r104;
        if (r104 == null) goto L10;
        addView(r104);
        r104.setJSBridgeListener(this);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView
    public final void load(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        HybridCard r102 = this.f22703a;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "url");
        r102.a(UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter("url", r100).appendQueryParameter("fallback_url", r101).build(), null);
        return;
    }
}
