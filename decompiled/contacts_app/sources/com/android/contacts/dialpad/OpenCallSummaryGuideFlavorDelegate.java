package com.android.contacts.dialpad;

import kotlin.Metadata;

/* JADX INFO: compiled from: OpenCallSummaryGuideFlavorDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/dialpad/OpenCallSummaryGuideFlavorDelegate;", "", "()V", "SHOULD_HIDE_OPEN_CALL_SUMMARY_GUIDE", "", "shouldHideOpenCallSummaryGuide", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OpenCallSummaryGuideFlavorDelegate {
    public static final OpenCallSummaryGuideFlavorDelegate INSTANCE = null;
    private static final boolean SHOULD_HIDE_OPEN_CALL_SUMMARY_GUIDE = true;

    static {
        INSTANCE = new OpenCallSummaryGuideFlavorDelegate();
    }

    public final boolean shouldHideOpenCallSummaryGuide() {
        return true;
    }

    private OpenCallSummaryGuideFlavorDelegate() {
    }
}
