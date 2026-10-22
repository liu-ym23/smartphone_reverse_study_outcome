package com.obric.capabilitykit.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityContentProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f32079b = "EntityContentProvider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f32080c = "data_check";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f32081d = "reindex_all_data";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f32082e = "update_entity_version";
    public static final String f = "sync_data_indexed_types";
    public static final long g = 2500;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        f32078a = new a(null);
    }

    public EntityContentProvider() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String a() {
        return getCallingPackage();
    L4:
        e = move-exception;
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        String r6 = r5.getPackageName();
    L9:
        r1.w(f32079b, r2.append(r6).append(" run method, callingPackage failed").toString(), e);
        return null;
    L8:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bundle call(String r17, String r18, Bundle r19) {
        o.e(r17, "method");
        Bundle r2 = new Bundle();
        String r3 = a();
        Logger r4 = Logger.INSTANCE;
        StringBuilder r5 = new StringBuilder();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r8 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getPackageName();
    L6:
        r4.d(f32079b, r5.append(r7).append(" run method: ").append(r17).append(" from pkg: ").append(r3).append(", call:").toString());
        if (PackageUtils.INSTANCE.checkSignature(r3) == true) goto L10;
        r4.i(f32079b, "signatures not match");
        r2.putBoolean(EntityUpdateVersionParams.RESULT_KEY, false);
        return r2;
    L10:
        long r11 = Binder.clearCallingIdentity();
        EntityProvider r9 = EntityProvider.INSTANCE;     // Catch: Throwable -> L56
        r9.waitEntityProviderInit(g);     // Catch: Throwable -> L56
        if (r9.isInitialized() == false) goto L50;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L56
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r14 == null) goto L16;
        String r15 = r14.getPackageName();     // Catch: Throwable -> L56
    L17:
        r4.d(f32079b, r13.append(r15).append(" run method: ").append(r17).append(", start:").toString());     // Catch: Throwable -> L56
        int r16 = r17.hashCode();     // Catch: Throwable -> L56
        if (r16 == (-1184655032)) goto L42;
        if (r16 == 1555726002) goto L36;
        if (r16 == 1604538419) goto L25;
    L58:
        Binder.restoreCallingIdentity(r11);
        Logger r0 = Logger.INSTANCE;
        StringBuilder r10 = new StringBuilder();
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L61;
        r8 = r12.getPackageName();
    L61:
        r0.d(f32079b, r10.append(r8).append(" run method: ").append(r17).append(" pkg: ").append(a()).append(" END.").toString());
        return r2;
    L25:
        if (r17.equals(f32080c) == false) goto L58;
        if (r19 == null) goto L33;
        ArrayList<Integer> r1 = r19.getIntegerArrayList(f);     // Catch: Throwable -> L56
        if (r1 == null) goto L33;
        List<Integer> r20 = p.o(r1);     // Catch: Throwable -> L56
        if (r20 == null) goto L33;
    L34:
        r9.syncData(r20);     // Catch: Throwable -> L56
    L33:
        r20 = p.b();     // Catch: Throwable -> L56
        goto L34
    L36:
        if (r17.equals(f32082e) == false) goto L58;
        if (r9.reDonateCheck$capabilitykit_release(r18) == false) goto L58;
        r2.putBoolean(EntityUpdateVersionParams.RESULT_KEY, true);     // Catch: Throwable -> L56
        goto L58
    L42:
        if (r17.equals(f32081d) == false) goto L58;
        PackageUtils r21 = PackageUtils.INSTANCE;     // Catch: Throwable -> L56
        if (r3 != null) goto L48;
        r3 = "";
    L48:
        if (r21.isMemoryPackageName(r3) == false) goto L58;
        r4.i(f32079b, "run reindex_all_data method start");     // Catch: Throwable -> L56
        r9.reindexEntityData$capabilitykit_release();     // Catch: Throwable -> L56
        r4.i(f32079b, "run reindex_all_data method end");     // Catch: Throwable -> L56
        goto L58
    L16:
        r15 = null;
        goto L17
    L50:
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L56
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r23 == null) goto L53;
        String r24 = r23.getPackageName();     // Catch: Throwable -> L56
    L54:
        r4.w(f32079b, r22.append(r24).append(" run method: ").append(r17).append(", not initialized").toString());     // Catch: Throwable -> L56
        goto L58
    L53:
        r24 = null;
    L56:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        Logger.INSTANCE.e(f32079b, "error: " + th.getMessage());     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Binder.restoreCallingIdentity(r11);
        throw th;
    L5:
        r7 = null;
        goto L6
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreate() {
        EntityProvider r0 = EntityProvider.INSTANCE;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L6:
        o.a(r4);
        r0.setSContext(r4);
        EntityContextHolder.INSTANCE.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }
}
