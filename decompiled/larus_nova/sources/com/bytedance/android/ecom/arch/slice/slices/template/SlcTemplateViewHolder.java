package com.bytedance.android.ecom.arch.slice.slices.template;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.f;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/slices/template/SlcTemplateViewHolder;", "Lcom/bytedance/android/ecom/arch/slice/slices/SlcBaseViewHolder;", "Lcom/bytedance/android/ecom/arch/slice/slices/template/d;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcTemplateViewHolder extends SlcBaseViewHolder<d> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f51044g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f51045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SlcContext f51047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f51048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SlcTemplateView f51049f;

    @Override // com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder
    public final void Z3() {
        this.f51045b = null;
    }

    public final void d4() {
        if (this.f51049f.isInLayout() == false) goto L5;
        h.c(new SlcTemplateViewHolder$bindVHStyle$1(this));
        return;
    L5:
        g r100 = this.f51026a;
        if (r100 == null) goto L10;
        T3(r100, null);
        this.f51049f.forceLayout();
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder
    public final f V3() {
        return this.f51048e;
    }

    @Override // com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder
    public final SlcContext W3() {
        return this.f51047d;
    }

    @Override // com.bytedance.android.ecom.arch.slice.slices.a
    public final View s0() {
        return this.f51049f;
    }

    @Override // com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder
    public final void Y3(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "slice");
        if ((r100 instanceof d) == true) goto L6;
        nq.a.c(null, new SlcTemplateViewHolder$onBindSlice$1(r100), 1);
        return;
    L6:
        d r101 = (d) r100;
        if (r101.b() != null) goto L11;
        nq.a.c(null, new SlcTemplateViewHolder$onBindSlice$2(r100), 1);
        return;
    L11:
        if (this.f51049f.f51042d == true) goto L13;
        this.f51045b = new a(this);
        r r102 = this.f51047d.c(r101.c(), this.f51045b);
        this.f51049f.b(this.f51047d, r102);
        this.f51049f.setActionHandler(new b(this, r101));
        c4(r101);
        return;
    L13:
        c4(r101);
        if (this.f51046c == false) goto L18;
        d4();
        return;
    }

    public final void c4(d r100) {
        Map<String, Object> r101 = r100.getData();
        HashMap r102 = null;
        if ((r101 instanceof HashMap) == true) goto L5;
        r101 = null;
    L5:
        HashMap r103 = (HashMap) r101;
        if (r103 == null) goto L9;
        Object r104 = r103.clone();
        if (r104 == null) goto L9;
    L11:
        if ((r104 instanceof HashMap) == true) goto L13;
        r104 = null;
    L13:
        HashMap r105 = (HashMap) r104;
        if (r105 == null) goto L16;
        r105.put("global", this.f51047d.f49960u0);
        r102 = r105;
    L16:
        Map<String, ? extends Object> r106 = SliceRender.a(r102);
        SlcTemplateView r107 = this.f51049f;
        String r108 = r100.getSliceId();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "dataCtx");
        r r109 = r107.f51041c;
        if (r109 == null) goto L20;
        r109.a(r106, r108);
        return;
    L20:
        return;
    L9:
        r104 = new HashMap();
        goto L11
    }

    public SlcTemplateViewHolder(SlcContext r100, f r101) {
        SlcTemplateView r102 = new SlcTemplateView(r100.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r100, "slcContext");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "slcView");
        super(r102);
        this.f51047d = r100;
        this.f51048e = r101;
        this.f51049f = r102;
    }
}
