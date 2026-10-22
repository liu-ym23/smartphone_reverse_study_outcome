package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IHostApi;", "", "changePayTypeAnimUp", "", "changePayTypeNeedMask", "clickConfirmBtn", "", "fetchRenderData", "getContext", "Landroid/app/Activity;", "getPageHeight", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IHostApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean changePayTypeAnimUp(IHostApi r100) {
            return false;
        }

        public static boolean changePayTypeNeedMask(IHostApi r100) {
            return false;
        }

        public static void clickConfirmBtn(IHostApi r100) {
        }

        public static void fetchRenderData(IHostApi r100) {
        }

        public static int getPageHeight(IHostApi r100) {
            return 470;
        }
    }

    boolean changePayTypeAnimUp();

    boolean changePayTypeNeedMask();

    void clickConfirmBtn();

    void fetchRenderData();

    Activity getContext();

    int getPageHeight();
}
