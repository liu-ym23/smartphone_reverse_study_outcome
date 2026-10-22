package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextWithIconConfig;", "", "Landroid/content/Context;", "component1", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "component2", "Lp93/a;", "component3", PerfLog.PARAM_KEY_CONTEXT_ID, "uiParams", "imageLoad", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "getUiParams", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "Lp93/a;", "getImageLoad", "()Lp93/a;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;Lp93/a;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextWithIconConfig {
    private final Context context;
    private final p93.a imageLoad;
    private final UIConfig uiParams;

    public static /* synthetic */ TextWithIconConfig copy$default(TextWithIconConfig r100, Context r101, UIConfig r102, p93.a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.uiParams;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.imageLoad;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Context component1() {
        return this.context;
    }

    public final UIConfig component2() {
        return this.uiParams;
    }

    public final p93.a component3() {
        return this.imageLoad;
    }

    public final TextWithIconConfig copy(Context r100, UIConfig r101, p93.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uiParams");
        Intrinsics.checkNotNullParameter(r102, "imageLoad");
        return new TextWithIconConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextWithIconConfig) == false) goto L12;
        TextWithIconConfig r101 = (TextWithIconConfig) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uiParams, r101.uiParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageLoad, r101.imageLoad) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Context r100 = this.context;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UIConfig r104 = this.uiParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p93.a r107 = this.imageLoad;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TextWithIconConfig(context=" + this.context + ", uiParams=" + this.uiParams + ", imageLoad=" + this.imageLoad + ")";
    }

    public final Context getContext() {
        return this.context;
    }

    public final p93.a getImageLoad() {
        return this.imageLoad;
    }

    public final UIConfig getUiParams() {
        return this.uiParams;
    }

    public TextWithIconConfig(Context r100, UIConfig r101, p93.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uiParams");
        Intrinsics.checkNotNullParameter(r102, "imageLoad");
        this.context = r100;
        this.uiParams = r101;
        this.imageLoad = r102;
    }

    public /* synthetic */ TextWithIconConfig(Context r100, UIConfig r101, p93.a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new b();
    L5:
        this(r100, r101, r102);
    }
}
