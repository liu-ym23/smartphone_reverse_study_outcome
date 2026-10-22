package com.obric.common.oea.style.scene.alpha;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.Configuration;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlphaView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\"\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "getListener", "()Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "setListener", "(Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;)V", "playerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "findLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getController", "getStatus", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "onAttachedToWindow", "", "onDetachedFromWindow", "pause", "release", "resume", "start", "file", "Ljava/io/File;", "loop", "", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "AlphaPlayerListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaView extends FrameLayout {
    private AlphaPlayerListener listener;
    private PlayerController playerController;

    /* JADX INFO: compiled from: AlphaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/AlphaView$AlphaPlayerListener;", "", "onEnd", "", "onStart", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface AlphaPlayerListener {
        void onEnd();

        void onStart();

        void onVideoSizeChanged(int r1, int r2);
    }

    public AlphaView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public AlphaView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public /* synthetic */ AlphaView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AlphaView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final AlphaPlayerListener getListener() {
        return this.listener;
    }

    public final void setListener(AlphaPlayerListener r1) {
        this.listener = r1;
    }

    private final PlayerController getController() {
        if (this.playerController != null) goto L9;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        LifecycleOwner r1 = findLifecycleOwner(r0);
        if (r1 == null) goto L8;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        Configuration r2 = new Configuration(r3, r1);
        r2.setAlphaVideoViewType(AlphaVideoViewType.GL_TEXTURE_VIEW);
        PlayerController r4 = new PlayerController(r2, null, 2, null);
        r4.setPlayerAction(new AlphaView$getController$$inlined$apply$lambda$1(this));
        Unit r5 = Unit.INSTANCE;
        this.playerController = r4;
        goto L9
    L8:
        throw new IllegalStateException("AlphaView must be attached to a LifecycleOwner (Activity or Fragment).");
    L9:
        PlayerController r6 = this.playerController;
        Intrinsics.checkNotNull(r6);
        return r6;
    }

    private final LifecycleOwner findLifecycleOwner(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof LifecycleOwner) == true) goto L7;
        Context r2 = ((ContextWrapper) r1).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(r2, "currentContext.baseContext");
        Object r3 = r2;
        goto L3
    L7:
        return (LifecycleOwner) r3;
    L9:
        return null;
    }

    public static /* synthetic */ void start$default(AlphaView r0, File r1, boolean r2, ScaleType r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = ScaleType.ScaleAspectFitCenter;
    L8:
        r0.start(r1, r2, r3);
    }

    public final void start(File r4, boolean r5, ScaleType r6) {
        Intrinsics.checkNotNullParameter(r4, "file");
        Intrinsics.checkNotNullParameter(r6, "scaleType");
        File r0 = r4.getParentFile();
        if (r0 == null) goto L9;
        DataSource r1 = new DataSource();
        String r2 = r0.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r2, "parent.absolutePath");
        DataSource r3 = r1.setBaseDir(r2);
        String r7 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "file.name");
        DataSource r8 = r3.setPortraitPath(r7, r6);
        String r9 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "file.name");
        DataSource r10 = r8.setLandscapePath(r9, r6).setLooping(r5);
        if (r10.isValid() == true) goto L7;
        return;
    L7:
        getController().start(r10);
        return;
    }

    public final void pause() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public final void resume() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L6;
        r0.resume();
        return;
    }

    public final void release() {
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        PlayerController r1 = (PlayerController) null;
        this.playerController = null;
    }

    public final PlayerState getStatus() {
        PlayerController r0 = this.playerController;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStatus();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getController().attachAlphaView(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayerController r0 = this.playerController;
        if (r0 == null) goto L5;
        r0.detachAlphaView(this);
    L5:
        release();
    }
}
