package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseModelListScrollManager f141140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceItemDecoration f141141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f141142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f141143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BaseMessageModelAdapter f141144e;

    public static final class a {
    }

    static {
        s1.f(2.0f);
    }

    public final void a() {
        BaseModelListScrollManager r100 = this.f141140a;
        Disposable r101 = r100.f141119g;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        r100.f141119g = null;
        r100.f141123k.setOnClickListener(null);
        r100.f141116d = false;
        r100.f141122j.setOnFlingListener(null);
        r100.f141122j.setOnTouchListener(null);
        r100.f141122j.removeOnScrollListener(r100.f141118f);
        this.f141142c.dispose();
        BaseMessageModelAdapter r102 = this.f141144e;
        ArrayList r103 = new ArrayList();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "items");
        r102.f141109a = r103;
        this.f141143d.removeItemDecoration(this.f141141b);
    }

    public f(RecyclerView r100, View r101, NoMoreSpaceTextView r102, BaseMessageModelAdapter r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "hintLayout");
        Intrinsics.checkNotNullParameter(r102, "hintTextView");
        Intrinsics.checkNotNullParameter(r103, "recyclerAdapter");
        this.f141143d = r100;
        this.f141144e = r103;
        this.f141140a = new BaseModelListScrollManager(r100, r101, r102, 550.0f);
        SpaceItemDecoration r105 = new SpaceItemDecoration(1, r104, false);
        this.f141141b = r105;
        this.f141142c = new CompositeDisposable();
        r100.setItemViewCacheSize(4);
        r100.addItemDecoration(r105);
        r100.setAdapter(r103);
        r100.setOverScrollMode(0);
    }
}
