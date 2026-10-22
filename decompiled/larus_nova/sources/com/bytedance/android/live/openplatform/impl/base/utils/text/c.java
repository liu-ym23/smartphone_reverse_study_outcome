package com.bytedance.android.live.openplatform.impl.base.utils.text;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableStringBuilder f84078a;

    public c(SpannableStringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f84078a = r100;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        b(new StyleSpan(2), r100);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c append(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f84078a.append(r100);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c c(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        b(new StyleSpan(1), r100);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c b(Object r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        int r102 = this.f84078a.length();
        r101.invoke(this);
        SpannableStringBuilder r103 = this.f84078a;
        r103.setSpan(r100, r102, r103.length(), 17);
        return this;
    }

    public final c d(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        b(new AbsoluteSizeSpan(r100, true), r101);
        return this;
    }

    public final c e(int r100, int r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r102, "builderAction");
        b(new a(r100, r101), r102);
        return this;
    }
}
