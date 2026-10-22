package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceStickerServiceWidget.b f118805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f118806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f118807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f118808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zg1.o f118809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f118810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AudienceStickerServiceWidget$onLoad$1$1 f118811g;

    public g(AudienceStickerServiceWidget.b r100, Ref.BooleanRef r101, boolean r102, Ref.ObjectRef r103, zg1.o r104, List r105, AudienceStickerServiceWidget$onLoad$1$1 r106) {
        this.f118805a = r100;
        this.f118806b = r101;
        this.f118807c = r102;
        this.f118808d = r103;
        this.f118809e = r104;
        this.f118810f = r105;
        this.f118811g = r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Sticker r102 = (Sticker) r100;
        Throwable r103 = (Throwable) r101;
        boolean r104 = this.f118806b.element;
        if (r104 == true) goto L5;
    L14:
        if (r104 == false) goto L16;
    L26:
        zg1.q r105 = this.f118809e.f571893d;
        if (r105 == null) goto L38;
        zg1.q.a.a(r105, false);
        return;
    L38:
        return;
    L16:
        if (this.f118807c == false) goto L26;
        if (Intrinsics.areEqual((String) this.f118808d.element, com.bytedance.android.live.effect.api.d0.f66753c) == false) goto L23;
        Sticker r106 = (Sticker) CollectionsKt.firstOrNull(this.f118810f);
        if (r106 == null) goto L22;
        com.bytedance.android.livesdk.widget.z0 r107 = com.bytedance.android.livesdk.widget.z0.a();
        Context r108 = this.f118805a.f118452a.getContext();
        r107.getClass();
        com.bytedance.android.livesdk.widget.x0.b r109 = new com.bytedance.android.livesdk.widget.x0.b(r108, 4);
        r109.f162238a.f162253l = false;
        r109.l(R.string.ttlive_link_change_sticker_content);
        r109.i(0, R.string.ttlive_link_confirm_change_sticker, new e(this, r106, r102));
        r109.i(1, R.string.ttlive_link_cancel_change_sticker, new f(this));
        r109.k(0, true);
        r109.n();
        return;
    L22:
        this.f118811g.invoke2(r106, r102);
        return;
    L23:
        zg1.q r110 = this.f118809e.f571893d;
        if (r110 == null) goto L36;
        zg1.q.a.a(r110, false);
        return;
    L36:
        return;
    L5:
        if (this.f118807c == true) goto L14;
        if (Intrinsics.areEqual((String) this.f118808d.element, com.bytedance.android.live.effect.api.d0.f66753c) == false) goto L11;
        List<String> r111 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.LINK).a().O((String) this.f118808d.element, r102, "AudienceStickerServiceWidget_changeSelectSticker_unselect");
        zg1.q r112 = this.f118809e.f571893d;
        if (r112 == null) goto L30;
        zg1.q.a.a(r112, true);
        return;
    L30:
        return;
    L11:
        zg1.q r113 = this.f118809e.f571893d;
        if (r113 == null) goto L32;
        zg1.q.a.a(r113, false);
        return;
    }
}
