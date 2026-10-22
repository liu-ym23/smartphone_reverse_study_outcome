package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import com.bytedance.android.gamecp.business.gamedetail.base.model.GroupJoinStatus;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GroupJoinStatus f54327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f54330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f54331e;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public k(GroupJoinStatus r100, String r101, String r102, Long r103, List<g> r104) {
        Intrinsics.checkNotNullParameter(r100, "curStatus");
        this.f54327a = r100;
        this.f54328b = r101;
        this.f54329c = r102;
        this.f54330d = r103;
        this.f54331e = r104;
    }
}
