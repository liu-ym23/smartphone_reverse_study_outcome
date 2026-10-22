package org.apache.commons.compress.archivers.dump;

import com.android.server.slice.SliceClientPermissions;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes3.dex */
public class DumpArchiveEntry implements ArchiveEntry {
    private long atime;
    private long ctime;
    private int generation;
    private int gid;
    private final TapeSegmentHeader header;
    private int ino;
    private boolean isDeleted;
    private int mode;
    private long mtime;
    private String name;
    private int nlink;
    private long offset;
    private String originalName;
    private Set<PERMISSION> permissions;
    private String simpleName;
    private long size;
    private final DumpArchiveSummary summary;
    private TYPE type;
    private int uid;
    private int volume;

    public static final enum PERMISSION extends Enum<PERMISSION> {
        private static final /* synthetic */ PERMISSION[] $VALUES = null;
        public static final PERMISSION GROUP_EXEC = null;
        public static final PERMISSION GROUP_READ = null;
        public static final PERMISSION GROUP_WRITE = null;
        public static final PERMISSION SETGUI = null;
        public static final PERMISSION SETUID = null;
        public static final PERMISSION STICKY = null;
        public static final PERMISSION USER_EXEC = null;
        public static final PERMISSION USER_READ = null;
        public static final PERMISSION USER_WRITE = null;
        public static final PERMISSION WORLD_EXEC = null;
        public static final PERMISSION WORLD_READ = null;
        public static final PERMISSION WORLD_WRITE = null;
        private int code;

        private static /* synthetic */ PERMISSION[] $values() {
            return new PERMISSION[]{SETUID, SETGUI, STICKY, USER_READ, USER_WRITE, USER_EXEC, GROUP_READ, GROUP_WRITE, GROUP_EXEC, WORLD_READ, WORLD_WRITE, WORLD_EXEC};
        }

        public static PERMISSION valueOf(String name) {
            return (PERMISSION) Enum.valueOf(PERMISSION.class, name);
        }

        public static PERMISSION[] values() {
            return (PERMISSION[]) $VALUES.clone();
        }

        static {
            SETUID = new PERMISSION("SETUID", 0, 2048);
            SETGUI = new PERMISSION("SETGUI", 1, 1024);
            STICKY = new PERMISSION("STICKY", 2, 512);
            USER_READ = new PERMISSION("USER_READ", 3, 256);
            USER_WRITE = new PERMISSION("USER_WRITE", 4, 128);
            USER_EXEC = new PERMISSION("USER_EXEC", 5, 64);
            GROUP_READ = new PERMISSION("GROUP_READ", 6, 32);
            GROUP_WRITE = new PERMISSION("GROUP_WRITE", 7, 16);
            GROUP_EXEC = new PERMISSION("GROUP_EXEC", 8, 8);
            WORLD_READ = new PERMISSION("WORLD_READ", 9, 4);
            WORLD_WRITE = new PERMISSION("WORLD_WRITE", 10, 2);
            WORLD_EXEC = new PERMISSION("WORLD_EXEC", 11, 1);
            $VALUES = $values();
        }

