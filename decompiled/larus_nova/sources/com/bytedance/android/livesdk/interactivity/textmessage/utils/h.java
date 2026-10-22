package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageStyleFormatter;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141232a = 0;

    static {
    }

    @JvmStatic
    public static final int a(SpannableType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 == SpannableType.MESSAGE_FILTER) goto L7;
        int r102 = k.f141238a;
        return i0.a(R.color.ttlive_hs_s40);
    L7:
        return MessageStyleFormatter.a(MessageStyleFormatter.StyleType.GIFT, r101).f133774b;
    }

    @JvmStatic
    public static final int b(SpannableType r100, boolean r101, MessageSceneType r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "mSceneType");
        if (r100 == SpannableType.MESSAGE_FILTER) goto L7;
        int r103 = k.f141238a;
        Intrinsics.checkNotNullParameter(r102, "type");
        return i0.a(R.color.ttlive_hs_s38);
    L7:
        return MessageStyleFormatter.a(MessageStyleFormatter.StyleType.GIFT, r101).f133773a;
    }
}
