package com.google.android.gms.common.stats;

import B0.g;
import ch.qos.logback.classic.net.SyslogAppender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int N();

    public abstract long O();

    public abstract long P();

    public abstract String Q();

    public final String toString() {
        long jP = P();
        int iN = N();
        long jO = O();
        String strQ = Q();
        StringBuilder sb = new StringBuilder();
        sb.append(jP);
        sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        sb.append(iN);
        sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        return g.p(sb, jO, strQ);
    }
}
