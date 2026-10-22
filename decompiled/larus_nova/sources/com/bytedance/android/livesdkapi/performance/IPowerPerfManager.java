package com.bytedance.android.livesdkapi.performance;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.performance.PowerPerfManager")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&JN\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/IPowerPerfManager;", "Lcom/bytedance/android/live/base/IService;", "doJatoBigCore", "", "tid", "", "doJatoBoostCpu", "time", "", "doJatoRestCore", "threadPerfStart", "threadPerfStop", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "config", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPowerPerfManager extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void doJatoBoostCpu$default(IPowerPerfManager r100, long r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = 1000;
        L6:
            r100.doJatoBoostCpu(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJatoBoostCpu");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HashMap threadPerfStop$default(IPowerPerfManager r100, HashMap r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = new HashMap();
        L7:
            return r100.threadPerfStop(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: threadPerfStop");
        }
    }

    void doJatoBigCore();

    void doJatoBigCore(int r100);

    void doJatoBoostCpu(long r100);

    void doJatoRestCore();

    void doJatoRestCore(int r100);

    void threadPerfStart();

    HashMap<String, Double> threadPerfStop(HashMap<String, Integer> r100);
}
