package bx2;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f21306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21310f;

    @Override // bx2.a
    public final String h() {
        return "id";
    }

    public i() {
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bitmap r101 = this.f21306b;
        if (r101 == null) goto L6;
        r100.a().drawBitmap(r101, this.f21307c, this.f21308d, r100.f16614b);
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21307c = a.c(r100, "x");
        this.f21308d = a.c(r100, "y");
        this.f21309e = a.e(r100, "w");
        this.f21310f = a.e(r100, "h");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter("id", "key");
        ArrayList r102 = new ArrayList();
        Object r103 = r100.get("id");
        if (r103 == null) goto L17;
        List r104 = (List) r103;
        int r105 = r104.size();
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L11;
        Object r108 = ListProtector.get(r104, r107);
        if (r108 == null) goto L10;
        r102.add(Integer.valueOf((int) ((Double) r108).doubleValue()));
        r107 = r107 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L11:
        int[] r109 = CollectionsKt.toIntArray(r102);
        int r110 = r109.length / 4;
        int[] r111 = new int[r110];
    L12:
        if (r106 >= r110) goto L14;
        int r112 = r106 * 4;
        r111[r106] = Color.argb(r109[r112 + 3], r109[r112 + 0], r109[r112 + 1], r109[r112 + 2]);
        r106 = r106 + 1;
        goto L12
    L14:
        this.f21306b = Bitmap.createBitmap(r111, this.f21309e, this.f21310f, Bitmap.Config.ARGB_8888);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }
}
