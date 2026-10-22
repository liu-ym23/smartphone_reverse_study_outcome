package com.ss.android.pushmanager.setting;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import ef.a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class PushMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f18191d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Uri f18192e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static UriMatcher f18193f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f18194g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f18195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f18196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f18197c;

    static {
    }

    public PushMultiProcessSharedProvider() {
        this.f18196b = new ConcurrentHashMap();
        this.f18197c = new Handler(Looper.getMainLooper());
    }

    public static final synchronized Uri a(Context r10, String r11, String r12) {
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
            java.lang.Class<com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider> r0 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f18192e     // Catch: java.lang.Throwable -> L15
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
            d(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L23
        L1d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r3 = 0
            return r3
        L23:
            android.net.Uri r3 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f18192e     // Catch: java.lang.Throwable -> L15
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.a(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static String c(Context r10, String r11) {
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

    public static void d(Context r10) {
        String r11 = c(r10, PushMultiProcessSharedProvider.class.getName());
        f18191d = r11;
        if (TextUtils.isEmpty(r11) == true) goto L10;
        if (Logger.debug() == false) goto L7;
        Logger.d("MultiProcessSharedProvider", f18191d);
    L7:
        UriMatcher r12 = new UriMatcher(-1);
        f18193f = r12;
        r12.addURI(f18191d, "*/*", 65536);
        f18192e = Uri.parse(CommonColumns.SCHEME + f18191d);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public final synchronized SharedPreferences b() {
        monitor-enter(this);
        SharedPreferences r10 = this.f18195a;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        SharedPreferences r11 = getContext().getApplicationContext().getSharedPreferences("push_multi_process_config", 4);     // Catch: Throwable -> L8
        this.f18195a = r11;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (f18193f.match(r10) != 65536) goto L7;
        return 0;
    L7:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    public final void e() {
        SharedPreferences r10 = b();
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r11 = r10.getAll().entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, ?> r12 = r11.next();
        String r13 = r12.getKey();
        Object r14 = r12.getValue();
        this.f18196b.put(r13, r14);
        goto L7
    }

    public final void f(Uri r10) {
        getContext().getContentResolver().notifyChange(r10, null);
    }

    public final void g() {
        if (a.c(getContext()) == true) goto L11;
        Intent r10 = new Intent();     // Catch: Throwable -> L6
        r10.setAction("com.ss.android.message");     // Catch: Throwable -> L6
        r10.putExtra("start_by", "PushMultiProcessSharedProvider");     // Catch: Throwable -> L6
        r10.setPackage(getContext().getPackageName());     // Catch: Throwable -> L6
        getContext().getApplicationContext().startService(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "vnd.android.cursor.item/vnd." + f18191d + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        if (f18193f.match(r10) != 65536) goto L52;
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L53
        SharedPreferences.Editor r13 = null;
    L7:
        if (r12.hasNext() == false) goto L47;
        Map.Entry<String, Object> r14 = r12.next();     // Catch: Exception -> L53
        Object r15 = r14.getValue();     // Catch: Exception -> L53
        String r16 = r14.getKey();     // Catch: Exception -> L53
        if (Logger.debug() == false) goto L12;
        Logger.d("PushService", "MultiProcessShareProvider insert key = " + r16 + " value = " + r15.toString());     // Catch: Exception -> L53
    L12:
        if (r15 == null) goto L13;
        Object r17 = this.f18196b.get(r16);     // Catch: Exception -> L53
        if (r17 == null) goto L18;
        if (r17.equals(r15) == true) goto L7;
    L18:
        this.f18196b.put(r16, r15);     // Catch: Exception -> L53
    L20:
        if (Logger.debug() == true) goto L22;
    L26:
        if (r13 != null) goto L28;
        r13 = b().edit();     // Catch: Exception -> L53
    L28:
        if (r15 == null) goto L29;
        if ((r15 instanceof String) == true) goto L32;
        if ((r15 instanceof Boolean) == true) goto L35;
        if ((r15 instanceof Long) == true) goto L38;
        if ((r15 instanceof Integer) == true) goto L41;
        if ((r15 instanceof Float) == false) goto L46;
        r13.putFloat(r16, ((Float) r15).floatValue());     // Catch: Exception -> L53
        f(a(getContext(), r16, "float"));     // Catch: Exception -> L53
        goto L7
    L46:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L53
    L41:
        r13.putInt(r16, ((Integer) r15).intValue());     // Catch: Exception -> L53
        f(a(getContext(), r16, "integer"));     // Catch: Exception -> L53
        goto L7
    L38:
        r13.putLong(r16, ((Long) r15).longValue());     // Catch: Exception -> L53
        f(a(getContext(), r16, "long"));     // Catch: Exception -> L53
        goto L7
    L35:
        r13.putBoolean(r16, ((Boolean) r15).booleanValue());     // Catch: Exception -> L53
        f(a(getContext(), r16, "boolean"));     // Catch: Exception -> L53
        goto L7
    L32:
        r13.putString(r16, (String) r15);     // Catch: Exception -> L53
        f(a(getContext(), r16, "string"));     // Catch: Exception -> L53
        goto L7
    L29:
        r13.remove(r16);     // Catch: Exception -> L53
        goto L7
    L22:
        if (("MultiProcessShareProvider reallly insert key = " + r16 + " value = " + r15) == null) goto L24;
        String r18 = r15.toString();     // Catch: Exception -> L53
    L25:
        Logger.d("PushService", r18);     // Catch: Exception -> L53
        goto L26
    L24:
        r18 = "null";
        goto L25
    L13:
        this.f18196b.remove(r16);     // Catch: Exception -> L53
        goto L20
    L47:
        if (r13 != null) goto L49;
        return null;
    L49:
        r13.apply();     // Catch: Exception -> L53
    L50:
        return null;
    L52:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (a.c(getContext()) == false) goto L6;
        f18194g = true;
    L6:
        if (f18193f == null) goto L18;
    L16:
        g();
        return true;
    L18:
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L12;
        Logger.d("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L10
    L12:
        d(getContext());     // Catch: Exception -> L10
        e();     // Catch: Exception -> L10
        goto L16
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
        if (f18193f.match(r10) != 65536) goto L50;
        ?? r15 = 0;
        if ("all".equals(r10.getPathSegments().get(1)) == false) goto L30;
        Map<String, ?> r16 = b().getAll();     // Catch: Exception -> L51
        MatrixCursor r17 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L51
        Iterator<Map.Entry<String, ?>> r18 = r16.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        boolean r19 = r18.hasNext();     // Catch: Exception -> L18
        r15 = r19;
        if (r19 == false) goto L54;
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
    L54:
        return r17;
    L18:
        r15 = r17;
        goto L65
    L30:
        String r25 = r10.getPathSegments().get(0);     // Catch: Exception -> L51
        boolean r26 = e.a(r25, "current_app_state");     // Catch: Exception -> L51
        if (this.f18196b.containsKey(r25) == true) goto L34;
        if (r26 == true) goto L34;
        return null;
    L34:
        MatrixCursor r27 = new MatrixCursor(new String[]{r25});     // Catch: Exception -> L51
        if (r26 == false) goto L38;
        Object r28 = Boolean.valueOf(ActivityLifecycleObserver.e().f());     // Catch: Exception -> L37
    L39:
        MatrixCursor.RowBuilder r29 = r27.newRow();     // Catch: Exception -> L37
        if ((r28 instanceof Boolean) == false) goto L43;
        r28 = Integer.valueOf(((Boolean) r28).booleanValue() ? 1 : 0);     // Catch: Exception -> L37
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d("PushService", "MultiProcessShareProvider reallly get key = " + r25 + " value = " + r28.toString());     // Catch: Exception -> L37
    L45:
        r29.add(r28);     // Catch: Exception -> L37
        r17 = r27;
        r15 = r29;
        goto L54
    L38:
        r28 = this.f18196b.get(r25);     // Catch: Exception -> L37
    L37:
        r15 = r27;
    L65:
        return r15;
    L50:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new UnsupportedOperationException();
    }
}
