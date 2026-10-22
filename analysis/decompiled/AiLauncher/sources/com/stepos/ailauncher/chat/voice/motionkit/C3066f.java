package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import s9.InterfaceC5453e;
import v9.C5685n;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b,\n\u0002\u0010\u0014\n\u0002\b;\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR+\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR+\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR+\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR+\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR+\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR+\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR+\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\n\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR+\u0010:\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\n\u001a\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010>\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\n\u001a\u0004\b<\u00107\"\u0004\b=\u00109R+\u0010B\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\n\u001a\u0004\b@\u00107\"\u0004\bA\u00109R+\u0010F\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\n\u001a\u0004\bD\u00107\"\u0004\bE\u00109R+\u0010J\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010\n\u001a\u0004\bH\u00107\"\u0004\bI\u00109R+\u0010N\u001a\u0002042\u0006\u0010\b\u001a\u0002048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\n\u001a\u0004\bL\u00107\"\u0004\bM\u00109R+\u0010R\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\n\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR+\u0010V\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010\n\u001a\u0004\bT\u0010\f\"\u0004\bU\u0010\u000eR+\u0010Z\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\n\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR+\u0010^\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010\n\u001a\u0004\b\\\u0010\f\"\u0004\b]\u0010\u000eR+\u0010b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010\n\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010\u000eR+\u0010f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010\n\u001a\u0004\bd\u0010\f\"\u0004\be\u0010\u000eR+\u0010j\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010\n\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR$\u0010n\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010\f\"\u0004\bm\u0010\u000e¨\u0006o"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/f;", "", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "bag", "<init>", "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;)V", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "", "<set-?>", "amp$delegate", "Ls9/e;", "getAmp", "()F", "setAmp", "(F)V", "amp", "freq$delegate", "getFreq", "setFreq", "freq", "speed$delegate", "getSpeed", "setSpeed", Const.JSON_KEY_SPEED, "len$delegate", "getLen", "setLen", "len", "taper$delegate", "getTaper", "setTaper", "taper", "fade$delegate", "getFade", "setFade", "fade", "offsetY$delegate", "getOffsetY", "setOffsetY", "offsetY", "phase1$delegate", "getPhase1", "setPhase1", "phase1", "phase2$delegate", "getPhase2", "setPhase2", "phase2", "phase3$delegate", "getPhase3", "setPhase3", "phase3", "", "stroke1$delegate", "getStroke1", "()[F", "setStroke1", "([F)V", "stroke1", "stroke2$delegate", "getStroke2", "setStroke2", "stroke2", "stroke3$delegate", "getStroke3", "setStroke3", "stroke3", "fill1$delegate", "getFill1", "setFill1", "fill1", "fill2$delegate", "getFill2", "setFill2", "fill2", "fill3$delegate", "getFill3", "setFill3", "fill3", "glowUp$delegate", "getGlowUp", "setGlowUp", "glowUp", "glowDn$delegate", "getGlowDn", "setGlowDn", "glowDn", "inten$delegate", "getInten", Const.INTENT_KEY_PKGNAME, "inten", "fillSoft$delegate", "getFillSoft", "setFillSoft", "fillSoft", "fillOp$delegate", "getFillOp", "setFillOp", "fillOp", "fillAdd$delegate", "getFillAdd", "setFillAdd", "fillAdd", "exitDur$delegate", Const.INTENT_KEY_APIKEY, "setExitDur", "exitDur", UxipConstants.f30680s, "getVolume", "c", "volume", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3066f {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "amp", "getAmp()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "freq", "getFreq()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, Const.JSON_KEY_SPEED, "getSpeed()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "len", "getLen()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "taper", "getTaper()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fade", "getFade()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "offsetY", "getOffsetY()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "phase1", "getPhase1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "phase2", "getPhase2()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "phase3", "getPhase3()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "stroke1", "getStroke1()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "stroke2", "getStroke2()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "stroke3", "getStroke3()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fill1", "getFill1()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fill2", "getFill2()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fill3", "getFill3()[F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "glowUp", "getGlowUp()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "glowDn", "getGlowDn()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "inten", "getInten()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fillSoft", "getFillSoft()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fillOp", "getFillOp()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "fillAdd", "getFillAdd()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(C3066f.class, "exitDur", "getExitDur()F", 0))};

    /* renamed from: amp$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e amp;
    private final C3077q bag;

    /* renamed from: exitDur$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e exitDur;

    /* renamed from: fade$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fade;

    /* renamed from: fill1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fill1;

    /* renamed from: fill2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fill2;

    /* renamed from: fill3$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fill3;

    /* renamed from: fillAdd$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fillAdd;

    /* renamed from: fillOp$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fillOp;

    /* renamed from: fillSoft$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fillSoft;

    /* renamed from: freq$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e freq;

    /* renamed from: glowDn$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e glowDn;

    /* renamed from: glowUp$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e glowUp;

    /* renamed from: inten$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e inten;

    /* renamed from: len$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e len;

    /* renamed from: offsetY$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e offsetY;

    /* renamed from: phase1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e phase1;

    /* renamed from: phase2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e phase2;

    /* renamed from: phase3$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e phase3;

    /* renamed from: speed$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e speed;

    /* renamed from: stroke1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e stroke1;

    /* renamed from: stroke2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e stroke2;

    /* renamed from: stroke3$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e stroke3;

    /* renamed from: taper$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e taper;

    public C3066f(C3077q bag) {
        kotlin.jvm.internal.p.i(bag, "bag");
        this.bag = bag;
        this.amp = bag.e("uAmp");
        this.freq = bag.e("uFreq");
        this.speed = bag.e("uSpeed");
        this.len = bag.e("uLen");
        this.taper = bag.e("uTaper");
        this.fade = bag.e("uFade");
        this.offsetY = bag.e("uOffsetY");
        this.phase1 = bag.e("uPhase1");
        this.phase2 = bag.e("uPhase2");
        this.phase3 = bag.e("uPhase3");
        this.stroke1 = bag.j("uCol1");
        this.stroke2 = bag.j("uCol2");
        this.stroke3 = bag.j("uCol3");
        this.fill1 = bag.j("uFillCol1");
        this.fill2 = bag.j("uFillCol2");
        this.fill3 = bag.j("uFillCol3");
        this.glowUp = bag.e("uGlowUp");
        this.glowDn = bag.e("uGlowDn");
        this.inten = bag.e("uInten");
        this.fillSoft = bag.e("uFillSoft");
        this.fillOp = bag.e("uFillOp");
        this.fillAdd = bag.e("uFillAdd");
        this.exitDur = bag.e("uExitDur");
    }

    public final float a() {
        return ((Number) this.exitDur.getValue(this, $$delegatedProperties[22])).floatValue();
    }

    public final void b(float f10) {
        this.inten.setValue(this, $$delegatedProperties[18], Float.valueOf(f10));
    }

    public final void c(float f10) {
        float fM = C5685n.m(f10, 0.0f, 1.0f);
        C3077q.i(this.bag, "uExtEnergy", new float[]{1.0f}, false, 4, null);
        C3077q.i(this.bag, "uEnergyIn", new float[]{fM}, false, 4, null);
    }
}
