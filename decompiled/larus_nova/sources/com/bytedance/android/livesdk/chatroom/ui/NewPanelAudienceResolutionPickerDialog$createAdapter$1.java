package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog$createAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog$a;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPanelAudienceResolutionPickerDialog$createAdapter$1 extends RecyclerView.Adapter<NewPanelAudienceResolutionPickerDialog.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewPanelAudienceResolutionPickerDialog f112433a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        this.f112433a.getClass();
        throw null;
    }

    public NewPanelAudienceResolutionPickerDialog$createAdapter$1(NewPanelAudienceResolutionPickerDialog r100) {
        this.f112433a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        NewPanelAudienceResolutionPickerDialog.a r102 = (NewPanelAudienceResolutionPickerDialog.a) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        this.f112433a.getClass();
        l5 r103 = (l5) ListProtector.get(null, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "audienceResolutionItemInfo");
        NewPanelAudienceResolutionPickerDialog.ResolutionItemView r104 = r102.f112432a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "resolutionInfo");
        r104.a().setText(r103.f113656b);
        r104.setBackground(new ColorDrawable(0));
        String r105 = r103.f113659e;
        int r106 = r105.hashCode();
        if (r106 == (-1577166796)) goto L16;
        if (r106 == 1191572123) goto L13;
        if (r106 == 1671308008) goto L10;
    L18:
        r104.setOnClickListener(new b8(r104, r103));
        return;
    L10:
        if (r105.equals("disable") == false) goto L18;
        r104.a().setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
        r104.a().setAlpha(0.5f);
        goto L18
    L13:
        if (r105.equals("selected") == false) goto L18;
        r104.a().setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        r104.setBackground(r104.getContext().getResources().getDrawable(R.drawable.ttlive_bg_resolution_item));
        goto L18
    L16:
        if (r105.equals("unselected") == false) goto L18;
        r104.a().setTextColor(-1);
        r104.a().setAlpha(0.9f);
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new NewPanelAudienceResolutionPickerDialog.a(new NewPanelAudienceResolutionPickerDialog.ResolutionItemView(this.f112433a.getContext(), new NewPanelAudienceResolutionPickerDialog$createAdapter$1$onCreateViewHolder$1(this)));
    }
}
