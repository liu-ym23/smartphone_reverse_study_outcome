package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f140255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoMoreSpaceTextView f140256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.o f140257c;

    public l(Context r100, com.bytedance.android.livesdk.interactivity.api.entity.l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        View r102 = LayoutInflater.from(r100).inflate(R.layout.ttlive_message_view_create, null);
        this.f140255a = r102;
        NoMoreSpaceTextView r103 = (NoMoreSpaceTextView) r102.findViewById(R.id.message_content);
        this.f140256b = r103;
        IRoomContextService r104 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r104 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r105 = IRoomContextService.a.a(r104, null, 0, 3);
    L6:
        this.f140257c = r105;
        int r106 = da2.a.f467668a;
        if (r105 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r105 == null) goto L14;
        Boolean r108 = r105.isAnchor();
    L15:
        da2.b r109 = new da2.b(new da2.c(r107, Intrinsics.areEqual(r108, Boolean.TRUE), null));
        q92.a r110 = new q92.a();
        Intrinsics.checkNotNullParameter(r110, "config");
        da2.b r111 = new da2.b(new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.b(r110));
        t r112 = r101.f133174b;
        s r113 = r101.f133173a;
        if (r113 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r114 = r111.b(r113, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new k(this));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r115 = r114.f133516b;
        if (r115 != null) goto L20;
    L22:
        r103.setText(r114.f133515a);
        return;
    L20:
        if (r115.f133511a != true) goto L22;
        r103.setAlwaysInvalidate(true);
        goto L22
    L23:
        com.bytedance.android.livesdk.interactivity.api.entity.f r116 = i0.e(r112, MessageSceneType.PUBLIC_SCREEN, null);
        if (r116 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r117 = r109.b(r116, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new j(this));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r118 = r117.f133516b;
        if (r118 != null) goto L28;
    L30:
        r103.setText(r117.f133515a);
        return;
    L28:
        if (r118.f133511a != true) goto L30;
        r103.setAlwaysInvalidate(true);
        goto L30
    L33:
        return;
    L14:
        r108 = null;
        goto L15
    L9:
        if (r105.isMediaRoom() != true) goto L11;
        r107 = true;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
