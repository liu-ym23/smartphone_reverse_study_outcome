package com.bumptech.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ResourceLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {
    private static final String TAG = "ResourceLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f3488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f3489b;

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f3490a;

        public a(Resources r1) {
            this.f3490a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Integer, AssetFileDescriptor> a(r r4) {
            return new s(this.f3490a, r4.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f3491a;

        public b(Resources r1) {
            this.f3491a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Integer, ParcelFileDescriptor> a(r r4) {
            return new s(this.f3491a, r4.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class c implements o<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f3492a;

        public c(Resources r1) {
            this.f3492a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Integer, InputStream> a(r r4) {
            return new s(this.f3492a, r4.a(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class d implements o<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f3493a;

        public d(Resources r1) {
            this.f3493a = r1;
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Integer, Uri> a(r r2) {
            return new s(this.f3493a, v.a());
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Integer r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(Integer r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Integer r3) {
        return a2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.aiagent.plugin"));
    }

    public s(Resources r3, n<Uri, Data> r4) {
        n<Uri, Data> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        this.f3489b = r3;
        this.f3488a = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(Integer r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        Uri r5 = b(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        return this.f3488a.a(r5, r2, r3, r4);
    }

    private Uri b(Integer r5) {
        return Uri.parse("android.resource://" + this.f3489b.getResourcePackageName(r5.intValue()) + '/' + this.f3489b.getResourceTypeName(r5.intValue()) + '/' + this.f3489b.getResourceEntryName(r5.intValue()));
    L4:
        e = move-exception;
        if (a(TAG, 5) == false) goto L12;
        a(TAG, "Received invalid resource id: " + r5, e);
        return null;
    L12:
        return null;
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
        return Log.w(r1, r2, r3);
    }
}
