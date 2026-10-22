package com.stepos.agentsafetycenter.screenperception;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import i9.g;
import kb.l;
import kc.e0;
import kc.w;
import rc.d;
import rc.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ScreenPerceptionSettingsProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        uri.getClass();
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        uri.getClass();
        return "vnd.android.cursor.dir/vnd.stepos.screenperception.blacklist";
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
        Context context = getContext();
        if (context == null) {
            return new MatrixCursor(new String[]{"blacklist_package_names", "schema_version", "updated_at_epoch_ms"});
        }
        e eVar = e0.f7430a;
        g gVar = (g) w.y(d.f10552f, new androidx.room.e(context, null, 4));
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"blacklist_package_names", "schema_version", "updated_at_epoch_ms"});
        matrixCursor.addRow(new Object[]{l.B0(gVar.f5861a, ",", null, null, null, 62), 2, Long.valueOf(gVar.f5862b)});
        matrixCursor.moveToFirst();
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        uri.getClass();
        return 0;
    }
}
