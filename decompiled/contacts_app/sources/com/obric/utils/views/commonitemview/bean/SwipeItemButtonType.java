package com.obric.utils.views.commonitemview.bean;

import com.android.contacts.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: SwipeItemButtonType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "", "drawable", "", "color", "(Ljava/lang/String;III)V", "getColor", "()I", "setColor", "(I)V", "getDrawable", "setDrawable", "SWIPE_PHONE", "SWIPE_PHONE1", "SWIPE_PHONE2", "SWIPE_STAR", "SWIPE_UNSTAR", "SWIPE_DELETE", "SWIPE_MESSAGE", "SWIPE_RESTORE", "SWIPE_EDIT", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum SwipeItemButtonType extends Enum<SwipeItemButtonType> {
    private static final /* synthetic */ SwipeItemButtonType[] $VALUES = null;
    public static final SwipeItemButtonType SWIPE_DELETE = null;
    public static final SwipeItemButtonType SWIPE_EDIT = null;
    public static final SwipeItemButtonType SWIPE_MESSAGE = null;
    public static final SwipeItemButtonType SWIPE_PHONE = null;
    public static final SwipeItemButtonType SWIPE_PHONE1 = null;
    public static final SwipeItemButtonType SWIPE_PHONE2 = null;
    public static final SwipeItemButtonType SWIPE_RESTORE = null;
    public static final SwipeItemButtonType SWIPE_STAR = null;
    public static final SwipeItemButtonType SWIPE_UNSTAR = null;
    private int color;
    private int drawable;

    private static final /* synthetic */ SwipeItemButtonType[] $values() {
        return new SwipeItemButtonType[]{SWIPE_PHONE, SWIPE_PHONE1, SWIPE_PHONE2, SWIPE_STAR, SWIPE_UNSTAR, SWIPE_DELETE, SWIPE_MESSAGE, SWIPE_RESTORE, SWIPE_EDIT};
    }

    public static SwipeItemButtonType valueOf(String r1) {
        return (SwipeItemButtonType) Enum.valueOf(SwipeItemButtonType.class, r1);
    }

    public static SwipeItemButtonType[] values() {
        return (SwipeItemButtonType[]) $VALUES.clone();
    }

    private SwipeItemButtonType(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.drawable = r3;
        this.color = r4;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDrawable() {
        return this.drawable;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    public final void setDrawable(int r1) {
        this.drawable = r1;
    }

    static {
        SWIPE_PHONE = new SwipeItemButtonType("SWIPE_PHONE", 0, R.drawable.menu_icon_phone, R.color.oui_fill_icon_as_action);
        SWIPE_PHONE1 = new SwipeItemButtonType("SWIPE_PHONE1", 1, R.drawable.menu_icon_phone1, R.color.oui_fill_icon_as_action);
        SWIPE_PHONE2 = new SwipeItemButtonType("SWIPE_PHONE2", 2, R.drawable.menu_icon_phone2, R.color.oui_fill_icon_as_action);
        SWIPE_STAR = new SwipeItemButtonType("SWIPE_STAR", 3, R.drawable.menu_icon_unstarred, R.color.oui_fill_icon_as_action);
        SWIPE_UNSTAR = new SwipeItemButtonType("SWIPE_UNSTAR", 4, R.drawable.menu_icon_starred, R.color.oui_functional_yellow_6);
        SWIPE_DELETE = new SwipeItemButtonType("SWIPE_DELETE", 5, R.drawable.menu_icon_delete, R.color.oui_red_6);
        SWIPE_MESSAGE = new SwipeItemButtonType("SWIPE_MESSAGE", 6, R.drawable.menu_icon_message, R.color.oui_fill_icon_as_action);
        SWIPE_RESTORE = new SwipeItemButtonType("SWIPE_RESTORE", 7, R.drawable.menu_icon_restore, R.color.oui_fill_icon_as_action);
        SWIPE_EDIT = new SwipeItemButtonType("SWIPE_EDIT", 8, R.drawable.left_mode_edit_btn, R.color.oui_fill_icon_as_action);
        $VALUES = $values();
    }
}
