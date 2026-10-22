package com.obric.oui.picker.reels.a;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OReelPickerBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b<FT, DT> {

    /* JADX INFO: compiled from: OReelPickerBuilder.kt */
    public static final class a {
        public static /* synthetic */ Object a(b r2, Context r3, AttributeSet r4, int r5, int r6, Object r7) {
            b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r10 = null;
        L8:
            if ((r6 & 4) == 0) goto L11;
            r5 = 0;
        L11:
            return r8.b(r9, r10, r5);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    FT b(Context r1, AttributeSet r2, int r3);
}
