package com.bytedance.android.shopping.anchorv3.activities.quick.presenter;

import android.widget.TextView;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.TimeUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f164414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f164415b;

    public d(TextView r100, long r101) {
        this.f164414a = r100;
        this.f164415b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        TextView r102 = this.f164414a;
        long r103 = this.f164415b;
        r102.setVisibility(0);
        long r104 = (System.currentTimeMillis() / 1000) - r103;
        StringBuilder r105 = new StringBuilder();
        if (r104 >= 60) goto L6;
        r105.append(r104);
        r105.append("秒前");
    L18:
        r102.setText(ag4.a.a(R.string.group_completed_before_x, CollectionsKt.listOf(r105.toString())));
        return;
    L6:
        if (r104 >= TimeUtils.SECONDS_PER_HOUR) goto L9;
        r105.append(r104 / 60);
        r105.append("分钟前");
        goto L18
    L9:
        if (r104 >= 86400) goto L12;
        r105.append(r104 / TimeUtils.SECONDS_PER_HOUR);
        r105.append("小时前");
        goto L18
    L12:
        if (r104 >= 2592000) goto L15;
        r105.append(r104 / 86400);
        r105.append("天前");
        goto L18
    L15:
        if (r104 >= 31536000) goto L17;
        r105.append(r104 / 2592000);
        r105.append("月前");
        goto L18
    L17:
        r105.append(r104 / 31536000);
        r105.append("年前");
        goto L18
    }
}
