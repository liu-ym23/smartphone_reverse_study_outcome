package com.obric.autoaction.vdplayer.components.cursor;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ICursorView.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: ICursorView.kt */
    public static final class a {
        public static /* synthetic */ void a(b r6, float r7, float r8, Float r9, Float r10, boolean r11, int r12, Object r13) {
            b r0 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L18;
            if ((r12 & 4) == 0) goto L7;
            Float r3 = null;
        L9:
            if ((r12 & 8) == 0) goto L11;
            Float r4 = null;
        L13:
            if ((r12 & 16) == 0) goto L15;
            r11 = true;
        L15:
            r0.a(r7, r8, r3, r4, r11);
            return;
        L11:
            r4 = r10;
            goto L13
        L7:
            r3 = r9;
            goto L9
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }
    }

    void a();

    void a(float r1, float r2, Float r3, Float r4);

    void a(float r1, float r2, Float r3, Float r4, boolean r5);

    void a(String r1, boolean r2);

    void b();

    void c();

    void d();

    void e();

    void f();
}
