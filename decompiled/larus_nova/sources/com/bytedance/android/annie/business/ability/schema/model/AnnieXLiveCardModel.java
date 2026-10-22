package com.bytedance.android.annie.business.ability.schema.model;

import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public class AnnieXLiveCardModel implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f38873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f38874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f38875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y36.a f38876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f38877e;

    public final String b() {
        Uri r100 = this.f38875c;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String c() {
        p r100 = this.f38873a;
        if (r100 == null) goto L6;
        String r101 = (String) r100.f565862b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public AnnieXLiveCardModel() {
        this.f38877e = LazyKt.lazy(new AnnieXLiveCardModel$noQueryUrlWithID$2(this));
    }

    @Override // t36.f
    public void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        this.f38873a = new p(r100, "annie_x_url", null);
        this.f38874b = new p(r100, "error_page_theme", null);
        this.f38875c = r100.getOriginUrl();
        Boolean r101 = Boolean.FALSE;
        new y36.a(r100, "_close_after_open_success", r101);
        new p(r100, "is_out_url", "");
        this.f38876d = new y36.a(r100, "screen_size_adaptation", r101);
    }
}
