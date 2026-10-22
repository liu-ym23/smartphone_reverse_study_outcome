package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMediaView;", "Landroid/widget/FrameLayout;", "", "getViewTopInScreen", "getItemHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentMediaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f164646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv3.commentv2.model.c f164647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommentNodeVO f164648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f164649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f164650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<Integer> f164651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f164652g;

    public CommentMediaView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentMediaView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getViewTopInScreen() {
        int[] r100 = {0, 0};
        getLocationOnScreen(r100);
        return r100[1];
    }

    public final int getItemHeight() {
        return this.f164650e;
    }

    public CommentMediaView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164649d = -1;
        this.f164650e = r100.getResources().getDimensionPixelOffset(R.dimen.commerce_comment_media_item_height);
        this.f164651f = new HashSet();
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_comment_item_new_media_view, this);
        this.f164646a = (RecyclerView) findViewById(R.id.comment_media_content_recyclerview);
    }

    public /* synthetic */ CommentMediaView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
