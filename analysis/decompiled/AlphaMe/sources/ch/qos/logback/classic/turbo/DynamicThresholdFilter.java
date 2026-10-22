package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.spi.FilterReply;
import java.util.HashMap;
import java.util.Map;
import n3.AbstractC0783d;
import n3.e;
import q3.a;

/* loaded from: classes.dex */
public class DynamicThresholdFilter extends TurboFilter {
    private String key;
    private Map<String, Level> valueLevelMap = new HashMap();
    private Level defaultThreshold = Level.ERROR;
    private FilterReply onHigherOrEqual = FilterReply.NEUTRAL;
    private FilterReply onLower = FilterReply.DENY;

    public void addMDCValueLevelPair(MDCValueLevelPair mDCValueLevelPair) {
        if (!this.valueLevelMap.containsKey(mDCValueLevelPair.getValue())) {
            this.valueLevelMap.put(mDCValueLevelPair.getValue(), mDCValueLevelPair.getLevel());
            return;
        }
        addError(mDCValueLevelPair.getValue() + " has been already set");
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(e eVar, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        String str2 = this.key;
        if (str2 == null) {
            a aVar = AbstractC0783d.f13669a;
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        a aVar2 = AbstractC0783d.f13669a;
        if (aVar2 == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        String str3 = aVar2.get(str2);
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        Level level2 = str3 != null ? this.valueLevelMap.get(str3) : null;
        if (level2 == null) {
            level2 = this.defaultThreshold;
        }
        return level.isGreaterOrEqual(level2) ? this.onHigherOrEqual : this.onLower;
    }

    public Level getDefaultThreshold() {
        return this.defaultThreshold;
    }

    public String getKey() {
        return this.key;
    }

    public FilterReply getOnHigherOrEqual() {
        return this.onHigherOrEqual;
    }

    public FilterReply getOnLower() {
        return this.onLower;
    }

    public void setDefaultThreshold(Level level) {
        this.defaultThreshold = level;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOnHigherOrEqual(FilterReply filterReply) {
        this.onHigherOrEqual = filterReply;
    }

    public void setOnLower(FilterReply filterReply) {
        this.onLower = filterReply;
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.key == null) {
            addError("No key name was specified");
        }
        super.start();
    }
}
