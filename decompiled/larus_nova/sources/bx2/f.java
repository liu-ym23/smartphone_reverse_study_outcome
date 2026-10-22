package bx2;

import android.graphics.Paint;
import android.graphics.Rect;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f21292e;

    @Override // bx2.a
    public final String h() {
        return "fr";
    }

    public f() {
        this.f21292e = new Rect();
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.f16614b.setStyle(Paint.Style.FILL);
        r100.f16614b.setColor(r100.f16616d.f16618b);
        r100.f16614b.setAlpha(r100.f16616d.f16619c);
        r100.a().drawRect(this.f21292e, r100.f16614b);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21289b = a.e(r100, "x");
        this.f21290c = a.e(r100, "y");
        this.f21291d = a.e(r100, "w");
        int r102 = a.e(r100, "h");
        Rect r103 = this.f21292e;
        int r104 = this.f21289b;
        r103.left = r104;
        r103.right = r104 + this.f21291d;
        int r105 = this.f21290c;
        r103.top = r105;
        r103.bottom = r105 + r102;
    }
}
