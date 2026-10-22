package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Disposable a(OrderedSongDataContext r100, boolean r101, Consumer r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = false;
        L6:
            return r100.observerKtvSingSongListChange(null, r101, r102);
        }
    }

    Disposable observerKtvSingSongListChange(LifecycleOwner r100, boolean r101, Consumer<List<MusicPanel>> r102);
}
