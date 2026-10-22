package androidx.compose.ui.graphics.vector;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002By\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020 H\u0086\u0002J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&H\u0096\u0002J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020 H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorGroup;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "", "name", "", "rotation", "", "pivotX", "pivotY", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "<init>", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getRotation", "()F", "getPivotX", "getPivotY", "getScaleX", "getScaleY", "getTranslationX", "getTranslationY", "getClipPathData", "()Ljava/util/List;", "size", "", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "index", "iterator", "", "equals", "", "other", "", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorGroup extends VectorNode implements Iterable<VectorNode>, KMappedMarker {
    public static final int $stable = 0;
    private final List<VectorNode> children;
    private final List<PathNode> clipPathData;
    private final String name;
    private final float pivotX;
    private final float pivotY;
    private final float rotation;
    private final float scaleX;
    private final float scaleY;
    private final float translationX;
    private final float translationY;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorGroup$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"androidx/compose/ui/graphics/vector/VectorGroup$iterator$1", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "it", "getIt", "()Ljava/util/Iterator;", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<VectorNode>, KMappedMarker {
        private final Iterator<VectorNode> it;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public VectorNode next() {
            return this.it.next();
        }

        public final Iterator<VectorNode> getIt() {
            return this.it;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ VectorNode next() {
            return next();
        }

        public AnonymousClass1(VectorGroup r100) {
            this.it = VectorGroup.access$getChildren$p(r100).iterator();
        }
    }

    public VectorGroup() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
    }

    public final int getSize() {
        return this.children.size();
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + Float.floatToIntBits(this.rotation)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + this.clipPathData.hashCode()) * 31) + this.children.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<VectorNode> iterator() {
        return new AnonymousClass1(this);
    }

    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public static final /* synthetic */ List access$getChildren$p(VectorGroup r100) {
        return r100.children;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L62:
        return false;
    L8:
        if ((r100 instanceof VectorGroup) == false) goto L62;
        VectorGroup r101 = (VectorGroup) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (this.rotation != r101.rotation) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L20;
        return false;
    L20:
        if (this.pivotX != r101.pivotX) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == true) goto L26;
        return false;
    L26:
        if (this.pivotY != r101.pivotY) goto L28;
        boolean r104 = true;
    L29:
        if (r104 == true) goto L32;
        return false;
    L32:
        if (this.scaleX != r101.scaleX) goto L34;
        boolean r105 = true;
    L35:
        if (r105 == true) goto L38;
        return false;
    L38:
        if (this.scaleY != r101.scaleY) goto L40;
        boolean r106 = true;
    L41:
        if (r106 == true) goto L44;
        return false;
    L44:
        if (this.translationX != r101.translationX) goto L46;
        boolean r107 = true;
    L47:
        if (r107 == true) goto L50;
        return false;
    L50:
        if (this.translationY != r101.translationY) goto L52;
        boolean r108 = true;
    L53:
        if (r108 == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.clipPathData, r101.clipPathData) == true) goto L59;
        return false;
    L59:
        if (Intrinsics.areEqual(this.children, r101.children) == true) goto L61;
        return false;
    L61:
        return true;
    L52:
        r108 = false;
        goto L53
    L46:
        r107 = false;
        goto L47
    L40:
        r106 = false;
        goto L41
    L34:
        r105 = false;
        goto L35
    L28:
        r104 = false;
        goto L29
    L22:
        r103 = false;
        goto L23
    L16:
        r102 = false;
        goto L17
    }

    public final VectorNode get(int r100) {
        return (VectorNode) ListProtector.get(this.children, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VectorGroup(String r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, List<? extends PathNode> r110, List<? extends VectorNode> r111) {
        super(null);
        this.name = r100;
        this.rotation = r101;
        this.pivotX = r102;
        this.pivotY = r103;
        this.scaleX = r104;
        this.scaleY = r105;
        this.translationX = r106;
        this.translationY = r107;
        this.clipPathData = r110;
        this.children = r111;
    }

    public /* synthetic */ VectorGroup(String r110, float r111, float r112, float r113, float r114, float r115, float r116, float r117, List r118, List r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        float r101 = 0.0f;
        if ((r211 & 2) == 0) goto L9;
        float r102 = 0.0f;
    L11:
        if ((r211 & 4) == 0) goto L13;
        float r103 = 0.0f;
    L15:
        if ((r211 & 8) == 0) goto L17;
        float r104 = 0.0f;
    L18:
        float r105 = 1.0f;
        if ((r211 & 16) == 0) goto L21;
        float r106 = 1.0f;
    L23:
        if ((r211 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r211 & 64) == 0) goto L29;
        float r107 = 0.0f;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r101 = r117;
    L35:
        if ((r211 & 256) == 0) goto L37;
        List r108 = VectorKt.getEmptyPath();
    L39:
        if ((r211 & 512) == 0) goto L41;
        List r109 = CollectionsKt.emptyList();
    L42:
        this(r100, r102, r103, r104, r106, r105, r107, r101, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
