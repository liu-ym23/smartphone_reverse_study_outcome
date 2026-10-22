package com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f<Data> implements n<File, Data> {
    private static final String TAG = "FileLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<Data> f3436a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<Data> f3437a;

        public a(d<Data> r3) {
            this.f3437a = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.load.b.o
        public final n<File, Data> a(r r1) {
            return new f(this.f3437a);
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new AnonymousClass1());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f3438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<Data> f3439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f3440c;

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        c(File r3, d<Data> r4) {
            d<Data> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f3438a = r3;
            this.f3439b = r5;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super Data> r3) {
            com.bumptech.glide.load.a.d.a r4 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            Data r5 = this.f3439b.b(this.f3438a);     // Catch: FileNotFoundException -> L6
            this.f3440c = r5;     // Catch: FileNotFoundException -> L6
            r4.a(r5);
            return;
        L6:
            e = move-exception;
            if (a(f.TAG, 3) == false) goto L10;
            a(f.TAG, "Failed to open file", e);
        L10:
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            Data r0 = this.f3440c;
            if (r0 == null) goto L9;
            this.f3439b.a(r0);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f3439b.a();
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean a(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        void a(Data r1);

        Data b(File r1);
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {
        public e() {
            super(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(File r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(File r3) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"));
    }

    public f(d<Data> r3) {
        this.f3436a = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(File r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new c(r1, this.f3436a));
    }
}
