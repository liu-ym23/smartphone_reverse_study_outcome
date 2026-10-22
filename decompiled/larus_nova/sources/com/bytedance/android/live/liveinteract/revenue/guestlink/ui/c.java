package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.message.model.n5;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f78509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<n5> f78510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f78511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f78512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j1 f78513e;

    public static final class a {
    }

    static {
    }

    public final void c() {
        vlc.d r100 = this.f78509a;
        if (r100 == null) goto L5;
        r100.removeMessageListener((l) this.f78511c.getValue());
    L5:
        ((ArrayList) this.f78510b).clear();
        this.f78512d.b();
        this.f78512d.clear();
    }

    public final void d() {
        ALogger.i("GiftMarqueeViewController", BasicTestActionHandler.TEST_ACTION_RESET);
        ((ArrayList) this.f78510b).clear();
        this.f78512d.clear();
    }

    public final void b() {
        t r100 = m.b();
        if (r100 == null) goto L7;
        j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        vlc.d r102 = r101.getValue();
    L8:
        this.f78509a = r102;
        if (r102 == null) goto L12;
        r102.addMessageListener(MessageType.GIFT.getIntType(), (l) this.f78511c.getValue());
        return;
    L12:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public static String a(n5 r100) {
        String r101 = String.valueOf(r100.getGiftId()) + "-" + String.valueOf(r100.getGroupId()) + "-" + String.valueOf(r100.getGroupCount());
        IBaseUser r102 = r100.getFromUser();
        if (r102 == null) goto L5;
        r101 = r101 + "_" + r102.getWebcastUid();
    L5:
        IBaseUser r103 = r100.getToUser();
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r101 + "_" + r103.getWebcastUid();
    }

    public c(GiftMarqueeContainer r100, j1 r101) {
        Intrinsics.checkNotNullParameter(r100, "giftMarqueeContainer");
        Intrinsics.checkNotNullParameter(r101, "outerScopeProvider");
        this.f78512d = r100;
        this.f78513e = r101;
        r100.f(new b(this));
        this.f78510b = new ArrayList();
        this.f78511c = LazyKt.lazy(new GiftMarqueeViewController$mOnMessageListener$2(this));
    }
}
