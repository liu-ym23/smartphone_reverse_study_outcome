package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ConditionLocationRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface k {

    /* JADX INFO: compiled from: ConditionLocationRepo.kt */
    public static final class a {
        public static /* synthetic */ Object a(k r8, Context r9, boolean r10, boolean r11, boolean r12, d.c.d r13, int r14, Object r15) {
            k r2 = (k) ZeusTransformUtils.wrapperContextForParams(r8, k.class, "com.obric.aiagent.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            d.c.d<? super List<ConditionLocationItemData>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L13;
            if ((r14 & 4) == 0) goto L7;
            r11 = true;
        L7:
            boolean r5 = r11;
            if ((r14 & 8) == 0) goto L11;
            r12 = false;
        L11:
            return r2.a(r3, r10, r5, r12, r7);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserLocation");
        }
    }

    Object a(Context r1, String r2, d.c.d<? super com.obric.autogui.common.d<n>> r3);

    Object a(Context r1, boolean r2, boolean r3, boolean r4, d.c.d<? super List<ConditionLocationItemData>> r5);
}
