package com.android.ttcjpaysdk.base.framework.container.abs;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "", "(Ljava/lang/String;I)V", "isDark", "", MediaScene.SYSTEM, "LIGHT", "DARK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Theme extends Enum<Theme> {
    private static final /* synthetic */ Theme[] $VALUES = null;
    public static final Theme DARK = null;
    public static final Theme LIGHT = null;
    public static final Theme SYSTEM = null;

    private static final /* synthetic */ Theme[] $values() {
        return new Theme[]{SYSTEM, LIGHT, DARK};
    }

    public static Theme valueOf(String r100) {
        return (Theme) a.a(Theme.class, r100);
    }

    public static Theme[] values() {
        return (Theme[]) $VALUES.clone();
    }

    static {
        SYSTEM = new Theme(MediaScene.SYSTEM, 0);
        LIGHT = new Theme("LIGHT", 1);
        DARK = new Theme("DARK", 2);
        $VALUES = $values();
    }

    public final boolean isDark() {
        if (this != DARK) goto L5;
        return true;
    L5:
        return false;
    }

    private Theme(String r100, int r101) {
        super(r100, r101);
    }
}
