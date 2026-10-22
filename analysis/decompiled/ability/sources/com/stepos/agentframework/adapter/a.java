package com.stepos.agentframework.adapter;

import S7.k;
import android.content.Context;
import com.stepos.net.HttpConfig;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3450a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(Context context, int i) {
        this.f3450a = i;
        this.b = context;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3450a;
        Context context = this.b;
        switch (i) {
            case 0:
                return ApiManager.init$lambda$0$0(context, (HttpConfig.Builder) obj);
            default:
                return WhitelistCacheManager.Companion.create$lambda$1(context, (String) obj);
        }
    }
}
