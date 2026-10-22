package com.bytedance.android.live.hostadapter.network.localdata;

import android.content.SharedPreferences;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;

/* JADX INFO: loaded from: classes45.dex */
public class LocalData {
    public static Key<Boolean> KEY_BOE_STATUS = null;
    public static Key<Boolean> KEY_ENABLE_WEB_OFFLINE = null;
    public static Key<String> KEY_FEED_SIMULATION_ROOMS = null;
    public static Key<Integer> KEY_FEED_SIMULATION_STYLE = null;
    public static Key<String> KEY_HISTORY_ENTER_ROOM_OPEN_ID = null;
    public static Key<String> KEY_LAST_ENTER_EPISODE_ID = null;
    public static Key<String> KEY_LAST_ENTER_EPISODE_IDS = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_ID = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_IDS = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_OPEN_ID = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_OPEN_IDS = null;
    public static Key<String> KEY_LOGIN_SESSION_KEY = null;
    public static Key<Boolean> KEY_LOGIN_STATUE = null;
    public static Key<String> KEY_LOGIN_UID = null;
    public static Key<String> KEY_LOGIN_USER_SESSION = null;
    private static final String VIRTUAL_SP = "virtual_sp";
    private static SharedPreferences sSharedPreferences;

    public static class Key<T> {
        protected String mKeyName;
        protected T mValue;
        protected Class<T> mValueType;

        public T getValue() {
            return this.mValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setValue(T r100) {
            this.mValue = r100;
            SharedPreferences.Editor r101 = LocalData.getEditor();
            if ((r100 instanceof Boolean) == false) goto L6;
            r101.putBoolean(this.mKeyName, ((Boolean) r100).booleanValue());
        L18:
            r101.apply();
            return;
        L6:
            if ((r100 instanceof Integer) == false) goto L9;
            r101.putInt(this.mKeyName, ((Integer) r100).intValue());
            goto L18
        L9:
            if ((r100 instanceof Long) == false) goto L12;
            r101.putLong(this.mKeyName, ((Long) r100).longValue());
            goto L18
        L12:
            if ((r100 instanceof Float) == false) goto L15;
            r101.putFloat(this.mKeyName, ((Float) r100).floatValue());
            goto L18
        L15:
            if ((r100 instanceof String) == false) goto L17;
            r101.putString(this.mKeyName, (String) r100);
            goto L18
        L17:
            r101.putString(this.mKeyName, r100.toString());
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void initValue(Class r100, T r101) {
            if (r100 != Boolean.class) goto L5;
        L35:
            T r102 = (T) Boolean.valueOf(LocalData.getSp().getBoolean(this.mKeyName, ((Boolean) r101).booleanValue()));
        L36:
            this.mValue = r102;
            return;
        L5:
            if (r100 == Boolean.TYPE) goto L35;
            if (r100 != Integer.class) goto L10;
        L34:
            r102 = (T) Integer.valueOf(LocalData.getSp().getInt(this.mKeyName, ((Integer) r101).intValue()));
            goto L36
        L10:
            if (r100 == Integer.TYPE) goto L34;
            if (r100 != Long.class) goto L15;
        L33:
            r102 = (T) Long.valueOf(LocalData.getSp().getLong(this.mKeyName, ((Long) r101).longValue()));
            goto L36
        L15:
            if (r100 == Long.TYPE) goto L33;
            if (r100 != Float.class) goto L20;
        L32:
            r102 = (T) Float.valueOf(LocalData.getSp().getFloat(this.mKeyName, ((Float) r101).floatValue()));
            goto L36
        L20:
            if (r100 == Float.TYPE) goto L32;
            String r103 = null;
            if (r100 != String.class) goto L28;
            SharedPreferences r104 = LocalData.getSp();
            String r105 = this.mKeyName;
            if (r101 == 0) goto L27;
            r103 = (String) r101;
        L27:
            r102 = (T) r104.getString(r105, r103);
            goto L36
        L28:
            SharedPreferences r106 = LocalData.getSp();
            String r107 = this.mKeyName;
            if (r101 == 0) goto L31;
            r103 = (String) r101;
        L31:
            r102 = (T) r106.getString(r107, r103);
            goto L36
        }

        public Key(String r100, Class<T> r101, T r102) {
            this.mKeyName = r100;
            this.mValueType = r101;
            this.mValue = r102;
            initValue(r101, r102);
        }
    }

    public LocalData() {
    }

    public static void init() {
    }

    static {
        Class r100 = Boolean.TYPE;
        Boolean r101 = Boolean.FALSE;
        KEY_LOGIN_STATUE = new Key("virtual_login_statue", r100, r101);
        KEY_LOGIN_UID = new Key("virtual_login_uid", String.class, "");
        KEY_LOGIN_SESSION_KEY = new Key("virtual_login_session_key", String.class, "");
        KEY_BOE_STATUS = new Key("virtual_boe_status", r100, r101);
        KEY_ENABLE_WEB_OFFLINE = new Key("Virtual_enable_web_offline", r100, Boolean.TRUE);
        KEY_LAST_ENTER_ROOM_ID = new Key("Virtual_last_enter_room_id", String.class, "");
        KEY_LAST_ENTER_ROOM_OPEN_ID = new Key("Virtual_last_enter_room_open_id", String.class, "");
        KEY_HISTORY_ENTER_ROOM_OPEN_ID = new Key("virtual_history_enter_room_open_id", String.class, "");
        KEY_LOGIN_USER_SESSION = new Key("VIRTUAL_LOGIN_USER_SESSION", String.class, "");
        KEY_LAST_ENTER_ROOM_IDS = new Key("Virtual_last_enter_room_ids", String.class, "");
        KEY_LAST_ENTER_ROOM_OPEN_IDS = new Key("Virtual_last_enter_room_open_ids", String.class, "");
        KEY_LAST_ENTER_EPISODE_IDS = new Key("Virtual_last_enter_episode_ids", String.class, "");
        KEY_LAST_ENTER_EPISODE_ID = new Key("Virtual_last_enter_episode_id", String.class, "");
        KEY_FEED_SIMULATION_STYLE = new Key("Virtual_KEY_FEED_SIMULATION_STYLE", Integer.class, 1);
        KEY_FEED_SIMULATION_ROOMS = new Key("Virtual_KEY_FEED_SIMULATION_ROOMS", String.class, "");
    }

    public static SharedPreferences getSp() {
        if (sSharedPreferences != null) goto L6;
        sSharedPreferences = BDLiveSdk.getContext().getSharedPreferences(VIRTUAL_SP, 0);
    L6:
        return sSharedPreferences;
    }

    public static SharedPreferences.Editor getEditor() {
        return getSp().edit();
    }
}
