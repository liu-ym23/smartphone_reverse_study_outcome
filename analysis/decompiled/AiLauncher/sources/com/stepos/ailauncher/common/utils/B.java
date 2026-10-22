package com.stepos.ailauncher.common.utils;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/common/utils/B;", "", "<init>", "()V", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    public static final B INSTANCE = new B();

    public final boolean a(View v10, MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (!(v10 instanceof EditText)) {
            return v10 != null;
        }
        int[] iArr = {0, 0};
        EditText editText = (EditText) v10;
        editText.getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return event.getX() <= ((float) i10) || event.getX() >= ((float) (editText.getWidth() + i10)) || event.getY() <= ((float) i11) || event.getY() >= ((float) (editText.getHeight() + i11));
    }
}
