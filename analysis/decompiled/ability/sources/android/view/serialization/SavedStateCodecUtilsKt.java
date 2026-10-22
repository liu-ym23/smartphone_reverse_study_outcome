package android.view.serialization;

import B9.C0179f;
import B9.C0186m;
import B9.C0190q;
import B9.C0197y;
import B9.E;
import B9.F;
import B9.K;
import B9.h0;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import z9.g;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0017\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u001a\u0010\t\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0004\"\u001a\u0010\r\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u001a\u0010\u000f\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0004\"\u001a\u0010\u0011\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0004\" \u0010\u0013\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0002\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lz9/g;", "intListDescriptor", "Lz9/g;", "getIntListDescriptor", "()Lz9/g;", "stringListDescriptor", "getStringListDescriptor", "booleanArrayDescriptor", "getBooleanArrayDescriptor", "charArrayDescriptor", "getCharArrayDescriptor", "doubleArrayDescriptor", "getDoubleArrayDescriptor", "floatArrayDescriptor", "getFloatArrayDescriptor", "intArrayDescriptor", "getIntArrayDescriptor", "longArrayDescriptor", "getLongArrayDescriptor", "stringArrayDescriptor", "getStringArrayDescriptor", "getStringArrayDescriptor$annotations", "()V", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateCodecUtilsKt {
    private static final g booleanArrayDescriptor;
    private static final g charArrayDescriptor;
    private static final g doubleArrayDescriptor;
    private static final g floatArrayDescriptor;
    private static final g intArrayDescriptor;
    private static final g intListDescriptor = AbstractC1451a.d(F.f218a).b;
    private static final g longArrayDescriptor;
    private static final g stringArrayDescriptor;
    private static final g stringListDescriptor;

    static {
        h0 h0Var = h0.f242a;
        stringListDescriptor = AbstractC1451a.d(h0Var).b;
        booleanArrayDescriptor = C0179f.c.b;
        charArrayDescriptor = C0186m.c.b;
        doubleArrayDescriptor = C0190q.c.b;
        floatArrayDescriptor = C0197y.c.b;
        intArrayDescriptor = E.c.b;
        longArrayDescriptor = K.c.b;
        stringArrayDescriptor = AbstractC1451a.c(m.f4928a.b(String.class), h0Var).c;
    }

    public static final g getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final g getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final g getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final g getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final g getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final g getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final g getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final g getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }

    public static final g getStringListDescriptor() {
        return stringListDescriptor;
    }
}
