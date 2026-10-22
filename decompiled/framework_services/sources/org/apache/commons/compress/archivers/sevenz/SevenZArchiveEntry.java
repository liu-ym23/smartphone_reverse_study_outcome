package org.apache.commons.compress.archivers.sevenz;

import com.android.server.job.controllers.JobStatus;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimeZone;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
public class SevenZArchiveEntry implements ArchiveEntry {
    private long accessDate;
    private long compressedCrc;
    private long compressedSize;
    private Iterable<? extends SevenZMethodConfiguration> contentMethods;
    private long crc;
    private long creationDate;
    private boolean hasAccessDate;
    private boolean hasCrc;
    private boolean hasCreationDate;
    private boolean hasLastModifiedDate;
    private boolean hasStream;
    private boolean hasWindowsAttributes;
    private boolean isAntiItem;
    private boolean isDirectory;
    private long lastModifiedDate;
    private String name;
    private long size;
    private int windowsAttributes;

    public SevenZArchiveEntry() {
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasStream() {
        return this.hasStream;
    }

    public void setHasStream(boolean hasStream) {
        this.hasStream = hasStream;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public boolean isAntiItem() {
        return this.isAntiItem;
    }

    public void setAntiItem(boolean isAntiItem) {
        this.isAntiItem = isAntiItem;
    }

    public boolean getHasCreationDate() {
        return this.hasCreationDate;
    }

    public void setHasCreationDate(boolean hasCreationDate) {
        this.hasCreationDate = hasCreationDate;
    }

    public Date getCreationDate() {
        if (this.hasCreationDate == false) goto L7;
        return ntfsTimeToJavaTime(this.creationDate);
    L7:
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setCreationDate(long ntfsCreationDate) {
        this.creationDate = ntfsCreationDate;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate == null) goto L4;
        boolean r0 = true;
    L5:
        this.hasCreationDate = r0;
        if (this.hasCreationDate == false) goto L9;
        this.creationDate = javaTimeToNtfsTime(creationDate);
        return;
    L9:
        return;
    L4:
        r0 = false;
        goto L5
    }

    public boolean getHasLastModifiedDate() {
        return this.hasLastModifiedDate;
    }

    public void setHasLastModifiedDate(boolean hasLastModifiedDate) {
        this.hasLastModifiedDate = hasLastModifiedDate;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        if (this.hasLastModifiedDate == false) goto L7;
        return ntfsTimeToJavaTime(this.lastModifiedDate);
    L7:
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setLastModifiedDate(long ntfsLastModifiedDate) {
        this.lastModifiedDate = ntfsLastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        if (lastModifiedDate == null) goto L4;
        boolean r0 = true;
    L5:
        this.hasLastModifiedDate = r0;
        if (this.hasLastModifiedDate == false) goto L9;
        this.lastModifiedDate = javaTimeToNtfsTime(lastModifiedDate);
        return;
    L9:
        return;
    L4:
        r0 = false;
        goto L5
    }

    public boolean getHasAccessDate() {
        return this.hasAccessDate;
    }

    public void setHasAccessDate(boolean hasAcessDate) {
        this.hasAccessDate = hasAcessDate;
    }

    public Date getAccessDate() {
        if (this.hasAccessDate == false) goto L7;
        return ntfsTimeToJavaTime(this.accessDate);
    L7:
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void setAccessDate(long ntfsAccessDate) {
        this.accessDate = ntfsAccessDate;
    }

    public void setAccessDate(Date accessDate) {
        if (accessDate == null) goto L4;
        boolean r0 = true;
    L5:
        this.hasAccessDate = r0;
        if (this.hasAccessDate == false) goto L9;
        this.accessDate = javaTimeToNtfsTime(accessDate);
        return;
    L9:
        return;
    L4:
        r0 = false;
        goto L5
    }

    public boolean getHasWindowsAttributes() {
        return this.hasWindowsAttributes;
    }

    public void setHasWindowsAttributes(boolean hasWindowsAttributes) {
        this.hasWindowsAttributes = hasWindowsAttributes;
    }

    public int getWindowsAttributes() {
        return this.windowsAttributes;
    }

    public void setWindowsAttributes(int windowsAttributes) {
        this.windowsAttributes = windowsAttributes;
    }

    public boolean getHasCrc() {
        return this.hasCrc;
    }

    public void setHasCrc(boolean hasCrc) {
        this.hasCrc = hasCrc;
    }

    @Deprecated
    public int getCrc() {
        return (int) this.crc;
    }

    @Deprecated
    public void setCrc(int crc) {
        this.crc = crc;
    }

    public long getCrcValue() {
        return this.crc;
    }

    public void setCrcValue(long crc) {
        this.crc = crc;
    }

    @Deprecated
    int getCompressedCrc() {
        return (int) this.compressedCrc;
    }

    @Deprecated
    void setCompressedCrc(int crc) {
        this.compressedCrc = crc;
    }

    long getCompressedCrcValue() {
        return this.compressedCrc;
    }

    void setCompressedCrcValue(long crc) {
        this.compressedCrc = crc;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    long getCompressedSize() {
        return this.compressedSize;
    }

    void setCompressedSize(long size) {
        this.compressedSize = size;
    }

    public void setContentMethods(Iterable<? extends SevenZMethodConfiguration> methods) {
        if (methods == null) goto L8;
        LinkedList<SevenZMethodConfiguration> l = new LinkedList();
        Iterator<? extends SevenZMethodConfiguration> r1 = methods.iterator();
    L5:
        if (r1.hasNext() == false) goto L7;
        SevenZMethodConfiguration m = r1.next();
        l.addLast(m);
        goto L5
    L7:
        this.contentMethods = Collections.unmodifiableList(l);
        return;
    L8:
        this.contentMethods = null;
    }

    public Iterable<? extends SevenZMethodConfiguration> getContentMethods() {
        return this.contentMethods;
    }

    public static Date ntfsTimeToJavaTime(long ntfsTime) {
        Calendar ntfsEpoch = Calendar.getInstance();
        ntfsEpoch.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        ntfsEpoch.set(1601, 0, 1, 0, 0, 0);
        ntfsEpoch.set(14, 0);
        long realTime = ntfsEpoch.getTimeInMillis() + (ntfsTime / JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return new Date(realTime);
    }

    public static long javaTimeToNtfsTime(Date date) {
        Calendar ntfsEpoch = Calendar.getInstance();
        ntfsEpoch.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        ntfsEpoch.set(1601, 0, 1, 0, 0, 0);
        ntfsEpoch.set(14, 0);
        return ((date.getTime() - ntfsEpoch.getTimeInMillis()) * 1000) * 10;
    }
}
