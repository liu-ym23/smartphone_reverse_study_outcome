package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public class SizeAndTimeBasedArchiveRemover extends DefaultArchiveRemover {
    public SizeAndTimeBasedArchiveRemover(FileNamePattern fileNamePattern, RollingCalendar rollingCalendar) {
        super(fileNamePattern, rollingCalendar);
    }

    @Override // ch.qos.logback.core.rolling.helper.DefaultArchiveRemover
    public void cleanByPeriodOffset(Date date, int i4) {
        Date relativeDate = this.rc.getRelativeDate(date, i4);
        String strAfterLastSlash = FileFilterUtil.afterLastSlash(this.fileNamePattern.toRegexForFixedDate(relativeDate));
        File parentFile = new File(this.fileNamePattern.convertMultipleArguments(relativeDate, 0)).getAbsoluteFile().getAbsoluteFile().getParentFile();
        for (File file : FileFilterUtil.filesInFolderMatchingStemRegex(parentFile, strAfterLastSlash)) {
            file.delete();
        }
        if (this.parentClean) {
            removeFolderIfEmpty(parentFile);
        }
    }
}
