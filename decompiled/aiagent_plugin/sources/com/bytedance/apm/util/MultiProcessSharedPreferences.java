package com.bytedance.apm.util;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessSharedPreferences extends PluginContentProvider implements SharedPreferences {
    private static String MONITOR_CONFIG_SP_NAME = "apm_config";
    public static String MONITOR_PROVIDER_SUFFIX = ".apm6";
    private static final String TAG = "MultiProcessSharedPref";
    private Application mApp;
    private ContentResolver mContentResolver;
    private Uri mDefaultUri;
    private String mUriString;

    /* JADX INFO: renamed from: com.bytedance.apm.util.MultiProcessSharedPreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;
        final /* synthetic */ MultiProcessSharedPreferences this$0;

        private EditorImpl(MultiProcessSharedPreferences r1) {
            this.this$0 = r1;
            this.mClear = false;
            this.mPuts = new HashMap();
        }

        /* synthetic */ EditorImpl(MultiProcessSharedPreferences r1, AnonymousClass1 r2) {
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
            this.mPuts.put(r3, com.bytedance.apm6.util.f.a(r5));
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
            ZeusProviderTransform.call(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(MultiProcessSharedPreferences.access$300(this.this$0), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), MultiProcessSharedPreferences.access$100(this.this$0), MultiProcessSharedPreferences.access$200(this.this$0), "edit", r5, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            com.bytedance.apm6.util.c.b.b(MultiProcessSharedPreferences.TAG, "apply exception: ", e);
            return;
        L5:
            if (this.mPuts.isEmpty() == false) goto L7;
        }
    }

    static {
    }

    public int delete(Uri r1, String r2, String[] r3) {
        return -1;
    }

    public String getType(Uri r1) {
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.aiagent.plugin");
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.aiagent.plugin");
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return -1;
    }

    static /* synthetic */ Uri access$100(MultiProcessSharedPreferences r0) {
        return r0.mDefaultUri;
    }

    static /* synthetic */ String access$200(MultiProcessSharedPreferences r0) {
        return r0.mUriString;
    }

    static /* synthetic */ Application access$300(MultiProcessSharedPreferences r0) {
        return r0.mApp;
    }

    public MultiProcessSharedPreferences() {
    }

    public static Uri getSpUri(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r0 = r4.getPackageName();
        String r5 = ToolUtils.a(r4, MultiProcessSharedPreferences.class.getName());
        if (TextUtils.isEmpty(r5) == false) goto L5;
        Uri r6 = Uri.parse("content://" + r0 + MONITOR_PROVIDER_SUFFIX);
    L9:
        return r6.buildUpon().appendPath("sp").appendPath(MONITOR_CONFIG_SP_NAME).build();
    L5:
        r6 = Uri.parse("content://" + r5);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a(TAG, "authority is " + r6);
        goto L9
    }

    private MultiProcessSharedPreferences(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        this.mApp = r4;
        Uri r5 = getSpUri(r4);
        this.mDefaultUri = r5;
        this.mUriString = r5.toString();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.a(TAG, "getSpUri is " + this.mDefaultUri);
        return;
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
    public boolean contains(String r11) {
        if (this.mDefaultUri != null) goto L5;
        return false;
    L5:
        Bundle r1 = null;
        ContentResolver r4 = this.mApp.getContentResolver();     // Catch: Throwable -> L12
        Uri r5 = this.mDefaultUri;     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        String r10 = this.mUriString + "/" + r11;     // Catch: Throwable -> L12
    L10:
        r1 = ZeusProviderTransform.call(r4, r5, r10, "contains", null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
    L14:
        if (r1 != null) goto L16;
        return false;
    L16:
        if (r1.getBoolean("contains") == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        r10 = this.mUriString;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-AsyncTask", "contains", th);
        goto L14
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

    public static SharedPreferences getSharedPreferences(Context r2) {
        return getProviderSharedPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private static SharedPreferences getProviderSharedPreferences(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == false) goto L5;
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.aiagent.plugin");
    L7:
        return new MultiProcessSharedPreferences(r4);
    L5:
        r4 = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private synchronized Pair<SharedPreferences, String> parseMethod(Uri r9) {
        monitor-enter(this);
        List<String> r10 = r9.getPathSegments();     // Catch: Throwable -> L17
        String r0 = null;
        if (r10 != null) goto L6;
    L15:
        monitor-exit(this);
        return null;
    L6:
        if (r10.size() < 2) goto L15;
        if ("sp".equals(r10.get(0)) == false) goto L15;
        SharedPreferences r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences((String) ZeusTransformUtils.preCheckCast(r10.get(1), String.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L17
        if (r10.size() <= 2) goto L12;
        r0 = (String) ZeusTransformUtils.preCheckCast(r10.get(2), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L12:
        Pair<SharedPreferences, String> r1 = new Pair(r3, r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    public boolean onCreate() {
        this.mContentResolver = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver();
        return false;
    }

    private Bundle querySP(SharedPreferences r6, String r7, Object r8) {
        SharedPreferences r5 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.class, "com.obric.aiagent.plugin");
        Bundle r9 = new Bundle();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        if (r7 != null) goto L9;
        Iterator<Map.Entry<String, ?>> r10 = r5.getAll().entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r1.add(new SpPair((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin"), r11.getValue()));
        goto L6
    L8:
        r9.putParcelableArrayList("sp", r1);
    L17:
        return r9;
    L9:
        Object r12 = r5.getAll().get(r7);
        if (r12 == null) goto L14;
        r8 = r12;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == false) goto L16;
        r8 = com.bytedance.apm6.util.f.a((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.aiagent.plugin"));
    L16:
        r1.add(new SpPair(r7, r8));
        r9.putParcelableArrayList("sp", r1);
        goto L17
    }

    public Bundle call(String r5, String r6, Bundle r7) {
        if (r7 == null) goto L4;
        r7.setClassLoader(getClass().getClassLoader());
    L4:
        Pair<SharedPreferences, String> r0 = parseMethod(Uri.parse(r5));
        Object r1 = null;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (DownloadConstants.QUERY_KEY.equals(r6) == false) goto L16;
        if (r7 == null) goto L14;
        SpPair r8 = (SpPair) ZeusTransformUtils.preCheckCast(r7.getParcelable("sp"), SpPair.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        r1 = r8.mValue;
    L14:
        return querySP((SharedPreferences) ZeusTransformUtils.preCheckCast(r0.first, SharedPreferences.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.second, String.class, "com.obric.aiagent.plugin"), r1);
    L16:
        if ("contains".equals(r6) == false) goto L20;
        return containsSP((SharedPreferences) ZeusTransformUtils.preCheckCast(r0.first, SharedPreferences.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.second, String.class, "com.obric.aiagent.plugin"));
    L20:
        if ("edit".equals(r6) == false) goto L26;
        if (r7 == null) goto L26;
        editSP((SharedPreferences) ZeusTransformUtils.preCheckCast(r0.first, SharedPreferences.class, "com.obric.aiagent.plugin"), r7);     // Catch: Throwable -> L24
        long r9 = Binder.clearCallingIdentity();     // Catch: Throwable -> L24
        ZeusProviderTransform.notifyChange(this.mContentResolver, Uri.parse(r5), null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(r9);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(TAG, "edit", th);
    L26:
        return null;
    }

    private Bundle containsSP(SharedPreferences r2, String r3) {
        SharedPreferences r1 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.aiagent.plugin");
        Bundle r4 = new Bundle();
        r4.putBoolean("contains", r1.contains(r3));
        return r4;
    }

    private void editSP(SharedPreferences r3, Bundle r4) {
        SharedPreferences.Editor r2 = ((SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.aiagent.plugin")).edit();
        if (r4.getBoolean("clear") == false) goto L5;
        r2.clear();
    L5:
        ArrayList r5 = r4.getParcelableArrayList("edit");
        if (r5 != null) goto L8;
        return;
    L8:
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        SpPair r7 = (SpPair) ZeusTransformUtils.preCheckCast(r6.next(), SpPair.class, "com.obric.aiagent.plugin");
        if (r7.mValue == null) goto L13;
        edit(r2, r7.mKey, r7.mValue);
        goto L10
    L13:
        r2.remove(r7.mKey);
        goto L10
    L15:
        r2.commit();
    }

    private static void edit(SharedPreferences.Editor r3, String r4, Object r5) {
        SharedPreferences.Editor r6 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L6;
        r6.putString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L9;
        r6.putInt(r4, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L12;
        r6.putLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L15;
        r6.putFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L18;
        r6.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L18:
        if ((r5 instanceof String[]) == false) goto L26;
        r6.putStringSet(r4, new HashSet(Arrays.asList((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin"))));
        return;
    }
}
