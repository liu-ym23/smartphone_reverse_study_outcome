package androidx.camera.video.internal.workaround;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedQualityQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class QualityAddedEncoderProfilesProvider implements EncoderProfilesProvider {
    private Map<Integer, EncoderProfilesProxy> mExtraQualityToEncoderProfiles;
    private final EncoderProfilesProvider mProvider;

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        Map<Integer, EncoderProfilesProxy> r101 = this.mExtraQualityToEncoderProfiles;
        if (r101 == null) goto L9;
        if (r101.containsKey(Integer.valueOf(r100)) == false) goto L9;
        return this.mExtraQualityToEncoderProfiles.get(Integer.valueOf(r100));
    L9:
        return this.mProvider.getAll(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        return getProfilesInternal(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (getProfilesInternal(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public QualityAddedEncoderProfilesProvider(EncoderProfilesProvider r100, Quirks r101, CameraInfoInternal r102, Function<VideoEncoderConfig, VideoEncoderInfo> r103) {
        this.mProvider = r100;
        List r104 = r101.getAll(ExtraSupportedQualityQuirk.class);
        if (r104.isEmpty() == true) goto L12;
        boolean r105 = true;
        if (r104.size() == 1) goto L8;
        r105 = false;
    L8:
        Preconditions.checkState(r105);
        Map<Integer, EncoderProfilesProxy> r106 = ((ExtraSupportedQualityQuirk) ListProtector.get(r104, 0)).getExtraEncoderProfiles(r102, r100, r103);
        if (r106 == null) goto L13;
        this.mExtraQualityToEncoderProfiles = new HashMap(r106);
        return;
    L13:
        return;
    }
}
