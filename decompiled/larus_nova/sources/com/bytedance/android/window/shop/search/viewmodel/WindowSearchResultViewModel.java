package com.bytedance.android.window.shop.search.viewmodel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zn.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/window/shop/search/viewmodel/WindowSearchResultViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroid/os/Bundle;", "bundle", "", "initData", "traceTimeStart", "traceTimeEnd", "Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;", "searchParam", "Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;", "getSearchParam", "()Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;", "setSearchParam", "(Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;)V", "", "mRecordTime", "J", "getMRecordTime", "()J", "setMRecordTime", "(J)V", "", "mToNewPage", "Z", "getMToNewPage", "()Z", "setMToNewPage", "(Z)V", "Lzn/a;", "", "screenState", "Lzn/a;", "getScreenState", "()Lzn/a;", "Landroid/content/Intent;", "data", "Landroid/content/Intent;", "getData", "()Landroid/content/Intent;", "isFormSearchActivity", "setFormSearchActivity", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultViewModel extends BaseViewModel {
    private final Intent data;
    private boolean isFormSearchActivity;
    private long mRecordTime;
    private boolean mToNewPage;
    private final a<Integer> screenState;
    public ECWindowSearchParam searchParam;
    private Uri uri;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowSearchResultViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.mRecordTime = SystemClock.elapsedRealtime();
        this.mToNewPage = true;
        this.screenState = new a(false, 7);
        this.data = new Intent();
        this.isFormSearchActivity = true;
    }

    public final ECWindowSearchParam getSearchParam() {
        ECWindowSearchParam r100 = this.searchParam;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        return r100;
    }

    public final void traceTimeStart() {
        this.mRecordTime = SystemClock.elapsedRealtime();
    }

    public final Intent getData() {
        return this.data;
    }

    public final long getMRecordTime() {
        return this.mRecordTime;
    }

    public final boolean getMToNewPage() {
        return this.mToNewPage;
    }

    public final a<Integer> getScreenState() {
        return this.screenState;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isFormSearchActivity() {
        return this.isFormSearchActivity;
    }

    public final void traceTimeEnd() {
        SystemClock.elapsedRealtime();
    }

    public final void initData(Bundle r100) {
        if (r100 == null) goto L4;
        Serializable r101 = r100.getSerializable("search_param");
    L5:
        if (r101 == null) goto L12;
        this.searchParam = (ECWindowSearchParam) r101;
        this.isFormSearchActivity = r100.getBoolean("is_from_search_activity");
        String r102 = r100.getString("uri");
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        this.uri = UriProtector.parse(r102);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.search.router.ECWindowSearchParam");
    L4:
        r101 = null;
        goto L5
    }

    public final void setFormSearchActivity(boolean r100) {
        this.isFormSearchActivity = r100;
    }

    public final void setMRecordTime(long r100) {
        this.mRecordTime = r100;
    }

    public final void setMToNewPage(boolean r100) {
        this.mToNewPage = r100;
    }

    public final void setSearchParam(ECWindowSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchParam = r100;
    }

    public final void setUri(Uri r100) {
        this.uri = r100;
    }
}
