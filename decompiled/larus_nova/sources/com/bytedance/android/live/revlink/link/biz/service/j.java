package com.bytedance.android.live.revlink.link.biz.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface j extends k {

    public static final class a {
        public static String a(j r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "$this$linkerID");
            p r102 = r100.getContext().getAnchorLinkUserCenter().getGuestInfo(r101, r101);
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.getInteractId();
        }

        public static String b(j r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "$this$uid");
            p r102 = r100.getContext().getAnchorLinkUserCenter().getGuestInfo(r101, r101);
            if (r102 == null) goto L7;
            IBaseUser r103 = r102.getUser();
            if (r103 == null) goto L7;
            return iz.a.a(r103);
        L7:
            return null;
        }
    }

    com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext();
}
