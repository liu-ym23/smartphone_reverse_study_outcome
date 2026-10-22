package com.bytedance.android.livesdk.chatroom.distribution.lifecycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/distribution/lifecycle/LifecycleFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleFragment extends BaseFragment {
    public LifecycleFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return new View(getContext());
    }
}
