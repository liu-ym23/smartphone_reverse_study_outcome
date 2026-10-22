package s6;

import D7.N;
import M0.i;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Base64;
import android.util.Log;
import androidx.room.Room;
import com.stepos.taskrobot.taskmemory.AppTaskDatabase;
import j9.AbstractC1607a;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.Result;
import kotlin.jvm.internal.k;
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory;

/* renamed from: s6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1914a {
    public static AppTaskDatabase a(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Object objA;
        Q3.f fVar;
        System.loadLibrary("sqlcipher");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("taskrobot_db_keys", 0);
        String string = sharedPreferences.getString("wrapped_passphrase", null);
        if (string != null) {
            try {
                objA = i.K(string);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objA instanceof Result.Failure) {
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    androidx.constraintlayout.core.dsl.a.w("库口令解包失败，将重建口令：", thA.getMessage(), "TaskDBPassphrase");
                }
                byte[] bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
                String strEncodeToString = Base64.encodeToString(bArr, 2);
                k.e(strEncodeToString, "encodeToString(...)");
                byte[] bytes = strEncodeToString.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, i.L());
                byte[] bArrDoFinal = cipher.doFinal(bytes);
                editorEdit.putString("wrapped_passphrase", Base64.encodeToString(cipher.getIV(), 2) + ":" + Base64.encodeToString(bArrDoFinal, 2)).commit();
                fVar = new Q3.f(bytes, true);
            } else {
                fVar = new Q3.f((byte[]) objA, false);
            }
        } else {
            byte[] bArr2 = new byte[32];
            new SecureRandom().nextBytes(bArr2);
            String strEncodeToString2 = Base64.encodeToString(bArr2, 2);
            k.e(strEncodeToString2, "encodeToString(...)");
            byte[] bytes2 = strEncodeToString2.getBytes(AbstractC1607a.f4778a);
            k.e(bytes2, "getBytes(...)");
            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
            Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
            cipher2.init(1, i.L());
            byte[] bArrDoFinal2 = cipher2.doFinal(bytes2);
            editorEdit2.putString("wrapped_passphrase", Base64.encodeToString(cipher2.getIV(), 2) + ":" + Base64.encodeToString(bArrDoFinal2, 2)).commit();
            fVar = new Q3.f(bytes2, true);
        }
        StringBuilder sb = new StringBuilder("SQLCipher 口令加载完成, freshlyCreated=");
        boolean z10 = fVar.b;
        sb.append(z10);
        Log.i("AppTaskDatabase", sb.toString());
        if (z10 && context.deleteDatabase(AppTaskDatabase.DB_NAME)) {
            Log.i("AppTaskDatabase", "已销毁无法打开的旧明文库 task_db");
        }
        AppTaskDatabase appTaskDatabase = (AppTaskDatabase) Room.databaseBuilder(context, AppTaskDatabase.class, AppTaskDatabase.DB_NAME).openHelperFactory(new SupportOpenHelperFactory(fVar.f1104a)).addMigrations(AppTaskDatabase.MIGRATION_1_2).build();
        Cursor cursorQuery = appTaskDatabase.getOpenHelper().getWritableDatabase().query("PRAGMA cipher_version");
        try {
            Cursor cursor = cursorQuery;
            if (cursor.moveToFirst()) {
                Log.i("AppTaskDatabase", "数据库加密已启用, cipher_version=" + cursor.getString(0) + ", path=" + context.getDatabasePath(AppTaskDatabase.DB_NAME));
            }
            N.t(cursorQuery, null);
            return appTaskDatabase;
        } finally {
        }
    }

    public final AppTaskDatabase b(Context context) {
        AppTaskDatabase appTaskDatabaseA;
        k.f(context, "context");
        AppTaskDatabase appTaskDatabase = AppTaskDatabase.INSTANCE;
        if (appTaskDatabase != null) {
            return appTaskDatabase;
        }
        synchronized (this) {
            appTaskDatabaseA = AppTaskDatabase.INSTANCE;
            if (appTaskDatabaseA == null) {
                C1914a c1914a = AppTaskDatabase.Companion;
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                c1914a.getClass();
                appTaskDatabaseA = a(applicationContext);
                AppTaskDatabase.INSTANCE = appTaskDatabaseA;
            }
        }
        return appTaskDatabaseA;
    }
}
