package com.google.android.material.g;

import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f13406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0276a f13407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13408c;

    /* JADX INFO: renamed from: com.google.android.material.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0276a {
        void a(Typeface r1);
    }

    public a(InterfaceC0276a r3, Typeface r4) {
        InterfaceC0276a r5 = (InterfaceC0276a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0276a.class, "com.obric.aiagent.plugin");
        this.f13406a = r4;
        this.f13407b = r5;
    }

    @Override // com.google.android.material.g.f
    public void a(Typeface r1, boolean r2) {
        a(r1);
    }

    @Override // com.google.android.material.g.f
    public void a(int r1) {
        a(this.f13406a);
    }

    public void a() {
        this.f13408c = true;
    }

    private void a(Typeface r2) {
        if (this.f13408c == true) goto L6;
        this.f13407b.a(r2);
        return;
    }
}
