package com.stepos.ailauncher.sheet.internal;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/M;", "", "", "offset", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "Lkotlin/Function2;", "LY8/t;", "onFrame", "<init>", "(FFLp9/p;)V", UxipConstants.f30680s, "f", "(F)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "()V", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "F", "Lp9/p;", "", "offsetUpdated", "Z", "scaleUpdated", "offsetFinished", "scaleFinished", "canceled", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M {
    private boolean canceled;
    private float offset;
    private boolean offsetFinished;
    private boolean offsetUpdated;
    private final p9.p<Float, Float, Y8.t> onFrame;
    private float scale;
    private boolean scaleFinished;
    private boolean scaleUpdated;

    /* JADX WARN: Multi-variable type inference failed */
    public M(float f10, float f11, p9.p<? super Float, ? super Float, Y8.t> onFrame) {
        kotlin.jvm.internal.p.i(onFrame, "onFrame");
        this.offset = f10;
        this.scale = f11;
        this.onFrame = onFrame;
    }

    public final void a() {
        this.canceled = true;
        this.offsetUpdated = false;
        this.scaleUpdated = false;
    }

    public final void b() {
        if (this.offsetUpdated || this.offsetFinished) {
            if (this.scaleUpdated || this.scaleFinished) {
                e();
            }
        }
    }

    public final void c() {
        this.offsetFinished = true;
        b();
    }

    public final void d() {
        this.scaleFinished = true;
        b();
    }

    public final void e() {
        if (this.canceled) {
            return;
        }
        if (this.offsetUpdated || this.scaleUpdated) {
            this.offsetUpdated = false;
            this.scaleUpdated = false;
            this.onFrame.invoke(Float.valueOf(this.offset), Float.valueOf(this.scale));
        }
    }

    public final void f(float value) {
        this.offset = value;
        this.offsetUpdated = true;
        b();
    }

    public final void g(float value) {
        this.scale = value;
        this.scaleUpdated = true;
        b();
    }
}
