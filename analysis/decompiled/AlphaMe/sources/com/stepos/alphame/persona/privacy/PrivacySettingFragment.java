package com.stepos.alphame.persona.privacy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.d;
import androidx.preference.C;
import androidx.preference.K;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.domain.event.ClearDataMessages;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.privacy.PrivacySettingFragment;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m2.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.DialogInterfaceC0865j;
import stepos.support.v7.app.S;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.l0;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/stepos/alphame/persona/privacy/PrivacySettingFragment;", "Landroidx/preference/y;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/preference/PreferenceScreen;", "preferenceScreen", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onCreateAdapter", "(Landroidx/preference/PreferenceScreen;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "mContext", "Landroid/content/Context;", "<init>", "()V", "CustomAdapter", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PrivacySettingFragment extends y {
    private Context mContext;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/stepos/alphame/persona/privacy/PrivacySettingFragment$CustomAdapter;", "Landroidx/preference/C;", "Lstepos/support/v7/widget/l0;", "", "showCtaRevocationDialog", "()V", "clearAppData", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/preference/K;", "holder", "", AppSuggestStorable.COLUMN_POSITION, "onBindViewHolder", "(Landroidx/preference/K;I)V", "Landroid/content/Context;", "mContext", "onPreferenceClick", "(ILandroid/content/Context;)V", "", "isEnabled", "(I)Z", "isSelectable", "immersiveItemType", "(I)I", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "Lstepos/support/v7/widget/StepOSRecyclerView;", "mzRecyclerView", "Lstepos/support/v7/widget/StepOSRecyclerView;", "", "getCustomTerms", "()Ljava/lang/CharSequence;", "customTerms", "Landroidx/preference/PreferenceGroup;", "preferenceGroup", "<init>", "(Landroidx/preference/PreferenceGroup;Landroid/content/Context;)V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
    @SuppressLint({"RestrictedApi"})
    public static final class CustomAdapter extends C implements l0 {

        @NotNull
        public static final String AEPP = "aepp";

        @NotNull
        private final Context context;

        @Nullable
        private StepOSRecyclerView mzRecyclerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomAdapter(@NotNull PreferenceGroup preferenceGroup, @NotNull Context context) {
            super(preferenceGroup);
            Intrinsics.checkNotNullParameter(preferenceGroup, "preferenceGroup");
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        private final void clearAppData() {
            Object systemService = this.context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService).clearApplicationUserData();
        }

        private final CharSequence getCustomTerms() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = this.context.getString(R.string.permission_privacy_recovation_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            spannableStringBuilder.append((CharSequence) string);
            return spannableStringBuilder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(CustomAdapter this$0, int i4, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this$0.onPreferenceClick(i4, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreferenceClick$lambda$1(PolicySdkResultBean policySdkResultBean) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreferenceClick$lambda$2(PolicySdkResultBean policySdkResultBean) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreferenceClick$lambda$3(PolicySdkResultBean policySdkResultBean) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreferenceClick$lambda$4(PolicySdkResultBean policySdkResultBean) {
        }

        private final void showCtaRevocationDialog() {
            DialogInterfaceC0865j dialogInterfaceC0865jShowWithdrawalDialogRecord;
            try {
                String string = this.context.getString(R.string.aicy_privacy_pp_revocation);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CharSequence customTerms = getCustomTerms();
                String string2 = this.context.getString(R.string.aicy_privacy_pp_revocation_arg);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = this.context.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                dialogInterfaceC0865jShowWithdrawalDialogRecord = PolicySdk.showWithdrawalDialogRecord(this.context, string, customTerms, string3, string2, new String[]{"pp", "up"}, null, new S() { // from class: com.stepos.alphame.persona.privacy.PrivacySettingFragment$CustomAdapter$showCtaRevocationDialog$1
                    public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, Map map) {
                    }

                    @Override // stepos.support.v7.app.S
                    public void onPermissionClick(@NotNull DialogInterface dialog, boolean alwaysDeny, boolean allow) {
                        Intrinsics.checkNotNullParameter(dialog, "dialog");
                        if (allow) {
                            PersonalPreferenceConfigs.INSTANCE.clearDataWhenUserRevocation();
                            if (this.this$0.context instanceof Activity) {
                                Context context = this.this$0.context;
                                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.stepos.alphame.persona.privacy.PrivacySettingActivity");
                                ((PrivacySettingActivity) context).getMMessenger().input(new ClearDataMessages(EventId.CLEAR_DATA, true));
                                ((Activity) this.this$0.context).finish();
                            }
                        }
                    }
                });
            } catch (Exception unused) {
                dialogInterfaceC0865jShowWithdrawalDialogRecord = null;
            }
            if (dialogInterfaceC0865jShowWithdrawalDialogRecord == null || dialogInterfaceC0865jShowWithdrawalDialogRecord.isShowing()) {
                return;
            }
            dialogInterfaceC0865jShowWithdrawalDialogRecord.show();
        }

        public int immersiveItemType(int position) {
            if (position != 0) {
                return (position == 1 || position == 2 || position == 3) ? 1 : 2;
            }
            return 0;
        }

        @Override // stepos.support.v7.widget.l0
        public boolean isEnabled(int position) {
            return false;
        }

        @Override // stepos.support.v7.widget.l0
        public boolean isSelectable(int position) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onAttachedToRecyclerView(recyclerView);
            if (recyclerView instanceof StepOSRecyclerView) {
                this.mzRecyclerView = (StepOSRecyclerView) recyclerView;
            }
        }

        public final void onPreferenceClick(int position, @NotNull Context mContext) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            String language = PolicySdkToolsUtils.INSTANCE.getLanguage();
            if (position == 0) {
                final int i4 = 0;
                PolicySdk.getOnlinePolicyMethod(mContext, language, "picl", mContext.getString(R.string.personal_information_collection_list), Boolean.FALSE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.alphame.persona.privacy.b
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                    public final void getResult(PolicySdkResultBean policySdkResultBean) {
                        switch (i4) {
                            case 0:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$1(policySdkResultBean);
                                break;
                            case 1:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$2(policySdkResultBean);
                                break;
                            case 2:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$3(policySdkResultBean);
                                break;
                            default:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$4(policySdkResultBean);
                                break;
                        }
                    }
                });
                return;
            }
            final int i5 = 1;
            if (position == 1) {
                PolicySdk.getOnlinePolicyMethod(mContext, language, "tisl", mContext.getString(R.string.third_party_information_shared_list), Boolean.FALSE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.alphame.persona.privacy.b
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                    public final void getResult(PolicySdkResultBean policySdkResultBean) {
                        switch (i5) {
                            case 0:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$1(policySdkResultBean);
                                break;
                            case 1:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$2(policySdkResultBean);
                                break;
                            case 2:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$3(policySdkResultBean);
                                break;
                            default:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$4(policySdkResultBean);
                                break;
                        }
                    }
                });
                return;
            }
            final int i6 = 2;
            if (position == 2) {
                PolicySdk.getOnlinePolicyMethod(mContext, language, "pcpi", mContext.getString(R.string.personal_information_protection_rules_of_children), Boolean.FALSE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.alphame.persona.privacy.b
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                    public final void getResult(PolicySdkResultBean policySdkResultBean) {
                        switch (i6) {
                            case 0:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$1(policySdkResultBean);
                                break;
                            case 1:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$2(policySdkResultBean);
                                break;
                            case 2:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$3(policySdkResultBean);
                                break;
                            default:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$4(policySdkResultBean);
                                break;
                        }
                    }
                });
                return;
            }
            final int i7 = 3;
            if (position == 3) {
                PolicySdk.getOnlinePolicyMethod(mContext, language, AEPP, mContext.getString(R.string.privacy_policy), Boolean.FALSE, new PolicySdk.PolicySdkCallback() { // from class: com.stepos.alphame.persona.privacy.b
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                    public final void getResult(PolicySdkResultBean policySdkResultBean) {
                        switch (i7) {
                            case 0:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$1(policySdkResultBean);
                                break;
                            case 1:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$2(policySdkResultBean);
                                break;
                            case 2:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$3(policySdkResultBean);
                                break;
                            default:
                                PrivacySettingFragment.CustomAdapter.onPreferenceClick$lambda$4(policySdkResultBean);
                                break;
                        }
                    }
                });
            } else {
                if (position != 4) {
                    return;
                }
                showCtaRevocationDialog();
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
                view.setPadding(view.getPaddingLeft(), (int) o.c(holder.itemView.getContext(), 24.0f), holder.itemView.getPaddingRight(), holder.itemView.getPaddingBottom());
            } else if (iImmersiveItemType == 2) {
                View view2 = holder.itemView;
                view2.setPadding(view2.getPaddingLeft(), holder.itemView.getPaddingTop(), holder.itemView.getPaddingRight(), (int) o.c(holder.itemView.getContext(), 24.0f));
            } else if (iImmersiveItemType == 3) {
                View view3 = holder.itemView;
                view3.setPadding(view3.getPaddingLeft(), (int) o.c(holder.itemView.getContext(), 24.0f), holder.itemView.getPaddingRight(), (int) o.c(holder.itemView.getContext(), 24.0f));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.alphame.persona.privacy.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    PrivacySettingFragment.CustomAdapter.onBindViewHolder$lambda$0(this.f11206a, position, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(PrivacySettingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getListView() == null) {
            return;
        }
        this$0.getListView().setPadding(this$0.getListView().getPaddingLeft(), this$0.getListView().getPaddingTop(), this$0.getListView().getPaddingRight(), (int) o.c(this$0.getListView().getContext(), 64.0f));
    }

    @Override // androidx.fragment.app.D
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // androidx.preference.y
    @NotNull
    public RecyclerView.Adapter<?> onCreateAdapter(@NotNull PreferenceScreen preferenceScreen) {
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        return new CustomAdapter(preferenceScreen, context);
    }

    @Override // androidx.preference.y
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.aicy_privacy_setting, rootKey);
    }

    @Override // androidx.preference.y
    @NotNull
    public RecyclerView onCreateRecyclerView(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        inflater.inflate(R.layout.preference_privacy_layout, parent, true);
        StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) parent.findViewById(R.id.view_rv);
        stepOSRecyclerView.f14915B0 = true;
        stepOSRecyclerView.setLayoutManager(new LinearLayoutManager(parent.getContext(), 1, false));
        Intrinsics.checkNotNull(stepOSRecyclerView);
        return stepOSRecyclerView;
    }

    @Override // androidx.preference.y, androidx.fragment.app.D
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        while (getListView().getItemDecorationCount() > 0) {
            getListView().removeItemDecorationAt(0);
        }
        getListView().setClipToPadding(false);
        getListView().post(new d(19, this));
    }
}
