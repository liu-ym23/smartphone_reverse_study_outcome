package com.bytedance.android.livesdk.room.external;

import android.graphics.Typeface;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.behavior.shadow.text.g;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f157639a = null;

    static {
        f157639a = new c();
    }

    public c() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.g.b
    public final Typeface a(String r100, int r101) {
        File r102 = d.f157640a;
        File r103 = d.f157640a;
        if (Intrinsics.areEqual("FZMoDengTiJF", r100) == false) goto L19;
        if (r103 != null) goto L6;
        return null;
    L6:
        if (r103.exists() != true) goto L26;
        if (TypeFaceOptimizer.getSwitch() == false) goto L18;
        String r104 = r103.getPath();     // Catch: Exception -> L21
        if (r104 == null) goto L18;
        if (TypeFaceLancet.cache.contains(r104) == true) goto L23;
        Typeface r105 = Typeface.createFromFile(r103);     // Catch: Exception -> L21
        if (r105 == null) goto L18;
        TypeFaceLancet.cache.put(r104, r105);     // Catch: Exception -> L21
        return r105;
    L23:
        return (Typeface) TypeFaceLancet.cache.get(r104);
    L18:
        return Typeface.createFromFile(r103);
    L27:
        return null;
    L26:
        return null;
    L19:
        return null;
    }
}
