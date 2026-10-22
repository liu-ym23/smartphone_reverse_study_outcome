package com.stepos.alphame.persona.common.time;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.n0;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.databinding.ActivityPersonalCommonTimePickerBinding;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LongKt;
import com.stepos.alphame.utils.ViewKt;
import com.stepos.architecture.ui.stepos.d;
import com.stepos.common.picker.TimePicker2;
import com.stepos.common.picker.m;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.G;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b2\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0014¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0004H\u0014¢\u0006\u0004\b%\u0010\bR\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/stepos/alphame/persona/common/time/PersonalCommonTimePickerActivity;", "Lcom/stepos/architecture/ui/stepos/d;", "Landroid/content/Intent;", "intent", "", "setupView", "(Landroid/content/Intent;)V", "observe", "()V", "", "type", "setToolbar", "(I)V", "sendResultForRequester", "", AppSuggestStorable.COLUMN_TIME, "updateTimePicker", "(J)V", "Landroid/view/View;", "view", "setMiddlePadding", "(Landroid/view/View;)V", "", "autoStatus", "initAutoLearningView", "(Z)V", "initCustomView", "getMarginTopValue", "()I", "id", "getTimeTitle", "(I)I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "initViewModel", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "Lcom/stepos/alphame/persona/common/time/PersonalCommonTimePickerRequester;", "mRequester", "Lcom/stepos/alphame/persona/common/time/PersonalCommonTimePickerRequester;", "Lcom/stepos/alphame/databinding/ActivityPersonalCommonTimePickerBinding;", "_binding", "Lcom/stepos/alphame/databinding/ActivityPersonalCommonTimePickerBinding;", "getBinding", "()Lcom/stepos/alphame/databinding/ActivityPersonalCommonTimePickerBinding;", "binding", "<init>", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalCommonTimePickerActivity extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_TIME_RESULT = "TIME_RESULT";

    @Nullable
    private ActivityPersonalCommonTimePickerBinding _binding;
    private PageMessenger mMessenger;
    private PersonalCommonTimePickerRequester mRequester;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/common/time/PersonalCommonTimePickerActivity$Companion;", "", "()V", "KEY_TIME_RESULT", "", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "type", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) PersonalCommonTimePickerActivity.class);
            intent.putExtra(PersonalContract.KEY_PAGE, type);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityPersonalCommonTimePickerBinding getBinding() {
        ActivityPersonalCommonTimePickerBinding activityPersonalCommonTimePickerBinding = this._binding;
        Intrinsics.checkNotNull(activityPersonalCommonTimePickerBinding);
        return activityPersonalCommonTimePickerBinding;
    }

    private final int getMarginTopValue() {
        return (int) ((16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int getTimeTitle(int id) {
        return id == EventId.TIME_AWAY_FROM_HOME.getId() ? R.string.time_away_from_home : id == EventId.OFF_DUTY_TIME.getId() ? R.string.off_duty_time : id == EventId.SLEEP_TIME.getId() ? R.string.sleep_time : id == EventId.WAKE_UP_TIME.getId() ? R.string.wake_up_time : R.string.no_information;
    }

    private final void initAutoLearningView(boolean autoStatus) {
        if (!autoStatus) {
            ViewKt.gone((ViewGroup) getBinding().autoLearningTimeTitleLayout);
            return;
        }
        ActivityPersonalCommonTimePickerBinding binding = getBinding();
        ViewKt.visible((ViewGroup) binding.autoLearningTimeTitleLayout);
        ViewKt.setHeadPadding(binding.autoLearningTimeTitleLayout);
        ViewKt.setMarginTop(binding.autoLearningTimeTitleLayout, getMarginTopValue());
        binding.autoLearningTimeTitle.setText(getString(R.string.automatic_learning_time));
        binding.autoTimeContent.setText(getString(R.string.learning));
        binding.autoLearningTimeTitleLayout.setOnClickListener(new a(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAutoLearningView$lambda$7$lambda$6(PersonalCommonTimePickerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this$0.mRequester;
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = null;
        if (personalCommonTimePickerRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester = null;
        }
        long type = personalCommonTimePickerRequester.get_mCustomTimeInfo().getType();
        PersonalDataType personalDataType = PersonalDataType.AUTO;
        if (type != personalDataType.getType()) {
            ActivityPersonalCommonTimePickerBinding binding = this$0.getBinding();
            binding.autoTimeBtSelect.setChecked(true);
            binding.customTimeBtSelect.setChecked(false);
            ViewKt.setFootPadding(binding.customTimeTitleLayout);
            ViewKt.gone((ViewGroup) binding.timePicker);
            PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = this$0.mRequester;
            if (personalCommonTimePickerRequester3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            } else {
                personalCommonTimePickerRequester2 = personalCommonTimePickerRequester3;
            }
            personalCommonTimePickerRequester2.setTimeOption(personalDataType.getType());
        }
    }

    private final void initCustomView(boolean autoStatus) {
        if (autoStatus) {
            ActivityPersonalCommonTimePickerBinding binding = getBinding();
            ViewKt.visible((ViewGroup) binding.customTimeTitleLayout);
            ViewKt.setFootPadding(binding.customTimeTitleLayout);
            ViewKt.gone((ViewGroup) binding.timePicker);
        } else {
            ActivityPersonalCommonTimePickerBinding binding2 = getBinding();
            ViewKt.visible((ViewGroup) binding2.customTimeTitleLayout);
            ViewKt.setHeadPadding(binding2.customTimeTitleLayout);
            ViewKt.setMarginTop(binding2.customTimeTitleLayout, getMarginTopValue());
        }
        ActivityPersonalCommonTimePickerBinding binding3 = getBinding();
        binding3.customTimeTitleLayout.setOnClickListener(new a(this, 0));
        TimePicker2 timePicker2 = binding3.timePicker;
        m mVar = new m() { // from class: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerActivity$initCustomView$3$2
            @Override // com.stepos.common.picker.m
            public void onTimeChanged(@Nullable TimePicker2 picker, boolean isAm, int hour, int minute) {
                long customTimeMill = TimeUtils.INSTANCE.getCustomTimeMill(isAm ? hour : hour + 12, minute);
                PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this.this$0.mRequester;
                if (personalCommonTimePickerRequester == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    personalCommonTimePickerRequester = null;
                }
                personalCommonTimePickerRequester.setCustomResult(customTimeMill);
                AlphaMeLogger.debugLog("Personal", "addOnTimeChangedListener hour " + hour + " min " + minute);
            }
        };
        if (timePicker2.f11339m == null) {
            timePicker2.f11339m = new ArrayList();
        }
        timePicker2.f11339m.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCustomView$lambda$12$lambda$11(PersonalCommonTimePickerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this$0.mRequester;
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = null;
        if (personalCommonTimePickerRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester = null;
        }
        long type = personalCommonTimePickerRequester.get_mCustomTimeInfo().getType();
        PersonalDataType personalDataType = PersonalDataType.CUSTOM;
        if (type != personalDataType.getType()) {
            ActivityPersonalCommonTimePickerBinding binding = this$0.getBinding();
            binding.autoTimeBtSelect.setChecked(false);
            binding.customTimeBtSelect.setChecked(true);
            Intrinsics.checkNotNull(view);
            this$0.setMiddlePadding(view);
            PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = this$0.mRequester;
            if (personalCommonTimePickerRequester3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                personalCommonTimePickerRequester3 = null;
            }
            this$0.updateTimePicker(personalCommonTimePickerRequester3.getCustomTime());
            PersonalCommonTimePickerRequester personalCommonTimePickerRequester4 = this$0.mRequester;
            if (personalCommonTimePickerRequester4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            } else {
                personalCommonTimePickerRequester2 = personalCommonTimePickerRequester4;
            }
            personalCommonTimePickerRequester2.setTimeOption(personalDataType.getType());
        }
    }

    private final void observe() {
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this.mRequester;
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = null;
        if (personalCommonTimePickerRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester = null;
        }
        personalCommonTimePickerRequester.getOption().d(this, new PersonalCommonTimePickerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerActivity.observe.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l4) {
                invoke2(l4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l4) {
                long type = PersonalDataType.CUSTOM.getType();
                if (l4 == null || l4.longValue() != type) {
                    ActivityPersonalCommonTimePickerBinding binding = PersonalCommonTimePickerActivity.this.getBinding();
                    binding.autoTimeBtSelect.setChecked(true);
                    binding.customTimeBtSelect.setChecked(false);
                    return;
                }
                ActivityPersonalCommonTimePickerBinding binding2 = PersonalCommonTimePickerActivity.this.getBinding();
                PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = PersonalCommonTimePickerActivity.this.mRequester;
                if (personalCommonTimePickerRequester3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    personalCommonTimePickerRequester3 = null;
                }
                if (personalCommonTimePickerRequester3.getAutoLearningState()) {
                    binding2.autoTimeBtSelect.setChecked(false);
                }
                binding2.customTimeBtSelect.setChecked(true);
            }
        }));
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = this.mRequester;
        if (personalCommonTimePickerRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester3 = null;
        }
        personalCommonTimePickerRequester3.getAutoTime().d(this, new PersonalCommonTimePickerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerActivity.observe.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l4) {
                invoke2(l4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l4) {
                ActivityPersonalCommonTimePickerBinding binding = PersonalCommonTimePickerActivity.this.getBinding();
                PersonalCommonTimePickerActivity personalCommonTimePickerActivity = PersonalCommonTimePickerActivity.this;
                if (l4 != null && l4.longValue() == 0) {
                    binding.autoTimeContent.setText(personalCommonTimePickerActivity.getString(R.string.learning));
                    return;
                }
                TextView textView = binding.autoTimeContent;
                Intrinsics.checkNotNull(l4);
                textView.setText(LongKt.formatDateHourAndMin(l4.longValue()));
            }
        }));
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester4 = this.mRequester;
        if (personalCommonTimePickerRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester4 = null;
        }
        personalCommonTimePickerRequester4.m15getCustomTime().d(this, new PersonalCommonTimePickerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.stepos.alphame.persona.common.time.PersonalCommonTimePickerActivity.observe.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l4) {
                invoke2(l4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l4) {
                PersonalCommonTimePickerActivity personalCommonTimePickerActivity = PersonalCommonTimePickerActivity.this;
                Intrinsics.checkNotNull(l4);
                personalCommonTimePickerActivity.updateTimePicker(l4.longValue());
            }
        }));
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester5 = this.mRequester;
        if (personalCommonTimePickerRequester5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            personalCommonTimePickerRequester2 = personalCommonTimePickerRequester5;
        }
        personalCommonTimePickerRequester2.requestData();
    }

    private final void sendResultForRequester() {
        Intent intent = new Intent();
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this.mRequester;
        if (personalCommonTimePickerRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester = null;
        }
        intent.putExtra(KEY_TIME_RESULT, personalCommonTimePickerRequester.getTimeResult());
        setResult(-1, intent);
    }

    private final void setMiddlePadding(View view) {
        ViewKt.setMiddlePadding(view);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
    }

    private final void setToolbar(int type) {
        AlphaMeLogger.debugLog(PersonalContract.TIME_TAG, "type " + type);
        ActivityPersonalCommonTimePickerBinding binding = getBinding();
        binding.toolbarTitle.setText(getTimeTitle(type));
        binding.cancel.setOnClickListener(new a(this, 1));
        binding.save.setOnClickListener(new a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$2$lambda$0(PersonalCommonTimePickerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbar$lambda$2$lambda$1(PersonalCommonTimePickerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = this$0.mRequester;
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = null;
        if (personalCommonTimePickerRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester = null;
        }
        Messages finalResult = personalCommonTimePickerRequester.getFinalResult();
        LogKt.logD(PersonalContract.TIME_TAG, "final message " + finalResult);
        PageMessenger pageMessenger = this$0.mMessenger;
        if (pageMessenger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
            pageMessenger = null;
        }
        pageMessenger.input(finalResult);
        this$0.sendResultForRequester();
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = this$0.mRequester;
        if (personalCommonTimePickerRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            personalCommonTimePickerRequester2 = personalCommonTimePickerRequester3;
        }
        personalCommonTimePickerRequester2.saveData();
        this$0.finish();
    }

    private final void setupView(Intent intent) {
        int intExtra = intent.getIntExtra(PersonalContract.KEY_PAGE, -1);
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester = null;
        if (intExtra != -1) {
            setToolbar(intExtra);
            PersonalCommonTimePickerRequester personalCommonTimePickerRequester2 = this.mRequester;
            if (personalCommonTimePickerRequester2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                personalCommonTimePickerRequester2 = null;
            }
            personalCommonTimePickerRequester2.setEventId(intExtra);
        }
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester3 = this.mRequester;
        if (personalCommonTimePickerRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalCommonTimePickerRequester3 = null;
        }
        initAutoLearningView(personalCommonTimePickerRequester3.getAutoLearningState());
        PersonalCommonTimePickerRequester personalCommonTimePickerRequester4 = this.mRequester;
        if (personalCommonTimePickerRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            personalCommonTimePickerRequester = personalCommonTimePickerRequester4;
        }
        initCustomView(personalCommonTimePickerRequester.getAutoLearningState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimePicker(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        TimePicker2 timePicker2 = getBinding().timePicker;
        ViewKt.visible((ViewGroup) timePicker2);
        timePicker2.b(calendar.get(11), calendar.get(12), DateFormat.is24HourFormat(this));
    }

    @Override // com.stepos.architecture.ui.stepos.d
    public void initViewModel() {
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        this.mMessenger = (PageMessenger) applicationScopeViewModel;
        n0 activityScopeViewModel = getActivityScopeViewModel(PersonalCommonTimePickerRequester.class);
        Intrinsics.checkNotNullExpressionValue(activityScopeViewModel, "getActivityScopeViewModel(...)");
        this.mRequester = (PersonalCommonTimePickerRequester) activityScopeViewModel;
    }

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._binding = ActivityPersonalCommonTimePickerBinding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        ((G) getLitePopup()).b();
        initViewModel();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        setupView(intent);
        observe();
    }

    @Override // com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}
