package com.bytedance.android.shopping.api.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f170664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f170665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CodecType f170666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f170667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f170668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f170669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f170670g;

    public final b b() {
        String r100 = this.f170664a;
        if (r100 == null) goto L22;
        String r101 = this.f170665b;
        if (r101 == null) goto L22;
        List r102 = this.f170667d;
        if (r102 == null) goto L22;
        if (r100 != null) goto L12;
        String r103 = "";
    L13:
        if (r101 != null) goto L15;
        String r104 = "";
    L16:
        CodecType r105 = this.f170666c;
        if (r102 != null) goto L21;
        r102 = CollectionsKt.emptyList();
    L21:
        return new b(r103, r104, 0, r105, r102, this.f170668e, (int) this.f170669f, this.f170670g, 0);
    L15:
        r104 = r101;
        goto L16
    L12:
        r103 = r100;
    L22:
        Objects.toString(this.f170667d);
        return null;
    }

    public k() {
        this.f170666c = CodecType.CODEC_TYPE_264;
        this.f170670g = "";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (this.f170667d != null) goto L6;
        this.f170667d = new ArrayList();
    L6:
        if (r100.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        ArrayList<String> r102 = this.f170667d;
        if (r102 == null) goto L15;
        r102.add(r100);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r101 = false;
        goto L9
    }
}
