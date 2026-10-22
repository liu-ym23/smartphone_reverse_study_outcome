package ch.qos.logback.core.pattern.util;

/* loaded from: classes.dex */
public class RestrictedEscapeUtil implements IEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c4, int i4) {
        if (str.indexOf(c4) >= 0) {
            stringBuffer.append(c4);
        } else {
            stringBuffer.append("\\");
            stringBuffer.append(c4);
        }
    }
}
