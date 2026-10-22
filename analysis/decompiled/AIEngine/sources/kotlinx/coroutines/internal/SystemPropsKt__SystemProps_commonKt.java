package kotlinx.coroutines.internal;

import com.stepos.core.ota.d;
import gc.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(String str, boolean z) {
        String strSystemProp = SystemPropsKt.systemProp(str);
        return strSystemProp != null ? Boolean.parseBoolean(strSystemProp) : z;
    }

    public static /* synthetic */ int systemProp$default(String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i10, i11, i12);
    }

    public static final int systemProp(String str, int i10, int i11, int i12) {
        return (int) SystemPropsKt.systemProp(str, i10, i11, i12);
    }

    public static /* synthetic */ long systemProp$default(String str, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = 1;
        }
        long j13 = j11;
        if ((i10 & 8) != 0) {
            j12 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j10, j13, j12);
    }

    public static final long systemProp(String str, long j10, long j11, long j12) {
        String strSystemProp = SystemPropsKt.systemProp(str);
        if (strSystemProp == null) {
            return j10;
        }
        Long lD0 = n.d0(strSystemProp);
        if (lD0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strSystemProp + '\'').toString());
        }
        long jLongValue = lD0.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        StringBuilder sbL = d.l("System property '", j11, str, "' should be in range ");
        a0.a.s(j12, "..", ", but is '", sbL);
        sbL.append(jLongValue);
        sbL.append('\'');
        throw new IllegalStateException(sbL.toString().toString());
    }

    public static final String systemProp(String str, String str2) {
        String strSystemProp = SystemPropsKt.systemProp(str);
        return strSystemProp == null ? str2 : strSystemProp;
    }
}
