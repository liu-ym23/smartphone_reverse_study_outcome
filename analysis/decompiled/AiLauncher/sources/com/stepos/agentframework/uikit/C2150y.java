package com.stepos.agentframework.uikit;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/uikit/y;", "", "Lu8/e;", "markdown", "Landroid/widget/TextView;", "view", "<init>", "(Lu8/e;Landroid/widget/TextView;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Lu8/e;", "Landroid/widget/TextView;", "", "globalTime", "J", "", "TAG", "Ljava/lang/String;", "markdownStr", "getMarkdownStr", "()Ljava/lang/String;", "setMarkdownStr", "(Ljava/lang/String;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.uikit.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2150y {
    private final String TAG;
    private long globalTime;
    private final u8.e markdown;
    private String markdownStr;
    private final TextView view;

    public C2150y(u8.e markdown, TextView view) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        kotlin.jvm.internal.p.i(view, "view");
        this.markdown = markdown;
        this.view = view;
        this.TAG = "DynamicTypeAnimator";
        this.markdownStr = "";
    }

    public final void a() {
        Spanned spannedH = this.markdown.h(this.markdownStr);
        kotlin.jvm.internal.p.h(spannedH, "toMarkdown(...)");
        SpannableString spannableString = new SpannableString(spannedH);
        int length = spannedH.length();
        if (length > 10) {
            int iMax = Math.max(0, length - 5);
            while (iMax < length) {
                long j10 = this.globalTime + 30;
                this.globalTime = j10;
                long j11 = j10 % 6000;
                int i10 = iMax + 1;
                spannableString.setSpan(new ForegroundColorSpan(-1), iMax, i10, 33);
                iMax = i10;
            }
            this.markdown.g(this.view, spannableString);
        }
    }
}
