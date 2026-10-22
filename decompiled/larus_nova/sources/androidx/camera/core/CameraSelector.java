package androidx.camera.core;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import androidx.core.util.Preconditions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA = null;
    public static final CameraSelector DEFAULT_FRONT_CAMERA = null;
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_EXTERNAL = 2;
    public static final int LENS_FACING_FRONT = 0;
    public static final int LENS_FACING_UNKNOWN = -1;
    private final LinkedHashSet<CameraFilter> mCameraFilterSet;
    private final String mPhysicalCameraId;

    public static final class Builder {
        private final LinkedHashSet<CameraFilter> mCameraFilterSet;
        private String mPhysicalCameraId;

        public CameraSelector build() {
            return new CameraSelector(this.mCameraFilterSet, this.mPhysicalCameraId);
        }

        public Builder() {
            this.mCameraFilterSet = new LinkedHashSet();
        }

        private Builder(LinkedHashSet<CameraFilter> r100) {
            this.mCameraFilterSet = new LinkedHashSet(r100);
        }

        public static Builder fromSelector(CameraSelector r100) {
            return new Builder(r100.getCameraFilterSet());
        }

        public Builder addCameraFilter(CameraFilter r100) {
            this.mCameraFilterSet.add(r100);
            return this;
        }

        public Builder requireLensFacing(int r100) {
            if (r100 == (-1)) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkState(r101, "The specified lens facing is invalid.");
            this.mCameraFilterSet.add(new LensFacingCameraFilter(r100));
            return this;
        L5:
            r101 = false;
            goto L6
        }

        public Builder setPhysicalCameraId(String r100) {
            this.mPhysicalCameraId = r100;
            return this;
        }
    }

    @Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LensFacing {
    }

    static {
        DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();
        DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();
    }

    public Integer getLensFacing() {
        Iterator<CameraFilter> r100 = this.mCameraFilterSet.iterator();
        Integer r101 = null;
    L4:
        if (r100.hasNext() == false) goto L15;
        CameraFilter r102 = r100.next();
        if ((r102 instanceof LensFacingCameraFilter) == false) goto L4;
        Integer r103 = Integer.valueOf(((LensFacingCameraFilter) r102).getLensFacing());
        if (r101 == null) goto L9;
        if (r101.equals(r103) == true) goto L4;
        throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
    L9:
        r101 = r103;
        goto L4
    L15:
        return r101;
    }

    public LinkedHashSet<CameraFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    public LinkedHashSet<CameraInternal> filter(LinkedHashSet<CameraInternal> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<CameraInternal> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getCameraInfo());
        goto L4
    L6:
        List<CameraInfo> r103 = filter(r101);
        LinkedHashSet<CameraInternal> r104 = new LinkedHashSet();
        Iterator<CameraInternal> r105 = r100.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        CameraInternal r106 = r105.next();
        if (r103.contains(r106.getCameraInfo()) == false) goto L8;
        r104.add(r106);
        goto L8
    L12:
        return r104;
    }

    public CameraInternal select(LinkedHashSet<CameraInternal> r100) {
        Iterator<CameraInternal> r101 = filter(r100).iterator();
        if (r101.hasNext() == false) goto L7;
        return r101.next();
    L7:
        throw new IllegalArgumentException("No available camera can be found");
    }

    public List<CameraInfo> filter(List<CameraInfo> r100) {
        List<CameraInfo> r101 = new ArrayList(r100);
        Iterator<CameraFilter> r102 = this.mCameraFilterSet.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101 = r102.next().filter(Collections.unmodifiableList(r101));
        goto L4
    L6:
        r101.retainAll(r100);
        return r101;
    }

    public CameraSelector(LinkedHashSet<CameraFilter> r100, String r101) {
        this.mCameraFilterSet = r100;
        this.mPhysicalCameraId = r101;
    }
}
