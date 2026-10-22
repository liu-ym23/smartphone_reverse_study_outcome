package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    Disposable observerKtvOrderedSongListChange(LifecycleOwner r100, boolean r101, Consumer<List<MusicPanel>> r102);
}
