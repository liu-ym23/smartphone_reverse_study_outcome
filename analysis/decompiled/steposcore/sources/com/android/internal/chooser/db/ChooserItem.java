package com.android.internal.chooser.db;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChooserItem {
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_LAST_TIME = "lastTime";
    private static final String KEY_ORDER = "order";
    private static final String KEY_PACKAGE_NAME = "package";
    private static final String KEY_STATE = "state";
    private static final String KEY_USAGE_COUNT = "usageCount";
    public static final int STATE_ADDED = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_REMOVED = 2;
    private String mClassName;
    private long mLastTime;
    private int mOrder;
    private String mPackage;
    private int mState;
    private int mUsageCount;

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public ChooserItem(String packageName, String className, int usageCount, long lastTime, int state, int order) {
        this.mPackage = packageName;
        this.mClassName = className;
        this.mUsageCount = usageCount;
        this.mLastTime = lastTime;
        this.mState = state;
        this.mOrder = order;
    }

    public static ChooserItem fromJson(String json) throws JSONException {
        try {
            JSONObject root = new JSONObject(json);
            String packageName = root.getString(KEY_PACKAGE_NAME);
            String className = root.getString(KEY_CLASS_NAME);
            int usageCount = root.getInt(KEY_USAGE_COUNT);
            long lastTime = root.getLong(KEY_LAST_TIME);
            int state = root.getInt(KEY_STATE);
            int order = root.getInt(KEY_ORDER);
            return new ChooserItem(packageName, className, usageCount, lastTime, state, order);
        } catch (Exception e) {
            return null;
        }
    }

    public String toJson() throws JSONException {
        try {
            JSONObject root = new JSONObject();
            root.put(KEY_PACKAGE_NAME, this.mPackage);
            root.put(KEY_CLASS_NAME, this.mClassName);
            root.put(KEY_USAGE_COUNT, this.mUsageCount);
            root.put(KEY_LAST_TIME, this.mLastTime);
            root.put(KEY_STATE, this.mState);
            root.put(KEY_ORDER, this.mOrder);
            return root.toString(0);
        } catch (Exception e) {
            return null;
        }
    }

    public String getPackage() {
        return this.mPackage;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public int getUsageCount() {
        return this.mUsageCount;
    }

    public void setUsageCount(int usageCount) {
        this.mUsageCount = usageCount;
    }

    public long getLastTime() {
        return this.mLastTime;
    }

    public void setLastTime(long lastTime) {
        this.mLastTime = lastTime;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int order) {
        this.mOrder = order;
    }
}
