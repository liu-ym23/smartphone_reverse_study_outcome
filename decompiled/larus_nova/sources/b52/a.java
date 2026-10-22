package b52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import d52.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends a52.a<d52.a, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17745a = null;

    static {
        f17745a = new a();
    }

    public a() {
    }

    @Override // a52.a
    public final BaseStyleSettingModel<d52.a> a() {
        return y42.a.f565987c;
    }

    public static Float c(d52.a r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (Intrinsics.areEqual(r100, d52.a.C5635a.f466968b) == false) goto L6;
        float r101 = PublicScreenABHelper.h().fontSize;
        float r102 = 16.0f;
    L8:
        float r103 = r102 / r101;
    L13:
        return Float.valueOf(r103);
    L6:
        if (Intrinsics.areEqual(r100, d52.a.b.f466970b) == false) goto L10;
        r101 = PublicScreenABHelper.h().fontSize;
        r102 = 18.0f;
        goto L8
    L10:
        if (Intrinsics.areEqual(r100, d52.a.c.f466971a) == false) goto L15;
        r103 = 1.0f;
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // a52.a
    public final /* bridge */ /* synthetic */ Float b(c r100) {
        return c((d52.a) r100);
    }
}
