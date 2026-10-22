package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public class TimeBasedArchiveRemover extends DefaultArchiveRemover {
    public TimeBasedArchiveRemover(FileNamePattern fileNamePattern, RollingCalendar rollingCalendar) {
        super(fileNamePattern, rollingCalendar);
    }

    @Override // ch.qos.logback.core.rolling.helper.DefaultArchiveRemover
    public void cleanByPeriodOffset(Date date, int i4) {
        File file = new File(this.fileNamePattern.convert(this.rc.getRelativeDate(date, i4)));
        if (file.exists() && file.isFile()) {
            file.delete();
            addInfo("deleting " + file);
            if (this.parentClean) {
                removeFolderIfEmpty(file.getParentFile());
            }
        }
    }

    public String toString() {
        return "c.q.l.core.rolling.helper.TimeBasedArchiveRemover";
    }
}
