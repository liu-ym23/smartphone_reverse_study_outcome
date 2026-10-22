package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0001H'¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0001H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "", "itemCount", "", "getItemCount", "()I", "Item", "", "index", "key", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "getIndex", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyLayoutItemProvider {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getContentType(LazyLayoutItemProvider r100, int r101) {
            return null;
        }

        public static int $default$getIndex(LazyLayoutItemProvider r100, Object r101) {
            return -1;
        }

        public static Object $default$getKey(LazyLayoutItemProvider r100, int r101) {
            return Lazy_androidKt.getDefaultLazyLayoutKey(r101);
        }
    }

    void Item(int r100, Object r101, Composer r102, int r103);

    Object getContentType(int r100);

    int getIndex(Object r100);

    int getItemCount();

    Object getKey(int r100);
}
