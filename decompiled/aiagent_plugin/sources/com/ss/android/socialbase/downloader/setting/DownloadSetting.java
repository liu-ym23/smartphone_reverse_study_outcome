package com.ss.android.socialbase.downloader.setting;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadSetting {
    private static final int POOL_SIZE = 16;
    private static final String TAG = "DownloadSetting";
    private static final LruCache<Integer, DownloadSetting> sCache = null;
    private static JSONObject sDisabledTaskKeys;
    private static final DownloadSetting sGlobal = null;
    private static Boolean sGlobalBugFixDefault;
    private static JSONObject sGlobalBugFixSetting;

    @Deprecated
    private static JSONObject sGlobalSetting;
    private static DownloadSetting sLastSetting;
    private static boolean sTaskSettingDisabled;
    private final Boolean mBugFixDefault;
    private final JSONObject mBugFixSetting;
    private int mDownloadId;
    private final JSONObject mTaskSetting;

    static {
        sCache = new LruCache(16, 16);
        sGlobal = new DownloadSetting(null);
        init();
    }

    public static void init() {
        JSONObject r0 = ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getDownloadSetting();
        boolean r2 = false;
        if (r0.optInt(DownloadSettingKeys.DISABLE_TASK_SETTING, 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        sTaskSettingDisabled = r1;
        sDisabledTaskKeys = r0.optJSONObject(DownloadSettingKeys.DISABLED_TASK_KEYS);
        JSONObject r3 = r0.optJSONObject(DownloadSettingKeys.BUG_FIX);
        Boolean r4 = null;
        if (r3 != null) goto L9;
    L14:
        sGlobalBugFixSetting = r3;
        sGlobalBugFixDefault = r4;
        if (Logger.debug() == false) goto L22;
        StringBuilder r5 = new StringBuilder().append("SettingUpdate:");
        if (r0 == null) goto L19;
        String r6 = r0.toString();
    L20:
        Logger.globalDebug(TAG, "init", r5.append(r6).toString());
        return;
    L19:
        r6 = "Empty";
        goto L20
    L22:
        return;
    L9:
        if (r3.has(DownloadSettingKeys.BugFix.DEFAULT) == false) goto L14;
        if (r3.optInt(DownloadSettingKeys.BugFix.DEFAULT, 0) != 1) goto L13;
        r2 = true;
    L13:
        r4 = Boolean.valueOf(r2);
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    private DownloadSetting(JSONObject r5) {
        this.mTaskSetting = r5;
        JSONObject r0 = null;
        Boolean r1 = null;
        r1 = null;
        r1 = null;
        if (r5 != null) goto L5;
    L17:
        Boolean r6 = null;
    L18:
        this.mBugFixSetting = r0;
        this.mBugFixDefault = r6;
        return;
    L5:
        if (isTaskKeyDisabled(DownloadSettingKeys.BUG_FIX) == true) goto L17;
        JSONObject r7 = r5.optJSONObject(DownloadSettingKeys.BUG_FIX);
        if (r7 != null) goto L9;
    L16:
        Boolean r3 = r1;
        r0 = r7;
        r6 = r3;
        goto L18
    L9:
        if (r7.has(DownloadSettingKeys.BugFix.DEFAULT) == false) goto L16;
        if (isTaskKeyDisabled(DownloadSettingKeys.BugFix.DEFAULT) == true) goto L16;
        boolean r2 = false;
        if (r7.optInt(DownloadSettingKeys.BugFix.DEFAULT, 0) != 1) goto L15;
        r2 = true;
    L15:
        r1 = Boolean.valueOf(r2);
        goto L16
    }

    public static JSONObject getGlobalSettings() {
        return ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getDownloadSetting();
    }

    public static void setGlobalBugFix(String r1, boolean r2) {
        if (sGlobalBugFixSetting != null) goto L5;
        sGlobalBugFixSetting = new JSONObject();     // Catch: JSONException -> L11
    L5:
        JSONObject r0 = sGlobalBugFixSetting;     // Catch: JSONException -> L11
        if (r2 == false) goto L8;
        int r3 = 1;
    L9:
        r0.put(r1, r3);     // Catch: JSONException -> L11
        return;
    L8:
        r3 = 0;
    }

    public static DownloadSetting obtainGlobal() {
        return sGlobal;
    }

    public static DownloadSetting obtain(int r1) {
        return obtain(r1, null);
    }

    public static DownloadSetting obtain(DownloadInfo r1) {
        if (r1 != null) goto L6;
        return sGlobal;
    L6:
        return obtain(r1.getId(), r1);
    }

    private static DownloadSetting obtain(int r4, DownloadInfo r5) {
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r1 = sCache;
        monitor-enter(r1);
        DownloadSetting r2 = (DownloadSetting) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r4)), DownloadSetting.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        if (r2 != null) goto L23;
        if (r5 != null) goto L14;
        DownloadSetting r6 = create(r4);
    L15:
        r2 = r6;
        monitor-enter(r1);
        r1.put(Integer.valueOf(r4), r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L14:
        r6 = create(r5);
    L23:
        r2.mDownloadId = r4;
        sLastSetting = r2;
        return r2;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r0.mDownloadId != r4) goto L7;
        return r0;
    }

    public boolean optBugFix(String r2) {
        return optBugFix(r2, false);
    }

    public boolean optBugFix(String r4, boolean r5) {
        if (this.mBugFixSetting != null) goto L5;
    L16:
        JSONObject r3 = sGlobalBugFixSetting;
        if (r3 != null) goto L19;
    L28:
        return r5;
    L19:
        if (r3.has(r4) == true) goto L21;
        Boolean r6 = sGlobalBugFixDefault;
        if (r6 == null) goto L28;
        return r6.booleanValue();
    L21:
        if (sGlobalBugFixSetting.optInt(r4, r5 ? 1 : 0) == 1) goto L23;
        return false;
    L23:
        return true;
    L5:
        if (isTaskKeyDisabled(r4) == true) goto L16;
        if (this.mBugFixSetting.has(r4) == true) goto L9;
        Boolean r7 = this.mBugFixDefault;
        if (r7 == null) goto L16;
        return r7.booleanValue();
    L9:
        if (this.mBugFixSetting.optInt(r4, r5 ? 1 : 0) == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public int optInt(String r2) {
        return optInt(r2, 0);
    }

    public int optInt(String r2, int r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optInt(r2, r3);
    L11:
        return getGlobalSettings().optInt(r2, r3);
    }

    public long optLong(String r3) {
        return optLong(r3, 0);
    }

    public long optLong(String r2, long r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optLong(r2, r3);
    L11:
        return getGlobalSettings().optLong(r2, r3);
    }

    public double optDouble(String r3) {
        return optDouble(r3, Double.NaN);
    }

    public double optDouble(String r2, double r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optDouble(r2, r3);
    L11:
        return getGlobalSettings().optDouble(r2, r3);
    }

    public boolean optBoolean(String r2) {
        return optBoolean(r2, false);
    }

    public boolean optBoolean(String r2, boolean r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optBoolean(r2, r3);
    L11:
        return getGlobalSettings().optBoolean(r2, r3);
    }

    public String optString(String r2) {
        return optString(r2, "");
    }

    public String optString(String r2, String r3) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optString(r2, r3);
    L11:
        return getGlobalSettings().optString(r2, r3);
    }

    public JSONObject optJSONObject(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optJSONObject(r2);
    L11:
        return getGlobalSettings().optJSONObject(r2);
    }

    public JSONArray optJSONArray(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.optJSONArray(r2);
    L11:
        return getGlobalSettings().optJSONArray(r2);
    }

    public Object opt(String r2) {
        JSONObject r0 = this.mTaskSetting;
        if (r0 == null) goto L11;
        if (r0.has(r2) == false) goto L11;
        if (isTaskKeyDisabled(r2) == true) goto L11;
        return this.mTaskSetting.opt(r2);
    L11:
        return getGlobalSettings().opt(r2);
    }

    public boolean has(String r2) {
        if (this.mTaskSetting == null) goto L9;
        if (isTaskKeyDisabled(r2) == true) goto L9;
        return this.mTaskSetting.has(r2);
    L9:
        return getGlobalSettings().has(r2);
    }

    public static boolean isTaskKeyDisabled(String r2) {
        JSONObject r0 = sDisabledTaskKeys;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.optInt(r2, 0) != 1) goto L7;
        return true;
    }

    public static DownloadSetting obtain(JSONObject r5) {
        if (r5 == null) goto L30;
        if (r5 == getGlobalSettings()) goto L30;
        if (sTaskSettingDisabled == true) goto L30;
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L11;
    L13:
        LruCache<Integer, DownloadSetting> r1 = sCache;
        monitor-enter(r1);
        Iterator<DownloadSetting> r2 = r1.values().iterator();     // Catch: Throwable -> L26
    L17:
        if (r2.hasNext() == false) goto L23;
        DownloadSetting r3 = (DownloadSetting) ZeusTransformUtils.preCheckCast(r2.next(), DownloadSetting.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r3.mTaskSetting != r5) goto L17;
        sLastSetting = r3;     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        return r3;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L26
        DownloadSetting r4 = new DownloadSetting(r5);
        sLastSetting = r4;
        return r4;
    L26:
        th = move-exception;
        throw th;
    L11:
        if (r0.mTaskSetting != r5) goto L13;
        return r0;
    L30:
        return sGlobal;
    }

    public static void addTaskDownloadSetting(int r6, JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7 != getGlobalSettings()) goto L6;
        return;
    L6:
        if (sTaskSettingDisabled == true) goto L37;
        LruCache<Integer, DownloadSetting> r0 = sCache;
        monitor-enter(r0);
        DownloadSetting r1 = sLastSetting;     // Catch: Throwable -> L27
        if (r1 != null) goto L13;
    L15:
        r1 = null;
        Iterator<DownloadSetting> r2 = r0.values().iterator();     // Catch: Throwable -> L27
    L17:
        if (r2.hasNext() == false) goto L21;
        DownloadSetting r3 = (DownloadSetting) ZeusTransformUtils.preCheckCast(r2.next(), DownloadSetting.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r3.mTaskSetting != r7) goto L17;
        r3.mDownloadId = r6;     // Catch: Throwable -> L27
        r1 = r3;
    L21:
        if (r1 != null) goto L23;
        r1 = new DownloadSetting(r7);     // Catch: Throwable -> L27
        r1.mDownloadId = r6;     // Catch: Throwable -> L27
    L23:
        sLastSetting = r1;     // Catch: Throwable -> L27
    L24:
        sCache.put(Integer.valueOf(r6), r1);     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L13:
        if (r1.mTaskSetting != r7) goto L15;
        r1.mDownloadId = r6;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void removeTaskDownloadSetting(int r1) {
        DownloadSetting r0 = sLastSetting;
        if (r0 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r2 = sCache;
        monitor-enter(r2);
        r2.remove(Integer.valueOf(r1));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r0.mDownloadId != r1) goto L7;
        sLastSetting = null;
        goto L7
    }

    private static DownloadSetting create(int r3) {
        if (sTaskSettingDisabled == false) goto L7;
        return sGlobal;
    L7:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L13;
        DownloadInfo r4 = ((IDownloadProcessDispatcherService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadProcessDispatcherService.class), IDownloadProcessDispatcherService.class, "com.obric.aiagent.plugin")).getDownloadInfo(r3);
        if (r4 == null) goto L13;
        return create(r4);
    L13:
        return sGlobal;
    }

    private static DownloadSetting create(DownloadInfo r1) {
        if (sTaskSettingDisabled == true) goto L5;
        String r2 = r1.getDownloadSettingString();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return new DownloadSetting(new JSONObject(r2));
    L13:
        return sGlobal;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L5:
        return sGlobal;
    }

    public String toString() {
        return "DownloadSetting{mTaskSetting=" + this.mTaskSetting + ", mBugFixSetting=" + this.mBugFixSetting + ", mBugFixDefault=" + this.mBugFixDefault + ", mDownloadId=" + this.mDownloadId + ", globalSetting=" + getGlobalSettings() + '}';
    }
}
