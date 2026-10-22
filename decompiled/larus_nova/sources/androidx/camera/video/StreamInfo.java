package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StreamInfo {
    static final Observable<StreamInfo> ALWAYS_ACTIVE_OBSERVABLE = null;
    static final Set<Integer> NON_SURFACE_STREAM_ID = null;
    static final int STREAM_ID_ANY = 0;
    static final int STREAM_ID_ERROR = -1;
    static final StreamInfo STREAM_INFO_ANY_INACTIVE = null;

    public static final enum StreamState extends Enum<StreamState> {
        private static final /* synthetic */ StreamState[] $VALUES = null;
        public static final StreamState ACTIVE = null;
        public static final StreamState INACTIVE = null;

        private static /* synthetic */ StreamState[] $values() {
            return new StreamState[]{ACTIVE, INACTIVE};
        }

        static {
            ACTIVE = new StreamState("ACTIVE", 0);
            INACTIVE = new StreamState("INACTIVE", 1);
            $VALUES = $values();
        }

        public static StreamState[] values() {
            return (StreamState[]) $VALUES.clone();
        }

        public static StreamState valueOf(String r100) {
            return (StreamState) r27.a.a(StreamState.class, r100);
        }

        private StreamState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract int getId();

    public abstract SurfaceRequest.TransformationInfo getInProgressTransformationInfo();

    public abstract StreamState getStreamState();

    static {
        STREAM_INFO_ANY_INACTIVE = of(0, StreamState.INACTIVE);
        NON_SURFACE_STREAM_ID = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{0, -1})));
        ALWAYS_ACTIVE_OBSERVABLE = ConstantObservable.withValue(of(0, StreamState.ACTIVE));
    }

    public StreamInfo() {
    }

    public static StreamInfo of(int r100, StreamState r101) {
        return new AutoValue_StreamInfo(r100, r101, null);
    }

    public static StreamInfo of(int r100, StreamState r101, SurfaceRequest.TransformationInfo r102) {
        return new AutoValue_StreamInfo(r100, r101, r102);
    }
}
