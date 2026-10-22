package com.bumptech.glide.load.engine;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<DataType> f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.k<DataType, ResourceType>> f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> f3672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.util.f.a<List<Throwable>> f3673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f3674e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        v<ResourceType> a(v<ResourceType> r1);
    }

    public i(Class<DataType> r3, Class<ResourceType> r4, Class<Transcode> r5, List<? extends com.bumptech.glide.load.k<DataType, ResourceType>> r6, com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> r7, androidx.core.util.f.a<List<Throwable>> r8) {
        List<? extends com.bumptech.glide.load.k<DataType, ResourceType>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.resource.d.e<ResourceType, Transcode> r10 = (com.bumptech.glide.load.resource.d.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.resource.d.e.class, "com.obric.aiagent.plugin");
        androidx.core.util.f.a<List<Throwable>> r11 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r8, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3670a = r3;
        this.f3671b = r9;
        this.f3672c = r10;
        this.f3673d = r11;
        this.f3674e = "Failed DecodePath{" + r3.getSimpleName() + "->" + r4.getSimpleName() + "->" + r5.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.a.e<DataType> r3, int r4, int r5, com.bumptech.glide.load.i r6, a<ResourceType> r7) {
        com.bumptech.glide.load.a.e<DataType> r8 = (com.bumptech.glide.load.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.e.class, "com.obric.aiagent.plugin");
        v<ResourceType> r9 = ((a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin")).a(a(r8, r4, r5, r6));
        return this.f3672c.a(r9, r6);
    }

    private v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> r9, int r10, int r11, com.bumptech.glide.load.i r12) {
        com.bumptech.glide.load.a.e<DataType> r3 = (com.bumptech.glide.load.a.e) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.a.e.class, "com.obric.aiagent.plugin");
        List<Throwable> r13 = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3673d.a()), List.class, "com.obric.aiagent.plugin");
        v<ResourceType> r14 = a(r3, r10, r11, r12, r13);     // Catch: Throwable -> L6
        this.f3673d.a(r13);
        return r14;
    L6:
        th = move-exception;
        this.f3673d.a(r13);
        throw th;
    }

    private v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> r10, int r11, int r12, com.bumptech.glide.load.i r13, List<Throwable> r14) {
        com.bumptech.glide.load.a.e r15 = (com.bumptech.glide.load.a.e) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.a.e.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        int r0 = this.f3671b.size();
        v<ResourceType> r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        com.bumptech.glide.load.k r4 = (com.bumptech.glide.load.k) ZeusTransformUtils.preCheckCast(this.f3671b.get(r3), com.bumptech.glide.load.k.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        if (a(TAG, 2) == false) goto L13;
        a(TAG, "Failed to decode data for " + r4, e);
    L13:
        r16.add(e);
    L14:
        if (r2 != null) goto L17;
        r3 = r3 + 1;
        goto L3
    L6:
        if (r4.a(r15.a(), r13) == false) goto L14;
        r2 = r4.a(r15.a(), r11, r12, r13);     // Catch: Throwable -> L9
    L17:
        if (r2 == null) goto L20;
        return r2;
    L20:
        throw new q(this.f3674e, new ArrayList(r16));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f3670a + ", decoders=" + this.f3671b + ", transcoder=" + this.f3672c + '}';
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
        return Log.v(r1, r2, r3);
    }
}
