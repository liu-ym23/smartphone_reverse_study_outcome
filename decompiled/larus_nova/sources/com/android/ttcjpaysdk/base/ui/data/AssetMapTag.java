package com.android.ttcjpaysdk.base.ui.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetMapTag;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "DEFAULT", "RETAIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AssetMapTag extends Enum<AssetMapTag> {
    private static final /* synthetic */ AssetMapTag[] $VALUES = null;
    public static final AssetMapTag DEFAULT = null;
    public static final AssetMapTag RETAIN = null;
    private final String tag;

    private static final /* synthetic */ AssetMapTag[] $values() {
        return new AssetMapTag[]{DEFAULT, RETAIN};
    }

    public static AssetMapTag valueOf(String r100) {
        return (AssetMapTag) a.a(AssetMapTag.class, r100);
    }

    public static AssetMapTag[] values() {
        return (AssetMapTag[]) $VALUES.clone();
    }

    static {
        DEFAULT = new AssetMapTag("DEFAULT", 0, "default");
        RETAIN = new AssetMapTag("RETAIN", 1, "retain");
        $VALUES = $values();
    }

    public final String getTag() {
        return this.tag;
    }

    private AssetMapTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
