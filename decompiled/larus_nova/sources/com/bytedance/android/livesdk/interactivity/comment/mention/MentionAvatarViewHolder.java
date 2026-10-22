package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MentionAvatarViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransparentCircleIconView f135251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f135252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MentionCheckBoxWrapper f135253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f135254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f135255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f135256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f135257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f135258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f135259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135260j;

    public static final class a implements MentionCheckBoxWrapper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MentionAvatarViewHolder f135262a;

        public a(MentionAvatarViewHolder r100) {
            this.f135262a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.mention.MentionCheckBoxWrapper.a
        public final void a(boolean r100) {
            MentionAvatarViewHolder r101 = this.f135262a;
            l r102 = r101.f135255e;
            if (r102 != null) goto L5;
            return;
        L5:
            r102.f135311b = r100;
            if (r100 == false) goto L8;
            r101.f135251a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
            UtilityKotlinExtentionsKt.t(this.f135262a.f135252b);
            this.f135262a.f135253c.f135265c.setVisibility(0);
        L12:
            this.f135262a.f135259i.a(r102, r100);
            return;
        L8:
            r101.f135253c.f135265c.setVisibility(8);
            MentionAvatarViewHolder r103 = this.f135262a;
            if (r103.f135257g == false) goto L11;
            r103.f135251a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
            UtilityKotlinExtentionsKt.w(this.f135262a.f135252b);
            goto L12
        L11:
            r103.f135251a.setCircleRadius(0.0f);
            UtilityKotlinExtentionsKt.t(this.f135262a.f135252b);
            goto L12
        }
    }

    public static final class b {
    }

    static {
    }

    public MentionAvatarViewHolder(View r100, m r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "selectListener");
        Intrinsics.checkNotNullParameter(r102, "bridges");
        super(r100);
        this.f135258h = r100;
        this.f135259i = r101;
        this.f135260j = r102;
        this.f135251a = (TransparentCircleIconView) r100.findViewById(R.id.mention_user_avatar);
        this.f135252b = (ImageView) r100.findViewById(R.id.mention_user_active);
        MentionCheckBoxWrapper r103 = new MentionCheckBoxWrapper(r100.findViewById(R.id.mention_user_selected));
        this.f135253c = r103;
        this.f135254d = (TextView) r100.findViewById(R.id.mention_user_name);
        this.f135256f = -1;
        a r104 = new a(this);
        Intrinsics.checkNotNullParameter(r104, "checkStateChangeListener");
        ((List) r103.f135264b.getValue()).add(r104);
        r100.setOnClickListener(new AnonymousClass2(this));
    }
}
