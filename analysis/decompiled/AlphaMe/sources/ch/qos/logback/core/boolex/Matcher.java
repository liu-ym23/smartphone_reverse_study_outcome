package ch.qos.logback.core.boolex;

import B0.g;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes.dex */
public class Matcher extends ContextAwareBase implements LifeCycle {
    private String name;
    private Pattern pattern;
    private String regex;
    private boolean caseSensitive = true;
    private boolean canonEq = false;
    private boolean unicodeCase = false;
    private boolean start = false;

    public String getName() {
        return this.name;
    }

    public String getRegex() {
        return this.regex;
    }

    public boolean isCanonEq() {
        return this.canonEq;
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.start;
    }

    public boolean isUnicodeCase() {
        return this.unicodeCase;
    }

    public boolean matches(String str) throws EvaluationException {
        if (this.start) {
            return this.pattern.matcher(str).find();
        }
        throw new EvaluationException(g.r(new StringBuilder("Matcher ["), this.regex, "] not started"));
    }

    public void setCanonEq(boolean z4) {
        this.canonEq = z4;
    }

    public void setCaseSensitive(boolean z4) {
        this.caseSensitive = z4;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public void setUnicodeCase(boolean z4) {
        this.unicodeCase = z4;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.name == null) {
            addError("All Matcher objects must be named");
            return;
        }
        try {
            int i4 = !this.caseSensitive ? 2 : 0;
            if (this.canonEq) {
                i4 |= 128;
            }
            if (this.unicodeCase) {
                i4 |= 64;
            }
            this.pattern = Pattern.compile(this.regex, i4);
            this.start = true;
        } catch (PatternSyntaxException e4) {
            addError("Failed to compile regex [" + this.regex + "]", e4);
        }
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.start = false;
    }
}
