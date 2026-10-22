package com.android.server.permission.jarjar.kotlin.text;

import com.android.server.permission.jarjar.kotlin.jvm.functions.Function1;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes2.dex */
class StringsKt__AppendableKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(Appendable $this$appendElement, T r2, Function1<? super T, ? extends CharSequence> r3) {
        Intrinsics.checkNotNullParameter($this$appendElement, "<this>");
        if (r3 == null) goto L5;
        $this$appendElement.append(r3.invoke(r2));
        return;
    L5:
        if (r2 != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        $this$appendElement.append((CharSequence) r2);
        return;
    L11:
        if ((r2 instanceof Character) == false) goto L13;
        $this$appendElement.append(((Character) r2).charValue());
        return;
    L13:
        $this$appendElement.append(r2.toString());
        return;
    L7:
        r0 = r2 instanceof CharSequence;
        goto L8
    }
}
