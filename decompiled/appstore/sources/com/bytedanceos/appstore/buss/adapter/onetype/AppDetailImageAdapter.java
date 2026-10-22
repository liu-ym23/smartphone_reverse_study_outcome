package com.bytedanceos.appstore.buss.adapter.onetype;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import f7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import x7.m0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailImageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroid/view/View$OnClickListener;", "listener", "<init>", "(Landroid/view/View$OnClickListener;)V", "helper", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/String;)V", "", "hasVideo", "d", "(Z)V", "isHorizontal", "e", "a", "Z", "mHasVideo", "mIsHorizontal", "c", "Landroid/view/View$OnClickListener;", "mClickListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppDetailImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f8399c;

    /* JADX WARN: Multi-variable type inference failed */
    public AppDetailImageAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void a(AppDetailImageAdapter r10, View r11) {
        c(r10, r11);
    }

    public static final void c(AppDetailImageAdapter r10, View r11) {
        q.g(r10, "this$0");
        View.OnClickListener r12 = r10.f8399c;
        if (r12 == null) goto L7;
        if (r12 == null) goto L8;
        r12.onClick(r11);
        return;
    L8:
        return;
    }

    public void b(BaseViewHolder r10, String r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        m0 r12 = m0.a(r10.itemView);
        q.f(r12, "bind(...)");
        if (this.f8397a == true) goto L5;
    L10:
        r12.f25698b.setVisibility(8);
        ImageView r13 = r12.f25699c;
        q.f(r13, "ivImage");
        ImageUtilKt.j(r13, r11, 0, R.drawable.screenshot_default, 2, null);
        return;
    L5:
        if (r10.getAdapterPosition() != 0) goto L10;
        r12.f25698b.setVisibility(0);
        r12.f25698b.setOnClickListener(new a(this));
        if (this.f8398b == false) goto L9;
        ViewGroup.LayoutParams r14 = r12.f25699c.getLayoutParams();
        r14.width = getContext().getResources().getDimensionPixelSize(R.dimen.detail_video_img_width);
        ImageView r15 = r12.f25699c;
        q.f(r15, "ivImage");
        ImageUtilKt.j(r15, r11, 0, R.drawable.screen_shot_bg, 2, null);
        return;
    L9:
        ImageView r16 = r12.f25699c;
        q.f(r16, "ivImage");
        ImageUtilKt.j(r16, r11, 0, R.drawable.screenshot_default, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, String r11) {
        b(r10, r11);
    }

    public final void d(boolean r10) {
        this.f8397a = r10;
    }

    public final void e(boolean r10) {
        this.f8398b = r10;
    }

    public AppDetailImageAdapter(@Nullable View.OnClickListener r10) {
        super(R.layout.tv_item_app_detail_image, null, 2, null);
        this.f8399c = r10;
    }

    public /* synthetic */ AppDetailImageAdapter(View.OnClickListener r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
