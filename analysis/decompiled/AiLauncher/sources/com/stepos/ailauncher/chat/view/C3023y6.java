package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/view/y6;", "", "", "compactSingleRowCornerDp", "expandedMultiRowCornerDp", "<init>", "(FF)V", "", "expandedMultiRow", Const.INTENT_KEY_PKGNAME, "(Z)F", "F", "Z", Const.INTENT_KEY_APIKEY, "()F", "currentCornerRadiusDp", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.y6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3023y6 {
    private final float compactSingleRowCornerDp;
    private boolean expandedMultiRow;
    private final float expandedMultiRowCornerDp;

    public C3023y6(float f10, float f11) {
        this.compactSingleRowCornerDp = f10;
        this.expandedMultiRowCornerDp = f11;
    }

    public final float a() {
        return this.expandedMultiRow ? this.expandedMultiRowCornerDp : this.compactSingleRowCornerDp;
    }

    public final float b(boolean expandedMultiRow) {
        this.expandedMultiRow = expandedMultiRow;
        return a();
    }
}
