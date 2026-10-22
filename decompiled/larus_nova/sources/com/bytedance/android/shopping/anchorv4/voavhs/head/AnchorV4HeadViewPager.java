package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\nJ\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\nJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0006\u0010\u0019\u001a\u00020\u000fR+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-R\u0019\u00104\u001a\u0004\u0018\u00010/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/f;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/e;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Ll53/b;", "collisionNegotiator", "", "setCollisionNegotiator", "", "Lkotlin/Pair;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/f;", "", "getGalleryDisplayData", "", "getLastPosition", "hub", "setActionHub", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTotalNavBlurTabCount", "getCurrentImageUri", "getTotalBottomTabCount", MapController.ITEM_LAYER_TAG, "setCurrentItem", "getTotalBuilderCount", "Ljava/util/ArrayList;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/a;", "Lkotlin/collections/ArrayList;", "d", "Lkotlin/Lazy;", "getHeadViewHolders", "()Ljava/util/ArrayList;", "headViewHolders", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "e", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "getOnHolderIndicatorChangedListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "setOnHolderIndicatorChangedListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;)V", "onHolderIndicatorChangedListener", "", "l", "getEnableOptimize", "()Z", "enableOptimize", "Lf83/p;", "p", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadViewPager extends ViewPager implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.f, com.bytedance.android.shopping.anchorv4.voavhs.head.base.e, ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f168424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f168425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f168426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f168427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f168428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l53.b f168429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HeadViewHolderBuilder f168430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends List<Integer>> f168431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f168432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f168433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f168434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f168435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f168436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f168437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super HeadViewHolderBuilder, Unit> f168438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f83.p f168439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d f168440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f83.l f168441r;

    public static final class a implements com.bytedance.android.shopping.anchorv4.dto.business.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f168442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f168443b;

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getBlockNameStr() {
            Object r100 = this.f168442a.get("block_name");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getEnterFromStr() {
            Object r100 = this.f168442a.get("enter_from");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getImageUriStr() {
            Object r100 = this.f168442a.get("image_uri");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final Integer getPageCounterInt() {
            Object r100 = this.f168442a.get("page_counter");
            if ((r100 instanceof Integer) == true) goto L5;
            r100 = null;
        L5:
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L8;
            int r102 = r101.intValue();
        L10:
            return Integer.valueOf(r102);
        L8:
            r102 = 0;
            goto L10
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final Integer getPageCursorInt() {
            Object r100 = this.f168442a.get("page_cursor");
            if ((r100 instanceof Integer) == true) goto L5;
            r100 = null;
        L5:
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L8;
            int r102 = r101.intValue();
        L10:
            return Integer.valueOf(r102);
        L8:
            r102 = 0;
            goto L10
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getProductIdStr() {
            Object r100 = this.f168442a.get("product_id");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getProductNameStr() {
            Object r100 = this.f168442a.get("product_name");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getRecommendProductIdStr() {
            Object r100 = this.f168442a.get("recommend_product_id");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getSceneIdStr() {
            Object r100 = this.f168442a.get("scene_id");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getSceneProductIdStr() {
            Object r100 = this.f168442a.get("scene_product_id");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getSearchChannelStr() {
            Object r100 = this.f168442a.get("search_channel");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final String getSearchSourceStr() {
            Object r100 = this.f168442a.get("search_source");
            if ((r100 instanceof String) == true) goto L6;
            r100 = null;
        L6:
            return (String) r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final Integer getShownCountInt() {
            Object r100 = this.f168442a.get("shown_count");
            if ((r100 instanceof Double) == true) goto L5;
            r100 = null;
        L5:
            Double r101 = (Double) r100;
            if (r101 == null) goto L8;
            int r102 = (int) r101.doubleValue();
        L10:
            return Integer.valueOf(r102);
        L8:
            r102 = 0;
            goto L10
        }

        @Override // com.bytedance.android.shopping.anchorv4.dto.business.c
        public final int getTypeInt() {
            Integer r100 = this.f168443b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.intValue();
        }

        public a(Map r100, Integer r101) {
            this.f168442a = r100;
            this.f168443b = r101;
        }
    }

    public AnchorV4HeadViewPager(Context r100) {
        this(r100, null, null, null, null, 30);
    }

    public AnchorV4HeadViewPager(Context r100, AttributeSet r101) {
        this(r100, r101, null, null, null, 28);
    }

    private final boolean getEnableOptimize() {
        return ((Boolean) this.f168435l.getValue()).booleanValue();
    }

    private final ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> getHeadViewHolders() {
        return (ArrayList) this.f168427d.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r100) {
        return null;
    }

    public final String getCurrentImageUri() {
        HeadViewHolderBuilder r100 = this.f168430g;
        if (r100 == null) goto L21;
        int r101 = getCurrentItem();
        List<c> r102 = r100.f168501b;
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.size() <= r101) goto L10;
        if (r101 < 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L16;
        return null;
    L16:
        if (((c) ListProtector.get(r102, r101)).getType() != HeadViewType.PICTURE.getType()) goto L24;
        ECUrlModel r104 = ((c) ListProtector.get(r102, r101)).f168529b;
        if (r104 != null) goto L20;
        return null;
    L20:
        return r104.getUri();
    L24:
        return null;
    L10:
        r103 = false;
        goto L11
    L21:
        return null;
    }

    public final List<ECUrlModel> getTotalBottomTabCount() {
        HeadViewHolderBuilder r100 = this.f168430g;
        if (r100 == null) goto L51;
        List r101 = CollectionsKt.listOf(new String[]{HeadViewType.SIZE.getType(), HeadViewType.FIND_SAME.getType(), HeadViewType.COMMENT.getType()});
        ArrayList r102 = new ArrayList();
        List<c> r103 = r100.f168501b;
        if (r103 == null) goto L37;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L37;
        c r105 = (c) r104.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r106 = r100.f168504e.get(r105.getType());
        if (r106 == null) goto L13;
        List<ECUrlModel> r107 = r106.l(r105);
        if (r107 == null) goto L13;
    L14:
        List r108 = r101;
        if ((r108 instanceof Collection) == true) goto L17;
    L19:
        Iterator r109 = r108.iterator();
    L21:
        if (r109.hasNext() == false) goto L25;
        if ((!Intrinsics.areEqual(r105.getType(), (String) r109.next())) == true) goto L21;
        boolean r110 = false;
    L26:
        if (r110 == false) goto L31;
        List<ECUrlModel> r111 = r107;
        if ((!r111.isEmpty()) == false) goto L31;
        r102.addAll(r111);
    L31:
        if ((!r107.isEmpty()) == true) goto L32;
        r102.add(null);
        goto L8
    L32:
        int r112 = r107.size();
        int r113 = 0;
    L33:
        if (r113 >= r112) goto L8;
        r102.add(null);
        r113 = r113 + 1;
    L25:
        r110 = true;
        goto L26
    L17:
        if (r108.isEmpty() == false) goto L19;
    L13:
        r107 = CollectionsKt.emptyList();
    L37:
        return r102;
    L51:
        return null;
    }

    public final List<ECUrlModel> getTotalNavBlurTabCount() {
        HeadViewHolderBuilder r100 = this.f168430g;
        if (r100 == null) goto L43;
        List r101 = CollectionsKt.listOf(new String[]{HeadViewType.SIZE.getType(), HeadViewType.FIND_SAME.getType(), HeadViewType.COMMENT.getType()});
        ArrayList r102 = new ArrayList();
        List<c> r103 = r100.f168501b;
        if (r103 == null) goto L32;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L32;
        c r105 = (c) r104.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r106 = r100.f168504e.get(r105.getType());
        if (r106 == null) goto L13;
        List<ECUrlModel> r107 = r106.k(r105);
        if (r107 == null) goto L13;
    L14:
        List r108 = r101;
        if ((r108 instanceof Collection) == true) goto L17;
    L19:
        Iterator r109 = r108.iterator();
    L21:
        if (r109.hasNext() == false) goto L25;
        if ((!Intrinsics.areEqual(r105.getType(), (String) r109.next())) == true) goto L21;
        boolean r110 = false;
    L26:
        if (r110 == false) goto L30;
        List<ECUrlModel> r111 = r107;
        if ((!r111.isEmpty()) == false) goto L30;
        r102.addAll(r111);
    L30:
        r102.add(null);
    L25:
        r110 = true;
        goto L26
    L17:
        if (r108.isEmpty() == false) goto L19;
    L13:
        r107 = CollectionsKt.emptyList();
    L32:
        return r102;
    L43:
        return null;
    }

    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> getGalleryDisplayData() {
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r100 = getHeadViewHolders();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r102.next()).f());
        goto L4
    L6:
        int r103 = r101.size();
        ArrayList r104 = new ArrayList(r103);
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L9;
        r104.add(CollectionsKt.emptyList());
        r105 = r105 + 1;
        goto L7
    L9:
        int r106 = r101.size();
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L16;
        Iterable r108 = (Iterable) ListProtector.get(r101, r107);
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L13:
        if (r110.hasNext() == false) goto L15;
        Pair r111 = (Pair) r110.next();
        r109.add(0);
        goto L13
    L15:
        ListProtector.set(r104, r107, r109);
        r107 = r107 + 1;
        goto L10
    L16:
        this.f168431h = r104;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r101.iterator();
    L18:
        if (r113.hasNext() == false) goto L20;
        r112.addAll((List) r113.next());
        goto L18
    L20:
        return r112;
    }

    public final int getTotalBuilderCount() {
        return getHeadViewHolders().size();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f168437n == false) goto L6;
        requestLayout();
        this.f168437n = false;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f168434k;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final List<Integer> getLastPosition() {
        return this.f168432i;
    }

    public final n getOnHolderIndicatorChangedListener() {
        return this.f168428e;
    }

    public final f83.p getTabLogicInterceptor() {
        return this.f168439p;
    }

    public static final /* synthetic */ boolean h(AnchorV4HeadViewPager r100) {
        return r100.getEnableOptimize();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.e
    public final void d(int r100) {
        if (getCurrentItem() != r100) goto L5;
        return;
    L5:
        setCurrentItem(r100, false);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.f
    public final void e(com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r100) {
        Intrinsics.checkNotNullParameter(r100, "itemViewDetail");
        HeadViewHolderBuilder r101 = this.f168430g;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "itemViewDetail");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r102 = r101.f168504e.get(r100.getType());
        if ((r102 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L7;
        r102 = null;
    L7:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r103 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r102;
        if (r103 == null) goto L12;
        r103.a(r100.f168526c);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.a i(int r100) {
        return (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) CollectionsKt.getOrNull(getHeadViewHolders(), r100);
    }

    public final Pair<Integer, Integer> k(int r100) {
        int r101 = this.f168431h.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L12;
        int r104 = ((Collection) ListProtector.get(this.f168431h, r102)).size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        int r106 = r103 + 1;
        if (r103 == r100) goto L9;
        r105 = r105 + 1;
        r103 = r106;
        goto L5
    L9:
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r105));
    L11:
        r102 = r102 + 1;
        goto L3
    L12:
        return null;
    }

    public final void l(boolean r100) {
        Iterator<T> r101 = getHeadViewHolders().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r101.next()).b2(r100);
        goto L4
    }

    public final void m(List<b> r110) {
        Intrinsics.checkNotNullParameter(r110, "headNodeGroupList");
        getHeadViewHolders().clear();
        if (this.f168430g != null) goto L5;
        this.f168430g = new HeadViewHolderBuilder(getContext(), this, r110, this.f168429f, this.f168440q, false);
    L5:
        HeadViewHolderBuilder r100 = this.f168430g;
        if (r100 == null) goto L10;
        Function1<? super HeadViewHolderBuilder, Unit> r101 = this.f168438o;
        if (r101 == null) goto L10;
        Unit r102 = r101.invoke(r100);
    L10:
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r103 = getHeadViewHolders();
        HeadViewHolderBuilder r104 = this.f168430g;
        if (r104 == null) goto L13;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r105 = r104.b();
    L14:
        r103.addAll(r105);
        if (getAdapter() != null) goto L17;
        ArrayList r106 = new ArrayList();
        r106.addAll(getHeadViewHolders());
        Unit r107 = Unit.INSTANCE;
        setAdapter(new AnchorV4HeadViewAdapter(this, r106));
    L23:
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r110.iterator();
    L25:
        if (r109.hasNext() == false) goto L29;
        Object r111 = r109.next();
        if ((true ^ ((b) r111).f168487d) == false) goto L25;
        r108.add(r111);
        goto L25
    L29:
        f83.p r112 = this.f168439p;
        if (r112 == null) goto L32;
        r112.a(r108);
    L32:
        fj.d.f477433s.getClass();
        ((LinkedHashMap) fj.d.f477432r).clear();
        Iterator r113 = r108.iterator();
        int r114 = 0;
        int r115 = 0;
    L34:
        if (r113.hasNext() == false) goto L131;
        Object r116 = r113.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        b r118 = (b) r116;
        String r119 = r118.f168485b;
        String r120 = a2.d(r118.f168488e);
        if (r120 != null) goto L42;
        r120 = c.f168527J.get(Integer.valueOf(c.a.a(r119)));
    L42:
        if (Intrinsics.areEqual(r120, EffectConstants.CHANNEL_TEST) == false) goto L60;
        e83.a.f471296d.getClass();
        Iterator r121 = e83.a.a().iterator();
    L45:
        if (r121.hasNext() == false) goto L49;
        Object r122 = r121.next();
        if (Intrinsics.areEqual(((c) r122).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L45;
    L50:
        c r123 = (c) r122;
        if (r123 == null) goto L57;
        h83.a r124 = r123.B;
        if (r124 == null) goto L57;
        CommentVideoInfo r125 = r124.f484068a;
        if (r125 == null) goto L57;
        TextWithOneIconElement r126 = r125.getMoreText();
    L58:
        if (r126 == null) goto L60;
        r120 = "more_test";
    L57:
        r126 = null;
        goto L58
    L49:
        r122 = null;
    L60:
        String r127 = r120;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r128 = this.f168440q;
        if (r128 == null) goto L130;
        c63.d r129 = r128.t();
        if (r129 == null) goto L130;
        if (com.bytedance.android.shopping.anchorv4.experiment.d.a() == false) goto L67;
        String r130 = "shrink";
    L68:
        String r131 = r130;
        if (Intrinsics.areEqual(r119, String.valueOf(r114)) == false) goto L89;
        int r132 = ((b) ListProtector.get(r108, r115)).f168486c.size();
        List<c> r133 = ((b) ListProtector.get(r108, r115)).f168486c;
        if ((r133 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r134 = r133.iterator();
        int r135 = 0;
    L77:
        if (r134.hasNext() == false) goto L83;
        if (Intrinsics.areEqual(((c) r134.next()).getType(), HeadViewType.VIDEO.getType()) == false) goto L77;
        r135 = r135 + 1;
        if (r135 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
    L83:
        if (r135 != 0) goto L85;
        String r136 = "picture";
    L88:
        String r137 = r136;
    L91:
        if (Intrinsics.areEqual(r119, String.valueOf(r114)) == false) goto L93;
    L94:
        Iterator<T> r138 = ((b) ListProtector.get(r108, r115)).f168486c.iterator();
    L96:
        if (r138.hasNext() == false) goto L107;
        Object r139 = r138.next();
        c r140 = (c) r139;
        if (Intrinsics.areEqual(r140.getType(), HeadViewType.VIDEO.getType()) == false) goto L100;
    L103:
        boolean r141 = true;
    L104:
        if (r141 == false) goto L96;
    L108:
        c r142 = (c) r139;
        if (r142 == null) goto L113;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r143 = r142.f168536i;
        if (r143 == null) goto L113;
        String r144 = r143.k(c.f168527J.get(Integer.valueOf(c.a.a(r119))));
    L115:
        if (Intrinsics.areEqual(r119, String.valueOf(5)) == false) goto L128;
        Iterator<T> r145 = ((b) ListProtector.get(r108, r115)).f168486c.iterator();
    L118:
        if (r145.hasNext() == false) goto L122;
        Object r146 = r145.next();
        if (Intrinsics.areEqual(((c) r146).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L118;
    L123:
        c r147 = (c) r146;
        if (r147 == null) goto L128;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r148 = r147.f168536i;
        if (r148 == null) goto L128;
        Integer r149 = r148.h();
    L129:
        r129.h(r127, r131, r137, r144, r149, Integer.valueOf(r115));
        goto L130
    L122:
        r146 = null;
    L128:
        r149 = null;
    L113:
        r144 = null;
        goto L115
    L100:
        if (Intrinsics.areEqual(r140.getType(), HeadViewType.GOOD_COMMENT.getType()) == true) goto L103;
        r141 = false;
        goto L104
    L107:
        r139 = null;
        goto L108
    L93:
        if (Intrinsics.areEqual(r119, String.valueOf(5)) == false) goto L113;
    L85:
        if (r135 != r132) goto L87;
        r136 = "video";
        goto L88
    L87:
        r136 = "picture_video";
        goto L88
    L73:
        if (r133.isEmpty() == false) goto L75;
        r135 = 0;
        goto L83
    L89:
        r137 = null;
        goto L91
    L67:
        r130 = "expansion";
    L130:
        r115 = r117;
        r114 = 0;
        goto L34
    L131:
        return;
    L17:
        PagerAdapter r150 = getAdapter();
        if ((r150 instanceof AnchorV4HeadViewAdapter) == true) goto L20;
        r150 = null;
    L20:
        AnchorV4HeadViewAdapter r151 = (AnchorV4HeadViewAdapter) r150;
        if (r151 == null) goto L23;
        ArrayList r152 = new ArrayList();
        r152.addAll(getHeadViewHolders());
        Unit r153 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r152, "viewHolder");
        r151.f168423e = r152;
        r151.notifyDataSetChanged();
        goto L23
    L13:
        r105 = CollectionsKt.emptyList();
        goto L14
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();     // Catch: Exception -> L21
        if (r101 != 0) goto L6;
        this.f168424a = r100.getX();     // Catch: Exception -> L21
        this.f168425b = r100.getY();     // Catch: Exception -> L21
    L17:
        if (this.f168426c == false) goto L19;
        super.onTouchEvent(r100);     // Catch: Exception -> L21
        boolean r102 = this.f168426c;     // Catch: Exception -> L21
    L25:
        return r102;
    L19:
        r102 = super.onTouchEvent(r100);     // Catch: Exception -> L21
        goto L25
    L6:
        if (r101 != 2) goto L17;
        if (Math.abs(r100.getY() - this.f168425b) > Math.abs(r100.getX() - this.f168424a)) goto L13;
        ViewParent r103 = getParent();     // Catch: Exception -> L21
        boolean r104 = true;
        if (r103 == null) goto L14;
        r103.requestDisallowInterceptTouchEvent(true);     // Catch: Exception -> L21
    L14:
        this.f168426c = r104;     // Catch: Exception -> L21
        goto L17
    L13:
        r104 = false;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f168434k = r100;
    }

    public final void setCollisionNegotiator(l53.b r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionNegotiator");
        this.f168429f = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        super.setCurrentItem(r100);
        if (ViewCompat.isAttachedToWindow(this) == true) goto L6;
        this.f168437n = true;
        return;
    }

    public final void setOnHolderIndicatorChangedListener(n r100) {
        this.f168428e = r100;
    }

    public final int j(int r100, int r101) {
        Collection r102 = (Collection) CollectionsKt.getOrNull(this.f168431h, r100);
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return -1;
    L11:
        int r105 = 0;
    L12:
        if (r103 >= r100) goto L15;
        r105 = r105 + ((List) ListProtector.get(this.f168431h, r103)).size();
        r103 = r103 + 1;
        goto L12
    L15:
        return RangesKt.coerceAtMost(r101, ((List) ListProtector.get(this.f168431h, r100)).size()) + r105;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r100, Object r101) {
        com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r102 = this.f168434k;
        if (r102 == null) goto L6;
        r102.l0(r100, r101);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r102 = this.f168440q;
        if (r102 != null) goto L5;
    L17:
        r101 = r100;
    L23:
        super.onMeasure(r100, r101);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r102.i() != true) goto L17;
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L17;
        float r103 = this.f168436m;
        if (r103 < 0.0f) goto L15;
        if (r103 <= 1.0f) goto L23;
    L15:
        if (this.f168440q.n() == false) goto L17;
        int r104 = View.MeasureSpec.getMode(r100);
        r101 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(r100) * 4) / 3, r104);
        goto L23
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        super.setCurrentItem(r100, r101);
        if (ViewCompat.isAttachedToWindow(this) == true) goto L6;
        this.f168437n = true;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r100, Action r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r103 = this.f168434k;
        if (r103 == null) goto L6;
        r103.O0(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.bytedance.android.shopping.anchorv4.data.FindSameSource] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, com.bytedance.android.shopping.anchorv4.data.FindSameSource] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, com.bytedance.android.shopping.anchorv4.data.FindSameSource] */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.e
    public final void a(Integer r100, com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r101, Boolean r110) {
        if (getHeadViewHolders().size() > 1) goto L5;
        return;
    L5:
        if (this.f168433j == true) goto L66;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = FindSameSource.DEFAULT;
        HeadViewHolderBuilder r103 = this.f168430g;
        String r104 = null;
        if (r103 == null) goto L12;
        CommonFindSameElement r105 = r103.a();
        if (r105 == null) goto L12;
        Map<String, Object> r106 = r105.getRequestParams();
    L13:
        r102.element = FindSameSource.HEAD_VH;
        if (r106 != null) goto L22;
        f83.l r107 = this.f168441r;
        if (r107 == null) goto L20;
        CommonFindSameElement r108 = r107.getFindSameElement();
        if (r108 == null) goto L20;
        r106 = r108.getRequestParams();
    L21:
        r102.element = FindSameSource.HEAD_INDICATOR;
    L20:
        r106 = null;
    L22:
        HeadViewHolderBuilder r109 = this.f168430g;
        if (r109 == null) goto L28;
        CommonFindSameElement r111 = r109.a();
        if (r111 == null) goto L28;
        Integer r112 = r111.getType();
        if (r112 == null) goto L28;
    L34:
        boolean r113 = false;
        if (ECSettingKeys.u() == 0) goto L37;
    L39:
        boolean r114 = false;
    L40:
        f83.p r115 = this.f168439p;
        if (r115 == null) goto L43;
        Integer r116 = Integer.valueOf(r115.d());
    L44:
        int r117 = com.bytedance.android.shopping.extensions.k.f(r116);
        if (r100 == null) goto L47;
        int r118 = r100.intValue();
    L49:
        if (((r117 - r118) - 1) > ECSettingKeys.u()) goto L51;
        r113 = true;
    L51:
        if (r101 == null) goto L53;
        r104 = r101.getType();
    L53:
        boolean r119 = Intrinsics.areEqual(r104, HeadViewType.FIND_SAME.getType());
        if (r114 == true) goto L57;
        if (r113 == true) goto L57;
        if (r119 == true) goto L57;
        return;
    L57:
        if (r106 == null) goto L65;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r120 = this.f168440q;
        if (r120 == null) goto L61;
        r120.j(new a(r106, r112), (FindSameSource) r102.element);
    L61:
        this.f168433j = true;
        return;
    L65:
        return;
    L47:
        r118 = 0;
        goto L49
    L43:
        r116 = null;
        goto L44
    L37:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L39;
        r114 = true;
    L28:
        f83.l r121 = this.f168441r;
        if (r121 == null) goto L33;
        CommonFindSameElement r122 = r121.getFindSameElement();
        if (r122 == null) goto L33;
        r112 = r122.getType();
    L33:
        r112 = null;
    L12:
        r106 = null;
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.f
    public final void c(int r100, boolean r101, com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r102) {
        Intrinsics.checkNotNullParameter(r102, "itemViewDetail");
        List<Integer> r103 = this.f168432i;
        ListProtector.set(r103, 0, ListProtector.get(r103, 1));
        ListProtector.set(this.f168432i, 1, Integer.valueOf(r100));
        HeadViewHolderBuilder r104 = this.f168430g;
        if (r104 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "itemViewDetail");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r105 = r104.f168504e.get(r102.getType());
        if ((r105 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L7;
        r105 = null;
    L7:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r106 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r105;
        if (r106 == null) goto L11;
        r106.f(r101, r102.f168526c);
    L11:
        if (getEnableOptimize() == true) goto L15;
        f83.p r107 = this.f168439p;
        if (r107 == null) goto L15;
        r107.b(r100, r101);
    L15:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e.a.a(this, Integer.valueOf(r100), r102, null, 4);
        f83.p r108 = this.f168439p;
        if (r108 == null) goto L18;
        r108.e(Integer.valueOf(r100));
    L18:
        ExtensionsKt.e(this, this);
        ExtensionsKt.b(this, this);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e.a.a(this, null, null, Boolean.TRUE, 3);
    }

    public AnchorV4HeadViewPager(Context r100, AttributeSet r101, f83.p r102, t r103, f83.l r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f168439p = r102;
        this.f168440q = r103;
        this.f168441r = r104;
        this.f168427d = LazyKt.lazy(AnchorV4HeadViewPager$headViewHolders$2.INSTANCE);
        this.f168431h = CollectionsKt.emptyList();
        this.f168432i = CollectionsKt.mutableListOf(new Integer[]{-1, -1});
        this.f168435l = LazyKt.lazy(AnchorV4HeadViewPager$enableOptimize$2.INSTANCE);
        this.f168436m = -1.0f;
    }
}
