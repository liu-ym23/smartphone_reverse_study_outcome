package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.e;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoView$BaseInfoLayoutOnHierarchyChangeListener$onChildViewRemoved$$inlined$cacheSimpleDraweeView$1;
import com.bytedance.android.shopping.extensions.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ExtensionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, WeakReference<Bitmap>> f167878a = null;

    public static final class a<T> implements y.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f167879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Background f167880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f167881c;

        public a(View r100, Background r101, String r102) {
            this.f167879a = r100;
            this.f167880b = r101;
            this.f167881c = r102;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r100) {
            this.f167879a.post(new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.a(this, (Bitmap) r100));
        }
    }

    static {
        f167878a = new HashMap();
    }

    public static final void a(LinearLayout r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$configAlignStrategy");
        if (r101 != 0) goto L5;
        r100.setVerticalGravity(48);
        return;
    L5:
        if (r101 != 1) goto L7;
        r100.setVerticalGravity(16);
        return;
    L7:
        if (r101 == 2) goto L9;
        r100.setVerticalGravity(48);
        return;
    L9:
        r100.setVerticalGravity(80);
    }

    public static final void b(ViewGroup r100, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsDispatchPossibleShow");
        Intrinsics.checkNotNullParameter(r101, "hub");
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        View r104 = r100.getChildAt(r103);
        if ((r104 instanceof ActionHubAccessor) == true) goto L7;
        Object r105 = null;
    L8:
        ActionHubAccessor r106 = (ActionHubAccessor) r105;
        if (r106 == null) goto L12;
        r106.dispatchPossibleShow();
    L12:
        if ((r104 instanceof ViewGroup) == false) goto L14;
        b((ViewGroup) r104, r101);
    L14:
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = r104;
        goto L8
    }

    public static final void e(ViewGroup r100, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsTreeAndAssignHub");
        Intrinsics.checkNotNullParameter(r101, "hub");
        IntRange r102 = RangesKt.until(0, r100.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r100.getChildAt(((IntIterator) r104).nextInt()));
        goto L4
    L6:
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L19;
        View r106 = (View) r105.next();
        if ((r106 instanceof ActionHubAccessor) == true) goto L12;
        Object r107 = null;
    L13:
        ActionHubAccessor r108 = (ActionHubAccessor) r107;
        if (r108 == null) goto L17;
        r108.setActionHub(r101);
    L17:
        if ((r106 instanceof ViewGroup) == false) goto L8;
        e((ViewGroup) r106, r101);
        goto L8
    L12:
        r107 = r106;
        goto L13
    }

    public static final void f(ViewGroup r100, Function1<? super ShowEvent, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsTreeAndLogShowEvent");
        Intrinsics.checkNotNullParameter(r101, "process");
        IntRange r102 = RangesKt.until(0, r100.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r100.getChildAt(((IntIterator) r104).nextInt()));
        goto L4
    L6:
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L24;
        View r106 = (View) r105.next();
        if ((r106 instanceof d) == true) goto L12;
        Object r107 = null;
    L13:
        d r108 = (d) r107;
        if (r108 == null) goto L22;
        List<ShowEvent> r109 = r108.showEvent();
        if (r109 == null) goto L22;
        Iterator<T> r110 = r109.iterator();
    L19:
        if (r110.hasNext() == false) goto L22;
        r101.invoke((ShowEvent) r110.next());
    L22:
        if ((r106 instanceof ViewGroup) == false) goto L8;
        f((ViewGroup) r106, r101);
        goto L8
    L12:
        r107 = r106;
        goto L13
    }

    public static final View g(ViewGroup r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsViewTag");
        IntRange r102 = RangesKt.until(0, r100.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r100.getChildAt(((IntIterator) r104).nextInt()));
        goto L4
    L6:
        Iterator r105 = r103.iterator();
    L7:
        View r106 = null;
        if (r105.hasNext() == false) goto L29;
        View r107 = (View) r105.next();
        if ((r107 instanceof e) == true) goto L12;
        Object r108 = null;
    L13:
        e r109 = (e) r108;
        if (r109 == null) goto L16;
        String r110 = r109.getViewTag();
    L18:
        if (Intrinsics.areEqual(r110, r101) == true) goto L19;
        if ((r107 instanceof ViewGroup) == false) goto L24;
        r106 = r107;
    L24:
        ViewGroup r111 = (ViewGroup) r106;
        if (r111 == null) goto L7;
        View r112 = g(r111, r101);
        if (r112 == null) goto L7;
        return r112;
    L19:
        return r107;
    L16:
        r110 = null;
        goto L18
    L12:
        r108 = r107;
        goto L13
    L29:
        return null;
    }

    public static final void i(View r100, ImageModel r101) {
        Intrinsics.checkNotNullParameter(r100, "theView");
        LocalImage r102 = null;
        if (r101 == null) goto L5;
        ECUrlModel r103 = r101.getRemote();
    L6:
        if (r103 != null) goto L8;
    L15:
        if (r101 == null) goto L17;
        r102 = r101.getLocal();
    L17:
        if (r102 != null) goto L19;
    L26:
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L29;
        r104.width = -2;
        r104.height = -2;
        r100.setLayoutParams(r104);
        return;
    L29:
        r100.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return;
    L19:
        if (r101.getLocal().getWidth() <= 0) goto L26;
        if (r101.getLocal().getHeight() <= 0) goto L26;
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if (r105 == null) goto L25;
        r105.width = vf4.a.b(Integer.valueOf(r101.getLocal().getWidth()));
        r105.height = vf4.a.b(Integer.valueOf(r101.getLocal().getHeight()));
        r100.setLayoutParams(r105);
        return;
    L25:
        r100.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(Integer.valueOf(r101.getLocal().getWidth())), vf4.a.b(Integer.valueOf(r101.getLocal().getHeight()))));
        return;
    L8:
        if (r101.getRemote().getWidth() <= 0) goto L15;
        if (r101.getRemote().getHeight() <= 0) goto L15;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if (r106 == null) goto L14;
        r106.width = vf4.a.b(Integer.valueOf(r101.getRemote().getWidth()));
        r106.height = vf4.a.b(Integer.valueOf(r101.getRemote().getHeight()));
        r100.setLayoutParams(r106);
        return;
    L14:
        r100.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(Integer.valueOf(r101.getRemote().getWidth())), vf4.a.b(Integer.valueOf(r101.getRemote().getHeight()))));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void j(View r100, final Background r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setBackground");
        String r102 = null;
        if (r101 == null) goto L5;
        Padding r103 = r101.getPadding();
    L6:
        Intrinsics.checkNotNullParameter(r100, "$this$setPadding");
        if (r103 == null) goto L9;
        r100.setPadding(vf4.a.b(Integer.valueOf(r103.getLeft())), vf4.a.b(Integer.valueOf(r103.getTop())), vf4.a.b(Integer.valueOf(r103.getRight())), vf4.a.b(Integer.valueOf(r103.getBottom())));
    L9:
        if (r101 == null) goto L11;
        ImageModel r104 = r101.getBackgroundImageModel();
    L12:
        if (r104 != null) goto L14;
        r100.setBackground(com.bytedance.commerce.base.drawable.a.a(new ExtensionsKt$setBackground$3(r101)));
        return;
    L14:
        if (r101.getBackgroundImageModel().getRemote() == null) goto L30;
        List<String> r105 = r101.getBackgroundImageModel().getRemote().getUrlList();
        if (r105 == null) goto L18;
        r102 = (String) CollectionsKt.firstOrNull(r105);
    L18:
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        WeakReference<Bitmap> r106 = f167878a.get(r102);
        if (r106 == null) goto L28;
        Bitmap r107 = r106.get();
        if (r107 == null) goto L28;
        Drawable r108 = h(r107, r100.getContext(), r101.getMaskColor());
        if (r108 == null) goto L38;
        r100.setBackground(r108);
        return;
    L38:
        return;
    L28:
        y.l(r101.getBackgroundImageModel().getRemote(), -1, -1, new a(r100, r101, r102));
        return;
    L30:
        if (r101.getBackgroundImageModel().getLocal() == null) goto L40;
        LocalImage r109 = r101.getBackgroundImageModel().getLocal();
        Context r110 = r100.getContext();
        String r111 = r101.getMaskColor();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (k.c(r111) == false) goto L34;
        Drawable r112 = new LayerDrawable(new Drawable[]{ImageExtensionsKt.b(r109, r110), new ColorDrawable(com.bytedance.android.shopping.extensions.a.a(r111, 0))});
    L35:
        r100.setBackground(r112);
        return;
    L34:
        r112 = ImageExtensionsKt.b(r109, r110);
        goto L35
    L40:
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static final View k(ViewGroup r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$trackSpecificViewWithRefId");
        Intrinsics.checkNotNullParameter(r101, "refId");
        IntRange r102 = RangesKt.until(0, r100.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r100.getChildAt(((IntIterator) r104).nextInt()));
        goto L4
    L6:
        Iterator r105 = r103.iterator();
    L7:
        View r106 = null;
        if (r105.hasNext() == false) goto L21;
        View r107 = (View) r105.next();
        if (Intrinsics.areEqual(r107.getTag(), r101) == true) goto L11;
        if ((r107 instanceof ViewGroup) == false) goto L16;
        r106 = r107;
    L16:
        ViewGroup r108 = (ViewGroup) r106;
        if (r108 == null) goto L7;
        View r109 = k(r108, r101);
        if (r109 == null) goto L7;
        return r109;
    L11:
        return r107;
    L21:
        return null;
    }

    public static final void c(ViewGroup r100, List r101, AnchorV4BaseInfoView$BaseInfoLayoutOnHierarchyChangeListener$onChildViewRemoved$$inlined$cacheSimpleDraweeView$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsFilterOutViews");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        View r104 = (View) r103.next();
        if (r102.invoke(r104).booleanValue() == true) goto L7;
        if ((r104 instanceof ViewGroup) == true) goto L11;
        r104 = null;
    L11:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L4;
        c(r105, r101, r102);
        goto L4
    L7:
        ((ArrayList) r101).add(r104);
        goto L4
    }

    public static final void d(ViewGroup r100, String r101, List<View> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$dfsGetViewsByTag");
        Intrinsics.checkNotNullParameter(r102, "result");
        IntRange r103 = RangesKt.until(0, r100.getChildCount());
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<Integer> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(r100.getChildAt(((IntIterator) r105).nextInt()));
        goto L4
    L6:
        Iterator r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L26;
        View r107 = (View) r106.next();
        if ((r107 instanceof e) == true) goto L12;
        Object r108 = null;
    L13:
        e r109 = (e) r108;
        if (r109 == null) goto L16;
        String r110 = r109.getViewTag();
    L18:
        if (Intrinsics.areEqual(r110, r101) == false) goto L21;
        ((ArrayList) r102).add(r107);
    L21:
        if ((r107 instanceof ViewGroup) == true) goto L23;
        r107 = null;
    L23:
        ViewGroup r111 = (ViewGroup) r107;
        if (r111 == null) goto L8;
        d(r111, r101, r102);
        goto L8
    L16:
        r110 = null;
        goto L18
    L12:
        r108 = r107;
        goto L13
    }

    public static final Drawable h(Bitmap r100, Context r101, String r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (k.c(r102) == false) goto L9;
        return new LayerDrawable(new Drawable[]{new BitmapDrawable(r101.getResources(), r100), new ColorDrawable(com.bytedance.android.shopping.extensions.a.a(r102, 0))});
    L9:
        return new BitmapDrawable(r101.getResources(), r100);
    }
}
