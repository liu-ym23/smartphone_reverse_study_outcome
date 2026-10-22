package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.j;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorSharedPreferences implements SharedPreferences {
    private static int sTargetPID = -1;
    private Application mApp;
    private Uri mDefaultUri;
    private String mUriString;

    /* JADX INFO: renamed from: com.bytedance.apm.core.MonitorSharedPreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;
        final /* synthetic */ MonitorSharedPreferences this$0;

        private EditorImpl(MonitorSharedPreferences r1) {
            this.this$0 = r1;
            this.mClear = false;
            this.mPuts = new HashMap();
        }

        /* synthetic */ EditorImpl(MonitorSharedPreferences r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.mPuts.put(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r3, Set<String> r4) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            this.mPuts.put(r3, j.a(r5));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.mPuts.put(r2, Integer.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.mPuts.put(r2, Long.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.mPuts.put(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.mPuts.put(r2, Boolean.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r3) {
            this.mPuts.put(r3, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mPuts.clear();
            this.mClear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.mClear == false) goto L5;
        L7:
            Bundle r5 = new Bundle();
            if (this.mClear == false) goto L10;
            r5.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r0 = new ArrayList(this.mPuts.size());
            Iterator<Map.Entry<String, Object>> r1 = this.mPuts.entrySet().iterator();
        L12:
            if (r1.hasNext() == false) goto L14;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            r0.add(new SpPair((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue()));
            goto L12
        L14:
            r5.putParcelableArrayList("edit", r0);
            ZeusProviderTransform.call(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(MonitorSharedPreferences.access$300(this.this$0), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), MonitorSharedPreferences.access$100(this.this$0), MonitorSharedPreferences.access$200(this.this$0), "edit", r5, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.mPuts.isEmpty() == false) goto L7;
        }
    }

    static {
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.aiagent.plugin");
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ Uri access$100(MonitorSharedPreferences r0) {
        return r0.mDefaultUri;
    }

    static /* synthetic */ String access$200(MonitorSharedPreferences r0) {
        return r0.mUriString;
    }

    static /* synthetic */ Application access$300(MonitorSharedPreferences r0) {
        return r0.mApp;
    }

    private MonitorSharedPreferences(Application r4, String r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
        this.mApp = r6;
        String r7 = "content://" + r6.getPackageName() + ".apm/sp/" + r5;
        this.mUriString = r7;
        this.mDefaultUri = Uri.parse(r7);
        Field r8 = getClass().getDeclaredField("mUriString");
        r8.setAccessible(true);
        String r9 = "content://com.larus.nova.apm/sp/" + r5;
        r8.set(this, r9);
        Field r10 = getClass().getDeclaredField("mDefaultUri");
        r10.setAccessible(true);
        r10.set(this, Uri.parse(r9));
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r4 = getPairs(null, null);
        if (r4 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<SpPair> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        SpPair r1 = (SpPair) ZeusTransformUtils.preCheckCast(r5.next(), SpPair.class, "com.obric.aiagent.plugin");
        r0.put(r1.mKey, r1.mValue);
        goto L7
    L9:
        return r0;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        ArrayList<SpPair> r0 = getPairs(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(((SpPair) ZeusTransformUtils.preCheckCast(r0.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue, String.class, "com.obric.aiagent.plugin");
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r4, Set<String> r5) {
        ArrayList<SpPair> r3 = getPairs(r4, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L6;
        return null;
    L6:
        if (((SpPair) ZeusTransformUtils.preCheckCast(r3.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue != null) goto L8;
        return null;
    L8:
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(((SpPair) ZeusTransformUtils.preCheckCast(r3.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue, String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin");
        HashSet r7 = new HashSet(r6.length);
        r7.addAll(Arrays.asList(r6));
        return r7;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r2, int r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L10;
        return ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L12;
        return r3;
    L12:
        return Integer.decode((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r2, long r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L10;
        return ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).longValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L12;
        return r3;
    L12:
        return Long.decode((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r2, float r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L10;
        return ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L12;
        return r3;
    L12:
        return Float.valueOf((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).floatValue();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r2, boolean r3) {
        ArrayList<SpPair> r1 = getPairs(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.aiagent.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L10;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L12;
        return r3;
    L12:
        return Boolean.valueOf((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r8) {
        ContentResolver r1 = this.mApp.getContentResolver();     // Catch: Exception -> L8
        Uri r2 = this.mDefaultUri;     // Catch: Exception -> L8
        if (r8 == null) goto L5;
        String r7 = this.mUriString + "/" + r8;     // Catch: Exception -> L8
    L6:
        Bundle r9 = ZeusProviderTransform.call(r1, r2, r7, "contains", null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
    L9:
        if (r9 != null) goto L11;
    L13:
        return false;
    L11:
        if (r9.getBoolean("contains") == false) goto L13;
        return true;
    L5:
        r7 = this.mUriString;     // Catch: Exception -> L8
    L8:
        r9 = null;
        goto L9
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorImpl(this, null);
    }

    private ArrayList<SpPair> getPairs(String r11, Object r12) {
        Bundle r0 = new Bundle();
        if (r12 == null) goto L21;
        r0.putParcelable("sp", new SpPair(r11, r12));
    L21:
        ContentResolver r4 = this.mApp.getContentResolver();     // Catch: Exception -> L16
        Uri r5 = this.mDefaultUri;     // Catch: Exception -> L16
        if (r11 == null) goto L9;
        String r13 = this.mUriString + "/" + r11;     // Catch: Exception -> L16
    L10:
        String r6 = r13;
        if (r12 == null) goto L13;
        Bundle r8 = r0;
    L14:
        Bundle r14 = ZeusProviderTransform.call(r4, r5, r6, DownloadConstants.QUERY_KEY, r8, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
    L17:
        if (r14 != null) goto L19;
        return null;
    L19:
        r14.setClassLoader(getClass().getClassLoader());
        return r14.getParcelableArrayList("sp");
    L13:
        r8 = null;
        goto L14
    L9:
        r13 = this.mUriString;     // Catch: Exception -> L16
    L16:
        r14 = null;
        goto L17
    }

    private static int getProviderPID(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Bundle r9 = ZeusProviderTransform.call(r8.getContentResolver(), Uri.parse("content://" + r8.getPackageName() + ".apm"), "getPid", null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        if (r9 == null) goto L7;
        return r9.getInt("Pid", -1);
    L7:
        return -1;
    }

    public static SharedPreferences getSharedPreferences(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (isProviderProcess(r4) == false) goto L7;
        return r4.getSharedPreferences(r3, 0);
    L7:
        return getProviderSharedPreferences(r4, r3);
    }

    static SharedPreferences getProviderSharedPreferences(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == false) goto L5;
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.aiagent.plugin");
    L7:
        return new MonitorSharedPreferences(r5, r3);
    L5:
        r5 = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        goto L7
    }

    public static boolean isProviderProcess(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (sTargetPID != (-1)) goto L6;
        sTargetPID = getProviderPID(r3);
    L6:
        if (sTargetPID != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }
}
