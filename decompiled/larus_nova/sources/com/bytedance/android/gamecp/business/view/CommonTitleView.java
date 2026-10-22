package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tJ+\u0010\u0011\u001a\u00020\u00042#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/CommonTitleView;", "Landroid/widget/FrameLayout;", "", "title", "", d.f25925o, "", "visible", "setOptionVisible", "Lkotlin/Function0;", "action", "setOnBackClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "setOnOptionClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f56449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f56450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f56451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f56452d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f56453a;

        public a(Function0 r100) {
            this.f56453a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f56453a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f56454a;

        public b(Function1 r100) {
            this.f56454a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f56454a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.view.CommonTitleView$setOnBackClickListener$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.view.CommonTitleView$setOnOptionClickListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class C98691 extends Lambda implements Function1<View, Unit> {
        public static final C98691 INSTANCE = null;

        static {
            INSTANCE = new C98691();
        }

        public C98691() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public CommonTitleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOnBackClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ImageView r101 = this.f56451c;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new a(r100));
        return;
    }

    public final void setOnOptionClickListener(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ImageView r101 = this.f56452d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new b(r100));
        return;
    }

    public final void setOptionVisible(boolean r100) {
        ImageView r101 = this.f56452d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void setTitle(String r100) {
        TextView r101 = this.f56450b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public CommonTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.gamecp_game_comment_tiitle_view, this, true);
        this.f56449a = r103;
        this.f56450b = (TextView) r103.findViewById(R.id.tv_game_comment_title);
        this.f56451c = (ImageView) r103.findViewById(R.id.iv_comment_detail_back);
        this.f56452d = (ImageView) r103.findViewById(R.id.iv_comment_detail_item_option);
    }

    public /* synthetic */ CommonTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
