package com.stepos.alphame.persona.common.list;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.n0;
import com.stepos.alphame.R;
import com.stepos.alphame.databinding.ActivityPersonalCommonSelectedBinding;
import com.stepos.alphame.persona.common.list.PersonalCommonListActivity;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.architecture.ui.stepos.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.G;
import stepos.support.v7.widget.StepOSRecyclerView;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/stepos/alphame/persona/common/list/PersonalCommonListActivity;", "Lcom/stepos/architecture/ui/stepos/d;", "", "initViewModel", "()V", "observe", "setupViews", "", "resId", "setToolbar", "(I)V", "selectedIndex", "save", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "Lcom/stepos/alphame/databinding/ActivityPersonalCommonSelectedBinding;", "_binding", "Lcom/stepos/alphame/databinding/ActivityPersonalCommonSelectedBinding;", "Lcom/stepos/alphame/persona/common/list/PersonalCommonListAdapter;", "mAdapter", "Lcom/stepos/alphame/persona/common/list/PersonalCommonListAdapter;", "getMAdapter", "()Lcom/stepos/alphame/persona/common/list/PersonalCommonListAdapter;", "setMAdapter", "(Lcom/stepos/alphame/persona/common/list/PersonalCommonListAdapter;)V", "getBinding", "()Lcom/stepos/alphame/databinding/ActivityPersonalCommonSelectedBinding;", "binding", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class PersonalCommonListActivity extends d {

    @Nullable
    private ActivityPersonalCommonSelectedBinding _binding;
    public PersonalCommonListAdapter mAdapter;
    private PageMessenger mMessenger;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$4$lambda$2(PersonalCommonListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$4$lambda$3(PersonalCommonListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.save(this$0.getMAdapter().get_selectedIndex());
        this$0.finish();
    }

    @NotNull
    public ActivityPersonalCommonSelectedBinding getBinding() {
        ActivityPersonalCommonSelectedBinding activityPersonalCommonSelectedBinding = this._binding;
        Intrinsics.checkNotNull(activityPersonalCommonSelectedBinding);
        return activityPersonalCommonSelectedBinding;
    }

    @NotNull
    public final PersonalCommonListAdapter getMAdapter() {
        PersonalCommonListAdapter personalCommonListAdapter = this.mAdapter;
        if (personalCommonListAdapter != null) {
            return personalCommonListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    @Override // com.stepos.architecture.ui.stepos.d
    public void initViewModel() {
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        this.mMessenger = (PageMessenger) applicationScopeViewModel;
    }

    public abstract void observe();

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._binding = ActivityPersonalCommonSelectedBinding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        ((G) getLitePopup()).b();
        setupViews();
        observe();
    }

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    public abstract void save(int selectedIndex);

    public final void setMAdapter(@NotNull PersonalCommonListAdapter personalCommonListAdapter) {
        Intrinsics.checkNotNullParameter(personalCommonListAdapter, "<set-?>");
        this.mAdapter = personalCommonListAdapter;
    }

    public final void setToolbar(int resId) {
        ActivityPersonalCommonSelectedBinding binding = getBinding();
        binding.toolbarTitle.setText(resId);
        final int i4 = 0;
        binding.cancel.setOnClickListener(new View.OnClickListener(this) { // from class: Q1.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalCommonListActivity f1641b;

            {
                this.f1641b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i5 = i4;
                PersonalCommonListActivity personalCommonListActivity = this.f1641b;
                switch (i5) {
                    case 0:
                        PersonalCommonListActivity.setToolbar$lambda$4$lambda$2(personalCommonListActivity, view);
                        break;
                    default:
                        PersonalCommonListActivity.setToolbar$lambda$4$lambda$3(personalCommonListActivity, view);
                        break;
                }
            }
        });
        final int i5 = 1;
        binding.save.setOnClickListener(new View.OnClickListener(this) { // from class: Q1.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalCommonListActivity f1641b;

            {
                this.f1641b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i52 = i5;
                PersonalCommonListActivity personalCommonListActivity = this.f1641b;
                switch (i52) {
                    case 0:
                        PersonalCommonListActivity.setToolbar$lambda$4$lambda$2(personalCommonListActivity, view);
                        break;
                    default:
                        PersonalCommonListActivity.setToolbar$lambda$4$lambda$3(personalCommonListActivity, view);
                        break;
                }
            }
        });
    }

    public void setupViews() {
        StepOSRecyclerView addressListview = getBinding().addressListview;
        Intrinsics.checkNotNullExpressionValue(addressListview, "addressListview");
        setMAdapter(new PersonalCommonListAdapter(addressListview));
        StepOSRecyclerView stepOSRecyclerView = getBinding().addressListview;
        stepOSRecyclerView.setAdapter(getMAdapter());
        stepOSRecyclerView.f14915B0 = true;
        stepOSRecyclerView.setSelector(R.drawable.selector_transient);
        setViewPadding(stepOSRecyclerView);
    }
}
