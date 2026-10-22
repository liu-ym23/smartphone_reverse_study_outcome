package ch.qos.logback.core.util;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.helpers.ThrowableToStringArray;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.StatusUtil;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class StatusPrinter {
    private static PrintStream ps = System.out;
    static CachingDateFormatter cachingDateFormat = new CachingDateFormatter("HH:mm:ss,SSS");

    private static void appendThrowable(StringBuilder sb, Throwable th) {
        for (String str : ThrowableToStringArray.convert(th)) {
            if (!str.startsWith(CoreConstants.CAUSED_BY)) {
                if (Character.isDigit(str.charAt(0))) {
                    sb.append("\t... ");
                } else {
                    sb.append("\tat ");
                }
            }
            sb.append(str);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
    }

    public static void buildStr(StringBuilder sb, String str, Status status) {
        String strP = status.hasChildren() ? AbstractC0351g.p(str, "+ ") : AbstractC0351g.p(str, "|-");
        CachingDateFormatter cachingDateFormatter = cachingDateFormat;
        if (cachingDateFormatter != null) {
            sb.append(cachingDateFormatter.format(status.getDate().longValue()));
            sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        }
        sb.append(strP);
        sb.append(status);
        sb.append(CoreConstants.LINE_SEPARATOR);
        if (status.getThrowable() != null) {
            appendThrowable(sb, status.getThrowable());
        }
        if (status.hasChildren()) {
            Iterator<Status> it = status.iterator();
            while (it.hasNext()) {
                buildStr(sb, str + "  ", it.next());
            }
        }
    }

    private static void buildStrFromStatusList(StringBuilder sb, List<Status> list) {
        if (list == null) {
            return;
        }
        Iterator<Status> it = list.iterator();
        while (it.hasNext()) {
            buildStr(sb, "", it.next());
        }
    }

    public static void print(Context context) {
        print(context, 0L);
    }

    public static void printIfErrorsOccured(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager != null) {
            if (new StatusUtil(context).getHighestLevel(0L) == 2) {
                print(statusManager);
            }
        } else {
            ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        }
    }

    public static void printInCaseOfErrorsOrWarnings(Context context) {
        printInCaseOfErrorsOrWarnings(context, 0L);
    }

    public static void setPrintStream(PrintStream printStream) {
        ps = printStream;
    }

    public static void print(Context context, long j4) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager != null) {
            print(statusManager, j4);
            return;
        }
        ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
    }

    public static void printInCaseOfErrorsOrWarnings(Context context, long j4) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager != null) {
            if (new StatusUtil(context).getHighestLevel(j4) >= 1) {
                print(statusManager, j4);
            }
        } else {
            ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        }
    }

    public static void print(StatusManager statusManager) {
        print(statusManager, 0L);
    }

    public static void print(StatusManager statusManager, long j4) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, StatusUtil.filterStatusListByTimeThreshold(statusManager.getCopyOfStatusList(), j4));
        ps.println(sb.toString());
    }

    public static void print(List<Status> list) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, list);
        ps.println(sb.toString());
    }
}
