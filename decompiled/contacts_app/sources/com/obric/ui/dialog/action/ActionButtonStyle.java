package com.obric.ui.dialog.action;

import kotlin.Metadata;

/* JADX INFO: compiled from: ActionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/ui/dialog/action/ActionButtonStyle;", "", "styleRes", "", "(Ljava/lang/String;II)V", "getStyleRes", "()I", "RedLight", "BlueLight", "Neutral", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum ActionButtonStyle extends Enum<ActionButtonStyle> {
    private static final /* synthetic */ ActionButtonStyle[] $VALUES = null;
    public static final ActionButtonStyle BlueLight = null;
    public static final ActionButtonStyle Neutral = null;
    public static final ActionButtonStyle RedLight = null;
    private final int styleRes;

    private static final /* synthetic */ ActionButtonStyle[] $values() {
        return new ActionButtonStyle[]{RedLight, BlueLight, Neutral};
    }

    public static ActionButtonStyle valueOf(String r1) {
        return (ActionButtonStyle) Enum.valueOf(ActionButtonStyle.class, r1);
    }

    public static ActionButtonStyle[] values() {
        return (ActionButtonStyle[]) $VALUES.clone();
    }

    private ActionButtonStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.styleRes = r3;
    }

    public final int getStyleRes() {
        return this.styleRes;
    }

    static {
        RedLight = new ActionButtonStyle("RedLight", 0, 2131952429);
        BlueLight = new ActionButtonStyle("BlueLight", 1, 2131952427);
        Neutral = new ActionButtonStyle("Neutral", 2, 2131952425);
        $VALUES = $values();
    }
}
