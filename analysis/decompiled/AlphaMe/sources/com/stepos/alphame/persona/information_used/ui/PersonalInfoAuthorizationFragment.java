package com.stepos.alphame.persona.information_used.ui;

import O1.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.media.session.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.d;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.n0;
import androidx.lifecycle.u0;
import androidx.preference.C;
import androidx.preference.InterfaceC0343o;
import androidx.preference.InterfaceC0344p;
import androidx.preference.K;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.R;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.information_used.data.InformationUsedEntity;
import com.stepos.alphame.persona.information_used.domain.InformationUsedRequester;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.common.preference.SwitchPreferenceCompat;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import m2.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.AbstractActivityC0866k;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.l0;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J)\u0010\u001e\u001a\u00028\u0000\"\n\b\u0000\u0010\u001b*\u0004\u0018\u00010\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\"\u0010#J\u001b\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00102R\u0016\u00106\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00107\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00102R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationFragment;", "Landroidx/preference/y;", "", "initView", "()V", "observer", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "rootKey", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/recyclerview/widget/RecyclerView;", "initViewModel", "Landroidx/lifecycle/n0;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "getFragmentScopeViewModel", "(Ljava/lang/Class;)Landroidx/lifecycle/n0;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/preference/PreferenceScreen;", "preferenceScreen", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onCreateAdapter", "(Landroidx/preference/PreferenceScreen;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "isAppExist", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/stepos/alphame/persona/information_used/domain/InformationUsedRequester;", "mRequester", "Lcom/stepos/alphame/persona/information_used/domain/InformationUsedRequester;", "Lcom/stepos/common/preference/SwitchPreferenceCompat;", "voiceAppSwitchPreference", "Lcom/stepos/common/preference/SwitchPreferenceCompat;", "noteAppSwitchPreference", "settingAppSwitchPreference", "systemUiToolAppSwitchPreference", "aicyButlerAppSwitchPreference", "weatherAppSwitchPreference", "LO1/b;", "mViewModelScope", "LO1/b;", "Lstepos/support/v7/app/k;", "mActivity", "Lstepos/support/v7/app/k;", "<init>", "Companion", "CustomAdapter", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalInfoAuthorizationFragment extends y {

    @NotNull
    public static final String TAG = "PersonalInfoAuthorization";
    private SwitchPreferenceCompat aicyButlerAppSwitchPreference;
    private AbstractActivityC0866k mActivity;
    private InformationUsedRequester mRequester;

    @NotNull
    private final b mViewModelScope = new b();
    private SwitchPreferenceCompat noteAppSwitchPreference;
    private SwitchPreferenceCompat settingAppSwitchPreference;
    private SwitchPreferenceCompat systemUiToolAppSwitchPreference;
    private SwitchPreferenceCompat voiceAppSwitchPreference;
    private SwitchPreferenceCompat weatherAppSwitchPreference;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/stepos/alphame/persona/information_used/ui/PersonalInfoAuthorizationFragment$CustomAdapter;", "Landroidx/preference/C;", "Lstepos/support/v7/widget/l0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/preference/K;", "holder", "", AppSuggestStorable.COLUMN_POSITION, "onBindViewHolder", "(Landroidx/preference/K;I)V", "", "isEnabled", "(I)Z", "isSelectable", "immersiveItemType", "(I)I", "Lstepos/support/v7/widget/StepOSRecyclerView;", "mzRecyclerView", "Lstepos/support/v7/widget/StepOSRecyclerView;", "footCount", "I", "getFootCount", "()I", "setFootCount", "(I)V", "Landroidx/preference/PreferenceGroup;", "preferenceGroup", "<init>", "(Landroidx/preference/PreferenceGroup;)V", "app_release"}, k = 1, mv = {1, 9, 0})
    @SuppressLint({"RestrictedApi"})
    public static final class CustomAdapter extends C implements l0 {
        private int footCount;

        @Nullable
        private StepOSRecyclerView mzRecyclerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomAdapter(@NotNull PreferenceGroup preferenceGroup) {
            super(preferenceGroup);
            Intrinsics.checkNotNullParameter(preferenceGroup, "preferenceGroup");
            this.footCount = 3;
        }

        public final int getFootCount() {
            return this.footCount;
        }

        public int immersiveItemType(int position) {
            if (position == 0) {
                return 4;
            }
            if (position == 1) {
                return 0;
            }
            return position <= this.footCount ? 1 : 2;
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

        public final void setFootCount(int i4) {
            this.footCount = i4;
        }

        @Override // androidx.preference.C, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull K holder, @SuppressLint({"RecyclerView"}) int position) {
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
            } else if (iImmersiveItemType != 3) {
                View view3 = holder.itemView;
                view3.setPadding((int) o.c(view3.getContext(), 32.0f), holder.itemView.getPaddingTop(), (int) o.c(holder.itemView.getContext(), 32.0f), holder.itemView.getPaddingBottom());
            } else {
                View view4 = holder.itemView;
                view4.setPadding((int) o.c(view4.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f), (int) o.c(holder.itemView.getContext(), 32.0f), (int) o.c(holder.itemView.getContext(), 24.0f));
            }
        }
    }

    private final void initView() throws PackageManager.NameNotFoundException {
        Preference preferenceFindPreference = findPreference("voice_app");
        Intrinsics.checkNotNull(preferenceFindPreference);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) preferenceFindPreference;
        this.voiceAppSwitchPreference = switchPreferenceCompat;
        SwitchPreferenceCompat switchPreferenceCompat2 = null;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        final int i4 = 0;
        switchPreferenceCompat.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i5 = i4;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i5) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        Preference preferenceFindPreference2 = findPreference("note_app");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) preferenceFindPreference2;
        this.noteAppSwitchPreference = switchPreferenceCompat3;
        if (switchPreferenceCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noteAppSwitchPreference");
            switchPreferenceCompat3 = null;
        }
        final int i5 = 1;
        switchPreferenceCompat3.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i52 = i5;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i52) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        Preference preferenceFindPreference3 = findPreference("setting_app");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) preferenceFindPreference3;
        this.settingAppSwitchPreference = switchPreferenceCompat4;
        if (switchPreferenceCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAppSwitchPreference");
            switchPreferenceCompat4 = null;
        }
        final int i6 = 2;
        switchPreferenceCompat4.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i52 = i6;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i52) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        Preference preferenceFindPreference4 = findPreference("system_ui_tool_app");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) preferenceFindPreference4;
        this.systemUiToolAppSwitchPreference = switchPreferenceCompat5;
        if (switchPreferenceCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("systemUiToolAppSwitchPreference");
            switchPreferenceCompat5 = null;
        }
        final int i7 = 3;
        switchPreferenceCompat5.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i52 = i7;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i52) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean zIsAppExist = isAppExist(contextRequireContext, EngineContract.AICY_Butler);
        if (!zIsAppExist) {
            PersonalPreferenceConfigs.INSTANCE.removeFromWhitelist(EngineContract.AICY_Butler);
        }
        Preference preferenceFindPreference5 = findPreference("aicy_butler_app");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        SwitchPreferenceCompat switchPreferenceCompat6 = (SwitchPreferenceCompat) preferenceFindPreference5;
        this.aicyButlerAppSwitchPreference = switchPreferenceCompat6;
        if (switchPreferenceCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aicyButlerAppSwitchPreference");
            switchPreferenceCompat6 = null;
        }
        final int i8 = 4;
        switchPreferenceCompat6.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i52 = i8;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i52) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        SwitchPreferenceCompat switchPreferenceCompat7 = this.aicyButlerAppSwitchPreference;
        if (switchPreferenceCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aicyButlerAppSwitchPreference");
            switchPreferenceCompat7 = null;
        }
        if (switchPreferenceCompat7.f4099w != zIsAppExist) {
            switchPreferenceCompat7.f4099w = zIsAppExist;
            InterfaceC0343o interfaceC0343o = switchPreferenceCompat7.f4070G;
            if (interfaceC0343o != null) {
                interfaceC0343o.onPreferenceVisibilityChange(switchPreferenceCompat7);
            }
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        boolean zIsAppExist2 = isAppExist(contextRequireContext2, EngineContract.WEATHER);
        if (!zIsAppExist2) {
            PersonalPreferenceConfigs.INSTANCE.removeFromWhitelist(EngineContract.WEATHER);
        }
        Preference preferenceFindPreference6 = findPreference("weather_app");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        SwitchPreferenceCompat switchPreferenceCompat8 = (SwitchPreferenceCompat) preferenceFindPreference6;
        this.weatherAppSwitchPreference = switchPreferenceCompat8;
        if (switchPreferenceCompat8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherAppSwitchPreference");
            switchPreferenceCompat8 = null;
        }
        final int i9 = 5;
        switchPreferenceCompat8.f4081e = new InterfaceC0344p(this) { // from class: com.stepos.alphame.persona.information_used.ui.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalInfoAuthorizationFragment f11205b;

            {
                this.f11205b = this;
            }

            @Override // androidx.preference.InterfaceC0344p
            public final boolean b(Preference preference, Serializable serializable) {
                int i52 = i9;
                PersonalInfoAuthorizationFragment personalInfoAuthorizationFragment = this.f11205b;
                switch (i52) {
                    case 0:
                        return PersonalInfoAuthorizationFragment.initView$lambda$1(personalInfoAuthorizationFragment, preference, serializable);
                    case 1:
                        return PersonalInfoAuthorizationFragment.initView$lambda$2(personalInfoAuthorizationFragment, preference, serializable);
                    case 2:
                        return PersonalInfoAuthorizationFragment.initView$lambda$3(personalInfoAuthorizationFragment, preference, serializable);
                    case 3:
                        return PersonalInfoAuthorizationFragment.initView$lambda$4(personalInfoAuthorizationFragment, preference, serializable);
                    case 4:
                        return PersonalInfoAuthorizationFragment.initView$lambda$5(personalInfoAuthorizationFragment, preference, serializable);
                    default:
                        return PersonalInfoAuthorizationFragment.initView$lambda$6(personalInfoAuthorizationFragment, preference, serializable);
                }
            }
        };
        SwitchPreferenceCompat switchPreferenceCompat9 = this.weatherAppSwitchPreference;
        if (switchPreferenceCompat9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherAppSwitchPreference");
        } else {
            switchPreferenceCompat2 = switchPreferenceCompat9;
        }
        if (switchPreferenceCompat2.f4099w != zIsAppExist2) {
            switchPreferenceCompat2.f4099w = zIsAppExist2;
            InterfaceC0343o interfaceC0343o2 = switchPreferenceCompat2.f4070G;
            if (interfaceC0343o2 != null) {
                interfaceC0343o2.onPreferenceVisibilityChange(switchPreferenceCompat2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.voiceAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.VOICE_ASSISTANT_PACKAGE_NAME, bool.booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.noteAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noteAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.NOTE_PAPER_PACKAGE_NAME, bool.booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.settingAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.SETTING_PACKAGE_NAME, bool.booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.systemUiToolAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("systemUiToolAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.SYSTEM_UI_TOOL_PACKAGE_NAME, bool.booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$5(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.aicyButlerAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aicyButlerAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.AICY_Butler, bool.booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$6(PersonalInfoAuthorizationFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.weatherAppSwitchPreference;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherAppSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(EngineContract.WEATHER, bool.booleanValue());
        return true;
    }

    private final void observer() {
        LogKt.logD(TAG, "observer");
        PersonalPreferenceConfigs.INSTANCE.getKeyList().size();
        InformationUsedRequester informationUsedRequester = this.mRequester;
        InformationUsedRequester informationUsedRequester2 = null;
        if (informationUsedRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            informationUsedRequester = null;
        }
        informationUsedRequester.getDataList().d(this, new PersonalInfoAuthorizationFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends InformationUsedEntity>, Unit>() { // from class: com.stepos.alphame.persona.information_used.ui.PersonalInfoAuthorizationFragment.observer.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends InformationUsedEntity> list) {
                invoke2((List<InformationUsedEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<InformationUsedEntity> list) {
                LogKt.logD(PersonalInfoAuthorizationFragment.TAG, "data update, update UI, size " + list.size());
                if (list.size() == 10) {
                    SwitchPreferenceCompat switchPreferenceCompat = PersonalInfoAuthorizationFragment.this.voiceAppSwitchPreference;
                    SwitchPreferenceCompat switchPreferenceCompat2 = null;
                    if (switchPreferenceCompat == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("voiceAppSwitchPreference");
                        switchPreferenceCompat = null;
                    }
                    switchPreferenceCompat.z(list.get(0).getState());
                    SwitchPreferenceCompat switchPreferenceCompat3 = PersonalInfoAuthorizationFragment.this.noteAppSwitchPreference;
                    if (switchPreferenceCompat3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noteAppSwitchPreference");
                        switchPreferenceCompat3 = null;
                    }
                    switchPreferenceCompat3.z(list.get(1).getState());
                    SwitchPreferenceCompat switchPreferenceCompat4 = PersonalInfoAuthorizationFragment.this.settingAppSwitchPreference;
                    if (switchPreferenceCompat4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingAppSwitchPreference");
                        switchPreferenceCompat4 = null;
                    }
                    switchPreferenceCompat4.z(list.get(2).getState());
                    SwitchPreferenceCompat switchPreferenceCompat5 = PersonalInfoAuthorizationFragment.this.systemUiToolAppSwitchPreference;
                    if (switchPreferenceCompat5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("systemUiToolAppSwitchPreference");
                        switchPreferenceCompat5 = null;
                    }
                    switchPreferenceCompat5.z(list.get(3).getState());
                    SwitchPreferenceCompat switchPreferenceCompat6 = PersonalInfoAuthorizationFragment.this.aicyButlerAppSwitchPreference;
                    if (switchPreferenceCompat6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aicyButlerAppSwitchPreference");
                        switchPreferenceCompat6 = null;
                    }
                    switchPreferenceCompat6.z(list.get(4).getState());
                    SwitchPreferenceCompat switchPreferenceCompat7 = PersonalInfoAuthorizationFragment.this.weatherAppSwitchPreference;
                    if (switchPreferenceCompat7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("weatherAppSwitchPreference");
                    } else {
                        switchPreferenceCompat2 = switchPreferenceCompat7;
                    }
                    switchPreferenceCompat2.z(list.get(5).getState());
                }
            }
        }));
        InformationUsedRequester informationUsedRequester3 = this.mRequester;
        if (informationUsedRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            informationUsedRequester2 = informationUsedRequester3;
        }
        informationUsedRequester2.requestDataList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(PersonalInfoAuthorizationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getListView() == null) {
            return;
        }
        this$0.getListView().setPadding(this$0.getListView().getPaddingLeft(), this$0.getListView().getPaddingTop(), this$0.getListView().getPaddingRight(), (int) o.c(this$0.getListView().getContext(), 64.0f));
    }

    public <T extends n0> T getFragmentScopeViewModel(@NotNull Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        b bVar = this.mViewModelScope;
        if (bVar.f1536a == null) {
            bVar.f1536a = new c((u0) this);
        }
        return (T) bVar.f1536a.e(modelClass);
    }

    public final void initViewModel() {
        this.mRequester = (InformationUsedRequester) getFragmentScopeViewModel(InformationUsedRequester.class);
    }

    public final boolean isAppExist(@NotNull Context context, @Nullable String packageName) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        try {
            Intrinsics.checkNotNull(packageName);
            packageManager.getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // androidx.fragment.app.D
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mActivity = (AbstractActivityC0866k) context;
        LogKt.logD(TAG, "onAttach");
    }

    @Override // androidx.preference.y, androidx.fragment.app.D
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogKt.logD(TAG, "onCreate");
    }

    @Override // androidx.preference.y
    @NotNull
    public RecyclerView.Adapter<?> onCreateAdapter(@NotNull PreferenceScreen preferenceScreen) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        CustomAdapter customAdapter = new CustomAdapter(preferenceScreen);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean zIsAppExist = isAppExist(contextRequireContext, EngineContract.AICY_Butler);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        customAdapter.setFootCount(RangesKt.coerceAtLeast((((zIsAppExist ? 1 : 0) + 4) + (isAppExist(contextRequireContext2, EngineContract.WEATHER) ? 1 : 0)) - 1, 1));
        return customAdapter;
    }

    @Override // androidx.preference.y
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) throws PackageManager.NameNotFoundException {
        LogKt.logD(TAG, "onCreatePreferences");
        setPreferencesFromResource(R.xml.personal_info_authorization, rootKey);
        initViewModel();
        initView();
        observer();
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
        getListView().post(new d(18, this));
    }
}
