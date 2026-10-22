package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import s9.InterfaceC5453e;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR+\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR+\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/x;", "", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "bag", "<init>", "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;)V", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "", "<set-?>", "glowDelayS$delegate", "Ls9/e;", Const.INTENT_KEY_APIKEY, "()F", "setGlowDelayS", "(F)V", "glowDelayS", "rippleDelayS$delegate", Const.INTENT_KEY_PKGNAME, "setRippleDelayS", "rippleDelayS", "waterDelayS$delegate", "c", "setWaterDelayS", "waterDelayS", "waveStartAtS$delegate", "e", "setWaveStartAtS", "waveStartAtS", "waveIntroDurS$delegate", Const.INTENT_KEY_UMID, "setWaveIntroDurS", "waveIntroDurS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(x.class, "glowDelayS", "getGlowDelayS()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(x.class, "rippleDelayS", "getRippleDelayS()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(x.class, "waterDelayS", "getWaterDelayS()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(x.class, "waveStartAtS", "getWaveStartAtS()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(x.class, "waveIntroDurS", "getWaveIntroDurS()F", 0))};
    private final C3077q bag;

    /* renamed from: glowDelayS$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e glowDelayS;

    /* renamed from: rippleDelayS$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e rippleDelayS;

    /* renamed from: waterDelayS$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e waterDelayS;

    /* renamed from: waveIntroDurS$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e waveIntroDurS;

    /* renamed from: waveStartAtS$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e waveStartAtS;

    public x(C3077q bag) {
        kotlin.jvm.internal.p.i(bag, "bag");
        this.bag = bag;
        this.glowDelayS = bag.e("glowDelayS");
        this.rippleDelayS = bag.e("rippleDelayS");
        this.waterDelayS = bag.e("waterDelayS");
        this.waveStartAtS = bag.e("waveStartAtS");
        this.waveIntroDurS = bag.e("waveIntroDurS");
    }

    public final float a() {
        return ((Number) this.glowDelayS.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final float b() {
        return ((Number) this.rippleDelayS.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final float c() {
        return ((Number) this.waterDelayS.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    public final float d() {
        return ((Number) this.waveIntroDurS.getValue(this, $$delegatedProperties[4])).floatValue();
    }

    public final float e() {
        return ((Number) this.waveStartAtS.getValue(this, $$delegatedProperties[3])).floatValue();
    }
}
