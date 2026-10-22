package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureInitDirectionIntent;", "", "()V", "DOWN", "", "IGNORE", "LEFT", "RIGHT", "UNDEFINE", "UP", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureInitDirectionIntent {
    public static final int DOWN = 4;
    public static final int IGNORE = -1;
    public static final GestureInitDirectionIntent INSTANCE = null;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int UNDEFINE = 0;
    public static final int UP = 2;

    private GestureInitDirectionIntent() {
    }

    static {
        INSTANCE = new GestureInitDirectionIntent();
    }
}
