package com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.b;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import fd2.z;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public final class SeatAnimEngineWrapper implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeatAnimManager f75864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiSoundManager f75865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f75866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f75867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f75868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f75869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f75870g;

    public final void b() {
        this.f75867d.clear();
        SeatAnimManager r100 = this.f75864a;
        if (r100 == null) goto L5;
        ((LinkedHashMap) r100.f72201a).clear();
    L5:
        d r101 = this.f75866c;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        EmojiSoundManager r102 = this.f75865b;
        if (r102 == null) goto L12;
        r102.c();
        return;
    }

    public final void a() {
        Boolean r100 = m.i().isAnchor();
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        this.f75864a = new SeatAnimManager(SeatAnimEngineWrapper$attach$1.INSTANCE);
        this.f75865b = new EmojiSoundManager(this.f75869f, r101, this.f75870g);
        d r102 = (d) this.f75868e.get("data_message_manager");
        this.f75866c = r102;
        if (r102 == null) goto L9;
        r102.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getKey(), this);
    L9:
        IKtvService r103 = (IKtvService) k.f(IKtvService.class);
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.k<z> r104 = r103.ktvComponentSingerChangedEvent();
        if (r104 == null) goto L16;
        Disposable r105 = r104.onEvent().subscribe(new a(this));
        if (r105 == null) goto L16;
        RxUtilKt.c(r105, this.f75867d);
    L16:
        IKtvService r106 = (IKtvService) k.f(IKtvService.class);
        if (r106 == null) goto L24;
        za r107 = r106.ktvCurrentSingerOrderInfo();
        if (r107 == null) goto L25;
        SeatAnimManager r108 = this.f75864a;
        if (r108 == null) goto L26;
        r108.d(r107);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof w8) == false) goto L29;
        w8 r101 = (w8) r100;
        if (r101.isThanksInteractEmoji() == false) goto L10;
        b.f79516r0.getClass();
        if (b.C1237b.b() == true) goto L10;
        return;
    L10:
        if (r101.isFriendTreeInteractEmoji() == false) goto L13;
        return;
    L13:
        if (r101.isInteractEmoji() == false) goto L16;
        this.f75868e.put("cmd_show_dynamic_emoji_in_comment", r101);
        return;
    L16:
        if (r101.isSoundEmoji() == false) goto L20;
        EmojiSoundManager r102 = this.f75865b;
        if (r102 == null) goto L20;
        r102.d(r101);
    L20:
        b.f79516r0.getClass();
        if (b.C1237b.b() == true) goto L23;
    L25:
        SeatAnimManager r103 = this.f75864a;
        if (r103 == null) goto L31;
        int r104 = p.f72337a;
        r103.b(p.a(ag1.b.a(r101)));
        return;
    L31:
        return;
    L23:
        if (r101.isThanksInteractEmoji() == false) goto L25;
        this.f75868e.put("cmd_show_dynamic_emoji_in_comment", r101);
        goto L25
    }

    public SeatAnimEngineWrapper(int r100, DataCenter r101, Context r102, com.bytedance.android.live.pushstream.d r103) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f75868e = r101;
        this.f75869f = r102;
        this.f75870g = r103;
        this.f75867d = new CompositeDisposable();
    }
}
