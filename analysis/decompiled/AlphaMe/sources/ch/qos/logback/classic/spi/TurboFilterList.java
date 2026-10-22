package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import java.util.concurrent.CopyOnWriteArrayList;
import n3.e;

/* loaded from: classes.dex */
public final class TurboFilterList extends CopyOnWriteArrayList<TurboFilter> {
    private static final long serialVersionUID = 1;

    public FilterReply getTurboFilterChainDecision(e eVar, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (size() == 1) {
            try {
                return get(0).decide(eVar, logger, level, str, objArr, th);
            } catch (IndexOutOfBoundsException unused) {
                return FilterReply.NEUTRAL;
            }
        }
        for (Object obj : toArray()) {
            FilterReply filterReplyDecide = ((TurboFilter) obj).decide(eVar, logger, level, str, objArr, th);
            if (filterReplyDecide == FilterReply.DENY || filterReplyDecide == FilterReply.ACCEPT) {
                return filterReplyDecide;
            }
        }
        return FilterReply.NEUTRAL;
    }
}
