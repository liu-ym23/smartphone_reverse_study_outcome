package com.bytedance.common.wschannel;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {
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
    private static MultiProcessShared sInstance = null;
    private static boolean sIsRegisterInMainProcess = false;
    private static volatile boolean sLoadValuesInit = false;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private SharedPreferences mSharedPreferences;
    private final Object sLoadValuesInitLock;

    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        /* synthetic */ Editor(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Editor(Context r2) {
            this.mValues = new ContentValues();
            this.mContext = r2.getApplicationContext();
        }

        public synchronized void apply() {
            monitor-enter(this);
            this.mContext.getContentResolver().insert(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsChannelMultiProcessSharedProvider.KEY, "type"), this.mValues);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void commit() {
            monitor-enter(this);
            apply();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public Editor putString(String r2, String r3) {
            this.mValues.put(r2, r3);
            return this;
        }

        public Editor putLong(String r2, long r3) {
            this.mValues.put(r2, Long.valueOf(r3));
            return this;
        }

        public Editor putBoolean(String r2, boolean r3) {
            this.mValues.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public Editor putInt(String r2, int r3) {
            this.mValues.put(r2, Integer.valueOf(r3));
            return this;
        }

        public Editor putFloat(String r2, float r3) {
            this.mValues.put(r2, Float.valueOf(r3));
            return this;
        }

        public void remove(String r1) {
            this.mValues.putNull(r1);
        }

        public void clear() {
            this.mContext.getContentResolver().delete(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsChannelMultiProcessSharedProvider.KEY, "type"), null, null);     // Catch: Throwable -> L4
            return;
        }
    }

    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        /* synthetic */ MultiProcessShared(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private MultiProcessShared(Context r3) {
            boolean r0 = false;
            this.mIsMainProcess = false;
            if (Utils.isMainProcess(r3) == true) goto L5;
        L7:
            this.mIsMainProcess = r0;
            Context r4 = r3.getApplicationContext();
            this.mContext = r4;
            this.mSharedPreferences = r4.getApplicationContext().getSharedPreferences(WsChannelMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
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

        public Editor edit() {
            return new Editor(this.mContext, null);
        }

        public String getString(String r8, String r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getString(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$400(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "string"), null, null, null, null), r9);
        }

        public long getLong(String r8, long r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getLong(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$500(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, WsChannelMultiProcessSharedProvider.LONG_TYPE), null, null, null, null), r9);
        }

        public float getFloat(String r8, float r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getFloat(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$600(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "float"), null, null, null, null), r9);
        }

        public boolean getBoolean(String r8, boolean r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getBoolean(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$700(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "boolean"), null, null, null, null), r9);
        }

        public int getInt(String r8, int r9) {
        L8:
            return r9;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getInt(r8, r9);
        L7:
            return WsChannelMultiProcessSharedProvider.access$800(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r8, "integer"), null, null, null, null), r9);
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

    static /* synthetic */ String access$400(Cursor r0, String r1) {
        return getStringValue(r0, r1);
    }

    static /* synthetic */ long access$500(Cursor r0, long r1) {
        return getLongValue(r0, r1);
    }

    static /* synthetic */ float access$600(Cursor r0, float r1) {
        return getFloatValue(r0, r1);
    }

    static /* synthetic */ boolean access$700(Cursor r0, boolean r1) {
        return getBooleanValue(r0, r1);
    }

    static /* synthetic */ int access$800(Cursor r0, int r1) {
        return getIntValue(r0, r1);
    }

    private void notifyContentChanged(Uri r2) {
        getContext().getContentResolver().notifyChange(r2, null);
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r0 = this.mSharedPreferences;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        SharedPreferences r1 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);     // Catch: Throwable -> L10
        this.mSharedPreferences = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private static void init(Context r3) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r3, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", sShareAuthority);
    L10:
        UriMatcher r4 = new UriMatcher(-1);
        sMatcher = r4;
        r4.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public static String getProviderAuthority(Context r5, String r6) {
        if (r5 != null) goto L5;
    L14:
        return null;
    L5:
        if (StringUtils.isEmpty(r6) == true) goto L14;
        ProviderInfo[] r7 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r7.length;     // Catch: Exception -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ProviderInfo r3 = r7[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        sShareAuthority = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (Utils.isMainProcess(getContext()) == false) goto L5;
        sIsRegisterInMainProcess = true;
    L5:
        WsChannelSdk2.monitorLifeCycle(getContext());
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
        init(getContext());     // Catch: Exception -> L12
        goto L15
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (sMatcher.match(r1) != 65536) goto L8;
        getMultiProcessSharedPreferences().edit().clear().commit();     // Catch: Exception -> L9
        this.mContentValues.clear();     // Catch: Exception -> L9
        notifyContentChanged(getContentUri(getContext(), KEY, "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r1);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        if (sMatcher.match(r10) != 65536) goto L62;
        loadValues();     // Catch: Exception -> L63
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L63
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L63
        SharedPreferences.Editor r2 = null;
    L7:
        if (r12.hasNext() == false) goto L53;
        Map.Entry<String, Object> r3 = r12.next();     // Catch: Exception -> L63
        Object r4 = r3.getValue();     // Catch: Exception -> L63
        String r5 = r3.getKey();     // Catch: Exception -> L63
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r5 + " value = " + r4.toString());     // Catch: Exception -> L63
    L12:
        boolean r6 = true;
        if (r4 != null) goto L15;
        this.mContentValues.remove(r5);     // Catch: Exception -> L63
    L22:
        if (r6 == false) goto L7;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r2 != null) goto L32;
        r2 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L63
    L32:
        if (r4 != null) goto L35;
        r2.remove(r5);     // Catch: Exception -> L63
        Runnable r7 = null;
    L49:
        if (r7 == null) goto L7;
        r1.add(r7);     // Catch: Exception -> L63
        goto L7
    L35:
        if ((r4 instanceof String) == false) goto L38;
        r2.putString(r5, (String) r4);     // Catch: Exception -> L63
        r7 = createNotifyRunnable(r5, "string");     // Catch: Exception -> L63
        goto L49
    L38:
        if ((r4 instanceof Boolean) == false) goto L41;
        r2.putBoolean(r5, ((Boolean) r4).booleanValue());     // Catch: Exception -> L63
        r7 = createNotifyRunnable(r5, "boolean");     // Catch: Exception -> L63
        goto L49
    L41:
        if ((r4 instanceof Long) == false) goto L44;
        r2.putLong(r5, ((Long) r4).longValue());     // Catch: Exception -> L63
        r7 = createNotifyRunnable(r5, LONG_TYPE);     // Catch: Exception -> L63
        goto L49
    L44:
        if ((r4 instanceof Integer) == false) goto L47;
        r2.putInt(r5, ((Integer) r4).intValue());     // Catch: Exception -> L63
        r7 = createNotifyRunnable(r5, "integer");     // Catch: Exception -> L63
        goto L49
    L47:
        if ((r4 instanceof Float) == false) goto L52;
        r2.putFloat(r5, ((Float) r4).floatValue());     // Catch: Exception -> L63
        r7 = createNotifyRunnable(r5, "float");     // Catch: Exception -> L63
        goto L49
    L52:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L63
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r5 + " value = " + r4) == null) goto L28;
        String r8 = r4.toString();     // Catch: Exception -> L63
    L29:
        Logger.v("PushService", r8);     // Catch: Exception -> L63
        goto L30
    L28:
        r8 = "null";
        goto L29
    L15:
        Object r9 = this.mContentValues.get(r5);     // Catch: Exception -> L63
        if (r9 != null) goto L18;
    L21:
        this.mContentValues.put(r5, r4);     // Catch: Exception -> L63
        goto L22
    L18:
        if (r9.equals(r4) == false) goto L21;
        r6 = false;
        goto L22
    L53:
        if (r2 != null) goto L55;
        return null;
    L55:
        r2.apply();     // Catch: Exception -> L63
        Iterator r13 = r1.iterator();     // Catch: Exception -> L63
    L57:
        if (r13.hasNext() == false) goto L60;
        ((Runnable) r13.next()).run();     // Catch: Exception -> L63
    L60:
        return null;
    L62:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    private Runnable createNotifyRunnable(final String r2, final String r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, String r6, String[] r7, String r8) {
        if (sMatcher.match(r4) != 65536) goto L54;
        Object r9 = null;
        String r10 = null;
        int r11 = 1;
        if (ALL_TYPE.equals(r4.getPathSegments().get(1)) == false) goto L34;
        Map<String, ?> r3 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L55
        MatrixCursor r12 = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r13 = r3.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        r9 = r10;
        if (r13.hasNext() == false) goto L60;
        Map.Entry<String, ?> r14 = r13.next();     // Catch: Exception -> L33
        String r15 = r14.getKey();     // Catch: Exception -> L33
        Object r16 = r14.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r17 = r12.newRow();     // Catch: Exception -> L33
        String r2 = "string";
        if ((r16 instanceof String) == true) goto L31;
        if ((r16 instanceof Boolean) == false) goto L23;
        r2 = "boolean";
        if (((Boolean) r16).booleanValue() == false) goto L20;
        int r18 = 1;
    L21:
        r16 = Integer.valueOf(r18);     // Catch: Exception -> L33
        goto L31
    L20:
        r18 = 0;
        goto L21
    L23:
        if ((r16 instanceof Integer) == false) goto L26;
        r2 = "integer";
        goto L31
    L26:
        if ((r16 instanceof Long) == false) goto L29;
        r2 = LONG_TYPE;
        goto L31
    L29:
        if ((r16 instanceof Float) == false) goto L31;
        r2 = "float";
    L31:
        r17.add(r15);     // Catch: Exception -> L33
        r17.add(r16);     // Catch: Exception -> L33
        r17.add(r2);     // Catch: Exception -> L33
        r10 = r15;
    L60:
        return r12;
    L33:
        r9 = r12;
        goto L69
    L34:
        String r19 = r4.getPathSegments().get(0);     // Catch: Exception -> L55
        loadValues();     // Catch: Exception -> L55
        if (this.mContentValues.containsKey(r19) == true) goto L37;
        return null;
    L37:
        MatrixCursor r20 = new MatrixCursor(new String[]{r19});     // Catch: Exception -> L55
        Object r21 = this.mContentValues.get(r19);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r22 = r20.newRow();     // Catch: Exception -> L50
        if ((r21 instanceof Boolean) == false) goto L46;
        if (((Boolean) r21).booleanValue() == true) goto L44;
        r11 = 0;
    L44:
        r21 = Integer.valueOf(r11);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r19 + " value = " + r21.toString());     // Catch: Exception -> L50
    L48:
        r22.add(r21);     // Catch: Exception -> L50
        r12 = r20;
        r9 = r22;
    L50:
        r9 = r20;
    L69:
        return r9;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r4);
    }

    @Override // android.content.ContentProvider
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
        Map.Entry<String, ?> r3 = r2.next();     // Catch: Throwable -> L20
        String r4 = r3.getKey();     // Catch: Throwable -> L20
        Object r5 = r3.getValue();     // Catch: Throwable -> L20
        this.mContentValues.put(r4, r5);     // Catch: Throwable -> L20
        goto L15
    L17:
        sLoadValuesInit = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }

    private static String getStringValue(Cursor r1, String r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getString(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static boolean getBooleanValue(Cursor r1, boolean r2) {
        if (r1 != null) goto L19;
        return r2;
    L19:
    L13:
        if (r1 != null) goto L17;
    L15:
        return r2;
    L17:
        r1.close();     // Catch: Exception -> L16
        goto L15
    L5:
        if (r1.moveToFirst() == false) goto L10;
        if (r1.getInt(0) <= 0) goto L9;
        r2 = true;
        goto L10
    L9:
        r2 = false;
    L10:
        if (r1 == null) goto L15;
        goto L15
    }

    private static int getIntValue(Cursor r1, int r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getInt(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static long getLongValue(Cursor r1, long r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getLong(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    private static float getFloatValue(Cursor r1, float r2) {
        if (r1 != null) goto L14;
        return r2;
    L14:
    L10:
        if (r1 != null) goto L16;
    L12:
        return r2;
    L16:
        r1.close();     // Catch: Exception -> L13
        goto L12
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getFloat(0);     // Catch: Throwable -> L10
    L7:
        if (r1 == null) goto L12;
        goto L12
    }

    public static Editor edit(Context r2) {
        return new Editor(r2, null);
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context r3) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MultiProcessShared(r3, null);     // Catch: Throwable -> L10
    L7:
        MultiProcessShared r4 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r4;
    }

    public static final synchronized Uri getContentUri(Context r3, String r4, String r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider> r0 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            init(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L33
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r3
        L33:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.getContentUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }
}
