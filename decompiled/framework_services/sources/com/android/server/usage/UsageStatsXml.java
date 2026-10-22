package com.android.server.usage;

import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class UsageStatsXml {
    static final String CHECKED_IN_SUFFIX = "-c";
    private static final String TAG = "UsageStatsXml";
    private static final String USAGESTATS_TAG = "usagestats";
    private static final String VERSION_ATTR = "version";

    public UsageStatsXml() {
    }

    public static void read(InputStream in, IntervalStats statsOut) throws IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "utf-8");     // Catch: XmlPullParserException -> L8
        XmlUtils.beginDocument(parser, USAGESTATS_TAG);     // Catch: XmlPullParserException -> L8
        String versionStr = parser.getAttributeValue(null, VERSION_ATTR);     // Catch: XmlPullParserException -> L8
    L10:
        e = move-exception;
        Slog.e(TAG, "Bad version");     // Catch: XmlPullParserException -> L8
        throw new IOException(e);     // Catch: XmlPullParserException -> L8
    L5:
        switch(Integer.parseInt(versionStr)) {
            case 1: goto L12;
            default: goto L6;
        };     // Catch: XmlPullParserException -> L8 NumberFormatException -> L10
    L6:
        Slog.e(TAG, "Unrecognized version " + versionStr);     // Catch: XmlPullParserException -> L8 NumberFormatException -> L10
        throw new IOException("Unrecognized version " + versionStr);     // Catch: XmlPullParserException -> L8 NumberFormatException -> L10
    L12:
        UsageStatsXmlV1.read(parser, statsOut);     // Catch: XmlPullParserException -> L8 NumberFormatException -> L10
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to parse Xml", e);
        throw new IOException(e);
    }
}
