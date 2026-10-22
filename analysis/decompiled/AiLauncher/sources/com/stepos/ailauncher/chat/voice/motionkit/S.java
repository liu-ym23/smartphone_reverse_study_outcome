package com.stepos.ailauncher.chat.voice.motionkit;

import android.graphics.Rect;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/S;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "water", "ripple", "", "screenW", "screenH", "", "density", "Landroid/graphics/Rect;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;Lcom/stepos/ailauncher/chat/voice/motionkit/q;IIF)Landroid/graphics/Rect;", "out", "bag", "sw", "sh", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Rect;Lcom/stepos/ailauncher/chat/voice/motionkit/q;IIF)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S {
    public static final S INSTANCE = new S();

    public static final float c(C3077q c3077q, String str) {
        return c3077q.g(str);
    }

    public final Rect a(C3077q water, C3077q ripple, int screenW, int screenH, float density) {
        Rect rect = new Rect();
        if (water != null) {
            b(rect, water, screenW, screenH, density);
        }
        if (ripple != null) {
            b(rect, ripple, screenW, screenH, density);
        }
        if (rect.isEmpty()) {
            return null;
        }
        int i10 = -C5685n.f((int) (density * 48.0f), 32);
        rect.inset(i10, i10);
        rect.left = C5685n.n(rect.left, 0, screenW - 1);
        rect.top = C5685n.n(rect.top, 0, screenH - 1);
        rect.right = C5685n.n(rect.right, rect.left + 1, screenW);
        rect.bottom = C5685n.n(rect.bottom, rect.top + 1, screenH);
        return rect;
    }

    public final void b(Rect out, C3077q bag, int sw, int sh, float density) {
        float f10 = sw;
        float f11 = f10 / 1080.0f;
        float fC = c(bag, "uCenterX") * f10;
        float fC2 = c(bag, "uCenterY") * sh;
        float fC3 = c(bag, "uSizeW1") * f11 * 0.5f;
        float fC4 = c(bag, "uSizeH1") * f11 * 0.5f;
        float fC5 = (c(bag, "uEndWidth") * f11 * 0.5f) + (c(bag, "uBlur1") * density) + 32.0f;
        out.union(new Rect((int) ((fC - fC3) - fC5), (int) ((fC2 - fC4) - fC5), (int) (fC + fC3 + fC5), (int) (fC2 + fC4 + fC5)));
    }
}
