package r2;

import android.net.NetworkRequest;
import android.util.Log;
import h2.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static g a(int[] iArr, int[] iArr2) {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i10 : iArr) {
            try {
                builder.addCapability(i10);
            } catch (IllegalArgumentException e10) {
                h2.j jVarD = h2.j.d();
                String str = g.f11692b;
                String str2 = g.f11692b;
                String str3 = "Ignoring adding capability '" + i10 + '\'';
                if (((j.a) jVarD).f9274c <= 5) {
                    Log.w(str2, str3, e10);
                }
            }
        }
        for (int i11 : iArr2) {
            builder.addTransportType(i11);
        }
        NetworkRequest networkRequestBuild = builder.build();
        kotlin.jvm.internal.g.e(networkRequestBuild, "networkRequest.build()");
        return new g(networkRequestBuild);
    }
}
