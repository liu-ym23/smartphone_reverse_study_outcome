package com.tt.skin.sdk;

import android.content.Context;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 1, 15})
final class Default$DEFAULT_VIEW_INTERCEPTOR$1$setTextColor$2 extends Lambda implements Function1<Context, Unit> {
    final /* synthetic */ int $colorRes;
    final /* synthetic */ TextView $textView;

    public Default$DEFAULT_VIEW_INTERCEPTOR$1$setTextColor$2(TextView r10, int r11) {
        this.$textView = r10;
        this.$colorRes = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Context r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Context r10) {
        q.h(r10, "it");
        TextView r11 = this.$textView;
        if (r11 == null) goto L6;
        r11.setTextColor(r10.getResources().getColorStateList(this.$colorRes));
        return;
    }
}
