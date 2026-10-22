package com.android.contacts.util;

import android.app.Activity;
import com.android.contacts.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: UiUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/android/contacts/util/UiUtils;", "", "()V", "isUiFinishing", "", "activity", "Landroid/app/Activity;", "setWindowColorStatusBar", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UiUtils {
    public static final UiUtils INSTANCE = null;

    static {
        INSTANCE = new UiUtils();
    }

    private UiUtils() {
    }

    @JvmStatic
    public static final boolean isUiFinishing(Activity r1) {
        if (r1 != null) goto L4;
        return true;
    L4:
        if (r1.isFinishing() == false) goto L6;
        return true;
    L6:
        if (r1.isDestroyed() == true) goto L13;
        return false;
    L13:
        return true;
    }

    @JvmStatic
    public static final void setWindowColorStatusBar(Activity r1) {
        if ((r1 instanceof BaseActivity) == false) goto L6;
        ((BaseActivity) r1).getImmersive().setup();
        return;
    }
}
