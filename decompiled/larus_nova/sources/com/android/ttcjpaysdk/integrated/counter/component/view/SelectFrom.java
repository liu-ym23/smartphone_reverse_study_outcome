package com.android.ttcjpaysdk.integrated.counter.component.view;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;", "", "lynxSource", "", "buttonName", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/ButtonName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/android/ttcjpaysdk/integrated/counter/component/view/ButtonName;)V", "getButtonName", "()Lcom/android/ttcjpaysdk/integrated/counter/component/view/ButtonName;", "getLynxSource", "()Ljava/lang/String;", "gotoSelectPayTypePage", "", "DEFAULT", "MORE_PROMOTION", "Confirm", "RECOMMEND_DY", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum SelectFrom extends Enum<SelectFrom> {
    private static final /* synthetic */ SelectFrom[] $VALUES = null;
    public static final SelectFrom Confirm = null;
    public static final SelectFrom DEFAULT = null;
    public static final SelectFrom MORE_PROMOTION = null;
    public static final SelectFrom RECOMMEND_DY = null;
    private final ButtonName buttonName;
    private final String lynxSource;

    private static final /* synthetic */ SelectFrom[] $values() {
        return new SelectFrom[]{DEFAULT, MORE_PROMOTION, Confirm, RECOMMEND_DY};
    }

    public static SelectFrom valueOf(String r100) {
        return (SelectFrom) a.a(SelectFrom.class, r100);
    }

    public static SelectFrom[] values() {
        return (SelectFrom[]) $VALUES.clone();
    }

    public final boolean gotoSelectPayTypePage() {
        return CollectionsKt.listOf(new SelectFrom[]{DEFAULT, MORE_PROMOTION}).contains(this);
    }

    static {
        DEFAULT = new SelectFrom("DEFAULT", 0, "native_paymethod", ButtonName.BUTTON_NAME1);
        MORE_PROMOTION = new SelectFrom("MORE_PROMOTION", 1, "native_paymethod_voucher", ButtonName.BUTTON_NAME2);
        Confirm = new SelectFrom("Confirm", 2, null, ButtonName.BUTTON_NAME3, 1, null);
        RECOMMEND_DY = new SelectFrom("RECOMMEND_DY", 3, null, ButtonName.BUTTON_NAME4, 1, null);
        $VALUES = $values();
    }

    public final ButtonName getButtonName() {
        return this.buttonName;
    }

    public final String getLynxSource() {
        return this.lynxSource;
    }

    private SelectFrom(String r100, int r101, String r102, ButtonName r103) {
        super(r100, r101);
        this.lynxSource = r102;
        this.buttonName = r103;
    }

    public /* synthetic */ SelectFrom(String r100, int r101, String r102, ButtonName r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102, r103);
    }
}
