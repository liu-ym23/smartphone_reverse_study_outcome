package com.bytedance.android.live.livepkaudience.dialog;

import android.view.ViewGroup;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.livepkaudience.dialog.b0;

/* JADX INFO: loaded from: classes46.dex */
public abstract class RevInteractDialogFragmentBaseContract$View<T extends b0> extends BaseFragment implements com.bytedance.android.livesdk.common.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k0 f81771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f81772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f81773f;

    public abstract float S90();

    public abstract String T90();

    public ViewGroup U90() {
        return null;
    }

    public RevInteractDialogFragmentBaseContract$View() {
        this.f81772e = getClass().getName();
    }
}
