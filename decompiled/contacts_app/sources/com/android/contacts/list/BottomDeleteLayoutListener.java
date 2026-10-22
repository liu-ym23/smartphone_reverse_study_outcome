package com.android.contacts.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomDeleteLayoutListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/android/contacts/list/BottomDeleteLayoutListener;", "", "isBottomBarVisible", "", "setBottomBtnEnable", "", "isEnable", "setButtonText", "text", "", "setLayoutVisible", "isVisible", "startTransition", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BottomDeleteLayoutListener {

    /* JADX INFO: compiled from: BottomDeleteLayoutListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setButtonText(BottomDeleteLayoutListener r0, String r1) {
            Intrinsics.checkNotNullParameter(r1, "text");
        }
    }

    boolean isBottomBarVisible();

    void setBottomBtnEnable(boolean r1);

    void setButtonText(String r1);

    void setLayoutVisible(boolean r1);

    void startTransition(boolean r1);
}
