package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.IContactActiveViewHolderWrapper;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.uicomponent.compoundbutton.TranslucentCheckBox;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class InviteeUserItemViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeUserItemViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TransparentCircleIconView f134660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TransparentCircleIconView f134661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f134662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f134663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TranslucentCheckBox f134664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IContactActiveViewHolderWrapper f134665f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.a f134666g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public a f134667h;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ItemViewHolder f134668a;

            public a(ItemViewHolder r100) {
                this.f134668a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                TranslucentCheckBox r101 = this.f134668a.f134664e;
                r101.setChecked(!r101.isChecked());
            }
        }

        public static final class b implements CompoundButton.OnCheckedChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ItemViewHolder f134669a;

            public b(ItemViewHolder r100) {
                this.f134669a = r100;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton r100, boolean r101) {
                a r102 = this.f134669a.f134667h;
                if (r102 == null) goto L8;
                r102.f134689b = r101;
                c r103 = r102.f134690c;
                if (r103 == null) goto L9;
                r103.bl(r102, r101);
                return;
            L9:
                return;
            }
        }

        public ItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f134660a = (TransparentCircleIconView) r100.findViewById(R.id.contact_avatar);
            this.f134661b = (TransparentCircleIconView) r100.findViewById(R.id.conversation_avatar);
            this.f134662c = (ImageView) r100.findViewById(R.id.contact_active);
            this.f134663d = (TextView) r100.findViewById(R.id.contact_name);
            TranslucentCheckBox r101 = (TranslucentCheckBox) r100.findViewById(R.id.contact_check);
            this.f134664e = r101;
            r100.setOnClickListener(new a(this));
            r101.setOnCheckedChangeListener(new b(this));
        }
    }

    public static final class a extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Fragment f134672d;

        public a(f r100, c r101, WidgetManager r102) {
            Intrinsics.checkNotNullParameter(r100, "contact");
            super(r100, false, r101);
            this.f134672d = r102;
        }
    }

    public InviteeUserItemViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        final ItemViewHolder r102 = (ItemViewHolder) r100;
        final a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f134667h = r103;
        r103.f134688a.getClass();
        r102.f134660a.setVisibility(8);
        r102.f134661b.setVisibility(0);
        TransparentCircleIconView r104 = r102.f134661b;
        r103.f134688a.getClass();
        ImageLoader.bindImage(r104, null);
        TextView r105 = r102.f134663d;
        r103.f134688a.getClass();
        r105.setText(null);
        r102.f134664e.setChecked(r103.f134689b);
        if (r102.f134665f != null) goto L8;
        Fragment r106 = r103.f134672d;
        if (r106 == null) goto L8;
        r102.f134665f = TTLiveSDK.hostService().user().createIContactActiveViewHolder(r106, r102.f134662c);
        Unit r107 = Unit.INSTANCE;
    L8:
        if (r102.f134666g != null) goto L10;
        r102.f134666g = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.a(r102);
        Unit r108 = Unit.INSTANCE;
    L10:
        IContactActiveViewHolderWrapper r109 = r102.f134665f;
        if (r109 == null) goto L13;
        r109.observeAndUpdateActiveStatus(r103.f134688a, r102.f134666g);
    L13:
        r3.e(r102.itemView, new InviteeUserItemViewBinder$ItemViewHolder$bindItem$3(r102, r103));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r102 = 0;
        View r103 = r100.inflate(R.layout.ttlive_item_invitee_list_invitee, r101, false);
        if ((r103 instanceof ViewGroup) == false) goto L8;
        ViewGroup r104 = (ViewGroup) r103;
        int r105 = r104.getChildCount();
    L5:
        if (r102 >= r105) goto L8;
        r3.k(r104.getChildAt(r102));
        r102 = r102 + 1;
    L8:
        return new ItemViewHolder(r103);
    }
}
