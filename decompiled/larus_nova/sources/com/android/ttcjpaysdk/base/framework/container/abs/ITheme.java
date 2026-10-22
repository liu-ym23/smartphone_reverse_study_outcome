package com.android.ttcjpaysdk.base.framework.container.abs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/abs/ITheme;", "", "getTheme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "setTheme", "", "theme", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITheme {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Theme getTheme(ITheme r100) {
            return null;
        }

        public static void setTheme(ITheme r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
        }

        public static /* synthetic */ void setTheme$default(ITheme r100, Theme r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = Theme.SYSTEM;
        L6:
            r100.setTheme(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTheme");
        }
    }

    Theme getTheme();

    void setTheme(Theme r100);
}
