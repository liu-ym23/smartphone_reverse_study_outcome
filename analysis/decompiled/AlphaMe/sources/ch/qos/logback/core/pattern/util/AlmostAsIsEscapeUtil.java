package ch.qos.logback.core.pattern.util;

/* loaded from: classes.dex */
public class AlmostAsIsEscapeUtil extends RestrictedEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.RestrictedEscapeUtil, ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c4, int i4) {
        super.escape("%)", stringBuffer, c4, i4);
    }
}
