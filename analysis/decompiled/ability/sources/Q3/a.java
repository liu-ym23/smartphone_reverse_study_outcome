package Q3;

import D7.N;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Base64;
import android.util.Log;
import androidx.room.Room;
import ca.AbstractC0897f;
import com.stepos.ability.database.AppDatabase;
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

/* loaded from: classes3.dex */
public final class a {
    public static AppDatabase a(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Object objA;
        f fVar;
        System.loadLibrary("sqlcipher");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("ability_db_keys", 0);
        String string = sharedPreferences.getString("wrapped_passphrase", null);
        if (string != null) {
            try {
                objA = AbstractC0897f.O(string);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objA instanceof Result.Failure) {
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    androidx.constraintlayout.core.dsl.a.w("库口令解包失败，将重建口令：", thA.getMessage(), "DatabasePassphrase");
                }
                byte[] bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
                String strEncodeToString = Base64.encodeToString(bArr, 2);
                k.e(strEncodeToString, "encodeToString(...)");
                byte[] bytes = strEncodeToString.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, AbstractC0897f.P());
                byte[] bArrDoFinal = cipher.doFinal(bytes);
                editorEdit.putString("wrapped_passphrase", Base64.encodeToString(cipher.getIV(), 2) + ":" + Base64.encodeToString(bArrDoFinal, 2)).commit();
                fVar = new f(bytes, true);
            } else {
                fVar = new f((byte[]) objA, false);
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
            cipher2.init(1, AbstractC0897f.P());
            byte[] bArrDoFinal2 = cipher2.doFinal(bytes2);
            editorEdit2.putString("wrapped_passphrase", Base64.encodeToString(cipher2.getIV(), 2) + ":" + Base64.encodeToString(bArrDoFinal2, 2)).commit();
            fVar = new f(bytes2, true);
        }
        StringBuilder sb = new StringBuilder("SQLCipher 口令加载完成, freshlyCreated=");
        boolean z10 = fVar.b;
        sb.append(z10);
        Log.i("AppDatabase", sb.toString());
        if (z10 && context.deleteDatabase(AppDatabase.DB_NAME)) {
            Log.i("AppDatabase", "已销毁无法打开的旧明文库 ability.db");
        }
        AppDatabase appDatabase = (AppDatabase) Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DB_NAME).openHelperFactory(new SupportOpenHelperFactory(fVar.f1104a)).addMigrations(c.f1101a, c.b, c.c, c.d, c.e, c.f).build();
        Cursor cursorQuery = appDatabase.getOpenHelper().getWritableDatabase().query("PRAGMA cipher_version");
        try {
            Cursor cursor = cursorQuery;
            if (cursor.moveToFirst()) {
                Log.i("AppDatabase", "数据库加密已启用, cipher_version=" + cursor.getString(0) + ", path=" + context.getDatabasePath(AppDatabase.DB_NAME));
            }
            N.t(cursorQuery, null);
            return appDatabase;
        } finally {
        }
    }

    public final AppDatabase b(Context context) {
        AppDatabase appDatabaseA;
        AppDatabase appDatabase = AppDatabase.instance;
        if (appDatabase != null) {
            return appDatabase;
        }
        synchronized (this) {
            appDatabaseA = AppDatabase.instance;
            if (appDatabaseA == null) {
                a aVar = AppDatabase.Companion;
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                aVar.getClass();
                appDatabaseA = a(applicationContext);
                AppDatabase.instance = appDatabaseA;
            }
        }
        return appDatabaseA;
    }
}
