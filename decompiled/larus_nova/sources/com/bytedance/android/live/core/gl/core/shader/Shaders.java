package com.bytedance.android.live.core.gl.core.shader;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/gl/core/shader/Shaders;", "", "Lcom/bytedance/android/live/core/gl/core/shader/a;", "createShader", "DEFAULT_TEXTURE_SHADER", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract enum Shaders extends Enum<Shaders> {
    public static final Shaders DEFAULT_TEXTURE_SHADER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Shaders[] f64811a = null;

    static {
        final String r100 = "DEFAULT_TEXTURE_SHADER";
        final int r101 = 0;
        Shaders r102 = new DEFAULT_TEXTURE_SHADER(r100, r101);
        DEFAULT_TEXTURE_SHADER = r102;
        f64811a = new Shaders[]{r102};
    }

    public Shaders() {
        throw null;
    }

    public static Shaders valueOf(String r100) {
        return (Shaders) r27.a.a(Shaders.class, r100);
    }

    public static Shaders[] values() {
        return (Shaders[]) f64811a.clone();
    }

    public abstract a createShader();

    public Shaders(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
