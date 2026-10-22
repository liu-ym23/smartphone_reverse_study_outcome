package ax2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import bx2.d;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f16610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f16611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f16612c;

    public final d getCommandProvider() {
        return this.f16610a;
    }

    public final b getDrawContext() {
        return this.f16611b;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        b r101 = new b();
        this.f16611b = r101;
        Resources r102 = r100.getResources();
        this.f16612c = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        r101.f16616d.f16628l = this;
    }

    public final void a(List<? extends bx2.a> r100) {
        if ((!r100.isEmpty()) == false) goto L8;
        Iterator<? extends bx2.a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        r101.next().b(this.f16611b);
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        b r101 = this.f16611b;
        r101.f16614b.clearShadowLayer();
        ((ArrayList) r101.f16616d.f16626j).clear();
        b r102 = this.f16611b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f16613a = r100;
        Canvas r103 = this.f16611b.a();
        float r104 = this.f16612c;
        r103.scale(r104, r104);
        d r105 = this.f16610a;
        if (r105 == null) goto L6;
        a(r105.a());
        a(r105.b());
        return;
    }

    public final void setCommandProvider(d r100) {
        this.f16610a = r100;
    }
}
