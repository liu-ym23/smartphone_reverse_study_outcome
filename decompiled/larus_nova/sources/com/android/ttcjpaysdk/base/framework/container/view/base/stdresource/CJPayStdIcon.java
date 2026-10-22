package com.android.ttcjpaysdk.base.framework.container.view.base.stdresource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.util.CJPayStdThemeManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;", "", "res", "", "(Ljava/lang/String;II)V", "getRes", "()I", "asDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "theme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "LEFT_ARROW_CLOSE", "NET_ERROR", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayStdIcon extends Enum<CJPayStdIcon> {
    private static final /* synthetic */ CJPayStdIcon[] $VALUES = null;
    public static final CJPayStdIcon LEFT_ARROW_CLOSE = null;
    public static final CJPayStdIcon NET_ERROR = null;
    private final int res;

    private static final /* synthetic */ CJPayStdIcon[] $values() {
        return new CJPayStdIcon[]{LEFT_ARROW_CLOSE, NET_ERROR};
    }

    public static CJPayStdIcon valueOf(String r100) {
        return (CJPayStdIcon) a.a(CJPayStdIcon.class, r100);
    }

    public static CJPayStdIcon[] values() {
        return (CJPayStdIcon[]) $VALUES.clone();
    }

    static {
        LEFT_ARROW_CLOSE = new CJPayStdIcon("LEFT_ARROW_CLOSE", 0, R.attr.cj_pay_std_title_bar_back_icon);
        NET_ERROR = new CJPayStdIcon("NET_ERROR", 1, R.attr.cj_pay_std_error_page_net_error_icon);
        $VALUES = $values();
    }

    public final int getRes() {
        return this.res;
    }

    public final Drawable asDrawable(Context r100, Theme r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CJPayStdThemeManager.INSTANCE.getDrawable(r100, this.res, r101);
    }

    private CJPayStdIcon(String r100, int r101, int r102) {
        super(r100, r101);
        this.res = r102;
    }
}
