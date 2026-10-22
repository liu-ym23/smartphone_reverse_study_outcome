package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = null;
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private boolean cacheComposition;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private LottieListener<Throwable> failureListener;
    private int fallbackResource;
    private boolean ignoreUnschedule;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private final Set<UserActionTaken> userActionsTaken;
    private final LottieListener<Throwable> wrappedFailureListener;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private SavedState(Parcel r3) {
            super(r3);
            this.animationName = r3.readString();
            this.progress = r3.readFloat();
            boolean r1 = true;
            if (r3.readInt() == 1) goto L6;
            r1 = false;
        L6:
            this.isAnimating = r1;
            this.imageAssetsFolder = r3.readString();
            this.repeatMode = r3.readInt();
            this.repeatCount = r3.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.animationName);
            r1.writeFloat(this.progress);
            r1.writeInt(this.isAnimating ? 1 : 0);
            r1.writeString(this.imageAssetsFolder);
            r1.writeInt(this.repeatMode);
            r1.writeInt(this.repeatCount);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static final enum UserActionTaken extends Enum<UserActionTaken> {
        private static final /* synthetic */ UserActionTaken[] $VALUES = null;
        public static final UserActionTaken PLAY_OPTION = null;
        public static final UserActionTaken SET_ANIMATION = null;
        public static final UserActionTaken SET_IMAGE_ASSETS = null;
        public static final UserActionTaken SET_PROGRESS = null;
        public static final UserActionTaken SET_REPEAT_COUNT = null;
        public static final UserActionTaken SET_REPEAT_MODE = null;

        private static /* synthetic */ UserActionTaken[] $values() {
            return new UserActionTaken[]{SET_ANIMATION, SET_PROGRESS, SET_REPEAT_MODE, SET_REPEAT_COUNT, SET_IMAGE_ASSETS, PLAY_OPTION};
        }

        private UserActionTaken(String r1, int r2) {
            super(r1, r2);
        }

        public static UserActionTaken valueOf(String r1) {
            return (UserActionTaken) Enum.valueOf(UserActionTaken.class, r1);
        }

        public static UserActionTaken[] values() {
            return (UserActionTaken[]) $VALUES.clone();
        }

        static {
            SET_ANIMATION = new UserActionTaken("SET_ANIMATION", 0);
            SET_PROGRESS = new UserActionTaken("SET_PROGRESS", 1);
            SET_REPEAT_MODE = new UserActionTaken("SET_REPEAT_MODE", 2);
            SET_REPEAT_COUNT = new UserActionTaken("SET_REPEAT_COUNT", 3);
            SET_IMAGE_ASSETS = new UserActionTaken("SET_IMAGE_ASSETS", 4);
            PLAY_OPTION = new UserActionTaken("PLAY_OPTION", 5);
            $VALUES = $values();
        }
    }

    private static class WeakFailureListener implements LottieListener<Throwable> {
        private final WeakReference<LottieAnimationView> targetReference;

        @Override // com.airbnb.lottie.LottieListener
        public /* bridge */ /* synthetic */ void onResult(Throwable r1) {
            onResult2(r1);
        }

        public WeakFailureListener(LottieAnimationView r2) {
            this.targetReference = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(Throwable r2) {
            LottieAnimationView r1 = this.targetReference.get();
            if (r1 != null) goto L6;
            return;
        L6:
            if (LottieAnimationView.access$000(r1) == 0) goto L9;
            r1.setImageResource(LottieAnimationView.access$000(r1));
        L9:
            if (LottieAnimationView.access$100(r1) != null) goto L11;
            LottieListener r3 = LottieAnimationView.access$200();
        L12:
            r3.onResult(r2);
            return;
        L11:
            r3 = LottieAnimationView.access$100(r1);
            goto L12
        }
    }

    private static class WeakSuccessListener implements LottieListener<LottieComposition> {
        private final WeakReference<LottieAnimationView> targetReference;

        @Override // com.airbnb.lottie.LottieListener
        public /* bridge */ /* synthetic */ void onResult(LottieComposition r1) {
            onResult2(r1);
        }

        public WeakSuccessListener(LottieAnimationView r2) {
            this.targetReference = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(LottieComposition r1) {
            LottieAnimationView r0 = this.targetReference.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.setComposition(r1);
        }
    }

    static /* synthetic */ int access$000(LottieAnimationView r0) {
        return r0.fallbackResource;
    }

    static /* synthetic */ LottieListener access$100(LottieAnimationView r0) {
        return r0.failureListener;
    }

    static /* synthetic */ LottieListener access$200() {
        return DEFAULT_FAILURE_LISTENER;
    }

    static {
        DEFAULT_FAILURE_LISTENER = new LottieAnimationView$$ExternalSyntheticLambda1();
    }

    static /* synthetic */ void lambda$static$0(Throwable r2) {
        if (Utils.isNetworkException(r2) == false) goto L7;
        Logger.warning("Unable to load composition.", r2);
        return;
    L7:
        throw new IllegalStateException("Unable to parse composition", r2);
    }

    public LottieAnimationView(Context r2) {
        super(r2);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(r3, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.loadedListener = new WeakSuccessListener(this);
        this.wrappedFailureListener = new WeakFailureListener(this);
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(r3, r4);
    }

    private void init(AttributeSet r6, int r7) {
        boolean r2 = false;
        TypedArray r8 = getContext().obtainStyledAttributes(r6, R.styleable.LottieAnimationView, r7, 0);
        this.cacheComposition = r8.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean r9 = r8.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean r1 = r8.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean r3 = r8.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (r9 == false) goto L8;
        if (r1 == false) goto L8;
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    L8:
        if (r9 == false) goto L12;
        int r10 = r8.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
        if (r10 == 0) goto L20;
        setAnimation(r10);
    L20:
        setFallbackResource(r8.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (r8.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false) == false) goto L24;
        this.autoPlay = true;
    L24:
        if (r8.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false) == false) goto L27;
        this.lottieDrawable.setRepeatCount(-1);
    L27:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode) == false) goto L30;
        setRepeatMode(r8.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
    L30:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount) == false) goto L33;
        setRepeatCount(r8.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
    L33:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_speed) == false) goto L36;
        setSpeed(r8.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
    L36:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_clipToCompositionBounds) == false) goto L39;
        setClipToCompositionBounds(r8.getBoolean(R.styleable.LottieAnimationView_lottie_clipToCompositionBounds, true));
    L39:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_defaultFontFileExtension) == false) goto L41;
        setDefaultFontFileExtension(r8.getString(R.styleable.LottieAnimationView_lottie_defaultFontFileExtension));
    L41:
        setImageAssetsFolder(r8.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgressInternal(r8.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f), r8.hasValue(R.styleable.LottieAnimationView_lottie_progress));
        enableMergePathsForKitKatAndAbove(r8.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter) == false) goto L45;
        SimpleColorFilter r4 = new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), r8.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor());
        addValueCallback(new KeyPath(new String[]{"**"}), LottieProperty.COLOR_FILTER, new LottieValueCallback(r4));
    L45:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_renderMode) == false) goto L51;
        int r11 = r8.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
        if (r11 < RenderMode.values().length) goto L49;
        r11 = RenderMode.AUTOMATIC.ordinal();
    L49:
        setRenderMode(RenderMode.values()[r11]);
    L51:
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_asyncUpdates) == false) goto L56;
        int r12 = r8.getInt(R.styleable.LottieAnimationView_lottie_asyncUpdates, AsyncUpdates.AUTOMATIC.ordinal());
        if (r12 < RenderMode.values().length) goto L55;
        r12 = AsyncUpdates.AUTOMATIC.ordinal();
    L55:
        setAsyncUpdates(AsyncUpdates.values()[r12]);
    L56:
        setIgnoreDisabledSystemAnimations(r8.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (r8.hasValue(R.styleable.LottieAnimationView_lottie_useCompositionFrameRate) == false) goto L59;
        setUseCompositionFrameRate(r8.getBoolean(R.styleable.LottieAnimationView_lottie_useCompositionFrameRate, false));
    L59:
        r8.recycle();
        LottieDrawable r13 = this.lottieDrawable;
        if (Utils.getAnimationScale(getContext()) == 0.0f) goto L62;
        r2 = true;
    L62:
        r13.setSystemAnimationsAreEnabled(Boolean.valueOf(r2));
        return;
    L12:
        if (r1 == false) goto L16;
        String r14 = r8.getString(R.styleable.LottieAnimationView_lottie_fileName);
        if (r14 == null) goto L20;
        setAnimation(r14);
        goto L20
    L16:
        if (r3 == false) goto L20;
        String r15 = r8.getString(R.styleable.LottieAnimationView_lottie_url);
        if (r15 == null) goto L20;
        setAnimationFromUrl(r15);
        goto L20
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r1) {
        cancelLoaderTask();
        super.setImageResource(r1);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        cancelLoaderTask();
        super.setImageDrawable(r1);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        cancelLoaderTask();
        super.setImageBitmap(r1);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable r3) {
        if (this.ignoreUnschedule == true) goto L10;
        LottieDrawable r0 = this.lottieDrawable;
        if (r3 != r0) goto L10;
        if (r0.isAnimating() == false) goto L10;
        pauseAnimation();
    L16:
        super.unscheduleDrawable(r3);
        return;
    L10:
        if (this.ignoreUnschedule == true) goto L16;
        if ((r3 instanceof LottieDrawable) == false) goto L16;
        LottieDrawable r1 = (LottieDrawable) r3;
        if (r1.isAnimating() == false) goto L16;
        r1.pauseAnimation();
        goto L16
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable r0 = getDrawable();
        if ((r0 instanceof LottieDrawable) == true) goto L5;
        return;
    L5:
        if (((LottieDrawable) r0).getRenderMode() != RenderMode.SOFTWARE) goto L9;
        this.lottieDrawable.invalidateSelf();
        return;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r3) {
        Drawable r0 = getDrawable();
        LottieDrawable r1 = this.lottieDrawable;
        if (r0 != r1) goto L5;
        super.invalidateDrawable(r1);
        return;
    L5:
        super.invalidateDrawable(r3);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.animationName = this.animationName;
        r1.animationResId = this.animationResId;
        r1.progress = this.lottieDrawable.getProgress();
        r1.isAnimating = this.lottieDrawable.isAnimatingOrWillAnimateOnVisible();
        r1.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        r1.repeatMode = this.lottieDrawable.getRepeatMode();
        r1.repeatCount = this.lottieDrawable.getRepeatCount();
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        this.animationName = r4.animationName;
        if (this.userActionsTaken.contains(UserActionTaken.SET_ANIMATION) == false) goto L9;
    L11:
        this.animationResId = r4.animationResId;
        if (this.userActionsTaken.contains(UserActionTaken.SET_ANIMATION) == true) goto L17;
        int r0 = this.animationResId;
        if (r0 == 0) goto L17;
        setAnimation(r0);
    L17:
        if (this.userActionsTaken.contains(UserActionTaken.SET_PROGRESS) == true) goto L20;
        setProgressInternal(r4.progress, false);
    L20:
        if (this.userActionsTaken.contains(UserActionTaken.PLAY_OPTION) == true) goto L25;
        if (r4.isAnimating == false) goto L25;
        playAnimation();
    L25:
        if (this.userActionsTaken.contains(UserActionTaken.SET_IMAGE_ASSETS) == true) goto L28;
        setImageAssetsFolder(r4.imageAssetsFolder);
    L28:
        if (this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_MODE) == true) goto L31;
        setRepeatMode(r4.repeatMode);
    L31:
        if (this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_COUNT) == true) goto L34;
        setRepeatCount(r4.repeatCount);
        return;
    L34:
        return;
    L9:
        if (TextUtils.isEmpty(this.animationName) == true) goto L11;
        setAnimation(this.animationName);
        goto L11
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.autoPlay == false) goto L9;
        this.lottieDrawable.playAnimation();
        return;
    }

    public void setIgnoreDisabledSystemAnimations(boolean r1) {
        this.lottieDrawable.setIgnoreDisabledSystemAnimations(r1);
    }

    public void setUseCompositionFrameRate(boolean r1) {
        this.lottieDrawable.setUseCompositionFrameRate(r1);
    }

    public void enableMergePathsForKitKatAndAbove(boolean r1) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(r1);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    public void setClipToCompositionBounds(boolean r1) {
        this.lottieDrawable.setClipToCompositionBounds(r1);
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.getClipToCompositionBounds();
    }

    public void setCacheComposition(boolean r1) {
        this.cacheComposition = r1;
    }

    public void setOutlineMasksAndMattes(boolean r1) {
        this.lottieDrawable.setOutlineMasksAndMattes(r1);
    }

    public void setAnimation(int r2) {
        this.animationResId = r2;
        this.animationName = null;
        setCompositionTask(fromRawRes(r2));
    }

    private LottieTask<LottieComposition> fromRawRes(final int r3) {
        if (isInEditMode() == false) goto L7;
        return new LottieTask(new LottieAnimationView$$ExternalSyntheticLambda0(this, r3), true);
    L7:
        if (this.cacheComposition == false) goto L10;
        return LottieCompositionFactory.fromRawRes(getContext(), r3);
    L10:
        return LottieCompositionFactory.fromRawRes(getContext(), r3, null);
    }

    /* JADX INFO: renamed from: lambda$fromRawRes$1$com-airbnb-lottie-LottieAnimationView, reason: not valid java name */
    /* synthetic */ LottieResult m101lambda$fromRawRes$1$comairbnblottieLottieAnimationView(int r2) throws Exception {
        if (this.cacheComposition == false) goto L6;
        return LottieCompositionFactory.fromRawResSync(getContext(), r2);
    L6:
        return LottieCompositionFactory.fromRawResSync(getContext(), r2, null);
    }

    public void setAnimation(String r2) {
        this.animationName = r2;
        this.animationResId = 0;
        setCompositionTask(fromAssets(r2));
    }

    private LottieTask<LottieComposition> fromAssets(final String r3) {
        if (isInEditMode() == false) goto L7;
        return new LottieTask(new LottieAnimationView$$ExternalSyntheticLambda2(this, r3), true);
    L7:
        if (this.cacheComposition == false) goto L10;
        return LottieCompositionFactory.fromAsset(getContext(), r3);
    L10:
        return LottieCompositionFactory.fromAsset(getContext(), r3, null);
    }

    /* JADX INFO: renamed from: lambda$fromAssets$2$com-airbnb-lottie-LottieAnimationView, reason: not valid java name */
    /* synthetic */ LottieResult m100lambda$fromAssets$2$comairbnblottieLottieAnimationView(String r2) throws Exception {
        if (this.cacheComposition == false) goto L6;
        return LottieCompositionFactory.fromAssetSync(getContext(), r2);
    L6:
        return LottieCompositionFactory.fromAssetSync(getContext(), r2, null);
    }

    @Deprecated
    public void setAnimationFromJson(String r2) {
        setAnimationFromJson(r2, null);
    }

    public void setAnimationFromJson(String r2, String r3) {
        setAnimation(new ByteArrayInputStream(r2.getBytes()), r3);
    }

    public void setAnimation(InputStream r1, String r2) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(r1, r2));
    }

    public void setAnimationFromUrl(String r3) {
        if (this.cacheComposition == false) goto L5;
        LottieTask<LottieComposition> r4 = LottieCompositionFactory.fromUrl(getContext(), r3);
    L6:
        setCompositionTask(r4);
        return;
    L5:
        r4 = LottieCompositionFactory.fromUrl(getContext(), r3, null);
        goto L6
    }

    public void setAnimationFromUrl(String r2, String r3) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), r2, r3));
    }

    public void setFailureListener(LottieListener<Throwable> r1) {
        this.failureListener = r1;
    }

    public void setFallbackResource(int r1) {
        this.fallbackResource = r1;
    }

    private void setCompositionTask(LottieTask<LottieComposition> r3) {
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = r3.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> r0 = this.compositionTask;
        if (r0 == null) goto L6;
        r0.removeListener(this.loadedListener);
        this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        return;
    }

    public void setComposition(LottieComposition r4) {
        if (L.DBG == false) goto L5;
        Log.v(TAG, "Set Composition \n" + r4);
    L5:
        this.lottieDrawable.setCallback(this);
        this.composition = r4;
        this.ignoreUnschedule = true;
        boolean r0 = this.lottieDrawable.setComposition(r4);
        this.ignoreUnschedule = false;
        if (getDrawable() != this.lottieDrawable) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        if (r0 == true) goto L11;
        setLottieDrawable();
    L11:
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<LottieOnCompositionLoadedListener> r3 = this.lottieOnCompositionLoadedListeners.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r3.next().onCompositionLoaded(r4);
        goto L13
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.playAnimation();
    }

    public void resumeAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.resumeAnimation();
    }

    public void setMinFrame(int r1) {
        this.lottieDrawable.setMinFrame(r1);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float r1) {
        this.lottieDrawable.setMinProgress(r1);
    }

    public void setMaxFrame(int r1) {
        this.lottieDrawable.setMaxFrame(r1);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(float r1) {
        this.lottieDrawable.setMaxProgress(r1);
    }

    public void setMinFrame(String r1) {
        this.lottieDrawable.setMinFrame(r1);
    }

    public void setMaxFrame(String r1) {
        this.lottieDrawable.setMaxFrame(r1);
    }

    public void setMinAndMaxFrame(String r1) {
        this.lottieDrawable.setMinAndMaxFrame(r1);
    }

    public void setMinAndMaxFrame(String r1, String r2, boolean r3) {
        this.lottieDrawable.setMinAndMaxFrame(r1, r2, r3);
    }

    public void setMinAndMaxFrame(int r1, int r2) {
        this.lottieDrawable.setMinAndMaxFrame(r1, r2);
    }

    public void setMinAndMaxProgress(float r1, float r2) {
        this.lottieDrawable.setMinAndMaxProgress(r1, r2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float r1) {
        this.lottieDrawable.setSpeed(r1);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.lottieDrawable.addAnimatorUpdateListener(r1);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.lottieDrawable.removeAnimatorUpdateListener(r1);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener r1) {
        this.lottieDrawable.addAnimatorListener(r1);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r1) {
        this.lottieDrawable.removeAnimatorListener(r1);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener r1) {
        this.lottieDrawable.addAnimatorPauseListener(r1);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener r1) {
        this.lottieDrawable.removeAnimatorPauseListener(r1);
    }

    @Deprecated
    public void loop(boolean r1) {
        LottieDrawable r0 = this.lottieDrawable;
        if (r1 == false) goto L5;
        int r2 = -1;
    L6:
        r0.setRepeatCount(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setRepeatMode(int r3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.lottieDrawable.setRepeatMode(r3);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int r3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.lottieDrawable.setRepeatCount(r3);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String r1) {
        this.lottieDrawable.setImagesAssetsFolder(r1);
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public void setMaintainOriginalImageBounds(boolean r1) {
        this.lottieDrawable.setMaintainOriginalImageBounds(r1);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.getMaintainOriginalImageBounds();
    }

    public Bitmap updateBitmap(String r1, Bitmap r2) {
        return this.lottieDrawable.updateBitmap(r1, r2);
    }

    public void setImageAssetDelegate(ImageAssetDelegate r1) {
        this.lottieDrawable.setImageAssetDelegate(r1);
    }

    public void setDefaultFontFileExtension(String r1) {
        this.lottieDrawable.setDefaultFontFileExtension(r1);
    }

    public void setFontAssetDelegate(FontAssetDelegate r1) {
        this.lottieDrawable.setFontAssetDelegate(r1);
    }

    public void setFontMap(Map<String, Typeface> r1) {
        this.lottieDrawable.setFontMap(r1);
    }

    public void setTextDelegate(TextDelegate r1) {
        this.lottieDrawable.setTextDelegate(r1);
    }

    public List<KeyPath> resolveKeyPath(KeyPath r1) {
        return this.lottieDrawable.resolveKeyPath(r1);
    }

    public <T> void addValueCallback(KeyPath r1, T r2, LottieValueCallback<T> r3) {
        this.lottieDrawable.addValueCallback(r1, r2, r3);
    }

    public <T> void addValueCallback(KeyPath r3, T r4, final SimpleLottieValueCallback<T> r5) {
        this.lottieDrawable.addValueCallback(r3, r4, new AnonymousClass1(this, r5));
    }

    public void cancelAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.cancelAnimation();
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.lottieDrawable.pauseAnimation();
    }

    public void setFrame(int r1) {
        this.lottieDrawable.setFrame(r1);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(float r2) {
        setProgressInternal(r2, true);
    }

    private void setProgressInternal(float r2, boolean r3) {
        if (r3 == false) goto L4;
        this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
    L4:
        this.lottieDrawable.setProgress(r2);
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L7;
        return 0;
    L7:
        return (long) r2.getDuration();
    }

    public void setPerformanceTrackingEnabled(boolean r1) {
        this.lottieDrawable.setPerformanceTrackingEnabled(r1);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    public void setSafeMode(boolean r1) {
        this.lottieDrawable.setSafeMode(r1);
    }

    public void setRenderMode(RenderMode r1) {
        this.lottieDrawable.setRenderMode(r1);
    }

    public RenderMode getRenderMode() {
        return this.lottieDrawable.getRenderMode();
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.lottieDrawable.getAsyncUpdates();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.lottieDrawable.getAsyncUpdatesEnabled();
    }

    public void setAsyncUpdates(AsyncUpdates r1) {
        this.lottieDrawable.setAsyncUpdates(r1);
    }

    public void setApplyingOpacityToLayersEnabled(boolean r1) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(r1);
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener r2) {
        LottieComposition r0 = this.composition;
        if (r0 == null) goto L6;
        r2.onCompositionLoaded(r0);
    L6:
        return this.lottieOnCompositionLoadedListeners.add(r2);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener r1) {
        return this.lottieOnCompositionLoadedListeners.remove(r1);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    private void setLottieDrawable() {
        boolean r0 = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        if (r0 == false) goto L6;
        this.lottieDrawable.resumeAnimation();
        return;
    }
}
