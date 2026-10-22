package com.bytedance.android.livesdkapi.sti.framework;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/ITempShortTouchService;", "", "changeTempWidth", "", "getTempShowTime", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "registerShowTempState", "showTime", "showNormalState", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITempShortTouchService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void changeTempWidth(ITempShortTouchService r100) {
        }

        public static long getTempShowTime(ITempShortTouchService r100, int r101) {
            return 0;
        }

        public static int registerShowTempState(ITempShortTouchService r100, int r101, long r102) {
            return 0;
        }

        public static void showNormalState(ITempShortTouchService r100) {
        }

        public static /* synthetic */ int registerShowTempState$default(ITempShortTouchService r100, int r101, long r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            return r100.registerShowTempState(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerShowTempState");
        }
    }

    void changeTempWidth();

    long getTempShowTime(int r100);

    int registerShowTempState(int r100, long r101);

    void showNormalState();
}
