package com.android.server.audio;

import android.media.IAudioPolicyService;
import android.os.Binder;
import android.os.RemoteException;
import com.android.media.permission.INativePermissionController;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAudioPolicyFacade implements AudioPolicyFacade {
    private static final String AUDIO_POLICY_SERVICE_NAME = "media.audio_policy";
    private final ServiceHolder<IAudioPolicyService> mServiceHolder;

    /* JADX INFO: renamed from: $r8$lambda$-AKBXD_jGFn8nzWEFdnCSYP_kCg, reason: not valid java name */
    public static /* synthetic */ void m2141$r8$lambda$AKBXD_jGFn8nzWEFdnCSYP_kCg(Runnable r0, IAudioPolicyService r1) {
        lambda$registerOnStartTask$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pChqcGzX0MLfsfJ880RTN3vNnNI(IAudioPolicyService r0) {
        lambda$new$0(r0);
    }

    public DefaultAudioPolicyFacade(Executor e) {
        this.mServiceHolder = new ServiceHolder(AUDIO_POLICY_SERVICE_NAME, new DefaultAudioPolicyFacade$$ExternalSyntheticLambda1(), e);
        this.mServiceHolder.registerOnStartTask(new DefaultAudioPolicyFacade$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ void lambda$new$0(IAudioPolicyService i) {
        Binder.allowBlocking(i.asBinder());
    }

    @Override // com.android.server.audio.AudioPolicyFacade
    public boolean isHotwordStreamSupported(boolean lookbackAudio) {
        IAudioPolicyService ap = this.mServiceHolder.waitForService();
        return ap.isHotwordStreamSupported(lookbackAudio);
    L6:
        this.mServiceHolder.attemptClear(ap.asBinder());
        throw new IllegalStateException();
    }

    @Override // com.android.server.audio.AudioPolicyFacade
    public INativePermissionController getPermissionController() {
        IAudioPolicyService ap = this.mServiceHolder.checkService();
        if (ap != null) goto L10;
        return null;
    L10:
        INativePermissionController res = ap.getPermissionController();     // Catch: RemoteException -> L7
        res.getClass();     // Catch: RemoteException -> L7
        Binder.allowBlocking(res.asBinder());     // Catch: RemoteException -> L7
        return res;
    L8:
        this.mServiceHolder.attemptClear(ap.asBinder());
        return null;
    }

    private static /* synthetic */ void lambda$registerOnStartTask$1(Runnable task, IAudioPolicyService unused) {
        task.run();
    }

    @Override // com.android.server.audio.AudioPolicyFacade
    public void registerOnStartTask(final Runnable task) {
        this.mServiceHolder.registerOnStartTask(new DefaultAudioPolicyFacade$$ExternalSyntheticLambda0(task));
    }

    @Override // com.android.server.audio.AudioPolicyFacade
    public void setEnableHardening(boolean shouldEnable) {
        IAudioPolicyService ap = this.mServiceHolder.waitForService();
        ap.setEnableHardening(shouldEnable);     // Catch: RemoteException -> L5
        return;
    L6:
        this.mServiceHolder.attemptClear(ap.asBinder());
    }
}
