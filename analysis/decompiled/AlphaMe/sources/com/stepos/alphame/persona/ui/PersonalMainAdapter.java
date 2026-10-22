package com.stepos.alphame.persona.ui;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.P;
import androidx.preference.C;
import androidx.preference.K;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.internal.p;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.address.ui.AddressMainActivity;
import com.stepos.alphame.persona.carbluetooth.CarBluetoothListActivity;
import com.stepos.alphame.persona.common.time.PersonalCommonTimePickerActivity;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.request.PersonalMainRequester;
import com.stepos.alphame.persona.privacy.PrivacySettingActivity;
import com.stepos.alphame.persona.wifi.WifiListActivity;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m2.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.C0861f;
import stepos.support.v7.app.C0864i;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.l0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/stepos/alphame/persona/ui/PersonalMainAdapter;", "Landroidx/preference/C;", "Lstepos/support/v7/widget/l0;", "", AppSuggestStorable.COLUMN_POSITION, "Landroid/content/Context;", "mContext", "", "onPreferenceClick", "(ILandroid/content/Context;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/preference/K;", "holder", "onBindViewHolder", "(Landroidx/preference/K;I)V", "", "isEnabled", "(I)Z", "isSelectable", "immersiveItemType", "(I)I", "Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "requester", "Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "getRequester", "()Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "Lstepos/support/v7/widget/StepOSRecyclerView;", "mzRecyclerView", "Lstepos/support/v7/widget/StepOSRecyclerView;", "Landroidx/preference/PreferenceGroup;", "preferenceGroup", "<init>", "(Landroidx/preference/PreferenceGroup;Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;)V", "app_release"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class PersonalMainAdapter extends C implements l0 {

    @Nullable
    private StepOSRecyclerView mzRecyclerView;

    @NotNull
    private final PersonalMainRequester requester;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalMainAdapter(@NotNull PreferenceGroup preferenceGroup, @NotNull PersonalMainRequester requester) {
        super(preferenceGroup);
        Intrinsics.checkNotNullParameter(preferenceGroup, "preferenceGroup");
        Intrinsics.checkNotNullParameter(requester, "requester");
        this.requester = requester;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PersonalMainAdapter this$0, int i4, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this$0.onPreferenceClick(i4, context);
    }

    private final void onPreferenceClick(int position, Context mContext) {
        g.z("po ", position, "sherlock");
        switch (position) {
            case 2:
                AddressMainActivity.INSTANCE.start(mContext, EventId.HOME_ADDRESS.getId());
                break;
            case 3:
                AddressMainActivity.INSTANCE.start(mContext, EventId.COMPANY_ADDRESS.getId());
                break;
            case 5:
                WifiListActivity.INSTANCE.start(mContext, EventId.HOME_WIFI.getId());
                break;
            case 6:
                WifiListActivity.INSTANCE.start(mContext, EventId.COMPANY_WIFI.getId());
                break;
            case 8:
                PersonalCommonTimePickerActivity.INSTANCE.start(mContext, EventId.TIME_AWAY_FROM_HOME.getId());
                break;
            case 9:
                PersonalCommonTimePickerActivity.INSTANCE.start(mContext, EventId.OFF_DUTY_TIME.getId());
                break;
            case 10:
                Object obj = this.requester.getCommutingMode().f3893e;
                if (obj == P.f3888k) {
                    obj = null;
                }
                Long l4 = (Long) obj;
                if (l4 != null) {
                    long jLongValue = l4.longValue();
                    C0864i c0864i = new C0864i(mContext);
                    int i4 = R.string.commuting_mode;
                    C0861f c0861f = c0864i.f14506a;
                    c0861f.f14452d = c0861f.f14449a.getText(i4);
                    int i5 = R.array.commuting_mode_option;
                    b bVar = new b(2, this);
                    C0861f c0861f2 = c0864i.f14506a;
                    c0861f2.f14463o = c0861f2.f14449a.getResources().getTextArray(i5);
                    c0861f2.f14465q = bVar;
                    c0861f2.f14468t = (int) jLongValue;
                    c0861f2.f14467s = true;
                    c0864i.a(new p(28, c0864i)).show();
                    break;
                }
                break;
            case 12:
                PersonalCommonTimePickerActivity.INSTANCE.start(mContext, EventId.SLEEP_TIME.getId());
                break;
            case 13:
                PersonalCommonTimePickerActivity.INSTANCE.start(mContext, EventId.WAKE_UP_TIME.getId());
                break;
            case 15:
                CarBluetoothListActivity.INSTANCE.start(mContext);
                break;
            case 17:
                PrivacySettingActivity.INSTANCE.start(mContext);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreferenceClick$lambda$2$lambda$1(PersonalMainAdapter this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlphaMeLogger.debugLog("Personal", "select " + i4);
        this$0.requester.postCommutingMode(i4);
        dialogInterface.dismiss();
    }

    @NotNull
    public final PersonalMainRequester getRequester() {
        return this.requester;
    }

    public int immersiveItemType(int position) {
        switch (position) {
            case 0:
            case 15:
            case 17:
                return 3;
            case 1:
            case 4:
            case 7:
            case 11:
            case 14:
            case 16:
                return 4;
            case 2:
            case 5:
            case 8:
            case 12:
                return 0;
            case 3:
            case 6:
            case 10:
            case 13:
                return 2;
            case 9:
            default:
                return 1;
        }
    }

    @Override // stepos.support.v7.widget.l0
    public boolean isEnabled(int position) {
        return true;
    }

    @Override // stepos.support.v7.widget.l0
    public boolean isSelectable(int position) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView instanceof StepOSRecyclerView) {
            this.mzRecyclerView = (StepOSRecyclerView) recyclerView;
        }
    }

    @Override // androidx.preference.C, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull K holder, @SuppressLint({"RecyclerView"}) final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        int iImmersiveItemType = immersiveItemType(position);
        StepOSRecyclerView stepOSRecyclerView = this.mzRecyclerView;
        Intrinsics.checkNotNull(stepOSRecyclerView);
        stepOSRecyclerView.t(iImmersiveItemType, holder.itemView);
        if (iImmersiveItemType == 0) {
            View view = holder.itemView;
            view.setPadding((int) o.c(view.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f), (int) o.c(holder.itemView.getContext(), 32.0f), holder.itemView.getPaddingBottom());
        } else if (iImmersiveItemType == 2) {
            View view2 = holder.itemView;
            view2.setPadding((int) o.c(view2.getContext(), 32.0f), holder.itemView.getPaddingTop(), (int) o.c(holder.itemView.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f));
        } else if (iImmersiveItemType == 3) {
            View view3 = holder.itemView;
            view3.setPadding((int) o.c(view3.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f), (int) o.c(holder.itemView.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f));
        } else if (iImmersiveItemType != 4) {
            View view4 = holder.itemView;
            view4.setPadding((int) o.c(view4.getContext(), 32.0f), holder.itemView.getPaddingTop(), (int) o.c(holder.itemView.getContext(), 32.0f), holder.itemView.getPaddingBottom());
        } else {
            View view5 = holder.itemView;
            view5.setPadding((int) o.c(view5.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 32.0f), holder.itemView.getPaddingBottom());
        }
        if (position != 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.alphame.persona.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    PersonalMainAdapter.onBindViewHolder$lambda$0(this.f11209a, position, view6);
                }
            });
        }
    }
}
