package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/CopiedLinkToThirdAppHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CopiedLinkToThirdAppHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f115458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f115459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f115460c;

    public CopiedLinkToThirdAppHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f115460c = r100;
        this.f115458a = (ImageView) r100.findViewById(R.id.item_icon);
        this.f115459b = (TextView) r100.findViewById(R.id.item_title);
    }
}
