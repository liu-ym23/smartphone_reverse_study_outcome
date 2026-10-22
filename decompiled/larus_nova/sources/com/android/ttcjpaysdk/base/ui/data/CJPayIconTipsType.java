package com.android.ttcjpaysdk.base.ui.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayIconTipsType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "QUESTION", "INFO", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayIconTipsType extends Enum<CJPayIconTipsType> {
    private static final /* synthetic */ CJPayIconTipsType[] $VALUES = null;
    public static final CJPayIconTipsType INFO = null;
    public static final CJPayIconTipsType QUESTION = null;
    private final String type;

    private static final /* synthetic */ CJPayIconTipsType[] $values() {
        return new CJPayIconTipsType[]{QUESTION, INFO};
    }

    public static CJPayIconTipsType valueOf(String r100) {
        return (CJPayIconTipsType) a.a(CJPayIconTipsType.class, r100);
    }

    public static CJPayIconTipsType[] values() {
        return (CJPayIconTipsType[]) $VALUES.clone();
    }

    static {
        QUESTION = new CJPayIconTipsType("QUESTION", 0, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        INFO = new CJPayIconTipsType("INFO", 1, "info");
        $VALUES = $values();
    }

    public final String getType() {
        return this.type;
    }

    private CJPayIconTipsType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
