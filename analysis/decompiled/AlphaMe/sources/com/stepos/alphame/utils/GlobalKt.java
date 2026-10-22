package com.stepos.alphame.utils;

import android.view.View;
import com.google.android.material.textfield.ViewOnClickListenerC0435a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"setOnClickListener", "", "v", "", "Landroid/view/View;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "([Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlobal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Global.kt\ncom/stepos/alphame/utils/GlobalKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,14:1\n13309#2,2:15\n*S KotlinDebug\n*F\n+ 1 Global.kt\ncom/stepos/alphame/utils/GlobalKt\n*L\n13#1:15,2\n*E\n"})
/* loaded from: classes.dex */
public final class GlobalKt {
    public static final void setOnClickListener(@NotNull View[] v4, @NotNull Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(v4, "v");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewOnClickListenerC0435a viewOnClickListenerC0435a = new ViewOnClickListenerC0435a(3, block);
        for (View view : v4) {
            if (view != null) {
                view.setOnClickListener(viewOnClickListenerC0435a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnClickListener$lambda$0(Function1 block, View view) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNull(view);
        block.invoke(view);
    }
}
