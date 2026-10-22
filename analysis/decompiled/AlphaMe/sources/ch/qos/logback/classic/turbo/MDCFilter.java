package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.spi.FilterReply;
import n3.AbstractC0783d;
import n3.e;
import q3.a;

/* loaded from: classes.dex */
public class MDCFilter extends MatchingFilter {
    String MDCKey;
    String value;

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(e eVar, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        String str2 = this.MDCKey;
        if (str2 == null) {
            return FilterReply.NEUTRAL;
        }
        a aVar = AbstractC0783d.f13669a;
        if (aVar != null) {
            return this.value.equals(aVar.get(str2)) ? this.onMatch : this.onMismatch;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public void setMDCKey(String str) {
        this.MDCKey = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
