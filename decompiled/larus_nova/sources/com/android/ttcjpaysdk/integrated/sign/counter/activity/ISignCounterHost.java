package com.android.ttcjpaysdk.integrated.sign.counter.activity;

import android.app.Activity;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterHost;", "", "disablePageClick", "", "disable", "", "finishHost", "finishHostAndNotifyPayResult", "getActivity", "Landroid/app/Activity;", "getSceneContainer", "Landroid/view/ViewGroup;", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISignCounterHost {
    void disablePageClick(boolean r100);

    void finishHost();

    void finishHostAndNotifyPayResult();

    Activity getActivity();

    ViewGroup getSceneContainer();
}
