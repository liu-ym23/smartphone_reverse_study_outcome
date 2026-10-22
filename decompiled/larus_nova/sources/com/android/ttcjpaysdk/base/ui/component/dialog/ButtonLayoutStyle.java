package com.android.ttcjpaysdk.base.ui.component.dialog;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/dialog/ButtonLayoutStyle;", "", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ButtonLayoutStyle extends Enum<ButtonLayoutStyle> {
    private static final /* synthetic */ ButtonLayoutStyle[] $VALUES = null;
    public static final ButtonLayoutStyle HORIZONTAL = null;
    public static final ButtonLayoutStyle VERTICAL = null;

    private static final /* synthetic */ ButtonLayoutStyle[] $values() {
        return new ButtonLayoutStyle[]{HORIZONTAL, VERTICAL};
    }

    public static ButtonLayoutStyle valueOf(String r100) {
        return (ButtonLayoutStyle) a.a(ButtonLayoutStyle.class, r100);
    }

    public static ButtonLayoutStyle[] values() {
        return (ButtonLayoutStyle[]) $VALUES.clone();
    }

    static {
        HORIZONTAL = new ButtonLayoutStyle("HORIZONTAL", 0);
        VERTICAL = new ButtonLayoutStyle("VERTICAL", 1);
        $VALUES = $values();
    }

    private ButtonLayoutStyle(String r100, int r101) {
        super(r100, r101);
    }
}
