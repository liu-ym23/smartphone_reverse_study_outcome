package com.bytedance.android.livesdkapi.depend.live.vs.fragment;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/fragment/IVSInteractiveAreaHelper;", "", "containComponent", "", "component", "", "hideComponent", "", "withAnim", "registerComponent", "controller", "Lcom/bytedance/android/livesdkapi/depend/live/vs/fragment/IVSInteractiveAreaHelper$IVisibleController;", "defaultVisible", "showComponent", "unRegisterComponent", "IAnimaListener", "IVisibleController", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSInteractiveAreaHelper {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void hideComponent$default(IVSInteractiveAreaHelper r100, int r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = true;
        L6:
            r100.hideComponent(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideComponent");
        }

        public static /* synthetic */ void showComponent$default(IVSInteractiveAreaHelper r100, int r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = true;
        L6:
            r100.showComponent(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showComponent");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/fragment/IVSInteractiveAreaHelper$IAnimaListener;", "", "afterAnimation", "", "beforeAnimation", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IAnimaListener {
        void afterAnimation();

        void beforeAnimation();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/fragment/IVSInteractiveAreaHelper$IVisibleController;", "", "hideComponent", "", "listener", "Lcom/bytedance/android/livesdkapi/depend/live/vs/fragment/IVSInteractiveAreaHelper$IAnimaListener;", "withAnim", "", "isShowing", "showComponent", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IVisibleController {
        void hideComponent(IAnimaListener r100, boolean r101);

        boolean isShowing();

        void showComponent(IAnimaListener r100, boolean r101);
    }

    boolean containComponent(int r100);

    void hideComponent(int r100, boolean r101);

    void registerComponent(int r100, IVisibleController r101, boolean r102);

    void showComponent(int r100, boolean r101);

    void unRegisterComponent(int r100);
}
