package com.bumptech.glide.load.b;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f3499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<Data> f3500b;

    /* JADX INFO: compiled from: UriLoader.java */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f3501a;

        public a(ContentResolver r1) {
            this.f3501a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, AssetFileDescriptor> a(r r1) {
            return new w(this);
        }

        @Override // com.bumptech.glide.load.b.w.c
        public com.bumptech.glide.load.a.d<AssetFileDescriptor> a(Uri r2) {
            return new com.bumptech.glide.load.a.a(this.f3501a, r2);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f3502a;

        public b(ContentResolver r1) {
            this.f3502a = r1;
        }

        @Override // com.bumptech.glide.load.b.w.c
        public com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(Uri r2) {
            return new com.bumptech.glide.load.a.i(this.f3502a, r2);
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, ParcelFileDescriptor> a(r r1) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> a(Uri r1);
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f3503a;

        public d(ContentResolver r1) {
            this.f3503a = r1;
        }

        @Override // com.bumptech.glide.load.b.w.c
        public com.bumptech.glide.load.a.d<InputStream> a(Uri r2) {
            return new com.bumptech.glide.load.a.o(this.f3503a, r2);
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, InputStream> a(r r1) {
            return new w(this);
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    static {
        f3499a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));
    }

    public w(c<Data> r3) {
        this.f3500b = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(Uri r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), this.f3500b.a(r1));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return f3499a.contains(r1.getScheme());
    }
}
