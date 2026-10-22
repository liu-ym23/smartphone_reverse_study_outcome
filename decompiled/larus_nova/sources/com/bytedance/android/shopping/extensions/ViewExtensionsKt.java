package com.bytedance.android.shopping.extensions;

import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ViewExtensionsKt {

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f174288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f174289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f174290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f174291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f174292e;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r110) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r110, "outline");
            float r101 = Math.min(Math.min(r100.getWidth(), r100.getHeight()) / 2, this.f174288a);
            float r102 = this.f174289b;
            float r103 = 0;
            if (r102 <= r103) goto L5;
        L8:
            int r104 = 0;
        L10:
            if (r102 <= r103) goto L12;
        L15:
            int r105 = 0;
        L17:
            if (this.f174291d <= r103) goto L19;
        L22:
            int r106 = r100.getWidth();
        L23:
            int r107 = r106;
            if (this.f174290c <= r103) goto L26;
        L29:
            int r108 = r100.getHeight();
        L30:
            r110.setRoundRect(r104, r105, r107, r108, r101);
            return;
        L26:
            if (this.f174292e > r103) goto L29;
            r108 = r100.getHeight() + ((int) r101);
            goto L30
        L19:
            if (this.f174292e > r103) goto L22;
            r106 = r100.getWidth() + ((int) r101);
            goto L23
        L12:
            if (this.f174291d > r103) goto L15;
            r105 = -((int) r101);
            goto L17
        L5:
            if (this.f174290c > r103) goto L8;
            r104 = -((int) r101);
            goto L10
        }

        public a(float r100, float r101, float r102, float r103, float r104) {
            this.f174288a = r100;
            this.f174289b = r101;
            this.f174290c = r102;
            this.f174291d = r103;
            this.f174292e = r104;
        }
    }

    public static final void d(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$scrollToTop");
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L22;
        Integer r102 = Integer.valueOf(r101.getItemCount());
        if (r102.intValue() <= 0) goto L7;
        boolean r103 = true;
    L8:
        RecyclerView.LayoutManager r104 = null;
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L23;
        r102.intValue();
        RecyclerView.LayoutManager r105 = r100.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L17;
        r104 = r105;
    L17:
        LinearLayoutManager r106 = (LinearLayoutManager) r104;
        if (r106 == null) goto L20;
        r106.scrollToPositionWithOffset(0, 0);
        return;
    L20:
        r100.scrollToPosition(0);
        return;
    L23:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static void i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$showWithAnimAlpha");
        r100.animate().cancel();
        r100.setVisibility(0);
        r100.animate().alpha(1.0f).setListener(null).setDuration(200).start();
    }

    public static final View b(ViewGroup r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$findFirst");
        Intrinsics.checkNotNullParameter(r101, "predict");
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r100.getChildAt(r103);
        if (((Boolean) r101.invoke(r104)).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static final void h(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTextSizeDp");
        r100.setTextSize(1, r101);
    }

    public static final View j(ViewGroup r100, String r101) {
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
        View r109 = j(r108, r101);
        if (r109 == null) goto L7;
        return r109;
    L11:
        return r107;
    L21:
        return null;
    }

    public static final View a(ViewGroup r100, final float r101, final float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$findChildUnder");
        return b(r100, new ViewExtensionsKt$findChildUnder$1(r101, r102));
    }

    public static void c(View r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        long r103 = 200;
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "$this$hideWithAnimAlpha");
        r100.animate().cancel();
        r100.animate().alpha(0.0f).setDuration(r103).setListener(new l(r100, r101)).start();
        return;
    L5:
        r103 = 0;
        goto L7
    }

    public static final void e(TextView r100, Paint r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setFontWeight");
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 <= 1000) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        if (r101 == null) goto L20;
        Typeface r103 = r101.getTypeface();
        Typeface r104 = r101.getTypeface();
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        r101.setTypeface(Typeface.create(r103, r102, r105));
        return;
    L13:
        if (r104.getStyle() != 2) goto L15;
        r105 = true;
        goto L16
    L20:
        return;
    }

    public static /* synthetic */ void g(View r100, float r101, float r102, float r103, float r110) {
        f(r100, r101, r102, r103, r110, true);
    }

    public static final void f(View r100, float r101, float r102, float r103, float r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRadius");
        if (r111 == false) goto L5;
        r101 = q.a(Float.valueOf(r101));
    L5:
        float r104 = r101;
        if (r111 == false) goto L8;
        r102 = q.a(Float.valueOf(r102));
    L8:
        float r105 = r102;
        if (r111 == false) goto L11;
        r103 = q.a(Float.valueOf(r103));
    L11:
        float r106 = r103;
        if (r111 == false) goto L14;
        r110 = q.a(Float.valueOf(r110));
    L14:
        float r107 = r110;
        Float r108 = ArraysKt.maxOrNull(new float[]{r104, r105, r106, r107});
        if (r108 == null) goto L17;
        float r109 = r108.floatValue();
    L19:
        if (r109 <= 0) goto L21;
        r100.setClipToOutline(true);
        r100.setOutlineProvider(new a(r109, r104, r107, r105, r106));
        return;
    L21:
        r100.setClipToOutline(false);
        r100.setOutlineProvider(null);
        return;
    L17:
        r109 = 0.0f;
        goto L19
    }
}
