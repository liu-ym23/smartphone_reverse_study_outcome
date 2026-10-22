package androidx.compose.ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0011J,\u0010\u0012\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00132\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00032\u0006\u0010\b\u001a\u0002H\u0013H\u0090\u0002¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003H\u0090\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0090\u0002¢\u0006\u0002\b\u001bR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/modifier/SingleLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "<init>", "(Landroidx/compose/ui/modifier/ModifierLocal;)V", "<set-?>", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "forceValue", "", "forceValue$ui_release", "set", ExifInterface.GPS_DIRECTION_TRUE, "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", MonitorConstants.CONNECT_TYPE_GET, "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "contains", "", "contains$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SingleLocalMap extends ModifierLocalMap {
    public static final int $stable = 0;
    private final ModifierLocal<?> key;
    private final MutableState value$delegate;

    private final Object getValue() {
        return this.value$delegate.getValue();
    }

    public SingleLocalMap(ModifierLocal<?> r100) {
        super(null);
        this.key = r100;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final void setValue(Object r100) {
        this.value$delegate.setValue(r100);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal<?> r100) {
        if (r100 != this.key) goto L5;
        return true;
    L5:
        return false;
    }

    public final void forceValue$ui_release(Object r100) {
        setValue(r100);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(ModifierLocal<T> r100) {
        if (r100 != this.key) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("Check failed.");
    L8:
        T r102 = (T) getValue();
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo6392set$ui_release(ModifierLocal<T> r100, T r101) {
        if (r100 != this.key) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("Check failed.");
    L8:
        setValue(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }
}
