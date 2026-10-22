package com.obric.oui.sheet.v2;

import kotlin.Metadata;

/* JADX INFO: compiled from: OSheetTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J&\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "", "fling", "", "xVelocity", "", "yVelocity", "move", "dx", "dy", "start", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SheetMoveDelegate {

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void move$default(SheetMoveDelegate r1, float r2, float r3, boolean r4, int r5, Object r6) {
            if (r6 != null) goto L15;
            if ((r5 & 1) == 0) goto L7;
            r2 = 0.0f;
        L7:
            if ((r5 & 2) == 0) goto L10;
            r3 = 0.0f;
        L10:
            if ((r5 & 4) == 0) goto L12;
            r4 = false;
        L12:
            r1.move(r2, r3, r4);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }
    }

    void fling(float r1, float r2);

    void move(float r1, float r2, boolean r3);
}
