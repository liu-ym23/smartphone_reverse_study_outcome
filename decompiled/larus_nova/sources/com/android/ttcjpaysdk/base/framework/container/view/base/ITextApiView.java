package com.android.ttcjpaysdk.base.framework.container.view.base;

import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/ITextApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/TextUiInfo;", "setTalkback", "", "contentDescription", "", "focusable", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setText", "text", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITextApiView extends IApiView<TextUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setTalkback(ITextApiView r100, String r101, Boolean r102) {
        }

        public static Theme getTheme(ITextApiView r100) {
            return IApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(ITextApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            IApiView.DefaultImpls.setTheme(r100, r101);
        }

        public static /* synthetic */ void setTalkback$default(ITextApiView r100, String r101, Boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.setTalkback(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTalkback");
        }
    }

    void setTalkback(String r100, Boolean r101);

    void setText(String r100);
}
