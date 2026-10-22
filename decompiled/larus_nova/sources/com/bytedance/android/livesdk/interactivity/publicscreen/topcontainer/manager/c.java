package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.CompositeImagePreviewDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f140053f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.likeegg.a> f140054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeImagePreviewDialog f140055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f140056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f140057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f140058e;

    public static final class a {
    }

    static {
    }

    public c(ViewGroup r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(null, "guideTrayManager");
        this.f140057d = r100;
        this.f140058e = r101;
        this.f140054a = new ArrayList();
        new d(this);
    }
}
