package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedCommentViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f135054k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f135055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f135056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f135057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f135058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f135059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f135060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final py.k f135061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final py.k f135062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f135063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f135064j;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OGCFixedCommentViewHolder f135065a;

        public a(OGCFixedCommentViewHolder r100) {
            this.f135065a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L6;
        L8:
            OGCFixedCommentViewHolder r103 = this.f135065a;
            int r104 = OGCFixedCommentViewHolder.f135054k;
            r103.T3(false);
        L10:
            return false;
        L6:
            if (r102 == 3) goto L8;
        L9:
            OGCFixedCommentViewHolder r105 = this.f135065a;
            int r106 = OGCFixedCommentViewHolder.f135054k;
            r105.T3(true);
            goto L10
        }
    }

    public final void T3(boolean r100) {
        if (this.f135055a == 1) goto L5;
        return;
    L5:
        ALogger.d("OGCFixedCommentViewHolder[" + hashCode() + ']', "index:" + getAdapterPosition() + ",switch to " + r100);
        if (r100 == false) goto L18;
        HSImageView r101 = (HSImageView) this.f135057c.getValue();
        if (r101 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r101);
    L10:
        HSImageView r102 = (HSImageView) this.f135058d.getValue();
        if (r102 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r102);
    L14:
        if (this.f135064j == null) goto L30;
        TextView r103 = (TextView) this.f135059e.getValue();
        if (r103 == null) goto L31;
        r103.setTextColor(this.f135064j.intValue());
        return;
    L31:
        return;
    L30:
        return;
    L18:
        HSImageView r104 = (HSImageView) this.f135057c.getValue();
        if (r104 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r104);
    L21:
        HSImageView r105 = (HSImageView) this.f135058d.getValue();
        if (r105 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r105);
    L25:
        if (this.f135063i == null) goto L33;
        TextView r106 = (TextView) this.f135059e.getValue();
        if (r106 == null) goto L34;
        r106.setTextColor(this.f135063i.intValue());
        return;
    L34:
        return;
    }

    public OGCFixedCommentViewHolder(View r100, py.k r101, py.k r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f135060f = r100;
        this.f135061g = r101;
        this.f135062h = r102;
        this.f135063i = r103;
        this.f135064j = r104;
        this.f135055a = 2;
        this.f135056b = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedItemRoot$2(this));
        Lazy r105 = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedTextBgDefault$2(this));
        this.f135057c = r105;
        Lazy r106 = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedTextBgSelect$2(this));
        this.f135058d = r106;
        this.f135059e = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedText$2(this));
        a r107 = new a(this);
        if (r102 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
    L11:
        this.itemView.setOnTouchListener(r107);
        return;
    L9:
        if ((!r101.getUrls().isEmpty()) == false) goto L11;
        a1.t((HSImageView) r105.getValue(), r101, false, null);
        goto L11
    L5:
        if ((!r102.getUrls().isEmpty()) == false) goto L7;
        a1.t((HSImageView) r106.getValue(), r102, false, null);
        goto L7
    }
}
