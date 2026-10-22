package bx2;

import android.graphics.Paint;
import android.graphics.Path;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends bx2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f21330c;

    public static final class a {
    }

    static {
    }

    @Override // bx2.a
    public final String h() {
        return "pas";
    }

    public k() {
    }

    public static void i(ax2.c r100) {
        if (((ArrayList) r100.f16626j).isEmpty() == false) goto L8;
        List<Path> r101 = r100.f16626j;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new Path());
        if (r100.f16625i == false) goto L9;
        r100.f16625i = false;
        return;
    L9:
        return;
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Path r101 = this.f21330c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f21329b != 0) goto L7;
        r100.f16614b.setStyle(Paint.Style.FILL);
        r100.f16614b.setColor(r100.f16616d.f16618b);
        r100.f16614b.setAlpha(r100.f16616d.f16619c);
        r100.a().drawPath(r101, r100.f16614b);
        return;
    L7:
        r100.f16614b.setStyle(Paint.Style.STROKE);
        r100.f16614b.setColor(r100.f16616d.f16617a);
        r100.f16614b.setAlpha(r100.f16616d.f16619c);
        r100.a().drawPath(r101, r100.f16614b);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r110, ax2.c r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "dataManager");
        Object r100 = r110.get(Segment.JsonKey.START);
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (Intrinsics.areEqual(r100, "bp") == false) goto L9;
        ((ArrayList) r111.f16626j).add(new Path());
        return;
    L9:
        if (Intrinsics.areEqual(r100, "mt") == false) goto L12;
        i(r111);
        ((Path) CollectionsKt.last(r111.f16626j)).moveTo(bx2.a.c(r110, "x"), bx2.a.c(r110, "y"));
        return;
    L12:
        if (Intrinsics.areEqual(r100, "cp") == false) goto L15;
        ((Path) CollectionsKt.last(r111.f16626j)).close();
        return;
    L15:
        if (Intrinsics.areEqual(r100, "lt") == false) goto L18;
        ((Path) CollectionsKt.last(r111.f16626j)).lineTo(bx2.a.c(r110, "x"), bx2.a.c(r110, "y"));
        return;
    L18:
        if (Intrinsics.areEqual(r100, RTLUtil.ARABIA_LANG) == false) goto L21;
        float r101 = bx2.a.c(r110, "x");
        float r102 = bx2.a.c(r110, "y");
        float r103 = bx2.a.c(r110, "r");
        double r104 = 180;
        double r105 = (((double) bx2.a.c(r110, "sAngle")) / 3.141592653589793d) * r104;
        double r106 = ((((double) bx2.a.c(r110, "eAngle")) / 3.141592653589793d) * r104) - r105;
        float r112 = r101 + r103;
        float r107 = r102 + r103;
        r111.f16629m.set(r101 - r103, r102 - r103, r112, r107);
        ((Path) CollectionsKt.last(r111.f16626j)).addArc(r111.f16629m, (float) r105, (float) r106);
        return;
    L21:
        if (Intrinsics.areEqual(r100, INotificationHitPoint.NoticeType.AT) == false) goto L24;
        float r108 = bx2.a.c(r110, "x1");
        float r109 = bx2.a.c(r110, "y1");
        float r113 = bx2.a.c(r110, "x2");
        float r114 = bx2.a.c(r110, "y2");
        bx2.a.c(r110, "r");
        ((Path) CollectionsKt.last(r111.f16626j)).quadTo(r108, r109, r113, r114);
        return;
    L24:
        if (Intrinsics.areEqual(r100, "qc") == false) goto L27;
        ((Path) CollectionsKt.last(r111.f16626j)).quadTo(bx2.a.c(r110, "cpx"), bx2.a.c(r110, "cpy"), bx2.a.c(r110, "x"), bx2.a.c(r110, "y"));
        return;
    L27:
        if (Intrinsics.areEqual(r100, "bc") == false) goto L30;
        ((Path) CollectionsKt.last(r111.f16626j)).cubicTo(bx2.a.c(r110, "cp1x"), bx2.a.c(r110, "cp1y"), bx2.a.c(r110, "cp2x"), bx2.a.c(r110, "cp2y"), bx2.a.c(r110, "x"), bx2.a.c(r110, "y"));
        return;
    L30:
        if (Intrinsics.areEqual(r100, "rc") == false) goto L33;
        float r115 = bx2.a.c(r110, "x");
        float r116 = bx2.a.c(r110, "y");
        float r117 = bx2.a.c(r110, "w");
        float r118 = bx2.a.c(r110, "h");
        i(r111);
        ((Path) CollectionsKt.last(r111.f16626j)).addRect(r115, r116, r115 + r117, r116 + r118, Path.Direction.CW);
        return;
    L33:
        if (Intrinsics.areEqual(r100, Segment.JsonKey.START) == false) goto L36;
        this.f21329b = 1;
        this.f21330c = (Path) CollectionsKt.last(r111.f16626j);
        return;
    L36:
        if (Intrinsics.areEqual(r100, "fi") == false) goto L49;
        this.f21329b = 0;
        this.f21330c = (Path) CollectionsKt.last(r111.f16626j);
        return;
    }
}
