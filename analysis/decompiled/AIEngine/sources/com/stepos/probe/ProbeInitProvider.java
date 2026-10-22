package com.stepos.probe;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import da.a;
import da.b;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ProbeInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        g.f(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        g.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        g.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        PerfettoSink perfettoSink = PerfettoSink.f7999a;
        Context context = getContext();
        g.c(context);
        boolean z = b.f8415a;
        ContentResolver contentResolver = context.getContentResolver();
        boolean z3 = b.f8415a;
        g.c(contentResolver);
        b.a("init", b.f(contentResolver));
        contentResolver.registerContentObserver(Settings.Global.getUriFor("clawbench_probe_profile"), false, new a(contentResolver, new Handler(Looper.getMainLooper())));
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        g.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        g.f(uri, "uri");
        return 0;
    }
}
