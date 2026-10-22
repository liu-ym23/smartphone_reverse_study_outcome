package com.stepos.core.ota.confirmui;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "", "Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;", "request", "LY8/t;", "show", "(Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;)V", "", "getPerfLabel", "()Ljava/lang/String;", "perfLabel", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ConfirmUiHost {
    String getPerfLabel();

    void show(ConfirmUiRequest request);
}
