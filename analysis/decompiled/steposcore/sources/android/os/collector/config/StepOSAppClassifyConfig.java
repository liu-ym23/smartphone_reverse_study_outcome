package android.os.collector.config;

import android.content.res.stepostheme.iconfilter.constants.Constants;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class StepOSAppClassifyConfig {
    private static final String APP_TYPE_FILE = "app_type_config.json";
    public static final int APP_TYPE_MUSIC = 7;
    public static final int APP_TYPE_UNKNOWN = 0;
    private static final String CONFIG_DIR = "/system_ext/etc/appclassify/";
    private static final String TAG = "StepOSAppClassifyConfig";
    private static final String TOP_APP_FILE = "top_app_list.json";
    private static volatile StepOSAppClassifyConfig sInstance;
    private volatile ArrayMap<String, Integer> mAppTypeMap = new ArrayMap<>();
    private volatile ArraySet<String> mTopAppSet = new ArraySet<>();

    private StepOSAppClassifyConfig() throws JSONException {
        loadConfigs();
    }

    public static StepOSAppClassifyConfig getInstance() {
        if (sInstance == null) {
            synchronized (StepOSAppClassifyConfig.class) {
                if (sInstance == null) {
                    sInstance = new StepOSAppClassifyConfig();
                }
            }
        }
        return sInstance;
    }

    public int getAppType(String packageName) {
        Integer type;
        if (packageName == null || (type = this.mAppTypeMap.get(packageName)) == null) {
            return 0;
        }
        return type.intValue();
    }

    public boolean isMusicApp(String packageName) {
        return getAppType(packageName) == 7;
    }

    public boolean isTopApp(String packageName) {
        if (packageName == null) {
            return false;
        }
        return this.mTopAppSet.contains(packageName);
    }

    public void reload() throws JSONException {
        loadConfigs();
    }

    private void loadConfigs() throws JSONException {
        loadAppTypeConfig();
        loadTopAppList();
    }

    private void loadAppTypeConfig() throws JSONException {
        File file = new File(CONFIG_DIR, APP_TYPE_FILE);
        if (!file.exists()) {
            Log.w(TAG, "App type config not found: " + file.getAbsolutePath());
            return;
        }
        try {
            String json = readFileContent(file);
            JSONObject root = new JSONObject(json);
            JSONArray types = root.getJSONArray("types");
            ArrayMap<String, Integer> newMap = new ArrayMap<>();
            for (int i = 0; i < types.length(); i++) {
                JSONObject typeObj = types.getJSONObject(i);
                int type = typeObj.getInt(Constants.ATTR_TYPE);
                JSONArray packages = typeObj.getJSONArray("packages");
                for (int j = 0; j < packages.length(); j++) {
                    newMap.put(packages.getString(j), Integer.valueOf(type));
                }
            }
            this.mAppTypeMap = newMap;
        } catch (Exception e) {
            Log.e(TAG, "Failed to load app type config", e);
        }
    }

    private void loadTopAppList() throws JSONException {
        File file = new File(CONFIG_DIR, TOP_APP_FILE);
        if (!file.exists()) {
            Log.w(TAG, "Top app list not found: " + file.getAbsolutePath());
            return;
        }
        try {
            String json = readFileContent(file);
            JSONObject root = new JSONObject(json);
            JSONArray packages = root.getJSONArray("packages");
            ArraySet<String> newSet = new ArraySet<>();
            for (int i = 0; i < packages.length(); i++) {
                newSet.add(packages.getString(i));
            }
            this.mTopAppSet = newSet;
        } catch (Exception e) {
            Log.e(TAG, "Failed to load top app list", e);
        }
    }

    private String readFileContent(File file) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    reader.close();
                    return sb.toString();
                }
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
