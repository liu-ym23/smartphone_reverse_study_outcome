package com.stepos.ailauncher.taskstore.widget;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/x0;", "", "<init>", "()V", "", "currentExpected", "imageCount", "pendingCount", Const.INTENT_KEY_APIKEY, "(III)I", Const.INTENT_KEY_PKGNAME, "(II)I", "expected", "", "c", "(III)Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x0 {
    public static final x0 INSTANCE = new x0();

    public final int a(int currentExpected, int imageCount, int pendingCount) {
        return Math.max(currentExpected, imageCount + b(imageCount, pendingCount));
    }

    public final int b(int imageCount, int pendingCount) {
        if (pendingCount <= 0) {
            return 0;
        }
        if (pendingCount != 1 || imageCount < 1) {
            return pendingCount;
        }
        return 0;
    }

    public final boolean c(int imageCount, int pendingCount, int expected) {
        return imageCount > 0 && pendingCount <= 0 && expected <= imageCount;
    }
}
