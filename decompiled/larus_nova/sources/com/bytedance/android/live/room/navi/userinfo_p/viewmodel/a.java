package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final o81.a a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAnchorInfoWidgetContext");
        r r101 = z51.a.e(r100);
        Object r102 = null;
        if (r101 == null) goto L7;
        j<ViewModel> r103 = r101.t();
        if (r103 == null) goto L7;
        ViewModel r104 = r103.getValue();
    L9:
        if ((r104 instanceof o81.a) == false) goto L13;
        r102 = r104;
    L13:
        return (o81.a) r102;
    L7:
        r104 = null;
        goto L9
    }
}
