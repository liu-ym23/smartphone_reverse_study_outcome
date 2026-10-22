package com.bytedance.android.livesdkapi.business;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J1\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rH&J\b\u0010\u000f\u001a\u00020\nH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveDouPlusEcpService;", "", "checkDouPlusEcpEntry", "", "roomId", "", "secUid", "", "resultCallback", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "(Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/android/livesdk/app/dataholder/Observer;)V", "getDouPlusEcpInfo", "Lkotlin/Pair;", "", "withDouPlusEcpEntry", "Stub", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveDouPlusEcpService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void checkDouPlusEcpEntry$default(ILiveDouPlusEcpService r100, Long r101, String r102, Observer r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 1) == 0) goto L6;
            r101 = 0L;
        L6:
            r100.checkDouPlusEcpEntry(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkDouPlusEcpEntry");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveDouPlusEcpService$Stub;", "Lcom/bytedance/android/livesdkapi/business/ILiveDouPlusEcpService;", "()V", "checkDouPlusEcpEntry", "", "roomId", "", "secUid", "", "resultCallback", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "(Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/android/livesdk/app/dataholder/Observer;)V", "getDouPlusEcpInfo", "Lkotlin/Pair;", "", "withDouPlusEcpEntry", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Stub implements ILiveDouPlusEcpService {
        public Stub() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusEcpService
        public void checkDouPlusEcpEntry(Long r100, String r101, Observer<Boolean> r102) {
            Intrinsics.checkNotNullParameter(r102, "resultCallback");
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusEcpService
        public boolean withDouPlusEcpEntry() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusEcpService
        public Pair<Integer, String> getDouPlusEcpInfo() {
            return new Pair(0, "");
        }
    }

    void checkDouPlusEcpEntry(Long r100, String r101, Observer<Boolean> r102);

    Pair<Integer, String> getDouPlusEcpInfo();

    boolean withDouPlusEcpEntry();
}
