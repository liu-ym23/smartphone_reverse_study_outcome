package com.android.ttcjpaysdk.base.framework.container.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u001d\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J%\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0097\u0001J'\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/util/CJPayStdThemeManager;", "Lcom/android/ttcjpaysdk/base/framework/container/util/ICJPayStdThemeResFetcher;", "()V", "CJTag", "", "d", "", "content", "e", LynxError.LYNX_THROWABLE, "", "getColor", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "resId", "theme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getThmeStyleId", RXScreenCaptureService.KEY_INDEX, "isLightTheme", "", "w", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdThemeManager implements ICJPayStdThemeResFetcher {
    public static final CJPayStdThemeManager INSTANCE = null;
    private final /* synthetic */ CJPayStdThemeResFetcher $$delegate_0;

    static {
        INSTANCE = new CJPayStdThemeManager();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return this.$$delegate_0.CJTag();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        this.$$delegate_0.d(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        this.$$delegate_0.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.util.ICJPayStdThemeResFetcher
    public int getColor(Context r100, int r101, Theme r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.$$delegate_0.getColor(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.util.ICJPayStdThemeResFetcher
    public Drawable getDrawable(Context r100, int r101, Theme r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.$$delegate_0.getDrawable(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.util.ICJPayStdThemeResFetcher
    public int getThmeStyleId(Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        return this.$$delegate_0.getThmeStyleId(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        this.$$delegate_0.i(r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.util.ICJPayStdThemeResFetcher
    public boolean isLightTheme(Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        return this.$$delegate_0.isLightTheme(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        this.$$delegate_0.w(r100);
    }

    private CJPayStdThemeManager() {
        this.$$delegate_0 = new CJPayStdThemeResFetcher(R.style.CJ_Pay_Std_Container_Light, R.style.CJ_Pay_Std_Container_Night);
    }
}
