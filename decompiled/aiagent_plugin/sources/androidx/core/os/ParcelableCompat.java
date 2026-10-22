package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ParcelableCompat {

    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final m<T> mCallbacks;

        ParcelableCompatCreatorHoneycombMR2(m<T> r3) {
            this.mCallbacks = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel r2) {
            return this.mCallbacks.a(r2, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel r1, ClassLoader r2) {
            return this.mCallbacks.a(r1, r2);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int r1) {
            return this.mCallbacks.a(r1);
        }
    }
}
