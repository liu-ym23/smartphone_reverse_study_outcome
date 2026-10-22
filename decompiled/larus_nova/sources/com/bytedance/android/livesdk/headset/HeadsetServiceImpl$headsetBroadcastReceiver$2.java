package com.bytedance.android.livesdk.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.service.HeadsetType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1;"}, k = 3, mv = {1, 4, 3})
public final class HeadsetServiceImpl$headsetBroadcastReceiver$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ HeadsetServiceImpl this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.headset.HeadsetServiceImpl$headsetBroadcastReceiver$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", "Landroid/content/BroadcastReceiver;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f132631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HeadsetServiceImpl$headsetBroadcastReceiver$2 f132632b;

        public AnonymousClass1(HeadsetServiceImpl$headsetBroadcastReceiver$2 r100) {
            this.f132632b = r100;
            IntentFilter r101 = new IntentFilter();
            this.f132631a = r101;
            r101.addAction("android.intent.action.HEADSET_PLUG");
            r101.addAction("android.media.AUDIO_BECOMING_NOISY");
            r101.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 != null) goto L6;
            return;
        L6:
            ALogger.i(HeadsetServiceImpl.TAG, "onReceive, intent is " + r101.getAction());
            final HeadsetType r102 = HeadsetServiceImpl.access$getCurrentType$p(this.f132632b.this$0);
            String r103 = r101.getAction();
            if (r103 == null) goto L39;
            int r104 = r103.hashCode();
            if (r104 == (-1676458352)) goto L29;
            if (r104 == (-549244379)) goto L26;
            if (r104 != 545516589) goto L39;
            if (r103.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L39;
            int r105 = r101.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            if (r105 != 0) goto L21;
            HeadsetServiceImpl.access$setCurrentType$p(this.f132632b.this$0, HeadsetType.UnKnow);
            goto L39
        L21:
            if (r105 != 2) goto L39;
            HeadsetServiceImpl.access$setCurrentType$p(this.f132632b.this$0, HeadsetType.BluetoothSco);
            goto L39
        L26:
            if (r103.equals("android.media.AUDIO_BECOMING_NOISY") == false) goto L39;
            HeadsetServiceImpl.access$setCurrentType$p(this.f132632b.this$0, HeadsetType.UnKnow);
            goto L39
        L29:
            if (r103.equals("android.intent.action.HEADSET_PLUG") == false) goto L39;
            HeadsetServiceImpl r106 = this.f132632b.this$0;
            if (r101.getIntExtra("state", 0) == 1) goto L33;
            HeadsetType r107 = HeadsetType.UnKnow;
        L37:
            HeadsetServiceImpl.access$setCurrentType$p(r106, r107);
            goto L39
        L33:
            if (r101.getIntExtra("microphone", 0) != 1) goto L35;
            r107 = HeadsetType.WiredHeadPhones;
            goto L37
        L35:
            r107 = HeadsetType.WiredHeadSet;
        L39:
            if (r102 == HeadsetServiceImpl.access$getCurrentType$p(this.f132632b.this$0)) goto L42;
            ALogger.i(HeadsetServiceImpl.TAG, "get headset type use receiver: " + HeadsetServiceImpl.access$getCurrentType$p(this.f132632b.this$0).getTypeValue());
            UtilityKotlinExtentionsKt.s(0, false, false, new HeadsetServiceImpl$headsetBroadcastReceiver$2$1$onReceive$1(this, r102), 7);
            HeadsetServiceImpl.access$updateFeatureValue(this.f132632b.this$0);
            return;
        }
    }

    public HeadsetServiceImpl$headsetBroadcastReceiver$2(HeadsetServiceImpl r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }
}
