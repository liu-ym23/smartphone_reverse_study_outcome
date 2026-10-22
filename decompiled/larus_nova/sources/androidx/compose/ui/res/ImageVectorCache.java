package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0086\u0002J\u0006\u0010\u0012\u001a\u00020\rR6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "Landroidx/compose/ui/res/ImageVectorCache$Key;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "Lkotlin/collections/HashMap;", MonitorConstants.CONNECT_TYPE_GET, "key", "prune", "", "configChanges", "", "set", "imageVectorEntry", "clear", "Key", "ImageVectorEntry", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageVectorCache {
    public static final int $stable = 8;
    private final HashMap<Key, WeakReference<ImageVectorEntry>> map;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "configFlags", "", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;I)V", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getConfigFlags", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ImageVectorEntry {
        public static final int $stable = 0;
        private final int configFlags;
        private final ImageVector imageVector;

        public static /* synthetic */ ImageVectorEntry copy$default(ImageVectorEntry r100, ImageVector r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.imageVector;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.configFlags;
        L9:
            return r100.copy(r101, r102);
        }

        public final ImageVector component1() {
            return this.imageVector;
        }

        public final int component2() {
            return this.configFlags;
        }

        public final ImageVectorEntry copy(ImageVector r100, int r101) {
            return new ImageVectorEntry(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ImageVectorEntry) == true) goto L8;
            return false;
        L8:
            ImageVectorEntry r101 = (ImageVectorEntry) r100;
            if (Intrinsics.areEqual(this.imageVector, r101.imageVector) == true) goto L12;
            return false;
        L12:
            if (this.configFlags == r101.configFlags) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.imageVector.hashCode() * 31) + this.configFlags;
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.imageVector + ", configFlags=" + this.configFlags + ')';
        }

        public final int getConfigFlags() {
            return this.configFlags;
        }

        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public ImageVectorEntry(ImageVector r100, int r101) {
            this.imageVector = r100;
            this.configFlags = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00060\u0003R\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache$Key;", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "id", "", "<init>", "(Landroid/content/res/Resources$Theme;I)V", "getTheme", "()Landroid/content/res/Resources$Theme;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key {
        public static final int $stable = 8;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f15278id;
        private final Resources.Theme theme;

        public static /* synthetic */ Key copy$default(Key r100, Resources.Theme r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.theme;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f15278id;
        L9:
            return r100.copy(r101, r102);
        }

        public final Resources.Theme component1() {
            return this.theme;
        }

        public final int component2() {
            return this.f15278id;
        }

        public final Key copy(Resources.Theme r100, int r101) {
            return new Key(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Key) == true) goto L8;
            return false;
        L8:
            Key r101 = (Key) r100;
            if (Intrinsics.areEqual(this.theme, r101.theme) == true) goto L12;
            return false;
        L12:
            if (this.f15278id == r101.f15278id) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.theme.hashCode() * 31) + this.f15278id;
        }

        public String toString() {
            return "Key(theme=" + this.theme + ", id=" + this.f15278id + ')';
        }

        public final int getId() {
            return this.f15278id;
        }

        public final Resources.Theme getTheme() {
            return this.theme;
        }

        public Key(Resources.Theme r100, int r101) {
            this.theme = r100;
            this.f15278id = r101;
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public ImageVectorCache() {
        this.map = new HashMap();
    }

    public final ImageVectorEntry get(Key r100) {
        WeakReference<ImageVectorEntry> r101 = this.map.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }

    public final void prune(int r100) {
        Iterator<Map.Entry<Key, WeakReference<ImageVectorEntry>>> r101 = this.map.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        ImageVectorEntry r102 = r101.next().getValue().get();
        if (r102 == null) goto L9;
        if (Configuration.needNewResources(r100, r102.getConfigFlags()) == false) goto L4;
    L9:
        r101.remove();
        goto L4
    }

    public final void set(Key r100, ImageVectorEntry r101) {
        this.map.put(r100, new WeakReference(r101));
    }
}
