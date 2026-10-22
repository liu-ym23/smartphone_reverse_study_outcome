package com.android.internal.chooser.db;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChooserRepository {
    private static final String CHOOSER_REPOSITORY_FILE = "chooser_repository";
    public static final String CHOOSER_REPOSITORY_UPDATE_BY = "chooser_repository_update_by";
    private static final String KEY_USE_CUSTOMIZE_FAVORITE = "KEY_USE_CUSTOMIZE_FAVORITE";
    private static final int REPO_LENGTH_LIMIT = 32768;
    private static final int REPO_LENGTH_LIMIT_PROTECTION = 1500;
    private static final int REPO_SUM = 8;
    private static final String REPO_UPDATED_NOTIFY = "repo_updated_notify";
    private static final String TAG = "sys_ChooserRepository";
    private static ChooserRepository sInstance;
    private final Context mContext;
    private final List<WeakReference<OnDataChangedListener>> mDataChangedListener = new ArrayList();
    private final Map<ComponentName, ChooserItem> mChooserItems = new HashMap();

    public interface OnDataChangedListener {
        void onDataChanged();
    }

    public static ChooserRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ChooserRepository(context.getApplicationContext());
        }
        return sInstance;
    }

    private ChooserRepository(Context context) {
        this.mContext = context;
        loadAll();
    }

    public void loadAll() {
        ChooserItem item;
        for (Map.Entry<String, ?> entry : getAllData().entrySet()) {
            ComponentName key = ComponentName.unflattenFromString(entry.getKey());
            if (key != null && (entry.getValue() instanceof String) && (item = ChooserItem.fromJson((String) entry.getValue())) != null) {
                this.mChooserItems.put(key, item);
            }
        }
    }

    public boolean useCustomizeFavorite() {
        String str = Settings.System.getString(this.mContext.getContentResolver(), KEY_USE_CUSTOMIZE_FAVORITE);
        return Boolean.parseBoolean(str);
    }

    public void enableCustomizeFavorite() {
        Settings.System.putString(this.mContext.getContentResolver(), KEY_USE_CUSTOMIZE_FAVORITE, "true");
    }

    public ChooserItem getChooserItemInfo(ResolveInfo resolveInfo) throws JSONException {
        ComponentInfo componentInfo = resolveInfo.getComponentInfo();
        ComponentName componentName = ComponentName.createRelative(componentInfo.packageName, componentInfo.name);
        ChooserItem info = this.mChooserItems.get(componentName);
        if (info == null) {
            String json = getItemDataByCmpName(componentName.flattenToString());
            if (!TextUtils.isEmpty(json)) {
                info = ChooserItem.fromJson(json);
            }
            if (info == null) {
                info = new ChooserItem(componentInfo.packageName, componentInfo.name, 0, 0L, 0, -1);
            }
            this.mChooserItems.put(componentName, info);
        }
        return info;
    }

    public void updateUsageCount(ResolveInfo resolveInfo) throws JSONException {
        ChooserItem item = getChooserItemInfo(resolveInfo);
        item.setUsageCount(item.getUsageCount() + 1);
        item.setLastTime(System.currentTimeMillis());
        updateChooserItemInfo(item);
    }

    public void updateChooserItemInfo(ChooserItem chooserItem) throws JSONException {
        ComponentName componentName = ComponentName.createRelative(chooserItem.getPackage(), chooserItem.getClassName());
        this.mChooserItems.put(componentName, chooserItem);
        updateRepository(componentName.flattenToString(), chooserItem.toJson());
    }

    public void updateAllChooserItem() throws JSONException {
        String updateOwner = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_UPDATE_BY);
        if (!TextUtils.equals(updateOwner, this.mContext.getPackageName())) {
            Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_UPDATE_BY, this.mContext.getPackageName());
        }
        try {
            JSONObject jsonObject = new JSONObject();
            int num = 0;
            for (Map.Entry<ComponentName, ChooserItem> entry : this.mChooserItems.entrySet()) {
                jsonObject.put(entry.getKey().flattenToString(), entry.getValue().toJson());
                if (jsonObject.toString().length() > 31268) {
                    String jsonStr = jsonObject.toString();
                    Log.d(TAG, "updateAllChooserItem jsonStr:" + num + " length:" + jsonStr.length());
                    if (jsonStr.length() >= 32768) {
                        return;
                    }
                    if (num == 0) {
                        Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE, jsonStr);
                    } else {
                        Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + num, jsonStr);
                    }
                    num++;
                    jsonObject = new JSONObject();
                }
            }
            String jsonStr_ = jsonObject.toString();
            Log.d(TAG, "updateAllChooserItem jsonStr_" + num + " length:" + jsonStr_.length());
            if (jsonStr_.length() >= 32768) {
                return;
            }
            if (num == 0) {
                Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE, jsonStr_);
            } else {
                Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + num, jsonStr_);
            }
            Settings.System.putString(this.mContext.getContentResolver(), REPO_UPDATED_NOTIFY, String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            Log.d(TAG, "updateAllChooserItem ex " + e + " jsonObject.put error");
        }
    }

    public void updateFavorites(List<DisplayResolveInfo> favorites, boolean notify) throws JSONException {
        for (DisplayResolveInfo resolveInfo : favorites) {
            ChooserItem item = getChooserItemInfo(resolveInfo.resolveInfo);
            item.setState(1);
            if (item.getOrder() == -1) {
                item.setOrder(getNextOrder());
            }
        }
        updateAllChooserItem();
        enableCustomizeFavorite();
        if (notify) {
            notifyDataChanged();
        }
    }

    public void removeFavorite(List<DisplayResolveInfo> favorites, DisplayResolveInfo removedItem, boolean notify) throws JSONException {
        for (DisplayResolveInfo resolveInfo : favorites) {
            ChooserItem item = getChooserItemInfo(resolveInfo.resolveInfo);
            item.setState(1);
            if (item.getOrder() == -1) {
                item.setOrder(getNextOrder());
            }
        }
        ChooserItem item2 = getChooserItemInfo(removedItem.resolveInfo);
        int order = item2.getOrder();
        item2.setState(2);
        item2.setOrder(-1);
        if (order != -1) {
            for (ChooserItem value : this.mChooserItems.values()) {
                if (value.getOrder() > order) {
                    value.setOrder(value.getOrder() - 1);
                }
            }
        }
        updateAllChooserItem();
        enableCustomizeFavorite();
        if (notify) {
            notifyDataChanged();
        }
    }

    public void moveFavorite(List<DisplayResolveInfo> favorites, DisplayResolveInfo movedItem, DisplayResolveInfo beforeItem, boolean notify) throws JSONException {
        for (DisplayResolveInfo resolveInfo : favorites) {
            ChooserItem item = getChooserItemInfo(resolveInfo.resolveInfo);
            item.setState(1);
            if (item.getOrder() == -1) {
                item.setOrder(getNextOrder());
            }
        }
        ChooserItem movedChooserItem = getChooserItemInfo(movedItem.resolveInfo);
        ChooserItem beforeChooserItem = null;
        if (beforeItem != null) {
            beforeChooserItem = getChooserItemInfo(beforeItem.resolveInfo);
        }
        int movedIndex = movedChooserItem.getOrder();
        int beforeIndex = beforeChooserItem != null ? beforeChooserItem.getOrder() : -1;
        movedChooserItem.setOrder(-1);
        for (ChooserItem value : this.mChooserItems.values()) {
            if (value.getOrder() > movedIndex) {
                value.setOrder(value.getOrder() - 1);
            }
        }
        for (ChooserItem value2 : this.mChooserItems.values()) {
            if (value2.getOrder() > beforeIndex) {
                value2.setOrder(value2.getOrder() + 1);
            }
        }
        movedChooserItem.setOrder(beforeIndex + 1);
        updateAllChooserItem();
        enableCustomizeFavorite();
        if (notify) {
            notifyDataChanged();
        }
    }

    public int getNextOrder() {
        int maxOrder = -1;
        for (ChooserItem item : this.mChooserItems.values()) {
            maxOrder = Math.max(maxOrder, item.getOrder());
        }
        return maxOrder + 1;
    }

    public void registerListener(OnDataChangedListener listener) {
        this.mDataChangedListener.add(new WeakReference<>(listener));
    }

    public void unregisterListener(OnDataChangedListener listener) {
        Iterator<WeakReference<OnDataChangedListener>> iterator = this.mDataChangedListener.iterator();
        while (iterator.hasNext()) {
            WeakReference<OnDataChangedListener> item = iterator.next();
            OnDataChangedListener l = item.get();
            if (l == null || l == listener) {
                iterator.remove();
            }
        }
    }

    private void notifyDataChanged() {
        for (WeakReference<OnDataChangedListener> weakReference : this.mDataChangedListener) {
            OnDataChangedListener listener = weakReference.get();
            if (listener != null) {
                listener.onDataChanged();
            }
        }
    }

    private void addRepository(String cmpName, String details) throws JSONException {
        JSONObject jsonObject = null;
        for (int i = 1; i < 8; i++) {
            String str_ = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i);
            Log.d(TAG, "addRepository str_" + i + " length:" + (TextUtils.isEmpty(str_) ? 0 : str_.length()));
            if (TextUtils.isEmpty(str_)) {
                jsonObject = new JSONObject();
            } else if (str_.length() + cmpName.length() + details.length() + REPO_LENGTH_LIMIT_PROTECTION < 32768) {
                jsonObject = new JSONObject(str_);
            }
            if (jsonObject != null) {
                jsonObject.put(cmpName, details);
                String jsonStr = jsonObject.toString();
                Log.d(TAG, "addRepository jsonStr" + i + " length:" + jsonStr.length());
                if (jsonStr.length() >= 32768) {
                    return;
                }
                Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i, jsonStr);
                return;
            }
        }
    }

    private void updateRepository(String cmpName, String details) throws JSONException {
        JSONObject jsonObject;
        Log.d(TAG, "updateRepository  cmpName:" + (TextUtils.isEmpty(cmpName) ? 0 : cmpName.length()) + ", details:" + (TextUtils.isEmpty(details) ? 0 : details.length()));
        String updateOwner = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_UPDATE_BY);
        if (!TextUtils.equals(updateOwner, this.mContext.getPackageName())) {
            Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_UPDATE_BY, this.mContext.getPackageName());
        }
        try {
            String str = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE);
            if (TextUtils.isEmpty(str)) {
                jsonObject = new JSONObject();
            } else {
                if (checkAndUpdateRepository(str, cmpName, details)) {
                    return;
                }
                if (str.length() + cmpName.length() + details.length() + REPO_LENGTH_LIMIT_PROTECTION > 32768) {
                    addRepository(cmpName, details);
                    return;
                }
                jsonObject = new JSONObject(str);
            }
            jsonObject.put(cmpName, details);
            String jsonStr = jsonObject.toString();
            Log.d(TAG, "updateRepository jsonStr length:" + jsonStr.length());
            if (jsonStr.length() >= 32768) {
                return;
            }
            Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE, jsonStr);
            Settings.System.putString(this.mContext.getContentResolver(), REPO_UPDATED_NOTIFY, String.valueOf(System.currentTimeMillis()));
        } catch (JSONException e) {
            Log.d(TAG, "updateSettingProvider ex " + e + " jsonObject.put error");
        }
    }

    private boolean checkAndUpdateRepository(String str, String cmpName, String details) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jsonObject = new JSONObject(str);
        if (jsonObject.has(cmpName)) {
            jsonObject.put(cmpName, details);
            String jsonStr = jsonObject.toString();
            Log.d(TAG, "checkAndUpdateRepository jsonStr length:" + jsonStr.length());
            if (jsonStr.length() >= 32768) {
                return true;
            }
            Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE, jsonStr);
            return true;
        }
        for (int i = 1; i < 8; i++) {
            String str_ = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i);
            if (TextUtils.isEmpty(str_)) {
                return false;
            }
            JSONObject jsonObject2 = new JSONObject(str_);
            if (jsonObject2.has(cmpName)) {
                jsonObject2.put(cmpName, details);
                String jsonStr_ = jsonObject2.toString();
                Log.d(TAG, "checkAndUpdateRepository jsonStr_" + i + " length:" + jsonStr_.length());
                if (jsonStr_.length() >= 32768) {
                    return true;
                }
                Settings.System.putString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i, jsonStr_);
                return true;
            }
        }
        return false;
    }

    private String getItemDataByCmpName(String cmpName) {
        String str;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE);
        } catch (JSONException e) {
            Log.d(TAG, "getItemDataByCmpName ex " + e + " jsonObject.get error");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Log.d(TAG, "getItemDataByCmpName str length:" + str.length());
        JSONObject jsonObject = new JSONObject(str);
        if (jsonObject.has(cmpName)) {
            JSONObject itemJson = (JSONObject) jsonObject.get(cmpName);
            return itemJson.toString();
        }
        for (int i = 1; i < 8; i++) {
            String str_ = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i);
            if (TextUtils.isEmpty(str_)) {
                break;
            }
            Log.d(TAG, "getItemDataByCmpName str_" + i + " length:" + str_.length());
            JSONObject jsonObject2 = new JSONObject(str_);
            if (jsonObject2.has(cmpName)) {
                JSONObject itemJson2 = (JSONObject) jsonObject2.get(cmpName);
                return itemJson2.toString();
            }
        }
        return "";
    }

    private Map<String, ?> getAllData() {
        Map<String, String> map = new HashMap<>();
        String str = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE);
        Log.d(TAG, "getAllData str length:" + (TextUtils.isEmpty(str) ? 0 : str.length()));
        try {
            getAllData(map, str);
            for (int i = 1; i < 8; i++) {
                String str_ = Settings.System.getString(this.mContext.getContentResolver(), CHOOSER_REPOSITORY_FILE + i);
                Log.d(TAG, "getAllData str_" + i + " length:" + (TextUtils.isEmpty(str_) ? 0 : str_.length()));
                if (TextUtils.isEmpty(str_)) {
                    break;
                }
                getAllData(map, str_);
            }
        } catch (JSONException e) {
            Log.d(TAG, "getAllData ex " + e + " jsonObject.get error");
        }
        return map;
    }

    private void getAllData(Map<String, String> map, String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jsonObject = new JSONObject(str);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                map.put(key, value);
            }
        }
    }
}
