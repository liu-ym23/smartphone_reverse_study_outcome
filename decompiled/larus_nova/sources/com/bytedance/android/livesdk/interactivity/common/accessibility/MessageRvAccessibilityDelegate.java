package com.bytedance.android.livesdk.interactivity.common.accessibility;

import androidx.core.view.AccessibilityDelegateCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/accessibility/MessageRvAccessibilityDelegate;", "Landroidx/recyclerview/widget/RecyclerViewAccessibilityDelegate;", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MessageRvAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecycleViewItemAccessibilityDelegate f136310a;

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public final AccessibilityDelegateCompat getItemDelegate() {
        return this.f136310a;
    }

    public MessageRvAccessibilityDelegate(LiveMessageRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super(r100);
        this.f136310a = new RecycleViewItemAccessibilityDelegate(this);
    }
}
