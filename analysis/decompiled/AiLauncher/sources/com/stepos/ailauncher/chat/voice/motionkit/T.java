package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import s9.InterfaceC5453e;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0003\b¥\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR+\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR+\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR+\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR+\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR+\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR+\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR+\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\n\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR+\u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\n\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR+\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\n\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR+\u0010?\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\n\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR+\u0010C\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\n\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000eR+\u0010G\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\n\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR+\u0010K\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\n\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR+\u0010O\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\n\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR+\u0010S\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010\n\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR+\u0010W\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010\n\u001a\u0004\bU\u0010\f\"\u0004\bV\u0010\u000eR+\u0010[\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010\n\u001a\u0004\bY\u0010\f\"\u0004\bZ\u0010\u000eR+\u0010_\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\n\u001a\u0004\b]\u0010\f\"\u0004\b^\u0010\u000eR+\u0010c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\n\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR+\u0010g\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010\n\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR+\u0010k\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010\n\u001a\u0004\bi\u0010\f\"\u0004\bj\u0010\u000eR+\u0010o\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bl\u0010\n\u001a\u0004\bm\u0010\f\"\u0004\bn\u0010\u000eR+\u0010s\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010\n\u001a\u0004\bq\u0010\f\"\u0004\br\u0010\u000eR+\u0010w\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bt\u0010\n\u001a\u0004\bu\u0010\f\"\u0004\bv\u0010\u000eR+\u0010{\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bx\u0010\n\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR+\u0010\u007f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b|\u0010\n\u001a\u0004\b}\u0010\f\"\u0004\b~\u0010\u000eR/\u0010\u0083\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010\n\u001a\u0005\b\u0081\u0001\u0010\f\"\u0005\b\u0082\u0001\u0010\u000eR/\u0010\u0087\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\n\u001a\u0005\b\u0085\u0001\u0010\f\"\u0005\b\u0086\u0001\u0010\u000eR/\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\n\u001a\u0005\b\u0089\u0001\u0010\f\"\u0005\b\u008a\u0001\u0010\u000eR/\u0010\u008f\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010\n\u001a\u0005\b\u008d\u0001\u0010\f\"\u0005\b\u008e\u0001\u0010\u000eR/\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\n\u001a\u0005\b\u0091\u0001\u0010\f\"\u0005\b\u0092\u0001\u0010\u000eR/\u0010\u0097\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010\n\u001a\u0005\b\u0095\u0001\u0010\f\"\u0005\b\u0096\u0001\u0010\u000eR/\u0010\u009b\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\n\u001a\u0005\b\u0099\u0001\u0010\f\"\u0005\b\u009a\u0001\u0010\u000eR/\u0010\u009f\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\n\u001a\u0005\b\u009d\u0001\u0010\f\"\u0005\b\u009e\u0001\u0010\u000eR/\u0010£\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b \u0001\u0010\n\u001a\u0005\b¡\u0001\u0010\f\"\u0005\b¢\u0001\u0010\u000eR/\u0010§\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¤\u0001\u0010\n\u001a\u0005\b¥\u0001\u0010\f\"\u0005\b¦\u0001\u0010\u000eR/\u0010«\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¨\u0001\u0010\n\u001a\u0005\b©\u0001\u0010\f\"\u0005\bª\u0001\u0010\u000e¨\u0006¬\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/T;", "", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "bag", "<init>", "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;)V", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "", "<set-?>", "centerX$delegate", "Ls9/e;", "getCenterX", "()F", "setCenterX", "(F)V", "centerX", "centerY$delegate", "getCenterY", "setCenterY", "centerY", "maxRadius$delegate", "getMaxRadius", "setMaxRadius", "maxRadius", "sizeRef$delegate", "getSizeRef", "setSizeRef", "sizeRef", "sizeW0$delegate", "getSizeW0", "setSizeW0", "sizeW0", "sizeH0$delegate", "getSizeH0", "setSizeH0", "sizeH0", "sizeW1$delegate", "getSizeW1", "setSizeW1", "sizeW1", "sizeH1$delegate", "getSizeH1", "setSizeH1", "sizeH1", "duration$delegate", "getDuration", "setDuration", "duration", "ringGap$delegate", "getRingGap", "setRingGap", "ringGap", "exitDur$delegate", Const.INTENT_KEY_APIKEY, "setExitDur", "exitDur", "startWidth$delegate", "getStartWidth", "setStartWidth", "startWidth", "endWidth$delegate", "getEndWidth", "setEndWidth", "endWidth", "refract0$delegate", "getRefract0", "setRefract0", "refract0", "refract1$delegate", "getRefract1", "setRefract1", "refract1", "refractFadeAt$delegate", "getRefractFadeAt", "setRefractFadeAt", "refractFadeAt", "crestBlur0$delegate", "getCrestBlur0", "setCrestBlur0", "crestBlur0", "crestBlur1$delegate", "getCrestBlur1", "setCrestBlur1", "crestBlur1", "highlightAlpha$delegate", "getHighlightAlpha", "setHighlightAlpha", "highlightAlpha", "blur0$delegate", "getBlur0", "setBlur0", "blur0", "blur1$delegate", "getBlur1", "setBlur1", "blur1", "featherX1$delegate", "getFeatherX1", "setFeatherX1", "featherX1", "featherY1$delegate", "getFeatherY1", "setFeatherY1", "featherY1", "featherX2$delegate", "getFeatherX2", "setFeatherX2", "featherX2", "featherY2$delegate", "getFeatherY2", "setFeatherY2", "featherY2", "dispersion0$delegate", "getDispersion0", "setDispersion0", "dispersion0", "dispersion1$delegate", "getDispersion1", "setDispersion1", "dispersion1", "highlight0$delegate", "getHighlight0", "setHighlight0", "highlight0", "highlight$delegate", "getHighlight", "setHighlight", "highlight", "waveHeight$delegate", "getWaveHeight", "setWaveHeight", "waveHeight", "endHeight$delegate", "getEndHeight", "setEndHeight", "endHeight", "waveCount$delegate", "getWaveCount", "setWaveCount", "waveCount", "shininess$delegate", "getShininess", "setShininess", "shininess", "surfaceDepth$delegate", "getSurfaceDepth", "setSurfaceDepth", "surfaceDepth", "highlightBlend$delegate", "getHighlightBlend", "setHighlightBlend", "highlightBlend", "easeX1$delegate", "getEaseX1", "setEaseX1", "easeX1", "easeY1$delegate", "getEaseY1", "setEaseY1", "easeY1", "easeX2$delegate", "getEaseX2", "setEaseX2", "easeX2", "easeY2$delegate", "getEaseY2", "setEaseY2", "easeY2", "rings$delegate", "getRings", "setRings", "rings", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "centerX", "getCenterX()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "centerY", "getCenterY()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "maxRadius", "getMaxRadius()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "sizeRef", "getSizeRef()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "sizeW0", "getSizeW0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "sizeH0", "getSizeH0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "sizeW1", "getSizeW1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "sizeH1", "getSizeH1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "duration", "getDuration()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "ringGap", "getRingGap()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "exitDur", "getExitDur()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "startWidth", "getStartWidth()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "endWidth", "getEndWidth()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "refract0", "getRefract0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "refract1", "getRefract1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "refractFadeAt", "getRefractFadeAt()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "crestBlur0", "getCrestBlur0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "crestBlur1", "getCrestBlur1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "highlightAlpha", "getHighlightAlpha()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "blur0", "getBlur0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "blur1", "getBlur1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "featherX1", "getFeatherX1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "featherY1", "getFeatherY1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "featherX2", "getFeatherX2()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "featherY2", "getFeatherY2()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "dispersion0", "getDispersion0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "dispersion1", "getDispersion1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "highlight0", "getHighlight0()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "highlight", "getHighlight()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "waveHeight", "getWaveHeight()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "endHeight", "getEndHeight()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "waveCount", "getWaveCount()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "shininess", "getShininess()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "surfaceDepth", "getSurfaceDepth()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "highlightBlend", "getHighlightBlend()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "easeX1", "getEaseX1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "easeY1", "getEaseY1()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "easeX2", "getEaseX2()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "easeY2", "getEaseY2()F", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(T.class, "rings", "getRings()F", 0))};
    private final C3077q bag;

    /* renamed from: blur0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e blur0;

    /* renamed from: blur1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e blur1;

    /* renamed from: centerX$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e centerX;

    /* renamed from: centerY$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e centerY;

    /* renamed from: crestBlur0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e crestBlur0;

    /* renamed from: crestBlur1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e crestBlur1;

    /* renamed from: dispersion0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e dispersion0;

    /* renamed from: dispersion1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e dispersion1;

    /* renamed from: duration$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e duration;

    /* renamed from: easeX1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e easeX1;

    /* renamed from: easeX2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e easeX2;

    /* renamed from: easeY1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e easeY1;

    /* renamed from: easeY2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e easeY2;

    /* renamed from: endHeight$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e endHeight;

    /* renamed from: endWidth$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e endWidth;

    /* renamed from: exitDur$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e exitDur;

    /* renamed from: featherX1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e featherX1;

    /* renamed from: featherX2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e featherX2;

    /* renamed from: featherY1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e featherY1;

    /* renamed from: featherY2$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e featherY2;

    /* renamed from: highlight$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e highlight;

    /* renamed from: highlight0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e highlight0;

    /* renamed from: highlightAlpha$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e highlightAlpha;

    /* renamed from: highlightBlend$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e highlightBlend;

    /* renamed from: maxRadius$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e maxRadius;

    /* renamed from: refract0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e refract0;

    /* renamed from: refract1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e refract1;

    /* renamed from: refractFadeAt$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e refractFadeAt;

    /* renamed from: ringGap$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e ringGap;

    /* renamed from: rings$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e rings;

    /* renamed from: shininess$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e shininess;

    /* renamed from: sizeH0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e sizeH0;

    /* renamed from: sizeH1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e sizeH1;

    /* renamed from: sizeRef$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e sizeRef;

    /* renamed from: sizeW0$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e sizeW0;

    /* renamed from: sizeW1$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e sizeW1;

    /* renamed from: startWidth$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e startWidth;

    /* renamed from: surfaceDepth$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e surfaceDepth;

    /* renamed from: waveCount$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e waveCount;

    /* renamed from: waveHeight$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e waveHeight;

    public T(C3077q bag) {
        kotlin.jvm.internal.p.i(bag, "bag");
        this.bag = bag;
        this.centerX = bag.e("uCenterX");
        this.centerY = bag.e("uCenterY");
        this.maxRadius = bag.e("uMaxRadius");
        this.sizeRef = bag.e("uSizeRef");
        this.sizeW0 = bag.e("uSizeW0");
        this.sizeH0 = bag.e("uSizeH0");
        this.sizeW1 = bag.e("uSizeW1");
        this.sizeH1 = bag.e("uSizeH1");
        this.duration = bag.e("uDuration");
        this.ringGap = bag.e("uRingGap");
        this.exitDur = bag.e("uExitDur");
        this.startWidth = bag.e("uStartWidth");
        this.endWidth = bag.e("uEndWidth");
        this.refract0 = bag.e("uRefract0");
        this.refract1 = bag.e("uRefract1");
        this.refractFadeAt = bag.e("uRefractFadeAt");
        this.crestBlur0 = bag.e("uCrestBlur0");
        this.crestBlur1 = bag.e("uCrestBlur1");
        this.highlightAlpha = bag.e("uHighlightAlpha");
        this.blur0 = bag.e("uBlur0");
        this.blur1 = bag.e("uBlur1");
        this.featherX1 = bag.e("uFeatherX1");
        this.featherY1 = bag.e("uFeatherY1");
        this.featherX2 = bag.e("uFeatherX2");
        this.featherY2 = bag.e("uFeatherY2");
        this.dispersion0 = bag.e("uDispersion0");
        this.dispersion1 = bag.e("uDispersion1");
        this.highlight0 = bag.e("uHighlight0");
        this.highlight = bag.e("uHighlight");
        this.waveHeight = bag.e("uWaveHeight");
        this.endHeight = bag.e("uEndHeight");
        this.waveCount = bag.e("uWaveCount");
        this.shininess = bag.e("uShininess");
        this.surfaceDepth = bag.e("uSurfaceDepth");
        this.highlightBlend = bag.e("uHighlightBlend");
        this.easeX1 = bag.e("uEaseX1");
        this.easeY1 = bag.e("uEaseY1");
        this.easeX2 = bag.e("uEaseX2");
        this.easeY2 = bag.e("uEaseY2");
        this.rings = bag.e("uRings");
    }

    public final float a() {
        return ((Number) this.exitDur.getValue(this, $$delegatedProperties[10])).floatValue();
    }
}
