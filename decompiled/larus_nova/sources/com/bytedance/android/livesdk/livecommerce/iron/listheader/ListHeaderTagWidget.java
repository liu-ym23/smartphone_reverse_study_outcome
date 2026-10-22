package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ListHeaderTagWidget;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListHeaderTagWidget extends ECCacheItemLinearLayout<ECDraweeView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f148774a;

    public static final class a {
    }

    public final class b implements ECCacheItemLinearLayout.a<ECDraweeView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ECRitTag> f148775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gi2.a f148776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ListHeaderTagWidget f148777c;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final View b() {
            ECDraweeView r100 = new ECDraweeView(this.f148777c.getContext(), null, 0, 6, null);
            r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            return r100;
        }

        public b(ListHeaderTagWidget r100) {
            this.f148777c = r100;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final void a(View r110, final int r111) {
            final ECDraweeView r112 = (ECDraweeView) r110;
            if (r112 == null) goto L26;
            List<ECRitTag> r100 = this.f148775a;
            if (r100 == null) goto L27;
            final ECRitTag r101 = (ECRitTag) ListProtector.get(r100, r111);
            if (r101 == null) goto L28;
            if (r111 == 0) goto L10;
            o0.e(r112, UtilityKotlinExtentionsKt.d(4));
        L10:
            ECUrlModel r102 = r101.getTextIcon();
            if (r102 == null) goto L13;
            String r103 = r102.getFirstUrl();
        L14:
            y.g(r112, r103, UtilityKotlinExtentionsKt.d(Integer.valueOf(r101.getIconWidth())), UtilityKotlinExtentionsKt.d(Integer.valueOf(r101.getIconHeight())));
            String r104 = r101.getTrackTag();
            Map<String, String> r105 = r101.getEventParam();
            gi2.a r106 = this.f148776b;
            int r107 = f.f148820a;
            if (r104 != null) goto L17;
        L20:
            boolean r108 = true;
        L21:
            if (r108 == true) goto L24;
            oh.a.c("list_tag_event", new g(false, r104, r106, r105));
        L24:
            com.bytedance.android.ec.core.widget.f.c(r112, null, "bind_key_live_promotion_list", new ListHeaderTagWidget$TagItemViewHelper$bindItemViewData$$inlined$let$lambda$1(r101, r112, this, r111, r112), 1);
            return;
        L17:
            if (StringsKt.isBlank(r104) == true) goto L20;
            r108 = false;
            goto L21
        L13:
            r103 = null;
            goto L14
        L28:
            return;
        L27:
            return;
        }
    }

    static {
    }

    public ListHeaderTagWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ListHeaderTagWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ListHeaderTagWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148774a = new b(this);
    }

    public final int b(List<ECRitTag> r110, int r111, gi2.a r210) {
        measure(-2, -2);
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
        long r102 = 0;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L21;
        Object r104 = r101.next();
        int r112 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ECRitTag r105 = (ECRitTag) r104;
        ECUrlModel r113 = r105.getTextIcon();
        if (r113 == null) goto L11;
        int r114 = r113.getWidth();
    L12:
        int r115 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r114));
        if (r103 <= 0) goto L15;
        int r106 = UtilityKotlinExtentionsKt.d(4);
    L16:
        long r116 = r102;
        if (((((long) r115) + r102) + ((long) r106)) > r111) goto L19;
        r100.add(r105);
        r102 = r116 + ((long) (r115 + r106));
    L20:
        r103 = r112;
        goto L4
    L19:
        r102 = r116;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L11:
        r114 = 0;
        goto L12
    L21:
        oh.a.c("reportShowTags", new h(r100, r210, BtmSDK.INSTANCE.getPageId(PageFinder.via(this))));
        b r107 = this.f148774a;
        r107.f148775a = r100;
        r107.f148776b = r210;
        a(r100.size(), this.f148774a);
        Iterator r108 = r100.iterator();
        int r109 = 0;
        int r117 = 0;
    L23:
        if (r108.hasNext() == false) goto L36;
        Object r118 = r108.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        ECUrlModel r120 = ((ECRitTag) r118).getTextIcon();
        if (r120 == null) goto L30;
        int r121 = r120.getWidth();
    L31:
        int r122 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r121));
        if (r117 <= 0) goto L34;
        int r123 = UtilityKotlinExtentionsKt.d(4);
    L35:
        r109 = r109 + (r122 + r123);
        r117 = r119;
        goto L23
    L34:
        r123 = 0;
        goto L35
    L30:
        r121 = 0;
        goto L31
    L36:
        return r109;
    }

    public /* synthetic */ ListHeaderTagWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
