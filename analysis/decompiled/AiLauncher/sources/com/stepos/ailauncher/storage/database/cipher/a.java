package com.stepos.ailauncher.storage.database.cipher;

import La.H;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.storage.database.cipher.PlainToCipherMigrator;
import h8.C4148a;
import j1.InterfaceC4757d;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SupportFactory;
import q6.C5156a;
import q6.c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/storage/database/cipher/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "dbName", "", "failClosed", "deviceDerivedKey", "Lj1/d$c;", "c", "(Landroid/content/Context;Ljava/lang/String;ZZ)Lj1/d$c;", "", "cause", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Throwable;)Z", "reason", "f", "(Ljava/lang/String;ZLjava/lang/String;)Lj1/d$c;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;)Z", "Ljava/io/File;", "dbFile", "e", "(Ljava/lang/String;Ljava/io/File;)Z", "TAG", "Ljava/lang/String;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TAG = "DatabaseCipher";

    public static /* synthetic */ InterfaceC4757d.c d(a aVar, Context context, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return aVar.c(context, str, z10, z11);
    }

    public final boolean a(Context context, String dbName, Throwable cause) {
        p.i(context, "context");
        p.i(dbName, "dbName");
        p.i(cause, "cause");
        if (!b(cause)) {
            return false;
        }
        File databasePath = context.getDatabasePath(dbName);
        if (!databasePath.isFile()) {
            return false;
        }
        PlainToCipherMigrator plainToCipherMigrator = PlainToCipherMigrator.INSTANCE;
        p.f(databasePath);
        C4148a.h(TAG, "recreating " + dbName + ": unopenable with current key (cipher=" + plainToCipherMigrator.f(databasePath) + ", cause=" + cause.getMessage() + ")", false, 4, null);
        context.deleteDatabase(dbName);
        return true;
    }

    public final boolean b(Throwable cause) {
        while (cause != null && !(cause instanceof CipherKeyUnavailableException)) {
            String message = cause.getMessage();
            if (message == null) {
                message = "";
            }
            String lowerCase = message.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (H.g0(lowerCase, "enospc", false, 2, null) || H.g0(lowerCase, "no space left", false, 2, null) || H.g0(lowerCase, "sqlite_full", false, 2, null)) {
                return false;
            }
            if (H.g0(lowerCase, "not a database", false, 2, null) || H.g0(lowerCase, "file is encrypted", false, 2, null) || H.g0(lowerCase, "disk image is malformed", false, 2, null)) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }

    public final synchronized InterfaceC4757d.c c(Context context, String dbName, boolean failClosed, boolean deviceDerivedKey) {
        try {
            p.i(context, "context");
            p.i(dbName, "dbName");
            c cVar = c.INSTANCE;
            cVar.d(context);
            File databasePath = context.getDatabasePath(dbName);
            if (deviceDerivedKey) {
                C5156a c5156a = C5156a.INSTANCE;
                byte[] bArrB = c5156a.b(context);
                if (bArrB == null) {
                    throw new CipherKeyUnavailableException(dbName);
                }
                PlainToCipherMigrator plainToCipherMigrator = PlainToCipherMigrator.INSTANCE;
                p.f(databasePath);
                if (plainToCipherMigrator.g(databasePath) && plainToCipherMigrator.h(context, databasePath, bArrB) == PlainToCipherMigrator.Result.FAILED) {
                    throw new CipherKeyUnavailableException(dbName);
                }
                byte[] bArrB2 = c5156a.b(context);
                if (bArrB2 == null) {
                    throw new CipherKeyUnavailableException(dbName);
                }
                return new SupportFactory(bArrB2, null, false);
            }
            if (cVar.g() == null) {
                p.f(databasePath);
                if (!e(dbName, databasePath)) {
                    return f(dbName, failClosed, "passphrase unavailable");
                }
            }
            if (cVar.n()) {
                PlainToCipherMigrator plainToCipherMigrator2 = PlainToCipherMigrator.INSTANCE;
                p.f(databasePath);
                if (plainToCipherMigrator2.f(databasePath)) {
                    C4148a.h(TAG, "dropping " + dbName + ": encrypted with the lost key, unrecoverable", false, 4, null);
                    context.deleteDatabase(dbName);
                }
            }
            PlainToCipherMigrator plainToCipherMigrator3 = PlainToCipherMigrator.INSTANCE;
            p.f(databasePath);
            if (plainToCipherMigrator3.g(databasePath) && plainToCipherMigrator3.h(context, databasePath, cVar.f()) == PlainToCipherMigrator.Result.FAILED) {
                return f(dbName, failClosed, "migration failed");
            }
            if (plainToCipherMigrator3.g(databasePath)) {
                return f(dbName, failClosed, "file header still SQLite format 3");
            }
            return new SupportFactory(cVar.f(), null, false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean e(String dbName, File dbFile) {
        c cVar = c.INSTANCE;
        if (cVar.m()) {
            if (cVar.k() != null) {
                return true;
            }
            C4148a.h(TAG, "passphrase reset failed for " + dbName, false, 4, null);
            return false;
        }
        if (PlainToCipherMigrator.INSTANCE.f(dbFile)) {
            throw new CipherKeyUnavailableException(dbName);
        }
        C4148a.h(TAG, "passphrase unavailable for " + dbName, false, 4, null);
        return false;
    }

    public final InterfaceC4757d.c f(String dbName, boolean failClosed, String reason) {
        if (failClosed) {
            C4148a.h(TAG, "refusing plaintext open for " + dbName + ": " + reason, false, 4, null);
            throw new CipherRefusedPlaintextException(dbName, reason);
        }
        C4148a.h(TAG, reason + ", opening " + dbName + " as plaintext this session", false, 4, null);
        return null;
    }
}
