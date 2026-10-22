package com.stepos.agentsafetycenter.ledger;

import ac.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.b;
import kc.e0;
import kc.k1;
import kc.w;
import m8.g0;
import pc.c;
import rc.d;
import rc.e;
import y8.u;
import y8.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class LedgerProvider extends ContentProvider {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2504g = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile u f2505c;

    /* renamed from: f, reason: collision with root package name */
    public final c f2506f;

    public LedgerProvider() {
        k1 k1VarC = w.c();
        e eVar = e0.f7430a;
        this.f2506f = w.a(a.N(k1VarC, d.f10552f));
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        str.getClass();
        boolean z10 = bundle != null && bundle.getBoolean("force_refresh", false);
        try {
            e eVar = e0.f7430a;
            return t0.a.m((v) w.y(d.f10552f, new g0(str, this, z10, (nb.c) null)));
        } catch (Exception e10) {
            Log.w("LedgerIpc", b.j("call failed method=", str, ": ", e10.getMessage()), e10);
            String message = e10.getMessage();
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
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        uri.getClass();
        return 0;
    }
}
