package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: QMediaStoreUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<DataT> implements n<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f3413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f3414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<DataT> f3415d;

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f3416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<DataT> f3417b;

        a(Context r3, Class<DataT> r4) {
            this.f3416a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f3417b = r4;
        }

        @Override // com.bumptech.glide.load.b.o
        public final n<Uri, DataT> a(r r6) {
            return new e(this.f3416a, r6.a(File.class, this.f3417b), r6.a(Uri.class, this.f3417b), this.f3417b);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    public static final class c extends a<InputStream> {
        public c(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), InputStream.class);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static final class d<DataT> implements com.bumptech.glide.load.a.d<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f3418a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f3419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n<File, DataT> f3420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final n<Uri, DataT> f3421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Uri f3422e;
        private final int f;
        private final int g;
        private final i h;
        private final Class<DataT> i;
        private volatile boolean j;
        private volatile com.bumptech.glide.load.a.d<DataT> k;

        static {
            f3418a = new String[]{"_data"};
        }

        d(Context r3, n<File, DataT> r4, n<Uri, DataT> r5, Uri r6, int r7, int r8, i r9, Class<DataT> r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            n<File, DataT> r12 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            n<Uri, DataT> r13 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
            this.f3419b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f3420c = r12;
            this.f3421d = r13;
            this.f3422e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r3, com.bumptech.glide.load.a.d.a<? super DataT> r4) {
            com.bumptech.glide.load.a.d.a<? super DataT> r5 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.a.d<DataT> r0 = e();     // Catch: FileNotFoundException -> L12
            if (r0 != null) goto L7;
            r5.a(new IllegalArgumentException("Failed to build fetcher for: " + this.f3422e));     // Catch: FileNotFoundException -> L12
            return;
        L7:
            this.k = r0;     // Catch: FileNotFoundException -> L12
            if (this.j == false) goto L10;
            c();     // Catch: FileNotFoundException -> L12
            return;
        L10:
            r0.a(r3, r5);     // Catch: FileNotFoundException -> L12
            return;
        L12:
            e = move-exception;
            r5.a(e);
        }

        private com.bumptech.glide.load.a.d<DataT> e() {
            n.a<DataT> r0 = f();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f3468c;
        }

        private n.a<DataT> f() {
            if (Environment.isExternalStorageLegacy() == false) goto L7;
            return this.f3420c.a(a(this.f3422e), this.f, this.g, this.h);
        L7:
            if (g() == false) goto L9;
            Uri r0 = MediaStore.setRequireOriginal(this.f3422e);
        L11:
            return this.f3421d.a(r0, this.f, this.g, this.h);
        L9:
            r0 = this.f3422e;
            goto L11
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            com.bumptech.glide.load.a.d<DataT> r0 = this.k;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
            this.j = true;
            com.bumptech.glide.load.a.d<DataT> r1 = this.k;
            if (r1 == null) goto L6;
            r1.c();
            return;
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<DataT> a() {
            return this.i;
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }

        private File a(Uri r9) {
            Cursor r0 = null;
            Cursor r1 = ZeusProviderTransform.query(this.f3419b.getContentResolver(), r9, f3418a, null, null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            if (r1 == null) goto L16;
            if (r1.moveToFirst() == false) goto L16;
            String r8 = r1.getString(r1.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r8) == true) goto L14;
            File r10 = new File(r8);     // Catch: Throwable -> L17
            if (r1 == null) goto L12;
            r1.close();
        L12:
            return r10;
        L14:
            throw new FileNotFoundException("File path was empty in media store for: " + r9);     // Catch: Throwable -> L17
        L16:
            throw new FileNotFoundException("Failed to media store entry for: " + r9);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            if (0 == 0) goto L20;
            r0.close();
        L20:
            throw th;
        }

        private boolean g() {
            if (this.f3419b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(Uri r3, int r4, int r5, i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    e(Context r3, n<File, DataT> r4, n<Uri, DataT> r5, Class<DataT> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        n<File, DataT> r8 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        n<Uri, DataT> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
        this.f3412a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f3413b = r8;
        this.f3414c = r9;
        this.f3415d = r6;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<DataT> a2(Uri r14, int r15, int r16, i r17) {
        return new n.a(new com.bumptech.glide.e.d(r14), new d(this.f3412a, this.f3413b, this.f3414c, r14, r15, r16, r17, this.f3415d));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.a.a.b.a(r2) == false) goto L7;
        return true;
    }
}
