package com.bytedance.android.gamecp.business.comment.adapter;

import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements bv.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListAdapter f51997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f51998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f51999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f52000d;

    @Override // bv.a
    public final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == false) goto L6;
        CommentReplyListAdapter.z2(this.f51997a, r100, "cancel", String.valueOf(this.f51999c), this.f52000d.toString());
        return;
    }

    public k(CommentReplyListAdapter r100, ArrayList r101, String r102, String r103) {
        this.f51997a = r100;
        this.f51998b = r101;
        this.f51999c = r102;
        this.f52000d = r103;
    }
}
