package androidx.camera.core.impl;

import android.util.Range;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class CaptureConfig {
    public static final String CAPTURE_CONFIG_ID_TAG_KEY = "CAPTURE_CONFIG_ID_KEY";
    public static final int DEFAULT_ID = -1;
    public static final Config.Option<Integer> OPTION_JPEG_QUALITY = null;
    private static final Config.Option<Range<Integer>> OPTION_RESOLVED_FRAME_RATE = null;
    public static final Config.Option<Integer> OPTION_ROTATION = null;
    public static final int TEMPLATE_TYPE_NONE = -1;
    final List<CameraCaptureCallback> mCameraCaptureCallbacks;
    private final CameraCaptureResult mCameraCaptureResult;
    final Config mImplementationOptions;
    final boolean mPostviewEnabled;
    final List<DeferrableSurface> mSurfaces;
    private final TagBundle mTagBundle;
    final int mTemplateType;
    private final boolean mUseRepeatingSurface;

    public static final class Builder {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;
        private CameraCaptureResult mCameraCaptureResult;
        private MutableConfig mImplementationOptions;
        private MutableTagBundle mMutableTagBundle;
        private boolean mPostviewEnabled;
        private final Set<DeferrableSurface> mSurfaces;
        private int mTemplateType;
        private boolean mUseRepeatingSurface;

        public CaptureConfig build() {
            return new CaptureConfig(new ArrayList(this.mSurfaces), OptionsBundle.from(this.mImplementationOptions), this.mTemplateType, this.mPostviewEnabled, new ArrayList(this.mCameraCaptureCallbacks), this.mUseRepeatingSurface, TagBundle.from(this.mMutableTagBundle), this.mCameraCaptureResult);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
        }

        public Range<Integer> getExpectedFrameRateRange() {
            return (Range) this.mImplementationOptions.retrieveOption(CaptureConfig.access$000(), StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        }

        public Builder() {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mPostviewEnabled = false;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
        }

        public Config getImplementationOptions() {
            return this.mImplementationOptions;
        }

        public Set<DeferrableSurface> getSurfaces() {
            return this.mSurfaces;
        }

        public int getTemplateType() {
            return this.mTemplateType;
        }

        public boolean isUseRepeatingSurface() {
            return this.mUseRepeatingSurface;
        }

        private Builder(CaptureConfig r100) {
            HashSet r101 = new HashSet();
            this.mSurfaces = r101;
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mPostviewEnabled = false;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
            r101.addAll(r100.mSurfaces);
            this.mImplementationOptions = MutableOptionsBundle.from(r100.mImplementationOptions);
            this.mTemplateType = r100.mTemplateType;
            this.mCameraCaptureCallbacks.addAll(r100.getCameraCaptureCallbacks());
            this.mUseRepeatingSurface = r100.isUseRepeatingSurface();
            this.mMutableTagBundle = MutableTagBundle.from(r100.getTagBundle());
            this.mPostviewEnabled = r100.mPostviewEnabled;
        }

        public static Builder createFrom(UseCaseConfig<?> r100) {
            OptionUnpacker r101 = r100.getCaptureOptionUnpacker(null);
            if (r101 == null) goto L7;
            Builder r102 = new Builder();
            r101.unpack(r100, r102);
            return r102;
        L7:
            throw new IllegalStateException("Implementation is missing option unpacker for " + r100.getTargetName(r100.toString()));
        }

        public static Builder from(CaptureConfig r100) {
            return new Builder(r100);
        }

        public void addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> r100) {
            Iterator<CameraCaptureCallback> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            addCameraCaptureCallback(r101.next());
            goto L4
        }

        public void addAllTags(TagBundle r100) {
            this.mMutableTagBundle.addTagBundle(r100);
        }

        public void addCameraCaptureCallback(CameraCaptureCallback r100) {
            if (this.mCameraCaptureCallbacks.contains(r100) == false) goto L5;
            return;
        L5:
            this.mCameraCaptureCallbacks.add(r100);
        }

        public void addImplementationOptions(Config r100) {
            Iterator<Config.Option<?>> r101 = r100.listOptions().iterator();
        L4:
            if (r101.hasNext() == false) goto L12;
            Config.Option<?> r102 = r101.next();
            Object r103 = this.mImplementationOptions.retrieveOption(r102, null);
            Object r104 = r100.retrieveOption(r102);
            if ((r103 instanceof MultiValueSet) == true) goto L7;
            if ((r104 instanceof MultiValueSet) == false) goto L11;
            r104 = ((MultiValueSet) r104).clone();
        L11:
            this.mImplementationOptions.insertOption(r102, r100.getOptionPriority(r102), r104);
            goto L4
        L7:
            ((MultiValueSet) r103).addAll(((MultiValueSet) r104).getAllItems());
            goto L4
        }

        public void addSurface(DeferrableSurface r100) {
            this.mSurfaces.add(r100);
        }

        public Object getTag(String r100) {
            return this.mMutableTagBundle.getTag(r100);
        }

        public boolean removeCameraCaptureCallback(CameraCaptureCallback r100) {
            return this.mCameraCaptureCallbacks.remove(r100);
        }

        public void removeSurface(DeferrableSurface r100) {
            this.mSurfaces.remove(r100);
        }

        public void setCameraCaptureResult(CameraCaptureResult r100) {
            this.mCameraCaptureResult = r100;
        }

        public void setExpectedFrameRateRange(Range<Integer> r100) {
            addImplementationOption(CaptureConfig.access$000(), r100);
        }

        public void setId(int r100) {
            this.mMutableTagBundle.putTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY, Integer.valueOf(r100));
        }

        public void setImplementationOptions(Config r100) {
            this.mImplementationOptions = MutableOptionsBundle.from(r100);
        }

        public void setPostviewEnabled(boolean r100) {
            this.mPostviewEnabled = r100;
        }

        public void setPreviewStabilization(int r100) {
            if (r100 == 0) goto L5;
            addImplementationOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(r100));
            return;
        }

        public void setTemplateType(int r100) {
            this.mTemplateType = r100;
        }

        public void setUseRepeatingSurface(boolean r100) {
            this.mUseRepeatingSurface = r100;
        }

        public void setVideoStabilization(int r100) {
            if (r100 == 0) goto L5;
            addImplementationOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(r100));
            return;
        }

        public <T> void addImplementationOption(Config.Option<T> r100, T r101) {
            this.mImplementationOptions.insertOption(r100, r101);
        }

        public void addTag(String r100, Object r101) {
            this.mMutableTagBundle.putTag(r100, r101);
        }
    }

    public interface OptionUnpacker {
        void unpack(UseCaseConfig<?> r100, Builder r101);
    }

    static {
        OPTION_ROTATION = Config.Option.create("camerax.core.captureConfig.rotation", Integer.TYPE);
        OPTION_JPEG_QUALITY = Config.Option.create("camerax.core.captureConfig.jpegQuality", Integer.class);
        OPTION_RESOLVED_FRAME_RATE = Config.Option.create("camerax.core.captureConfig.resolvedFrameRate", Range.class);
    }

    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    public Range<Integer> getExpectedFrameRateRange() {
        Range<Integer> r100 = (Range) this.mImplementationOptions.retrieveOption(OPTION_RESOLVED_FRAME_RATE, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        Objects.requireNonNull(r100);
        return r100;
    }

    public int getId() {
        Object r100 = this.mTagBundle.getTag(CAPTURE_CONFIG_ID_TAG_KEY);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return ((Integer) r100).intValue();
    }

    public int getPreviewStabilizationMode() {
        Integer r100 = (Integer) this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0);
        Objects.requireNonNull(r100);
        return r100.intValue();
    }

    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public int getVideoStabilizationMode() {
        Integer r100 = (Integer) this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0);
        Objects.requireNonNull(r100);
        return r100.intValue();
    }

    public static /* synthetic */ Config.Option access$000() {
        return OPTION_RESOLVED_FRAME_RATE;
    }

    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isPostviewEnabled() {
        return this.mPostviewEnabled;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public CaptureConfig(List<DeferrableSurface> r100, Config r101, int r102, boolean r103, List<CameraCaptureCallback> r104, boolean r105, TagBundle r106, CameraCaptureResult r107) {
        this.mSurfaces = r100;
        this.mImplementationOptions = r101;
        this.mTemplateType = r102;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(r104);
        this.mUseRepeatingSurface = r105;
        this.mTagBundle = r106;
        this.mCameraCaptureResult = r107;
        this.mPostviewEnabled = r103;
    }
}
