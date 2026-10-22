package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c3 implements SingleObserver<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d3 f63329a;

    public c3(d3 r100) {
        this.f63329a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        this.f63329a.finishWithFailure(r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        this.f63329a.f63346a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(String r100) {
        String r101 = r100;
        JSONObject r102 = new JSONObject();
        r102.put(TemplateNodeType.RAW, r101);     // Catch: JSONException -> L5
        this.f63329a.finishWithResult(r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        this.f63329a.finishWithFailure(e);
    }
}
