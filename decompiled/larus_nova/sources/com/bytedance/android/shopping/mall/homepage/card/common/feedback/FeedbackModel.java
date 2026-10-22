package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class FeedbackModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super FeedbackData.Item, Unit> f177512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f177513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f177514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f177515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f177516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f177517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f177518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f177519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f177520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f177521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f177522k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FeedbackData.Item f177523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f177524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f177525c;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f177524b = r100;
            this.f177525c = r101;
        }
    }

    public FeedbackModel(List<a> r100, List<a> r101, boolean r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "pageOneList");
        Intrinsics.checkNotNullParameter(r101, "pageTwoList");
        Intrinsics.checkNotNullParameter(r103, "moreText");
        Intrinsics.checkNotNullParameter(r105, "toastMsg");
        this.f177517f = r100;
        this.f177518g = r101;
        this.f177519h = r102;
        this.f177520i = r103;
        this.f177521j = r104;
        this.f177522k = r105;
        this.f177512a = FeedbackModel$onClickItem$1.INSTANCE;
        this.f177513b = FeedbackModel$onClickClose$1.INSTANCE;
        this.f177514c = FeedbackModel$onClickFindSimilar$1.INSTANCE;
        this.f177515d = FeedbackModel$onClickBack$1.INSTANCE;
        this.f177516e = FeedbackModel$onClickMore$1.INSTANCE;
    }
}
