package android.view;

import S7.k;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateReader;", "block", "read", "(Landroid/os/Bundle;LS7/k;)Ljava/lang/Object;", "Landroidx/savedstate/SavedStateWriter;", "write", "savedstate_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateKt")
/* loaded from: classes2.dex */
final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(Bundle bundle, k block) {
        kotlin.jvm.internal.k.f(bundle, "<this>");
        kotlin.jvm.internal.k.f(block, "block");
        return (T) block.invoke(SavedStateReader.m7176boximpl(SavedStateReader.m7177constructorimpl(bundle)));
    }

    public static final <T> T write(Bundle bundle, k block) {
        kotlin.jvm.internal.k.f(bundle, "<this>");
        kotlin.jvm.internal.k.f(block, "block");
        return (T) block.invoke(SavedStateWriter.m7261boximpl(SavedStateWriter.m7263constructorimpl(bundle)));
    }
}
