package com.bytedance.android.livesdk.gift.fastgift;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/FastGiftComboView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastGiftComboView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f126044a;

    public static final class a {
    }

    static {
    }

    public FastGiftComboView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FastGiftComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f126044a != null) goto L5;
        this.f126044a = new LinkedHashMap();
    L5:
        View r101 = this.f126044a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f126044a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public FastGiftComboView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f126044a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_fast_gift_combo, this);
        Typeface r103 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L10
        TextView r104 = (TextView) a(R.id.combo_count);     // Catch: Exception -> L10
        if (r104 == null) goto L6;
        r104.setTypeface(r103);     // Catch: Exception -> L10
    L6:
        TextView r105 = (TextView) a(R.id.combo_count_x);     // Catch: Exception -> L10
        if (r105 == null) goto L15;
        r105.setTypeface(r103);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("FastGiftComboView", "load font asset exception: " + e.getMessage(), null, 4);
    }

    public /* synthetic */ FastGiftComboView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
