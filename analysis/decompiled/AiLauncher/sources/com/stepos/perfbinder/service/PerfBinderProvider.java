package com.stepos.perfbinder.service;

import Z8.r;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.stepos.perbinder.service.PerfBinderServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JS\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J3\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/stepos/perfbinder/service/PerfBinderProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", ChatTracker.CLICK_DELETE, "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", a.BUTTON_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "Companion", "perfbinder-service_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class PerfBinderProvider extends ContentProvider {
    private static final String TAG = "PerfBinderProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        String str;
        PackageManager packageManager;
        p.i(method, "method");
        Log.i(TAG, "call: " + getCallingPackage() + " " + method);
        Bundle bundle = new Bundle();
        if (p.d(method, BaseConstantsKt.KEY_PERF_BINDER)) {
            Context context = getContext();
            String[] packagesForUid = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid == null || (str = (String) r.j0(packagesForUid, 0)) == null) {
                str = "";
            }
            if (extras == null) {
                extras = new Bundle();
            }
            Bundle bundleIpcActionCall = PerfBinderServiceManager.ipcActionCall(str, arg, extras);
            if (bundleIpcActionCall != null) {
                return bundleIpcActionCall;
            }
        }
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }
}
