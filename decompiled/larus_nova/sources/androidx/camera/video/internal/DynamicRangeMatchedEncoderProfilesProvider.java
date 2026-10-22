package androidx.camera.video.internal;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRangeMatchedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final DynamicRange mDynamicRange;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mEncoderProfilesProvider;

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r100)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r100));
    L7:
        if (this.mEncoderProfilesProvider.hasProfile(r100) == false) goto L9;
        EncoderProfilesProxy r101 = filterUnmatchedDynamicRange(this.mEncoderProfilesProvider.getAll(r100), this.mDynamicRange);
        this.mEncoderProfilesCache.put(Integer.valueOf(r100), r101);
        return r101;
    L9:
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        return getProfilesInternal(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (this.mEncoderProfilesProvider.hasProfile(r100) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public DynamicRangeMatchedEncoderProfilesProvider(EncoderProfilesProvider r100, DynamicRange r101) {
        this.mEncoderProfilesCache = new HashMap();
        this.mEncoderProfilesProvider = r100;
        this.mDynamicRange = r101;
    }

    private static EncoderProfilesProxy filterUnmatchedDynamicRange(EncoderProfilesProxy r100, DynamicRange r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r103 = r100.getVideoProfiles().iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        EncoderProfilesProxy.VideoProfileProxy r104 = r103.next();
        if (DynamicRangeUtil.isHdrSettingsMatched(r104, r101) == false) goto L7;
        r102.add(r104);
        goto L7
    L12:
        if (r102.isEmpty() == false) goto L15;
        return null;
    L15:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r100.getDefaultDurationSeconds(), r100.getRecommendedFileFormat(), r100.getAudioProfiles(), r102);
    }
}
