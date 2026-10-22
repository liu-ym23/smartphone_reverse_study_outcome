package io.ktor.utils.io.core.internal;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0081\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "", "name", "", "toIntOrFail", "(JLjava/lang/String;)I", UxipConstants.f30680s, "", "failLongToIntConversion", "(JLjava/lang/String;)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumbersKt {
    public static final Void failLongToIntConversion(long j10, String name) {
        p.i(name, "name");
        throw new IllegalArgumentException("Long value " + j10 + " of " + name + " doesn't fit into 32-bit integer");
    }

    public static final int toIntOrFail(long j10, String name) {
        p.i(name, "name");
        if (j10 < 2147483647L) {
            return (int) j10;
        }
        failLongToIntConversion(j10, name);
        throw new KotlinNothingValueException();
    }
}
