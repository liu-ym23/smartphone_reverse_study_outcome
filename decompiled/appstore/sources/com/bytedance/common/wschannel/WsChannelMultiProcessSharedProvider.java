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
import com.bytedance.common.utility.e;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f6871d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Uri f6872e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static UriMatcher f6873f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f6874g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f6875h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c f6876i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6879c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f6881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WsChannelMultiProcessSharedProvider f6882c;

        public a(WsChannelMultiProcessSharedProvider r10, String r11, String r12) {
            this.f6882c = r10;
            this.f6880a = r11;
            this.f6881b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelMultiProcessSharedProvider r10 = this.f6882c;
            WsChannelMultiProcessSharedProvider.a(r10, WsChannelMultiProcessSharedProvider.h(r10.getContext(), this.f6880a, this.f6881b));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContentValues f6884b;

        public /* synthetic */ b(Context r10, a r11) {
            this(r10);
        }

        public synchronized void a() {
            monitor-enter(this);
            this.f6883a.getContentResolver().insert(WsChannelMultiProcessSharedProvider.h(this.f6883a, "key", "type"), this.f6884b);     // Catch: Throwable -> L6
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

        public b c(String r10, String r11) {
            this.f6884b.put(r10, r11);
            return this;
        }

        public b(Context r10) {
            this.f6884b = new ContentValues();
            this.f6883a = r10.getApplicationContext();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SharedPreferences f6887c;

        public /* synthetic */ c(Context r10, a r11) {
            this(r10);
        }

        public b a() {
            return new b(this.f6885a, null);
        }

        public boolean b(String r10, boolean r11) {
        L8:
            return r11;
        L3:
            if (this.f6886b == false) goto L7;
            return this.f6887c.getBoolean(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.e(this.f6885a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f6885a, r10, "boolean"), null, null, null, null), r11);
        }

        public long c(String r10, long r11) {
        L8:
            return r11;
        L3:
            if (this.f6886b == false) goto L7;
            return this.f6887c.getLong(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.d(this.f6885a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f6885a, r10, "long"), null, null, null, null), r11);
        }

        public String d(String r10, String r11) {
        L8:
            return r11;
        L3:
            if (this.f6886b == false) goto L7;
            return this.f6887c.getString(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.c(this.f6885a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f6885a, r10, "string"), null, null, null, null), r11);
        }

        public c(Context r10) {
            boolean r11 = false;
            this.f6886b = false;
            if (j4.a.e(r10) == true) goto L5;
        L7:
            this.f6886b = r11;
            Context r12 = r10.getApplicationContext();
            this.f6885a = r12;
            this.f6887c = r12.getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.b() == false) goto L7;
            r11 = true;
            goto L7
        }
    }

    static {
    }

    public WsChannelMultiProcessSharedProvider() {
        this.f6878b = new ConcurrentHashMap();
        this.f6879c = new Object();
    }

    public static /* synthetic */ void a(WsChannelMultiProcessSharedProvider r10, Uri r11) {
        r10.p(r11);
    }

    public static /* synthetic */ boolean b() {
        return f6874g;
    }

    public static /* synthetic */ String c(Cursor r10, String r11) {
        return m(r10, r11);
    }

    public static /* synthetic */ long d(Cursor r10, long r11) {
        return i(r10, r11);
    }

    public static /* synthetic */ boolean e(Cursor r10, boolean r11) {
        return g(r10, r11);
    }

    public static boolean g(Cursor r10, boolean r11) {
        if (r10 != null) goto L14;
        return r11;
    L14:
        if (r10.moveToFirst() == false) goto L16;
        if (r10.getInt(0) <= 0) goto L9;
        r11 = true;
        goto L16
    L9:
        r11 = false;
    L16:
        r10.close();     // Catch: Exception -> L13
    L11:
        return r11;
    }

    public static final synchronized Uri h(Context r10, String r11, String r12) {
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
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f6872e     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L23
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            if (r1 == 0) goto L19
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L19
        L15:
            r3 = move-exception
            goto L37
        L17:
            r3 = move-exception
            goto L1d
        L19:
            n(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L23
        L1d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r3 = 0
            return r3
        L23:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f6872e     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L15
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            return r3
        L37:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.h(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static long i(Cursor r10, long r11) {
        if (r10 != null) goto L11;
        return r11;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r11 = r10.getLong(0);     // Catch: Throwable -> L9
    L13:
        r10.close();     // Catch: Exception -> L10
    L8:
        return r11;
    }

    public static synchronized c k(Context r10) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f6876i != null) goto L9;
        f6876i = new c(r10, null);     // Catch: Throwable -> L7
    L9:
        c r11 = f6876i;     // Catch: Throwable -> L7
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r11;
    }

    public static String l(Context r10, String r11) {
        if (r10 != null) goto L5;
    L14:
        return null;
    L5:
        if (e.b(r11) == true) goto L14;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r13 = r12.length;     // Catch: Exception -> L15
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L14;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L15
        if (r11.equals(r15.name) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15.authority;
    }

    public static String m(Cursor r10, String r11) {
        if (r10 != null) goto L11;
        return r11;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r11 = r10.getString(0);     // Catch: Throwable -> L9
    L13:
        r10.close();     // Catch: Exception -> L10
    L8:
        return r11;
    }

    public static void n(Context r10) {
        if (TextUtils.isEmpty(f6871d) == false) goto L6;
        f6871d = l(r10, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f6871d) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", f6871d);
    L10:
        UriMatcher r11 = new UriMatcher(-1);
        f6873f = r11;
        r11.addURI(f6871d, "*/*", 65536);
        f6872e = Uri.parse(CommonColumns.SCHEME + f6871d);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r10, ProviderInfo r11) {
        if (r11 == null) goto L4;
        f6871d = r11.authority;
    L4:
        super.attachInfo(r10, r11);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (f6873f.match(r10) != 65536) goto L8;
        j().edit().clear().commit();     // Catch: Exception -> L9
        this.f6878b.clear();     // Catch: Exception -> L9
        p(h(getContext(), "key", "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    public final Runnable f(String r10, String r11) {
        return new a(this, r10, r11);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "vnd.android.cursor.item/vnd." + f6871d + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        if (f6873f.match(r10) != 65536) goto L58;
        o();     // Catch: Exception -> L59
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L59
        Iterator<Map.Entry<String, Object>> r13 = r11.valueSet().iterator();     // Catch: Exception -> L59
        SharedPreferences.Editor r14 = null;
    L7:
        if (r13.hasNext() == false) goto L49;
        Map.Entry<String, Object> r15 = r13.next();     // Catch: Exception -> L59
        Object r16 = r15.getValue();     // Catch: Exception -> L59
        String r17 = r15.getKey();     // Catch: Exception -> L59
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r17 + " value = " + r16.toString());     // Catch: Exception -> L59
    L12:
        if (r16 == null) goto L13;
        Object r18 = this.f6878b.get(r17);     // Catch: Exception -> L59
        if (r18 == null) goto L18;
        if (r18.equals(r16) == true) goto L7;
    L18:
        this.f6878b.put(r17, r16);     // Catch: Exception -> L59
    L20:
        if (Logger.debug() == true) goto L22;
    L26:
        if (r14 != null) goto L28;
        r14 = j().edit();     // Catch: Exception -> L59
    L28:
        if (r16 != null) goto L31;
        r14.remove(r17);     // Catch: Exception -> L59
        Runnable r19 = null;
    L45:
        if (r19 == null) goto L7;
        r12.add(r19);     // Catch: Exception -> L59
        goto L7
    L31:
        if ((r16 instanceof String) == false) goto L34;
        r14.putString(r17, (String) r16);     // Catch: Exception -> L59
        r19 = f(r17, "string");     // Catch: Exception -> L59
        goto L45
    L34:
        if ((r16 instanceof Boolean) == false) goto L37;
        r14.putBoolean(r17, ((Boolean) r16).booleanValue());     // Catch: Exception -> L59
        r19 = f(r17, "boolean");     // Catch: Exception -> L59
        goto L45
    L37:
        if ((r16 instanceof Long) == false) goto L40;
        r14.putLong(r17, ((Long) r16).longValue());     // Catch: Exception -> L59
        r19 = f(r17, "long");     // Catch: Exception -> L59
        goto L45
    L40:
        if ((r16 instanceof Integer) == false) goto L43;
        r14.putInt(r17, ((Integer) r16).intValue());     // Catch: Exception -> L59
        r19 = f(r17, "integer");     // Catch: Exception -> L59
        goto L45
    L43:
        if ((r16 instanceof Float) == false) goto L48;
        r14.putFloat(r17, ((Float) r16).floatValue());     // Catch: Exception -> L59
        r19 = f(r17, "float");     // Catch: Exception -> L59
        goto L45
    L48:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L59
    L22:
        if (("MultiProcessShareProvider reallly insert key = " + r17 + " value = " + r16) == null) goto L24;
        String r20 = r16.toString();     // Catch: Exception -> L59
    L25:
        Logger.v("PushService", r20);     // Catch: Exception -> L59
        goto L26
    L24:
        r20 = "null";
        goto L25
    L13:
        this.f6878b.remove(r17);     // Catch: Exception -> L59
        goto L20
    L49:
        if (r14 != null) goto L51;
        return null;
    L51:
        r14.apply();     // Catch: Exception -> L59
        Iterator r21 = r12.iterator();     // Catch: Exception -> L59
    L53:
        if (r21.hasNext() == false) goto L56;
        ((Runnable) r21.next()).run();     // Catch: Exception -> L59
    L56:
        return null;
    L58:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    public final synchronized SharedPreferences j() {
        monitor-enter(this);
        SharedPreferences r10 = this.f6877a;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        SharedPreferences r11 = getContext().getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);     // Catch: Throwable -> L8
        this.f6877a = r11;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public final void o() {
        if (f6875h == true) goto L24;
        Object r10 = this.f6879c;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f6875h == true) goto L20;
        SharedPreferences r11 = j();     // Catch: Throwable -> L13
        if (r11 != null) goto L15;
        f6875h = true;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        Iterator<Map.Entry<String, ?>> r12 = r11.getAll().entrySet().iterator();     // Catch: Throwable -> L13
    L17:
        if (r12.hasNext() == false) goto L19;
        Map.Entry<String, ?> r13 = r12.next();     // Catch: Throwable -> L13
        String r14 = r13.getKey();     // Catch: Throwable -> L13
        Object r15 = r13.getValue();     // Catch: Throwable -> L13
        this.f6878b.put(r14, r15);     // Catch: Throwable -> L13
        goto L17
    L19:
        f6875h = true;     // Catch: Throwable -> L13
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (j4.a.e(getContext()) == false) goto L6;
        f6874g = true;
    L6:
        if (f6873f == null) goto L17;
    L16:
        return true;
    L17:
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L12;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L10
    L12:
        n(getContext());     // Catch: Exception -> L10
        goto L16
    }

    public final void p(Uri r10) {
        getContext().getContentResolver().notifyChange(r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        if (f6873f.match(r10) != 65536) goto L46;
        ?? r15 = 0;
        if ("all".equals(r10.getPathSegments().get(1)) == false) goto L30;
        Map<String, ?> r16 = j().getAll();     // Catch: Exception -> L47
        MatrixCursor r17 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L47
        Iterator<Map.Entry<String, ?>> r18 = r16.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        boolean r19 = r18.hasNext();     // Catch: Exception -> L18
        r15 = r19;
        if (r19 == false) goto L52;
        Map.Entry<String, ?> r20 = r18.next();     // Catch: Exception -> L18
        String r21 = r20.getKey();     // Catch: Exception -> L18
        Object r22 = r20.getValue();     // Catch: Exception -> L18
        MatrixCursor.RowBuilder r23 = r17.newRow();     // Catch: Exception -> L18
        String r24 = "string";
        if ((r22 instanceof String) == true) goto L28;
        if ((r22 instanceof Boolean) == false) goto L20;
        r24 = "boolean";
        r22 = Integer.valueOf(((Boolean) r22).booleanValue() ? 1 : 0);     // Catch: Exception -> L18
        goto L28
    L20:
        if ((r22 instanceof Integer) == false) goto L23;
        r24 = "integer";
        goto L28
    L23:
        if ((r22 instanceof Long) == false) goto L26;
        r24 = "long";
        goto L28
    L26:
        if ((r22 instanceof Float) == false) goto L28;
        r24 = "float";
    L28:
        r23.add(r21);     // Catch: Exception -> L18
        r23.add(r22);     // Catch: Exception -> L18
        r23.add(r24);     // Catch: Exception -> L18
    L52:
        return r17;
    L18:
        r15 = r17;
        goto L61
    L30:
        String r25 = r10.getPathSegments().get(0);     // Catch: Exception -> L47
        o();     // Catch: Exception -> L47
        if (this.f6878b.containsKey(r25) == true) goto L33;
        return null;
    L33:
        MatrixCursor r26 = new MatrixCursor(new String[]{r25});     // Catch: Exception -> L47
        Object r27 = this.f6878b.get(r25);     // Catch: Exception -> L37
        MatrixCursor.RowBuilder r28 = r26.newRow();     // Catch: Exception -> L37
        if ((r27 instanceof Boolean) == false) goto L39;
        r27 = Integer.valueOf(((Boolean) r27).booleanValue() ? 1 : 0);     // Catch: Exception -> L37
    L39:
        if (Logger.debug() == false) goto L41;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r25 + " value = " + r27.toString());     // Catch: Exception -> L37
    L41:
        r28.add(r27);     // Catch: Exception -> L37
        r17 = r26;
        r15 = r28;
    L37:
        r15 = r26;
    L61:
        return r15;
    L46:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new UnsupportedOperationException();
    }
}
