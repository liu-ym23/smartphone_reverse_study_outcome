package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ Disposable a(OrderedSongDataContext r100, LifecycleOwner r101, Consumer r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.observerKtvSongUniqueInfoListChange(r101, false, r102);
        }
    }

    Disposable observerKtvSongUniqueInfoListChange(LifecycleOwner r100, boolean r101, Consumer<List<SongUniqueInfo>> r102);
}
