package com.android.ttcjpaysdk.base.utils.html.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.html.callback.UniversalClickCallback;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/span/UniversalClickableSpan;", "Landroid/text/style/ClickableSpan;", "id", "", "data", "type", "Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback$ClickType;", "callback", "Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback;", "underlineText", "", "textColor", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback$ClickType;Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback;ZLjava/lang/Integer;)V", "Ljava/lang/Integer;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UniversalClickableSpan extends ClickableSpan {
    public static final Companion Companion = null;
    private static final String TAG = "UniversalClickableSpan";
    private final UniversalClickCallback callback;
    private final String data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f29373id;
    private final Integer textColor;
    private final UniversalClickCallback.ClickType type;
    private final boolean underlineText;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/span/UniversalClickableSpan$Companion;", "", "()V", "TAG", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        CJLogger.a(TAG, "点击事件触发 - id: " + this.f29373id + ", data: " + this.data + ", type: " + this.type.getValue());     // Catch: Exception -> L7
        UniversalClickCallback r101 = this.callback;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.onUniversalClick(this.f29373id, this.data, this.type);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UniversalClickableSpan#onClick", e);
        CJLogger.c(TAG, "处理点击事件失败", e);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(this.underlineText);
        Integer r101 = this.textColor;
        if (r101 == null) goto L5;
        r100.setColor(r101.intValue());
    L5:
        CJLogger.a(TAG, "文本样式更新 - 下划线: " + this.underlineText + ", 颜色: " + this.textColor);
    }

    public UniversalClickableSpan(String r100, String r101, UniversalClickCallback.ClickType r102, UniversalClickCallback r103, boolean r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f29373id = r100;
        this.data = r101;
        this.type = r102;
        this.callback = r103;
        this.underlineText = r104;
        this.textColor = r105;
    }

    public /* synthetic */ UniversalClickableSpan(String r100, String r101, UniversalClickCallback.ClickType r110, UniversalClickCallback r111, boolean r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r101, r110, r111, r102, r113);
        return;
    L5:
        r102 = r112;
        goto L7
    }
}
