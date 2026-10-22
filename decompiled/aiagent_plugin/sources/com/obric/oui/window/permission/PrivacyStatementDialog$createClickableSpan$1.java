package com.obric.oui.window.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PrivacyStatementDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyStatementDialog$createClickableSpan$1 extends ClickableSpan {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;
    final /* synthetic */ a this$0;

    PrivacyStatementDialog$createClickableSpan$1(String r3, a r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.$url = r3;
        this.this$0 = r4;
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r5) {
        o.e(r5, "widget");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$url, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L22;
        b r8 = a.a(this.this$0);
        if (r8 != null) goto L13;
        x r9 = null;
    L14:
        if (r9 != null) goto L23;
        String r10 = this.$url;
        Context r2 = this.$context;
        PrivacyStatementDialog$createClickableSpan$1 r4 = (PrivacyStatementDialog$createClickableSpan$1) ZeusTransformUtils.preCheckCast(this, PrivacyStatementDialog$createClickableSpan$1.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.startActivity(r2, new Intent("android.intent.action.VIEW", Uri.parse(r10)), "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        return;
    L18:
        Toast.makeText(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.no_browser, WsChannelMultiProcessSharedProvider.STRING_TYPE, "no_browser")), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L23:
        return;
    L13:
        r8.invoke(this.$url);
        r9 = x.f38692a;
        goto L14
    L22:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r4) {
        o.e(r4, "ds");
        super.updateDrawState(r4);
        r4.setColor(androidx.core.content.a.c(this.$context, ZeusTransformUtils.mapRes(R.color.oui_fill_highlighted, "color", "oui_fill_highlighted")));
        r4.setUnderlineText(false);
    }
}
