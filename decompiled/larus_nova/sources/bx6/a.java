package bx6;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.utils.e;
import com.bytedance.locallife.pdp.groupondetail.view.ContentViewWithUnit;
import com.bytedance.locallife.pdp.groupondetail.view.HalfScreenTagView;
import com.bytedance.locallife.pdp.groupondetail.view.SimpleContentView;
import com.bytedance.locallife.pdp.groupondetail.view.SimpleTitleView;
import com.bytedance.locallife.pdp.groupondetail.view.SplitTitleView;
import com.bytedance.locallife.pdp.groupondetail.view.StructContentInBorderView;
import com.bytedance.locallife.pdp.groupondetail.view.StructContentView;
import com.bytedance.locallife.pdp.groupondetail.view.StructContentViewWithBorder;
import com.bytedance.locallife.pdp.groupondetail.vo.CommonContentVOType;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.b;
import dx6.c;
import dx6.f;
import dx6.h;
import dx6.i;
import dx6.j;
import dx6.l;
import dx6.m;
import dx6.n;
import dx6.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final float b() {
        float r100 = 100;
        float r101 = (e.d(Double.valueOf(com.bytedance.locallife.biz.common.utils.e.b())) / 375.0f) * r100;
        if (r101 > 98) goto L6;
        return 0.96f;
    L6:
        if (r101 > r100) goto L9;
        return 1.0f;
    L9:
        if (r101 > 106) goto L11;
        return 1.04f;
    L11:
        return 1.15f;
    }

    public static final int c(int r100) {
        return MathKt.roundToInt(r100 * b());
    }

    public static final c d(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.i();
        int r102 = CommonContentVOType.TYPE_1.getType();
        if (r101 != null) goto L6;
    L8:
        int r103 = CommonContentVOType.TYPE_2.getType();
        if (r101 != null) goto L12;
    L14:
        int r104 = CommonContentVOType.TYPE_3.getType();
        if (r101 != null) goto L18;
    L20:
        int r105 = CommonContentVOType.TYPE_4.getType();
        if (r101 != null) goto L24;
    L26:
        int r106 = CommonContentVOType.TYPE_5.getType();
        if (r101 != null) goto L30;
    L32:
        int r107 = CommonContentVOType.TYPE_6.getType();
        if (r101 != null) goto L36;
    L38:
        int r108 = CommonContentVOType.TYPE_7.getType();
        if (r101 != null) goto L42;
    L44:
        int r109 = CommonContentVOType.TYPE_8.getType();
        if (r101 != null) goto L48;
    L50:
        return null;
    L48:
        if (r101.intValue() != r109) goto L50;
        return r100.h();
    L42:
        if (r101.intValue() != r108) goto L44;
        return r100.g();
    L36:
        if (r101.intValue() != r107) goto L38;
        return r100.f();
    L30:
        if (r101.intValue() != r106) goto L32;
        return r100.e();
    L24:
        if (r101.intValue() != r105) goto L26;
        return r100.d();
    L18:
        if (r101.intValue() != r104) goto L20;
        return r100.c();
    L12:
        if (r101.intValue() != r103) goto L14;
        return r100.b();
    L6:
        if (r101.intValue() != r102) goto L8;
        return r100.a();
    }

    public static final View a(j r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r102 = r100.i();
        int r103 = CommonContentVOType.TYPE_1.getType();
        int r104 = 0;
        int r105 = 6;
        AttributeSet r106 = null;
        if (r102 != null) goto L6;
    L11:
        int r107 = CommonContentVOType.TYPE_2.getType();
        if (r102 != null) goto L15;
    L19:
        int r108 = CommonContentVOType.TYPE_3.getType();
        if (r102 != null) goto L23;
    L27:
        int r109 = CommonContentVOType.TYPE_4.getType();
        if (r102 != null) goto L31;
    L35:
        int r110 = CommonContentVOType.TYPE_5.getType();
        if (r102 != null) goto L39;
    L43:
        int r111 = CommonContentVOType.TYPE_6.getType();
        if (r102 != null) goto L47;
    L51:
        int r112 = CommonContentVOType.TYPE_7.getType();
        if (r102 != null) goto L55;
    L59:
        int r113 = CommonContentVOType.TYPE_8.getType();
        if (r102 != null) goto L63;
        return null;
    L63:
        if (r102.intValue() != r113) goto L75;
        f r114 = r100.h();
        if (r114 == null) goto L76;
        HalfScreenTagView r115 = new HalfScreenTagView(r101, null, 6, 0);
        r115.setVO(r114);
        View r116 = r115;
    L68:
        return r116;
    L76:
        return null;
    L75:
        return null;
    L55:
        if (r102.intValue() != r112) goto L59;
        m r117 = r100.g();
        if (r117 == null) goto L74;
        StructContentInBorderView r118 = new StructContentInBorderView(r101, r106, r105, r104);
        r118.setVO(r117);
        r116 = r118;
        goto L68
    L74:
        return null;
    L47:
        if (r102.intValue() != r111) goto L51;
        o r119 = r100.f();
        if (r119 == null) goto L73;
        StructContentViewWithBorder r120 = new StructContentViewWithBorder(r101, null, 6, 0);
        r120.setVO(r119);
        r116 = r120;
        goto L68
    L73:
        return null;
    L39:
        if (r102.intValue() != r110) goto L43;
        b r121 = r100.e();
        if (r121 == null) goto L72;
        ContentViewWithUnit r122 = new ContentViewWithUnit(r101, null, 6, 0);
        r122.setVO(r121);
        r116 = r122;
        goto L68
    L72:
        return null;
    L31:
        if (r102.intValue() != r109) goto L35;
        h r123 = r100.d();
        if (r123 == null) goto L71;
        SimpleContentView r124 = new SimpleContentView(r101, null, 6, 0);
        r124.setVO(r123);
        r116 = r124;
        goto L68
    L71:
        return null;
    L23:
        if (r102.intValue() != r108) goto L27;
        n r125 = r100.c();
        if (r125 == null) goto L70;
        StructContentView r126 = new StructContentView(r101, r106, r105, r104);
        r126.setVO(r125);
        r116 = r126;
        goto L68
    L70:
        return null;
    L15:
        if (r102.intValue() != r107) goto L19;
        l r127 = r100.b();
        if (r127 == null) goto L69;
        SplitTitleView r128 = new SplitTitleView(r101, null, 6, 0);
        r128.setVO(r127);
        r116 = r128;
        goto L68
    L69:
        return null;
    L6:
        if (r102.intValue() != r103) goto L11;
        i r129 = r100.a();
        if (r129 == null) goto L67;
        SimpleTitleView r130 = new SimpleTitleView(r101, null, 6, 0);
        r130.setVO(r129);
        r116 = r130;
        goto L68
    L67:
        return null;
    }

    public static final void e(DuxTextView r100, float r101) {
        if (r100 == null) goto L5;
        r100.setTextSize(2, r101 * b());
        return;
    }

    public static final void f(DuxTextView r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r100.setTypeface(Typeface.create(r100.getTypeface(), r101, false));
        return;
    }
}
