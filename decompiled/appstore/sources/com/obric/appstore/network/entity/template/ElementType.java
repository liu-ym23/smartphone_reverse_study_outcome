package com.obric.appstore.network.entity.template;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementType;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "IMAGE", "VIDEO", "APP", "APP_CATEGORY", "MULTI_TEXT", "ARRAY", "CATEGORY", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ElementType extends Enum<ElementType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ElementType[] $VALUES = null;
    public static final ElementType APP = null;
    public static final ElementType APP_CATEGORY = null;
    public static final ElementType ARRAY = null;
    public static final ElementType CATEGORY = null;
    public static final ElementType IMAGE = null;
    public static final ElementType MULTI_TEXT = null;
    public static final ElementType TEXT = null;
    public static final ElementType VIDEO = null;
    private final int value;

    private static final /* synthetic */ ElementType[] $values() {
        return new ElementType[]{TEXT, IMAGE, VIDEO, APP, APP_CATEGORY, MULTI_TEXT, ARRAY, CATEGORY};
    }

    static {
        TEXT = new ElementType("TEXT", 0, 1);
        IMAGE = new ElementType("IMAGE", 1, 2);
        VIDEO = new ElementType("VIDEO", 2, 3);
        APP = new ElementType("APP", 3, 4);
        APP_CATEGORY = new ElementType("APP_CATEGORY", 4, 6);
        MULTI_TEXT = new ElementType("MULTI_TEXT", 5, 8);
        ARRAY = new ElementType("ARRAY", 6, 12);
        CATEGORY = new ElementType("CATEGORY", 7, 25);
        ElementType[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private ElementType(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    @NotNull
    public static EnumEntries<ElementType> getEntries() {
        return $ENTRIES;
    }

    public static ElementType valueOf(String r10) {
        return (ElementType) Enum.valueOf(ElementType.class, r10);
    }

    public static ElementType[] values() {
        return (ElementType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
