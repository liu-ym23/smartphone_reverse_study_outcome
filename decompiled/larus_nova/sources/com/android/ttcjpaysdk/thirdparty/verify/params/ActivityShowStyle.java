package com.android.ttcjpaysdk.thirdparty.verify.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/ActivityShowStyle;", "", "style", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "OLD", "NEW_TAG", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ActivityShowStyle extends Enum<ActivityShowStyle> {
    private static final /* synthetic */ ActivityShowStyle[] $VALUES = null;
    public static final ActivityShowStyle NEW_TAG = null;
    public static final ActivityShowStyle OLD = null;
    private final String style;

    private static final /* synthetic */ ActivityShowStyle[] $values() {
        return new ActivityShowStyle[]{OLD, NEW_TAG};
    }

    public static ActivityShowStyle valueOf(String r100) {
        return (ActivityShowStyle) a.a(ActivityShowStyle.class, r100);
    }

    public static ActivityShowStyle[] values() {
        return (ActivityShowStyle[]) $VALUES.clone();
    }

    static {
        OLD = new ActivityShowStyle("OLD", 0, "202411");
        NEW_TAG = new ActivityShowStyle("NEW_TAG", 1, "202412");
        $VALUES = $values();
    }

    public final String getStyle() {
        return this.style;
    }

    private ActivityShowStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.style = r102;
    }
}
