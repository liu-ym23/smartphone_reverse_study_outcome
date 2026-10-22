package com.bytedance.android.livesdk.message.linker;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class m {
    public static final boolean a(MessageType r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, com.alipay.sdk.m.p.e.f25671s);
        if (r110 != null) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r110.getWsMethod(), r111) == false) goto L10;
        return true;
    L10:
        String r112 = StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(r111, MessageType.WEBCAST_OPEN, "", false, 4, null), MessageType.WEBCAST, "", false, 4, null);
        return Intrinsics.areEqual(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(r110.getWsMethod(), MessageType.WEBCAST_OPEN, "", false, 4, null), MessageType.WEBCAST, "", false, 4, null), r112);
    }
}
