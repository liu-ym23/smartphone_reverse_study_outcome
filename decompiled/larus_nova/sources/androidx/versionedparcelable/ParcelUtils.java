package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    public static <T extends VersionedParcelable> T fromInputStream(InputStream r100) {
        return (T) new VersionedParcelStream(r100, null).readVersionedParcelable();
    }

    public static <T extends VersionedParcelable> T fromParcelable(Parcelable r100) {
        if ((r100 instanceof ParcelImpl) == false) goto L7;
        return (T) ((ParcelImpl) r100).getVersionedParcel();
    L7:
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static Parcelable toParcelable(VersionedParcelable r100) {
        return new ParcelImpl(r100);
    }

    public static <T extends VersionedParcelable> T getVersionedParcelable(Bundle r100, String r101) {
        Bundle r102 = (Bundle) r100.getParcelable(r101);     // Catch: RuntimeException -> L8
        if (r102 != null) goto L6;
        return null;
    L6:
        r102.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L8
        return (T) fromParcelable(r102.getParcelable("a"));
    L8:
        return null;
    }

    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle r100, String r101) {
        ArrayList r102 = new ArrayList();
        Bundle r103 = (Bundle) r100.getParcelable(r101);     // Catch: RuntimeException -> L9
        r103.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L9
        Iterator r104 = r103.getParcelableArrayList("a").iterator();     // Catch: RuntimeException -> L9
    L5:
        if (r104.hasNext() == false) goto L8;
        r102.add(fromParcelable((Parcelable) r104.next()));     // Catch: RuntimeException -> L9
        goto L5
    L8:
        return r102;
    L9:
        return null;
    }

    public static void toOutputStream(VersionedParcelable r100, OutputStream r101) {
        VersionedParcelStream r102 = new VersionedParcelStream(null, r101);
        r102.writeVersionedParcelable(r100);
        r102.closeField();
    }

    public static void putVersionedParcelable(Bundle r100, String r101, VersionedParcelable r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        Bundle r103 = new Bundle();
        r103.putParcelable("a", toParcelable(r102));
        r100.putParcelable(r101, r103);
    }

    public static void putVersionedParcelableList(Bundle r100, String r101, List<? extends VersionedParcelable> r102) {
        Bundle r103 = new Bundle();
        ArrayList<? extends Parcelable> r104 = new ArrayList();
        Iterator<? extends VersionedParcelable> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(toParcelable(r105.next()));
        goto L4
    L6:
        r103.putParcelableArrayList("a", r104);
        r100.putParcelable(r101, r103);
    }
}
