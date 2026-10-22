package com.obric.oui.privacy;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheetListener;", "", "onAgreeClicked", "", "onBackPressed", "onDismiss", "onExitClicked", "onPrivacyPolicyClicked", "linkText", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OPrivacySheetListener {

    public static final class a {
        public static void a(OPrivacySheetListener r10) {
            q.g(r10, "this");
        }
    }

    void onAgreeClicked();

    void onBackPressed();

    void onDismiss();

    void onExitClicked();

    void onPrivacyPolicyClicked(@NotNull String r10);
}
