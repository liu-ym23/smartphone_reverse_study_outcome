package com.bytedance.android.livesdk.interactivity.common.accessibility;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/accessibility/RecycleViewItemAccessibilityDelegate;", "Landroidx/recyclerview/widget/RecyclerViewAccessibilityDelegate$ItemDelegate;", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecycleViewItemAccessibilityDelegate extends RecyclerViewAccessibilityDelegate.ItemDelegate {
    public RecycleViewItemAccessibilityDelegate(RecyclerViewAccessibilityDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerViewDelegate");
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate.ItemDelegate, androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        if (TextUtils.isEmpty(r101.getText()) == true) goto L5;
        return;
    L5:
        TextView r102 = (TextView) r100.findViewById(R.id.text);
        if (r102 != null) goto L8;
        return;
    L8:
        String r103 = r102.getText().toString();
        if (r103 == null) goto L26;
        String r104 = StringsKt.trimStart(r103).toString();
    L12:
        if (r104.length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L23;
        if (StringsKt.startsWith$default(r104, "$", false, 2, null) == false) goto L23;
        String r106 = StringsKt.replaceFirst$default(r104, "$", "", false, 4, null);
        if (r106 == null) goto L22;
        r104 = StringsKt.trimStart(r106).toString();
        goto L12
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L23:
        r101.setContentDescription(r104);
        return;
    L14:
        r105 = false;
        goto L15
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
