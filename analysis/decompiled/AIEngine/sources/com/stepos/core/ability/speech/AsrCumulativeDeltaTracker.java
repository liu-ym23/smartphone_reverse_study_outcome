package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCumulativeDeltaTracker {
    private final Object lock = new Object();
    private String emitted = "";

    public final String currentSegmentText() {
        String str;
        synchronized (this.lock) {
            str = this.emitted;
        }
        return str;
    }

    public final String nextIncrement(String cumulative) {
        String strSubstring;
        kotlin.jvm.internal.g.f(cumulative, "cumulative");
        synchronized (this.lock) {
            try {
                if (cumulative.length() <= this.emitted.length() || !gc.o.k0(cumulative, this.emitted, false)) {
                    strSubstring = "";
                } else {
                    strSubstring = cumulative.substring(this.emitted.length());
                    kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                    this.emitted = cumulative;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strSubstring;
    }

    public final void rebaseToCommitted(int i10) {
        synchronized (this.lock) {
            if (i10 <= 0) {
                this.emitted = "";
                return;
            }
            String str = this.emitted;
            if (i10 < str.codePointCount(0, str.length())) {
                String str2 = this.emitted;
                String strSubstring = str2.substring(0, str2.offsetByCodePoints(0, i10));
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                this.emitted = strSubstring;
            }
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void reset() {
        synchronized (this.lock) {
            this.emitted = "";
            lb.n nVar = lb.n.f10413a;
        }
    }
}
