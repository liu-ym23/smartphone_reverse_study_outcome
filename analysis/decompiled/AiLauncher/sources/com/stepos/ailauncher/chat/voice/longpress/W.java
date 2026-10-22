package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0003R$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/W;", "", "<init>", "()V", "", "deltaSeconds", "", Const.INTENT_KEY_APIKEY, "(D)F", "LY8/t;", Const.INTENT_KEY_PKGNAME, UxipConstants.f30680s, "F", "getValue", "()F", "target", "getTarget", "c", "(F)V", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W {

    @Deprecated
    public static final double ATTACK_SECONDS = 0.1d;
    private static final a Companion = new a(null);

    @Deprecated
    public static final double MAX_STEP_SECONDS = 0.03333333333333333d;

    @Deprecated
    public static final double RELEASE_SECONDS = 0.16d;
    private float target;
    private float value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/W$a;", "", "<init>", "()V", "", "ATTACK_SECONDS", "D", "RELEASE_SECONDS", "MAX_STEP_SECONDS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public final float a(double deltaSeconds) {
        if (Math.abs(deltaSeconds) > Double.MAX_VALUE || deltaSeconds <= 0.0d) {
            return this.value;
        }
        double dExp = 1.0d - Math.exp((-C5685n.h(deltaSeconds, 0.03333333333333333d)) / (this.target > this.value ? 0.1d : 0.16d));
        float fM = C5685n.m((float) (this.value + ((this.target - r5) * dExp)), 0.0f, 1.0f);
        this.value = fM;
        return fM;
    }

    public final void b() {
        this.value = 0.0f;
        c(0.0f);
    }

    public final void c(float f10) {
        this.target = Math.abs(f10) <= Float.MAX_VALUE ? C5685n.m(f10, 0.0f, 1.0f) : 0.0f;
    }
}
