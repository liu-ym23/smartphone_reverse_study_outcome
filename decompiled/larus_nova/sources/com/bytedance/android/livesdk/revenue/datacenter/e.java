package com.bytedance.android.livesdk.revenue.datacenter;

import android.graphics.Bitmap;
import com.bytedance.ies.sdk.widgets.KVData;
import io.reactivex.Observable;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes11.dex */
public interface e {
    Observable<KVData> a(KProperty1<e, ? extends Object> r100);

    void b(String r100);

    void c(Integer r100);

    void d(int r100);

    void e(Bitmap r100);

    void f(String r100);

    String g();

    int getLinkState();

    void h(String r100);
}
