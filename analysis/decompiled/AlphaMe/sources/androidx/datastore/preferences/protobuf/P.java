package androidx.datastore.preferences.protobuf;

import com.stepos.alphame.common.CommonContractKt;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: b, reason: collision with root package name */
    public static final N f3432b = new N();

    /* renamed from: a, reason: collision with root package name */
    public final W f3433a;

    public P() {
        W w4;
        W[] wArr = new W[2];
        wArr[0] = C0276x.f3550a;
        try {
            w4 = (W) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(CommonContractKt.METHOD_NAME_GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            w4 = f3432b;
        }
        wArr[1] = w4;
        O o4 = new O();
        o4.f3431a = wArr;
        Charset charset = D.f3396a;
        this.f3433a = o4;
    }
}
