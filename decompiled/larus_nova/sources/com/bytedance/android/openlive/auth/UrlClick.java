package com.bytedance.android.openlive.auth;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/openlive/auth/UrlClick;", "Landroid/text/style/ClickableSpan;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getUrl", "()Ljava/lang/String;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class UrlClick extends ClickableSpan {
    private final Context context;
    private final String url;

    public final Context getContext() {
        return this.context;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        ((IBrowserService) k.n(IBrowserService.class)).buildFullScreenWebPage(this.context, this.url).b();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
    }

    public UrlClick(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        this.context = r100;
        this.url = r101;
    }
}
