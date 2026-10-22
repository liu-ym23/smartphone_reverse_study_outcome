package com.bytedance.common.wschannel;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends PluginContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    private static final String SP_CONFIG_NAME = "wschannel_multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri = null;
    private static b sInstance = null;
    private static boolean sIsRegisterInMainProcess = false;
    private static volatile boolean sLoadValuesInit = false;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private SharedPreferences mSharedPreferences;
    private final Object sLoadValuesInitLock;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f6751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f6752b;

        /* synthetic */ a(Context r2, AnonymousClass1 r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        }

        private a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.f6752b = new ContentValues();
            this.f6751a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        public synchronized void a() {
            monitor-enter(this);
            ZeusProviderTransform.insert(this.f6751a.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.f6751a, WsChannelMultiProcessSharedProvider.KEY, "type"), this.f6752b, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void b() {
            monitor-enter(this);
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public a a(String r2, String r3) {
            this.f6752b.put(r2, r3);
            return this;
        }

        public a a(String r2, boolean r3) {
            this.f6752b.put(r2, Boolean.valueOf(r3));
            return this;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f6753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SharedPreferences f6755c;

        /* synthetic */ b(Context r2, AnonymousClass1 r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        }

        private b(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            boolean r0 = false;
            this.f6754b = false;
            if (com.bytedance.common.wschannel.e.c.a(r5) == true) goto L5;
        L7:
            this.f6754b = r0;
            Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f6753a = r6;
            this.f6755c = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(WsChannelMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.access$300() == false) goto L7;
            r0 = true;
            goto L7
        }

        public a a() {
            return new a(this.f6753a, null);
        }

        public String a(String r9, String r10) {
        L8:
            return r10;
        L3:
            if (this.f6754b == false) goto L7;
            return this.f6755c.getString(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.access$400(ZeusProviderTransform.query(this.f6753a.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.f6753a, r9, WsChannelMultiProcessSharedProvider.STRING_TYPE), null, null, null, null, "com.obric.aiagent.plugin"), r10);
        }

        public long a(String r9, long r10) {
        L8:
            return r10;
        L3:
            if (this.f6754b == false) goto L7;
            return this.f6755c.getLong(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.access$500(ZeusProviderTransform.query(this.f6753a.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.f6753a, r9, WsChannelMultiProcessSharedProvider.LONG_TYPE), null, null, null, null, "com.obric.aiagent.plugin"), r10);
        }

        public boolean a(String r9, boolean r10) {
        L8:
            return r10;
        L3:
            if (this.f6754b == false) goto L7;
            return this.f6755c.getBoolean(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.access$700(ZeusProviderTransform.query(this.f6753a.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.f6753a, r9, WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE), null, null, null, null, "com.obric.aiagent.plugin"), r10);
        }
    }

    static {
    }

    public WsChannelMultiProcessSharedProvider() {
        this.mContentValues = new ConcurrentHashMap();
        this.sLoadValuesInitLock = new Object();
    }

    static /* synthetic */ void access$000(WsChannelMultiProcessSharedProvider r0, Uri r1) {
        r0.notifyContentChanged(r1);
    }

    static /* synthetic */ boolean access$300() {
        return sIsRegisterInMainProcess;
    }

    static /* synthetic */ String access$400(Cursor r2, String r3) {
        return getStringValue((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ long access$500(Cursor r2, long r3) {
        return getLongValue((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ float access$600(Cursor r2, float r3) {
        return getFloatValue((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ boolean access$700(Cursor r2, boolean r3) {
        return getBooleanValue((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ int access$800(Cursor r2, int r3) {
        return getIntValue((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
    }

    private void notifyContentChanged(Uri r3) {
        ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r3, null, "com.obric.aiagent.plugin");
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r0 = this.mSharedPreferences;     // Catch: Throwable -> L14
        if (r0 != null) goto L12;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r1 < 11) goto L8;
        int r3 = 4;
    L9:
        SharedPreferences r4 = r2.getSharedPreferences(SP_CONFIG_NAME, r3);     // Catch: Throwable -> L14
        this.mSharedPreferences = r4;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L8:
        r3 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    private static void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r4, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", sShareAuthority);
    L10:
        UriMatcher r5 = new UriMatcher(-1);
        sMatcher = r5;
        r5.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public static String getProviderAuthority(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L14:
        return null;
    L5:
        if (com.bytedance.common.utility.j.a(r6) == true) goto L14;
        ProviderInfo[] r8 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r8.length;     // Catch: Exception -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ProviderInfo r3 = r8[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        sShareAuthority = r4.authority;
    L5:
        super.attachInfo(r5, r4);
    }

    public boolean onCreate() {
        if (com.bytedance.common.wschannel.e.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
        sIsRegisterInMainProcess = true;
    L5:
        l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (sMatcher == null) goto L16;
    L15:
        return true;
    L16:
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
        goto L15
    }

    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    public int delete(Uri r2, String r3, String[] r4) {
        if (sMatcher.match(r2) != 65536) goto L8;
        getMultiProcessSharedPreferences().edit().clear().commit();     // Catch: Exception -> L9
        this.mContentValues.clear();     // Catch: Exception -> L9
        notifyContentChanged(getContentUri((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), KEY, "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    public Uri insert(Uri r12, ContentValues r13) {
        if (sMatcher.match(r12) != 65536) goto L66;
        loadValues();     // Catch: Exception -> L67
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L67
        Iterator<Map.Entry<String, Object>> r14 = r13.valueSet().iterator();     // Catch: Exception -> L67
        SharedPreferences.Editor r2 = null;
    L8:
        if (r14.hasNext() == false) goto L53;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L67
        Object r5 = r3.getValue();     // Catch: Exception -> L67
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L67
        if (Logger.debug() == false) goto L13;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r4 + " value = " + r5.toString());     // Catch: Exception -> L67
    L13:
        boolean r6 = false;
        if (r5 != null) goto L17;
        this.mContentValues.remove(r4);     // Catch: Exception -> L67
    L16:
        r6 = true;
    L22:
        if (r6 == false) goto L8;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r2 != null) goto L32;
        r2 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L67
    L32:
        if (r5 != null) goto L35;
        r2.remove(r4);     // Catch: Exception -> L67
        Runnable r7 = null;
    L49:
        if (r7 == null) goto L8;
        r1.add(r7);     // Catch: Exception -> L67
        goto L8
    L35:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L38;
        r2.putString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L67
        r7 = createNotifyRunnable(r4, STRING_TYPE);     // Catch: Exception -> L67
        goto L49
    L38:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L41;
        r2.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Exception -> L67
        r7 = createNotifyRunnable(r4, BOOLEAN_TYPE);     // Catch: Exception -> L67
        goto L49
    L41:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L44;
        r2.putLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L67
        r7 = createNotifyRunnable(r4, LONG_TYPE);     // Catch: Exception -> L67
        goto L49
    L44:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L47;
        r2.putInt(r4, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L67
        r7 = createNotifyRunnable(r4, INT_TYPE);     // Catch: Exception -> L67
        goto L49
    L47:
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L52;
        r2.putFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin")).floatValue());     // Catch: Exception -> L67
        r7 = createNotifyRunnable(r4, FLOAT_TYPE);     // Catch: Exception -> L67
        goto L49
    L52:
        throw new IllegalArgumentException("Unsupported type " + r12);     // Catch: Exception -> L67
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r4 + " value = " + r5) == null) goto L28;
        String r8 = r5.toString();     // Catch: Exception -> L67
    L29:
        Logger.v("PushService", r8);     // Catch: Exception -> L67
        goto L30
    L28:
        r8 = "null";
        goto L29
    L17:
        Object r10 = this.mContentValues.get(r4);     // Catch: Exception -> L67
        if (r10 != null) goto L20;
    L21:
        this.mContentValues.put(r4, r5);     // Catch: Exception -> L67
        goto L16
    L20:
        if (r10.equals(r5) == true) goto L22;
    L53:
        if (r2 != null) goto L56;
        return null;
    L56:
        if (Build.VERSION.SDK_INT <= 8) goto L58;
        r2.apply();     // Catch: Exception -> L67
    L59:
        Iterator r11 = r1.iterator();     // Catch: Exception -> L67
    L61:
        if (r11.hasNext() == false) goto L64;
        ((Runnable) ZeusTransformUtils.preCheckCast(r11.next(), Runnable.class, "com.obric.aiagent.plugin")).run();     // Catch: Exception -> L67
        goto L61
    L58:
        r2.commit();     // Catch: Exception -> L67
    L64:
        return null;
    L66:
        throw new IllegalArgumentException("Unsupported uri " + r12);
    }

    private Runnable createNotifyRunnable(final String r2, final String r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public Cursor query(Uri r5, String[] r6, String r7, String[] r8, String r9) {
        if (sMatcher.match(r5) != 65536) goto L54;
        ?? r10 = 0;
        int r11 = 1;
        if ("all".equals((String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(1), String.class, "com.obric.aiagent.plugin")) == false) goto L34;
        Map<String, ?> r4 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L55
        MatrixCursor r12 = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r13 = r4.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        boolean r14 = r13.hasNext();     // Catch: Exception -> L33
        r10 = r14;
        if (r14 == false) goto L60;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
        Object r17 = r15.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r1 = r12.newRow();     // Catch: Exception -> L33
        boolean r2 = ZeusTransformUtils.instanceOf(r17, String.class);     // Catch: Exception -> L33
        String r3 = STRING_TYPE;
        if (r2 == true) goto L31;
        if (ZeusTransformUtils.instanceOf(r17, Boolean.class) == false) goto L23;
        r3 = BOOLEAN_TYPE;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L20;
        int r18 = 1;
    L21:
        r17 = Integer.valueOf(r18);     // Catch: Exception -> L33
        goto L31
    L20:
        r18 = 0;
        goto L21
    L23:
        if (ZeusTransformUtils.instanceOf(r17, Integer.class) == false) goto L26;
        r3 = INT_TYPE;
        goto L31
    L26:
        if (ZeusTransformUtils.instanceOf(r17, Long.class) == false) goto L29;
        r3 = LONG_TYPE;
        goto L31
    L29:
        if (ZeusTransformUtils.instanceOf(r17, Float.class) == false) goto L31;
        r3 = FLOAT_TYPE;
    L31:
        r1.add(r16);     // Catch: Exception -> L33
        r1.add(r17);     // Catch: Exception -> L33
        r1.add(r3);     // Catch: Exception -> L33
    L60:
        return r12;
    L33:
        r10 = r12;
        goto L69
    L34:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L55
        loadValues();     // Catch: Exception -> L55
        if (this.mContentValues.containsKey(r19) == true) goto L37;
        return null;
    L37:
        MatrixCursor r20 = new MatrixCursor(new String[]{r19});     // Catch: Exception -> L55
        Object r21 = this.mContentValues.get(r19);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r22 = r20.newRow();     // Catch: Exception -> L50
        if (ZeusTransformUtils.instanceOf(r21, Boolean.class) == false) goto L46;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r21, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L44;
        r11 = 0;
    L44:
        r21 = Integer.valueOf(r11);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r19 + " value = " + r21.toString());     // Catch: Exception -> L50
    L48:
        r22.add(r21);     // Catch: Exception -> L50
        r12 = r20;
        r10 = r22;
    L50:
        r10 = r20;
    L69:
        return r10;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r5);
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }

    private void loadValues() {
        if (sLoadValuesInit == true) goto L23;
        Object r0 = this.sLoadValuesInitLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (sLoadValuesInit == true) goto L18;
        SharedPreferences r1 = getMultiProcessSharedPreferences();     // Catch: Throwable -> L20
        if (r1 != null) goto L13;
        sLoadValuesInit = true;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r2 = r1.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Object r5 = r3.getValue();     // Catch: Throwable -> L20
        this.mContentValues.put(r4, r5);     // Catch: Throwable -> L20
        goto L15
    L17:
        sLoadValuesInit = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }

    private static String getStringValue(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getString(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    private static boolean getBooleanValue(Cursor r2, boolean r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L18;
        return r3;
    L18:
    L14:
        if (r4 != null) goto L20;
    L16:
        return r3;
    L20:
        r4.close();     // Catch: Exception -> L17
        goto L16
    L6:
        if (r4.moveToFirst() == false) goto L11;
        if (r4.getInt(0) <= 0) goto L10;
        r3 = true;
        goto L11
    L10:
        r3 = false;
    L11:
        if (r4 == null) goto L16;
        goto L16
    }

    private static int getIntValue(Cursor r2, int r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getInt(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    private static long getLongValue(Cursor r2, long r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getLong(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    private static float getFloatValue(Cursor r2, float r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getFloat(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    public static a edit(Context r2) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public static synchronized b getMultiprocessShared(Context r3) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new b(r4, null);     // Catch: Throwable -> L10
    L7:
        b r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static final synchronized Uri getContentUri(Context r3, String r4, String r5) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (sBaseUri == null) goto L23;
    L16:
        Uri r7 = sBaseUri.buildUpon().appendPath(r4).appendPath(r5).build();     // Catch: Throwable -> L19
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r7;
    L23:
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        return null;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("MultiProcessSharedProvider", "init form getContentUri");     // Catch: Exception -> L11 Throwable -> L19
    L9:
        init(r6);     // Catch: Exception -> L11 Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
