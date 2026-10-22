package ac0;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TuningButtonType f2528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2533f;

    public final TuningButtonType getType() {
        return this.f2528a;
    }

    public a(TuningButtonType r100, String r101, boolean r102, boolean r103, float r104, int r105) {
        int r106 = 0;
        if ((r105 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = true;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r104 = 1.0f;
    L12:
        if ((r105 & 32) == 0) goto L14;
        r106 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f2528a = r100;
        this.f2529b = r101;
        this.f2530c = r102;
        this.f2531d = r103;
        this.f2532e = r104;
        this.f2533f = r106;
    }
}
