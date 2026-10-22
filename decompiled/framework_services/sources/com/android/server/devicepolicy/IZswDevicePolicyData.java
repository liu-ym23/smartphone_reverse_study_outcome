package com.android.server.devicepolicy;

import android.app.admin.PasswordMetrics;
import android.util.Slog;
import com.android.modules.utils.TypedXmlSerializer;
import com.zte.feature.Feature;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswDevicePolicyData {
    public static final String ATTR_LENGTH = "length";
    public static final String TAG_ACTIVE_PASSWORD = "active-password";
    public static final boolean ZTE_PWD_LEN = false;

    PasswordMetrics getActivePasswordMetrics();

    int getUserDataLength();

    void setPasswordMetrics(PasswordMetrics r1);

    static {
        ZTE_PWD_LEN = Feature.getBoolean("ZTE_PWD_LEN", false);
    }

    static void storeActivePasswordLength(PasswordMetrics m, TypedXmlSerializer out) throws IOException {
        if (ZTE_PWD_LEN == false) goto L10;
        if (m != null) goto L6;
        return;
    L6:
        if (m.length == 0) goto L12;
        out.startTag(null, TAG_ACTIVE_PASSWORD);
        out.attribute(null, ATTR_LENGTH, Integer.toString(m.length));
        out.endTag(null, TAG_ACTIVE_PASSWORD);
        return;
    L12:
        return;
    }

    static void loadPasswordLength(PasswordMetrics m, XmlPullParser parser) throws XmlPullParserException {
        if (ZTE_PWD_LEN == true) goto L10;
        return;
    L10:
        m.length = Integer.parseInt(parser.getAttributeValue(null, ATTR_LENGTH));     // Catch: NumberFormatException -> L7
        return;
    L8:
        Slog.e("IZswDevicePolicyData", "Failed to load the password.length ");
    }
}
