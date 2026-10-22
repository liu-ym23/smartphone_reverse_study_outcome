package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import android.widget.EditText;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f134928a = 0;

    static {
        f134928a = s1.f(15.0f);
    }

    public static void a(EditText r100, CharSequence r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "content");
        int r104 = r100.getSelectionStart();
        r100.getEditableText().insert(r104, ab2.b.a().c(r101.toString(), r102));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r103 == false) goto L8;
        String r105 = "recommend";
    L9:
        SafetyGuard.a(null, e, "input " + r105 + " comment failed");
        return;
    L8:
        r105 = "frequent";
        goto L9
    }
}
