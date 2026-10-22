package com.bumptech.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ResourceDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements k<Uri, Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3779a;

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<Drawable> a(Uri r3, int r4, int r5, i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(Uri r3, i r4) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4);
    }

    public d(Context r3) {
        this.f3779a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1, i r2) {
        return r1.getScheme().equals("android.resource");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public v<Drawable> a2(Uri r1, int r2, int r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(r1, r1.getAuthority()), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r6 = a(r5, r1);
        return c.a(a.a(this.f3779a, r5, r6));
    }

    private Context a(Uri r4, String r5) {
        if (r5.equals(this.f3779a.getPackageName()) == true) goto L5;
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f3779a.createPackageContext(r5, 0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L8:
        e = move-exception;
        if (r5.contains(this.f3779a.getPackageName()) == false) goto L14;
        return this.f3779a;
    L14:
        throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + r4, e);
    L5:
        return this.f3779a;
    }

    private int a(Context r4, Uri r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        List<String> r0 = r5.getPathSegments();
        if (r0.size() != 2) goto L7;
        return b(r6, r5);
    L7:
        if (r0.size() != 1) goto L11;
        return a(r5);
    L11:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r5);
    }

    private int b(Context r5, Uri r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List<String> r7 = r6.getPathSegments();
        String r1 = r6.getAuthority();
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.aiagent.plugin");
        int r9 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"), r8, r2, r1, "com.obric.aiagent.plugin");
        if (r9 != 0) goto L5;
        r9 = ZeusTransformUtils.getIdentifier(Resources.getSystem(), r8, r2, "android", "com.obric.aiagent.plugin");
    L5:
        if (r9 == 0) goto L8;
        return r9;
    L8:
        throw new IllegalArgumentException("Failed to find resource id for: " + r6);
    }

    private int a(Uri r4) {
        return Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r4.getPathSegments().get(0), String.class, "com.obric.aiagent.plugin"));
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Unrecognized Uri format: " + r4, e);
    }
}
