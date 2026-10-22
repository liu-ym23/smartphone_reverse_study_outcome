package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f155965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f155966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f155967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ILivePlayerClient f155968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveRequest f155969e;

    public j(ILivePlayerClient r100, LiveRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter("pullStream", "action");
        this.f155968d = r100;
        this.f155969e = r101;
        this.f155965a = r100.context().getCreateScene().getScene();
        this.f155966b = r100.context().getUseScene().getScene();
        Long r102 = StringsKt.toLongOrNull(r100.identifier());
        if (r102 != null) goto L8;
        String r103 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r100.identifier(), new String[]{"@T"}, false, 0, 6, null), 0);
        if (r103 == null) goto L7;
        r102 = StringsKt.toLongOrNull(r103);
        goto L8
    L7:
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        long r104 = r102.longValue();
    L11:
        this.f155967c = r104;
        return;
    L10:
        r104 = 0;
        goto L11
    }
}
