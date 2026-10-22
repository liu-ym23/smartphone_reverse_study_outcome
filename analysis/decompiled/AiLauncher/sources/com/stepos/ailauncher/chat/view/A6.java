package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/A6;", "", "<init>", "()V", "", "heightPx", "", "density", Const.INTENT_KEY_APIKEY, "(IF)F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A6 {
    public static final A6 INSTANCE = new A6();

    public final float a(int heightPx, float density) {
        if (Math.abs(density) > Float.MAX_VALUE || density <= 0.0f) {
            return 15.0f;
        }
        return (C5685n.m(((heightPx / density) - 56.0f) / 184.0f, 0.0f, 1.0f) * 165.0f) + 15.0f;
    }
}
