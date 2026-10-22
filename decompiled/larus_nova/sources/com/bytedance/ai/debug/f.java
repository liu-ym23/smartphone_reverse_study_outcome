package com.bytedance.ai.debug;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36213a = null;

    public static final class a implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f36214b = null;

        static {
            f36214b = new a();
        }

        public a() {
        }

        public final void a(View r100, boolean r101) {
            IAISDKDebugService.f36186a.getClass();
            IAISDKDebugService r102 = IAISDKDebugService.Companion.f36188c;
            if ((r102 instanceof IAISDKDebugService.b) == false) goto L5;
            IAISDKDebugService.b r103 = (IAISDKDebugService.b) r102;
        L6:
            if (r103 == null) goto L9;
            r103.t(r100, r101);
            return;
        L9:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        f36213a = a.f36214b;
    }
}
