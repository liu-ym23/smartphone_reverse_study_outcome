package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap;
    private final String mCameraId;

    public interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo r100);
    }

    public static final class UseCaseAttachInfo {
        private boolean mActive;
        private boolean mAttached;
        private final List<UseCaseConfigFactory.CaptureType> mCaptureTypes;
        private final SessionConfig mSessionConfig;
        private final StreamSpec mStreamSpec;
        private final UseCaseConfig<?> mUseCaseConfig;

        public String toString() {
            return "UseCaseAttachInfo{mSessionConfig=" + this.mSessionConfig + ", mUseCaseConfig=" + this.mUseCaseConfig + ", mStreamSpec=" + this.mStreamSpec + ", mCaptureTypes=" + this.mCaptureTypes + ", mAttached=" + this.mAttached + ", mActive=" + this.mActive + '}';
        }

        public boolean getActive() {
            return this.mActive;
        }

        public boolean getAttached() {
            return this.mAttached;
        }

        public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
            return this.mCaptureTypes;
        }

        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        public StreamSpec getStreamSpec() {
            return this.mStreamSpec;
        }

        public UseCaseConfig<?> getUseCaseConfig() {
            return this.mUseCaseConfig;
        }

        public void setActive(boolean r100) {
            this.mActive = r100;
        }

        public void setAttached(boolean r100) {
            this.mAttached = r100;
        }

        public UseCaseAttachInfo(SessionConfig r100, UseCaseConfig<?> r101, StreamSpec r102, List<UseCaseConfigFactory.CaptureType> r103) {
            this.mAttached = false;
            this.mActive = false;
            this.mSessionConfig = r100;
            this.mUseCaseConfig = r101;
            this.mStreamSpec = r102;
            this.mCaptureTypes = r103;
        }
    }

    public static /* synthetic */ boolean a(UseCaseAttachInfo r100) {
        return lambda$getActiveAndAttachedSessionConfigs$3(r100);
    }

    public static /* synthetic */ boolean b(UseCaseAttachInfo r100) {
        return lambda$getAttachedSessionConfigs$1(r100);
    }

    public static /* synthetic */ boolean c(UseCaseAttachInfo r100) {
        return lambda$getAttachedUseCaseInfo$2(r100);
    }

    public static /* synthetic */ boolean d(UseCaseAttachInfo r100) {
        return lambda$getAttachedUseCaseConfigs$0(r100);
    }

    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder r100 = new SessionConfig.ValidatingBuilder();
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r102 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r103 = r102.next();
        UseCaseAttachInfo r104 = r103.getValue();
        if (r104.getActive() == false) goto L4;
        if (r104.getAttached() == false) goto L4;
        String r105 = r103.getKey();
        r100.add(r104.getSessionConfig());
        r101.add(r105);
        goto L4
    L10:
        Logger.d(TAG, "Active and attached use case: " + r101 + " for camera: " + this.mCameraId);
        return r100;
    }

    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new y()));
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder r100 = new SessionConfig.ValidatingBuilder();
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r102 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, UseCaseAttachInfo> r103 = r102.next();
        UseCaseAttachInfo r104 = r103.getValue();
        if (r104.getAttached() == false) goto L4;
        r100.add(r104.getSessionConfig());
        r101.add(r103.getKey());
        goto L4
    L8:
        Logger.d(TAG, "All use case: " + r101 + " for camera: " + this.mCameraId);
        return r100;
    }

    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new v()));
    }

    public Collection<UseCaseConfig<?>> getAttachedUseCaseConfigs() {
        return Collections.unmodifiableCollection(getUseCaseConfigs(new x()));
    }

    public Collection<UseCaseAttachInfo> getAttachedUseCaseInfo() {
        return Collections.unmodifiableCollection(getUseCaseInfo(new w()));
    }

    public UseCaseAttachState(String r100) {
        this.mAttachedUseCasesToInfoMap = new LinkedHashMap();
        this.mCameraId = r100;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r102 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r103 = r102.next();
        if (r100 == null) goto L9;
        if (r100.filter(r103.getValue()) == false) goto L4;
    L9:
        r101.add(r103.getValue().getSessionConfig());
        goto L4
    L10:
        return r101;
    }

    private Collection<UseCaseConfig<?>> getUseCaseConfigs(AttachStateFilter r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r102 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r103 = r102.next();
        if (r100 == null) goto L9;
        if (r100.filter(r103.getValue()) == false) goto L4;
    L9:
        r101.add(r103.getValue().getUseCaseConfig());
        goto L4
    L10:
        return r101;
    }

    private Collection<UseCaseAttachInfo> getUseCaseInfo(AttachStateFilter r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, UseCaseAttachInfo>> r102 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, UseCaseAttachInfo> r103 = r102.next();
        if (r100 == null) goto L9;
        if (r100.filter(r103.getValue()) == false) goto L4;
    L9:
        r101.add(r103.getValue());
        goto L4
    L10:
        return r101;
    }

    private static /* synthetic */ boolean lambda$getActiveAndAttachedSessionConfigs$3(UseCaseAttachInfo r100) {
        if (r100.getActive() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getAttached() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAttachedSessionConfigs$1(UseCaseAttachInfo r100) {
        return r100.getAttached();
    }

    private static /* synthetic */ boolean lambda$getAttachedUseCaseConfigs$0(UseCaseAttachInfo r100) {
        return r100.getAttached();
    }

    private static /* synthetic */ boolean lambda$getAttachedUseCaseInfo$2(UseCaseAttachInfo r100) {
        return r100.getAttached();
    }

    public boolean isUseCaseAttached(String r100) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r100) == true) goto L7;
        return false;
    L7:
        return this.mAttachedUseCasesToInfoMap.get(r100).getAttached();
    }

    public void removeUseCase(String r100) {
        this.mAttachedUseCasesToInfoMap.remove(r100);
    }

    public void setUseCaseDetached(String r100) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r100) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r101 = this.mAttachedUseCasesToInfoMap.get(r100);
        r101.setAttached(false);
        if (r101.getActive() == true) goto L9;
        this.mAttachedUseCasesToInfoMap.remove(r100);
        return;
    }

    public void setUseCaseInactive(String r100) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r100) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r101 = this.mAttachedUseCasesToInfoMap.get(r100);
        r101.setActive(false);
        if (r101.getAttached() == true) goto L9;
        this.mAttachedUseCasesToInfoMap.remove(r100);
        return;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String r100, SessionConfig r101, UseCaseConfig<?> r102, StreamSpec r103, List<UseCaseConfigFactory.CaptureType> r104) {
        UseCaseAttachInfo r105 = this.mAttachedUseCasesToInfoMap.get(r100);
        if (r105 != null) goto L6;
        UseCaseAttachInfo r106 = new UseCaseAttachInfo(r101, r102, r103, r104);
        this.mAttachedUseCasesToInfoMap.put(r100, r106);
        return r106;
    L6:
        return r105;
    }

    public void setUseCaseActive(String r100, SessionConfig r101, UseCaseConfig<?> r102, StreamSpec r103, List<UseCaseConfigFactory.CaptureType> r104) {
        getOrCreateUseCaseAttachInfo(r100, r101, r102, r103, r104).setActive(true);
    }

    public void setUseCaseAttached(String r100, SessionConfig r101, UseCaseConfig<?> r102, StreamSpec r103, List<UseCaseConfigFactory.CaptureType> r104) {
        getOrCreateUseCaseAttachInfo(r100, r101, r102, r103, r104).setAttached(true);
        updateUseCase(r100, r101, r102, r103, r104);
    }

    public void updateUseCase(String r100, SessionConfig r101, UseCaseConfig<?> r102, StreamSpec r103, List<UseCaseConfigFactory.CaptureType> r104) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(r100) == true) goto L5;
        return;
    L5:
        UseCaseAttachInfo r105 = new UseCaseAttachInfo(r101, r102, r103, r104);
        UseCaseAttachInfo r106 = this.mAttachedUseCasesToInfoMap.get(r100);
        r105.setAttached(r106.getAttached());
        r105.setActive(r106.getActive());
        this.mAttachedUseCasesToInfoMap.put(r100, r105);
    }
}
