package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.spi.FilterReply;
import n3.e;
import n3.f;
import o3.a;

/* loaded from: classes.dex */
public class MarkerFilter extends MatchingFilter {
    e markerToMatch;

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(e eVar, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (eVar == null) {
            return this.onMismatch;
        }
        return ((a) eVar).a(this.markerToMatch) ? this.onMatch : this.onMismatch;
    }

    public void setMarker(String str) {
        if (str != null) {
            this.markerToMatch = f.a(str);
        }
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.markerToMatch != null) {
            super.start();
            return;
        }
        addError("The marker property must be set for [" + getName() + "]");
    }
}
