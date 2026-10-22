package ccc;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.columns.entity.ColumnsCellData;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.columns.view.ColumnsView;
import com.ss.android.lark.widget.columns.view.ColumnsViewLinearLayout;
import com.ss.android.lark.widget.light.e;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mcc.f;
import mcc.m;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements kcc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f23352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f23353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ColumnsInfo f23354c;

    /* JADX INFO: renamed from: ccc.a$a, reason: collision with other inner class name */
    public static final class C0432a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ColumnsViewLinearLayout f23355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ColumnsInfo f23356b;

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            Object r101 = this.f23355a.getTag(R.id.tag_span_container_view);
            if ((r101 instanceof m) == true) goto L5;
            return;
        L5:
            if ((r101 instanceof View) == false) goto L9;
            ((f) r101).q((View) r101, this.f23356b);
            return;
        }

        public C0432a(ColumnsViewLinearLayout r100, ColumnsInfo r101) {
            this.f23355a = r100;
            this.f23356b = r101;
        }
    }

    @Override // kcc.a
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        ColumnsViewLinearLayout r111 = (ColumnsViewLinearLayout) r110;
        e r100 = this.f23352a;
        Context r101 = this.f23353b;
        ColumnsInfo r102 = this.f23354c;
        int r103 = r100.M;
        if (r103 <= 0) goto L5;
        int r104 = r103 - 1;
    L6:
        if (r102 != null) goto L8;
        r111.getClass();
    L40:
        r111.setOnClickListener(new C0432a(r111, r102));
        return;
    L8:
        if (r104 <= 0) goto L11;
        r111.f445735b = r104;
    L11:
        if (r111.f445735b == 0) goto L40;
        r111.f445736c = dcc.a.a(r102.getColumnsWidthRatio(), r111.f445735b);
        if (r102.isValid() == false) goto L33;
        LinkedList<Integer> r105 = r102.getColumnsWidthRatio();
        int r106 = 0;
        if (r105 == null) goto L19;
        int r107 = r105.size();
    L20:
        float r108 = r111.f445735b - ((r107 - 1) * 6.0f);
        r102.setDownGradeColumnsWidthRatioIfNeed();
        if (r105 == null) goto L33;
        ArrayList r109 = new ArrayList();
        int r112 = CollectionsKt.sumOfInt(r105);
        int r113 = r105.size();
    L23:
        if (r106 >= r113) goto L34;
        float r114 = r105.get(r106).intValue() / r112;
        if (r111.f445736c == false) goto L27;
        Number r115 = Integer.valueOf(r111.f445735b);
    L28:
        HashMap<Integer, Layout> r116 = r102.getColumnsContentLayout();
        if (r116 == null) goto L31;
        Layout r117 = r116.get(Integer.valueOf(r106));
    L32:
        r109.add(new ColumnsCellData(r117, UIUtils.dp2px(r111.getContext(), r115.floatValue())));
        r106 = r106 + 1;
        goto L23
    L31:
        r117 = null;
        goto L32
    L27:
        r115 = Float.valueOf(r114 * r108);
    L34:
        ecc.b r118 = new ecc.b(r111.getContext(), r109);
        r118.f472169d = null;
        r118.f472170e = null;
        r118.f472171f = null;
        r118.f472172g = null;
        r118.f472173h = null;
        r118.f472174i = null;
        r118.f472175j = null;
        ColumnsView r119 = r111.f445734a;
        if (r119 == null) goto L37;
        r119.setLinearLayoutOrientation(r111.f445736c);
    L37:
        ColumnsView r120 = r111.f445734a;
        if (r120 == null) goto L40;
        r120.setColumnsAdapter(r118);
        goto L40
    L19:
        r107 = 0;
    L33:
        r109 = null;
        goto L34
    L5:
        r104 = UIUtils.px2dp(r101, r100.f445982J);
        goto L6
    }

    @Override // kcc.a
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ColumnsViewLinearLayout(r100, null);
    }

    public a(e r100, Context r101, ColumnsInfo r102) {
        this.f23352a = r100;
        this.f23353b = r101;
        this.f23354c = r102;
    }
}
