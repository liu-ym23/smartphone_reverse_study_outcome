package com.bytedance.android.livesdk.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.service.HeadsetType;
import com.bytedance.android.livesdkapi.service.IHeadsetChange;
import com.bytedance.android.livesdkapi.service.IHeadsetService;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b*\u0001\u001b\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl;", "Lcom/bytedance/android/livesdkapi/service/IHeadsetService;", "Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "getHeadsetType", "", "updateFeatureValue", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "", "forceRefresh", "getHeadSetType", "startListenHeadSetChange", "Lcom/bytedance/android/livesdkapi/service/IHeadsetChange;", "listener", "addHeadsetChangeListener", "removeHeadsetChangeListener", "currentType", "Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "startedListenChange", "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList$delegate", "Lkotlin/Lazy;", "getListenerList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", "headsetBroadcastReceiver$delegate", "getHeadsetBroadcastReceiver", "()Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1;", "headsetBroadcastReceiver", "Landroid/content/Context;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadsetServiceImpl implements IHeadsetService {
    public static final a Companion = null;
    public static final String TAG = "HeadsetServiceImpl";
    private Context context;
    private HeadsetType currentType;
    private final Lazy headsetBroadcastReceiver$delegate;
    private final Lazy listenerList$delegate;
    private boolean startedListenChange;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final HeadsetServiceImpl$headsetBroadcastReceiver$2.AnonymousClass1 getHeadsetBroadcastReceiver() {
        return (HeadsetServiceImpl$headsetBroadcastReceiver$2.AnonymousClass1) this.headsetBroadcastReceiver$delegate.getValue();
    }

    private final CopyOnWriteArrayList<IHeadsetChange> getListenerList() {
        return (CopyOnWriteArrayList) this.listenerList$delegate.getValue();
    }

    private final HeadsetType getHeadsetType() {
        Context r100 = this.context;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("audio");
    L7:
        if ((r102 instanceof AudioManager) == false) goto L10;
        r101 = r102;
    L10:
        AudioManager r103 = (AudioManager) r101;
        if (r103 == null) goto L42;
        ALogger.i(TAG, "get headset type use audio manager");
        if (Build.VERSION.SDK_INT < 23) goto L31;
        AudioDeviceInfo[] r104 = r103.getDevices(2);
        if (r104.length <= 0) goto L42;
        int r105 = r104[0].getType();
        if (r105 == 3) goto L29;
        if (r105 == 4) goto L46;
        if (r105 == 7) goto L45;
        if (r105 == 8) goto L44;
        return HeadsetType.UnKnow;
    L44:
        return HeadsetType.BluetoothA2DP;
    L45:
        return HeadsetType.BluetoothSco;
    L46:
        return HeadsetType.WiredHeadPhones;
    L29:
        return HeadsetType.WiredHeadSet;
    L31:
        if (r103.isWiredHeadsetOn() == false) goto L34;
        return HeadsetType.WiredHeadSet;
    L34:
        if (r103.isBluetoothScoOn() == false) goto L37;
        return HeadsetType.BluetoothSco;
    L37:
        if (r103.isBluetoothA2dpOn() == false) goto L40;
        return HeadsetType.BluetoothA2DP;
    L40:
        return HeadsetType.UnKnow;
    L42:
        return HeadsetType.Null;
    L5:
        r102 = null;
        goto L7
    }

    private final void updateFeatureValue() {
        IFeatureService r100 = (IFeatureService) k.f(IFeatureService.class);
        if (r100 == null) goto L17;
        z90.a r101 = r100.getFeatureManager();
        if (r101 == null) goto L18;
        HeadsetType r102 = this.currentType;
        int r103 = com.bytedance.android.livesdk.headset.a.f132633a[r102.ordinal()];
        int r104 = 1;
        if (r103 == 1) goto L14;
        if (r103 == 2) goto L14;
        if (r103 != 3) goto L12;
    L15:
        z90.a.C8431a.a(r101, "live_audio_play_type", Integer.valueOf(r104));
        return;
    L12:
        if (r103 == 4) goto L15;
        r104 = 0;
    L14:
        r104 = 2;
        goto L15
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IHeadsetService
    public void startListenHeadSetChange() {
        if (this.startedListenChange == true) goto L11;
        Context r100 = this.context;     // Catch: Throwable -> L8
        if (r100 == null) goto L12;
        ALogger.i(TAG, "started listen headset change");     // Catch: Throwable -> L8
        this.startedListenChange = true;     // Catch: Throwable -> L8
        INVOKEVIRTUAL_com_bytedance_android_livesdk_headset_HeadsetServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, getHeadsetBroadcastReceiver(), getHeadsetBroadcastReceiver().f132631a);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public HeadsetServiceImpl() {
        this.currentType = HeadsetType.Null;
        this.listenerList$delegate = LazyKt.lazy(HeadsetServiceImpl$listenerList$2.INSTANCE);
        this.headsetBroadcastReceiver$delegate = LazyKt.lazy(new HeadsetServiceImpl$headsetBroadcastReceiver$2(this));
        k.l(IHeadsetService.class, this);
        ALogger.i(TAG, "register headsetService succeed");
    }

    public static final /* synthetic */ HeadsetType access$getCurrentType$p(HeadsetServiceImpl r100) {
        return r100.currentType;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListenerList$p(HeadsetServiceImpl r100) {
        return r100.getListenerList();
    }

    public static final /* synthetic */ void access$updateFeatureValue(HeadsetServiceImpl r100) {
        r100.updateFeatureValue();
    }

    @Override // com.bytedance.android.livesdkapi.service.IHeadsetService
    public void addHeadsetChangeListener(IHeadsetChange r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getListenerList().add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.IHeadsetService
    public HeadsetType getHeadSetType(boolean r100) {
        if (r100 == true) goto L5;
        HeadsetType r101 = this.currentType;
        if (r101 == HeadsetType.Null) goto L5;
        return r101;
    L5:
        HeadsetType r102 = getHeadsetType();
        ALogger.i(TAG, "get Headset type result: " + r102.getTypeValue() + ' ');
        if (r102 == HeadsetType.Null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L15;
        this.currentType = r102;
        updateFeatureValue();
        return r102;
    L15:
        return this.currentType;
    L8:
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.service.IHeadsetService
    public void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        getHeadSetType(false);
    }

    @Override // com.bytedance.android.livesdkapi.service.IHeadsetService
    public void removeHeadsetChangeListener(IHeadsetChange r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getListenerList().remove(r100);
    }

    public static final /* synthetic */ void access$setCurrentType$p(HeadsetServiceImpl r100, HeadsetType r101) {
        r100.currentType = r101;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_android_livesdk_headset_HeadsetServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
