package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f81360a = null;

    static {
        f81360a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r100 = (Long) r110;
        LinkMonitor.a("PipeLineM", "recordLinkDuration", "current LinkSource " + LinkMonitor.f252236j, null, null, false, 120);
        int r101 = a.f81356a[LinkMonitor.f252236j.ordinal()];
        if (r101 != 1) goto L5;
        StringBuilder r102 = new StringBuilder("[duration] first_frame ");
        if (LinkMonitor.f252234h == false) goto L13;
        long r111 = LinkMonitor.f252233g;
        long r112 = LinkMonitor.f252228b;
    L14:
        r102.append(r111 - r112);
        r102.append(" link ");
        if (LinkMonitor.f252234h == false) goto L17;
        long r103 = LinkMonitor.f252231e;
        long r113 = LinkMonitor.f252228b;
    L18:
        r102.append(r103 - r113);
        r102.append(" isAutoJoin ");
        r102.append(LinkMonitor.f252234h);
        r102.append(" autoApplyToPermit ");
        if (LinkMonitor.f252234h == false) goto L21;
        long r104 = LinkMonitor.f252229c - LinkMonitor.f252228b;
    L22:
        r102.append(r104);
        r102.append(" applyApi ");
        r102.append(LinkMonitor.f252238l);
        r102.append(" joinChannel ");
        r102.append(LinkMonitor.f252239m);
        r102.append(" rtc ");
        r102.append(LinkMonitor.f252232f - LinkMonitor.f252230d);
        r102.append(" linkOptInfo ");
        r102.append(LinkMonitor.f252235i);
        LinkMonitor.a("PipeLineM", "applyLinkDuration", r102.toString(), null, null, true, 56);
        if (LinkMonitor.f252234h == false) goto L25;
        InteractLinkFullLinkMonitor.LinkSource r105 = InteractLinkFullLinkMonitor.LinkSource.APPLY_AUTO;
    L26:
        String r106 = LinkMonitor.f252235i;
        if (LinkMonitor.f252234h == false) goto L29;
        long r107 = LinkMonitor.f252231e;
        long r108 = LinkMonitor.f252228b;
    L30:
        InteractLinkFullLinkMonitor.D(r105, r106, r107 - r108, false);
        if (LinkMonitor.f252234h == false) goto L33;
        long r109 = LinkMonitor.f252233g;
        long r114 = LinkMonitor.f252228b;
    L35:
        if ((r109 - r114) > 0) goto L37;
    L49:
        LinkMonitor.b();
        return;
    L37:
        if (LinkMonitor.f252234h == false) goto L39;
        InteractLinkFullLinkMonitor.LinkSource r115 = InteractLinkFullLinkMonitor.LinkSource.APPLY_AUTO;
    L40:
        String r116 = LinkMonitor.f252235i;
        if (LinkMonitor.f252234h == false) goto L43;
        long r117 = LinkMonitor.f252233g;
        long r118 = LinkMonitor.f252228b;
    L44:
        long r119 = r117 - r118;
        if (LinkMonitor.f252234h == false) goto L47;
        long r120 = LinkMonitor.f252231e;
        long r121 = LinkMonitor.f252228b;
    L48:
        InteractLinkFullLinkMonitor.D(r115, r116, RangesKt.coerceAtLeast(r119, r120 - r121), true);
        goto L49
    L47:
        r120 = LinkMonitor.f252231e;
        r121 = LinkMonitor.f252229c;
        goto L48
    L43:
        r117 = LinkMonitor.f252233g;
        r118 = LinkMonitor.f252229c;
        goto L44
    L39:
        r115 = InteractLinkFullLinkMonitor.LinkSource.APPLY;
        goto L40
    L33:
        r109 = LinkMonitor.f252233g;
        r114 = LinkMonitor.f252229c;
        goto L35
    L29:
        r107 = LinkMonitor.f252231e;
        r108 = LinkMonitor.f252229c;
        goto L30
    L25:
        r105 = InteractLinkFullLinkMonitor.LinkSource.APPLY;
        goto L26
    L21:
        r104 = 0;
        goto L22
    L17:
        r103 = LinkMonitor.f252231e;
        r113 = LinkMonitor.f252229c;
        goto L18
    L13:
        r111 = LinkMonitor.f252233g;
        r112 = LinkMonitor.f252229c;
        goto L14
    L5:
        if (r101 != 2) goto L49;
        LinkMonitor.a("PipeLineM", "replyLinkDuration", "[duration] first_frame " + (LinkMonitor.f252233g - LinkMonitor.f252227a) + " link " + (LinkMonitor.f252231e - LinkMonitor.f252227a) + " replyApi " + LinkMonitor.f252237k + " rtc " + (LinkMonitor.f252232f - LinkMonitor.f252230d) + " linkOptInfo " + LinkMonitor.f252235i, null, null, true, 56);
        InteractLinkFullLinkMonitor.LinkSource r122 = InteractLinkFullLinkMonitor.LinkSource.REPLY;
        InteractLinkFullLinkMonitor.D(r122, LinkMonitor.f252235i, LinkMonitor.f252231e - LinkMonitor.f252227a, false);
        if ((LinkMonitor.f252233g - LinkMonitor.f252227a) <= 0) goto L49;
        InteractLinkFullLinkMonitor.D(r122, LinkMonitor.f252235i, RangesKt.coerceAtLeast(LinkMonitor.f252233g - LinkMonitor.f252227a, LinkMonitor.f252231e - LinkMonitor.f252227a), true);
        goto L49
    }
}
