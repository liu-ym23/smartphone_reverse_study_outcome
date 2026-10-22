package com.stepos.agentframework;

import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/widget/TextView;", "Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "style", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;Lcom/stepos/agentframework/AgentUIConfig$TextStyle;)V", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final void a(TextView textView, AgentUIConfig.TextStyle textStyle) {
        p.i(textView, "<this>");
        if (textStyle == null) {
            return;
        }
        if (textStyle.getTextColor() != -1) {
            textView.setTextColor(textStyle.getTextColor());
        }
        if (textStyle.getTextSizeSp() > 0.0f) {
            textView.setTextSize(2, textStyle.getTextSizeSp());
        }
        if (textStyle.getLineSpacingMultiplier() > 0.0f) {
            textView.setLineSpacing(0.0f, textStyle.getLineSpacingMultiplier());
        }
    }
}
