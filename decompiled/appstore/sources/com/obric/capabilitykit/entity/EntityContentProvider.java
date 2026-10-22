package com.obric.capabilitykit.entity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JQ\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\u001b\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010!\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "callingPackageSafely", "()Ljava/lang/String;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11314a = null;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f11314a = new a(null);
    }

    public EntityContentProvider() {
    }

    public final String a() {
        return getCallingPackage();
    L4:
        e = move-exception;
        Logger r10 = Logger.INSTANCE;
        StringBuilder r11 = new StringBuilder();
        Context r12 = getContext();
        if (r12 == null) goto L8;
        String r13 = r12.getPackageName();
    L9:
        r11.append(r13);
        r11.append(" run method, callingPackage failed");
        r10.w("EntityContentProvider", r11.toString(), e);
        return null;
    L8:
        r13 = null;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r16, String r17, Bundle r18) {
        q.g(r16, "method");
        Bundle r10 = new Bundle();
        String r11 = a();
        Logger r12 = Logger.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        Context r14 = getContext();
        String r15 = null;
        if (r14 == null) goto L5;
        String r19 = r14.getPackageName();
    L6:
        r13.append(r19);
        r13.append(" run method: ");
        r13.append(r16);
        r13.append(" from pkg: ");
        r13.append(r11);
        r13.append(", call:");
        r12.d("EntityContentProvider", r13.toString());
        PackageUtils r20 = PackageUtils.INSTANCE;
        if (r20.checkSignature(r11) == true) goto L10;
        r12.i("EntityContentProvider", "signatures not match");
        r10.putBoolean(EntityUpdateVersionParams.RESULT_KEY, false);
        return r10;
    L10:
        long r110 = Binder.clearCallingIdentity();
        EntityProvider r21 = EntityProvider.INSTANCE;     // Catch: Throwable -> L16
        r21.waitEntityProviderInit(PerfConsts.DEFAULT_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L16
        if (r21.isInitialized() == false) goto L51;
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L16
        Context r112 = getContext();     // Catch: Throwable -> L16
        if (r112 == null) goto L18;
        String r113 = r112.getPackageName();     // Catch: Throwable -> L16
    L19:
        r111.append(r113);     // Catch: Throwable -> L16
        r111.append(" run method: ");     // Catch: Throwable -> L16
        r111.append(r16);     // Catch: Throwable -> L16
        r111.append(", start:");     // Catch: Throwable -> L16
        r12.d("EntityContentProvider", r111.toString());     // Catch: Throwable -> L16
        int r114 = r16.hashCode();     // Catch: Throwable -> L16
        if (r114 == (-1184655032)) goto L44;
        if (r114 == 1555726002) goto L38;
        if (r114 == 1604538419) goto L27;
    L56:
        Binder.restoreCallingIdentity(r110);
        Logger r22 = Logger.INSTANCE;
        StringBuilder r23 = new StringBuilder();
        Context r24 = getContext();
        if (r24 == null) goto L62;
        r15 = r24.getPackageName();
    L62:
        r23.append(r15);
        r23.append(" run method: ");
        r23.append(r16);
        r23.append(" pkg: ");
        r23.append(a());
        r23.append(" END.");
        r22.d("EntityContentProvider", r23.toString());
        return r10;
    L27:
        if (r16.equals("data_check") == false) goto L56;
        if (r18 == null) goto L35;
        ArrayList<Integer> r25 = r18.getIntegerArrayList("sync_data_indexed_types");     // Catch: Throwable -> L16
        if (r25 == null) goto L35;
        List<Integer> r26 = b0.x0(r25);     // Catch: Throwable -> L16
        if (r26 == null) goto L35;
    L36:
        r21.syncData(r26);     // Catch: Throwable -> L16
    L35:
        r26 = t.i();     // Catch: Throwable -> L16
        goto L36
    L38:
        if (r16.equals("update_entity_version") == false) goto L56;
        if (r21.reDonateCheck$capabilitykit_release(r17) == false) goto L56;
        r10.putBoolean(EntityUpdateVersionParams.RESULT_KEY, true);     // Catch: Throwable -> L16
        goto L56
    L44:
        if (r16.equals("reindex_all_data") == false) goto L56;
        if (r11 != null) goto L49;
        r11 = "";
    L49:
        if (r20.isMemoryPackageName(r11) == false) goto L56;
        r12.i("EntityContentProvider", "run reindex_all_data method start");     // Catch: Throwable -> L16
        r21.reindexEntityData$capabilitykit_release();     // Catch: Throwable -> L16
        r12.i("EntityContentProvider", "run reindex_all_data method end");     // Catch: Throwable -> L16
        goto L56
    L18:
        r113 = null;
        goto L19
    L51:
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L16
        Context r28 = getContext();     // Catch: Throwable -> L16
        if (r28 == null) goto L54;
        String r29 = r28.getPackageName();     // Catch: Throwable -> L16
    L55:
        r27.append(r29);     // Catch: Throwable -> L16
        r27.append(" run method: ");     // Catch: Throwable -> L16
        r27.append(r16);     // Catch: Throwable -> L16
        r27.append(", not initialized");     // Catch: Throwable -> L16
        r12.w("EntityContentProvider", r27.toString());     // Catch: Throwable -> L16
        goto L56
    L54:
        r29 = null;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        Logger.INSTANCE.e("EntityContentProvider", "error: " + th.getMessage());     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Binder.restoreCallingIdentity(r110);
        throw th;
    L5:
        r19 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        q.g(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        q.g(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        q.g(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        EntityProvider r10 = EntityProvider.INSTANCE;
        Context r11 = getContext();
        if (r11 == null) goto L5;
        Context r12 = r11.getApplicationContext();
    L6:
        q.d(r12);
        r10.setSContext(r12);
        EntityContextHolder.INSTANCE.init(r10.getSContext());
        return true;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        q.g(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        q.g(r10, "uri");
        return 0;
    }
}
