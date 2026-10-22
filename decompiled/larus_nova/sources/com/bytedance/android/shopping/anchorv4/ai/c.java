package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f165642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f165643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f165644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f165645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f165646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f165647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<CommonMeta> f165648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<String> f165649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o0 f165650i;

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final String d() {
        String r100 = this.f165649h.invoke();
        if (r100 == null) goto L8;
        if ((!StringsKt.isBlank(r100)) == false) goto L8;
        return r100;
    L8:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final String getProductId() {
        CommonMeta r100 = this.f165648g.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProductId();
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final String b() {
        return this.f165647f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final View c() {
        return this.f165646e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final h0 e() {
        return this.f165642a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public FragmentActivity getActivity() {
        return this.f165643b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final FragmentManager getFragmentManager() {
        return this.f165644c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.d
    public final void a(int r100) {
        Intrinsics.checkNotNullParameter("pdp_ai_chat", "source");
        this.f165650i.a(r100);
    }

    public c(FragmentActivity r100, FragmentManager r101, ViewGroup r102, View r103, String r104, Function0 r105, Function0 r106, com.bytedance.android.shopping.anchorv4.containers.page.b r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r105, "commonMetaProvider");
        Intrinsics.checkNotNullParameter(r106, "mcpDataProvider");
        Intrinsics.checkNotNullParameter(r107, "bottomOverlayInsetHandler");
        this.f165643b = r100;
        this.f165644c = r101;
        this.f165645d = r102;
        this.f165646e = r103;
        this.f165647f = r104;
        this.f165648g = r105;
        this.f165649h = r106;
        this.f165650i = r107;
        this.f165642a = new h0(getActivity(), new b(this), new b0());
    }
}
