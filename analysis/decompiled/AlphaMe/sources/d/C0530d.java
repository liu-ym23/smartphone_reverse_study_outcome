package d;

import android.content.Intent;
import androidx.activity.o;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: d.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0530d extends AbstractC0528b {
    @Override // d.AbstractC0528b
    public final Intent a(o context, Object obj) {
        Intent input = (Intent) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return input;
    }

    @Override // d.AbstractC0528b
    public final Object c(int i4, Intent intent) {
        return new ActivityResult(i4, intent);
    }
}
