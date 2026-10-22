package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\"@\u0010\u0010\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e0\rj\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"*\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0017"}, d2 = {"LC7/r;", "enableLiveLiterals", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "value", "Landroidx/compose/runtime/State;", "liveLiteral", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/compose/runtime/State;", "", "updateLiveLiteralValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/util/HashMap;", "Landroidx/compose/runtime/MutableState;", "Lkotlin/collections/HashMap;", "liveLiteralCache", "Ljava/util/HashMap;", "", "isLiveLiteralsEnabled", "Z", "()Z", "isLiveLiteralsEnabled$annotations", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LiveLiteralKt {
    private static boolean isLiveLiteralsEnabled;
    private static final HashMap<String, MutableState<Object>> liveLiteralCache = new HashMap<>();

    @InternalComposeApi
    public static final void enableLiveLiterals() {
        isLiveLiteralsEnabled = true;
    }

    public static final boolean isLiveLiteralsEnabled() {
        return isLiveLiteralsEnabled;
    }

    @ComposeCompilerApi
    @InternalComposeApi
    public static /* synthetic */ void isLiveLiteralsEnabled$annotations() {
    }

    @ComposeCompilerApi
    @InternalComposeApi
    public static final <T> State<T> liveLiteral(String str, T t9) {
        HashMap<String, MutableState<Object>> map = liveLiteralCache;
        MutableState<Object> mutableStateMutableStateOf$default = map.get(str);
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t9, null, 2, null);
            map.put(str, mutableStateMutableStateOf$default);
        }
        kotlin.jvm.internal.k.d(mutableStateMutableStateOf$default, "null cannot be cast to non-null type androidx.compose.runtime.State<T of androidx.compose.runtime.internal.LiveLiteralKt.liveLiteral>");
        return mutableStateMutableStateOf$default;
    }

    @InternalComposeApi
    public static final void updateLiveLiteralValue(String str, Object obj) {
        boolean z10;
        HashMap<String, MutableState<Object>> map = liveLiteralCache;
        MutableState<Object> mutableStateMutableStateOf$default = map.get(str);
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            map.put(str, mutableStateMutableStateOf$default);
            z10 = false;
        } else {
            z10 = true;
        }
        MutableState<Object> mutableState = mutableStateMutableStateOf$default;
        if (z10) {
            mutableState.setValue(obj);
        }
    }
}
