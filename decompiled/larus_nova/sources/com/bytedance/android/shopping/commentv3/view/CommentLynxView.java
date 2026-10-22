package com.bytedance.android.shopping.commentv3.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentLynxComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentTemplate;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommentLynxView;", "Lcom/bytedance/android/ui/base/widget/round/RoundFrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentLynxView extends com.bytedance.android.ui.base.widget.round.RoundFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f172939a;

    public CommentLynxView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentLynxView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(CommentLynxComponent r110, com.bytedance.android.shopping.commentv3.data.b r111) {
        Intrinsics.checkNotNullParameter(r110, "component");
        if (this.f172939a == null) goto L5;
        return;
    L5:
        Map<String, Object> r100 = r110.getStyle();
        boolean r101 = false;
        if (r100 == null) goto L8;
        int r102 = nc3.a.b(r100, "min_height", 0);
    L9:
        setMinimumHeight(CJPayBasicExtensionKt.dp(r102));
        Map<String, Object> r103 = r110.getStyle();
        Integer r104 = null;
        if (r103 == null) goto L12;
        Object r105 = r103.get(GXTemplateKey.FLEXBOX_MARGIN);
    L13:
        if (r111 == null) goto L20;
        fc3.a r106 = r111.f172737b;
        if (r106 == null) goto L20;
        fc3.a.C5880a r107 = r106.f476337b;
        if (r107 == null) goto L20;
        Function1 r108 = r107.f476343e;
        if (r108 == null) goto L20;
    L21:
        nc3.b.b(this, r105, r108);
        CommentTemplate r109 = r110.getTemplate();
        if (r109 == null) goto L24;
        String r112 = r109.getUrl();
    L25:
        if (r112 != null) goto L27;
    L28:
        r101 = true;
    L29:
        if (r101 == false) goto L31;
        return;
    L31:
        HashMap r113 = new HashMap();
        r113.put("type", r109.getType());
        Map<String, Object> r114 = r110.getData();
        String r115 = "";
        if (r114 == null) goto L35;
        String r116 = nc3.a.e(r114, "content", null);
        if (r116 == null) goto L35;
    L36:
        r113.put("content", r116);
        Map<String, Object> r117 = r110.getData();
        if (r117 == null) goto L39;
        Object r118 = r117.get("extra_data");
    L40:
        r113.put("extra_data", r118);
        HashMap r119 = new HashMap();
        TrackerProvider.a r120 = TrackerProvider.Companion;
        Context r121 = getContext();
        if (r121 == null) goto L48;
        Activity r122 = d0.f165305a.getActivity(r121);
        if ((r122 instanceof FragmentActivity) == true) goto L46;
        r122 = null;
    L46:
        FragmentActivity r123 = (FragmentActivity) r122;
        if (r123 == null) goto L48;
        Object r124 = ((TrackerProvider) ViewModelProviders.of(r123).get(TrackerProvider.class)).getTracker();
        if ((r124 instanceof t53.a) == true) goto L52;
        r124 = null;
    L52:
        t53.a r125 = (t53.a) r124;
    L53:
        if (r125 == null) goto L55;
        HashMap<String, String> r126 = r125.f544621a;
    L57:
        if (r126 == null) goto L60;
        String r127 = r126.get(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE);
        if (r127 == null) goto L60;
    L61:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, r127);
        if (r126 == null) goto L65;
        String r128 = r126.get("product_id");
        if (r128 == null) goto L65;
    L66:
        r119.put("product_id", r128);
        if (r126 == null) goto L70;
        String r129 = r126.get("page_name");
        if (r129 == null) goto L70;
    L71:
        r119.put("page_name", r129);
        if (r126 == null) goto L75;
        String r130 = r126.get(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE);
        if (r130 == null) goto L75;
    L76:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r130);
        if (r126 == null) goto L80;
        String r131 = r126.get(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
        if (r131 == null) goto L80;
    L81:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r131);
        if (r126 == null) goto L85;
        String r132 = r126.get(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);
        if (r132 == null) goto L85;
    L86:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r132);
        if (r126 == null) goto L90;
        String r133 = r126.get("previous_page");
        if (r133 == null) goto L90;
    L91:
        r119.put("previous_page", r133);
        if (r126 == null) goto L95;
        String r134 = r126.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        if (r134 == null) goto L95;
    L96:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r134);
        if (r126 == null) goto L100;
        String r135 = r126.get(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE);
        if (r135 == null) goto L100;
    L101:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r135);
        if (r111 == null) goto L104;
        r104 = Integer.valueOf(r111.a());
    L104:
        r119.put("data_type", String.valueOf(r104));
        if (r111 == null) goto L110;
        String r136 = String.valueOf(r111.f172743h.f172698c);
        if (r136 == null) goto L110;
        r115 = r136;
    L110:
        r119.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r115);
        r113.put("track_params", r119);
        this.f172939a = ECLiveHybridUtil.b(getContext(), r112, r113, this, null, null, null, false, null, null, false, 4080);
        return;
    L100:
        r135 = "";
    L95:
        r134 = "";
    L90:
        r133 = "";
    L85:
        r132 = "";
    L80:
        r131 = "";
    L75:
        r130 = "";
    L70:
        r129 = "";
    L65:
        r128 = "";
    L60:
        r127 = "";
        goto L61
    L55:
        r126 = null;
    L48:
        r125 = null;
        goto L53
    L39:
        r118 = null;
    L35:
        r116 = "";
        goto L36
    L27:
        if (r112.length() != 0) goto L29;
    L24:
        r112 = null;
    L20:
        r108 = CommentLynxView$setStyle$slcDp$1.INSTANCE;
        goto L21
    L12:
        r105 = null;
        goto L13
    L8:
        r102 = 0;
        goto L9
    }

    public CommentLynxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CommentLynxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
