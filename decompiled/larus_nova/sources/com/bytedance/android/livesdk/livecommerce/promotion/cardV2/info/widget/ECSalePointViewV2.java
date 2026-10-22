package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.response.ECSalePointDataV2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.x;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECSalePointViewV2;", "Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointViewV2 extends AutoHideLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TextView> f150615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Space> f150616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f150617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<TextView, x> f150618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECSalePointDataV2 f150619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b f150620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f150621h;

    public static final class a {
    }

    static {
    }

    public ECSalePointViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f150615b = new ArrayList();
        this.f150616c = new ArrayList();
        this.f150617d = new ArrayList();
        this.f150618e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    public final <T extends View> T f(List<T> r100) {
        if ((!r100.isEmpty()) == false) goto L7;
        T r101 = (T) ListProtector.remove(r100, 0);
        if (r101.getParent() != null) goto L9;
        return r101;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout, android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        if ((r100 instanceof TextView) == false) goto L6;
        ((ArrayList) this.f150615b).add(r100);
        return;
    L6:
        if ((r100 instanceof Space) == false) goto L9;
        ((ArrayList) this.f150616c).add(r100);
        return;
    L9:
        if ((r100 instanceof View) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100.getTag(R.id.ec_sale_point_view_tag), "divider_line") == false) goto L17;
        ((ArrayList) this.f150617d).add(r100);
        return;
    }

    public ECSalePointViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f150615b = new ArrayList();
        this.f150616c = new ArrayList();
        this.f150617d = new ArrayList();
        this.f150618e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    public ECSalePointViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150615b = new ArrayList();
        this.f150616c = new ArrayList();
        this.f150617d = new ArrayList();
        this.f150618e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        super.onLayout(r110, r111, r210, r211, r212);
        if (this.f150621h == true) goto L96;
        Set r100 = ((LinkedHashMap) this.f150618e).entrySet();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L17;
        Object r104 = r102.next();
        TextView r105 = (TextView) ((Map.Entry) r104).getKey();
        if (r105.getVisibility() == 0) goto L11;
    L15:
        if (r103 == false) goto L6;
        r101.add(r104);
        goto L6
    L11:
        if (r105.getWidth() <= 0) goto L15;
        if (r105.getHeight() <= 0) goto L15;
        r103 = true;
        goto L15
    L17:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r107 = r101.iterator();
    L19:
        if (r107.hasNext() == false) goto L22;
        r106.add((x) ((Map.Entry) r107.next()).getValue());
        goto L19
    L22:
        if ((!r106.isEmpty()) == true) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L68;
        this.f150621h = true;
        LinkedHashMap r108 = new LinkedHashMap();
        ArrayList r109 = new ArrayList();
        Iterator r112 = r106.iterator();
    L28:
        if (r112.hasNext() == false) goto L35;
        Map<String, String> r113 = ((x) r112.next()).c();
        if (r113 == null) goto L32;
        String r114 = r113.get("elastic_title_type");
    L33:
        if (r114 == null) goto L28;
        r109.add(r114);
        goto L28
    L32:
        r114 = null;
        goto L33
    L35:
        r108.put("elastic_title_types", CollectionsKt.joinToString$default(r109, ",", null, null, 0, null, null, 62, null));
        ArrayList r115 = new ArrayList();
        Iterator r116 = r106.iterator();
    L37:
        if (r116.hasNext() == false) goto L44;
        Map<String, String> r117 = ((x) r116.next()).c();
        if (r117 == null) goto L41;
        String r118 = r117.get("sellpoint_bp");
    L42:
        if (r118 == null) goto L37;
        r115.add(r118);
        goto L37
    L41:
        r118 = null;
        goto L42
    L44:
        r108.put("sellpoint_bp", CollectionsKt.joinToString$default(r115, "@", null, null, 0, null, null, 62, null));
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b r119 = this.f150620g;
        if (r119 == null) goto L47;
        r119.a(r108);
    L47:
        ECSalePointDataV2 r120 = this.f150619f;
        if (r120 == null) goto L94;
        List<s1> r121 = r120.c();
        if (r121 == null) goto L95;
        Iterator<T> r122 = r121.iterator();
    L53:
        if (r122.hasNext() == false) goto L97;
        s1 r123 = (s1) r122.next();
        String r124 = r123.a();
        Map<String, String> r125 = r123.b();
        if (r124 == null) goto L53;
        if (r124.length() <= 0) goto L59;
        boolean r126 = true;
    L60:
        if (r126 != true) goto L53;
        if (r125 == null) goto L64;
        Map<String, String> r127 = MapsKt.plus(r125, r108);
        if (r127 == null) goto L64;
    L65:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b r128 = this.f150620g;
        if (r128 == null) goto L53;
        r128.b(r124, r127, ECSalePointViewV2$reportShowEvent$4$1$1.INSTANCE);
    L64:
        r127 = r108;
        goto L65
    L59:
        r126 = false;
        goto L60
    L97:
        return;
    L95:
        return;
    L94:
        return;
    L68:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final boolean e(View r100, boolean r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof TextView) == false) goto L12;
        if (UtilityKotlinExtentionsKt.e((TextView) r100) == false) goto L12;
        if (indexOfChild(r100) <= 0) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.e(r100, r101, r102, r103, r104, r105);
    }
}
