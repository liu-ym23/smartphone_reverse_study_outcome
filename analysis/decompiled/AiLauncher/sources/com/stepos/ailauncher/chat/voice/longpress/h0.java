package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/h0;", "", "", "preserveMultiRowHeight", "", "originalContentHeightDp", "<init>", "(ZF)V", "e", "()F", "pageDeltaDp", "layoutDeltaDp", Const.INTENT_KEY_APIKEY, "(FF)F", "currentHeightDp", "verticalAnchor", Const.INTENT_KEY_UMID, "(FFF)F", "animatedSingleRowHeightDp", "c", "(F)F", Const.INTENT_KEY_PKGNAME, "Z", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h0 {
    private final float originalContentHeightDp;
    private final boolean preserveMultiRowHeight;

    public h0(boolean z10, float f10) {
        this.preserveMultiRowHeight = z10;
        this.originalContentHeightDp = f10;
    }

    public final float a(float pageDeltaDp, float layoutDeltaDp) {
        if (this.preserveMultiRowHeight) {
            return 0.0f;
        }
        return pageDeltaDp - layoutDeltaDp;
    }

    public final float b(float animatedSingleRowHeightDp) {
        if (this.preserveMultiRowHeight) {
            return 24.0f;
        }
        return animatedSingleRowHeightDp / 2.0f;
    }

    public final float c(float animatedSingleRowHeightDp) {
        return this.preserveMultiRowHeight ? this.originalContentHeightDp : animatedSingleRowHeightDp;
    }

    public final float d(float pageDeltaDp, float currentHeightDp, float verticalAnchor) {
        return a(pageDeltaDp, (-(currentHeightDp - this.originalContentHeightDp)) * (1.0f - verticalAnchor));
    }

    public final float e() {
        return this.preserveMultiRowHeight ? 0.0f : 8.0f;
    }
}
