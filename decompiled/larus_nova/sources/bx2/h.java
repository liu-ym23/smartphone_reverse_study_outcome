package bx2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends bx2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f21299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f21300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f21301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f21302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f21303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f21304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21305k;

    public static final class a {
    }

    static {
    }

    @Override // bx2.a
    public final String h() {
        return "im";
    }

    public h() {
        this.f21296b = 1;
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bitmap r101 = r100.f16616d.f16627k.get(this.f21297c);
        if (r101 == null) goto L14;
        int r102 = this.f21296b;
        if (r102 != 0) goto L8;
        r100.a().drawBitmap(r101, this.f21298d, this.f21299e, r100.f16614b);
        return;
    L8:
        if (r102 != 1) goto L11;
        Canvas r103 = r100.a();
        float r104 = this.f21298d;
        float r105 = this.f21299e;
        r103.drawBitmap(r101, null, new RectF(r104, r105, this.f21300f + r104, this.f21301g + r105), r100.f16614b);
        return;
    L11:
        if (r102 != 2) goto L17;
        Canvas r106 = r100.a();
        float r107 = this.f21302h;
        float r108 = this.f21303i;
        Rect r109 = new Rect((int) r107, (int) r108, (int) (r107 + this.f21304j), (int) (r108 + this.f21305k));
        float r110 = this.f21298d;
        float r111 = this.f21299e;
        r106.drawBitmap(r101, r109, new RectF(r110, r111, this.f21300f + r110, this.f21301g + r111), r100.f16614b);
        return;
    L17:
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        Object r102 = r100.get(Segment.JsonKey.START);
        String r103 = null;
        if ((r102 instanceof String) == false) goto L5;
        String r104 = (String) r102;
    L6:
        Object r105 = r100.get("im");
        if ((r105 instanceof String) == false) goto L9;
        r103 = (String) r105;
    L9:
        this.f21297c = r103;
        boolean r106 = true;
        if (r103 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L47;
        if (r104 != null) goto L19;
    L22:
        if (r106 == true) goto L49;
        int r108 = r104.hashCode();
        if (r108 == 115) goto L40;
        if (r108 == 3178) goto L36;
        if (r108 == 3180) goto L32;
    L43:
        String r109 = this.f21297c;
        if (r109 == null) goto L48;
        r101.f16627k.get(r109);
        return;
    L48:
        return;
    L32:
        if (r104.equals("co") == false) goto L43;
        this.f21298d = bx2.a.c(r100, "x");
        this.f21299e = bx2.a.c(r100, "y");
        this.f21300f = bx2.a.c(r100, "w");
        this.f21301g = bx2.a.c(r100, "h");
        this.f21302h = bx2.a.c(r100, "sx");
        this.f21303i = bx2.a.c(r100, "sy");
        this.f21304j = bx2.a.c(r100, "sw");
        this.f21305k = bx2.a.c(r100, "sh");
        goto L43
    L36:
        if (r104.equals("cm") == false) goto L43;
        this.f21298d = bx2.a.c(r100, "x");
        this.f21299e = bx2.a.c(r100, "y");
        this.f21300f = bx2.a.c(r100, "w");
        this.f21301g = bx2.a.c(r100, "h");
        goto L43
    L40:
        if (r104.equals("s") == false) goto L43;
        this.f21298d = bx2.a.c(r100, "x");
        this.f21299e = bx2.a.c(r100, "y");
        goto L43
    L49:
        return;
    L19:
        if (r104.length() == 0) goto L22;
        r106 = false;
        goto L22
    L47:
        return;
    L12:
        if (r103.length() == 0) goto L15;
        r107 = false;
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
