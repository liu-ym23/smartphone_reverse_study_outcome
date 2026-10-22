package ccc;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.light.e;
import com.ss.android.lark.widget.light.processor.j;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.span.SpanInfo;
import kcc.c;
import kotlin.jvm.internal.Intrinsics;
import ncc.g;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j<ColumnsInfo> {
    public b() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, g r101, SpanInfo r102, e r103) {
        ColumnsInfo r104 = (ColumnsInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        int r105 = r101.length();
        String r106 = r104.text;
        a r107 = new a(r103, r100, r104);
        Intrinsics.checkNotNull(r106);
        c.a(r101, r107, r106);
        r101.setSpan(new p(r104, r106), r105, r106.length() + r105, 33);
    }
}
