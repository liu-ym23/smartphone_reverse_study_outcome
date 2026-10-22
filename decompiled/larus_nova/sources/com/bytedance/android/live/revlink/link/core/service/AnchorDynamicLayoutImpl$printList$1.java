package com.bytedance.android.live.revlink.link.core.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, BaseSwitches.V, AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
final class AnchorDynamicLayoutImpl$printList$1 extends Lambda implements Function1<Object, CharSequence> {
    public static final AnchorDynamicLayoutImpl$printList$1 INSTANCE = null;

    static {
        INSTANCE = new AnchorDynamicLayoutImpl$printList$1();
    }

    public AnchorDynamicLayoutImpl$printList$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Object r100) {
        StringBuilder r101 = new StringBuilder("Value: ");
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.append(r102);
        return r101.toString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Object r100) {
        return invoke(r100);
    }
}
