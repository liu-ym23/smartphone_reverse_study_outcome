package com.android.server.power;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class WakeLockLog {
    private static final SimpleDateFormat DATE_FORMAT = null;
    private static final boolean DEBUG = false;
    private static final int FLAG_ACQUIRE_CAUSES_WAKEUP = 16;
    private static final int FLAG_ON_AFTER_RELEASE = 8;
    private static final int FLAG_SYSTEM_WAKELOCK = 32;
    private static final int LEVEL_DOZE_WAKE_LOCK = 6;
    private static final int LEVEL_DRAW_WAKE_LOCK = 7;
    private static final int LEVEL_FULL_WAKE_LOCK = 2;
    private static final int LEVEL_PARTIAL_WAKE_LOCK = 1;
    private static final int LEVEL_PROXIMITY_SCREEN_OFF_WAKE_LOCK = 5;
    private static final int LEVEL_SCREEN_BRIGHT_WAKE_LOCK = 4;
    private static final int LEVEL_SCREEN_DIM_WAKE_LOCK = 3;
    private static final int LEVEL_SCREEN_TIMEOUT_OVERRIDE_WAKE_LOCK = 0;
    private static final String[] LEVEL_TO_STRING = null;
    private static final int LOG_SIZE = 20480;
    private static final int LOG_SIZE_MIN = 10;
    private static final int MASK_LOWER_6_BITS = 63;
    private static final int MASK_LOWER_7_BITS = 127;
    private static final int MAX_LOG_ENTRY_BYTE_SIZE = 9;
    private static final String[] REDUCED_TAG_PREFIXES = null;
    static final String SYSTEM_PACKAGE_NAME = "System";
    private static final String TAG = "PowerManagerService.WLLog";
    private static final int TAG_DATABASE_SIZE = 64;
    private static final int TAG_DATABASE_SIZE_MAX = 128;
    private static final int TAG_DATABASE_STARTING_SIZE = 16;
    private static final int TYPE_ACQUIRE = 1;
    private static final int TYPE_RELEASE = 2;
    private static final int TYPE_TIME_RESET = 0;
    private final Context mContext;
    private final SimpleDateFormat mDumpsysDateFormat;
    private final Injector mInjector;
    private final Object mLock;
    private final TheLog mLog;
    private final TagDatabase mTagDatabase;

    static class EntryByteTranslator {
        static final int ERROR_TIME_IS_NEGATIVE = -1;
        static final int ERROR_TIME_TOO_LARGE = -2;
        private final TagDatabase mTagDatabase;

        EntryByteTranslator(TagDatabase tagDatabase) {
            this.mTagDatabase = tagDatabase;
        }

        LogEntry fromBytes(byte[] bytes, long timeReference, LogEntry entryToReuse) {
            if (bytes != null) goto L5;
        L32:
            return null;
        L5:
            if (bytes.length == 0) goto L32;
            if (entryToReuse == null) goto L9;
            LogEntry r1 = entryToReuse;
        L10:
            LogEntry entry = r1;
            int type = (bytes[0] >> 6) & 3;
            if ((type & 2) != 2) goto L13;
            int type2 = 2;
        L15:
            switch(type2) {
                case 0: goto L27;
                case 1: goto L23;
                case 2: goto L18;
                default: goto L16;
            };
        L16:
            Slog.w(WakeLockLog.TAG, "Type not recognized [" + type2 + "]", new Exception());
        L29:
            return null;
        L27:
            int tagIndex = bytes.length;
            if (tagIndex < 9) goto L29;
            long time = (((long) bytes[8]) & 255) | ((((((((((long) bytes[1]) & 255) << 56) | ((((long) bytes[2]) & 255) << 48)) | ((((long) bytes[3]) & 255) << 40)) | ((((long) bytes[4]) & 255) << 32)) | ((((long) bytes[5]) & 255) << 24)) | ((((long) bytes[6]) & 255) << 16)) | ((((long) bytes[7]) & 255) << 8));
            entry.set(time, 0, null, 0);
            return entry;
        L18:
            if (bytes.length < 2) goto L29;
            int tagIndex2 = bytes[0] & 127;
            TagData tag = this.mTagDatabase.getTag(tagIndex2);
            long time2 = ((long) (bytes[1] & CecDeviceType.INACTIVE)) + timeReference;
            entry.set(time2, 2, tag, 0);
            return entry;
        L23:
            if (bytes.length < 3) goto L29;
            int flags = bytes[0] & 63;
            int tagIndex3 = bytes[1] & 127;
            TagData tag2 = this.mTagDatabase.getTag(tagIndex3);
            long time3 = ((long) (bytes[2] & CecDeviceType.INACTIVE)) + timeReference;
            entry.set(time3, 1, tag2, flags);
            return entry;
        L13:
            type2 = type;
            goto L15
        L9:
            r1 = new LogEntry();
            goto L10
        }

        int toBytes(LogEntry entry, byte[] bytes, long timeReference) {
            switch(entry.type) {
                case 0: goto L22;
                case 1: goto L14;
                case 2: goto L6;
                default: goto L5;
            };
        L6:
            int sizeNeeded = 2;
            if (bytes != null) goto L9;
        L27:
            return sizeNeeded;
        L9:
            if (bytes.length < 2) goto L27;
            int relativeTime = getRelativeTime(timeReference, entry.time);
            if (relativeTime >= 0) goto L13;
            return relativeTime;
        L13:
            bytes[0] = (byte) (this.mTagDatabase.getTagIndex(entry.tag) | 128);
            bytes[1] = (byte) (relativeTime & 255);
            goto L27
        L14:
            sizeNeeded = 3;
            if (bytes == null) goto L27;
            if (bytes.length < 3) goto L27;
            int relativeTime2 = getRelativeTime(timeReference, entry.time);
            if (relativeTime2 >= 0) goto L21;
            return relativeTime2;
        L21:
            bytes[0] = (byte) ((entry.flags & 63) | 64);
            bytes[1] = (byte) this.mTagDatabase.getTagIndex(entry.tag);
            bytes[2] = (byte) (relativeTime2 & 255);
            goto L27
        L22:
            sizeNeeded = 9;
            long time = entry.time;
            if (bytes == null) goto L27;
            if (bytes.length < 9) goto L27;
            bytes[0] = 0;
            bytes[1] = (byte) ((time >> 56) & 255);
            bytes[2] = (byte) ((time >> 48) & 255);
            bytes[3] = (byte) ((time >> 40) & 255);
            bytes[4] = (byte) ((time >> 32) & 255);
            bytes[5] = (byte) ((time >> 24) & 255);
            bytes[6] = (byte) ((time >> 16) & 255);
            bytes[7] = (byte) ((time >> 8) & 255);
            bytes[8] = (byte) (time & 255);
            goto L27
        L5:
            throw new RuntimeException("Unknown type " + entry);
        }

        private int getRelativeTime(long timeReference, long time) {
            if (time >= timeReference) goto L6;
            return -1;
        L6:
            long relativeTime = time - timeReference;
            if (relativeTime <= 255) goto L11;
            return -2;
        L11:
            return (int) relativeTime;
        }
    }

    public static class Injector {
        public Injector() {
        }

        public int getTagDatabaseSize() {
            return 64;
        }

        public int getTagDatabaseStartingSize() {
            return 16;
        }

        public int getLogSize() {
            return WakeLockLog.LOG_SIZE;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        public SimpleDateFormat getDateFormat() {
            return WakeLockLog.m7598$$Nest$sfgetDATE_FORMAT();
        }
    }

    static class LogEntry {
        public int flags;
        public String packageName;
        public TagData tag;
        public long time;
        public int type;

        LogEntry() {
        }

        LogEntry(long time, int type, TagData tag, int flags) {
            set(time, type, tag, flags);
        }

        public void set(long time, int type, TagData tag, int flags) {
            this.time = time;
            this.type = type;
            this.tag = tag;
            this.flags = flags;
        }

        public void dump(PrintWriter pw, SimpleDateFormat dateFormat) {
            pw.println("  " + toStringInternal(dateFormat));
        }

        public String toString() {
            return toStringInternal(WakeLockLog.m7598$$Nest$sfgetDATE_FORMAT());
        }

        private String toStringInternal(SimpleDateFormat dateFormat) {
            StringBuilder sb = new StringBuilder();
            if (this.type == 0) goto L5;
            sb.append(dateFormat.format(new Date(this.time)));
            sb.append(" - ");
            if (this.tag != null) goto L9;
            Object r2 = "---";
        L10:
            sb.append(r2);
            if (this.packageName == null) goto L13;
            sb.append(" (");
            sb.append(this.packageName);
            sb.append(")");
        L13:
            sb.append(" - ");
            if (this.type != 1) goto L16;
            String r1 = "ACQ";
        L17:
            sb.append(r1);
            sb.append(" ");
            if (this.tag != null) goto L20;
            String r3 = "UNKNOWN";
        L21:
            sb.append(r3);
            if (this.type != 1) goto L25;
            sb.append(" (");
            flagsToString(sb);
            sb.append(")");
        L25:
            return sb.toString();
        L20:
            r3 = this.tag.tag;
            goto L21
        L16:
            r1 = "REL";
            goto L17
        L9:
            r2 = Integer.valueOf(this.tag.ownerUid);
            goto L10
        L5:
            return dateFormat.format(new Date(this.time)) + " - RESET";
        }

        private void flagsToString(StringBuilder sb) {
            sb.append(WakeLockLog.m7599$$Nest$sfgetLEVEL_TO_STRING()[this.flags & 7]);
            if ((this.flags & 8) != 8) goto L6;
            sb.append(",on-after-release");
        L6:
            if ((this.flags & 16) != 16) goto L9;
            sb.append(",acq-causes-wake");
        L9:
            if ((this.flags & 32) != 32) goto L12;
            sb.append(",system-wakelock");
            return;
        }

        public void updatePackageName(SparseArray<String[]> uidToPackagesCache, PackageManager packageManager) {
            if (this.tag != null) goto L6;
            return;
        L6:
            if (this.tag.ownerUid != 1000) goto L9;
            this.packageName = WakeLockLog.SYSTEM_PACKAGE_NAME;
            return;
        L9:
            if (uidToPackagesCache.contains(this.tag.ownerUid) == false) goto L11;
            String[] packages = uidToPackagesCache.get(this.tag.ownerUid);
        L12:
            if (packages != null) goto L14;
            return;
        L14:
            if (packages.length <= 0) goto L21;
            this.packageName = packages[0];
            if (packages.length <= 1) goto L22;
            this.packageName += ",...";
            return;
        L22:
            return;
        L21:
            return;
        L11:
            packages = packageManager.getPackagesForUid(this.tag.ownerUid);
            uidToPackagesCache.put(this.tag.ownerUid, packages);
            goto L12
        }
    }

    static class TagData {
        public int index;
        public long lastUsedTime;
        public int ownerUid;
        public String tag;

        TagData(String tag, int ownerUid) {
            this.tag = tag;
            this.ownerUid = ownerUid;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof TagData) == false) goto L14;
            TagData other = (TagData) o;
            if (TextUtils.equals(this.tag, other.tag) == false) goto L13;
            if (this.ownerUid != other.ownerUid) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public String toString() {
            return "[" + this.ownerUid + " ; " + this.tag + "]";
        }

        int getByteSize() {
            int bytes = 0 + 8;
            if (this.tag != null) goto L5;
            int r1 = 0;
        L7:
            return (((bytes + r1) + 4) + 4) + 8;
        L5:
            r1 = this.tag.length() * 2;
            goto L7
        }
    }

    static class TagDatabase {
        private TagData[] mArray;
        private Callback mCallback;
        private final int mInvalidIndex;
        private final int mMaxArraySize;

        interface Callback {
            void onIndexRemoved(int r1);
        }

        TagDatabase(Injector injector) {
            this.mMaxArraySize = Math.min(injector.getTagDatabaseSize(), 127);
            int startingSize = Math.min(this.mMaxArraySize, injector.getTagDatabaseStartingSize());
            this.mArray = new TagData[startingSize];
            this.mInvalidIndex = this.mMaxArraySize;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Tag Database: size(");
            sb.append(this.mArray.length);
            sb.append(")");
            int entries = 0;
            int byteEstimate = 0;
            int tagSize = 0;
            int tags = 0;
            TagData[] r5 = this.mArray;
            int r6 = r5.length;
            int r7 = 0;
        L3:
            if (r7 >= r6) goto L10;
            TagData tagData = r5[r7];
            byteEstimate = byteEstimate + 8;
            if (tagData == null) goto L9;
            entries = entries + 1;
            byteEstimate = byteEstimate + tagData.getByteSize();
            if (tagData.tag == null) goto L9;
            tags = tags + 1;
            tagSize = tagSize + tagData.tag.length();
        L9:
            r7 = r7 + 1;
            goto L3
        L10:
            sb.append(", entries: ");
            sb.append(entries);
            sb.append(", Bytes used: ");
            sb.append(byteEstimate);
            return sb.toString();
        }

        public void setCallback(Callback callback) {
            this.mCallback = callback;
        }

        public TagData getTag(int index) {
            if (index >= 0) goto L4;
            return null;
        L4:
            if (index < this.mArray.length) goto L6;
            return null;
        L6:
            if (index != this.mInvalidIndex) goto L9;
            return null;
        L9:
            return this.mArray[index];
        }

        public TagData getTag(String tag, int ownerUid) {
            return findOrCreateTag(tag, ownerUid, false);
        }

        public int getTagIndex(TagData tagData) {
            if (tagData != null) goto L5;
            return this.mInvalidIndex;
        L5:
            return tagData.index;
        }

        public TagData findOrCreateTag(String tagStr, int ownerUid, boolean shouldCreate) {
            int firstAvailable = -1;
            TagData oldest = null;
            int oldestIndex = -1;
            TagData tag = new TagData(tagStr, ownerUid);
            int i = 0;
        L4:
            if (i >= this.mArray.length) goto L19;
            TagData current = this.mArray[i];
            if (tag.equals(current) == true) goto L7;
            if (shouldCreate == false) goto L17;
            if (current == null) goto L15;
            if (oldest != null) goto L13;
        L14:
            oldestIndex = i;
            oldest = current;
            goto L17
        L13:
            if (current.lastUsedTime >= oldest.lastUsedTime) goto L17;
        L15:
            if (firstAvailable != (-1)) goto L17;
            firstAvailable = i;
        L17:
            i = i + 1;
            goto L4
        L7:
            return current;
        L19:
            if (shouldCreate == true) goto L22;
            return null;
        L22:
            boolean useOldest = false;
            if (firstAvailable == (-1)) goto L25;
        L27:
            if (firstAvailable != (-1)) goto L29;
            useOldest = true;
        L29:
            if (useOldest == true) goto L31;
        L33:
            if (firstAvailable == (-1)) goto L35;
            int r5 = firstAvailable;
        L36:
            setToIndex(tag, r5);
            return tag;
        L35:
            r5 = oldestIndex;
            goto L36
        L31:
            if (this.mCallback == null) goto L33;
            this.mCallback.onIndexRemoved(oldestIndex);
            goto L33
        L25:
            if (this.mArray.length >= this.mMaxArraySize) goto L27;
            int oldSize = this.mArray.length;
            int newSize = Math.min(oldSize * 2, this.mMaxArraySize);
            TagData[] newArray = new TagData[newSize];
            System.arraycopy(this.mArray, 0, newArray, 0, oldSize);
            this.mArray = newArray;
            firstAvailable = oldSize;
            goto L27
        }

        public static void updateTagTime(TagData tag, long time) {
            if (tag == null) goto L5;
            tag.lastUsedTime = time;
            return;
        }

        private void setToIndex(TagData tag, int index) {
            if (index >= 0) goto L4;
            return;
        L4:
            if (index >= this.mArray.length) goto L12;
            TagData current = this.mArray[index];
            if (current == null) goto L9;
            current.index = this.mInvalidIndex;
        L9:
            this.mArray[index] = tag;
            tag.index = index;
            return;
        }
    }

    static class TheLog {
        private final byte[] mBuffer;
        private long mChangeCount;
        private int mEnd;
        private long mLatestTime;
        private final byte[] mReadWriteTempBuffer;
        private final List<LogEntry> mSavedAcquisitions;
        private int mStart;
        private long mStartTime;
        private final TagDatabase mTagDatabase;
        private final byte[] mTempBuffer;
        private final EntryByteTranslator mTranslator;

        /* JADX INFO: renamed from: -$$Nest$fgetmBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m7600$$Nest$fgetmBuffer(TheLog r0) {
            return r0.mBuffer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmChangeCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7601$$Nest$fgetmChangeCount(TheLog r2) {
            return r2.mChangeCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEnd, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7602$$Nest$fgetmEnd(TheLog r0) {
            return r0.mEnd;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSavedAcquisitions, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m7603$$Nest$fgetmSavedAcquisitions(TheLog r0) {
            return r0.mSavedAcquisitions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStart, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7604$$Nest$fgetmStart(TheLog r0) {
            return r0.mStart;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStartTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7605$$Nest$fgetmStartTime(TheLog r2) {
            return r2.mStartTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTranslator, reason: not valid java name */
        static /* bridge */ /* synthetic */ EntryByteTranslator m7606$$Nest$fgetmTranslator(TheLog r0) {
            return r0.mTranslator;
        }

        /* JADX INFO: renamed from: -$$Nest$mreadEntryAt, reason: not valid java name */
        static /* bridge */ /* synthetic */ LogEntry m7607$$Nest$mreadEntryAt(TheLog r0, int r1, long r2, LogEntry r4) {
            return r0.readEntryAt(r1, r2, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveTagIndex, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7608$$Nest$mremoveTagIndex(TheLog r0, int r1) {
            r0.removeTagIndex(r1);
        }

        TheLog(Injector injector, EntryByteTranslator translator, TagDatabase tagDatabase) {
            this.mTempBuffer = new byte[9];
            this.mReadWriteTempBuffer = new byte[9];
            this.mStart = 0;
            this.mEnd = 0;
            this.mStartTime = 0;
            this.mLatestTime = 0;
            this.mChangeCount = 0;
            int logSize = Math.max(injector.getLogSize(), 10);
            this.mBuffer = new byte[logSize];
            this.mTranslator = translator;
            this.mTagDatabase = tagDatabase;
            this.mTagDatabase.setCallback(new AnonymousClass1(this));
            this.mSavedAcquisitions = new ArrayList();
        }

        int getUsedBufferSize() {
            return this.mBuffer.length - getAvailableSpace();
        }

        void addEntry(LogEntry entry) {
            if (isBufferEmpty() == false) goto L5;
            long r0 = entry.time;
            this.mLatestTime = r0;
            this.mStartTime = r0;
        L5:
            int size = this.mTranslator.toBytes(entry, this.mTempBuffer, this.mLatestTime);
            if (size != (-1)) goto L9;
            return;
        L9:
            if (size != (-2)) goto L12;
            addEntry(new LogEntry(entry.time, 0, null, 0));
            size = this.mTranslator.toBytes(entry, this.mTempBuffer, this.mLatestTime);
        L12:
            if (size > 9) goto L20;
            if (size <= 0) goto L20;
            if (makeSpace(size) == true) goto L18;
            return;
        L18:
            writeBytesAt(this.mEnd, this.mTempBuffer, size);
            this.mEnd = (this.mEnd + size) % this.mBuffer.length;
            this.mLatestTime = entry.time;
            TagDatabase.updateTagTime(entry.tag, entry.time);
            this.mChangeCount++;
            return;
        L20:
            Slog.w(WakeLockLog.TAG, "Log entry size is out of expected range: " + size);
        }

        Iterator<LogEntry> getAllItems(final LogEntry tempEntry) {
            return new AnonymousClass2(this, tempEntry);
        }

        private void removeTagIndex(int tagIndex) {
            if (isBufferEmpty() == false) goto L5;
            return;
        L5:
            int readIndex = this.mStart;
            long timeReference = this.mStartTime;
            LogEntry reusableEntryInstance = new LogEntry();
        L7:
            if (readIndex == this.mEnd) goto L23;
            LogEntry entry = readEntryAt(readIndex, timeReference, reusableEntryInstance);
            if (entry == null) goto L10;
            if (entry.tag == null) goto L16;
            if (entry.tag.index != tagIndex) goto L16;
            entry.tag = null;
            writeEntryAt(readIndex, entry, timeReference);
        L16:
            timeReference = entry.time;
            int entryByteSize = this.mTranslator.toBytes(entry, null, 0);
            readIndex = (readIndex + entryByteSize) % this.mBuffer.length;
            goto L7
        L10:
            Slog.w(WakeLockLog.TAG, "Entry is unreadable - Unexpected @ " + readIndex);
            return;
        }

        private boolean makeSpace(int spaceNeeded) {
            if (this.mBuffer.length >= (spaceNeeded + 1)) goto L7;
            return false;
        L7:
            if (getAvailableSpace() >= (spaceNeeded + 1)) goto L9;
            removeOldestItem();
            goto L7
        L9:
            return true;
        }

        private int getAvailableSpace() {
            if (this.mEnd <= this.mStart) goto L6;
            return this.mBuffer.length - (this.mEnd - this.mStart);
        L6:
            if (this.mEnd >= this.mStart) goto L9;
            return this.mStart - this.mEnd;
        L9:
            return this.mBuffer.length;
        }

        private void removeOldestItem() {
            if (isBufferEmpty() == false) goto L5;
            return;
        L5:
            LogEntry entry = readEntryAt(this.mStart, this.mStartTime, null);
            if (entry.type != 1) goto L9;
            this.mSavedAcquisitions.add(entry);
        L17:
            int size = this.mTranslator.toBytes(entry, null, this.mStartTime);
            this.mStart = (this.mStart + size) % this.mBuffer.length;
            this.mStartTime = entry.time;
            this.mChangeCount++;
            return;
        L9:
            if (entry.type != 2) goto L17;
            int i = 0;
        L12:
            if (i >= this.mSavedAcquisitions.size()) goto L17;
            if (Objects.equals(this.mSavedAcquisitions.get(i).tag, entry.tag) == true) goto L15;
            i = i + 1;
            goto L12
        L15:
            this.mSavedAcquisitions.remove(i);
            goto L17
        }

        private boolean isBufferEmpty() {
            if (this.mStart != this.mEnd) goto L5;
            return true;
        L5:
            return false;
        }

        private LogEntry readEntryAt(int index, long timeReference, LogEntry entryToSet) {
            int i = 0;
        L4:
            if (i >= 9) goto L10;
            int indexIntoMainBuffer = (index + i) % this.mBuffer.length;
            if (indexIntoMainBuffer == this.mEnd) goto L10;
            this.mReadWriteTempBuffer[i] = this.mBuffer[indexIntoMainBuffer];
            i = i + 1;
        L10:
            return this.mTranslator.fromBytes(this.mReadWriteTempBuffer, timeReference, entryToSet);
        }

        private void writeEntryAt(int index, LogEntry entry, long timeReference) {
            int size = this.mTranslator.toBytes(entry, this.mReadWriteTempBuffer, timeReference);
            if (size <= 0) goto L6;
            writeBytesAt(index, this.mReadWriteTempBuffer, size);
            return;
        }

        private void writeBytesAt(int index, byte[] buffer, int size) {
            int i = 0;
        L3:
            if (i >= size) goto L6;
            int indexIntoMainBuffer = (index + i) % this.mBuffer.length;
            this.mBuffer[indexIntoMainBuffer] = buffer[i];
            i = i + 1;
            goto L3
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATE_FORMAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ SimpleDateFormat m7598$$Nest$sfgetDATE_FORMAT() {
        return DATE_FORMAT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLEVEL_TO_STRING, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m7599$$Nest$sfgetLEVEL_TO_STRING() {
        return LEVEL_TO_STRING;
    }

    static {
        LEVEL_TO_STRING = new String[]{"override", "partial", "full", "screen-dim", "screen-bright", "prox", "doze", "draw"};
        REDUCED_TAG_PREFIXES = new String[]{"*job*/", "*gms_scheduler*/", "IntentOp:"};
        DATE_FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }

    WakeLockLog(Context context) {
        this(new Injector(), context);
    }

    WakeLockLog(Injector injector, Context context) {
        this.mLock = new Object();
        this.mInjector = injector;
        this.mTagDatabase = new TagDatabase(injector);
        EntryByteTranslator translator = new EntryByteTranslator(this.mTagDatabase);
        this.mLog = new TheLog(injector, translator, this.mTagDatabase);
        this.mDumpsysDateFormat = injector.getDateFormat();
        this.mContext = context;
    }

    public void onWakeLockAcquired(String tag, int ownerUid, int flags, long eventTime) {
        onWakeLockEvent(1, tag, ownerUid, flags, eventTime);
    }

    public void onWakeLockReleased(String tag, int ownerUid, long eventTime) {
        onWakeLockEvent(2, tag, ownerUid, 0, eventTime);
    }

    public void dump(PrintWriter pw) {
        dump(pw, true);
    }

    void dump(PrintWriter pw, boolean includeTagDb) {
        Object r0 = this.mLock;     // Catch: Exception -> L27
        monitor-enter(r0);     // Catch: Exception -> L27
        pw.println("Wake Lock Log");     // Catch: Throwable -> L8
        int numEvents = 0;
        int numResets = 0;
        SparseArray<String[]> uidToPackagesCache = new SparseArray();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= TheLog.m7603$$Nest$fgetmSavedAcquisitions(this.mLog).size()) goto L10;
        numEvents = numEvents + 1;     // Catch: Throwable -> L8
        LogEntry entry = (LogEntry) TheLog.m7603$$Nest$fgetmSavedAcquisitions(this.mLog).get(i);     // Catch: Throwable -> L8
        entry.updatePackageName(uidToPackagesCache, this.mContext.getPackageManager());     // Catch: Throwable -> L8
        entry.dump(pw, this.mDumpsysDateFormat);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        LogEntry tempEntry = new LogEntry();     // Catch: Throwable -> L8
        Iterator<LogEntry> iterator = this.mLog.getAllItems(tempEntry);     // Catch: Throwable -> L8
    L12:
        if (iterator.hasNext() == false) goto L20;
        LogEntry entry2 = iterator.next();     // Catch: Throwable -> L8
        if (entry2 == null) goto L12;
        if (entry2.type != 0) goto L18;
        numResets = numResets + 1;     // Catch: Throwable -> L8
        goto L12
    L18:
        numEvents = numEvents + 1;     // Catch: Throwable -> L8
        entry2.updatePackageName(uidToPackagesCache, this.mContext.getPackageManager());     // Catch: Throwable -> L8
        entry2.dump(pw, this.mDumpsysDateFormat);     // Catch: Throwable -> L8
        goto L12
    L20:
        pw.println("  -");     // Catch: Throwable -> L8
        pw.println("  Events: " + numEvents + ", Time-Resets: " + numResets);     // Catch: Throwable -> L8
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L8
        r6.append("  Buffer, Bytes used: ");     // Catch: Throwable -> L8
        r6.append(this.mLog.getUsedBufferSize());     // Catch: Throwable -> L8
        pw.println(r6.toString());     // Catch: Throwable -> L8
        if (includeTagDb == false) goto L23;
        pw.println("  " + this.mTagDatabase);     // Catch: Throwable -> L8
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
    L38:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        pw.println("Exception dumping wake-lock log: " + e.toString());
    }

    private void onWakeLockEvent(int eventType, String tag, int ownerUid, int flags, long eventTime) {
        if (tag != null) goto L6;
        Slog.w(TAG, "Insufficient data to log wakelock [tag: " + tag + ", ownerUid: " + ownerUid + ", flags: 0x" + Integer.toHexString(flags));
        return;
    L6:
        if (eventTime != (-1)) goto L8;
        long r0 = this.mInjector.currentTimeMillis();
    L9:
        long time = r0;
        if (eventType != 1) goto L12;
        int translatedFlags = translateFlagsFromPowerManager(flags);
    L13:
        handleWakeLockEventInternal(eventType, tagNameReducer(tag), ownerUid, translatedFlags, time);
        return;
    L12:
        translatedFlags = 0;
        goto L13
    L8:
        r0 = eventTime;
        goto L9
    }

    private void handleWakeLockEventInternal(int eventType, String tag, int ownerUid, int flags, long time) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        TagData tagData = this.mTagDatabase.findOrCreateTag(tag, ownerUid, true);     // Catch: Throwable -> L11
        TheLog r0 = this.mLog;     // Catch: Throwable -> L11
        r0.addEntry(new LogEntry(time, eventType, tagData, flags));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    int translateFlagsFromPowerManager(int flags) {
        int newFlags = 0;
        switch((65535 & flags)) {
            case 1: goto L12;
            case 6: goto L11;
            case 10: goto L10;
            case 26: goto L9;
            case 32: goto L8;
            case 64: goto L7;
            case 128: goto L6;
            case 256: goto L5;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unsupported lock level for logging, flags: " + flags);
    L14:
        if ((268435456 & flags) == 0) goto L17;
        newFlags = newFlags | 16;
    L17:
        if ((536870912 & flags) == 0) goto L20;
        newFlags = newFlags | 8;
    L20:
        if ((Integer.MIN_VALUE & flags) != 0) goto L22;
        return newFlags;
    L22:
        return newFlags | 32;
    L5:
        newFlags = 0;
        goto L14
    L6:
        newFlags = 7;
        goto L14
    L7:
        newFlags = 6;
        goto L14
    L8:
        newFlags = 5;
        goto L14
    L9:
        newFlags = 2;
        goto L14
    L10:
        newFlags = 4;
        goto L14
    L11:
        newFlags = 3;
        goto L14
    L12:
        newFlags = 1;
        goto L14
    }

    private String tagNameReducer(String tag) {
        if (tag != null) goto L5;
        return null;
    L5:
        String reduciblePrefix = null;
        String[] r1 = REDUCED_TAG_PREFIXES;
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L12;
        String reducedTagPrefix = r1[r4];
        if (tag.startsWith(reducedTagPrefix) == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        reduciblePrefix = reducedTagPrefix;
    L12:
        if (reduciblePrefix == null) goto L28;
        StringBuilder sb = new StringBuilder();
        sb.append(tag, 0, reduciblePrefix.length());
        int end = Math.max(tag.lastIndexOf(SliceClientPermissions.SliceAuthority.DELIMITER), tag.lastIndexOf("."));
        boolean printNext = true;
        int index = sb.length();
    L14:
        if (index >= end) goto L26;
        char c = tag.charAt(index);
        if (c != '.') goto L18;
    L21:
        boolean isMarker = true;
    L22:
        if (isMarker == true) goto L24;
        if (printNext == true) goto L24;
    L25:
        printNext = isMarker;
        index = index + 1;
    L24:
        sb.append(c);
        goto L25
    L18:
        if (c == '/') goto L21;
        isMarker = false;
        goto L22
    L26:
        sb.append(tag.substring(index));
        return sb.toString();
    L28:
        return tag;
    }
}
