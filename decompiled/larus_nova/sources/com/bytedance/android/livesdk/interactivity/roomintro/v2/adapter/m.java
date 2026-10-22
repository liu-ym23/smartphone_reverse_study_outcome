package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f140621i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f140622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f140623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f140624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f140625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<p> f140626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RoomIntroDataSource f140627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f140628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f140629h;

    public static final class a {
    }

    static {
    }

    public m(RoomIntroDataSource r100, WrapLineFlowLayout r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "cd");
        this.f140627f = r100;
        this.f140628g = r101;
        this.f140629h = r102;
        this.f140626e = new ArrayList();
    }
}
