package com.stepos.agentsafetycenter.permission;

import a4.n;
import ac.a;
import ad.z;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.b;
import g9.g0;
import g9.j;
import g9.k;
import g9.l;
import java.lang.invoke.VarHandle;
import kc.e0;
import kc.w;
import p5.c;
import rc.d;
import rc.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AgentPermissionProvider extends ContentProvider {

    /* renamed from: f, reason: collision with root package name */
    public static final UriMatcher f2512f;

    /* renamed from: c, reason: collision with root package name */
    public volatile z f2513c;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.stepos.agentsafetycenter.permission", "", 1);
        uriMatcher.addURI("com.stepos.agentsafetycenter.permission", "snapshot", 2);
        f2512f = uriMatcher;
    }

    public static final z a(AgentPermissionProvider agentPermissionProvider) {
        Context applicationContext;
        z zVar = agentPermissionProvider.f2513c;
        if (zVar != null) {
            return zVar;
        }
        synchronized (agentPermissionProvider) {
            z zVar2 = agentPermissionProvider.f2513c;
            if (zVar2 != null) {
                return zVar2;
            }
            Context context = agentPermissionProvider.getContext();
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                throw new IllegalStateException("AgentPermissionProvider has no context");
            }
            g0 g0Var = new g0();
            g0Var.f4462a = applicationContext.getApplicationContext();
            VarHandle.storeStoreFence();
            k kVar = new k(0);
            kVar.f4509f = applicationContext;
            VarHandle.storeStoreFence();
            c cVar = new c(5);
            cVar.f9717f = g0Var;
            cVar.f9718g = kVar;
            VarHandle.storeStoreFence();
            n nVar = new n();
            nVar.f190a = applicationContext;
            VarHandle.storeStoreFence();
            androidx.room.c cVar2 = new androidx.room.c(5);
            androidx.room.c cVar3 = new androidx.room.c(4);
            z zVar3 = new z(1);
            zVar3.f637b = cVar;
            zVar3.f638c = nVar;
            zVar3.f639d = cVar2;
            zVar3.f640e = cVar3;
            zVar3.f641f = new sc.c();
            VarHandle.storeStoreFence();
            agentPermissionProvider.f2513c = zVar3;
            return zVar3;
        }
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        String str3;
        str.getClass();
        boolean z10 = bundle != null && bundle.getBoolean("force_refresh", false);
        try {
            e eVar = e0.f7430a;
            str3 = str;
        } catch (Exception e10) {
            e = e10;
            str3 = str;
        }
        try {
            return a.b0((j) w.y(d.f10552f, new l(str3, this, z10, bundle, null)));
        } catch (Exception e11) {
            e = e11;
            Exception exc = e;
            Log.w("AgentPermissionIpc", b.j("call failed method=", str3, ": ", exc.getMessage()), exc);
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("code", 6);
            bundle2.putString("message", message);
            bundle2.putInt("schema_version", 1);
            bundle2.putLong("updated_at_ms", 0L);
            bundle2.putBoolean("from_cache", true);
            bundle2.putBoolean("stale", false);
            bundle2.putString("payload_json", "");
            return bundle2;
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        uri.getClass();
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        uri.getClass();
        int iMatch = f2512f.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            return "vnd.android.cursor.dir/vnd.com.stepos.agentsafetycenter.permission.snapshot";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        uri.getClass();
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        uri.getClass();
        int iMatch = f2512f.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            return new MatrixCursor(new String[]{"_id"});
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        uri.getClass();
        return 0;
    }
}
