package cd3;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.a<SlcScrollingView> {
    public String W3;
    public Map<String, ? extends Object> X3;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f23372a;

        public a(b r100) {
            this.f23372a = r100;
        }

        public final void a() {
            b r100 = this.f23372a;
            if (r100.I1().f173630a == true) goto L20;
            SlcScrollingView r101 = r100.I1();
            if (r101.getChildCount() == 0) goto L21;
            r101.c();
            int r102 = r101.getChildAt(0).getMeasuredWidth();
            if (r101.getWidth() <= 0) goto L11;
            int r103 = r101.getWidth();
        L12:
            if (r102 <= r103) goto L22;
            r101.f173630a = true;
            long r104 = r101.f173635f;
            if (r104 <= 0) goto L17;
            r101.postDelayed(new e(r101, r102, r103), r104);
            return;
        L17:
            r101.a(r102, r103);
            return;
        L22:
            return;
        L11:
            r103 = r101.getMeasuredWidth();
            goto L12
        L21:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "templateCtx");
        super(r100);
        this.W3 = "";
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Object r101 = r100.get("indexChanged");
        Object r102 = null;
        if ((r101 instanceof Boolean) == true) goto L5;
        r101 = null;
    L5:
        Boolean r103 = (Boolean) r101;
        if (r103 != null) goto L8;
    L10:
        Object r104 = r100.get("scrollEndAction");
        if ((r104 instanceof Map) == true) goto L13;
        r104 = null;
    L13:
        Map r105 = (Map) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.get("type");
        if ((r106 instanceof String) == true) goto L18;
        r106 = null;
    L18:
        String r107 = (String) r106;
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        this.W3 = r107;
        Object r108 = r105.get(SlcCommonAction.KEY_PARAMS);
        if ((r108 instanceof Map) == true) goto L24;
        r108 = null;
    L24:
        this.X3 = (Map) r108;
    L25:
        Object r109 = r100.get("scrollingSpeed");
        if ((r109 instanceof Number) == true) goto L28;
        r109 = null;
    L28:
        Number r110 = (Number) r109;
        if (r110 == null) goto L31;
        I1().setScrollingSpeed(r110.floatValue());
    L31:
        Object r111 = r100.get("waitDuration");
        if ((r111 instanceof Number) == true) goto L34;
        r111 = null;
    L34:
        Number r112 = (Number) r111;
        if (r112 == null) goto L37;
        I1().setWaitDuration(r112.longValue());
    L37:
        Object r113 = r100.get("startDelay");
        if ((r113 instanceof Number) == false) goto L41;
        r102 = r113;
    L41:
        Number r114 = (Number) r102;
        if (r114 == null) goto L45;
        I1().setStartDelay(r114.longValue());
        return;
    L45:
        return;
    L8:
        if (r103.booleanValue() == false) goto L10;
        I1().post(new a(this));
        goto L10
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.a
    public final ViewGroup K1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SlcScrollingView r101 = new SlcScrollingView(r100, null, 6, 0);
        r101.setOnScrollAnimationEndListener(new cd3.a(this, r101));
        return r101;
    }
}
