package com.android.ttcjpaysdk.base.ui.component.tag;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJLabelType;", "", "typeStr", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeStr", "()Ljava/lang/String;", CardAdapter.TEXT, BackgroundConfig.BackgroundType.TYPE_PICTURE, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJLabelType extends Enum<CJLabelType> {
    private static final /* synthetic */ CJLabelType[] $VALUES = null;
    public static final CJLabelType PICTURE = null;
    public static final CJLabelType TEXT = null;
    private final String typeStr;

    private static final /* synthetic */ CJLabelType[] $values() {
        return new CJLabelType[]{TEXT, PICTURE};
    }

    public static CJLabelType valueOf(String r100) {
        return (CJLabelType) a.a(CJLabelType.class, r100);
    }

    public static CJLabelType[] values() {
        return (CJLabelType[]) $VALUES.clone();
    }

    static {
        TEXT = new CJLabelType(CardAdapter.TEXT, 0, "text");
        PICTURE = new CJLabelType(BackgroundConfig.BackgroundType.TYPE_PICTURE, 1, "picture");
        $VALUES = $values();
    }

    public final String getTypeStr() {
        return this.typeStr;
    }

    private CJLabelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeStr = r102;
    }
}
