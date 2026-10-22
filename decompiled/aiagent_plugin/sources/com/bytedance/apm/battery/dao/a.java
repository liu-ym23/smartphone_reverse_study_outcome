package com.bytedance.apm.battery.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.c;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: BaseDao.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Integer> f4327d;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseDao.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDao.java */
    public interface InterfaceC0110a<T> {
        T a(b r1);
    }

    /* JADX INFO: compiled from: BaseDao.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Cursor f4328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, Integer> f4329b;

        /* synthetic */ b(Cursor r2, HashMap r3, AnonymousClass1 r4) {
            this((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin"), r3);
        }

        private b(Cursor r3, HashMap<String, Integer> r4) {
            this.f4328a = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
            this.f4329b = r4;
        }

        public long a(String r2) {
            return this.f4328a.getLong(d(r2));
        L4:
            return -1;
        }

        public int b(String r2) {
            return this.f4328a.getInt(d(r2));
        L4:
            return -1;
        }

        public String c(String r2) {
            return this.f4328a.getString(d(r2));
        L4:
            return "";
        }

        private int d(String r4) {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f4329b.get(r4), Integer.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L9;
            r0 = Integer.valueOf(this.f4328a.getColumnIndex(r4));     // Catch: Throwable -> L6
        L7:
            this.f4329b.put(r4, r0);
        L6:
            r0 = -1;
        L9:
            return r0.intValue();
        }
    }

    public String a() {
        return DBHelper.DB_NAME;
    }

    public abstract String b();

    public abstract String[] c();

    public a() {
        this.f4327d = new HashMap();
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f4324a = r0;
        this.f4325b = r0.getPackageName() + ".apm";
    }

    public Uri d() {
        if (this.f4326c != null) goto L6;
        this.f4326c = Uri.parse("content://" + this.f4325b + "/" + a() + "/" + b());
    L6:
        return this.f4326c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> query(String r10, String[] r11, String r12, InterfaceC0110a<T> r13) {
        InterfaceC0110a r14 = (InterfaceC0110a) ZeusTransformUtils.wrapperContextForParams(r13, InterfaceC0110a.class, "com.obric.aiagent.plugin");
        Cursor r0 = null;
        Object[] r1 = 0;
        Cursor r15 = ZeusProviderTransform.query(this.f4324a.getContentResolver(), d(), c(), r10, r11, r12, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r15 != null) goto L31;
    L24:
        List<T> r9 = Collections.emptyList();     // Catch: Throwable -> L27
        a(r15);
        return r9;
    L31:
    L27:
        r0 = r15;
        goto L28
    L6:
        if (r15.getCount() <= 0) goto L24;
        int r16 = Integer.MAX_VALUE;
        if (TextUtils.isEmpty(r12) == true) goto L16;
        int r2 = r12.indexOf("LIMIT");     // Catch: Throwable -> L27
        if (r2 <= 0) goto L16;
        int r17 = r12.indexOf("OFF");     // Catch: Throwable -> L27
        if (r17 <= 0) goto L15;
        r16 = Integer.valueOf(r12.substring(r2 + 5, r17).trim()).intValue();     // Catch: Throwable -> L27
        goto L16
    L15:
        r16 = Integer.valueOf(r12.substring(r2 + 5).trim()).intValue();     // Catch: Throwable -> L27
    L16:
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L27
        int r3 = 0;
    L18:
        if (r15.moveToNext() == false) goto L22;
        if (r3 >= r16) goto L22;
        r18.add(r14.a(new b(r15, this.f4327d, r1 == true ? 1 : 0)));     // Catch: Throwable -> L27
        r3 = r3 + 1;
    L22:
        a(r15);
        return r18;
    L28:
        a(r0);
        return Collections.emptyList();
    }

    public int update(ContentValues r9, String r10, String[] r11) {
        if (r9 != null) goto L8;
        return -1;
    L8:
        return ZeusProviderTransform.update(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), d(), r9, r10, r11, "com.obric.aiagent.plugin");
    L7:
        return -1;
    }

    public synchronized <I extends T> long insert(ContentValues r6) {
        monitor-enter(this);
        if (r6 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r7 = ZeusProviderTransform.insert(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), d(), r6, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17 Exception -> L20
        if (r7 != null) goto L24;
        monitor-exit(this);
        return -1;
    L24:
        long r0 = Long.parseLong(r7.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r0;
    L14:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    public int delete(String r3, String[] r4) {
        return ZeusProviderTransform.delete(this.f4324a.getContentResolver(), d(), r3, r4, "com.obric.aiagent.plugin");
    L4:
        return -1;
    }

    private static void a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        if (r3.isClosed() == true) goto L12;
        r3.close();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }
}
