package h3;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k3.C0694i;
import k3.InterfaceC0695j;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class D extends Z {

    /* renamed from: c, reason: collision with root package name */
    public static final M f12703c;

    /* renamed from: a, reason: collision with root package name */
    public final List f12704a;

    /* renamed from: b, reason: collision with root package name */
    public final List f12705b;

    static {
        Pattern pattern = M.f12732d;
        f12703c = C0611u.o("application/x-www-form-urlencoded");
    }

    public D(ArrayList encodedNames, ArrayList encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.f12704a = Util.toImmutableList(encodedNames);
        this.f12705b = Util.toImmutableList(encodedValues);
    }

    public final long a(InterfaceC0695j interfaceC0695j, boolean z4) throws EOFException {
        C0694i c0694iF;
        if (z4) {
            c0694iF = new C0694i();
        } else {
            Intrinsics.checkNotNull(interfaceC0695j);
            c0694iF = interfaceC0695j.f();
        }
        List list = this.f12704a;
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            if (i4 > 0) {
                c0694iF.V(38);
            }
            c0694iF.d0((String) list.get(i4));
            c0694iF.V(61);
            c0694iF.d0((String) this.f12705b.get(i4));
            i4 = i5;
        }
        if (!z4) {
            return 0L;
        }
        long j4 = c0694iF.f13357b;
        c0694iF.a();
        return j4;
    }

    @Override // h3.Z
    public final long contentLength() {
        return a(null, true);
    }

    @Override // h3.Z
    public final M contentType() {
        return f12703c;
    }

    @Override // h3.Z
    public final void writeTo(InterfaceC0695j sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
