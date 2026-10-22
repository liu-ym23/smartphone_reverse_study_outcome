package bx2;

import android.graphics.Paint;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21341d;

    @Override // bx2.a
    public final String h() {
        return Segment.JsonKey.START;
    }

    public p() {
        this.f21339b = "";
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.f16614b.setStyle(Paint.Style.STROKE);
        r100.f16614b.setColor(r100.f16616d.f16617a);
        r100.f16614b.setAlpha(r100.f16616d.f16619c);
        float r101 = a.a(r100.f16616d.f16620d, this.f21341d, r100.f16614b);
        r100.a().drawText(this.f21339b, this.f21340c, r101, r100.f16614b);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21340c = a.c(r100, "x");
        this.f21341d = a.c(r100, "y");
        Object r102 = r100.get("text");
        if (r102 == null) goto L6;
        String r103 = r102.toString();
        if (r103 == null) goto L6;
    L7:
        this.f21339b = r103;
        return;
    L6:
        r103 = "";
        goto L7
    }
}
