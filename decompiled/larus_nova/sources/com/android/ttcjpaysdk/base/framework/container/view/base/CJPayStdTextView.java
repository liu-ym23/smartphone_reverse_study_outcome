package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.content.Context;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.AbsBaseViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016J!\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdTextView;", "Landroid/widget/TextView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/ITextApiView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "refresh", "", "viewUIInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/TextUiInfo;", "setClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "setTalkback", "contentDescription", "", "focusable", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setText", "text", "TextViewController", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdTextView extends TextView implements ITextApiView {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdTextView$TextViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/TextUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/ITextApiView;", "textUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/TextUiInfo;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TextViewController extends AbsBaseViewController<TextUiInfo, ITextApiView> {
        /* JADX WARN: Multi-variable type inference failed */
        public TextViewController() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public TextViewController(TextUiInfo r100) {
            super(r100);
        }

        public /* synthetic */ TextViewController(TextUiInfo r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public Theme getTheme() {
        return ITextApiView.DefaultImpls.getTheme(this);
    }

    public CJPayStdTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public void refresh(TextUiInfo r100) {
        if (r100 == null) goto L5;
        setText(r100.getText());
        setTextColor(r100.parseColor(r100.getTextColor()));
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public void setClickListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this, new AnonymousClass1(r100));
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.ITextApiView
    public void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        setText(r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public void setTheme(Theme r100) {
        ITextApiView.DefaultImpls.setTheme(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public /* bridge */ /* synthetic */ void refresh(IViewUiInfo r100) {
        refresh((TextUiInfo) r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.ITextApiView
    public void setTalkback(String r100, Boolean r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        if (r102 == false) goto L12;
        setContentDescription(r100);
        if (r101 == null) goto L13;
        r101.booleanValue();
        setFocusable(r101.booleanValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r102 = true;
        goto L7
    }
}
