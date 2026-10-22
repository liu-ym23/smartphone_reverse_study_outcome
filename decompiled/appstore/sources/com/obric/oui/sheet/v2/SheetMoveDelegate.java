package com.obric.oui.sheet.v2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J&\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "", "fling", "", "xVelocity", "", "yVelocity", "move", "dx", "dy", "start", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SheetMoveDelegate {

    public static final class a {
        public static /* synthetic */ void a(SheetMoveDelegate r10, float r11, float r12, boolean r13, int r14, Object r15) {
            if (r15 != null) goto L15;
            if ((r14 & 1) == 0) goto L7;
            r11 = 0.0f;
        L7:
            if ((r14 & 2) == 0) goto L10;
            r12 = 0.0f;
        L10:
            if ((r14 & 4) == 0) goto L12;
            r13 = false;
        L12:
            r10.move(r11, r12, r13);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }
    }

    void fling(float r10, float r11);

    void move(float r10, float r11, boolean r12);
}
