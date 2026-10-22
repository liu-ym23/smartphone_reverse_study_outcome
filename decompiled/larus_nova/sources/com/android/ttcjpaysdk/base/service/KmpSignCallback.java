package com.android.ttcjpaysdk.base.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J2\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/KmpSignCallback;", "", "onEntryRequestFinished", "", "success", "", "msg", "", "onSignPageShow", "onSignResult", "code", "ext", "onCleanup", "Lkotlin/Function0;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface KmpSignCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onSignResult$default(KmpSignCallback r100, String r101, String r102, String r103, Function0 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.onSignResult(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSignResult");
        }
    }

    void onEntryRequestFinished(boolean r100, String r101);

    void onSignPageShow();

    void onSignResult(String r100, String r101, String r102, Function0<Unit> r103);
}
