package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import sb.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerController;", "", "Lsb/b;", "dataSource", "", "start", "(Lsb/b;)V", "pause", "()V", "resume", "stop", "reset", "release", "", "visibility", "setVisibility", "(I)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;", "playerAction", "setPlayerAction", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IMonitor;", "monitor", "setMonitor", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IMonitor;)V", "Landroid/view/ViewGroup;", "parentView", "attachAlphaView", "(Landroid/view/ViewGroup;)V", "detachAlphaView", "Landroid/view/View;", "getView", "()Landroid/view/View;", "", "getPlayerType", "()Ljava/lang/String;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerController {
    void attachAlphaView(@NotNull ViewGroup r10);

    void detachAlphaView(@NotNull ViewGroup r10);

    @NotNull
    String getPlayerType();

    @NotNull
    View getView();

    void pause();

    void release();

    void reset();

    void resume();

    void setMonitor(@NotNull IMonitor r10);

    void setPlayerAction(@NotNull IPlayerAction r10);

    void setVisibility(int r10);

    void start(@NotNull b r10);

    void stop();
}
