package com.bumptech.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: StringLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f3495a;

    /* JADX INFO: compiled from: StringLoader.java */
    public static final class a implements o<String, AssetFileDescriptor> {
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<String, AssetFileDescriptor> a(r r3) {
            return new u(r3.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class b implements o<String, ParcelFileDescriptor> {
        public b() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<String, ParcelFileDescriptor> a(r r3) {
            return new u(r3.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class c implements o<String, InputStream> {
        public c() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<String, InputStream> a(r r3) {
            return new u(r3.a(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(String r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(String r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(String r3) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public u(n<Uri, Data> r3) {
        this.f3495a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(String r2, int r3, int r4, com.bumptech.glide.load.i r5) {
        Uri r6 = b(r2);
        if (r6 != null) goto L5;
        return null;
    L5:
        if (this.f3495a.a(r6) == true) goto L8;
        return null;
    L8:
        return this.f3495a.a(r6, r3, r4, r5);
    }

    private static Uri b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        if (r2.charAt(0) == '/') goto L14;
        Uri r0 = Uri.parse(r2);
        if (r0.getScheme() != null) goto L13;
        return c(r2);
    L13:
        return r0;
    L14:
        return c(r2);
    }

    private static Uri c(String r1) {
        return Uri.fromFile(new File(r1));
    }
}
