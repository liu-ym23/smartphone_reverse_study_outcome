package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerMiddlewareImpl implements ISoundTriggerMiddlewareInternal {
    private static final String TAG = "SoundTriggerMiddlewareImpl";
    private final SoundTriggerModule[] mModules;

    public static abstract class AudioSessionProvider {

        public static final class AudioSession {
            final int mDeviceHandle;
            final int mIoHandle;
            final int mSessionHandle;

            AudioSession(int sessionHandle, int ioHandle, int deviceHandle) {
                this.mSessionHandle = sessionHandle;
                this.mIoHandle = ioHandle;
                this.mDeviceHandle = deviceHandle;
            }
        }

        public abstract AudioSession acquireSession();

        public abstract void releaseSession(int r1);

        public AudioSessionProvider() {
        }
    }

    public SoundTriggerMiddlewareImpl(HalFactory[] halFactories, AudioSessionProvider audioSessionProvider) {
        List<SoundTriggerModule> modules = new ArrayList(halFactories.length);
        int r1 = halFactories.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        HalFactory halFactory = halFactories[r3];
        modules.add(new SoundTriggerModule(halFactory, audioSessionProvider));     // Catch: Exception -> L7
    L9:
        r3 = r3 + 1;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to add a SoundTriggerModule instance", e);
        goto L9
    L10:
        this.mModules = (SoundTriggerModule[]) modules.toArray(new SoundTriggerModule[0]);
    }

    public SoundTriggerMiddlewareImpl(HalFactory factory, AudioSessionProvider audioSessionProvider) {
        this(new HalFactory[]{factory}, audioSessionProvider);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public SoundTriggerModuleDescriptor[] listModules() {
        SoundTriggerModuleDescriptor[] result = new SoundTriggerModuleDescriptor[this.mModules.length];
        int i = 0;
    L4:
        if (i >= this.mModules.length) goto L7;
        SoundTriggerModuleDescriptor desc = new SoundTriggerModuleDescriptor();
        desc.handle = i;
        desc.properties = this.mModules[i].getProperties();
        result[i] = desc;
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public ISoundTriggerModule attach(int handle, ISoundTriggerCallback callback, boolean isTrusted) {
        return this.mModules[handle].attach(callback);
    }
}
