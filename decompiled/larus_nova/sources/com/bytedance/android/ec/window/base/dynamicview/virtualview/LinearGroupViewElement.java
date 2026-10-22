package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.window.base.dynamicview.common.ECRoundedConstraintLayout;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LinearGroupViewElement<LP extends ViewGroup.LayoutParams> extends UIViewGroup<ECRoundedConstraintLayout, LP, ConstraintLayout.LayoutParams, b> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final vo.b<ECRoundedConstraintLayout> f49275o = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f49276n;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/window/base/dynamicview/virtualview/LinearGroupViewElement$b;", "", "", "orientation", "Ljava/lang/String;", "getOrientation", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("orientation")
        private final String orientation;

        public final boolean a() {
            return Intrinsics.areEqual(this.orientation, "vertical");
        }

        public b() {
            this.orientation = null;
        }
    }

    public final boolean g() {
        return ((Boolean) this.f49276n.getValue()).booleanValue();
    }

    static {
        f49275o = new vo.b(LinearGroupViewElement$Companion$constraintGroupMaker$1.INSTANCE);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.UIViewGroup
    public final b f() {
        return (b) uo.a.a(this.f49286l, b.class);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.k
    public final void e(View r110) {
        ECRoundedConstraintLayout r111 = (ECRoundedConstraintLayout) r110;
        Intrinsics.checkNotNullParameter(r111, BaseSwitches.V);
        super.e(r111);
        float r100 = this.f49319c.f49309c;
        if (r100 <= 0) goto L5;
        r111.setRadius(r100);
    L5:
        Iterator r101 = this.f49287m.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((k) r101.next()).f49320d, "expander") == true) goto L13;
        r102 = r102 + 1;
    L13:
        Iterator r103 = this.f49287m.iterator();
        int r104 = 0;
    L15:
        if (r103.hasNext() == false) goto L73;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        k r107 = (k) r105;
        View r108 = r107.d(r111.getContext(), false);
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r107.b(r107.f49319c);
        if (Intrinsics.areEqual(r107.f49320d, "expander") == true) goto L22;
    L25:
        if (r102 < 0) goto L29;
        if (r104 <= r102) goto L29;
        boolean r112 = true;
    L30:
        k r113 = (k) CollectionsKt.getOrNull(this.f49287m, r104 - 1);
        k r114 = (k) CollectionsKt.getOrNull(this.f49287m, r106);
        if (Intrinsics.areEqual(r113, r107) == true) goto L72;
        if (r112 == false) goto L35;
        float r115 = 1.0f;
    L37:
        if (g() == false) goto L39;
        r109.verticalBias = r115;
    L40:
        if (r113 == null) goto L42;
        int r116 = r113.f49318b;
    L43:
        if (r113 != null) goto L49;
        if (g() == false) goto L47;
        r109.topToTop = r116;
    L52:
        if (r114 == null) goto L54;
        int r117 = r114.f49318b;
    L55:
        if (r114 != null) goto L61;
        if (g() == false) goto L59;
        r109.bottomToBottom = r117;
    L65:
        if (g() == false) goto L70;
        if (((ViewGroup.MarginLayoutParams) r109).height != (-1)) goto L72;
        ((ViewGroup.MarginLayoutParams) r109).height = 0;
        goto L72
    L70:
        if (((ViewGroup.MarginLayoutParams) r109).width != (-1)) goto L72;
        ((ViewGroup.MarginLayoutParams) r109).width = 0;
        goto L72
    L59:
        r109.rightToRight = r117;
        goto L65
    L61:
        if (g() == false) goto L63;
        r109.bottomToTop = r117;
        goto L65
    L63:
        r109.rightToLeft = r117;
        goto L65
    L54:
        r117 = 0;
        goto L55
    L47:
        r109.leftToLeft = r116;
        goto L52
    L49:
        if (g() == false) goto L51;
        r109.topToBottom = r116;
        goto L52
    L51:
        r109.leftToRight = r116;
        goto L52
    L42:
        r116 = 0;
        goto L43
    L39:
        r109.horizontalBias = r115;
        goto L40
    L35:
        r115 = 0.0f;
    L72:
        r107.a(this.f49284j.getValue(), r109, this.f49287m);
        r111.addView(r108, r109);
        r104 = r106;
    L29:
        r112 = false;
        goto L30
    L22:
        if (g() == false) goto L24;
        ((ViewGroup.MarginLayoutParams) r109).height = 0;
        goto L25
    L24:
        ((ViewGroup.MarginLayoutParams) r109).width = 0;
        goto L25
    L73:
        return;
    L12:
        r102 = -1;
        goto L13
    }

    public LinearGroupViewElement(String r110, j r111, JsonObject r112, int r113, g<LP, Object> r114, List<? extends k<? extends View, ConstraintLayout.LayoutParams>> r115) {
        Intrinsics.checkNotNullParameter(r110, "uniqueId");
        Intrinsics.checkNotNullParameter(r111, "uiParam");
        Intrinsics.checkNotNullParameter(r114, "filler");
        Intrinsics.checkNotNullParameter(r115, "uiViewElements");
        super(r110, r113, r111, f49275o, r112, "linear_group", r114, r115);
        this.f49276n = LazyKt.lazy(new LinearGroupViewElement$isVertical$2(this));
    }
}
