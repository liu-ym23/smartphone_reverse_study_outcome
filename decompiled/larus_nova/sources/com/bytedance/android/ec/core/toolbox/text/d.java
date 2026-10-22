package com.bytedance.android.ec.core.toolbox.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableStringBuilder f45497a;

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d e() {
        this.f45497a.append(Permission.EXECUTE);
        return this;
    }

    public final SpannedString f() {
        return new SpannedString(this.f45497a);
    }

    public d(SpannableStringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f45497a = r100;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        b(new StyleSpan(2), r100);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d append(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f45497a.append(r100);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d c(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        b(new StyleSpan(1), r100);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d d(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        b(new a(), r100);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d b(Object r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        int r102 = this.f45497a.length();
        r101.invoke(this);
        SpannableStringBuilder r103 = this.f45497a;
        r103.setSpan(r100, r102, r103.length(), 17);
        return this;
    }

    public final d g(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        b(new ForegroundColorSpan(r100), r101);
        return this;
    }

    public final d h(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        b(new AbsoluteSizeSpan(r100, true), r101);
        return this;
    }

    public final d i(int r100, int r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r102, "builderAction");
        b(new b(r100, r101), r102);
        return this;
    }
}
