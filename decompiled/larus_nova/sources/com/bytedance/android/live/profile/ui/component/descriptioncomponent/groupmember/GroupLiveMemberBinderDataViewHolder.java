package com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt0.b;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/groupmember/GroupLiveMemberBinderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveMemberBinderDataViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qt0.a f86517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundCornerImageView f86518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f86519c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupLiveMemberBinderDataViewHolder f86520a;

        public a(GroupLiveMemberBinderDataViewHolder r100) {
            this.f86520a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            qt0.a r101 = this.f86520a.f86517a;
            b r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.f534764a;
        L6:
            if (r101 == null) goto L8;
            r102 = r101.f534768e;
        L8:
            if (r103 == null) goto L12;
            if (r102 == null) goto L13;
            r102.a(r103);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public GroupLiveMemberBinderDataViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        r100.setOnClickListener(new a(this));
        this.f86518b = (RoundCornerImageView) r100.findViewById(R.id.member_avatar);
        this.f86519c = (TextView) r100.findViewById(R.id.member_name);
    }
}
