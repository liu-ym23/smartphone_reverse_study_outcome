package com.bytedance.android.gamecp.business.gamedetail.component;

import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class c extends com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.d f53851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f53852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f53853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f53854g;

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53849b;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return this.f53850c;
    }

    public c(String r100, int r101, com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.d r102, i r103, h r104, Float r105) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        super(1);
        this.f53849b = r100;
        this.f53850c = r101;
        this.f53851d = r102;
        this.f53852e = r103;
        this.f53853f = r104;
        this.f53854g = r105;
    }
}
