package cfa;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class k {
    public static final WindowAnimationType a(String r100) {
        WindowAnimationType r101 = null;
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        Iterator<WindowAnimationType> r103 = WindowAnimationType.getEntries().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        WindowAnimationType r104 = r103.next();
        if (Intrinsics.areEqual(r104.getSerializedValue(), r102) == false) goto L10;
        r101 = r104;
    L14:
        WindowAnimationType r105 = r101;
        if (r105 == null) goto L17;
        return r105;
    L17:
        return WindowAnimationType.None;
    L5:
        r102 = null;
        goto L6
    }
}
