package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentAppendLayout;", "Landroid/widget/FrameLayout;", "", "getViewTopInScreen", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentAppendLayout extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f164584e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f164585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentMediaView f164587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f164588d;

    public static final class a {
    }

    static {
    }

    public CommentAppendLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentAppendLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getViewTopInScreen() {
        return this.f164587c.getViewTopInScreen();
    }

    public CommentAppendLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_anchor_v3_item_comment_append, this, true);
        this.f164585a = (TextView) findViewById(R.id.append_comment_content);
        this.f164586b = (TextView) findViewById(R.id.append_comment_time);
        this.f164587c = (CommentMediaView) findViewById(R.id.comment_media_view);
        this.f164588d = (TextView) findViewById(R.id.comment_append_tv_content_info);
    }

    public /* synthetic */ CommentAppendLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
