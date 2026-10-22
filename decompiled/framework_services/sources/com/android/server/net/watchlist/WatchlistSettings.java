package com.android.server.net.watchlist;

import android.os.Environment;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.HexDump;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class WatchlistSettings {
    private static final String FILE_NAME = "watchlist_settings.xml";
    private static final int SECRET_KEY_LENGTH = 48;
    private static final String TAG = "WatchlistSettings";
    private static final WatchlistSettings sInstance = null;
    private byte[] mPrivacySecretKey;
    private final AtomicFile mXmlFile;

    static {
        sInstance = new WatchlistSettings();
    }

    public static WatchlistSettings getInstance() {
        return sInstance;
    }

    private WatchlistSettings() {
        this(getSystemWatchlistFile());
    }

    static File getSystemWatchlistFile() {
        return new File(Environment.getDataSystemDirectory(), FILE_NAME);
    }

    protected WatchlistSettings(File xmlFile) {
        this.mPrivacySecretKey = null;
        this.mXmlFile = new AtomicFile(xmlFile, "net-watchlist");
        reloadSettings();
        if (this.mPrivacySecretKey != null) goto L6;
        this.mPrivacySecretKey = generatePrivacySecretKey();
        saveSettings();
        return;
    }

    private void reloadSettings() {
        if (this.mXmlFile.exists() == true) goto L34;
        return;
    L34:
        FileInputStream stream = this.mXmlFile.openRead();     // Catch: Throwable -> L18
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L12
        XmlUtils.beginDocument(parser, "network-watchlist-settings");     // Catch: Throwable -> L12
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L12
    L8:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L14;
        if (parser.getName().equals("secret-key") == false) goto L8;
        this.mPrivacySecretKey = parseSecretKey(parser);     // Catch: Throwable -> L12
        goto L8
    L14:
        Slog.i(TAG, "Reload watchlist settings done");     // Catch: Throwable -> L12
        if (stream == null) goto L40;
        stream.close();     // Catch: Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18
        return;
    L40:
        return;
    L12:
        th = move-exception;
        if (stream != null) goto L32;
    L27:
        throw th;     // Catch: Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18
    L32:
        stream.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18
    L18:
        e = move-exception;
        Slog.e(TAG, "Failed parsing xml", e);
    }

    private byte[] parseSecretKey(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(2, null, "secret-key");
        byte[] key = HexDump.hexStringToByteArray(parser.nextText());
        parser.require(3, null, "secret-key");
        if (key != null) goto L5;
    L8:
        Log.e(TAG, "Unable to parse secret key");
        return null;
    L5:
        if (key.length != 48) goto L8;
        return key;
    }

    synchronized byte[] getPrivacySecretKey() {
        monitor-enter(this);
        byte[] key = new byte[48];     // Catch: Throwable -> L7
        System.arraycopy(this.mPrivacySecretKey, 0, key, 0, 48);     // Catch: Throwable -> L7
        monitor-exit(this);
        return key;
    L7:
        th = move-exception;
        throw th;
    }

    private byte[] generatePrivacySecretKey() {
        byte[] key = new byte[48];
        new SecureRandom().nextBytes(key);
        return key;
    }

    private void saveSettings() {
        FileOutputStream stream = this.mXmlFile.startWrite();     // Catch: IOException -> L9
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: IOException -> L6
        out.startDocument(null, true);     // Catch: IOException -> L6
        out.startTag(null, "network-watchlist-settings");     // Catch: IOException -> L6
        out.startTag(null, "secret-key");     // Catch: IOException -> L6
        out.text(HexDump.toHexString(this.mPrivacySecretKey));     // Catch: IOException -> L6
        out.endTag(null, "secret-key");     // Catch: IOException -> L6
        out.endTag(null, "network-watchlist-settings");     // Catch: IOException -> L6
        out.endDocument();     // Catch: IOException -> L6
        this.mXmlFile.finishWrite(stream);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to write display settings, restoring backup.", e);
        this.mXmlFile.failWrite(stream);
        return;
    L9:
        e = move-exception;
        Log.w(TAG, "Failed to write display settings: " + e);
    }
}
