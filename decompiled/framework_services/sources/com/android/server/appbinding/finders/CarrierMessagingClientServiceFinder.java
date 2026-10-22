package com.android.server.appbinding.finders;

import android.R;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.UserHandle;
import android.service.carrier.CarrierMessagingClientService;
import android.service.carrier.ICarrierMessagingClientService;
import android.text.TextUtils;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.CollectionUtils;
import com.android.server.appbinding.AppBindingConstants;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class CarrierMessagingClientServiceFinder extends AppServiceFinder<CarrierMessagingClientService, ICarrierMessagingClientService> {
    private final OnRoleHoldersChangedListener mRoleHolderChangedListener;
    private final RoleManager mRoleManager;

    public static /* synthetic */ void $r8$lambda$ddDD0hG5zSTGAVBKIlMbkK0OLkM(CarrierMessagingClientServiceFinder r0, String r1, UserHandle r2) {
        r0.lambda$new$0(r1, r2);
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    public /* bridge */ /* synthetic */ IInterface asInterface(IBinder r1) {
        return m1682asInterface(r1);
    }

    public CarrierMessagingClientServiceFinder(Context context, BiConsumer<AppServiceFinder, Integer> listener, Handler callbackHandler) {
        super(context, listener, callbackHandler);
        this.mRoleHolderChangedListener = new CarrierMessagingClientServiceFinder$$ExternalSyntheticLambda0(this);
        this.mRoleManager = (RoleManager) context.getSystemService(RoleManager.class);
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    protected boolean isEnabled(AppBindingConstants constants) {
        if (constants.SMS_SERVICE_ENABLED == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.getResources().getBoolean(R.bool.config_viewBasedRotaryEncoderHapticsEnabled) == false) goto L7;
        return true;
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    public String getAppDescription() {
        return "[Default SMS app]";
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    protected Class<CarrierMessagingClientService> getServiceClass() {
        return CarrierMessagingClientService.class;
    }

    /* JADX INFO: renamed from: asInterface, reason: collision with other method in class */
    public ICarrierMessagingClientService m1682asInterface(IBinder obj) {
        return ICarrierMessagingClientService.Stub.asInterface(obj);
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    protected String getServiceAction() {
        return "android.telephony.action.CARRIER_MESSAGING_CLIENT_SERVICE";
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    protected String getServicePermission() {
        return "android.permission.BIND_CARRIER_MESSAGING_CLIENT_SERVICE";
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    public String getTargetPackage(int userId) {
        String ret = (String) CollectionUtils.firstOrNull(this.mRoleManager.getRoleHoldersAsUser("android.app.role.SMS", UserHandle.of(userId)));
        return ret;
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    public void startMonitoring() {
        this.mRoleManager.addOnRoleHoldersChangedListenerAsUser(BackgroundThread.getExecutor(), this.mRoleHolderChangedListener, UserHandle.ALL);
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    protected String validateService(ServiceInfo service) {
        String packageName = service.packageName;
        String process = service.processName;
        if (process != null) goto L5;
        return "Service must not run on the main process";
    L5:
        if (TextUtils.equals(packageName, process) == true) goto L11;
        return null;
    L11:
        return "Service must not run on the main process";
    }

    @Override // com.android.server.appbinding.finders.AppServiceFinder
    public int getBindFlags(AppBindingConstants constants) {
        return constants.SMS_APP_BIND_FLAGS;
    }

    private /* synthetic */ void lambda$new$0(String role, UserHandle user) {
        if ("android.app.role.SMS".equals(role) == false) goto L6;
        this.mListener.accept(this, Integer.valueOf(user.getIdentifier()));
        return;
    }
}
