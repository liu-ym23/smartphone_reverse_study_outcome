package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;
import com.baidu.platform.comapi.util.EglConfigUtils;

/* loaded from: classes.dex */
public class s {

    public enum a {
        OPENGL_ES,
        VULKAN,
        AUTO
    }

    public static r a(SurfaceView surfaceView, a aVar, boolean z4, Context context) {
        int i4;
        int i5;
        e eVar = new e(surfaceView);
        eVar.a(3);
        if (z4) {
            i4 = 4;
            i5 = 1;
        } else {
            i5 = 0;
            i4 = 0;
        }
        try {
            if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 8, i5, i4)) {
                eVar.a(8, 8, 8, 8, 24, 8, i5, i4);
            } else {
                eVar.a(true);
            }
        } catch (IllegalArgumentException unused) {
            eVar.a(true);
        }
        eVar.b(true);
        return eVar;
    }
}
