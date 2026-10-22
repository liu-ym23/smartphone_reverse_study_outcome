package com.stepos.renderfilter;

import C2.f;
import K.C0073e;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.api.internal.s;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (!f.f344a) {
            f.f344a = true;
            byte[] bArrDecode = Base64.decode("ZGV4CjAzNQC+qDk0htQtTbJAFjm51pzO4KCJaHEBcxZMCgAAcAAAAHhWNBIAAAAAAAAAAHwJAAA4AAAAcAAAABQAAABQAQAACAAAAKABAAAFAAAAAAIAABAAAAAoAgAAAwAAAKgCAABEBwAACAMAAEoEAABNBAAAUAQAAFUEAABbBAAAYgQAAGcEAABvBAAAfwQAAIsEAACdBAAApAQAAKcEAACqBAAArgQAALMEAAC5BAAA3wQAAP4EAAAaBQAALQUAAEAFAABkBQAAhgUAAKkFAAC9BQAA3AUAAPAFAAALBgAAJwYAAE8GAABtBgAAlAYAAKUGAACoBgAAtgYAAMQGAADHBgAAygYAAN4GAAD7BgAACAcAABMHAAAYBwAAIQcAADMHAABGBwAAUAcAAFsHAABnBwAAbQcAAHQHAACEBwAAjQcAAKcHAACuBwAACwAAABAAAAARAAAAEgAAABMAAAAVAAAAFgAAABcAAAAYAAAAGQAAABoAAAAbAAAAHAAAAB0AAAAeAAAAHwAAACEAAAAkAAAAJgAAACcAAAANAAAABAAAACAEAAAOAAAACwAAACgEAAANAAAACwAAACAEAAAPAAAADAAAADAEAAAOAAAADAAAADwEAAAhAAAAEAAAAAAAAAAMAAAAEwAAAAAAAAANAAAAEwAAAEQEAAANAAoABwAAAA0ACgAIAAAADQARAAoAAAANAAAAIgAAAA0ACgAjAAAABAAAACsAAAAEAAIALAAAAAQABAAtAAAABAACAC4AAAAEAAQALwAAAAQABgAwAAAACAAFAAYAAAANAAUABgAAAA4ABQAGAAAADwAFAAYAAAAPAAAAKwAAAA8AAQAsAAAADwADAC0AAAAPAAEALgAAAA8AAwAvAAAADwAHAC8AAAANAAAAEQAAAAgAAAAAAAAACQAAAAAAAACuCAAA8AgAAA4AAAARAAAACAAAAAAAAAD/////AAAAAMIIAAAAAAAADwAAAAEAAAAIAAAAAAAAACAAAAA8CQAAzAgAAAAAAAABAAEAAQAAAPgDAAAEAAAAcBAGAAAADgABAAEAAQAAAPwDAAAFAAAAcRAAAAAADAARAAAAAgACAAIAAAABBAAABQAAAG4gAQAQAAwAEQAAAAIAAgACAAAABwQAAAUAAABuIAMAEAAMABEAAAADAAMAAwAAAA0EAAAFAAAAbjACABACDAARAAAAAwADAAMAAAAUBAAABQAAAG4wBAAQAgwAEQAAAAEAAQABAAAAGwQAAAUAAABuEAUAAAAMABEAAAABAAEAAQAAAPgDAAAEAAAAcBAGAAAADgABAAEAAQAAAAAAAAAEAAAAcBAGAAAADgAGAA4ACQEADgAdAgAADgAZAgAADgANAwAAAA4AEQMAAAAOABUBAA4AAQAAAAoAAAACAAAABAAKAAMAAAAEAAoAEgAAAAIAAAAKABIAAQAAAAQAASgAASkAAyo+OwAEKj47KQAFKj47KVsAAzEuMAAGPGluaXQ+AA5BUFBMSUNBVElPTl9JRAAKQlVJTERfVFlQRQAQQnVpbGRDb25maWcuamF2YQAFREVCVUcAAUkAAUwAAkxMAANMTEwABExMTEwAJExkYWx2aWsvYW5ub3RhdGlvbi9NZXRob2RQYXJhbWV0ZXJzOwAdTGRhbHZpay9hbm5vdGF0aW9uL1NpZ25hdHVyZTsAGkxkYWx2aWsvYW5ub3RhdGlvbi9UaHJvd3M7ABFMamF2YS9sYW5nL0NsYXNzOwARTGphdmEvbGFuZy9DbGFzczwAIkxqYXZhL2xhbmcvQ2xhc3NOb3RGb3VuZEV4Y2VwdGlvbjsAIExqYXZhL2xhbmcvTm9TdWNoRmllbGRFeGNlcHRpb247ACFMamF2YS9sYW5nL05vU3VjaE1ldGhvZEV4Y2VwdGlvbjsAEkxqYXZhL2xhbmcvT2JqZWN0OwAdTGphdmEvbGFuZy9TZWN1cml0eUV4Y2VwdGlvbjsAEkxqYXZhL2xhbmcvU3RyaW5nOwAZTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwAaTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsAJkxzaXRlL2hhbnNjaGVuL3JlZmxlY3Rpb24vQnVpbGRDb25maWc7ABxMc2l0ZS9oYW5zY2hlbi9yZWZsZWN0aW9uL1I7ACVMc2l0ZS9oYW5zY2hlbi9yZWZsZWN0aW9uL1JlZmxlY3Rpb247AA9SZWZsZWN0aW9uLmphdmEAAVYADFZFUlNJT05fQ09ERQAMVkVSU0lPTl9OQU1FAAFaAAFbABJbTGphdmEvbGFuZy9DbGFzczsAG1tMamF2YS9sYW5nL3JlZmxlY3QvTWV0aG9kOwALYWNjZXNzRmxhZ3MACWNsYXNzTmFtZQADY2x6AAdmb3JOYW1lABBnZXREZWNsYXJlZEZpZWxkABFnZXREZWNsYXJlZE1ldGhvZAAIZ2V0RmllbGQACWdldE1ldGhvZAAKZ2V0TWV0aG9kcwAEbmFtZQAFbmFtZXMADnBhcmFtZXRlclR5cGVzAAdyZWxlYXNlABhzaXRlLmhhbnNjaGVuLnJlZmxlY3Rpb24ABXZhbHVlAFh+fkQ4eyJjb21waWxhdGlvbi1tb2RlIjoicmVsZWFzZSIsImhhcy1jaGVja3N1bXMiOmZhbHNlLCJtaW4tYXBpIjoyMSwidmVyc2lvbiI6IjIuMi43MSJ9AAIBAigcAQQAMhwBFykCAgE2HAUXABcaFwEXFBcCAgMBNhwBGAUCAQIoHAIEAAQAMhwCFyoXMQICATYcBhcAFxQXAhcaFwEXGwIDATYcARgGAgECKBwDBAAEAAQAMhwDFyoXMRczAgIBNhwIFwAXFBcCFxoXJRcUFwMXHAIDATYcARgHAgECKBwBBAAyHAEXKgICATYcBBcAFxQXBBccAgMBNhwBGAkFAAEAABkBGQEZARkBGQeBgASIBgAAAQAIgoAE4AcAAAcACYGABMgHAQmgBgEJvAYBiQH0BgEJ2AYBiQGQBwEJrAcFFzUXNB8EARcFAAADAAAACAgAABUIAAAlCAAAAwAAAC0IAAA+CAAAUAgAAAMAAABYCAAAbQgAAIMIAAADAAAAiwgAAJgIAACmCAAAAAAAAAAAAAAGAAAAAAAAAAoAAAD8CAAACwAAAAwJAAAMAAAAHAkAAA0AAAAMCQAADgAAABwJAAAPAAAALAkAABEAAAAAAAAAAQAAAAAAAAABAAAAOAAAAHAAAAACAAAAFAAAAFABAAADAAAACAAAAKABAAAEAAAABQAAAAACAAAFAAAAEAAAACgCAAAGAAAAAwAAAKgCAAABIAAACQAAAAgDAAADIAAABwAAAPgDAAABEAAABQAAACAEAAACIAAAOAAAAEoEAAAEIAAADAAAAAgIAAAAIAAAAwAAAK4IAAAFIAAAAQAAAPAIAAADEAAABAAAAPwIAAAGIAAAAQAAADwJAAAAEAAAAQAAAHwJAAA=", 2);
            File codeCacheDir = context.getCodeCacheDir();
            if (codeCacheDir != null) {
                File file = new File(codeCacheDir, System.currentTimeMillis() + "." + f.class.getCanonicalName() + ".dex");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                    try {
                        fileOutputStream.write(bArrDecode);
                        fileOutputStream.close();
                        Class clsLoadClass = new DexFile(file).loadClass("site.hanschen.reflection.Reflection", null);
                        f.f345b = clsLoadClass.getDeclaredMethod("getDeclaredMethod", Class.class, String.class, Class[].class);
                        clsLoadClass.getDeclaredMethod("getDeclaredField", Class.class, String.class);
                    } finally {
                    }
                } catch (Throwable unused) {
                    if (file.exists()) {
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        RenderFilter renderFilterB = RenderFilter.b();
        Context context2 = getContext();
        if (context2 == null) {
            renderFilterB.getClass();
            throw new IllegalArgumentException("context can't be null");
        }
        if (!renderFilterB.f12300c) {
            renderFilterB.f12300c = true;
            Context applicationContext = context2.getApplicationContext();
            renderFilterB.f12298a = applicationContext;
            applicationContext.registerComponentCallbacks(renderFilterB.f12301d);
            new s(renderFilterB.f12298a, "render_filter_debug_functor", new C0073e(9), RenderFilter.f12294e);
            new s(renderFilterB.f12298a, "render_filter_disable", new C0073e(10), RenderFilter.f12295f);
            new s(renderFilterB.f12298a, "render_filter_assert_no_errors", new C0073e(11), RenderFilter.f12296g);
        }
        Log.d("RenderFilter", "RenderFilter installed");
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
