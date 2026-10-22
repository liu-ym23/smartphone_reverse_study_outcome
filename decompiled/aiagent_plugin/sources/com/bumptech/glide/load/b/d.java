package com.bumptech.glide.load.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ByteBufferFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    private static final class a implements com.bumptech.glide.load.a.d<ByteBuffer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f3429a;

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        a(File r1) {
            this.f3429a = r1;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super ByteBuffer> r3) {
            com.bumptech.glide.load.a.d.a r4 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            r4.a(com.bumptech.glide.f.a.a(this.f3429a));
            return;
        L6:
            e = move-exception;
            if (a(d.TAG, 3) == false) goto L10;
            a(d.TAG, "Failed to obtain ByteBuffer for file", e);
        L10:
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    public static class b implements o<File, ByteBuffer> {
        public b() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<File, ByteBuffer> a(r r1) {
            return new d();
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1) {
        return true;
    }

    public d() {
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a<ByteBuffer> a(File r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(File r3) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<ByteBuffer> a2(File r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new a(r1));
    }
}
