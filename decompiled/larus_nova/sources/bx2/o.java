package bx2;

import android.graphics.Paint;
import android.graphics.Rect;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f21338e;

    @Override // bx2.a
    public final String h() {
        return IVideoEventLogger.FEATURE_KEY_SR;
    }

    public o() {
        this.f21338e = new Rect();
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.f16614b.setStyle(Paint.Style.STROKE);
        r100.f16614b.setColor(r100.f16616d.f16617a);
        r100.f16614b.setAlpha(r100.f16616d.f16619c);
        r100.a().drawRect(this.f21338e, r100.f16614b);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21335b = a.e(r100, "x");
        this.f21336c = a.e(r100, "y");
        this.f21337d = a.e(r100, "w");
        int r102 = a.e(r100, "h");
        Rect r103 = this.f21338e;
        int r104 = this.f21335b;
        r103.left = r104;
        r103.right = r104 + this.f21337d;
        int r105 = this.f21336c;
        r103.top = r105;
        r103.bottom = r105 + r102;
    }
}
