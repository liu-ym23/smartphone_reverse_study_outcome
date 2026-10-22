package bu2;

import com.bytedance.android.livesdk.utils.guide.LongPressGuideScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f20723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongPressGuideScene f20724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f20725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20726d;

    public a(LongPressGuideScene r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f20724b = r100;
        this.f20725c = r101;
        this.f20726d = 3000;
    }
}
