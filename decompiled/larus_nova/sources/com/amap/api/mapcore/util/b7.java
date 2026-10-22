package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e7 f27072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f27073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private r1 f27074c;

    static {
        new HashMap();
    }

    private SQLiteDatabase a() {
        SQLiteDatabase r100 = this.f27073b;     // Catch: Throwable -> L11
        if (r100 != null) goto L5;
    L6:
        SQLiteDatabase r101 = this.f27073b;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.close();     // Catch: Throwable -> L11
    L9:
        this.f27073b = this.f27072a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.f27073b;
    L5:
        if (r100.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        p6.a(th, "dbs", "gwd");
        goto L14
    }

    public <T> void a(List<T> r100) {
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
            this = this;
            com.amap.api.mapcore.util.r1 r0 = r5.f27074c
            monitor-enter(r0)
            int r1 = r6.size()     // Catch: java.lang.Throwable -> La9
            if (r1 != 0) goto Lb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            return
        Lb:
            android.database.sqlite.SQLiteDatabase r1 = r5.a()     // Catch: java.lang.Throwable -> La9
            r5.f27073b = r1     // Catch: java.lang.Throwable -> La9
            if (r1 != 0) goto L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            return
        L15:
            r2 = 0
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L52
        L1d:
            boolean r1 = r6.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L2d
            java.lang.Object r1 = r6.next()     // Catch: java.lang.Throwable -> L52
            android.database.sqlite.SQLiteDatabase r3 = r5.f27073b     // Catch: java.lang.Throwable -> L52
            a(r3, r1)     // Catch: java.lang.Throwable -> L52
            goto L1d
        L2d:
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L52
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L40
            boolean r6 = r6.inTransaction()     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L48
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L40
            r6.endTransaction()     // Catch: java.lang.Throwable -> L40
            goto L48
        L40:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.p6.a(r6, r1, r3)     // Catch: java.lang.Throwable -> La9
        L48:
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L50
            r6.close()     // Catch: java.lang.Throwable -> L50
            r5.f27073b = r2     // Catch: java.lang.Throwable -> L50
            goto L7f
        L50:
            r6 = move-exception
            goto L78
        L52:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.p6.a(r6, r1, r3)     // Catch: java.lang.Throwable -> L81
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L68
            boolean r6 = r6.inTransaction()     // Catch: java.lang.Throwable -> L68
            if (r6 == 0) goto L70
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L68
            r6.endTransaction()     // Catch: java.lang.Throwable -> L68
            goto L70
        L68:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.p6.a(r6, r1, r3)     // Catch: java.lang.Throwable -> La9
        L70:
            android.database.sqlite.SQLiteDatabase r6 = r5.f27073b     // Catch: java.lang.Throwable -> L50
            r6.close()     // Catch: java.lang.Throwable -> L50
            r5.f27073b = r2     // Catch: java.lang.Throwable -> L50
            goto L7f
        L78:
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "ild"
            com.amap.api.mapcore.util.p6.a(r6, r1, r2)     // Catch: java.lang.Throwable -> La9
        L7f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            return
        L81:
            r6 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r5.f27073b     // Catch: java.lang.Throwable -> L90
            boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L98
            android.database.sqlite.SQLiteDatabase r1 = r5.f27073b     // Catch: java.lang.Throwable -> L90
            r1.endTransaction()     // Catch: java.lang.Throwable -> L90
            goto L98
        L90:
            r1 = move-exception
            java.lang.String r3 = "dbs"
            java.lang.String r4 = "ild"
            com.amap.api.mapcore.util.p6.a(r1, r3, r4)     // Catch: java.lang.Throwable -> La9
        L98:
            android.database.sqlite.SQLiteDatabase r1 = r5.f27073b     // Catch: java.lang.Throwable -> La0
            r1.close()     // Catch: java.lang.Throwable -> La0
            r5.f27073b = r2     // Catch: java.lang.Throwable -> La0
            goto La8
        La0:
            r1 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.p6.a(r1, r2, r3)     // Catch: java.lang.Throwable -> La9
        La8:
            throw r6     // Catch: java.lang.Throwable -> La9
        La9:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.b7.a(java.util.List):void");
    }

    public <T> void a(T r100) {
        r1 r101 = this.f27074c;
        monitor-enter(r101);
        SQLiteDatabase r102 = a();     // Catch: Throwable -> L25
        this.f27073b = r102;     // Catch: Throwable -> L25
        if (r102 != null) goto L29;
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L29:
        a(r102, r100);     // Catch: Throwable -> L13
        SQLiteDatabase r103 = this.f27073b;     // Catch: Throwable -> L25
        if (r103 != null) goto L17;
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L17:
        r103.close();     // Catch: Throwable -> L25
        this.f27073b = null;     // Catch: Throwable -> L25
        goto L18
    L13:
        th = move-exception;
        p6.a(th, "dbs", "itd");     // Catch: Throwable -> L20
        r103 = this.f27073b;     // Catch: Throwable -> L25
        if (r103 == null) goto L18;
    L20:
        th = move-exception;
        SQLiteDatabase r104 = this.f27073b;     // Catch: Throwable -> L25
        if (r104 == null) goto L24;
        r104.close();     // Catch: Throwable -> L25
        this.f27073b = null;     // Catch: Throwable -> L25
    L24:
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private static <T> c7 a(Class<T> r100) {
        Annotation r101 = r100.getAnnotation(c7.class);
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return (c7) r101;
    L5:
        r102 = false;
        goto L6
    }

    private static <T> String a(c7 r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.tableName();
    }

    public b7(Context r100, r1 r101) {
        Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L7
        r101.getClass();     // Catch: Throwable -> L7
        this.f27072a = new e7(r102, "offlineDbV4.db", 2, r101);     // Catch: Throwable -> L7
    L9:
        this.f27074c = r101;
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    private static ContentValues a(Object r100, c7 r101) {
        ContentValues r102 = new ContentValues();
        Class<?> r103 = r100.getClass();
        if (r101.isSuperField() == false) goto L5;
        Field[] r104 = r103.getSuperclass().getDeclaredFields();
    L6:
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L25;
        Field r107 = r104[r106];
        r107.setAccessible(true);
        Annotation r108 = r107.getAnnotation(d7.class);
        if (r108 == null) goto L24;
        d7 r109 = (d7) r108;
        switch(r109.fieldType()) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L26;
            default: goto L24;
        };
    L15:
        String r110 = (String) r107.get(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), r110);     // Catch: IllegalAccessException -> L22
        goto L24
    L16:
        long r111 = r107.getLong(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), Long.valueOf(r111));     // Catch: IllegalAccessException -> L22
        goto L24
    L17:
        double r112 = r107.getDouble(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), Double.valueOf(r112));     // Catch: IllegalAccessException -> L22
        goto L24
    L18:
        float r113 = r107.getFloat(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), Float.valueOf(r113));     // Catch: IllegalAccessException -> L22
        goto L24
    L19:
        int r114 = r107.getInt(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), Integer.valueOf(r114));     // Catch: IllegalAccessException -> L22
        goto L24
    L20:
        short r115 = r107.getShort(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), Short.valueOf(r115));     // Catch: IllegalAccessException -> L22
        goto L24
    L26:
        byte[] r116 = (byte[]) r107.get(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r109.fieldName(), r116);     // Catch: IllegalAccessException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        r106 = r106 + 1;
        goto L7
    L25:
        return r102;
    L5:
        r104 = r103.getDeclaredFields();
        goto L6
    }

    public <T> List<T> b(String r110, Class<T> r111) {
        r1 r100 = this.f27074c;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L81
        c7 r102 = a(r111);     // Catch: Throwable -> L81
        String r103 = a(r102);     // Catch: Throwable -> L81
        SQLiteDatabase r104 = this.f27073b;     // Catch: Throwable -> L81
        if (r104 != null) goto L13;
        if (r104 == null) goto L104;
    L11:
        this.f27073b = this.f27073b;     // Catch: Throwable -> L81
        goto L13
    L104:
        this.f27073b = this.f27072a.getReadableDatabase();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        p6.a(th, "dbs", "grd");     // Catch: Throwable -> L81
    L13:
        if (this.f27073b != null) goto L15;
    L79:
        monitor-exit(r100);     // Catch: Throwable -> L81
    L80:
        return r101;
    L15:
        if (TextUtils.isEmpty(r103) == true) goto L79;
        if (r110 == null) goto L79;
        Cursor r112 = this.f27073b.query(r103, null, r110, null, null, null, null);     // Catch: Throwable -> L49
        if (r112 != null) goto L36;
        this.f27073b.close();     // Catch: Throwable -> L47
        this.f27073b = null;     // Catch: Throwable -> L47
        if (r112 == null) goto L98;
        r112.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
    L98:
        SQLiteDatabase r113 = this.f27073b;     // Catch: Throwable -> L31
        if (r113 == null) goto L33;
        r113.close();     // Catch: Throwable -> L31
        this.f27073b = null;     // Catch: Throwable -> L31
    L33:
        monitor-exit(r100);     // Catch: Throwable -> L81
    L31:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
    L36:
        if (r112.moveToNext() == false) goto L86;
        r101.add(a(r112, r111, r102));     // Catch: Throwable -> L47
        goto L36
    L86:
        r112.close();     // Catch: Throwable -> L41
    L43:
        SQLiteDatabase r114 = this.f27073b;     // Catch: Throwable -> L62
        if (r114 == null) goto L64;
        r114.close();     // Catch: Throwable -> L62
    L60:
        this.f27073b = null;     // Catch: Throwable -> L62
    L64:
        monitor-exit(r100);     // Catch: Throwable -> L81
        goto L80
    L41:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
    L47:
        th = th;
    L84:
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L66
        if (r112 != null) goto L89;
    L57:
        SQLiteDatabase r115 = this.f27073b;     // Catch: Throwable -> L62
        if (r115 == null) goto L64;
        r115.close();     // Catch: Throwable -> L62
        goto L60
    L89:
        r112.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
        goto L57
    L66:
        th = move-exception;
        if (r112 == null) goto L102;
        r112.close();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
    L102:
        SQLiteDatabase r116 = this.f27073b;     // Catch: Throwable -> L76
        if (r116 == null) goto L106;
        r116.close();     // Catch: Throwable -> L76
        this.f27073b = null;     // Catch: Throwable -> L76
    L107:
        throw th;     // Catch: Throwable -> L81
    L106:
        throw th;     // Catch: Throwable -> L81
    L76:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L81
    L49:
        th = th;
        r112 = null;
    L62:
        th = move-exception;
        p6.a(th, "dbs", "sld");     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    }

    public <T> void a(String r100, Object r101) {
        r1 r102 = this.f27074c;
        monitor-enter(r102);
        c7 r103 = a(r101.getClass());     // Catch: Throwable -> L29
        String r104 = a(r103);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r104) == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L8:
        ContentValues r105 = a(r101, r103);     // Catch: Throwable -> L29
        SQLiteDatabase r106 = a();     // Catch: Throwable -> L29
        this.f27073b = r106;     // Catch: Throwable -> L29
        if (r106 != null) goto L35;
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L35:
        r106.update(r104, r105, r100, null);     // Catch: Throwable -> L17
        SQLiteDatabase r107 = this.f27073b;     // Catch: Throwable -> L29
        if (r107 != null) goto L21;
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L21:
        r107.close();     // Catch: Throwable -> L29
        this.f27073b = null;     // Catch: Throwable -> L29
        goto L22
    L17:
        th = move-exception;
        p6.a(th, "dbs", "udd");     // Catch: Throwable -> L24
        r107 = this.f27073b;     // Catch: Throwable -> L29
        if (r107 == null) goto L22;
    L24:
        th = move-exception;
        SQLiteDatabase r108 = this.f27073b;     // Catch: Throwable -> L29
        if (r108 == null) goto L28;
        r108.close();     // Catch: Throwable -> L29
        this.f27073b = null;     // Catch: Throwable -> L29
    L28:
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public <T> void a(String r100, Class<T> r101) {
        r1 r102 = this.f27074c;
        monitor-enter(r102);
        String r103 = a(a(r101));     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r103) == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L8:
        SQLiteDatabase r104 = a();     // Catch: Throwable -> L29
        this.f27073b = r104;     // Catch: Throwable -> L29
        if (r104 != null) goto L33;
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L33:
        r104.delete(r103, r100, null);     // Catch: Throwable -> L17
        SQLiteDatabase r105 = this.f27073b;     // Catch: Throwable -> L29
        if (r105 != null) goto L21;
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L21:
        r105.close();     // Catch: Throwable -> L29
        this.f27073b = null;     // Catch: Throwable -> L29
        goto L22
    L17:
        th = move-exception;
        p6.a(th, "dbs", "dld");     // Catch: Throwable -> L24
        r105 = this.f27073b;     // Catch: Throwable -> L29
        if (r105 == null) goto L22;
    L24:
        th = move-exception;
        SQLiteDatabase r106 = this.f27073b;     // Catch: Throwable -> L29
        if (r106 == null) goto L28;
        r106.close();     // Catch: Throwable -> L29
        this.f27073b = null;     // Catch: Throwable -> L29
    L28:
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    private static <T> void a(SQLiteDatabase r100, T r101) {
        c7 r102 = a(r101.getClass());
        String r103 = a(r102);
        if (TextUtils.isEmpty(r103) == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        r100.insert(r103, null, a(r101, r102));
    }

    public void a(Object r100, String r101) {
        r1 r102 = this.f27074c;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) b(r101, r100.getClass())).size() != 0) goto L7;
        a(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L7:
        a(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    private static <T> T a(Cursor r100, Class<T> r101, c7 r102) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        boolean r103 = r102.isSuperField();
        if (r101 != null) goto L5;
        Field[] r104 = null;
    L8:
        int r105 = 0;
        Constructor<T> r106 = r101.getDeclaredConstructor(new Class[0]);
        r106.setAccessible(true);
        T r107 = r106.newInstance(new Object[0]);
        int r108 = r104.length;
    L9:
        if (r105 >= r108) goto L23;
        Field r109 = r104[r105];
        r109.setAccessible(true);
        Annotation r110 = r109.getAnnotation(d7.class);
        if (r110 == null) goto L22;
        d7 r111 = (d7) r110;
        int r112 = r111.fieldType();
        int r113 = r100.getColumnIndex(r111.fieldName());
        switch(r112) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L22;
        };
    L15:
        r109.set(r107, r100.getBlob(r113));
        goto L22
    L16:
        r109.set(r107, r100.getString(r113));
        goto L22
    L17:
        r109.set(r107, Long.valueOf(r100.getLong(r113)));
        goto L22
    L18:
        r109.set(r107, Double.valueOf(r100.getDouble(r113)));
        goto L22
    L19:
        r109.set(r107, Float.valueOf(r100.getFloat(r113)));
        goto L22
    L20:
        r109.set(r107, Integer.valueOf(r100.getInt(r113)));
        goto L22
    L21:
        r109.set(r107, Short.valueOf(r100.getShort(r113)));
    L22:
        r105 = r105 + 1;
        goto L9
    L23:
        return r107;
    L5:
        if (r103 == false) goto L7;
        r104 = r101.getSuperclass().getDeclaredFields();
        goto L8
    L7:
        r104 = r101.getDeclaredFields();
        goto L8
    }
}
