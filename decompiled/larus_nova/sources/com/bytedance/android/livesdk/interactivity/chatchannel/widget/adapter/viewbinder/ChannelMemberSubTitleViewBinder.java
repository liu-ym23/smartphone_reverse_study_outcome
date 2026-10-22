package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes9.dex */
public final class ChannelMemberSubTitleViewBinder extends b<a, TitleViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/viewbinder/ChannelMemberSubTitleViewBinder$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f134579a;

        public TitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f134579a = (TextView) r100.findViewById(R.id.sub_title_view);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f134580a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f134580a, ((a) r100).f134580a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f134580a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "SubTitle(title=" + this.f134580a + ")";
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f134580a = r100;
        }
    }

    public ChannelMemberSubTitleViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        TitleViewHolder r102 = (TitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "title");
        r102.f134579a.setText(r103.f134580a);
        r3.a(r102.f134579a, r103.f134580a);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new TitleViewHolder(r100.inflate(R.layout.ttlive_item_room_channel_member_list_sub_title, r101, false));
    }

    @Override // me.drakeet.multitype.b
    public final void c(RecyclerView.ViewHolder r100, a r101, List r102) {
        TitleViewHolder r103 = (TitleViewHolder) r100;
        a r104 = r101;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.size() != 0) goto L5;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "title");
        r103.f134579a.setText(r104.f134580a);
        r3.a(r103.f134579a, r104.f134580a);
        return;
    L5:
        Object r105 = ListProtector.get(r102, r102.size() - 1);
        if (r105 == null) goto L21;
        Iterator<String> r106 = ((Bundle) r105).keySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L31;
        String r107 = r106.next();
        if (r107 == null) goto L9;
        if (r107.hashCode() != (-2047941432)) goto L9;
        if (r107.equals("payload_key_sub_title") == false) goto L9;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "title");
        r103.f134579a.setText(r104.f134580a);
        r3.a(r103.f134579a, r104.f134580a);
        goto L9
    L31:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }
}
