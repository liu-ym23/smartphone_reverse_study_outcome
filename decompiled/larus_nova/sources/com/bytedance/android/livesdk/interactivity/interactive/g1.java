package com.bytedance.android.livesdk.interactivity.interactive;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f137412a;

    public g1(Function2 r100) {
        this.f137412a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function2 r102 = this.f137412a;
        pm1.h r103 = pm1.h.f529822d;
        yq1.d r104 = (yq1.d) r103.c(yq1.d.class);
        if (r104 == null) goto L5;
        int r105 = r104.g(r101);
    L6:
        r102.invoke(Integer.valueOf(r105), r101.getMessage());
        if ((r101 instanceof ApiServerException) == false) goto L36;
        yq1.d r106 = (yq1.d) r103.c(yq1.d.class);
        if (r106 == null) goto L11;
        Integer r107 = Integer.valueOf(r106.g(r101));
    L12:
        if (r107 != null) goto L15;
    L17:
        if (r107 != null) goto L20;
    L22:
        if (r107 != null) goto L25;
    L27:
        if (r107 != null) goto L30;
    L32:
        String r108 = "";
    L34:
        if (TextUtils.isEmpty(r108) == true) goto L36;
        f2.c(r108, 0);
        goto L36
    L30:
        if (r107.intValue() != 4008147) goto L32;
        r108 = s1.B(R.string.ttlive_sned_msg_board_comment_switch_off);
        goto L34
    L25:
        if (r107.intValue() != 4008146) goto L27;
        r108 = s1.B(R.string.ttlive_sned_msg_board_comment_max_count);
        goto L34
    L20:
        if (r107.intValue() != 4008145) goto L22;
        r108 = s1.B(R.string.ttlive_sned_msg_board_comment_too_often);
        goto L34
    L15:
        if (r107.intValue() != 4008144) goto L17;
        r108 = s1.B(R.string.ttlive_sned_msg_board_comment_review_fail);
        goto L34
    L11:
        r107 = null;
    L36:
        int r109 = h1.f137415a;
        String r110 = "send comment failed, " + r101.getMessage();
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("VSMsgBoard", r110);
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
