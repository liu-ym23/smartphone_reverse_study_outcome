package c52;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends a52.a<d52.b, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f22475d;

    public abstract int d();

    public abstract int f();

    public b() {
        this.f22472a = UtilityKotlinExtentionsKt.i(100);
        this.f22473b = f.a().highHeightMultiFactor;
        this.f22474c = f.a().midHeightMultiFactor;
        this.f22475d = f.a().lowHeightMultiFactor;
    }

    public final int c() {
        return (int) (((((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(330)) - f()) - d()) * (1 - this.f22474c));
    }

    public final int e() {
        return f() + ((int) (((((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(330)) - f()) - d()) * this.f22474c));
    }

    @Override // a52.a
    public final BaseStyleSettingModel<d52.b> a() {
        return z42.a.f569930c;
    }

    @Override // a52.a
    public final /* bridge */ /* synthetic */ Integer b(d52.c r100) {
        return g((d52.b) r100);
    }

    public final Integer g(d52.b r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (c() >= 0) goto L7;
        return Integer.valueOf(e());
    L7:
        if (Intrinsics.areEqual(r100, d52.b.C5636b.f466974a) == false) goto L11;
        int r101 = e();
        float r102 = c();
        float r103 = this.f22475d;
    L9:
        int r104 = r101 + ((int) (r102 * r103));
    L17:
        return Integer.valueOf(RangesKt.coerceAtLeast(r104, this.f22472a));
    L11:
        if (Intrinsics.areEqual(r100, d52.b.a.f466973b) == false) goto L14;
        r101 = e();
        r102 = c();
        r103 = this.f22473b;
        goto L9
    L14:
        if (Intrinsics.areEqual(r100, d52.b.c.f466976b) == false) goto L19;
        r104 = e();
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
