package com.bytedance.android.livesdk.livecommerce.room.api;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public interface c {
    void a(FragmentActivity r100, String r101, Window r102);

    void b(int r100);

    void c(boolean r100);

    void d(FragmentActivity r100, String r101, Window r102, Function2 r103);

    void e();

    void f(FragmentActivity r100, String r101, Window r102);

    Observable<ge.a> g(Context r100, ge.b r101);

    <T extends be.a> T getLogger(Class<T> r100);

    void h(String r100, Bundle r101, String r102);

    void i(ak2.f<String, String> r100);

    boolean insertLegalMessage(long r100, String r101, boolean r102);

    boolean isLinkmic();

    void jetDanmaku(String r100, long r101, String r102, String r103);

    void onCouponMessage(int r100, long r101, String r102, int r103, long r104);

    void onPurchasingIntentionAction();

    void previewCompShowEvent();

    void sendLogger(String r100, Map<String, String> r101);
}
