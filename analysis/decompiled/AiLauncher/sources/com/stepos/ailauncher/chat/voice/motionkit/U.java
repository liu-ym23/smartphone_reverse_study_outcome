package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/U;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "bag", "", "viewW", "viewH", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;FF)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U {
    public static final U INSTANCE = new U();

    public final int a(C3077q bag, float viewW, float viewH) {
        float fMin;
        kotlin.jvm.internal.p.i(bag, "bag");
        if (viewW <= 0.0f || viewH <= 0.0f) {
            return 0;
        }
        float fE = C5685n.e(viewH, 1.0f);
        float fG = bag.g("uDpRef");
        if (fG > 0.5f) {
            fMin = Math.min(viewW, viewH) / (fG * fE);
        } else {
            float fG2 = bag.g("uPxPerDp");
            if (fG2 <= 0.0f) {
                return C5685n.f((int) (viewH * 0.28f), 1);
            }
            fMin = fG2 / fE;
        }
        float fG3 = bag.g("uOffsetY") + 0.5f + (Math.abs(bag.g("uAmp")) * fMin * 1.35f) + (Math.max(bag.g("uGlowUp"), bag.g("uGlowDn")) * fMin) + 0.04f;
        if (fG3 <= 0.0f) {
            return 0;
        }
        return C5685n.n((int) (fG3 * viewH * 1.12f), 1, C5685n.f((int) viewH, 1));
    }
}
