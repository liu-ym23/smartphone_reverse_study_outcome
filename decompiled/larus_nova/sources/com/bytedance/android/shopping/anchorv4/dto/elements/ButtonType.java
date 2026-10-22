package com.bytedance.android.shopping.anchorv4.dto.elements;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/ButtonType;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "LEFT", "TOP", "RIGHT", "BOTTOM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ButtonType extends Enum<ButtonType> {
    public static final ButtonType BOTTOM = null;
    public static final ButtonType LEFT = null;
    public static final ButtonType RIGHT = null;
    public static final ButtonType TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonType[] f166525a = null;
    private final Integer type;

    static {
        ButtonType r100 = new ButtonType("LEFT", 0, 0);
        LEFT = r100;
        ButtonType r101 = new ButtonType("TOP", 1, 1);
        TOP = r101;
        ButtonType r102 = new ButtonType("RIGHT", 2, 2);
        RIGHT = r102;
        ButtonType r103 = new ButtonType("BOTTOM", 3, 3);
        BOTTOM = r103;
        f166525a = new ButtonType[]{r100, r101, r102, r103};
    }

    public static ButtonType valueOf(String r100) {
        return (ButtonType) a.a(ButtonType.class, r100);
    }

    public static ButtonType[] values() {
        return (ButtonType[]) f166525a.clone();
    }

    public final Integer getType() {
        return this.type;
    }

    public ButtonType(String r100, int r101, Integer r102) {
        super(r100, r101);
        this.type = r102;
    }
}
