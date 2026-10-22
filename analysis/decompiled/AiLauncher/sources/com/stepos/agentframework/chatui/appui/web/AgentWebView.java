package com.stepos.agentframework.chatui.appui.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/web/AgentWebView;", "Landroid/webkit/WebView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes2.dex */
public final class AgentWebView extends WebView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger liveWebViews = new AtomicInteger(0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/web/AgentWebView$a;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "liveWebViews", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/atomic/AtomicInteger;", "getLiveWebViews$annotations", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.web.AgentWebView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AtomicInteger a() {
            return AgentWebView.liveWebViews;
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p.i(context, "context");
        p.i(attrs, "attrs");
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowFileAccess(false);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setMixedContentMode(0);
        getSettings().setCacheMode(2);
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowContentAccess(true);
        setWebChromeClient(new WebChromeClient());
    }

    public static final int c(int i10) {
        if (i10 > 0) {
            return i10 - 1;
        }
        return 0;
    }

    public static final AtomicInteger getLiveWebViews() {
        return INSTANCE.a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        liveWebViews.incrementAndGet();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        liveWebViews.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.agentframework.chatui.appui.web.a
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return AgentWebView.c(i10);
            }
        });
        super.onDetachedFromWindow();
    }
}
