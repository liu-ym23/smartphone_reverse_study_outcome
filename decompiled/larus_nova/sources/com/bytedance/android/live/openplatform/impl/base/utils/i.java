package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f84062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f84063b;

    public i(Function1 r100, Function2 r101) {
        this.f84062a = r100;
        this.f84063b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        List<String> r102 = ((CoverImageModel) r101.data).getUrlList();
        if (r102 == null) goto L15;
        boolean r103 = true;
        if ((!r102.isEmpty()) != true) goto L15;
        String r104 = ((CoverImageModel) r101.data).getUri();
        if (r104 != null) goto L9;
    L12:
        if (r103 == true) goto L15;
        this.f84063b.invoke(((CoverImageModel) r101.data).getUri(), ListProtector.get(((CoverImageModel) r101.data).getUrlList(), 0));
        return;
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r103 = false;
    L15:
        Function1 r105 = this.f84062a;
        if (r105 == null) goto L20;
        Unit r106 = (Unit) r105.invoke(new Throwable("uri or url list is empty"));
        return;
    }
}
