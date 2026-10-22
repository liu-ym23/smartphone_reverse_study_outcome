package androidx.camera.video.internal.workaround;

import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.StretchedVideoResolutionQuirk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class QualityResolutionModifiedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    private Size getAlternativeResolution(int r100) {
        Iterator r101 = this.mQuirks.getAll(StretchedVideoResolutionQuirk.class).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        StretchedVideoResolutionQuirk r102 = (StretchedVideoResolutionQuirk) r101.next();
        if (r102 == null) goto L4;
        return r102.getAlternativeResolution(r100);
    L9:
        return null;
    }

    private EncoderProfilesProxy getProfilesInternal(int r100) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r100)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r100));
    L7:
        if (this.mProvider.hasProfile(r100) == false) goto L12;
        EncoderProfilesProxy r101 = this.mProvider.getAll(r100);
        Objects.requireNonNull(r101);
        EncoderProfilesProxy r102 = r101;
        Size r103 = getAlternativeResolution(r100);
        if (r103 == null) goto L13;
        r102 = createNewEncoderProfiles(r102, r103);
    L13:
        this.mEncoderProfilesCache.put(Integer.valueOf(r100), r102);
        return r102;
    L12:
        r102 = null;
        goto L13
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r100) {
        return getProfilesInternal(r100);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r100) {
        if (this.mProvider.hasProfile(r100) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public QualityResolutionModifiedEncoderProfilesProvider(EncoderProfilesProvider r100, Quirks r101) {
        this.mEncoderProfilesCache = new HashMap();
        this.mProvider = r100;
        this.mQuirks = r101;
    }

    private EncoderProfilesProxy createNewEncoderProfiles(EncoderProfilesProxy r100, Size r101) {
        ArrayList r102 = new ArrayList();
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r103 = r100.getVideoProfiles().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add(generateVideoProfile(r103.next(), r101));
        goto L4
    L7:
        if (r102.isEmpty() == false) goto L10;
        return null;
    L10:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r100.getDefaultDurationSeconds(), r100.getRecommendedFileFormat(), r100.getAudioProfiles(), r102);
    }

    private static EncoderProfilesProxy.VideoProfileProxy generateVideoProfile(EncoderProfilesProxy.VideoProfileProxy r110, Size r111) {
        return EncoderProfilesProxy.VideoProfileProxy.create(r110.getCodec(), r110.getMediaType(), r110.getBitrate(), r110.getFrameRate(), r111.getWidth(), r111.getHeight(), r110.getProfile(), r110.getBitDepth(), r110.getChromaSubsampling(), r110.getHdrFormat());
    }
}
