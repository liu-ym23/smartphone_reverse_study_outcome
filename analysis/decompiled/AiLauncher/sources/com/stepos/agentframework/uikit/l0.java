package com.stepos.agentframework.uikit;

import android.os.Handler;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/agentframework/uikit/l0;", "", "Landroid/widget/TextView;", "textView", "Landroid/os/Handler;", "mainHandler", "Lkotlin/Function1;", "", "LY8/t;", "applyMarkdown", "<init>", "(Landroid/widget/TextView;Landroid/os/Handler;Lp9/l;)V", "normalized", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "delayMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", Const.INTENT_KEY_PKGNAME, "f", "", "c", "()I", "Landroid/widget/TextView;", "Landroid/os/Handler;", "Lp9/l;", "incoming", "Ljava/lang/String;", "laidOut", "", "chunkPosted", "Z", "Ljava/lang/Runnable;", "pumpChunkRunnable", "Ljava/lang/Runnable;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class l0 {
    private final InterfaceC5074l<String, Y8.t> applyMarkdown;
    private boolean chunkPosted;
    private String incoming;
    private String laidOut;
    private final Handler mainHandler;
    private final Runnable pumpChunkRunnable;
    private final TextView textView;

    /* JADX WARN: Multi-variable type inference failed */
    public l0(TextView textView, Handler mainHandler, InterfaceC5074l<? super String, Y8.t> applyMarkdown) {
        kotlin.jvm.internal.p.i(textView, "textView");
        kotlin.jvm.internal.p.i(mainHandler, "mainHandler");
        kotlin.jvm.internal.p.i(applyMarkdown, "applyMarkdown");
        this.textView = textView;
        this.mainHandler = mainHandler;
        this.applyMarkdown = applyMarkdown;
        this.incoming = "";
        this.laidOut = "";
        this.pumpChunkRunnable = new Runnable() { // from class: com.stepos.agentframework.uikit.k0
            @Override // java.lang.Runnable
            public final void run() {
                l0.g(this.f23322a);
            }
        };
    }

    public static final void g(l0 l0Var) {
        l0Var.f();
    }

    public final void b() {
        this.chunkPosted = false;
        this.mainHandler.removeCallbacks(this.pumpChunkRunnable);
    }

    public final int c() {
        int width = (this.textView.getWidth() - this.textView.getTotalPaddingLeft()) - this.textView.getTotalPaddingRight();
        float fMeasureText = this.textView.getPaint().measureText("中");
        if (width <= 0 || fMeasureText <= 0.0f) {
            return 16;
        }
        return C5685n.n((int) (width / fMeasureText), 4, 80);
    }

    public final void d() {
        b();
        if (this.incoming.length() <= 0 || kotlin.jvm.internal.p.d(this.incoming, this.laidOut)) {
            return;
        }
        this.applyMarkdown.invoke(this.incoming);
        this.laidOut = this.incoming;
    }

    public final void e(String normalized) {
        kotlin.jvm.internal.p.i(normalized, "normalized");
        this.incoming = normalized;
        if (this.laidOut.length() < this.incoming.length()) {
            j(this.laidOut.length() == 0 ? 0L : 420L);
        }
    }

    public final void f() {
        int iA;
        this.chunkPosted = false;
        if (this.laidOut.length() < this.incoming.length() && (iA = m0.INSTANCE.a(this.incoming, this.laidOut.length(), c())) > this.laidOut.length()) {
            String strSubstring = this.incoming.substring(0, iA);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            this.applyMarkdown.invoke(strSubstring);
            this.laidOut = strSubstring;
            if (strSubstring.length() < this.incoming.length()) {
                j(420L);
            }
        }
    }

    public final void h(String normalized) {
        kotlin.jvm.internal.p.i(normalized, "normalized");
        b();
        this.incoming = normalized;
        this.applyMarkdown.invoke(normalized);
        this.laidOut = normalized;
    }

    public final void i() {
        b();
        this.incoming = "";
        this.laidOut = "";
    }

    public final void j(long delayMs) {
        if (this.chunkPosted) {
            return;
        }
        this.chunkPosted = true;
        if (delayMs <= 0) {
            this.mainHandler.post(this.pumpChunkRunnable);
        } else {
            this.mainHandler.postDelayed(this.pumpChunkRunnable, delayMs);
        }
    }
}
