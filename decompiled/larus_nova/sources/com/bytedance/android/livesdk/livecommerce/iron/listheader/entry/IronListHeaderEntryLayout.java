package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.e;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.f;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/entry/IronListHeaderEntryLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/entry/IronListHeaderEntryView;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECLottieAnimationView;", "getCartEntryView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderEntryLayout extends ECCacheItemLinearLayout<IronListHeaderEntryView> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f148798d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f148799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECLottieAnimationView f148800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f148801c;

    public static final class a {
    }

    public final class b implements ECCacheItemLinearLayout.a<IronListHeaderEntryView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ECPromotionEntry> f148802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f148803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f148804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IronListHeaderEntryLayout f148805d;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final View b() {
            return new IronListHeaderEntryView(this.f148805d.getContext());
        }

        public b(IronListHeaderEntryLayout r100) {
            this.f148805d = r100;
            this.f148804c = 0;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final void a(View r110, int r111) {
            final IronListHeaderEntryView r112 = (IronListHeaderEntryView) r110;
            if (r112 == null) goto L50;
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
            gi2.a r101 = null;
            if (r111 <= 0) goto L19;
            Integer r102 = this.f148804c;
            if (r102 != null) goto L9;
        L17:
            r102 = 8;
        L18:
            r100.leftMargin = UtilityKotlinExtentionsKt.d(r102);
            goto L19
        L9:
            if (r102.intValue() <= 0) goto L11;
            boolean r103 = true;
        L12:
            if (r103 == true) goto L15;
            r102 = null;
        L15:
            if (r102 == null) goto L17;
        L11:
            r103 = false;
        L19:
            r112.setLayoutParams(r100);
            final IronListHeaderEntryLayout r104 = this.f148805d;
            List<ECPromotionEntry> r105 = this.f148802a;
            if (r105 == null) goto L22;
            ECPromotionEntry r113 = (ECPromotionEntry) ListProtector.get(r105, r111);
        L23:
            final Map<String, String> r106 = this.f148803b;
            r112.a(r113, r104.f148801c, r106);
            if (r113 != null) goto L26;
        L31:
            if (r113 == null) goto L35;
            final List<ECPromotionEntry> r107 = r113.getSubEntries();
            if (r107 == null) goto L35;
            final ECPromotionEntry r108 = r113;
            r112.setPopupWindow(new IronListHeaderEntryLayout$bindEntryItemData$$inlined$let$lambda$2(r107, r112, r104, r108, r106));
        L35:
            if (r113 == null) goto L37;
            int r114 = r113.getType();
        L38:
            if (r113 == null) goto L41;
            String r109 = r113.getTrackName();
            if (r109 == null) goto L41;
        L42:
            if (r113 == null) goto L44;
            Map<String, String> r115 = r113.getTrackParams();
        L45:
            i r116 = r104.f148801c;
            if (r116 == null) goto L48;
            r101 = r116.f148843g;
        L48:
            int r117 = f.f148820a;
            Intrinsics.checkNotNullParameter(r109, "trackName");
            oh.a.c("list_entry_show_event", new e(r114, r109, r101, r115));
            return;
        L44:
            r115 = null;
        L41:
            r109 = "";
            goto L42
        L37:
            r114 = -1;
            goto L38
        L26:
            if (r113.getType() != 3) goto L31;
            i r118 = r104.f148801c;
            if (r118 == null) goto L30;
            com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.b r119 = new com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.b(r104, r106);
            Intrinsics.checkNotNullParameter(r119, "listHeaderHelper");
            r118.f148839c = r119;
        L30:
            r104.f148800b = r112.getLottieImageView();
            goto L31
        L22:
            r113 = null;
            goto L23
        }
    }

    static {
    }

    public IronListHeaderEntryLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IronListHeaderEntryLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ECLottieAnimationView getCartEntryView() {
        return this.f148800b;
    }

    public IronListHeaderEntryLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148799a = new b(this);
    }

    public /* synthetic */ IronListHeaderEntryLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
