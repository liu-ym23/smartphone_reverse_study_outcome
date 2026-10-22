package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.downloadbtn;

import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.d;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a extends com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f55180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f55181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f55182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f55183f;

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55179b;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return this.f55183f;
    }

    public a(String r100, d r101, i r102, h r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        super(1);
        this.f55179b = r100;
        this.f55180c = r101;
        this.f55181d = r102;
        this.f55182e = r103;
        this.f55183f = r104;
    }
}
