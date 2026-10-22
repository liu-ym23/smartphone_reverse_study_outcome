package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.util.AttributeSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.commentv3.data.SliceHeight;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/RoundFrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommentSliceView extends RoundFrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f172940f;

    public CommentSliceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentSliceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int c(int r100) {
        r r101 = this.f172940f;
        if (r101 == null) goto L8;
        SlcTemplateContext r102 = r101.f50700b;
        if (r102 == null) goto L8;
        return SlcDimensExtensionsKt.a(Integer.valueOf(r100), r102.m());
    L8:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r100));
    }

    public CommentSliceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public final void a(Map<String, ? extends Object> r100, int r101, int r102) {
        if (r100 == null) goto L4;
        Integer r103 = Integer.valueOf(nc3.a.b(r100, "height", 0));
    L5:
        int r104 = SliceHeight.MATCH_PARENT.getHeight();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.intValue() != r104) goto L15;
        int r105 = r102 - r101;
        if (r105 <= 0) goto L13;
        nc3.b.a(this, r105, CommentSliceView$onFilterCardHeightChanged$1.INSTANCE);
        return;
    L13:
        nc3.b.a(this, r103.intValue(), new CommentSliceView$onFilterCardHeightChanged$2(this));
        return;
    L15:
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final void b(Map<String, ? extends Object> r110, int r111, int r112) {
        Object r100 = null;
        if (r110 == null) goto L5;
        Object r101 = r110.get(GXTemplateKey.FLEXBOX_MARGIN);
    L6:
        nc3.b.b(this, r101, new CommentSliceView$setCardStyle$1(this));
        if (r110 == null) goto L9;
        Object r102 = r110.get(GXTemplateKey.FLEXBOX_PADDING);
    L10:
        nc3.b.c(this, r102, new CommentSliceView$setCardStyle$2(this));
        if (r110 == null) goto L13;
        Object r103 = r110.get("radius");
    L14:
        CommentSliceView$setCardStyle$3 r104 = new CommentSliceView$setCardStyle$3(this);
        Intrinsics.checkNotNullParameter(this, "$this$setRadius");
        Intrinsics.checkNotNullParameter(r104, "toSlcDp");
        float r105 = 0.0f;
        boolean r106 = true;
        if (r103 != null) goto L17;
    L48:
        this.f172964b = 0.0f;
        this.f172965c = 0.0f;
        this.f172966d = 0.0f;
        this.f172967e = 0.0f;
        invalidate();
    L49:
        if (r110 == null) goto L51;
        int r107 = nc3.a.b(r110, "height", 0);
    L52:
        int r113 = r112 - r111;
        if (r107 != SliceHeight.MATCH_PARENT.getHeight()) goto L56;
        if (r113 <= 0) goto L56;
        nc3.b.a(this, r113, CommentSliceView$setCardStyle$4.INSTANCE);
    L57:
        if (r110 == null) goto L59;
        Object r114 = r110.get("bg_color");
    L61:
        if ((r114 instanceof String) == false) goto L64;
        r100 = r114;
    L64:
        String r108 = (String) r100;
        if (r108 != null) goto L67;
    L70:
        if (r106 == true) goto L72;
        setBackgroundColor(ColorProtector.parseColor(r108));
        return;
    L72:
        setBackgroundColor(0);
        return;
    L67:
        if (r108.length() == 0) goto L70;
        r106 = false;
        goto L70
    L59:
        r114 = null;
    L56:
        nc3.b.a(this, r107, new CommentSliceView$setCardStyle$5(this));
        goto L57
    L51:
        r107 = 0;
        goto L52
    L17:
        if ((r103 instanceof List) == false) goto L48;
        List<Integer> r109 = nc3.a.f((List) r103);
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r116 = ((ArrayList) r109).iterator();
    L21:
        if (r116.hasNext() == false) goto L23;
        r115.add(Float.valueOf(r104.invoke(Integer.valueOf(((Number) r116.next()).intValue())).intValue()));
        goto L21
    L23:
        int r117 = r115.size();
        if (r117 != 1) goto L26;
        Float r118 = (Float) CollectionsKt.getOrNull(r115, 0);
        if (r118 == null) goto L47;
        r105 = r118.floatValue();
    L47:
        this.f172964b = r105;
        this.f172965c = r105;
        this.f172966d = r105;
        this.f172967e = r105;
        invalidate();
        goto L49
    L26:
        if (r117 == 4) goto L28;
        this.f172964b = 0.0f;
        this.f172965c = 0.0f;
        this.f172966d = 0.0f;
        this.f172967e = 0.0f;
        invalidate();
        goto L49
    L28:
        Float r119 = (Float) CollectionsKt.getOrNull(r115, 0);
        if (r119 == null) goto L31;
        float r120 = r119.floatValue();
    L32:
        Float r121 = (Float) CollectionsKt.getOrNull(r115, 1);
        if (r121 == null) goto L35;
        float r122 = r121.floatValue();
    L36:
        Float r123 = (Float) CollectionsKt.getOrNull(r115, 2);
        if (r123 == null) goto L39;
        float r124 = r123.floatValue();
    L40:
        Float r125 = (Float) CollectionsKt.getOrNull(r115, 3);
        if (r125 == null) goto L43;
        r105 = r125.floatValue();
    L43:
        this.f172964b = r120;
        this.f172965c = r122;
        this.f172966d = r124;
        this.f172967e = r105;
        invalidate();
        goto L49
    L39:
        r124 = 0.0f;
        goto L40
    L35:
        r122 = 0.0f;
        goto L36
    L31:
        r120 = 0.0f;
        goto L32
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public /* synthetic */ CommentSliceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
