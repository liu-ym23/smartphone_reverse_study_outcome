package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class d0 implements ISendCommentEvent, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ISendCommentEvent.Sender f123338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f123339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f123340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f123341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f123342f;

    @Override // com.bytedance.android.livesdk.event.ISendCommentEvent
    public final Map<String, Object> a() {
        return this.f123339c;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final m b() {
        return this.f123340d;
    }

    @Override // com.bytedance.android.livesdk.event.k
    public final q c() {
        return this.f123341e;
    }

    public d0(String r100, ISendCommentEvent.Sender r101, Map<String, ? extends Object> r102, m r103, q r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "sender");
        Intrinsics.checkNotNullParameter(r102, "args");
        this.f123337a = r100;
        this.f123338b = r101;
        this.f123339c = r102;
        this.f123340d = r103;
        this.f123341e = r104;
        this.f123342f = r105;
    }

    public /* synthetic */ d0(String r100, ISendCommentEvent.Sender r101, Map r110, m r111, q r112, boolean r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        r110 = MapsKt.emptyMap();
    L5:
        Map r102 = r110;
        if ((r114 & 8) == 0) goto L8;
        m r103 = null;
    L10:
        if ((r114 & 16) == 0) goto L12;
        q r104 = null;
    L14:
        if ((r114 & 32) == 0) goto L16;
        boolean r105 = false;
    L17:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L16:
        r105 = r113;
        goto L17
    L12:
        r104 = r112;
        goto L14
    L8:
        r103 = r111;
        goto L10
    }
}
