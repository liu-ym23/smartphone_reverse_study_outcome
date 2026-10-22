package cd4;

import android.webkit.WebView;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b implements ed4.l, ICJTag {
    public b() {
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // ed4.l
    public void onLoadStart(String r100, WebView r101) {
        i("onLoadStart: " + r100);
    }

    @Override // ed4.l
    public void onLoadUriSuccess(String r100, WebView r101) {
        i("onLoadUriSuccess: " + r100);
    }

    @Override // ed4.l
    public void onRuntimeReady(String r100, WebView r101) {
        i("onRuntimeReady: " + r100);
    }

    @Override // ed4.l
    public void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        e("onLoadFail: " + r100, r102);
    }

    @Override // ed4.l
    public void onViewDestroy(String r100, WebView r101, Throwable r102) {
        e("onViewDestroy: " + r100, r102);
    }
}
