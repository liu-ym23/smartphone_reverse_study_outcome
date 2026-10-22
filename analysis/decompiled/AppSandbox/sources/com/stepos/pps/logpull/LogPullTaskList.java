package com.stepos.pps.logpull;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.stepos.pps.logpull.LogPullTaskList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LogPullTaskList {
    private static final String KEY_SHOWING = "showing_config_id";
    private static final String KEY_TASKS = "tasks";
    private static final String[] LEGACY_PREFS = {"logpull_pending_task", "logpull_auth_pending", "logpull_upload"};
    private static final Object LOCK = new Object();
    public static final String PHASE_COLLECTING = "collecting";
    public static final String PHASE_IDLE = "idle";
    public static final String PHASE_PENDING_AUTH = "pending_auth";
    public static final String PHASE_UPLOAD = "upload";
    private static final String PREFS = "logpull_tasklist";
    private static final String TAG = "LogPull.TaskList";
    private final SharedPreferences prefs;

    public LogPullTaskList(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.prefs = applicationContext.getSharedPreferences(PREFS, 0);
        for (String str : LEGACY_PREFS) {
            try {
                applicationContext.deleteSharedPreferences(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static class Entry {
        public long configId;
        public String deadlineTime;
        public long expireAt;
        public String fileName;
        public String filePath;
        public boolean fulldump;
        public long lastActiveTime;
        public String logEndTime;
        public String logStartTime;
        public long maxLimit;
        public String oaid;
        public String objectKey;
        public long partSize;
        public String phase;
        public long sizeBytes;
        public long totalSize;
        public String uploadId;
        public String uploadUrl;
        public long uploadedBytes;
        public String zipPath;
        public String[] logTypes = new String[0];
        public String fileType = "zip";
        public String uploadType = LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        public final Map<Integer, String> completedParts = new TreeMap();

        boolean hasUploadState() {
            String str;
            String str2 = this.objectKey;
            return (str2 == null || str2.isEmpty() || (str = this.filePath) == null || str.isEmpty()) ? false : true;
        }
    }

    public Entry get(long j) {
        synchronized (LOCK) {
            for (Entry entry : readAll()) {
                if (entry.configId == j) {
                    return entry;
                }
            }
            return null;
        }
    }

    public void put(Entry entry) {
        if (entry == null || entry.configId <= 0) {
            return;
        }
        synchronized (LOCK) {
            List<Entry> all = readAll();
            int i = 0;
            while (true) {
                if (i >= all.size()) {
                    all.add(entry);
                    break;
                } else {
                    if (all.get(i).configId == entry.configId) {
                        all.set(i, entry);
                        break;
                    }
                    i++;
                }
            }
            writeAll(all);
        }
    }

    public void remove(final long j) {
        synchronized (LOCK) {
            List<Entry> all = readAll();
            if (all.removeIf(new Predicate() { // from class: com.stepos.pps.logpull.LogPullTaskList$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return LogPullTaskList.lambda$remove$0(j, (LogPullTaskList.Entry) obj);
                }
            })) {
                writeAll(all);
                if (this.prefs.getLong(KEY_SHOWING, -1L) == j) {
                    this.prefs.edit().remove(KEY_SHOWING).apply();
                }
                Log.i(TAG, "移除任务 configId=" + j + " 剩余=" + all.size());
            }
        }
    }

    static /* synthetic */ boolean lambda$remove$0(long j, Entry entry) {
        return entry.configId == j;
    }

    public List<Entry> all() {
        List<Entry> all;
        synchronized (LOCK) {
            all = readAll();
        }
        return all;
    }

    public List<Entry> byPhase(String... strArr) {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            for (Entry entry : readAll()) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (strArr[i].equals(entry.phase)) {
                        arrayList.add(entry);
                        break;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    public Entry activeTask() {
        synchronized (LOCK) {
            for (Entry entry : readAll()) {
                if ("collecting".equals(entry.phase) || "idle".equals(entry.phase) || "upload".equals(entry.phase)) {
                    return entry;
                }
            }
            return null;
        }
    }

    public void setShowing(long j) {
        this.prefs.edit().putLong(KEY_SHOWING, j).apply();
    }

    public long getShowing() {
        return this.prefs.getLong(KEY_SHOWING, -1L);
    }

    public void clearShowing() {
        this.prefs.edit().remove(KEY_SHOWING).apply();
    }

    private List<Entry> readAll() {
        Entry entryFromJson;
        ArrayList arrayList = new ArrayList();
        String string = this.prefs.getString(KEY_TASKS, null);
        if (string != null && !string.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (entryFromJson = fromJson(jSONObjectOptJSONObject)) != null && entryFromJson.configId > 0) {
                        arrayList.add(entryFromJson);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "解析任务表失败，按空处理", e);
            }
        }
        return arrayList;
    }

    private void writeAll(List<Entry> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Entry> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(toJson(it.next()));
            }
            this.prefs.edit().putString(KEY_TASKS, jSONArray.toString()).apply();
        } catch (Exception e) {
            Log.e(TAG, "保存任务表失败", e);
        }
    }

    private static JSONObject toJson(Entry entry) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("configId", entry.configId);
        jSONObject.put(LogPullAuthActivity.EXTRA_OAID, entry.oaid != null ? entry.oaid : "");
        jSONObject.put("phase", entry.phase != null ? entry.phase : PHASE_PENDING_AUTH);
        JSONArray jSONArray = new JSONArray();
        if (entry.logTypes != null) {
            for (String str : entry.logTypes) {
                jSONArray.put(str);
            }
        }
        jSONObject.put("logTypes", jSONArray);
        jSONObject.put("logStartTime", entry.logStartTime != null ? entry.logStartTime : "");
        jSONObject.put("logEndTime", entry.logEndTime != null ? entry.logEndTime : "");
        jSONObject.put("deadlineTime", entry.deadlineTime != null ? entry.deadlineTime : "");
        jSONObject.put("maxLimit", entry.maxLimit);
        jSONObject.put("fileType", entry.fileType != null ? entry.fileType : "zip");
        jSONObject.put("zipPath", entry.zipPath != null ? entry.zipPath : "");
        jSONObject.put("fileName", entry.fileName != null ? entry.fileName : "");
        jSONObject.put("sizeBytes", entry.sizeBytes);
        jSONObject.put("fulldump", entry.fulldump);
        jSONObject.put("uploadUrl", entry.uploadUrl != null ? entry.uploadUrl : "");
        jSONObject.put("objectKey", entry.objectKey != null ? entry.objectKey : "");
        jSONObject.put("uploadType", entry.uploadType != null ? entry.uploadType : LogPullStatusReporter.UPLOAD_TYPE_NORMAL);
        jSONObject.put("uploadId", entry.uploadId != null ? entry.uploadId : "");
        jSONObject.put("filePath", entry.filePath != null ? entry.filePath : "");
        jSONObject.put("expireAt", entry.expireAt);
        jSONObject.put("totalSize", entry.totalSize);
        jSONObject.put("uploadedBytes", entry.uploadedBytes);
        jSONObject.put("lastActiveTime", entry.lastActiveTime);
        jSONObject.put("partSize", entry.partSize);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<Integer, String> entry2 : entry.completedParts.entrySet()) {
            jSONObject2.put(String.valueOf(entry2.getKey()), entry2.getValue());
        }
        jSONObject.put("completedParts", jSONObject2);
        return jSONObject;
    }

    private static Entry fromJson(JSONObject jSONObject) {
        try {
            Entry entry = new Entry();
            entry.configId = jSONObject.getLong("configId");
            entry.oaid = emptyToNull(jSONObject.optString(LogPullAuthActivity.EXTRA_OAID, null));
            entry.phase = jSONObject.optString("phase", PHASE_PENDING_AUTH);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("logTypes");
            if (jSONArrayOptJSONArray != null) {
                entry.logTypes = new String[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    entry.logTypes[i] = jSONArrayOptJSONArray.getString(i);
                }
            } else {
                entry.logTypes = new String[0];
            }
            entry.logStartTime = emptyToNull(jSONObject.optString("logStartTime", null));
            entry.logEndTime = emptyToNull(jSONObject.optString("logEndTime", null));
            entry.deadlineTime = emptyToNull(jSONObject.optString("deadlineTime", null));
            entry.maxLimit = jSONObject.optLong("maxLimit", 0L);
            entry.fileType = jSONObject.optString("fileType", "zip");
            entry.zipPath = emptyToNull(jSONObject.optString("zipPath", null));
            entry.fileName = emptyToNull(jSONObject.optString("fileName", null));
            entry.sizeBytes = jSONObject.optLong("sizeBytes", 0L);
            entry.fulldump = jSONObject.optBoolean("fulldump", false);
            entry.uploadUrl = emptyToNull(jSONObject.optString("uploadUrl", null));
            entry.objectKey = emptyToNull(jSONObject.optString("objectKey", null));
            entry.uploadType = jSONObject.optString("uploadType", LogPullStatusReporter.UPLOAD_TYPE_NORMAL);
            entry.uploadId = emptyToNull(jSONObject.optString("uploadId", null));
            entry.filePath = emptyToNull(jSONObject.optString("filePath", null));
            entry.expireAt = jSONObject.optLong("expireAt", 0L);
            entry.totalSize = jSONObject.optLong("totalSize", 0L);
            entry.uploadedBytes = jSONObject.optLong("uploadedBytes", 0L);
            entry.lastActiveTime = jSONObject.optLong("lastActiveTime", 0L);
            entry.partSize = jSONObject.optLong("partSize", 0L);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("completedParts");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        entry.completedParts.put(Integer.valueOf(Integer.parseInt(next)), jSONObjectOptJSONObject.getString(next));
                    } catch (Exception unused) {
                    }
                }
            }
            return entry;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static String emptyToNull(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }
}
