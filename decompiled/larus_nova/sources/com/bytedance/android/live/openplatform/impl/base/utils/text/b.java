package com.bytedance.android.live.openplatform.impl.base.utils.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(c r100, int r101) {
            r100.e(r101, 0, SpannableStringBuilderEnv$space$1.INSTANCE);
        }
    }

    c a(Function1 r100);

    c append(CharSequence r100);

    c b(Object r100, Function1 r101);

    c c(Function1 r100);
}
