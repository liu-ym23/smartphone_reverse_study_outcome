package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import io.reactivex.Observable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashSet<Long> f117479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f117480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f117481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f117482d = null;

    public m() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f117482d = new m();
        f117479a = new ConcurrentHashSet();
        f117480b = "WatchLaterBubbleShowController";
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
        if (f117481c == true) goto L6;
        f117481c = true;
        Observable.interval(3, TimeUnit.HOURS).subscribe(l.f117478a);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
    L22:
        e = move-exception;
        ALogger.e(f117480b, String.valueOf(e));
        return;
    L4:
        if (r100.hashCode() == 1549130846) goto L7;
        return;
    L7:
        if (r100.equals("livesdk_watch_seconds") == false) goto L28;
        String r102 = r101.get(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_TIME);     // Catch: Exception -> L22
        if (r102 == null) goto L11;
        long r103 = CastLongProtector.parseLong(r102);     // Catch: Exception -> L22
    L12:
        String r104 = r101.get("room_id");     // Catch: Exception -> L22
        if (r104 == null) goto L15;
        long r105 = CastLongProtector.parseLong(r104);     // Catch: Exception -> L22
    L17:
        if (r103 == 10) goto L19;
        return;
    L19:
        if (r105 <= 0) goto L30;
        f117479a.add(Long.valueOf(r105));     // Catch: Exception -> L22
        return;
    L30:
        return;
    L15:
        r105 = 0;
        goto L17
    L11:
        r103 = 0;
        goto L12
    }
}
