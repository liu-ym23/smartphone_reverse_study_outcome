package com.bumptech.glide.load.b;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3398a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f3399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0087a<Data> f3400c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0087a<Data> {
        com.bumptech.glide.load.a.d<Data> a(AssetManager r1, String r2);
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements InterfaceC0087a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f3401a;

        public b(AssetManager r1) {
            this.f3401a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, ParcelFileDescriptor> a(r r2) {
            return new a(this.f3401a, this);
        }

        @Override // com.bumptech.glide.load.b.a.InterfaceC0087a
        public com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(AssetManager r1, String r2) {
            return new com.bumptech.glide.load.a.h(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements InterfaceC0087a<InputStream>, o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f3402a;

        public c(AssetManager r1) {
            this.f3402a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, InputStream> a(r r2) {
            return new a(this.f3402a, this);
        }

        @Override // com.bumptech.glide.load.b.a.InterfaceC0087a
        public com.bumptech.glide.load.a.d<InputStream> a(AssetManager r1, String r2) {
            return new com.bumptech.glide.load.a.n(r1, r2);
        }
    }

    static {
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    public a(AssetManager r3, InterfaceC0087a<Data> r4) {
        InterfaceC0087a<Data> r5 = (InterfaceC0087a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0087a.class, "com.obric.aiagent.plugin");
        this.f3399b = r3;
        this.f3400c = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        String r5 = r1.toString().substring(f3398a);
        return new n.a(new com.bumptech.glide.e.d(r1), this.f3400c.a(this.f3399b, r5));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r2) {
        if ("file".equals(r2.getScheme()) == true) goto L5;
        return false;
    L5:
        if (r2.getPathSegments().isEmpty() == false) goto L7;
        return false;
    L7:
        if ("android_asset".equals(r2.getPathSegments().get(0)) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
