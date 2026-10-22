package com.android.ttcjpaysdk.base.ui.Utils;

import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayBrandPromotionUtils;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBrandPromotionUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayBrandPromotionUtils$Companion;", "", "()V", "getFullSetPasswordTitle", "", "passwordTitle", "getFullSetPasswordTitleAgain", "getInputPasswordTitle", "middleTitle", "getMiddleTitle", "title", "getOneKeyCashierTitle", "oneKeyTitle", "getVerifyPasswordTitle", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getFullSetPasswordTitle(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().full_set_password_title;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        public final String getFullSetPasswordTitleAgain(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().full_set_password_title_again;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        public final String getInputPasswordTitle(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().half_input_password_title;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        public final String getMiddleTitle(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().cashier_title;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        public final String getOneKeyCashierTitle(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().one_key_quick_cashier_title;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }

        public final String getVerifyPasswordTitle(String r100) {
            String r101 = CJPaySettingsManager.getInstance().getBrandPromotion().full_verify_password_title;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L12;
            return r100;
        L12:
            return r101;
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayBrandPromotionUtils() {
    }
}
