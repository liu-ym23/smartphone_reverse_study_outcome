package com.bytedanceos.appstore.buss.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.TvAppInfoVideoEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.toolbox.ServerElements;
import com.github.chrisbanes.photoview.PhotoView;
import com.obric.appstore.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/appstore/buss/activity/AppImageDetailActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "<init>", "()V", "", "J", "initView", "initData", "I", "finish", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "imageList", "", "d", "prePointIndex", "H", "()I", "layoutId", "Lx7/b;", "O", "()Lx7/b;", "activityTvImageDetailBinding", "e", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppImageDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppImageDetailActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppImageDetailActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1864#2,3:113\n*S KotlinDebug\n*F\n+ 1 AppImageDetailActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppImageDetailActivity\n*L\n61#1:113,3\n*E\n"})
public final class AppImageDetailActivity extends BaseActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8305e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f8306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8307d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Context r10, TvAppInfoVideoEntity r11, int r12, ArrayList r13) {
            q.g(r10, ServerElements.CONTENT);
            q.g(r13, "imageDetailList");
            Intent r14 = new Intent(r10, AppImageDetailActivity.class);
            r14.putExtra(ServerElements.VIDEO, r11);
            r14.putExtra("imagePosition", r12);
            r14.putExtra("imageUrl", r13);
            r10.startActivity(r14);
        }

        public a() {
        }
    }

    public static final class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppImageDetailActivity f8308a;

        public b(AppImageDetailActivity r10) {
            this.f8308a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            AppImageDetailActivity.L(this.f8308a).f25498b.getChildAt(r10).setBackgroundResource(R.drawable.dot_active);
            AppImageDetailActivity.L(this.f8308a).f25498b.getChildAt(AppImageDetailActivity.M(this.f8308a)).setBackgroundResource(R.drawable.dot_dark);
            AppImageDetailActivity.N(this.f8308a, r10);
        }
    }

    static {
        f8305e = new a(null);
    }

    public AppImageDetailActivity() {
        this.f8306c = new ArrayList();
    }

    public static /* synthetic */ void K(AppImageDetailActivity r10, View r11) {
        P(r10, r11);
    }

    public static final /* synthetic */ x7.b L(AppImageDetailActivity r10) {
        return r10.O();
    }

    public static final /* synthetic */ int M(AppImageDetailActivity r10) {
        return r10.f8307d;
    }

    public static final /* synthetic */ void N(AppImageDetailActivity r10, int r11) {
        r10.f8307d = r11;
    }

    public static final void P(AppImageDetailActivity r10, View r11) {
        q.g(r10, "this$0");
        r10.finish();
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_image_detail;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
    }

    public final x7.b O() {
        x7.b r10 = x7.b.a(G());
        q.f(r10, "bind(...)");
        return r10;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.close_activity_exit);
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
        int r10 = 0;
        int r11 = getIntent().getIntExtra("imagePosition", 0);
        Serializable r12 = getIntent().getSerializableExtra("imageUrl");
        q.e(r12, "null cannot be cast to non-null type kotlin.collections.List<*>");
        getIntent().getSerializableExtra(ServerElements.VIDEO);
        O().f25498b.removeAllViews();
        Iterator r13 = ((List) r12).iterator();
    L4:
        if (r13.hasNext() == false) goto L16;
        Object r14 = r13.next();
        int r15 = r10 + 1;
        if (r10 >= 0) goto L8;
        t.q();
    L8:
        PhotoView r16 = new PhotoView(this);
        r16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r16.setAdjustViewBounds(true);
        r16.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        ImageUtilKt.d(r16, r14);
        this.f8306c.add(r16);
        ImageView r17 = new ImageView(this);
        this.f8307d = r11;
        if (r10 != r11) goto L11;
        int r18 = R.drawable.dot_active;
    L12:
        r17.setBackgroundResource(r18);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(com.bytedanceos.appstore.buss.utilities.g.b(10), com.bytedanceos.appstore.buss.utilities.g.b(10));
        if (r10 == 0) goto L15;
        r19.leftMargin = com.bytedanceos.appstore.buss.utilities.g.b(10);
    L15:
        r17.setLayoutParams(r19);
        O().f25498b.addView(r17);
        r16.setOnClickListener(new com.bytedanceos.appstore.buss.activity.b(this));
        r10 = r15;
        goto L4
    L11:
        r18 = R.drawable.dot_dark;
        goto L12
    L16:
        f7.b r20 = new f7.b(this.f8306c);
        O().f25499c.setAdapter(r20);
        r20.notifyDataSetChanged();
        O().f25499c.setCurrentItem(r11);
        O().f25499c.addOnPageChangeListener(new b(this));
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
    }
}