        private PERMISSION(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public static Set<PERMISSION> find(int code) {
            Set<PERMISSION> set = new HashSet();
            PERMISSION[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            PERMISSION p = r1[r3];
            if ((p.code & code) != p.code) goto L7;
            set.add(p);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (set.isEmpty() == false) goto L13;
            return Collections.emptySet();
        L13:
            return EnumSet.copyOf(set);
        }
    }

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE BLKDEV = null;
        public static final TYPE CHRDEV = null;
        public static final TYPE DIRECTORY = null;
        public static final TYPE FIFO = null;
        public static final TYPE FILE = null;
        public static final TYPE LINK = null;
        public static final TYPE SOCKET = null;
        public static final TYPE UNKNOWN = null;
        public static final TYPE WHITEOUT = null;
        private int code;

        private static /* synthetic */ TYPE[] $values() {
            return new TYPE[]{WHITEOUT, SOCKET, LINK, FILE, BLKDEV, DIRECTORY, CHRDEV, FIFO, UNKNOWN};
        }

        public static TYPE valueOf(String name) {
            return (TYPE) Enum.valueOf(TYPE.class, name);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }

        static {
            WHITEOUT = new TYPE("WHITEOUT", 0, 14);
            SOCKET = new TYPE("SOCKET", 1, 12);
            LINK = new TYPE("LINK", 2, 10);
            FILE = new TYPE("FILE", 3, 8);
            BLKDEV = new TYPE("BLKDEV", 4, 6);
            DIRECTORY = new TYPE("DIRECTORY", 5, 4);
            CHRDEV = new TYPE("CHRDEV", 6, 2);
            FIFO = new TYPE("FIFO", 7, 1);
            UNKNOWN = new TYPE("UNKNOWN", 8, 15);
            $VALUES = $values();
        }

        private TYPE(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public static TYPE find(int code) {
            TYPE type = UNKNOWN;
            TYPE[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            TYPE t = r1[r3];
            if (code != t.code) goto L7;
            type = t;
        L7:
            r3 = r3 + 1;
            goto L3
        L8:
            return type;
        }
    }

    static class TapeSegmentHeader {
        private final byte[] cdata;
        private int count;
        private int holes;
        private int ino;
        private DumpArchiveConstants.SEGMENT_TYPE type;
        private int volume;

        TapeSegmentHeader() {
            this.cdata = new byte[512];
        }

        static /* synthetic */ DumpArchiveConstants.SEGMENT_TYPE access$002(TapeSegmentHeader x0, DumpArchiveConstants.SEGMENT_TYPE x1) {
            x0.type = x1;
            return x1;
        }

        static /* synthetic */ int access$102(TapeSegmentHeader x0, int x1) {
            x0.volume = x1;
            return x1;
        }

        static /* synthetic */ int access$202(TapeSegmentHeader x0, int x1) {
            x0.ino = x1;
            return x1;
        }

        static /* synthetic */ int access$300(TapeSegmentHeader x0) {
            return x0.count;
        }

        static /* synthetic */ int access$302(TapeSegmentHeader x0, int x1) {
            x0.count = x1;
            return x1;
        }

        static /* synthetic */ int access$402(TapeSegmentHeader x0, int x1) {
            x0.holes = x1;
            return x1;
        }

        static /* synthetic */ int access$408(TapeSegmentHeader x0) {
            int r0 = x0.holes;
            x0.holes = r0 + 1;
            return r0;
        }

        static /* synthetic */ byte[] access$500(TapeSegmentHeader x0) {
            return x0.cdata;
        }

        public DumpArchiveConstants.SEGMENT_TYPE getType() {
            return this.type;
        }

        public int getVolume() {
            return this.volume;
        }

        public int getIno() {
            return this.ino;
        }

        void setIno(int ino) {
            this.ino = ino;
        }

        public int getCount() {
            return this.count;
        }

        public int getHoles() {
            return this.holes;
        }

        public int getCdata(int idx) {
            return this.cdata[idx];
        }
    }

    public DumpArchiveEntry() {
        this.type = TYPE.UNKNOWN;
        this.permissions = Collections.emptySet();
        this.summary = null;
        this.header = new TapeSegmentHeader();
    }

    public DumpArchiveEntry(String name, String simpleName) {
        this.type = TYPE.UNKNOWN;
        this.permissions = Collections.emptySet();
        this.summary = null;
        this.header = new TapeSegmentHeader();
        setName(name);
        this.simpleName = simpleName;
    }

    protected DumpArchiveEntry(String name, String simpleName, int ino, TYPE type) {
        this.type = TYPE.UNKNOWN;
        this.permissions = Collections.emptySet();
        this.summary = null;
        this.header = new TapeSegmentHeader();
        setType(type);
        setName(name);
        this.simpleName = simpleName;
        this.ino = ino;
        this.offset = 0;
    }

    public String getSimpleName() {
        return this.simpleName;
    }

    protected void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public int getIno() {
        return this.header.getIno();
    }

    public int getNlink() {
        return this.nlink;
    }

    public void setNlink(int nlink) {
        this.nlink = nlink;
    }

    public Date getCreationTime() {
        return new Date(this.ctime);
    }

    public void setCreationTime(Date ctime) {
        this.ctime = ctime.getTime();
    }

    public int getGeneration() {
        return this.generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public DumpArchiveConstants.SEGMENT_TYPE getHeaderType() {
        return this.header.getType();
    }

    public int getHeaderCount() {
        return this.header.getCount();
    }

    public int getHeaderHoles() {
        return this.header.getHoles();
    }

    public boolean isSparseRecord(int idx) {
        if ((this.header.getCdata(idx) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int hashCode() {
        return this.ino;
    }

    public boolean equals(Object o) {
        if (o != this) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L26:
        return false;
    L8:
        if (o.getClass().equals(getClass()) == false) goto L26;
        DumpArchiveEntry rhs = (DumpArchiveEntry) o;
        if (rhs.header != null) goto L14;
        return false;
    L14:
        if (this.ino == rhs.ino) goto L17;
        return false;
    L17:
        if (this.summary != null) goto L21;
        if (rhs.summary == null) goto L21;
    L24:
        return false;
    L21:
        if (this.summary != null) goto L23;
    L25:
        return true;
    L23:
        if (this.summary.equals(rhs.summary) == true) goto L25;
        goto L24
    }

    public String toString() {
        return getName();
    }

    static DumpArchiveEntry parse(byte[] buffer) {
        DumpArchiveEntry entry = new DumpArchiveEntry();
        TapeSegmentHeader header = entry.header;
        TapeSegmentHeader.access$002(header, DumpArchiveConstants.SEGMENT_TYPE.find(DumpArchiveUtil.convert32(buffer, 0)));
        TapeSegmentHeader.access$102(header, DumpArchiveUtil.convert32(buffer, 12));
        entry.ino = TapeSegmentHeader.access$202(header, DumpArchiveUtil.convert32(buffer, 20));
        int m = DumpArchiveUtil.convert16(buffer, 32);
        entry.setType(TYPE.find((m >> 12) & 15));
        entry.setMode(m);
        entry.nlink = DumpArchiveUtil.convert16(buffer, 34);
        entry.setSize(DumpArchiveUtil.convert64(buffer, 40));
        long t = (((long) DumpArchiveUtil.convert32(buffer, 48)) * 1000) + ((long) (DumpArchiveUtil.convert32(buffer, 52) / 1000));
        entry.setAccessTime(new Date(t));
        long t2 = (((long) DumpArchiveUtil.convert32(buffer, 56)) * 1000) + ((long) (DumpArchiveUtil.convert32(buffer, 60) / 1000));
        entry.setLastModifiedDate(new Date(t2));
        long t3 = (((long) DumpArchiveUtil.convert32(buffer, 64)) * 1000) + ((long) (DumpArchiveUtil.convert32(buffer, 68) / 1000));
        entry.ctime = t3;
        entry.generation = DumpArchiveUtil.convert32(buffer, 140);
        entry.setUserId(DumpArchiveUtil.convert32(buffer, 144));
        entry.setGroupId(DumpArchiveUtil.convert32(buffer, 148));
        TapeSegmentHeader.access$302(header, DumpArchiveUtil.convert32(buffer, 160));
        TapeSegmentHeader.access$402(header, 0);
        int i = 0;
    L4:
        if (i >= 512) goto L11;
        if (i >= TapeSegmentHeader.access$300(header)) goto L11;
        if (buffer[i + 164] != 0) goto L10;
        TapeSegmentHeader.access$408(header);
    L10:
        i = i + 1;
    L11:
        System.arraycopy(buffer, 164, TapeSegmentHeader.access$500(header), 0, 512);
        entry.volume = header.getVolume();
        return entry;
    }

    void update(byte[] buffer) {
        TapeSegmentHeader.access$102(this.header, DumpArchiveUtil.convert32(buffer, 16));
        TapeSegmentHeader.access$302(this.header, DumpArchiveUtil.convert32(buffer, 160));
        TapeSegmentHeader.access$402(this.header, 0);
        int i = 0;
    L4:
        if (i >= 512) goto L11;
        if (i >= TapeSegmentHeader.access$300(this.header)) goto L11;
        if (buffer[i + 164] != 0) goto L10;
        TapeSegmentHeader.access$408(this.header);
    L10:
        i = i + 1;
    L11:
        System.arraycopy(buffer, 164, TapeSegmentHeader.access$500(this.header), 0, 512);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    String getOriginalName() {
        return this.originalName;
    }

    public final void setName(String name) {
        this.originalName = name;
        if (name != null) goto L5;
    L12:
        this.name = name;
        return;
    L5:
        if (isDirectory() == false) goto L10;
        if (name.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L10;
        name = name + SliceClientPermissions.SliceAuthority.DELIMITER;
    L10:
        if (name.startsWith("./") == false) goto L12;
        name = name.substring(2);
        goto L12
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(this.mtime);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        if (this.type != TYPE.DIRECTORY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFile() {
        if (this.type != TYPE.FILE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSocket() {
        if (this.type != TYPE.SOCKET) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isChrDev() {
        if (this.type != TYPE.CHRDEV) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBlkDev() {
        if (this.type != TYPE.BLKDEV) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFifo() {
        if (this.type != TYPE.FIFO) goto L5;
        return true;
    L5:
        return false;
    }

    public TYPE getType() {
        return this.type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode & UnixStat.PERM_MASK;
        this.permissions = PERMISSION.find(mode);
    }

    public Set<PERMISSION> getPermissions() {
        return this.permissions;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        if (isDirectory() == false) goto L6;
        return -1;
    L6:
        return this.size;
    }

    long getEntrySize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setLastModifiedDate(Date mtime) {
        this.mtime = mtime.getTime();
    }

    public Date getAccessTime() {
        return new Date(this.atime);
    }

    public void setAccessTime(Date atime) {
        this.atime = atime.getTime();
    }

    public int getUserId() {
        return this.uid;
    }

    public void setUserId(int uid) {
        this.uid = uid;
    }

    public int getGroupId() {
        return this.gid;
    }

    public void setGroupId(int gid) {
        this.gid = gid;
    }
}
