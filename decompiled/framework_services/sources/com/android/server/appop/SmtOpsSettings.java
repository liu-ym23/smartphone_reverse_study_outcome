package com.android.server.appop;

import android.app.SmtOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import bytedanceos.os.PeroptWhiteListParser;
import com.android.internal.util.XmlUtils;
import com.android.server.scene.SceneUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.compress.utils.CharsetNames;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class SmtOpsSettings {
    private static final boolean DEBUG = false;
    private static final String PEROPT_SMTOPS_POLICY_NAME = "smtops_policy.xml";
    private static final String URI = "content://com.bytedanceos.datasync/sync_datas";
    private static String mDevice;
    private final String TAG;
    private Context mContext;
    private final File mFile;
    HashMap<String, PolicyPkg> mPolicy;
    private String mReceivedMD5;
    private SmtOpsService mService;
    private int mVersion;

    public static final class PolicyOp {
        public int mode;
        public int op;

        public PolicyOp(int op, int mode) {
            this.op = op;
            this.mode = mode;
        }

        public String toString() {
            return "PolicyOp [op=" + this.op + ", mode=" + this.mode + "]";
        }
    }

    public static final class PolicyPkg extends SparseArray<PolicyOp> {
        public int mode;
        public String packageName;

        public PolicyPkg(String packageName, int mode) {
            this.packageName = packageName;
            this.mode = mode;
        }

        @Override // android.util.SparseArray
        public String toString() {
            return "PolicyPkg [package=" + this.packageName + ", mode=" + this.mode + "]";
        }
    }

    static {
        DEBUG = SmtOpsService.DEBUG;
        mDevice = SystemProperties.get("ro.product.device");
    }

    SmtOpsSettings(SmtOpsService service) {
        this.TAG = "SmtOpsSettings";
        this.mVersion = 0;
        this.mPolicy = new HashMap();
        this.mService = service;
        this.mFile = new File("/system/etc/smtops_policy.xml");
    }

    public void publish(Context context) {
        this.mContext = context;
    }

    public boolean readStateLocked() {
        return false;
    }

    public boolean writeStateLocked() {
        return false;
    }

    private String getAppType(String packageName) {
        if (this.mContext == null) goto L23;
        long ident = Binder.clearCallingIdentity();
        ApplicationInfo appInfo = this.mContext.getPackageManager().getApplicationInfo(packageName, 0);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        Binder.restoreCallingIdentity(ident);
        ApplicationInfo appInfo2 = appInfo;
    L14:
        if (appInfo2 != null) goto L16;
        return null;
    L16:
        if ((appInfo2.flags & 1) == 0) goto L18;
    L21:
        return "system";
    L18:
        if ((appInfo2.getSmtEx().appTypeFlag & 2) == 2) goto L21;
        return "user";
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L13:
        appInfo2 = null;
        Binder.restoreCallingIdentity(ident);
        goto L14
    L23:
        Slog.e("SmtOpsSettings", "Context is null");
        return null;
    }

    public int getDefaultPolicyMode(int code, int uid, String pkgName) {
        PolicyPkg pkg = this.mPolicy.get(pkgName);
        if (pkg == null) goto L8;
        int result = pkg.mode;
        PolicyOp op = pkg.get(code);
        if (op == null) goto L9;
        int result2 = op.mode;
        return result2;
    L9:
        return result;
    L8:
        return -1;
    }

    public int getDefaultMode(int code, int uid, String pkgName, int dm) {
        int result = dm;
        PolicyPkg pkg = this.mPolicy.get(pkgName);
        if (pkg == null) goto L8;
        result = pkg.mode;
        PolicyOp op = pkg.get(code);
        if (op == null) goto L14;
        result = op.mode;
    L14:
        if (dm == (-1)) goto L18;
        if (result != (-1)) goto L18;
        result = dm;
    L18:
        if (DEBUG == false) goto L20;
        Slog.i("SmtOpsSettings", "getDefaultMode for code=" + code + " uid=" + uid + " package=" + pkgName + " default=" + dm + " result=" + result);
    L20:
        return result;
    L8:
        String type = getAppType(pkgName);
        if (type == null) goto L14;
        if (SmtOpsManager.isOpVisibleToUser(code) == false) goto L14;
        result = this.mPolicy.get(type).mode;
        goto L14
    }

    public int readDefaultSettings() {
        File r0 = this.mFile;
        monitor-enter(r0);
        File f = new File("/data/system/smtops_policy.xml");     // Catch: Throwable -> L7 FileNotFoundException -> L9
        if (f.exists() == false) goto L11;
        FileInputStream stream = new FileInputStream(f);     // Catch: Throwable -> L7 FileNotFoundException -> L9
    L13:
        int r1 = parserSmtops(stream);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L11:
        stream = new FileInputStream(this.mFile);     // Catch: Throwable -> L7 FileNotFoundException -> L9
    L7:
        th = move-exception;
        throw th;
    L16:
        Slog.i("SmtOpsSettings", "readDefaultSettings failed cause mFile not exist " + this.mFile);     // Catch: Throwable -> L7
        return -1;
    }

    public int parserSmtops(InputStream stream) {
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        parser.setInput(stream, null);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
    L4:
        int type = parser.next();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (type == 2) goto L8;
        if (type != 1) goto L4;
    L8:
        if (type != 2) goto L75;
        String startTagName = parser.getName();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (startTagName.equals("appops-policy") == false) goto L46;
        String deviceString = parser.getAttributeValue(null, "device");     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (deviceString != null) goto L14;
    L37:
        String versionString = parser.getAttributeValue(null, "version");     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        int version = Integer.parseInt(versionString);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (version <= this.mVersion) goto L40;
        this.mVersion = version;     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        this.mPolicy.clear();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        goto L46
    L40:
        Slog.w("SmtOpsSettings", "version err, mVersion: " + this.mVersion + ", new version: " + version);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        stream.close();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        stream.close();     // Catch: IOException -> L44
    L45:
        return 7;
    L14:
        if ("".equals(deviceString) == true) goto L37;
        if (deviceString.equals(mDevice) == true) goto L37;
        Slog.w("SmtOpsSettings", "device err, mDevice: " + mDevice + ", new device: " + deviceString);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        stream.close();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        stream.close();     // Catch: IOException -> L21
    L22:
        return 5;
    L46:
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
    L47:
        int type2 = parser.next();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (type2 == 1) goto L125;
        if (type2 == 3) goto L52;
    L54:
        if (type2 == 3) goto L47;
        if (type2 == 4) goto L47;
        String tagName = parser.getName();     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        if (tagName.equals("user") == true) goto L67;
        if (tagName.equals("system") == true) goto L67;
        if (tagName.equals("application") == true) goto L65;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        goto L47
    L65:
        readApplicationPolicy(parser);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
    L67:
        readDefaultPolicy(parser, tagName);     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
        goto L47
    L52:
        if (parser.getDepth() > outerDepth) goto L54;
    L125:
        stream.close();     // Catch: IOException -> L72
        return 2;
    L158:
        return 2;
    L75:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L23 IndexOutOfBoundsException -> L25 IOException -> L27 XmlPullParserException -> L29 NumberFormatException -> L31 NullPointerException -> L33 IllegalStateException -> L35
    L23:
        th = move-exception;
        stream.close();     // Catch: IOException -> L116
    L117:
        throw th;
    L29:
        e = move-exception;
        int result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L93
    L113:
        return result;
    L35:
        e = move-exception;
        result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L111
    L27:
        e = move-exception;
        result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L87
    L25:
        e = move-exception;
        result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L80
    L31:
        e = move-exception;
        result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L99
    L33:
        e = move-exception;
        result = 1;
        Slog.w("SmtOpsSettings", "Failed parsing " + e);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L105
        goto L113
    }

    public int loadData(String taskName) {
        if (PeroptWhiteListParser.DEBUG_PEROPT_LIST == false) goto L5;
        Log.i("SmtOpsSettings", " ### read db from download center.");
    L5:
        int result = -1;
        ContentResolver resolver = this.mContext.getContentResolver();
        Uri uri = Uri.parse(URI);
        String[] params = {taskName};
        Cursor cursor = resolver.query(uri, null, null, params, null);
        byte[] data = null;
        if (cursor != null) goto L30;
    L28:
        cursor.close();
        return result;
    L30:
        int md5Index = cursor.getColumnIndex("md5");     // Catch: Throwable -> L12 Exception -> L14
        int dataIndex = cursor.getColumnIndex("data");     // Catch: Throwable -> L12 Exception -> L14
        if (cursor.moveToFirst() == false) goto L16;
    L9:
        this.mReceivedMD5 = cursor.getString(md5Index);     // Catch: Throwable -> L12 Exception -> L14
        data = cursor.getBlob(dataIndex);     // Catch: Throwable -> L12 Exception -> L14
        if (cursor.moveToNext() == true) goto L9;
    L16:
        if (data == null) goto L28;
        if (PeroptWhiteListParser.DEBUG_PEROPT_LIST == false) goto L20;
        Log.i("SmtOpsSettings", "read data from provider! md5: " + this.mReceivedMD5 + ", data: " + new String(data));     // Catch: Throwable -> L12 Exception -> L14
    L20:
        result = updateDataFromRemote(data, taskName);     // Catch: Throwable -> L12 Exception -> L14
        goto L28
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        cursor.close();
        return -1;
    L12:
        th = move-exception;
        cursor.close();
        throw th;
    }

    private int updateDataFromRemote(byte[] data, String taskName) {
        sendFeedBack(taskName);
        InputStream is = new ByteArrayInputStream(data);
        File r2 = this.mFile;
        monitor-enter(r2);
        int result = parserSmtops(is);     // Catch: Throwable -> L8
        is.close();     // Catch: Throwable -> L8 IOException -> L10
    L13:
        if (result == 2) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L8
        return result;
    L17:
        if (PeroptWhiteListParser.DEBUG_PEROPT_LIST == false) goto L19;
        Log.i("SmtOpsSettings", "### finishloading, update map");     // Catch: Throwable -> L8
    L19:
        int result2 = saveSmtopsDataToXmlFile("/data/system/smtops_policy.xml");     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return result2;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void sendFeedBack(String taskName) {
        Intent feedback = new Intent();
        feedback.setAction("com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK");
        feedback.putExtra("md5", this.mReceivedMD5);
        feedback.putExtra("name", taskName);
        this.mContext.sendBroadcastAsUser(feedback, UserHandle.ALL);
    }

    private int saveSmtopsDataToXmlFile(String writeToFile) {
        if (PeroptWhiteListParser.DEBUG_PEROPT_LIST == false) goto L5;
        Log.i("SmtOpsSettings", "### save current config to file.");
    L5:
        XmlSerializer serializer = Xml.newSerializer();
        FileOutputStream fos = null;
        String enter = System.getProperty("line.separator");
    L65:
        fos = new FileOutputStream(writeToFile);     // Catch: Throwable -> L33 Exception -> L35
        serializer.setOutput(fos, "utf-8");     // Catch: Throwable -> L33 Exception -> L35
        serializer.startDocument(CharsetNames.UTF_8, true);     // Catch: Throwable -> L33 Exception -> L35
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L33 Exception -> L35
        serializer.startTag("", "appops-policy");     // Catch: Throwable -> L33 Exception -> L35
        serializer.attribute("", "version", String.valueOf(this.mVersion));     // Catch: Throwable -> L33 Exception -> L35
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L33 Exception -> L35
        serializer.startTag("", "user");     // Catch: Throwable -> L33 Exception -> L35
        PolicyPkg pkgUser = this.mPolicy.get("user");     // Catch: Throwable -> L33 Exception -> L35
        int modeUser = -1;
        if (pkgUser != null) goto L56;
    L17:
        String userModeName = SmtOpsManager.modeToName(modeUser);     // Catch: Throwable -> L33 Exception -> L35
        serializer.attribute("", "mode", userModeName);     // Catch: Throwable -> L33 Exception -> L35
        serializer.endTag("", "user");     // Catch: Throwable -> L33 Exception -> L35
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L33 Exception -> L35
        serializer.startTag("", "system");     // Catch: Throwable -> L33 Exception -> L35
        PolicyPkg pkgSystem = this.mPolicy.get("system");     // Catch: Throwable -> L33 Exception -> L35
        int modeSystem = 0;
        if (pkgSystem == null) goto L26;
        int result = -1;
        int result2 = pkgSystem.mode;     // Catch: Throwable -> L22 Exception -> L24
        modeSystem = result2;
    L27:
        String systemodeName = SmtOpsManager.modeToName(modeSystem);     // Catch: Throwable -> L22 Exception -> L24
        serializer.attribute("", "mode", systemodeName);     // Catch: Throwable -> L22 Exception -> L24
        serializer.endTag("", "system");     // Catch: Throwable -> L22 Exception -> L24
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L22 Exception -> L24
        serializer.startTag("", "application");     // Catch: Throwable -> L22 Exception -> L24
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L22 Exception -> L24
        handleSmtopsPkgAttribute(serializer, enter);     // Catch: Throwable -> L22 Exception -> L24
        serializer.endTag("", "application");     // Catch: Throwable -> L22 Exception -> L24
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Throwable -> L22 Exception -> L24
        serializer.endTag("", "appops-policy");     // Catch: Throwable -> L22 Exception -> L24
        serializer.endDocument();     // Catch: Throwable -> L22 Exception -> L24
    L58:
        fos.close();     // Catch: IOException -> L31
        return 4;
    L31:
        e = move-exception;
        e.printStackTrace();
        return 4;
    L24:
        e = e;
    L42:
        e.printStackTrace();     // Catch: Throwable -> L13
        Log.e("SmtOpsSettings", "saveDataToXmlFile exception: " + e.getMessage());     // Catch: Throwable -> L13
        if (fos == null) goto L49;
        fos.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L49:
        return 3;
    L13:
        th = move-exception;
        Throwable r2 = th;
    L50:
        if (fos == null) goto L73;
        fos.close();     // Catch: IOException -> L53
        throw r2;
    L53:
        e = move-exception;
        e.printStackTrace();
        throw r2;
    L73:
        throw r2;
    L22:
        th = move-exception;
        r2 = th;
        goto L50
    L26:
        result = -1;
        goto L27
    L56:
        modeUser = pkgUser.mode;     // Catch: Throwable -> L13 Exception -> L15
    L15:
        e = e;
    L35:
        e = e;
    L33:
        th = th;
    L34:
        r2 = th;
    L39:
        e = e;
    L37:
        th = th;
        goto L34
    }

    private void handleSmtopsPkgAttribute(XmlSerializer serializer, String enter) {
        SmtOpsSettings this = this;
        Iterator<String> itOfPkg = this.mPolicy.keySet().iterator();     // Catch: Exception -> L20
    L5:
        if (itOfPkg.hasNext() == false) goto L42;
        String pkgName = itOfPkg.next();     // Catch: Exception -> L20
        if (pkgName.equals("user") == true) goto L5;
        if (pkgName.equals("system") == true) goto L5;
        serializer.startTag("", SceneUtils.KEY_PKG);     // Catch: Exception -> L20
        serializer.attribute("", "name", pkgName);     // Catch: Exception -> L20
        PolicyPkg pkg = this.mPolicy.get(pkgName);     // Catch: Exception -> L20
        int mode = pkg.mode;     // Catch: Exception -> L20
        String pkgModeName = SmtOpsManager.modeToName(mode);     // Catch: Exception -> L20
        serializer.attribute("", "mode", pkgModeName);     // Catch: Exception -> L20
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Exception -> L20
        int i = 0;
    L14:
        if (i >= pkg.size()) goto L23;
        serializer.startTag("", "op");     // Catch: Exception -> L20
        int key = pkg.keyAt(i);     // Catch: Exception -> L20
        if (key == (-1)) goto L22;
        String opName = SmtOpsManager.opToName(key);     // Catch: Exception -> L20
        serializer.attribute("", "name", opName);     // Catch: Exception -> L20
        PolicyOp op = pkg.get(key);     // Catch: Exception -> L20
        if (op == null) goto L22;
        String opModeName = SmtOpsManager.modeToName(op.mode);     // Catch: Exception -> L20
        serializer.attribute("", "mode", opModeName);     // Catch: Exception -> L20
    L22:
        serializer.endTag("", "op");     // Catch: Exception -> L20
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Exception -> L20
        i = i + 1;     // Catch: Exception -> L20
        goto L14
    L23:
        serializer.endTag("", SceneUtils.KEY_PKG);     // Catch: Exception -> L20
        PeroptWhiteListParser.changeLine(serializer, enter);     // Catch: Exception -> L20
        goto L5
    L42:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        Log.e("SmtOpsSettings", "handleAttribute exception: " + e.getMessage());
    }

    private void readDefaultPolicy(XmlPullParser parser, String packageName) throws NumberFormatException, XmlPullParserException, IOException {
        if ("user".equalsIgnoreCase(packageName) == false) goto L5;
    L7:
        int mode = SmtOpsManager.modeNameToMode(parser.getAttributeValue(null, "mode"));
        PolicyPkg pkg = this.mPolicy.get(packageName);
        if (pkg != null) goto L10;
        this.mPolicy.put(packageName, new PolicyPkg(packageName, mode));
        return;
    L10:
        Slog.w("SmtOpsSettings", "Duplicate policy found for package: " + packageName + " of type: " + packageName);
        pkg.mode = mode;
        return;
    L5:
        if ("system".equalsIgnoreCase(packageName) == true) goto L7;
    }

    private void readApplicationPolicy(XmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(SceneUtils.KEY_PKG) == true) goto L16;
        Slog.w("SmtOpsSettings", "Unknown element under <application>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readPkgPolicy(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readPkgPolicy(XmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
        String packageName = parser.getAttributeValue(null, "name");
        if (packageName != null) goto L5;
        return;
    L5:
        int mode = SmtOpsManager.modeNameToMode(parser.getAttributeValue(null, "mode"));
        PolicyPkg pkg = this.mPolicy.get(packageName);
        if (pkg != null) goto L8;
        pkg = new PolicyPkg(packageName, mode);
        this.mPolicy.put(packageName, pkg);
    L9:
        int outerDepth = parser.getDepth();
    L10:
        int type = parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L15;
    L17:
        if (type == 3) goto L10;
        if (type == 4) goto L10;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L23;
        Slog.w("SmtOpsSettings", "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L10
    L23:
        readOpPolicy(parser, pkg);
        goto L10
    L15:
        if (parser.getDepth() > outerDepth) goto L17;
        return;
    L26:
        return;
    L8:
        Slog.w("SmtOpsSettings", "Duplicate policy found for package: " + pkg);
        pkg.mode = mode;
        goto L9
    }

    private void readOpPolicy(XmlPullParser parser, PolicyPkg pkg) throws NumberFormatException, XmlPullParserException, IOException {
        if (pkg != null) goto L4;
        return;
    L4:
        String opName = parser.getAttributeValue(null, "name");
        if (opName != null) goto L8;
        Slog.w("SmtOpsSettings", "Op name is null");
        return;
    L8:
        int code = SmtOpsManager.opNameToOp(opName);
        int mode = SmtOpsManager.modeNameToMode(parser.getAttributeValue(null, "mode"));
        PolicyOp op = pkg.get(code);
        if (op != null) goto L11;
        pkg.put(code, new PolicyOp(code, mode));
        return;
    L11:
        Slog.w("SmtOpsSettings", "Duplicate policy found for package: " + pkg.packageName + " op: " + op.op);
        op.mode = mode;
    }
}
