package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdtracker.e6;
import com.bytedance.bdtracker.k5;
import com.bytedance.bdtracker.w5;
import com.bytedance.dr.OaidApi;

/* loaded from: classes.dex */
public abstract class b<SERVICE> implements OaidApi {
    public final String a;
    public final w5<Boolean> b = new a();

    public class a extends w5<Boolean> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.w5
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(k5.a((Context) objArr[0], b.this.a));
        }
    }

    public b(String str) {
        this.a = str;
    }

    public abstract Intent a(Context context);

    public abstract e6.b<SERVICE, String> a();

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        String str = (String) new e6(context, a(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = str;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }
}
