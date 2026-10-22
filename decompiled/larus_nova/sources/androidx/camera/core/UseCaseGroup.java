package androidx.camera.core;

import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class UseCaseGroup {
    private final List<CameraEffect> mEffects;
    private final List<UseCase> mUseCases;
    private final ViewPort mViewPort;

    public static final class Builder {
        private static final List<Integer> SUPPORTED_TARGETS = null;
        private final List<CameraEffect> mEffects;
        private final List<UseCase> mUseCases;
        private ViewPort mViewPort;

        static {
            SUPPORTED_TARGETS = Arrays.asList(new Integer[]{1, 2, 4, 3, 7});
        }

        private void checkEffectTargets() {
            Iterator<CameraEffect> r100 = this.mEffects.iterator();
            int r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L10;
            int r102 = r100.next().getTargets();
            TargetUtils.checkSupportedTargets(SUPPORTED_TARGETS, r102);
            int r103 = r101 & r102;
            if (r103 > 0) goto L9;
            r101 = r101 | r102;
            goto L4
        L9:
            throw new IllegalArgumentException(String.format(Locale.US, "More than one effects has targets %s.", new Object[]{TargetUtils.getHumanReadableName(r103)}));
        }

        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            checkEffectTargets();
            return new UseCaseGroup(this.mViewPort, this.mUseCases, this.mEffects);
        }

        public Builder() {
            this.mUseCases = new ArrayList();
            this.mEffects = new ArrayList();
        }

        public Builder addEffect(CameraEffect r100) {
            this.mEffects.add(r100);
            return this;
        }

        public Builder addUseCase(UseCase r100) {
            this.mUseCases.add(r100);
            return this;
        }

        public Builder setViewPort(ViewPort r100) {
            this.mViewPort = r100;
            return this;
        }
    }

    public List<CameraEffect> getEffects() {
        return this.mEffects;
    }

    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }

    public UseCaseGroup(ViewPort r100, List<UseCase> r101, List<CameraEffect> r102) {
        this.mViewPort = r100;
        this.mUseCases = r101;
        this.mEffects = r102;
    }
}
