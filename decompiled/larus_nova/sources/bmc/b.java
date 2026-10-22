package bmc;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f19671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f19672b;

    @Override // com.ss.ugc.live.sdk.msg.dispatch.f
    public final d a(SdkMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "sdkMessage");
        Iterator<T> r101 = this.f19672b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (TextUtils.equals(r100.method, ((a) r102).kM()) == false) goto L4;
    L9:
        a r103 = (a) r102;
        if (r103 == null) goto L13;
        return r103.a(r100);
    L13:
        return this.f19671a.a(r100);
    L8:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(f r100, List<? extends a> r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultDecoder");
        Intrinsics.checkNotNullParameter(r101, "messagePlugins");
        this.f19671a = r100;
        this.f19672b = r101;
    }
}
