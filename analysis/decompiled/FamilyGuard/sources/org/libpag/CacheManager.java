package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
class CacheManager {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f19114a = true;

    /* renamed from: b, reason: collision with root package name */
    static CacheManager f19115b;

    /* renamed from: c, reason: collision with root package name */
    private String f19116c;

    /* renamed from: d, reason: collision with root package name */
    Context f19117d;

    /* renamed from: e, reason: collision with root package name */
    HashMap<String, a> f19118e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, Integer> f19119f = new HashMap<>();

    private static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        protected long f19122a;

        /* renamed from: b, reason: collision with root package name */
        protected File f19123b;

        protected b(File file) {
            this.f19123b = file;
            this.f19122a = file.lastModified();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            long j5 = ((b) obj).f19122a;
            long j6 = this.f19122a;
            if (j6 < j5) {
                return -1;
            }
            return j6 == j5 ? 0 : 1;
        }
    }

    private CacheManager() {
    }

    static native int ContentVersion(PAGComposition pAGComposition);

    protected static CacheManager a(Context context) {
        CacheManager cacheManager = f19115b;
        if (cacheManager != null) {
            return cacheManager;
        }
        if (context == null) {
            return null;
        }
        synchronized (CacheManager.class) {
            try {
                CacheManager cacheManager2 = f19115b;
                if (cacheManager2 != null) {
                    return cacheManager2;
                }
                CacheManager cacheManager3 = new CacheManager();
                f19115b = cacheManager3;
                cacheManager3.f19117d = context.getApplicationContext();
                CacheManager cacheManager4 = f19115b;
                cacheManager4.f19116c = a(cacheManager4.f19117d, null);
                return f19115b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c(String str) {
        Integer num = this.f19119f.get(str);
        if (num == null) {
            num = 0;
        }
        this.f19119f.put(str, Integer.valueOf(num.intValue() + 1));
    }

    protected void b(String str) {
        synchronized (this) {
            try {
                Integer num = this.f19119f.get(str);
                if (num == null) {
                    return;
                }
                int iIntValue = num.intValue() - 1;
                Integer numValueOf = Integer.valueOf(iIntValue);
                if (iIntValue <= 0) {
                    this.f19119f.remove(str);
                    a aVar = this.f19118e.get(str);
                    if (aVar == null) {
                        return;
                    }
                    aVar.g();
                    aVar.e();
                    this.f19118e.remove(str);
                    aVar.h();
                } else {
                    this.f19119f.put(str, numValueOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private ImageCache f19120a;

        /* renamed from: b, reason: collision with root package name */
        ReentrantReadWriteLock f19121b = new ReentrantReadWriteLock();

        a() {
        }

        static a a(String str, int i5, int i6, int i7) {
            ImageCache imageCacheA = ImageCache.a(str, i5, i6, i7);
            if (imageCacheA == null) {
                return null;
            }
            a aVar = new a();
            aVar.f19120a = imageCacheA;
            return aVar;
        }

        protected boolean b(int i5, Bitmap bitmap) {
            g();
            boolean zB = this.f19120a.b(i5, bitmap);
            h();
            return zB;
        }

        protected void c() {
            this.f19121b.readLock().lock();
        }

        protected void d() {
            this.f19121b.readLock().unlock();
        }

        protected void e() {
            this.f19120a.release();
        }

        protected void f() {
            g();
            this.f19120a.releaseSaveBuffer();
            h();
        }

        protected void g() {
            this.f19121b.writeLock().lock();
        }

        protected void h() {
            this.f19121b.writeLock().unlock();
        }

        protected boolean a() {
            g();
            boolean zFlushSave = this.f19120a.flushSave();
            h();
            return zFlushSave;
        }

        protected boolean b() {
            c();
            boolean zIsAllCached = this.f19120a.isAllCached();
            d();
            return zIsAllCached;
        }

        protected boolean a(int i5, Bitmap bitmap) {
            c();
            boolean zA = this.f19120a.a(i5, bitmap);
            d();
            return zA;
        }

        protected boolean a(int i5) {
            c();
            boolean zIsCached = this.f19120a.isCached(i5);
            d();
            return zIsCached;
        }
    }

    private static class ImageCache {
        private long nativeContext;

        static {
            P4.a.a("pag");
            nativeInit();
        }

        private ImageCache(long j5) {
            this.nativeContext = j5;
        }

        private static native long SetupCache(String str, int i5, int i6, int i7, boolean z5);

        static ImageCache a(String str, int i5, int i6, int i7) {
            boolean z5;
            File file = new File(str);
            if (file.exists()) {
                z5 = false;
            } else {
                file.getParentFile().mkdirs();
                z5 = true;
            }
            long jSetupCache = SetupCache(str, i5, i6, i7, z5);
            if (jSetupCache != 0) {
                return new ImageCache(jSetupCache);
            }
            file.delete();
            return null;
        }

        private static native void nativeInit();

        boolean b(int i5, Bitmap bitmap) {
            if (bitmap == null) {
                return false;
            }
            return putBitmapToSaveBuffer(i5, bitmap, bitmap.getByteCount(), bitmap.getConfig() == Bitmap.Config.HARDWARE);
        }

        native boolean flushSave();

        native boolean inflateBitmap(int i5, Bitmap bitmap, int i6, boolean z5);

        native boolean isAllCached();

        native boolean isCached(int i5);

        native boolean putBitmapToSaveBuffer(int i5, Bitmap bitmap, int i6, boolean z5);

        native void release();

        native void releaseSaveBuffer();

        boolean a(int i5, Bitmap bitmap) {
            if (bitmap == null) {
                return false;
            }
            return inflateBitmap(i5, bitmap, bitmap.getByteCount(), bitmap.getConfig() == Bitmap.Config.HARDWARE);
        }
    }

    protected void a() {
        try {
            File[] fileArrListFiles = new File(this.f19116c).listFiles();
            if (fileArrListFiles.length == 0) {
                return;
            }
            int length = fileArrListFiles.length;
            b[] bVarArr = new b[length];
            long length2 = 0;
            long length3 = 0;
            for (int i5 = 0; i5 < fileArrListFiles.length; i5++) {
                length3 += fileArrListFiles[i5].length();
                bVarArr[i5] = new b(fileArrListFiles[i5]);
            }
            if (length3 < PAGImageView.f19145b) {
                return;
            }
            Arrays.sort(bVarArr);
            long j5 = (long) (PAGImageView.f19145b * 0.39999998f);
            for (int i6 = 0; i6 < length; i6++) {
                b bVar = bVarArr[i6];
                length2 += bVar.f19123b.length();
                bVar.f19123b.delete();
                if (length3 - length2 <= j5) {
                    return;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    protected a a(String str, int i5, int i6, int i7) {
        synchronized (this) {
            try {
                a aVarA = this.f19118e.get(str);
                if (aVarA != null) {
                    c(str);
                    return aVarA;
                }
                if (aVarA == null) {
                    aVarA = a.a(a(str), i5, i6, i7);
                }
                if (aVarA == null) {
                    return null;
                }
                this.f19118e.put(str, aVarA);
                c(str);
                return aVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected String a(String str) {
        return this.f19116c + File.separator + str;
    }

    private static String a(Context context, String str) {
        String path;
        if (TextUtils.isEmpty(str)) {
            str = "PAGImageViewCache";
        }
        if (f19114a) {
            str = str + "_Hardware";
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            path = context.getCacheDir().getPath();
        } else {
            path = context.getExternalCacheDir().getPath();
        }
        return path + File.separator + str;
    }
}
