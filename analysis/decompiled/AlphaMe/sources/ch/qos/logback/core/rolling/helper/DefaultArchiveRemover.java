package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.LiteralConverter;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class DefaultArchiveRemover extends ContextAwareBase implements ArchiveRemover {
    protected static final long INACTIVITY_TOLERANCE_IN_MILLIS = 5529600000L;
    static final int MAX_VALUE_FOR_INACTIVITY_PERIODS = 336;
    protected static final long UNINITIALIZED = -1;
    final FileNamePattern fileNamePattern;
    long lastHeartBeat = -1;
    final boolean parentClean;
    int periodOffsetForDeletionTarget;
    final RollingCalendar rc;

    public DefaultArchiveRemover(FileNamePattern fileNamePattern, RollingCalendar rollingCalendar) {
        this.fileNamePattern = fileNamePattern;
        this.rc = rollingCalendar;
        this.parentClean = computeParentCleaningFlag(fileNamePattern);
    }

    @Override // ch.qos.logback.core.rolling.helper.ArchiveRemover
    public void clean(Date date) {
        long time = date.getTime();
        int iComputeElapsedPeriodsSinceLastClean = computeElapsedPeriodsSinceLastClean(time);
        this.lastHeartBeat = time;
        if (iComputeElapsedPeriodsSinceLastClean > 1) {
            addInfo("periodsElapsed = " + iComputeElapsedPeriodsSinceLastClean);
        }
        for (int i4 = 0; i4 < iComputeElapsedPeriodsSinceLastClean; i4++) {
            cleanByPeriodOffset(date, this.periodOffsetForDeletionTarget - i4);
        }
    }

    public abstract void cleanByPeriodOffset(Date date, int i4);

    public int computeElapsedPeriodsSinceLastClean(long j4) {
        long j5;
        long jPeriodsElapsed;
        long j6 = this.lastHeartBeat;
        if (j6 == -1) {
            addInfo("first clean up after appender initialization");
            jPeriodsElapsed = this.rc.periodsElapsed(j4, INACTIVITY_TOLERANCE_IN_MILLIS + j4);
            j5 = 336;
            if (jPeriodsElapsed > 336) {
                jPeriodsElapsed = j5;
            }
        } else {
            long jPeriodsElapsed2 = this.rc.periodsElapsed(j6, j4);
            j5 = 1;
            if (jPeriodsElapsed2 < 1) {
                addWarn("Unexpected periodsElapsed value " + jPeriodsElapsed2);
                jPeriodsElapsed = j5;
            } else {
                jPeriodsElapsed = jPeriodsElapsed2;
            }
        }
        return (int) jPeriodsElapsed;
    }

    public boolean computeParentCleaningFlag(FileNamePattern fileNamePattern) {
        if (fileNamePattern.getPrimaryDateTokenConverter().getDatePattern().indexOf(47) != -1) {
            return true;
        }
        Converter<Object> next = fileNamePattern.headTokenConverter;
        while (next != null && !(next instanceof DateTokenConverter)) {
            next = next.getNext();
        }
        while (next != null) {
            if ((next instanceof LiteralConverter) && next.convert(null).indexOf(47) != -1) {
                return true;
            }
            next = next.getNext();
        }
        return false;
    }

    public void removeFolderIfEmpty(File file) {
        removeFolderIfEmpty(file, 0);
    }

    @Override // ch.qos.logback.core.rolling.helper.ArchiveRemover
    public void setMaxHistory(int i4) {
        this.periodOffsetForDeletionTarget = (-i4) - 1;
    }

    private void removeFolderIfEmpty(File file, int i4) {
        if (i4 < 3 && file.isDirectory() && FileFilterUtil.isEmptyDirectory(file)) {
            addInfo("deleting folder [" + file + "]");
            file.delete();
            removeFolderIfEmpty(file.getParentFile(), i4 + 1);
        }
    }
}
