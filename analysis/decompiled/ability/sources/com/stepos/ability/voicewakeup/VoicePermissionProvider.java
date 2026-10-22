package com.stepos.ability.voicewakeup;

import C4.c;
import C7.f;
import D7.q;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/voicewakeup/VoicePermissionProvider;", "Landroid/content/ContentProvider;", AppAgent.CONSTRUCT, "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoicePermissionProvider extends ContentProvider {
    public static final Uri c;
    public static final UriMatcher d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3320a = new Object();
    public final f b = kotlin.a.a(new Ba.a(1));

    static {
        Uri uri = Uri.parse("content://com.stepos.ability.voicewakeup.permission/consent");
        k.e(uri, "parse(...)");
        c = uri;
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.stepos.ability.voicewakeup.permission", "consent", 1);
        d = uriMatcher;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        k.f(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Context context;
        k.f(uri, "uri");
        if (d.match(uri) != 1 || (context = getContext()) == null) {
            return null;
        }
        String str3 = strArr2 != null ? (String) q.n0(strArr2) : null;
        if (str3 == null) {
            str3 = "";
        }
        boolean z10 = context.getApplicationContext().getSharedPreferences("voice_wakeup_permission", 0).getBoolean("consent_" + str3, false);
        Log.i("VoicePermissionStorage", "isGranted userId=" + str3 + " granted=" + z10);
        Log.i("VoicePermissionProvider", "query userId=" + str3 + " granted=" + z10);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"user_id", "granted"});
        matrixCursor.addRow(new Object[]{str3, Integer.valueOf(z10 ? 1 : 0)});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Context context;
        k.f(uri, "uri");
        if (d.match(uri) != 1 || (context = getContext()) == null || contentValues == null) {
            return 0;
        }
        String asString = contentValues.getAsString("user_id");
        if (asString == null) {
            asString = "";
        }
        Integer asInteger = contentValues.getAsInteger("granted");
        boolean z10 = (asInteger != null ? asInteger.intValue() : 0) == 1;
        synchronized (this.f3320a) {
            Log.i("VoicePermissionProvider", "update userId=" + asString + " granted=" + z10);
            a.b(context, asString, z10);
        }
        if (!z10) {
            Log.i("VoicePermissionProvider", "granted=false, scheduling clearVoiceprint");
            ((Handler) this.b.getF4884a()).post(new c(0));
        }
        return 1;
    }
}
