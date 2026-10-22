package com.android.server.net.watchlist;

import android.os.FileUtils;
import android.util.Log;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.HexDump;
import com.android.internal.util.XmlUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class WatchlistConfig {
    private static final String NETWORK_WATCHLIST_DB_FOR_TEST_PATH = "/data/misc/network_watchlist/network_watchlist_for_test.xml";
    private static final String NETWORK_WATCHLIST_DB_PATH = "/data/misc/network_watchlist/network_watchlist.xml";
    private static final String TAG = "WatchlistConfig";
    private static final WatchlistConfig sInstance = null;
    private volatile CrcShaDigests mDomainDigests;
    private volatile CrcShaDigests mIpDigests;
    private boolean mIsSecureConfig;
    private File mXmlFile;

    private static class CrcShaDigests {
        public final HarmfulCrcs crc32s;
        public final HarmfulDigests sha256Digests;

        CrcShaDigests(HarmfulCrcs crc32s, HarmfulDigests sha256Digests) {
            this.crc32s = crc32s;
            this.sha256Digests = sha256Digests;
        }
    }

    private static class XmlTags {
        private static final String CRC32_DOMAIN = "crc32-domain";
        private static final String CRC32_IP = "crc32-ip";
        private static final String HASH = "hash";
        private static final String SHA256_DOMAIN = "sha256-domain";
        private static final String SHA256_IP = "sha256-ip";
        private static final String WATCHLIST_CONFIG = "watchlist-config";

        private XmlTags() {
        }
    }

    static {
        sInstance = new WatchlistConfig();
    }

    public static WatchlistConfig getInstance() {
        return sInstance;
    }

    private WatchlistConfig() {
        this(new File(NETWORK_WATCHLIST_DB_PATH));
    }

    protected WatchlistConfig(File xmlFile) {
        this.mIsSecureConfig = true;
        this.mXmlFile = xmlFile;
        reloadConfig();
    }

    public void reloadConfig() {
        if (this.mXmlFile.exists() == true) goto L48;
        return;
    L48:
        FileInputStream stream = new FileInputStream(this.mXmlFile);     // Catch: Throwable -> L37
        List<byte[]> crc32DomainList = new ArrayList();     // Catch: Throwable -> L15
        List<byte[]> sha256DomainList = new ArrayList();     // Catch: Throwable -> L15
        List<byte[]> crc32IpList = new ArrayList();     // Catch: Throwable -> L15
        List<byte[]> sha256IpList = new ArrayList();     // Catch: Throwable -> L15
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L15
        parser.setInput(stream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L15
        parser.nextTag();     // Catch: Throwable -> L15
        parser.require(2, null, "watchlist-config");     // Catch: Throwable -> L15
    L7:
        byte r11 = 3;
        if (parser.nextTag() != 2) goto L34;
        String tagName = parser.getName();     // Catch: Throwable -> L15
        switch(tagName.hashCode()) {
            case -1862636386: goto L24;
            case -14835926: goto L21;
            case 835385997: goto L18;
            case 1718657537: goto L13;
            default: goto L26;
        };     // Catch: Throwable -> L15
    L26:
        r11 = -1;
    L27:
        switch(r11) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            default: goto L28;
        };     // Catch: Throwable -> L15
    L28:
        Log.w(TAG, "Unknown element: " + parser.getName());     // Catch: Throwable -> L15
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L15
        goto L7
    L29:
        parseHashes(parser, tagName, sha256IpList);     // Catch: Throwable -> L15
        goto L7
    L30:
        parseHashes(parser, tagName, sha256DomainList);     // Catch: Throwable -> L15
        goto L7
    L31:
        parseHashes(parser, tagName, crc32IpList);     // Catch: Throwable -> L15
        goto L7
    L32:
        parseHashes(parser, tagName, crc32DomainList);     // Catch: Throwable -> L15
        goto L7
    L13:
        if (tagName.equals("crc32-ip") == false) goto L26;
        r11 = 1;
        goto L27
    L18:
        if (tagName.equals("sha256-ip") == false) goto L26;
    L21:
        if (tagName.equals("sha256-domain") == false) goto L26;
        r11 = 2;
        goto L27
    L24:
        if (tagName.equals("crc32-domain") == false) goto L26;
        r11 = 0;
        goto L27
    L34:
        parser.require(3, null, "watchlist-config");     // Catch: Throwable -> L15
        this.mDomainDigests = new CrcShaDigests(new HarmfulCrcs(crc32DomainList), new HarmfulDigests(sha256DomainList));     // Catch: Throwable -> L15
        this.mIpDigests = new CrcShaDigests(new HarmfulCrcs(crc32IpList), new HarmfulDigests(sha256IpList));     // Catch: Throwable -> L15
        Log.i(TAG, "Reload watchlist done");     // Catch: Throwable -> L15
        stream.close();     // Catch: Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37
        return;
    L15:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L41
    L43:
        throw th;     // Catch: Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37 Throwable -> L37
    L37:
        e = move-exception;
        Slog.e(TAG, "Failed parsing xml", e);
    }

    private void parseHashes(XmlPullParser parser, String tagName, List<byte[]> hashList) throws IOException, XmlPullParserException {
        parser.require(2, null, tagName);
    L4:
        if (parser.nextTag() != 2) goto L6;
        parser.require(2, null, "hash");
        byte[] hash = HexDump.hexStringToByteArray(parser.nextText());
        parser.require(3, null, "hash");
        hashList.add(hash);
        goto L4
    L6:
        parser.require(3, null, tagName);
    }

    public boolean containsDomain(String domain) {
        CrcShaDigests domainDigests = this.mDomainDigests;
        if (domainDigests != null) goto L5;
        return false;
    L5:
        int crc32 = getCrc32(domain);
        if (domainDigests.crc32s.contains(crc32) == true) goto L8;
        return false;
    L8:
        byte[] sha256 = getSha256(domain);
        return domainDigests.sha256Digests.contains(sha256);
    }

    public boolean containsIp(String ip) {
        CrcShaDigests ipDigests = this.mIpDigests;
        if (ipDigests != null) goto L5;
        return false;
    L5:
        int crc32 = getCrc32(ip);
        if (ipDigests.crc32s.contains(crc32) == true) goto L8;
        return false;
    L8:
        byte[] sha256 = getSha256(ip);
        return ipDigests.sha256Digests.contains(sha256);
    }

    private int getCrc32(String str) {
        CRC32 crc = new CRC32();
        crc.update(str.getBytes());
        return (int) crc.getValue();
    }

    private byte[] getSha256(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");     // Catch: NoSuchAlgorithmException -> L5
        messageDigest.update(str.getBytes());
        return messageDigest.digest();
    L6:
        return null;
    }

    public boolean isConfigSecure() {
        return this.mIsSecureConfig;
    }

    public byte[] getWatchlistConfigHash() {
        if (this.mXmlFile.exists() == true) goto L10;
        return null;
    L10:
        return DigestUtils.getSha256Hash(this.mXmlFile);
    L7:
        e = move-exception;
        Log.e(TAG, "Unable to get watchlist config hash", e);
        return null;
    }

    public void setTestMode(InputStream testConfigInputStream) throws IOException {
        Log.i(TAG, "Setting watchlist testing config");
        FileUtils.copyToFileOrThrow(testConfigInputStream, new File(NETWORK_WATCHLIST_DB_FOR_TEST_PATH));
        this.mIsSecureConfig = false;
        this.mXmlFile = new File(NETWORK_WATCHLIST_DB_FOR_TEST_PATH);
        reloadConfig();
    }

    public void removeTestModeConfig() {
        File f = new File(NETWORK_WATCHLIST_DB_FOR_TEST_PATH);     // Catch: Exception -> L6
        if (f.exists() == false) goto L13;
        f.delete();     // Catch: Exception -> L6
        return;
    L13:
        return;
    L9:
        Log.e(TAG, "Unable to delete test config");
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        byte[] hash = getWatchlistConfigHash();
        StringBuilder r1 = new StringBuilder();
        r1.append("Watchlist config hash: ");
        if (hash == null) goto L5;
        String r2 = HexDump.toHexString(hash);
    L6:
        r1.append(r2);
        pw.println(r1.toString());
        pw.println("Domain CRC32 digest list:");
        if (this.mDomainDigests == null) goto L9;
        this.mDomainDigests.crc32s.dump(fd, pw, args);
    L9:
        pw.println("Domain SHA256 digest list:");
        if (this.mDomainDigests == null) goto L12;
        this.mDomainDigests.sha256Digests.dump(fd, pw, args);
    L12:
        pw.println("Ip CRC32 digest list:");
        if (this.mIpDigests == null) goto L15;
        this.mIpDigests.crc32s.dump(fd, pw, args);
    L15:
        pw.println("Ip SHA256 digest list:");
        if (this.mIpDigests == null) goto L19;
        this.mIpDigests.sha256Digests.dump(fd, pw, args);
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
