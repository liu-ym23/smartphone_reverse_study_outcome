package androidx.core.content;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences r100, boolean r101, Function1<? super SharedPreferences.Editor, Unit> r102) {
        SharedPreferences.Editor r103 = r100.edit();
        r102.invoke(r103);
        if (r101 == false) goto L5;
        r103.commit();
        return;
    L5:
        r103.apply();
    }

    public static /* synthetic */ void edit$default(SharedPreferences r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        SharedPreferences.Editor r105 = r100.edit();
        r102.invoke(r105);
        if (r101 == false) goto L8;
        r105.commit();
        return;
    L8:
        r105.apply();
    }
}
