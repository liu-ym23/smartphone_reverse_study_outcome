package com.android.server.tv.tunerresourcemanager;

import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.SystemService;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class UseCasePriorityHints {
    private static final boolean DEBUG = false;
    private static final int INVALID_PRIORITY_VALUE = -1;
    private static final int INVALID_USE_CASE = -1;
    private static final String NS = null;
    private static final String PATH_TO_VENDOR_CONFIG_XML = "/vendor/etc/tunerResourceManagerUseCaseConfig.xml";
    private static final String TAG = "UseCasePriorityHints";
    private int mDefaultBackground;
    private int mDefaultForeground;
    SparseArray<int[]> mPriorityHints;
    Set<Integer> mVendorDefinedUseCase;

    public UseCasePriorityHints() {
        this.mPriorityHints = new SparseArray();
        this.mVendorDefinedUseCase = new HashSet();
        this.mDefaultForeground = 150;
        this.mDefaultBackground = 50;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        NS = null;
    }

    int getForegroundPriority(int useCase) {
        if (this.mPriorityHints.get(useCase) == null) goto L9;
        if (this.mPriorityHints.get(useCase).length != 2) goto L9;
        return this.mPriorityHints.get(useCase)[0];
    L9:
        return this.mDefaultForeground;
    }

    int getBackgroundPriority(int useCase) {
        if (this.mPriorityHints.get(useCase) == null) goto L9;
        if (this.mPriorityHints.get(useCase).length != 2) goto L9;
        return this.mPriorityHints.get(useCase)[1];
    L9:
        return this.mDefaultBackground;
    }

    boolean isDefinedUseCase(int useCase) {
        if (this.mVendorDefinedUseCase.contains(Integer.valueOf(useCase)) == false) goto L5;
    L8:
        return true;
    L5:
        if (isPredefinedUseCase(useCase) == true) goto L8;
        return false;
    }

    public void parse() {
        File file = new File(PATH_TO_VENDOR_CONFIG_XML);
        if (file.exists() == false) goto L14;
        InputStream in = new FileInputStream(file);     // Catch: XmlPullParserException -> L6 IOException -> L8
        parseInternal(in);     // Catch: XmlPullParserException -> L6 IOException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error reading vendor file: " + file, e);
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Unable to parse vendor file: " + file, e);
        return;
    L14:
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "no vendor priority configuration available. Using default priority");
    L16:
        addNewUseCasePriority(100, 180, 100);
        addNewUseCasePriority(200, 450, 200);
        addNewUseCasePriority(300, SystemService.PHASE_LOCK_SETTINGS_READY, 300);
        addNewUseCasePriority(400, 490, 400);
        addNewUseCasePriority(500, 600, 500);
    }

    protected void parseInternal(InputStream in) throws IOException, XmlPullParserException {
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L12
        parser.nextTag();     // Catch: Throwable -> L12
        readUseCase(parser);     // Catch: Throwable -> L12
        in.close();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= this.mPriorityHints.size()) goto L11;
        int useCase = this.mPriorityHints.keyAt(i);
        int[] priorities = this.mPriorityHints.get(useCase);
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "{defaultFg=" + this.mDefaultForeground + ", defaultBg=" + this.mDefaultBackground + "}");
        Slog.d(TAG, "{useCase=" + useCase + ", fg=" + priorities[0] + ", bg=" + priorities[1] + "}");
    L9:
        i = i + 1;
        goto L5
    L11:
        return;
    L12:
        e = move-exception;
        throw e;
    }

    private void readUseCase(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(2, NS, "config");
    L4:
        if (parser.next() == 3) goto L22;
        if (parser.getEventType() != 2) goto L4;
        String name = parser.getName();
        if (name.equals("useCaseDefault") == true) goto L10;
        if (name.equals("useCasePreDefined") == true) goto L13;
        if (name.equals("useCaseVendor") == true) goto L19;
        skip(parser);
        goto L4
    L19:
        int useCase = readAttributeToInt("id", parser);
        addNewUseCasePriority(useCase, readAttributeToInt("fgPriority", parser), readAttributeToInt("bgPriority", parser));
        this.mVendorDefinedUseCase.add(Integer.valueOf(useCase));
        parser.nextTag();
        parser.require(3, NS, name);
        goto L4
    L13:
        int useCase2 = formatTypeToNum(DatabaseHelper.SoundModelContract.KEY_TYPE, parser);
        if (useCase2 == (-1)) goto L15;
        addNewUseCasePriority(useCase2, readAttributeToInt("fgPriority", parser), readAttributeToInt("bgPriority", parser));
        parser.nextTag();
        parser.require(3, NS, name);
        goto L4
    L15:
        Slog.e(TAG, "Wrong predefined use case name given in the vendor config.");
        goto L4
    L10:
        this.mDefaultForeground = readAttributeToInt("fgPriority", parser);
        this.mDefaultBackground = readAttributeToInt("bgPriority", parser);
        parser.nextTag();
        parser.require(3, NS, name);
        goto L4
    }

    private void skip(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != 2) goto L14;
        int depth = 1;
    L5:
        if (depth == 0) goto L12;
        switch(parser.next()) {
            case 2: goto L10;
            case 3: goto L9;
            default: goto L5;
        };
    L9:
        depth = depth - 1;
        goto L5
    L10:
        depth = depth + 1;
        goto L5
    L12:
        return;
    L14:
        throw new IllegalStateException();
    }

    private int readAttributeToInt(String attributeName, TypedXmlPullParser parser) throws XmlPullParserException {
        return parser.getAttributeInt(null, attributeName);
    }

    private void addNewUseCasePriority(int useCase, int fgPriority, int bgPriority) {
        int[] priorities = {fgPriority, bgPriority};
        this.mPriorityHints.append(useCase, priorities);
    }

    private static int formatTypeToNum(String attributeName, TypedXmlPullParser parser) {
        String useCaseName = parser.getAttributeValue(null, attributeName);
        switch(useCaseName.hashCode()) {
            case -884787515: goto L18;
            case 377959794: goto L15;
            case 1222007747: goto L12;
            case 1222209876: goto L9;
            case 1990900072: goto L6;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            default: goto L22;
        };
    L22:
        return -1;
    L23:
        return 500;
    L25:
        return 400;
    L27:
        return 300;
    L29:
        return 200;
    L31:
        return 100;
    L6:
        if (useCaseName.equals("USE_CASE_RECORD") == false) goto L33;
        r1 = 4;
        goto L21
    L33:
        r1 = -1;
        goto L21
    L9:
        if (useCaseName.equals("USE_CASE_SCAN") == false) goto L34;
        r1 = 1;
        goto L21
    L34:
        r1 = -1;
        goto L21
    L12:
        if (useCaseName.equals("USE_CASE_LIVE") == false) goto L35;
        r1 = 3;
        goto L21
    L35:
        r1 = -1;
        goto L21
    L15:
        if (useCaseName.equals("USE_CASE_PLAYBACK") == false) goto L36;
        r1 = 2;
        goto L21
    L36:
        r1 = -1;
        goto L21
    L18:
        if (useCaseName.equals("USE_CASE_BACKGROUND") == false) goto L37;
        r1 = 0;
        goto L21
    L37:
        r1 = -1;
        goto L21
    }

    private static boolean isPredefinedUseCase(int useCase) {
        switch(useCase) {
            case 100: goto L5;
            case 200: goto L5;
            case 300: goto L5;
            case 400: goto L5;
            case 500: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }
}
