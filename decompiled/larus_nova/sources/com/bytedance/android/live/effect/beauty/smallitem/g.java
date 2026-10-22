package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements LiveSmallItemBeautyHelper.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f67701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f67702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f67703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f67704d;

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
    public final void onError() {
        q r100 = this.f67704d;
        if (r100 == null) goto L6;
        r100.onError();
        return;
    }

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
    public final void onSuccess(List<Sticker> r100) {
        Intrinsics.checkNotNullParameter(r100, "stickerList");
        Map<String, Map<String, List<Sticker>>> r101 = this.f67701a.f67670b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(this.f67702b) != null) goto L5;
        this.f67701a.f67670b.put(this.f67702b, new LinkedHashMap());
    L5:
        Map<String, Map<String, List<Sticker>>> r103 = this.f67701a.f67670b;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Map r105 = (Map) r104.get(this.f67702b);
        if (r105 == null) goto L8;
        List r106 = (List) r105.put(this.f67703c, r100);
    L8:
        q r107 = this.f67704d;
        if (r107 == null) goto L12;
        r107.a(r100, null);
        return;
    }

    public g(d r100, String r101, String r102, q r103) {
        this.f67701a = r100;
        this.f67702b = r101;
        this.f67703c = r102;
        this.f67704d = r103;
    }
}
