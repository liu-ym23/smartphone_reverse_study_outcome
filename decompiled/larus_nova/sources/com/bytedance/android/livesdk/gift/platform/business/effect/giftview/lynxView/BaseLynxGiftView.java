package com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.annie.util.o;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.configmodel.q1;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vy0.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/lynxView/BaseLynxGiftView;", "Landroid/widget/FrameLayout;", "Lzy0/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lzy0/b;", "getLynxCard", "()Lzy0/b;", "setLynxCard", "(Lzy0/b;)V", "lynxCard", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseLynxGiftView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zy0.b f129399a;

    public static final class a {
    }

    static {
    }

    public BaseLynxGiftView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseLynxGiftView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        removeAllViews();
        zy0.b r100 = this.f129399a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f129399a = null;
    }

    public final zy0.b getLynxCard() {
        return this.f129399a;
    }

    public final void setLynxCard(zy0.b r100) {
        this.f129399a = r100;
    }

    public final void b(Activity r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "lynxViewParam");
        a();
        if (r111.f129404e == false) goto L5;
        String r100 = r111.f129400a + "&enable_canvas=1";
    L6:
        x0 r101 = new x0(r100);
        x0 r102 = r101.d("url");
        ReadOnlyProperty r103 = com.bytedance.android.livesdk.gift.platform.business.effect.a.L;
        KProperty<?>[] r104 = com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a;
        if (((q1) r103.getValue(null, r104[36])).enableSurfaceCanvas == false) goto L18;
        Map<String, String> r105 = r111.f129401b;
        if (r105 == null) goto L11;
        String r106 = r105.get("giftId");
    L12:
        if (r106 == null) goto L18;
        List<String> r107 = ((q1) r103.getValue(null, r104[36])).surfaceCanvasWhiteGiftIdList;
        if (r107 == null) goto L18;
        if (CollectionsKt.contains(r107, r111.f129401b.get("giftId")) != true) goto L18;
        r102.b("enable_surface_canvas", "1");
        goto L18
    L11:
        r106 = null;
    L18:
        Map<String, String> r108 = r111.f129401b;
        if (r108 == null) goto L24;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L24;
        Map.Entry<String, String> r112 = r109.next();
        r102.b(r112.getKey(), r112.getValue());
    L24:
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r101.f91014a.put("url", r102);
        String r113 = r101.toString();
        if (((q1) com.bytedance.android.livesdk.gift.platform.business.effect.a.L.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a[36])).enableAnnieX == true) goto L117;
        zy0.b r114 = ((c) f.a(c.class)).J8(r110, UriProtector.parse(r113), new BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1(this, r111));
    L43:
        this.f129399a = r114;
        if (r114 != null) goto L119;
    L49:
        String r115 = r102.toString();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.f126507t.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.f126488a[18])).booleanValue() == false) goto L93;
        zy0.b r116 = this.f129399a;
        if (r116 == null) goto L98;
        xy0.a<?> r117 = r116.g();
        if (r117 == null) goto L98;
        if (r115 == null) goto L91;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r118 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r119 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L121;
        Class<?> r120 = Class.forName("q20.h");     // Catch: Throwable -> L63
        if (r119 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L85;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L63
    L85:
        Object r121 = o.b(r120, "onLynxLoad", new Object[]{UriProtector.parse(r115)});
        if (r121 == null) goto L91;
        String r122 = r121.toString();
        if (r122 == null) goto L91;
        r115 = r122;
    L63:
        th = move-exception;
        if (r119 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L67;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L67:
        throw th;
    L121:
        r120 = Class.forName("q20.h");     // Catch: Throwable -> L72
        if (r119 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L85;
        FastClassNotFoundHandler.a("com.bytedance.android.live.browser.debug.mock.HybridMockTool");     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        if (r119 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L77;
        FastClassNotFoundHandler.b("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
    L77:
        if ((th instanceof PluginClassNotFoundException) == false) goto L79;
        throw th;
    L79:
        if ((th instanceof ClassNotFoundException) == false) goto L81;
    L84:
        r120 = MiraPluginFix.forName("com.bytedance.android.live.browser.debug.mock.HybridMockTool");
        goto L85
    L81:
        if ((th instanceof NoClassDefFoundError) == true) goto L84;
        throw th;
    L91:
        r117.load(r115);
    L98:
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r123 = r111.f129402c;
        if (r123 == null) goto L106;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r124 = r123.entrySet().iterator();
    L102:
        if (r124.hasNext() == false) goto L106;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r125 = r124.next();
        final String r126 = r125.getKey();
        final com.bytedance.ies.web.jsbridge2.f.b r127 = r125.getValue();
        zy0.b r128 = this.f129399a;
        if (r128 == null) goto L102;
        r128.l1(new BaseLynxGiftView$showLynxView$3$1(r126, r127));
    L106:
        Map<String, g<Object, Object>> r129 = r111.f129403d;
        if (r129 == null) goto L114;
        Iterator<Map.Entry<String, g<Object, Object>>> r130 = r129.entrySet().iterator();
    L110:
        if (r130.hasNext() == false) goto L135;
        Map.Entry<String, g<Object, Object>> r131 = r130.next();
        final String r132 = r131.getKey();
        final g<Object, Object> r133 = r131.getValue();
        zy0.b r134 = this.f129399a;
        if (r134 == null) goto L110;
        r134.l1(new BaseLynxGiftView$showLynxView$4$1(r132, r133));
        goto L110
    L135:
        return;
    L114:
        return;
    L93:
        zy0.b r135 = this.f129399a;
        if (r135 == null) goto L98;
        xy0.a<?> r136 = r135.g();
        if (r136 == null) goto L98;
        r136.load(r115);
        goto L98
    L119:
        r114.x();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxGiftView", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L49
    L117:
        Uri r137 = UriProtector.parse(r113);     // Catch: Exception -> L36
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r137, "group"), "-1") == true) goto L38;
        Uri.Builder r138 = new Uri.Builder().scheme(r137.getScheme()).authority(r137.getAuthority()).path(r137.getPath());     // Catch: Exception -> L36
        Iterator<T> r139 = UriProtector.getQueryParameterNames(r137).iterator();     // Catch: Exception -> L36
    L32:
        if (r139.hasNext() == false) goto L34;
        String r140 = (String) r139.next();     // Catch: Exception -> L36
        r138.appendQueryParameter(r140, UriProtector.getQueryParameter(r137, r140));     // Catch: Exception -> L36
        goto L32
    L34:
        r138.appendQueryParameter("group", "-1");     // Catch: Exception -> L36
        String r141 = r138.build().toString();     // Catch: Exception -> L36
    L39:
        if (r141 == null) goto L41;
        r114 = ((c) f.a(c.class)).q8(r110, UriProtector.parse(r141), new BaseLynxGiftView$createLynxComponentDelegateWithAnnieX$1(this, r111));
        goto L43
    L41:
        r114 = ((c) f.a(c.class)).J8(r110, UriProtector.parse(r113), new BaseLynxGiftView$createLynxComponentDelegateWithAnnie$1(this, r111));
    L38:
        r141 = null;
    L36:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxGiftView", "processUrlWithGroupParam error " + e);
        goto L38
    L5:
        r100 = r111.f129400a;
        goto L6
    }

    public BaseLynxGiftView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ BaseLynxGiftView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
