package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: classes8.dex */
public final class LynxAirDSLProcess$realLoad$lynxClient$1 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f122857a;

    public LynxAirDSLProcess$realLoad$lynxClient$1(q r100) {
        this.f122857a = r100;
    }

    @Override // com.lynx.tasm.q1
    public final void onTemplateBundleReady(TemplateBundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        cu1.a r101 = cu1.a.f465417b;
        q r102 = this.f122857a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        boolean r103 = true;
        if (r102.f569039c.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L13:
        r101.b().put(r102, r100);
    L14:
        m.f123003h.d(new LynxAirDSLProcess$realLoad$lynxClient$1$onTemplateBundleReady$1(this));
        return;
    L8:
        if (r102.f569038b.length() == 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
    L5:
        r104 = false;
        goto L6
    }
}
