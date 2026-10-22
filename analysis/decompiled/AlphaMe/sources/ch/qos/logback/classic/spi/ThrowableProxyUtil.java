package ch.qos.logback.classic.spi;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes.dex */
public class ThrowableProxyUtil {
    private static final int BUILDER_CAPACITY = 2048;
    public static final int REGULAR_EXCEPTION_INDENT = 1;
    public static final int SUPPRESSED_EXCEPTION_INDENT = 1;

    public static String asString(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        recursiveAppend(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }

    public static void build(ThrowableProxy throwableProxy, Throwable th, ThrowableProxy throwableProxy2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        throwableProxy.commonFrames = throwableProxy2 != null ? findNumberOfCommonFrames(stackTrace, throwableProxy2.getStackTraceElementProxyArray()) : -1;
        throwableProxy.stackTraceElementProxyArray = steArrayToStepArray(stackTrace);
    }

    public static int findNumberOfCommonFrames(StackTraceElement[] stackTraceElementArr, StackTraceElementProxy[] stackTraceElementProxyArr) {
        int i4 = 0;
        if (stackTraceElementProxyArr != null && stackTraceElementArr != null) {
            int length = stackTraceElementArr.length - 1;
            for (int length2 = stackTraceElementProxyArr.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementProxyArr[length2].ste); length2--) {
                i4++;
                length--;
            }
        }
        return i4;
    }

    public static void indent(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append('\t');
        }
    }

    private static void recursiveAppend(StringBuilder sb, String str, int i4, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return;
        }
        subjoinFirstLine(sb, str, i4, iThrowableProxy);
        sb.append(CoreConstants.LINE_SEPARATOR);
        subjoinSTEPArray(sb, i4, iThrowableProxy);
        IThrowableProxy[] suppressed = iThrowableProxy.getSuppressed();
        if (suppressed != null) {
            for (IThrowableProxy iThrowableProxy2 : suppressed) {
                recursiveAppend(sb, CoreConstants.SUPPRESSED, i4 + 1, iThrowableProxy2);
            }
        }
        recursiveAppend(sb, CoreConstants.CAUSED_BY, i4, iThrowableProxy.getCause());
    }

    public static StackTraceElementProxy[] steArrayToStepArray(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return new StackTraceElementProxy[0];
        }
        int length = stackTraceElementArr.length;
        StackTraceElementProxy[] stackTraceElementProxyArr = new StackTraceElementProxy[length];
        for (int i4 = 0; i4 < length; i4++) {
            stackTraceElementProxyArr[i4] = new StackTraceElementProxy(stackTraceElementArr[i4]);
        }
        return stackTraceElementProxyArr;
    }

    private static void subjoinExceptionMessage(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        sb.append(iThrowableProxy.getClassName());
        sb.append(": ");
        sb.append(iThrowableProxy.getMessage());
    }

    private static void subjoinFirstLine(StringBuilder sb, String str, int i4, IThrowableProxy iThrowableProxy) {
        indent(sb, i4 - 1);
        if (str != null) {
            sb.append(str);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }

    public static void subjoinFirstLineRootCauseFirst(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy.getCause() != null) {
            sb.append(CoreConstants.WRAPPED_BY);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }

    public static void subjoinPackagingData(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
        ClassPackagingData classPackagingData;
        if (stackTraceElementProxy == null || (classPackagingData = stackTraceElementProxy.getClassPackagingData()) == null) {
            return;
        }
        if (classPackagingData.isExact()) {
            sb.append(" [");
        } else {
            sb.append(" ~[");
        }
        sb.append(classPackagingData.getCodeLocation());
        sb.append(CoreConstants.COLON_CHAR);
        sb.append(classPackagingData.getVersion());
        sb.append(']');
    }

    public static void subjoinSTEP(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
        sb.append(stackTraceElementProxy.toString());
        subjoinPackagingData(sb, stackTraceElementProxy);
    }

    public static void subjoinSTEPArray(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        subjoinSTEPArray(sb, 1, iThrowableProxy);
    }

    public static void subjoinSTEPArray(StringBuilder sb, int i4, IThrowableProxy iThrowableProxy) {
        StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        int commonFrames = iThrowableProxy.getCommonFrames();
        for (int i5 = 0; i5 < stackTraceElementProxyArray.length - commonFrames; i5++) {
            StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArray[i5];
            indent(sb, i4);
            subjoinSTEP(sb, stackTraceElementProxy);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        if (commonFrames > 0) {
            indent(sb, i4);
            sb.append("... ");
            sb.append(commonFrames);
            sb.append(" common frames omitted");
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
    }

    public static void subjoinFirstLine(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy.getCommonFrames() > 0) {
            sb.append(CoreConstants.CAUSED_BY);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }
}
