package com.stepos.alphame.persona.wifi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.n0;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.ui.e;
import com.stepos.alphame.persona.common.list.PersonalCommonListActivity;
import com.stepos.alphame.persona.common.list.PersonalCommonListAdapter;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.domain.event.WifiMessages;
import com.stepos.alphame.persona.domain.message.PageMessenger;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/wifi/WifiListActivity;", "Lcom/stepos/alphame/persona/common/list/PersonalCommonListActivity;", "()V", "mMessenger", "Lcom/stepos/alphame/persona/domain/message/PageMessenger;", "mRequester", "Lcom/stepos/alphame/persona/wifi/WifiRequester;", "getTitleResId", "", "eventId", "initViewModel", "", "observe", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "save", "selectedIndex", "sendResultForRequester", "wifiInfo", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WifiListActivity extends PersonalCommonListActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_WIFI_MAC_ADDRESS = "WIFI_MAC_ADDRESS";

    @NotNull
    public static final String KEY_WIFI_NAME = "WIFI_NAME";
    private PageMessenger mMessenger;
    private WifiRequester mRequester;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/persona/wifi/WifiListActivity$Companion;", "", "()V", "KEY_WIFI_MAC_ADDRESS", "", "KEY_WIFI_NAME", "start", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "type", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WifiListActivity.class);
            intent.putExtra(PersonalContract.KEY_PAGE, type);
            context.startActivity(intent);
        }
    }

    private final int getTitleResId(int eventId) {
        return eventId == EventId.HOME_WIFI.getId() ? R.string.home_wifi : R.string.company_wifi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$0(WifiListActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlphaMeLogger.debugLog("Personal", "common data update, update ui, size " + list.size());
        PersonalCommonListAdapter mAdapter = this$0.getMAdapter();
        Intrinsics.checkNotNull(list);
        mAdapter.setData(list);
    }

    private final void sendResultForRequester(WifiInfo wifiInfo) {
        Intent intent = new Intent();
        intent.putExtra(KEY_WIFI_NAME, wifiInfo.getSsid());
        intent.putExtra(KEY_WIFI_MAC_ADDRESS, wifiInfo.getBSsid());
        setResult(-1, intent);
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity, com.stepos.architecture.ui.stepos.d
    public void initViewModel() {
        super.initViewModel();
        n0 activityScopeViewModel = getActivityScopeViewModel(WifiRequester.class);
        Intrinsics.checkNotNullExpressionValue(activityScopeViewModel, "getActivityScopeViewModel(...)");
        this.mRequester = (WifiRequester) activityScopeViewModel;
        n0 applicationScopeViewModel = getApplicationScopeViewModel(PageMessenger.class);
        Intrinsics.checkNotNullExpressionValue(applicationScopeViewModel, "getApplicationScopeViewModel(...)");
        this.mMessenger = (PageMessenger) applicationScopeViewModel;
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity
    public void observe() {
        WifiRequester wifiRequester = this.mRequester;
        WifiRequester wifiRequester2 = null;
        if (wifiRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            wifiRequester = null;
        }
        wifiRequester.getDataList().d(this, new e(3, this));
        WifiRequester wifiRequester3 = this.mRequester;
        if (wifiRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            wifiRequester2 = wifiRequester3;
        }
        wifiRequester2.requestDataList();
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity, com.stepos.architecture.ui.stepos.d, stepos.support.v7.app.D, stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int intExtra = getIntent().getIntExtra(PersonalContract.KEY_PAGE, EventId.HOME_WIFI.getId());
        WifiRequester wifiRequester = this.mRequester;
        if (wifiRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            wifiRequester = null;
        }
        wifiRequester.setEventId(intExtra);
        setToolbar(getTitleResId(intExtra));
        getBinding().tvTip.setText(getString(R.string.show_connected_wifi));
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonListActivity
    public void save(int selectedIndex) {
        WifiRequester wifiRequester = this.mRequester;
        WifiRequester wifiRequester2 = null;
        if (wifiRequester == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            wifiRequester = null;
        }
        WifiInfo wifiResult = wifiRequester.getWifiResult(selectedIndex);
        PageMessenger pageMessenger = this.mMessenger;
        if (pageMessenger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
            pageMessenger = null;
        }
        WifiRequester wifiRequester3 = this.mRequester;
        if (wifiRequester3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
            wifiRequester3 = null;
        }
        pageMessenger.input(new WifiMessages(wifiRequester3.get_eventId(), wifiResult));
        sendResultForRequester(wifiResult);
        WifiRequester wifiRequester4 = this.mRequester;
        if (wifiRequester4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequester");
        } else {
            wifiRequester2 = wifiRequester4;
        }
        wifiRequester2.saveData(wifiResult);
    }
}
