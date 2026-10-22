package com.stepos.alphame.persona.carbluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.n0;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.persona.address.ui.e;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import com.stepos.alphame.persona.common.list.PersonalCommonListActivity;
import com.stepos.alphame.persona.common.list.PersonalCommonListAdapter;
import com.stepos.alphame.persona.domain.event.BluetoothMessages;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/carbluetooth/CarBluetoothListActivity;", "Lcom/stepos/alphame/persona/common/list/PersonalCommonListActivity;", "()V", "mDataStore", "Lcom/stepos/alphame/common/data/DataStorePreferences;", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mRequester", "Lcom/stepos/alphame/persona/carbluetooth/CarBluetoothRequester;", "initViewModel", "", "observe", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "save", "selectedIndex", "", "sendResultForRequester", "bluetoothInfo", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarBluetoothListActivity extends PersonalCommonListActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_BLUETOOTH_MAC_ADDRESS = "BLUETOOTH_MAC_ADDRESS";

    @NotNull
    public static final String KEY_BLUETOOTH_NAME = "BLUETOOTH_NAME";

    @NotNull
    private final DataStorePreferences mDataStore = DataStoreManager.INSTANCE.getDataStore("personalPreference");
    private PageMessenger mMessenger;
    private CarBluetoothRequester mRequester;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/persona/carbluetooth/CarBluetoothListActivity$Companion;", "", "()V", "KEY_BLUETOOTH_MAC_ADDRESS", "", "KEY_BLUETOOTH_NAME", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) CarBluetoothListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$0(CarBluetoothListActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlphaMeLogger.debugLog("Personal", "common data update, update ui, size " + list.size());
        PersonalCommonListAdapter mAdapter = this$0.getMAdapter();
        Intrinsics.checkNotNull(list);
        mAdapter.setData(list);
    }

    private final void sendResultForRequester(BluetoothInfo bluetoothInfo) {
        Intent intent = new Intent();
        intent.putExtra(KEY_BLUETOOTH_NAME, bluetoothInfo.getBluetoothName());
        intent.putExtra(KEY_BLUETOOTH_MAC_ADDRESS, bluetoothInfo.getBluetoothAddress());
        setResult(-1, intent);
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity, com.stepos.architecture.ui.stepos.d
    public void initViewModel() {
        super.initViewModel();
        n0 activityScopeViewModel = getActivityScopeViewModel(CarBluetoothRequester.class);
        Intrinsics.checkNotNullExpressionValue(activityScopeViewModel, "getActivityScopeViewModel(...)");
        this.mRequester = (CarBluetoothRequester) activityScopeViewModel;
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        this.mMessenger = (PageMessenger) applicationScopeViewModel;
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity
    public void observe() {
        CarBluetoothRequester carBluetoothRequester = this.mRequester;
        CarBluetoothRequester carBluetoothRequester2 = null;
        if (carBluetoothRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            carBluetoothRequester = null;
        }
        carBluetoothRequester.get_dataList().d(this, new e(1, this));
        CarBluetoothRequester carBluetoothRequester3 = this.mRequester;
        if (carBluetoothRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            carBluetoothRequester2 = carBluetoothRequester3;
        }
        carBluetoothRequester2.requestDataList();
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity, com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(R.string.car_bluetooth);
        getBinding().tvTip.setText(getString(R.string.show_connected_bluetooth));
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity
    public void save(int selectedIndex) {
        CarBluetoothRequester carBluetoothRequester = this.mRequester;
        PageMessenger pageMessenger = null;
        if (carBluetoothRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            carBluetoothRequester = null;
        }
        BluetoothInfo bluetoothResult = carBluetoothRequester.getBluetoothResult(selectedIndex);
        AlphaMeLogger.debugLog("Personal", "save " + bluetoothResult);
        sendResultForRequester(bluetoothResult);
        CarBluetoothRequester carBluetoothRequester2 = this.mRequester;
        if (carBluetoothRequester2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            carBluetoothRequester2 = null;
        }
        carBluetoothRequester2.saveData(bluetoothResult);
        PageMessenger pageMessenger2 = this.mMessenger;
        if (pageMessenger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
        } else {
            pageMessenger = pageMessenger2;
        }
        pageMessenger.input(new BluetoothMessages(EventId.CAR_BLUETOOTH, bluetoothResult));
        if (getMAdapter().get_selectedIndex() == 0) {
            this.mDataStore.putData(KEY_BLUETOOTH_NAME, Boolean.TRUE);
        }
    }
}
