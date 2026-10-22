package org.apache.commons.compress.archivers.tar;

import android.hardware.tv.mediaquality.ParameterName;
import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TarArchiveEntry implements ArchiveEntry, TarConstants {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRIES = null;
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final File file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    static {
        EMPTY_TAR_ARCHIVE_ENTRIES = new TarArchiveEntry[0];
    }

    private TarArchiveEntry(boolean preserveAbsolutePath) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String user = System.getProperty("user.name", "");
        if (user.length() <= 31) goto L5;
        user = user.substring(0, 31);
    L5:
        this.userName = user;
        this.file = null;
        this.preserveAbsolutePath = preserveAbsolutePath;
    }

    public TarArchiveEntry(String name) {
        this(name, false);
    }

    public TarArchiveEntry(String name, boolean preserveAbsolutePath) {
        this(preserveAbsolutePath);
        String name2 = normalizeFileName(name, preserveAbsolutePath);
        boolean isDir = name2.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER);
        this.name = name2;
        if (isDir == false) goto L5;
        int r1 = DEFAULT_DIR_MODE;
    L6:
        this.mode = r1;
        if (isDir == false) goto L9;
        byte r2 = 53;
    L10:
        this.linkFlag = r2;
        this.modTime = new Date().getTime() / 1000;
        this.userName = "";
        return;
    L9:
        r2 = 48;
        goto L10
    L5:
        r1 = DEFAULT_FILE_MODE;
        goto L6
    }

    public TarArchiveEntry(String name, byte linkFlag) {
        this(name, linkFlag, false);
    }

    public TarArchiveEntry(String name, byte linkFlag, boolean preserveAbsolutePath) {
        this(name, preserveAbsolutePath);
        this.linkFlag = linkFlag;
        if (linkFlag != 76) goto L6;
        this.magic = TarConstants.MAGIC_GNU;
        this.version = TarConstants.VERSION_GNU_SPACE;
        return;
    }

    public TarArchiveEntry(File file) {
        this(file, file.getPath());
    }

    public TarArchiveEntry(File file, String fileName) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String normalizedName = normalizeFileName(fileName, false);
        this.file = file;
        if (file.isDirectory() == false) goto L12;
        this.mode = DEFAULT_DIR_MODE;
        this.linkFlag = 53;
        int nameLength = normalizedName.length();
        if (nameLength != 0) goto L7;
    L10:
        this.name = normalizedName + SliceClientPermissions.SliceAuthority.DELIMITER;
    L13:
        this.modTime = file.lastModified() / 1000;
        this.userName = "";
        this.preserveAbsolutePath = false;
        return;
    L7:
        if (normalizedName.charAt(nameLength - 1) != '/') goto L10;
        this.name = normalizedName;
        goto L13
    L12:
        this.mode = DEFAULT_FILE_MODE;
        this.linkFlag = 48;
        this.size = file.length();
        this.name = normalizedName;
        goto L13
    }

    public TarArchiveEntry(byte[] headerBuf) {
        this(false);
        parseTarHeader(headerBuf);
    }

    public TarArchiveEntry(byte[] headerBuf, ZipEncoding encoding) throws IOException {
        this(false);
        parseTarHeader(headerBuf, encoding);
    }

    public boolean equals(TarArchiveEntry it) {
        if (it != null) goto L4;
    L6:
        return false;
    L4:
        if (getName().equals(it.getName()) == false) goto L6;
        return true;
    }

    public boolean equals(Object it) {
        if (it != null) goto L4;
        return false;
    L4:
        if (getClass() == it.getClass()) goto L7;
        return false;
    L7:
        return equals((TarArchiveEntry) it);
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isDescendent(TarArchiveEntry desc) {
        return desc.getName().startsWith(getName());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = normalizeFileName(name, this.preserveAbsolutePath);
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String link) {
        this.linkName = link;
    }

    @Deprecated
    public int getUserId() {
        return (int) (this.userId & (-1));
    }

    public void setUserId(int userId) {
        setUserId(userId);
    }

    public long getLongUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Deprecated
    public int getGroupId() {
        return (int) (this.groupId & (-1));
    }

    public void setGroupId(int groupId) {
        setGroupId(groupId);
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setIds(int userId, int groupId) {
        setUserId(userId);
        setGroupId(groupId);
    }

    public void setNames(String userName, String groupName) {
        setUserName(userName);
        setGroupName(groupName);
    }

    public void setModTime(long time) {
        this.modTime = time / 1000;
    }

    public void setModTime(Date time) {
        this.modTime = time.getTime() / 1000;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return getModTime();
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public File getFile() {
        return this.file;
    }

    public int getMode() {
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        if (size < 0) goto L7;
        this.size = size;
        return;
    L7:
        throw new IllegalArgumentException("Size is out of range: " + size);
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public void setDevMajor(int devNo) {
        if (devNo < 0) goto L6;
        this.devMajor = devNo;
        return;
    L6:
        throw new IllegalArgumentException("Major device number is out of range: " + devNo);
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public void setDevMinor(int devNo) {
        if (devNo < 0) goto L6;
        this.devMinor = devNo;
        return;
    L6:
        throw new IllegalArgumentException("Minor device number is out of range: " + devNo);
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public long getRealSize() {
        return this.realSize;
    }

    public boolean isGNUSparse() {
        if (isOldGNUSparse() == false) goto L5;
    L8:
        return true;
    L5:
        if (isPaxGNUSparse() == true) goto L8;
        return false;
    }

    public boolean isOldGNUSparse() {
        if (this.linkFlag != 83) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    public boolean isGNULongLinkEntry() {
        if (this.linkFlag != 75) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGNULongNameEntry() {
        if (this.linkFlag != 76) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPaxHeader() {
        if (this.linkFlag != 120) goto L5;
    L8:
        return true;
    L5:
        if (this.linkFlag == 88) goto L8;
        return false;
    }

    public boolean isGlobalPaxHeader() {
        if (this.linkFlag != 103) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        if (this.file == null) goto L7;
        return this.file.isDirectory();
    L7:
        if (this.linkFlag != 53) goto L10;
        return true;
    L10:
        if (isPaxHeader() == false) goto L12;
    L16:
        return false;
    L12:
        if (isGlobalPaxHeader() == true) goto L16;
        if (getName().endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L16;
        return true;
    }

    public boolean isFile() {
        if (this.file == null) goto L7;
        return this.file.isFile();
    L7:
        if (this.linkFlag != 0) goto L9;
    L13:
        return true;
    L9:
        if (this.linkFlag == 48) goto L13;
        return !getName().endsWith(SliceClientPermissions.SliceAuthority.DELIMITER);
    }

    public boolean isSymbolicLink() {
        if (this.linkFlag != 50) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLink() {
        if (this.linkFlag != 49) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCharacterDevice() {
        if (this.linkFlag != 51) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBlockDevice() {
        if (this.linkFlag != 52) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFIFO() {
        if (this.linkFlag != 54) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSparse() {
        if (isGNUSparse() == false) goto L5;
    L8:
        return true;
    L5:
        if (isStarSparse() == true) goto L8;
        return false;
    }

    public Map<String, String> getExtraPaxHeaders() {
        return Collections.unmodifiableMap(this.extraPaxHeaders);
    }

    public void clearExtraPaxHeaders() {
        this.extraPaxHeaders.clear();
    }

    public void addPaxHeader(String name, String value) {
        processPaxHeader(name, value);
    }

    public String getExtraPaxHeader(String name) {
        return this.extraPaxHeaders.get(name);
    }

    void updateEntryFromPaxHeaders(Map<String, String> headers) {
        Iterator<Map.Entry<String, String>> r0 = headers.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> ent = r0.next();
        String key = ent.getKey();
        String val = ent.getValue();
        processPaxHeader(key, val, headers);
        goto L4
    }

    private void processPaxHeader(String key, String val) {
        processPaxHeader(key, val, this.extraPaxHeaders);
    }

    private void processPaxHeader(String key, String val, Map<String, String> headers) {
        switch(key.hashCode()) {
            case -1916861932: goto L42;
            case -1916619760: goto L39;
            case -277496563: goto L36;
            case -160380561: goto L33;
            case 102338: goto L30;
            case 115792: goto L27;
            case 3433509: goto L24;
            case 3530753: goto L21;
            case 98496370: goto L18;
            case 104223930: goto L15;
            case 111425664: goto L12;
            case 530706950: goto L9;
            case 1195018015: goto L6;
            default: goto L44;
        };
    L44:
        byte r0 = -1;
    L45:
        switch(r0) {
            case 0: goto L61;
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L54;
            case 8: goto L53;
            case 9: goto L52;
            case 10: goto L51;
            case 11: goto L50;
            case 12: goto L48;
            default: goto L46;
        };
    L46:
        this.extraPaxHeaders.put(key, val);
        return;
    L50:
        fillGNUSparse1xData(headers);
        return;
    L51:
        fillGNUSparse0xData(headers);
        return;
    L52:
        setDevMajor(Integer.parseInt(val));
        return;
    L53:
        setDevMinor(Integer.parseInt(val));
        return;
    L54:
        setModTime((long) (Double.parseDouble(val) * 1000.0d));
        return;
    L55:
        setSize(Long.parseLong(val));
        return;
    L56:
        setUserName(val);
        return;
    L57:
        setUserId(Long.parseLong(val));
        return;
    L58:
        setGroupName(val);
        return;
    L59:
        setGroupId(Long.parseLong(val));
        return;
    L60:
        setLinkName(val);
        return;
    L61:
        setName(val);
        return;
    L48:
        if ("sparse".equals(val) == false) goto L64;
        fillStarSparseData(headers);
        return;
    L64:
        return;
    L6:
        if (key.equals("linkpath") == false) goto L44;
        r0 = 1;
        goto L45
    L9:
        if (key.equals("SCHILY.filetype") == false) goto L44;
        r0 = 12;
        goto L45
    L12:
        if (key.equals("uname") == false) goto L44;
        r0 = 5;
        goto L45
    L15:
        if (key.equals("mtime") == false) goto L44;
        r0 = 7;
        goto L45
    L18:
        if (key.equals("gname") == false) goto L44;
        r0 = 3;
        goto L45
    L21:
        if (key.equals("size") == false) goto L44;
        r0 = 6;
        goto L45
    L24:
        if (key.equals("path") == false) goto L44;
        r0 = 0;
        goto L45
    L27:
        if (key.equals("uid") == false) goto L44;
        r0 = 4;
        goto L45
    L30:
        if (key.equals("gid") == false) goto L44;
        r0 = 2;
        goto L45
    L33:
        if (key.equals("GNU.sparse.size") == false) goto L44;
        r0 = 10;
        goto L45
    L36:
        if (key.equals("GNU.sparse.realsize") == false) goto L44;
        r0 = 11;
        goto L45
    L39:
        if (key.equals("SCHILY.devminor") == false) goto L44;
        r0 = 8;
        goto L45
    L42:
        if (key.equals("SCHILY.devmajor") == false) goto L44;
        r0 = 9;
        goto L45
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        if (this.file == null) goto L18;
        if (this.file.isDirectory() == false) goto L18;
        String[] list = this.file.list();
        if (list == null) goto L10;
        TarArchiveEntry[] result = new TarArchiveEntry[list.length];
        int i = 0;
    L13:
        if (i >= result.length) goto L16;
        result[i] = new TarArchiveEntry(new File(this.file, list[i]));
        i = i + 1;
        goto L13
    L16:
        return result;
    L10:
        return EMPTY_TAR_ARCHIVE_ENTRIES;
    L18:
        return EMPTY_TAR_ARCHIVE_ENTRIES;
    }

    public void writeEntryHeader(byte[] outbuf) {
        writeEntryHeader(outbuf, TarUtils.DEFAULT_ENCODING, false);     // Catch: IOException -> L5
        return;
    L13:
        writeEntryHeader(outbuf, TarUtils.FALLBACK_ENCODING, false);     // Catch: IOException -> L8
        return;
    L8:
        ex2 = move-exception;
        throw new RuntimeException(ex2);
    }

    public void writeEntryHeader(byte[] outbuf, ZipEncoding encoding, boolean starMode) throws IOException {
        int offset = TarUtils.formatNameBytes(this.name, outbuf, 0, 100, encoding);
        int offset2 = this.mode;
        int offset3 = writeEntryHeaderField(this.modTime, outbuf, writeEntryHeaderField(this.size, outbuf, writeEntryHeaderField(this.groupId, outbuf, writeEntryHeaderField(this.userId, outbuf, writeEntryHeaderField(offset2, outbuf, offset, 8, starMode), 8, starMode), 8, starMode), 12, starMode), 12, starMode);
        int c = 0;
    L4:
        if (c >= 8) goto L6;
        outbuf[offset3] = ParameterName.CVRR;
        c = c + 1;
        offset3 = offset3 + 1;
        goto L4
    L6:
        int c2 = offset3 + 1;
        outbuf[offset3] = this.linkFlag;
        int offset4 = TarUtils.formatNameBytes(this.linkName, outbuf, c2, 100, encoding);
        int offset5 = TarUtils.formatNameBytes(this.groupName, outbuf, TarUtils.formatNameBytes(this.userName, outbuf, TarUtils.formatNameBytes(this.version, outbuf, TarUtils.formatNameBytes(this.magic, outbuf, offset4, 6), 2), 32, encoding), 32, encoding);
        int offset6 = this.devMajor;
        int offset7 = writeEntryHeaderField(this.devMinor, outbuf, writeEntryHeaderField(offset6, outbuf, offset5, 8, starMode), 8, starMode);
    L8:
        if (offset7 >= outbuf.length) goto L10;
        outbuf[offset7] = 0;
        offset7 = offset7 + 1;
        goto L8
    L10:
        long chk = TarUtils.computeCheckSum(outbuf);
        TarUtils.formatCheckSumOctalBytes(chk, outbuf, offset3, 8);
    }

    private int writeEntryHeaderField(long value, byte[] outbuf, int offset, int length, boolean starMode) {
        if (starMode == true) goto L10;
        if (value < 0) goto L8;
        if (value < (1 << ((length - 1) * 3))) goto L10;
    L8:
        return TarUtils.formatLongOctalBytes(0, outbuf, offset, length);
    L10:
        return TarUtils.formatLongOctalOrBinaryBytes(value, outbuf, offset, length);
    }

    public void parseTarHeader(byte[] header) {
        parseTarHeader(header, TarUtils.DEFAULT_ENCODING);     // Catch: IOException -> L4
        return;
    L12:
        parseTarHeader(header, TarUtils.DEFAULT_ENCODING, true);     // Catch: IOException -> L7
        return;
    L7:
        ex2 = move-exception;
        throw new RuntimeException(ex2);
    }

    public void parseTarHeader(byte[] header, ZipEncoding encoding) throws IOException {
        parseTarHeader(header, encoding, false);
    }

    private void parseTarHeader(byte[] header, ZipEncoding encoding, boolean oldStyle) throws IOException {
        if (oldStyle == false) goto L5;
        String r2 = TarUtils.parseName(header, 0, 100);
    L6:
        this.name = r2;
        int offset = 0 + 100;
        this.mode = (int) TarUtils.parseOctalOrBinary(header, offset, 8);
        int offset2 = offset + 8;
        this.userId = (int) TarUtils.parseOctalOrBinary(header, offset2, 8);
        int offset3 = offset2 + 8;
        this.groupId = (int) TarUtils.parseOctalOrBinary(header, offset3, 8);
        int offset4 = offset3 + 8;
        this.size = TarUtils.parseOctalOrBinary(header, offset4, 12);
        int offset5 = offset4 + 12;
        this.modTime = TarUtils.parseOctalOrBinary(header, offset5, 12);
        this.checkSumOK = TarUtils.verifyCheckSum(header);
        int offset6 = (offset5 + 12) + 8;
        int offset7 = offset6 + 1;
        this.linkFlag = header[offset6];
        if (oldStyle == false) goto L9;
        String r0 = TarUtils.parseName(header, offset7, 100);
    L10:
        this.linkName = r0;
        int offset8 = offset7 + 100;
        this.magic = TarUtils.parseName(header, offset8, 6);
        int offset9 = offset8 + 6;
        this.version = TarUtils.parseName(header, offset9, 2);
        int offset10 = offset9 + 2;
        if (oldStyle == false) goto L13;
        String r1 = TarUtils.parseName(header, offset10, 32);
    L14:
        this.userName = r1;
        int offset11 = offset10 + 32;
        if (oldStyle == false) goto L17;
        String r3 = TarUtils.parseName(header, offset11, 32);
    L18:
        this.groupName = r3;
        int offset12 = offset11 + 32;
        if (this.linkFlag != 51) goto L21;
    L24:
        this.devMajor = (int) TarUtils.parseOctalOrBinary(header, offset12, 8);
        int offset13 = offset12 + 8;
        this.devMinor = (int) TarUtils.parseOctalOrBinary(header, offset13, 8);
        int offset14 = offset13 + 8;
    L25:
        int type = evaluateType(header);
        switch(type) {
            case 2: goto L46;
            case 3: goto L28;
            case 4: goto L40;
            default: goto L28;
        };
    L46:
        int offset15 = (((((offset14 + 12) + 12) + 12) + 4) + 1) + 96;
        this.isExtended = TarUtils.parseBoolean(header, offset15);
        int offset16 = offset15 + 1;
        this.realSize = TarUtils.parseOctal(header, offset16, 12);
        int r4 = offset16 + 12;
        return;
    L28:
        if (oldStyle == false) goto L30;
        String prefix = TarUtils.parseName(header, offset14, 155);
    L32:
        if (isDirectory() == false) goto L37;
        if (this.name.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L37;
        this.name += SliceClientPermissions.SliceAuthority.DELIMITER;
    L37:
        if (prefix.length() <= 0) goto L48;
        this.name = prefix + SliceClientPermissions.SliceAuthority.DELIMITER + this.name;
        return;
    L48:
        return;
    L30:
        prefix = TarUtils.parseName(header, offset14, 155, encoding);
        goto L32
    L40:
        if (oldStyle == false) goto L42;
        String xstarPrefix = TarUtils.parseName(header, offset14, 131);
    L44:
        if (xstarPrefix.length() <= 0) goto L50;
        this.name = xstarPrefix + SliceClientPermissions.SliceAuthority.DELIMITER + this.name;
        return;
    L50:
        return;
    L42:
        xstarPrefix = TarUtils.parseName(header, offset14, 131, encoding);
        goto L44
    L21:
        if (this.linkFlag == 52) goto L24;
        offset14 = offset12 + 16;
        goto L25
    L17:
        r3 = TarUtils.parseName(header, offset11, 32, encoding);
        goto L18
    L13:
        r1 = TarUtils.parseName(header, offset10, 32, encoding);
        goto L14
    L9:
        r0 = TarUtils.parseName(header, offset7, 100, encoding);
        goto L10
    L5:
        r2 = TarUtils.parseName(header, 0, 100, encoding);
        goto L6
    }

    private static String normalizeFileName(String fileName, boolean preserveAbsolutePath) {
        if (preserveAbsolutePath == true) goto L27;
        String osname = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (osname == null) goto L27;
        if (osname.startsWith("windows") == false) goto L23;
        if (fileName.length() <= 2) goto L27;
        char ch1 = fileName.charAt(0);
        char ch2 = fileName.charAt(1);
        if (ch2 != ':') goto L27;
        if (ch1 < 'a') goto L17;
        if (ch1 > 'z') goto L17;
    L20:
        fileName = fileName.substring(2);
    L17:
        if (ch1 < 'A') goto L27;
        if (ch1 > 'Z') goto L27;
    L23:
        if (osname.contains("netware") == false) goto L27;
        int colon = fileName.indexOf(58);
        if (colon == (-1)) goto L27;
        fileName = fileName.substring(colon + 1);
    L27:
        String fileName2 = fileName.replace(File.separatorChar, '/');
    L28:
        if (preserveAbsolutePath == true) goto L32;
        if (fileName2.startsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L32;
        fileName2 = fileName2.substring(1);
    L32:
        return fileName2;
    }

    private int evaluateType(byte[] header) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, header, 257, 6) == false) goto L7;
        return 2;
    L7:
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", header, 257, 6) == true) goto L9;
        return 0;
    L9:
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, header, TarConstants.XSTAR_MAGIC_OFFSET, 4) == false) goto L11;
        return 4;
    L11:
        return 3;
    }

    void fillGNUSparse0xData(Map<String, String> headers) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(headers.get("GNU.sparse.size"));
        if (headers.containsKey("GNU.sparse.name") == false) goto L6;
        this.name = headers.get("GNU.sparse.name");
        return;
    }

    void fillGNUSparse1xData(Map<String, String> headers) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(headers.get("GNU.sparse.realsize"));
        this.name = headers.get("GNU.sparse.name");
    }

    void fillStarSparseData(Map<String, String> headers) {
        this.starSparse = true;
        if (headers.containsKey("SCHILY.realsize") == false) goto L6;
        this.realSize = Long.parseLong(headers.get("SCHILY.realsize"));
        return;
    }
}
