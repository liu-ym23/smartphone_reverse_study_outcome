package com.android.ttcjpaysdk.kmp.base.bytesync;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JQ\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\n\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/bytesync/IKmpByteSyncEventListener;", "", "receiveEvent", "", "data", "", "publishTimeStamp", "", "Lcom/bytedance/kmp/ohos_ffi/types/BigInt;", "receiveTimeStamp", EffectConfiguration.KEY_CURSOR, "topic", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpByteSyncEventListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void receiveEvent(IKmpByteSyncEventListener r100, String r101, Long r102, Long r103, Long r104, String r105) {
        }
    }

    void receiveEvent(String r100, Long r101, Long r102, Long r103, String r104);
}
