package com.mdisdk.gles;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import h6.C1490b;
import h6.RunnableC1489a;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2999a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f2999a = i;
        this.b = obj;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        int i = this.f2999a;
        Object obj = this.b;
        switch (i) {
            case 0:
                TextureInput.setup$lambda$0((TextureInput) obj, surfaceTexture);
                return;
            default:
                C1490b c1490b = (C1490b) obj;
                Handler handler = c1490b.d;
                if (handler != null) {
                    handler.post(new RunnableC1489a(c1490b, 2));
                    return;
                } else {
                    k.n("handler");
                    throw null;
                }
        }
    }
}
