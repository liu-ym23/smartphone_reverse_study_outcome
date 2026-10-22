package com.bytedance.android.livesdkapi.paidlive;

import android.widget.TextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidMaskAdHolderWrapper;", "", "appendAdLabel", "", "titleText", "Landroid/widget/TextView;", "hasAd", "", "logTempMaskShow", "logTicketModuleClick", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidMaskAdHolderWrapper {
    void appendAdLabel(TextView r100);

    boolean hasAd();

    void logTempMaskShow();

    void logTicketModuleClick();
}
