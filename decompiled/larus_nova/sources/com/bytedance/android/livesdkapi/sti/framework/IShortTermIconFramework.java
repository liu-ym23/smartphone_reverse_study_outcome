package com.bytedance.android.livesdkapi.sti.framework;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\u0001H&¢\u0006\u0002\u0010\bJ$\u0010\u0002\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\nH&J,\u0010\u0002\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00040\rH&J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/IShortTermIconFramework;", "", "load", "", "M", "Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "uniqueId", "(Lcom/bytedance/android/livesdkapi/sti/framework/IIconModel;Ljava/lang/Object;)V", "modelClass", "Ljava/lang/Class;", "uniqueKey", "factory", "Lkotlin/Function0;", "onPause", "onResume", "showIconTermState", "strategyKey", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShortTermIconFramework {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onPause(IShortTermIconFramework r100) {
        }

        public static void onResume(IShortTermIconFramework r100) {
        }
    }

    <M extends IIconModel<?>> void load(M r100, Object r101);

    <M extends IIconModel<?>> void load(Class<M> r100);

    <M extends IIconModel<?>> void load(Object r100, Function0<? extends M> r101);

    void onPause();

    void onResume();

    void showIconTermState(String r100);
}
