package com.bytedance.android.shopping.prepurchase.arch.exposure;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f180893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f180894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f180895c;

    public static final class a {
    }

    static {
    }

    public final void update(d r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if ((!Intrinsics.areEqual(r100.f180889a, this.f180894b.f180889a)) == false) goto L5;
        return;
    L5:
        d r101 = this.f180894b;
        List<l> r102 = r100.f180891c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f180891c = r102;
        d r103 = this.f180894b;
        g r104 = r100.f180892d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f180892d = r104;
        this.f180894b.f180890b = r100.f180890b;
    }

    public e(d r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f180894b = r100;
        this.f180895c = r101;
    }

    public final void a(h r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_PROP_PROVIDER);
        long r100 = System.currentTimeMillis();
        boolean r101 = false;
        if (r111 == true) goto L29;
        List<l> r112 = this.f180894b.f180891c;
        if ((r112 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r113 = r112.iterator();
    L12:
        if (r113.hasNext() == false) goto L29;
        l r102 = (l) r113.next();
        c r103 = r110.a(r102);
        if (r103 == null) goto L22;
        int r104 = r103.f180887a;
        if (r104 <= 0) goto L22;
        if (((r103.f180888b * 1.0f) / r104) < this.f180894b.f180890b) goto L22;
        boolean r105 = true;
    L23:
        f r106 = this.f180895c;
        if (r106 == null) goto L26;
        r106.d("ExposureTask", "schedule#" + r102.f180908a + '_' + r102.f180909b + " shown: " + r105);
    L26:
        if (r105 == false) goto L12;
        r101 = true;
    L22:
        r105 = false;
        goto L23
    L8:
        if (r112.isEmpty() == false) goto L10;
    L29:
        if (r101 == true) goto L31;
    L35:
        if (r101 == false) goto L37;
        return;
    L37:
        if (this.f180893a <= 0) goto L52;
        long r107 = System.currentTimeMillis() - this.f180893a;
        this.f180893a = 0;
        f r108 = this.f180895c;
        if (r108 == null) goto L42;
        r108.i("ExposureTask", "report: " + this.f180894b.f180889a + ", " + r107 + "ms");
    L42:
        if (r107 <= 0) goto L53;
        this.f180894b.f180892d.a(r107);
        return;
    L53:
        return;
    L52:
        return;
    L31:
        if (this.f180893a > 0) goto L35;
        this.f180893a = r100;
        f r109 = this.f180895c;
        if (r109 == null) goto L35;
        r109.i("ExposureTask", "taskId: " + this.f180894b.f180889a + ", isShown: " + r101 + ", ts:" + this.f180893a);
        goto L35
    }
}
