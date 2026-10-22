package com.bytedance.android.livesdkapi.listener;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/listener/ICallStatusListener;", "", "onCallActivityCreate", "", "fromFloatWindow", "", "onCallActivityDestroy", "toFloatWindow", "onCallEnd", "onCallStart", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ICallStatusListener {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        public static void onCallActivityCreate(ICallStatusListener r100, boolean r101) {
        }

        public static void onCallActivityDestroy(ICallStatusListener r100, boolean r101) {
        }

        public static void onCallEnd(ICallStatusListener r100) {
        }

        public static void onCallStart(ICallStatusListener r100) {
        }

        public static /* synthetic */ void onCallActivityCreate$default(ICallStatusListener r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.onCallActivityCreate(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCallActivityCreate");
        }

        public static /* synthetic */ void onCallActivityDestroy$default(ICallStatusListener r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.onCallActivityDestroy(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCallActivityDestroy");
        }
    }

    void onCallActivityCreate(boolean r100);

    void onCallActivityDestroy(boolean r100);

    void onCallEnd();

    void onCallStart();
}
