package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.model.api.o;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f146593a = null;

    static {
        f146593a = new d();
    }

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        ALogger.i("GroupLiveGameInviteUtils", "inviteFriends success, response: " + ((o) r101.data));
        o r102 = (o) r101.data;
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102.b()) == true) goto L7;
        f2.c(r102.b(), 0);
    L7:
        List<String> r103 = r102.a();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        c.f146588c.put((String) r104.next(), Long.valueOf(System.currentTimeMillis()));
        goto L11
    L16:
        return;
    }
}
