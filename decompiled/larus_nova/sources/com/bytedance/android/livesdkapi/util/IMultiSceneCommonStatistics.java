package com.bytedance.android.livesdkapi.util;

import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H&J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH&J>\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u00132\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00170\u0016H&J8\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IMultiSceneCommonStatistics;", "", "checkDurationValid", "", "duration", "clearUploadUIData", "", "handleDynamicViewLoadDuration", "durationInfo", "recordSubElementShow", "subElement", "", "time", "startObserveBaseElementLoadEnd", "type", "startObserveKtvElementLoadEnd", "startObservePlayModeElementLoadEnd", "startObserveUIElementLoadEnd", "subElementList", "", "Lio/reactivex/subjects/BehaviorSubject;", "getExtraParamsAction", "Lkotlin/Function0;", "", "uploadUILoadEnd", "getMaxTimeAction", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMultiSceneCommonStatistics {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static long checkDurationValid(IMultiSceneCommonStatistics r100, long r101) {
            if (r101 >= 0) goto L6;
            return -1;
        L6:
            return r101;
        }

        public static /* synthetic */ void recordSubElementShow$default(IMultiSceneCommonStatistics r100, String r101, long r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = System.currentTimeMillis();
        L6:
            r100.recordSubElementShow(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordSubElementShow");
        }
    }

    long checkDurationValid(long r100);

    void clearUploadUIData();

    void handleDynamicViewLoadDuration(Object r100);

    void recordSubElementShow(String r100, long r101);

    void startObserveBaseElementLoadEnd(String r100);

    void startObserveKtvElementLoadEnd(String r100);

    void startObservePlayModeElementLoadEnd(String r100);

    void startObserveUIElementLoadEnd(String r100, List<BehaviorSubject<Long>> r101, Function0<? extends Map<String, String>> r102);

    void uploadUILoadEnd(String r100, Function0<? extends Map<String, String>> r101, Function0<Long> r102);
}
