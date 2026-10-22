package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class e extends jg0.a<MultiLinkSpecialViewBinder.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiLinkSpecialViewBinder.a f75750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f75751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f75752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f75753h;

    public void r() {
        throw null;
    }

    @Override // jg0.c, jg0.f
    public void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        this.f75751f = (HSImageView) q().findViewById(R.id.ttlive_empty_bg);
        this.f75753h = (ImageView) q().findViewById(R.id.ttlive_lock);
        this.f75752g = q().findViewById(R.id.ttlive_empty_content);
        TextView r101 = (TextView) q().findViewById(R.id.ttlive_empty_tips);
    }

    public void s(MultiLinkSpecialViewBinder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        this.f75750e = r100;
        if (r100 != null) goto L5;
    L9:
        ImageView r101 = this.f75753h;
        if (r101 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r101);
    L12:
        r();
        return;
    L5:
        if (r100.f75986l != LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L9;
        ImageView r102 = this.f75753h;
        if (r102 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r102);
        goto L12
    }

    public e(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        super(r100, r101);
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r100, int r101, Bundle r102) {
        t((MultiLinkSpecialViewBinder.a) r100, r101, r102);
    }

    public void t(MultiLinkSpecialViewBinder.a r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        this.f75750e = r100;
    }
}
