package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import u2.C5572c;

/* loaded from: classes2.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f19735a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f19736b;

    /* renamed from: c, reason: collision with root package name */
    public static String f19737c;

    /* renamed from: d, reason: collision with root package name */
    public static int f19738d;

    public static int a(Context context) {
        b(context);
        return f19738d;
    }

    public static void b(Context context) {
        Bundle bundle;
        synchronized (f19735a) {
            try {
                if (f19736b) {
                    return;
                }
                f19736b = true;
                try {
                    bundle = C5572c.a(context).a(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
                if (bundle == null) {
                    return;
                }
                f19737c = bundle.getString("com.google.app.id");
                f19738d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
