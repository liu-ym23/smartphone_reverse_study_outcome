package com.android.server.pm.pkg;

import android.content.pm.SuspendDialogInfo;
import android.os.BaseBundle;
import android.os.PersistableBundle;
import android.util.Slog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class SuspendParams {
    private static final String ATTR_QUARANTINED = "quarantined";
    private static final String LOG_TAG = "FrameworkPackageUserState";
    private static final String TAG_APP_EXTRAS = "app-extras";
    private static final String TAG_DIALOG_INFO = "dialog-info";
    private static final String TAG_LAUNCHER_EXTRAS = "launcher-extras";
    private final PersistableBundle mAppExtras;
    private final SuspendDialogInfo mDialogInfo;
    private final PersistableBundle mLauncherExtras;
    private final boolean mQuarantined;

    public SuspendParams(SuspendDialogInfo dialogInfo, PersistableBundle appExtras, PersistableBundle launcherExtras) {
        this(dialogInfo, appExtras, launcherExtras, false);
    }

    public SuspendParams(SuspendDialogInfo dialogInfo, PersistableBundle appExtras, PersistableBundle launcherExtras, boolean quarantined) {
        this.mDialogInfo = dialogInfo;
        this.mAppExtras = appExtras;
        this.mLauncherExtras = launcherExtras;
        this.mQuarantined = quarantined;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof SuspendParams) == true) goto L8;
        return false;
    L8:
        SuspendParams other = (SuspendParams) obj;
        if (Objects.equals(this.mDialogInfo, other.mDialogInfo) == true) goto L12;
        return false;
    L12:
        if (BaseBundle.kindofEquals(this.mAppExtras, other.mAppExtras) == true) goto L15;
        return false;
    L15:
        if (BaseBundle.kindofEquals(this.mLauncherExtras, other.mLauncherExtras) == true) goto L18;
        return false;
    L18:
        if (this.mQuarantined == other.mQuarantined) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int hashCode = Objects.hashCode(this.mDialogInfo);
        int r1 = hashCode * 31;
        int r3 = 0;
        if (this.mAppExtras == null) goto L5;
        int r2 = this.mAppExtras.size();
    L6:
        int hashCode2 = r1 + r2;
        int hashCode3 = hashCode2 * 31;
        if (this.mLauncherExtras == null) goto L10;
        r3 = this.mLauncherExtras.size();
    L10:
        return ((hashCode3 + r3) * 31) + Boolean.hashCode(this.mQuarantined);
    L5:
        r2 = 0;
        goto L6
    }

    public void saveToXml(TypedXmlSerializer out) throws IOException {
        out.attributeBoolean(null, ATTR_QUARANTINED, this.mQuarantined);
        if (this.mDialogInfo == null) goto L6;
        out.startTag(null, TAG_DIALOG_INFO);
        this.mDialogInfo.saveToXml(out);
        out.endTag(null, TAG_DIALOG_INFO);
    L6:
        if (this.mAppExtras == null) goto L14;
        out.startTag(null, TAG_APP_EXTRAS);
        this.mAppExtras.saveToXml(out);     // Catch: XmlPullParserException -> L10
    L12:
        out.endTag(null, TAG_APP_EXTRAS);
    L10:
        e = move-exception;
        Slog.e(LOG_TAG, "Exception while trying to write appExtras. Will be lost on reboot", e);
    L14:
        if (this.mLauncherExtras == null) goto L26;
        out.startTag(null, TAG_LAUNCHER_EXTRAS);
        this.mLauncherExtras.saveToXml(out);     // Catch: XmlPullParserException -> L18
    L20:
        out.endTag(null, TAG_LAUNCHER_EXTRAS);
        return;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Exception while trying to write launcherExtras. Will be lost on reboot", e);
        goto L20
    }

    public static SuspendParams restoreFromXml(TypedXmlPullParser in) throws IOException {
        SuspendDialogInfo readDialogInfo = null;
        PersistableBundle readAppExtras = null;
        PersistableBundle readLauncherExtras = null;
        boolean quarantined = in.getAttributeBoolean(null, ATTR_QUARANTINED, false);
        int currentDepth = in.getDepth();
    L41:
        int type = in.next();     // Catch: XmlPullParserException -> L10
        byte r9 = 1;
        if (type == 1) goto L40;
        if (type == 3) goto L8;
    L13:
        if (type == 3) goto L41;
        if (type == 4) goto L41;
        String r7 = in.getName();     // Catch: XmlPullParserException -> L10
        switch(r7.hashCode()) {
            case -538220657: goto L27;
            case -22768109: goto L24;
            case 1627485488: goto L21;
            default: goto L29;
        };     // Catch: XmlPullParserException -> L10
    L29:
        r9 = -1;
    L30:
        switch(r9) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            default: goto L31;
        };     // Catch: XmlPullParserException -> L10
    L32:
        PersistableBundle readLauncherExtras2 = PersistableBundle.restoreFromXml(in);     // Catch: XmlPullParserException -> L10
        readLauncherExtras = readLauncherExtras2;
        goto L41
    L33:
        PersistableBundle readAppExtras2 = PersistableBundle.restoreFromXml(in);     // Catch: XmlPullParserException -> L10
        readAppExtras = readAppExtras2;
        goto L41
    L34:
        SuspendDialogInfo readDialogInfo2 = SuspendDialogInfo.restoreFromXml(in);     // Catch: XmlPullParserException -> L10
        readDialogInfo = readDialogInfo2;
        goto L41
    L31:
        Slog.w(LOG_TAG, "Unknown tag " + in.getName() + " in SuspendParams. Ignoring");     // Catch: XmlPullParserException -> L10
        goto L41
    L21:
        if (r7.equals(TAG_LAUNCHER_EXTRAS) == false) goto L29;
        r9 = 2;
        goto L30
    L24:
        if (r7.equals(TAG_DIALOG_INFO) == false) goto L29;
        r9 = 0;
        goto L30
    L27:
        if (r7.equals(TAG_APP_EXTRAS) == false) goto L29;
    L8:
        if (in.getDepth() > currentDepth) goto L13;
    L40:
        return new SuspendParams(readDialogInfo, readAppExtras, readLauncherExtras, quarantined);
    L10:
        e = move-exception;
        Slog.e(LOG_TAG, "Exception while trying to parse SuspendParams, some fields may default", e);
        goto L40
    }

    public SuspendDialogInfo getDialogInfo() {
        return this.mDialogInfo;
    }

    public PersistableBundle getAppExtras() {
        return this.mAppExtras;
    }

    public PersistableBundle getLauncherExtras() {
        return this.mLauncherExtras;
    }

    public boolean isQuarantined() {
        return this.mQuarantined;
    }
}
