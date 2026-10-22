package com.stepos.alphame.persona.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.d;
import androidx.core.app.f;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.n0;
import androidx.lifecycle.u0;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.common.api.internal.p;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.persona.address.ui.e;
import com.stepos.alphame.persona.data.bean.CommutingMode;
import com.stepos.alphame.persona.domain.event.AddressMessages;
import com.stepos.alphame.persona.domain.event.ClearDataMessages;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.event.Messages;
import com.stepos.alphame.persona.domain.event.TimeMessages;
import com.stepos.alphame.persona.domain.event.WifiMessages;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.alphame.persona.domain.request.PersonalMainRequester;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LongKt;
import com.stepos.common.preference.SwitchPreferenceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m2.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.AbstractActivityC0866k;
import stepos.support.v7.app.C0861f;
import stepos.support.v7.app.C0864i;
import stepos.support.v7.widget.StepOSRecyclerView;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bT\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u00028\u0000\"\n\b\u0000\u0010\u0019*\u0004\u0018\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\u00028\u0000\"\n\b\u0000\u0010\u0019*\u0004\u0018\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0004¢\u0006\u0004\b\u001e\u0010\u001dJ!\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010&\u001a\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001a\u00020#H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0017J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0017J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020.H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u000b2\u0006\u00104\u001a\u00020.H\u0002¢\u0006\u0004\b7\u00106R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010CR\u0016\u0010G\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010H\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010CR\u0016\u0010I\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010CR\u0016\u0010J\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010CR\u0016\u0010K\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010CR\u0016\u0010L\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010CR\u0016\u0010M\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010CR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lcom/stepos/alphame/persona/ui/PersonalMainFragment;", "Landroidx/preference/y;", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "rootKey", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/recyclerview/widget/RecyclerView;", "initViewModel", "()V", "Landroidx/lifecycle/n0;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "getFragmentScopeViewModel", "(Ljava/lang/Class;)Landroidx/lifecycle/n0;", "getApplicationScopeViewModel", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/preference/PreferenceScreen;", "preferenceScreen", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onCreateAdapter", "(Landroidx/preference/PreferenceScreen;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "initView", "observer", "", "mode", "getCommutingModeText", "(J)Ljava/lang/String;", "Lcom/stepos/alphame/persona/domain/event/Messages;", "task", "Lcom/stepos/alphame/persona/ui/IDialogClickListener;", "listener", "showInfoUpdateDialog", "(Lcom/stepos/alphame/persona/domain/event/Messages;Lcom/stepos/alphame/persona/ui/IDialogClickListener;)V", "messages", "getMessageTitle", "(Lcom/stepos/alphame/persona/domain/event/Messages;)Ljava/lang/String;", "getMessageContent", "Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "mRequester", "Lcom/stepos/alphame/persona/domain/request/PersonalMainRequester;", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "Lcom/stepos/common/preference/SwitchPreferenceCompat;", "personalSwitchPreference", "Lcom/stepos/common/preference/SwitchPreferenceCompat;", "Landroidx/preference/Preference;", "homeAddressPreference", "Landroidx/preference/Preference;", "companyAddressPreference", "homeWifiPreference", "companyWifiPreference", "timeAwayFromHomePreference", "offDutyPreference", "commutingModePreference", "sleepTimePreference", "wakeUpTimePreference", "carBluetoothPreference", "aboutPreference", "LO1/b;", "mViewModelScope", "LO1/b;", "Lstepos/support/v7/app/k;", "mActivity", "Lstepos/support/v7/app/k;", "<init>", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalMainFragment extends y {

    @NotNull
    public static final String TAG = "PersonalMain";
    private Preference aboutPreference;
    private Preference carBluetoothPreference;
    private Preference commutingModePreference;
    private Preference companyAddressPreference;
    private Preference companyWifiPreference;
    private Preference homeAddressPreference;
    private Preference homeWifiPreference;
    private AbstractActivityC0866k mActivity;
    private PageMessenger mMessenger;
    private PersonalMainRequester mRequester;

    @NotNull
    private final O1.b mViewModelScope = new O1.b();
    private Preference offDutyPreference;
    private SwitchPreferenceCompat personalSwitchPreference;
    private Preference sleepTimePreference;
    private Preference timeAwayFromHomePreference;
    private Preference wakeUpTimePreference;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventId.values().length];
            try {
                iArr[EventId.HOME_ADDRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventId.COMPANY_ADDRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventId.HOME_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventId.COMPANY_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventId.TIME_AWAY_FROM_HOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventId.OFF_DUTY_TIME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventId.SLEEP_TIME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventId.WAKE_UP_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCommutingModeText(long mode) {
        if (mode == CommutingMode.BUS.getMode()) {
            String string = ApplicationImpl.getApplication().getString(R.string.commuting_mode_bus);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = ApplicationImpl.getApplication().getString(R.string.commuting_mode_drive);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final String getMessageContent(Messages messages) {
        switch (WhenMappings.$EnumSwitchMapping$0[messages.getId().ordinal()]) {
            case 1:
            case 2:
                Intrinsics.checkNotNull(messages, "null cannot be cast to non-null type com.stepos.alphame.persona.domain.event.AddressMessages");
                return ((AddressMessages) messages).getAddressInfo().getName();
            case 3:
            case 4:
                Intrinsics.checkNotNull(messages, "null cannot be cast to non-null type com.stepos.alphame.persona.domain.event.WifiMessages");
                return ((WifiMessages) messages).getWifiInfo().getSsid();
            case 5:
            case 6:
            case 7:
            case 8:
                Intrinsics.checkNotNull(messages, "null cannot be cast to non-null type com.stepos.alphame.persona.domain.event.TimeMessages");
                return LongKt.formatDateFull(((TimeMessages) messages).getTimeInfo().getTime(), "HH:mm");
            default:
                return "";
        }
    }

    private final String getMessageTitle(Messages messages) {
        int i4;
        switch (WhenMappings.$EnumSwitchMapping$0[messages.getId().ordinal()]) {
            case 1:
                i4 = R.string.get_new_home_address;
                break;
            case 2:
                i4 = R.string.get_new_company_address;
                break;
            case 3:
                i4 = R.string.get_new_home_wifi;
                break;
            case 4:
                i4 = R.string.get_new_company_wifi;
                break;
            case 5:
                i4 = R.string.get_new_time_away_from_home;
                break;
            case 6:
                i4 = R.string.get_new_off_duty_time;
                break;
            case 7:
                i4 = R.string.get_new_sleep_time;
                break;
            case 8:
                i4 = R.string.get_new_wake_up_time;
                break;
            default:
                i4 = R.string.get_new_home_address;
                break;
        }
        String string = getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void initView() {
        LogKt.logD("PersonalMain", "initView");
        Preference preferenceFindPreference = findPreference("personal_switch");
        Intrinsics.checkNotNull(preferenceFindPreference);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) preferenceFindPreference;
        this.personalSwitchPreference = switchPreferenceCompat;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personalSwitchPreference");
            switchPreferenceCompat = null;
        }
        switchPreferenceCompat.f4081e = new f(this);
        Preference preferenceFindPreference2 = findPreference("home_address");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        this.homeAddressPreference = preferenceFindPreference2;
        Preference preferenceFindPreference3 = findPreference("company_address");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        this.companyAddressPreference = preferenceFindPreference3;
        Preference preferenceFindPreference4 = findPreference("home_wifi");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        this.homeWifiPreference = preferenceFindPreference4;
        Preference preferenceFindPreference5 = findPreference("company_wifi");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        this.companyWifiPreference = preferenceFindPreference5;
        Preference preferenceFindPreference6 = findPreference("time_away_from_home");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        this.timeAwayFromHomePreference = preferenceFindPreference6;
        Preference preferenceFindPreference7 = findPreference("off_duty_time");
        Intrinsics.checkNotNull(preferenceFindPreference7);
        this.offDutyPreference = preferenceFindPreference7;
        Preference preferenceFindPreference8 = findPreference("commuting_mode");
        Intrinsics.checkNotNull(preferenceFindPreference8);
        this.commutingModePreference = preferenceFindPreference8;
        Preference preferenceFindPreference9 = findPreference(SleepModeData.SLEEP_TIME);
        Intrinsics.checkNotNull(preferenceFindPreference9);
        this.sleepTimePreference = preferenceFindPreference9;
        Preference preferenceFindPreference10 = findPreference("wake_up_time");
        Intrinsics.checkNotNull(preferenceFindPreference10);
        this.wakeUpTimePreference = preferenceFindPreference10;
        Preference preferenceFindPreference11 = findPreference("car_bluetooth");
        Intrinsics.checkNotNull(preferenceFindPreference11);
        this.carBluetoothPreference = preferenceFindPreference11;
        Preference preferenceFindPreference12 = findPreference("about");
        Intrinsics.checkNotNull(preferenceFindPreference12);
        this.aboutPreference = preferenceFindPreference12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(PersonalMainFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preference, "<anonymous parameter 0>");
        SwitchPreferenceCompat switchPreferenceCompat = this$0.personalSwitchPreference;
        PersonalMainRequester personalMainRequester = null;
        if (switchPreferenceCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personalSwitchPreference");
            switchPreferenceCompat = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj;
        switchPreferenceCompat.z(bool.booleanValue());
        AlphaMeLogger.debugLog("Personal", "isChecked " + obj);
        PersonalMainRequester personalMainRequester2 = this$0.mRequester;
        if (personalMainRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester2 = null;
        }
        personalMainRequester2.postAutoLearningState(bool.booleanValue());
        PersonalMainRequester personalMainRequester3 = this$0.mRequester;
        if (personalMainRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            personalMainRequester = personalMainRequester3;
        }
        personalMainRequester.requestData();
        return true;
    }

    private final void observer() {
        LogKt.logD("PersonalMain", "observer");
        PersonalMainRequester personalMainRequester = this.mRequester;
        AbstractActivityC0866k abstractActivityC0866k = null;
        if (personalMainRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester = null;
        }
        personalMainRequester.requestAutoLearningState().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AlphaMeLogger.debugLog("Personal", "observe changed isChecked " + bool);
                SwitchPreferenceCompat switchPreferenceCompat = PersonalMainFragment.this.personalSwitchPreference;
                if (switchPreferenceCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personalSwitchPreference");
                    switchPreferenceCompat = null;
                }
                Intrinsics.checkNotNull(bool);
                switchPreferenceCompat.z(bool.booleanValue());
            }
        }));
        PersonalMainRequester personalMainRequester2 = this.mRequester;
        if (personalMainRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester2 = null;
        }
        personalMainRequester2.getHomeAddress().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.homeAddressPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("homeAddressPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester3 = this.mRequester;
        if (personalMainRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester3 = null;
        }
        personalMainRequester3.getCompanyAddress().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.companyAddressPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("companyAddressPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester4 = this.mRequester;
        if (personalMainRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester4 = null;
        }
        personalMainRequester4.getHomeWifi().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.homeWifiPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("homeWifiPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester5 = this.mRequester;
        if (personalMainRequester5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester5 = null;
        }
        personalMainRequester5.getCompanyWifi().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.companyWifiPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("companyWifiPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester6 = this.mRequester;
        if (personalMainRequester6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester6 = null;
        }
        personalMainRequester6.getTimeAwayFromHome().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.timeAwayFromHomePreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeAwayFromHomePreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester7 = this.mRequester;
        if (personalMainRequester7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester7 = null;
        }
        personalMainRequester7.getOffDutyTime().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.offDutyPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offDutyPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester8 = this.mRequester;
        if (personalMainRequester8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester8 = null;
        }
        personalMainRequester8.getCommutingMode().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.8
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
                Preference preference = PersonalMainFragment.this.commutingModePreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commutingModePreference");
                    preference = null;
                }
                PersonalMainFragment personalMainFragment = PersonalMainFragment.this;
                Intrinsics.checkNotNull(l4);
                preference.v(personalMainFragment.getCommutingModeText(l4.longValue()));
            }
        }));
        PersonalMainRequester personalMainRequester9 = this.mRequester;
        if (personalMainRequester9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester9 = null;
        }
        personalMainRequester9.getSleepTime().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.sleepTimePreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sleepTimePreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester10 = this.mRequester;
        if (personalMainRequester10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester10 = null;
        }
        personalMainRequester10.getWakeupTime().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Preference preference = PersonalMainFragment.this.wakeUpTimePreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wakeUpTimePreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester11 = this.mRequester;
        if (personalMainRequester11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester11 = null;
        }
        personalMainRequester11.getCarBluetoothName().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                AlphaMeLogger.debugLog("Personal", "observer ,new bluetooth name " + str);
                Preference preference = PersonalMainFragment.this.carBluetoothPreference;
                if (preference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("carBluetoothPreference");
                    preference = null;
                }
                preference.v(str);
            }
        }));
        PersonalMainRequester personalMainRequester12 = this.mRequester;
        if (personalMainRequester12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester12 = null;
        }
        personalMainRequester12.getAutoInfoUpdate().d(this, new PersonalMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment.observer.12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AlphaMeLogger.debugLog("Personal", "autoInfo update");
                PersonalMainRequester personalMainRequester13 = PersonalMainFragment.this.mRequester;
                if (personalMainRequester13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                    personalMainRequester13 = null;
                }
                final Messages task = personalMainRequester13.getTask();
                if (task != null) {
                    final PersonalMainFragment personalMainFragment = PersonalMainFragment.this;
                    AlphaMeLogger.debugLog("Personal", "update task " + task);
                    personalMainFragment.showInfoUpdateDialog(task, new IDialogClickListener() { // from class: com.stepos.alphame.persona.ui.PersonalMainFragment$observer$12$1$1
                        @Override // com.stepos.alphame.persona.ui.IDialogClickListener
                        public void accept() {
                            PersonalMainRequester personalMainRequester14 = personalMainFragment.mRequester;
                            PersonalMainRequester personalMainRequester15 = null;
                            if (personalMainRequester14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                                personalMainRequester14 = null;
                            }
                            personalMainRequester14.updateAutoInfo(task);
                            PersonalMainRequester personalMainRequester16 = personalMainFragment.mRequester;
                            if (personalMainRequester16 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                            } else {
                                personalMainRequester15 = personalMainRequester16;
                            }
                            personalMainRequester15.checkUpdateFinish();
                        }

                        @Override // com.stepos.alphame.persona.ui.IDialogClickListener
                        public void cancel() {
                            PersonalMainRequester personalMainRequester14 = personalMainFragment.mRequester;
                            if (personalMainRequester14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                                personalMainRequester14 = null;
                            }
                            personalMainRequester14.checkUpdateFinish();
                        }

                        @Override // com.stepos.alphame.persona.ui.IDialogClickListener
                        public void reject() {
                            PersonalMainRequester personalMainRequester14 = personalMainFragment.mRequester;
                            if (personalMainRequester14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRequester");
                                personalMainRequester14 = null;
                            }
                            personalMainRequester14.checkUpdateFinish();
                        }
                    });
                }
            }
        }));
        PersonalMainRequester personalMainRequester13 = this.mRequester;
        if (personalMainRequester13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester13 = null;
        }
        personalMainRequester13.requestData();
        PersonalMainRequester personalMainRequester14 = this.mRequester;
        if (personalMainRequester14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester14 = null;
        }
        personalMainRequester14.checkAutoInfoUpdate();
        PageMessenger pageMessenger = this.mMessenger;
        if (pageMessenger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
            pageMessenger = null;
        }
        AbstractActivityC0866k abstractActivityC0866k2 = this.mActivity;
        if (abstractActivityC0866k2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            abstractActivityC0866k = abstractActivityC0866k2;
        }
        pageMessenger.output(abstractActivityC0866k, new e(2, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$2(PersonalMainFragment this$0, Messages messages) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlphaMeLogger.debugLog("Personal", "receive messages " + messages);
        PersonalMainRequester personalMainRequester = null;
        AbstractActivityC0866k abstractActivityC0866k = null;
        if (messages instanceof ClearDataMessages) {
            AbstractActivityC0866k abstractActivityC0866k2 = this$0.mActivity;
            if (abstractActivityC0866k2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                abstractActivityC0866k = abstractActivityC0866k2;
            }
            abstractActivityC0866k.finish();
            return;
        }
        PersonalMainRequester personalMainRequester2 = this$0.mRequester;
        if (personalMainRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            personalMainRequester = personalMainRequester2;
        }
        Intrinsics.checkNotNull(messages);
        personalMainRequester.setCustomPreference(messages, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(PersonalMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getListView() == null) {
            return;
        }
        this$0.getListView().setPadding(this$0.getListView().getPaddingLeft(), this$0.getListView().getPaddingTop(), this$0.getListView().getPaddingRight(), (int) o.c(this$0.getListView().getContext(), 64.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInfoUpdateDialog(Messages task, final IDialogClickListener listener) {
        AbstractActivityC0866k abstractActivityC0866k = this.mActivity;
        if (abstractActivityC0866k == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            abstractActivityC0866k = null;
        }
        C0864i c0864i = new C0864i(abstractActivityC0866k);
        String messageTitle = getMessageTitle(task);
        C0861f c0861f = c0864i.f14506a;
        c0861f.f14452d = messageTitle;
        c0861f.f14454f = getMessageContent(task);
        int i4 = R.string.use;
        b bVar = new b(0, listener);
        Context context = c0861f.f14449a;
        c0861f.f14455g = context.getText(i4);
        c0861f.f14456h = bVar;
        int i5 = R.string.cancel;
        b bVar2 = new b(1, listener);
        c0861f.f14457i = context.getText(i5);
        c0861f.f14458j = bVar2;
        c0861f.f14461m = new DialogInterface.OnDismissListener() { // from class: com.stepos.alphame.persona.ui.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PersonalMainFragment.showInfoUpdateDialog$lambda$5(listener, dialogInterface);
            }
        };
        c0864i.a(new p(28, c0864i)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInfoUpdateDialog$lambda$3(IDialogClickListener listener, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.accept();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInfoUpdateDialog$lambda$4(IDialogClickListener listener, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.reject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInfoUpdateDialog$lambda$5(IDialogClickListener listener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.cancel();
    }

    public final <T extends n0> T getApplicationScopeViewModel(@NotNull Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        O1.b bVar = this.mViewModelScope;
        if (bVar.f1537b == null) {
            bVar.f1537b = new android.support.v4.media.session.c(O1.a.f1534b);
        }
        return (T) bVar.f1537b.e(modelClass);
    }

    public <T extends n0> T getFragmentScopeViewModel(@NotNull Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        O1.b bVar = this.mViewModelScope;
        if (bVar.f1536a == null) {
            bVar.f1536a = new android.support.v4.media.session.c((u0) this);
        }
        return (T) bVar.f1536a.e(modelClass);
    }

    public final void initViewModel() {
        this.mRequester = (PersonalMainRequester) getFragmentScopeViewModel(PersonalMainRequester.class);
        this.mMessenger = (PageMessenger) getApplicationScopeViewModel(PageMessenger.class);
    }

    @Override // androidx.fragment.app.D
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mActivity = (AbstractActivityC0866k) context;
        LogKt.logD("PersonalMain", "onAttach");
    }

    @Override // androidx.preference.y, androidx.fragment.app.D
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogKt.logD("PersonalMain", "onCreate");
    }

    @Override // androidx.preference.y
    @NotNull
    public RecyclerView.Adapter<?> onCreateAdapter(@NotNull PreferenceScreen preferenceScreen) {
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        LogKt.logD("PersonalMain", "onCreateAdapter");
        PersonalMainRequester personalMainRequester = this.mRequester;
        if (personalMainRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            personalMainRequester = null;
        }
        return new PersonalMainAdapter(preferenceScreen, personalMainRequester);
    }

    @Override // androidx.preference.y
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        LogKt.logD("PersonalMain", "onCreatePreferences");
        setPreferencesFromResource(R.xml.personal_main, rootKey);
        initViewModel();
        initView();
        observer();
    }

    @Override // androidx.preference.y
    @NotNull
    public RecyclerView onCreateRecyclerView(@NotNull LayoutInflater inflater, @NotNull ViewGroup parent, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        inflater.inflate(R.layout.personal_main_fragment, parent, true);
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
        getListView().post(new d(20, this));
    }
}
