package c62;

import com.bytedance.android.livesdk.config.yn0;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements vlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LimitQueue f22542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<tlc.d, Boolean> f22543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<tlc.d, Unit> f22544c;

    @Override // vlc.b
    public final boolean onMessage(tlc.d r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f22543b.invoke(r100).booleanValue() == false) goto L9;
        this.f22542a.add(r100);
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super tlc.d, Boolean> r100, Function1<? super tlc.d, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "needBufferCallback");
        Intrinsics.checkNotNullParameter(r101, "dispatchCallback");
        this.f22543b = r100;
        this.f22544c = r101;
        this.f22542a = new LimitQueue(yn0.f121703a.getValue().intValue());
    }
}
