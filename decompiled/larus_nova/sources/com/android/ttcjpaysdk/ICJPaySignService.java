package com.android.ttcjpaysdk;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.service.ICJPayService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015JP\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/ICJPaySignService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getPayOrderFragment", "Landroidx/fragment/app/Fragment;", "hostInfo", "Lorg/json/JSONObject;", "payListUrl", "", "from", "payType", "supportPayType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/android/ttcjpaysdk/ICJPaySignService$IHalfFragmentListener;", "startSignOnlyActivity", "", "activity", "Landroid/app/Activity;", "token", "signInfo", "IHalfFragmentListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPaySignService extends ICJPayService {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/ICJPaySignService$IHalfFragmentListener;", "", "isShowDialog", "", "isShow", "", "onBackWithNotify", "isFinish", "status", "", "onBackWithPayType", "typeText", "onUpdatePayType", "showMaskView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IHalfFragmentListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void isShowDialog(IHalfFragmentListener r100, boolean r101) {
            }

            public static void onBackWithNotify(IHalfFragmentListener r100, boolean r101, String r102) {
                Intrinsics.checkNotNullParameter(r102, "status");
            }

            public static void onBackWithPayType(IHalfFragmentListener r100, String r101) {
            }

            public static void onUpdatePayType(IHalfFragmentListener r100, String r101) {
            }

            public static /* synthetic */ void onBackWithPayType$default(IHalfFragmentListener r100, String r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = null;
            L6:
                r100.onBackWithPayType(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBackWithPayType");
            }

            public static /* synthetic */ void onUpdatePayType$default(IHalfFragmentListener r100, String r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = null;
            L6:
                r100.onUpdatePayType(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdatePayType");
            }

            public static /* synthetic */ void onBackWithNotify$default(IHalfFragmentListener r100, boolean r101, String r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = false;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = "";
            L9:
                r100.onBackWithNotify(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBackWithNotify");
            }
        }

        void isShowDialog(boolean r100);

        void onBackWithNotify(boolean r100, String r101);

        void onBackWithPayType(String r100);

        void onUpdatePayType(String r100);

        void showMaskView(boolean r100);
    }

    Fragment getPayOrderFragment(JSONObject r100, String r101, String r102, String r103, ArrayList<String> r104, IHalfFragmentListener r105);

    void startSignOnlyActivity(Activity r100, String r101, JSONObject r102, JSONObject r103);
}
