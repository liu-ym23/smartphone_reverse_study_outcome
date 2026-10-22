package com.bumptech.glide.load.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3455a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f3456a;

        public a(Context r3) {
            this.f3456a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, File> a(r r1) {
            return new k(this.f3456a);
        }
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.a.d<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f3457a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f3458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f3459c;

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        static {
            f3457a = new String[]{"_data"};
        }

        b(Context r3, Uri r4) {
            this.f3458b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f3459c = r4;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r8, com.bumptech.glide.load.a.d.a<? super File> r9) {
            com.bumptech.glide.load.a.d.a r10 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            Cursor r11 = ZeusProviderTransform.query(this.f3458b.getContentResolver(), this.f3459c, f3457a, null, null, null, "com.obric.aiagent.plugin");
            String r0 = null;
            if (r11 == null) goto L12;
        L8:
            th = move-exception;
            r11.close();
            throw th;
        L5:
            if (r11.moveToFirst() == false) goto L7;
            r0 = r11.getString(r11.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L8
        L7:
            r11.close();
        L12:
            if (TextUtils.isEmpty(r0) == false) goto L14;
            r10.a(new FileNotFoundException("Failed to find file path for: " + this.f3459c));
            return;
        L14:
            r10.a(new File(r0));
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a<File> a(Uri r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    public k(Context r3) {
        this.f3455a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<File> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new b(this.f3455a, r1));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return com.bumptech.glide.load.a.a.b.a(r1);
    }
}
