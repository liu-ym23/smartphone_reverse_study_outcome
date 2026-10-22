package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.live.base.model.message.n3;
import com.bytedance.android.live.base.model.message.o3;
import kotlin.Metadata;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveMessageListener;", "Lvlc/l;", "Ltlc/d;", "message", "", "onMessage", "Lcom/bytedance/android/live/base/model/message/n3;", "onPaidLiveDataMessage", "Lcom/bytedance/android/live/base/model/message/o3;", "onPaidLiveTypeModifyMessage", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidLiveMessageListener extends l {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onPaidLiveTypeModifyMessage(IPaidLiveMessageListener r100, o3 r101) {
        }

        public static void onMessage(IPaidLiveMessageListener r100, d r101) {
            if ((r101 instanceof n3) == false) goto L6;
            r100.onPaidLiveDataMessage((n3) r101);
            return;
        L6:
            if ((r101 instanceof o3) == false) goto L10;
            r100.onPaidLiveTypeModifyMessage((o3) r101);
            return;
        }
    }

    @Override // vlc.l
    void onMessage(d r100);

    void onPaidLiveDataMessage(n3 r100);

    void onPaidLiveTypeModifyMessage(o3 r100);
}
