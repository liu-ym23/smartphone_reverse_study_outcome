package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0000¨\u0006\u000b"}, d2 = {"areObjectsOfSameType", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "b", "classKeyForObject", "tryPopulateReflectively", "", "Landroidx/compose/ui/platform/InspectorInfo;", "element", "Landroidx/compose/ui/node/ModifierNodeElement;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Actual_jvmKt {
    public static final Object classKeyForObject(Object r100) {
        return r100.getClass();
    }

    public static final boolean areObjectsOfSameType(Object r100, Object r101) {
        if (r100.getClass() != r101.getClass()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void tryPopulateReflectively(InspectorInfo r100, ModifierNodeElement<?> r101) {
        List r102 = ArraysKt.sortedWith(r101.getClass().getDeclaredFields(), new Actual_jvmKt$tryPopulateReflectively$$inlined$sortedBy$1());
        int r103 = r102.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        Field r105 = (Field) ListProtector.get(r102, r104);
        if (r105.getDeclaringClass().isAssignableFrom(ModifierNodeElement.class) == true) goto L8;
        r105.setAccessible(true);     // Catch: Throwable -> L10
        r100.getProperties().set(r105.getName(), r105.get(r101));     // Catch: Throwable -> L10
    L8:
        r104 = r104 + 1;
        goto L3
    }
}
