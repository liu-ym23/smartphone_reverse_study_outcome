package com.stepos.ailauncher.chat.minor;

import Y8.t;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import l9.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/minor/a;", "", "<init>", "()V", "", "c", "()Z", Const.INTENT_KEY_UMID, "LY8/t;", "e", "", "TAG", "Ljava/lang/String;", "Landroid/net/Uri;", "MINOR_MODE_URI", "Landroid/net/Uri;", "COLUMN_MINOR_MODE", "cached", "Ljava/lang/Boolean;", "observerRegistered", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private static final String COLUMN_MINOR_MODE = "minor_mode";
    public static final a INSTANCE = new a();
    private static final Uri MINOR_MODE_URI;
    private static final String TAG = "MinorModeChecker";
    private static volatile Boolean cached;
    private static volatile boolean observerRegistered;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/minor/a$a", "Landroid/database/ContentObserver;", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.minor.a$a, reason: collision with other inner class name */
    public static final class C0290a extends ContentObserver {
        public C0290a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            boolean zD = a.this.d();
            a.cached = Boolean.valueOf(zD);
            C4148a.d(a.TAG, "minor mode changed -> " + zD, false, 4, null);
        }
    }

    static {
        Uri uri = Uri.parse("content://com.stepos.familyguard.MinorProvider/minor_mode");
        p.h(uri, "parse(...)");
        MINOR_MODE_URI = uri;
    }

    public final boolean c() {
        boolean zBooleanValue;
        Boolean bool = cached;
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (this) {
            try {
                Boolean bool2 = cached;
                if (bool2 != null) {
                    zBooleanValue = bool2.booleanValue();
                } else {
                    a aVar = INSTANCE;
                    boolean zD = aVar.d();
                    cached = Boolean.valueOf(zD);
                    aVar.e();
                    zBooleanValue = zD;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public final boolean d() {
        Object objB;
        int columnIndex;
        try {
            Result.Companion companion = Result.INSTANCE;
            Cursor cursorQuery = C3197a.INSTANCE.a().getContentResolver().query(MINOR_MODE_URI, null, null, null, null);
            boolean z10 = false;
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex(COLUMN_MINOR_MODE)) >= 0) {
                        if (cursor2.getInt(columnIndex) == 1) {
                            z10 = true;
                        }
                    }
                    b.a(cursor, null);
                } finally {
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "query minor mode failed, fallback to off", thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void e() {
        Object objB;
        if (observerRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            C3197a.INSTANCE.a().getContentResolver().registerContentObserver(MINOR_MODE_URI, false, new C0290a(new Handler(Looper.getMainLooper())));
            observerRegistered = true;
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerContentObserver failed", thE, false, 8, null);
        }
    }
}
