package com.obric.oui.sheet.v2;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OSheetTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    public static final class a {
        public static /* synthetic */ void a(e r2, float r3, float r4, boolean r5, int r6, Object r7) {
            e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L16;
            if ((r6 & 1) == 0) goto L8;
            r3 = 0.0f;
        L8:
            if ((r6 & 2) == 0) goto L11;
            r4 = 0.0f;
        L11:
            if ((r6 & 4) == 0) goto L13;
            r5 = false;
        L13:
            r8.move(r3, r4, r5);
            return;
        L16:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }
    }

    void fling(float r1, float r2);

    void move(float r1, float r2, boolean r3);
}
