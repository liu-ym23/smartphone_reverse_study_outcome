package com.obric.autoaction.app.launcherpage.ui;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeletableSpan.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeletableSpan extends CharacterStyle {
    public static final a Companion = null;
    private static final String TAG = "DeletableSpan";
    private final float paddingLeft;
    private final float paddingRight;
    private final Integer textColor;

    /* JADX INFO: compiled from: DeletableSpan.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public DeletableSpan() {
        this(null, 0.0f, 0.0f, 7, null);
    }

    public /* synthetic */ DeletableSpan(Integer r2, float r3, float r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        this(r2, r3, r4);
    }

    public DeletableSpan(Integer r1, float r2, float r3) {
        this.textColor = r1;
        this.paddingLeft = r2;
        this.paddingRight = r3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r3) {
        d.h.b.o.e(r3, "tp");
        Integer r2 = this.textColor;
        if (r2 == null) goto L6;
        r3.setColor(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    }
}
