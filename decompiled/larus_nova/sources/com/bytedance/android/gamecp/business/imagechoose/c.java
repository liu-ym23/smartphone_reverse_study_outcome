package com.bytedance.android.gamecp.business.imagechoose;

import android.view.View;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageChooseAdapter f56074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f56075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageChooseAdapter.ViewHolder f56076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f56077d;

    public c(ImageChooseAdapter r100, w r101, ImageChooseAdapter.ViewHolder r102, int r103) {
        this.f56074a = r100;
        this.f56075b = r101;
        this.f56076c = r102;
        this.f56077d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        w r101 = this.f56075b;
        if (r101.f51412b == false) goto L5;
        ImageChooseAdapter.A2(this.f56074a, r101);
    L6:
        Function1<? super LinkedList<w>, Unit> r102 = this.f56074a.f56015i;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOnSelectedImageChangeListener");
    L9:
        r102.invoke(this.f56074a.f56010d);
        return;
    L5:
        ImageChooseAdapter r103 = this.f56074a;
        ImageChooseAdapter.ViewHolder r104 = this.f56076c;
        int r105 = this.f56077d;
        int r106 = ImageChooseAdapter.f56006q;
        r103.z2(r101, r104, r105);
        goto L6
    }
}
