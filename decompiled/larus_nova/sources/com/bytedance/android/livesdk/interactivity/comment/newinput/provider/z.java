package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f136023a;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    public z() {
        this.f136023a = InputSectionType.EMPTY;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f136023a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L6;
        return null;
    L6:
        return LayoutInflater.from(r101).inflate(R.layout.ttlive_view_input_empty, null);
    }
}
