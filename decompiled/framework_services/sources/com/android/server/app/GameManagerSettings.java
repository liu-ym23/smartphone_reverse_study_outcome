package com.android.server.app;

import android.os.FileUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class GameManagerSettings {
    private static final String ATTR_FPS = "fps";
    private static final String ATTR_GAME_MODE = "gameMode";
    private static final String ATTR_LOADING_BOOST_DURATION = "loadingBoost";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_SCALING = "scaling";
    private static final String ATTR_USE_ANGLE = "useAngle";
    private static final String GAME_SERVICE_FILE_NAME = "game-manager-service.xml";
    public static final String TAG = "GameManagerService_GameManagerSettings";
    private static final String TAG_GAME_MODE_CONFIG = "gameModeConfig";
    private static final String TAG_PACKAGE = "package";
    private static final String TAG_PACKAGES = "packages";
    private final ArrayMap<String, GameManagerService.GamePackageConfiguration> mConfigOverrides;
    private final ArrayMap<String, Integer> mGameModes;
    final AtomicFile mSettingsFile;
    private final File mSystemDir;

    GameManagerSettings(File dataDir) {
        this.mGameModes = new ArrayMap();
        this.mConfigOverrides = new ArrayMap();
        this.mSystemDir = new File(dataDir, "system");
        this.mSystemDir.mkdirs();
        FileUtils.setPermissions(this.mSystemDir.toString(), 509, -1, -1);
        this.mSettingsFile = new AtomicFile(new File(this.mSystemDir, GAME_SERVICE_FILE_NAME));
    }

    int getGameModeLocked(String packageName) {
        if (this.mGameModes.containsKey(packageName) == false) goto L8;
        int gameMode = this.mGameModes.get(packageName).intValue();
        if (gameMode != 0) goto L7;
        return 1;
    L7:
        return gameMode;
    L8:
        return 1;
    }

    void setGameModeLocked(String packageName, int gameMode) {
        this.mGameModes.put(packageName, Integer.valueOf(gameMode));
    }

    void removeGameLocked(String packageName) {
        this.mGameModes.remove(packageName);
        this.mConfigOverrides.remove(packageName);
    }

    GameManagerService.GamePackageConfiguration getConfigOverrideLocked(String packageName) {
        return this.mConfigOverrides.get(packageName);
    }

    void setConfigOverrideLocked(String packageName, GameManagerService.GamePackageConfiguration configOverride) {
        this.mConfigOverrides.put(packageName, configOverride);
    }

    void removeConfigOverrideLocked(String packageName) {
        this.mConfigOverrides.remove(packageName);
    }

    void writePersistentDataLocked() {
        FileOutputStream fstr = null;
        fstr = this.mSettingsFile.startWrite();     // Catch: IOException -> L9
        TypedXmlSerializer serializer = Xml.resolveSerializer(fstr);     // Catch: IOException -> L9
        serializer.startDocument(null, true);     // Catch: IOException -> L9
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: IOException -> L9
        serializer.startTag(null, TAG_PACKAGES);     // Catch: IOException -> L9
        ArraySet<String> packageNames = new ArraySet(this.mGameModes.keySet());     // Catch: IOException -> L9
        packageNames.addAll(this.mConfigOverrides.keySet());     // Catch: IOException -> L9
        Iterator<String> r5 = packageNames.iterator();     // Catch: IOException -> L9
    L5:
        if (r5.hasNext() == false) goto L12;
        String packageName = r5.next();     // Catch: IOException -> L9
        serializer.startTag(null, "package");     // Catch: IOException -> L9
        serializer.attribute(null, "name", packageName);     // Catch: IOException -> L9
        if (this.mGameModes.containsKey(packageName) == false) goto L11;
        serializer.attributeInt(null, ATTR_GAME_MODE, this.mGameModes.get(packageName).intValue());     // Catch: IOException -> L9
    L11:
        writeGameModeConfigTags(serializer, this.mConfigOverrides.get(packageName));     // Catch: IOException -> L9
        serializer.endTag(null, "package");     // Catch: IOException -> L9
        goto L5
    L12:
        serializer.endTag(null, TAG_PACKAGES);     // Catch: IOException -> L9
        serializer.endDocument();     // Catch: IOException -> L9
        this.mSettingsFile.finishWrite(fstr);     // Catch: IOException -> L9
        FileUtils.setPermissions(this.mSettingsFile.toString(), FrameworkStatsLog.HOTWORD_DETECTION_SERVICE_RESTARTED, -1, -1);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        this.mSettingsFile.failWrite(fstr);
        Slog.wtf(TAG, "Unable to write game manager service settings, current changes will be lost at reboot", e);
    }

    private void writeGameModeConfigTags(TypedXmlSerializer serializer, GameManagerService.GamePackageConfiguration config) throws IOException {
        if (config != null) goto L4;
        return;
    L4:
        int[] gameModes = config.getAvailableGameModes();
        int r1 = gameModes.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        int mode = gameModes[r2];
        GameManagerService.GamePackageConfiguration.GameModeConfiguration modeConfig = config.getGameModeConfiguration(mode);
        if (modeConfig == null) goto L9;
        serializer.startTag(null, TAG_GAME_MODE_CONFIG);
        serializer.attributeInt(null, ATTR_GAME_MODE, mode);
        serializer.attributeBoolean(null, "useAngle", modeConfig.getUseAngle());
        serializer.attribute(null, "fps", modeConfig.getFpsStr());
        serializer.attributeFloat(null, ATTR_SCALING, modeConfig.getScaling());
        serializer.attributeInt(null, "loadingBoost", modeConfig.getLoadingBoostDuration());
        serializer.endTag(null, TAG_GAME_MODE_CONFIG);
    L9:
        r2 = r2 + 1;
        goto L5
    }

    boolean readPersistentDataLocked() {
        this.mGameModes.clear();
        if (this.mSettingsFile.exists() == true) goto L54;
        Slog.v(TAG, "Settings file doesn't exist, skip reading");
        return false;
    L54:
        FileInputStream str = this.mSettingsFile.openRead();     // Catch: Throwable -> L17
        TypedXmlPullParser parser = Xml.resolvePullParser(str);     // Catch: Throwable -> L20
    L8:
        int type = parser.next();     // Catch: Throwable -> L20
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type == 2) goto L22;
        Slog.wtf(TAG, "No start tag found in game manager settings");     // Catch: Throwable -> L20
        if (str == null) goto L19;
        str.close();     // Catch: Throwable -> L17 Throwable -> L17
    L19:
        return false;
    L22:
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L20
    L23:
        int type2 = parser.next();     // Catch: Throwable -> L20
        if (type2 == 1) goto L41;
        if (type2 == 3) goto L28;
    L30:
        if (type2 == 3) goto L23;
        if (type2 == 4) goto L23;
        String tagName = parser.getName();     // Catch: Throwable -> L20
        if (type2 != 2) goto L39;
        if ("package".equals(tagName) == false) goto L39;
        readPackage(parser);     // Catch: Throwable -> L20
    L39:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L20
        Slog.w(TAG, "Unknown element under packages tag: " + tagName + " with type: " + type2);     // Catch: Throwable -> L20
        goto L23
    L28:
        if (parser.getDepth() > outerDepth) goto L30;
    L41:
        if (str == null) goto L44;
        str.close();     // Catch: Throwable -> L17 Throwable -> L17
    L44:
        return true;
    L20:
        th = move-exception;
        if (str != null) goto L55;
    L51:
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L55:
        str.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17 Throwable -> L17
    L17:
        e = move-exception;
        Slog.wtf(TAG, "Error reading game manager settings", e);
        return false;
    }

    private void readPackage(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String name = parser.getAttributeValue(null, "name");
        if (name != null) goto L33;
        Slog.wtf(TAG, "No package name found in package tag");
        XmlUtils.skipCurrentTag(parser);
        return;
    L33:
        int gameMode = parser.getAttributeInt(null, ATTR_GAME_MODE);     // Catch: XmlPullParserException -> L8
        this.mGameModes.put(name, Integer.valueOf(gameMode));     // Catch: XmlPullParserException -> L8
    L10:
        int packageTagDepth = parser.getDepth();
        GameManagerService.GamePackageConfiguration config = new GameManagerService.GamePackageConfiguration(name);
    L11:
        int type = parser.next();
        if (type == 1) goto L30;
        if (type == 3) goto L16;
    L18:
        if (type == 3) goto L11;
        if (type == 4) goto L11;
        String tagName = parser.getName();
        if (type != 2) goto L27;
        if (TAG_GAME_MODE_CONFIG.equals(tagName) == false) goto L27;
        readGameModeConfig(parser, config);
    L27:
        XmlUtils.skipCurrentTag(parser);
        Slog.w(TAG, "Unknown element under package tag: " + tagName + " with type: " + type);
        goto L11
    L16:
        if (parser.getDepth() > packageTagDepth) goto L18;
    L30:
        if (config.hasActiveGameModeConfig() == false) goto L47;
        this.mConfigOverrides.put(name, config);
        return;
    L47:
        return;
    L9:
        Slog.v(TAG, "No game mode selected by user for package" + name);
        goto L10
    }

    private void readGameModeConfig(TypedXmlPullParser parser, GameManagerService.GamePackageConfiguration config) {
        int gameMode = parser.getAttributeInt(null, ATTR_GAME_MODE);     // Catch: XmlPullParserException -> L29
        GameManagerService.GamePackageConfiguration.GameModeConfiguration modeConfig = config.getOrAddDefaultGameModeConfiguration(gameMode);
        float scaling = parser.getAttributeFloat(null, ATTR_SCALING);     // Catch: XmlPullParserException -> L7
        modeConfig.setScaling(scaling);     // Catch: XmlPullParserException -> L7
    L11:
        String fps = parser.getAttributeValue(null, "fps");
        if (fps == null) goto L14;
        String r7 = fps;
    L15:
        modeConfig.setFpsStr(r7);
        boolean useAngle = parser.getAttributeBoolean(null, "useAngle");     // Catch: XmlPullParserException -> L18
        modeConfig.setUseAngle(useAngle);     // Catch: XmlPullParserException -> L18
    L38:
        int loadingBoostDuration = parser.getAttributeInt(null, "loadingBoost");     // Catch: XmlPullParserException -> L24
        modeConfig.setLoadingBoostDuration(loadingBoostDuration);     // Catch: XmlPullParserException -> L24
        return;
    L24:
        e = move-exception;
        String rawLoadingBoost = parser.getAttributeValue(null, "loadingBoost");
        if (rawLoadingBoost == null) goto L40;
        Slog.wtf(TAG, "Invalid loading boost in config tag: " + rawLoadingBoost, e);
        return;
    L40:
        return;
    L18:
        e = move-exception;
        String rawUseAngle = parser.getAttributeValue(null, "useAngle");
        if (rawUseAngle == null) goto L38;
        Slog.wtf(TAG, "Invalid useAngle value in config tag: " + rawUseAngle, e);
        goto L38
    L14:
        r7 = "";
    L7:
        e = move-exception;
        String rawScaling = parser.getAttributeValue(null, ATTR_SCALING);
        if (rawScaling == null) goto L11;
        Slog.wtf(TAG, "Invalid scaling value in config tag: " + rawScaling, e);
    L29:
        e = move-exception;
        Slog.wtf(TAG, "Invalid game mode value in config tag: " + parser.getAttributeValue(null, ATTR_GAME_MODE), e);
    }
}
