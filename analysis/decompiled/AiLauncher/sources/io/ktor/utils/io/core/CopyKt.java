package io.ktor.utils.io.core;

import fb.s;
import fb.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lfb/v;", "Lfb/s;", "output", "", "copyTo", "(Lfb/v;Lfb/s;)J", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CopyKt {
    public static final long copyTo(v vVar, s output) {
        p.i(vVar, "<this>");
        p.i(output, "output");
        return vVar.B(output);
    }
}
