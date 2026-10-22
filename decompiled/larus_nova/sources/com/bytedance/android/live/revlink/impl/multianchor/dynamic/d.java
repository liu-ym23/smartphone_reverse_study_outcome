package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f94075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f94076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FormatType f94077c;

    public d(MediatorLiveData r100, String r101, FormatType r102) {
        this.f94075a = r100;
        this.f94076b = r101;
        this.f94077c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        JSONObject r101 = new JSONObject();
        r101.put("type", this.f94076b);
        if (this.f94077c != FormatType.NEW) goto L8;
        if (r100 == null) goto L6;
        String r102 = this.f94076b;
        Intrinsics.checkNotNullParameter(r100, "$this$toNewFormatString");
        Intrinsics.checkNotNullParameter(r102, "tag");
        JSONObject r103 = new JSONObject();
        r103.put(r102, r100);
        r100 = r103.toString();
    L13:
        r101.put("data", r100);
        this.f94075a.setValue(new Pair(this.f94076b, r101));
        return;
    L6:
        r100 = null;
        goto L13
    L8:
        if ((r100 instanceof String) == true) goto L13;
        if ((r100 instanceof JSONObject) == true) goto L13;
        r100 = GsonProtectorUtils.toJson(l97.a.f508113a, r100);
        goto L13
    }
}
