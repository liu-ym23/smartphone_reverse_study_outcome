package com.bytedance.android.shopping.api.mall.common.widget;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f170496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f170497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f170498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f170499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f170500e;

    public static final class a {
    }

    static {
    }

    public final Function0<Unit> getClickListener() {
        return this.f170500e;
    }

    public final String getEnterFrom() {
        return this.f170499d;
    }

    public b(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "clickListener");
        super(r100, null, 0);
        this.f170499d = null;
        this.f170500e = r101;
        FrameLayout.inflate(r100, R.layout.shopping_mall_default_login_guide_view, this);
        this.f170496a = (TextView) findViewById(R.id.shopping_default_login_guide_tv);
        this.f170497b = (TextView) findViewById(R.id.shopping_default_login_guide_desc);
        Button r102 = (Button) findViewById(R.id.shopping_default_login_guide_btn);
        this.f170498c = (ImageView) findViewById(R.id.shopping_default_login_guide_iv);
        r102.setOnClickListener(new com.bytedance.android.shopping.api.mall.common.widget.a(this, r100));
    }
}
