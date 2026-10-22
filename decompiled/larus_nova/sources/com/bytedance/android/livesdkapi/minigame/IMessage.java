package com.bytedance.android.livesdkapi.minigame;

import android.text.Spannable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/IMessage;", "", "getButtonText", "", "getMessageSpannable", "Landroid/text/Spannable;", "getMessageSubType", "", "getMessageType", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMessage {
    String getButtonText();

    Spannable getMessageSpannable();

    int getMessageSubType();

    int getMessageType();
}
