package com.bytedance.android.livesdk.interactivity.api.comment.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.layer.core.data.TetrisViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/KeyboardViewModel;", "Lcom/bytedance/android/live/core/tetris/layer/core/data/TetrisViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/KeyboardViewModel$a;", "keyboardData", "Landroidx/lifecycle/MutableLiveData;", "getKeyboardData", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyboardViewModel extends TetrisViewModel {
    private final MutableLiveData<a> keyboardData;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f133033a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (this.f133033a == ((a) r100).f133033a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f133033a;
        }

        public final String toString() {
            return "LiveInputData(offset=" + this.f133033a + ")";
        }

        public a(int r100) {
            this.f133033a = r100;
        }
    }

    public KeyboardViewModel() {
        this.keyboardData = new MutableLiveData();
    }

    public final MutableLiveData<a> getKeyboardData() {
        return this.keyboardData;
    }
}
